package eg.edu.alexu.csd.datastructure.iceHockey.cs18;

import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;
import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
/**
 *
 * @author ahmed hamdy
 *
 */
public class IceHockeyTest {
	/**
	 * An object to test the class on.
	 */
	private IceHockey playersFinder = new IceHockey();
	/**
	 * given test.
	 */
	@Test
	public void randomPhoto4() {
		IPlayersFinder test = (IPlayersFinder) playersFinder;
		final String[] photo = {
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"};
		final int team = 4;
		final int threshold = 16;
		Point[] returnedPoints;
		returnedPoints = test.findPlayers(photo, team,
				threshold);
		final Point[] ans = {
				new Point(3, 8),
				new Point(4, 16),
				new Point(5, 4),
				new Point(16, 3),
				new Point(16, 17),
				new Point(17, 9)};
		Assert.assertArrayEquals(ans, returnedPoints);
	}
	/**
	 * given test.
	 */
	@Test
	public void randomPhoto5() {
		IPlayersFinder test = (IPlayersFinder) playersFinder;
		final String[] photo = {
				"33JUBU33",
				"3U3O4433",
				"O33P44NB",
				"PO3NSDP3",
				"VNDSD333",
				"OINFD33X"};
		final int team = 3;
		final int threshold = 16;
		Point[] returnedPoints;
		returnedPoints = test.findPlayers(photo, team,
				threshold);
		final Point[] ans = {
				new Point(4, 5),
				new Point(13, 9),
				new Point(14, 2)};
		Assert.assertArrayEquals(ans, returnedPoints);
	}
	/**
	 * given test.
	 */
	@Test
	public void randomPhoto6() {
		IPlayersFinder test = (IPlayersFinder) playersFinder;
		final String[] photo = {
				"A12YUOL",
				"OLKMTIO",
				"YOMKIL2",
				"PLRWTBO",
				"MBNROLW",
				"TKLAMFG",
				"L33MRTO",
				"OP3FRWL"};
		final int team = 3;
		final int threshold = 8;
		Point[] returnedPoints;
		returnedPoints = test.findPlayers(photo, team,
				threshold);
		final Point[] ans = {
				new Point(4, 14)};
		Assert.assertArrayEquals(ans, returnedPoints);
	}
	/**
	 * given test.
	 */
	@Test
	public void randomPhoto7() {
		IPlayersFinder test = (IPlayersFinder) playersFinder;
		final String[] photo = {
				"A12YUOL",
				"OLKMTIO",
				"YOMK5ML",
				"PLRW55A",
				"MBN555L",
				"TKLAM5Y",
				"L33MRTO",
				"OP3FRWL"};
		final int team = 5;
		final int threshold = 12;
		Point[] returnedPoints;
		returnedPoints = test.findPlayers(photo, team,
				threshold);
		final Point[] ans = {
				new Point(9, 8)};
		Assert.assertArrayEquals(ans, returnedPoints);
	}
	/**
	 * given test.
	 */
	@Test
	public void randomPhoto8() {
		IPlayersFinder test = (IPlayersFinder) playersFinder;
		final String[] photo = null;
		final int team = 5;
		final int threshold = 12;
		Point[] returnedPoints;
		returnedPoints = test.findPlayers(photo, team,
				threshold);
		final Point[] ans = null;
		Assert.assertArrayEquals(ans, returnedPoints);
	}
	/**
	 * given test.
	 */
	@Test
	public void randomPhoto9() {
		IPlayersFinder test = (IPlayersFinder) playersFinder;
		final String[] photo = {
				"A17777L",
				"OLKM77O",
				"YOM15ML",
				"P77755A",
				"MBN775L",
				"T77777Y",
				"L33MRTO",
				"OP3FRWL"};
		final int team = 7;
		final int threshold = 12;
		Point[] returnedPoints;
		returnedPoints = test.findPlayers(photo, team,
				threshold);
		final Point[] ans = {
				new Point(7, 9),
				new Point(8, 2)};
		Assert.assertArrayEquals(ans, returnedPoints);
	}
	/**
	 * given test.
	 */
	@Test
	public void randomPhoto10() {
		IPlayersFinder test = (IPlayersFinder) playersFinder;
		final String[] photo = {
				"11111",
				"1AAA1",
				"1A1A1",
				"1AAA1",
				"11111"};
		final int team = 1;
		final int threshold = 3;
		Point[] returnedPoints;
		returnedPoints = test.findPlayers(photo, team,
				threshold);
		final Point[] ans = {
				new Point(5, 5),
				new Point(5, 5)};
		Assert.assertArrayEquals(ans, returnedPoints);
	}
	/**
	 * given test.
	 */
	@Test
	public void randomPhoto11() {
		IPlayersFinder test = (IPlayersFinder) playersFinder;
		final String[] photo = {
				"44JUBU33",
				"343O4433",
				"O43P44NB",
				"P444SDP3",
				"VN4SD333",
				"OI44D33X"};
		final int team = 4;
		final int threshold = 12;
		Point[] returnedPoints;
		returnedPoints = test.findPlayers(photo, team,
				threshold);
		final Point[] ans = {
				new Point(4, 6),
				new Point(10, 4)};
		Assert.assertArrayEquals(ans, returnedPoints);
	}
}
