package com.amap.api.col.p0003l;

import java.util.Hashtable;
import java.util.Map;

/* compiled from: OfflineDownloadRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bz extends db {

    /* renamed from: a, reason: collision with root package name */
    private String f5188a;

    public bz(String str) {
        this.f5188a = str;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getIPV6URL() {
        return getURL();
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.id
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getURL() {
        return this.f5188a;
    }

    @Override // com.amap.api.col.p0003l.id
    public final boolean isSupportIPV6() {
        return false;
    }
}
