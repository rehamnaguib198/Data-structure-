package eg.edu.alexu.csd.datastructure.calculator.cs18;
import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
/**
 * @author arabtech
 *
 */
public class Calculator implements ICalculator {
	@Override
	public int add(final int x, final int y) {
		// TODO Auto-generated method stub
		return x + y;
	}
	@Override
	public float divide(final int x, final int y) {
		if (y == 0) {
			throw new RuntimeException("Division by zero!");
		} else {
			return (float) x / y;
		}
	}
}
