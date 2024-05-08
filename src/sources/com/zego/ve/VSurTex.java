package com.zego.ve;

import android.graphics.SurfaceTexture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VSurTex implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "VSurTex";
    private long pthis = 0;
    private SurfaceTexture mSt = null;
    private Object mLock = new Object();

    private static native int on_frame(long j10, int i10);

    public int create(long j10, int i10) {
        this.pthis = j10;
        SurfaceTexture surfaceTexture = new SurfaceTexture(i10);
        this.mSt = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        return this.mSt.hashCode();
    }

    public void destroy() {
        synchronized (this.mLock) {
            this.pthis = 0L;
        }
        this.mSt.setOnFrameAvailableListener(null);
        this.mSt.release();
        this.mSt = null;
    }

    public SurfaceTexture get() {
        return this.mSt;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        try {
            synchronized (this.mLock) {
                long j10 = this.pthis;
                if (j10 != 0) {
                    on_frame(j10, surfaceTexture.hashCode());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
