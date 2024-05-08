package com.qq.e.ads.nativ.widget;

import android.view.MotionEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z10);

    void onWindowVisibilityChanged(int i10);
}
