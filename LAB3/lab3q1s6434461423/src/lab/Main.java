package lab;

import java.util.Random;
import datastr.ArrayList;

//Q1
public class Main {
    public static void main(String[] args) {
        ArrayList num = new ArrayList(100);
        for (int i = 0; i < 100; i++) {
            num.add(i);
        }
        System.out.println("Initial list");
        for (int i = 0; i < num.size(); i++) {
            if (i == num.size() - 1) System.out.print(num.get(i));
            else System.out.print(num.get(i) + ",");
        }
        num.reverse();
        System.out.println("\nReverse");
        for (int i = 0; i < num.size(); i++) {
            if (i == num.size() - 1) System.out.print(num.get(i));
            else System.out.print(num.get(i) + ",");
        }
        Random ran = new Random();
        int i = ran.nextInt(0,100);
        int j = ran.nextInt(i,100);
        num.removeRange(i, j);
        System.out.println("\nRemove" + " " + String.valueOf(i) + ", " + String.valueOf(j));
        for (int e = 0; e < num.size(); e++) {
            if (e == num.size() - 1) System.out.print(num.get(e));
            else System.out.print(num.get(e) + ",");
        }
    }
}
