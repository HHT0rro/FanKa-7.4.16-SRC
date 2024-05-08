package com.android.internal.policy;

import android.graphics.Rect;
import android.view.animation.ClipRectAnimation;
import android.view.animation.Transformation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ClipRectLRAnimation extends ClipRectAnimation {
    public ClipRectLRAnimation(int fromL, int fromR, int toL, int toR) {
        super(fromL, 0, fromR, 0, toL, 0, toR, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.ClipRectAnimation, android.view.animation.Animation
    public void applyTransformation(float it, Transformation tr) {
        Rect oldClipRect = tr.getClipRect();
        tr.setClipRect(this.mFromRect.left + ((int) ((this.mToRect.left - this.mFromRect.left) * it)), oldClipRect.top, this.mFromRect.right + ((int) ((this.mToRect.right - this.mFromRect.right) * it)), oldClipRect.bottom);
    }
}
