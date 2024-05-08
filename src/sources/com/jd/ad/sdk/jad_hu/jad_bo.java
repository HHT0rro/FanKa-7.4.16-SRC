package com.jd.ad.sdk.jad_hu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.util.List;

/* compiled from: DataBaseTemplateStorage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo extends com.jd.ad.sdk.jad_qd.jad_an {
    public static jad_bo jad_bo;

    /* compiled from: DataBaseTemplateStorage.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an implements Runnable {
        public final /* synthetic */ List jad_an;

        public jad_an(List list) {
            this.jad_an = list;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
        
            if (r1.inTransaction() != false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
        
            r1 = r0.jad_an;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
        
            if (r1.inTransaction() != false) goto L33;
         */
        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r9 = this;
                com.jd.ad.sdk.jad_hu.jad_bo r0 = com.jd.ad.sdk.jad_hu.jad_bo.this
                java.util.List r1 = r9.jad_an
                monitor-enter(r0)
                if (r1 == 0) goto L9a
                int r2 = r1.size()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                if (r2 != 0) goto Lf
                goto L9a
            Lf:
                r2 = 0
                r3 = 1
                r0.getWritableDatabase()     // Catch: java.lang.Throwable -> L62
                boolean r4 = r0.jad_bo()     // Catch: java.lang.Throwable -> L62
                if (r4 != 0) goto L27
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                if (r1 == 0) goto L9a
                boolean r1 = r1.inTransaction()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                if (r1 == 0) goto L9a
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                goto L7c
            L27:
                android.database.sqlite.SQLiteDatabase r4 = r0.jad_an     // Catch: java.lang.Throwable -> L62
                r4.beginTransaction()     // Catch: java.lang.Throwable -> L62
                java.util.Iterator r1 = r1.iterator2()     // Catch: java.lang.Throwable -> L62
            L30:
                boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> L62
                if (r4 == 0) goto L52
                java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> L62
                java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L62
                int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L62
                android.database.sqlite.SQLiteDatabase r5 = r0.jad_an     // Catch: java.lang.Throwable -> L62
                java.lang.String r6 = "lottieTemplate"
                java.lang.String r7 = "_id=?"
                java.lang.String[] r8 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L62
                java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L62
                r8[r2] = r4     // Catch: java.lang.Throwable -> L62
                r5.delete(r6, r7, r8)     // Catch: java.lang.Throwable -> L62
                goto L30
            L52:
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L62
                r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L62
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                if (r1 == 0) goto L9a
                boolean r1 = r1.inTransaction()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                if (r1 == 0) goto L9a
                goto L7a
            L62:
                r1 = move-exception
                java.lang.String r4 = "Exception while clearing templates:"
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L80
                java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L80
                r3[r2] = r1     // Catch: java.lang.Throwable -> L80
                com.jd.ad.sdk.logger.Logger.w(r4, r3)     // Catch: java.lang.Throwable -> L80
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                if (r1 == 0) goto L9a
                boolean r1 = r1.inTransaction()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                if (r1 == 0) goto L9a
            L7a:
                android.database.sqlite.SQLiteDatabase r1 = r0.jad_an     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            L7c:
                r1.endTransaction()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                goto L9a
            L80:
                r1 = move-exception
                android.database.sqlite.SQLiteDatabase r2 = r0.jad_an     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                if (r2 == 0) goto L90
                boolean r2 = r2.inTransaction()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                if (r2 == 0) goto L90
                android.database.sqlite.SQLiteDatabase r2 = r0.jad_an     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                r2.endTransaction()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            L90:
                throw r1     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            L91:
                r1 = move-exception
                goto L98
            L93:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L91
                goto L9a
            L98:
                monitor-exit(r0)
                throw r1
            L9a:
                monitor-exit(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_hu.jad_bo.jad_an.run():void");
        }
    }

    public jad_bo(Context context, String str, int i10) {
        super(context, str, i10);
    }

    public static synchronized jad_bo jad_an(Context context, String str, int i10) {
        jad_bo jad_boVar;
        synchronized (jad_bo.class) {
            if (jad_bo == null) {
                jad_bo = new jad_bo(context, str, i10);
            }
            jad_boVar = jad_bo;
        }
        return jad_boVar;
    }

    public final ContentValues jad_bo(jad_cp jad_cpVar) {
        ContentValues contentValues;
        try {
            contentValues = new ContentValues();
            try {
                contentValues.put("appIdPid", jad_cpVar.jad_bo);
                contentValues.put("templateID", Integer.valueOf(jad_cpVar.jad_cp));
                contentValues.put("templateJSON", ANEProxy.ja(jad_cpVar.jad_er));
                contentValues.put("templateUpdateTimeStamp", jad_cpVar.jad_dq);
                contentValues.put("timeStampInterval", jad_cpVar.jad_fs);
            } catch (Exception e2) {
                e = e2;
                Logger.w("Exception while add templates:", e.getMessage());
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
                this.jad_an.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,  %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "lottieTemplate", "appIdPid", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"));
            }
        } catch (Exception e2) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render template sql create error:");
            jad_an2.append(Log.getStackTraceString(e2));
            Logger.d(jad_an2.toString());
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s TEXT, %s TEXT, %s TEXT)", "lottieTemplate", "appIdPid", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"));
        } catch (Exception e2) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render template sql create error:");
            jad_an2.append(Log.getStackTraceString(e2));
            Logger.d(jad_an2.toString());
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_vi.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS lottieTemplate");
        onCreate(sQLiteDatabase);
    }

    public synchronized void jad_an(jad_cp jad_cpVar) {
        if (jad_cpVar != null) {
            try {
                getWritableDatabase();
                if (!jad_bo()) {
                    return;
                }
                ContentValues jad_bo2 = jad_bo(jad_cpVar);
                int i10 = jad_cpVar.jad_an;
                if (i10 > 0) {
                    this.jad_an.update("lottieTemplate", jad_bo2, "_id=?", new String[]{String.valueOf(i10)});
                } else {
                    this.jad_an.insert("lottieTemplate", null, jad_bo2);
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
    
        if (r3.isClosed() == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.jd.ad.sdk.jad_hu.jad_cp> jad_an(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_hu.jad_bo.jad_an(java.lang.String):java.util.List");
    }
}
