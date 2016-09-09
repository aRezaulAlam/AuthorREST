package com.agroho.authorrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.agroho.authorrest.adapter.AuthorAdapter;
import com.agroho.authorrest.model.Author;
import com.agroho.authorrest.rest.AuthorCall;
import com.agroho.authorrest.rest.AuthorInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Author> authorList;
    ListView authorListView;
    AuthorAdapter authorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authorListView = (ListView)findViewById(R.id.authorlistview);

        AuthorInterface apiInterface = AuthorCall.getClient().create(AuthorInterface.class);

        Call<Author> call = apiInterface.addAuthor(new Author("","Nahid","Nasenia"));

        call.enqueue(new Callback<Author>() {
            @Override
            public void onResponse(Call<Author> call, Response<Author> response) {
                Log.d("Response status code: ", "Response status code"+response.code());
            }

            @Override
            public void onFailure(Call<Author> call, Throwable t) {

            }
        });

        Call<List<Author>> userList = apiInterface.getAuthors();

        userList.enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                authorList = response.body();
                authorAdapter = new AuthorAdapter(MainActivity.this,authorList);
                authorListView.setAdapter(authorAdapter);
                Log.d("Authors List", "Number of authors: " + authorList.size());
            }

            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {
                Log.e("Error in Author Parsing", t.toString());

            }
        });


    }
}
