package com.example.a2ramae45.android5ui;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        NavigationView nView = (NavigationView)findViewById(R.id.navigationView);
        final DrawerLayout dLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        nView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                String what = "";
                switch (item.getItemId()) {
                    case R.id.save:
                        what = "SAVE";
                        break;

                    case R.id.load:
                        what = "LOAD";
                        break;
                }
                new AlertDialog.Builder(MainActivity.this).setPositiveButton("OK", null).setMessage(what).show();
                dLayout.closeDrawers();
                return true;

            }

    });
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView sv = (SearchView) MenuItemCompat.getActionView(item);
        sv.setOnQueryTextListener(new SearchHandler());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab1);
        fab.setOnClickListener (new View.OnClickListener() {

            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setPositiveButton("OK", null).
                        setMessage("The FloatingActionButton was clicked!").show();
            }
        });
        return true;

    }



    public  boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.save) {
            new AlertDialog.Builder(this).setPositiveButton("OK", null).
                    setMessage("Saving...").show();
            return true;
        }

        if(item.getItemId() == R.id.load) {
            new AlertDialog.Builder(this).setPositiveButton("OK", null).setMessage("Settings/Load...").show();
        }


        return false;
    }



    class SearchHandler implements SearchView.OnQueryTextListener {

        public SearchHandler() {
        }
        public boolean onQueryTextChange(String txt) {
            return true;
        }
        public boolean onQueryTextSubmit(String txt) {
            new AlertDialog.Builder(MainActivity.this).setPositiveButton("OK", null).setMessage("Searching").show();
                    return true;
        }

    }






}
