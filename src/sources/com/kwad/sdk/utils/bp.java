package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bp {
    private View aRb;
    public Point aRa = new Point();
    public Rect aQY = new Rect();
    public Rect aQZ = new Rect();

    public bp(View view) {
        this.aRb = view;
    }

    public final boolean Nr() {
        boolean globalVisibleRect = this.aRb.getGlobalVisibleRect(this.aQY, this.aRa);
        Point point = this.aRa;
        if (point.x == 0 && point.y == 0 && this.aQY.height() == this.aRb.getHeight() && this.aQZ.height() != 0 && Math.abs(this.aQY.top - this.aQZ.top) > this.aRb.getHeight() / 2) {
            this.aQY.set(this.aQZ);
        }
        this.aQZ.set(this.aQY);
        return globalVisibleRect;
    }
}
