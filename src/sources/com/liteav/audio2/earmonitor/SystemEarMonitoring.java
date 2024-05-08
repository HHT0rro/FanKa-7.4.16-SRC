package com.liteav.audio2.earmonitor;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class SystemEarMonitoring {
    private static native void nativeNotifySystemEarMonitoringError(long j10, SystemEarMonitoring systemEarMonitoring);

    private static native void nativeNotifySystemEarMonitoringInitialized(long j10, SystemEarMonitoring systemEarMonitoring, boolean z10);
}
