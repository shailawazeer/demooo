import java.io.*;
import java.time.LocalDateTime;

public class SaveLoadManager {
    private static final String FILE_PATH = "pet_save.dat";

    public static void saveGame(Pet pet) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(pet);
            out.writeObject(LocalDateTime.now());  // Save the last saved time
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Pet loadGame() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Pet pet = (Pet) in.readObject();
            LocalDateTime lastSaved = (LocalDateTime) in.readObject();
            System.out.println("Game loaded successfully! Last saved at: " + lastSaved);
            TimeManager.adjustStats(pet, lastSaved);
            return pet;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
