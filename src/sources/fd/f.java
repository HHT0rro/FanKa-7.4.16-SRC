package fd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.hailiang.advlib.core.ADEvent;
import com.hailiang.advlib.core.QMConfig;
import com.huawei.openalliance.ad.constant.bg;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: UpdateManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f49301a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f49302b;

    /* renamed from: c, reason: collision with root package name */
    public static String f49303c;

    /* renamed from: d, reason: collision with root package name */
    public static String f49304d;

    /* renamed from: e, reason: collision with root package name */
    public static String f49305e;

    /* renamed from: f, reason: collision with root package name */
    public static String f49306f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile b f49307g;

    /* renamed from: h, reason: collision with root package name */
    public static final char[] f49308h;

    /* renamed from: i, reason: collision with root package name */
    public static AtomicInteger f49309i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f49310j;

    /* renamed from: k, reason: collision with root package name */
    public static long f49311k;

    /* renamed from: l, reason: collision with root package name */
    public static long f49312l;

    /* renamed from: m, reason: collision with root package name */
    public static Context f49313m;

    /* renamed from: n, reason: collision with root package name */
    public static String f49314n;

    /* renamed from: o, reason: collision with root package name */
    public static List<d> f49315o;

    /* renamed from: p, reason: collision with root package name */
    public static String f49316p;

    /* renamed from: q, reason: collision with root package name */
    public static String f49317q;

    /* renamed from: r, reason: collision with root package name */
    public static String f49318r;

    /* renamed from: s, reason: collision with root package name */
    public static int f49319s;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f49320t;

    /* renamed from: u, reason: collision with root package name */
    public static c f49321u;

    /* renamed from: v, reason: collision with root package name */
    public static int f49322v;

    /* compiled from: UpdateManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f49323b;

        public a(JSONObject jSONObject) {
            this.f49323b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.e(this.f49323b);
        }
    }

    static {
        String str = Build.VERSION.RELEASE;
        f49301a = str.contains(Constants.VIA_REPORT_TYPE_SET_AVATAR) ? "_hailiang_localjar" : "_hailiang_local.jar";
        f49302b = str.contains(Constants.VIA_REPORT_TYPE_SET_AVATAR) ? "_hailiang_remotejar" : "_hailiang_remote.jar";
        f49303c = "https://update0.qquanquan.com/qm/nsdk/cgi/";
        f49304d = null;
        f49305e = null;
        f49306f = null;
        f49307g = null;
        f49308h = new char[0];
        f49309i = new AtomicInteger(0);
        f49310j = false;
        f49311k = 0L;
        f49312l = 0L;
        f49315o = new CopyOnWriteArrayList();
        f49322v = 0;
    }

    public static Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("expectedSdkVersion", f49318r);
        bundle.putString(bg.e.Code, f49321u.b());
        return bundle;
    }

    public static void b(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            context.getSharedPreferences("hailiang_loadremote_config", 0).edit().putString("aisdk_lib_version", str).commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:5|(2:31|(5:36|11|12|13|(2:15|16)(1:17))(1:35))(1:9)|10|11|12|13|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0089, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        r1.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0091, code lost:
    
        if (r0.exists() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
    
        r0.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0096, code lost:
    
        n();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
    
        d(fd.f.f49304d);
        fd.f.f49319s = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a0, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(com.hailiang.advlib.core.QMConfig r11) {
        /*
            android.content.Context r0 = fd.f.f49313m
            boolean r0 = o(r0)
            if (r0 != 0) goto L9
            return
        L9:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = fd.f.f49306f
            r1.append(r2)
            java.lang.String r2 = "/"
            r1.append(r2)
            java.lang.String r3 = fd.f.f49302b
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            android.content.Context r1 = fd.f.f49313m
            int[] r1 = k(r1)
            r4 = 0
            fd.f.f49311k = r4
            long r6 = r0.length()
            r8 = 0
            r9 = 1
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 <= 0) goto L47
            r6 = r1[r9]
            if (r6 != r9) goto L47
            fd.f.f49304d = r3
            java.lang.String r1 = fd.f.f49317q
            fd.f.f49318r = r1
            fd.f.f49320t = r9
            goto L76
        L47:
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = fd.f.f49306f
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = fd.f.f49301a
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            r3.<init>(r6)
            long r6 = r3.length()
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L78
            r1 = r1[r8]
            if (r1 != r9) goto L78
            fd.f.f49304d = r2
            java.lang.String r1 = fd.f.f49316p
            fd.f.f49318r = r1
            fd.f.f49320t = r8
        L76:
            r1 = 0
            goto L7c
        L78:
            n()
            r1 = 1
        L7c:
            java.lang.String r2 = fd.f.f49304d     // Catch: java.lang.Throwable -> L84 java.lang.ClassNotFoundException -> L89
            d(r2)     // Catch: java.lang.Throwable -> L84 java.lang.ClassNotFoundException -> L89
            fd.f.f49319s = r8     // Catch: java.lang.Throwable -> L84 java.lang.ClassNotFoundException -> L89
            goto La1
        L84:
            r0 = move-exception
            r0.printStackTrace()
            goto La1
        L89:
            r1 = move-exception
            r1.printStackTrace()
            boolean r1 = r0.exists()
            if (r1 == 0) goto L96
            r0.delete()
        L96:
            n()
            java.lang.String r0 = fd.f.f49304d     // Catch: java.lang.Exception -> La0
            d(r0)     // Catch: java.lang.Exception -> La0
            fd.f.f49319s = r9     // Catch: java.lang.Exception -> La0
        La0:
            r1 = 1
        La1:
            fd.f.f49310j = r9
            p()
            f(r1, r8)
            android.content.Context r0 = fd.f.f49313m
            boolean r0 = m(r0)
            if (r0 == 0) goto Lb8
            fd.e r0 = fd.e.a()
            r0.h(r11)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fd.f.c(com.hailiang.advlib.core.QMConfig):void");
    }

    public static void d(String str) throws ClassNotFoundException {
        f49307g = null;
        f49307g = new b(f49306f + "/" + str, f49305e, null, f.class.getClassLoader());
        f49307g.a(f49321u.e());
    }

    public static void e(JSONObject jSONObject) {
        if (!l() && f49322v <= 2) {
            try {
                if (f49306f == null || f49305e == null) {
                    o(f49313m);
                }
                new b(f49306f + "/" + f49302b, f49305e, null, f.class.getClassLoader());
                f49322v = 0;
                if (jSONObject.has("version")) {
                    b(f49313m, jSONObject.getString("version"));
                }
            } catch (Throwable unused) {
                f49322v++;
                com.hailiang.advlib.common.d.a(new a(jSONObject), 5000L);
            }
        }
    }

    public static void f(boolean z10, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("opt_isRemote", (f49320t ? 1 : 0) + "");
        hashMap.put("opt_local_version", f49316p);
        hashMap.put("opt_remote_version", f49317q);
        hashMap.put("opt_is_update", "1");
        hashMap.put("opt_channel", ADEvent.HAILIANG);
        hashMap.put("opt_is_androidx", String.valueOf(com.hailiang.advlib.common.e.a()));
        hashMap.put("opt_new_inside_version", "12.426");
        hashMap.put("opt_load_version", f49318r);
        hashMap.put("opt_time", System.currentTimeMillis() + "");
        hashMap.put("opt_location", String.valueOf(f49319s));
        if (j()) {
            com.hailiang.advlib.common.d.a(f49313m, f49304d.equals(f49302b), z10, z11, f49312l, f49311k, hashMap);
        } else {
            com.hailiang.advlib.common.d.a(f49313m, f49304d.equals(f49302b), z10, z11, "unknow", f49311k, hashMap);
            f49309i.decrementAndGet();
        }
    }

    public static boolean g(QMConfig qMConfig, @NonNull c cVar) {
        f49314n = qMConfig.getVersionName();
        f49321u = cVar;
        if (f49309i.getAndIncrement() > 0) {
            return false;
        }
        Context context = qMConfig.getContext();
        f49313m = context;
        com.hailiang.advlib.common.d.a(context);
        f49312l = System.currentTimeMillis();
        c(qMConfig);
        return false;
    }

    public static boolean h(String str, String str2) {
        try {
            return str.compareTo(str2) >= 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String i(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("hailiang_loadremote_config", 0);
            String string = sharedPreferences.getString("ruid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String uuid = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("ruid", uuid).apply();
            return uuid;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean j() {
        return f49307g != null && f49307g.b();
    }

    public static int[] k(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("hailiang_loadremote_config", 0);
            f49316p = sharedPreferences.getString("aisdk_lib_local", "1.0");
            f49317q = sharedPreferences.getString("aisdk_lib_version", "1.0");
            return new int[]{h(f49316p, "3.460") ? 1 : 0, h(f49317q, "3.460") ? 1 : 0};
        } catch (Throwable th) {
            com.hailiang.advlib.common.d.a(context, th.getMessage());
            return new int[]{0, 0};
        }
    }

    public static boolean l() {
        try {
            return Build.VERSION.SDK_INT <= 22;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean m(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            try {
                return context.getApplicationContext().getPackageName().equals(com.hailiang.advlib.common.e.c(context));
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static void n() {
        try {
            File file = new File(f49306f + "/" + f49301a);
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
            InputStream open = f49313m.getAssets().open(f49321u.c());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            com.hailiang.advlib.common.e.b(open, fileOutputStream);
            fileOutputStream.close();
            open.close();
            file.setReadOnly();
            f49304d = f49301a;
            f49318r = "3.460";
            f49320t = false;
            q(f49313m);
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Throwable unused2) {
        }
        f49304d = f49301a;
        f49318r = "3.460";
    }

    public static boolean o(Context context) {
        try {
            if (f49306f != null) {
                return true;
            }
            f49306f = context.getDir("qm", 0).getAbsolutePath();
            f49305e = context.getCodeCacheDir().getAbsolutePath();
            return true;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void p() {
        for (d dVar : f49315o) {
            dVar.a(j(), a());
            f49315o.remove(dVar);
        }
    }

    public static void q(Context context) {
        try {
            context.getSharedPreferences("hailiang_loadremote_config", 0).edit().putString("aisdk_lib_local", "3.460").apply();
        } catch (Throwable unused) {
        }
    }
}
