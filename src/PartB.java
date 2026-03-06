import java.util.ArrayList;
import java.util.HashMap;

public class PartB {
    public Integer orderByNumberOfTags(ArrayList<Slide> slides) {
        SlideOrganiser SO = new SlideOrganiser();
        Utils U = new Utils();

        // For part B, we need to sort all the slides by tag count once again
        HashMap<Integer, ArrayList<Slide>> slidesByTagNumber = SO.sortSlidesByTagNumber(slides);

        ArrayList<Slide> orderedSlides = SO.orderSlides(slidesByTagNumber);

        return U.totalScore(orderedSlides);
    }
}
