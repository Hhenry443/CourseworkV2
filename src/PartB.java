import java.util.*;

public class PartB {

    // This version of the program works by splitting up the slides into groups based on the number of tags.
    // The reasoning behind this is that it will negate any interest caps from differing slide numbers
    // for example, if a slide has 4 tags, and another has 3, there will always be a difference of 1
    // This would then cap the interest score at 1, which leads to lots of checks that aren't as valuable
    public Integer orderByNumberOfTags(ArrayList<Slide> slides) {
        SlideOrganiser SO = new SlideOrganiser();
        Utils U = new Utils();

        HashMap<Integer, ArrayList<Slide>> slidesByTagNumber = SO.sortSlidesByTagNumber(slides);

        ArrayList<Slide> orderedSlides = SO.orderSlidesbyTagNumber(slidesByTagNumber);

        return U.totalScore(orderedSlides);
    }

    // slides that share at least one tag are good options for pairs.
    // maybe ordering based on these groups of shared tags is better than number of tags
    public Integer orderByTagGroups(ArrayList<Slide> slides) {
        // first we need to make the tag groups
        // then we need to pick a random starting slideshow
        // then, make a big list of candidates of all slides that share at least one tag
        // find the best one from that
        // then remove the current slide from all its tag groups, then set the new current slide to the best one.

        HashMap<String, ArrayList<Slide>> tagGroups = new HashMap<>();
        Utils U = new Utils();

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

        Slide current = slides.removeFirst();
        ArrayList<Slide> ordered = new ArrayList<>();

        ordered.add(current);

        int iteration = 0;

        int totalSlides = slides.size();

        System.out.println("Slides remaining: " + slides.size());

        while (!slides.isEmpty()) {


            ArrayList<Slide> candidates = new ArrayList<>();

            for (String t : current.getSlideTags()) {
                candidates.addAll(tagGroups.get(t));
            }

            Slide best = null;
            int bestScore = -1;



            if (candidates.size() > 10000) {
                Collections.shuffle(candidates);

                candidates = new ArrayList<>(candidates.subList(0, 5000));
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

            if (iteration % 1000 == 0) {
                System.out.println(
                        "Processed: " + iteration + "/" + totalSlides
                );
            }
        }

        return U.totalScore(ordered);
    }

}
