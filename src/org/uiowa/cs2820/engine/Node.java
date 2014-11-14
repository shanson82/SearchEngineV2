package org.uiowa.cs2820.engine;

//import java.util.ArrayList;

public class Node {
	// Node is a basic unit in the database
	private byte[] Key;  // Key of this node for lookup
	private int value;
	private int next;

	Node(byte[] f, int e) {
		this.Key = f;
		this.value = e;
		this.next = -1;
	}

	public byte[] getKey() {
		return this.Key;
	}
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int area) {
		this.value = area;
	}

	public int getNext() {
		return this.next;
	}
	
	public void setNext(int area) {
		this.next = area;
	}
}
