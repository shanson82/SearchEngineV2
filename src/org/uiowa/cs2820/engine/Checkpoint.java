import java.io.*;

import src.org.uiowa.cs2820.engine.Field;

public class Checkpoint {
	
	private Object o;
	private String dir;
	private String filename;
	
	public void Checkpoint(Object o, String dir, String filename){
		this.o = o;
		this.dir = dir;
		this.filename = filename;
	}
	
	public void save(){
		FileOutputStream f = new FileOutputStream(filename);
		byte[] bArray = Field.convert(o);
		f.write(o);
		f.close();
		return;
	}
	
	public Object restore(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileInputStream f = new FileInputStream(filename);
		byte[] bArray = baos.toByteArray(f);
		Object obj = Field.revert(bArray);
		f.close();
		return obj;
	}
}
