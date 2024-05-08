package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.ly;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class LinkedSurfaceView extends RelativeLayout implements ly {
    private int B;
    private int I;
    private BaseGlVideoView V;

    public LinkedSurfaceView(Context context) {
        super(context);
        Code(context);
    }

    public LinkedSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public LinkedSurfaceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    private void Code(Context context) {
        this.V = Build.VERSION.SDK_INT >= 26 ? new SurfaceVideoView(context) : new TextureGlVideoView(context);
        addView(this.V, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void Code(float f10, float f11, float f12, int i10, int i11) {
        super.setScaleY(f10);
        super.setTranslationY(f11);
        super.setScaleX(f12);
        this.B = i11;
        this.I = i10;
        if (this.V.getVideoHeight() == 0 || i11 == 0) {
            return;
        }
        this.V.Code(i10, i11);
        this.V.Code((r2.getVideoWidth() * 1.0f) / this.V.getVideoHeight(), (i10 * 1.0f) / i11, i10, i11);
    }

    public void Code(float f10, float f11, int i10, int i11) {
        this.V.Code(f10, f11, i10, i11);
    }

    public void Z() {
        this.V.destroyView();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        gl.V("LinkedSurfaceView", "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        gl.V("LinkedSurfaceView", "onDetachedFromWindow");
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.B == 0 && this.I == 0) {
            this.I = i12 - i10;
            this.B = i13 - i11;
        }
        if (this.V.getVideoHeight() == 0 || (i14 = this.B) == 0) {
            return;
        }
        this.V.Code(this.I, i14);
        int i15 = this.I;
        int i16 = this.B;
        this.V.Code((r2.getVideoWidth() * 1.0f) / this.V.getVideoHeight(), (i15 * 1.0f) / i16, i15, i16);
    }

    public void setAutoScaleResizeLayoutOnVideoSizeChange(boolean z10) {
        this.V.setAutoScaleResizeLayoutOnVideoSizeChange(z10);
    }

    public void setNeedPauseOnSurfaceDestory(boolean z10) {
        this.V.setNeedPauseOnSurfaceDestory(z10);
    }

    public void setScreenOnWhilePlaying(boolean z10) {
        this.V.setScreenOnWhilePlaying(z10);
    }

    public void setVideoRatio(Float f10) {
        this.V.setVideoRatio(f10);
    }

    public void setVideoScaleMode(int i10) {
        this.V.setVideoScaleMode(i10);
    }
}
