package src.org.uiowa.cs2820.engine;

import java.io.*;
import java.lang.String;

public class Checkpoint {
	
	private Object o;
	private final String filename = "memoryMap.txt";
	
	//parse in the object only
	public Checkpoint(Object o){//check to make sure if file exist
		this.o = o;
		File file = new File(filename);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void save() throws IOException{
		FileOutputStream f = new FileOutputStream(filename);
		byte[] bArray = utility.convert(o);
		// need to write the byte array, not the object
		f.write(bArray);
		f.close();
		return;
	}
	
	public Object restore() throws IOException{
		FileInputStream f = new FileInputStream(filename);
		byte[] bArray = new byte[1024];//the length of byte[] may need a bigger value
		f.read(bArray);
		Object obj = utility.revert(bArray);
		f.close();
		return obj;
	}
}
