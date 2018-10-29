/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs52_cs18;

/**
 *
 * @author arabtech
 */
public class Dnode {

    /**.
     *
     * variable
     */
    private Object data;
    /**.
     *
     * variable
     */
    private Dnode next;
    /**.
     *
     * variable
     */
    private Dnode prev;

    /**
     * .
     *
     * @param element to
     * @param nextE to
     * @param prevE to
     */
    public Dnode(final Object element, final Dnode nextE, final Dnode prevE) {
        this.data = element;
        this.next = nextE;
        this.prev = prevE;
    }
    /**
     * .
     *
     * @return it
     */
    public Dnode getPrev() {
        return prev;
    }
    /**
     * .
     *
     * @param prevE to
     */
    public void setPrev(final Dnode prevE) {
        this.prev = prevE;
    }
    /**
     * .
     *
     * @return data
     */
    public Object getData() {
        return data;
    }
    /**
     * .
     *
     * @param element to
     */
    public void setData(final Object element) {
        this.data = element;
    }
    /**
     * .
     *
     * @return next
     */
    public Dnode getNext() {
        return next;
    }
    /**
     * .
     *
     * @param nextE to
     */
    public void setNext(final Dnode nextE) {
        this.next = nextE;
    }
}
