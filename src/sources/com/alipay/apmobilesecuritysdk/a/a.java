package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.os.Environment;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import f0.c;
import f0.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f4297a;

    /* renamed from: b, reason: collision with root package name */
    private com.alipay.apmobilesecuritysdk.b.a f4298b = com.alipay.apmobilesecuritysdk.b.a.a();

    /* renamed from: c, reason: collision with root package name */
    private int f4299c = 4;

    public a(Context context) {
        this.f4297a = context;
    }

    public static String a(Context context) {
        String b4 = b(context);
        return z.a.d(b4) ? h.f(context) : b4;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String a10 = i.a(str);
            if (!z.a.d(a10)) {
                return a10;
            }
            String a11 = g.a(context, str);
            i.a(str, a11);
            return !z.a.d(a11) ? a11 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtils.STARD_FROMAT);
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i10 = 0; i10 < 3; i10++) {
            try {
                String[] split = strArr[i10].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(parse2);
                    calendar.add(13, random);
                    Date time = calendar.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b b4;
        b c4;
        String str4 = "";
        try {
            Context context = this.f4297a;
            d dVar = new d();
            String c10 = z.a.c(map, "appName", "");
            String c11 = z.a.c(map, "sessionId", "");
            String c12 = z.a.c(map, "rpcVersion", "");
            String a10 = a(context, c10);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String d10 = h.d(context);
            if (z.a.g(c11)) {
                dVar.i(c11);
            } else {
                dVar.i(a10);
            }
            dVar.k(securityToken);
            dVar.m(d10);
            dVar.e("android");
            com.alipay.apmobilesecuritysdk.e.c c13 = com.alipay.apmobilesecuritysdk.e.d.c(context);
            if (c13 != null) {
                str2 = c13.a();
                str = c13.c();
            } else {
                str = "";
                str2 = str;
            }
            if (z.a.d(str2) && (c4 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = c4.a();
                str = c4.c();
            }
            com.alipay.apmobilesecuritysdk.e.c b10 = com.alipay.apmobilesecuritysdk.e.d.b();
            if (b10 != null) {
                str4 = b10.a();
                str3 = b10.c();
            } else {
                str3 = "";
            }
            if (z.a.d(str4) && (b4 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = b4.a();
                str3 = b4.c();
            }
            dVar.p(str2);
            dVar.o(str4);
            dVar.b(c12);
            if (z.a.d(str2)) {
                dVar.g(str4);
                dVar.q(str3);
            } else {
                dVar.g(str2);
                dVar.q(str);
            }
            dVar.c(e.a(context, map));
            return e0.d.c(this.f4297a, this.f4298b.c()).a(dVar);
        } catch (Throwable th) {
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    private static String b(Context context) {
        try {
            String b4 = i.b();
            if (!z.a.d(b4)) {
                return b4;
            }
            com.alipay.apmobilesecuritysdk.e.c b10 = com.alipay.apmobilesecuritysdk.e.d.b(context);
            if (b10 != null) {
                i.a(b10);
                String a10 = b10.a();
                if (z.a.g(a10)) {
                    return a10;
                }
            }
            b b11 = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (b11 == null) {
                return "";
            }
            i.a(b11);
            String a11 = b11.a();
            return z.a.g(a11) ? a11 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i10 = 0; i10 < 5; i10++) {
                String str = strArr[i10];
                File file = new File(Environment.getExternalStorageDirectory(), ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x020f A[Catch: Exception -> 0x024c, TryCatch #0 {Exception -> 0x024c, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:12:0x00be, B:15:0x01f4, B:17:0x020f, B:19:0x0215, B:21:0x021b, B:25:0x0224, B:27:0x022a, B:32:0x00d3, B:34:0x00eb, B:39:0x00f8, B:40:0x010a, B:41:0x0111, B:46:0x0123, B:48:0x0181, B:50:0x018b, B:51:0x0193, B:53:0x01a0, B:55:0x01aa, B:56:0x01b2, B:57:0x01ae, B:58:0x018f, B:60:0x0055, B:62:0x0063, B:65:0x006e, B:67:0x0074, B:70:0x007f, B:73:0x0088, B:76:0x0095, B:80:0x00a2, B:82:0x00b0), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0215 A[Catch: Exception -> 0x024c, TryCatch #0 {Exception -> 0x024c, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:12:0x00be, B:15:0x01f4, B:17:0x020f, B:19:0x0215, B:21:0x021b, B:25:0x0224, B:27:0x022a, B:32:0x00d3, B:34:0x00eb, B:39:0x00f8, B:40:0x010a, B:41:0x0111, B:46:0x0123, B:48:0x0181, B:50:0x018b, B:51:0x0193, B:53:0x01a0, B:55:0x01aa, B:56:0x01b2, B:57:0x01ae, B:58:0x018f, B:60:0x0055, B:62:0x0063, B:65:0x006e, B:67:0x0074, B:70:0x007f, B:73:0x0088, B:76:0x0095, B:80:0x00a2, B:82:0x00b0), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0224 A[Catch: Exception -> 0x024c, TryCatch #0 {Exception -> 0x024c, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:12:0x00be, B:15:0x01f4, B:17:0x020f, B:19:0x0215, B:21:0x021b, B:25:0x0224, B:27:0x022a, B:32:0x00d3, B:34:0x00eb, B:39:0x00f8, B:40:0x010a, B:41:0x0111, B:46:0x0123, B:48:0x0181, B:50:0x018b, B:51:0x0193, B:53:0x01a0, B:55:0x01aa, B:56:0x01b2, B:57:0x01ae, B:58:0x018f, B:60:0x0055, B:62:0x0063, B:65:0x006e, B:67:0x0074, B:70:0x007f, B:73:0x0088, B:76:0x0095, B:80:0x00a2, B:82:0x00b0), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3 A[Catch: Exception -> 0x024c, TryCatch #0 {Exception -> 0x024c, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:12:0x00be, B:15:0x01f4, B:17:0x020f, B:19:0x0215, B:21:0x021b, B:25:0x0224, B:27:0x022a, B:32:0x00d3, B:34:0x00eb, B:39:0x00f8, B:40:0x010a, B:41:0x0111, B:46:0x0123, B:48:0x0181, B:50:0x018b, B:51:0x0193, B:53:0x01a0, B:55:0x01aa, B:56:0x01b2, B:57:0x01ae, B:58:0x018f, B:60:0x0055, B:62:0x0063, B:65:0x006e, B:67:0x0074, B:70:0x007f, B:73:0x0088, B:76:0x0095, B:80:0x00a2, B:82:0x00b0), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.a.a(java.util.Map):int");
    }
}
