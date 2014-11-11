package src.org.uiowa.cs2820.engine;

import src.org.uiowa.cs2820.engine.Diskspace;
import src.org.uiowa.cs2820.engine.Field;
import src.org.uiowa.cs2820.engine.Allocate;
import src.org.uiowa.cs2820.engine.Node;

public class keyStorage {
	protected Diskspace disk;
	
	public keyStorage(){
		
	}
	public keyStorage(Field f){
		Node node;
		int area = Allocate.allocate();
		int start = Allocate.allocate();
		byte[] myByte = utility.convert(f);
		node = Node(myByte, start);
		add(node);
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
		try{
			byte[] myByte = disk.readArea(area);
			Node myNode = utility.revert(myByte);
			return myNode;
		}
		catch(IOException e){
			return null;
		}
	}
	public void add(Node node){
		this.node = node;
		int area = node.start;
		put(area, node);
	}
	public void put(int area, Node node){
	//Inserts Node into specified area number of Disk Space	
		byte[] myByte = utility.convert(node);
		disk.writeArea(area, myByte);
	}
	public void del(Node node){
		Iterator itr = disk.iterator();
		while(itr.hasNext()){
			byte[] seq = disk.readArea(itr.next());
			Node found = utility.revert(seq);
			if (found == node){
				Allocate.free(itr.next());
			}	
		}
	}
}
