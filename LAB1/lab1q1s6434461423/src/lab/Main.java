package lab;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import datastr.ArrayCollection;
//Q1
public class Main {
    public static void main(String[] args) {
        try {
            File studentFile = new File("src/student.csv");
            Scanner scanner = new Scanner(studentFile);
            ArrayCollection collection = new ArrayCollection(4);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                collection.add(new Student(data[0],data[1],data[2],data[3]));
            }
            Scanner inputScan = new Scanner(System.in);
            System.out.println("add or delete or stop?");
            String input = inputScan.next().strip();
            while (!input.equals("stop")) { 
                boolean showQuestion = true;
                if (input.equals("add")) { //ADD
                    String[] data = new String[4];
                    for (int i = 0; i < data.length; i++) {
                        data[i] = inputScan.next().strip();
                    }
                    Student student = new Student(data[0],data[1],data[2],data[3]);
                    boolean duplicate = false;
                    for (Object i : collection.toArray()) {
                        if (student.getID().equals(((Student) i).getID())) {
                            collection.add(student);
                            collection.remove(i);
                            duplicate = true;
                            break;
                        }
                    }
                    if (!duplicate) {
                        collection.add(student);
                    }
                    System.out.println("Add new record.");
                }
                else if (input.equals("delete")) { //DELETE
                    String data = inputScan.next().strip();
                    for (Object i : collection.toArray()) {
                        if (data.equals(((Student) i ).getID())) {
                            collection.remove(i);
                        }
                    }
                    System.out.println("Remove a record.");
                }
                else { //INVALID
                    System.out.println("Invalid command.");
                    showQuestion = false;
                }
                if (showQuestion) {
                    System.out.println("add or delete or stop?");
                }
                input = inputScan.next().strip();
            }
            File studentNewFile = new File("src/studentNEW.csv");
            studentNewFile.createNewFile();
            try (PrintWriter writer = new PrintWriter(studentNewFile)) {
                for (Object i : collection.toArray()) {
                    writer.println(((Student) i).toString());
                }
            }
            System.out.println("Written to studentNew.csv");
            scanner.close();
            inputScan.close();
        }
        catch (IOException e) {
            System.out.println("File not found.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
