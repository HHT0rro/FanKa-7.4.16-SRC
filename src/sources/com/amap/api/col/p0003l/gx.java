package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.id;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gx extends fp {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f6176a;

    /* renamed from: b, reason: collision with root package name */
    private String f6177b;

    public gx(byte[] bArr, String str) {
        this.f6177b = "1";
        this.f6176a = (byte[]) bArr.clone();
        this.f6177b = str;
        setDegradeAbility(id.a.SINGLE);
        setHttpProtocol(id.c.HTTP);
    }

    @Override // com.amap.api.col.p0003l.id
    public final byte[] getEntityBytes() {
        return this.f6176a;
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f6176a.length));
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getURL() {
        String c4 = fv.c(gj.f6090b);
        byte[] a10 = fv.a(gj.f6089a);
        byte[] bArr = new byte[a10.length + 50];
        System.arraycopy((Object) this.f6176a, 0, (Object) bArr, 0, 50);
        System.arraycopy((Object) a10, 0, (Object) bArr, 50, a10.length);
        return String.format(c4, "1", this.f6177b, "1", "open", fq.a(bArr));
    }

    @Override // com.amap.api.col.p0003l.id
    public final boolean isHostToIP() {
        return false;
    }
}
