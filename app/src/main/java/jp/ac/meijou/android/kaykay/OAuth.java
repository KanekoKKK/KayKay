package jp.ac.meijou.android.kaykay;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import okhttp3.*;
import java.io.IOException;

public class OAuth {
    private static final String BASE_URL = "https://api.paypay.ne.jp/";
    private static final String API_KEY = "a_GSm8N9RYCG_rMOC";
    private static final String API_SECRET = "pUHBhTdyAUBFjTBGLMuzU0FGG4sB+air1feKSu+bGwY=";

    public static String getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String credentials = Credentials.basic(API_KEY, API_SECRET);

        Request request = new Request.Builder()
                .url(BASE_URL + "v2/token")
                .header("Authorization", credentials)
                .post(RequestBody.create("", MediaType.parse("application/json")))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        String jsonData = response.body().string();
        // パースしてアクセストークンを取得
        return new Gson().fromJson(jsonData, JsonObject.class).get("access_token").getAsString();
    }
}

