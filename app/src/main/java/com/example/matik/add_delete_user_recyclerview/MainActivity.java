package com.example.matik.add_delete_user_recyclerview;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.example.matik.add_delete_user_recyclerview.Actor.*;
import static com.example.matik.add_delete_user_recyclerview.Category.*;

public class MainActivity extends AppCompatActivity implements
        MovieAdapter.OnItemClicked{

    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static Actor[] annihilActors = {PORTMANN, LEIGH, THOMPSON, RODRIGUEZ, NOVOTNY, ISAAC};
    private static Actor[] everestActors = {CLARK, BROLIN, GYLLENHAAL, HAWKES, WRIGHT, WATSON,
                                    KELLY, KNIGHTLEY};
    private static Actor[] playerActors  = {SHERIDAN, COOKE, MENDELSOHN, WAITHE, MILLER, PEGG};
    private static Actor[] shapeActors   = {HAWKINS, SHANNON, JENKINS, SPENCER, STUHLBARG, JONES};
    private static Actor[] tombActors    = {VIKANDER, WEST, GOGGINS, WU, THOMAS, JACOBI};
    private static Movie [] movies = {new Movie("Annihilation",THRILLER,annihilActors),
                                new Movie("Everest", ADVENTURE, everestActors),
                                new Movie("Player One", ADVENTURE, playerActors),
                                new Movie("Shape of Water", FANTASY, shapeActors),
                                new Movie("Tomb Raider", ADVENTURE, tombActors)};
    private static Integer POSTER_POSITION_IN_IMAGES_ARRAY = 0;
    private final static String MOVIE_EXTRA_TEXT =
                            "com.main.java.matik.add_delete_user_recyclerview_MOVIE_EXTRA_TEXT";
    private final static String CATEGORY_EXTRA_TEXT =
                            "com.main.java.matik.add_delete_user_recyclerview_CATEGORY_EXTRA_TEXT";
    private final static String ACTORS_EXTRA_TEXT =
                            "com.main.java.matik.add_delete_user_recyclerview_ACTORS_EXTRA_TEXT";
    private final static String ACTORS_AGES_EXTRA_TEXT =
            "com.main.java.matik.add_delete_user_recyclerview_ACTORS_AGES_EXTRA_TEXT";
    private final static String MOVIE_IMAGES_IDS_EXTRA_TEXT =
            "com.main.java.matik.add_delete_user_recyclerview_MOVIE_IMAGES_IDS_EXTRA_TEXT ";
    private final static String ACTORS_IMAGES_IDS_EXTRA_TEXT =
            "com.main.java.matik.add_delete_user_recyclerview_ACTOR_IMAGES_IDS_EXTRA_TEXT ";

    public static void startMovieActivity(Context context, String movieName, String categoryName,
                                          String [] actorsNames, Integer [] actorsAges,
                                          Integer [] movieImagesIDs, Integer [] actorsImagesIDs) {
        Intent starter = new Intent(context, MovieActivity.class);
        String [] extraKeys = {MOVIE_EXTRA_TEXT, CATEGORY_EXTRA_TEXT, ACTORS_EXTRA_TEXT,
                                ACTORS_AGES_EXTRA_TEXT, MOVIE_IMAGES_IDS_EXTRA_TEXT,
                                ACTORS_IMAGES_IDS_EXTRA_TEXT};
        starter.putExtra(Intent.EXTRA_TEXT, extraKeys);
        starter.putExtra(MOVIE_EXTRA_TEXT, movieName);
        starter.putExtra(CATEGORY_EXTRA_TEXT, categoryName);
        starter.putStringArrayListExtra(ACTORS_EXTRA_TEXT,
                                        new ArrayList<>(Arrays.asList(actorsNames)));
        starter.putIntegerArrayListExtra(ACTORS_AGES_EXTRA_TEXT,
                                        new ArrayList<>(Arrays.asList(actorsAges)));
        starter.putIntegerArrayListExtra(MOVIE_IMAGES_IDS_EXTRA_TEXT,
                                        new ArrayList<>(Arrays.asList(movieImagesIDs)));
        starter.putIntegerArrayListExtra(ACTORS_IMAGES_IDS_EXTRA_TEXT,
                                        new ArrayList<>(Arrays.asList(actorsImagesIDs)));
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeRecView();
        initializeItemTouchHelper(mAdapter);
    }


    public void initializeRecView(){
        mRecyclerView = findViewById(R.id.movies_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MovieAdapter(this,
                                        new LinkedList<>(Arrays.asList(movies)),
                                        new LinkedList<>(
                                                Arrays.asList(getMoviesPostersIdsByMovieName())));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnClick(this);

    }

    private Integer [] getMovieImagesIdsByMovieName(String name){
        name = name.replaceAll("\\s+","");
        name = name.toLowerCase();
        Field[] fields = R.drawable.class.getFields();
        List<Integer> drawables = new ArrayList<>();
        for (Field field : fields) {
            // Take only those with name starting with movie title
            if (field.getName().startsWith(name)) {
                try {
                    drawables.add(field.getInt(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return drawables.toArray(new Integer[drawables.size()]);
    }

    private Integer [] getMoviesActorsImagesIdsByMovieName(Movie movie, Context context) {
        String[] actorsNames = movie.getActorsNames();
        Integer[] actorsImagesIDs = new Integer[actorsNames.length];
        for (int i = 0; i < actorsNames.length; i++) {
            String name = actorsNames[i].replaceAll("\\s+", "");
            name = name.toLowerCase();
            actorsImagesIDs[i] = context.getResources().getIdentifier(name,
                    "drawable",
                    context.getPackageName());
        }
        return actorsImagesIDs;
    }

    private Integer [] getMoviesPostersIdsByMovieName(){
        Integer [] moviesPosterId = new Integer[movies.length];
        for (int i=0;i<movies.length;i++){
            moviesPosterId[i] = getMovieImagesIdsByMovieName
                                (movies[i].getTitle())[POSTER_POSITION_IN_IMAGES_ARRAY];
        }
        return moviesPosterId;
    }

    @Override
    public void onItemClick(int position) {
        startMovieActivity(this, movies[position].getTitle(),
                movies[position].getCategoryName(), movies[position].getActorsNames(),
                movies[position].getActorsAges(),
                getMovieImagesIdsByMovieName(movies[position].getTitle()),
                getMoviesActorsImagesIdsByMovieName(movies[position], this));
    }

    public void initializeItemTouchHelper(final MovieAdapter adapter) {
        ItemTouchHelper.SimpleCallback itemTouchHelperSimpleCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        Movie [] temp = new Movie[movies.length-1];
                        System.arraycopy(movies, 0,
                                temp, 0,viewHolder.getAdapterPosition());
                        System.arraycopy(movies, viewHolder.getAdapterPosition()+1,
                                temp, viewHolder.getAdapterPosition(),
                                temp.length - viewHolder.getAdapterPosition());
                        movies = temp;
                        adapter.removeAt(viewHolder.getAdapterPosition());

                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperSimpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }

}
