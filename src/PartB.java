import java.util.*;

public class PartB {
    public HashMap<String, ArrayList<Slide>> createTagGroups(ArrayList<Slide> slides) {
        HashMap<String, ArrayList<Slide>> tagGroups = new HashMap<>();

        for (Slide s : slides) {
            ArrayList<String> tags = s.getSlideTags();

            for (String t : tags) {
                if (tagGroups.containsKey(t)) {
                    tagGroups.get(t).add(s);
                } else {
                    ArrayList<Slide> newSlideGroup = new ArrayList<>();
                    newSlideGroup.add(s);
                    tagGroups.put(t, newSlideGroup);
                }
            }
        }

        return tagGroups;
    }


    // slides that share at least one tag are good options for pairs.
    // maybe ordering based on these groups of shared tags is better than number of tags
    public int orderByTagGroups(ArrayList<Slide> slides, int threshold) {
        // first we need to make the tag groups
        // then we need to pick a random starting slideshow
        // then, make a big list of candidates of all slides that share at least one tag
        // find the best one from that
        // then remove the current slide from all its tag groups, then set the new current slide to the best one.
        Utils U = new Utils();

        HashMap<String, ArrayList<Slide>> tagGroups = this.createTagGroups(slides);

        System.out.println("Created tag groups");

        Slide current = slides.removeFirst();
        ArrayList<Slide> ordered = new ArrayList<>();

        ordered.add(current);

        int iteration = 0;

        int totalSlides = slides.size();

        while (!slides.isEmpty()) {
            ArrayList<Slide> candidates = new ArrayList<>();

            for (String t : current.getSlideTags()) {
                candidates.addAll(tagGroups.get(t));
            }

            Slide best = null;
            int bestScore = -1;

            if (candidates.size() > threshold) {
                candidates = new ArrayList<>(candidates.subList(0, threshold));
            }

            for (Slide i : candidates) {

                Integer score = i.computeInterest(current);

                if (score > bestScore) {
                    best = i;
                    bestScore = score;
                }
            }

            // fallback if no shared tags
            if (best == null) {
                best = slides.getFirst();
            }

            ordered.add(best);

            slides.remove(best);

            for (String tag : best.getSlideTags()) {
                tagGroups.get(tag).remove(best);
            }

            current = best;

            iteration++;

//            if (iteration % 1000 == 0) {
//                System.out.println(
//                        "Processed: " + iteration + "/" + totalSlides
//                );
//            }
        }

        return U.totalScore(ordered);
    }

}
