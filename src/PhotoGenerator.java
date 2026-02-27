import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhotoGenerator {
    public ArrayList<Photo> processPhotos(String filepath) {
        File photoSet = new File(filepath);
        ArrayList<Photo> photos = new ArrayList<>();

        try (Scanner fileReader = new Scanner(photoSet)) {
            while (fileReader.hasNextLine()) {
                // check if it is the number of photos
                String lineData = fileReader.nextLine();
                String[] data = lineData.split(" ");

                if (data.length != 1) {
                    // Extract tags
                    ArrayList<String> tagList = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(data, 2, data.length)));

                    // make new photo with the metadata
                    Photo newPhoto = new Photo(data[0], data[1], tagList);

                    photos.add(newPhoto);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return photos;
    }
}
