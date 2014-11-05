package src.org.uiowa.cs2820.engine;

import java.util.BitSet;
import src.org.uiowa.cs2820.engine.Checkpoint;

public class Allocate {
	
	// not quite sure about this 
	// need a file name to store the bit array
	private String filename;
	private BitSet space = new BitSet();
	
	
	
	// allocate finds the next available block that can be allocated for use
	public int allocate() {
		// use Checkpoint to restore bit array from the file
		int nextAvailable;
		for (nextAvailable = 0; nextAvailable <= space.length(); nextAvailable++) {
			if (space.get(nextAvailable) == false) {
				space.set(nextAvailable);
				// use Checkpoint to save bit array back to file
				return nextAvailable;
			}
		}
		// this should be unreachable
		return nextAvailable + 1;
	}

	public void free(int block) {
		// use Checkpoint to restore bit array from the file
		space.clear(block); // update bit array
		// use Checkpoint to save bit array back to file
		
	}
}
