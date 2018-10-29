/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs52_cs18;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 *
 * @author arabtech
 */
public class PolynomialSolver implements IPolynomialSolver {

    /**
     * .
     * var a
     */
    DlinkedList a = new DlinkedList();
    /**
     * .
     * var b
     */
    DlinkedList b = new DlinkedList();
    /**
     * .
     * var c
     */
    DlinkedList c = new DlinkedList();
    /**
     * .
     * var r
     */
    DlinkedList r = new DlinkedList();
    /**
     * .
     * var boola
     */
    boolean boola = false;
    /**
     * .
     * var boolb
     */
    boolean boolb = false;
    /**
     * .
     * var boolc
     */
    boolean boolc = false;
    /**
     * .
     * var boolr
     */
    boolean boolr = false;

    /**
     * .
     * @param poly to
     * @param terms to
     */
    @Override
    public void setPolynomial(final char poly, final int[][] terms) {
        if (poly == 'A') {
            a.clear();
            for (int i = 0; i < terms.length; i++) {
                if (terms[i][0] != 0) {
                    a.add(new PolyNode(terms[i][0], terms[i][1]));
                }
            }
            sumOfCoeff(a);
            sortList(a);
            boola = true;
        } else if (poly == 'B') {
            b.clear();
            for (int i = 0; i < terms.length; i++) {
                if (terms[i][0] != 0) {
                    b.add(new PolyNode(terms[i][0], terms[i][1]));
                }
            }
            sumOfCoeff(b);
            sortList(b);
            boolb = true;
        } else if (poly == 'C') {
            c.clear();
            for (int i = 0; i < terms.length; i++) {
                if (terms[i][0] != 0) {
                    c.add(new PolyNode(terms[i][0], terms[i][1]));
                }
            }
            sumOfCoeff(c);
            sortList(c);
            boolc = true;
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    /**
     * .
     *
     * @param list to
     * @return it polynomial to
     */
    public String printList(final DlinkedList list) {
        String str = "";
        for (int i = 0; i < list.size; i++) {
            PolyNode temp = (PolyNode) list.get(i);
            if (temp.getCoef() != 0) {
                if (temp.getCoef() != 1 && temp.getCoef() != -1) {
                    if (i == 0 && temp.getExp() != 0 && temp.getExp() != 1) {
                        str += (temp.getCoef() + "x^" + temp.getExp());
} else if (i == 0 && temp.getExp() != 0
                    		&& temp.getExp() == 1) {
                        str += (temp.getCoef() + "x");
                    } else if (i == 0 && temp.getExp() == 0) {
                        str += (String.valueOf(temp.getCoef()));
                    } else {
                        if (temp.getCoef() > 0
&& temp.getExp() != 0 && temp.getExp() != 1) {
                            str += ("+" + Math.abs(temp.getCoef())
                            + "x^" + temp.getExp());
                        } else if (temp.getCoef() > 0
&& temp.getExp() != 0 && temp.getExp() == 1) {
                            str += ("+" + Math.abs(temp.getCoef()) + "x");
                        } else if (temp.getCoef() < 0
&& temp.getExp() == 0) {
                            str += ("-" + Math.abs(temp.getCoef()));
                        } else if (temp.getCoef() > 0
&& temp.getExp() == 0) {
                            str += ("+" + Math.abs(temp.getCoef()));
                        } else if (temp.getCoef() < 0
&& temp.getExp() != 0 && temp.getExp() != 1) {
str += ("-" + Math.abs(temp.getCoef()) + "x^" + temp.getExp());
                        } else if (temp.getCoef() < 0
&& temp.getExp() != 0
&& temp.getExp() == 1) {
str += ("-" + Math.abs(temp.getCoef()) + "x");
                        }
                    }
                } else if (temp.getCoef() == 1) {
                    if (i == 0 && temp.getExp() != 0
&& temp.getExp() != 1) {
str += ("x^" + temp.getExp());
                    } else if (i == 0 && temp.getExp() != 0
&& temp.getExp() == 1) {
str += ("x");
                    } else if (i == 0
&& temp.getExp() == 0) {
str += (String.valueOf(temp.getCoef()));
                    } else if (i != 0) {
                        if (temp.getExp() != 0
&& temp.getExp() != 1) {
                            str += ("+" + "x^" + temp.getExp());
                        } else if (temp.getExp() != 0
&& temp.getExp() == 1) {
                            str += ("+" + "x");
                        } else if (temp.getExp() == 0) {
                            str += ("+" + temp.getCoef());
                        }
                    }
                } else if (temp.getCoef() == -1) {
                    if (i == 0 && temp.getExp() != 0
&& temp.getExp() != 1) {
                        str += ("-" + "x^" + temp.getExp());
                    } else if (i == 0 && temp.getExp() != 0
&& temp.getExp() == 1) {
                        str += ("-" + "x");
                    } else if (i == 0 && temp.getExp() == 0) {
                        str += (String.valueOf(temp.getCoef()));
                    } else if (i != 0) {
                        if (temp.getExp() != 0
&& temp.getExp() != 1) {
                            str += ("-" + "x^" + temp.getExp());
                        } else if (temp.getExp() != 0
&& temp.getExp() == 1) {
                            str += ("-" + "x");
                        } else if (temp.getExp() == 0) {
                            str += ("-" + Math.abs(temp.getCoef()));
                        }
                    }
                }
            }
        }
        if (str == "") {
            return "0";
        }
        return str;
    }

    /**
     * .
     *
     * @param poly
     * @return it
     */
    @Override
    public String print(final char poly) {
        if (poly == 'A' && boola) {
            return printList(a);
        } else if (poly == 'B' && boolb) {
            return printList(b);
        } else if (poly == 'C' && boolc) {
            return printList(c);
        } else if (poly == 'R' && boolr) {
            return printList(r);
        } else {
            return null;
        }
    }

    /**
     * .
     *
     * @param poly
     */
    @Override
    public void clearPolynomial(final char poly) {
        if (poly == 'A') {
            a.clear();
            boola = false;
        } else if (poly == 'B') {
            b.clear();
            boolb = false;
        } else if (poly == 'C') {
            c.clear();
            boolc = false;
        } else if (poly == 'R') {
            r.clear();
            boolr = false;
        }
    }

    /**
     * .
     *
     * @param poly
     * @param value
     * @return it
     */
    @Override
    public float evaluatePolynomial(final char poly, final float value) {
        float res = 0;
        if (poly == 'A' && boola) {
            for (int i = 0; i < a.size(); i++) {
                PolyNode temp = (PolyNode) a.get(i);
                res += temp.getCoef() * Math.pow(value, temp.getExp());
            }
            return res;
        } else if (poly == 'B' && boolb) {
            for (int i = 0; i < b.size(); i++) {
                PolyNode temp = (PolyNode) b.get(i);
                res += temp.getCoef() * Math.pow(value, temp.getExp());
            }
            return res;
        } else if (poly == 'C' && boolc) {
            for (int i = 0; i < c.size(); i++) {
                PolyNode temp = (PolyNode) c.get(i);
                res += temp.getCoef() * Math.pow(value, temp.getExp());
            }
            return res;
        } else if (poly == 'R' && boolr) {
            for (int i = 0; i < r.size(); i++) {
                PolyNode temp = (PolyNode) r.get(i);
                res += temp.getCoef() * Math.pow(value, temp.getExp());
            }
            return res;
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    /**
     * .
     * @param list1 to
     * @param list2 to
     * @return it it
     */
    public int[][] addLists(final DlinkedList list1, final DlinkedList list2) {
        int s1 = list1.size();
        int s2 = list2.size();
        for (int i = 0; i < s1; i++) {
            r.add((PolyNode) list1.get(i));
        }
        for (int i = 0; i < s2; i++) {
            r.add((PolyNode) list2.get(i));
        }
        boolr = true;
        sumOfCoeff(r);
        sortList(r);
        return toArray(r);
    }

    /**
     * .
     * @param list1 to
     * @param list2 to
     * @return it
     */
    public int[][] sublists(final DlinkedList list1, final DlinkedList list2) {
        int s1 = list1.size();
        int s2 = list2.size();
        for (int i = 0; i < s1; i++) {
            r.add(list1.get(i));
        }
        for (int i = 0; i < s2; i++) {
            PolyNode temp = (PolyNode) list2.get(i);
            r.add(new PolyNode(-1 * temp.getCoef(), temp.getExp()));
        }
        boolr = true;
        sumOfCoeff(r);
        sortList(r);
        return toArray(r);
    }

    /**
     * .
     *
     * @param poly1 to
     * @param poly2 to
     * @return it
     */
    @Override
    public int[][] add(final char poly1, final char poly2) {
        if (poly1 == 'A' && boola && boolb && poly2 == 'B') {
            r.clear();
            return addLists(a, b);
        } else if (poly1 == 'A' && boola && boolc && poly2 == 'C') {
            r.clear();
            return addLists(a, c);
        } else if (poly1 == 'B' && boolc && boolb && poly2 == 'C') {
            r.clear();
            return addLists(b, c);
        } else if (poly1 == 'B' && boola && boolb && poly2 == 'A') {
            r.clear();
            return addLists(a, b);
        } else if (poly1 == 'C' && boola && boolc && poly2 == 'A') {
            r.clear();
            return addLists(a, c);
        } else if (poly1 == 'C' && boolc && boolb && poly2 == 'B') {
            r.clear();
            return addLists(b, c);
        } else if (poly1 == 'A' && boola && poly2 == 'A') {
            r.clear();
            return addLists(a, a);
        } else if (poly1 == 'B' && boolb && poly2 == 'B') {
            r.clear();
            return addLists(b, b);
        } else if (poly1 == 'C' && boolc && poly2 == 'C') {
            r.clear();
            return addLists(c, c);
        } else {
            throw new UnsupportedOperationException("add.");
        }
    }

    /**
     * .
     *
     * @param poly1 to
     * @param poly2 to
     * @return it
     */
    @Override
    public int[][] subtract(final char poly1, final char poly2) {
        if (poly1 == 'A' && poly2 == 'B' && boola && boolb) {
            r.clear();
            return sublists(a, b);
        } else if (poly1 == 'A' && boola && boolc && poly2 == 'C') {
            r.clear();
            return sublists(a, c);
        } else if (poly1 == 'B' && boolc && boolb && poly2 == 'C') {
            r.clear();
            return sublists(b, c);
        } else if (poly1 == 'B' && boola && boolb && poly2 == 'A') {
            r.clear();
            return sublists(b, a);
        } else if (poly1 == 'C' && boolc && boolb && poly2 == 'B') {
            r.clear();
            return sublists(c, b);
        } else if (poly1 == 'C' && boola && boolc && poly2 == 'A') {
            r.clear();
            return sublists(c, a);
        } else if (poly1 == 'A' && boola && poly2 == 'A') {
            r.clear();
            return sublists(a, a);
        } else if (poly1 == 'B' && boolb && poly2 == 'B') {
            r.clear();
            return sublists(b, b);
        } else if (poly1 == 'C' && boolc && poly2 == 'C') {
            r.clear();
            return sublists(c, c);
        } else {
            throw new UnsupportedOperationException("subtract.");
        }
    }

    /**
     * .
     *
     * @param poly1 to
     * @param poly2 to
     * @return it
     */
    @Override
    public int[][] multiply(final char poly1, final char poly2) {
        if ((poly1 == 'A' || poly2 == 'A') && boola
        		&& (poly1 == 'B' || poly2 == 'B') && boolb) {
            r.clear();
            for (int i = 0; i < a.size(); i++) {
                for (int y = 0; y < b.size(); y++) {
                    PolyNode temp = (PolyNode) a.get(i);
                    PolyNode temp2 = (PolyNode) b.get(y);
                    r.add(new PolyNode(temp.getCoef() * temp2.getCoef()
                    		, temp.getExp() + temp2.getExp()));
                }
            }
            sumOfCoeff(r);
            sortList(r);
            boolr = true;
            return toArray(r);
        } else if ((poly1 == 'A' || poly2 == 'A') && boola
        		&& (poly2 == 'C' || poly1 == 'C') && boolc) {
            r.clear();
            for (int i = 0; i < a.size(); i++) {
                for (int y = 0; y < c.size(); y++) {
                    PolyNode temp = (PolyNode) a.get(i);
                    PolyNode temp2 = (PolyNode) c.get(y);
                    r.add(new PolyNode(temp.getCoef() * temp2.getCoef()
                    		, temp.getExp() + temp2.getExp()));
                }
            }
            sumOfCoeff(r);
            sortList(r);
            boolr = true;
            return toArray(r);
        } else if ((poly1 == 'B' || poly2 == 'B') && boolb
        		&& (poly2 == 'C' || poly1 == 'C') && boolc) {
            r.clear();
            for (int i = 0; i < b.size(); i++) {
                for (int y = 0; y < c.size(); y++) {
                    PolyNode temp = (PolyNode) b.get(i);
                    PolyNode temp2 = (PolyNode) c.get(y);
                    r.add(new PolyNode(temp.getCoef() * temp2.getCoef(),
                    		temp.getExp() + temp2.getExp()));
                }
            }
            sumOfCoeff(r);
            sortList(r);
            boolr = true;
            return toArray(r);
        } else if ((poly1 == 'B' || poly2 == 'B') && boolb
        		&& (poly2 == 'B' || poly1 == 'B') && boolb) {
            r.clear();
            for (int i = 0; i < b.size(); i++) {
                for (int y = 0; y < b.size(); y++) {
                    PolyNode temp = (PolyNode) b.get(i);
                    PolyNode temp2 = (PolyNode) b.get(y);
                    r.add(new PolyNode(temp.getCoef() * temp2.getCoef(),
                    		temp.getExp() + temp2.getExp()));
                }
            }
            sumOfCoeff(r);
            sortList(r);
            boolr = true;
            return toArray(r);
        } else if ((poly1 == 'A' || poly2 == 'A') && boola
        		&& (poly2 == 'A' || poly1 == 'A') && boola) {
            r.clear();
            for (int i = 0; i < a.size(); i++) {
                for (int y = 0; y < a.size(); y++) {
                    PolyNode temp = (PolyNode) a.get(i);
                    PolyNode temp2 = (PolyNode) a.get(y);
                    r.add(new PolyNode(temp.getCoef() * temp2.getCoef(),
                    		temp.getExp() + temp2.getExp()));
                }
            }
            sumOfCoeff(r);
            sortList(r);
            boolr = true;
            return toArray(r);
        } else if ((poly1 == 'C' || poly2 == 'C') && boolc
        		&& (poly2 == 'C' || poly1 == 'C') && boolc) {
            r.clear();
            for (int i = 0; i < c.size(); i++) {
                for (int y = 0; y < c.size(); y++) {
                    PolyNode temp = (PolyNode) c.get(i);
                    PolyNode temp2 = (PolyNode) c.get(y);
                    r.add(new PolyNode(temp.getCoef() * temp2.getCoef(),
temp.getExp() + temp2.getExp()));
                }
            }
            sumOfCoeff(r);
            sortList(r);
            boolr = true;
            return toArray(r);
        } else {
            throw new UnsupportedOperationException("multiply error");
        }
    }

    /**
     * .
     *
     * @param list to
     */
    public void sumOfCoeff(final DlinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            PolyNode temp;
            temp = (PolyNode) list.get(i);
            int tempE = temp.getExp();
            int tempC = temp.getCoef();
            for (int y = i + 1; y < list.size(); y++) {
                PolyNode temp2 = (PolyNode) list.get(y);
                if (temp2.getExp() == tempE) {
                    PolyNode temp3 = new PolyNode(tempC
                    		+ temp2.getCoef(), tempE);
                    list.set(i, temp3);
                    temp = temp3;
                    tempE = temp.getExp();
                    tempC = temp.getCoef();
                    list.remove(y);
                    y--;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            PolyNode temp;
            temp = (PolyNode) list.get(i);
            if (temp.getCoef() == 0) {
                list.remove(i);
                i--;
            }
        }
        if (list.size() == 0) {
            PolyNode temp = new PolyNode(0, 0);
            list.add(temp);
        }
    }

    /**
     * .
     *
     * @param list to
     */
    public void sortList(final DlinkedList list) {
        int n = list.size();
        int tempC;
        int tempE;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                PolyNode temp = (PolyNode) list.get(j - 1);
                PolyNode temp1 = (PolyNode) list.get(j);
                if (temp.getExp() < temp1.getExp()) {
                    tempC = temp.getCoef();
                    tempE = temp.getExp();
                    list.set(j - 1,
                    		new PolyNode(temp1.getCoef(), temp1.getExp()));
                    list.set(j, new PolyNode(tempC, tempE));
                }

            }
        }

    }

    /**
     * .
     *
     * @param list to
     * @return it
     */
    public int[][] toArray(final DlinkedList list) {
        int[][] polyArray = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            PolyNode temp = (PolyNode) list.get(i);
            polyArray[i][0] = temp.getCoef();
            polyArray[i][1] = temp.getExp();
        }
        return polyArray;
    }

    /**
     * .
     *
     * @param list to
     */
    public void subtractCoeff(final DlinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            PolyNode temp;
            temp = (PolyNode) list.get(i);
            int tempE = temp.getExp();
            int tempC = temp.getCoef();
            for (int y = i + 1; y < list.size(); y++) {
                PolyNode temp2 = (PolyNode) list.get(y);
                if (temp2.getExp() == tempE) {
                    PolyNode temp3 = new PolyNode(tempC
                    		- temp2.getCoef(), tempE);
                    list.set(i, temp3);
                    list.remove(y);
                    y--;
                }
            }
        }
    }
}
