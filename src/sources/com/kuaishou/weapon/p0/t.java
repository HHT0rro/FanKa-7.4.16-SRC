package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class t {
    private static t E = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f36216a = "k";

    /* renamed from: b, reason: collision with root package name */
    public static final String f36217b = "p";

    /* renamed from: c, reason: collision with root package name */
    public static final String f36218c = "v";

    /* renamed from: d, reason: collision with root package name */
    public static final String f36219d = "l";

    /* renamed from: e, reason: collision with root package name */
    public static final String f36220e = "i";

    /* renamed from: f, reason: collision with root package name */
    public static final String f36221f = "a";

    /* renamed from: g, reason: collision with root package name */
    public static final String f36222g = "s";

    /* renamed from: h, reason: collision with root package name */
    public static final String f36223h = "n";

    /* renamed from: i, reason: collision with root package name */
    public static final String f36224i = "u";

    /* renamed from: j, reason: collision with root package name */
    public static final String f36225j = "c";

    /* renamed from: k, reason: collision with root package name */
    public static final String f36226k = "r";

    /* renamed from: l, reason: collision with root package name */
    public static final String f36227l = "b";

    /* renamed from: m, reason: collision with root package name */
    public static final String f36228m = "m";

    /* renamed from: n, reason: collision with root package name */
    public static final String f36229n = "el";

    /* renamed from: o, reason: collision with root package name */
    public static final String f36230o = "ail";

    /* renamed from: p, reason: collision with root package name */
    public static final String f36231p = "aps";

    /* renamed from: q, reason: collision with root package name */
    public static final String f36232q = "dp";

    /* renamed from: r, reason: collision with root package name */
    public static final String f36233r = "pcn";

    /* renamed from: s, reason: collision with root package name */
    public static final String f36234s = "pst";

    /* renamed from: t, reason: collision with root package name */
    public static final String f36235t = "d";

    /* renamed from: u, reason: collision with root package name */
    public static final String f36236u = "at";

    /* renamed from: v, reason: collision with root package name */
    public static final String f36237v = "dm";

    /* renamed from: w, reason: collision with root package name */
    public static final String f36238w = "rm";

    /* renamed from: x, reason: collision with root package name */
    public static final String f36239x = "pc";

    /* renamed from: y, reason: collision with root package name */
    public static final String f36240y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;

    /* renamed from: z, reason: collision with root package name */
    private int f36241z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, bi.f35846p, (SQLiteDatabase.CursorFactory) null, t.this.f36241z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            if (i10 >= 3 || i11 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable unused) {
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    private t(Context context) {
        this.D = context.getApplicationContext();
        this.B = new a(context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.C = this.B.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        if (r11.isClosed() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        if (r11.isClosed() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "n"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.C     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "wp"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L41
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L41
            r5.append(r11)     // Catch: java.lang.Throwable -> L41
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L41
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L41
            if (r11 == 0) goto L35
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L35
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L33
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L33
            r1 = r0
            goto L35
        L33:
            goto L42
        L35:
            if (r11 == 0) goto L4b
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4b
        L3d:
            r11.close()
            goto L4b
        L41:
            r11 = 0
        L42:
            if (r11 == 0) goto L4b
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4b
            goto L3d
        L4b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.c(int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r11.isClosed() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
    
        if (r11.isClosed() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.C     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "wp"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L44
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L44
            r5.append(r11)     // Catch: java.lang.Throwable -> L44
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L44
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L44
            if (r11 == 0) goto L38
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L38
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L36
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L36
            r2 = 1
            if (r0 != r2) goto L38
            r1 = 1
            goto L38
        L36:
            goto L45
        L38:
            if (r11 == 0) goto L4e
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4e
        L40:
            r11.close()
            goto L4e
        L44:
            r11 = 0
        L45:
            if (r11 == 0) goto L4e
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4e
            goto L40
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.d(int):boolean");
    }

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            if (E == null) {
                E = new t(context);
            }
            tVar = E;
        }
        return tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r10.isClosed() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
    
        if (r10.isClosed() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(int r10) {
        /*
            r9 = this;
            java.lang.String r1 = "wp"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r9.C     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = "p"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L3a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            r3.append(r10)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3a
            if (r10 == 0) goto L2e
            int r0 = r10.getCount()     // Catch: java.lang.Throwable -> L2c
            if (r0 <= 0) goto L2e
            r0 = 1
            r8 = 1
            goto L2e
        L2c:
            goto L3b
        L2e:
            if (r10 == 0) goto L44
            boolean r0 = r10.isClosed()
            if (r0 != 0) goto L44
        L36:
            r10.close()
            goto L44
        L3a:
            r10 = 0
        L3b:
            if (r10 == 0) goto L44
            boolean r0 = r10.isClosed()
            if (r0 != 0) goto L44
            goto L36
        L44:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.b(int):boolean");
    }

    public long a(s sVar) {
        long j10 = 0;
        if (sVar == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(sVar.f36192b));
        contentValues.put(f36231p, Integer.valueOf(sVar.f36206p));
        contentValues.put(f36217b, sVar.f36193c);
        contentValues.put("a", sVar.f36195e);
        contentValues.put("l", sVar.f36198h);
        contentValues.put(f36218c, sVar.f36194d);
        contentValues.put(f36232q, sVar.f36204n);
        contentValues.put("a", sVar.f36195e);
        contentValues.put(f36233r, sVar.f36205o);
        contentValues.put(f36234s, Long.valueOf(sVar.f36209s));
        contentValues.put(f36238w, Integer.valueOf(sVar.f36213w));
        contentValues.put("at", Integer.valueOf(sVar.f36207q));
        contentValues.put(f36239x, Integer.valueOf(sVar.f36214x));
        contentValues.put(f36240y, Integer.valueOf(sVar.f36215y ? 1 : 0));
        if (!TextUtils.isEmpty(sVar.f36200j)) {
            contentValues.put(f36237v, sVar.f36200j);
        }
        try {
            if (b(sVar.f36191a)) {
                j10 = this.C.update(bi.f35847q, contentValues, "k=" + sVar.f36191a, null);
            } else {
                contentValues.put("k", Integer.valueOf(sVar.f36191a));
                j10 = this.C.insert(bi.f35847q, null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return j10;
    }

    public void b() {
        ArrayList<s> arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dn.a(sVar.f36195e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r a10 = r.a();
            for (s sVar2 : arrayList) {
                if (a10 != null) {
                    a10.a(sVar2.f36195e);
                }
                this.C.delete(bi.f35847q, "k=" + sVar2.f36191a, null);
                List<Integer> list = r.f36183b;
                if (list != null && !list.contains(Integer.valueOf(sVar2.f36191a))) {
                    dn.c(this.D.getFilesDir().getCanonicalPath() + bi.f35840j + sVar2.f36191a);
                }
                if (a10.b() != null && a10.b().get(sVar2.f36193c) != null) {
                    dn.c(this.D.getFileStreamPath(sVar2.f36193c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update(bi.f35847q, contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f36224i, (Integer) 0);
        try {
            this.C.update(bi.f35847q, contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    public void c(int i10, int i11) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(f36239x, Integer.valueOf(i11));
            this.C.update(bi.f35847q, contentValues, "k=" + i10, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b4, code lost:
    
        if (r1.isClosed() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00aa, code lost:
    
        if (r1.isClosed() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00b6, code lost:
    
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.kuaishou.weapon.p0.s> a() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.C     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "wp"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto La4
        L15:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto La4
            com.kuaishou.weapon.p0.s r2 = new com.kuaishou.weapon.p0.s     // Catch: java.lang.Throwable -> La2
            r2.<init>()     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "k"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f36191a = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f36193c = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f36195e = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "l"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f36198h = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "v"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f36194d = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pst"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> La2
            r2.f36209s = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "d"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f36210t = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "rm"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f36213w = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pc"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f36214x = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "cbl"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r4 = 1
            if (r3 != r4) goto L9a
            goto L9b
        L9a:
            r4 = 0
        L9b:
            r2.f36215y = r4     // Catch: java.lang.Throwable -> La2
            r0.add(r2)     // Catch: java.lang.Throwable -> La2
            goto L15
        La2:
            goto Lae
        La4:
            if (r1 == 0) goto Lb9
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lb9
            goto Lb6
        Lad:
            r1 = 0
        Lae:
            if (r1 == 0) goto Lb9
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lb9
        Lb6:
            r1.close()
        Lb9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.a():java.util.List");
    }

    public void b(int i10, int i11) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i11));
            this.C.update(bi.f35847q, contentValues, "k=" + i10, null);
        } catch (Throwable unused) {
        }
    }

    public s b(String str) {
        s sVar;
        Cursor cursor = null;
        r1 = null;
        s sVar2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean z10 = true;
            Cursor query = this.C.query(bi.f35847q, null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f36191a = query.getInt(query.getColumnIndex("k"));
                            sVar.f36192b = query.getInt(query.getColumnIndex("n"));
                            sVar.f36193c = query.getString(query.getColumnIndex(f36217b));
                            sVar.f36195e = query.getString(query.getColumnIndex("a"));
                            sVar.f36198h = query.getString(query.getColumnIndex("l"));
                            sVar.f36194d = query.getString(query.getColumnIndex(f36218c));
                            sVar.f36204n = query.getString(query.getColumnIndex(f36232q));
                            sVar.f36206p = query.getInt(query.getColumnIndex(f36231p));
                            sVar.f36205o = query.getString(query.getColumnIndex(f36233r));
                            sVar.f36207q = query.getInt(query.getColumnIndex("at"));
                            sVar.f36209s = query.getLong(query.getColumnIndex(f36234s));
                            sVar.f36210t = query.getInt(query.getColumnIndex("d"));
                            sVar.f36213w = query.getInt(query.getColumnIndex(f36238w));
                            sVar.f36200j = query.getString(query.getColumnIndex(f36237v));
                            sVar.f36214x = query.getInt(query.getColumnIndex(f36239x));
                            if (query.getInt(query.getColumnIndex(f36240y)) != 1) {
                                z10 = false;
                            }
                            sVar.f36215y = z10;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query == null || query.isClosed()) {
                return sVar2;
            }
            query.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public s a(int i10) {
        s sVar;
        Cursor cursor = null;
        r0 = null;
        s sVar2 = null;
        try {
            Cursor query = this.C.query(bi.f35847q, null, "k=" + i10, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f36191a = i10;
                            sVar.f36192b = query.getInt(query.getColumnIndex("n"));
                            sVar.f36193c = query.getString(query.getColumnIndex(f36217b));
                            sVar.f36195e = query.getString(query.getColumnIndex("a"));
                            sVar.f36198h = query.getString(query.getColumnIndex("l"));
                            sVar.f36194d = query.getString(query.getColumnIndex(f36218c));
                            sVar.f36204n = query.getString(query.getColumnIndex(f36232q));
                            sVar.f36206p = query.getInt(query.getColumnIndex(f36231p));
                            sVar.f36205o = query.getString(query.getColumnIndex(f36233r));
                            sVar.f36207q = query.getInt(query.getColumnIndex("at"));
                            sVar.f36209s = query.getLong(query.getColumnIndex(f36234s));
                            sVar.f36210t = query.getInt(query.getColumnIndex("d"));
                            sVar.f36213w = query.getInt(query.getColumnIndex(f36238w));
                            sVar.f36200j = query.getString(query.getColumnIndex(f36237v));
                            sVar.f36214x = query.getInt(query.getColumnIndex(f36239x));
                            boolean z10 = true;
                            if (query.getInt(query.getColumnIndex(f36240y)) != 1) {
                                z10 = false;
                            }
                            sVar.f36215y = z10;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query == null || query.isClosed()) {
                return sVar2;
            }
            query.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bi.f35847q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public int a(int i10, int i11) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(f36224i, Integer.valueOf(i11));
            return this.C.update(bi.f35847q, contentValues, "k=" + i10, null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
