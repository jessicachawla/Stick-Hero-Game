package application.stickhero;

public class Platform extends Position {
    private double width;
    private double length;

    public Platform() {
        createPlatform();
    }

    // getters
    public double getWidth() {
        return this.width;
    }
    public double getLength() {
        return this.length;
    }

    public void createPlatform() {
        // creates a platform with desired width, length, and position
    }
}
