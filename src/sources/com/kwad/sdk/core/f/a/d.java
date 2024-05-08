package com.kwad.sdk.core.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.alibaba.security.realidentity.build.aq;
import com.inno.innosdk.pb.InnoMain;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    private static String f(Cursor cursor) {
        String str;
        str = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            str = columnIndex > 0 ? cursor.getString(columnIndex) : "";
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex(aq.P);
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return str;
    }

    public final String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            try {
                cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{InnoMain.INNO_KEY_OAID}, null);
                str = f(cursor);
            } finally {
                try {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                } catch (Throwable th) {
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        } catch (Exception unused) {
            return str;
        }
    }
}
