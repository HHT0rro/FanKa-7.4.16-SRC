package com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.inno.innosdk.pb.InnoMain;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111Il extends l111l1111lI1l {
    private Context l1111l111111Il;

    public l111l11111Il(Context context) {
        this.l1111l111111Il = context;
    }

    @Override // com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        try {
            Cursor query = this.l1111l111111Il.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{InnoMain.INNO_KEY_OAID}, null);
            if (query == null) {
                return "";
            }
            query.moveToFirst();
            int columnIndex = query.getColumnIndex("value");
            String string = columnIndex > 0 ? query.getString(columnIndex) : "";
            query.close();
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }
}
