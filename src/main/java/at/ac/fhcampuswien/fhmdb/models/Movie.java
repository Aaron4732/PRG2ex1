package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Movie {

    private String id;

    private String title;
    private List<Genres> genres;

    private int releaseYear;
    private String description;

    private String imgURL;

    private int lengthInMinutes;

    private List<String> directors;

    private String[] writers;

    private String[] mainCAst;

    private double rating;




//  private static ObservableList<String> genreList = FXCollections.observableArrayList("All","Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Drama", "Documentary", "Family", "Fantasy", "History", "Horror", "Musical", "Mystery", "Romance", "Science Fiction", "Sport", "Thriller", "War", "Western");



    List<Genres> GenreList = Arrays.asList(Genres.values());


    public Movie(String title, String description, List<Genres> genres) {
        this.title = title;
        this.description = description;
   //     this.genre = List.of(genre);
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getDirector() { return directors; }

    public int getYear() { return releaseYear; }



    public List<Genres> getGenreList() { return GenreList; }

    public boolean searchGenre(String target) {
        //return genre.contains(target);
        for (Genres aktuellGenre : genres) {
            if (Objects.equals(aktuellGenre.toString(), target)) return true;
        }
        return false;
    }

    public boolean hasStringInTitleOrDescription(String context){
        return Arrays.stream(this.getTitle().split(" ")).anyMatch(word -> word.equals(context)) ||
                Arrays.stream(this.getDescription().split(" ")).anyMatch(word -> word.equals(context));
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Titanic", "Film about ship vs iceberg.", Arrays.asList(Genres.ROMANCE, Genres.DRAMA, Genres.HISTORY)));
        movies.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", Arrays.asList(Genres.FAMILY, Genres.COMEDY, Genres.ROMANCE, Genres.ANIMATION)));
        movies.add(new Movie("Antman", "Movie about superhero who is also an ant.", Arrays.asList(Genres.ACTION, Genres.FANTASY, Genres.SCIENCE_FICTION)));
        movies.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", Arrays.asList(Genres.ADVENTURE, Genres.ACTION, Genres.FANTASY)));
        movies.add(new Movie("Sharknado", "Sharks falling from sky, people dying. ", Arrays.asList(Genres.HORROR, Genres.ACTION, Genres.DRAMA)));
        movies.add(new Movie("Shaun of the Dead", "Two friends not noticing a zombie apocalypse.", Arrays.asList(Genres.COMEDY, Genres.HORROR)));
        movies.add(new Movie("Once Upon A Time In The West", "A cowboy movie with great harmonica sounds.", Arrays.asList(Genres.WESTERN, Genres.DRAMA, Genres.HISTORY, Genres.THRILLER)));
        movies.add(new Movie("Encanto", "A story about a young girl who is the only member of her family without magical powers.", Arrays.asList(Genres.ANIMATION, Genres.FAMILY, Genres.MUSICAL)));
        movies.add(new Movie("Pulp Fiction", "Two mob hitmen and other people experience a series of violent and unexpected events in Los Angeles.", Arrays.asList(Genres.MYSTERY, Genres.CRIME, Genres.THRILLER, Genres.COMEDY)));
        movies.add(new Movie("Rush", "Two Formula One drivers trying to be faster than one another.", Arrays.asList(Genres.BIOGRAPHY, Genres.DOCUMENTARY, Genres.SPORT)));
        movies.add(new Movie("Inglourious Basterds", "A group of Jewish-American soldiers and a French Jewish girl that want to end World War II .", Arrays.asList(Genres.WAR, Genres.HISTORY, Genres.THRILLER, Genres.ADVENTURE)));

        return movies;
    }

}
