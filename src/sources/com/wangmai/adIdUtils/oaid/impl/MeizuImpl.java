package com.wangmai.adIdUtils.oaid.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.inno.innosdk.pb.InnoMain;
import com.wangmai.adIdUtils.oaid.IGetter;
import com.wangmai.adIdUtils.oaid.IOAID;
import com.wangmai.adIdUtils.oaid.OAIDException;
import com.wangmai.adIdUtils.oaid.OAIDLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MeizuImpl implements IOAID {
    public final Context context;

    public MeizuImpl(Context context) {
        this.context = context;
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public void doGet(IGetter iGetter) {
        String string;
        if (this.context == null || iGetter == null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = this.context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{InnoMain.INNO_KEY_OAID}, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                }
                string = cursor.getString(cursor.getColumnIndex("value"));
            } catch (Exception e2) {
                OAIDLog.print(e2);
                iGetter.onOAIDGetError(e2);
                if (0 == 0) {
                    return;
                }
            }
            if (string != null && string.length() != 0) {
                OAIDLog.print("OAID query success: " + string);
                iGetter.onOAIDGetComplete(string);
                cursor.close();
                return;
            }
            throw new OAIDException("OAID query failed");
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.wangmai.adIdUtils.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e2) {
            OAIDLog.print(e2);
            return false;
        }
    }
}
