package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class am extends k {

    /* renamed from: y, reason: collision with root package name */
    private static byte[] f40049y;

    /* renamed from: z, reason: collision with root package name */
    private static Map<String, String> f40050z;

    /* renamed from: a, reason: collision with root package name */
    public int f40051a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f40052b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f40053c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f40054d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f40055e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f40056f = "";

    /* renamed from: g, reason: collision with root package name */
    public int f40057g = 0;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f40058h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f40059i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f40060j = "";

    /* renamed from: k, reason: collision with root package name */
    public Map<String, String> f40061k = null;

    /* renamed from: l, reason: collision with root package name */
    public String f40062l = "";

    /* renamed from: m, reason: collision with root package name */
    public long f40063m = 0;

    /* renamed from: n, reason: collision with root package name */
    public String f40064n = "";

    /* renamed from: o, reason: collision with root package name */
    public String f40065o = "";

    /* renamed from: p, reason: collision with root package name */
    public String f40066p = "";

    /* renamed from: q, reason: collision with root package name */
    public long f40067q = 0;

    /* renamed from: u, reason: collision with root package name */
    private String f40071u = "";

    /* renamed from: r, reason: collision with root package name */
    public String f40068r = "";

    /* renamed from: v, reason: collision with root package name */
    private String f40072v = "";

    /* renamed from: w, reason: collision with root package name */
    private String f40073w = "";

    /* renamed from: s, reason: collision with root package name */
    public String f40069s = "";

    /* renamed from: t, reason: collision with root package name */
    public String f40070t = "";

    /* renamed from: x, reason: collision with root package name */
    private String f40074x = "";

    static {
        f40049y = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f40050z = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40051a, 0);
        jVar.a(this.f40052b, 1);
        jVar.a(this.f40053c, 2);
        jVar.a(this.f40054d, 3);
        String str = this.f40055e;
        if (str != null) {
            jVar.a(str, 4);
        }
        jVar.a(this.f40056f, 5);
        jVar.a(this.f40057g, 6);
        jVar.a(this.f40058h, 7);
        String str2 = this.f40059i;
        if (str2 != null) {
            jVar.a(str2, 8);
        }
        String str3 = this.f40060j;
        if (str3 != null) {
            jVar.a(str3, 9);
        }
        Map<String, String> map = this.f40061k;
        if (map != null) {
            jVar.a((Map) map, 10);
        }
        String str4 = this.f40062l;
        if (str4 != null) {
            jVar.a(str4, 11);
        }
        jVar.a(this.f40063m, 12);
        String str5 = this.f40064n;
        if (str5 != null) {
            jVar.a(str5, 13);
        }
        String str6 = this.f40065o;
        if (str6 != null) {
            jVar.a(str6, 14);
        }
        String str7 = this.f40066p;
        if (str7 != null) {
            jVar.a(str7, 15);
        }
        jVar.a(this.f40067q, 16);
        String str8 = this.f40071u;
        if (str8 != null) {
            jVar.a(str8, 17);
        }
        String str9 = this.f40068r;
        if (str9 != null) {
            jVar.a(str9, 18);
        }
        String str10 = this.f40072v;
        if (str10 != null) {
            jVar.a(str10, 19);
        }
        String str11 = this.f40073w;
        if (str11 != null) {
            jVar.a(str11, 20);
        }
        String str12 = this.f40069s;
        if (str12 != null) {
            jVar.a(str12, 21);
        }
        String str13 = this.f40070t;
        if (str13 != null) {
            jVar.a(str13, 22);
        }
        String str14 = this.f40074x;
        if (str14 != null) {
            jVar.a(str14, 23);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40051a = iVar.a(this.f40051a, 0, true);
        this.f40052b = iVar.b(1, true);
        this.f40053c = iVar.b(2, true);
        this.f40054d = iVar.b(3, true);
        this.f40055e = iVar.b(4, false);
        this.f40056f = iVar.b(5, true);
        this.f40057g = iVar.a(this.f40057g, 6, true);
        this.f40058h = iVar.c(7, true);
        this.f40059i = iVar.b(8, false);
        this.f40060j = iVar.b(9, false);
        this.f40061k = (Map) iVar.a((i) f40050z, 10, false);
        this.f40062l = iVar.b(11, false);
        this.f40063m = iVar.a(this.f40063m, 12, false);
        this.f40064n = iVar.b(13, false);
        this.f40065o = iVar.b(14, false);
        this.f40066p = iVar.b(15, false);
        this.f40067q = iVar.a(this.f40067q, 16, false);
        this.f40071u = iVar.b(17, false);
        this.f40068r = iVar.b(18, false);
        this.f40072v = iVar.b(19, false);
        this.f40073w = iVar.b(20, false);
        this.f40069s = iVar.b(21, false);
        this.f40070t = iVar.b(22, false);
        this.f40074x = iVar.b(23, false);
    }
}
