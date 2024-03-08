package com.es2.bridge;

import java.util.LinkedHashMap;

public class APIMoodle implements APIServiceInterface {
	protected LinkedHashMap<String, String> content = new LinkedHashMap<>();
	private int _contentId = 0;

	@Override
	public String getContent(String contentId) {
		if (contentId.equals("0")) {
			StringBuilder builder = new StringBuilder();
			for (String value : content.values()) {
				builder.append(value);
			}
			return builder.toString();
		}
		return content.get(contentId);
	}

	@Override
	public String setContent(String content) {
		String contentIdString = String.valueOf(_contentId);

		this.content.put(contentIdString, content);

		_contentId++;
		return contentIdString;
	}
}
