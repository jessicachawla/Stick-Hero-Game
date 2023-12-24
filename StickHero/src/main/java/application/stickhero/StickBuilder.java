package application.stickhero;

public class StickBuilder {
    public double x;
    public double y;

    public StickBuilder setX(double x) {
        this.x = x;
        return this;
    }

    public StickBuilder setY(double y) {
        this.y = y;
        return this;
    }

    public Stick build() {
        return new Stick(this);
    }
}
