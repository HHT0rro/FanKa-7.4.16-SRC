package com.tencent.bugly.idasc.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bo extends m {
    public static ArrayList<bn> A;
    public static Map<String, String> B;
    public static Map<String, String> C;

    /* renamed from: v, reason: collision with root package name */
    public static Map<String, String> f39771v;

    /* renamed from: w, reason: collision with root package name */
    public static bm f39772w;

    /* renamed from: x, reason: collision with root package name */
    public static bl f39773x;

    /* renamed from: y, reason: collision with root package name */
    public static ArrayList<bl> f39774y;

    /* renamed from: z, reason: collision with root package name */
    public static ArrayList<bl> f39775z;

    /* renamed from: a, reason: collision with root package name */
    public String f39776a = "";

    /* renamed from: b, reason: collision with root package name */
    public long f39777b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f39778c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f39779d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f39780e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f39781f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f39782g = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f39783h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f39784i = "";

    /* renamed from: j, reason: collision with root package name */
    public bm f39785j = null;

    /* renamed from: k, reason: collision with root package name */
    public int f39786k = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f39787l = "";

    /* renamed from: m, reason: collision with root package name */
    public String f39788m = "";

    /* renamed from: n, reason: collision with root package name */
    public bl f39789n = null;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<bl> f39790o = null;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<bl> f39791p = null;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<bn> f39792q = null;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f39793r = null;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f39794s = null;

    /* renamed from: t, reason: collision with root package name */
    public String f39795t = "";

    /* renamed from: u, reason: collision with root package name */
    public boolean f39796u = true;

    static {
        HashMap hashMap = new HashMap();
        f39771v = hashMap;
        hashMap.put("", "");
        f39772w = new bm();
        f39773x = new bl();
        f39774y = new ArrayList<>();
        f39774y.add(new bl());
        f39775z = new ArrayList<>();
        f39775z.add(new bl());
        A = new ArrayList<>();
        A.add(new bn());
        HashMap hashMap2 = new HashMap();
        B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f39776a = kVar.b(0, true);
        this.f39777b = kVar.a(this.f39777b, 1, true);
        this.f39778c = kVar.b(2, true);
        this.f39779d = kVar.b(3, false);
        this.f39780e = kVar.b(4, false);
        this.f39781f = kVar.b(5, false);
        this.f39782g = kVar.b(6, false);
        this.f39783h = (Map) kVar.a((k) f39771v, 7, false);
        this.f39784i = kVar.b(8, false);
        this.f39785j = (bm) kVar.a((m) f39772w, 9, false);
        this.f39786k = kVar.a(this.f39786k, 10, false);
        this.f39787l = kVar.b(11, false);
        this.f39788m = kVar.b(12, false);
        this.f39789n = (bl) kVar.a((m) f39773x, 13, false);
        this.f39790o = (ArrayList) kVar.a((k) f39774y, 14, false);
        this.f39791p = (ArrayList) kVar.a((k) f39775z, 15, false);
        this.f39792q = (ArrayList) kVar.a((k) A, 16, false);
        this.f39793r = (Map) kVar.a((k) B, 17, false);
        this.f39794s = (Map) kVar.a((k) C, 18, false);
        this.f39795t = kVar.b(19, false);
        this.f39796u = kVar.a(20, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39776a, 0);
        lVar.a(this.f39777b, 1);
        lVar.a(this.f39778c, 2);
        String str = this.f39779d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f39780e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        String str3 = this.f39781f;
        if (str3 != null) {
            lVar.a(str3, 5);
        }
        String str4 = this.f39782g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        Map<String, String> map = this.f39783h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
        String str5 = this.f39784i;
        if (str5 != null) {
            lVar.a(str5, 8);
        }
        bm bmVar = this.f39785j;
        if (bmVar != null) {
            lVar.a((m) bmVar, 9);
        }
        lVar.a(this.f39786k, 10);
        String str6 = this.f39787l;
        if (str6 != null) {
            lVar.a(str6, 11);
        }
        String str7 = this.f39788m;
        if (str7 != null) {
            lVar.a(str7, 12);
        }
        bl blVar = this.f39789n;
        if (blVar != null) {
            lVar.a((m) blVar, 13);
        }
        ArrayList<bl> arrayList = this.f39790o;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 14);
        }
        ArrayList<bl> arrayList2 = this.f39791p;
        if (arrayList2 != null) {
            lVar.a((Collection) arrayList2, 15);
        }
        ArrayList<bn> arrayList3 = this.f39792q;
        if (arrayList3 != null) {
            lVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f39793r;
        if (map2 != null) {
            lVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f39794s;
        if (map3 != null) {
            lVar.a((Map) map3, 18);
        }
        String str8 = this.f39795t;
        if (str8 != null) {
            lVar.a(str8, 19);
        }
        lVar.a(this.f39796u, 20);
    }
}
