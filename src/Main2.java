import Model.*;

public class Main2 {

    public static void main(String[] args) {
        Student ss = new Student("jo@", "jo", "jo");
        Student ss2 = new Student("fa@", "jo", "jo");
        AllStudents students = new AllStudents();
        students.addStudent(ss);
        students.addStudent(ss2);
        ManageStudent.saveStudents(students);

        Teacher tt = new Teacher("tea@", "tea", "tea");
        Teacher tt2 = new Teacher("ola@", "ola", "ola");
        AllTeachers teachers = new AllTeachers();
        teachers.addTeacher(tt);
        teachers.addTeacher(tt2);
        ManageTeacher.saveTeachers(teachers);
    }
}
