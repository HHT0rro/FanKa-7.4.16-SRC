package com.alibaba.security.biometrics.build;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.common.utils.DisplayUtils;
import com.alibaba.security.common.utils.SystemUtils;

/* compiled from: CommonInspector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ah implements ai {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2216a = "CommonInspector";

    /* renamed from: b, reason: collision with root package name */
    private int f2217b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f2218c;

    public ah(Context context) {
        this.f2218c = context;
    }

    private boolean b(boolean z10) {
        this.f2217b = 0;
        if (!SystemUtils.supportNEON()) {
            this.f2217b = GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_NEON;
            return false;
        }
        String str = Build.CPU_ABI;
        if (!"armeabi-v7a".equalsIgnoreCase(str) && !"armeabi".equalsIgnoreCase(str) && !"x86".equalsIgnoreCase(str) && !"arm64-v8a".equalsIgnoreCase(str)) {
            this.f2217b = GlobalErrorCode.ERROR_DEVICE_CPU_NOT_SUPPORT;
            return false;
        }
        if (!z10 && SystemUtils.isCpuX86()) {
            this.f2217b = GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_X86;
            return false;
        }
        if (!ALBiometricsJni.isLoaded()) {
            this.f2217b = GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL;
            return false;
        }
        if (!b()) {
            this.f2217b = GlobalErrorCode.ERROR_DEVICE_NO_CAMERA;
            return false;
        }
        if (!GetCacheDataManager.getInstance().getUseHwMagicWindow() || !DisplayUtils.isInHuaweiMagicWindow(this.f2218c)) {
            return true;
        }
        this.f2217b = GlobalErrorCode.ERROR_DEVICE_HW_MAGIC_WINDOW;
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.ai
    public final int a() {
        return this.f2217b;
    }

    @Override // com.alibaba.security.biometrics.build.ai
    public final boolean a(boolean z10) {
        this.f2217b = 0;
        if (!SystemUtils.supportNEON()) {
            this.f2217b = GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_NEON;
            return false;
        }
        String str = Build.CPU_ABI;
        if (!"armeabi-v7a".equalsIgnoreCase(str) && !"armeabi".equalsIgnoreCase(str) && !"x86".equalsIgnoreCase(str) && !"arm64-v8a".equalsIgnoreCase(str)) {
            this.f2217b = GlobalErrorCode.ERROR_DEVICE_CPU_NOT_SUPPORT;
            return false;
        }
        if (!z10 && SystemUtils.isCpuX86()) {
            this.f2217b = GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_X86;
            return false;
        }
        if (!ALBiometricsJni.isLoaded()) {
            this.f2217b = GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL;
            return false;
        }
        if (!b()) {
            this.f2217b = GlobalErrorCode.ERROR_DEVICE_NO_CAMERA;
            return false;
        }
        if (!GetCacheDataManager.getInstance().getUseHwMagicWindow() || !DisplayUtils.isInHuaweiMagicWindow(this.f2218c)) {
            return true;
        }
        this.f2217b = GlobalErrorCode.ERROR_DEVICE_HW_MAGIC_WINDOW;
        return false;
    }

    private static boolean b() {
        Camera.CameraInfo cameraInfo;
        try {
            int numberOfCameras = Integer.parseInt(Build.VERSION.SDK) > 8 ? Camera.getNumberOfCameras() : 0;
            for (int i10 = 0; i10 < numberOfCameras; i10++) {
                try {
                    cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i10, cameraInfo);
                } catch (Throwable unused) {
                }
                if (cameraInfo.facing == 1) {
                    return true;
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }
}
