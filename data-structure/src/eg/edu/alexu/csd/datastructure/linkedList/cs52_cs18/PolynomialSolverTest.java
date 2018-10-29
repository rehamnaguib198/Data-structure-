/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs52_cs18;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author arabtech
 */
public class PolynomialSolverTest {
	/**
	 * javadoc1.
	 */
    public PolynomialSolverTest() {
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
     * Test of setPolynomial method, of class PolynomialSolver.
     */
    @Test
    public void testSolveAdd() {
        PolynomialSolver poly = new PolynomialSolver();
        final int[][] test1 = {{3, 7}, {45, 5}, {176, 3}, {128, 1}};
        final int[][] test2 = {{-120, 5}, {-1, 3}, {27, 2}, {1, 1}, {-1, 0}};
        poly.setPolynomial('C',
                test1);
        poly.setPolynomial('B',
                test2);
        // assertNull("Polynomial R is not set yet", poly.print('R'));
        int[][] result1 = poly.add('B', 'C');
        // assertNotNull("Polynomial R must be set after evaluation",
        //poly.print('R'));
        final int[][] expected = {
            {3, 7}, {-75, 5}, {175, 3}, {27, 2}, {129, 1}, {-1, 0}
        };
        assertArrayEquals(expected, result1);

    }
    /**
	 * given test.
	 */
    @Test
    public void testAdd() {
        PolynomialSolver poly = new PolynomialSolver();
        final int[][] test1 = {{1, 2}, {1, 3}, {1, 4}};
        final int[][] test2 = {{2, 2}, {2, 3}, {2, 4}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('B', test2);
        int[][] result = poly.add('A', 'B');
        final int[][] expected = {
            {3, 4}, {3, 3}, {3, 2}
        };
        assertArrayEquals(expected, result);
    }
    /**
	 * given test.
	 */
    @Test
    public void testSubtract() {
        PolynomialSolver poly = new PolynomialSolver();
        final int[][] test1 = {{1, 2}, {1, 3}, {1, 4}};
        final int[][] test2 = {{1, 2}, {1, 3}, {1, 4}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('B', test2);
        int[][] result = poly.subtract('A', 'B');
        final int[][] expected = {
            {0, 4}, {0, 3}, {0, 2}
        };
        assertArrayEquals(expected, result);
    }
    /**
	 * given test.
	 */
    @Test
    public void testSubtract2() {
        PolynomialSolver poly = new PolynomialSolver();
        final int[][] test1 = {{1, 5}, {1, 6}, {1, 7}};
        final int[][] test2 = {{1, 2}, {1, 3}, {1, 4}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('B', test2);
        int[][] result = poly.subtract('A', 'B');
        final int[][] expected = {
            {1, 7}, {1, 6}, {1, 5}, {-1, 4}, {-1, 3}, {-1, 2}
        };
        assertArrayEquals(expected, result);
    }
    /**
	 * given test.
	 */
    @Test
    public void testMultiply() {
        PolynomialSolver poly = new PolynomialSolver();
        final int[][] test1 = {{1, 5}, {1, 6}, {1, 7}};
        final int[][] test2 = {{1, 2}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('B', test2);
       final int[][] result = poly.multiply('A', 'B');
       final int[][] expected = {
            {1, 9}, {1, 8}, {1, 7}
        };
        assertArrayEquals(expected, result);
    }
    /**
	 * given test.
	 */
    @Test
    public void testMultiply2() {
        PolynomialSolver poly = new PolynomialSolver();
        final int[][] test1 = {{1, 5}, {1, 6}, {1, 7}};
        final int[][] test2 = {{10, 1}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('B', test2);
        final int[][] result = poly.multiply('A', 'B');
        final int[][] expected = {
            {10, 8}, {10, 7}, {10, 6}
        };
        assertArrayEquals(expected, result);
    }
    /**
	 * given test.
	 */
    @Test
    public void testSet() {
        PolynomialSolver poly = new PolynomialSolver();
        final int[][] test1 = {{7, 25}, {1, 8}, {3, 9}};
        final int[][] test2 = {{2, 3}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('A', test2);
       final int[][] result = new int[][]{{2, 3}};
       final int[][] expected = {
            {2, 3}
        };
        assertArrayEquals(expected, result);
    }
    /**
	 * given test.
	 */
    @Test
    public void testEvaluate() {
        PolynomialSolver poly = new PolynomialSolver();
        final int[][] test1 = {{7, 25}, {1, 8}, {3, 9}};
        poly.setPolynomial('A', test1);
        final float number = 2;
        float result = poly.evaluatePolynomial('A', number);
        final float res = (float) 2.34882816E8;
        float expected = res;
        final double dec = 0.1;
        assertEquals(expected, result, dec);
    }
}
