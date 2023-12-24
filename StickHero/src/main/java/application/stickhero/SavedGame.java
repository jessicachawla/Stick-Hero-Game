package application.stickhero;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class SavedGame implements java.io.Serializable {

    private int score;

    public double getCurrentPlatformWidth() {
        return currentPlatformWidth;
    }

    public double getNextPlatformWidth() {
        return nextPlatformWidth;
    }

    private int cherries;

    private Position playerPosition;
    private Position currentPlatformPosition;
    private Position nextPlatformPosition;

    private double currentPlatformWidth;

    private double nextPlatformWidth;

    public SavedGame(int score, int cherries, Position playerPosition, Position currentPlatformPosition,
        Position nextPlatformPosition, double currentPlatformWidth, double nextPlatformWidth) {
        this.score = score;
        this.cherries = cherries;
        this.playerPosition = playerPosition;
        this.currentPlatformPosition = currentPlatformPosition;
        this.nextPlatformPosition = nextPlatformPosition;
        this.currentPlatformWidth = currentPlatformWidth;
        this.nextPlatformWidth = nextPlatformWidth;
    }

    public static SavedGame loadFromFile(String filename) {
        SavedGame object1 = null;
        try

        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (SavedGame)in.readObject();

            in.close();
            file.close();

        }

        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("IOException is caught");
        }
        return object1;
    }
    public void saveToFile(String filePath) {

    }


    public int getScore() {
        return score;
    }

    public int getCherries() {
        return cherries;
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public Position getCurrentPlatformPosition() {
        return currentPlatformPosition;
    }

    public Position getNextPlatformPosition() {
        return nextPlatformPosition;
    }
}
