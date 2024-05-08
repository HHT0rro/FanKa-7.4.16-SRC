package com.amap.api.col.s;

import com.amap.api.col.s.dz;
import java.util.Map;

/* compiled from: ADIURequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ds extends dz {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f7739a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f7740b;

    public ds(byte[] bArr, Map<String, String> map) {
        this.f7739a = bArr;
        this.f7740b = map;
        a(dz.a.SINGLE);
        a(dz.c.HTTPS);
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> f() {
        return this.f7740b;
    }

    @Override // com.amap.api.col.s.dz
    public final Map<String, String> g() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final byte[] h() {
        return this.f7739a;
    }
}
