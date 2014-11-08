package src.org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class Node {
  // Node is a basic unit in the database
  byte[] Key;  //Field object converted to byte[]
  //ArrayList<String> Identifiers;
  long ValueArea; //where ValueStorage area starts
  
  Node(byte[] f, long areaNum) { //(field_object,area_started)
	this.Key = f;
	this.ValueArea = areaNum;
    }
  
  public void add(String id) { 
	
    }
  
  public void del(String id) {
	Identifiers.remove(id);
    }
  
  public int getSize() {
	return size;
    }
  }
