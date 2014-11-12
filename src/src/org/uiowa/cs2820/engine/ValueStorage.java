package org.uiowa.cs2820.engine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import src.org.uiowa.cs2820.engine.Diskspace;


public class ValueStorage {
	ArrayList<String> ArrayGuy;
	LinkedList<byte[]> L;
	Object[] O;
	//
	private Node start; //could be the areaNum for the first location of the byte
	private int next1; //this should point to next size of byte 
	private int size; //the size of the byte

	///Constructor -
	ValueStorage(ArrayList<String> ArrayGuy){
		this.ArrayGuy = ArrayGuy;
	}
	//
	//think of this node as (areaNum,byte)
	//a constructor similar to a linked list
	public ValueStorage(byte[] a, int loc){
		this.start = new Node(a,loc);
		this.next1 = 0; //since the list is initially empty the next has no value
		this.size = a.length; //no byte = no size
	}
	//
	public void add(byte[] data){//adds to the linked list; this is the identifier
		int areaNum =  //should get this from allocate maybe
		Node temp = new Node(data, areaNum); 
		Node current = start; //starting point to our linked list
		while(current.)
	}
	public void init(){
	}


	public void clear(){
	}


	///Reads entire value of Linked List and Converts to array of identifiers
	///To Do: should create linked list directly from calls to disc space.
	public void load(){
	
	Object[] Expander = L.toArray();
	///To Do - Need to figure out if we should convert the bytes to identifiers before
	///or after they placed in the array.
	}
	
	
	///Writes entire ArrayList of Identifiers
	public void storage(Object[] O){
	this.O = O;
	
	}}
