package com.example.gallery;

import android.widget.ImageView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class API{

    public static String baseUrl = "https://api.flickr.com/";


    public static ImageService imageService = null;

    public static  ImageService getImageService()
    {
        if(imageService == null)
        {




            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            imageService = retrofit.create(ImageService.class);

        }

        return imageService;

        }





    public interface ImageService
    {

        @GET("services/rest/?method=flickr.photos.getRecent&per_page=20&page=1&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
        Call<Images> getPhotolist();
    }

}
