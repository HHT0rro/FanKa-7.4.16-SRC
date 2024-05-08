package com.alipay.sdk.tid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alipay.sdk.util.c;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4678a = "msp.db";

    /* renamed from: b, reason: collision with root package name */
    private static final int f4679b = 1;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f4680c;

    public a(Context context) {
        super(context, f4678a, (SQLiteDatabase.CursorFactory) null, 1);
        this.f4680c = new WeakReference<>(context);
    }

    private String c(String str, String str2) {
        return str + str2;
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = getWritableDatabase();
                sQLiteDatabase.execSQL("drop table if exists tb_tid");
                if (!sQLiteDatabase.isOpen()) {
                    return;
                }
            } catch (Exception e2) {
                c.a(e2);
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return;
                }
            }
            sQLiteDatabase.close();
        } catch (Throwable th) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        if (r2.isOpen() != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        if (r2.isOpen() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "select key_tid from tb_tid where name=?"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L48
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            java.lang.String r5 = r4.c(r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            android.database.Cursor r5 = r2.rawQuery(r0, r3)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            boolean r0 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            if (r0 == 0) goto L1f
            java.lang.String r1 = r5.getString(r6)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
        L1f:
            r5.close()
            boolean r5 = r2.isOpen()
            if (r5 == 0) goto L58
        L28:
            r2.close()
            goto L58
        L2c:
            r6 = move-exception
            r1 = r5
            goto L37
        L2f:
            goto L4a
        L31:
            r6 = move-exception
            goto L37
        L33:
            r5 = r1
            goto L4a
        L35:
            r6 = move-exception
            r2 = r1
        L37:
            if (r1 == 0) goto L3c
            r1.close()
        L3c:
            if (r2 == 0) goto L47
            boolean r5 = r2.isOpen()
            if (r5 == 0) goto L47
            r2.close()
        L47:
            throw r6
        L48:
            r5 = r1
            r2 = r5
        L4a:
            if (r5 == 0) goto L4f
            r5.close()
        L4f:
            if (r2 == 0) goto L58
            boolean r5 = r2.isOpen()
            if (r5 == 0) goto L58
            goto L28
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.b(java.lang.String, java.lang.String):java.lang.String");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("drop table if exists tb_tid");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        if (r2.isOpen() != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        if (r2.isOpen() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "select tid from tb_tid where name=?"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L48
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            java.lang.String r5 = r4.c(r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            android.database.Cursor r5 = r2.rawQuery(r0, r3)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L33
            boolean r0 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
            if (r0 == 0) goto L1f
            java.lang.String r1 = r5.getString(r6)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2f
        L1f:
            r5.close()
            boolean r5 = r2.isOpen()
            if (r5 == 0) goto L58
        L28:
            r2.close()
            goto L58
        L2c:
            r6 = move-exception
            r1 = r5
            goto L37
        L2f:
            goto L4a
        L31:
            r6 = move-exception
            goto L37
        L33:
            r5 = r1
            goto L4a
        L35:
            r6 = move-exception
            r2 = r1
        L37:
            if (r1 == 0) goto L3c
            r1.close()
        L3c:
            if (r2 == 0) goto L47
            boolean r5 = r2.isOpen()
            if (r5 == 0) goto L47
            r2.close()
        L47:
            throw r6
        L48:
            r5 = r1
            r2 = r5
        L4a:
            if (r5 == 0) goto L4f
            r5.close()
        L4f:
            if (r2 == 0) goto L58
            boolean r5 = r2.isOpen()
            if (r5 == 0) goto L58
            goto L28
        L58:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L6e
            java.lang.ref.WeakReference<android.content.Context> r5 = r4.f4680c
            java.lang.Object r5 = r5.get()
            android.content.Context r5 = (android.content.Context) r5
            java.lang.String r5 = com.alipay.sdk.util.a.c(r5)
            java.lang.String r1 = com.alipay.sdk.encrypt.b.b(r1, r5)
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.tid.a.a(java.lang.String, java.lang.String):java.lang.String");
    }
}
