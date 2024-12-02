import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameLogic {
    private Pet pet;
    private Timeline timeline;

    public GameLogic(Pet pet) {
        this.pet = pet;
        startGameLoop();
    }

    private void startGameLoop() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> {
            pet.updateStatsOverTime();
            checkForWarnings();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void checkForWarnings() {
        if (pet.getHunger() > 80) {
            System.out.println("Warning: Your pet is very hungry!");
        }
        if (pet.getEnergy() < 20) {
            System.out.println("Warning: Your pet needs rest!");
        }
    }
}
