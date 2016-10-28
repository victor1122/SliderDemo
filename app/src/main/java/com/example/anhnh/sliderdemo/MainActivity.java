package com.example.anhnh.sliderdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    SwipeAdapter swipeAdapter;
    private LinearLayout dotsLayout;
    private Context context;
    TextView[] dots;
    int[] colorsInactive;
    int[] colorsActive ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getApplicationContext();
        //Show slider
        viewPager = (ViewPager) findViewById(R.id.view_paper);
        swipeAdapter = new SwipeAdapter(this);
        viewPager.setAdapter(swipeAdapter);
        //set color array for dots and dots array size, must be put before call addBottomDots to prevent null
        colorsInactive = viewPager.getResources().getIntArray(R.array.array_dot_inactive);
        colorsActive = viewPager.getResources().getIntArray(R.array.array_dot_active);
        dots = new TextView[colorsActive.length];
        //create dots at bottom
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        addBottomDots(context);
        //set action for dot state change
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setActive(position, 5, dots);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void addBottomDots(Context context) {
        if (dotsLayout != null) {
            dotsLayout.removeAllViews();
        }
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
    }

    private void setActive(int position, int length, TextView[] dot){
        for (int i = 0; i < dots.length; i++) {
            dots[i].setTextColor(colorsInactive[position]);
            if (dots.length > 0)
                dots[position].setTextColor(colorsActive[position]);
        }
    }
}
