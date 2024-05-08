package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class by {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9978a = "ApkLoader";

    /* renamed from: b, reason: collision with root package name */
    public static Thread.UncaughtExceptionHandler f9979b = null;

    /* renamed from: c, reason: collision with root package name */
    public static final String f9980c = "__badApkVersion__9.332";

    /* renamed from: d, reason: collision with root package name */
    public static final String f9981d = "previousProxyVersion";

    /* renamed from: e, reason: collision with root package name */
    public static final String f9982e = "__xadsdk__remote__final__";

    /* renamed from: f, reason: collision with root package name */
    public static final String f9983f = "bdxadsdk.jar";

    /* renamed from: g, reason: collision with root package name */
    public static final String f9984g = "__xadsdk__remote__final__builtin__.jar";

    /* renamed from: h, reason: collision with root package name */
    public static final String f9985h = "__xadsdk__remote__final__builtinversion__.jar";

    /* renamed from: i, reason: collision with root package name */
    public static final String f9986i = "__xadsdk__remote__final__downloaded__.jar";

    /* renamed from: j, reason: collision with root package name */
    public static final String f9987j = "__xadsdk__remote__final__running__.jar";

    /* renamed from: k, reason: collision with root package name */
    public static final String f9988k = "OK";

    /* renamed from: l, reason: collision with root package name */
    public static final String f9989l = "ERROR";

    /* renamed from: m, reason: collision with root package name */
    public static final String f9990m = "APK_INFO";

    /* renamed from: n, reason: collision with root package name */
    public static final String f9991n = "CODE";

    /* renamed from: o, reason: collision with root package name */
    public static final String f9992o = "success";

    /* renamed from: p, reason: collision with root package name */
    public static volatile bn f9993p = null;

    /* renamed from: q, reason: collision with root package name */
    public static volatile bn f9994q = null;

    /* renamed from: r, reason: collision with root package name */
    public static volatile Class f9995r = null;

    /* renamed from: s, reason: collision with root package name */
    public static String f9996s = null;

    /* renamed from: t, reason: collision with root package name */
    public static final Handler f9997t = new bz(Looper.getMainLooper());

    /* renamed from: x, reason: collision with root package name */
    private static final String f9998x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;

    /* renamed from: u, reason: collision with root package name */
    public Handler f9999u;

    /* renamed from: v, reason: collision with root package name */
    public final Handler f10000v;

    /* renamed from: w, reason: collision with root package name */
    private bw f10001w;

    /* renamed from: y, reason: collision with root package name */
    private final Context f10002y;

    /* renamed from: z, reason: collision with root package name */
    private bs f10003z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends Exception {

        /* renamed from: a, reason: collision with root package name */
        private static final long f10004a = 2978543166232984104L;

        public a(String str) {
            bs.a().c(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends Exception {

        /* renamed from: a, reason: collision with root package name */
        private static final long f10005a = -7838296421993681751L;

        public b(String str) {
            bs.a().c(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface c {
        void a(boolean z10);
    }

    public by(Activity activity) {
        this(activity.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            File[] listFiles = this.f10002y.getFilesDir().listFiles();
            int i10 = 0;
            while (listFiles != null) {
                if (i10 >= listFiles.length) {
                    return;
                }
                if (listFiles[i10].getAbsolutePath().contains(f9982e) && listFiles[i10].getAbsolutePath().endsWith("dex")) {
                    listFiles[i10].delete();
                }
                i10++;
            }
        } catch (Exception e2) {
            bs.a().c(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        return this.f10002y.getSharedPreferences(x.aM, 0);
    }

    private boolean n() {
        String string = m().getString(f9981d, null);
        return string == null || !string.equals(a());
    }

    private boolean o() {
        try {
            if (!bq.a(c())) {
                if (!bq.a(f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            this.f10003z.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        br brVar = new br(f(), this.f10002y);
        if (!bq.a(brVar)) {
            return false;
        }
        try {
            if (!n()) {
                synchronized (this) {
                    this.f10003z.a(f9978a, "loadDownloadedOrBuiltInApk len=" + brVar.length() + ", path=" + brVar.getAbsolutePath());
                    b(brVar);
                    double d10 = (double) m().getFloat(f9980c, -1.0f);
                    this.f10003z.a(f9978a, "downloadedApkFile.getApkVersion(): " + brVar.c() + ", badApkVersion: " + d10);
                    if (brVar.c() != d10) {
                        this.f10003z.a(f9978a, "loaded: " + brVar.getPath());
                    } else {
                        throw new a("downloaded file marked bad, drop it and use built-in");
                    }
                }
                return true;
            }
            throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
        } catch (a e2) {
            this.f10003z.a(f9978a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
            if (brVar.exists()) {
                brVar.delete();
            }
            k();
            return false;
        }
    }

    public final String a() {
        return "9.332";
    }

    public int h() {
        return this.f10002y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public IXAdContainerFactory i() {
        return a(f9993p);
    }

    public IXAdContainerFactory j() {
        return a(f9994q);
    }

    public void k() {
        if (f9993p != null) {
            f9993p.b();
            f9993p = null;
        }
    }

    public by(Context context) {
        this.f10003z = bs.a();
        this.A = false;
        this.f9999u = f9997t;
        this.B = new CopyOnWriteArrayList<>();
        this.f10000v = new ca(this, Looper.getMainLooper());
        this.f10002y = context;
        c(context);
        if (f9979b == null) {
            f9979b = cm.a(context);
            cm.a(context).a(new cb(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cm) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(f9979b);
    }

    public static String f() {
        if (TextUtils.isEmpty(f9996s)) {
            return "";
        }
        return f9996s + f9986i;
    }

    public void e() {
        this.f10003z.a(f9978a, "start load assets file");
        d(this.f10002y);
        String c4 = c();
        br brVar = new br(c4, this.f10002y);
        if (bq.a(brVar)) {
            this.f10003z.a(f9978a, "assets file can read ,will use it ");
            if (c(brVar)) {
                b(true);
                return;
            }
            return;
        }
        throw new b("loadBuiltInApk failed: " + c4);
    }

    public void g() {
        if (h() != 2 ? p() : false) {
            this.f10003z.a(f9978a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.f10003z.a(f9978a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            this.f10003z.a(f9978a, "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(f9996s)) {
            f9996s = context.getDir(f9998x, 0).getAbsolutePath() + "/";
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f9996s)) {
            return "";
        }
        return f9996s + f9985h;
    }

    public void b() {
        new File(f()).delete();
    }

    private static synchronized void d(Context context) {
        synchronized (by.class) {
            try {
                String c4 = c();
                double b4 = b(c4);
                bs.a().a(f9978a, "copy assets,compare version=" + ((Object) Double.valueOf("9.332")) + "remote=" + b4);
                if (Double.valueOf("9.332").doubleValue() != b4) {
                    br brVar = new br(c4, context);
                    if (brVar.exists()) {
                        brVar.delete();
                    }
                    bq.a(context, f9983f, c4);
                }
            } catch (Exception e2) {
                throw new b("loadBuiltInApk failed: " + e2.toString());
            }
        }
    }

    private void b(br brVar) {
        this.f10003z.a(f9978a, "len=" + brVar.length() + ", path=" + brVar.getAbsolutePath());
        if (f9993p == null) {
            String a10 = a(this.f10002y);
            br brVar2 = new br(a10, this.f10002y);
            if (brVar2.exists()) {
                brVar2.delete();
            }
            try {
                bq.a(new FileInputStream(brVar), a10);
            } catch (Exception e2) {
                this.f10003z.c(e2);
            }
            f9993p = new bn(brVar2.b(), this.f10002y);
            try {
                IXAdContainerFactory a11 = f9993p.a();
                this.f10003z.a(f9978a, "preloaded apk.version=" + a11.getRemoteVersion());
                return;
            } catch (a e10) {
                this.f10003z.a(f9978a, "preload local apk " + brVar.getAbsolutePath() + " failed, msg:" + e10.getMessage() + ", v=" + f9993p.f9916b);
                a(e10.getMessage());
                throw e10;
            }
        }
        this.f10003z.a(f9978a, "mApkBuilder already initialized, version: " + f9993p.f9916b);
    }

    public static String c() {
        if (TextUtils.isEmpty(f9996s)) {
            return "";
        }
        return f9996s + f9984g;
    }

    public void a(String str) {
        if (f9993p != null) {
            SharedPreferences.Editor edit = m().edit();
            edit.putFloat(f9980c, (float) f9993p.f9916b);
            edit.apply();
        }
    }

    private boolean c(br brVar) {
        synchronized (this) {
            b(brVar);
            this.f10003z.a(f9978a, "loaded: " + brVar.getPath());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10) {
        Message obtainMessage = this.f9999u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z10);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.f9999u.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z10) {
        double d10;
        if (z10) {
            try {
                d10 = f9993p.f9916b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d10 = ShadowDrawableWrapper.COS_45;
        }
        ao.a(d10, new ce(this, d10), new cf(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(br brVar) {
        Class<?> b4 = brVar.b();
        synchronized (this) {
            f9994q = new bn(b4, this.f10002y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z10, String str) {
        try {
            cm.a(this.f10002y).c();
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i10 = 0; i10 < this.B.size(); i10++) {
                    c cVar = this.B.get(i10);
                    if (cVar != null) {
                        cVar.a(z10);
                    }
                }
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z10) {
        if (!z10 && !o()) {
            this.A = true;
        } else {
            a(z10, z10 ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.A) {
            bb.a().a((i) new cc(this, z10));
        } else {
            bb.a().a(new cd(this, z10), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.f9999u = handler;
        if (f9993p == null) {
            g();
        } else {
            b(true);
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f9996s)) {
            f9996s = context.getDir(f9998x, 0).getAbsolutePath() + "/";
        }
        if (TextUtils.isEmpty(f9996s)) {
            return "";
        }
        return f9996s + f9987j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bw bwVar) {
        if (bwVar.a().booleanValue()) {
            bu a10 = bu.a(this.f10002y, bwVar, f9996s, this.f10000v);
            if (!a10.isAlive()) {
                this.f10003z.a(f9978a, "XApkDownloadThread starting ...");
                a10.start();
            } else {
                this.f10003z.a(f9978a, "XApkDownloadThread already started");
                a10.a(bwVar.c());
            }
        }
    }

    public static double b(Context context) {
        try {
            c(context);
            double b4 = b(f());
            String d10 = d();
            if (Double.valueOf("9.332").doubleValue() > b(d10)) {
                br brVar = new br(d10, context);
                if (brVar.exists()) {
                    brVar.delete();
                }
                bq.a(context, f9983f, d10);
            }
            return Math.max(b4, b(d()));
        } catch (Exception unused) {
            return ShadowDrawableWrapper.COS_45;
        }
    }

    public void a(c cVar, Handler handler) {
        bb.a().a((i) new cg(this, cVar, handler));
    }

    public void a(c cVar) {
        a(cVar, f9997t);
    }

    private IXAdContainerFactory a(bn bnVar) {
        if (bnVar == null) {
            return null;
        }
        try {
            return bnVar.a();
        } catch (Exception unused) {
            return null;
        }
    }

    public static double b(String str) {
        JarFile jarFile = null;
        try {
            try {
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cl.f10052d.booleanValue()) {
            File file = new File(str);
            if (bq.a(file)) {
                JarFile jarFile2 = new JarFile(file);
                try {
                    double parseDouble = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                    if (parseDouble > ShadowDrawableWrapper.COS_45) {
                        try {
                            jarFile2.close();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                        return parseDouble;
                    }
                    jarFile = jarFile2;
                } catch (Exception unused2) {
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    return ShadowDrawableWrapper.COS_45;
                } catch (Throwable th2) {
                    th = th2;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (jarFile != null) {
                jarFile.close();
            }
            return ShadowDrawableWrapper.COS_45;
        }
        return Double.valueOf("9.332").doubleValue();
    }
}
