package com.es2.memento;

import java.util.ArrayList;

public class BackupService
{
	private final Server server;
	private final ArrayList<Memento> snapshotsList = new ArrayList<>();

	public BackupService(Server server)
	{
		this.server = server;
	}

	public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException
	{
		if (this.snapshotsList.size() <= snapshotNumber)
		{
			throw new NotExistingSnapshotException();
		}

		this.server.restore(this.snapshotsList.get(snapshotNumber));
	}

	public void takeSnapshot()
	{
		this.snapshotsList.add(this.server.backup());
	}
}
