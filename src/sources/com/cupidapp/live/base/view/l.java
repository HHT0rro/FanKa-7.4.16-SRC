package com.cupidapp.live.base.view;

import android.view.MotionEvent;
import android.view.View;
import org.jetbrains.annotations.Nullable;

/* compiled from: PressEffectListener.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View view, @Nullable MotionEvent motionEvent) {
        boolean z10 = true;
        if ((view == null || view.isEnabled()) ? false : true) {
            return false;
        }
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf == null || valueOf.intValue() != 0) {
            if ((valueOf == null || valueOf.intValue() != 1) && (valueOf == null || valueOf.intValue() != 3)) {
                z10 = false;
            }
            if (z10 && view != null) {
                view.setAlpha(1.0f);
            }
        } else if (view != null) {
            view.setAlpha(0.5f);
        }
        return false;
    }
}
