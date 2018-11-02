import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    /* List for students that the database will have */
    private List<Student> students;
    /* List of courses that the students can be */
    private List<Course> courses;
    /* We have the number of times we have to ask for the new student */
    private int cont = 0;
    private static final String MENU_PROGRAM = "-------------------------\n"
            + "- DataBase for Students -\n"
            + "-------------------------\n"
            + "How many students do you need?";

    public Menu() {
        /* We fill the List of courses */
        this.students = new ArrayList<Student>();
        this.courses = new ArrayList<Course>();
        addCourses();
    }

    /**
     * This is the constructor
     * @param students
     * @param courses
     */
    public Menu(List<Student> students, List<Course> courses) {
        this.students = students;
        this.courses = courses;
    }

    /**
     * This is the menu that the user of the app will see
     */
    public void menu() {
        int numberStudents = 0;
        System.out.println(MENU_PROGRAM);
        numberStudents = scanner.nextInt();

        while (cont != numberStudents) {
            if (numberStudents == 0) {
                System.out.println("You need to have at least one student!!!");
                numberStudents = scanner.nextInt();
            } else {
                while (cont != numberStudents) {
                    Student std = new Student();

                    /* We introduce the name of the std */
                    System.out.print("Introduce the name of the student: ");
                    String name = scanner.next();

                    while (name.isEmpty()) {
                        if (name.isEmpty()) {
                            System.out.println("The name can't be empty!!!");
                        }
                    }
                    std.setName(name);

                    /* Show the courses available */
                    showCourses();

                    /* We introduce the course of the std */
                    System.out.print("Introduce the ID of course of the student: ");
                    String idCourse = scanner.next();

                    while (idCourse.isEmpty()) {
                        if (idCourse.isEmpty()) {
                            System.out.println("The student have to be in a course!!!");
                        }
                    }
                    std.setCourse(courses.get(Integer.parseInt(idCourse)).getLaberCourse());

                    /* We get the id the of the course and we can get of the label the level of the course
                     * xxxx 101 --> we get the 101 from the label that is the digit that we need for the
                     * id of the std
                     */
                    String aux = getIdCourseLevel(Integer.parseInt(idCourse));

                    /* We introduce the id of the std */
                    String val = createIdStudent(aux);
                    std.setId(Integer.parseInt(val));



                    /* We add the std to the List */
                    students.add(std);

                    /* We increment the cont to ask the number of the students only */
                    cont++;

                    System.out.println("size " + students.size());

                    /* OPTION FOR THE STUDENT TO SEE ITS BALANCE */
                }
            }
        }
    }

    /**
     * We are going to add here all the courses that the student can have
     */
    public void addCourses() {
        courses.add(new Course(0, "History          101", 600.00));
        courses.add(new Course(1, "Mathematics      101", 600.00));
        courses.add(new Course(2, "English          101", 600.00));
        courses.add(new Course(3, "Chemistry        101", 600.00));
        courses.add(new Course(4, "Computer Science 101", 600.00));
    }

    /**
     * Show all the courses that the student can have
     */
    public void showCourses() {
        for (Course cou : this.courses) {
            System.out.println(cou.getIdCourse() + " " + cou.getLaberCourse() + " " + cou.getPrice() + "$");
        }
    }

    /**
     * It will be the number of the course 101, 102, and a random number
     * 101XX --> Prototype
     * 10100 First one
     * 10199 The last one
     *
     * @return
     */
    public String createIdStudent(String id) {
        Random rnd = new Random();
        String idUser = "";
        idUser = String.valueOf(rnd.nextInt(99 - 00) + 00);
        /* We concat 101 + the random value between 0 and 20 */
        idUser = id + idUser;
        return idUser;
    }

    /**
     * We get the ID from label of the course
     *
     * @param idCourse
     * @return
     */
    public String getIdCourseLevel(int idCourse) {
        String idCourseLevel;
        String num;
        /* We have the label and next we take the digit EX: 101 */
        idCourseLevel = courses.get(idCourse).getLaberCourse();
        num = getNumbers(idCourseLevel);
        return num;
    }

    /**
     * We get the number of the label of the course
     *
     * @param aux
     * @return
     */
    public static String getNumbers(String aux) {
        char[] aux_1 = aux.toCharArray();
        String numbers = "";
        for (int i = 0; i < aux_1.length; i++) {
            if (Character.isDigit(aux_1[i])) {
                numbers += aux_1[i];
            }
        }
        return numbers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
