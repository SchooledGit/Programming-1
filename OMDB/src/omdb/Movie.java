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

    public Movie(String t, int y, String c, String g, int d, int r) {
        title = t;
        year = y;
        certificate = c;
        genres = g;
        duration = d;
        rating = r;
    }

    public Movie(String line) {
        this(); //allocate memory
        String[] splits = line.split(",");

        //get index of year
        int index = 1;
        //https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
        while (!splits[index].matches("\\d+") && index < splits.length - 1) {
            ++index;
        }
        for (int i = 0; i < index; ++i) {
            title += splits[i]; //make title
        }
        //remaining data
        year = Integer.parseInt(splits[index]);
        certificate = splits[index + 1];
        genres = splits[index + 2];
        duration = Integer.parseInt(splits[index + 3]);
        rating = Integer.parseInt(splits[index + 4]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        String p = "%s,"; //pattern
        f.format(p, title);
        f.format(p, year);
        f.format(p, certificate);
        f.format(p, genres);
        f.format(p, getDuration());
        sb.append(rating);

        return sb.toString();
    }

    @Override
    public int compareTo(Movie o) {
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
