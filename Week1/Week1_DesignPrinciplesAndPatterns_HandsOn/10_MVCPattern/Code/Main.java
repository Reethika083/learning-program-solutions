public class Main {
    public static void main(String[] args) {
        Student model = new Student("Luna Lovegood", "A042", "A+");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        // Let's update the grade
        controller.setStudentGrade("A++");
        controller.updateView();
    }
}
