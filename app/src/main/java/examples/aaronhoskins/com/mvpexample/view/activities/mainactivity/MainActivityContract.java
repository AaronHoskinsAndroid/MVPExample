package examples.aaronhoskins.com.mvpexample.view.activities.mainactivity;

import java.util.ArrayList;

import examples.aaronhoskins.com.mvpexample.model.datasource.tvshows.TvShow;

public interface MainActivityContract {
    void populateAllTvShows(ArrayList<TvShow> tvShows);
}
