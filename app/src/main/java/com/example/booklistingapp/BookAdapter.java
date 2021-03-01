package com.example.booklistingapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<BookInfo> {
    public BookAdapter(Activity context, ArrayList<BookInfo> books) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.show_books, parent, false);
        }

        BookInfo currentBook = getItem(position);

        TextView rating = (TextView) listItemView.findViewById(R.id.ratings);
        rating.setText(currentBook.getRating());

        TextView bookTitle = (TextView) listItemView.findViewById(R.id.bookName);
        bookTitle.setText("Book Title: "+currentBook.getBookTitle());

        TextView bookSub = (TextView) listItemView.findViewById(R.id.bookSub);
        bookSub.setText("Page Count: "+currentBook.getBookSubTitle());

        TextView auth = (TextView) listItemView.findViewById(R.id.bookAuthor);
        auth.setText("Publishers: "+currentBook.getBookAuthor());


        return listItemView;

    }
   /** private String formatRating(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }*/
}
