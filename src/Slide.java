import java.lang.reflect.Array;
import java.util.ArrayList;

public class Slide {
    ArrayList<String> slideTags = new ArrayList<>();

    // Constructor to create the slide object from the tags provided
    public Slide(ArrayList<String> tags) {
        slideTags = tags;
    }

    // Constructor to create a slide from two vertical slides
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

    public void outputDetails() {
        System.out.println("Slide with Tags: " + slideTags.toString());
    }


}
