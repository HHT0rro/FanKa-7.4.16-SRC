package com.alipay.sdk.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4749a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        if (EnvUtils.isSandBox()) {
            return com.alipay.sdk.cons.a.f4519b;
        }
        if (context == null) {
            return com.alipay.sdk.cons.a.f4518a;
        }
        String str = com.alipay.sdk.cons.a.f4518a;
        return TextUtils.isEmpty(str) ? com.alipay.sdk.cons.a.f4518a : str;
    }

    private static String b(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(f4749a), null, null, null, null);
        if (query != null && query.getCount() > 0) {
            r0 = query.moveToFirst() ? query.getString(query.getColumnIndex("url")) : null;
            query.close();
        }
        return r0;
    }
}
