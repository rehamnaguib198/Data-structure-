/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.queue.cs18_cs23_cs45_cs52;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.linkedList.cs52_cs18.DlinkedList;

/**
 *
 * @author arabtech
 */
public class Qlinked implements IQueue, ILinkedBased {

    /**
     *
     * @author arabtech
     */
    DlinkedList link = new DlinkedList();

    /**
     * .
     * @param item
     */
    @Override
    public void enqueue(final Object item) {
        link.add(item);
    }

    /**
     * .
     * @return
     */
    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("dq");
        }
        Object ob = link.get(0);
        link.remove(0);
        return ob;
    }

    /**
     * .
     * @return
     */
    @Override
    public boolean isEmpty() {
        return link.size() == 0;

    }

    /**
     * .
     * @return
     */
    @Override
    public int size() {
        return link.size();
    }

}
