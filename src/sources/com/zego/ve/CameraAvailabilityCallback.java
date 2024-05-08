package com.zego.ve;

import android.hardware.camera2.CameraManager;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CameraAvailabilityCallback extends CameraManager.AvailabilityCallback {
    private String mCameraId;
    private boolean mIsFirstTime;
    private Listener mListener;
    private final AtomicLong mThis;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Listener {
        void onCameraAvailable(long j10, String str);

        void onCameraUnavailable(long j10, String str);
    }

    public CameraAvailabilityCallback(long j10, int i10, Listener listener) {
        AtomicLong atomicLong = new AtomicLong();
        this.mThis = atomicLong;
        this.mCameraId = null;
        this.mIsFirstTime = false;
        atomicLong.set(j10);
        this.mListener = listener;
        this.mCameraId = String.valueOf(i10);
        this.mIsFirstTime = true;
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public void onCameraAvailable(String str) {
        long j10 = this.mThis.get();
        if (j10 == 0 || !str.equals(this.mCameraId)) {
            return;
        }
        if (this.mIsFirstTime) {
            this.mIsFirstTime = false;
        } else {
            this.mListener.onCameraAvailable(j10, str);
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public void onCameraUnavailable(String str) {
        long j10 = this.mThis.get();
        if (j10 == 0 || !str.equals(this.mCameraId)) {
            return;
        }
        if (this.mIsFirstTime) {
            this.mIsFirstTime = false;
        } else {
            this.mListener.onCameraUnavailable(j10, str);
        }
    }

    public void uninit() {
        this.mThis.set(0L);
    }
}
