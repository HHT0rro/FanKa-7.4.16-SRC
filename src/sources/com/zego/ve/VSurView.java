package com.zego.ve;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VSurView implements SurfaceHolder.Callback {
    private long pthis = 0;
    private SurfaceView mSurView = null;
    private final Object lock = new Object();

    private static native int on_surface_changed(long j10, SurfaceHolder surfaceHolder, int i10, int i11, int i12);

    private static native int on_surface_created(long j10, SurfaceHolder surfaceHolder);

    private static native int on_surface_destroyed(long j10, SurfaceHolder surfaceHolder);

    public int removeView() {
        synchronized (this.lock) {
            SurfaceView surfaceView = this.mSurView;
            if (surfaceView != null) {
                SurfaceHolder holder = surfaceView.getHolder();
                if (holder != null) {
                    holder.removeCallback(this);
                }
                this.mSurView = null;
            }
        }
        return 0;
    }

    public int setThis(long j10) {
        synchronized (this.lock) {
            this.pthis = j10;
        }
        return 0;
    }

    public int setView(SurfaceView surfaceView) {
        SurfaceHolder holder;
        synchronized (this.lock) {
            removeView();
            this.mSurView = surfaceView;
            if (surfaceView != null && (holder = surfaceView.getHolder()) != null) {
                holder.addCallback(this);
            }
        }
        return 0;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        synchronized (this.lock) {
            long j10 = this.pthis;
            if (j10 != 0) {
                on_surface_changed(j10, surfaceHolder, i10, i11, i12);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        synchronized (this.lock) {
            long j10 = this.pthis;
            if (j10 != 0) {
                on_surface_created(j10, surfaceHolder);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.lock) {
            long j10 = this.pthis;
            if (j10 != 0) {
                on_surface_destroyed(j10, surfaceHolder);
            }
        }
    }
}
