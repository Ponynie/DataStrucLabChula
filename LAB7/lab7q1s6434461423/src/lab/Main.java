package lab;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import datastr.SeparateChainingHashMap;
//Q1
public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("register.csv");
        SeparateChainingHashMap studentTable = new SeparateChainingHashMap(16);
            //อ่านไฟล์เก็บข้อมูล
        try (Scanner sc = new Scanner(file)) { //คลุม try ไว้ปิดไฟล์เฉยๆ
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                for (int i = 0 ; i < data.length ; i++) data[i] = data[i].trim();
                Student st = new Student(data[0], data[1], data[2]); //สร้างนักเรียนกับวิชา
                CourseGrade cg = new CourseGrade(data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Float.parseFloat(data[8]));
                if (studentTable.get(st) != null) ((ArrayList<CourseGrade>) studentTable.get(st)).add(cg); //ถ้ามีอยู่แล้วให้ส่ง pointer เอามา append ลงใน arraylist ได้เลย
                else {
                    ArrayList<CourseGrade> cgList = new ArrayList<CourseGrade>(); //ถ้าไม่มีก็สร้าง arraylist เก็บ course ละ put ลง hash
                    cgList.add(cg);
                    studentTable.put(st, cgList);
                }
            }
            //รับรหัสมาแสดงผล
            System.out.println(studentTable.toString());
        }
    }
}