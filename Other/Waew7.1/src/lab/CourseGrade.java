package lab;

public class CourseGrade {
    private String courseId;
    private String cname;
    private int sem;
    private int year;
    private int credit;
    private float grade;

    public CourseGrade(String courseId, String cname, int sem, int year, int credit, float grade) {
        this.courseId = courseId;
        this.cname = cname;
        this.sem = sem;
        this.year = year;
        this.credit = credit;
        this.grade = grade;
    }

    public String toString() {
        return courseId + " " + cname + " " + year + "/" + sem + " " + credit + " " + grade;
    }
}

