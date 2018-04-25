package io.hasura.webreq;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by HARIHARAN on 27-06-2017.
 */

public interface ApiInterface {

    @GET()
    Call<String> send(@Url String url);

}
