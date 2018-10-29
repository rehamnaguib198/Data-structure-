/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.mailServer.cs18_cs23_cs45_cs52;

/**
 *
 * @author HP
 */
public class Node {

    /**
     *
     * @author HP
     */
    private int key;
    /**
     *
     * @author HP
     */
    private Object element;
    /**
     *
     * @author HP
     */
    private Node next;

    /**
     *
     * @param x .
     * @param y .
     * @param z .
     */
    public Node(final Object x, final int y, final Node z) {
        element = x;
        key = y;
        next = z;

    }

    /**
     *
     * @return .
     */
    public int getKey() {
        return key;
    }

    /**
     *
     * @param key1 .
     */
    public void setKey(final int key1) {
        this.key = key1;
    }

    /**
     *
     * @return .
     */
    public Object getElement() {
        return element;
    }

    /**
     *
     * @param element1 .
     */
    public void setElement(final Object element1) {
        this.element = element1;
    }

    /**
     *
     * @return .
     */
    public Node getNext() {
        return next;
    }

    /**
     *
     * @param next1 .
     */
    public void setNext(final Node next1) {
        this.next = next1;
    }

}
