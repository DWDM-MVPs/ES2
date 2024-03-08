package com.es2.composite;

public abstract class Menu {
	private String _label;

	public String getLabel() {
		return this._label;
	}

	public void setLabel(String label) {
		this._label = label;
	}

	public abstract void showOptions();
}
