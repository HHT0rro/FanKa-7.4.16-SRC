package com.android.internal.os;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class KernelCpuTotalBpfMapReader {
    private static native long[] readInternal();

    private KernelCpuTotalBpfMapReader() {
    }

    public static long[] read() {
        if (!KernelCpuBpfTracking.startTracking()) {
            return null;
        }
        return readInternal();
    }
}
