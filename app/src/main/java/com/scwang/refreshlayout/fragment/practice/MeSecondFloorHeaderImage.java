package com.scwang.refreshlayout.fragment.practice;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.scwang.refreshlayout.R;

import pl.droidsonroids.gif.GifImageView;

/**
 * @author wupuquan
 * @version 1.0
 * @since 2018/10/11 11:28
 */
public class MeSecondFloorHeaderImage extends LinearLayout {

    public MeSecondFloorHeaderImage(Context context) {
        this(context, null);
    }

    public MeSecondFloorHeaderImage(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MeSecondFloorHeaderImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 背景渐变
        setGradientBackground();
        // 底部居中
        setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        // padding
        setPadding(0, 0, 0, 100);
        // gif
        addGif();
    }

    /**
     * 设置渐变背景
     */
    private void setGradientBackground() {
        int colors[] = {0xFFFFFFFF, 0xFFF0FFFF};
        GradientDrawable bg = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            setBackgroundDrawable(bg);
        } else {
            setBackground(bg);
        }
    }

    /**
     * 添加gif图
     */
    private void addGif() {
        GifImageView imageView = new GifImageView(getContext());
        imageView.setImageResource(R.mipmap.gif_header_repast);
        addView(imageView);
    }
}
