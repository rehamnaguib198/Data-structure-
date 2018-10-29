package eg.edu.alexu.csd.datastructure.stack.cs18;

import java.util.Scanner;

/**
 *
 * @author arabtech
 */
public class Main {

    /**
     * .
     * @param args t
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        /**
         * . st new stack
         */
        Stack st = new Stack();
        /**
         * . a loop variable
         */
        int a = 0;
        /**
         * . a loop variable
         */
        final int a1 = 1;
        /**
         * . a loop variable
         */
        final int a2 = 2;
        /**
         * . a loop variable
         */
        final int a3 = 3;
        /**
         * . a loop variable
         */
        final int a4 = 4;
        /**
         * . a loop variable
         */
        final int a5 = 5;
        /**
         * . a loop variable
         */
        final int a6 = 6;
        while (a == 0) {
            System.out.println("Choose an action");
            System.out.println("1:push\n" + "2:pop\n"
                    + "3:peek\n"
                    + "4:get size\n"
                    + "5:check if empty\n"
                    + "6:exit");
            Scanner scan = new Scanner(System.in);
            /**
             * . c action
             */
            int c = 0;
            c = scan.nextInt();
            if (c == a1) {
                System.out.println("Enter the element\n");
                st.push(scan.next());
            } else if (c == a2) {
                System.out.println("the element is:\n");
                System.out.println(st.pop());
            } else if (c == a3) {
                System.out.println("the top element is:\n");
                System.out.println(st.peek());
            } else if (c == a4) {
                System.out.println("Stack size is:\n");
                System.out.println(st.size());
            } else if (c == a5) {
                if (st.isEmpty()) {
                    System.out.println("Stack is empty\n");
                } else {
                    System.out.println("Stack is not empty\n");
                }
            } else if (c == a6) {
                break;
            } else {
                System.out.print("ERROR!\n");
            }
        }
    }
}
