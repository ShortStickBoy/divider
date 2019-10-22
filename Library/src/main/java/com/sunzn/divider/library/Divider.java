package com.sunzn.divider.library;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class Divider extends RecyclerView.ItemDecoration {

    public enum Sort {
        DP, PX
    }

    private Context mContext;

    private Drawable mDivider;

    public Context getContext() {
        return mContext;
    }

    public Drawable getDivider() {
        return mDivider;
    }

    public Divider(Context context, int res) {
        mContext = context;
        initDivider(res);
    }

    private void initDivider(int resId) {
        mDivider = mContext.getResources().getDrawable(resId);
        if (mDivider instanceof ColorDrawable) {
            onColorDrawable(1);
        }
    }

    public abstract void onColorDrawable(int height);

    public abstract void onGetItemOffsets(Rect outRect);

    public abstract void onDrawDivider(Canvas c, RecyclerView parent);

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        onDrawDivider(c, parent);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        onGetItemOffsets(outRect);
    }

    public static int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

}
