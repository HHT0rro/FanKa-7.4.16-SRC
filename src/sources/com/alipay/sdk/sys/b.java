package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.data.c;
import com.ta.utdid2.device.UTDevice;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f4676a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4677b;

    private b() {
    }

    public static b a() {
        if (f4676a == null) {
            f4676a = new b();
        }
        return f4676a;
    }

    public static boolean d() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i10 = 0; i10 < 10; i10++) {
            if (new File(strArr[i10]).exists()) {
                return true;
            }
        }
        return false;
    }

    public Context b() {
        return this.f4677b;
    }

    public c c() {
        return c.b();
    }

    public String e() {
        try {
            return UTDevice.getUtdid(this.f4677b);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4435e, com.alipay.sdk.app.statistic.c.f4441k, th);
            return "";
        }
    }

    public void a(Context context, c cVar) {
        this.f4677b = context.getApplicationContext();
    }
}
