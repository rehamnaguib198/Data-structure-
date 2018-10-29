package eg.edu.alexu.csd.datastructure.stack.cs18;

import eg.edu.alexu.csd.datastructure.stack.IStack;
import eg.edu.alexu.csd.datastructure.linkedList.cs52_cs18.DlinkedList;

/**
 *
 * @author arabtech
 */
public class Stack implements IStack {

    /**
     * . s dhd
     */
    DlinkedList s = new DlinkedList();
    /**
     * .
     *
     * stack constructor
     */
    public Stack() {
    }
    /**
     * .
     *
     * variables
     */
    int size;

    @Override
    public Object pop() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new UnsupportedOperationException();
        }
        Object el = s.get(0);
        s.remove(0);
        size--;
        return el;
    }

    @Override
    public Object peek() {
        // TODO Auto-generated method stub
        Object topElement = s.get(0);
        return topElement;
    }

    @Override
    public void push(final Object element) {
        // TODO Auto-generated method stub
        s.add(0, element);
        size++;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

}
