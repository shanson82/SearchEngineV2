package src.org.uiowa.cs2820.engine;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Diskspace {
	
	private static File diskMem;
	
	//constructor for diskspace
	Diskspace(File filename){
		this.diskMem = filename;
	}
	
	//writes a byte to an area in the file
	public void writeArea(int areaNum, byte[] element) throws IOException{
		//deleted the check for areaNum since prof said to trust that values will not exceed it
		int diskSize;
		if(diskMem.exists()) { //check to see if file exist here since not nec. for read method
			RandomAccessFile disk = new RandomAccessFile(diskMem, "rw");
			areaNum = areaNum * 1024;
			disk.seek(areaNum);
			disk.write(element);
			disk.close();
			diskSize = (int) diskMem.length();
		}
		
		else{ //creates new file and writes to it if it didnt exist
			diskMem = new File("diskSpace.txt");
			RandomAccessFile disk = new RandomAccessFile(diskMem, "rw");
			areaNum = areaNum * 1024;
			disk.seek(areaNum);
			disk.write(element);
			disk.close();
			diskSize = (int) diskMem.length();
		}
		
	}
	//reads a byte from the given areaNum
	public static byte readArea(int areaNum) throws IOException{
		RandomAccessFile disk = new RandomAccessFile(diskMem,"r");
		areaNum = areaNum * 1024;
		disk.seek(areaNum); 
		byte thisByte = disk.readByte();
		disk.close();
		return thisByte;
	}
	
	
}
