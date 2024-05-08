package com.zego.ve;

import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VTextureViewListener implements TextureView.SurfaceTextureListener {
    private static final String TAG = "VTextureViewListener";
    private long pthis = 0;
    private TextureView mView = null;
    private final Object lock = new Object();

    private static native int on_surface_texture_changed(long j10, SurfaceTexture surfaceTexture, int i10, int i11);

    private static native int on_surface_texture_created(long j10, SurfaceTexture surfaceTexture, int i10, int i11);

    private static native int on_surface_texture_destroyed(long j10, SurfaceTexture surfaceTexture);

    public boolean isAvailable() {
        TextureView textureView = this.mView;
        return textureView != null && textureView.isAvailable();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        synchronized (this.lock) {
            if (this.pthis != 0) {
                surfaceTexture.setDefaultBufferSize(i10, i11);
                on_surface_texture_created(this.pthis, surfaceTexture, i10, i11);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        synchronized (this.lock) {
            long j10 = this.pthis;
            if (j10 != 0) {
                on_surface_texture_destroyed(j10, surfaceTexture);
            }
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        synchronized (this.lock) {
            long j10 = this.pthis;
            if (j10 != 0) {
                on_surface_texture_changed(j10, surfaceTexture, i10, i11);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public int setThis(long j10, TextureView textureView) {
        synchronized (this.lock) {
            TextureView textureView2 = this.mView;
            if (textureView2 != null && textureView2.getSurfaceTextureListener().equals(this)) {
                this.mView.setSurfaceTextureListener(null);
            }
            if (textureView != null) {
                textureView.setSurfaceTextureListener(this);
            }
            this.pthis = j10;
            this.mView = textureView;
        }
        return 0;
    }
}
