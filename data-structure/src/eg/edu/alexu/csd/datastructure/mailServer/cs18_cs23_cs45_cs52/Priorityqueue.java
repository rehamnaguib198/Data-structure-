/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.mailServer.cs18_cs23_cs45_cs52;

import eg.edu.alexu.csd.datastructure.mailServer.IPriorityQueue;

/**
 *
 * @author HP
 */
public class Priorityqueue implements IPriorityQueue {

    /**
     *
     * @author HP
     */
    private Node head;
    /**
     *
     * @author HP
     */
    private Node tail;
    /**
     *
     * @author HP
     */
    private int size;

    /**
     *
     * @author HP
     */
    public Priorityqueue() {
        head = new Node(null, 0, null);
        tail = new Node(null, 0, null);
        size = 0;

    }

    @Override
    public void insert(final Object item, final int key) {
        if (key <= 0) {
            throw new UnsupportedOperationException();
        }
        if (size == 0) {
            Node n = new Node(item, key, null);
            head = n;
            tail = n;
            size++;
        } else if (size == 1) {
            Node n = new Node(item, key, null);
            if (key >= head.getKey()) {
                tail = n;
                head.setNext(tail);
                size++;
            } else if (key <= head.getKey()) {
                n.setNext(head);
                head = n;
                //head.setNext(tail);//
                size++;
            }
        } else {
            Node n = new Node(item, key, null);
            if (key >= tail.getKey()) {
                tail.setNext(n);
                tail = n;
                size++;
            } else if (key < head.getKey()) {
                n.setNext(head);
                head = n;
                size++;
            } else {
                Node s1 = head;
                while (key >= s1.getNext().getKey()) {
                    s1 = s1.getNext();
                }
                n.setNext(s1.getNext());
                s1.setNext(n);
                size++;
            }

        }

    }

    @Override
    public Object removeMin() {
        if (size == 0) {
            throw new UnsupportedOperationException("empty");
        } else {
            Object ans = head.getElement();
            head = head.getNext();
            size--;
            return ans;
        }
    }

    @Override
    public Object min() {
        if (size == 0) {
            throw new UnsupportedOperationException("empty");
        }
        return head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

}
