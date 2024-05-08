package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private static p f40164a;

    /* renamed from: b, reason: collision with root package name */
    private static q f40165b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f40166c;

    private p(Context context, List<com.tencent.bugly.a> list) {
        f40165b = new q(context, list);
    }

    private synchronized boolean b(r rVar) {
        ContentValues d10;
        if (rVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f40165b.getWritableDatabase();
            if (writableDatabase == null || (d10 = d(rVar)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_pf", "_id", d10);
            if (replace < 0) {
                return false;
            }
            x.c("[Database] insert %s success.", "t_pf");
            rVar.f40189a = replace;
            return true;
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    private static ContentValues c(r rVar) {
        if (rVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = rVar.f40189a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tp", Integer.valueOf(rVar.f40190b));
            contentValues.put("_pc", rVar.f40191c);
            contentValues.put("_th", rVar.f40192d);
            contentValues.put("_tm", Long.valueOf(rVar.f40193e));
            byte[] bArr = rVar.f40195g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues d(r rVar) {
        if (rVar != null && !z.a(rVar.f40194f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j10 = rVar.f40189a;
                if (j10 > 0) {
                    contentValues.put("_id", Long.valueOf(j10));
                }
                contentValues.put("_tp", rVar.f40194f);
                contentValues.put("_tm", Long.valueOf(rVar.f40193e));
                byte[] bArr = rVar.f40195g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized p a(Context context, List<com.tencent.bugly.a> list) {
        p pVar;
        synchronized (p.class) {
            if (f40164a == null) {
                f40164a = new p(context, list);
            }
            pVar = f40164a;
        }
        return pVar;
    }

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private int f40167a;

        /* renamed from: b, reason: collision with root package name */
        private o f40168b;

        /* renamed from: c, reason: collision with root package name */
        private String f40169c;

        /* renamed from: d, reason: collision with root package name */
        private ContentValues f40170d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f40171e;

        /* renamed from: f, reason: collision with root package name */
        private String[] f40172f;

        /* renamed from: g, reason: collision with root package name */
        private String f40173g;

        /* renamed from: h, reason: collision with root package name */
        private String[] f40174h;

        /* renamed from: i, reason: collision with root package name */
        private String f40175i;

        /* renamed from: j, reason: collision with root package name */
        private String f40176j;

        /* renamed from: k, reason: collision with root package name */
        private String f40177k;

        /* renamed from: l, reason: collision with root package name */
        private String f40178l;

        /* renamed from: m, reason: collision with root package name */
        private String f40179m;

        /* renamed from: n, reason: collision with root package name */
        private String[] f40180n;

        /* renamed from: o, reason: collision with root package name */
        private int f40181o;

        /* renamed from: p, reason: collision with root package name */
        private String f40182p;

        /* renamed from: q, reason: collision with root package name */
        private byte[] f40183q;

        public a(int i10, o oVar) {
            this.f40167a = i10;
            this.f40168b = oVar;
        }

        public final void a(boolean z10, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f40171e = z10;
            this.f40169c = str;
            this.f40172f = strArr;
            this.f40173g = str2;
            this.f40174h = strArr2;
            this.f40175i = str3;
            this.f40176j = str4;
            this.f40177k = str5;
            this.f40178l = str6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f40167a) {
                case 1:
                    p.this.a(this.f40169c, this.f40170d, this.f40168b);
                    return;
                case 2:
                    p.this.a(this.f40169c, this.f40179m, this.f40180n, this.f40168b);
                    return;
                case 3:
                    Cursor a10 = p.this.a(this.f40171e, this.f40169c, this.f40172f, this.f40173g, this.f40174h, this.f40175i, this.f40176j, this.f40177k, this.f40178l, this.f40168b);
                    if (a10 != null) {
                        a10.close();
                        return;
                    }
                    return;
                case 4:
                    p.this.a(this.f40181o, this.f40182p, this.f40183q, this.f40168b);
                    return;
                case 5:
                    p.this.a(this.f40181o, this.f40168b);
                    return;
                case 6:
                    p.this.a(this.f40181o, this.f40182p, this.f40168b);
                    return;
                default:
                    return;
            }
        }

        public final void a(int i10, String str, byte[] bArr) {
            this.f40181o = i10;
            this.f40182p = str;
            this.f40183q = bArr;
        }
    }

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            pVar = f40164a;
        }
        return pVar;
    }

    public final long a(String str, ContentValues contentValues, o oVar, boolean z10) {
        return a(str, contentValues, (o) null);
    }

    private synchronized List<r> c(int i10) {
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = f40165b.getWritableDatabase();
            if (writableDatabase != null) {
                String str = "_id = " + i10;
                cursor = writableDatabase.query("t_pf", null, str, null, null, null, null);
                if (cursor == null) {
                    return null;
                }
                try {
                    StringBuilder sb2 = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        r b4 = b(cursor);
                        if (b4 != null) {
                            arrayList.add(b4);
                        } else {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("_tp"));
                                sb2.append(" or _tp");
                                sb2.append(" = ");
                                sb2.append(string);
                            } catch (Throwable unused) {
                                x.d("[Database] unknown id.", new Object[0]);
                            }
                        }
                    }
                    if (sb2.length() > 0) {
                        sb2.append(" and _id");
                        sb2.append(" = ");
                        sb2.append(i10);
                        x.d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
                    }
                    cursor.close();
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, o oVar, boolean z10) {
        return a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    public final int a(String str, String str2, String[] strArr, o oVar, boolean z10) {
        return a(str, str2, (String[]) null, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized long a(String str, ContentValues contentValues, o oVar) {
        long j10;
        j10 = 0;
        try {
            SQLiteDatabase writableDatabase = f40165b.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long replace = writableDatabase.replace(str, "_id", contentValues);
                if (replace >= 0) {
                    x.c("[Database] insert %s success.", str);
                } else {
                    x.d("[Database] replace %s error.", str);
                }
                j10 = replace;
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j10;
    }

    public final synchronized void b(int i10) {
        String str;
        SQLiteDatabase writableDatabase = f40165b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i10 >= 0) {
                try {
                    str = "_tp = " + i10;
                } catch (Throwable th) {
                    if (x.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            } else {
                str = null;
            }
            x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z10, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, o oVar) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = f40165b.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z10, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } finally {
            try {
                return cursor;
            } finally {
            }
        }
        return cursor;
    }

    private static r b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.f40189a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.f40193e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.f40194f = cursor.getString(cursor.getColumnIndex("_tp"));
            rVar.f40195g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, o oVar) {
        int i10;
        i10 = 0;
        try {
            SQLiteDatabase writableDatabase = f40165b.getWritableDatabase();
            if (writableDatabase != null) {
                i10 = writableDatabase.delete(str, str2, strArr);
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i10;
    }

    public final boolean a(int i10, String str, byte[] bArr, o oVar, boolean z10) {
        if (!z10) {
            a aVar = new a(4, null);
            aVar.a(i10, str, bArr);
            w.a().a(aVar);
            return true;
        }
        return a(i10, str, bArr, (o) null);
    }

    public final Map<String, byte[]> a(int i10, o oVar, boolean z10) {
        return a(i10, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i10, String str, byte[] bArr, o oVar) {
        try {
            r rVar = new r();
            rVar.f40189a = i10;
            rVar.f40194f = str;
            rVar.f40193e = System.currentTimeMillis();
            rVar.f40195g = bArr;
            return b(rVar);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, byte[]> a(int i10, o oVar) {
        HashMap hashMap = null;
        try {
            List<r> c4 = c(i10);
            if (c4 == null) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            try {
                for (r rVar : c4) {
                    byte[] bArr = rVar.f40195g;
                    if (bArr != null) {
                        hashMap2.put(rVar.f40194f, bArr);
                    }
                }
                return hashMap2;
            } catch (Throwable th) {
                th = th;
                hashMap = hashMap2;
                if (x.a(th)) {
                    return hashMap;
                }
                th.printStackTrace();
                return hashMap;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized boolean a(r rVar) {
        ContentValues c4;
        if (rVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f40165b.getWritableDatabase();
            if (writableDatabase == null || (c4 = c(rVar)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_lr", "_id", c4);
            if (replace < 0) {
                return false;
            }
            x.c("[Database] insert %s success.", "t_lr");
            rVar.f40189a = replace;
            return true;
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a8 A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #0 {all -> 0x00b1, blocks: (B:42:0x00a2, B:44:0x00a8), top: B:41:0x00a2, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad A[Catch: all -> 0x00ba, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:11:0x0031, B:36:0x0099, B:47:0x00ad, B:50:0x00b4, B:51:0x00b7, B:42:0x00a2, B:44:0x00a8), top: B:2:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.r> a(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.tencent.bugly.proguard.q r0 = com.tencent.bugly.proguard.p.f40165b     // Catch: java.lang.Throwable -> Lba
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> Lba
            r9 = 0
            if (r0 == 0) goto Lb8
            if (r12 < 0) goto L20
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            java.lang.String r2 = "_tp = "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1c
            r1.append(r12)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r12 = r1.toString()     // Catch: java.lang.Throwable -> L1c
            r4 = r12
            goto L21
        L1c:
            r12 = move-exception
            r0 = r9
            goto La2
        L20:
            r4 = r9
        L21:
            java.lang.String r2 = "t_lr"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L1c
            if (r12 != 0) goto L36
            if (r12 == 0) goto L34
            r12.close()     // Catch: java.lang.Throwable -> Lba
        L34:
            monitor-exit(r11)
            return r9
        L36:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r1.<init>()     // Catch: java.lang.Throwable -> L9e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L9e
            r2.<init>()     // Catch: java.lang.Throwable -> L9e
        L40:
            boolean r3 = r12.moveToNext()     // Catch: java.lang.Throwable -> L9e
            r4 = 0
            if (r3 == 0) goto L71
            com.tencent.bugly.proguard.r r3 = a(r12)     // Catch: java.lang.Throwable -> L9e
            if (r3 == 0) goto L51
            r2.add(r3)     // Catch: java.lang.Throwable -> L9e
            goto L40
        L51:
            java.lang.String r3 = "_id"
            int r3 = r12.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L69
            long r5 = r12.getLong(r3)     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = " or _id"
            r1.append(r3)     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = " = "
            r1.append(r3)     // Catch: java.lang.Throwable -> L69
            r1.append(r5)     // Catch: java.lang.Throwable -> L69
            goto L40
        L69:
            java.lang.String r3 = "[Database] unknown id."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L9e
            com.tencent.bugly.proguard.x.d(r3, r4)     // Catch: java.lang.Throwable -> L9e
            goto L40
        L71:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9e
            int r3 = r1.length()     // Catch: java.lang.Throwable -> L9e
            if (r3 <= 0) goto L99
            r3 = 4
            java.lang.String r1 = r1.substring(r3)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r3 = "t_lr"
            int r0 = r0.delete(r3, r1, r9)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = "[Database] deleted %s illegal data %d"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9e
            java.lang.String r5 = "t_lr"
            r3[r4] = r5     // Catch: java.lang.Throwable -> L9e
            r4 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L9e
            r3[r4] = r0     // Catch: java.lang.Throwable -> L9e
            com.tencent.bugly.proguard.x.d(r1, r3)     // Catch: java.lang.Throwable -> L9e
        L99:
            r12.close()     // Catch: java.lang.Throwable -> Lba
            monitor-exit(r11)
            return r2
        L9e:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        La2:
            boolean r1 = com.tencent.bugly.proguard.x.a(r12)     // Catch: java.lang.Throwable -> Lb1
            if (r1 != 0) goto Lab
            r12.printStackTrace()     // Catch: java.lang.Throwable -> Lb1
        Lab:
            if (r0 == 0) goto Lb8
            r0.close()     // Catch: java.lang.Throwable -> Lba
            goto Lb8
        Lb1:
            r12 = move-exception
            if (r0 == 0) goto Lb7
            r0.close()     // Catch: java.lang.Throwable -> Lba
        Lb7:
            throw r12     // Catch: java.lang.Throwable -> Lba
        Lb8:
            monitor-exit(r11)
            return r9
        Lba:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(int):java.util.List");
    }

    public final synchronized void a(List<r> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f40165b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb2 = new StringBuilder();
                    for (r rVar : list) {
                        sb2.append(" or _id");
                        sb2.append(" = ");
                        sb2.append(rVar.f40189a);
                    }
                    String sb3 = sb2.toString();
                    if (sb3.length() > 0) {
                        sb3 = sb3.substring(4);
                    }
                    sb2.setLength(0);
                    try {
                        x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb3, null)));
                    } catch (Throwable th) {
                        if (x.a(th)) {
                            return;
                        }
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    private static r a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.f40189a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.f40190b = cursor.getInt(cursor.getColumnIndex("_tp"));
            rVar.f40191c = cursor.getString(cursor.getColumnIndex("_pc"));
            rVar.f40192d = cursor.getString(cursor.getColumnIndex("_th"));
            rVar.f40193e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.f40195g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i10, String str, o oVar) {
        boolean z10;
        String str2;
        z10 = false;
        try {
            SQLiteDatabase writableDatabase = f40165b.getWritableDatabase();
            if (writableDatabase != null) {
                if (z.a(str)) {
                    str2 = "_id = " + i10;
                } else {
                    str2 = "_id = " + i10 + " and _tp = \"" + str + "\"";
                }
                int delete = writableDatabase.delete("t_pf", str2, null);
                x.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                if (delete > 0) {
                    z10 = true;
                }
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }
}
