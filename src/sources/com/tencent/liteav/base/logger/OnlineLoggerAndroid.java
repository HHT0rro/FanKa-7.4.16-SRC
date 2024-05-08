package com.tencent.liteav.base.logger;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OnlineLoggerAndroid {
    private static final int INVALID_INSTANCE = -1;
    private long mNativeOnlineLoggerAndroid;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        kApi(1),
        kInfo(2),
        kWarning(3),
        kError(4);

        public int level;

        a(int i10) {
            this.level = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum b {
        kTRTC,
        kLive
    }

    public OnlineLoggerAndroid(b bVar, int i10, String str, String str2) {
        this.mNativeOnlineLoggerAndroid = -1L;
        this.mNativeOnlineLoggerAndroid = nativeCreate(bVar.ordinal(), i10, str, str2);
    }

    private static native long nativeCreate(int i10, int i11, String str, String str2);

    private static native void nativeDestroy(long j10);

    private static native void nativeLog(long j10, int i10, String str);

    public synchronized void destroy() {
        long j10 = this.mNativeOnlineLoggerAndroid;
        if (j10 == -1) {
            return;
        }
        nativeDestroy(j10);
        this.mNativeOnlineLoggerAndroid = -1L;
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public synchronized void log(a aVar, String str) {
        long j10 = this.mNativeOnlineLoggerAndroid;
        if (j10 == -1) {
            return;
        }
        nativeLog(j10, aVar.level, str);
    }
}
