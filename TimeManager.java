import java.time.Duration;
import java.time.LocalDateTime;

public class TimeManager {
    public static void adjustStats(Pet pet, LocalDateTime lastSaved) {
        LocalDateTime now = LocalDateTime.now();
        long hoursElapsed = Duration.between(lastSaved, now).toHours();

        pet.setHunger(Math.min(pet.getHunger() + (int) (hoursElapsed * 5), 100));
        pet.setHappiness(Math.max(pet.getHappiness() - (int) (hoursElapsed * 2), 0));
        pet.setEnergy(Math.max(pet.getEnergy() - (int) (hoursElapsed * 3), 0));
    }
}

