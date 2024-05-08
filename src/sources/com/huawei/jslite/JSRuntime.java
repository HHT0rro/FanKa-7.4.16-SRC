package com.huawei.jslite;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JSRuntime {
    private final long mRuntime = createRuntime();

    static {
        try {
            System.loadLibrary("jslite");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private static native long createRuntime();

    private static native void destroyRuntime(long j10);

    public void close() {
        destroyRuntime(this.mRuntime);
    }

    public JSContext createContext() {
        return new JSContext(this.mRuntime);
    }
}
