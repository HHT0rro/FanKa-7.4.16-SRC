package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ak extends k {
    private static ArrayList<aj> A;
    private static Map<String, String> B;
    private static Map<String, String> C;

    /* renamed from: v, reason: collision with root package name */
    private static Map<String, String> f40021v;

    /* renamed from: w, reason: collision with root package name */
    private static ai f40022w;

    /* renamed from: x, reason: collision with root package name */
    private static ah f40023x;

    /* renamed from: y, reason: collision with root package name */
    private static ArrayList<ah> f40024y;

    /* renamed from: z, reason: collision with root package name */
    private static ArrayList<ah> f40025z;

    /* renamed from: a, reason: collision with root package name */
    public String f40026a = "";

    /* renamed from: b, reason: collision with root package name */
    public long f40027b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f40028c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f40029d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f40030e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f40031f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f40032g = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f40033h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f40034i = "";

    /* renamed from: j, reason: collision with root package name */
    public ai f40035j = null;

    /* renamed from: k, reason: collision with root package name */
    public int f40036k = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f40037l = "";

    /* renamed from: m, reason: collision with root package name */
    public String f40038m = "";

    /* renamed from: n, reason: collision with root package name */
    public ah f40039n = null;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<ah> f40040o = null;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<ah> f40041p = null;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<aj> f40042q = null;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f40043r = null;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f40044s = null;

    /* renamed from: t, reason: collision with root package name */
    private String f40045t = "";

    /* renamed from: u, reason: collision with root package name */
    private boolean f40046u = true;

    static {
        HashMap hashMap = new HashMap();
        f40021v = hashMap;
        hashMap.put("", "");
        f40022w = new ai();
        f40023x = new ah();
        f40024y = new ArrayList<>();
        f40024y.add(new ah());
        f40025z = new ArrayList<>();
        f40025z.add(new ah());
        A = new ArrayList<>();
        A.add(new aj());
        HashMap hashMap2 = new HashMap();
        B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40026a, 0);
        jVar.a(this.f40027b, 1);
        jVar.a(this.f40028c, 2);
        String str = this.f40029d;
        if (str != null) {
            jVar.a(str, 3);
        }
        String str2 = this.f40030e;
        if (str2 != null) {
            jVar.a(str2, 4);
        }
        String str3 = this.f40031f;
        if (str3 != null) {
            jVar.a(str3, 5);
        }
        String str4 = this.f40032g;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        Map<String, String> map = this.f40033h;
        if (map != null) {
            jVar.a((Map) map, 7);
        }
        String str5 = this.f40034i;
        if (str5 != null) {
            jVar.a(str5, 8);
        }
        ai aiVar = this.f40035j;
        if (aiVar != null) {
            jVar.a((k) aiVar, 9);
        }
        jVar.a(this.f40036k, 10);
        String str6 = this.f40037l;
        if (str6 != null) {
            jVar.a(str6, 11);
        }
        String str7 = this.f40038m;
        if (str7 != null) {
            jVar.a(str7, 12);
        }
        ah ahVar = this.f40039n;
        if (ahVar != null) {
            jVar.a((k) ahVar, 13);
        }
        ArrayList<ah> arrayList = this.f40040o;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 14);
        }
        ArrayList<ah> arrayList2 = this.f40041p;
        if (arrayList2 != null) {
            jVar.a((Collection) arrayList2, 15);
        }
        ArrayList<aj> arrayList3 = this.f40042q;
        if (arrayList3 != null) {
            jVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f40043r;
        if (map2 != null) {
            jVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f40044s;
        if (map3 != null) {
            jVar.a((Map) map3, 18);
        }
        String str8 = this.f40045t;
        if (str8 != null) {
            jVar.a(str8, 19);
        }
        jVar.a(this.f40046u, 20);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40026a = iVar.b(0, true);
        this.f40027b = iVar.a(this.f40027b, 1, true);
        this.f40028c = iVar.b(2, true);
        this.f40029d = iVar.b(3, false);
        this.f40030e = iVar.b(4, false);
        this.f40031f = iVar.b(5, false);
        this.f40032g = iVar.b(6, false);
        this.f40033h = (Map) iVar.a((i) f40021v, 7, false);
        this.f40034i = iVar.b(8, false);
        this.f40035j = (ai) iVar.a((k) f40022w, 9, false);
        this.f40036k = iVar.a(this.f40036k, 10, false);
        this.f40037l = iVar.b(11, false);
        this.f40038m = iVar.b(12, false);
        this.f40039n = (ah) iVar.a((k) f40023x, 13, false);
        this.f40040o = (ArrayList) iVar.a((i) f40024y, 14, false);
        this.f40041p = (ArrayList) iVar.a((i) f40025z, 15, false);
        this.f40042q = (ArrayList) iVar.a((i) A, 16, false);
        this.f40043r = (Map) iVar.a((i) B, 17, false);
        this.f40044s = (Map) iVar.a((i) C, 18, false);
        this.f40045t = iVar.b(19, false);
        this.f40046u = iVar.a(20, false);
    }
}
