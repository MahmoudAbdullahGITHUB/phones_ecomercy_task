package com.example.ecomer_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.example.ecomer_java.Model.ProductModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<ProductModel> myProducts;
    ProductListAdapter adapter;

    String myqerry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.lv_Recyclerview);
        myProducts = new ArrayList<>();

        adapter = new ProductListAdapter();
        recycler.setAdapter(adapter);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<ProductModel>> call = apiInterface.getProducts();

        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                System.out.println("mon title = " + response.body().get(0).getTitle());

                myProducts = (ArrayList<ProductModel>) response.body();
                System.out.println("size =-=1 " + myProducts.size());

                adapter.setList(myProducts);

            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {

            }
        });

        System.out.println("size =-= " + myProducts.size());


//        myProducts.add(new ProductModel("prod1"));
//        myProducts.add(new ProductModel("prod2"));
//        myProducts.add(new ProductModel("prod3"));
//        myProducts.add(new ProductModel("prod4"));
//        myProducts.add(new ProductModel("prod5"));


        recycler.setLayoutManager(new LinearLayoutManager(this));


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //MenuInflater inflater = getMenuInflater();
//        getMenuInflater().inflate(R.menu.nav__menu, menu);
//
//        MenuItem menuItem = findViewById(R.id.nav_search);
//
//        SearchView searchView = (SearchView) menuItem.getActionView();
//
//        searchView.setQueryHint("Search here!");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                myqerry = newText;
//                return true;
//            }
//        });
//
//
//        return super.onCreateOptionsMenu(menu);
//    }
}