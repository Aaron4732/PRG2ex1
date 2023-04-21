package at.ac.fhcampuswien.fhmdb.api;
import at.ac.fhcampuswien.fhmdb.models.Genres;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MovieAPI {


    String jsonString;

    String searchtext = "";

    private final static String BASIC_URL = "http://prog2.fh-campuswien.ac.at/movies";

    Genres genre = Genres.ALL;
    public MovieAPI() throws IOException {
        this.run();
    }

    public void run() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = ganerateURL();

        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent","Firefox/112.0")
                .build();

        try (Response response = client.newCall(request).execute()) {
            ResponseBody responseBody = response.body();

            if (responseBody != null) {
                jsonString = responseBody.string();
            }
        }
    }

    public Movie[] parseMovies() {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Movie[].class);
    }
    public List<Movie> getMoviesAsList() {
        return Arrays.asList(parseMovies());
    }

    public void setSearchtext(String searchtext) {
        this.searchtext = searchtext;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    private String ganerateURL() {
        return BASIC_URL + "?genre=" + genre + "&" + "query=" + searchtext;
    }
}
