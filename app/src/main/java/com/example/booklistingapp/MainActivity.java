package com.example.booklistingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String BOOK_API_CALL = "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=10";
    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        
        mAdapter = new BookAdapter(this, new ArrayList<BookInfo>());
        ListView bookListView = (ListView) findViewById(R.id.list);
        bookListView.setAdapter(mAdapter);


        BookAsyncTask task = new BookAsyncTask();
        task.execute(BOOK_API_CALL);

    }
    private class BookAsyncTask extends AsyncTask<String, Void, List<BookInfo>> {

        @Override
        protected List<BookInfo> doInBackground(String... urls) {

            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<BookInfo> result = QueryUtils.fetchBookData(urls[0]);
            return result;
        }


        @Override
        protected void onPostExecute(List<BookInfo> data) {
            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }


    }
}

