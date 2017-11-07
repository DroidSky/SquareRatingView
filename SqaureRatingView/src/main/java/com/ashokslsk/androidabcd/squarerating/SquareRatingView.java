package com.ashokslsk.androidabcd.squarerating;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatRatingBar;
import android.util.AttributeSet;

/**
 * Created by ashok.kumar on 07/11/17.
 */

public class SquareRatingView extends AppCompatRatingBar {


    private int[] iconArrayActive =  {
            R.drawable.ic_square_sel,
            R.drawable.ic_square_sel,
            R.drawable.ic_square_sel,
            R.drawable.ic_square_sel,
            R.drawable.ic_square_sel,
            R.drawable.ic_square_sel,
            R.drawable.ic_square_sel,
            R.drawable.ic_square_sel,
            R.drawable.ic_square_sel,
            R.drawable.ic_square_sel

    };

    private int[] iconArrayInactive =  {
            R.drawable.ic_square_unsel,
            R.drawable.ic_square_unsel,
            R.drawable.ic_square_unsel,
            R.drawable.ic_square_unsel,
            R.drawable.ic_square_unsel,
            R.drawable.ic_square_unsel,
            R.drawable.ic_square_unsel,
            R.drawable.ic_square_unsel,
            R.drawable.ic_square_unsel,
            R.drawable.ic_square_unsel
    };

    public SquareRatingView(Context context) {
        super(context);
        init();
    }

    public SquareRatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SquareRatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setMax(10);
        this.setNumStars(10);
        this.setStepSize(1.0f);
        this.setRating(1.0f);
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
                bitmap = getBitmapFromVectorDrawable(getContext(), iconArrayActive[i]);
            } else {
                bitmap = getBitmapFromVectorDrawable(getContext(), iconArrayInactive[i]);
            }
            x = offset+(i*delta);
            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, icon_size, icon_size, true);
            canvas.drawBitmap(scaled, x, y_pos, paint);
            canvas.save();
        }
    }


}
