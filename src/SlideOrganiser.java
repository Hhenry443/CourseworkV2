import java.util.ArrayList;
import java.util.HashMap;

public class SlideOrganiser {
    public HashMap<Integer, ArrayList<Slide>> sortSlidesByTagNumber(ArrayList<Slide> slides) {
        HashMap<Integer, ArrayList<Slide>> slidesByTagNumber = new HashMap<>();

        for (Slide s : slides) {
            // divide the number of tags by 2, which increases the size of the buckets.
            // Leads to a low performance score increase.
            int numberOfTags = s.getSlideTags().size() / 2;

            // Check if number of tags already present
            if (slidesByTagNumber.containsKey(numberOfTags)) {
                slidesByTagNumber.get(numberOfTags).add(s);
            } else {
                ArrayList<Slide> newList = new ArrayList<>();
                newList.add(s);
                slidesByTagNumber.put(numberOfTags, newList);
            }
        }

        return  slidesByTagNumber;
    }

    public ArrayList<Slide> orderSlidesbyTagNumber(HashMap<Integer, ArrayList<Slide>> slidesByTagNumber) {
        ArrayList<Slide> orderedSlides = new ArrayList<>();

        // now we need to loop through each arraylist and find the best order. This will then be stored in a new hashset
        for (Integer key : slidesByTagNumber.keySet()) {
            // Extract the arraylist
            ArrayList<Slide> workingSlides = slidesByTagNumber.get(key);

            if (workingSlides.size() == 1) {
                orderedSlides.add(workingSlides.removeFirst());
            }

            while (workingSlides.size() > 1) {
                Slide current = workingSlides.get(0);
                Slide bestPair = null;
                int bestScore = -1;

                for (int i = 1; i < workingSlides.size(); i++) {
                    Slide candidate = workingSlides.get(i);
                    int score = current.computeInterest(candidate);

                    if (score > bestScore) {
                        bestScore = score;
                        bestPair = candidate;
                    }
                }

                orderedSlides.add(current);
                orderedSlides.add(bestPair);

                workingSlides.remove(current);
                workingSlides.remove(bestPair);
            }

            if (workingSlides.size() == 1) {
                orderedSlides.add(workingSlides.getLast());
            }
        }

        return orderedSlides;
    }
}
