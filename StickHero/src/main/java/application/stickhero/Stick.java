package application.stickhero;

public class Stick extends Position {

    private double height;
    private double width;

    public Stick(StickBuilder builder) {
        this.setX(builder.x);
        this.setY(builder.y);

    }


    public static StickBuilder builder() {
        return new StickBuilder();
    }
}
