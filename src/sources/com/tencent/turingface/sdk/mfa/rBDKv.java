package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.huawei.appgallery.marketinstallerservice.api.Constant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class rBDKv {

    /* renamed from: a, reason: collision with root package name */
    public static final rBDKv f45926a = new rBDKv();

    /* renamed from: b, reason: collision with root package name */
    public static long f45927b = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: c, reason: collision with root package name */
    public static int[] f45928c = {0, 15, 30, 90, 240, 360, 600, 1200, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY, 3200, 4800, 7200};

    /* renamed from: d, reason: collision with root package name */
    public CvowV f45929d;

    /* renamed from: e, reason: collision with root package name */
    public spXPg f45930e;

    /* renamed from: g, reason: collision with root package name */
    public fenkF f45932g;

    /* renamed from: f, reason: collision with root package name */
    public boolean f45931f = false;

    /* renamed from: h, reason: collision with root package name */
    public final Object f45933h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public final AtomicReference<vneRm> f45934i = new AtomicReference<>(null);

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReference<Boolean> f45935j = new AtomicReference<>(Boolean.FALSE);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public Context f45936a;

        public spXPg(Looper looper, Context context) {
            super(looper);
            this.f45936a = context;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            System.currentTimeMillis();
            int i10 = message.what;
            if (i10 == 1) {
                rBDKv.this.a(this.f45936a, true, 3);
                return;
            }
            if (i10 != 2) {
                return;
            }
            rBDKv.this.a(rBDKv.this.a(this.f45936a, true, false, ((Integer) message.obj).intValue()), false);
            synchronized (rBDKv.this.f45935j) {
                rBDKv.this.f45935j.set(Boolean.FALSE);
                rBDKv.this.f45935j.notifyAll();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.tencent.turingface.sdk.mfa.rBDKv r21) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.rBDKv.a(com.tencent.turingface.sdk.mfa.rBDKv):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x029e, code lost:
    
        if (r21 != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0297, code lost:
    
        if (r6 != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02a0, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x059d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:409:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x030a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.HashMap, java.util.Map<java.lang.Integer, java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r15v7, types: [java.util.Collection, java.util.List<java.lang.String>, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.turingface.sdk.mfa.vneRm b(android.content.Context r33, boolean r34, int r35) {
        /*
            Method dump skipped, instructions count: 3009
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.rBDKv.b(android.content.Context, boolean, int):com.tencent.turingface.sdk.mfa.vneRm");
    }

    public final vneRm a(Context context) {
        vneRm vnerm;
        vneRm a10;
        synchronized (this.f45934i) {
            vnerm = this.f45934i.get();
            if (vnerm == null) {
                fenkF fenkf = this.f45932g;
                if (fenkf != null) {
                    a10 = fenkf.a(context);
                } else {
                    a10 = vneRm.a(1);
                }
                vnerm = a10;
                this.f45934i.set(vnerm);
            }
        }
        return vnerm;
    }

    public final void a(vneRm vnerm, boolean z10) {
        synchronized (this.f45934i) {
            if (!z10) {
                if (vnerm.f45967c != 0) {
                    return;
                }
            }
            this.f45934i.set(vnerm);
        }
    }

    public final void a() {
        synchronized (this.f45935j) {
            if (this.f45935j.get().booleanValue()) {
                return;
            }
            this.f45935j.set(Boolean.TRUE);
            this.f45930e.sendMessageDelayed(Message.obtain(this.f45930e, 2, 3), 0L);
        }
    }

    public final vneRm a(Context context, boolean z10, int i10) {
        vneRm a10;
        vneRm a11 = a(context);
        if (this.f45929d == null) {
            return vneRm.a(Constant.INSTALL_FAILED_SHA256_EEROR);
        }
        int a12 = a(a11);
        if (a12 == 1) {
            return a11;
        }
        if (a12 != 2) {
            if (a12 == 3) {
                a();
            }
            return a11;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a();
            return vneRm.a(-10008);
        }
        synchronized (this.f45933h) {
            a10 = a(context);
            if (a10 == a11 || a(a10) != 1) {
                synchronized (this.f45935j) {
                    if (!this.f45935j.get().booleanValue()) {
                        this.f45935j.set(Boolean.TRUE);
                        this.f45930e.post(new eCoqw(this, context, i10));
                    }
                    try {
                        this.f45935j.wait(z10 ? this.f45929d.f45559u : 10000L);
                    } catch (InterruptedException unused) {
                    }
                }
                a10 = a(context);
                if (a10 == a11) {
                    a10 = vneRm.a(-10004);
                }
            }
        }
        return a10;
    }

    public final int a(vneRm vnerm) {
        Context context;
        long j10;
        Context context2;
        if (this.f45929d.f45555q || vnerm.f45967c != 0 || TextUtils.isEmpty(vnerm.f45965a)) {
            return 2;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= vnerm.f45966b) {
            this.f45929d.getClass();
            return 3;
        }
        fenkF fenkf = this.f45932g;
        synchronized (i3cNc.class) {
            context = i3cNc.f45809a;
        }
        fenkf.getClass();
        try {
            j10 = Long.valueOf(fenkF.b(context, "107")).longValue();
        } catch (Throwable unused) {
            j10 = 0;
        }
        fenkF fenkf2 = this.f45932g;
        synchronized (i3cNc.class) {
            context2 = i3cNc.f45809a;
        }
        if (Math.abs(currentTimeMillis - fenkf2.a(context2, "108")) < j10) {
            return 1;
        }
        this.f45929d.getClass();
        return 3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c3, code lost:
    
        if (r20 != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ee, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ea, code lost:
    
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - r9.longValue()) >= com.tencent.turingface.sdk.mfa.rBDKv.f45927b) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.turingface.sdk.mfa.vneRm a(android.content.Context r18, boolean r19, boolean r20, int r21) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.rBDKv.a(android.content.Context, boolean, boolean, int):com.tencent.turingface.sdk.mfa.vneRm");
    }
}
