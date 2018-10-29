package eg.edu.alexu.csd.datastructure.linkedList.cs52_cs18;

/**
 *
 * @author arabtech
 */
public class Node {
	/**
	 * .
	 *
	 * variable
	 */
	Object el;
	/**
	 * .
	 *
	 * variable
	 */
	Node next;

	/**
	 * .
	 *
	 * @param e
	 *            to
	 * @param n
	 *            to
	 */
	Node(final Object e, final Node n) {
		el = e;
		next = n;
	}
}
