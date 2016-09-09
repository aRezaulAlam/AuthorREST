package com.agroho.authorrest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.agroho.authorrest.R;
import com.agroho.authorrest.model.Author;

import java.util.List;

/**
 * Created by Rezaul on 09-Sep-16.
 */
public class AuthorAdapter extends BaseAdapter {

    Context context;
    List<Author> authors;
    LayoutInflater inflater;

    public AuthorAdapter(Context context, List<Author> authors){

        this.context = context;
        this.authors = authors;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return authors.size();
    }

    @Override
    public Object getItem(int i) {
        return authors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return authors.get(i).getAuthorId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.author_row,parent,false);

            holder.authorId = (TextView)convertView.findViewById(R.id.authorId);
            holder.authorName = (TextView)convertView.findViewById(R.id.authorName);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Author author = authors.get(i);
        holder.authorId.setText(author.getId());
        holder.authorName.setText(author.getFirstName()+" "+author.getLastName());

        return convertView;
    }


    private class ViewHolder{

        TextView authorId;
        TextView authorName;


    }
}
