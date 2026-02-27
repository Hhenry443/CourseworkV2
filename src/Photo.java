import java.util.ArrayList;

/**
 * This class represents a single photo from the file input.
 * It contains an orientation, tagNumber and Arraylist of tags
 * This metadata is needed to organise photos into respective slides.
 */
public class Photo {
    private final String orientation;
    private final int tagNumber;
    private final ArrayList<String> tags;

    /**
     * Create a photo
     *
     * @param o The orientation of the photo
     * @param tn The number of tags associated with the photo
     * @param t The list of tags associated with the photo
     */
    public Photo(String o, String tn, ArrayList<String> t) {
        orientation = o;
        tagNumber = Integer.parseInt(tn);
        tags = t;
    }

    /**
     * @return the photos orientation
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * @return the number of tags on the photo
     */
    public int getTagNumber() {
        return tagNumber;
    }

    /**
     * @return the photo's tags
     */
    public ArrayList<String> getTags() {
        return tags;
    }
}
