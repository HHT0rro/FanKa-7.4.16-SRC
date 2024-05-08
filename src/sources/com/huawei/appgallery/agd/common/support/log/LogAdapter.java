package com.huawei.appgallery.agd.common.support.log;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.appgallery.agd.common.flavor.ReportErrorLogListener;
import com.huawei.openalliance.ad.constant.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LogAdapter {

    /* renamed from: b, reason: collision with root package name */
    public static ReportErrorLogListener f27371b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f27372c;

    /* renamed from: a, reason: collision with root package name */
    public final String f27373a;

    public LogAdapter(String str) {
        this.f27373a = str;
    }

    public static void setDebugMode(boolean z10) {
        f27372c = z10;
    }

    public static void setReportErrorLogListener(ReportErrorLogListener reportErrorLogListener) {
        f27371b = reportErrorLogListener;
    }

    public final void a(int i10, String str, String str2, Throwable th) {
        if (str2 == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = '[' + str + "] " + str2;
        }
        if (th != null) {
            str2 = str2 + th.getMessage();
        }
        if (FlavorApi.getConfig().isPrintLog(i10) || f27372c) {
            int length = str2.length();
            if (length <= 3584) {
                Log.println(i10, this.f27373a, str2);
                return;
            }
            Log.println(i10, this.f27373a, "message is over length, length = " + str2.length());
            int i11 = length / 3584;
            int i12 = 0;
            while (i12 <= i11) {
                int i13 = i12 + 1;
                int i14 = i13 * 3584;
                if (i14 >= length) {
                    Log.println(i10, this.f27373a, "chunk " + i12 + " of " + i11 + u.bD + str2.substring(i12 * 3584));
                } else {
                    Log.println(i10, this.f27373a, "chunk " + i12 + " of " + i11 + u.bD + str2.substring(i12 * 3584, i14));
                }
                i12 = i13;
            }
        }
    }

    public void d(String str, String str2) {
        a(3, str, str2, null);
    }

    public void d(String str, String str2, Throwable th) {
        a(3, str, str2, th);
    }

    public void e(String str, String str2) {
        a(6, str, str2, null);
        ReportErrorLogListener reportErrorLogListener = f27371b;
        if (reportErrorLogListener != null) {
            reportErrorLogListener.onErrorLogReport(str, str2, null);
        }
    }

    public void e(String str, String str2, Throwable th) {
        a(6, str, str2, th);
        ReportErrorLogListener reportErrorLogListener = f27371b;
        if (reportErrorLogListener != null) {
            reportErrorLogListener.onErrorLogReport(str, str2, th);
        }
    }

    public void i(String str, String str2) {
        a(4, str, str2, null);
    }

    public void i(String str, String str2, Throwable th) {
        a(4, str, str2, th);
    }

    public void w(String str, String str2) {
        a(5, str, str2, null);
    }

    public void w(String str, String str2, Throwable th) {
        a(5, str, str2, th);
    }
}
