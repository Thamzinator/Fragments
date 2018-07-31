package com.example.tcssi.fragments.Calendar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tcssi.fragments.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import com.example.tcssi.fragments.Utils.BottomNavigationViewHelper;

public class CalendarActivity extends AppCompatActivity {

    private static final String TAG = "CalandarActivity";
    private static final int ACTIVITY_NUM = 1;
    private Context mContext = CalendarActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");

        setupBottomNavigationView();
    }

    /**
     *  BottomNavigationView setup
     */

    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}

