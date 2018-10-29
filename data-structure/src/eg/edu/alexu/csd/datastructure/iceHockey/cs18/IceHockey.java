package eg.edu.alexu.csd.datastructure.iceHockey.cs18;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;
import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
/**
 * @author arabtech
 *
 */
public class IceHockey implements IPlayersFinder {
	/**
	 * . field for global variables
	 *
	 */
	/**
	 * . area of the squares
	 *
	 */
	int area = 0;
	/**
	 * . boolean array size
	 *
	 */
	public static final int LEN = 100;
	/**
	 * . step
	 *
	 */
	public static final int STEP = 4;
	/**
	 * . boolean array
	 *
	 */
	boolean[][] checked = new boolean[LEN][LEN];
	/**
	 * . boundaries
	 *
	 */
	int minI, minJ, maxI, maxJ;
	/**
	 * . vector for storing points
	 *
	 */
	Vector<Point> answer = new Vector<>();
	@Override
	public Point[] findPlayers(final String[] photo
			, final int team, final int threshold) {
		// TODO Auto-generated method stub

		// boolean[][] checked = new boolean[row][size];
		if (photo == null) {
			return null;
		} else {
			String rkm = String.valueOf(team);
			char mtlob = rkm.charAt(0);
			int size = photo.length;
			int i = 0, j = 0;
			int col = photo[0].length();
			for (i = 0; i < size; i++) {
				for (j = 0; j < col; j++) {
					char req = photo[i].charAt(j);
					if (req == mtlob) {
						area = 0;
						minI = i;
						minJ = j;
						maxI = i;
						maxJ = j;
						int ar =
dfs(photo, i, j, mtlob);
						if (ar >= threshold) {
int y = (2 * minI + 2 * (maxI + 1)) / 2;
int x = (2 * minJ + 2 * (maxJ + 1)) / 2;
Point center = new Point(x, y);
answer.add(center);
						}
					}
				}
			}
			int s = answer.size();
			Point[] fin = new Point[s];
			for (int k = 0; k < s; k++) {
fin[k] = answer.get(k);
			}
Arrays.sort(fin, new Comparator<Point>() {
public int compare(final Point a, final Point b) {
int xComp = Integer.compare(a.x, b.x);
if (xComp == 0) {
return Integer.compare(a.y, b.y);
					} else {
						return xComp;
					}
				}
			});
			for (int z = 0; z < LEN; z++) {
				for (int t = 0; t < LEN; t++) {
					checked[z][t] = false;
				}
			}
			answer.removeAllElements();
			return fin;
		}
	}
	/**.
	* Search for players locations at the given photo
	* @param photo
	* Two dimension array of photo contents
	* Will contain between 1 and 50 elements, inclusive
	* @param i
	* x place
	* @param j
	* y place
	* @param mtlob
	* el team el mtlob
	* @return
	* area
	*/
	public int dfs(final String[] photo, final int i
			, final int j, final char mtlob) {
		char req2 = photo[i].charAt(j);
		if (req2 != mtlob || checked[i][j]) {
			return area;
		} else {
			if (i <= minI) {
				minI = i;
			}
			if (maxI <= i) {
				maxI = i;
			}
			if (j <= minJ) {
				minJ = j;
			}
			if (maxJ <= j) {
				maxJ = j;
			}
			checked[i][j] = true;
			area += STEP;
			if (i - 1 >= 0) {
				dfs(photo, i - 1, j, mtlob);
			}
			if (i + 1 < photo.length) {
				dfs(photo, i + 1, j, mtlob);
			}
			if (j - 1 >= 0) {
				dfs(photo, i, j - 1, mtlob);
			}
			if (j + 1 < photo[0].length()) {
				dfs(photo, i, j + 1, mtlob);
			}
			return area;
		}
	}
}
