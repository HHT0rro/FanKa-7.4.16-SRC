package com.tencent.bugly.idasc.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tencent.bugly.idasc.crashreport.biz.UserInfoBean;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class r {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f39911e = true;

    /* renamed from: a, reason: collision with root package name */
    private Context f39912a;

    /* renamed from: b, reason: collision with root package name */
    private long f39913b;

    /* renamed from: c, reason: collision with root package name */
    private int f39914c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39915d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private boolean f39921b;

        /* renamed from: c, reason: collision with root package name */
        private UserInfoBean f39922c;

        public a(UserInfoBean userInfoBean, boolean z10) {
            this.f39922c = userInfoBean;
            this.f39921b = z10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (r.this.f39915d) {
                try {
                    UserInfoBean userInfoBean = this.f39922c;
                    if (userInfoBean != null) {
                        r.a(userInfoBean);
                        al.c("[UserInfo] Record user info.", new Object[0]);
                        r.this.a(this.f39922c, false);
                    }
                    if (this.f39921b) {
                        r.this.b();
                    }
                } catch (Throwable th) {
                    if (al.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < r.this.f39913b) {
                ak.a().a(new b(), (r.this.f39913b - currentTimeMillis) + 5000);
            } else {
                r.this.a(3, false);
                r.this.a();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private long f39925b;

        public c(long j10) {
            this.f39925b = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            r.this.b();
            r.this.a(this.f39925b);
        }
    }

    public r(Context context, boolean z10) {
        this.f39912a = context;
        this.f39915d = z10;
    }

    private static int a(List<UserInfoBean> list) {
        int i10;
        long currentTimeMillis = System.currentTimeMillis();
        int i11 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.f39367e > currentTimeMillis - TTAdConstant.AD_MAX_EVENT_TIME && ((i10 = userInfoBean.f39364b) == 1 || i10 == 4 || i10 == 3)) {
                i11++;
            }
        }
        return i11;
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ap.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f39363a = j10;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (ap.b(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = w.a().a("t_ui", (String[]) null, str2);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a10 = a(cursor);
                    if (a10 != null) {
                        arrayList.add(a10);
                    } else {
                        try {
                            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
                            sb2.append(" or _id = ");
                            sb2.append(j10);
                        } catch (Throwable unused) {
                            al.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb3 = sb2.toString();
                if (sb3.length() > 0) {
                    al.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb3.substring(4))));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!al.a(th)) {
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
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public static /* synthetic */ void a(UserInfoBean userInfoBean) {
        aa b4;
        if (userInfoBean == null || (b4 = aa.b()) == null) {
            return;
        }
        userInfoBean.f39372j = b4.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserInfoBean userInfoBean, boolean z10) {
        List<UserInfoBean> a10;
        if (userInfoBean == null) {
            return;
        }
        if (!z10 && userInfoBean.f39364b != 1 && (a10 = a(aa.a(this.f39912a).f39474d)) != null && a10.size() >= 20) {
            al.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a10.size()));
            return;
        }
        long a11 = w.a().a("t_ui", b(userInfoBean), (v) null);
        if (a11 >= 0) {
            al.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a11));
            userInfoBean.f39363a = a11;
        }
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i10 = 0;
            while (i10 < list.size() - 1) {
                int i11 = i10 + 1;
                for (int i12 = i11; i12 < list.size(); i12++) {
                    if (list.get(i10).f39367e > list.get(i12).f39367e) {
                        UserInfoBean userInfoBean = list.get(i10);
                        list.set(i10, list.get(i12));
                        list.set(i12, userInfoBean);
                    }
                }
                i10 = i11;
            }
            for (int i13 = 0; i13 < size; i13++) {
                list2.add(list.get(i13));
            }
        }
    }

    private void a(final List<UserInfoBean> list, boolean z10) {
        aa b4;
        if (!b(z10)) {
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f39368f = currentTimeMillis;
                a(userInfoBean, true);
            }
            al.d("uploadCheck failed", new Object[0]);
            return;
        }
        int i10 = this.f39914c == 1 ? 1 : 2;
        bv bvVar = null;
        if (list != null && list.size() != 0 && (b4 = aa.b()) != null) {
            b4.o();
            bv bvVar2 = new bv();
            bvVar2.f39864b = b4.f39474d;
            bvVar2.f39865c = b4.g();
            ArrayList<bu> arrayList = new ArrayList<>();
            Iterator<UserInfoBean> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                bu a10 = ae.a(iterator2.next());
                if (a10 != null) {
                    arrayList.add(a10);
                }
            }
            bvVar2.f39866d = arrayList;
            HashMap hashMap = new HashMap();
            bvVar2.f39867e = hashMap;
            hashMap.put("A7", new StringBuilder().toString());
            bvVar2.f39867e.put("A6", aa.n());
            bvVar2.f39867e.put("A5", b4.m());
            Map<String, String> map = bvVar2.f39867e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b4.k());
            map.put("A2", sb2.toString());
            Map<String, String> map2 = bvVar2.f39867e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b4.k());
            map2.put("A1", sb3.toString());
            bvVar2.f39867e.put("A24", b4.f39481k);
            Map<String, String> map3 = bvVar2.f39867e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(b4.l());
            map3.put("A17", sb4.toString());
            bvVar2.f39867e.put("A15", b4.q());
            Map<String, String> map4 = bvVar2.f39867e;
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) b4.r());
            map4.put("A13", sb5.toString());
            bvVar2.f39867e.put("F08", b4.E);
            bvVar2.f39867e.put("F09", b4.F);
            Map<String, String> y10 = b4.y();
            if (y10 != null && y10.size() > 0) {
                for (Map.Entry<String, String> entry : y10.entrySet()) {
                    bvVar2.f39867e.put("C04_" + entry.getKey(), entry.getValue());
                }
            }
            if (i10 == 1) {
                bvVar2.f39863a = (byte) 1;
            } else if (i10 != 2) {
                al.e("unknown up type %d ", Integer.valueOf(i10));
            } else {
                bvVar2.f39863a = (byte) 2;
            }
            bvVar = bvVar2;
        }
        if (bvVar == null) {
            al.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] a11 = ae.a((m) bvVar);
        if (a11 == null) {
            al.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        bq a12 = ae.a(this.f39912a, 840, a11);
        if (a12 == null) {
            al.d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        ai.a().a(1001, a12, ac.a().c().f39401q, StrategyBean.f39385a, new ah() { // from class: com.tencent.bugly.idasc.proguard.r.1
            @Override // com.tencent.bugly.idasc.proguard.ah
            public final void a(boolean z11, String str) {
                if (z11) {
                    al.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    for (UserInfoBean userInfoBean2 : list) {
                        userInfoBean2.f39368f = currentTimeMillis2;
                        r.this.a(userInfoBean2, true);
                    }
                }
            }
        }, this.f39914c == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[Catch: all -> 0x0092, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:10:0x002b, B:12:0x003e, B:14:0x004c, B:15:0x0061, B:17:0x0067, B:19:0x006c, B:22:0x0073, B:25:0x0089, B:29:0x005b, B:30:0x0009, B:33:0x0010, B:36:0x0017, B:38:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067 A[Catch: all -> 0x0092, TryCatch #0 {, blocks: (B:3:0x0001, B:10:0x002b, B:12:0x003e, B:14:0x004c, B:15:0x0061, B:17:0x0067, B:19:0x006c, B:22:0x0073, B:25:0x0089, B:29:0x005b, B:30:0x0009, B:33:0x0010, B:36:0x0017, B:38:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(boolean r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f39915d     // Catch: java.lang.Throwable -> L92
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L9
        L7:
            r0 = 0
            goto L27
        L9:
            com.tencent.bugly.idasc.proguard.ai r0 = com.tencent.bugly.idasc.proguard.ai.a()     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L10
            goto L7
        L10:
            com.tencent.bugly.idasc.proguard.ac r3 = com.tencent.bugly.idasc.proguard.ac.a()     // Catch: java.lang.Throwable -> L92
            if (r3 != 0) goto L17
            goto L7
        L17:
            boolean r3 = r3.b()     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L26
            r3 = 1001(0x3e9, float:1.403E-42)
            boolean r0 = r0.b(r3)     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L26
            goto L7
        L26:
            r0 = 1
        L27:
            if (r0 != 0) goto L2b
            monitor-exit(r7)
            return
        L2b:
            android.content.Context r0 = r7.f39912a     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.idasc.proguard.aa r0 = com.tencent.bugly.idasc.proguard.aa.a(r0)     // Catch: java.lang.Throwable -> L92
            java.lang.String r0 = r0.f39474d     // Catch: java.lang.Throwable -> L92
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L92
            r3.<init>()     // Catch: java.lang.Throwable -> L92
            java.util.List r0 = a(r0)     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L5b
            a(r0, r3)     // Catch: java.lang.Throwable -> L92
            b(r0, r3)     // Catch: java.lang.Throwable -> L92
            int r4 = a(r0)     // Catch: java.lang.Throwable -> L92
            r5 = 15
            if (r4 <= r5) goto L60
            java.lang.String r5 = "[UserInfo] Upload user info too many times in 10 min: %d"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L92
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L92
            r6[r2] = r4     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.idasc.proguard.al.d(r5, r6)     // Catch: java.lang.Throwable -> L92
            r4 = 0
            goto L61
        L5b:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L92
            r0.<init>()     // Catch: java.lang.Throwable -> L92
        L60:
            r4 = 1
        L61:
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L92
            if (r5 <= 0) goto L6a
            b(r3)     // Catch: java.lang.Throwable -> L92
        L6a:
            if (r4 == 0) goto L89
            int r3 = r0.size()     // Catch: java.lang.Throwable -> L92
            if (r3 != 0) goto L73
            goto L89
        L73:
            java.lang.String r3 = "[UserInfo] Upload user info(size: %d)"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L92
            int r4 = r0.size()     // Catch: java.lang.Throwable -> L92
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L92
            r1[r2] = r4     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.idasc.proguard.al.c(r3, r1)     // Catch: java.lang.Throwable -> L92
            r7.a(r0, r8)     // Catch: java.lang.Throwable -> L92
            monitor-exit(r7)
            return
        L89:
            java.lang.String r8 = "[UserInfo] There is no user info in local database."
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L92
            com.tencent.bugly.idasc.proguard.al.c(r8, r0)     // Catch: java.lang.Throwable -> L92
            monitor-exit(r7)
            return
        L92:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.r.a(boolean):void");
    }

    private static ContentValues b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = userInfoBean.f39363a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f39367e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f39368f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f39364b));
            contentValues.put("_pc", userInfoBean.f39365c);
            contentValues.put("_dt", ap.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static void b(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size() && i10 < 50; i10++) {
            UserInfoBean userInfoBean = list.get(i10);
            sb2.append(" or _id = ");
            sb2.append(userInfoBean.f39363a);
        }
        String sb3 = sb2.toString();
        if (sb3.length() > 0) {
            sb3 = sb3.substring(4);
        }
        sb2.setLength(0);
        try {
            al.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb3)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            UserInfoBean next = iterator2.next();
            if (next.f39368f != -1) {
                iterator2.remove();
                if (next.f39367e < ap.b()) {
                    list2.add(next);
                }
            }
        }
    }

    private boolean b(boolean z10) {
        boolean z11;
        boolean z12 = true;
        if (!f39911e) {
            return true;
        }
        File file = new File(this.f39912a.getFilesDir(), "bugly_last_us_up_tm");
        long currentTimeMillis = System.currentTimeMillis();
        if (z10) {
            am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
            return true;
        }
        if (file.exists()) {
            BufferedReader a10 = ap.a(file);
            try {
                if (a10 != null) {
                    try {
                        long longValue = Long.valueOf(a10.readLine().trim()).longValue();
                        if (currentTimeMillis >= longValue && currentTimeMillis - longValue <= 86400000) {
                            z11 = true;
                            if (z11 || currentTimeMillis - longValue >= com.huawei.openalliance.ad.constant.u.as) {
                                am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                            } else {
                                z12 = false;
                            }
                        }
                        z11 = false;
                        if (z11) {
                        }
                        am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                    } catch (Throwable th) {
                        try {
                            al.b(th);
                            am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                            a10.close();
                        } catch (Throwable th2) {
                            try {
                                a10.close();
                            } catch (Exception e2) {
                                al.a(e2);
                            }
                            throw th2;
                        }
                    }
                }
                if (a10 != null) {
                    a10.close();
                }
            } catch (Exception e10) {
                al.a(e10);
            }
        } else {
            am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
        }
        return z12;
    }

    public final void a() {
        this.f39913b = ap.b() + 86400000;
        ak.a().a(new b(), (this.f39913b - System.currentTimeMillis()) + 5000);
    }

    public final void a(int i10, boolean z10) {
        ac a10 = ac.a();
        if (a10 != null && !a10.c().f39391g && i10 != 1 && i10 != 3) {
            al.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i10 == 1 || i10 == 3) {
            this.f39914c++;
        }
        aa a11 = aa.a(this.f39912a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f39364b = i10;
        userInfoBean.f39365c = a11.f39474d;
        userInfoBean.f39366d = a11.f();
        userInfoBean.f39367e = System.currentTimeMillis();
        userInfoBean.f39368f = -1L;
        userInfoBean.f39376n = a11.f39485o;
        userInfoBean.f39377o = i10 == 1 ? 1 : 0;
        userInfoBean.f39374l = a11.a();
        userInfoBean.f39375m = a11.f39495y;
        userInfoBean.f39369g = a11.f39496z;
        userInfoBean.f39370h = a11.A;
        userInfoBean.f39371i = a11.B;
        userInfoBean.f39373k = a11.C;
        userInfoBean.f39380r = a11.t();
        userInfoBean.f39381s = a11.y();
        userInfoBean.f39378p = a11.z();
        userInfoBean.f39379q = a11.f39494x;
        ak.a().a(new a(userInfoBean, z10), 0L);
    }

    public final void a(long j10) {
        ak.a().a(new c(j10), j10);
    }

    public final void b() {
        ak a10 = ak.a();
        if (a10 != null) {
            a10.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.r.2

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ boolean f39918a = false;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        r.this.a(this.f39918a);
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
            });
        }
    }
}
