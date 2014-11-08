package src.org.uiowa.cs2820.engine;

import src.org.uiowa.cs2820.engine.Diskspace;
import src.org.uiowa.cs2820.engine.Field;
import src.org.uiowa.cs2820.engine.Allocate;
import src.org.uiowa.cs2820.engine.Node;

public class keyStorage {
	
	private Node node;
	
	int area = 0;
	keyStorage(Field f){
		area = Allocate.allocate();
		int start = Allocate.allocate();
		byte[] myByte = utility.convert(f);
		node = Node(myByte, start);
	}
	public boolean init(byte[] key){
		for (Node n : diskSpace){
			byte[] bn = utility.revert(n);
			if(Arrays.equals(key, bn)){
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
		byte[] myByte = Diskspace.readArea(area);
		Node myNode = utility.revert(myByte);
		return myNode;
	}
	public void put(int area, Node node){
	//Inserts Node into specified area number of Disk Space	
		byte[] myByte = utility.convert(node);
		diskSpace.writeArea(area, myByte);
	}
	public void add(Node node){
		this.node = node;
		int area = Allocate.allocate();
		put(area, node);
	}
	public void del(Node node){
		
	}
	
}
	public void del(Node node){
		
	}
	
}
