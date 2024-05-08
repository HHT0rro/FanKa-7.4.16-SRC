package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.xiaomi.push.b2;
import com.xiaomi.push.g7;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.hv;
import com.xiaomi.push.i4;
import com.xiaomi.push.ia;
import com.xiaomi.push.id;
import com.xiaomi.push.im;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.iw;
import com.xiaomi.push.jb;
import com.xiaomi.push.o6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class h0 {

    /* renamed from: j, reason: collision with root package name */
    public static h0 f47006j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f47007k;

    /* renamed from: l, reason: collision with root package name */
    public static final ArrayList<a> f47008l = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    public boolean f47009a;

    /* renamed from: b, reason: collision with root package name */
    public Context f47010b;

    /* renamed from: d, reason: collision with root package name */
    public Messenger f47012d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f47013e;

    /* renamed from: f, reason: collision with root package name */
    public List<Message> f47014f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public boolean f47015g = false;

    /* renamed from: h, reason: collision with root package name */
    public Intent f47016h = null;

    /* renamed from: i, reason: collision with root package name */
    public Integer f47017i = null;

    /* renamed from: c, reason: collision with root package name */
    public String f47011c = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a<T extends jb<T, ?>> {

        /* renamed from: a, reason: collision with root package name */
        public T f47018a;

        /* renamed from: b, reason: collision with root package name */
        public hq f47019b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f47020c;
    }

    public h0(Context context) {
        this.f47009a = false;
        this.f47013e = null;
        this.f47010b = context.getApplicationContext();
        this.f47009a = P();
        f47007k = T();
        this.f47013e = new i0(this, Looper.getMainLooper());
        Intent H = H();
        if (H != null) {
            J(H);
        }
    }

    public static synchronized h0 g(Context context) {
        h0 h0Var;
        synchronized (h0.class) {
            if (f47006j == null) {
                f47006j = new h0(context);
            }
            h0Var = f47006j;
        }
        return h0Var;
    }

    public final void A(String str, av avVar, boolean z10, HashMap<String, String> hashMap) {
        ip ipVar;
        String str2;
        if (o0.c(this.f47010b).p() && com.xiaomi.push.j0.p(this.f47010b)) {
            ip ipVar2 = new ip();
            ipVar2.a(true);
            Intent c4 = c();
            if (TextUtils.isEmpty(str)) {
                str = kc.m.a();
                ipVar2.a(str);
                ipVar = z10 ? new ip(str, true) : null;
                synchronized (z.class) {
                    z.b(this.f47010b).e(str);
                }
            } else {
                ipVar2.a(str);
                ipVar = z10 ? new ip(str, true) : null;
            }
            switch (l0.f47029a[avVar.ordinal()]) {
                case 1:
                    ia iaVar = ia.DisablePushMessage;
                    ipVar2.c(iaVar.f329a);
                    ipVar.c(iaVar.f329a);
                    if (hashMap != null) {
                        ipVar2.a(hashMap);
                        ipVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    c4.setAction(str2);
                    break;
                case 2:
                    ia iaVar2 = ia.EnablePushMessage;
                    ipVar2.c(iaVar2.f329a);
                    ipVar.c(iaVar2.f329a);
                    if (hashMap != null) {
                        ipVar2.a(hashMap);
                        ipVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    c4.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ipVar2.c(ia.ThirdPartyRegUpdate.f329a);
                    if (hashMap != null) {
                        ipVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            ipVar2.b(o0.c(this.f47010b).d());
            ipVar2.d(this.f47010b.getPackageName());
            hq hqVar = hq.Notification;
            v(ipVar2, hqVar, false, null);
            if (z10) {
                ipVar.b(o0.c(this.f47010b).d());
                ipVar.d(this.f47010b.getPackageName());
                Context context = this.f47010b;
                byte[] c10 = o6.c(a0.b(context, ipVar, hqVar, false, context.getPackageName(), o0.c(this.f47010b).d()));
                if (c10 != null) {
                    b2.f(this.f47010b.getPackageName(), this.f47010b, ipVar, hqVar, c10.length);
                    c4.putExtra("mipush_payload", c10);
                    c4.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    c4.putExtra("mipush_app_id", o0.c(this.f47010b).d());
                    c4.putExtra("mipush_app_token", o0.c(this.f47010b).m());
                    O(c4);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = avVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f47013e.sendMessageDelayed(obtain, 5000L);
        }
    }

    public void B(String str, String str2) {
        Intent c4 = c();
        c4.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        c4.putExtra(kc.n.f50841w, this.f47010b.getPackageName());
        c4.putExtra(kc.n.B, str);
        c4.putExtra(kc.n.C, str2);
        O(c4);
    }

    public final void C(boolean z10) {
        D(z10, null);
    }

    public final void D(boolean z10, String str) {
        av avVar;
        z b4;
        av avVar2;
        if (z10) {
            z b10 = z.b(this.f47010b);
            avVar = av.DISABLE_PUSH;
            b10.d(avVar, "syncing");
            b4 = z.b(this.f47010b);
            avVar2 = av.ENABLE_PUSH;
        } else {
            z b11 = z.b(this.f47010b);
            avVar = av.ENABLE_PUSH;
            b11.d(avVar, "syncing");
            b4 = z.b(this.f47010b);
            avVar2 = av.DISABLE_PUSH;
        }
        b4.d(avVar2, "");
        A(str, avVar, true, null);
    }

    public boolean E() {
        return this.f47009a && 1 == o0.c(this.f47010b).a();
    }

    public boolean F(int i10) {
        if (!o0.c(this.f47010b).p()) {
            return false;
        }
        N(i10);
        ip ipVar = new ip();
        ipVar.a(kc.m.a());
        ipVar.b(o0.c(this.f47010b).d());
        ipVar.d(this.f47010b.getPackageName());
        ipVar.c(ia.ClientABTest.f329a);
        HashMap hashMap = new HashMap();
        ipVar.f468a = hashMap;
        hashMap.put("boot_mode", i10 + "");
        g(this.f47010b).v(ipVar, hq.Notification, false, null);
        return true;
    }

    public final Intent H() {
        if (!"com.xiaomi.xmsf".equals(this.f47010b.getPackageName())) {
            return L();
        }
        fc.c.m("pushChannel xmsf create own channel");
        return U();
    }

    public final void I() {
        Intent c4 = c();
        c4.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        O(c4);
    }

    public final void J(Intent intent) {
        try {
            if (g7.f() || Build.VERSION.SDK_INT < 26) {
                this.f47010b.startService(intent);
            } else {
                S(intent);
            }
        } catch (Exception e2) {
            fc.c.k(e2);
        }
    }

    public boolean K() {
        if (!E() || !W()) {
            return true;
        }
        if (this.f47017i == null) {
            Integer valueOf = Integer.valueOf(kc.q.c(this.f47010b).a());
            this.f47017i = valueOf;
            if (valueOf.intValue() == 0) {
                this.f47010b.getContentResolver().registerContentObserver(kc.q.c(this.f47010b).b(), false, new j0(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f47017i.intValue() != 0;
    }

    public final Intent L() {
        if (E()) {
            fc.c.m("pushChannel app start miui china channel");
            return Q();
        }
        fc.c.m("pushChannel app start  own channel");
        return U();
    }

    public void M() {
        Intent intent = this.f47016h;
        if (intent != null) {
            O(intent);
            this.f47016h = null;
        }
    }

    public final synchronized void N(int i10) {
        this.f47010b.getSharedPreferences("mipush_extra", 0).edit().putInt("service_boot_mode", i10).commit();
    }

    public final void O(Intent intent) {
        kc.j d10 = kc.j.d(this.f47010b);
        int a10 = hv.ServiceBootMode.a();
        hr hrVar = hr.START;
        int a11 = d10.a(a10, hrVar.a());
        int a12 = a();
        hr hrVar2 = hr.BIND;
        boolean z10 = a11 == hrVar2.a() && f47007k;
        int a13 = z10 ? hrVar2.a() : hrVar.a();
        if (a13 != a12) {
            F(a13);
        }
        if (z10) {
            S(intent);
        } else {
            J(intent);
        }
    }

    public final boolean P() {
        try {
            PackageInfo packageInfo = this.f47010b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final Intent Q() {
        Intent intent = new Intent();
        String packageName = this.f47010b.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", j());
        intent.putExtra("mipush_app_package", packageName);
        X();
        return intent;
    }

    public void R() {
        ArrayList<a> arrayList = f47008l;
        synchronized (arrayList) {
            Iterator<a> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                a next = iterator2.next();
                x(next.f47018a, next.f47019b, next.f47020c, false, null, true);
            }
            f47008l.clear();
        }
    }

    public final synchronized void S(Intent intent) {
        if (this.f47015g) {
            Message d10 = d(intent);
            if (this.f47014f.size() >= 50) {
                this.f47014f.remove(0);
            }
            this.f47014f.add(d10);
            return;
        }
        if (this.f47012d == null) {
            this.f47010b.bindService(intent, new k0(this), 1);
            this.f47015g = true;
            this.f47014f.clear();
            this.f47014f.add(d(intent));
        } else {
            try {
                this.f47012d.send(d(intent));
            } catch (RemoteException unused) {
                this.f47012d = null;
                this.f47015g = false;
            }
        }
    }

    public final boolean T() {
        if (E()) {
            try {
                return this.f47010b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public final Intent U() {
        Intent intent = new Intent();
        String packageName = this.f47010b.getPackageName();
        Y();
        intent.setComponent(new ComponentName(this.f47010b, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    public void V() {
        Intent c4 = c();
        c4.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        c4.putExtra(kc.n.f50841w, this.f47010b.getPackageName());
        c4.putExtra(kc.n.A, com.xiaomi.push.o0.c(this.f47010b.getPackageName()));
        O(c4);
    }

    public final boolean W() {
        String packageName = this.f47010b.getPackageName();
        return packageName.contains("miui") || packageName.contains(ADEvent.XIAOMI) || (this.f47010b.getApplicationInfo().flags & 1) != 0;
    }

    public final void X() {
        try {
            PackageManager packageManager = this.f47010b.getPackageManager();
            ComponentName componentName = new ComponentName(this.f47010b, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    public final void Y() {
        try {
            PackageManager packageManager = this.f47010b.getPackageManager();
            ComponentName componentName = new ComponentName(this.f47010b, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    public final synchronized int a() {
        return this.f47010b.getSharedPreferences("mipush_extra", 0).getInt("service_boot_mode", -1);
    }

    public final Intent c() {
        return (!E() || "com.xiaomi.xmsf".equals(this.f47010b.getPackageName())) ? U() : Q();
    }

    public final Message d(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public final String j() {
        try {
            return this.f47010b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    public void l() {
        J(c());
    }

    public void m(int i10) {
        Intent c4 = c();
        c4.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        c4.putExtra(kc.n.f50841w, this.f47010b.getPackageName());
        c4.putExtra(kc.n.f50842x, i10);
        O(c4);
    }

    public void n(int i10, String str) {
        Intent c4 = c();
        c4.setAction("com.xiaomi.mipush.thirdparty");
        c4.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i10);
        c4.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        J(c4);
    }

    public void o(Intent intent) {
        intent.fillIn(c(), 24);
        O(intent);
    }

    public final void q(hu huVar) {
        Intent c4 = c();
        byte[] c10 = o6.c(huVar);
        if (c10 == null) {
            fc.c.i("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        c4.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        c4.putExtra("mipush_payload", c10);
        J(c4);
    }

    public final void r(iq iqVar, boolean z10) {
        i4.a(this.f47010b.getApplicationContext()).g(this.f47010b.getPackageName(), "E100003", iqVar.a(), 6001, null);
        this.f47016h = null;
        o0.c(this.f47010b).f47054d = iqVar.a();
        Intent c4 = c();
        byte[] c10 = o6.c(a0.a(this.f47010b, iqVar, hq.Registration));
        if (c10 == null) {
            fc.c.i("register fail, because msgBytes is null.");
            return;
        }
        c4.setAction("com.xiaomi.mipush.REGISTER_APP");
        c4.putExtra("mipush_app_id", o0.c(this.f47010b).d());
        c4.putExtra("mipush_payload", c10);
        c4.putExtra("mipush_session", this.f47011c);
        c4.putExtra("mipush_env_chanage", z10);
        c4.putExtra("mipush_env_type", o0.c(this.f47010b).a());
        if (com.xiaomi.push.j0.p(this.f47010b) && K()) {
            O(c4);
        } else {
            this.f47016h = c4;
        }
    }

    public final void s(iw iwVar) {
        byte[] c4 = o6.c(a0.a(this.f47010b, iwVar, hq.UnRegistration));
        if (c4 == null) {
            fc.c.i("unregister fail, because msgBytes is null.");
            return;
        }
        Intent c10 = c();
        c10.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        c10.putExtra("mipush_app_id", o0.c(this.f47010b).d());
        c10.putExtra("mipush_payload", c4);
        O(c10);
    }

    public final <T extends jb<T, ?>> void t(T t2, hq hqVar, id idVar) {
        v(t2, hqVar, !hqVar.equals(hq.Registration), idVar);
    }

    public <T extends jb<T, ?>> void u(T t2, hq hqVar, boolean z10) {
        a aVar = new a();
        aVar.f47018a = t2;
        aVar.f47019b = hqVar;
        aVar.f47020c = z10;
        ArrayList<a> arrayList = f47008l;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public final <T extends jb<T, ?>> void v(T t2, hq hqVar, boolean z10, id idVar) {
        x(t2, hqVar, z10, true, idVar, true);
    }

    public final <T extends jb<T, ?>> void w(T t2, hq hqVar, boolean z10, id idVar, boolean z11) {
        x(t2, hqVar, z10, true, idVar, z11);
    }

    public final <T extends jb<T, ?>> void x(T t2, hq hqVar, boolean z10, boolean z11, id idVar, boolean z12) {
        y(t2, hqVar, z10, z11, idVar, z12, this.f47010b.getPackageName(), o0.c(this.f47010b).d());
    }

    public final <T extends jb<T, ?>> void y(T t2, hq hqVar, boolean z10, boolean z11, id idVar, boolean z12, String str, String str2) {
        if (!o0.c(this.f47010b).s()) {
            if (z11) {
                u(t2, hqVar, z10);
                return;
            } else {
                fc.c.i("drop the message before initialization.");
                return;
            }
        }
        im b4 = a0.b(this.f47010b, t2, hqVar, z10, str, str2);
        if (idVar != null) {
            b4.a(idVar);
        }
        byte[] c4 = o6.c(b4);
        if (c4 == null) {
            fc.c.i("send message fail, because msgBytes is null.");
            return;
        }
        b2.f(this.f47010b.getPackageName(), this.f47010b, t2, hqVar, c4.length);
        Intent c10 = c();
        c10.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        c10.putExtra("mipush_payload", c4);
        c10.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z12);
        O(c10);
    }

    public final void z(String str, av avVar, d dVar) {
        z.b(this.f47010b).d(avVar, "syncing");
        A(str, avVar, false, t0.c(this.f47010b, dVar));
    }
}
