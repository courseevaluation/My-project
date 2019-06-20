package com.example.course_evaluation.customcomponent;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.course_evaluation.R;

public class SquareImageView extends android.support.v7.widget.AppCompatImageView {
    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
    protected int hr=1,wr=1;

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getWr() {
        return wr;
    }

    public void setWr(int wr) {
        this.wr = wr;
    }
}