package com.example.matik.add_delete_user_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;


public class ActorsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ActorAdapter mAdapter;

    private static String ACTORS_EXTRA_TEXT;
    private static String ACTORS_AGES_EXTRA_TEXT;
    private static String ACTORS_IMAGES_IDS_EXTRA_TEXT;
    private final static int COLUMNS_NO_IN_LANDSCAPE_MODE = 2;

    private final static Integer ACTORS_EXTRA_KEY_POSITION_IN_ARRAY = 0;
    private final static Integer ACTORS_AGES_EXTRA_KEY_POSITION_IN_ARRAY = 1;
    private final static Integer ACTORS_IMAGES_IDS_EXTRA_KEY_POSITION_IN_ARRAY = 2;

    private ArrayList<String> actorNames;
    private ArrayList<Integer> actorsAges;
    private ArrayList<Integer> actorsIDs;

    private RecyclerView.LayoutManager layoutManager;

    public ActorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_actors, container, false);
        getExtras();

        recyclerView = view.findViewById(R.id.actors_recycler_view);
        setScreenMode();
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ActorAdapter(getContext(), actorNames, actorsAges, actorsIDs);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    private void getExtras(){
        Bundle bundle = getArguments();
        ArrayList<String> EXTRA_KEYS = bundle.getStringArrayList(Intent.EXTRA_TEXT);

        ACTORS_EXTRA_TEXT = EXTRA_KEYS.get(ACTORS_EXTRA_KEY_POSITION_IN_ARRAY);
        ACTORS_AGES_EXTRA_TEXT = EXTRA_KEYS.get(ACTORS_AGES_EXTRA_KEY_POSITION_IN_ARRAY);
        ACTORS_IMAGES_IDS_EXTRA_TEXT = EXTRA_KEYS.
                get(ACTORS_IMAGES_IDS_EXTRA_KEY_POSITION_IN_ARRAY);

        actorNames = bundle.getStringArrayList(ACTORS_EXTRA_TEXT);
        actorsAges = bundle.getIntegerArrayList(ACTORS_AGES_EXTRA_TEXT);
        actorsIDs = bundle.
                getIntegerArrayList(ACTORS_IMAGES_IDS_EXTRA_TEXT);
    }

    private void setScreenMode(){
        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            layoutManager = new LinearLayoutManager(getContext());
        }
        else {
            layoutManager = new GridLayoutManager(
                    this.getActivity(), COLUMNS_NO_IN_LANDSCAPE_MODE);
        }
    }
}
