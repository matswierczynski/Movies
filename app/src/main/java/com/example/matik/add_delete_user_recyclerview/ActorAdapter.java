package com.example.matik.add_delete_user_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {
    private ArrayList<String>  actorData;
    private ArrayList<Integer> actorsAge;
    private ArrayList<Integer> actorsImagesIDs;
    private LayoutInflater layoutInflater;

    public ActorAdapter(Context context, ArrayList<String> actorData,
                        ArrayList<Integer> actorsAge,
                        ArrayList<Integer> actorsImagesIDs ){
        layoutInflater= LayoutInflater.from(context);
        this.actorData = actorData;
        this.actorsAge = actorsAge;
        this.actorsImagesIDs = actorsImagesIDs;
    }

    @Override
    public ActorAdapter.ActorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.actor_row, parent, false);
        ActorViewHolder holder = new ActorViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ActorAdapter.ActorViewHolder holder, int position) {
        holder.actorPersonalData.setText(actorData.get(position));
        holder.actorAge.setText(actorsAge.get(position).toString());
        holder.actorImage.setImageResource(actorsImagesIDs.get(position));
    }

    @Override
    public int getItemCount() {
        return actorData.size();
    }

    static class ActorViewHolder extends RecyclerView.ViewHolder {

        private TextView actorPersonalData, actorAge;
        private ImageView actorImage;

        public ActorViewHolder(View itemView) {
            super(itemView);
            actorPersonalData = itemView.findViewById(R.id.singleActorData);
            actorAge = itemView.findViewById(R.id.singleActorAge);
            actorImage = itemView.findViewById(R.id.singleActorImage);
        }
    }
}
