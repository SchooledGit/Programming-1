package omdb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author evt18zfu
 */
public class MovieDatabase {

    private ArrayList<Movie> database;

    public MovieDatabase() {
        database = new ArrayList<Movie>();
    }

    public void readFile(String filepath) {
        /*
        https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
            Used the updated method, adding a catch for IOException
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            for (String line; (line = reader.readLine()) != null;) {
                database.add(new Movie(line));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void sort() {
        //https://www.javadevjournal.com/java/java-sorting-example-comparable-comparator/
        Collections.sort(database);
    }

    public void sort(Comparator<Movie> c) {
        //https://www.javadevjournal.com/java/java-sorting-example-comparable-comparator/, "Comparator with multi options"
        Collections.sort(database, c);
    }

    public void filter(String field, Object value) {
        switch (field) {
            /*
            https://stackoverflow.com/questions/9146224/arraylist-filter
                Used the removeIf method in switch case statements, depending on field type
            */
            case "certificate":
                database.removeIf(s -> !s.getCertificate().contains(value.toString()));
                break;
            case "genres":
                database.removeIf(s -> !s.getGenres().contains(value.toString()));
                break;
            default:
                System.out.println("Filter unused for field:" + field);
                break;
        }
    }
    //https://www.geeksforgeeks.org/collections-reverse-java-examples/
    public void reverseDatabase() {
        Collections.reverse(database);
    }

    public void printDatabase() {
        for (Movie m : database) {
            System.out.println(m.toString());
        }
    }

    public Movie getMovie(int index) {
        return database.get(index);
    }
}
