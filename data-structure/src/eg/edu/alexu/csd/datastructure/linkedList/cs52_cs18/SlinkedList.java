package eg.edu.alexu.csd.datastructure.linkedList.cs52_cs18;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 *
 * @author arabtech
 */
public class SlinkedList implements ILinkedList {

    /**
     * .
     *
     * variables
     */
    Node head;
    /**
     * .
     *
     * variables
     */
    int size;

    /**
     * .
     *
     * constructor
     */
    SlinkedList() {
        head = null;
        size = 0;
    }

    /**
     * .
     *
     * @param index1 to
     * @param element to
     */
    @Override
    public void add(final int index, final Object element) {
        int index1 = index;
        Node temp;
        if (size == 0 && index1 == 0) {
            temp = new Node(element, null);
            head = temp;
            size++;
            return;
        } else if (size == 1 && index1 == 0) {
            temp = new Node(element, head);
            head = temp;
            size++;
            return;
        } else if (size == 1 && index1 == 1) {
            temp = new Node(element, null);
            head.next = temp;
            size++;
            return;
        } else if (index1 == 0) {
            Node newNode = new Node(element, head);
            head = newNode;
            size++;
            return;
        }
        index1 = index1 - 1;
        int i;
        temp = head;
        Node n;
        int flag = 0;
        for (i = 0; i < size; i++) {
            if (i != index1) {
                temp = temp.next;
            } else {
                n = new Node(element, temp.next);
                temp.next = n;
                size++;
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * .
     *
     * @param element to
     */
    @Override
    public void add(final Object element) {
        // TODO Auto-generated method stub
        int index, i = 0;
        Node n;
        if (size == 0) {
            n = new Node(element, null);
            head = n;
            size++;
        } else {
            Node temp = head;
            index = size - 1;
            for (i = 0; i < size; i++) {
                if (i != index) {
                    temp = temp.next;
                } else {
                    n = new Node(element, null);
                    temp.next = n;
                    size++;
                }
            }
        }
    }

    /**
     * .
     *
     * @param index to
     * @return it
     */
    @Override
    public Object get(final int index) {
        // TODO Auto-generated method stub
        Node temp = head;
        Object req = null;
        int flag = 0;
        if (size == 0 || index >= size) {
            throw new UnsupportedOperationException();
        } else {
            for (int i = 0; i < size; i++) {
                if (i != index) {
                    temp = temp.next;
                } else {
                    req = temp.el;
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 1) {
            return req;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * .
     *
     * @param index to
     * @param element to
     */
    @Override
    public void set(final int index, final Object element) {
        // TODO Auto-generated method stub
        Node temp = head;
        if (size == 0 || index >= size) {
            throw new UnsupportedOperationException();
        } else {
            for (int i = 0; i < size; i++) {
                if (i != index) {
                    temp = temp.next;
                } else {
                    temp.el = element;
                }
            }
        }
    }

    /**
     * .
     *
     * clear
     */
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        head = null;
        size = 0;
    }

    /**
     * .
     *
     * @return bool
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return (size == 0);
    }

    /**
     * .
     *
     * @param index to
     */
    @Override
    public void remove(final int index) {
        // TODO Auto-generated method stub
        Node temp = head;
        if (size == 0 || index >= size || index < 0) {
            throw new UnsupportedOperationException();
        }
        if (index == 0) {
            head = head.next;
            size--;
        } else {
            for (int i = 0; i < size; i++) {
                if (i == index - 1) {
                    temp.next = temp.next.next;
                    size--;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    /**
     * .
     *
     * @return size
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    /**
     * .
     *
     * @param fromindex to
     * @param toindex to
     * @return it
     */
    @Override
    public ILinkedList sublist(final int fromIndex, final int toIndex) {
        // TODO Auto-generated method stub
        Node temp = head;
        SlinkedList mylist = new SlinkedList();
        if (fromIndex < 0 || fromIndex >= size
                || toIndex < 0 || toIndex >= size) {
            throw new UnsupportedOperationException();
        } else {
            for (int i = 0; i < fromIndex; i++) {
                temp = temp.next;
            }
            for (int i = fromIndex; i < toIndex + 1; i++) {
                mylist.add(temp.el);
                temp = temp.next;
            }
        }
        return mylist;
    }

    /**
     * .
     *
     * @param object o
     * @return bool
     */
    @Override
    public boolean contains(final Object o) {
        // TODO Auto-generated method stub
        Node temp = head;
        int flag = 0;
        for (int i = 0; i < size; i++) {
            if (temp.el.equals(o)) {
                flag = 1;
                break;
            }
            temp = temp.next;
        }
        return (flag == 1);
    }
}
