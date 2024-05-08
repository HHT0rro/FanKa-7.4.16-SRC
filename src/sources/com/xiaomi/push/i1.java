package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.k1;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i1 extends k1.d {

    /* renamed from: j, reason: collision with root package name */
    public String f47504j;

    public i1(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f47504j = str2;
    }

    public static i1 i(Context context, String str, hu huVar) {
        byte[] c4 = o6.c(huVar);
        if (c4 == null || c4.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", huVar.d());
        contentValues.put("messageItem", c4);
        contentValues.put("appId", z0.b(context).l());
        contentValues.put("packageName", z0.b(context).d());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new i1(str, contentValues, "a job build to insert message to db");
    }
}
