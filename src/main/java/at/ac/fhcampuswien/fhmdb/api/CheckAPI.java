package at.ac.fhcampuswien.fhmdb.api;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CheckAPI {

    private static final OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) throws IOException {
        CheckAPI example = new CheckAPI();
        String response = null;

        response = example.run("http://localhost:3002/users");

        System.out.println(response);

        Gson gson = new Gson();
        User[] users = gson.fromJson(response, User[].class);

        System.out.println(Arrays.toString(users));

        double d = Arrays.stream(users)
                .mapToDouble(User::getAge)
                .average()
                .orElse(0);

        System.out.println("Average age="+d);

        List<User> list = Arrays.stream(users)
                .filter(s -> s.getUsername().startsWith("A"))
                .toList();


        list.stream().forEach(n -> System.out.println(n.getUsername()));
    }
}

