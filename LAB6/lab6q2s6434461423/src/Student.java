public class Student {
    private String id, name, surname;
    public Student(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    public String getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public boolean equals(Object o) {
        if (o instanceof Student s) {
            return id.equals(s.getId()); //รหัสนิสิตแบบเต็ม unique อยู่แล้วไม่ต้องเทียบชื่อนามสกุล
        }
        return false;
    }
    public int hashCode() { //เอารหัสนิสิตตำแหน่งที่ 3-6 หากมี collision ใน hashtable ก็มี equals() ใช้เทียบอีกที
        return Integer.parseInt(id.substring(3,7));
    }
}
