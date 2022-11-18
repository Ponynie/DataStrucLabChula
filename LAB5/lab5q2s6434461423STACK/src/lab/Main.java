//STACK

package lab;

import java.util.Random;

import datastr.ArrayStack;
import datastr.Stack;

public class Main {
    private static final int SPACE = -1;
    private static final int BLOCK = -9;
    private static final int[][] map = new int[10][10]; 
    private static int count = 0;

    private static class Pos {
        int row, col;
        Pos(int r, int c) {row = r; col = c;}
    }
    public static void main(String[] args) throws Exception { //STACK
        Pos a = new Pos(0,0);
        Pos b = new Pos(0,9);
        Random r = new Random(29);
        for (int i = 0; i < map.length; i++) 
            for (int j = 0; j < map[i].length; j++) 
                map[i][j] = r.nextFloat() < 0.2 ? BLOCK : SPACE;
        viewMap();
        findPath(a,b);
        viewMap();
        System.out.println("STEP " + count);
    }
    static void findPath(Pos source, Pos target) {
        map[source.row][source.col] = 0;
        map[target.row][target.col] = SPACE;
        Stack q = new ArrayStack(); q.push(source);
        while (!q.isEmpty()) {
            Pos p = (Pos) q.pop();
            if (p.row == target.row && p.col == target.col) break;
            expand(q, p.row +  1, p.col, map[p.row][p.col]);
            expand(q, p.row -  1, p.col, map[p.row][p.col]);
            expand(q, p.row, p.col + 1, map[p.row][p.col]);
            expand(q, p.row, p.col - 1, map[p.row][p.col]);
            count++;
        }
    }
    static void expand(Stack q, int r, int c, int k) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[r].length || map[r][c] != SPACE) return;
        map[r][c] = k + 1;
        q.push(new Pos(r, c));
    }
    static void viewMap() {
        System.out.println("-----------------------------------------------------");
        for (int i = 0 ; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%4d",map[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------");
    }
}

