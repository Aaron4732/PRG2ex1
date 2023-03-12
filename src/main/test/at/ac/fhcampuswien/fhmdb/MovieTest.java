package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    void check_name() {
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama");

        //When
        movie.getTitle();

        //Then
        assertEquals("Titanic", movie.getTitle());
    }

    @Test
    void check_description() {
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama");

        assertEquals("Film about ship vs iceberg.", movie.getDescription());
    }

    @Test
    void is_genre_list() {
        //Given

    }
    @Test
    void check_searchGenra_if_Drama_is_genra_of_titanic() {
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama");

        //When
        String accepted = "Drama";

        //Then
        assertTrue(movie.searchGenra(accepted));
    }
    @Test
    void check_searchGenra_if_Action_is_no_genra_of_titanic() {
        //Given
        Movie movie = new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama");

        //When
        String acceptet = "Action";

        //Then
        assertFalse(movie.searchGenra(acceptet));
    }
}
