import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // This version of the program works by splitting up the slides into groups based on the number of tags.
        // The reasoning behind this is that it will negate any interest caps from differing slide numbers
        // for example, if a slide has 4 tags, and another has 3, there will always be a difference of 1
        // This would then cap the interest score at 1, which leads to lots of checks that aren't as valuable

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
        ArrayList<Photo> photos = PG.processPhotos("c_memorable_moments.txt");

        // Generate slides from that set of photos.
        ArrayList<Slide> slides = SG.generateSlides(photos);

        // Output generated slides
        for (Slide s : slides) {
            s.outputDetails();
        }

        System.out.println();

        // Part A completed.

        // Initialise SlideOrganiser & Utils object

        PartB PB = new PartB();

        Integer totalScore = PB.orderByNumberOfTags(slides);

        System.out.println("Total score for slides: " + totalScore);
    }
}