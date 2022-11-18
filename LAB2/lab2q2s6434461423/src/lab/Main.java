package lab;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import datastr.LinkedCollection;

public class Main {
    public static void main(String[] args) throws IOException {
        //----------------------------------------------------------------------------------------------Student
        File fileS = new File("src/student.csv"); 
        Scanner scannerS = new Scanner(fileS);
        LinkedCollection collectionS = new LinkedCollection();
        while (scannerS.hasNextLine()) {
            String[] dataS = scannerS.nextLine().split(",");
            collectionS.add(new Student(dataS[0],dataS[1],dataS[2],dataS[3]));
        }
        if (!collectionS.containsDup()) System.out.println("No duplicate student.");
        else {
            collectionS.removeDup();
            System.out.println("Duplicate students in file. Removed.\n");
        }
        scannerS.close();
        //------------------------------------------------------------------------------------------------Withdraw
        File fileW = new File("src/withdraw.csv"); 
        Scanner scannerW = new Scanner(fileW);
        LinkedCollection collectionW = new LinkedCollection();
        while (scannerW.hasNextLine()) {
            String[] dataW = scannerW.nextLine().split(",");
            collectionW.add(new Student(dataW[0],dataW[1],dataW[2],dataW[3]));
        }
        if (!collectionW.containsDup()) System.out.println("No duplicate withdraw.\n");
        else {
            collectionW.removeDup();
            System.out.println("Duplicate withdraws in file. Removed.\n");
        }
        scannerW.close();
        //------------------------------------------------------------------------------------------------Display
        if (collectionS.equals(collectionW)) {
            System.out.println("All withdrew (" + String.valueOf(collectionW.size()) + ")");
            for (Object i : collectionS.toArray()) {
                System.out.println(i.toString());
            }
        }
        else {
            for (Object i : collectionW.toArray()) {
                collectionS.remove(i);
            }
            System.out.println("All registered (" + String.valueOf(collectionS.size()) + ")");
            for (int i = 0; i < collectionS.size(); i++) {
                if (i == collectionS.size() - 1) System.out.println(collectionS.toArray()[i].toString() + "\n");
                else System.out.println(collectionS.toArray()[i].toString());
            }
            System.out.println("All withdrew (" + String.valueOf(collectionW.size()) + ")");
            for (int i = 0; i < collectionW.size(); i++) {
                System.out.println(collectionW.toArray()[i].toString());
            }
        }
    }
}
