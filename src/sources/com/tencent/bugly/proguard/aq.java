package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aq extends k {

    /* renamed from: i, reason: collision with root package name */
    private static Map<String, String> f40102i;

    /* renamed from: a, reason: collision with root package name */
    public long f40103a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f40104b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f40105c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f40106d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f40107e = "";

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f40108f = null;

    /* renamed from: h, reason: collision with root package name */
    private String f40110h = "";

    /* renamed from: g, reason: collision with root package name */
    public boolean f40109g = true;

    static {
        HashMap hashMap = new HashMap();
        f40102i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40103a, 0);
        jVar.a(this.f40104b, 1);
        String str = this.f40105c;
        if (str != null) {
            jVar.a(str, 2);
        }
        String str2 = this.f40106d;
        if (str2 != null) {
            jVar.a(str2, 3);
        }
        String str3 = this.f40107e;
        if (str3 != null) {
            jVar.a(str3, 4);
        }
        Map<String, String> map = this.f40108f;
        if (map != null) {
            jVar.a((Map) map, 5);
        }
        String str4 = this.f40110h;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        jVar.a(this.f40109g, 7);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40103a = iVar.a(this.f40103a, 0, true);
        this.f40104b = iVar.a(this.f40104b, 1, true);
        this.f40105c = iVar.b(2, false);
        this.f40106d = iVar.b(3, false);
        this.f40107e = iVar.b(4, false);
        this.f40108f = (Map) iVar.a((i) f40102i, 5, false);
        this.f40110h = iVar.b(6, false);
        this.f40109g = iVar.a(7, false);
    }
}
