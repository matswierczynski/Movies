package com.example.matik.add_delete_user_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by matik on 22.03.2018.
 */

public class MovieAdapter extends RecyclerView.Adapter
                                        <MovieAdapter.MovieViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Movie> movies;
    private OnItemClicked onClick;

    public MovieAdapter(Context context, List<Movie> movies){
        layoutInflater=LayoutInflater.from(context);
        this.movies = movies;
    }
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.movie_row, parent, false);
        MovieViewHolder holder = new MovieViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieName.setText(movies.get(position).getTitle());
        holder.categoryName.setText(movies.get(position).getCategoryName());
        holder.movieImage.setImageResource(R.drawable.ic_launcher_background);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


    public void removeAt(int position){
        movies.remove(position);
        notifyItemRemoved(position);
    }

    public void setOnClick(OnItemClicked onClick)
    {
        this.onClick=onClick;
    }


     static class MovieViewHolder extends RecyclerView.ViewHolder{

        private TextView movieName, categoryName;
        private ImageView movieImage;

        public MovieViewHolder(View itemView) {
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
