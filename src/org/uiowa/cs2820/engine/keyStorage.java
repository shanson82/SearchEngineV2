package org.uiowa.cs2820.engine;

import org.uiowa.cs2820.engine.*;

import java.io.IOException;
import java.util.Arrays;

public class keyStorage {
	protected Diskspace disk;
	private Field f;
	private byte[] key;
	private Node node;
	public keyStorage(){
		
	}
	public keyStorage(Field f){
		this.f = f;
		Node node;
		int start;
		try {
			int area = Allocate.allocate(); 
			start = Allocate.allocate();
			byte[] myByte = utility.convert(f);
			node = new Node(myByte, start);
			add(node);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean init(byte[] key){
		this.key = key;
		for (int i = 1; i < disk.getSize(); i++){
			Node bn;
			try {
				bn = (Node)utility.revert(disk.readArea(i));
				if(Arrays.equals(key, bn.Key))
					return true;
			} 
				catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}	
		return false;	
	}
	public void clear(){
		
	}
	public Node get(int area){
	//Returns Node located at particular area number
		try{
			byte[] myByte = disk.readArea(area);
			Node myNode = (Node)utility.revert(myByte);
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
		try {
			disk.writeArea(area, myByte);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public void del(Node node){
//		Iterator itr = disk.iterator();
//		while(itr.hasNext()){
//			byte[] seq = disk.readArea(itr.next());
//			Node found = utility.revert(seq);
//			if (found == node){
//				Allocate.free(itr.next());
//			}	
//		}
//	}
}
