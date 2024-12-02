public class ScoreTracker {
    private int score;

    public ScoreTracker() {
        this.score = 0;
    }

    public void incrementScore(int points) {
        this.score += points;
        System.out.println("Score increased by " + points + ". Total Score: " + this.score);
    }

    public int getScore() {
        return score;
    }
}
