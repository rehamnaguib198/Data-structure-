/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs52_cs18;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author arabtech
 *
 */
public class SlinkedListTest {

	/**
	 * javadoc1.
	 */
	public SlinkedListTest() {
	}

	/**
	 * javadoc2.
	 */
	@BeforeClass
	public static void setUpClass() {
	}

	/**
	 * javadoc3.
	 */
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of add method, of class SlinkedList.
	 */
	@Test
	public void testAddRemoveSet() {
		SlinkedList list = new SlinkedList();
		final int number1 = 1;
		list.add(number1);
		list.add("a");
		list.add('b');
		final int number5 = 5;
		list.add(number1, number5);
		final int number0 = 0;
		list.add(number0, null);
		list.add(number5, 'h');
		final int number43 = 43;
		list.add(number43);
		final int number123 = 123;
		list.add(number123);
		list.remove(number5);
		list.set(1, "abc");
		assertEquals("abc", list.get(number1));
	}

	/**
	 * given test.
	 */
	@Test
	public void testclear() {
		SlinkedList list = new SlinkedList();
		final int number1 = 1;
		list.add(number1);
		final int number2 = 2;
		list.add(number2);
		final int number3 = 3;
		list.add(number3);
		final int number4 = 4;
		list.add(number4);
		final int number5 = 5;
		list.add(number5);
		list.clear();
		assertEquals(0, list.size());
	}

	/**
	 * given test.
	 */
	@Test
	public void testAddSize1() {
		SlinkedList list = new SlinkedList();
		final int number1 = 1;
		list.add(number1);
		final int number2 = 2;
		list.add(number2);
		final int number3 = 3;
		list.add(number3);
		final int number4 = 4;
		list.add(number4);
		final int number5 = 5;
		list.add(number5);
		list.clear();
		final int number0 = 0;
		list.add(number0);
		assertEquals(number1, list.size());
	}

	/**
	 * given test.
	 */
	@Test
	public void testContain() {
		SlinkedList list = new SlinkedList();
		list.add("welcome");
		list.add("to");
		list.add("csed");
		final int number21 = 21;
		list.add("number21");
		assertEquals(true, list.contains("csed"));

	}

	/**
	 * given test.
	 */
	@Test
	public void testAddSameIndex() {
		SlinkedList list = new SlinkedList();
		final int number0 = 0;
		final int number1 = 1;
		list.add(number0, number1);
		list.add(number0, "abc");
		list.add(number0, 'a');
		assertEquals('a', list.get(number0));
	}

	/**
	 * given test.
	 */
	@Test
	public void testRemove() {
		SlinkedList list = new SlinkedList();
		final int number0 = 0;
		final int number1 = 1;
		list.add(number0, number1);
		list.add(number0, "abc");
		list.add(number0, 'a');
		final int number3 = 3;
		list.add(number1, number3);
		list.add("aaabc");
		list.add('n');
		final int number111 = 111;
		list.add(number111);
		list.add("abcd");
		list.add('t');
		list.remove(number0);
		final int number5 = 5;
		list.remove(number5);
		list.remove(number1);
		final int number6 = 6;
		assertEquals(number6, list.size());
	}

	/**
	 * given test.
	 */
	@Test
	public void testSubList() {
		SlinkedList list = new SlinkedList();
		final int number0 = 0;
		final int number1 = 1;
		list.add(number0, number1);
		list.add(number1, "abc");
		list.add(number1, 'a');
		list.add("csed");
		list.add('g');
		SlinkedList aa = new SlinkedList();
		aa.add('a');
		aa.add("abc");
		final int number2 = 2;
		assertEquals(aa.get(number0),
				list.sublist(number1, number2).get(number0));
		assertEquals(aa.get(number1),
				list.sublist(number1, number2).get(number1));
	}

	/**
	 * given test.
	 */
	@Test
	public void testEmpty() {
		SlinkedList list = new SlinkedList();
		final int number0 = 0;
		final int number1 = 1;
		list.add(number0, number1);
		list.add(number1, "abc");
		list.add(number1, 'a');
		list.add("csed");
		list.add('g');
		assertEquals(false, list.isEmpty());
	}

	/**
	 * given test.
	 */
	@Test
	public void testEmpty1() {
		SlinkedList list = new SlinkedList();
		final int number0 = 0;
		final int number1 = 1;
		list.add(number0, number1);
		list.add(number1, "abc");
		list.add(number1, 'a');
		list.add("csed");
		list.add('g');
		list.clear();
		assertEquals(true, list.isEmpty());
	}

	/**
	 * given test.
	 */
	@Test
	public void testWrongIndex() {
		SlinkedList list = new SlinkedList();
		try {
			final int number1 = -1;
			list.add(number1, 'a');
			fail("Wrong Index");
		} catch (RuntimeException f) {
			System.out.println("Exception occurred");
		}
	}

	/**
	 * given test.
	 */
	@Test
	public void testWrongget() {
		SlinkedList list = new SlinkedList();
		try {
			final int number0 = 0;
			final int number2 = 2;
			list.add(number0, 'a');
			list.get(number2);
			fail("Wrong Index to get");
		} catch (RuntimeException f) {
			System.out.println("Exception occurred");
		}
	}
}
