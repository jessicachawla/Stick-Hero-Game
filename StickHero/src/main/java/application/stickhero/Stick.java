package application.stickhero;

public class Stick extends Position {
    public Stick(Player player) {
        this.setX(player.getX());
        this.setY(player.getY());
    }
}
