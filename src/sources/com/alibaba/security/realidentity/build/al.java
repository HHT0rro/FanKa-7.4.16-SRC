package com.alibaba.security.realidentity.build;

import android.hardware.Camera;
import com.alibaba.security.common.log.RPLogging;

/* compiled from: OpenCameraInterface.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class al {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3081a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static final String f3082b = "com.alibaba.security.realidentity.build.al";

    private al() {
    }

    public static Camera a(int i10) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            RPLogging.w(f3082b, "No cameras!");
            return null;
        }
        boolean z10 = i10 >= 0;
        if (!z10) {
            i10 = 0;
            while (i10 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i10, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i10++;
            }
        }
        if (i10 < numberOfCameras) {
            RPLogging.i(f3082b, "Opening camera #".concat(String.valueOf(i10)));
            return Camera.open(i10);
        }
        if (z10) {
            RPLogging.w(f3082b, "Requested camera does not exist: ".concat(String.valueOf(i10)));
            return null;
        }
        RPLogging.i(f3082b, "No camera facing back; returning camera #0");
        return Camera.open(0);
    }
}
