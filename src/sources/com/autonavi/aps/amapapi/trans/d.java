package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fu;
import com.amap.api.col.p0003l.hx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* compiled from: LocationRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d extends hx {

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f9567d;

    /* renamed from: e, reason: collision with root package name */
    public String f9568e;

    /* renamed from: f, reason: collision with root package name */
    public String f9569f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f9570g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f9571h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9572i;

    /* renamed from: j, reason: collision with root package name */
    public String f9573j;

    /* renamed from: k, reason: collision with root package name */
    public Map<String, String> f9574k;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9575p;

    /* renamed from: q, reason: collision with root package name */
    private String f9576q;

    public d(Context context, fu fuVar) {
        super(context, fuVar);
        this.f9567d = null;
        this.f9576q = "";
        this.f9568e = "";
        this.f9569f = "";
        this.f9570g = null;
        this.f9571h = null;
        this.f9572i = false;
        this.f9573j = null;
        this.f9574k = null;
        this.f9575p = false;
    }

    public final void a(Map<String, String> map) {
        this.f9574k = map;
    }

    public final void b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(hx.a(bArr));
                    byteArrayOutputStream2.write(bArr);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        th.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                return;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            }
            this.f9571h = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void c(byte[] bArr) {
        this.f9570g = bArr;
    }

    @Override // com.amap.api.col.p0003l.hx
    public final byte[] d() {
        return this.f9571h;
    }

    @Override // com.amap.api.col.p0003l.hx
    public final boolean f() {
        return this.f9572i;
    }

    @Override // com.amap.api.col.p0003l.hx
    public final String g() {
        return this.f9573j;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getIPDNSName() {
        return this.f9576q;
    }

    @Override // com.amap.api.col.p0003l.fp, com.amap.api.col.p0003l.id
    public final String getIPV6URL() {
        return this.f9569f;
    }

    @Override // com.amap.api.col.p0003l.hx, com.amap.api.col.p0003l.id
    public final Map<String, String> getParams() {
        return this.f9574k;
    }

    @Override // com.amap.api.col.p0003l.id
    public final Map<String, String> getRequestHead() {
        return this.f9567d;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getSDKName() {
        return "loc";
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getURL() {
        return this.f9568e;
    }

    @Override // com.amap.api.col.p0003l.hx
    public final boolean h() {
        return this.f9575p;
    }

    public final void a(String str) {
        this.f9573j = str;
    }

    public final void c(String str) {
        this.f9569f = str;
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f9576q = str;
        } else {
            this.f9576q = "";
        }
    }

    public final void a(boolean z10) {
        this.f9572i = z10;
    }

    @Override // com.amap.api.col.p0003l.hx
    public final byte[] c() {
        return this.f9570g;
    }

    public final void b(String str) {
        this.f9568e = str;
    }

    public final void b(Map<String, String> map) {
        this.f9567d = map;
    }

    public final void b(boolean z10) {
        this.f9575p = z10;
    }
}
