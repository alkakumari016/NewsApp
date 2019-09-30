package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;

/**created by alka
 * *
 */

public interface Api {
    @GET("v2/top-headlines?sources=google-news-in&apiKey=5816174d2a0b4dec93334e4103c0ce94")
    Call<WebServiceResponse> getResponse();
}
