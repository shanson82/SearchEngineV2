package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.IOException;

public class keyStorage{
	private KeyNode knode;
	
	keyStorage(byte[] key){
		this.knode = newKeyNode(key);
	}
	public void putNode(int area){
		byte[] key = utility.convert(this.knode);
		File diskMem = newFile("diskSpace.txt");
		Diskspace G = new DiskSpace(diskMem);
		try{
			G.writeArea(area, key);
			return;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return;
	}
	public KeyNode getNode(){
		return this.knode;
	}
}
