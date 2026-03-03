import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // This program is split into two main parts.
        // Part A - Making the slides from the two photosets
        // Part B - Ordering the slides based on interest score

        // --- Part A: Slide Creation ---

        // We need to create the photos from the text file provided.
        // To do this, we will use the two generator classes.
        PhotoGenerator PG = new PhotoGenerator();
        SlideGenerator SG = new SlideGenerator();

        // Process the photos from a text file.
        // This generates a usable set of photos to generate the slides from.
        ArrayList<Photo> photos = PG.processPhotos("a_example.txt");

        // Generate slides from that set of photos.
        ArrayList<Slide> slides = SG.generateSlides(photos);

        // Output generated slides
        for (Slide s : slides) {
            s.outputDetails();
        }

        System.out.println();

        // Part A completed.

        // For part B, we need to sort all the slides by tag count once again
        HashMap<Integer, ArrayList<Slide>> slidesByTagNumber = new HashMap<>();
        for (Slide s : slides) {
            int numberOfTags = s.getSlideTags().size();

            // Check if number of tags already present
            if (slidesByTagNumber.containsKey(numberOfTags)) {
                slidesByTagNumber.get(numberOfTags).add(s);
            } else {
                ArrayList<Slide> newList = new ArrayList<>();
                newList.add(s);
                slidesByTagNumber.put(numberOfTags, newList);
            }
        }

        // Output Hashmap

        // Iterate through the HashMap
        for (Map.Entry<Integer, ArrayList<Slide>> entry : slidesByTagNumber.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        ArrayList<Slide> orderedSlides = new ArrayList<>();

        // now we need to loop through each arraylist and find the best order. This will then be stored in a new hashset
        for (Integer key : slidesByTagNumber.keySet()) {
            // Extract the arraylist
            ArrayList<Slide> workingSlides = slidesByTagNumber.get(key);
            Slide current = workingSlides.removeFirst();

            if (workingSlides.isEmpty()) continue;
            
            while (!workingSlides.isEmpty()) {
                if (workingSlides.size() == 1) {
                    orderedSlides.add(current);
                    orderedSlides.add(workingSlides.removeFirst());
                    break;
                }

                Slide bestPartner = workingSlides.get(0);
                int bestInterest = current.computeInterest(bestPartner);

                for (Slide otherSlide : workingSlides) {
                    int interest = current.computeInterest(otherSlide);
                    if (interest > bestInterest){
                        bestPartner = otherSlide;
                        bestInterest = interest;
                    }
                }

                orderedSlides.add(current);
                workingSlides.remove(bestPartner);
                current = bestPartner;
            }

            if (workingSlides.isEmpty()) {
                orderedSlides.add(current);
            }
        }

        System.out.println(orderedSlides);
    }

    static void sortSlides(ArrayList<Slide> arr, int n) {
        int i, j;
        Slide temp;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr.get(j).getSlideTags().size() > arr.get(j + 1).getSlideTags().size()) {
                    // swap the two values
                    temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j+1, temp);
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }
}