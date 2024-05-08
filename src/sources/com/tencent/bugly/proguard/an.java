package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class an extends k {

    /* renamed from: i, reason: collision with root package name */
    private static byte[] f40075i;

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, String> f40076j;

    /* renamed from: a, reason: collision with root package name */
    public byte f40077a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f40078b = 0;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f40079c = null;

    /* renamed from: f, reason: collision with root package name */
    private String f40082f = "";

    /* renamed from: d, reason: collision with root package name */
    public long f40080d = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f40083g = "";

    /* renamed from: e, reason: collision with root package name */
    public String f40081e = "";

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f40084h = null;

    static {
        f40075i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f40076j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40077a, 0);
        jVar.a(this.f40078b, 1);
        byte[] bArr = this.f40079c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
        String str = this.f40082f;
        if (str != null) {
            jVar.a(str, 3);
        }
        jVar.a(this.f40080d, 4);
        String str2 = this.f40083g;
        if (str2 != null) {
            jVar.a(str2, 5);
        }
        String str3 = this.f40081e;
        if (str3 != null) {
            jVar.a(str3, 6);
        }
        Map<String, String> map = this.f40084h;
        if (map != null) {
            jVar.a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40077a = iVar.a(this.f40077a, 0, true);
        this.f40078b = iVar.a(this.f40078b, 1, true);
        this.f40079c = iVar.c(2, false);
        this.f40082f = iVar.b(3, false);
        this.f40080d = iVar.a(this.f40080d, 4, false);
        this.f40083g = iVar.b(5, false);
        this.f40081e = iVar.b(6, false);
        this.f40084h = (Map) iVar.a((i) f40076j, 7, false);
    }
}
