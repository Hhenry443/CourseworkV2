import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // This program is split into two main parts.
        // Part A - Making the slides from the two photosets
        // Part B - Ordering the slides based on interest score

        // --- Part A: Slide Creation ---

        // We need to create the photos from the text file provided.
        // To do this, we will use the two generator classes.
        PhotoGenerator PG = new PhotoGenerator();
        SlideGenerator SG = new SlideGenerator();

        // Process the photos from a text file.
        // This generates a usable set of photos to generate the slides from.
        ArrayList<Photo> photos = PG.processPhotos("a_example.txt");

        // Generate slides from that set of photos.
        ArrayList<Slide> slides = SG.generateSlides(photos);

        // Output generated slides
        for (Slide s : slides) {
            s.outputDetails();
        }

        // Part A completed.
    }
}