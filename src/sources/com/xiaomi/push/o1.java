package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class o1 {

    /* renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f48043a;

    /* renamed from: b, reason: collision with root package name */
    public static String f48044b;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f48043a = simpleDateFormat;
        f48044b = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static hu a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        hu huVar = new hu();
        huVar.d("category_push_stat");
        huVar.a("push_sdk_stat_channel");
        huVar.a(1L);
        huVar.b(str);
        huVar.a(true);
        huVar.b(System.currentTimeMillis());
        huVar.g(z0.b(context).d());
        huVar.e("com.xiaomi.xmsf");
        huVar.f("");
        huVar.c("push_stat");
        return huVar;
    }
}
