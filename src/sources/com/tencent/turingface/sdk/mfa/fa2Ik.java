package com.tencent.turingface.sdk.mfa;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class fa2Ik extends ucT3w {

    /* renamed from: a, reason: collision with root package name */
    public static Map<Integer, byte[]> f45775a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static ShGzN f45776b;

    /* renamed from: c, reason: collision with root package name */
    public static DX7Nf f45777c;

    /* renamed from: d, reason: collision with root package name */
    public static y8N3A f45778d;

    /* renamed from: e, reason: collision with root package name */
    public static Map<Integer, String> f45779e;

    /* renamed from: f, reason: collision with root package name */
    public static Map<Integer, String> f45780f;

    /* renamed from: g, reason: collision with root package name */
    public long f45781g = 0;

    /* renamed from: h, reason: collision with root package name */
    public Map<Integer, byte[]> f45782h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f45783i = 0;

    /* renamed from: j, reason: collision with root package name */
    public ShGzN f45784j = null;

    /* renamed from: k, reason: collision with root package name */
    public DX7Nf f45785k = null;

    /* renamed from: l, reason: collision with root package name */
    public y8N3A f45786l = null;

    /* renamed from: m, reason: collision with root package name */
    public Map<Integer, String> f45787m = null;

    /* renamed from: n, reason: collision with root package name */
    public Map<Integer, String> f45788n = null;

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map<java.lang.Integer, byte[]>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map<java.lang.Integer, java.lang.String>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.Map<java.lang.Integer, java.lang.String>, java.util.HashMap] */
    static {
        f45775a.put(0, new byte[]{0});
        f45776b = new ShGzN();
        f45777c = new DX7Nf();
        f45778d = new y8N3A();
        f45779e = new HashMap();
        f45779e.put(0, "");
        f45780f = new HashMap();
        f45780f.put(0, "");
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f45781g, 0);
        d5hoq.a((Map) this.f45782h, 1);
        d5hoq.a(this.f45783i, 2);
        d5hoq.a((ucT3w) this.f45784j, 3);
        d5hoq.a((ucT3w) this.f45785k, 4);
        y8N3A y8n3a = this.f45786l;
        if (y8n3a != null) {
            d5hoq.a((ucT3w) y8n3a, 5);
        }
        Map<Integer, String> map = this.f45787m;
        if (map != null) {
            d5hoq.a((Map) map, 6);
        }
        Map<Integer, String> map2 = this.f45788n;
        if (map2 != null) {
            d5hoq.a((Map) map2, 7);
        }
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        this.f45781g = nyvkz.a(this.f45781g, 0, true);
        this.f45782h = (Map) nyvkz.a((nyvKz) f45775a, 1, true);
        this.f45783i = nyvkz.a(this.f45783i, 2, true);
        this.f45784j = (ShGzN) nyvkz.a((ucT3w) f45776b, 3, true);
        this.f45785k = (DX7Nf) nyvkz.a((ucT3w) f45777c, 4, true);
        this.f45786l = (y8N3A) nyvkz.a((ucT3w) f45778d, 5, false);
        this.f45787m = (Map) nyvkz.a((nyvKz) f45779e, 6, false);
        this.f45788n = (Map) nyvkz.a((nyvKz) f45780f, 7, false);
    }
}
