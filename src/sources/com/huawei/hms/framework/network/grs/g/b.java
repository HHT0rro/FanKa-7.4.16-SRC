package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import org.json.JSONException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f29979a;

    /* renamed from: b, reason: collision with root package name */
    private final GrsBaseInfo f29980b;

    /* renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f29981c;

    public b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo) {
        this.f29979a = context;
        this.f29980b = grsBaseInfo;
        this.f29981c = aVar;
    }

    public String a(boolean z10) {
        String str = com.huawei.hms.framework.network.grs.a.a(this.f29981c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + str);
        String a10 = this.f29981c.a().a("geoipCountryCodetime", "0");
        long j10 = 0;
        if (!TextUtils.isEmpty(a10) && a10.matches("\\d+")) {
            try {
                j10 = Long.parseLong(a10);
            } catch (NumberFormatException e2) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e2);
            }
        }
        if (TextUtils.isEmpty(str) || com.huawei.hms.framework.network.grs.h.e.a(Long.valueOf(j10))) {
            com.huawei.hms.framework.network.grs.g.j.c cVar = new com.huawei.hms.framework.network.grs.g.j.c(this.f29980b, this.f29979a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c c4 = this.f29981c.c();
            if (c4 != null) {
                String str2 = null;
                try {
                    str2 = h.a(c4.a("services", ""), cVar.c());
                } catch (JSONException e10) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e10.getMessage()));
                }
                if (!TextUtils.isEmpty(str2)) {
                    c4.b("services", str2);
                }
            }
            if (z10) {
                d a11 = this.f29981c.b().a(cVar, "geoip.countrycode", c4, -1);
                if (a11 != null) {
                    str = com.huawei.hms.framework.network.grs.a.a(a11.j(), "geoip.countrycode").get("ROOT");
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str);
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.f29981c.b().a(cVar, null, "geoip.countrycode", c4, -1);
            }
        }
        return str;
    }
}
