package org.ttrung.mai.tool.util.string;

import java.net.MalformedURLException;
import java.net.URL;

public class CheckStringUtil {

	private CheckStringUtil() {
	}

	public static boolean isValidUrl(String str) {
		try {
			new URL(str);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}
	}
}
