package org.ttrung.mai.tool.util.extract;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * extract util especially for html 
 * @author ttrung.mai
 *
 */
public class ExtractHtmlUtil {

	/**
	 * 
	 * @see https://stackoverflow.com/questions/6998163/android-java-get-html-image-tag-from-string
	 * @param text
	 * @return
	 */
	public static List<String> extractSourceImages(String text) {
		if(StringUtils.isBlank(text)) {
			return new ArrayList<>();
		}
		Pattern pattern = Pattern.compile("(?<=<img src=\\\")[^\\\"]*", Pattern.DOTALL);
		final List<String> tagValues = new ArrayList<String>();
		final Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			tagValues.add(matcher.group());
		}
		return tagValues;
	}
}
