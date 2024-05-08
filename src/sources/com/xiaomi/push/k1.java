package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k1 {

    /* renamed from: e, reason: collision with root package name */
    public static volatile k1 f47875e;

    /* renamed from: a, reason: collision with root package name */
    public Context f47876a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, j1> f47877b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public ThreadPoolExecutor f47878c = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<a> f47879d = new ArrayList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public String f47880b;

        /* renamed from: d, reason: collision with root package name */
        public String f47882d;

        /* renamed from: e, reason: collision with root package name */
        public WeakReference<Context> f47883e;

        /* renamed from: h, reason: collision with root package name */
        public a f47886h;

        /* renamed from: c, reason: collision with root package name */
        public j1 f47881c = null;

        /* renamed from: f, reason: collision with root package name */
        public Random f47884f = new Random();

        /* renamed from: g, reason: collision with root package name */
        public int f47885g = 0;

        public a(String str) {
            this.f47882d = str;
        }

        public SQLiteDatabase a() {
            return this.f47881c.getWritableDatabase();
        }

        public Object b() {
            return null;
        }

        public String c() {
            return this.f47882d;
        }

        public void d(Context context) {
            a aVar = this.f47886h;
            if (aVar != null) {
                aVar.f(context, b());
            }
            h(context);
        }

        public abstract void e(Context context, SQLiteDatabase sQLiteDatabase);

        public void f(Context context, Object obj) {
            k1.b(context).d(this);
        }

        public void g(a aVar) {
            this.f47886h = aVar;
        }

        public void h(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f47883e;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f47881c == null || TextUtils.isEmpty(this.f47882d)) {
                return;
            }
            File file = new File(this.f47882d);
            p7.b(context, new File(file.getParentFile(), o0.c(file.getAbsolutePath())), new l1(this, context));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class b<T> extends a {

        /* renamed from: i, reason: collision with root package name */
        public List<String> f47887i;

        /* renamed from: j, reason: collision with root package name */
        public String f47888j;

        /* renamed from: k, reason: collision with root package name */
        public String[] f47889k;

        /* renamed from: l, reason: collision with root package name */
        public String f47890l;

        /* renamed from: m, reason: collision with root package name */
        public String f47891m;

        /* renamed from: n, reason: collision with root package name */
        public String f47892n;

        /* renamed from: o, reason: collision with root package name */
        public int f47893o;

        /* renamed from: p, reason: collision with root package name */
        public List<T> f47894p;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i10) {
            super(str);
            this.f47894p = new ArrayList();
            this.f47887i = list;
            this.f47888j = str2;
            this.f47889k = strArr;
            this.f47890l = str3;
            this.f47891m = str4;
            this.f47892n = str5;
            this.f47893o = i10;
        }

        @Override // com.xiaomi.push.k1.a
        public SQLiteDatabase a() {
            return this.f47881c.getReadableDatabase();
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        
            if (r14.moveToFirst() != false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        
            r0 = i(r13, r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
        
            if (r0 == null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        
            r12.f47894p.add(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        
            if (r14.moveToNext() != false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        
            r14.close();
         */
        @Override // com.xiaomi.push.k1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void e(android.content.Context r13, android.database.sqlite.SQLiteDatabase r14) {
            /*
                r12 = this;
                java.util.List<T> r0 = r12.f47894p
                r0.clear()
                java.util.List<java.lang.String> r0 = r12.f47887i
                r1 = 0
                if (r0 == 0) goto L1f
                int r0 = r0.size()
                if (r0 <= 0) goto L1f
                java.util.List<java.lang.String> r0 = r12.f47887i
                int r0 = r0.size()
                java.lang.String[] r0 = new java.lang.String[r0]
                java.util.List<java.lang.String> r2 = r12.f47887i
                r2.toArray(r0)
                r5 = r0
                goto L20
            L1f:
                r5 = r1
            L20:
                int r0 = r12.f47893o
                if (r0 > 0) goto L25
                goto L29
            L25:
                java.lang.String r1 = java.lang.String.valueOf(r0)
            L29:
                r11 = r1
                java.lang.String r4 = r12.f47880b
                java.lang.String r6 = r12.f47888j
                java.lang.String[] r7 = r12.f47889k
                java.lang.String r8 = r12.f47890l
                java.lang.String r9 = r12.f47891m
                java.lang.String r10 = r12.f47892n
                r3 = r14
                android.database.Cursor r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)
                if (r14 == 0) goto L57
                boolean r0 = r14.moveToFirst()
                if (r0 == 0) goto L57
            L43:
                java.lang.Object r0 = r12.i(r13, r14)
                if (r0 == 0) goto L4e
                java.util.List<T> r1 = r12.f47894p
                r1.add(r0)
            L4e:
                boolean r0 = r14.moveToNext()
                if (r0 != 0) goto L43
                r14.close()
            L57:
                java.util.List<T> r14 = r12.f47894p
                r12.j(r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.k1.b.e(android.content.Context, android.database.sqlite.SQLiteDatabase):void");
        }

        public abstract T i(Context context, Cursor cursor);

        public abstract void j(Context context, List<T> list);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class c extends a {

        /* renamed from: i, reason: collision with root package name */
        public String f47895i;

        /* renamed from: j, reason: collision with root package name */
        public String[] f47896j;

        public c(String str, String str2, String[] strArr) {
            super(str);
            this.f47895i = str2;
            this.f47896j = strArr;
        }

        @Override // com.xiaomi.push.k1.a
        public void e(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f47880b, this.f47895i, this.f47896j);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class d extends a {

        /* renamed from: i, reason: collision with root package name */
        public ContentValues f47897i;

        public d(String str, ContentValues contentValues) {
            super(str);
            this.f47897i = contentValues;
        }

        @Override // com.xiaomi.push.k1.a
        public void e(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f47880b, null, this.f47897i);
        }
    }

    public k1(Context context) {
        this.f47876a = context;
    }

    public static k1 b(Context context) {
        if (f47875e == null) {
            synchronized (k1.class) {
                if (f47875e == null) {
                    f47875e = new k1(context);
                }
            }
        }
        return f47875e;
    }

    public final j1 a(String str) {
        j1 j1Var = this.f47877b.get(str);
        if (j1Var == null) {
            synchronized (this.f47877b) {
                try {
                    if (j1Var == null) {
                        throw null;
                    }
                } finally {
                }
            }
        }
        return j1Var;
    }

    public String c(String str) {
        return a(str).a();
    }

    public void d(a aVar) {
        if (aVar != null) {
            throw new IllegalStateException("should exec init method first!");
        }
    }

    public void e(Runnable runnable) {
        if (this.f47878c.isShutdown()) {
            return;
        }
        this.f47878c.execute(runnable);
    }
}
