package application.stickhero;

import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Platform extends Position {
    private double width;
    public Platform(double start) {
        createPlatform(start);
    }
    Rectangle platform;
    private static class WidthCalculator implements Runnable {
        private volatile int width;

        @Override
        public void run() {
            Random random = new Random();
            int e = random.nextInt(175);
            width = Math.max(e, 100);
        }

        public int getWidth() {
            return width;
        }
    }
    // getters
    public double getWidth() {
        return this.width;
    }

    public void createPlatform(double start) {
        // creates a platform with desired width, length, and position
        WidthCalculator widthCalculator = new WidthCalculator();
        Thread thread = new Thread(widthCalculator);
        thread.start();
        this.setY(307);
        this.setX(start);
        try{thread.join();}catch (InterruptedException e){e.printStackTrace();}
        this.setWidth(widthCalculator.getWidth());
    }
    public void setWidth(double width) {
        this.width = width;
    }
}
