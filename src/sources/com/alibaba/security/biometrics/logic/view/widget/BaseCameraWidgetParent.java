package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.logic.view.custom.CameraGLSurfaceView;
import com.alibaba.security.common.utils.DisplayUtils;
import java.text.DecimalFormat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseCameraWidgetParent extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    private static final String f2485b = "BaseCameraWidgetParent";

    /* renamed from: a, reason: collision with root package name */
    public CameraGLSurfaceView f2486a;

    public BaseCameraWidgetParent(Context context) {
        super(context);
    }

    private static void d() {
    }

    public final void a(int i10, int i11, int i12, boolean z10) {
        float parseFloat;
        DecimalFormat decimalFormat = new DecimalFormat("#0");
        if (!z10) {
            parseFloat = Float.parseFloat(decimalFormat.format(DisplayUtils.getWidth(getContext())));
        } else {
            parseFloat = Float.parseFloat(decimalFormat.format(DisplayUtils.getDisplayCircleRadius(getContext()) * 2.0f));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2486a.getLayoutParams();
        float parseFloat2 = (Float.parseFloat(decimalFormat.format(i10)) / Float.parseFloat(decimalFormat.format(i11))) * parseFloat;
        int i13 = (int) parseFloat;
        layoutParams.width = i13;
        layoutParams.height = (int) parseFloat2;
        layoutParams.gravity = 49;
        layoutParams.topMargin = i12 - (i13 / 2);
        this.f2486a.setLayoutParams(layoutParams);
    }

    public final void b() {
        CameraGLSurfaceView cameraGLSurfaceView = this.f2486a;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.onPause();
        }
    }

    public final void c() {
        CameraGLSurfaceView cameraGLSurfaceView = this.f2486a;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.onResume();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2486a = (CameraGLSurfaceView) findViewById(R.id.abfl_widget_camera_surface);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f2486a.setRenderer(renderer);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        this.f2486a.setVisibility(i10);
        super.setVisibility(i10);
    }

    public BaseCameraWidgetParent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseCameraWidgetParent(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public final void a() {
        CameraGLSurfaceView cameraGLSurfaceView = this.f2486a;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.requestRender();
        }
    }

    public final void a(Runnable runnable) {
        CameraGLSurfaceView cameraGLSurfaceView = this.f2486a;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.queueEvent(runnable);
        }
    }
}
