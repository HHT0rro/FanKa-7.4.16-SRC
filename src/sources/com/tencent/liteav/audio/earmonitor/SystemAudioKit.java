package com.tencent.liteav.audio.earmonitor;

import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class SystemAudioKit {
    private final long mNativeSystemAudioKit;

    public SystemAudioKit(long j10) {
        this.mNativeSystemAudioKit = j10;
    }

    @CalledByNative
    public static SystemAudioKit create(long j10) {
        String manufacturer = LiteavSystemInfo.getManufacturer();
        if (TextUtils.isEmpty(manufacturer)) {
            return null;
        }
        String lowerCase = manufacturer.toLowerCase();
        lowerCase.hashCode();
        char c4 = 65535;
        switch (lowerCase.hashCode()) {
            case -1206476313:
                if (lowerCase.equals("huawei")) {
                    c4 = 0;
                    break;
                }
                break;
            case 3620012:
                if (lowerCase.equals(ADEvent.VIVO)) {
                    c4 = 1;
                    break;
                }
                break;
            case 1864941562:
                if (lowerCase.equals("samsung")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return new a(j10, ContextUtils.getApplicationContext());
            case 1:
                return new i(j10, ContextUtils.getApplicationContext());
            case 2:
                ContextUtils.getApplicationContext();
                return new h(j10);
            default:
                return null;
        }
    }

    private static native void nativeNotifyEarMonitoringInitialized(long j10, SystemAudioKit systemAudioKit, boolean z10);

    private static native void nativeNotifySystemError(long j10, SystemAudioKit systemAudioKit);

    @CalledByNative
    public abstract void initialize();

    public void notifyEarMonitoringInitialized(SystemAudioKit systemAudioKit, boolean z10) {
        nativeNotifyEarMonitoringInitialized(this.mNativeSystemAudioKit, systemAudioKit, z10);
    }

    public void notifySystemError(SystemAudioKit systemAudioKit) {
        nativeNotifySystemError(this.mNativeSystemAudioKit, systemAudioKit);
    }

    @CalledByNative
    public abstract void setEarMonitoringVolume(int i10);

    @CalledByNative
    public abstract void startEarMonitoring();

    @CalledByNative
    public abstract void stopEarMonitoring();

    @CalledByNative
    public abstract void terminate();
}
