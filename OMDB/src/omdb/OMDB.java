package omdb;

import omdb.comparators.*;

/**
 *
 * @author evt18zfu
 */
public class OMDB {

    public static void main(String[] args) {
        String filepath = System.getProperty("user.dir") + "\\films.txt";
        //Init database
        MovieDatabase database = new MovieDatabase();
        database.readFile(filepath);

        //The entire collection of films in chronological order
        database.sort();
        database.printDatabase();
        System.out.println();

        //Third longest film noir
        database.filter("genres", "Film-Noir");
        database.sort(new MovieDurationComparator());
        System.out.println(database.getMovie(3, true).toString());

        //Eighth most recent "UNRATED"
        database.readFile(filepath);
        database.sort();
        database.filter("certificate", "UNRATED");
        System.out.println(database.getMovie(8, true).toString());
        
        //Film with the longest name
        database.readFile(filepath);
        database.sort(new MovieTitleLengthComparator());
        System.out.println(database.getMovie(1, true).toString());
    }
}
