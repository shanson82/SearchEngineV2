package src.org.uiowa.cs2820.engine;

import java.io.*;
import java.util.Arrays;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOut;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class utility implements Serializable{
	public static byte[] convert(Object O) {
		  // private method converts objects into byte array
		  ByteArrayOutputStream M = new ByteArrayOutputStream();
		  ObjectOutput N = null;
		  try {
			N = new ObjectOutputStream(M);
			N.writeObject(O);
		    } 
		  catch (IOException e) {
	        return null; // wrong, but should not happen	    	
		    }
		  return M.toByteArray();
		  }
		
		public static Object revert(byte[] seq) {
		  Object O = null;  // default value
		  try {
			ByteArrayInputStream M = new ByteArrayInputStream(seq);
			ObjectInputStream N = new ObjectInputStream(M);
			O = N.readObject();
			}
		  catch (Exception e) { };
			return O;
		  }
}
