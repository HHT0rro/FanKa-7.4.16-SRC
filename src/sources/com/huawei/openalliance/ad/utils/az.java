package com.huawei.openalliance.ad.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class az implements Runnable {
    private static final String Code = "TaskWrapper";
    private Runnable V;

    public az(Runnable runnable) {
        this.V = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.V;
        if (runnable != null) {
            try {
                runnable.run();
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
