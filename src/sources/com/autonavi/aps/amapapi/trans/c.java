package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.fl;
import com.amap.api.col.p0003l.fo;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.fv;
import com.amap.api.col.p0003l.hw;
import com.amap.api.col.p0003l.id;
import com.amap.api.col.p0003l.ie;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DTileBuildType;
import com.autonavi.aps.amapapi.utils.j;
import com.tencent.mmkv.MMKVContentProvider;
import com.wangmai.okhttp.model.HttpHeaders;
import java.util.HashMap;
import java.util.Locale;
import wseemann.media.FFmpegMediaMetadataRetriever;

/* compiled from: LocNetManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static c f9561b;

    /* renamed from: a, reason: collision with root package name */
    public hw f9562a;

    /* renamed from: c, reason: collision with root package name */
    private Context f9563c;

    /* renamed from: d, reason: collision with root package name */
    private int f9564d = com.autonavi.aps.amapapi.utils.b.f9640i;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9565e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f9566f = 0;

    private c(Context context) {
        this.f9562a = null;
        this.f9563c = null;
        try {
            fo.a().a(context);
        } catch (Throwable unused) {
        }
        this.f9563c = context;
        this.f9562a = hw.a();
    }

    public static c a(Context context) {
        if (f9561b == null) {
            f9561b = new c(context);
        }
        return f9561b;
    }

    public final void a(long j10, boolean z10, int i10) {
        try {
            this.f9565e = z10;
            this.f9564d = Long.valueOf(j10).intValue();
            this.f9566f = i10;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LocNetManager", "setOption");
        }
    }

    public final d a(Context context, byte[] bArr, String str, String str2, boolean z10) {
        try {
            HashMap hashMap = new HashMap(16);
            d dVar = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put(HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
                hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.1");
                hashMap.put(MMKVContentProvider.KEY, fj.f(context));
                hashMap.put("enginever", com.autonavi.aps.amapapi.utils.b.f9632a);
                String a10 = fl.a();
                String a11 = fl.a(context, a10, "key=" + fj.f(context));
                hashMap.put("ts", a10);
                hashMap.put("scode", a11);
                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f9632a).doubleValue() >= 5.3d) {
                    hashMap.put("aps_s_src", "openapi");
                }
                hashMap.put("encr", "1");
                dVar.b(hashMap);
                String str3 = z10 ? "loc" : "locf";
                dVar.b(true);
                dVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.1", str3, 3));
                dVar.a(z10);
                dVar.b(str);
                dVar.c(str2);
                dVar.c(j.a(bArr));
                dVar.setProxy(ft.a(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put("policy", AMap3DTileBuildType.AIRPORT_TERMINAL);
                int i10 = this.f9566f;
                if (i10 == 0) {
                    hashMap2.remove("custom");
                } else if (i10 == 1) {
                    hashMap2.put("custom", "language:cn");
                } else if (i10 != 2) {
                    hashMap2.remove("custom");
                } else {
                    hashMap2.put("custom", "language:en");
                }
                dVar.a(hashMap2);
                dVar.setConnectionTimeout(this.f9564d);
                dVar.setSoTimeout(this.f9564d);
                if (!this.f9565e) {
                    return dVar;
                }
                dVar.setHttpProtocol(id.c.HTTPS);
                return dVar;
            } catch (Throwable unused) {
                return dVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final ie a(d dVar) throws Throwable {
        if (this.f9565e) {
            dVar.setHttpProtocol(id.c.HTTPS);
        }
        return hw.a(dVar);
    }

    public final String a(Context context, double d10, double d11) {
        try {
            HashMap hashMap = new HashMap(16);
            d dVar = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put(HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.1");
            HashMap hashMap2 = new HashMap(16);
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put("key", fj.f(context));
            int i10 = this.f9566f;
            if (i10 == 0) {
                hashMap2.remove(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
            } else if (i10 == 1) {
                hashMap2.put(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "zh-CN");
            } else if (i10 != 2) {
                hashMap2.remove(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
            } else {
                hashMap2.put(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "en");
            }
            hashMap2.put("curLocationType", j.m(this.f9563c) ? "coarseLoc" : "fineLoc");
            String a10 = fl.a();
            String a11 = fl.a(context, a10, fv.b(hashMap2));
            hashMap2.put("ts", a10);
            hashMap2.put("scode", a11);
            dVar.b(("output=json&radius=1000&extensions=all&location=" + d11 + "," + d10).getBytes("UTF-8"));
            dVar.b(false);
            dVar.a(true);
            dVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.4.1", "loc", 3));
            dVar.a(hashMap2);
            dVar.b(hashMap);
            dVar.setProxy(ft.a(context));
            dVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.f9640i);
            dVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.f9640i);
            try {
                dVar.c("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
                dVar.b("http://restsdk.amap.com/v3/geocode/regeo");
                if (this.f9565e) {
                    dVar.setHttpProtocol(id.c.HTTPS);
                }
                return new String(hw.a(dVar).f6444a, "utf-8");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "LocNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
        }
    }
}
