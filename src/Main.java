import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        String[] files = new String[] {"b_lovely_landscapes.txt", "c_memorable_moments.txt", "d_pet_pictures.txt", "e_shiny_selfies.txt"};

        Controller c1 = new Controller("b_lovely_landscapes.txt", 100);
        Controller c2 = new Controller("c_memorable_moments.txt", 100);
        Controller c3 = new Controller("d_pet_pictures.txt", 100);
        Controller c4 = new Controller("e_shiny_selfies.txt", 100);

        Instant start = Instant.now();

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        while (c1.isAlive() || c2.isAlive() || c3.isAlive() || c4.isAlive()) {
            continue;
        }

        int finalScore = c1.getFinalScore() + c2.getFinalScore() + c3.getFinalScore() + c4.getFinalScore();
        System.out.println("Final Score is: " + finalScore);

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toSeconds() +" seconds");
    }
}