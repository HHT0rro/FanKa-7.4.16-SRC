package com.autonavi.base.amap.api.mapcore;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.amap.api.col.p0003l.dh;
import com.amap.api.col.p0003l.di;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IGLSurfaceView {
    int getHeight();

    SurfaceHolder getHolder();

    ViewParent getParent();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    void onDetachedGLThread();

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j10);

    void queueEvent(Runnable runnable);

    void requestRender();

    void setBackgroundColor(int i10);

    void setEGLConfigChooser(dh dhVar);

    void setEGLContextFactory(di diVar);

    void setRenderMode(int i10);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setVisibility(int i10);

    void setZOrderOnTop(boolean z10);
}
