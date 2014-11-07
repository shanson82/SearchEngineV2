package src.org.uiowa.cs2820.engine;

import java.io.*;

import src.org.uiowa.cs2820.engine.Field;

public class Checkpoint {
	
	private Object o;
	private String dir;
	private String filename;
	
	public Checkpoint(Object o, String dir, String filename){
		this.o = o;
		this.dir = dir;
		this.filename = filename;
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
		//ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileInputStream f = new FileInputStream(filename);
		//byte[] bArray = baos.toByteArray(f);
		// can read file input stream into a byte array
		byte[] bArray;
		f.read(bArray);
		Object obj = utility.revert(bArray);
		f.close();
		return obj;
	}
}
