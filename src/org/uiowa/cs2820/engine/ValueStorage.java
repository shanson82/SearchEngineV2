package src.org.uiowa.cs2820.engine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
public class ValueStorage {
ArrayList<String> ArrayGuy;
LinkedList<byte[]> L;
Object[] O;
///Constructor -
ValueStorage(ArrayList<String> ArrayGuy){
this.ArrayGuy = ArrayGuy;
}
public void init(){
}
public void clear(){
}
///Reads entire value of Linked List and Converts to array of identifiers
public void load(LinkedList<byte[]> L){
this.L = L;
Object[] Expander = L.toArray();
///To Do - Need to figure out if we should convert the bytes to identifiers before
///or after they placed in the array.
}
///Writes entire ArrayList of Identifiers
public void storage(Object[] O){
this.O = O;
///To Do - Need to determine where to write Array of Identifiers to...
}
}
