package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ValueStorage {
	
	private IDNode idnode; // identifier node
	private int areaToWrite; // area to write the node
	private int areaToSearch; // area to start searching
	
	// constructor to use if storing an identifier
	ValueStorage(String id, int areaToSearch) {
		byte[] idArray = utility.convert(id);
		this.idnode = new IDNode(idArray);
		this.areaToSearch = areaToSearch;
		// can add a check to make sure idArray < 1024 bytes
		try {
			this.areaToWrite = Allocate.allocate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// constructor to use if searching for identifiers (see FieldSearch)
	ValueStorage(int areaToSearch) {
		this.idnode = null;
		this.areaToWrite = -1;
		this.areaToSearch = areaToSearch;
	}
	
	public int getArea() {
		return this.areaToWrite;
	}


	
	public ArrayList<String> load() {
		ArrayList<String> identifiers = new ArrayList<String>();
		if (this.areaToSearch == -1) {
			return identifiers;
		}
		File diskMem = new File("diskSpace.txt");
		Diskspace G = new Diskspace(diskMem);
		int searchArea = this.areaToSearch;
		while (true) {
			try {
				byte[] i = G.readArea(searchArea);
				IDNode current = (IDNode) utility.revert(i);
				// convert identifier from byte[] to String
				String id = (String) utility.revert(current.getid());
				identifiers.add(id);
				// if next value == -1, then at end of list of identifiers, return the ArrayList
				if (current.getNext() == -1) {
					return identifiers;
				}
				// increment to next area to search
				searchArea = current.getNext();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}		
	}

	public void store() {
		//byte[] identifier = Utility.convert(this.idnode); // identifier node to write to file
		File diskMem = new File("diskSpace.txt");
		Diskspace G = new Diskspace(diskMem);
		try {
			if (this.areaToSearch == -1) {
				G.writeArea(this.areaToWrite, utility.convert(this.idnode));
				return;
			}
			int currentArea = this.areaToSearch;
			while (true) {
				byte[] currentArray = G.readArea(currentArea);
				IDNode current = (IDNode) utility.revert(currentArray);
				if (current.getNext() == -1) {
					G.writeArea(this.areaToWrite, utility.convert(this.idnode));
					current.setNext(this.areaToWrite);
					G.writeArea(currentArea, utility.convert(current));
					return;
				}
				currentArea = current.getNext();
			}
		} catch (IOException e) {
			e.printStackTrace();			
		}
		
	}
	
	
}