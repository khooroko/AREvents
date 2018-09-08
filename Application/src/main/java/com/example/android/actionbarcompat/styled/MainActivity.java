/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.actionbarcompat.styled;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;


import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import com.example.android.actionbarcompat.styled.db_connection.DatabaseComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * This sample shows you how to use ActionBarCompat with a customized theme. It utilizes a split
 * action bar when running on a device with a narrow display, and show three tabs.
 *
 * This Activity extends from {@link AppCompatActivity}, which provides all of the function
 * necessary to display a compatible Action Bar on devices running Android v2.1+.
 *
 * The interesting bits of this sample start in the theme files
 * ('res/values/styles.xml' and 'res/values-v14</styles.xml').
 *
 * Many of the drawables used in this sample were generated with the
 * 'Android Action Bar Style Generator': http://jgilfelt.github.io/android-actionbarstylegenerator
 */
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

//    private List<Event> eventList = new ArrayList<>();
//    private RecyclerView recyclerView;
//    private EventsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);

        // Set the Action Bar to use tabs for navigation
        ActionBar ab = getSupportActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Add three tabs to the Action Bar for display
        ab.addTab(ab.newTab().setText("Tab 1").setTabListener(this));
        ab.addTab(ab.newTab().setText("Tab 2").setTabListener(this));
        ab.addTab(ab.newTab().setText("Tab 3").setTabListener(this));

//        DatabaseComponent databaseComponent = new DatabaseComponent();
//        databaseComponent.test_addDummyEventData();
//        databaseComponent.getEvents();

//        prepareEventData();     // Sample Events to test RecyclerView
    }


//    private void prepareEventData() {
//        Event event = new Event("Test Event 1", "DATE", "START_TIME", "END_TIME", "PLACE");
//        eventList.add(event);
//
//        event = new Event("Test Event 2", "DATE", "START_TIME", "END_TIME", "PLACE");
//        eventList.add(event);
//    }
//
//    private void clearEventData() {
//        eventList.clear();
//    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu from menu resource (res/menu/main)
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }
*/
    // Implemented from ActionBar.TabListener
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // This is called when a tab is selected.

        if (tab.getText().equals("Tab 1")) {
            setContentView(R.layout.sample_main);

//            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//
//            mAdapter = new EventsAdapter(eventList);
//            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//            recyclerView.setLayoutManager(mLayoutManager);
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
//            recyclerView.setAdapter(mAdapter);
        }

        if (tab.getText().equals("Tab 2")) {
            setContentView(R.layout.tab2);
            switchToMaps();
        }

        if (tab.getText().equals("Tab 3")) {
            setContentView(R.layout.tab3);
        }
    }

    // Implemented from ActionBar.TabListener
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // This is called when a previously selected tab is unselected.
    }

    // Implemented from ActionBar.TabListener
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // This is called when a previously selected tab is selected again.
    }

    public void switchToMaps() {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }
}
