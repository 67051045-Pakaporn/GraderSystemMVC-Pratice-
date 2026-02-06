package packMVC;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DBmanager {
    private String fn = "students.csv";

    public void save(Grader g) {
        ArrayList<Grader> db = load();

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getId().equals(g.getId())) { return;}
        }

        db.add(g);
        saveAll(db);
    }

    public void update(Grader g) {
        ArrayList<Grader> db = load();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getId().equals(g.getId())) {
                db.set(i, g);
                flag = true;
                break;
            }
        }

        if (flag == true) { saveAll(db); }
    }

    public void delete(Grader g) {
        ArrayList<Grader> db = load();
        boolean flag = false;

        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getId().equals(g.getId())) {
                db.remove(i);
                flag = true;
                break;
            }
        }

        if (flag == true) { saveAll(db); }
    }

    public void drop(Grader g) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(fn, false))) {} 
        catch (IOException e) { e.printStackTrace(); }
    }

    public ArrayList<Grader> load() {
        ArrayList<Grader> lst = new ArrayList<>();
        File f = new File(fn);
        if (!f.exists()) { return lst; }

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                String id = data[0];
                String fname = data[1];
                String lname = data[2];
                int score = Integer.parseInt(data[3]);

                lst.add(new Grader(id, fname, lname, score));
            }
        } catch(Exception e) { e.printStackTrace(); }

        return lst;
    }

    private void saveAll(ArrayList<Grader> lst) {
        try (PrintWriter prw = new PrintWriter(new FileWriter(fn, false))) {
            for (Grader g : lst) {
                prw.println(g.getId() + "," + g.getFname() + "," + g.getLname() + "," + g.getScore());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
