package packMVC;

public class Grader {
    private String StdFName;
    private String StdLName;
    private String StdId;
    private int StdScore;

    public Grader() {}

    public Grader(String id, String name, String surname, int score) {
        this.StdId = id;
        this.StdFName = name;
        this.StdLName = surname;
        this.StdScore = score;
    }

    public int getScore() {
        return this.StdScore;
    }

    public void addScore(int score) {
        if (score >= 0 && score <= 100) { this.setScore(score); }
        else { System.out.println("Invalid Score"); }
    }

    public void minusScore(int score) {
        if (score >= 0 && score <= 100) { this.setScore(score*-1); }
        else { System.out.println("Invalid Score"); }
    }

    private void setScore(int score) {
        int tmp = this.StdScore + score;
        if (tmp >= 0 && tmp <= 100) {
            this.StdScore = tmp;
        } else {
            System.out.println("Couldn't update the score");
        }
    }

    public String getName() {
        return this.StdFName + " " + this.StdLName;
    }

    public String getFname() {
        return this.StdFName;
    }

    public String getLname() {
        return this.StdLName;
    }

    public void setName(String nm, String snm) {
        this.StdFName = nm;
        this.StdLName = snm;
    }

    public String getId() {
        return this.StdId;
    }

    public void setId(String id) {
        this.StdId = id;
    }

    public String gpaCalculator() {
        if (this.StdScore >= 65) {
            if (this.StdScore < 70) { return "C+"; }
            else if (this.StdScore < 75) { return "B"; }
            else if (this.StdScore < 80) { return "B+"; }
            else if (this.StdScore < 101) { return "A"; }
        } else {
            if (this.StdScore > 59) { return "C"; }
            else if (this.StdScore > 54) { return "D+"; }
            else if (this.StdScore > 49) { return "D"; }
            else { return "F"; }
        }

        return "";
    }

}