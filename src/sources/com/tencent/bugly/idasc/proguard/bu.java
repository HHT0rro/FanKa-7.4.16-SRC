package com.tencent.bugly.idasc.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bu extends m {

    /* renamed from: i, reason: collision with root package name */
    public static Map<String, String> f39852i;

    /* renamed from: a, reason: collision with root package name */
    public long f39853a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f39854b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f39855c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f39856d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f39857e = "";

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f39858f = null;

    /* renamed from: g, reason: collision with root package name */
    public String f39859g = "";

    /* renamed from: h, reason: collision with root package name */
    public boolean f39860h = true;

    static {
        HashMap hashMap = new HashMap();
        f39852i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f39853a = kVar.a(this.f39853a, 0, true);
        this.f39854b = kVar.a(this.f39854b, 1, true);
        this.f39855c = kVar.b(2, false);
        this.f39856d = kVar.b(3, false);
        this.f39857e = kVar.b(4, false);
        this.f39858f = (Map) kVar.a((k) f39852i, 5, false);
        this.f39859g = kVar.b(6, false);
        this.f39860h = kVar.a(7, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39853a, 0);
        lVar.a(this.f39854b, 1);
        String str = this.f39855c;
        if (str != null) {
            lVar.a(str, 2);
        }
        String str2 = this.f39856d;
        if (str2 != null) {
            lVar.a(str2, 3);
        }
        String str3 = this.f39857e;
        if (str3 != null) {
            lVar.a(str3, 4);
        }
        Map<String, String> map = this.f39858f;
        if (map != null) {
            lVar.a((Map) map, 5);
        }
        String str4 = this.f39859g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        lVar.a(this.f39860h, 7);
    }
}
