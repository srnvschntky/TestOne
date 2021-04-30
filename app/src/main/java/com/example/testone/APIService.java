package com.example.testone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("users")
    Call<List<UserModel>> getUserList();

}
