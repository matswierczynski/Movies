package com.example.matik.add_delete_user_recyclerview;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {

    private static final int MOVIE_POSTER_POSITION_IN_ARRAY = 0;
    private static final int MOVIE_IMAGES_POSITION_IN_ARRAY = 1;
    private static final int MOVIE_EXTRA_KEY_POSITION_IN_ARRAY = 0;
    private static final int CATEGORY_EXTRA_KEY_POSITION_IN_ARRAY = 1;
    private static final int ACTORS_EXTRA_KEY_POSITION_IN_ARRAY = 2;
    private String movieName;
    private String categoryName;
    private List<String> actorsNames;
    private List<Integer> imagesIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        getExtra();
        imagesIDs = getMovieImages(movieName);
        fillMovieData(movieName, categoryName, actorsNames, imagesIDs);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



        Bundle imFragbundle = new Bundle();
        ArrayList<Integer> imagesList = new ArrayList<>(imagesIDs.
                                        subList(MOVIE_IMAGES_POSITION_IN_ARRAY, imagesIDs.size()));
        imFragbundle.putIntegerArrayList(Intent.EXTRA_TEXT, imagesList);
        ImagesFragment imagesFragment = new ImagesFragment();
        imagesFragment.setArguments(imFragbundle);
        fragmentTransaction.add(R.id.images_fragment_container, imagesFragment);
        fragmentTransaction.commit();

    }

    private void getExtra(){
        String[] EXTRA_KEYS;
        EXTRA_KEYS = getIntent().getStringArrayExtra(Intent.EXTRA_TEXT);
        String MOVIE_EXTRA_TEXT = EXTRA_KEYS[MOVIE_EXTRA_KEY_POSITION_IN_ARRAY];
        String CATEGORY_EXTRA_TEXT = EXTRA_KEYS[CATEGORY_EXTRA_KEY_POSITION_IN_ARRAY];
        String ACTORS_EXTRA_TEXT = EXTRA_KEYS[ACTORS_EXTRA_KEY_POSITION_IN_ARRAY];
        movieName = getIntent().getStringExtra(MOVIE_EXTRA_TEXT);
        categoryName = getIntent().getStringExtra(CATEGORY_EXTRA_TEXT);
        actorsNames = getIntent().getStringArrayListExtra(ACTORS_EXTRA_TEXT);

    }

    private void fillMovieData(String movieName, String categoryName,
                               List<String> actorsNames, List<Integer> images){
        ((TextView)findViewById(R.id.movieNameTextView)).setText(movieName);
        ((TextView)findViewById(R.id.movieCategoryTextView)).setText(categoryName);
        ((ImageView)findViewById(R.id.moviePosterImageView)).
                setImageResource(images.get(MOVIE_POSTER_POSITION_IN_ARRAY));
    }

    private List<Integer> getMovieImages(String movieName){
        movieName = movieName.replaceAll("\\s+","");
        movieName = movieName.toLowerCase();
        Field[] fields = R.drawable.class.getFields();
        List<Integer> drawables = new ArrayList<Integer>();
        for (Field field : fields) {
            // Take only those with name starting with movie title
            if (field.getName().startsWith(movieName)) {
                try {
                    drawables.add(field.getInt(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return drawables;
    }

}
