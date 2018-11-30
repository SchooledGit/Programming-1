package omdb;

import java.util.Formatter;

/**
 *
 * @author evt18zfu
 */
public class Movie implements Comparable<Movie> {

    String title;
    int year;
    String certificate;
    String genres;
    int duration;
    int rating;

    public Movie() {
        title = "";
        year = 0;
        certificate = "";
        genres = "";
        duration = 0;
        rating = 0;
    }

    public Movie(String line) {
        this(); //Default values
        String[] splits = line.split(",");
        int yearIndex = 1;

        /*
        https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
            used "-?\\d+", changed to "\\d+" as time isn't negative (to my knowledge)
         */
        //Checks if the current index is all digits
        while (!splits[yearIndex].matches("\\d+")) {
            ++yearIndex;
        }
        //concat all the splits, upto and not including year, to title
        for (int i = 0; i < yearIndex; ++i) {
            title += splits[i];
        }
        //fill in remaining data
        year = Integer.parseInt(splits[yearIndex]);
        certificate = splits[yearIndex + 1];
        genres = splits[yearIndex + 2];
        duration = Integer.parseInt(splits[yearIndex + 3]);
        rating = Integer.parseInt(splits[yearIndex + 4]);
    }

    @Override
    public String toString() {
        /*
        https://dzone.com/articles/java-string-format-examples
            %s -> anytype specifier
        https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
            used the StringBuilder as arg constructor
         */
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        String p = "%s,"; //to match the format of the original file

        f.format(p, title);
        f.format(p, year);
        f.format(p, certificate);
        f.format(p, genres);
        f.format(p, duration);
        f.format("%s", rating);

        return sb.toString();
    }

    @Override
    public int compareTo(Movie o) {
        //https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html
        return Integer.compare(year, o.getYear());
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenres() {
        return genres;
    }

    public String getCertificate() {
        return certificate;
    }

    public int getDuration() {
        return duration;
    }
}
