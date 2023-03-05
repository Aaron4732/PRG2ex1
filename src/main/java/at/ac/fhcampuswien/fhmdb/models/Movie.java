package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private String[] genre;
    //private ArrayList<String> genres = new ArrayList<String>();
    // TODO add more properties here

    public Movie(String title, String description, String ...genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
    }
    /*
    public void addGenre(String genre){
        genres.add(genre);
    }
     */

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String[] getGenre(){
        return genre;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here

        movies.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        movies.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        movies.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        movies.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        movies.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        return movies;
    }
}
