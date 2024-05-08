package com.huawei.hms.scankit.p;

import android.hardware.Camera;

/* compiled from: CameraExposureManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h0 {

    /* renamed from: a, reason: collision with root package name */
    private Camera f31046a;

    public synchronized void a(Camera camera) {
        this.f31046a = camera;
    }

    public synchronized g0 a() {
        return new g0(this.f31046a.getParameters().getMaxExposureCompensation(), this.f31046a.getParameters().getMinExposureCompensation(), this.f31046a.getParameters().getExposureCompensation(), this.f31046a.getParameters().getExposureCompensationStep());
    }

    public synchronized void a(int i10) {
        Camera camera = this.f31046a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setExposureCompensation(i10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setExpuseModeA: ");
            sb2.append(parameters.getAutoExposureLock());
            this.f31046a.setParameters(parameters);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("setExpuseModeB: ");
            sb3.append(parameters.getAutoExposureLock());
        } catch (RuntimeException unused) {
        }
    }
}
