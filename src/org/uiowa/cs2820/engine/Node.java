package src.org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class Node {
  // Node is a basic unit in the database
  byte[] Key;  //Field object converted to byte[]
  //ArrayList<String> Identifiers;
  long ValueArea; //where ValueStorage area starts
  
  Node(byte[] f, String id) {
	this.Key = f;
	this.Identifiers = new ArrayList<String>();
	this.Identifiers.add(id);
    }
  
  public void add(String id) { 
	Identifiers.remove(id);  // does nothing if id not already there
	Identifiers.add(id);
    }
  
  public void del(String id) {
	Identifiers.remove(id);
    }
  
  public int getSize() {
	return size;
    }
  }
