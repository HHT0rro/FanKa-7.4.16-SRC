package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4735a = "pref_trade_token";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4736b = ";";

    /* renamed from: c, reason: collision with root package name */
    public static final String f4737c = "result={";

    /* renamed from: d, reason: collision with root package name */
    public static final String f4738d = "}";

    /* renamed from: e, reason: collision with root package name */
    public static final String f4739e = "trade_token=\"";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4740f = "\"";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4741g = "trade_token=";

    public static void a(Context context, String str) {
        try {
            String a10 = a(str);
            c.b("", "PayResultUtil::saveTradeToken > tradeToken:" + a10);
            if (TextUtils.isEmpty(a10)) {
                return;
            }
            j.a(context, f4735a, a10);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.f4456z, th);
            c.a(th);
        }
    }

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(";");
        for (int i10 = 0; i10 < split.length; i10++) {
            if (split[i10].startsWith(f4737c) && split[i10].endsWith(f4738d)) {
                String[] split2 = split[i10].substring(8, split[i10].length() - 1).split("&");
                int i11 = 0;
                while (true) {
                    if (i11 >= split2.length) {
                        break;
                    }
                    if (split2[i11].startsWith(f4739e) && split2[i11].endsWith("\"")) {
                        str2 = split2[i11].substring(13, split2[i11].length() - 1);
                        break;
                    }
                    if (split2[i11].startsWith(f4741g)) {
                        str2 = split2[i11].substring(12);
                        break;
                    }
                    i11++;
                }
            }
        }
        return str2;
    }

    public static String a(Context context) {
        String b4 = j.b(context, f4735a, "");
        c.b("", "PayResultUtil::fetchTradeToken > tradeToken:" + b4);
        return b4;
    }
}
