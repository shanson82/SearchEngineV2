package src.org.uiowa.cs2820.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.IOException;

public class Diskspace {
	//Not sure if this portion of the code is really necessary
	//but this uses the file diskSpace as the Diskspace and gets
	//the size of the file
	File diskSpace = new File("diskSpace.txt");
	int fileSize = (int) diskSpace.length();
	
	//This constructor is used to find if the file exists already.
	//if it does exist then it uses the diskSpace as the filename
	//and the fileSize is saved
	Diskspace(File fileName) throws IOException{
		if (fileName.exists()){
			this.diskSpace = fileName;
			this.fileSize = (int) fileName.length();
		}
		else{	//if not existing it creates it
			fileName.createNewFile();
			this.diskSpace = fileName;
			this.fileSize = (int) fileName.length();
		}
	}
	
	//writes a byte to an area in the file
	public void writeArea(int areaNum, byte[] element) throws IOException{
		//uses RandomAccessFile and tests to see if the areaNum is beyond
		//the end of the file. If so, we reset the areaNum to the end of the file 
		//where it will append to
		RandomAccessFile disk = new RandomAccessFile("diskSpace.txt", "rw");
		long endoFile = disk.length();
		
		if (areaNum > endoFile){
			areaNum = (int) endoFile;
		}
		disk.seek(areaNum);
		disk.write(element);
		disk.close();
		}
	//reads a byte from the given areaNum
	public static byte readArea(int areaNum) throws IOException{
		
		RandomAccessFile disk = new RandomAccessFile("diskSpace.txt","r");
		disk.seek(areaNum); 
		byte thisByte = disk.readByte();
		disk.close();
		return thisByte;
	}
	
	
}
