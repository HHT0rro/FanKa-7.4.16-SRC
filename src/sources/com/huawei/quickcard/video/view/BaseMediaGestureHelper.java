package com.huawei.quickcard.video.view;

import android.content.Context;
import android.view.MotionEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class BaseMediaGestureHelper {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface MediaGestureChangeListener {
        void onBrightnessChange(float f10, float f11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface MediaGestureHelperHoster {
        boolean canChangePosition();

        boolean canSeek();

        int getCurrentPosition();

        int getDuration();

        int getHosterMeasuredHeight();

        int getHosterMeasuredWidth();

        boolean isGestureEffective();

        void requestHosterDisallowInterceptTouchEvent(boolean z10);

        void setSeekValue(int i10);
    }

    public BaseMediaGestureHelper(Context context, MediaGestureHelperHoster mediaGestureHelperHoster) {
    }

    public abstract boolean onTouch(MotionEvent motionEvent);

    public abstract void setGestureChangeListener(MediaGestureChangeListener mediaGestureChangeListener);

    public abstract void setOtherParams(Object obj);
}
