package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e4 implements z3 {
    @Override // com.xiaomi.push.z3
    public void a(Context context, w3 w3Var) {
        if (w3Var != null) {
            d(context, w3Var.b(), w3Var.g(), w3Var.i());
        }
    }

    @Override // com.xiaomi.push.z3
    public void b(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            return;
        }
        c((Service) context, intent);
    }

    public final void c(Service service, Intent intent) {
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("waker_pkgname");
            String stringExtra2 = intent.getStringExtra("awake_info");
            if (TextUtils.isEmpty(stringExtra)) {
                t3.a(service.getApplicationContext(), "service", 1007, "old version message");
                return;
            }
            if (TextUtils.isEmpty(stringExtra2)) {
                t3.a(service.getApplicationContext(), stringExtra, 1007, "play with service ");
                return;
            }
            String d10 = s3.d(stringExtra2);
            boolean isEmpty = TextUtils.isEmpty(d10);
            Context applicationContext = service.getApplicationContext();
            if (isEmpty) {
                t3.a(applicationContext, "service", 1008, "B get a incorrect message");
            } else {
                t3.a(applicationContext, d10, 1007, "old version message ");
            }
        }
    }

    public final void d(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                t3.a(context, "service", 1008, "argument error");
                return;
            } else {
                t3.a(context, str3, 1008, "argument error");
                return;
            }
        }
        if (!kc.g0.a(context, str)) {
            t3.a(context, str3, 1003, "B is not ready");
            return;
        }
        t3.a(context, str3, 1002, "B is ready");
        t3.a(context, str3, 1004, "A is ready");
        try {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
            intent.putExtra("waker_pkgname", context.getPackageName());
            intent.putExtra("awake_info", s3.b(str3));
            if (context.startService(intent) == null) {
                t3.a(context, str3, 1008, "A is fail to help B's service");
            } else {
                t3.a(context, str3, 1005, "A is successful");
                t3.a(context, str3, 1006, "The job is finished");
            }
        } catch (Exception e2) {
            fc.c.k(e2);
            t3.a(context, str3, 1008, "A meet a exception when help B's service");
        }
    }
}
