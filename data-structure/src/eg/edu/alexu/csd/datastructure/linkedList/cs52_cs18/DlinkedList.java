package eg.edu.alexu.csd.datastructure.linkedList.cs52_cs18;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 *
 * @author arabtech
 */
public class DlinkedList implements ILinkedList {
    /**.
     *
     * variables
     */
    Dnode head;
    /**.
     *
     * variables
     */
    Dnode tail;
    /**.
     *
     * variables
     */
    int size;
    /**.
     *
     * constractor
     */
    public DlinkedList() {
        size = 0;
    }
    /**.
     *
     * @param index to
     * @param element to
     */
    @Override
    public void add(final int index, final Object element) {
        if (index > size || index < 0) {
            throw new UnsupportedOperationException("Not supported yet.");
        } else if (size == 0 && index == 0) {
            Dnode firstNode = new Dnode(element, null, null);
            head = firstNode;
            tail = firstNode;
            size++;
            return;
        } else if (size == 1 && index == 0) {
            Dnode firstNode = new Dnode(element, tail, null);
            head = firstNode;
            tail.setPrev(firstNode);
            size++;
            return;
        } else if (size == 1 && index == 1) {
            Dnode lastNode = new Dnode(element, null, head);
            head.setNext(lastNode);
            tail = lastNode;
            size++;
            return;
        } else if (size > 1 && index == 0) {
            Dnode firstNode = new Dnode(element, head, null);
            head.setPrev(firstNode);
            head = firstNode;
            size++;
            return;
        } else if (index == size) {
            Dnode lastNode = new Dnode(element, null, tail);
            tail.setNext(lastNode);
            tail = lastNode;
            size++;
            return;
        } else {
            Dnode temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.getNext();
            }
            Dnode newNode = new Dnode(element, temp.getNext(), temp);
            temp.getNext().setPrev(newNode);
            temp.setNext(newNode);
            size++;
            return;
        }
    }
    /**.
     *
     * @param element to
     */
    @Override
    public void add(final Object element) {
        if (size == 0) {
            Dnode firstNode = new Dnode(element, null, null);
            head = firstNode;
            tail = firstNode;
            size++;
            return;
        } else {
            Dnode lastNode = new Dnode(element, null, tail);
            tail.setNext(lastNode);
            tail = lastNode;
            size++;
            return;
        }
    }
    /**.
     *
     * @param index to
     * @return it
     */
    @Override
    public Object get(final int index) {
        if (index >= size || index < 0) {
            throw new UnsupportedOperationException("Not supported yet.");
        } else if (index == 0) {
            return head.getData();
        } else if (index == size - 1) {
            return tail.getData();
        } else {
            Dnode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp.getData();
        }
    }
    /**.
     *
     * @param index to
     * @param element to
     */
    @Override
    public void set(final int index, final Object element) {
        if (index > size - 1 || index < 0) {
            throw new UnsupportedOperationException("Not supported yet.");
        } else if (index == 0) {
            head.setData(element);
        } else {
            Dnode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            temp.setData(element);
        }
    }
    /**.
     *
     * clear
     */
    @Override
    public void clear() {
        head = null;
        tail = head;
        size = 0;
    }
    /**.
     *
     * @return it
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    /**.
     *
     * @param index to
     */
    @Override
    public void remove(final int index) {
        if (index >= size || index < 0) {
            throw new UnsupportedOperationException("Not supported yet.");
        } else if (size == 1 && index == 0) {
            head = null;
            tail = head;
            size--;
            return;
        } else if (index == 0) {
            head = head.getNext();
            head.setPrev(null);
            size--;
            return;
        } else if (index == size - 1) {
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
        } else {
            Dnode temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            temp.getNext().setPrev(temp);
            size--;
        }
    }
    /**.
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }
    /**.
     *
     * @param fromIndex first index
     * @param toIndex last index
     * @return it
     */
    @Override
    public ILinkedList sublist(final int fromIndex, final int toIndex) {
        if (fromIndex < 0 || fromIndex >= size
                || toIndex < 0 || toIndex >= size) {
            throw new UnsupportedOperationException("Not supported yet.");
        } else {
            DlinkedList list = new DlinkedList();
            Dnode temp = head;
            for (int i = 0; i < fromIndex; i++) {
                temp = temp.getNext();
            }
            for (int i = fromIndex; i <= toIndex; i++) {
                list.add(temp.getData());
                temp = temp.getNext();
            }
            return list;
        }
    }
    /**.
     *
     * @param o to
     * @return it
     */
    @Override
    public boolean contains(final Object o) {
        Dnode temp = head;
        boolean contain = false;
        for (int i = 0; i < size; i++) {
            if (temp.getData().equals(o)) {
                contain = true;
            }
            temp = temp.getNext();
        }
        return contain;
    }
}
