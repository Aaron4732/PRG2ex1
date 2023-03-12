package at.ac.fhcampuswien.fhmdb.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List <String> genre;
    private ObservableList<String> genreList = FXCollections.observableArrayList("Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Drama", "Documentary", "Family", "Fantasy", "History", "Horror", "Musical", "Mystery", "Romance", "Science Fiction", "Sport", "Thriller", "War", "Western");


    // TODO add more properties here

    public Movie(String title, String description, String ...genre) {
        this.title = title;
        this.description = description;
        this.genre = List.of(genre);
    }


    /* public void addGenre(String genre) {
        genreList.add(genre);
    }
    */


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List <String> getGenre(){
        return genre;
    }

    public boolean searchGenra(String target) {
        return genre.contains(target);
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here

        movies.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama", "History"));
        movies.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance", "Animation"));
        movies.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action", "Fantasy", "Science Fiction"));
        movies.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action", "Fantasy"));
        movies.add(new Movie("Sharknado", "Sharks falling from sky, people dying. ", "Horror", "Action", "Drama"));
        movies.add(new Movie("Shaun of the Dead", "Two friends not noticing a zombie apocalypse.", "Comedy", "Horror"));
        movies.add(new Movie("Once Upon A Time In The West", "A cowboy movie with great harmonica sounds.", "Western", "Drama", "History", "Thriller"));
        movies.add(new Movie("Encanto", "A story about a young girl who is the only member of her family without magical powers.", "Animation", "Family", "Musical"));
        movies.add(new Movie("Pulp Fiction", "Two mob hitmen and other people experience a series of violent and unexpected events in Los Angeles.", "Mystery", "Crime", "Thriller", "Comedy"));
        movies.add(new Movie("Rush", "Two Formula One drivers trying to be faster than one another.", "Biography", "Documentary", "Sport"));
        movies.add(new Movie("Inglourious Basterds", "A group of Jewish-American soldiers and a French Jewish girl that want to end World War II .", "War", "History", "Thriller", "Adventure"));

        return movies;
    }
}
