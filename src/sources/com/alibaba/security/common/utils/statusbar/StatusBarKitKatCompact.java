package com.alibaba.security.common.utils.statusbar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class StatusBarKitKatCompact {
    private static final String TAG_FAKE_STATUS_BAR_VIEW = "statusBarView";
    private static final String TAG_MARGIN_ADDED = "marginAdded";

    private static View addFakeStatusBarView(Activity activity, int i10, int i11) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i11);
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i10);
        view.setTag(TAG_FAKE_STATUS_BAR_VIEW);
        viewGroup.addView(view);
        return view;
    }

    private static void addMarginTopToContentChild(View view, int i10) {
        if (view == null || TAG_MARGIN_ADDED.equals(view.getTag())) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin += i10;
        view.setLayoutParams(layoutParams);
        view.setTag(TAG_MARGIN_ADDED);
    }

    private static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    private static void removeFakeStatusBarViewIfExist(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag(TAG_FAKE_STATUS_BAR_VIEW);
        if (findViewWithTag != null) {
            viewGroup.removeView(findViewWithTag);
        }
    }

    private static void removeMarginTopOfContentChild(View view, int i10) {
        if (view != null && TAG_MARGIN_ADDED.equals(view.getTag())) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin -= i10;
            view.setLayoutParams(layoutParams);
            view.setTag(null);
        }
    }

    public static void setStatusBarColor(Activity activity, int i10) {
        Window window = activity.getWindow();
        window.addFlags(67108864);
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        int statusBarHeight = getStatusBarHeight(activity);
        removeFakeStatusBarViewIfExist(activity);
        addFakeStatusBarView(activity, i10, statusBarHeight);
        addMarginTopToContentChild(childAt, statusBarHeight);
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
        }
    }

    public static void translucentStatusBar(Activity activity) {
        activity.getWindow().addFlags(67108864);
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        removeFakeStatusBarViewIfExist(activity);
        removeMarginTopOfContentChild(childAt, getStatusBarHeight(activity));
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
        }
    }
}
