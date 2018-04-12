package com.example.matik.add_delete_user_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter
                                        <MovieAdapter.MovieViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Movie> movies;
    private List<Integer> moviesPosters;
    private OnItemClicked onClick;

    MovieAdapter(Context context, List<Movie> movies, List<Integer> moviesPosters){
        layoutInflater=LayoutInflater.from(context);
        this.movies = movies;
        this.moviesPosters = moviesPosters;
    }
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.movie_row, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, int position) {
        holder.movieName.setText(movies.get(position).getTitle());
        holder.categoryName.setText(movies.get(position).getCategoryName());
        holder.movieImage.setImageResource(moviesPosters.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(holder.getAdapterPosition());
            }
        });

    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


    void removeAt(int position){
        movies.remove(position);
        notifyItemRemoved(position);
    }

    void setOnClick(OnItemClicked onClick)
    {
        this.onClick=onClick;
    }


     static class MovieViewHolder extends RecyclerView.ViewHolder{

        private TextView movieName, categoryName;
        private ImageView movieImage;

        MovieViewHolder(View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movie_row_name);
            categoryName  = itemView.findViewById(R.id.movie_row_category);
            movieImage = itemView.findViewById(R.id.movie_row_image);
        }

     }


    public interface OnItemClicked {
        void onItemClick(int position);
    }
}
