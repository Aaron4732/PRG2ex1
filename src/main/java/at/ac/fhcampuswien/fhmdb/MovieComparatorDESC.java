package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.Comparator;

public class MovieComparatorDESC implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return m1.getTitle().toLowerCase().compareTo(m2.getTitle().toLowerCase()) * -1;
    }
}
