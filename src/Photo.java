import java.util.ArrayList;

public class Photo {
    String orientation;
    int tagNumber;
    ArrayList<String> tags;

    public Photo(String o, String tn, ArrayList<String> t) {
        orientation = o;
        tagNumber = Integer.parseInt(tn);
        tags = t;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getTagNumber() {
        return tagNumber;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
