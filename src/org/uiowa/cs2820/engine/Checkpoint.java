package src.org.uiowa.cs2820.engine;

import java.io.*;
import java.lang.String;

public class Checkpoint {
	
	private Object o;
	private static final String filename = "memoryMap.txt";
	
	//parse in the object only
	public Checkpoint(Object o) throws IOException{//check to make sure if file exist
		this.o = o;
		File file = new File(filename);
		if(!file.exists()){
			file.createNewFile();
		}
	}
	
	public void save() throws IOException{
		FileOutputStream f = new FileOutputStream(filename);
		byte[] bArray = utility.convert(o);
		// need to write the byte array, not the object
		//f.write(o);
		f.write(bArray);
		f.close();
		return;
	}
	
	public Object restore() throws IOException{
		byte[] bArray = null;
		FileInputStream f = new FileInputStream(filename);
		// can read file input stream into a byte array
		f.read(bArray);
		Object obj = utility.revert(bArray);
		f.close();
		return obj;
	}
}
