import java.util.ArrayList;

/**
 * This represents the actual slide that will make up the slideshow.
 *
 * A slide does not need an orientation, as they are treated the same
 * Slides only consist of an ArrayList of tags
 *
 */
public class Slide {
    private ArrayList<String> slideTags = new ArrayList<>();

    /**
     * Creates a slide from generic tag list
     * Used for horizontal photo slides
     *
     * @param tags ArrayList of the tags for the slide, from the photo
     * */
    public Slide(ArrayList<String> tags) {
        slideTags = tags;
    }

    /**
     * Creates a slide from two vertical photos
     * It merges the two tag lists, without duplication
     * This assumes that the two given photos are vertical
     *
     * @param p1 First Vertical Photo
     * @param p2 Second Vertical Photo
     * */
    public Slide(Photo p1, Photo p2) {
        ArrayList<String> p1Tags = p1.getTags();
        ArrayList<String> p2Tags = p2.getTags();

        for (String tag : p1Tags){
            if (!slideTags.contains(tag)) {
                slideTags.add(tag);
            }
        }

        for (String tag : p2Tags){
            if (!slideTags.contains(tag)) {
                slideTags.add(tag);
            }
        }
    }

    /**
     * Gets all the tags from the slide
     * Assumes that the slide has tags attached to it
     *
     * @return ArrayList of tags as String object
     * */
    public ArrayList<String> getSlideTags() {
        return slideTags;
    }

    /**
     * Output the slides tags
     * Assumes that the slide has tags attached to it
     *  */
    public void outputDetails() {
        System.out.println("Slide with Tags: " + getSlideTags().toString());
    }
}
