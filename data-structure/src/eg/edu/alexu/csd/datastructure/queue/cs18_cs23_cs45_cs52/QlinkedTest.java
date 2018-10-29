package eg.edu.alexu.csd.datastructure.queue.cs18_cs23_cs45_cs52;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author arabtech
 *
*/
public class QlinkedTest {

    /**
     * javadoc1.
     */
    public QlinkedTest() {
    }

    /**
     * javadoc1.
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * javadoc1.
     */
    @AfterClass
    public static void tearDownClass() {
    }
    /**.
     * num0 t
     */
    final int num0 = 0;
    /**.
     * num1 t
     */
    final int num1 = 1;
    /**.
     * num4 t
     */
    final int num4 = 4;
    /**.
     * num5 t
     */
    final int num5 = 5;
    /**.
     * num6 t
     */
    final int num6 = 6;

    /**
     * Test of enqueue method, of class Qlinked.
     */
    @Test
    public void testenqueue() {
        Qlinked d = new Qlinked();
        d.enqueue(num5);
        d.enqueue(num6);
        d.enqueue(num0);
        d.enqueue(num1);

        assertEquals(num5, d.dequeue());
    }

    /**
     * given test.
     */
    @Test
    public void testenqueue1() {
        Qlinked d = new Qlinked();
        d.enqueue("alahly");
        d.enqueue(num6);
        d.enqueue('k');
        d.enqueue(num1);

        assertEquals("alahly", d.dequeue());
    }

    /**
     * given test.
     */
    @Test
    public void testenqueue2() {
        Qlinked d = new Qlinked();
        d.enqueue(num5);
        d.enqueue(num6);
        d.enqueue(num0);
        d.enqueue(num1);
        d.dequeue();
        d.dequeue();
        d.dequeue();

        assertEquals(num1, d.dequeue());
    }

    /**
     * given test.
     */
    @Test
    public void testsize() {
        Qlinked d = new Qlinked();
        d.enqueue(num5);
        d.enqueue(num6);
        d.enqueue(num0);
        d.enqueue(num1);

        assertEquals(num4, d.size());
    }

    /**
     * given test.
     */
    @Test
    public void testsize1() {
        Qlinked d = new Qlinked();
        d.enqueue(num5);
        d.enqueue(num6);
        d.enqueue(num0);
        d.enqueue(num1);
        d.dequeue();
        d.dequeue();
        d.dequeue();
        d.dequeue();

        assertEquals(num0, d.size());
    }

    /**
     * given test.
     */
    @Test
    public void testempty() {
        Qlinked d = new Qlinked();
        d.enqueue(num5);
        d.enqueue(num6);
        d.enqueue(num0);
        d.enqueue(num1);
        d.dequeue();

        assertEquals(false, d.isEmpty());
    }

    /**
     * given test.
     */
    @Test
    public void testempty1() {
        Qlinked d = new Qlinked();
        d.enqueue(num5);
        d.enqueue(num6);
        d.enqueue(num0);
        d.enqueue(num1);
        d.dequeue();
        d.dequeue();
        d.dequeue();
        d.dequeue();

        assertEquals(true, d.isEmpty());
    }

    /**
     * given test.
     */
    @Test
    public void testerror() {
        Qlinked d = new Qlinked();
        try {
            d.dequeue();
            fail("empty queue");
        } catch (RuntimeException f) {
            System.out.println("Exception occurred");
        }
    }

    /**
     * given test.
     */
    @Test
    public void testerror1() {
        Qlinked d = new Qlinked();
        try {
            d.enqueue(num4);
            d.enqueue(num4);
            d.enqueue(num4);
            d.enqueue(num4);
            d.dequeue();
            d.dequeue();
            d.dequeue();
            d.dequeue();
            d.dequeue();
            d.dequeue();
            fail("empty queue");
        } catch (RuntimeException f) {
            System.out.println("Exception occurred");
        }
    }

}
