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
public class PolyNode {
    /**
     * .
     * var coef
     */
    private int coef;
    /**
     * .
     * var exp
     */
    private int exp;
    /**
     * .
     * @param coeff to
     * @param expp to
     */
    public PolyNode(final int coeff, final int expp) {
        this.coef = coeff;
        this.exp = expp;
    }
    /**
     * .
     * @return it
     */
    public int getCoef() {
        return coef;
    }
    /**
     * .
     * @param coef1 to
     */
    public void setCoef(final int coef1) {
        this.coef = coef1;
    }
    /**
     * .
     * @return it
     */
    public int getExp() {
        return exp;
    }
    /**
     * .
     * @param exp1 to
     */
    public void setExp(final int exp1) {
        this.exp = exp1;
    }
}
