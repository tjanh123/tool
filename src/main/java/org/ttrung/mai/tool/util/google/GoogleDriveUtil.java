package org.ttrung.mai.tool.util.google;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ttrung.mai.tool.util.common.FileUtil;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files.Create;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;

public class GoogleDriveUtil {

	private static final Logger log = LoggerFactory.getLogger(GoogleDriveUtil.class);

	public static Drive getDriveService(String serviceAccountEmail, String credentialPath)
			throws GeneralSecurityException, IOException {
		
		GoogleCredential credential = getCredential(serviceAccountEmail, credentialPath);
		
		Drive service = new Drive.Builder(credential.getTransport(), credential.getJsonFactory(), null).setHttpRequestInitializer(credential).setApplicationName("Google Drive Util").setHttpRequestInitializer(new HttpRequestInitializer() {

            @Override
            public void initialize(HttpRequest httpRequest) throws IOException {

                credential.initialize(httpRequest);
                httpRequest.setConnectTimeout(300 * 60000);  // 300 minutes connect timeout
                httpRequest.setReadTimeout(300 * 60000);  // 300 minutes read timeout

            }
        })
				.build();
		return service;
	}

	private static GoogleCredential getCredential(String serviceAccountEmail, String credentialPath) throws GeneralSecurityException, IOException {
		HttpTransport httpTransport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		List<String> scopes = new ArrayList<>();
		scopes.add(DriveScopes.DRIVE);
		String fileType = FileUtil.getExtension(credentialPath);
		if("json".equals(fileType)) {
			return  GoogleCredential.fromStream(new FileInputStream(credentialPath), httpTransport, jsonFactory)
				    .createScoped(scopes);
		} else if ("p12".equals(fileType)) {
			return new GoogleCredential.Builder().setTransport(httpTransport)
					.setJsonFactory(jsonFactory).setServiceAccountId(serviceAccountEmail).setServiceAccountScopes(scopes)
					.setServiceAccountPrivateKeyFromP12File(new java.io.File(credentialPath)).build();
		}
		return null;
	}

	public static File createFile(Drive drive, List<Permission> permissions, File fileMetadata, java.io.File fileSource,
			JsonBatchCallback<Permission> callback) throws IOException {
		if (callback == null) {
			callback = createCallbackBatchDefault(Permission.class);
		}
		String type = FileUtil.getMimeType(fileSource.toPath());
		AbstractInputStreamContent mediaContent = new FileContent(type, fileSource);
		return createFile(drive, permissions, fileMetadata, mediaContent, callback);
	}
	
	public static File createFile(Drive drive, List<Permission> permissions, File fileMetadata, AbstractInputStreamContent fileContent,
			JsonBatchCallback<Permission> callback) throws IOException {
		if (callback == null) {
			callback = createCallbackBatchDefault(Permission.class);
		}
		Create create = drive.files().create(fileMetadata, fileContent);
		return createFile(drive, permissions, create, callback);
	}

	public static File createFile(Drive drive, List<Permission> permissions, Create create,
			JsonBatchCallback<Permission> callback) throws IOException {
		if (callback == null) {
			callback = createCallbackBatchDefault(Permission.class);
		}
		File file = create.execute();
		if (CollectionUtils.isNotEmpty(permissions)) {
			BatchRequest batchRequest = drive.batch();
			for (Permission per : permissions) {
				drive.permissions().create(file.getId(), per).setSendNotificationEmail(false).queue(batchRequest, callback);
			}
			batchRequest.execute();
		}
		return file;
	}

	public static <T> JsonBatchCallback<T> createCallbackBatchDefault(Class<T> clazz) {
		return new JsonBatchCallback<T>() {
			@Override
			public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) throws IOException {
				log.error(e.getMessage(), e);
			}

			@Override
			public void onSuccess(T subject, HttpHeaders responseHeaders) throws IOException {
				log.info("Callback Success " + subject);
			}
		};
	}

}
