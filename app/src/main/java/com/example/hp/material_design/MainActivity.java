package com.example.hp.material_design;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

// Creating a string array and adding elements into it .
    private String [] versions = {"Alpha", "Beta", "CupCake", "Donut", "Eclair", "Froyo", "Gingerbread",
            "Honeycomb", "Ice Cream Sandwich", "Jellybean", "Kitkat","Lollipop"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //A Toolbar is a generalization of action bars for use within application layouts.
        // Creating and initializing object by ID
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        /*
          * A floating action button represents the primary action in an application.
          * A floating action button is used for a promoted action.
         */
        // Creating and initializing object by ID
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        toolbar.setTitleTextColor(Color.WHITE);
        // setSupportActionBar() method will set the toolbar as the app bar for the activity.
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() { // onClickListener method
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Floating Action Button", // Toast Message
                        Toast.LENGTH_LONG).show();

            }
        });

        /*
          * RecyclerView is a flexible view for providing a limited window into a large data set.
          *
         */
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view); // Creating abject

        /*
          setHasFixedSize() method is used to to prevent the Collapsing ToolbarLayout.
          This allows the RecyclerView to optimize better by figuring out the exact height and width
          of the entire list based on the your adapter.
         */
        recyclerView.setHasFixedSize(true);

        /*
         RecyclerView.LayoutManager is responsible for measuring and positioning item views within
         a RecyclerView as well as determining the policy for when to recycle item views that
         are no longer visible to the user.
         */
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);// Creating object
        recyclerView.setLayoutManager(layoutManager); //Enable or disable layout and scroll


        // RecyclerView.Adapter responsible for providing views that represent items in a data set.
        RecyclerView.Adapter adapter = new View_holder(versions);
        recyclerView.setAdapter(adapter); // Display items in the list.
    }

    @Override
    // Creating method it will specify the options menu for an activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);//getMenuInflater() returns an object
        return super.onCreateOptionsMenu(menu);
    }
}
