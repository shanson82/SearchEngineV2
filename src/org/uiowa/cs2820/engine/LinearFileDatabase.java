package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

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
	
	public KeyNode fetch(byte[] key) {
		File diskMem = new File("diskSpace.txt");
		Diskspace G = new Diskspace(diskMem);
		try {
			byte[] n = G.readArea(0); // start from beginning of file
			Head h = (Head) utility.revert(n);
			if (h.getNext() == -1) {
				return null; // indicates no keys in file
			}
			int areaToSearch = h.getNext();
			while (true) {
				n = G.readArea(areaToSearch);
				KeyNode k = (KeyNode) utility.revert(n);
				if (Arrays.equals(k.getKey(), key)) {
					return k;
				}
				if (k.getNext() == -1) return null;
				areaToSearch = k.getNext();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void store(byte[] key, String id) {
		File diskMem = new File("diskSpace.txt");
		Diskspace G = new Diskspace(diskMem);
		try {
			byte[] n = G.readArea(0); // read the first block of the file
			Head h = (Head) utility.revert(n);
			System.out.println("head points to: " + h.getNext());
			if (h.getNext() == -1) {
				int areaToWriteKey = Allocate.allocate();
				h.setNext(areaToWriteKey);
				G.writeArea(0, utility.convert(h));
				KeyStorage ks = new KeyStorage(key);
				ValueStorage vs = new ValueStorage(id, -1);
				ks.getNode().setValue(vs.getArea()); // set pointer of KeyNode to point to IDNode
				ks.putNode(areaToWriteKey);
				vs.store();		
				return;
			}
			int currentArea = h.getNext();
			while (true) {
				n = G.readArea(currentArea);		
				KeyNode k = (KeyNode) utility.revert(n); // revert back to KeyNode 
				System.out.println("area reading: " + currentArea);
				System.out.println("KeyNode points to next and value: " + k.getNext() + " " + k.getValue());
				
				// key stored in node matches the key to be stored
				if (Arrays.equals(k.getKey(),  key)) {
					System.out.println("Keys are equal");
					int areaToSearch = k.getValue();
					ValueStorage vs = new ValueStorage(id, areaToSearch);
					vs.store();
					return;
				}			
				// either no other keys in file or no matches and now at the end of the list
				if (k.getNext() == -1) {
					int areaToWriteKey = Allocate.allocate();
					KeyStorage ks = new KeyStorage(key);
					ValueStorage vs = new ValueStorage(id, -1);
					ks.getNode().setValue(vs.getArea());
					ks.putNode(areaToWriteKey);
					vs.store();
					k.setNext(areaToWriteKey);
					G.writeArea(currentArea, utility.convert(k));
					return;
				}
				currentArea = k.getNext();
				System.out.println("area to read next: " + currentArea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	
	// deletion methods not implemented
	public void delete(byte[] key, String id) {
		return;
	}
}
