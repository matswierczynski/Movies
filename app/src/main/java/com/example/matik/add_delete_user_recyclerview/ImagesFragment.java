package com.example.matik.add_delete_user_recyclerview;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ImagesFragment extends Fragment {


    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private ImageAdapter mAdapter;


    public ImagesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ArrayList<Integer> imageIDs = bundle.getIntegerArrayList(Intent.EXTRA_TEXT);

            recyclerView = view.findViewById(R.id.images_recycler_view);
            layoutManager = new GridLayoutManager(this.getActivity(), 2);
            recyclerView.setLayoutManager(layoutManager);

            mAdapter = new ImageAdapter(getContext(), imageIDs);
            recyclerView.setAdapter(mAdapter);
        }
        return view;
    }

}
