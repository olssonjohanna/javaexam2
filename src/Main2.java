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

        Admin ad = new Admin("fo@", "fo","fadi");
        Admin bb = new Admin("jojo@", "jojo","johanna");
        AllAdmins admins = new AllAdmins();
        admins.addAdmin(ad);
        admins.addAdmin(bb);
        ManageAdmin.saveAdmins(admins);

        Course cc = new Course("matte", 3);
        Course c1 = new Course("samhäll", 1);
        Course c2 = new Course("data", 2);
        AllCourses courses = new AllCourses();
        courses.addCourse(cc);
        courses.addCourse(c1);
        courses.addCourse(c2);
        ManageCourse.saveCourses(courses);

    }
}
