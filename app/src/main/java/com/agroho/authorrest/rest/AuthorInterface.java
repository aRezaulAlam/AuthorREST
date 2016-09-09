package com.agroho.authorrest.rest;

import com.agroho.authorrest.model.Author;

import java.util.List;

import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Rezaul on 09-Sep-16.
 */
public interface AuthorInterface {

    @GET("authors")
    Call<List<Author>> getAuthors();

   /* @POST("author")
    Author postAuthor(@Body Author author);*/

    @POST("author")
    Call<Author> addAuthor(@Body Author Author);




}
