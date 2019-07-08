package examples.aaronhoskins.com.mvpexample.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import examples.aaronhoskins.com.mvpexample.R;
import examples.aaronhoskins.com.mvpexample.model.datasource.tvshows.TvShow;

public class TvShowRecyclerViewAdapter extends RecyclerView.Adapter<TvShowRecyclerViewAdapter.ViewHolder>
    implements TvShowRecyclerViewContract{
    private ArrayList<TvShow> tvShowArrayList;
    private TvShowRecyclerViewPresenter tvShowRecyclerViewPresenter;
    private ViewHolder holder;

    public TvShowRecyclerViewAdapter(ArrayList<TvShow> tvShowArrayList) {
        this.tvShowArrayList = tvShowArrayList;
        tvShowRecyclerViewPresenter = new TvShowRecyclerViewPresenter(this);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.tv_show_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TvShow tvShow = tvShowArrayList.get(position);
        holder.tvTitle.setText(tvShow.getTitle());
        holder.tvRating.setText(tvShow.getRating());
        holder.tvDesc.setText(tvShow.getDescription());
        this.holder = holder;
        tvShowRecyclerViewPresenter.getSeasonString(tvShow.getSeason());
    }

    @Override
    public int getItemCount() {
        return tvShowArrayList.size();
    }

    @Override
    public void getSeasonString(String seasonString) {
        holder.tvSeason.setText(seasonString);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvDesc;
        TextView tvRating;
        TextView tvSeason;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvSeason = itemView.findViewById(R.id.tvSeason);
        }
    }
}
