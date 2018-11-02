import java.util.List;

public class Student {

  private int id;
  private String name;
    private String year;
    private List<Course> course;
  private double balance;

  public Student() {
  }

    public Student(int id, String name, String year, List<Course> course, double balance) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.course = course;
    this.balance = balance;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

    public String getYear() {
    return year;
  }

    public void setYear(String year) {
    this.year = year;
  }

    public List<Course> getCourse() {
    return course;
  }

    public void setCourse(List<Course> course) {
    this.course = course;
  }

  public double getBalance() {
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
