package com.es2.singleton;

public class Registry
{
	private static Registry _instance = null;

	private Registry() {}

	public static Registry getInstance()
	{
		if (_instance == null)
		{
			_instance = new Registry();
		}
		return _instance;
	}

	private String _connectionString;
	private String _path;

	public String getConnectionString()
	{
		return this._connectionString;
	}

	public void setConnectionString(String connectionString)
	{
		this._connectionString = connectionString;
	}

	public String getPath()
	{
		return this._path;
	}

	public void setPath(String path)
	{
		this._path = path;
	}
}