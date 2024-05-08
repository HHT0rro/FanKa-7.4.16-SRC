package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import o6.k;
import o6.t;

/* compiled from: HttpMediaDrmCallback.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i implements j {

    /* renamed from: a, reason: collision with root package name */
    public final HttpDataSource.a f19987a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f19988b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19989c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, String> f19990d;

    public i(@Nullable String str, boolean z10, HttpDataSource.a aVar) {
        com.google.android.exoplayer2.util.a.a((z10 && TextUtils.isEmpty(str)) ? false : true);
        this.f19987a = aVar;
        this.f19988b = str;
        this.f19989c = z10;
        this.f19990d = new HashMap();
    }

    public static byte[] c(HttpDataSource.a aVar, String str, @Nullable byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        t tVar = new t(aVar.a());
        com.google.android.exoplayer2.upstream.b a10 = new b.C0209b().j(str).e(map).d(2).c(bArr).b(1).a();
        int i10 = 0;
        com.google.android.exoplayer2.upstream.b bVar = a10;
        while (true) {
            try {
                k kVar = new k(tVar, bVar);
                try {
                    return j0.S0(kVar);
                } catch (HttpDataSource.InvalidResponseCodeException e2) {
                    String d10 = d(e2, i10);
                    if (d10 != null) {
                        i10++;
                        bVar = bVar.a().j(d10).a();
                    } else {
                        throw e2;
                    }
                } finally {
                    j0.o(kVar);
                }
            } catch (Exception e10) {
                throw new MediaDrmCallbackException(a10, (Uri) com.google.android.exoplayer2.util.a.e(tVar.t()), tVar.e(), tVar.n(), e10);
            }
        }
    }

    @Nullable
    public static String d(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i10) {
        Map<String, List<String>> map;
        List<String> list;
        int i11 = invalidResponseCodeException.responseCode;
        if (!((i11 == 307 || i11 == 308) && i10 < 5) || (map = invalidResponseCodeException.headerFields) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] a(UUID uuid, g.a aVar) throws MediaDrmCallbackException {
        String str;
        String b4 = aVar.b();
        if (this.f19989c || TextUtils.isEmpty(b4)) {
            b4 = this.f19988b;
        }
        if (!TextUtils.isEmpty(b4)) {
            HashMap hashMap = new HashMap();
            UUID uuid2 = com.google.android.exoplayer2.h.f20708e;
            if (uuid2.equals(uuid)) {
                str = "text/xml";
            } else {
                str = com.google.android.exoplayer2.h.f20706c.equals(uuid) ? "application/json" : "application/octet-stream";
            }
            hashMap.put("Content-Type", str);
            if (uuid2.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.f19990d) {
                hashMap.putAll(this.f19990d);
            }
            return c(this.f19987a, b4, aVar.a(), hashMap);
        }
        throw new MediaDrmCallbackException(new b.C0209b().i(Uri.EMPTY).a(), Uri.EMPTY, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] b(UUID uuid, g.d dVar) throws MediaDrmCallbackException {
        String b4 = dVar.b();
        String E = j0.E(dVar.a());
        StringBuilder sb2 = new StringBuilder(String.valueOf(b4).length() + 15 + String.valueOf(E).length());
        sb2.append(b4);
        sb2.append("&signedRequest=");
        sb2.append(E);
        return c(this.f19987a, sb2.toString(), null, Collections.emptyMap());
    }

    public void e(String str, String str2) {
        com.google.android.exoplayer2.util.a.e(str);
        com.google.android.exoplayer2.util.a.e(str2);
        synchronized (this.f19990d) {
            this.f19990d.put(str, str2);
        }
    }
}
