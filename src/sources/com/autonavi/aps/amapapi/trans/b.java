package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.p0003l.fp;
import java.util.Map;

/* compiled from: HttpRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b extends fp {

    /* renamed from: a, reason: collision with root package name */
    public Map<String, String> f9556a = null;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f9557b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f9558c = "";

    /* renamed from: d, reason: collision with root package name */
    public byte[] f9559d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f9560e = null;

    public final void a(Map<String, String> map) {
        this.f9556a = map;
    }

    public final void b(Map<String, String> map) {
        this.f9557b = map;
    }

    @Override // com.amap.api.col.p0003l.id
    public final byte[] getEntityBytes() {
        return this.f9559d;
    }

    @Override // com.amap.api.col.p0003l.fp, com.amap.api.col.p0003l.id
    public final String getIPV6URL() {
        if (!TextUtils.isEmpty(this.f9560e)) {
            return this.f9560e;
        }
        return super.getIPV6URL();
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getParams() {
        return this.f9557b;
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getRequestHead() {
        return this.f9556a;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getURL() {
        return this.f9558c;
    }

    public final void a(String str) {
        this.f9558c = str;
    }

    public final void b(String str) {
        this.f9560e = str;
    }

    public final void a(byte[] bArr) {
        this.f9559d = bArr;
    }
}
