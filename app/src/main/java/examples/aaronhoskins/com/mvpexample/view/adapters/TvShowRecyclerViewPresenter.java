package examples.aaronhoskins.com.mvpexample.view.adapters;

import java.util.Locale;

public class TvShowRecyclerViewPresenter {
    TvShowRecyclerViewContract tvShowRecyclerViewContract;

    public TvShowRecyclerViewPresenter(TvShowRecyclerViewContract tvShowRecyclerViewContract) {
        this.tvShowRecyclerViewContract = tvShowRecyclerViewContract;
    }

    public void getSeasonString(int seasonNumber) {
        tvShowRecyclerViewContract.getSeasonString(
                String.format(Locale.US, "Season %d", seasonNumber)
        );
    }
}
