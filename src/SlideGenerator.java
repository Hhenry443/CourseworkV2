import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SlideGenerator {
    public ArrayList<Slide> generateSlides(ArrayList<Photo> photos) {
        ArrayList<Slide> slides = new ArrayList<>();
        ArrayList<Photo> verticalPhotos = new ArrayList<>();

        // now that we have a list of the photos, we can generate all the horizontal slides
        // we can put any vertical photos into a separate array
        for (Photo p : photos) {
            if (p.getOrientation().equals("H")) {
                Slide newSlide = new Slide(p.getTags());
                slides.add(newSlide);
            } else {
                verticalPhotos.add(p);
            }
        }

        // use built in sort
        verticalPhotos.sort((a, b) -> a.getTagNumber() - b.getTagNumber());

        // now construct the vertical slides, based on the number of tags
        // so photos with few tags are paired with ones with lots of tags.
        for (int i = 0; i < verticalPhotos.size() / 2; i++) {
            Slide newSlide = new Slide(
                    verticalPhotos.get(i),
                    verticalPhotos.get(verticalPhotos.size() - 1 - i)
            );

            slides.add(newSlide);
        }

            return slides;
    }
}
