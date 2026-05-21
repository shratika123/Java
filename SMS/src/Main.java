public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // ADD STUDENT
        Student s1 = new Student(
            0,
            "Rahul",
            "rahul@gmail.com",
            "Java",
            21
        );

        dao.addStudent(s1);

        // VIEW STUDENTS
        dao.viewStudents();

        // UPDATE STUDENT WITH ID = 2
        Student s2 = new Student(
            2,
            "Rahul Sharma",
            "rahulsharma@gmail.com",
            "Advanced Java",
            23
        );

        dao.updateStudent(s2);

        // VIEW AGAIN
        dao.viewStudents();

        // DELETE STUDENT WITH ID = 3
        dao.deleteStudent(3);

        // FINAL VIEW
        dao.viewStudents();
    }
}