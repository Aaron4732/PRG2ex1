package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    void check_name() {
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama", "History");

        //When
        movie.getTitle();

        //Then
        assertEquals("Titanic", movie.getTitle());
    }

    @Test
    void check_description() {
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama", "History");

        //When
        movie.getDescription();

        //Then
        assertEquals("Film about ship vs iceberg.", movie.getDescription());
    }

    @Test
    void is_genre_list() {
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama", "History");
        List <String> testList = new ArrayList <String>(List.of("Romance", "Drama", "History"));

        //When
        movie.getGenre();

        //Then
        assertLinesMatch(testList, movie.getGenre());

    }

    @Test
    void are_movies_in_list_the_right_searched_genre_true() {
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama");

        //When
        movie.searchGenre("Drama");

        //Then
        assertTrue(movie.searchGenre("Drama"));

    }

    @Test
    void are_movies_in_list_the_right_searched_genre_false() {
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama");

        //When
        movie.searchGenre("Action");

        //Then
        assertFalse(movie.searchGenre("Action"));

    }

    @Test
    void check_if_title_or_description_contains_String_true(){
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama", "History");

        //When
        movie.hasStringInTitleOrDescription("ship");

        //Then
        assertTrue(movie.hasStringInTitleOrDescription("ship"));
    }

    @Test
    void check_if_title_or_description_contains_String_false(){
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama", "History");

        //When
        movie.hasStringInTitleOrDescription("water");

        //Then
        assertFalse(movie.hasStringInTitleOrDescription("water"));
    }


}
