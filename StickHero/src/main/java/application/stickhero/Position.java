package application.stickhero;

public class Position {
    private double x;
    private double y;

    public Position() {
        x = 0.0;
        y = 0.0;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
