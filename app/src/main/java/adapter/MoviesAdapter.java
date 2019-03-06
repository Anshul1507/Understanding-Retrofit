package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import model.Movie;
import practice.module.com.understandingretrofit.R;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;

        public MovieViewHolder(View v){
            super(v);
            moviesLayout = v.findViewById(R.id.movies_layout);
            movieTitle = v.findViewById(R.id.title);
            data = v.findViewById(R.id.subtitle);
            movieDescription = v.findViewById(R.id.description);
            rating = v.findViewById(R.id.rating);

        }
    }

    public MoviesAdapter(List<Movie> movies,int rowLayout,Context context)
    {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout,viewGroup,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.movieTitle.setText(movies.get(i).getTitle());
        movieViewHolder.data.setText(movies.get(i).getReleaseDate());
        movieViewHolder.movieDescription.setText(movies.get(i).getOverview());
        movieViewHolder.rating.setText(movies.get(i).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
