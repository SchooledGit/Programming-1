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
        
        System.out.println(); //differentiate the collection of films to the other answers

        //Third longest film noir
        database.filter("genres", "Film-Noir");
        database.sort(new MovieDurationComparator());
        database.reverseDatabase(); //sorted ascending, we want descending
        
        System.out.println(database.getMovie(2).toString());

        //Eighth most recent "UNRATED"
        database.readFile(filepath); //reload database due to filter
        
        database.filter("certificate", "UNRATED");
        database.sort();
        database.reverseDatabase(); //sorted ascending, we want descending
        
        System.out.println(database.getMovie(7).toString());

        //Film with the longest name
        database.readFile(filepath); //reload database due to filter
        
        database.sort(new MovieTitleLengthComparator());
        database.reverseDatabase(); //sorted ascending, we want descending
        
        System.out.println(database.getMovie(0).toString());
    }
}
