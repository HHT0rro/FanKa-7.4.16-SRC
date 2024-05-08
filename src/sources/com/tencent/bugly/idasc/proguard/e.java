package com.tencent.bugly.idasc.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends d {

    /* renamed from: h, reason: collision with root package name */
    public static HashMap<String, byte[]> f39876h;

    /* renamed from: i, reason: collision with root package name */
    public static HashMap<String, HashMap<String, byte[]>> f39877i;

    /* renamed from: g, reason: collision with root package name */
    public g f39878g;

    /* renamed from: j, reason: collision with root package name */
    private int f39879j;

    public e() {
        g gVar = new g();
        this.f39878g = gVar;
        this.f39879j = 0;
        gVar.f39885a = (short) 2;
    }

    @Override // com.tencent.bugly.idasc.proguard.d, com.tencent.bugly.idasc.proguard.c
    public final <T> void a(String str, T t2) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
        }
        super.a(str, (String) t2);
    }

    @Override // com.tencent.bugly.idasc.proguard.d, com.tencent.bugly.idasc.proguard.c
    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            k kVar = new k(bArr, (byte) 0);
            kVar.a(this.f39870c);
            this.f39878g.a(kVar);
            g gVar = this.f39878g;
            if (gVar.f39885a == 3) {
                k kVar2 = new k(gVar.f39891g);
                kVar2.a(this.f39870c);
                if (f39876h == null) {
                    HashMap<String, byte[]> hashMap = new HashMap<>();
                    f39876h = hashMap;
                    hashMap.put("", new byte[0]);
                }
                ((d) this).f39873e = kVar2.a((Map) f39876h, 0, false);
                return;
            }
            k kVar3 = new k(gVar.f39891g);
            kVar3.a(this.f39870c);
            if (f39877i == null) {
                f39877i = new HashMap<>();
                HashMap<String, byte[]> hashMap2 = new HashMap<>();
                hashMap2.put("", new byte[0]);
                f39877i.put("", hashMap2);
            }
            this.f39868a = kVar3.a((Map) f39877i, 0, false);
            this.f39869b = new HashMap<>();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.d, com.tencent.bugly.idasc.proguard.c
    public final byte[] a() {
        g gVar = this.f39878g;
        if (gVar.f39885a != 2) {
            if (gVar.f39889e == null) {
                gVar.f39889e = "";
            }
            if (gVar.f39890f == null) {
                gVar.f39890f = "";
            }
        } else {
            if (gVar.f39889e.equals("")) {
                throw new IllegalArgumentException("servantName can not is null");
            }
            if (this.f39878g.f39890f.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        }
        l lVar = new l(0);
        lVar.a(this.f39870c);
        lVar.a((Map) (this.f39878g.f39885a == 2 ? this.f39868a : ((d) this).f39873e), 0);
        this.f39878g.f39891g = n.a(lVar.f39901a);
        l lVar2 = new l(0);
        lVar2.a(this.f39870c);
        this.f39878g.a(lVar2);
        byte[] a10 = n.a(lVar2.f39901a);
        int length = a10.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a10).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.idasc.proguard.d
    public final void b() {
        super.b();
        this.f39878g.f39885a = (short) 3;
    }

    public final void b(String str) {
        this.f39878g.f39889e = str;
    }

    public final void c() {
        this.f39878g.f39888d = 1;
    }

    public final void c(String str) {
        this.f39878g.f39890f = str;
    }
}
