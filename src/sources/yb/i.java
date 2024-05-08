package yb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.internal.power.ModemPowerProfile;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: Database.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class i {

    /* renamed from: n, reason: collision with root package name */
    public static Boolean f54747n;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f54748a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final String f54749b;

    /* renamed from: c, reason: collision with root package name */
    public final int f54750c;

    /* renamed from: d, reason: collision with root package name */
    public final int f54751d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final Context f54752e;

    /* renamed from: h, reason: collision with root package name */
    public o f54755h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public SQLiteDatabase f54756i;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Integer f54759l;

    /* renamed from: f, reason: collision with root package name */
    public final List<com.tekartik.sqflite.operation.d> f54753f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final Map<Integer, t> f54754g = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public int f54757j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f54758k = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f54760m = 0;

    /* compiled from: Database.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements DatabaseErrorHandler {
        public a() {
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }

    public i(Context context, String str, int i10, boolean z10, int i11) {
        this.f54752e = context;
        this.f54749b = str;
        this.f54748a = z10;
        this.f54750c = i10;
        this.f54751d = i11;
    }

    public static /* synthetic */ Cursor G(d0 d0Var, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        d0Var.a(sQLiteQuery);
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(com.tekartik.sqflite.operation.c cVar) {
        Boolean e2 = cVar.e();
        boolean z10 = Boolean.TRUE.equals(e2) && cVar.d();
        if (z10) {
            int i10 = this.f54758k + 1;
            this.f54758k = i10;
            this.f54759l = Integer.valueOf(i10);
        }
        if (!w(cVar)) {
            if (z10) {
                this.f54759l = null;
            }
        } else if (z10) {
            HashMap hashMap = new HashMap();
            hashMap.put("transactionId", this.f54759l);
            cVar.success(hashMap);
        } else {
            if (Boolean.FALSE.equals(e2)) {
                this.f54759l = null;
            }
            cVar.success(null);
        }
    }

    @VisibleForTesting
    @NotNull
    public static boolean i(Context context, String str, boolean z10) {
        ApplicationInfo y10;
        try {
            String packageName = context.getPackageName();
            if (Build.VERSION.SDK_INT >= 33) {
                y10 = context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128L));
            } else {
                y10 = y(context, packageName, 128);
            }
            return y10.metaData.getBoolean(str, z10);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @VisibleForTesting
    @NotNull
    public static boolean j(Context context) {
        return i(context, "com.tekartik.sqflite.wal_enabled", false);
    }

    public static void o(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    public static boolean x(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static ApplicationInfo y(Context context, String str, int i10) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(str, i10);
    }

    public String A() {
        return "[" + B() + "] ";
    }

    public String B() {
        Thread currentThread = Thread.currentThread();
        return "" + this.f54750c + "," + currentThread.getName() + "(" + currentThread.getId() + ")";
    }

    public SQLiteDatabase C() {
        return this.f54756i;
    }

    public void D(Exception exc, com.tekartik.sqflite.operation.c cVar) {
        if (exc instanceof SQLiteCantOpenDatabaseException) {
            cVar.error("sqlite_error", "open_failed " + this.f54749b, null);
            return;
        }
        if (exc instanceof SQLException) {
            cVar.error("sqlite_error", exc.getMessage(), com.tekartik.sqflite.operation.e.a(cVar));
        } else {
            cVar.error("sqlite_error", exc.getMessage(), com.tekartik.sqflite.operation.e.a(cVar));
        }
    }

    public void E(final com.tekartik.sqflite.operation.c cVar) {
        S(cVar, new Runnable() { // from class: yb.d
            @Override // java.lang.Runnable
            public final void run() {
                i.this.I(cVar);
            }
        });
    }

    public synchronized boolean F() {
        return this.f54757j > 0;
    }

    public void M() {
        if (f54747n == null) {
            Boolean valueOf = Boolean.valueOf(j(this.f54752e));
            f54747n = valueOf;
            if (valueOf.booleanValue() && r.c(this.f54751d)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(A());
                sb2.append("[sqflite] WAL enabled");
            }
        }
        this.f54756i = SQLiteDatabase.openDatabase(this.f54749b, null, f54747n.booleanValue() ? ModemPowerProfile.MODEM_DRAIN_TYPE_TX : 268435456);
    }

    public void N() {
        this.f54756i = SQLiteDatabase.openDatabase(this.f54749b, null, 1, new a());
    }

    public void O(@NonNull final com.tekartik.sqflite.operation.c cVar) {
        S(cVar, new Runnable() { // from class: yb.f
            @Override // java.lang.Runnable
            public final void run() {
                i.this.J(cVar);
            }
        });
    }

    public void P(@NonNull final com.tekartik.sqflite.operation.c cVar) {
        S(cVar, new Runnable() { // from class: yb.e
            @Override // java.lang.Runnable
            public final void run() {
                i.this.K(cVar);
            }
        });
    }

    public final void Q() {
        while (!this.f54753f.isEmpty() && this.f54759l == null) {
            this.f54753f.get(0).a();
            this.f54753f.remove(0);
        }
    }

    public void R(@NonNull final com.tekartik.sqflite.operation.c cVar) {
        S(cVar, new Runnable() { // from class: yb.g
            @Override // java.lang.Runnable
            public final void run() {
                i.this.L(cVar);
            }
        });
    }

    public final void S(@NonNull com.tekartik.sqflite.operation.c cVar, Runnable runnable) {
        Integer transactionId = cVar.getTransactionId();
        Integer num = this.f54759l;
        if (num == null) {
            runnable.run();
            return;
        }
        if (transactionId != null && (transactionId.equals(num) || transactionId.intValue() == -1)) {
            runnable.run();
            if (this.f54759l != null || this.f54753f.isEmpty()) {
                return;
            }
            this.f54755h.c(this, new Runnable() { // from class: yb.c
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.Q();
                }
            });
            return;
        }
        this.f54753f.add(new com.tekartik.sqflite.operation.d(cVar, runnable));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x008a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(io.flutter.plugin.common.MethodCall r9, io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            com.tekartik.sqflite.operation.MethodCallOperation r0 = new com.tekartik.sqflite.operation.MethodCallOperation
            r0.<init>(r9, r10)
            boolean r9 = r0.f()
            boolean r1 = r0.h()
            java.lang.String r2 = "operations"
            java.lang.Object r0 = r0.a(r2)
            java.util.List r0 = (java.util.List) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator2()
        L1e:
            boolean r3 = r0.hasNext()
            r4 = 0
            if (r3 == 0) goto Le0
            java.lang.Object r3 = r0.next()
            java.util.Map r3 = (java.util.Map) r3
            com.tekartik.sqflite.operation.BatchOperation r5 = new com.tekartik.sqflite.operation.BatchOperation
            r5.<init>(r3, r9)
            java.lang.String r3 = r5.getMethod()
            r3.hashCode()
            r6 = -1
            int r7 = r3.hashCode()
            switch(r7) {
                case -1319569547: goto L61;
                case -1183792455: goto L56;
                case -838846263: goto L4b;
                case 107944136: goto L40;
                default: goto L3f;
            }
        L3f:
            goto L6b
        L40:
            java.lang.String r7 = "query"
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L49
            goto L6b
        L49:
            r6 = 3
            goto L6b
        L4b:
            java.lang.String r7 = "update"
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L54
            goto L6b
        L54:
            r6 = 2
            goto L6b
        L56:
            java.lang.String r7 = "insert"
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L5f
            goto L6b
        L5f:
            r6 = 1
            goto L6b
        L61:
            java.lang.String r7 = "execute"
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L6a
            goto L6b
        L6a:
            r6 = 0
        L6b:
            switch(r6) {
                case 0: goto Lca;
                case 1: goto Lb4;
                case 2: goto L9e;
                case 3: goto L8a;
                default: goto L6e;
            }
        L6e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Batch method '"
            r9.append(r0)
            r9.append(r3)
            java.lang.String r0 = "' not supported"
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "bad_param"
            r10.error(r0, r9, r4)
            return
        L8a:
            boolean r3 = r8.J(r5)
            if (r3 == 0) goto L94
            r5.p(r2)
            goto L1e
        L94:
            if (r1 == 0) goto L9a
            r5.o(r2)
            goto L1e
        L9a:
            r5.n(r10)
            return
        L9e:
            boolean r3 = r8.L(r5)
            if (r3 == 0) goto La9
            r5.p(r2)
            goto L1e
        La9:
            if (r1 == 0) goto Lb0
            r5.o(r2)
            goto L1e
        Lb0:
            r5.n(r10)
            return
        Lb4:
            boolean r3 = r8.I(r5)
            if (r3 == 0) goto Lbf
            r5.p(r2)
            goto L1e
        Lbf:
            if (r1 == 0) goto Lc6
            r5.o(r2)
            goto L1e
        Lc6:
            r5.n(r10)
            return
        Lca:
            boolean r3 = r8.p(r5)
            if (r3 == 0) goto Ld5
            r5.p(r2)
            goto L1e
        Ld5:
            if (r1 == 0) goto Ldc
            r5.o(r2)
            goto L1e
        Ldc:
            r5.n(r10)
            return
        Le0:
            if (r9 == 0) goto Le6
            r10.success(r4)
            goto Le9
        Le6:
            r10.success(r2)
        Le9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: yb.i.h(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void k() {
        if (!this.f54754g.isEmpty() && r.b(this.f54751d)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(A());
            sb2.append(this.f54754g.size());
            sb2.append(" cursor(s) are left opened");
        }
        this.f54756i.close();
    }

    public final void l(int i10) {
        t tVar = this.f54754g.get(Integer.valueOf(i10));
        if (tVar != null) {
            m(tVar);
        }
    }

    public final void m(@NonNull t tVar) {
        try {
            int i10 = tVar.f54787a;
            if (r.c(this.f54751d)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(A());
                sb2.append("closing cursor ");
                sb2.append(i10);
            }
            this.f54754g.remove(Integer.valueOf(i10));
            tVar.f54789c.close();
        } catch (Exception unused) {
        }
    }

    public final Map<String, Object> n(Cursor cursor, @Nullable Integer num) {
        HashMap hashMap = null;
        ArrayList arrayList = null;
        int i10 = 0;
        while (cursor.moveToNext()) {
            if (hashMap == null) {
                ArrayList arrayList2 = new ArrayList();
                HashMap hashMap2 = new HashMap();
                i10 = cursor.getColumnCount();
                hashMap2.put("columns", Arrays.asList(cursor.getColumnNames()));
                hashMap2.put("rows", arrayList2);
                arrayList = arrayList2;
                hashMap = hashMap2;
            }
            arrayList.add(e0.a(cursor, i10));
            if (num != null && arrayList.size() >= num.intValue()) {
                break;
            }
        }
        return hashMap == null ? new HashMap() : hashMap;
    }

    public final boolean p(com.tekartik.sqflite.operation.c cVar) {
        if (!w(cVar)) {
            return false;
        }
        cVar.success(null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b8  */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean I(com.tekartik.sqflite.operation.c r9) {
        /*
            r8 = this;
            boolean r0 = r8.w(r9)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r0 = r9.f()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L14
            r9.success(r2)
            return r3
        L14:
            java.lang.String r0 = "SELECT changes(), last_insert_rowid()"
            android.database.sqlite.SQLiteDatabase r4 = r8.C()     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> La7
            android.database.Cursor r0 = r4.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> La7
            if (r0 == 0) goto L8b
            int r4 = r0.getCount()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            if (r4 <= 0) goto L8b
            boolean r4 = r0.moveToFirst()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            if (r4 == 0) goto L8b
            int r4 = r0.getInt(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            if (r4 != 0) goto L5e
            int r4 = r8.f54751d     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            boolean r4 = yb.r.b(r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            if (r4 == 0) goto L57
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r4.<init>()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            java.lang.String r5 = r8.A()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r4.append(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            java.lang.String r5 = "no changes (id was "
            r4.append(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            long r5 = r0.getLong(r3)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r4.append(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
        L57:
            r9.success(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r0.close()
            return r3
        L5e:
            long r4 = r0.getLong(r3)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            int r2 = r8.f54751d     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            boolean r2 = yb.r.b(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            if (r2 == 0) goto L7e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r2.<init>()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            java.lang.String r6 = r8.A()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r2.append(r6)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            java.lang.String r6 = "inserted "
            r2.append(r6)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r2.append(r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
        L7e:
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r9.success(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r0.close()
            return r3
        L89:
            r2 = move-exception
            goto Lab
        L8b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r4.<init>()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            java.lang.String r5 = r8.A()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r4.append(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            java.lang.String r5 = "fail to read changes for Insert"
            r4.append(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            r9.success(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lb4
            if (r0 == 0) goto La4
            r0.close()
        La4:
            return r3
        La5:
            r9 = move-exception
            goto Lb6
        La7:
            r0 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
        Lab:
            r8.D(r2, r9)     // Catch: java.lang.Throwable -> Lb4
            if (r0 == 0) goto Lb3
            r0.close()
        Lb3:
            return r1
        Lb4:
            r9 = move-exception
            r2 = r0
        Lb6:
            if (r2 == 0) goto Lbb
            r2.close()
        Lbb:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: yb.i.I(com.tekartik.sqflite.operation.c):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.tekartik.sqflite.operation.OperationResult, com.tekartik.sqflite.operation.c] */
    /* JADX WARN: Type inference failed for: r1v0, types: [yb.d0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v0, types: [yb.i] */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final boolean J(@NonNull com.tekartik.sqflite.operation.c cVar) {
        Integer num = (Integer) cVar.a("cursorPageSize");
        final ?? c4 = cVar.c();
        if (r.b(this.f54751d)) {
            ?? sb2 = new StringBuilder();
            sb2.append(A());
            sb2.append(c4);
        }
        t tVar = null;
        try {
            try {
                c4 = z().rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: yb.b
                    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                        Cursor G;
                        G = i.G(d0.this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                        return G;
                    }
                }, c4.c(), yb.a.f54702a, null);
                try {
                    Map<String, Object> n10 = n(c4, num);
                    if ((num == null || c4.isLast() || c4.isAfterLast()) ? false : true) {
                        int i10 = this.f54760m + 1;
                        this.f54760m = i10;
                        n10.put("cursorId", Integer.valueOf(i10));
                        t tVar2 = new t(i10, num.intValue(), c4);
                        try {
                            this.f54754g.put(Integer.valueOf(i10), tVar2);
                            tVar = tVar2;
                        } catch (Exception e2) {
                            e = e2;
                            tVar = tVar2;
                            D(e, cVar);
                            if (tVar != null) {
                                m(tVar);
                            }
                            if (tVar == null && c4 != 0) {
                                c4.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            tVar = tVar2;
                            if (tVar == null && c4 != 0) {
                                c4.close();
                            }
                            throw th;
                        }
                    }
                    cVar.success(n10);
                    if (tVar == null && c4 != 0) {
                        c4.close();
                    }
                    return true;
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Exception e11) {
                e = e11;
                c4 = 0;
            } catch (Throwable th2) {
                th = th2;
                c4 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00bb: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:42:0x00bb */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final boolean K(@NonNull com.tekartik.sqflite.operation.c cVar) {
        boolean z10;
        boolean z11;
        int intValue = ((Integer) cVar.a("cursorId")).intValue();
        boolean equals = Boolean.TRUE.equals(cVar.a(CardEventType.CLICK_ACTION_CANCEL));
        if (r.c(this.f54751d)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(A());
            sb2.append("cursor ");
            sb2.append(intValue);
            sb2.append(equals ? " cancel" : " next");
        }
        t tVar = null;
        if (equals) {
            l(intValue);
            cVar.success(null);
            return true;
        }
        t tVar2 = this.f54754g.get(Integer.valueOf(intValue));
        boolean z12 = false;
        try {
            try {
                if (tVar2 != null) {
                    Cursor cursor = tVar2.f54789c;
                    Map<String, Object> n10 = n(cursor, Integer.valueOf(tVar2.f54788b));
                    z10 = (cursor.isLast() || cursor.isAfterLast()) ? false : true;
                    if (z10) {
                        try {
                            n10.put("cursorId", Integer.valueOf(intValue));
                        } catch (Exception e2) {
                            e = e2;
                            D(e, cVar);
                            if (tVar2 != null) {
                                m(tVar2);
                            } else {
                                tVar = tVar2;
                            }
                            if (!z10 && tVar != null) {
                                m(tVar);
                            }
                            return false;
                        }
                    }
                    cVar.success(n10);
                    if (!z10) {
                        m(tVar2);
                    }
                    return true;
                }
                throw new IllegalStateException("Cursor " + intValue + " not found");
            } catch (Exception e10) {
                e = e10;
                z10 = false;
            } catch (Throwable th) {
                th = th;
                if (!z12) {
                    m(tVar2);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z12 = z11;
            if (!z12 && tVar2 != null) {
                m(tVar2);
            }
            throw th;
        }
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final boolean L(com.tekartik.sqflite.operation.c cVar) {
        if (!w(cVar)) {
            return false;
        }
        Cursor cursor = null;
        if (cVar.f()) {
            cVar.success(null);
            return true;
        }
        try {
            try {
                Cursor rawQuery = C().rawQuery("SELECT changes()", null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0 && rawQuery.moveToFirst()) {
                            int i10 = rawQuery.getInt(0);
                            if (r.b(this.f54751d)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(A());
                                sb2.append("changed ");
                                sb2.append(i10);
                            }
                            cVar.success(Integer.valueOf(i10));
                            rawQuery.close();
                            return true;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = rawQuery;
                        D(e, cVar);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(A());
                sb3.append("fail to read changes for Update/Delete");
                cVar.success(null);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    public synchronized void u(Boolean bool) {
        if (Boolean.TRUE.equals(bool)) {
            this.f54757j++;
        } else if (Boolean.FALSE.equals(bool)) {
            this.f54757j--;
        }
    }

    public void v(@NonNull final com.tekartik.sqflite.operation.c cVar) {
        S(cVar, new Runnable() { // from class: yb.h
            @Override // java.lang.Runnable
            public final void run() {
                i.this.H(cVar);
            }
        });
    }

    public final boolean w(com.tekartik.sqflite.operation.c cVar) {
        d0 c4 = cVar.c();
        if (r.b(this.f54751d)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(A());
            sb2.append((Object) c4);
        }
        Boolean e2 = cVar.e();
        try {
            C().execSQL(c4.c(), c4.d());
            u(e2);
            return true;
        } catch (Exception e10) {
            D(e10, cVar);
            return false;
        }
    }

    public SQLiteDatabase z() {
        return this.f54756i;
    }
}
