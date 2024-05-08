package com.amap.api.col.s;

import com.amap.api.col.s.dz;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class de extends cd {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f7663a;

    /* renamed from: b, reason: collision with root package name */
    private String f7664b;

    public de(byte[] bArr, String str) {
        this.f7664b = "1";
        this.f7663a = (byte[]) bArr.clone();
        this.f7664b = str;
        a(dz.a.SINGLE);
        a(dz.c.HTTP);
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        String c4 = ci.c(cr.f7578b);
        byte[] a10 = ci.a(cr.f7577a);
        byte[] bArr = new byte[a10.length + 50];
        System.arraycopy((Object) this.f7663a, 0, (Object) bArr, 0, 50);
        System.arraycopy((Object) a10, 0, (Object) bArr, 50, a10.length);
        return String.format(c4, "1", this.f7664b, "1", "open", ce.a(bArr));
    }

    @Override // com.amap.api.col.s.dz
    public final boolean b_() {
        return false;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> f() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> g() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f7663a.length));
        return hashMap;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] h() {
        return this.f7663a;
    }
}
