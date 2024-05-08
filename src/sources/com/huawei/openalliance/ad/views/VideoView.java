package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.views.BaseVideoView;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoView extends BaseVideoView {
    private static final String Code = "VideoView";

    public VideoView(Context context) {
        super(context);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void B() {
        super.B();
        Surface surface = this.f32643g;
        if (surface != null) {
            surface.release();
        }
        this.f32643g = null;
        this.f32644h = null;
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_view_video, this);
        TextureView textureView = (TextureView) findViewById(R.id.hiad_id_video_texture_view);
        this.f32638b = textureView;
        textureView.setSurfaceTextureListener(this);
    }

    public Bitmap getSurfaceBitmap() {
        return this.f32638b.getBitmap();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        S();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        gl.V(Code, "onSurfaceTextureAvailable width: %d height: %d", Integer.valueOf(i10), Integer.valueOf(i11));
        this.f32640d = true;
        Surface surface = this.f32643g;
        if (surface == null || this.f32644h != surfaceTexture) {
            if (surface != null) {
                gl.V(Code, "release old surface when onSurfaceTextureAvailable");
                this.f32643g.release();
            }
            if (this.f32644h != null) {
                gl.V(Code, "release old SurfaceTexture when onSurfaceTextureAvailable");
                this.f32644h.release();
            }
            Surface surface2 = new Surface(surfaceTexture);
            this.f32643g = surface2;
            this.f32641e.Code(surface2);
            this.f32644h = surfaceTexture;
        }
        if (this.f32648l == null) {
            BaseVideoView.h hVar = new BaseVideoView.h(this.f32651o);
            this.f32648l = hVar;
            this.f32641e.Code(hVar);
        }
        if (this.f32639c) {
            Code(this.f32645i);
        }
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        gl.V(Code, "onSurfaceTextureDestroyed");
        this.f32640d = false;
        if (this.f32647k) {
            L();
        }
        d();
        if (this.f32643g != null) {
            gl.V(Code, "release old surface when onSurfaceTextureDestroyed");
            this.f32643g.release();
            this.f32643g = null;
        }
        if (this.f32644h == null) {
            return true;
        }
        gl.V(Code, "release old surfaceTexture when onSurfaceTextureDestroyed");
        this.f32644h.release();
        this.f32644h = null;
        return true;
    }
}
