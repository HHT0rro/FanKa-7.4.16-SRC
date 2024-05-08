package com.inno.innosdk.a;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.alibaba.security.realidentity.common.BuildConfig;
import com.huawei.quickcard.base.Attributes;
import com.inno.innosdk.bean.FyDeviceInfo;
import com.inno.innosdk.pb.InnoCustomController;
import com.inno.innosdk.pb.InnoMain;
import com.inno.innosdk.pb.Option;
import com.inno.innosdk.utils.AppInfomation;
import com.inno.innosdk.utils.NativeUtils;
import com.inno.innosdk.utils.NetworkConnectChangedReceiver;
import com.inno.innosdk.utils.j;
import com.inno.innosdk.utils.m;
import com.inno.innosdk.utils.o;
import com.inno.innosdk.utils.q;
import com.inno.innosdk.utils.r;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: InnoMainImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static Context f35473a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f35474b = false;

    /* renamed from: c, reason: collision with root package name */
    public static Hashtable<String, Object> f35475c = null;

    /* renamed from: d, reason: collision with root package name */
    public static FyDeviceInfo f35476d = null;

    /* renamed from: e, reason: collision with root package name */
    public static Option f35477e = null;

    /* renamed from: f, reason: collision with root package name */
    public static InnoMain.CallBack f35478f = null;

    /* renamed from: g, reason: collision with root package name */
    public static InnoCustomController f35479g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f35480h = "";

    /* renamed from: i, reason: collision with root package name */
    public static String f35481i = "";

    /* renamed from: j, reason: collision with root package name */
    public static String f35482j = "";

    /* renamed from: k, reason: collision with root package name */
    public static String f35483k = "";

    /* renamed from: l, reason: collision with root package name */
    public static String f35484l = "";

    /* renamed from: m, reason: collision with root package name */
    public static int f35485m;

    /* renamed from: n, reason: collision with root package name */
    public static long f35486n;

    /* renamed from: o, reason: collision with root package name */
    public static int f35487o;

    /* renamed from: p, reason: collision with root package name */
    public static volatile String f35488p;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f35489q;

    /* renamed from: r, reason: collision with root package name */
    public static Timer f35490r;

    /* renamed from: s, reason: collision with root package name */
    public static int f35491s;

    /* renamed from: t, reason: collision with root package name */
    public static Timer f35492t;

    /* compiled from: InnoMainImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f35493a;

        public a(Context context) {
            this.f35493a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a10 = com.inno.innosdk.b.b.a(this.f35493a);
            if (TextUtils.isEmpty(a10)) {
                return;
            }
            c.a(a10);
        }
    }

    /* compiled from: InnoMainImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f35494a;

        public b(Context context) {
            this.f35494a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f35494a;
            q.f35656a = context.getSharedPreferences(context.getPackageName(), 0);
            try {
                NativeUtils.c();
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
            try {
                c.g();
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
            try {
                j.a(this.f35494a);
            } catch (Throwable th2) {
                com.inno.innosdk.utils.u.a.a(th2);
            }
        }
    }

    /* compiled from: InnoMainImpl.java */
    /* renamed from: com.inno.innosdk.a.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class RunnableC0346c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f35495a;

        public RunnableC0346c(Context context) {
            this.f35495a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                NetworkConnectChangedReceiver.a(this.f35495a);
                com.inno.innosdk.utils.a aVar = new com.inno.innosdk.utils.a();
                ((Application) this.f35495a).registerActivityLifecycleCallbacks(aVar);
                aVar.d();
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
            c.z();
        }
    }

    /* compiled from: InnoMainImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class d implements Runnable {

        /* compiled from: InnoMainImpl.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                c.r();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.inno.innosdk.b.a.f();
                com.inno.innosdk.b.a.d(q.c("NetworkMessage"));
                if (c.f35476d == null) {
                    FyDeviceInfo unused = c.f35476d = new FyDeviceInfo();
                }
                c.f35476d.setCp(c.f35475c);
                c.f35476d.loadFyData(c.f35473a);
                com.inno.innosdk.b.b.b(c.m(), Attributes.LayoutDirection.AUTO);
                c.u();
                try {
                    if (c.f35490r != null) {
                        c.f35490r.cancel();
                        Timer unused2 = c.f35490r = null;
                        int unused3 = c.f35491s = 0;
                    }
                    Timer unused4 = c.f35490r = new Timer();
                    c.f35490r.schedule(new a(), 20000L, 20000L);
                } catch (Throwable th) {
                    com.inno.innosdk.utils.u.a.a(th);
                }
                NativeUtils.a(new byte[0]);
                NativeUtils.b(new byte[0]);
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
        }
    }

    /* compiled from: InnoMainImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class e extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            c.y();
        }
    }

    public static void g() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
                declaredField.setAccessible(true);
                declaredField.setBoolean(invoke, true);
            } catch (Throwable th2) {
                com.inno.innosdk.utils.u.a.a(th2);
            }
        }
    }

    public static String h() {
        return f35480h;
    }

    public static String i() {
        return f35484l;
    }

    public static String j() {
        return f35482j;
    }

    public static Context k() {
        return f35473a;
    }

    public static InnoCustomController l() {
        return f35479g;
    }

    public static FyDeviceInfo m() {
        Hashtable<String, Object> hashtable;
        FyDeviceInfo fyDeviceInfo = f35476d;
        if (fyDeviceInfo != null && (hashtable = f35475c) != null) {
            fyDeviceInfo.setCp(hashtable);
        }
        return f35476d;
    }

    public static int n() {
        return f35485m;
    }

    public static int o() {
        return f35487o;
    }

    public static Option p() {
        return f35477e;
    }

    public static String q() {
        return f35481i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        com.inno.innosdk.a.c.f35490r.cancel();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void r() {
        /*
            boolean r0 = com.inno.innosdk.a.c.f35474b
            if (r0 != 0) goto L5
            return
        L5:
            int r0 = com.inno.innosdk.a.c.f35491s     // Catch: java.lang.Throwable -> L29
            r1 = 1
            int r0 = r0 + r1
            com.inno.innosdk.a.c.f35491s = r0     // Catch: java.lang.Throwable -> L29
            android.content.Context r0 = k()     // Catch: java.lang.Throwable -> L29
            java.lang.String r0 = com.inno.innosdk.pb.InnoMain.checkInfo(r0)     // Catch: java.lang.Throwable -> L29
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L29
            if (r0 == 0) goto L21
            int r0 = com.inno.innosdk.a.c.f35491s     // Catch: java.lang.Throwable -> L29
            r2 = 20
            if (r0 <= r2) goto L20
            goto L21
        L20:
            r1 = 0
        L21:
            if (r1 == 0) goto L2d
            java.util.Timer r0 = com.inno.innosdk.a.c.f35490r     // Catch: java.lang.Throwable -> L29
            r0.cancel()     // Catch: java.lang.Throwable -> L29
            goto L2d
        L29:
            r0 = move-exception
            com.inno.innosdk.utils.u.a.a(r0)
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.a.c.r():void");
    }

    public static InnoMain.CallBack s() {
        return f35478f;
    }

    public static Map<String, Object> t() {
        return f35475c;
    }

    public static void u() {
        if (p().getReport() == 1) {
            try {
                Timer timer = f35492t;
                if (timer != null) {
                    timer.cancel();
                    f35492t = null;
                }
                Timer timer2 = new Timer();
                f35492t = timer2;
                timer2.schedule(new e(), p().getInterval() * 1000, p().getInterval() * 1000);
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }
    }

    public static void v() {
        Hashtable<String, Object> hashtable = f35475c;
        if (hashtable == null) {
            return;
        }
        hashtable.remove("action");
    }

    public static void w() {
        Option p10 = p();
        p10.setReport(1);
        a(p10);
        Timer timer = f35492t;
        if (timer != null) {
            timer.cancel();
        }
        f35492t = null;
        u();
    }

    public static void x() {
        Option p10 = p();
        p10.setReport(3);
        a(p10);
        Timer timer = f35492t;
        if (timer != null) {
            timer.cancel();
        }
        f35492t = null;
    }

    public static void y() {
    }

    public static void z() {
        if (f35474b) {
            f.f35500a.execute(new d());
        }
    }

    public static void b(String str) {
        TextUtils.isEmpty(str);
        if (f35474b) {
            com.inno.innosdk.b.b.a(m(), "upJsInfo");
        }
    }

    public static String c(Context context) {
        return o.a(context).f();
    }

    public static String d(Context context) {
        return o.a(context).h();
    }

    public static String e(Context context) {
        return AppInfomation.u();
    }

    public static synchronized String f(Context context) {
        synchronized (c.class) {
            if (!TextUtils.isEmpty(com.inno.innosdk.b.b.f35515n)) {
                return com.inno.innosdk.b.b.f35515n;
            }
            if (!TextUtils.isEmpty(f35488p)) {
                return f35488p;
            }
            HashMap hashMap = new HashMap(10);
            if (f35476d == null) {
                hashMap.put(InnoMain.INNO_KEY_ACCOUNT, f35480h);
                hashMap.put(InnoMain.INNO_KEY_PRODUCT, f35481i);
                hashMap.put("cid", f35482j);
                hashMap.put(InnoMain.INNO_KEY_OAID, f35483k);
                hashMap.put("ncuid", AppInfomation.v(context));
                hashMap.put("cuid", AppInfomation.s(context));
                hashMap.put("mac", AppInfomation.u());
                o a10 = o.a(context);
                hashMap.put("imsi", a10.h());
                hashMap.put("imei", a10.f());
                hashMap.put("aid", AppInfomation.a(context));
                hashMap.put("did", AppInfomation.k(context));
                hashMap.put("cv", BuildConfig.VERSION_NAME);
                hashMap.put(com.alipay.sdk.sys.a.f4670k, AppInfomation.e(context));
                hashMap.put("sdcid", AppInfomation.x());
            } else {
                hashMap.put(InnoMain.INNO_KEY_ACCOUNT, f35480h);
                hashMap.put(InnoMain.INNO_KEY_PRODUCT, f35481i);
                hashMap.put("cid", f35482j);
                hashMap.put(InnoMain.INNO_KEY_OAID, f35483k);
                hashMap.put("ncuid", f35476d.ncuid);
                hashMap.put("cuid", f35476d.cuid);
                hashMap.put("mac", f35476d.mac);
                hashMap.put("imsi", f35476d.imsi);
                hashMap.put("imei", f35476d.imei);
                hashMap.put("aid", f35476d.aid);
                hashMap.put("did", f35476d.did);
                hashMap.put("cv", f35476d.cv);
                hashMap.put(com.alipay.sdk.sys.a.f4670k, f35476d.av);
                hashMap.put("sdcid", f35476d.sdcid);
            }
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    if (sb2.length() > 0) {
                        sb2.append((char) 30);
                    }
                    sb2.append((String) entry.getKey());
                    sb2.append((char) 31);
                    sb2.append((String) entry.getValue());
                }
            }
            byte[] b4 = NativeUtils.b(sb2.toString());
            if (b4 != null && b4.length != 0) {
                f35488p = "agzf" + Base64.encodeToString(b4, 11);
                return f35488p;
            }
            return "";
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, Option option, InnoMain.CallBack callBack, InnoCustomController innoCustomController) {
        f35480h = str;
        f35481i = str2;
        f35484l = str4;
        a(context, str3, option, callBack, innoCustomController);
    }

    public static void b(Map<String, Object> map) {
        if (map.containsKey(InnoMain.INNO_KEY_ACCOUNT)) {
            f35480h = (String) map.get(InnoMain.INNO_KEY_ACCOUNT);
        }
        if (map.containsKey(InnoMain.INNO_KEY_PRODUCT)) {
            f35481i = (String) map.get(InnoMain.INNO_KEY_PRODUCT);
        }
        if (map.containsKey("cid")) {
            f35482j = (String) map.get("cid");
        }
        if (map.containsKey(InnoMain.INNO_KEY_OAID)) {
            f35483k = (String) map.get(InnoMain.INNO_KEY_OAID);
        }
        if (map.containsKey(InnoMain.INNO_KEY_CONTROLLER)) {
            f35479g = (InnoCustomController) map.get(InnoMain.INNO_KEY_CONTROLLER);
        }
    }

    public static void a(Context context, String str, Option option, InnoMain.CallBack callBack, InnoCustomController innoCustomController) {
        if (context == null || f35474b) {
            return;
        }
        if (context.getApplicationContext() == null) {
            f35473a = context;
        } else {
            f35473a = context.getApplicationContext();
        }
        f35478f = callBack;
        if (innoCustomController != null) {
            f35479g = innoCustomController;
        }
        f.f35500a.execute(new a(context));
        f35482j = str;
        f35474b = true;
        try {
            f35486n = System.currentTimeMillis();
            com.inno.innosdk.utils.u.a.a((Object) ("TIME start" + f35486n));
            try {
                f.f35500a.execute(new b(context));
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
            if (option == null) {
                try {
                    option = new Option();
                } catch (Exception e10) {
                    com.inno.innosdk.utils.u.a.a((Throwable) e10);
                }
            }
            f35489q = option.isbReportJSData();
            if (option.getInterval() < 60) {
                option.setInterval(60);
            }
            if (!option.isUpGyro() && !option.isUpTouch() && option.getReport() == 1) {
                option.setReport(3);
            }
            f35477e = option;
            f.f35500a.execute(new RunnableC0346c(context));
            f35485m = (int) (System.currentTimeMillis() - f35486n);
        } catch (Exception e11) {
            com.inno.innosdk.utils.u.a.a((Throwable) e11);
        }
    }

    public static List<PackageInfo> b(Context context) {
        return com.inno.innosdk.utils.c.a(context).i();
    }

    public static void a(String str) {
        if (s() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            s().getOpenid(str, 0, "");
            a((InnoMain.CallBack) null);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void a(Option option) {
        f35477e = option;
    }

    public static void a(String str, Object obj) {
        try {
            if (f35475c == null) {
                f35475c = new Hashtable<>();
            }
            f35475c.put(str, obj);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void a(Map<String, Object> map) {
        try {
            if (f35475c == null) {
                f35475c = new Hashtable<>();
            }
            boolean z10 = false;
            for (String str : map.h()) {
                Object obj = map.get(str);
                if (obj != null) {
                    if (str.equals(InnoMain.INNO_KEY_OAID)) {
                        f35483k = (String) obj;
                    }
                    if (f35475c.get(str) == null || !f35475c.get(str).toString().equals(obj)) {
                        f35475c.put(str, obj);
                        z10 = true;
                    }
                }
            }
            if (z10 && f35474b) {
                com.inno.innosdk.b.b.a(m(), "changeCp");
                if (TextUtils.equals(q.b(f35473a, "device_new", "0"), "1")) {
                    q.d(f35473a, "device_new", "0");
                    q.d(f35473a, "task_check_login", "1");
                    m.f35621g = 1;
                    m.b(k());
                }
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void a(InnoMain.CallBack callBack) {
        f35478f = callBack;
        if (callBack == null) {
            f35487o = (int) (System.currentTimeMillis() - f35486n);
            com.inno.innosdk.utils.u.a.a((Object) ("class load time = " + InnoMain.ct + "\nstart time = " + f35486n + "\ninit time = " + f35485m + "\ncall back time = " + f35487o));
        }
    }

    public static void a(List<MotionEvent> list, String str) {
        if (f35474b) {
            r.a(list, str);
        }
    }

    public static void a(boolean z10) {
        com.inno.innosdk.a.a.a(z10);
    }

    public static String a(Context context) {
        return AppInfomation.a(context);
    }
}
