package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CustomStyleTextureRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ct extends fb<String, a> {

    /* compiled from: CustomStyleTextureRequest.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f5249a;

        /* renamed from: b, reason: collision with root package name */
        public int f5250b = -1;
    }

    public ct(Context context, String str) {
        super(context, str);
        ((fb) this).f5702d = "/map/styles";
    }

    @Override // com.amap.api.col.p0003l.fb
    public final /* bridge */ /* synthetic */ a a(String str) throws fa {
        return null;
    }

    @Override // com.amap.api.col.p0003l.fb
    public final /* synthetic */ a a(byte[] bArr) throws fa {
        return b(bArr);
    }

    public final void b(String str) {
        ((fb) this).f5702d = str;
    }

    @Override // com.amap.api.col.p0003l.fb
    public final String c() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getIPV6URL() {
        return dx.a(getURL());
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.id
    public final Map<String, String> getParams() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", fj.f(((fb) this).f5701c));
        hashMap.put("output", "bin");
        String a10 = fl.a();
        String a11 = fl.a(((fb) this).f5701c, a10, fv.b(hashMap));
        hashMap.put("ts", a10);
        hashMap.put("scode", a11);
        return hashMap;
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getURL() {
        return ((fb) this).f5702d;
    }

    @Override // com.amap.api.col.p0003l.id
    public final boolean isSupportIPV6() {
        return true;
    }

    private static a b(byte[] bArr) throws fa {
        a aVar = new a();
        aVar.f5249a = bArr;
        return aVar;
    }
}
