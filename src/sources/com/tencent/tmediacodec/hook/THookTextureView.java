package com.tencent.tmediacodec.hook;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class THookTextureView extends TextureView {

    /* renamed from: a, reason: collision with root package name */
    private static a f45371a;

    /* renamed from: b, reason: collision with root package name */
    private TextureView.SurfaceTextureListener f45372b;

    /* renamed from: c, reason: collision with root package name */
    private final TextureView.SurfaceTextureListener f45373c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        boolean a();
    }

    public THookTextureView(@Nullable Context context) {
        this(context, null, 0);
    }

    public static void setHookCallback(a aVar) {
        f45371a = aVar;
    }

    @Override // android.view.TextureView
    public final void setSurfaceTextureListener(@Nullable TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.f45372b = surfaceTextureListener;
        super.setSurfaceTextureListener(this.f45373c);
    }

    public THookTextureView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public THookTextureView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f45373c = new TextureView.SurfaceTextureListener() { // from class: com.tencent.tmediacodec.hook.THookTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(@Nullable SurfaceTexture surfaceTexture, int i11, int i12) {
                if (THookTextureView.this.f45372b != null) {
                    THookTextureView.this.f45372b.onSurfaceTextureAvailable(surfaceTexture, i11, i12);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture surfaceTexture) {
                boolean z10 = false;
                boolean z11 = THookTextureView.this.f45372b == null || THookTextureView.this.f45372b.onSurfaceTextureDestroyed(surfaceTexture);
                if (THookTextureView.f45371a != null) {
                    if (z11 && THookTextureView.f45371a.a()) {
                        z10 = true;
                    }
                    com.tencent.tmediacodec.a.a.a("THookTextureView", ((Object) this) + "onSurfaceTextureDestroyed surfaceTexture:" + ((Object) surfaceTexture) + " hookResult:" + z10 + "result:" + z11);
                    return z10;
                }
                com.tencent.tmediacodec.a.a.a("THookTextureView", ((Object) this) + ", onSurfaceTextureDestroyed surfaceTexture:" + ((Object) surfaceTexture) + " result:" + z11);
                return z11;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture surfaceTexture, int i11, int i12) {
                if (THookTextureView.this.f45372b != null) {
                    THookTextureView.this.f45372b.onSurfaceTextureSizeChanged(surfaceTexture, i11, i12);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(@Nullable SurfaceTexture surfaceTexture) {
                if (THookTextureView.this.f45372b != null) {
                    THookTextureView.this.f45372b.onSurfaceTextureUpdated(surfaceTexture);
                }
            }
        };
        setSurfaceTextureListener(null);
    }
}
