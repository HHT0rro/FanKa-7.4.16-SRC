package com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111I1l extends l111l1111lI1l {
    private Context l1111l111111Il;

    public l11l1111I1l(Context context) {
        this.l1111l111111Il = context;
    }

    @Override // com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        String str;
        Uri parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        ContentResolver contentResolver = this.l1111l111111Il.getContentResolver();
        str = "";
        if (contentResolver == null) {
            return "";
        }
        Cursor query = contentResolver.query(parse, null, null, null, null);
        if (query != null) {
            query.moveToNext();
            int columnIndex = query.getColumnIndex("value");
            str = columnIndex >= 0 ? query.getString(columnIndex) : "";
            query.close();
        }
        return str;
    }
}
