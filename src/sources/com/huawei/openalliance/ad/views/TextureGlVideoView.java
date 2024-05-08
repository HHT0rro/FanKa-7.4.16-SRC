package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.splash.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TextureGlVideoView extends BaseGlVideoView {

    /* renamed from: q, reason: collision with root package name */
    private final int f33017q;

    /* renamed from: r, reason: collision with root package name */
    private SurfaceTexture f33018r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f33019s;

    /* renamed from: t, reason: collision with root package name */
    private Surface f33020t;

    public TextureGlVideoView(Context context) {
        super(context);
        this.f33017q = hashCode();
        this.f33019s = false;
    }

    public TextureGlVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33017q = hashCode();
        this.f33019s = false;
    }

    public TextureGlVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f33017q = hashCode();
        this.f33019s = false;
    }

    private void i() {
        Surface surface = this.f33020t;
        if (surface != null) {
            surface.release();
            this.f33020t = null;
        }
        SurfaceTexture surfaceTexture = this.f33018r;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f33018r = null;
        }
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_view_video, this);
        TextureView textureView = (TextureView) findViewById(R.id.hiad_id_video_texture_view);
        this.f32638b = textureView;
        textureView.setSurfaceTextureListener(this);
    }

    @Override // com.huawei.openalliance.ad.views.BaseGlVideoView
    public String getLogTag() {
        return "TextureGlVideoView" + this.f33017q;
    }

    public boolean h() {
        return this.f33019s;
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        gl.V(getLogTag(), "onAttachedToWindow");
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        gl.V(getLogTag(), "onDetachedFromWindow");
        i();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        this.f33019s = true;
        i();
        this.f33018r = surfaceTexture;
        Surface surface = new Surface(surfaceTexture);
        this.f33020t = surface;
        Code(surface);
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f33019s = false;
        i();
        return true;
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        V(i10, i11);
    }
}
