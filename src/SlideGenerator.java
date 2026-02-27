import java.util.ArrayList;

public class SlideGenerator {
    public ArrayList<Slide> generateSlides(ArrayList<Photo> photos) {
        ArrayList<Slide> slides = new ArrayList<>();
        ArrayList<Photo> verticalPhotos = new ArrayList<>();

        // now that we have a list of the photos, we can generate all the horizontal slides
        // we can put any vertical photos into a separate array
        for (Photo p : photos) {
            if (p.getOrientation().equals("H")) {
                Slide newSlide = new Slide(p.getTags());
                slides.add(newSlide);
            } else {
                verticalPhotos.add(p);
            }
        }

        // simple bubble sort to order the horizontal photos by number of tags
        bubbleSort(verticalPhotos, verticalPhotos.size());

        // now construct the vertical slides, based on the number of tags
        // so photos with few tags are paired with ones with lots of tags.
        for (int i = 0; i < verticalPhotos.size() / 2; i++) {
            Slide newSlide = new Slide(
                    verticalPhotos.get(i),
                    verticalPhotos.get(verticalPhotos.size() - 1 - i)
            );

            slides.add(newSlide);
        }

        return slides;
    }

    static void bubbleSort(ArrayList<Photo> arr, int n) {
        int i, j;
        Photo temp;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr.get(j).getTagNumber() > arr.get(j + 1).getTagNumber()) {
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
