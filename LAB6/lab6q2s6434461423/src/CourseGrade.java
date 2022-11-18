public class CourseGrade {
    private String id, name;
    private int semester, year, credit;
    private float gpa;
    public CourseGrade(String id, String name, int semester, int year, int credit, float gpa) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.year = year;
        this.credit = credit;
        this.gpa = gpa;
    }
    public String toString() {
        return id + " " + name + " " + year + "/" + semester + " " + credit + " " + gpa;
    }
}
