package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Diskspace {
	
	private static File diskMem;
	private static int diskSize;
	private final int blockSize = 1024;
	
	//constructor for diskspace
	Diskspace(File filename){
		this.diskMem = filename;
	}
	
	//writes a byte to an area in the file
	public void writeArea(int areaNum, byte[] element) throws IOException{
		//deleted the check for areaNum since prof said to trust that values will not exceed it
		
		if(diskMem.exists()) { //check to see if file exist here since not nec. for read method
			RandomAccessFile disk = new RandomAccessFile(diskMem, "rw");
			areaNum = areaNum * blockSize;
			disk.seek(areaNum);
			disk.write(element);
			disk.close();
			diskSize = (int) diskMem.length();
		}
		
		else{ //creates new file and writes to it if it didnt exist
			diskMem = new File("diskSpace.txt");
			RandomAccessFile disk = new RandomAccessFile(diskMem, "rw");
			areaNum = areaNum * blockSize;
			disk.seek(areaNum);
			disk.write(element);
			disk.close();
			diskSize = (int) diskMem.length();
		}
		
	}
	//reads a byte from the given areaNum
	public byte[] readArea(int areaNum) throws IOException{
		RandomAccessFile disk = new RandomAccessFile(diskMem,"r");
		byte[] theseBytes = new byte[blockSize];
		areaNum = areaNum * blockSize;
		disk.seek(areaNum); 
		disk.read(theseBytes); // disk.readFully(theseBytes) might also work
		disk.close();
		return theseBytes;
	}
	public int getSize(){
		return diskSize;
	}
	
}
