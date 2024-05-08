package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f39056a;

    /* renamed from: b, reason: collision with root package name */
    private long f39057b;

    /* renamed from: c, reason: collision with root package name */
    private int f39058c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39059d;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.c();
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class RunnableC0610a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private boolean f39063a;

        /* renamed from: b, reason: collision with root package name */
        private UserInfoBean f39064b;

        public RunnableC0610a(UserInfoBean userInfoBean, boolean z10) {
            this.f39064b = userInfoBean;
            this.f39063a = z10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.crashreport.common.info.a b4;
            try {
                UserInfoBean userInfoBean = this.f39064b;
                if (userInfoBean != null) {
                    if (userInfoBean != null && (b4 = com.tencent.bugly.crashreport.common.info.a.b()) != null) {
                        userInfoBean.f39046j = b4.e();
                    }
                    x.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.f39064b, false);
                }
                if (this.f39063a) {
                    a aVar = a.this;
                    w a10 = w.a();
                    if (a10 != null) {
                        a10.a(new AnonymousClass2());
                    }
                }
            } catch (Throwable th) {
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a.this.f39057b) {
                w.a().a(new b(), (a.this.f39057b - currentTimeMillis) + 5000);
            } else {
                a.this.a(3, false, 0L);
                a.this.a();
            }
        }
    }

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private long f39067a;

        public c(long j10) {
            this.f39067a = j10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            w a10 = w.a();
            if (a10 != null) {
                a10.a(new AnonymousClass2());
            }
            a aVar2 = a.this;
            long j10 = this.f39067a;
            w.a().a(new c(j10), j10);
        }
    }

    public a(Context context, boolean z10) {
        this.f39056a = context;
        this.f39059d = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ee A[Catch: all -> 0x016f, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:63:0x00cc, B:73:0x00d3, B:74:0x00e8, B:76:0x00ee, B:78:0x00f3, B:81:0x00fa, B:84:0x0112, B:86:0x0118, B:89:0x0121, B:91:0x0127, B:94:0x0130, B:96:0x013a, B:99:0x0143, B:102:0x0161, B:107:0x0166, B:111:0x00e2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0118 A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:63:0x00cc, B:73:0x00d3, B:74:0x00e8, B:76:0x00ee, B:78:0x00f3, B:81:0x00fa, B:84:0x0112, B:86:0x0118, B:89:0x0121, B:91:0x0127, B:94:0x0130, B:96:0x013a, B:99:0x0143, B:102:0x0161, B:107:0x0166, B:111:0x00e2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0121 A[Catch: all -> 0x016f, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:63:0x00cc, B:73:0x00d3, B:74:0x00e8, B:76:0x00ee, B:78:0x00f3, B:81:0x00fa, B:84:0x0112, B:86:0x0118, B:89:0x0121, B:91:0x0127, B:94:0x0130, B:96:0x013a, B:99:0x0143, B:102:0x0161, B:107:0x0166, B:111:0x00e2), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void c() {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.a.c():void");
    }

    public static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean, boolean z10) {
        List<UserInfoBean> a10;
        if (userInfoBean != null) {
            if (!z10 && userInfoBean.f39038b != 1 && (a10 = aVar.a(com.tencent.bugly.crashreport.common.info.a.a(aVar.f39056a).f39096d)) != null && a10.size() >= 20) {
                x.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a10.size()));
                return;
            }
            long a11 = p.a().a("t_ui", a(userInfoBean), (o) null, true);
            if (a11 >= 0) {
                x.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a11));
                userInfoBean.f39037a = a11;
            }
        }
    }

    public final void b() {
        w a10 = w.a();
        if (a10 != null) {
            a10.a(new AnonymousClass2());
        }
    }

    public final void a(int i10, boolean z10, long j10) {
        com.tencent.bugly.crashreport.common.strategy.a a10 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a10 != null && !a10.c().f39127f && i10 != 1 && i10 != 3) {
            x.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i10 == 1 || i10 == 3) {
            this.f39058c++;
        }
        com.tencent.bugly.crashreport.common.info.a a11 = com.tencent.bugly.crashreport.common.info.a.a(this.f39056a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f39038b = i10;
        userInfoBean.f39039c = a11.f39096d;
        userInfoBean.f39040d = a11.g();
        userInfoBean.f39041e = System.currentTimeMillis();
        userInfoBean.f39042f = -1L;
        userInfoBean.f39050n = a11.f39102j;
        userInfoBean.f39051o = i10 == 1 ? 1 : 0;
        userInfoBean.f39048l = a11.a();
        userInfoBean.f39049m = a11.f39108p;
        userInfoBean.f39043g = a11.f39109q;
        userInfoBean.f39044h = a11.f39110r;
        userInfoBean.f39045i = a11.f39111s;
        userInfoBean.f39047k = a11.f39112t;
        userInfoBean.f39054r = a11.u();
        userInfoBean.f39055s = a11.z();
        userInfoBean.f39052p = a11.A();
        userInfoBean.f39053q = a11.B();
        w.a().a(new RunnableC0610a(userInfoBean, z10), 0L);
    }

    public final void a() {
        this.f39057b = z.b() + 86400000;
        w.a().a(new b(), (this.f39057b - System.currentTimeMillis()) + 5000);
    }

    public final List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (z.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = p.a().a("t_ui", null, str2, null, null, true);
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
                            sb2.append(" or _id");
                            sb2.append(" = ");
                            sb2.append(j10);
                        } catch (Throwable unused) {
                            x.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb3 = sb2.toString();
                if (sb3.length() > 0) {
                    x.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", sb3.substring(4), (String[]) null, (o) null, true)));
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
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size() && i10 < 50; i10++) {
            UserInfoBean userInfoBean = list.get(i10);
            sb2.append(" or _id");
            sb2.append(" = ");
            sb2.append(userInfoBean.f39037a);
        }
        String sb3 = sb2.toString();
        if (sb3.length() > 0) {
            sb3 = sb3.substring(4);
        }
        String str = sb3;
        sb2.setLength(0);
        try {
            x.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", str, (String[]) null, (o) null, true)));
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = userInfoBean.f39037a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f39041e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f39042f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f39038b));
            contentValues.put("_pc", userInfoBean.f39039c);
            contentValues.put("_dt", z.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
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
            UserInfoBean userInfoBean = (UserInfoBean) z.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f39037a = j10;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
