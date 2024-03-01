package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReusablePool
{
	private static ReusablePool _instance;

	private final List<HttpURLConnection> _pool = new ArrayList<>();
	private final List<HttpURLConnection> _inUse = new ArrayList<>();
	private int _maxPoolSize = 10;

	public static ReusablePool getInstance()
	{
		if (_instance == null)
		{
			_instance = new ReusablePool();
		}
		return _instance;
	}

	private ReusablePool()
	{
		this.resetPool();
	}

	public synchronized HttpURLConnection acquire() throws IOException, PoolExhaustedException
	{
		if (_pool.size() > 0)
		{

			HttpURLConnection existingConnection = _pool.remove(0);
			this._inUse.add(existingConnection);
			return existingConnection;
		}
		if (this._pool.size() < 1 && this._inUse.size() < _maxPoolSize)
		{
			HttpURLConnection newConnection = new HttpURLConnection(new URL("https://ipv.pt/"))
			{
				@Override
				public void disconnect()
				{

				}

				@Override
				public boolean usingProxy()
				{
					return false;
				}

				@Override
				public void connect() throws IOException
				{

				}
			};
			this._inUse.add(newConnection);
			return newConnection;
		}
		else
		{
			throw new PoolExhaustedException();
		}
	}

	public synchronized void release(HttpURLConnection conn) throws ObjectNotFoundException
	{
		if (!this._inUse.contains(conn))
		{
			throw new ObjectNotFoundException();
		}

		_inUse.remove(conn);
		_pool.add(conn);
	}

	public synchronized void resetPool()
	{
		this._maxPoolSize = 10;
		this._pool.clear();
		this._inUse.clear();
	}

	public synchronized void setMaxPoolSize(int size)
	{
		this._maxPoolSize = size;
	}
}
