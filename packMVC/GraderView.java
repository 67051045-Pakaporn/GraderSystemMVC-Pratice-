package packMVC;

public class GraderView {
    public void PrintOut(String name, String id, int score, String gpa) {
        System.out.println("========== " + name + "(" + id + ")'s Transcript ==========");
        System.out.println("Your total score is: " + score);
        System.out.println("Your GPA is " + gpa);
        System.out.println("========== Congratulations! ==========");
    }
}
