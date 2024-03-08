package com.es2.composite;

public class Link extends Menu {
	private String _url;

	public String getURL() {
		return this._url;
	}

	public void setURL(String url) {
		this._url = url;
	}

	@Override
	public void showOptions() {
		System.out.println(this.getLabel() + "\n" + this.getURL());
	}
}
