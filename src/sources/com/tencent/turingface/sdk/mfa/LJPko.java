package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.code.AbilityCode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class LJPko {

    /* renamed from: a, reason: collision with root package name */
    public static CvowV f45634a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference<YaDRx> f45635b = new AtomicReference<>(null);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class spXPg implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public static final Handler f45636a;

        /* renamed from: b, reason: collision with root package name */
        public static final AtomicReference<AtomicReference<YaDRx>> f45637b = new AtomicReference<>(null);

        static {
            HandlerThread handlerThread = new HandlerThread("TuringRiskThread", 0);
            handlerThread.start();
            f45636a = new Handler(handlerThread.getLooper());
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            YaDRx yaDRx;
            synchronized (i3cNc.class) {
                context = i3cNc.f45809a;
            }
            ZIDl7 zIDl7 = new ZIDl7();
            try {
                DO0IX.f45565a.a(context);
                zIDl7.f45735b = 1;
                zIDl7.f45738e = System.currentTimeMillis();
                byte[] a10 = LJPko.a(context, zIDl7, true);
                zIDl7.f45739f = System.currentTimeMillis();
                zIDl7.f45736c = a10.length;
                yaDRx = LJPko.a(context, a10, zIDl7);
                try {
                    LJPko.a(context, yaDRx);
                    LJPko.a(context, zIDl7);
                    AtomicReference<AtomicReference<YaDRx>> atomicReference = f45637b;
                    synchronized (atomicReference) {
                        AtomicReference<YaDRx> andSet = atomicReference.getAndSet(null);
                        if (andSet != null) {
                            andSet.set(yaDRx);
                        }
                        atomicReference.notifyAll();
                    }
                } catch (Throwable unused) {
                    AtomicReference<AtomicReference<YaDRx>> atomicReference2 = f45637b;
                    synchronized (atomicReference2) {
                        AtomicReference<YaDRx> andSet2 = atomicReference2.getAndSet(null);
                        if (andSet2 != null) {
                            if (yaDRx == null) {
                                yaDRx = new YaDRx(-10015);
                            }
                            andSet2.set(yaDRx);
                        }
                        atomicReference2.notifyAll();
                    }
                }
            } catch (Throwable unused2) {
                yaDRx = null;
            }
        }
    }

    public static void a(Context context, ZIDl7 zIDl7) {
        long j10;
        StringBuilder b4 = com.tencent.turingcam.oqKCa.b("5_");
        b4.append(zIDl7.f45735b);
        b4.append("_");
        b4.append(zIDl7.f45737d);
        b4.append("_");
        b4.append(System.currentTimeMillis() - zIDl7.f45734a);
        b4.append("_");
        b4.append(zIDl7.f45736c);
        b4.append("_");
        long j11 = zIDl7.f45738e;
        if (j11 >= 0) {
            long j12 = zIDl7.f45739f;
            if (j12 >= j11) {
                j10 = j12 - j11;
                b4.append(j10);
                String sb2 = b4.toString();
                String str = fenkF.f45789a;
                HashMap hashMap = new HashMap();
                hashMap.put("703", sb2);
                fenkF.a(context, hashMap);
            }
        }
        j10 = -1;
        b4.append(j10);
        String sb22 = b4.toString();
        String str2 = fenkF.f45789a;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("703", sb22);
        fenkF.a(context, hashMap2);
    }

    public static YaDRx a(Context context, byte[] bArr, ZIDl7 zIDl7) {
        if (bArr.length == 0) {
            return new YaDRx(-1000);
        }
        tmnyR a10 = A48DB.f45525a.a(bArr);
        int i10 = a10.f45957b;
        if (i10 != 0) {
            return new YaDRx(i10);
        }
        byte[] bArr2 = a10.f45958c;
        try {
            sWkeo swkeo = new sWkeo();
            swkeo.f45940a = -999;
            if (zIDl7.f45735b == 1) {
                swkeo = (sWkeo) com.tencent.turingcam.oqKCa.a(swkeo, bArr2);
            } else {
                swkeo.a(new nyvKz(bArr2));
            }
            if (swkeo == null) {
                return new YaDRx(-1002);
            }
            int i11 = swkeo.f45940a;
            if (i11 == 0) {
                if (TextUtils.isEmpty(swkeo.f45941b)) {
                    return new YaDRx(AbilityCode.SHARE_INSTALLED_ERROR);
                }
                int seconds = (int) TimeUnit.MINUTES.toSeconds(10L);
                if (swkeo.f45942c < seconds) {
                    swkeo.f45942c = seconds;
                }
                return new YaDRx(0, swkeo.f45941b, System.currentTimeMillis(), swkeo.f45942c * 1000, swkeo.f45943d);
            }
            return new YaDRx((-2000) - i11);
        } catch (Throwable unused) {
            return new YaDRx(-999);
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Collection, java.util.List<java.lang.String>, java.util.ArrayList] */
    public static String a(Context context, int i10) {
        ?? r12;
        HashMap hashMap = new HashMap();
        hashMap.put("3", "" + i10);
        if (i10 == 17 || i10 == 40) {
            f45634a.getClass();
            synchronized (BijG2.class) {
                r12 = BijG2.f45534a;
                r12.isEmpty();
            }
            HashSet hashSet = new HashSet();
            if (!r12.isEmpty()) {
                hashSet.addAll(r12);
            }
            if (hashSet.size() > 0) {
                hashMap.put("277", BijG2.a(hashSet));
            }
        }
        try {
            SparseArray<Object> h77 = TNative$aa.h77(new SparseArray(), context, hashMap, 0);
            if (com.tencent.turingcam.oqKCa.b(h77) != 0) {
                return "";
            }
            String str = (String) com.tencent.turingcam.oqKCa.a(h77, 205, String.class);
            if (str == null) {
                str = "";
            }
            StringBuilder sb2 = new StringBuilder();
            for (String str2 : str.split(",")) {
                if (!str2.split(u.bD)[0].equals("0")) {
                    sb2.append(str2);
                    sb2.append(u.bD);
                    sb2.append(",");
                }
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x028f, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x05fd, code lost:
    
        r11 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(android.content.Context r16, com.tencent.turingface.sdk.mfa.ZIDl7 r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 1653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.LJPko.a(android.content.Context, com.tencent.turingface.sdk.mfa.ZIDl7, boolean):byte[]");
    }

    public static void a(Context context, YaDRx yaDRx) {
        AtomicReference<YaDRx> atomicReference = f45635b;
        synchronized (atomicReference) {
            if (yaDRx.f45727a != 0) {
                return;
            }
            atomicReference.set(yaDRx);
            String str = fenkF.f45789a;
            if (TextUtils.isEmpty(yaDRx.f45728b)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("1001", yaDRx.f45728b);
            hashMap.put("1002", String.valueOf(yaDRx.f45729c));
            hashMap.put("1003", String.valueOf(yaDRx.f45730d));
            hashMap.put("1004", String.valueOf(yaDRx.f45731e));
            fenkF.a(context, hashMap);
        }
    }
}
