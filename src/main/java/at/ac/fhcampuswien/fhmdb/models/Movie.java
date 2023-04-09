package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genres> genre;
//  private static ObservableList<String> genreList = FXCollections.observableArrayList("All","Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Drama", "Documentary", "Family", "Fantasy", "History", "Horror", "Musical", "Mystery", "Romance", "Science Fiction", "Sport", "Thriller", "War", "Western");

    public enum Genres {
        ALL("All"),
        ACTION("Action"),
        ADVENTURE("Adventure"),
        ANIMATION("Animation"),
        BIOGRAPHY("Biography"),
        COMEDY("Comedy"),
        CRIME("Crime"),
        DRAMA("Drama"),
        DOCUMENTARY("Documentary"),
        FAMILY("Family"),
        FANTASY("Fantasy"),
        HISTORY("History"),
        HORROR("Horror"),
        MUSICAL("Musical"),
        MYSTERY("Mystery"),
        ROMANCE("Romance"),
        SCIENCE_FICTION("Science Fiction"),
        SPORT("Sport"),
        THRILLER("Thriller"),
        WAR("War"),
        WESTERN("Western");

        private final String genre;

        Genres(String genre){
            this.genre = genre;
        }


        public String toString(){
            return genre;
        }
    }

    List<Genres> GenreList = Arrays.asList(Genres.values());


    public Movie(String title, String description, List<Genres> genres) {
        this.title = title;
        this.description = description;
   //     this.genre = List.of(genre);
        this.genre = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //public List<String> getGenre(){
    //    return genre;
    //}

    public List<Genres> getGenreList() { return GenreList; }

    public boolean searchGenra(String target) {
        return genre.contains(target);
    }
    //public static ObservableList<String> getGenre() {return Genres;}

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
