package nio;

import java.io.IOException;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpExample {
    private OkHttpClient client = new OkHttpClient();

    private String execute(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    public static void main(String[] args) throws IOException {
        OkHttpExample example = new OkHttpExample();
        String response = null;
        try {
            response = example.execute("http://localhost:8801");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(response);
    }
}