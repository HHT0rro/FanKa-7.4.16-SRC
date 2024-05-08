package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final long f39948a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    private static u f39949b;

    /* renamed from: c, reason: collision with root package name */
    private Context f39950c;

    /* renamed from: f, reason: collision with root package name */
    private SharedPreferences f39953f;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Map<String, t>> f39952e = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private String f39951d = aa.b().f39474d;

    private u(Context context) {
        this.f39950c = context;
        this.f39953f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            uVar = f39949b;
        }
        return uVar;
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (f39949b == null) {
                f39949b = new u(context);
            }
            uVar = f39949b;
        }
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0049 A[Catch: all -> 0x004d, Exception -> 0x004f, TRY_ENTER, TryCatch #1 {Exception -> 0x004f, blocks: (B:9:0x0006, B:15:0x0025, B:22:0x003f, B:30:0x0049, B:31:0x004c), top: B:8:0x0006, outer: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> void a(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            android.content.Context r2 = r4.f39950c     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r3 = "crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L30
            r2.writeObject(r6)     // Catch: java.io.IOException -> L2a java.lang.Throwable -> L46
            r2.close()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            monitor-exit(r4)
            return
        L2a:
            r5 = move-exception
            goto L33
        L2c:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L47
        L30:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L33:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L46
            com.tencent.bugly.idasc.proguard.al.a(r5, r6)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L44
            r2.close()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            monitor-exit(r4)
            return
        L44:
            monitor-exit(r4)
            return
        L46:
            r5 = move-exception
        L47:
            if (r2 == 0) goto L4c
            r2.close()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
        L4c:
            throw r5     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
        L4d:
            r5 = move-exception
            goto L58
        L4f:
            java.lang.String r5 = "writeCrashRecord error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.idasc.proguard.al.e(r5, r6)     // Catch: java.lang.Throwable -> L4d
            monitor-exit(r4)
            return
        L58:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.u.a(int, java.util.List):void");
    }

    public static /* synthetic */ boolean a(t tVar, t tVar2) {
        String str;
        return tVar.f39947g == tVar2.f39947g && (str = tVar.f39942b) != null && str.equalsIgnoreCase(tVar2.f39942b);
    }

    public static /* synthetic */ boolean b(t tVar, t tVar2) {
        String str = tVar.f39945e;
        if (str != null && !str.equalsIgnoreCase(tVar2.f39945e)) {
            return true;
        }
        String str2 = tVar.f39946f;
        return !(str2 == null || str2.equalsIgnoreCase(tVar2.f39946f)) || tVar.f39944d <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized boolean c(int i10) {
        try {
            List<t> d10 = d(i10);
            if (d10 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (t tVar : d10) {
                String str = tVar.f39942b;
                if (str != null && str.equalsIgnoreCase(this.f39951d) && tVar.f39944d > 0) {
                    arrayList.add(tVar);
                }
                if (tVar.f39943c + 86400000 < currentTimeMillis) {
                    arrayList2.add(tVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() < 2) {
                d10.removeAll(arrayList2);
                a(i10, (int) d10);
                return false;
            }
            if (arrayList.size() <= 0 || ((t) arrayList.get(arrayList.size() - 1)).f39943c + 86400000 >= currentTimeMillis) {
                return true;
            }
            d10.clear();
            a(i10, (int) d10);
            return false;
        } catch (Exception unused) {
            al.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T d(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            android.content.Context r3 = r5.f39950c     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            if (r6 != 0) goto L1c
            monitor-exit(r5)
            return r0
        L1c:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L31 java.lang.ClassNotFoundException -> L34 java.io.IOException -> L42
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L35 java.io.IOException -> L43 java.lang.Throwable -> L4d
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L35 java.io.IOException -> L43 java.lang.Throwable -> L4d
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            monitor-exit(r5)
            return r2
        L31:
            r2 = move-exception
            r6 = r0
            goto L4e
        L34:
            r6 = r0
        L35:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.idasc.proguard.al.a(r2, r3)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L5d
        L3e:
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            goto L5d
        L42:
            r6 = r0
        L43:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.idasc.proguard.al.a(r2, r3)     // Catch: java.lang.Throwable -> L4d
            if (r6 == 0) goto L5d
            goto L3e
        L4d:
            r2 = move-exception
        L4e:
            if (r6 == 0) goto L53
            r6.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
        L53:
            throw r2     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
        L54:
            r6 = move-exception
            goto L5f
        L56:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L54
            com.tencent.bugly.idasc.proguard.al.e(r6, r1)     // Catch: java.lang.Throwable -> L54
        L5d:
            monitor-exit(r5)
            return r0
        L5f:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.u.d(int):java.util.List");
    }

    public final void a(final int i10) {
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.u.1

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f39954a = 1004;

            @Override // java.lang.Runnable
            public final void run() {
                t tVar;
                try {
                    if (TextUtils.isEmpty(u.this.f39951d)) {
                        return;
                    }
                    List<t> d10 = u.this.d(this.f39954a);
                    if (d10 == null) {
                        d10 = new ArrayList();
                    }
                    if (u.this.f39952e.get(Integer.valueOf(this.f39954a)) == null) {
                        u.this.f39952e.put(Integer.valueOf(this.f39954a), new HashMap());
                    }
                    if (((Map) u.this.f39952e.get(Integer.valueOf(this.f39954a))).get(u.this.f39951d) == null) {
                        tVar = new t();
                        tVar.f39941a = this.f39954a;
                        tVar.f39947g = u.f39948a;
                        tVar.f39942b = u.this.f39951d;
                        tVar.f39946f = aa.b().f39485o;
                        tVar.f39945e = aa.b().f39478h;
                        tVar.f39943c = System.currentTimeMillis();
                        tVar.f39944d = i10;
                        ((Map) u.this.f39952e.get(Integer.valueOf(this.f39954a))).put(u.this.f39951d, tVar);
                    } else {
                        tVar = (t) ((Map) u.this.f39952e.get(Integer.valueOf(this.f39954a))).get(u.this.f39951d);
                        tVar.f39944d = i10;
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z10 = false;
                    for (t tVar2 : d10) {
                        if (u.a(tVar2, tVar)) {
                            z10 = true;
                            tVar2.f39944d = tVar.f39944d;
                        }
                        if (u.b(tVar2, tVar)) {
                            arrayList.add(tVar2);
                        }
                    }
                    d10.removeAll(arrayList);
                    if (!z10) {
                        d10.add(tVar);
                    }
                    u.this.a(this.f39954a, (int) d10);
                } catch (Exception unused) {
                    al.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    public final synchronized boolean b(final int i10) {
        boolean z10;
        z10 = true;
        try {
            z10 = this.f39953f.getBoolean(i10 + "_" + this.f39951d, true);
            ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.u.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean c4 = u.this.c(i10);
                    u.this.f39953f.edit().putBoolean(i10 + "_" + u.this.f39951d, !c4).commit();
                }
            });
        } catch (Exception unused) {
            al.e("canInit error", new Object[0]);
            return z10;
        }
        return z10;
    }
}
