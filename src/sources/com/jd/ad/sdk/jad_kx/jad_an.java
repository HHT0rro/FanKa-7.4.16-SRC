package com.jd.ad.sdk.jad_kx;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PreLoadAdDataBaseStorage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_an extends com.jd.ad.sdk.jad_qd.jad_an {
    public static jad_an jad_cp;
    public static List<String> jad_dq = new ArrayList();
    public List<String> jad_bo;

    /* compiled from: PreLoadAdDataBaseStorage.java */
    /* renamed from: com.jd.ad.sdk.jad_kx.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class RunnableC0372jad_an implements Runnable {
        public RunnableC0372jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_an jad_anVar = jad_an.this;
            List<String> list = jad_an.jad_dq;
            synchronized (jad_anVar) {
                jad_anVar.jad_an(list);
            }
        }
    }

    public jad_an(Context context, String str, int i10) {
        super(context, str, i10);
        this.jad_bo = new ArrayList();
    }

    public static synchronized jad_an jad_dq() {
        jad_an jad_anVar;
        synchronized (jad_an.class) {
            if (jad_cp == null) {
                jad_cp = new jad_an(com.jd.ad.sdk.jad_do.jad_bo.jad_an(), "jaddb.db", 2);
            }
            jad_anVar = jad_cp;
        }
        return jad_anVar;
    }

    public synchronized void jad_an(jad_cp jad_cpVar) {
        try {
            getWritableDatabase();
        } finally {
        }
        if (jad_bo()) {
            ContentValues jad_bo = jad_bo(jad_cpVar);
            int i10 = jad_cpVar.jad_an;
            if (i10 > 0) {
                this.jad_an.update("preloadAd", jad_bo, "_id=?", new String[]{String.valueOf(i10)});
            } else {
                this.jad_an.insert("preloadAd", null, jad_bo);
            }
        }
    }

    public final ContentValues jad_bo(jad_cp jad_cpVar) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
            try {
                contentValues.put("appIdSlotId", jad_cpVar.jad_cp);
                contentValues.put("rId", jad_cpVar.jad_bo);
                contentValues.put("preloadAdJson", ANEProxy.ja(jad_cpVar.jad_dq));
                contentValues.put("preloadAdCacheTimeStamp", jad_cpVar.jad_er);
            } catch (Exception e2) {
                e = e2;
                Logger.w("Exception while add preload ad data: ", e.getMessage());
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
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
            }
        } catch (Exception e2) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
        }
    }

    public synchronized Cursor jad_er() {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, null, null, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (Throwable th) {
            try {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                return null;
            } finally {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.jad_an = sQLiteDatabase;
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT,%s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
        } catch (Exception e2) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preloadAd");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a8, code lost:
    
        if (r1.isClosed() == false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.jd.ad.sdk.jad_kx.jad_cp> jad_an(java.lang.String r15) {
        /*
            r14 = this;
            monitor-enter(r14)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Ldb
            r0.<init>()     // Catch: java.lang.Throwable -> Ldb
            r1 = 0
            r2 = 0
            r3 = 1
            r14.getReadableDatabase()     // Catch: java.lang.Throwable -> Lab
            boolean r4 = r14.jad_bo()     // Catch: java.lang.Throwable -> Lab
            if (r4 != 0) goto L14
            monitor-exit(r14)
            return r0
        L14:
            java.lang.String r8 = "appIdSlotId =?"
            java.lang.String[] r9 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = java.lang.String.valueOf(r15)     // Catch: java.lang.Throwable -> Lab
            r9[r2] = r4     // Catch: java.lang.Throwable -> Lab
            java.lang.String r12 = "preloadAdCacheTimeStamp ASC"
            android.database.sqlite.SQLiteDatabase r5 = r14.jad_an     // Catch: java.lang.Throwable -> Lab
            java.lang.String r6 = "preloadAd"
            r7 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r1 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Lab
            int r4 = r1.getCount()     // Catch: java.lang.Throwable -> Lab
            if (r4 <= 0) goto La4
            r1.moveToFirst()     // Catch: java.lang.Throwable -> Lab
            com.jd.ad.sdk.jad_kx.jad_er r4 = com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an     // Catch: java.lang.Throwable -> Lab
            int r4 = r4.jad_bo()     // Catch: java.lang.Throwable -> Lab
            int r4 = r4 * 1000
            long r4 = (long) r4     // Catch: java.lang.Throwable -> Lab
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lab
            long r6 = r6 - r4
        L42:
            boolean r4 = r1.isAfterLast()     // Catch: java.lang.Throwable -> Lab
            if (r4 != 0) goto L99
            java.lang.String r4 = "_id"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lab
            int r9 = r1.getInt(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = "preloadAdCacheTimeStamp"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r13 = r1.getString(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = "rId"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r11 = r1.getString(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = "preloadAdJson"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.String r12 = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(r4)     // Catch: java.lang.Throwable -> Lab
            boolean r4 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> Lab
            if (r4 != 0) goto L8e
            long r4 = java.lang.Long.parseLong(r13)     // Catch: java.lang.Throwable -> Lab
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L83
            goto L8e
        L83:
            com.jd.ad.sdk.jad_kx.jad_cp r4 = new com.jd.ad.sdk.jad_kx.jad_cp     // Catch: java.lang.Throwable -> Lab
            r8 = r4
            r10 = r15
            r8.<init>(r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> Lab
            r0.add(r4)     // Catch: java.lang.Throwable -> Lab
            goto L95
        L8e:
            java.util.List<java.lang.String> r4 = com.jd.ad.sdk.jad_kx.jad_an.jad_dq     // Catch: java.lang.Throwable -> Lab
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch: java.lang.Throwable -> Lab
            r4.add(r11)     // Catch: java.lang.Throwable -> Lab
        L95:
            r1.moveToNext()     // Catch: java.lang.Throwable -> Lab
            goto L42
        L99:
            r1.close()     // Catch: java.lang.Throwable -> Lab
            com.jd.ad.sdk.jad_kx.jad_an$jad_an r15 = new com.jd.ad.sdk.jad_kx.jad_an$jad_an     // Catch: java.lang.Throwable -> Lab
            r15.<init>()     // Catch: java.lang.Throwable -> Lab
            com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(r15)     // Catch: java.lang.Throwable -> Lab
        La4:
            boolean r15 = r1.isClosed()     // Catch: java.lang.Throwable -> Ldb
            if (r15 != 0) goto Lcc
            goto Lc9
        Lab:
            r15 = move-exception
            java.lang.String r4 = ""
            com.jd.ad.sdk.jad_uh.jad_an r5 = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR     // Catch: java.lang.Throwable -> Lce
            int r6 = r5.jad_an     // Catch: java.lang.Throwable -> Lce
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lce
            java.lang.String r15 = r15.getMessage()     // Catch: java.lang.Throwable -> Lce
            r3[r2] = r15     // Catch: java.lang.Throwable -> Lce
            java.lang.String r15 = r5.jad_an(r3)     // Catch: java.lang.Throwable -> Lce
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an(r4, r6, r15)     // Catch: java.lang.Throwable -> Lce
            if (r1 == 0) goto Lcc
            boolean r15 = r1.isClosed()     // Catch: java.lang.Throwable -> Ldb
            if (r15 != 0) goto Lcc
        Lc9:
            r1.close()     // Catch: java.lang.Throwable -> Ldb
        Lcc:
            monitor-exit(r14)
            return r0
        Lce:
            r15 = move-exception
            if (r1 == 0) goto Lda
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> Ldb
            if (r0 != 0) goto Lda
            r1.close()     // Catch: java.lang.Throwable -> Ldb
        Lda:
            throw r15     // Catch: java.lang.Throwable -> Ldb
        Ldb:
            r15 = move-exception
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_an.jad_an(java.lang.String):java.util.List");
    }

    public synchronized Cursor jad_bo(String str) {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, "appIdSlotId =?", new String[]{String.valueOf(str)}, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (Throwable th) {
            try {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                return null;
            } finally {
            }
        }
    }

    public synchronized void jad_an(List<String> list) {
        SQLiteDatabase sQLiteDatabase;
        if (list != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (list.size() != 0) {
                try {
                    getWritableDatabase();
                } catch (Throwable th) {
                    try {
                        Logger.w("Exception while clearing preload ad data:", th.getMessage());
                        SQLiteDatabase sQLiteDatabase2 = this.jad_an;
                        if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                            sQLiteDatabase = this.jad_an;
                        }
                    } finally {
                        SQLiteDatabase sQLiteDatabase3 = this.jad_an;
                        if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                            this.jad_an.endTransaction();
                        }
                    }
                }
                if (jad_bo()) {
                    this.jad_an.beginTransaction();
                    Iterator<String> iterator2 = list.iterator2();
                    while (iterator2.hasNext()) {
                        this.jad_an.delete("preloadAd", "rId=?", new String[]{iterator2.next()});
                    }
                    this.jad_an.setTransactionSuccessful();
                    SQLiteDatabase sQLiteDatabase4 = this.jad_an;
                    if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                        sQLiteDatabase = this.jad_an;
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
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
            java.lang.String r1 = "preloadAd"
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
            java.lang.String r4 = "Exception while clearing events: "
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
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kx.jad_an.jad_an(java.lang.String, java.lang.String[]):void");
    }
}
