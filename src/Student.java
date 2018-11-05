import java.util.List;

public class Student {

    private int id;
    private String name;
    private String year;
    private List<Course> course;
    private double balance;

    Student() {
    }

    public Student(int id, String name, String year, List<Course> course, double balance) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.course = course;
        this.balance = balance;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getYear() {
        return year;
    }

    void setYear(String year) {
        this.year = year;
    }

    List<Course> getCourse() {
        return course;
    }

    void setCourse(List<Course> course) {
        this.course = course;
    }

    double getBalance() {
        this.balance = 600.00;
        if (course.size() > 1) {
            balance = balance + balance;
        }
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
