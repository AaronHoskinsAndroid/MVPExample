package examples.aaronhoskins.com.mvpexample.view.activities.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import examples.aaronhoskins.com.mvpexample.R;
import examples.aaronhoskins.com.mvpexample.model.datasource.tvshows.TvShow;
import examples.aaronhoskins.com.mvpexample.view.adapters.TvShowRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements MainActivityContract {
    MainActivityPresenter mainActivityPresenter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        mainActivityPresenter
                = new MainActivityPresenter(this);
        mainActivityPresenter.getAllTvShows(this);
    }

    @Override
    public void populateAllTvShows(ArrayList<TvShow> tvShows) {
        TvShowRecyclerViewAdapter tvShowRecyclerViewAdapter = new TvShowRecyclerViewAdapter(tvShows);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(tvShowRecyclerViewAdapter);
    }
}
