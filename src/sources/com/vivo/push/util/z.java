package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: PushClientSdkAppSp.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class z extends c {

    /* renamed from: b, reason: collision with root package name */
    private Context f46456b;

    public z(Context context) {
        if (context != null) {
            this.f46456b = context;
            a(context);
        }
    }

    private synchronized void a(Context context) {
        a(context, "com.vivo.push_preferences.appconfig_v1");
    }

    public final String b() {
        String obj;
        Context context = this.f46456b;
        String packageName = context.getPackageName();
        Object a10 = ag.a(context, packageName, "com.vivo.push.app_id");
        if (a10 != null) {
            obj = a10.toString();
        } else {
            Object a11 = ag.a(context, packageName, "app_id");
            obj = a11 != null ? a11.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? b("APP_APPID", "") : obj;
    }

    public final String c() {
        String obj;
        Context context = this.f46456b;
        String packageName = context.getPackageName();
        Object a10 = ag.a(context, packageName, "com.vivo.push.api_key");
        if (a10 != null) {
            obj = a10.toString();
        } else {
            Object a11 = ag.a(context, packageName, "api_key");
            obj = a11 != null ? a11.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? b("APP_APIKEY", "") : obj;
    }
}
