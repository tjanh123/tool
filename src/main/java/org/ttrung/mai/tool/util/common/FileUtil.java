package org.ttrung.mai.tool.util.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;
import org.ttrung.mai.tool.enums.CheckSumTypeEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtil {

	public static void createFile(byte[] bytes, String fullPath) throws IOException {
		createFolderIfNotExist(new File(fullPath).getParent());
		try (FileOutputStream stream = new FileOutputStream(fullPath)) {
			stream.write(bytes);
		}
	}

	public static void createFolderIfNotExist(String dir) {
		File directory = new File(dir);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	public static String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	public static String getMimeType(Path path) throws IOException {
		return Files.probeContentType(path);
	}

	public static String checksum(String fileLocation, CheckSumTypeEnum type) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance(type.getValue());
			return getFileChecksum(messageDigest, fileLocation);
		} catch (NoSuchAlgorithmException | IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static String getFilename(String str) {
		if(StringUtils.isNotBlank(str)) {
			return StringUtils.substringAfterLast(str.replaceAll("\\\\", "/"),"/");
		}
		return null;
	}

	private static String getFileChecksum(MessageDigest digest, String fileLocation)
			throws IOException, NoSuchAlgorithmException {
		File file = new File(fileLocation);
		// Get file input stream for reading the file content
		FileInputStream fis = new FileInputStream(file);

		// Create byte array to read data in chunks
		byte[] byteArray = new byte[1024];
		int bytesCount = 0;

		// Read file data and update in message digest
		while ((bytesCount = fis.read(byteArray)) != -1) {
			digest.update(byteArray, 0, bytesCount);
		}

		// close the stream; We don't need it now.
		fis.close();

		// Get the hash's bytes
		byte[] bytes = digest.digest();

		// This bytes[] has bytes in decimal format;
		// Convert it to hexadecimal format
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		// return complete hash
		return sb.toString();
	}

}
