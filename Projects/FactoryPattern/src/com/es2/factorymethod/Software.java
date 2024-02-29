package com.es2.factorymethod;

public class Software implements Product
{
	private String _brand;

	protected Software() {}

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
