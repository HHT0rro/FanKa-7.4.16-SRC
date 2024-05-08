package com.tencent.bugly.idasc.proguard;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g extends m {

    /* renamed from: g, reason: collision with root package name */
    public byte[] f39891g;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f39893i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, String> f39894j;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ boolean f39884m = true;

    /* renamed from: k, reason: collision with root package name */
    public static byte[] f39882k = null;

    /* renamed from: l, reason: collision with root package name */
    public static Map<String, String> f39883l = null;

    /* renamed from: a, reason: collision with root package name */
    public short f39885a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f39886b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f39887c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f39888d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f39889e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f39890f = null;

    /* renamed from: h, reason: collision with root package name */
    public int f39892h = 0;

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        try {
            this.f39885a = kVar.a(this.f39885a, 1, true);
            this.f39886b = kVar.a(this.f39886b, 2, true);
            this.f39887c = kVar.a(this.f39887c, 3, true);
            this.f39888d = kVar.a(this.f39888d, 4, true);
            this.f39889e = kVar.b(5, true);
            this.f39890f = kVar.b(6, true);
            if (f39882k == null) {
                f39882k = new byte[]{0};
            }
            this.f39891g = kVar.c(7, true);
            this.f39892h = kVar.a(this.f39892h, 8, true);
            if (f39883l == null) {
                HashMap hashMap = new HashMap();
                f39883l = hashMap;
                hashMap.put("", "");
            }
            this.f39893i = (Map) kVar.a((k) f39883l, 9, true);
            if (f39883l == null) {
                HashMap hashMap2 = new HashMap();
                f39883l = hashMap2;
                hashMap2.put("", "");
            }
            this.f39894j = (Map) kVar.a((k) f39883l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("RequestPacket decode error " + f.a(this.f39891g));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39885a, 1);
        lVar.a(this.f39886b, 2);
        lVar.a(this.f39887c, 3);
        lVar.a(this.f39888d, 4);
        lVar.a(this.f39889e, 5);
        lVar.a(this.f39890f, 6);
        lVar.a(this.f39891g, 7);
        lVar.a(this.f39892h, 8);
        lVar.a((Map) this.f39893i, 9);
        lVar.a((Map) this.f39894j, 10);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb2, int i10) {
        i iVar = new i(sb2, i10);
        iVar.a(this.f39885a, "iVersion");
        iVar.a(this.f39886b, "cPacketType");
        iVar.a(this.f39887c, "iMessageType");
        iVar.a(this.f39888d, "iRequestId");
        iVar.a(this.f39889e, "sServantName");
        iVar.a(this.f39890f, "sFuncName");
        iVar.a(this.f39891g, "sBuffer");
        iVar.a(this.f39892h, "iTimeout");
        iVar.a((Map) this.f39893i, "context");
        iVar.a((Map) this.f39894j, "status");
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f39884m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        g gVar = (g) obj;
        return n.a(1, (int) gVar.f39885a) && n.a(1, (int) gVar.f39886b) && n.a(1, gVar.f39887c) && n.a(1, gVar.f39888d) && n.a((Object) 1, (Object) gVar.f39889e) && n.a((Object) 1, (Object) gVar.f39890f) && n.a((Object) 1, (Object) gVar.f39891g) && n.a(1, gVar.f39892h) && n.a((Object) 1, (Object) gVar.f39893i) && n.a((Object) 1, (Object) gVar.f39894j);
    }
}
