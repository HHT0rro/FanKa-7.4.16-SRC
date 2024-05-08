package kc;

import android.content.SharedPreferences;
import com.xiaomi.push.g3;
import com.xiaomi.push.i3;
import com.xiaomi.push.n6;
import com.xiaomi.push.n7;
import com.xiaomi.push.r;
import com.xiaomi.push.v5;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class x {

    /* renamed from: d, reason: collision with root package name */
    public static String f50868d;

    /* renamed from: e, reason: collision with root package name */
    public static x f50869e = new x();

    /* renamed from: a, reason: collision with root package name */
    public List<a> f50870a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public g3 f50871b;

    /* renamed from: c, reason: collision with root package name */
    public r.b f50872c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class a {
        public void b(g3 g3Var) {
        }

        public void c(i3 i3Var) {
        }
    }

    public static synchronized String f() {
        String str;
        synchronized (x.class) {
            if (f50868d == null) {
                SharedPreferences sharedPreferences = n7.b().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f50868d = string;
                if (string == null) {
                    String i10 = n6.i(n7.b(), false);
                    f50868d = i10;
                    if (i10 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f50868d).commit();
                    }
                }
            }
            str = f50868d;
        }
        return str;
    }

    public static x h() {
        return f50869e;
    }

    public int a() {
        m();
        g3 g3Var = this.f50871b;
        if (g3Var != null) {
            return g3Var.u();
        }
        return 0;
    }

    public g3 c() {
        m();
        return this.f50871b;
    }

    public synchronized void i() {
        this.f50870a.clear();
    }

    public void j(i3 i3Var) {
        a[] aVarArr;
        if (i3Var.u() && i3Var.t() > a()) {
            n();
        }
        synchronized (this) {
            List<a> list = this.f50870a;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.c(i3Var);
        }
    }

    public synchronized void k(a aVar) {
        this.f50870a.add(aVar);
    }

    public final void m() {
        if (this.f50871b == null) {
            o();
        }
    }

    public final void n() {
        if (this.f50872c != null) {
            return;
        }
        y yVar = new y(this);
        this.f50872c = yVar;
        v5.a(yVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.push.n7.b()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            com.xiaomi.push.g0 r0 = com.xiaomi.push.g0.f(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            com.xiaomi.push.g3 r0 = com.xiaomi.push.g3.r(r0)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r4.f50871b = r0     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r2.close()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
        L1d:
            com.xiaomi.push.s7.b(r2)
            goto L43
        L21:
            r0 = move-exception
            goto L2a
        L23:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L50
        L27:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L2a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r1.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = "load config failure: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L4f
            r1.append(r0)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L4f
            fc.c.i(r0)     // Catch: java.lang.Throwable -> L4f
            goto L1d
        L43:
            com.xiaomi.push.g3 r0 = r4.f50871b
            if (r0 != 0) goto L4e
            com.xiaomi.push.g3 r0 = new com.xiaomi.push.g3
            r0.<init>()
            r4.f50871b = r0
        L4e:
            return
        L4f:
            r0 = move-exception
        L50:
            com.xiaomi.push.s7.b(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.x.o():void");
    }

    public final void p() {
        try {
            if (this.f50871b != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(n7.b().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c n10 = com.xiaomi.push.c.n(bufferedOutputStream);
                this.f50871b.e(n10);
                n10.q();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            fc.c.i("save config failure: " + e2.getMessage());
        }
    }
}
