package com.androidabcd.ashokslsk.squareratingview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.Toast;

import com.ashokslsk.androidabcd.squarerating.SquareRatingView;

public class MainActivity extends AppCompatActivity {

    SquareRatingView mRatingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRatingView = (SquareRatingView) findViewById(R.id.square);
        mRatingView.setNumStars(0);

        mRatingView.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Toast.makeText(MainActivity.this, ratingBar.getRating()+"", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
