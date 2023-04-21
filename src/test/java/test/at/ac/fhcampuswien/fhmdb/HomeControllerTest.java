package test.at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.MovieComparatorASC;
import at.ac.fhcampuswien.fhmdb.MovieComparatorDESC;
import at.ac.fhcampuswien.fhmdb.api.MovieAPI;
import at.ac.fhcampuswien.fhmdb.models.Genres;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.HomeController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeControllerTest {

    public MovieAPI movieAPI = new MovieAPI();

    public HomeControllerTest() throws IOException {
    }

    @Test
    void asc_sorter_check_1st_element_if_is_Antman() {
        // given
        ObservableList<Movie> list = FXCollections.observableArrayList();

        list.add(new Movie("Titanic", "Film about ship vs iceberg.", Arrays.asList(Genres.ROMANCE, Genres.DRAMA, Genres.HISTORY)));
        list.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", Arrays.asList(Genres.FAMILY, Genres.COMEDY, Genres.ROMANCE, Genres.ANIMATION)));
        list.add(new Movie("Antman", "Movie about superhero who is also an ant.", Arrays.asList(Genres.ACTION, Genres.FANTASY, Genres.SCIENCE_FICTION)));
        list.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", Arrays.asList(Genres.ADVENTURE, Genres.ACTION, Genres.FANTASY)));
        list.add(new Movie("Sharknado", "Sharks falling from sky, people dying. ", Arrays.asList(Genres.HORROR, Genres.ACTION, Genres.DRAMA)));

        // when
        list.sort(new MovieComparatorASC());

        // then
        String firstExpectedElement = "Antman";
        assertEquals(firstExpectedElement, list.get(0).getTitle());
    }

    @Test
    void asc_sorter_check_3st_element_if_its_Sharknado() {
        // given
        ObservableList<Movie> list = FXCollections.observableArrayList();

        list.add(new Movie("Titanic", "Film about ship vs iceberg.", Arrays.asList(Genres.ROMANCE, Genres.DRAMA, Genres.HISTORY)));
        list.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", Arrays.asList(Genres.FAMILY, Genres.COMEDY, Genres.ROMANCE, Genres.ANIMATION)));
        list.add(new Movie("Antman", "Movie about superhero who is also an ant.", Arrays.asList(Genres.ACTION, Genres.FANTASY, Genres.SCIENCE_FICTION)));
        list.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", Arrays.asList(Genres.ADVENTURE, Genres.ACTION, Genres.FANTASY)));
        list.add(new Movie("Sharknado", "Sharks falling from sky, people dying. ", Arrays.asList(Genres.HORROR, Genres.ACTION, Genres.DRAMA)));

        // when
        list.sort(new MovieComparatorASC());


        // then
        String firstExpectedElement = "Sharknado";
        assertEquals(firstExpectedElement, list.get(2).getTitle());
    }

    @Test
    void desc_sorter_check_1st_element_if_its_Titanic() {
        // given
        ObservableList<Movie> list = FXCollections.observableArrayList();

        list.add(new Movie("Titanic", "Film about ship vs iceberg.", Arrays.asList(Genres.ROMANCE, Genres.DRAMA, Genres.HISTORY)));
        list.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", Arrays.asList(Genres.FAMILY, Genres.COMEDY, Genres.ROMANCE, Genres.ANIMATION)));
        list.add(new Movie("Antman", "Movie about superhero who is also an ant.", Arrays.asList(Genres.ACTION, Genres.FANTASY, Genres.SCIENCE_FICTION)));
        list.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", Arrays.asList(Genres.ADVENTURE, Genres.ACTION, Genres.FANTASY)));
        list.add(new Movie("Sharknado", "Sharks falling from sky, people dying. ", Arrays.asList(Genres.HORROR, Genres.ACTION, Genres.DRAMA)));

        // when
        list.sort(new MovieComparatorDESC());

        // then
        String firstExpectedElement = "Titanic";
        assertEquals(firstExpectedElement, list.get(0).getTitle());
    }

    @Test
    void desc_sorter_check_3st_element_if_its_Sharknado() {
        // given
        ObservableList<Movie> list = FXCollections.observableArrayList();

        list.add(new Movie("Titanic", "Film about ship vs iceberg.", Arrays.asList(Genres.ROMANCE, Genres.DRAMA, Genres.HISTORY)));
        list.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", Arrays.asList(Genres.FAMILY, Genres.COMEDY, Genres.ROMANCE, Genres.ANIMATION)));
        list.add(new Movie("Antman", "Movie about superhero who is also an ant.", Arrays.asList(Genres.ACTION, Genres.FANTASY, Genres.SCIENCE_FICTION)));
        list.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", Arrays.asList(Genres.ADVENTURE, Genres.ACTION, Genres.FANTASY)));
        list.add(new Movie("Sharknado", "Sharks falling from sky, people dying. ", Arrays.asList(Genres.HORROR, Genres.ACTION, Genres.DRAMA)));

        // when
        list.sort(new MovieComparatorDESC());

        // then
        String firstExpectedElement = "Sharknado";
        assertEquals(firstExpectedElement, list.get(2).getTitle());
    }

    @Test
    void test_CountMoviesFrom_() {
        List<Movie> movies = movieAPI.getMoviesAsList();

        long count1 = HomeController.countMoviesFrom(movies, "Frank Darabont");

        assertEquals(1, count1);

    }



   /* long count2 = HomeController.countMoviesFrom(movies, "Steven Spielberg");
    long count3 = HomeController.countMoviesFrom(movies, "Annelies Deadlock");

    Assertions.assertEquals(3, count2);
    Assertions.assertEquals(0, count3);*/
    @Test
    void testGetMostPopularActor() {
        List <Movie> movies = movieAPI.getMoviesAsList();

        String mostPopularActor = HomeController.getMostPopularActor(movies);
        assertEquals("Tom Hanks", mostPopularActor);
    }

    @Test
    void testGetLongestTitle() {
        List <Movie> movies = movieAPI.getMoviesAsList();
        int longestMovieTitle = HomeController.getLongestMovieTitle(movies);
        assertEquals(201, longestMovieTitle);
    }
}
