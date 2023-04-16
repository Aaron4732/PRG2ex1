package at.ac.fhcampuswien.fhmdb.api;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieAPI {
    OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();

    String jsonString;

    public MovieAPI() throws IOException {
        this.run("http://prog2.fh-campuswien.ac.at/movies");
     }

    public void run(String url) throws IOException {

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
        return gson.fromJson(jsonString, Movie[].class);
    }

    public List<Movie> getMoviesAsList() {
        return Arrays.asList(parseMovies());
    }
}
