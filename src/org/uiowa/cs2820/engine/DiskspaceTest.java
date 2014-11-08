package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.uiowa.cs2820.engine.utility;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class DiskspaceTest {

	@Test //test writeArea method
	public void test1() throws IOException {
		int areaNum = 4;
		byte[] element = utility.convert("here");
		File diskMem = new File("diskSpace.txt");
		Diskspace G = new Diskspace(diskMem);
		G.writeArea(areaNum, element);
		assertEquals(Diskspace.readArea(areaNum),element);
	}

	@Test //test readArea method
	public void test2() throws IOException {
		int areaNum = 7;
		byte[] element = utility.convert("is");
		File diskMem = new File("diskSpace.txt");
		Diskspace G = new Diskspace(diskMem);
		G.writeArea(areaNum, element);
		assertEquals(Diskspace.readArea(areaNum),element);
	
	}
	@Test //Still works without file given
	public void test3 () throws IOException{
		int areaNum = 12;
		byte[] element = utility.convert("the");
		Diskspace G = new Diskspace(null);
		G.writeArea(areaNum, element);
		assertEquals(Diskspace.readArea(areaNum),element);
	}
	}
