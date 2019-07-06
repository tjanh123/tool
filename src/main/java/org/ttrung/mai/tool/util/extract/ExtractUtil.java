package org.ttrung.mai.tool.util.extract;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * extract content util
 * @author ttrung.mai
 *
 */
public class ExtractUtil {
	
	
	/**
	 * @see https://stackoverflow.com/questions/6560672/java-regex-to-extract-text-between-tags
	 * @param text
	 * @param tag
	 * @return
	 */
	public static List<String> extractInsideTag(String text, String tag) {
		Pattern pattern = Pattern.compile("<" + tag + ">(.+?)</" + tag + ">", Pattern.DOTALL);

		final List<String> tagValues = new ArrayList<String>();
		final Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			tagValues.add(matcher.group(1));
		}
		return tagValues;

	}
}
