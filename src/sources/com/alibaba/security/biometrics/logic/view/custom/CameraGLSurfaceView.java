package com.alibaba.security.biometrics.logic.view.custom;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CameraGLSurfaceView extends GLSurfaceView {
    public CameraGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
    }

    private void a() {
        setEGLContextClientVersion(2);
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEGLContextClientVersion(2);
    }
}
