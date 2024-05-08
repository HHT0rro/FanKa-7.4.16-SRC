package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class s {
    private static final String Code = "HandlerExecAgent";
    private static final long I = 60000;
    private static final String V = "handler_exec_release_task";
    private static final String Z = "handler_exec_thread";
    private final byte[] B = new byte[0];
    private final byte[] C = new byte[0];
    private HandlerThread D;
    private r F;
    private int L;
    private final String S;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        public static final int Code = 1;
        public static final int V = 2;
        public String B;
        public long C;
        public int I;
        public Runnable Z;

        public a(int i10, Runnable runnable, String str, long j10) {
            this.I = i10;
            this.Z = runnable;
            this.B = str;
            this.C = j10;
        }

        public String toString() {
            return "CacheTask{taskType=" + this.I + ", id='" + this.B + "'}";
        }
    }

    public s(String str) {
        this.S = TextUtils.isEmpty(str) ? Z : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (Z()) {
            synchronized (this.C) {
                if (this.D == null) {
                    gl.V(Code, "init handler thread");
                    HandlerThread handlerThread = new HandlerThread(this.S);
                    handlerThread.start();
                    Looper looper = handlerThread.getLooper();
                    if (looper != null) {
                        this.D = handlerThread;
                        Code(new r(new Handler(looper)));
                    } else {
                        handlerThread.quit();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r C() {
        r rVar;
        synchronized (this.B) {
            rVar = this.F;
        }
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(r rVar) {
        synchronized (this.B) {
            this.F = rVar;
        }
    }

    private void Code(final a aVar) {
        f.Z(new Runnable() { // from class: com.huawei.openalliance.ad.utils.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.this.B();
                r C = s.this.C();
                if (C != null) {
                    a aVar2 = aVar;
                    int i10 = aVar2.I;
                    if (i10 == 1) {
                        C.Code(aVar2.Z, aVar2.B, aVar2.C);
                    } else if (i10 == 2) {
                        C.Code(aVar2.B);
                    }
                }
            }
        });
    }

    private void I() {
        r C = C();
        if (C != null) {
            gl.V(Code, "delay quit thread");
            C.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.s.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (s.this.C) {
                        if (s.this.D != null) {
                            s.this.D.quitSafely();
                            s.this.D = null;
                        }
                        s.this.Code((r) null);
                        gl.V(s.Code, "quit thread and release");
                    }
                }
            }, V, 60000L);
        }
    }

    private boolean Z() {
        boolean z10;
        synchronized (this.B) {
            z10 = this.L > 0;
        }
        return z10;
    }

    public void Code() {
        synchronized (this.B) {
            this.L++;
            r C = C();
            if (C != null) {
                C.Code(V);
            }
            if (gl.Code()) {
                gl.Code(Code, "acquire exec agent. ref count: %d", Integer.valueOf(this.L));
            }
        }
    }

    public void Code(Runnable runnable) {
        if (Z()) {
            r C = C();
            if (C != null) {
                C.Code(runnable);
            } else {
                Code(new a(1, runnable, null, 0L));
            }
        }
    }

    public void Code(Runnable runnable, String str, long j10) {
        if (Z()) {
            r C = C();
            if (C != null) {
                C.Code(runnable, str, j10);
            } else {
                Code(new a(1, runnable, str, j10));
            }
        }
    }

    public void Code(String str) {
        if (Z()) {
            r C = C();
            if (C != null) {
                C.Code(str);
            } else {
                Code(new a(2, null, str, 0L));
            }
        }
    }

    public void V() {
        synchronized (this.B) {
            if (!Z()) {
                gl.V(Code, "release exec agent - not working");
                return;
            }
            int i10 = this.L - 1;
            this.L = i10;
            if (i10 <= 0) {
                this.L = 0;
                I();
            }
            if (gl.Code()) {
                gl.Code(Code, "release exec agent - ref count: %d", Integer.valueOf(this.L));
            }
        }
    }
}
