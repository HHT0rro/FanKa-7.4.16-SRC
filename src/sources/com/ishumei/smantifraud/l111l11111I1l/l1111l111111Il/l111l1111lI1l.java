package com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class l111l1111lI1l {
    private String l1111l111111Il = "";

    public abstract String l1111l111111Il();

    public final String l1111l111111Il(long j10) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111lI1l.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    l111l1111lI1l l111l1111li1l = l111l1111lI1l.this;
                    l111l1111li1l.l1111l111111Il = l111l1111li1l.l1111l111111Il();
                } catch (Throwable unused) {
                }
                countDownLatch.countDown();
            }
        }).start();
        try {
            countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        return this.l1111l111111Il;
    }
}
