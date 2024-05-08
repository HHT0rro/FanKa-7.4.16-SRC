package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.h.e;
import com.huawei.openalliance.ad.constant.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f29951e = "a";

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Map<String, Map<String, String>>> f29952f = new ConcurrentHashMap(16);

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f29953a = new ConcurrentHashMap(16);

    /* renamed from: b, reason: collision with root package name */
    private final c f29954b;

    /* renamed from: c, reason: collision with root package name */
    private final c f29955c;

    /* renamed from: d, reason: collision with root package name */
    private final g f29956d;

    public a(c cVar, c cVar2, g gVar) {
        this.f29955c = cVar2;
        this.f29954b = cVar;
        this.f29956d = gVar;
        gVar.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l10 = this.f29953a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l10)) {
            bVar.a(2);
            return;
        }
        if (e.a(l10, u.as)) {
            this.f29956d.a(new com.huawei.hms.framework.network.grs.g.j.c(grsBaseInfo, context), null, str, this.f29955c, -1);
        }
        bVar.a(1);
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.f29953a.get(str), u.as)) {
            this.f29956d.a(new com.huawei.hms.framework.network.grs.g.j.c(grsBaseInfo, context), null, null, this.f29955c, -1);
        }
    }

    public c a() {
        return this.f29954b;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        Map<String, Map<String, Map<String, String>>> map = f29952f;
        Map<String, Map<String, String>> map2 = map.get(grsParasKey);
        if (map2 != null && !map2.isEmpty()) {
            a(grsBaseInfo, bVar, context, str);
            return map2.get(str);
        }
        Logger.d(f29951e, "Cache size is: " + map.size());
        return new HashMap();
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.f29954b.b(grsParasKey + "time", "0");
        this.f29953a.remove(grsParasKey + "time");
        Map<String, Map<String, Map<String, String>>> map = f29952f;
        map.remove(grsParasKey);
        Logger.d(f29951e, "Cache size is: " + map.size());
        this.f29956d.a(grsParasKey);
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, com.huawei.hms.framework.network.grs.g.j.c cVar) {
        if (dVar.f() == 2) {
            Logger.w(f29951e, "update cache from server failed");
            return;
        }
        if (cVar.d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (dVar.m()) {
                f29952f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.f29954b.a(grsParasKey, "")));
            } else {
                this.f29954b.b(grsParasKey, dVar.j());
                f29952f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
            }
            if (!TextUtils.isEmpty(dVar.e())) {
                this.f29954b.b(grsParasKey + "ETag", dVar.e());
            }
            this.f29954b.b(grsParasKey + "time", dVar.a());
            this.f29953a.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
        } else {
            this.f29954b.b("geoipCountryCode", dVar.j());
            this.f29954b.b("geoipCountryCodetime", dVar.a());
        }
        Logger.d(f29951e, "Cache size is: " + f29952f.size());
    }

    public g b() {
        return this.f29956d;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String a10 = this.f29954b.a(grsParasKey, "");
        String a11 = this.f29954b.a(grsParasKey + "time", "0");
        long j10 = 0;
        if (!TextUtils.isEmpty(a11) && a11.matches("\\d+")) {
            try {
                j10 = Long.parseLong(a11);
            } catch (NumberFormatException e2) {
                Logger.w(f29951e, "convert urlParamKey from String to Long catch NumberFormatException.", e2);
            }
        }
        Map<String, Map<String, Map<String, String>>> map = f29952f;
        map.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(a10));
        Logger.d(f29951e, "Cache size is: " + map.size());
        this.f29953a.put(grsParasKey, Long.valueOf(j10));
        a(grsBaseInfo, grsParasKey, context);
    }

    public c c() {
        return this.f29955c;
    }
}
