package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genres;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXComboBox releaseYearComboBox;

    @FXML
    public JFXComboBox ratingComboBox;



    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(Movie.initializeMovies());
        observableMovies.sort(new MovieComparatorASC());// add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.setItems(FXCollections.observableArrayList(Genres.values())); //geändert von Trixi

        releaseYearComboBox.setPromptText("Filter by Release Year");
        releaseYearComboBox.getItems().addAll("1980 - 2000", "2000-2020", "above 2020");

        ratingComboBox.setPromptText("Filter by Rating");
        ratingComboBox.getItems().addAll("below 5.0", "5.0 - 9.0", "above 9.5");

        searchBtn.setOnAction(actionEvent -> {

            if(Objects.equals(searchField.getText(), "")){
                searchWithNoSearchField();
            }
            else{
                searchWithSearchField();
            }
        } );

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {
                observableMovies.sort(new MovieComparatorASC());
                sortBtn.setText("Sort (desc)");
            } else {
                observableMovies.sort(new MovieComparatorDESC());
                sortBtn.setText("Sort (asc)");
            }
        });
    }

    public void searchWithNoSearchField(){
        System.out.println(genreComboBox.getSelectionModel().getSelectedItem().toString());
        if(Objects.equals(genreComboBox.getSelectionModel().getSelectedItem().toString(), "All")){
            movieListView.setItems(observableMovies);
        }
        else {
            movieListView.setItems(observableMovies.filtered(movie -> movie.searchGenre(genreComboBox.getSelectionModel().getSelectedItem().toString())));
        }
    }

    public void searchWithSearchField(){
        if(genreComboBox.getSelectionModel().getSelectedItem().toString() == "All"){
            movieListView.setItems(observableMovies.filtered(movie ->
                    movie.hasStringInTitleOrDescription(searchField.getText())));
        }
        else {
            movieListView.setItems(observableMovies.filtered(movie ->
                    movie.hasStringInTitleOrDescription(searchField.getText()) &&
                            movie.searchGenre((String) genreComboBox.getSelectionModel().getSelectedItem().toString())));

        }
    }
}

