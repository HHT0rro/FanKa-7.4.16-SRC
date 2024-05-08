package com.tencent.turingface.sdk.mfa;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class QjsR0 extends ucT3w implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, String> f45670a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<Integer, Integer> f45671b;

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, String> f45672c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f45673d = true;

    /* renamed from: e, reason: collision with root package name */
    public long f45674e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f45675f = true;

    /* renamed from: g, reason: collision with root package name */
    public long f45676g = 0;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f45677h = null;

    /* renamed from: i, reason: collision with root package name */
    public Map<Integer, Integer> f45678i = null;

    /* renamed from: j, reason: collision with root package name */
    public long f45679j = 0;

    /* renamed from: k, reason: collision with root package name */
    public Map<String, String> f45680k = null;

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    static {
        HashMap hashMap = new HashMap();
        f45670a = hashMap;
        hashMap.put("", "");
        f45671b = new HashMap();
        f45671b.put(0, 0);
        HashMap hashMap2 = new HashMap();
        f45672c = hashMap2;
        hashMap2.put("", "");
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f45674e, 0);
        d5hoq.a(this.f45675f ? (byte) 1 : (byte) 0, 1);
        d5hoq.a(this.f45676g, 2);
        d5hoq.a((Map) this.f45677h, 3);
        d5hoq.a((Map) this.f45678i, 4);
        d5hoq.a(this.f45679j, 5);
        Map<String, String> map = this.f45680k;
        if (map != null) {
            d5hoq.a((Map) map, 6);
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f45673d) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        QjsR0 qjsR0 = (QjsR0) obj;
        if (fi6GY.a(this.f45674e, qjsR0.f45674e)) {
            return (this.f45675f == qjsR0.f45675f) && fi6GY.a(this.f45676g, qjsR0.f45676g) && this.f45677h.equals(qjsR0.f45677h) && this.f45678i.equals(qjsR0.f45678i) && fi6GY.a(this.f45679j, qjsR0.f45679j) && this.f45680k.equals(qjsR0.f45680k);
        }
        return false;
    }

    public final int hashCode() {
        try {
            throw new Exception("");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f45674e = nyvkz.a(this.f45674e, 0, true);
        this.f45675f = nyvkz.a(this.f45675f, 1, true);
        this.f45676g = nyvkz.a(this.f45676g, 2, true);
        this.f45677h = (Map) nyvkz.a((nyvKz) f45670a, 3, true);
        this.f45678i = (Map) nyvkz.a((nyvKz) f45671b, 4, true);
        this.f45679j = nyvkz.a(this.f45679j, 5, true);
        this.f45680k = (Map) nyvkz.a((nyvKz) f45672c, 6, false);
    }
}
