package com.es2.composite;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SubMenu extends Menu {
	private List<Menu> _childList = new ArrayList<>();

	public void addChild(Menu child) {
		_childList.add(child);
	}

	public void removeChild(Menu child) {
		_childList.remove(child);
	}

	@Override
	public void showOptions() {
		System.out.println(this.getLabel());
		for (Menu menu : _childList) {
			menu.showOptions();
		}
	}
}
