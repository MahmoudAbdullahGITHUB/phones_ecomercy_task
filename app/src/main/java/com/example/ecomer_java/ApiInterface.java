package com.example.ecomer_java;

import com.example.ecomer_java.Model.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("products")
    public Call<List<ProductModel>> getProducts();
}
