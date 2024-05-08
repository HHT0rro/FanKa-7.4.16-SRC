package com.tencent.turingcam.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ShGzN extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    private spXPg f45464a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f45465b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface spXPg {
        void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11);

        boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);
    }

    public ShGzN(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView
    public Bitmap getBitmap() {
        if (this.f45465b.get()) {
            return super.getBitmap();
        }
        return null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        spXPg spxpg = this.f45464a;
        if (spxpg != null) {
            spxpg.onSurfaceTextureAvailable(surfaceTexture, i10, i11);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f45465b.set(false);
        spXPg spxpg = this.f45464a;
        if (spxpg != null) {
            spxpg.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f45465b.set(true);
    }

    public ShGzN(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f45465b = new AtomicBoolean(false);
        a();
    }

    public void a(spXPg spxpg) {
        this.f45464a = spxpg;
    }
}
