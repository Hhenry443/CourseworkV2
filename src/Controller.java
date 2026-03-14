import java.util.ArrayList;

public class Controller extends Thread{
    String file;
    Integer finalScore;
    int threshold;

    public Controller(String file, int threshold) {

        this.file = file;
        this.threshold = threshold;
    }

    public Controller(String file, int threshold, int cap) {

        this.file = file;
        this.threshold = threshold;
    }

    @Override
    public void run() {
        System.out.println("Thread Started for file: " + this.file);
        this.generateSlideshow();
    }

    public void generateSlideshow() {
        PartA PA = new PartA(this.file);
        PartB PB = new PartB();

        ArrayList<Slide> slides = PA.generateSlides();

        this.finalScore = PB.orderByTagGroups(slides, this.threshold);

        System.out.println("Score for " + file + ": " + finalScore);
    }

    public Integer getFinalScore() {
        return finalScore;
    }
}
