import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // We need to create the photos from the text file provided.
        // To do this, we will use the two generator classes.
        PhotoGenerator PG = new PhotoGenerator();
        SlideGenerator SG = new SlideGenerator();

        // Process the photos from a text file.
        // This generates a usable set of photos to generate the slides from.
        ArrayList<Photo> photos = PG.processPhotos("a_example.txt");
        // ArrayList<Photo> photos = PG.processPhotos("c_memorable_moments.txt");

        // Generate slides from that set of photos.
        ArrayList<Slide> slides = SG.generateSlides(photos);

        // output slides
        for (Slide s : slides) {
            s.outputDetails();
        }

    }


}