package com.example.matik.add_delete_user_recyclerview;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieActivity extends AppCompatActivity {

    private static final int MOVIE_POSTER_POSITION_IN_ARRAY = 0;
    private static final int MOVIE_IMAGES_POSITION_IN_ARRAY = 1;

    private static final int MOVIE_EXTRA_KEY_POSITION_IN_ARRAY = 0;
    private static final int CATEGORY_EXTRA_KEY_POSITION_IN_ARRAY = 1;
    private static final int ACTORS_EXTRA_KEY_POSITION_IN_ARRAY = 2;
    private static final int ACTORS_AGES_EXTRA_KEY_POSITION_IN_ARRAY = 3;
    private static final int MOVIE_IMAGES_IDS_EXTRA_KEY_POSITION_IN_ARRAY = 4;
    private static final int ACTORS_IMAGES_IDS_EXTRA_KEY_POSITION_IN_ARRAY = 5;

    private static String MOVIE_EXTRA_TEXT;
    private static String CATEGORY_EXTRA_TEXT;
    private static String ACTORS_EXTRA_TEXT;
    private static String ACTORS_AGES_EXTRA_TEXT;
    private static String MOVIE_IMAGES_IDS_EXTRA_TEXT;
    private static String ACTORS_IMAGES_IDS_EXTRA_TEXT;

    private String movieName;
    private String categoryName;
    private List<String> actorsNames;
    private List<Integer> actorsAges;
    private List<Integer> imagesIDs;
    private List<Integer> actorsIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        getExtra();
        fillMovieData(movieName, categoryName, imagesIDs);

        Bundle imagesFragbundle = new Bundle();
        ArrayList<Integer> imagesList = new ArrayList<>(imagesIDs.
                                        subList(MOVIE_IMAGES_POSITION_IN_ARRAY, imagesIDs.size()));
        imagesFragbundle.putIntegerArrayList(Intent.EXTRA_TEXT, imagesList);
        ImagesFragment imagesFragment = new ImagesFragment();
        imagesFragment.setArguments(imagesFragbundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.images_fragment_container, imagesFragment);
        fragmentTransaction.commit();

        String [] extraKeys = {ACTORS_EXTRA_TEXT, ACTORS_AGES_EXTRA_TEXT,
                                ACTORS_IMAGES_IDS_EXTRA_TEXT};

        Bundle actorsFragBundle = new Bundle();
        actorsFragBundle.putStringArrayList(Intent.EXTRA_TEXT,
                new ArrayList<>(Arrays.asList(extraKeys)));
        actorsFragBundle.putStringArrayList(ACTORS_EXTRA_TEXT,
                                            new ArrayList<>(actorsNames));
        actorsFragBundle.putIntegerArrayList(ACTORS_AGES_EXTRA_TEXT,
                                            new ArrayList<>(actorsAges));
        actorsFragBundle.putIntegerArrayList(ACTORS_IMAGES_IDS_EXTRA_TEXT,
                                            new ArrayList<>(actorsIDs));
        ActorsFragment actorsFragment = new ActorsFragment();
        actorsFragment.setArguments(actorsFragBundle);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.actors_fragment_container, actorsFragment);
        fragmentTransaction.commit();

    }

    private void getExtra(){
        String[] EXTRA_KEYS;
        EXTRA_KEYS = getIntent().getStringArrayExtra(Intent.EXTRA_TEXT);
        MOVIE_EXTRA_TEXT = EXTRA_KEYS[MOVIE_EXTRA_KEY_POSITION_IN_ARRAY];
        CATEGORY_EXTRA_TEXT = EXTRA_KEYS[CATEGORY_EXTRA_KEY_POSITION_IN_ARRAY];
        ACTORS_EXTRA_TEXT = EXTRA_KEYS[ACTORS_EXTRA_KEY_POSITION_IN_ARRAY];
        ACTORS_AGES_EXTRA_TEXT = EXTRA_KEYS[ACTORS_AGES_EXTRA_KEY_POSITION_IN_ARRAY];
        MOVIE_IMAGES_IDS_EXTRA_TEXT = EXTRA_KEYS[MOVIE_IMAGES_IDS_EXTRA_KEY_POSITION_IN_ARRAY];
        ACTORS_IMAGES_IDS_EXTRA_TEXT = EXTRA_KEYS[ACTORS_IMAGES_IDS_EXTRA_KEY_POSITION_IN_ARRAY];
        movieName = getIntent().getStringExtra(MOVIE_EXTRA_TEXT);
        categoryName = getIntent().getStringExtra(CATEGORY_EXTRA_TEXT);
        actorsNames = getIntent().getStringArrayListExtra(ACTORS_EXTRA_TEXT);
        actorsAges  = getIntent().getIntegerArrayListExtra(ACTORS_AGES_EXTRA_TEXT);
        imagesIDs   = getIntent().getIntegerArrayListExtra(MOVIE_IMAGES_IDS_EXTRA_TEXT);
        actorsIDs   = getIntent().getIntegerArrayListExtra(ACTORS_IMAGES_IDS_EXTRA_TEXT);
    }

    private void fillMovieData(String movieName, String categoryName,
                               List<Integer> images){
        ((TextView)findViewById(R.id.movieNameTextView)).setText(movieName);
        ((TextView)findViewById(R.id.movieCategoryTextView)).setText(categoryName);
        ((ImageView)findViewById(R.id.moviePosterImageView)).
                setImageResource(images.get(MOVIE_POSTER_POSITION_IN_ARRAY));
    }



}
