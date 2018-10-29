/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.datastructure.maze.cs18_cs23_cs45_cs52;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs18_cs23_cs45_cs52.Qlinked;
import eg.edu.alexu.csd.datastructure.stack.cs18.Stack;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arabtech
 */
public class MazeSolver implements IMazeSolver {

    /**
     * .
     * row to col to
     */
    int row, col;

    /**
     * .
     * @param maze to
     * @return it
     */
    @Override
    public int[][] solveBFS(final File maze) {
        row = 0;
        col = 0;
        int sRow = 0, sCol = 0;
        Point p;
        boolean findS = false;
        boolean findE = false;
        String[] mazeGame = fileToString(maze);
        boolean[][] check = new boolean[row][col];
        Point[][] parent = new Point[row][col];
        Qlinked q = new Qlinked();
        for (int i = 0; i < row; i++) {
            for (int y = 0; y < col; y++) {
                if (mazeGame[i].charAt(y) == 'S') {
                    sRow = i;
                    sCol = y;
                    findS = true;
                }
                if (mazeGame[i].charAt(y) == 'E') {
                    findE = true;
                }
            }
        }
        if (!findE) {
            throw new UnsupportedOperationException("No End Found");
        } else if (findS) {
            p = new Point(sRow, sCol);
            q.enqueue(p);
            check[sRow][sCol] = true;
            int tempR = 0;
            int tempC = 0;
            while (!q.isEmpty()) {
                Point temp = (Point) q.dequeue();
                tempR = (int) temp.getX();
                tempC = (int) temp.getY();
                check[tempR][tempC] = true;
                if (mazeGame[tempR].charAt(tempC) == 'E') {
                    break;
                } else {
                    if (tempC + 1 < col && !check[tempR][tempC + 1]
                            && mazeGame[tempR].charAt(tempC + 1) != '#') {
                        Point temp1 = new Point(tempR, tempC + 1);
                        parent[tempR][tempC + 1] = new Point(tempR, tempC);
                        q.enqueue(temp1);
                    }
                    if (tempC - 1 >= 0 && !check[tempR][tempC - 1]
                            && mazeGame[tempR].charAt(tempC - 1) != '#') {
                        Point temp1 = new Point(tempR, tempC - 1);
                        parent[tempR][tempC - 1] = new Point(tempR, tempC);
                        q.enqueue(temp1);
                    }
                    if (tempR + 1 < row && !check[tempR + 1][tempC]
                            && mazeGame[tempR + 1].charAt(tempC) != '#') {
                        Point temp1 = new Point(tempR + 1, tempC);
                        parent[tempR + 1][tempC] = new Point(tempR, tempC);
                        q.enqueue(temp1);
                    }
                    if (tempR - 1 >= 0 && !check[tempR - 1][tempC]
                            && mazeGame[tempR - 1].charAt(tempC) != '#') {
                        Point temp1 = new Point(tempR - 1, tempC);
                        parent[tempR - 1][tempC] = new Point(tempR, tempC);
                        q.enqueue(temp1);
                    }
                }
            }
            if (mazeGame[tempR].charAt(tempC) == 'E') {
                Qlinked reversedPath = new Qlinked();
                while (!(tempR == sRow && tempC == sCol)) {
                    reversedPath.enqueue(new Point(tempR, tempC));
                    Point temp2 = parent[tempR][tempC];
                    tempR = (int) temp2.getX();
                    tempC = (int) temp2.getY();
                }
                reversedPath.enqueue(new Point(sRow, sCol));
                int pathSize = reversedPath.size();
                int[][] path = new int[pathSize][2];
                for (int i = pathSize - 1; i >= 0; i--) {
                    Point temp3 = (Point) reversedPath.dequeue();
                    tempR = (int) temp3.getX();
                    tempC = (int) temp3.getY();
                    path[i][0] = tempR;
                    path[i][1] = tempC;
                }
                return path;
            } else {
                return null;
            }
        } else {
            throw new UnsupportedOperationException("No Start Found");
        }
    }

    @Override
    public int[][] solveDFS(final File maze) {
        row = 0;
        col = 0;
        String[] mazeGame = fileToString(maze);
        boolean[][] visit = new boolean[row][col];
        boolean found = false;
        boolean founds = false;
        boolean founde = false;
        //Point start;
        int x = 0, y = 0;
        Stack points = new Stack();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mazeGame[i].charAt(j) == 'S') {
                    founds = true;
                    x = i;
                    y = j;
                    visit[x][y] = true;
                    //start = new Point(i, j);
                    // points.push((Point) start);
                }
                if (mazeGame[i].charAt(j) == 'E') {
                    founde = true;
                }

            }
        }
        if (!founds) {
            throw new UnsupportedOperationException("no start");
        }
        if (!founde) {
            throw new UnsupportedOperationException("no start");
        }
        while (!found) {
            Point pos = new Point(x, y);
            if ((x + 1 < row) && (mazeGame[x + 1].charAt(y) != '#')
                    && !visit[x + 1][y]) {
                visit[x + 1][y] = true;
                points.push((Point) pos);
                if (mazeGame[x + 1].charAt(y) == 'E') {
                    Point answer = new Point(x + 1, y);
                    points.push((Point) answer);
                    found = true;
                }
                x++;
            } else if ((y + 1 < col) && (mazeGame[x].charAt(y + 1) != '#')
                    && !visit[x][y + 1]) {
                visit[x][y + 1] = true;
                points.push((Point) pos);
                if (mazeGame[x].charAt(y + 1) == 'E') {
                    Point answer = new Point(x, y + 1);
                    points.push((Point) answer);
                    found = true;
                }
                y++;
            } else if ((x - 1 >= 0) && (mazeGame[x - 1].charAt(y) != '#')
                    && !visit[x - 1][y]) {
                visit[x - 1][y] = true;
                points.push((Point) pos);
                if (mazeGame[x - 1].charAt(y) == 'E') {
                    Point answer = new Point(x - 1, y);
                    points.push((Point) answer);
                    found = true;
                }
                x--;
            } else if ((y - 1 >= 0) && (mazeGame[x].charAt(y - 1) != '#')
                    && !visit[x][y - 1]) {
                visit[x][y - 1] = true;
                points.push((Point) pos);
                if (mazeGame[x].charAt(y - 1) == 'E') {
                    Point answer = new Point(x, y - 1);
                    points.push((Point) answer);
                    found = true;
                }
                y--;
            } else {
                if (points.size() == 1) {
                    return null;
                    //return null;

                }
                points.pop();
                pos = (Point) points.peek();
                x = (int) pos.x;
                y = (int) pos.y;

            }
        }
        int[][] fa = new int[points.size()][2];
        if (found) {
            int x1 = 0, y1 = 0;
            for (int i = points.size() - 1; i >= 0; i--) {
                Point ans = new Point(0, 0);
                ans = (Point) points.pop();
                fa[i][0] = (int) ans.x;
                fa[i][1] = (int) ans.y;
            }
        }
        return fa;
    }

    /**
     * .
     * @param maze1 to
     * @return it
     */
    public String[] fileToString(final File maze1) {
        row = 0;
        col = 0;
        String[] game = null;
        FileReader f = null;
        try {
            f = new FileReader(maze1);
            BufferedReader read = new BufferedReader(f);
            StringBuilder s = new StringBuilder("");
            s.append(read.readLine());
            String[] split;
            split = s.toString().split(" ");
            row = Integer.parseInt(split[0]);
            col = Integer.parseInt(split[1]);
            game = new String[row];
            for (int i = 0; i < row; i++) {
                game[i] = read.readLine();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MazeSolver.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MazeSolver.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(MazeSolver.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return game;
    }

}
