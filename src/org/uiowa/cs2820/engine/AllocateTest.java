package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.BitSet;

import org.junit.Test;


 // Note: need to start with an empty memoryMap.txt file or no file to pass the tests
public class AllocateTest {
	
	@Test
	public void test0() throws IOException {
		assertEquals(Allocate.allocate(), 0);
	}
	
	@Test
	public void test1() throws IOException {
		Allocate.free(0);
		assertEquals(Allocate.getSpace().length(), 0);
	}

	@Test
	public void test2() throws IOException {
		Allocate.allocate();
		Allocate.allocate();
		assertEquals(Allocate.allocate(), 2);
	}
	/*
	@Test
	public void test3() throws IOException {
		System.out.println("test 3");
		System.out.println("b: " + b);
		System.out.println(a.getSpace());
		b = a.getSpace();
		int i = b.length() - 1;
		while (i >= 0) {
			a.free(i);
			i--;
			System.out.println("b: " + b);
		}
		b = a.getSpace();
		assertEquals(b.length(), 0);
	}
	
	@Test
	public void test4() throws IOException {
		System.out.println("test4");
		System.out.println(b);
		a.allocate();
		a.allocate();
		a.allocate();
		a.allocate();
		a.free(2);
		BitSet c = new BitSet(4);
		c.set(0,4,true);
		c.clear(2);
		assertEquals(a.getSpace(), c);
	}
	*/
}
