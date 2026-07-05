public class MVCPatternTest {
    public static void main(String[] args) {
        Student student = new Student("Alice Johnson", 101, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        System.out.println("--- Initial Student Record ---");
        controller.updateView();

        System.out.println("\n--- Updating Student Details ---");
        controller.setStudentName("Alice Smith");
        controller.setStudentGrade("A+");
        System.out.println("Name updated to: " + controller.getStudentName());
        System.out.println("Grade updated to: " + controller.getStudentGrade());

        System.out.println("\n--- Updated Student Record ---");
        controller.updateView();
    }
}
