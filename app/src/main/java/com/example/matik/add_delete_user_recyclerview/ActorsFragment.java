package com.example.matik.add_delete_user_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ActorsFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ActorAdapter mAdapter;

    private static String ACTORS_EXTRA_TEXT;
    private static String ACTORS_AGES_EXTRA_TEXT;
    private static String ACTORS_IMAGES_IDS_EXTRA_TEXT;

    private final static Integer ACTORS_EXTRA_KEY_POSITION_IN_ARRAY = 0;
    private final static Integer ACTORS_AGES_EXTRA_KEY_POSITION_IN_ARRAY = 1;
    private final static Integer ACTORS_IMAGES_IDS_EXTRA_KEY_POSITION_IN_ARRAY = 2;

    public ActorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_actors, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {

            ArrayList<String> EXTRA_KEYS = bundle.getStringArrayList(Intent.EXTRA_TEXT);

            ACTORS_EXTRA_TEXT = EXTRA_KEYS.get(ACTORS_EXTRA_KEY_POSITION_IN_ARRAY);
            ACTORS_AGES_EXTRA_TEXT = EXTRA_KEYS.get(ACTORS_AGES_EXTRA_KEY_POSITION_IN_ARRAY);
            ACTORS_IMAGES_IDS_EXTRA_TEXT = EXTRA_KEYS.
                    get(ACTORS_IMAGES_IDS_EXTRA_KEY_POSITION_IN_ARRAY);

            ArrayList<String> actorNames = bundle.getStringArrayList(ACTORS_EXTRA_TEXT);
            ArrayList<Integer> actorsAges = bundle.getIntegerArrayList(ACTORS_AGES_EXTRA_TEXT);
            ArrayList<Integer> actorsIDs = bundle.
                    getIntegerArrayList(ACTORS_IMAGES_IDS_EXTRA_TEXT);

            recyclerView = view.findViewById(R.id.actors_recycler_view);
            layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);

            mAdapter = new ActorAdapter(getContext(), actorNames, actorsAges, actorsIDs);
            recyclerView.setAdapter(mAdapter);
        }


        return view;
    }
}
