package packMVC;

import java.util.ArrayList;

public class GraderController {
    private Grader grdModel;
    private GraderView grdView;
    private DBmanager db;

    public GraderController() {}

    public GraderController(Grader m, GraderView v) {
        this.grdModel = m;
        this.grdView = v;
        this.db = new DBmanager();
    }

    public void addScoreController(int score) {
        this.grdModel.addScore(score);
    }

    public void minusScoreController(int score) {
        this.grdModel.minusScore(score);
    }

    public int getScoreController() {
        return this.grdModel.getScore();
    }

    public void setNameController(String fname, String lname) {
        this.grdModel.setName(fname, lname);
    }

    public String getFnameController() {
        return this.grdModel.getFname();
    }

    public String getNameController() {
        return this.grdModel.getName();
    }

    public void setIdController(String id) {
        this.grdModel.setId(id);
    }

    public String getIdController() {
        return this.grdModel.getId();
    }

    public String getGPA() {
        return this.grdModel.gpaCalculator();
    }

    public void ViewDisplayer() {
        this.grdView.PrintOut(getNameController(), getIdController(), getScoreController(), getGPA());
    }

    public void saveToCSV() {
        db.save(this.grdModel);
    }

    public void updateToCSV() {
        db.update(this.grdModel);
    }

    public void deleteToCSV() {
        db.delete(this.grdModel);
    }

    public void dropCSV() {
        db.drop(this.grdModel);
    }

    public void showDatainFile() {
        ArrayList<Grader> data = db.load();
        System.out.println("===== Content in File =====");
        for (Grader g : data) {
            System.out.println(g.getId() + " : " + g.getName() + " [Score: " + g.getScore() + "]");
        }
    }
}