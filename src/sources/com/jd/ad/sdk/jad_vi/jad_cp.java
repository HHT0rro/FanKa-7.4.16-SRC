package com.jd.ad.sdk.jad_vi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;

/* compiled from: DataBaseEventsStorage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_cp extends com.jd.ad.sdk.jad_qd.jad_an {
    public static jad_cp jad_bo;

    public jad_cp(Context context, String str, int i10) {
        super(context, str, i10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003a -> B:19:0x0047). Please report as a decompilation issue!!! */
    public synchronized void jad_an(jad_dq jad_dqVar, String str) {
        if (jad_dqVar != null) {
            boolean isEmpty = TextUtils.isEmpty(str);
            if (!isEmpty) {
                isEmpty = false;
                isEmpty = false;
                isEmpty = false;
                int i10 = 1;
                try {
                    getWritableDatabase();
                    if (!jad_bo()) {
                        return;
                    }
                    ContentValues jad_bo2 = jad_bo(jad_dqVar, str);
                    int i11 = jad_dqVar.jad_an;
                    if (i11 > 0) {
                        this.jad_an.update("events", jad_bo2, "_id=?", new String[]{String.valueOf(i11)});
                    } else {
                        this.jad_an.insert("events", null, jad_bo2);
                    }
                } catch (Throwable th) {
                    Object[] objArr = new Object[i10];
                    objArr[isEmpty ? 1 : 0] = th;
                    Logger.w("Exception while saving events: ", objArr);
                }
            }
        }
    }

    public final ContentValues jad_bo(jad_dq jad_dqVar, String str) {
        ContentValues contentValues;
        byte[] bytes;
        try {
            contentValues = new ContentValues(4);
            try {
                String jSONObject = jad_dqVar.jad_an().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    String ja2 = ANEProxy.ja(jSONObject);
                    if (!TextUtils.isEmpty(ja2) && (bytes = ja2.getBytes(Charset.forName("UTF-8"))) != null && bytes.length > 0) {
                        contentValues.put("event", new String(bytes));
                        if (!TextUtils.isEmpty(str)) {
                            contentValues.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str);
                        }
                    }
                    return contentValues;
                }
            } catch (Exception e2) {
                e = e2;
                Logger.w("Exception while add event: ", e.getMessage());
                return contentValues;
            }
        } catch (Exception e10) {
            e = e10;
            contentValues = null;
        }
        return contentValues;
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s ,%s)", "events", "event", ContentProviderManager.PLUGIN_PROCESS_NAME));
            }
        } catch (Exception e2) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_CREATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s,%s)", "events", "event", ContentProviderManager.PLUGIN_PROCESS_NAME));
        } catch (Exception e2) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_CREATE_DB_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }

    public synchronized Cursor jad_an(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("events", null, "process_name =?", new String[]{str}, null, null, null);
        } catch (Throwable th) {
            Logger.w("Exception while loading events: ", th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r3.inTransaction() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        r2.jad_an.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        if (r3.inTransaction() != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void jad_an(java.lang.String r3, java.lang.String[] r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L3b
            boolean r0 = r2.jad_bo()     // Catch: java.lang.Throwable -> L3b
            if (r0 != 0) goto L1f
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r3 == 0) goto L19
            boolean r3 = r3.inTransaction()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r3 == 0) goto L19
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            r3.endTransaction()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
        L19:
            monitor-exit(r2)
            return
        L1b:
            r3 = move-exception
            goto L71
        L1d:
            r3 = move-exception
            goto L6c
        L1f:
            android.database.sqlite.SQLiteDatabase r0 = r2.jad_an     // Catch: java.lang.Throwable -> L3b
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L3b
            android.database.sqlite.SQLiteDatabase r0 = r2.jad_an     // Catch: java.lang.Throwable -> L3b
            java.lang.String r1 = "events"
            r0.delete(r1, r3, r4)     // Catch: java.lang.Throwable -> L3b
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L3b
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3b
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r3 == 0) goto L6f
            boolean r3 = r3.inTransaction()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r3 == 0) goto L6f
            goto L55
        L3b:
            r3 = move-exception
            java.lang.String r4 = "Exception while clearing event: "
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L5b
            r1 = 0
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L5b
            r0[r1] = r3     // Catch: java.lang.Throwable -> L5b
            com.jd.ad.sdk.logger.Logger.w(r4, r0)     // Catch: java.lang.Throwable -> L5b
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r3 == 0) goto L6f
            boolean r3 = r3.inTransaction()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r3 == 0) goto L6f
        L55:
            android.database.sqlite.SQLiteDatabase r3 = r2.jad_an     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            r3.endTransaction()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            goto L6f
        L5b:
            r3 = move-exception
            android.database.sqlite.SQLiteDatabase r4 = r2.jad_an     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r4 == 0) goto L6b
            boolean r4 = r4.inTransaction()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            if (r4 == 0) goto L6b
            android.database.sqlite.SQLiteDatabase r4 = r2.jad_an     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            r4.endTransaction()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
        L6b:
            throw r3     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
        L6c:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L1b
        L6f:
            monitor-exit(r2)
            return
        L71:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_vi.jad_cp.jad_an(java.lang.String, java.lang.String[]):void");
    }
}
