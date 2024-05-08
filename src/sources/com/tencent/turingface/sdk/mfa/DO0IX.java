package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class DO0IX {

    /* renamed from: a, reason: collision with root package name */
    public static final DO0IX f45565a = new DO0IX();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Integer> f45566b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Integer, Integer> f45567c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map<Integer, Integer> f45568d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final Map<Integer, Integer> f45569e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final Object f45570f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public CvowV f45571g;

    /* renamed from: h, reason: collision with root package name */
    public fenkF f45572h;

    static {
        HashMap hashMap = new HashMap();
        f45566b = hashMap;
        hashMap.put(2, 0);
        hashMap.put(6, 0);
        hashMap.put(3, 0);
        hashMap.put(32, 0);
        hashMap.put(5, 0);
        hashMap.put(4, 0);
        hashMap.put(17, 1);
        hashMap.put(40, 0);
        hashMap.put(43, 0);
        hashMap.put(19, 0);
        hashMap.put(36, 0);
        hashMap.put(114, 0);
        hashMap.put(10001, 0);
        hashMap.put(45, 0);
        hashMap.put(136, 0);
        hashMap.put(139, 0);
        hashMap.put(10002, 0);
        hashMap.put(10003, 0);
        int i10 = com.tencent.turingcam.oqKCa.f45455a;
        if (i10 == 105668) {
            hashMap.put(18, 0);
        } else if (i10 == 105928) {
            hashMap.put(18, 0);
        } else if (i10 == 108168) {
            hashMap.put(18, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        if (r1 <= 0) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0114 A[Catch: all -> 0x0177, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0014, B:13:0x0028, B:16:0x0064, B:73:0x006b, B:19:0x006f, B:24:0x0075, B:71:0x008b, B:34:0x0114, B:42:0x015c, B:50:0x016b, B:51:0x0176, B:36:0x011f, B:41:0x0154, B:46:0x0159), top: B:2:0x0001, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean a(android.content.Context r7, int r8, java.lang.String r9, long r10, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.DO0IX.a(android.content.Context, int, java.lang.String, long, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.concurrent.ConcurrentHashMap] */
    public final synchronized void b(Context context) {
        Map<Integer, Integer> emptyMap;
        synchronized (this.f45570f) {
            this.f45567c.clear();
            this.f45567c.putAll(f45566b);
            QjsR0 b4 = G1g37.f45591b.b(context);
            if (b4 == null || (emptyMap = b4.f45678i) == null) {
                emptyMap = Collections.emptyMap();
            }
            this.f45567c.putAll(emptyMap);
            Iterator<Integer> iterator2 = this.f45568d.h().iterator2();
            while (iterator2.hasNext()) {
                int intValue = iterator2.next().intValue();
                if (a(intValue)) {
                    this.f45567c.put(Integer.valueOf(intValue), this.f45568d.get(Integer.valueOf(intValue)));
                }
            }
            Iterator<Integer> iterator22 = this.f45569e.h().iterator2();
            while (iterator22.hasNext()) {
                int intValue2 = iterator22.next().intValue();
                if (a(intValue2)) {
                    this.f45567c.put(Integer.valueOf(intValue2), this.f45569e.get(Integer.valueOf(intValue2)));
                }
            }
            if (a(17)) {
                this.f45567c.put(40, 0);
                this.f45567c.put(43, 0);
            }
        }
    }

    public final void c(Context context) {
        try {
            if (f45565a.a(context, uAnWx.f45964f, this.f45571g.b(), this.f45572h.a(context, "501"), rBDKv.f45926a.a(context).f45965a, CFgXs.a())) {
                fenkF fenkf = this.f45572h;
                fenkf.getClass();
                fenkf.a(context, "501", "" + System.currentTimeMillis(), true);
            }
        } catch (Throwable unused) {
        }
    }

    public final long a(Context context) {
        long j10 = 0;
        if (this.f45572h.a(context, "501") > 0) {
            return 0L;
        }
        synchronized (this) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                c(context);
                j10 = System.currentTimeMillis() - currentTimeMillis;
                b(context);
            } catch (Throwable unused) {
            }
        }
        return j10;
    }

    public final boolean a(int i10) {
        Integer num;
        if (this.f45567c.containsKey(Integer.valueOf(i10)) && (num = this.f45567c.get(Integer.valueOf(i10))) != null) {
            return num.intValue() != 0;
        }
        return true;
    }

    public final String a() {
        HashSet hashSet = new HashSet();
        synchronized (this.f45570f) {
            for (Integer num : this.f45567c.h()) {
                if (this.f45567c.get(num).intValue() == 0) {
                    hashSet.add(num);
                }
            }
        }
        Iterator iterator2 = hashSet.iterator2();
        StringBuilder sb2 = new StringBuilder();
        while (iterator2.hasNext()) {
            sb2.append("" + ((Integer) iterator2.next()).intValue());
            if (iterator2.hasNext()) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }
}
