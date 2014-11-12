package org.uiowa.cs2820.engine;

///This is a new class of Nodes made to exist independently of the original node class.
///This new NodeParty class is necessary for the construction of the linked list in Value Storage. 
///Originally, we thought that ValueStorage would use the Nodes from the Node class, but it is necessary because they hold different values. 


public class NodeParty {

	private String id; //could be the areaNum for the firstlocation of the byte
	private int next; //this should point to next size of byte 
	private int size; //the size of the byte
	private int loc; //the soon to be area number 

	public NodeParty(String guy, int w){
		this.next = w; //since the list is initially empty the next has no value
		this.id = guy; 
		new NodeParty(null, next); //null will become the byte[] from the areaNum							   //while next will find the next loc of next load
		size = 0; //no byte = no size
		loc = Allocate.allocate();
		Diskspace.write(loc,convert(this));
		
	}
	
	public String getId(){
		return id; 
	}
	
	public int getNext(){
		return next;
	}
	
	
}
	
	
