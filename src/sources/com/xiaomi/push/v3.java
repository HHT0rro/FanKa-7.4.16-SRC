package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class v3 implements z3 {
    @Override // com.xiaomi.push.z3
    public void a(Context context, w3 w3Var) {
        if (w3Var != null) {
            d(context, w3Var);
        } else {
            t3.a(context, "activity", 1008, "A receive incorrect message");
        }
    }

    @Override // com.xiaomi.push.z3
    public void b(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            t3.a(context, "activity", 1008, "B receive incorrect message");
        } else {
            c((Activity) context, intent);
        }
    }

    public final void c(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String d10 = s3.d(stringExtra);
            if (!TextUtils.isEmpty(d10)) {
                t3.a(activity.getApplicationContext(), d10, 1007, "play with activity successfully");
                return;
            }
        }
        t3.a(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
    }

    public final void d(Context context, w3 w3Var) {
        String b4 = w3Var.b();
        String e2 = w3Var.e();
        String i10 = w3Var.i();
        int a10 = w3Var.a();
        if (context == null || TextUtils.isEmpty(b4) || TextUtils.isEmpty(e2) || TextUtils.isEmpty(i10)) {
            if (TextUtils.isEmpty(i10)) {
                t3.a(context, "activity", 1008, "argument error");
                return;
            } else {
                t3.a(context, i10, 1008, "argument error");
                return;
            }
        }
        if (!kc.g0.d(context, b4, e2)) {
            t3.a(context, i10, 1003, "B is not ready");
            return;
        }
        t3.a(context, i10, 1002, "B is ready");
        t3.a(context, i10, 1004, "A is ready");
        Intent intent = new Intent(e2);
        intent.setPackage(b4);
        intent.putExtra("awake_info", s3.b(i10));
        intent.addFlags(276824064);
        intent.setAction(e2);
        if (a10 == 1) {
            try {
                if (!x3.m(context)) {
                    t3.a(context, i10, 1008, "A not in foreground");
                    return;
                }
            } catch (Exception e10) {
                fc.c.k(e10);
                t3.a(context, i10, 1008, "A meet a exception when help B's activity");
                return;
            }
        }
        context.startActivity(intent);
        t3.a(context, i10, 1005, "A is successful");
        t3.a(context, i10, 1006, "The job is finished");
    }
}