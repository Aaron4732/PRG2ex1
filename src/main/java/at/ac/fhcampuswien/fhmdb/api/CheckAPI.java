package at.ac.fhcampuswien.fhmdb.api;
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

        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent","Firefox/112.0")
                .build();

        try (Response response = client.newCall(request).execute()) {
            ResponseBody responseBody = response.body();

            if (responseBody != null) {
                String jsonString = responseBody.string();
                JSONArray jsonArray = new JSONArray(jsonString);

                JSONObject jsonObject = jsonArray.getJSONObject(0);

                // Einzelne Werte aus dem JSONObject abfragen
                String title = jsonObject.getString("title");
                int releaseYear = jsonObject.getInt("releaseYear");
                double rating = jsonObject.getDouble("rating");

                System.out.println(title);
                System.out.println(releaseYear);
                System.out.println(rating);
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

