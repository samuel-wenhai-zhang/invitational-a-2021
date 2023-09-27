package WorkHere;

import java.io.*;
import java.util.*;

public class Rebecca {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("rebecca.dat"));
        int test = input.nextInt();
        for (int t = 1; t <= test; t++) {
            int rows = input.nextInt();
            int cols = input.nextInt();
            int[][] canvas = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    canvas[r][c] = input.nextInt();
                }
            }
            Set<Rectangle> rectangles = new TreeSet<Rectangle>();
            search(rectangles, canvas, 0, 0, 0, 0);
            System.out.println(rectangles);
            System.out.println("Case #" + t + ": " + rectangles.size());
        }
    }

    
    public static void search(Set<Rectangle> rectangles, int[][] canvas, int r1, int r2, int c1, int c2) {
        if (r2 < canvas.length && c2 < canvas[r2].length) {
            if (canvas[r2][c2] == canvas[r1][c1]) {
                rectangles.add(new Rectangle(r1, r2, c1, c2));
                search(rectangles, canvas, r1, r2 + 1, c1, c2);
                search(rectangles, canvas, r1, r2, c1, c2 + 1);
            }
            else {
                r1 = r2;
                c1 = c2;
                search(rectangles, canvas, r1, r2, c1, c2);
            }
        }
    }
}

class Rectangle implements Comparable<Rectangle> {
    public int r1, r2, c1, c2;
    public int x, y;

    public Rectangle(int r1, int r2, int c1, int c2) {
        this.r1 = r1;
        this.r2 = r2;
        this.c1 = c1;
        this.c2 = c2;
        x = c2 - c1;
        y = r2 - r1;
    }

    @Override
    public int compareTo(Rectangle o) {
        if (r1 != o.r1) {
            return r1 - o.r1;
        }
        else {
            if (c1 != o.c1) {
                return c1 - o.c1;
            }
            else {
                if (r2 != o.r2) {
                    return r2 - o.r2;
                }
                else {
                    if (c2 != o.c2) {
                        return c2 - o.c2;
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        // return "(" + r1 + ", " + c1 + ")(" + r2 + ", " + c2 + ")";
        return x + "x" + y;
    }
}
