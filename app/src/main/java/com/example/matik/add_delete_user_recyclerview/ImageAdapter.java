package com.example.matik.add_delete_user_recyclerview;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


class ImageAdapter extends RecyclerView.Adapter
        <ImageAdapter.ImageViewHolder> {

    private ArrayList<Integer> imagesIDs;
    private LayoutInflater layoutInflater;

    public ImageAdapter(Context context, ArrayList<Integer> imagesIDs ){
        layoutInflater= LayoutInflater.from(context);
        this.imagesIDs = imagesIDs;
    }
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.image_row, parent, false);
        ImageViewHolder holder = new ImageViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ImageViewHolder holder, int position) {
        holder.movieImage.setImageResource(imagesIDs.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesIDs.size();
    }


    static class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView movieImage;

        public ImageViewHolder(View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.singleMovieImage);
        }
    }
}
