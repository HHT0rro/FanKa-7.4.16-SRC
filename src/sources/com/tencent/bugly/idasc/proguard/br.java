package com.tencent.bugly.idasc.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class br extends m {

    /* renamed from: i, reason: collision with root package name */
    public static byte[] f39825i;

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, String> f39826j;

    /* renamed from: a, reason: collision with root package name */
    public byte f39827a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f39828b = 0;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f39829c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f39830d = "";

    /* renamed from: e, reason: collision with root package name */
    public long f39831e = 0;

    /* renamed from: f, reason: collision with root package name */
    public String f39832f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f39833g = "";

    /* renamed from: h, reason: collision with root package name */
    public Map<String, String> f39834h = null;

    static {
        f39825i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f39826j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f39827a = kVar.a(this.f39827a, 0, true);
        this.f39828b = kVar.a(this.f39828b, 1, true);
        this.f39829c = kVar.c(2, false);
        this.f39830d = kVar.b(3, false);
        this.f39831e = kVar.a(this.f39831e, 4, false);
        this.f39832f = kVar.b(5, false);
        this.f39833g = kVar.b(6, false);
        this.f39834h = (Map) kVar.a((k) f39826j, 7, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39827a, 0);
        lVar.a(this.f39828b, 1);
        byte[] bArr = this.f39829c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
        String str = this.f39830d;
        if (str != null) {
            lVar.a(str, 3);
        }
        lVar.a(this.f39831e, 4);
        String str2 = this.f39832f;
        if (str2 != null) {
            lVar.a(str2, 5);
        }
        String str3 = this.f39833g;
        if (str3 != null) {
            lVar.a(str3, 6);
        }
        Map<String, String> map = this.f39834h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
    }
}
