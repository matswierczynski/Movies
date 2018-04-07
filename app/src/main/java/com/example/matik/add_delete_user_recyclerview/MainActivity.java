package com.example.matik.add_delete_user_recyclerview;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
    private final static String MOVIE_EXTRA_TEXT =
                            "com.main.java.matik.add_delete_user_recyclerview_MOVIE_EXTRA_TEXT";
    private final static String CATEGORY_EXTRA_TEXT =
                            "com.main.java.matik.add_delete_user_recyclerview_CATEGORY_EXTRA_TEXT";
    private final static String ACTORS_EXTRA_TEXT =
                            "com.main.java.matik.add_delete_user_recyclerview_ACTORS_EXTRA_TEXT";

    public static void start(Context context, String movieName, String categoryName,
                             String [] actorsNames) {
        Intent starter = new Intent(context, MovieActivity.class);
        String [] extraKeys = {MOVIE_EXTRA_TEXT, CATEGORY_EXTRA_TEXT, ACTORS_EXTRA_TEXT};
        starter.putExtra(Intent.EXTRA_TEXT, extraKeys);
        starter.putExtra(MOVIE_EXTRA_TEXT, movieName);
        starter.putExtra(CATEGORY_EXTRA_TEXT, categoryName);
        starter.putStringArrayListExtra(ACTORS_EXTRA_TEXT,
                                        new ArrayList<>(Arrays.asList(actorsNames)));
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
                                        new LinkedList<>(Arrays.asList(movies) ));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnClick(this);

    }

    @Override
    public void onItemClick(int position) {
        start(this, movies[position].getTitle(),
                movies[position].getCategoryName(), movies[position].getActorsNames());
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
                        adapter.removeAt(viewHolder.getAdapterPosition());

                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperSimpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }

}
