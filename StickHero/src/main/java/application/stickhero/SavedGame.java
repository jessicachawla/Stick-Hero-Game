package application.stickhero;

public class SavedGame {

    private Player player;
    private int score;
    private int cherries;

    public SavedGame(GamePage gamePage) {
        this.player = gamePage.getPlayer();
        this.score = gamePage.getScore();
        this.cherries = gamePage.getCherries();
    }

    public static void loadFromFile(String filePath) {

    }
    public void saveToFile(String filePath) {

    }
}
