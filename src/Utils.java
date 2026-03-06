import java.util.ArrayList;

public class Utils {
    public Integer totalScore(ArrayList<Slide> orderedSlides) {
        Integer totalScore = 0;

        for (int i = 0; i < orderedSlides.size() - 1; i++) {
            totalScore += orderedSlides.get(i)
                    .computeInterest(orderedSlides.get(i + 1));
        }

        return totalScore;
    }
}
