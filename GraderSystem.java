import packMVC.*;

public class GraderSystem {
    public static void main(String[] args) {
        Grader student1 = new Grader("123", "Kim", "Minjeong", 0);
        GraderView view = new GraderView();
        GraderController ctrl = new GraderController(student1, view);

        ctrl.ViewDisplayer();
        ctrl.saveToCSV();

        System.out.println("\nUpdating Score test");
        ctrl.addScoreController(20);
        ctrl.minusScoreController(-10);
        ctrl.addScoreController(50);
        ctrl.addScoreController(3000);
        ctrl.updateToCSV();

        System.out.println("");

        ctrl.ViewDisplayer();

        Grader student2 = new Grader("182","Aeri", "Uchinaga", 80);
        GraderController ctrl2 = new GraderController(student2, view);
        ctrl2.saveToCSV();

        ctrl2.minusScoreController(30);
        ctrl2.addScoreController(55);
        ctrl2.updateToCSV();
        ctrl2.ViewDisplayer();

        System.out.println();

        ctrl2.addScoreController(40);
        ctrl2.updateToCSV();
        ctrl2.ViewDisplayer();

        System.out.println("\nDisplay Content in file....");

        ctrl.showDatainFile();
    }
}
