package com.tencent.liteav.videobase.utils;

import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SurfaceTextureHolder implements SurfaceTexture.OnFrameAvailableListener {

    @Nullable
    private CustomHandler mCallbackHandler;

    @Nullable
    private SurfaceTexture.OnFrameAvailableListener mOnFrameAvailableListener;

    @Nullable
    private Surface mSurface;

    @Nullable
    private SurfaceTexture mSurfaceTexture;
    private final String mTag = "SurfaceTextureHolder_" + Integer.toHexString(hashCode());

    @CalledByNative
    public SurfaceTextureHolder(int i10, boolean z10) {
        this.mSurfaceTexture = new SurfaceTexture(i10);
        if (z10) {
            this.mSurface = new Surface(this.mSurfaceTexture);
        }
    }

    public static /* synthetic */ void lambda$onFrameAvailable$0(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = surfaceTextureHolder.mOnFrameAvailableListener;
        if (onFrameAvailableListener != null) {
            onFrameAvailableListener.onFrameAvailable(surfaceTexture);
        }
    }

    @CalledByNative
    public Surface getSurface() {
        return this.mSurface;
    }

    @CalledByNative
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    @CalledByNative
    public float[] getTransformMatrix(boolean z10, float f10, float f11, float f12, float f13) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            LiteavLog.e(this.mTag, "getTransformMatrix, surface texture is released!");
            return null;
        }
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        if (z10) {
            if (!e.a(f10, 0.0f) || !e.a(f11, 0.0f)) {
                Matrix.translateM(fArr, 0, f10, f11, 0.0f);
            }
            if (!e.a(f12, 1.0f) || !e.a(f13, 1.0f)) {
                Matrix.scaleM(fArr, 0, f12, f13, 1.0f);
            }
        }
        return fArr;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        CustomHandler customHandler = this.mCallbackHandler;
        if (customHandler != null) {
            customHandler.runOrPost(s.a(this, surfaceTexture));
        }
    }

    @CalledByNative
    public void release() {
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
    }

    @CalledByNative
    public void setDefaultBufferSize(int i10, int i11) {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            LiteavLog.e(this.mTag, "setDefaultBufferSize, surface texture is released!");
        } else {
            surfaceTexture.setDefaultBufferSize(i10, i11);
        }
    }

    @CalledByNative
    public void setOnFrameAvailableListener(@Nullable SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, @Nullable Handler handler) {
        if (this.mSurfaceTexture == null) {
            LiteavLog.e(this.mTag, "setOnFrameAvailableListener, surface texture is released!");
            return;
        }
        this.mCallbackHandler = new CustomHandler(handler != null ? handler.getLooper() : Looper.getMainLooper());
        this.mOnFrameAvailableListener = onFrameAvailableListener;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            this.mSurfaceTexture.setOnFrameAvailableListener(this, this.mCallbackHandler);
        } else {
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }
    }

    @CalledByNative
    public void updateTexImage() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            LiteavLog.e(this.mTag, "updateTexImage, surface texture is released!");
        } else {
            surfaceTexture.updateTexImage();
        }
    }
}
