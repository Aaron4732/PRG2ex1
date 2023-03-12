package at.ac.fhcampuswien.fhmdb;

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
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(Movie.initializeMovies());         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.setItems(Movie.getGenreList());

        searchBtn.setOnAction(actionEvent -> {

            if(searchField.getText() == ""){
                if(genreComboBox.getSelectionModel().getSelectedItem() == "All"){
                    movieListView.setItems(observableMovies);
                }
                else {
                    movieListView.setItems(observableMovies.filtered(movie -> movie.searchGenra((String) genreComboBox.getSelectionModel().getSelectedItem())));
                }
            }
            else{
                if(genreComboBox.getSelectionModel().getSelectedItem() == "All"){
                    movieListView.setItems(observableMovies.filtered(movie -> movie.hasStringInTitleOrDescription(searchField.getText())));
                }
                else {
                    movieListView.setItems(observableMovies.filtered(movie ->
                            movie.hasStringInTitleOrDescription(searchField.getText()) &&
                            movie.searchGenra((String) genreComboBox.getSelectionModel().getSelectedItem())));
                }
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

    public static ObservableList<Movie> genreFilter(ObservableList<Movie> list, String genre){
        ObservableList<Movie> newList = FXCollections.observableArrayList();

        for (Movie movie : list){
            if (movie.searchGenra(genre)){
                newList.add(movie);
            }
        }
        return newList;
    }


}

