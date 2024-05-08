package com.huawei.hms.scankit.p;

import android.hardware.Camera;

/* compiled from: CameraZoomManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n0 {

    /* renamed from: a, reason: collision with root package name */
    private Camera f31294a;

    public synchronized void a(Camera camera) {
        this.f31294a = camera;
    }

    public synchronized boolean b() {
        Camera camera = this.f31294a;
        if (camera == null) {
            return false;
        }
        return camera.getParameters().isZoomSupported();
    }

    public synchronized m0 a() {
        return new m0(this.f31294a.getParameters().getMaxZoom(), this.f31294a.getParameters().getZoom(), this.f31294a.getParameters().getZoomRatios());
    }

    public synchronized void a(int i10) {
        Camera camera = this.f31294a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setZoom(i10);
        try {
            this.f31294a.setParameters(parameters);
        } catch (RuntimeException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CameraZoomManager::setCameraZoomIndex failed: ");
            sb2.append(e2.getMessage());
        }
    }
}
