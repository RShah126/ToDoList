package Shah.TASKS;

import Shah.DB.DBSupport;
import java.sql.SQLException;

public class Task {
    private static int lastAssignedID = 0;
    private int ID;
    private String textTitle;
    private boolean done;
    private String priority;

    public Task(String textTitle, boolean done, String priority) {
        this.textTitle = textTitle;
        this.done = done;
        this.priority = priority;
        this.ID = ++lastAssignedID;
    }

    public int getLastAssignedID() {
        return lastAssignedID;
    }

    public void setLastAssignedID(int lastAssignedID) {
        this.lastAssignedID = lastAssignedID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return String.format("{\"ID\":%d, \"textTitle\":\"%s\", \"priority\":\"%s\"}", ID, textTitle, priority);
    }



    public void newTaskSQL() throws SQLException, ClassNotFoundException {
        String q;
        q = "INSERT INTO Tasks VALUES('" + ID + "', '" + textTitle + "', '" + priority + "');";

        try {
            System.out.println("Before executeQuery");
            DBSupport.executeQuery(q);
            System.out.println("After executeQuery");
            System.out.println("Inserted/Updated Data: " + this.toString());
        } catch (SQLException e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
