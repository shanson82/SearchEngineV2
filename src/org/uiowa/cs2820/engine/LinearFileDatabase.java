package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LinearFileDatabase implements Database {

	LinearFileDatabase() {
		File diskMem = new File("diskSpace.txt");
		if (diskMem.length() == 0) {
			try {
				System.out.println("diskSpace is empty");
				RandomAccessFile disk = new RandomAccessFile(diskMem, "rw");
				int writeArea = Allocate.allocate();
				Head h = new Head(writeArea);				
				disk.write(utility.convert(h));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Node fetch(byte[] key) {
		// read head of file
		File diskMem = new File("diskSpace.txt");
		Diskspace G = new Diskspace(diskMem);
		byte[] h;
		try {
			h = G.readArea(0);
			Head headNode = (Head) utility.revert(h);
			if (headNode.getNext() == -1) {
				return null;
			}
			int currentArea = headNode.getNext();
			keyStorage ks = new keyStorage();
			while (true) {
				Node n = ks.get(currentArea);
				if (n.getKey() == key) {
					return n;
				}
				currentArea = n.getNext();
				if (currentArea == -1) {
					return null;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void store(byte[] key, String id) {
		return;
	}
	
	
	// deletion not implemented
	public void delete(byte[] key, String id) {
		return;
	}
}
