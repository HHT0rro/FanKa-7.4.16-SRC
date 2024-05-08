package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b4 implements z3 {
    @Override // com.xiaomi.push.z3
    public void a(Context context, w3 w3Var) {
        if (w3Var != null) {
            d(context, w3Var);
        } else {
            t3.a(context, "provider", 1008, "A receive incorrect message");
        }
    }

    @Override // com.xiaomi.push.z3
    public void b(Context context, Intent intent, String str) {
        c(context, str);
    }

    public final void c(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                String[] split = str.split("/");
                if (split.length > 0 && !TextUtils.isEmpty(split[split.length - 1])) {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        t3.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String decode = Uri.decode(str2);
                    if (TextUtils.isEmpty(decode)) {
                        t3.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String d10 = s3.d(decode);
                    if (!TextUtils.isEmpty(d10)) {
                        t3.a(context, d10, 1007, "play with provider successfully");
                        return;
                    }
                }
            }
            t3.a(context, "provider", 1008, "B get a incorrect message");
        } catch (Exception e2) {
            t3.a(context, "provider", 1008, "B meet a exception" + e2.getMessage());
        }
    }

    public final void d(Context context, w3 w3Var) {
        String e2 = w3Var.e();
        String i10 = w3Var.i();
        int a10 = w3Var.a();
        if (context == null || TextUtils.isEmpty(e2) || TextUtils.isEmpty(i10)) {
            if (TextUtils.isEmpty(i10)) {
                t3.a(context, "provider", 1008, "argument error");
                return;
            } else {
                t3.a(context, i10, 1008, "argument error");
                return;
            }
        }
        if (!kc.g0.c(context, e2)) {
            t3.a(context, i10, 1003, "B is not ready");
            return;
        }
        t3.a(context, i10, 1002, "B is ready");
        t3.a(context, i10, 1004, "A is ready");
        String b4 = s3.b(i10);
        try {
            if (TextUtils.isEmpty(b4)) {
                t3.a(context, i10, 1008, "info is empty");
                return;
            }
            if (a10 == 1 && !x3.m(context)) {
                t3.a(context, i10, 1008, "A not in foreground");
                return;
            }
            String type = context.getContentResolver().getType(s3.a(e2, b4));
            if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                t3.a(context, i10, 1008, "A is fail to help B's provider");
            } else {
                t3.a(context, i10, 1005, "A is successful");
                t3.a(context, i10, 1006, "The job is finished");
            }
        } catch (Exception e10) {
            fc.c.k(e10);
            t3.a(context, i10, 1008, "A meet a exception when help B's provider");
        }
    }
}
