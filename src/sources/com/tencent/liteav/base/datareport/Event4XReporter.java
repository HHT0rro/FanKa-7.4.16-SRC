package com.tencent.liteav.base.datareport;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Event4XReporter {
    private static final int INVALID_INSTANCE = 0;
    public static final int REPORT_EVENT = 1;
    public static final int REPORT_STATUS = 2;
    private static final String TAG = "Event4XReporter";
    private long mNativeEvent4XReporterAndroid;

    public Event4XReporter(int i10, int i11, String str, boolean z10, int i12) {
        this.mNativeEvent4XReporterAndroid = 0L;
        this.mNativeEvent4XReporterAndroid = nativeCreate(i10, i11, str, z10, i12);
    }

    private static native long nativeCreate(int i10, int i11, String str, boolean z10, int i12);

    private static native void nativeDestroy(long j10);

    private static native int nativeGetColdDownTime(long j10);

    private static native void nativeSendReport(long j10);

    private static native void nativeSetCommonIntValue(long j10, String str, long j11);

    private static native void nativeSetCommonStringValue(long j10, String str, String str2);

    private static native void nativeSetEventIntValue(long j10, String str, long j11);

    private static native void nativeSetEventStringValue(long j10, String str, String str2);

    public synchronized void destroy() {
        long j10 = this.mNativeEvent4XReporterAndroid;
        if (j10 == 0) {
            return;
        }
        nativeDestroy(j10);
        this.mNativeEvent4XReporterAndroid = 0L;
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public int getColdDownTime() {
        long j10 = this.mNativeEvent4XReporterAndroid;
        if (j10 == 0) {
            return 10000;
        }
        return nativeGetColdDownTime(j10);
    }

    public synchronized void reportDau(int i10, int i11, String str) {
        long j10 = this.mNativeEvent4XReporterAndroid;
        if (j10 == 0) {
            return;
        }
        nativeSetEventStringValue(j10, "event_id", String.valueOf(i10));
        nativeSetEventStringValue(this.mNativeEvent4XReporterAndroid, "err_code", String.valueOf(i11));
        nativeSetEventStringValue(this.mNativeEvent4XReporterAndroid, "err_info", str);
        nativeSendReport(this.mNativeEvent4XReporterAndroid);
    }

    public synchronized void sendReport() {
        long j10 = this.mNativeEvent4XReporterAndroid;
        if (j10 == 0) {
            return;
        }
        nativeSendReport(j10);
    }

    public synchronized void setCommonIntValue(String str, long j10) {
        long j11 = this.mNativeEvent4XReporterAndroid;
        if (j11 != 0 && str != null) {
            nativeSetCommonIntValue(j11, str, j10);
        }
    }

    public synchronized void setCommonStringValue(String str, String str2) {
        long j10 = this.mNativeEvent4XReporterAndroid;
        if (j10 != 0 && str != null && str2 != null) {
            nativeSetCommonStringValue(j10, str, str2);
        }
    }

    public synchronized void setEventIntValue(String str, long j10) {
        long j11 = this.mNativeEvent4XReporterAndroid;
        if (j11 != 0 && str != null) {
            nativeSetEventIntValue(j11, str, j10);
        }
    }

    public synchronized void setEventStringValue(String str, String str2) {
        long j10 = this.mNativeEvent4XReporterAndroid;
        if (j10 != 0 && str != null && str2 != null) {
            nativeSetEventStringValue(j10, str, str2);
        }
    }
}
