package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends c {

    /* renamed from: f, reason: collision with root package name */
    private static HashMap<String, byte[]> f40121f;

    /* renamed from: g, reason: collision with root package name */
    private static HashMap<String, HashMap<String, byte[]>> f40122g;

    /* renamed from: e, reason: collision with root package name */
    private f f40123e;

    public d() {
        f fVar = new f();
        this.f40123e = fVar;
        fVar.f40128a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final <T> void a(String str, T t2) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t2);
        } else {
            throw new IllegalArgumentException("put name can not startwith . , now is " + str);
        }
    }

    public final void b(String str) {
        this.f40123e.f40130c = str;
    }

    @Override // com.tencent.bugly.proguard.c
    public final void c() {
        super.c();
        this.f40123e.f40128a = (short) 3;
    }

    public final void c(String str) {
        this.f40123e.f40131d = str;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final byte[] a() {
        f fVar = this.f40123e;
        if (fVar.f40128a == 2) {
            if (!fVar.f40130c.equals("")) {
                if (this.f40123e.f40131d.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (fVar.f40130c == null) {
                fVar.f40130c = "";
            }
            if (fVar.f40131d == null) {
                fVar.f40131d = "";
            }
        }
        j jVar = new j(0);
        jVar.a(this.f39995b);
        if (this.f40123e.f40128a == 2) {
            jVar.a((Map) this.f39994a, 0);
        } else {
            jVar.a((Map) ((c) this).f40118d, 0);
        }
        this.f40123e.f40132e = l.a(jVar.a());
        j jVar2 = new j(0);
        jVar2.a(this.f39995b);
        this.f40123e.a(jVar2);
        byte[] a10 = l.a(jVar2.a());
        int length = a10.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a10).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                i iVar = new i(bArr, 4);
                iVar.a(this.f39995b);
                this.f40123e.a(iVar);
                f fVar = this.f40123e;
                if (fVar.f40128a == 3) {
                    i iVar2 = new i(fVar.f40132e);
                    iVar2.a(this.f39995b);
                    if (f40121f == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f40121f = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    ((c) this).f40118d = iVar2.a((Map) f40121f, 0, false);
                    return;
                }
                i iVar3 = new i(fVar.f40132e);
                iVar3.a(this.f39995b);
                if (f40122g == null) {
                    f40122g = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f40122g.put("", hashMap2);
                }
                this.f39994a = iVar3.a((Map) f40122g, 0, false);
                new HashMap();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public final void a(int i10) {
        this.f40123e.f40129b = 1;
    }
}
