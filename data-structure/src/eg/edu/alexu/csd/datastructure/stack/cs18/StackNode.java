package eg.edu.alexu.csd.datastructure.stack.cs18;

/**
 *
 * @author arabtech
 */
public class StackNode {
	/**
	 * . element t
	 */
	Object element;
	/**
	 * . next t
	 */
	StackNode next;
	/**
     * .
     * @param e t
     * @param n t
     */
	StackNode(final Object e, final StackNode n) {
		element = e;
		next = n;
	}
}
