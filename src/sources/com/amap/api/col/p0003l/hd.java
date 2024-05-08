package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: SPConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hd {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f6245a = new HashMap<>();

    public static void a(Context context, fu fuVar, String str, String str2) {
        if (fuVar == null || TextUtils.isEmpty(fuVar.a())) {
            return;
        }
        String str3 = str + fuVar.a();
        f6245a.put(fuVar.a() + str, str2);
        if (context == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") || TextUtils.isEmpty(str2)) {
            return;
        }
        String g3 = fv.g(fh.a(fv.a(str2)));
        SharedPreferences.Editor edit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        edit.putString(str3, g3);
        edit.commit();
    }

    public static String a(Context context, fu fuVar, String str) {
        if (fuVar == null || TextUtils.isEmpty(fuVar.a())) {
            return null;
        }
        String str2 = f6245a.get(fuVar.a() + str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = str + fuVar.a();
        return (context == null || TextUtils.isEmpty(str3)) ? "" : fv.a(fh.b(fv.d(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(str3, ""))));
    }
}
