package com.scwang.refreshlayout.fragment.practice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;

/**
 * "我的"下拉进入二楼蛋壳日常
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class MeSecondFloorHeader extends InternalClassics<MeSecondFloorHeader> implements RefreshHeader {

    public static String REFRESH_HEADER_PULLING = null; //"下拉刷新";
    public static String REFRESH_HEADER_REFRESHING = null; //"刷新中...";
    public static String REFRESH_HEADER_LOADING = null; //"加载中...";
    public static String REFRESH_HEADER_RELEASE = null; //"释放即可刷新";
    public static String REFRESH_HEADER_FINISH = null; //"刷新完成";
    public static String REFRESH_HEADER_FAILED = null; //"刷新失败";
    public static String REFRESH_HEADER_SECONDARY = null; //"继续下拉进入二楼";

    public MeSecondFloorHeader(Context context) {
        this(context, null);
    }

    public MeSecondFloorHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MeSecondFloorHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (REFRESH_HEADER_PULLING == null) {
            REFRESH_HEADER_PULLING = "下拉刷新";
        }
        if (REFRESH_HEADER_REFRESHING == null) {
            REFRESH_HEADER_REFRESHING = "刷新中...";
        }
        if (REFRESH_HEADER_LOADING == null) {
            REFRESH_HEADER_LOADING = "加载中...";
        }
        if (REFRESH_HEADER_RELEASE == null) {
            REFRESH_HEADER_RELEASE = "释放即可刷新";
        }
        if (REFRESH_HEADER_FINISH == null) {
            REFRESH_HEADER_FINISH = "刷新完成";
        }
        if (REFRESH_HEADER_FAILED == null) {
            REFRESH_HEADER_FAILED = "刷新失败";
        }
        if (REFRESH_HEADER_SECONDARY == null) {
            REFRESH_HEADER_SECONDARY = "继续下拉，有惊喜哦";
        }

        // 文字颜色
        setAccentColor(0xFF3dbcc6);
    }

    @Override
    public int onFinish(@NonNull RefreshLayout layout, boolean success) {
        if (success) {
            mTitleText.setText(REFRESH_HEADER_FINISH);
        } else {
            mTitleText.setText(REFRESH_HEADER_FAILED);
        }
        return super.onFinish(layout, success); // 延迟500毫秒之后再弹回
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownToRefresh:
                mTitleText.setText(REFRESH_HEADER_PULLING);
                break;
            case Refreshing:
            case RefreshReleased:
                mTitleText.setText(REFRESH_HEADER_REFRESHING);
                break;
            case ReleaseToRefresh:
                mTitleText.setText(REFRESH_HEADER_RELEASE);
                break;
            case ReleaseToTwoLevel:
                mTitleText.setText(REFRESH_HEADER_SECONDARY);
                break;
            case Loading:
                mTitleText.setText(REFRESH_HEADER_LOADING);
                break;
        }
    }

}
