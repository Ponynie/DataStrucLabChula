package lab;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import datastr.SeparateChainingHashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("register.csv");
        SeparateChainingHashMap stuTable = new SeparateChainingHashMap(14);

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(",");
            for (int i = 0; i < data.length; i++) data[i] = data[i].trim();
            Student stu = new Student(data[0], data[1], data[2]);
            CourseGrade courseGrade = new CourseGrade(data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Float.parseFloat(data[8]));
            if (stuTable.get(stu) != null) {
                ((ArrayList<CourseGrade>) stuTable.get(stu)).add(courseGrade);
            } 
            else {
                ArrayList<CourseGrade> cgList = new ArrayList<CourseGrade>();
                cgList.add(courseGrade);
                stuTable.put(stu, cgList);
            }
        }
            System.out.println(stuTable.toString());
            sc.close();
    }
}

