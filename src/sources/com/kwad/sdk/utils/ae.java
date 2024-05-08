package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ae {
    private static String aPp;
    private static boolean aPq;

    public static String ci(Context context) {
        if (TextUtils.isEmpty(aPp) && !aPq && at.Me()) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
                aPp = k(cursor);
            } catch (Throwable unused) {
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            aPq = TextUtils.isEmpty(aPp);
            return aPp;
        }
        return aPp;
    }

    private static String k(Cursor cursor) {
        int columnIndex;
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex2 = cursor.getColumnIndex("support");
            return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
        }
        com.kwad.sdk.core.e.c.i("MiMarketHelper", "cursor is null");
        return "";
    }
}
