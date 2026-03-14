import java.util.ArrayList;

public class PartA {

    String file;

    public PartA(String file) {
        this.file = file;
    }

    public ArrayList<Slide> generateSlides() {
        // --- Part A: Slide Creation ---

        // We need to create the photos from the text file provided.
        // To do this, we will use the two generator classes.
        PhotoGenerator PG = new PhotoGenerator();
        SlideGenerator SG = new SlideGenerator();

        // Process the photos from a text file.
        // This generates a usable set of photos to generate the slides from.
        ArrayList<Photo> photos = PG.processPhotos(this.file);

        // Generate slides from that set of photos.

        return SG.generateSlides(photos);
    }
}
