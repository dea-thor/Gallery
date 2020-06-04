package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
     RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.reyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        getData();











    }

    void getData()
    {
         Call<Images>  Photo = API.getImageService().getPhotolist();

        Photo.enqueue(new Callback<Images>() {
            @Override
            public void onResponse(Call<Images> call, Response<Images> response) {

                Images list = response.body();
                Photos all = list.getPhotos();
                List<Photo> gg= all.getPhoto();

                mAdapter = new ExampleAdapter(gg,MainActivity.this);
                recyclerView.setAdapter(mAdapter);





            }

            @Override
            public void onFailure(Call<Images> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_LONG).show();

            }
        });

    }



}
