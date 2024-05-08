package com.ss.android.downloadlib;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {

    /* renamed from: m, reason: collision with root package name */
    private static volatile n f38816m;
    private com.ss.android.download.api.config.n dk = null;

    private n() {
    }

    public static n m() {
        if (f38816m == null) {
            synchronized (n.class) {
                if (f38816m == null) {
                    f38816m = new n();
                }
            }
        }
        return f38816m;
    }

    public com.ss.android.download.api.config.n dk() {
        return this.dk;
    }
}
