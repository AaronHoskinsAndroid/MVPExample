package examples.aaronhoskins.com.mvpexample.view.activities.mainactivity;

import android.content.Context;

import java.util.ArrayList;

import examples.aaronhoskins.com.mvpexample.model.datasource.local.database.TvShowDatabaseHelper;
import examples.aaronhoskins.com.mvpexample.model.datasource.tvshows.TvShow;

public class MainActivityPresenter {
    MainActivityContract mainActivityContract;

    public MainActivityPresenter(MainActivityContract mainActivityContract) {
        this.mainActivityContract = mainActivityContract;
    }

    public void getAllTvShows(Context context) {
        TvShowDatabaseHelper tvShowDatabaseHelper = new TvShowDatabaseHelper(context);
        ArrayList<TvShow> allTvShows = tvShowDatabaseHelper.getAllTvShows();
        mainActivityContract.populateAllTvShows(allTvShows);
    }


}
