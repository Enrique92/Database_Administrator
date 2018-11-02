public class Course {
    private int idCourse;
    private String laberCourse;
    private double price;


    public Course() {
    }

    public Course(int idCourse, String laberCourse, double price) {
        this.idCourse = idCourse;
        this.laberCourse = laberCourse;
        this.price = price;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getLaberCourse() {
        return laberCourse;
    }

    public void setLaberCourse(String laberCourse) {
        this.laberCourse = laberCourse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
