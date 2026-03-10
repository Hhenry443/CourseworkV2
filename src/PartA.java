import java.util.ArrayList;

public class PartA {
    public ArrayList<Slide> generateSlides(String file) {
        // --- Part A: Slide Creation ---

        // We need to create the photos from the text file provided.
        // To do this, we will use the two generator classes.
        PhotoGenerator PG = new PhotoGenerator();
        SlideGenerator SG = new SlideGenerator();

        // Process the photos from a text file.
        // This generates a usable set of photos to generate the slides from.
        ArrayList<Photo> photos = PG.processPhotos(file);

        // Generate slides from that set of photos.
        ArrayList<Slide> slides = SG.generateSlides(photos);

        return slides;
    }
}
