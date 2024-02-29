package com.es2.factorymethod;

public class Computer implements Product
{
	private String _brand;

	protected Computer() {}

	@Override
	public String getBrand()
	{
		return this._brand;
	}

	@Override
	public void setBrand(String brand)
	{
		this._brand = brand;
	}
}
