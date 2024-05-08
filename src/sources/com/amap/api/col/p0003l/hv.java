package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.id;
import java.util.Map;

/* compiled from: ADIURequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hv extends id {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f6307a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f6308b;

    public hv(byte[] bArr, Map<String, String> map) {
        this.f6307a = bArr;
        this.f6308b = map;
        setDegradeAbility(id.a.SINGLE);
        setHttpProtocol(id.c.HTTPS);
    }

    @Override // com.amap.api.col.p0003l.id
    public final byte[] getEntityBytes() {
        return this.f6307a;
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getParams() {
        return this.f6308b;
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
