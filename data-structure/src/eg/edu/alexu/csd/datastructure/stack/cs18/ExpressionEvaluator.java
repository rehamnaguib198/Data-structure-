package eg.edu.alexu.csd.datastructure.stack.cs18;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 *
 * @author arabtech
 */
public class ExpressionEvaluator implements IExpressionEvaluator {

    /**
     * . s dhd
     */
    Stack s = new Stack();
    /**
     * . e dhd
     */
    Stack e = new Stack();
    /**
     * . st dhd
     */
    StringBuilder st = new StringBuilder("");

    @Override
    public String infixToPostfix(final String expression) {
        // TODO Auto-generated method stub
        /**
         * . left dhd
         */
        boolean left = false;
        /**
         * . sign dhd
         */
        int sign = 1;
        /**
         * . ws dhd
         */
        char ws = ' ';
        if (expression == "") {
            throw new UnsupportedOperationException();
        } else {
            for (int i = 0; i < expression.length(); i++) {
                int last = expression.length() - 1;
                char current = expression.charAt(i);
                if (Character.isWhitespace(current)
                        && i != expression.length() - 1) {
                	continue;
                } else if (sign == 1
                        && (current == '+'
                        || current == '-'
                        || current == '*'
                        || current == '/')) {
                    throw new UnsupportedOperationException();
                } else if (Character.isLetterOrDigit(current)) {
                    st.append(current);
                    while (i + 1 < expression.length()) {
                        if (Character.isDigit(expression.charAt(i + 1))) {
                            st.append(expression.charAt(i + 1));
                            i++;
                        } else {
                            break;
                        }
                    }
                    st.append(ws);
                    sign = 0;
                } else if ((current == '+'
                        || current == '-')
                        && sign == 0
                        && i != last) {
                    while (!s.isEmpty()) {
                        if (s.peek().equals('*')
                                || s.peek().equals('/')
                                || s.peek().equals('+')
                                || s.peek().equals('-')) {
                            st.append(s.pop());

                            st.append(ws);
                        } else {
                            break;
                        }
                    }
                    s.push(current);
                    sign = 1;
                } else if ((current == '*'
                        || current == '/')
                        && sign == 0
                        && i != last) {
                    while (!s.isEmpty()) {
                        if (s.peek().equals('*') || s.peek().equals('/')) {
                            st.append(s.pop());
                            st.append(ws);
                        } else {
                            break;
                        }
                    }
                    sign = 1;
                    s.push(current);
                } else if (current == '(' && i != last) {
                    s.push(current);
                    left = true;
                } else if (current == ')' && left) {
                    while (!s.peek().equals('(')) {
                        if (!s.isEmpty()) {
                            if ((char) s.peek() != '(') {

                                st.append(s.pop());
                                st.append(ws);
                            }
                        }
                    }
                    s.pop();
                    sign = 0;
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            while (!s.isEmpty()) {
                if ((char) s.peek() != '(') {

                    st.append(s.pop());
                    st.append(ws);
                } else {
                    s.pop();
                }

            }
        }
        String n = st.toString();
        String result = n.substring(0, n.length() - 1);
        return result;
    }

    @Override
    public int evaluate(final String expression) {
        // TODO Auto-generated method stub
        float answer = 0;
        final int ch = 48;
        if (expression.equals("")) {
            throw new UnsupportedOperationException();
        } else {
            for (int i = 0; i < expression.length(); i++) {
                String m = "";
                char current = expression.charAt(i);
                if (Character.isWhitespace(current)) {
                	continue;
                } else if (Character.isDigit(current)
                        && (!Character.isDigit(expression.charAt(i + 1)))) {
                    float c = current;
                    c = c - ch;
                    e.push(c);
                } else if (Character.isDigit(current)
                        && Character.isDigit(expression.charAt(i + 1))) {
                    int k = i;
                    m += expression.charAt(k);
                    while (expression.charAt(k + 1) != ' ') {
                        m += expression.charAt(k + 1);
                        k++;
                        i++;
                    }
                    int c = Integer.parseInt(m);
                    e.push((float) c);
                } else if (current == '+') {
                    if (e.size >= 2) {
                        float first = (float) e.pop();
                        float second = (float) e.pop();
                        float res = first + second;
                        e.push(res);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else if (current == '-') {
                    if (e.size >= 2) {
                        float first = (float) e.pop();
                        float second = (float) e.pop();
                        float res = second - first;
                        e.push(res);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else if (current == '*') {
                    if (e.size >= 2) {
                        float first = (float) e.pop();
                        float second = (float) e.pop();
                        float res = first * second;
                        e.push(res);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else if (current == '/') {
                    if (e.size >= 2) {
                        float first = (float) e.pop();
                        float second = (float) e.pop();
                        float res = second / first;
                        e.push(res);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            if (e.size() == 1) {
                answer = (float) e.pop();
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return Math.round(answer);
    }
}
