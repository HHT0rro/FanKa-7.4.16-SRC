package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static final int f36171a = 3;

    /* renamed from: b, reason: collision with root package name */
    private static q f36172b = null;

    /* renamed from: g, reason: collision with root package name */
    private static final String f36173g = "1";

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f36174c = false;

    /* renamed from: d, reason: collision with root package name */
    private dp f36175d;

    /* renamed from: e, reason: collision with root package name */
    private Context f36176e;

    /* renamed from: f, reason: collision with root package name */
    private t f36177f;

    private q(Context context) {
        this.f36176e = context;
        this.f36175d = dp.a(context);
        this.f36177f = t.a(context);
    }

    private static void d() {
        try {
            dp a10 = dp.a();
            if (a10 != null) {
                a10.b("W_S_V", "1");
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        for (s sVar : this.f36177f.a()) {
            r a10 = r.a();
            if ((a10 != null ? a10.d(sVar.f36193c) : null) == null) {
                a(sVar.f36191a, sVar.f36194d, (PackageInfo) null);
            }
        }
    }

    public static synchronized q a(Context context) {
        q qVar;
        synchronized (q.class) {
            try {
                if (f36172b == null) {
                    f36172b = new q(context);
                }
                qVar = f36172b;
            } catch (Exception unused) {
                return null;
            }
        }
        return qVar;
    }

    public synchronized void b() {
        try {
            if (this.f36174c) {
                return;
            }
            this.f36174c = true;
            for (s sVar : this.f36177f.a()) {
                String str = null;
                try {
                    str = this.f36176e.getFilesDir().getCanonicalPath();
                } catch (Throwable unused) {
                }
                if (str != null) {
                    sVar.f36203m = str + bi.f35840j + sVar.f36191a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(sVar.f36203m);
                    sb2.append("/lib");
                    dn.c(sb2.toString());
                    dn.c(sVar.f36203m);
                }
            }
            this.f36177f.b();
            if (!this.f36175d.b(dp.f36099d)) {
                this.f36175d.a(dp.f36099d, Boolean.TRUE, true);
            } else {
                this.f36177f.c();
            }
            n.a().a(new u(this.f36176e, 1, false));
        } catch (Throwable unused2) {
        }
    }

    public void a() {
        d();
        if (WeaponHI.isLoad) {
            b();
        } else {
            WeaponHI.iD();
        }
    }

    public synchronized boolean a(int i10, String str, PackageInfo packageInfo) {
        return a(i10, str, null, false, packageInfo);
    }

    private synchronized boolean a(int i10, String str, String str2, boolean z10, PackageInfo packageInfo) {
        if (z10) {
            if (this.f36177f.c(i10) != 1) {
                return false;
            }
        }
        s a10 = this.f36177f.a(i10);
        if (a10 == null) {
            this.f36177f.b(i10, -1);
            return false;
        }
        if (!dn.a(new File(a10.f36195e))) {
            this.f36177f.b(i10, -1);
            return false;
        }
        if (packageInfo != null) {
            a10.f36208r = packageInfo;
        }
        r a11 = r.a(this.f36176e.getApplicationContext(), true);
        if (!a11.a(a10, false)) {
            this.f36177f.b(i10, -1);
            a11.a(a10.f36195e);
            return false;
        }
        s c4 = a11.c(a10.f36195e);
        c4.f36192b = 1;
        c4.f36206p = 1;
        this.f36177f.a(c4);
        return true;
    }

    public void b(String str) {
        r a10;
        try {
            if (TextUtils.isEmpty(str) || (a10 = r.a()) == null) {
                return;
            }
            a10.b(str);
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2) {
        this.f36177f.a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public void a(final String str) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1
                @Override // java.lang.Runnable
                public void run() {
                    final r a10;
                    try {
                        if (TextUtils.isEmpty(str) || (a10 = r.a(q.this.f36176e.getApplicationContext(), true)) == null) {
                            return;
                        }
                        final s d10 = a10.d(str);
                        if (d10 == null) {
                            s b4 = q.this.f36177f.b(str);
                            if (b4 != null) {
                                q.this.a(str, b4.f36195e);
                                return;
                            }
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                a10.b(str);
                                q.this.f36177f.a(str);
                                File file = new File(d10.f36195e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, TTAdConstant.AD_MAX_EVENT_TIME);
                        a10.b(str);
                        q.this.f36177f.a(str);
                        File file = new File(d10.f36195e);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public boolean a(s sVar, String str, String str2) {
        r a10;
        if (sVar == null) {
            return false;
        }
        File file = new File(sVar.f36195e);
        if (!dn.a(file)) {
            return false;
        }
        try {
            if (!this.f36177f.b(sVar.f36191a)) {
                this.f36177f.a(sVar);
            }
            a10 = r.a(this.f36176e.getApplicationContext(), true);
            this.f36177f.a(sVar.f36191a, 1);
            b(sVar.f36193c);
        } catch (Throwable unused) {
        }
        if (!a10.a(sVar, true)) {
            file.delete();
            a(sVar.f36191a, sVar.f36194d, null, true, null);
            this.f36177f.a(sVar.f36191a, 0);
            return false;
        }
        sVar = a10.c(sVar.f36195e);
        if (sVar == null) {
            this.f36177f.a(sVar.f36191a, 0);
            return false;
        }
        try {
            s a11 = this.f36177f.a(sVar.f36191a);
            File file2 = null;
            if (a11 != null && !a11.f36194d.equals(sVar.f36194d)) {
                file2 = new File(a11.f36195e);
            }
            sVar.f36192b = 1;
            sVar.f36206p = 1;
            if (this.f36177f.a(sVar) > 0 && file2 != null && file2.exists()) {
                file2.delete();
            }
            this.f36177f.a(sVar.f36191a, 0);
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
