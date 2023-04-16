package at.ac.fhcampuswien.fhmdb.api;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CheckAPI {



    String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent","Firefox/112.0")
                .build();

        try (Response response = client.newCall(request).execute()) {
            ResponseBody responseBody = response.body();

            if (responseBody != null) {
                String jsonString = responseBody.string();
                Movie[] movies = gson.fromJson(jsonString, Movie[].class);

                // Einzelne Werte aus dem JSONObject abfragen

                Movie firstMovie = movies[0];
                String title = firstMovie.getTitle();
                System.out.println(title);
            }

            return "test";
        }
    }

    public static void main(String[] args) throws IOException {
        CheckAPI example = new CheckAPI();
        String response = null;

        response = example.run("http://prog2.fh-campuswien.ac.at/movies");

        System.out.println(response);

    }
}

