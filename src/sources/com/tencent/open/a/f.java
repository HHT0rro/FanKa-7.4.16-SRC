package com.tencent.open.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.log.SLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f45164a = {"key"};

    /* renamed from: b, reason: collision with root package name */
    public static f f45165b;

    public f(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f45165b == null) {
                f45165b = new f(com.tencent.open.utils.f.a());
            }
            fVar = f45165b;
        }
        return fVar;
    }

    public synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (writableDatabase == null) {
                return;
            }
            try {
                writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e2);
            }
        } finally {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075 A[Catch: all -> 0x007f, Exception -> 0x0082, TRY_ENTER, TryCatch #13 {Exception -> 0x0082, all -> 0x007f, blocks: (B:22:0x0030, B:24:0x0036, B:25:0x0039, B:31:0x0053, B:33:0x0056, B:35:0x0075, B:36:0x0078, B:67:0x0062, B:60:0x0065, B:61:0x0068, B:53:0x006c, B:48:0x006f), top: B:21:0x0030 }] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.io.ObjectInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<java.io.Serializable> a(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La9
            r0.<init>()     // Catch: java.lang.Throwable -> La9
            java.util.List r0 = java.util.Collections.synchronizedList(r0)     // Catch: java.lang.Throwable -> La9
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> La9
            if (r1 == 0) goto L12
            monitor-exit(r11)
            return r0
        L12:
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> La9
            if (r1 != 0) goto L1a
            monitor-exit(r11)
            return r0
        L1a:
            r10 = 0
            java.lang.String r3 = "via_cgi_report"
            r4 = 0
            java.lang.String r5 = "type = ?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r2 = 0
            r6[r2] = r12     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r1
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            if (r12 == 0) goto L85
            int r2 = r12.getCount()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            if (r2 <= 0) goto L85
            r12.moveToFirst()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
        L39:
            java.lang.String r2 = "blob"
            int r2 = r12.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            byte[] r2 = r12.getBlob(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L69
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L69
            java.lang.Object r4 = r2.readObject()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L6a
            java.io.Serializable r4 = (java.io.Serializable) r4     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L6a
            r2.close()     // Catch: java.io.IOException -> L56 java.lang.Throwable -> L7f java.lang.Exception -> L82
        L56:
            r3.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L7f java.lang.Exception -> L82
            goto L73
        L5a:
            goto L73
        L5c:
            r4 = move-exception
            r10 = r2
            goto L60
        L5f:
            r4 = move-exception
        L60:
            if (r10 == 0) goto L65
            r10.close()     // Catch: java.io.IOException -> L65 java.lang.Throwable -> L7f java.lang.Exception -> L82
        L65:
            r3.close()     // Catch: java.io.IOException -> L68 java.lang.Throwable -> L7f java.lang.Exception -> L82
        L68:
            throw r4     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
        L69:
            r2 = r10
        L6a:
            if (r2 == 0) goto L6f
            r2.close()     // Catch: java.io.IOException -> L6f java.lang.Throwable -> L7f java.lang.Exception -> L82
        L6f:
            r3.close()     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L7f java.lang.Exception -> L82
        L72:
            r4 = r10
        L73:
            if (r4 == 0) goto L78
            r0.add(r4)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
        L78:
            boolean r2 = r12.moveToNext()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L82
            if (r2 != 0) goto L39
            goto L85
        L7f:
            r0 = move-exception
            r10 = r12
            goto La0
        L82:
            r2 = move-exception
            r10 = r12
            goto L91
        L85:
            if (r12 == 0) goto L8a
            r12.close()     // Catch: java.lang.Throwable -> La9
        L8a:
            r1.close()     // Catch: java.lang.Throwable -> La9
            goto L9e
        L8e:
            r0 = move-exception
            goto La0
        L90:
            r2 = move-exception
        L91:
            java.lang.String r12 = "openSDK_LOG.ReportDatabaseHelper"
            java.lang.String r3 = "getReportItemFromDB has exception."
            com.tencent.open.log.SLog.e(r12, r3, r2)     // Catch: java.lang.Throwable -> L8e
            if (r10 == 0) goto L8a
            r10.close()     // Catch: java.lang.Throwable -> La9
            goto L8a
        L9e:
            monitor-exit(r11)
            return r0
        La0:
            if (r10 == 0) goto La5
            r10.close()     // Catch: java.lang.Throwable -> La9
        La5:
            r1.close()     // Catch: java.lang.Throwable -> La9
            throw r0     // Catch: java.lang.Throwable -> La9
        La9:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.f.a(java.lang.String):java.util.List");
    }

    public synchronized void a(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.beginTransaction();
        try {
            try {
                ContentValues contentValues = new ContentValues();
                for (int i10 = 0; i10 < size; i10++) {
                    Serializable serializable = list.get(i10);
                    if (serializable != null) {
                        contentValues.put("type", str);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                        ObjectOutputStream objectOutputStream2 = null;
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        } catch (IOException unused) {
                            objectOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            objectOutputStream.writeObject(serializable);
                            try {
                                objectOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        } catch (IOException unused3) {
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            byteArrayOutputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream2 = objectOutputStream;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (IOException unused4) {
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (IOException unused5) {
                                throw th;
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused6) {
                            contentValues.put("blob", byteArrayOutputStream.toByteArray());
                            writableDatabase.insert("via_cgi_report", null, contentValues);
                        }
                    }
                    contentValues.clear();
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Exception unused7) {
                SLog.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
                writableDatabase.endTransaction();
            }
            writableDatabase.close();
        } catch (Throwable th3) {
            writableDatabase.endTransaction();
            writableDatabase.close();
            throw th3;
        }
    }
}
