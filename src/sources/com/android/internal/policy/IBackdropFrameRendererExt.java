package com.android.internal.policy;

import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IBackdropFrameRendererExt {
    default void drawDarkModeBackground(DecorView decorView, Drawable drawable, int lastCaptionHeight, int top, int left, int height, int width, RecordingCanvas canvas, RenderNode renderNode) {
    }

    default void checkSystemBarForceDark(DecorView decorView, RenderNode systemBarBackgroundNode) {
    }
}
