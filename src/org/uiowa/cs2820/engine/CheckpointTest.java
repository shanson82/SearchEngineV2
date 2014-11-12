package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;

public class CheckpointTest {

	@Test
	public void test1() throws IOException{
		String s1 = "This is a sentence.";
		Checkpoint ckp1 = new Checkpoint(s1);
		ckp1.save();
		String s2 = (String) ckp1.restore();
		assertEquals(s1, s2);
	}

	@Test
	public void test2() throws IOException{
		int[] s1 = {1,2,3,4,5};
		Checkpoint ckp2 = new Checkpoint(s1);
		ckp2.save();
		int[] s2 = (int[]) ckp2.restore();
		assertEquals(s1[0], s2[0]);
		assertEquals(s1[1], s2[1]);
		assertEquals(s1[2], s2[2]);
		assertEquals(s1[3], s2[3]);
		assertEquals(s1[4], s2[4]);
	}
	
	@Test
	public void test3() throws IOException{
		Field s1 = new Field("Name", "Value");
		Checkpoint ckp3 = new Checkpoint(s1);
		ckp3.save();
		Field s2 = (Field) ckp3.restore();
		assertEquals(s1.getFieldName(), s2.getFieldName());
		assertEquals(s1.getFieldValue(), s2.getFieldValue());
	}
	
	@Test
	public void test4() throws IOException{
		int s1 = 3;
		Checkpoint ckp4 = new Checkpoint(s1);
		ckp4.save();
		int s2 = (int) ckp4.restore();
		assertEquals(s1, s2);
	}
}
