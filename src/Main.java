import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // This program is split into two main parts.
        // Part A - Making the slides from the two photosets
        // Part B - Ordering the slides based on interest score
        // A few attempts have been made for part B, as this is where there are the most methods to get a score.

        // Part A
        PartA PA = new PartA();

        // String file = "a_example.txt";
        // String file = "b_lovely_landscapes.txt";
        // String file = "c_memorable_moments.txt";
        // String file = "d_pet_pictures.txt";
        String file = "e_shiny_selfies.txt";

        ArrayList<Slide> slides = PA.generateSlides(file);

        // Part B
        PartB PB = new PartB();

        Integer totalScore = PB.orderByNumberOfTags(slides);
        System.out.println("Total score for slides (Using the number of tags method): " + totalScore);

        // Integer totalScore = PB.orderByTagGroups(slides);
        // System.out.println("Total score for slides (Using tag groups): " + totalScore);
    }
}

// Number of Tags based approach
// Set A - 2
// Set B - 40203
// Set C - 613
// Set D - 310468
// Set E -

// Tag Group based approach - 100 cap
// Set A - 2
// Set B - 205266
// Set C - 1460
// Set D - 379705
// Set E - 322477

// Tag Group based approach - 1000 cap
// Set A - 2
// Set B - 205476
// Set C - 1463
// Set D - 404002
// Set E - 374508

// Tag Group based approach - 5000 cap
// Set A - 2
// Set B - 205863
// Set C - 1476
// Set D - 410576
// Set E - 399412