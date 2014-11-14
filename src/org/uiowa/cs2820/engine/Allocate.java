package org.uiowa.cs2820.engine;

import java.io.IOException;
import java.util.BitSet;

import org.uiowa.cs2820.engine.Checkpoint;

public class Allocate {

	private static BitSet space = new BitSet();

	public static BitSet getSpace() throws IOException {
		Checkpoint c = new Checkpoint(space);
		space = (BitSet) c.restore();
		return space;
	}
	
	public void setSpace(int x) {
		space.set(x);
	}

	// allocate finds the next available block that can be allocated for use
	public static int allocate() throws IOException {
		// use Checkpoint to restore bit array from the file
		Checkpoint c = new Checkpoint(Allocate.space);
		Allocate.space = (BitSet) c.restore();
		int nextAvailable;
		if (space == null) {
			space = new BitSet();
			space.set(0);
			c = new Checkpoint(Allocate.space);
			c.save();
			return 0;
		} 
		for (nextAvailable = 0; nextAvailable <= Allocate.space.length(); nextAvailable++) {
			if (space.get(nextAvailable) == false) {
				space.set(nextAvailable);
				// use Checkpoint to save bit array back to file
				c = new Checkpoint(space);
				c.save();
				//StaticCheckpoint.save();
				return nextAvailable;
			}
		}

		// this should be unreachable
		c.save();
		return nextAvailable + 1;

	}

	public static void free(int block) throws IOException {
		// use Checkpoint to restore bit array from the file
		Checkpoint c = new Checkpoint(space);
		Object o = c.restore();
		space = (BitSet) o;
		space.clear(block); // update bit array
		// use Checkpoint to save bit array back to file
		c = new Checkpoint(space);
		c.save();
		
	}

}
