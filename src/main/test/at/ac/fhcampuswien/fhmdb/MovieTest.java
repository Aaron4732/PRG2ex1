package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
}
