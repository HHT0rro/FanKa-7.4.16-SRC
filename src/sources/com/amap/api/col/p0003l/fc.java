package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: AbstractBasicLbsRestHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class fc<T, V> extends fb<T, V> {
    public fc(Context context, T t2) {
        super(context, t2);
    }

    @Override // com.amap.api.col.p0003l.fb
    public abstract V a(String str) throws fa;

    @Override // com.amap.api.col.p0003l.fb
    public abstract String c();

    @Override // com.amap.api.col.p0003l.id
    public byte[] getEntityBytes() {
        try {
            return c().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.id
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.fb, com.amap.api.col.p0003l.id
    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 9.8.3");
        hashMap.put("x-INFO", fl.b(((fb) this).f5701c));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "9.8.3", "trace"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
