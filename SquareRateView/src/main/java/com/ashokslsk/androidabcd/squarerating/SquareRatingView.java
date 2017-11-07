package com.ashokslsk.androidabcd.squarerating;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashok.kumar on 07/11/17.
 */

public class SquareRatingView extends AppCompatRatingBar {

    private List<Integer> inActive = new ArrayList<>();
    private List<Integer> Active = new ArrayList<>();


    public SquareRatingView(Context context) {
        super(context);
        init(context,null);
    }

    public SquareRatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public SquareRatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ratevalue=getContext().obtainStyledAttributes(
                attrs,
                R.styleable.SquareRating);

        int max = ratevalue.getInteger(R.styleable.SquareRating_setMax, 5);
        int NumStars = ratevalue.getInteger(R.styleable.SquareRating_setNumSquare, 5);
        Float Stepsize = ratevalue.getFloat(R.styleable.SquareRating_setStepSize, 0.5f);
        Float Rating = ratevalue.getFloat(R.styleable.SquareRating_setRating, 0.0f);
        int Selected = ratevalue.getResourceId(R.styleable.SquareRating_setSelectedResource, R.drawable.ic_square_sel);
        int UnSelected = ratevalue.getResourceId(R.styleable.SquareRating_setUnSelectedResource, R.drawable.ic_square_unsel);

            for (int i = 0; i <NumStars ; i++) {
                Active.add(Selected);
                inActive.add(UnSelected);
            }


        this.setMax(max);
        this.setNumStars(NumStars);
        this.setStepSize(Stepsize);
        this.setRating(Rating);

        ratevalue.recycle();
    }

    private Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {

        int stars = getNumStars();
        float rating = getRating();
        float x = 0;

        Bitmap bitmap;
        Paint paint = new Paint();
        int W = getWidth();
        int H = getHeight();
        int icon_size = (W/stars)-0;

        int y_pos = (H/2)-icon_size/2;

        int delta = ((H > W)?(H):(W))/(stars);
        int offset = (W-(icon_size+(stars-1)*delta))/2;

        for(int i = 0; i < stars; i++) {
            if ((int) rating-1 >= i) {
                bitmap = getBitmapFromVectorDrawable(getContext(), Active.get(i));
            } else {
                bitmap = getBitmapFromVectorDrawable(getContext(), inActive.get(i));
            }
            x = offset+(i*delta);
            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, icon_size, icon_size, true);
            canvas.drawBitmap(scaled, x, y_pos, paint);
            canvas.save();
        }
    }


}
