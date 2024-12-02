
    import java.io.Serializable;

public class Pet implements Serializable {
    private String name;
    private int hunger;      // 0 (full) to 100 (starving)
    private int happiness;   // 0 (sad) to 100 (happy)
    private int energy;      // 0 (exhausted) to 100 (full)

    public Pet(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 50;
    }

    public String getName() { return name; }
    public int getHunger() { return hunger; }
    public int getHappiness() { return happiness; }
    public int getEnergy() { return energy; }

    public void feed() {
        hunger = Math.max(hunger - 20, 0);
    }

    public void play() {
        happiness = Math.min(happiness + 20, 100);
        energy = Math.max(energy - 10, 0);
    }

    public void sleep() {
        energy = Math.min(energy + 30, 100);
        hunger = Math.min(hunger + 10, 100);
    }

    public void updateStatsOverTime() {
        hunger = Math.min(hunger + 5, 100);
        happiness = Math.max(happiness - 5, 0);
        energy = Math.max(energy - 2, 0);
    }
}