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
    /* List of courses that the students can be */
    private List<Course> coursesStudent;
    private static final String MENU = "-------------------------\n"
            + "- DataBase for Students -\n"
            + "-------------------------\n"
            + "Are you a teacher or a student?(1-Teacher/2-Student)";
    private static final String MENU_STUDENT = "-------------------------\n"
            + "-------- Student --------\n"
            + "-------------------------\n"
            + "Which is your Id of student?";
    private static final String MENU_TEACHER = "-------------------------\n"
            + "-------- Teacher --------\n"
            + "-------------------------\n"
            + "How many students do you need?";

    /**
     * This is the constructor for the class
     */
    Menu() {
        /* We fill the List of courses */
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        addCourses();
    }

    /**
     * This is the constructor
     *
     * @param students
     * @param courses
     */
    public Menu(List<Student> students, List<Course> courses, List<Course> coursesStudent) {
        this.students = students;
        this.courses = courses;
        this.coursesStudent = coursesStudent;
    }

    /**
     * This is the menu that the user of the app will see
     */
    void mainMenu() {
        String opt;
        System.out.println(MENU);
        opt = scanner.next();

        switch (opt) {
            case "1":
                teacherMenu();
                mainMenu();
                break;
            case "2":
                studentMenu();
                break;
            default:
                System.out.println("Select a correct option!!!");
                mainMenu();
        }
    }

    /**
     * Is the menu for the students
     */
    void studentMenu() {
        int identificationStudent;

        if (students.size() != 0) {
            /* Previously we show the students and their ID to know which student see */
            for (Student s : students) {
                System.out.println(" - ID: " + s.getId() + " - " + s.getName() + " -");
            }

            System.out.println(MENU_STUDENT);
            identificationStudent = scanner.nextInt();

            for (Student std : this.students) {
                if (identificationStudent == std.getId()) {
                    System.out.println("------------- ID " + std.getId() + " -------------\n" +
                            "- Name:     " + std.getName() + "\n" +
                            "- Year:     " + std.getYear() + "\n" +
                            "- Balance:  " + std.getBalance() + "$");
                    for (Course c : std.getCourse()) {
                        System.out.println("- Course/s: " + c.getLaberCourse());
                    }
                    System.out.println("----------------------------------");
                } else {
                    System.out.println("The student don't exist!!!");
                }
            }
        } else {
            System.out.println("You don'y have any student, add one lazy!!");
        }
        mainMenu();
    }

    /**
     * Is the menu for the teacher
     */
    boolean teacherMenu() {
        /* We have the number of times we have to ask for the new student */
        int cont = 0;
        int numberStudents;
        System.out.println(MENU_TEACHER);
        numberStudents = scanner.nextInt();

        do {
            if (numberStudents == 0) {
                System.out.println("You need to have at least one student!!!");
                return false;
            } else {
                while (cont < numberStudents) {
                    Student std = new Student();
                    Course c = new Course();
                    String answer;

                    /* We introduce the name of the std */
                    System.out.print("Introduce the name of the student: ");
                    String name = scanner.next();

                    while (name.isEmpty()) {
                        if (name.isEmpty()) {
                            System.out.println("The name can't be empty!!!");
                        }
                    }
                    std.setName(name);

                    /* We introduce the name of the std */
                    System.out.print("Introduce the year of the student: ");
                    String year = scanner.next();

                    while (year.isEmpty() || year.length() > 4) {
                        if (year.isEmpty()) {
                            System.out.println("The year can't be empty!!!");
                            System.out.print("Introduce the year of the student: ");
                            year = scanner.next();
                        } else if (year.length() > 4) {
                            System.out.println("The year can't have more than 4 characters!!!");
                            System.out.print("Introduce the year of the student: ");
                            year = scanner.next();
                        }
                    }
                    std.setYear(year);

                    /* Show the courses available */
                    showCourses();

                    /* We introduce the course of the student */
                    System.out.print("Introduce the ID of course: ");
                    String idCourse = scanner.next();

                    while (idCourse.isEmpty() || Integer.parseInt(idCourse) > 4) {
                        if (idCourse.isEmpty()) {
                            System.out.println("The student have to be in a course!!!");
                        } else if (Integer.parseInt(idCourse) > 4) {
                            System.out.println("The course don't exist!!!");
                            System.out.print("Introduce the ID of course: ");
                            idCourse = scanner.next();
                        }
                    }

                    /* We create a new instance of courses for the students */
                    coursesStudent = new ArrayList<Course>();

                    for (Course cou : this.courses) {
                        if (Integer.parseInt(idCourse) == cou.getIdCourse()) {
                            c = new Course(cou.getIdCourse(), cou.getLaberCourse(), cou.getPrice());
                        }
                    }

                    /* We add the course for the student */
                    coursesStudent.add(c);


                    /* We ask if the teacher want to introduce another course */
                    System.out.println("Would you like to add another course?(y/n)");
                    answer = scanner.next();

                    while (answer.equals("y") || answer.equals("Y")) {
                        /* We introduce the course of the student */
                        System.out.print("Introduce the ID of course: ");
                        idCourse = scanner.next();

                        while (idCourse.isEmpty()) {
                            if (idCourse.isEmpty()) {
                                System.out.println("The student have to be in a course!!!");
                            }
                        }

                        for (Course cou : this.courses) {
                            if (Integer.parseInt(idCourse) == cou.getIdCourse()) {
                                c = new Course(cou.getIdCourse(), cou.getLaberCourse(), cou.getPrice());
                            }
                        }

                        /* We add the course for the student */
                        coursesStudent.add(c);

                        /* We ask if the teacher want to introduce another course */
                        System.out.println("Would you like to add another course?(y/n)");
                        answer = scanner.next();
                    }

                    /* We add all the courses to the student */
                    std.setCourse(coursesStudent);

                    /* We get the id the of the course and we can get of the label the level of the course
                     * xxxx 101 --> we get the 101 from the label that is the digit that we need for the
                     * id of the std
                     */
                    String aux = getIdCourseLevel(Integer.parseInt(idCourse));

                    /* We introduce the id of the std */
                    String val = createIdStudent(aux);
                    std.setId(Integer.parseInt(val));

                    /* We did the same time that number of students the teacher want to introduce */
                    cont = cont + 1;

                    /* We add the std to the List */
                    students.add(std);
                }
            }
            return true;
            /* We return to the main menu if the teacher introduce all their students */
            /*mainMenu();*/
        } while (true);
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
        System.out.println("------- LIST OF COURSES -------");
        for (Course cou : this.courses) {
            System.out.println(cou.getIdCourse() + " " + cou.getLaberCourse() + " " + cou.getPrice() + "$");
        }
        System.out.println("-------------------------------");
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
        String idUser;
        idUser = String.valueOf(rnd.nextInt(99 - 10) + 10);
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
    String getIdCourseLevel(int idCourse) {
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
    static String getNumbers(String aux) {
        char[] aux_1 = aux.toCharArray();
        String numbers = "";
        for (char anAux_1 : aux_1)
            if (Character.isDigit(anAux_1)) {
                numbers += anAux_1;
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
