package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends k {

    /* renamed from: e, reason: collision with root package name */
    public byte[] f40132e;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, String> f40136i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, String> f40137j;

    /* renamed from: m, reason: collision with root package name */
    private static /* synthetic */ boolean f40127m = true;

    /* renamed from: k, reason: collision with root package name */
    private static byte[] f40125k = null;

    /* renamed from: l, reason: collision with root package name */
    private static Map<String, String> f40126l = null;

    /* renamed from: a, reason: collision with root package name */
    public short f40128a = 0;

    /* renamed from: f, reason: collision with root package name */
    private byte f40133f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f40134g = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f40129b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f40130c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f40131d = null;

    /* renamed from: h, reason: collision with root package name */
    private int f40135h = 0;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40128a, 1);
        jVar.a(this.f40133f, 2);
        jVar.a(this.f40134g, 3);
        jVar.a(this.f40129b, 4);
        jVar.a(this.f40130c, 5);
        jVar.a(this.f40131d, 6);
        jVar.a(this.f40132e, 7);
        jVar.a(this.f40135h, 8);
        jVar.a((Map) this.f40136i, 9);
        jVar.a((Map) this.f40137j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f40127m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        f fVar = (f) obj;
        return l.a(1, (int) fVar.f40128a) && l.a(1, (int) fVar.f40133f) && l.a(1, fVar.f40134g) && l.a(1, fVar.f40129b) && l.a((Object) 1, (Object) fVar.f40130c) && l.a((Object) 1, (Object) fVar.f40131d) && l.a((Object) 1, (Object) fVar.f40132e) && l.a(1, fVar.f40135h) && l.a((Object) 1, (Object) fVar.f40136i) && l.a((Object) 1, (Object) fVar.f40137j);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        try {
            this.f40128a = iVar.a(this.f40128a, 1, true);
            this.f40133f = iVar.a(this.f40133f, 2, true);
            this.f40134g = iVar.a(this.f40134g, 3, true);
            this.f40129b = iVar.a(this.f40129b, 4, true);
            this.f40130c = iVar.b(5, true);
            this.f40131d = iVar.b(6, true);
            if (f40125k == null) {
                f40125k = new byte[]{0};
            }
            this.f40132e = iVar.c(7, true);
            this.f40135h = iVar.a(this.f40135h, 8, true);
            if (f40126l == null) {
                HashMap hashMap = new HashMap();
                f40126l = hashMap;
                hashMap.put("", "");
            }
            this.f40136i = (Map) iVar.a((i) f40126l, 9, true);
            if (f40126l == null) {
                HashMap hashMap2 = new HashMap();
                f40126l = hashMap2;
                hashMap2.put("", "");
            }
            this.f40137j = (Map) iVar.a((i) f40126l, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("RequestPacket decode error " + e.a(this.f40132e));
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb2, int i10) {
        h hVar = new h(sb2, i10);
        hVar.a(this.f40128a, "iVersion");
        hVar.a(this.f40133f, "cPacketType");
        hVar.a(this.f40134g, "iMessageType");
        hVar.a(this.f40129b, "iRequestId");
        hVar.a(this.f40130c, "sServantName");
        hVar.a(this.f40131d, "sFuncName");
        hVar.a(this.f40132e, "sBuffer");
        hVar.a(this.f40135h, "iTimeout");
        hVar.a((Map) this.f40136i, "context");
        hVar.a((Map) this.f40137j, "status");
    }
}
