package org.uiowa.cs2820.engine;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Diskspace {
	
	private static File diskMem;
	
	//Diskspace() {
		//constructor may not be necessary if no one is 
		//actually going to create a new diskspace.
	//}
	
	//writes a byte to an area in the file
	public void writeArea(int areaNum, byte[] element) throws IOException{
		//deleted the check for areaNum since prof said to trust that values will not exceed it
		int diskSize;
		if(diskMem.exists()) { //check to see if file exist here since not nec. for read method
			RandomAccessFile disk = new RandomAccessFile(diskMem, "rw");
			disk.seek(areaNum);
			disk.write(element);
			disk.close();
			diskSize = (int) diskMem.length();
		}
		
		else{ //creates new file and writes to it if it didnt exist
			diskMem = new File("diskSpace.txt");
			RandomAccessFile disk = new RandomAccessFile(diskMem, "rw");
			disk.seek(areaNum);
			disk.write(element);
			disk.close();
			diskSize = (int) diskMem.length();
		}
		
	}
	//reads a byte from the given areaNum
	public static byte readArea(int areaNum) throws IOException{
		
		RandomAccessFile disk = new RandomAccessFile(diskMem,"r");
		disk.seek(areaNum); 
		byte thisByte = disk.readByte();
		disk.close();
		return thisByte;
	}
	
	
}
