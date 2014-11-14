package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Head implements Serializable {
	
	private int area;
	private int next;
	
	Head(int area) {
		this.area = area;
		this.next = -1;
	}
	
	public int getArea() {
		return this.area;
	}
	
	public int getNext() {
		return this.next;
	}
	
	public void setNext(int area) {
		this.next = area;
	}
	
	public Head getHead() throws IOException {
		File diskMem = new File("diskSpace.txt");
		Diskspace G = new Diskspace(diskMem);
		byte[] h = G.readArea(0);
		return (Head) utility.revert(h);
	}
}