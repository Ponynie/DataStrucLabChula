package lab;

public class Student {
    //Field----------------------------------------------------------------
    private String Fname, Lname , studentId , GPA;
    //Contructor------------------------------------------------------------
    public Student(String studentId, String Fname, String Lname, String GPA) {
        this.GPA = GPA;
        this.studentId = studentId;
        this.Fname = Fname;
        this.Lname = Lname;
    }
    //Method----------------------------------------------------------------
    public void setGPAX(String GPA) {
        this.GPA = GPA;
    }
    public String getFname() {
        return this.Fname;
    }
    public String getLname() {
        return this.Lname;
    }
    public String getID() {
        return this.studentId;
    }
    public String getGPAX() {
        return this.GPA;
    }
    public boolean equals(Object o) {
        if (o instanceof Student) {
            return this.studentId.equals(((Student) o).getID());
        }
        else {
            return false;
        }
    }
    public String toString() {
        return studentId + "," + Fname + "," + Lname + "," + GPA;
    }
}

