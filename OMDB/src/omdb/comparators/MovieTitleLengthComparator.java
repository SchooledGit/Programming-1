package omdb.comparators;

import java.util.Comparator;
import omdb.Movie;

/**
 *
 * @author evt18zfu
 */
public class MovieTitleLengthComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o1.getTitle().length(), o2.getTitle().length());
    }
}
