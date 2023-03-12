package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

class HomeControllerTest {

    @Test
    void asc_sorter_check_1st_element_if_its_Antman() {
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.ascSorter(unsortetList);

        // then
        String firstExpectetElement = "Antman";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }
    @Test
    void asc_sorter_check_3st_element_if_its_Sharknado() {
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.ascSorter(unsortetList);

        // then
        String firstExpectetElement = "Sharknado";
        assertEquals(firstExpectetElement, sortetList.get(2).getTitle());
    }

    @Test
    void desc_sorter_check_1st_element_if_its_Titanic(){
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.descSorter(unsortetList);

        // then
        String firstExpectetElement = "Titanic";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }

    @Test
    void desc_sorter_check_3st_element_if_its_Sharknado(){
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.descSorter(unsortetList);

        // then
        String firstExpectetElement = "Sharknado";
        assertEquals(firstExpectetElement, sortetList.get(2).getTitle());
    }

    @Test
    void genre_filter_check_1st_element_in_list_of_action_genres_if_its_Antman(){
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.genreFilter(unsortetList, "Action");

        // then
        String firstExpectetElement = "Antman";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }

    @Test
    void genre_filter_check_2st_element_in_list_of_drame_genres_if_its_Sharknado(){
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.genreFilter(unsortetList, "Drama");

        // then
        String firstExpectetElement = "Sharknado";
        assertEquals(firstExpectetElement, sortetList.get(1).getTitle());
    }

    @Test
    void genre_filter_check_1st_element_in_list_of_Romance_genres_if_its_Shrek(){
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.genreFilter(unsortetList, "Romance");

        // then
        String firstExpectetElement = "Shrek";
        assertEquals(firstExpectetElement, sortetList.get(0).getTitle());
    }

    @Test
    void string_filter_check_if_movie_Shrek_is_return_as_1st_element_by_search_string_shrek(){
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.stringFilter(unsortetList, "shrek");

        // then
        String firstExpectetElement = "Shrek";
        assertEquals(firstExpectetElement,sortetList.get(0).getTitle());
    }

    @Test
    void string_filter_check_if_movie_Titanic_is_return_as_1st_element_by_search_string_iceberg(){
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.stringFilter(unsortetList, "iceberg");

        // then
        String firstExpectetElement = "Titanic";
        assertEquals(firstExpectetElement,sortetList.get(0).getTitle());
    }

    @Test
    void string_filter_check_if_movie_Titanic_is_return_as_2st_element_by_search_string_about(){
        // given
        ObservableList<Movie> unsortetList = FXCollections.observableArrayList();

        unsortetList.add(new Movie("Shrek", "Ogre living peacefully in his swamp.", "Family", "Comedy", "Romance"));
        unsortetList.add(new Movie("Antman", "Movie about superhero who is also an ant.", "Action"));
        unsortetList.add(new Movie("Titanic", "Film about ship vs iceberg.", "Romance", "Drama"));
        unsortetList.add(new Movie("Lord of the rings", "Boys trying to destroy an invisibility ring.", "Adventure", "Action"));
        unsortetList.add(new Movie("Sharknado", "Sharks falling from sky, people dying.", "Horror", "Action", "Drama"));

        // when
        ObservableList<Movie> sortetList = HomeController.stringFilter(unsortetList, "iceberg");

        // then
        String firstExpectetElement = "Titanic";
        assertEquals(firstExpectetElement,sortetList.get(0).getTitle());
    }


}
