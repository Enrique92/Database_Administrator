import java.util.Date;

public class Student {

  private int id;
  private String name;
  private Date year;
  private String course;
  private double balance;

  public Student() {
  }

  public Student(int id, String name, Date year, String course, double balance) {
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

  public Date getYear() {
    return year;
  }

  public void setYear(Date year) {
    this.year = year;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
