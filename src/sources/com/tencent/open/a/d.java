package com.tencent.open.a;

import android.os.SystemClock;
import com.tencent.open.utils.l;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static d f45163a;

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f45163a == null) {
                f45163a = new d();
            }
            dVar = f45163a;
        }
        return dVar;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        g.a().a(l.a(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        g.a().a(l.a(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        g.a().a(l.a(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }

    public void a(int i10, String str, String str2, String str3, String str4, Long l10, int i11, int i12, String str5) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - l10.longValue();
        if (l10.longValue() == 0 || elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        StringBuffer stringBuffer = new StringBuffer("https://huatuocode.huatuo.qq.com");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i10);
        stringBuffer.append("&code=");
        stringBuffer.append(i11);
        stringBuffer.append("&time=");
        stringBuffer.append(elapsedRealtime);
        stringBuffer.append("&rate=");
        stringBuffer.append(i12);
        stringBuffer.append("&uin=");
        stringBuffer.append(str2);
        stringBuffer.append("&data=");
        g.a().a(stringBuffer.toString(), "GET", l.a(String.valueOf(i10), String.valueOf(i11), String.valueOf(elapsedRealtime), String.valueOf(i12), str, str2, str3, str4, str5), true);
    }
}
