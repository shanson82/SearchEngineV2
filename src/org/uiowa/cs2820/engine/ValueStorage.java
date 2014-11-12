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
	public ValueStorage(){
		next1 = 0; //since the list is initially empty the next has no value
		start = new Node(null, next1); //null will become the byte[] from the areaNum
									   //while next will find the next loc of next load
		size = 0; //no byte = no size
	}
	//
	public void add(byte[] data){//adds to the linked list; this is the identifier
		Node temp = new Node(data, 0); 
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
