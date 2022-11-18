package lab;

public class Student {
    private String stuId;
    private String fname;
    private String lname;

    public Student(String stuId, String fname, String lname) {
        this.stuId = stuId;
        this.fname = fname;
        this.lname = lname;
    }

    public String getId() {
        return this.stuId;
    }
    public String getName() {
        return this.fname;
    }
    public String getSurname() {
        return this.lname;
    }
    public boolean equals(Object o) {
        if (o instanceof Student s) {
            return stuId.equals(s.getId());
        }
        return false;
    }

    public int hashCode() {
        return Integer.parseInt(stuId.substring(3,7));
    }

}

