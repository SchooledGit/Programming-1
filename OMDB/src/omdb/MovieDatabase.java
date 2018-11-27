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
        //https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            while (line != null) {
                database.add(new Movie(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void sort() {
        Collections.sort(database);
    }

    public void sort(Comparator<Movie> c) {
        Collections.sort(database, c);
    }

    public void filter(String field, Object value) {
        switch (field) {
            //https://stackoverflow.com/questions/9146224/arraylist-filter
            case "certificate":
                database.removeIf(s -> !s.getCertificate().contains(value.toString()));
                break;
            case "genres":
                database.removeIf(s -> !s.getGenres().contains(value.toString()));
                break;
            default:
                System.out.println("Field didn't work:" + field);
                break;
        }
    }

    public void printDatabase() {
        for (Movie m : database) {
            System.out.println(m.toString());
        }
    }

    public int getSize() {
        return database.size();
    }
    
    public Movie getMovie(int index, boolean biggest) {
        return database.get(biggest ? database.size() - index : index - 1);
    }

    public ArrayList<Movie> getDatabase() {
        return database;
    }

    public void setDatabase(ArrayList<Movie> database) {
        this.database = database;
    }
}