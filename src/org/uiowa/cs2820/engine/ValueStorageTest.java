package org.uiowa.cs2820.engine;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ValueStorageTest {

	


	@Test
	public void test1() throws IOException{
		ValueStorage p = new ValueStorage("abc", 5);
		p.store();
		assertEquals(p.load(),"abc");
	}
}