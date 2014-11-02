package src.org.uiowa.cs2820.engine;

import src.org.uiowa.cs2820.engine.Field;

public class Checkpoint {
	
	private Field f;
	private String filename;
	
	public void Checkpoint(Field f, String filename){
		this.f = f;
		this.filename = filename;
	}
	
	public void save(){
		//open file;
		Field.convert(f);
		//write into file;
		//close file;
	}
	
	public Object restore(){
		//open file;
		//read line
		Object o = Field.revert(line);
		//close file
		return o;
	}
}
