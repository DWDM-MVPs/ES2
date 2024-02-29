package com.es2.factorymethod;

import java.util.Locale;

public class FactoryProduct
{
	public FactoryProduct() {}

	public static Product makeProduct(String type) throws UndefinedProductException
	{
		Product product;
		switch (type.toLowerCase(Locale.ROOT))
		{
			case "computer":
			{
				product = new Computer();
				break;
			}
			case "software":
			{
				product = new Software();
				break;
			}
			default:
				throw new UndefinedProductException();
		}
		return product;
	}
}
