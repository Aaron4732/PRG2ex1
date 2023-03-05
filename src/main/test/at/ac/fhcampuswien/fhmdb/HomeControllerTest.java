package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @Test
    void asc_sorter_check_1st_element() {
        // given
        ArrayList<Movie> unsortetList = new ArrayList<>();

        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ArrayList<Movie> sortetList = HomeController.ascSorter(unsortetList);

        // then
        String firstExpectetElement = "Antman";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }
    @Test
    void asc_sorter_check_3st_element() {
        // given
        ArrayList<Movie> unsortetList = new ArrayList<>();

        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ArrayList<Movie> sortetList = HomeController.ascSorter(unsortetList);

        // then
        String firstExpectetElement = "Sharknado";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }

    @Test
    void desc_sorter_check_1st_element(){
        // given
        ArrayList<Movie> unsortetList = new ArrayList<>();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ArrayList<Movie> sortetList = HomeController.descSorter(unsortetList);

        // then
        String firstExpectetElement = "Titanic";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }

    @Test
    void desc_sorter_check_3st_element(){
        // given
        ArrayList<Movie> unsortetList = new ArrayList<>();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ArrayList<Movie> sortetList = HomeController.descSorter(unsortetList);

        // then
        String firstExpectetElement = "Sharknado";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }

    @Test
    void genre_filter_check_1st_element_in_list_of_action_genres(){
        // given
        ArrayList<Movie> unsortetList = new ArrayList<>();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ArrayList<Movie> sortetList = HomeController.genreFilter(unsortetList, "Action");

        // then
        String firstExpectetElement = "Antman";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }

    @Test
    void genre_filter_check_2st_element_in_list_of_drame_genres(){
        // given
        ArrayList<Movie> unsortetList = new ArrayList<>();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ArrayList<Movie> sortetList = HomeController.genreFilter(unsortetList, "Drama");

        // then
        String firstExpectetElement = "Sharknado";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }

    @Test
    void genre_filter_check_1st_element_in_list_of_Romance_genres(){
        // given
        ArrayList<Movie> unsortetList = new ArrayList<>();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ArrayList<Movie> sortetList = HomeController.genreFilter(unsortetList, "Romance");

        // then
        String firstExpectetElement = "Shrek";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }
}
