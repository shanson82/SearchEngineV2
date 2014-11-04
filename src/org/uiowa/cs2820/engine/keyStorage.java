package src.org.uiowa.cs2820.engine;

import src.org.uiowa.cs2820.engine.diskSpace;
import src.org.uiowa.cs2820.engine.Field;

public class keystorage {
	
	private Node node;
	
	public boolean init(byte [] key){
	//Determines if Key exists in Disk Space
		for (Node n : diskSpace){
			if (Arrays.equals(n.Key, key)){
				return true;
			}
			else{
				return false;
			}
		}
	}
	public void clear(){
		
	}
	public Node get(int area){
	//Returns Node located at particular area number	
		Node myNode = diskSpace.get(area);
		return myNode;
	}
	public void put(int area, Node node){
	//Inserts Node into specified area number of Disk Space	
		byte[] myByte = Field.convert(node);
		diskSpace.add(area, myByte);
	}
	public void add(Node node){
		
	}
	public void del(Node node){
		
	}
	
}
