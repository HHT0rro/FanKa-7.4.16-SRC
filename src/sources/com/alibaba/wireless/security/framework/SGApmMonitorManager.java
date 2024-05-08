package com.alibaba.wireless.security.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.view.WindowManager;
import com.alibaba.security.realidentity.http.BaseHttpManager;
import com.alibaba.wireless.security.framework.utils.C0050;
import com.alibaba.wireless.security.framework.utils.C0055;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alipay.sdk.cons.b;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.openalliance.ad.constant.as;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SGApmMonitorManager {

    /* renamed from: п, reason: collision with root package name */
    private static volatile SGApmMonitorManager f4072 = null;

    /* renamed from: р, reason: collision with root package name */
    private static int f4073 = 5000;

    /* renamed from: с, reason: collision with root package name */
    private static ScheduledExecutorService f4074;

    /* renamed from: т, reason: collision with root package name */
    private static ScheduledExecutorService f4075;

    /* renamed from: у, reason: collision with root package name */
    private static JSONObject f4076 = new JSONObject();

    /* renamed from: ф, reason: collision with root package name */
    private static long f4077;

    /* renamed from: д, reason: contains not printable characters */
    private C0059 f10;

    /* renamed from: а, reason: collision with root package name */
    private ConcurrentHashMap<String, Number> f4078 = new ConcurrentHashMap<>();

    /* renamed from: б, reason: collision with root package name */
    private ConcurrentHashMap<String, Number> f4079 = new ConcurrentHashMap<>();

    /* renamed from: в, reason: collision with root package name */
    private volatile int f4080 = 0;

    /* renamed from: г, reason: collision with root package name */
    private Context f4081 = null;

    /* renamed from: е, reason: contains not printable characters */
    private String f11 = null;

    /* renamed from: ё, reason: contains not printable characters */
    private volatile boolean f21 = false;

    /* renamed from: ж, reason: contains not printable characters */
    private boolean f12 = false;

    /* renamed from: з, reason: contains not printable characters */
    private int f13 = 0;

    /* renamed from: и, reason: contains not printable characters */
    private boolean f14 = true;

    /* renamed from: й, reason: contains not printable characters */
    private long f15 = 0;

    /* renamed from: к, reason: contains not printable characters */
    private long f16 = 0;

    /* renamed from: л, reason: contains not printable characters */
    private long f17 = 0;

    /* renamed from: м, reason: contains not printable characters */
    private long f18 = 0;

    /* renamed from: н, reason: contains not printable characters */
    private boolean f19 = false;

    /* renamed from: о, reason: contains not printable characters */
    private String f20 = null;

    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class C0039 implements Application.ActivityLifecycleCallbacks {
        public C0039() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            SGApmMonitorManager.m1778(SGApmMonitorManager.this);
            if (SGApmMonitorManager.this.f13 == 1) {
                SGApmMonitorManager.this.f14 = true;
                if (SGApmMonitorManager.this.f18 > 0) {
                    SGApmMonitorManager.this.f17 += System.currentTimeMillis() - SGApmMonitorManager.this.f18;
                }
                SGApmMonitorManager.this.f16 = System.currentTimeMillis();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            SGApmMonitorManager.m1783(SGApmMonitorManager.this);
            if (SGApmMonitorManager.this.f13 == 0) {
                SGApmMonitorManager.this.f14 = false;
                if (SGApmMonitorManager.this.f16 == 0) {
                    SGApmMonitorManager.this.f16 = SGApmMonitorManager.f4077;
                }
                SGApmMonitorManager.this.f15 += System.currentTimeMillis() - SGApmMonitorManager.this.f16;
                SGApmMonitorManager.this.f18 = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$б, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class ThreadFactoryC0040 implements ThreadFactory {
        public ThreadFactoryC0040(SGApmMonitorManager sGApmMonitorManager) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SGApmMonitor-1");
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$в, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class ThreadFactoryC0041 implements ThreadFactory {
        public ThreadFactoryC0041(SGApmMonitorManager sGApmMonitorManager) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SGApmMonitor-2");
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$г, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0042 implements Runnable {
        public RunnableC0042() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SGApmMonitorManager.this.m1793();
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$д, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0043 implements Runnable {
        public RunnableC0043() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SGApmMonitorManager.this.m1810();
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$е, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0044 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        public final /* synthetic */ boolean f25;

        /* renamed from: б, reason: contains not printable characters */
        public final /* synthetic */ String f26;

        /* renamed from: в, reason: contains not printable characters */
        public final /* synthetic */ String f27;

        public RunnableC0044(boolean z10, String str, String str2) {
            this.f25 = z10;
            this.f26 = str;
            this.f27 = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            UserTrackMethodJniBridge.addUtRecord("100171", 0, 1, SGApmMonitorManager.this.f11, 0L, null, SGApmMonitorManager.this.f20, "" + this.f25, this.f26, this.f27);
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$ж, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0045 implements Runnable {
        public RunnableC0045() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SGApmMonitorManager.this.f12) {
                SGApmMonitorManager.f4075.submit(new RunnableC0048("always", 1));
            }
            if (SGApmMonitorManager.this.f4080 == 0 && SGApmMonitorManager.this.isAllPluginLoaded()) {
                SGApmMonitorManager.this.m1814();
                SGApmMonitorManager.this.f21 = false;
                JSONObject unused = SGApmMonitorManager.f4076 = null;
                SGApmMonitorManager.f4074.shutdown();
                SGApmMonitorManager.f4075.shutdown();
            }
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$з, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0046 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        private String f30;

        /* renamed from: б, reason: contains not printable characters */
        private int f31;

        /* renamed from: в, reason: contains not printable characters */
        private int f32;

        /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$з$а, reason: contains not printable characters */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class RunnableC0047 implements Runnable {
            public RunnableC0047() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SGApmMonitorManager.this.m1795();
            }
        }

        public RunnableC0046(String str, int i10, int i11) {
            this.f30 = str;
            this.f31 = i10;
            this.f32 = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f30 != null && SGApmMonitorManager.this.f21 && SGApmMonitorManager.f4076 != null && this.f31 <= 5) {
                try {
                    if (((Number) SGApmMonitorManager.this.f4079.get(this.f30)) == null) {
                        SGApmMonitorManager.f4075.submit(new RunnableC0047());
                        SGApmMonitorManager.f4075.submit(new RunnableC0048(this.f30 + "_f", this.f31));
                        synchronized (SGApmMonitorManager.class) {
                            SGApmMonitorManager.m1796(SGApmMonitorManager.this);
                        }
                        SGApmMonitorManager.f4074.schedule(new RunnableC0046(this.f30, this.f31 + 1, this.f32), this.f32, TimeUnit.MILLISECONDS);
                        return;
                    }
                    if (this.f31 <= 1) {
                        return;
                    }
                    SGApmMonitorManager.f4075.submit(new RunnableC0048(this.f30 + "_s", this.f31));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: com.alibaba.wireless.security.framework.SGApmMonitorManager$ё, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class RunnableC0048 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        private String f35;

        public RunnableC0048(String str, int i10) {
            this.f35 = Base64.encodeToString(SGApmMonitorManager.this.m1770(str, i10).getBytes(), 2);
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f35;
            if (str == null) {
                return;
            }
            SGApmMonitorManager.this.m1774(str);
        }
    }

    public static SGApmMonitorManager getInstance() {
        if (f4072 == null) {
            synchronized (SGApmMonitorManager.class) {
                if (f4072 == null) {
                    f4072 = new SGApmMonitorManager();
                }
            }
        }
        return f4072;
    }

    /* renamed from: а, reason: contains not printable characters */
    private String m1768(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: а, reason: contains not printable characters */
    public String m1770(String str, int i10) {
        String str2;
        String packageName = this.f4081.getPackageName();
        try {
            str2 = this.f4081.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "";
        }
        long j10 = this.f15;
        long j11 = this.f17;
        if (this.f16 == 0) {
            this.f16 = f4077;
        }
        if (this.f14) {
            j10 += System.currentTimeMillis() - this.f16;
        } else if (this.f18 > 0) {
            j11 += System.currentTimeMillis() - this.f18;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(b.f4545g, m1799());
            jSONObject.put("sysver", Build.VERSION.RELEASE);
            jSONObject.put(bk.f9900i, Build.MODEL);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("reason", str);
            jSONObject.put("wsv", this.f11);
            jSONObject.put("wsd", m1800());
            jSONObject.put("foreground", this.f14);
            jSONObject.put("foregroundtime", j10);
            jSONObject.put("backgroundtime", j11);
            jSONObject.put("fulltrack", this.f19);
            jSONObject.put("sample", this.f12);
            jSONObject.put("tryround", i10);
            jSONObject.put("initts", f4077);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("appver", str2);
            jSONObject.put(as.f32250y, packageName);
            jSONObject.put(ExposeManager.UtArgsNames.pid, Process.myPid());
            jSONObject.put("process", m1768(this.f4081));
            jSONObject.put("tracklog", f4076);
            jSONObject.put("costlog", m1771(this.f4079));
            jSONObject.put("nt", this.f10.getRouter().doCommand(11154, new Object[0]));
        } catch (Exception unused2) {
        }
        return jSONObject.toString();
    }

    /* renamed from: а, reason: contains not printable characters */
    private JSONObject m1771(ConcurrentHashMap<String, Number> concurrentHashMap) {
        try {
            ArrayList<String> arrayList = new ArrayList(concurrentHashMap.h());
            Collections.sort(arrayList);
            JSONObject jSONObject = new JSONObject();
            for (String str : arrayList) {
                jSONObject.put(str, concurrentHashMap.get(str));
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: а, reason: contains not printable characters */
    public void m1774(String str) {
        Context context;
        String str2;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        if (str == null || (context = this.f4081) == null) {
            return;
        }
        String packageName = context.getPackageName();
        try {
            str2 = this.f4081.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "";
        }
        BufferedReader bufferedReader = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("https://umdc.alibabachengdun.com/repTd.json?e=" + WindowManager.LayoutParams.TYPE_NOTIFICATION_SHADE + "&pn=" + packageName + "&os=0&pv=" + str2 + "&pt=1").openConnection();
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.setConnectTimeout(20000);
                    httpURLConnection.setReadTimeout(20000);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
                    httpURLConnection.setRequestProperty(BaseHttpManager.HTTP_REQ_PROPERTY_CHARSET, "UTF-8");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.connect();
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        try {
                            outputStream.write(str.getBytes());
                            outputStream.flush();
                            if (httpURLConnection.getResponseCode() != 200) {
                                try {
                                    outputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                httpURLConnection.disconnect();
                                return;
                            }
                            InputStream inputStream = httpURLConnection.getInputStream();
                            if (inputStream == null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                                httpURLConnection.disconnect();
                                return;
                            }
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                            do {
                                try {
                                } catch (Exception e11) {
                                    e = e11;
                                    bufferedReader = bufferedReader2;
                                    e.printStackTrace();
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e12) {
                                            e12.printStackTrace();
                                        }
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e13) {
                                            e13.printStackTrace();
                                        }
                                    }
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                    httpURLConnection.disconnect();
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e14) {
                                            e14.printStackTrace();
                                        }
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e15) {
                                            e15.printStackTrace();
                                        }
                                    }
                                    if (httpURLConnection == null) {
                                        throw th;
                                    }
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                            } while (bufferedReader2.readLine() != null);
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e16) {
                        e = e16;
                    }
                } catch (Exception e17) {
                    e = e17;
                    outputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                }
            } else {
                outputStream = null;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
            if (httpURLConnection == null) {
                return;
            }
        } catch (Exception e20) {
            e = e20;
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            httpURLConnection = null;
        }
        httpURLConnection.disconnect();
    }

    /* renamed from: а, reason: contains not printable characters */
    private void m1775(String str, String str2) {
        try {
            if (TextUtils.equals(str2, "7L2OvtRdxzOJAe7ImU+4I2bAxvq1oDLyTCzRgSPGufNIb7ZY5FsHDFaEzD98Mn7K")) {
                boolean delete = new File(m1780(this.f4081), "init.config").delete();
                this.f10.m1914(m1800());
                f4075.schedule(new RunnableC0044(delete, str, str2), 5L, TimeUnit.SECONDS);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    private boolean m1776() {
        if (m1807()) {
            return true;
        }
        double d10 = 0.001d;
        File file = new File(m1780(this.f4081), "." + m1797());
        if (file.exists()) {
            String m1826 = C0050.m1826(file);
            try {
                if (!TextUtils.isEmpty(m1826)) {
                    d10 = Double.parseDouble(m1826);
                }
            } catch (Exception unused) {
            }
        }
        return new Random().nextDouble() < d10;
    }

    /* renamed from: б, reason: contains not printable characters */
    public static /* synthetic */ int m1778(SGApmMonitorManager sGApmMonitorManager) {
        int i10 = sGApmMonitorManager.f13;
        sGApmMonitorManager.f13 = i10 + 1;
        return i10;
    }

    /* renamed from: б, reason: contains not printable characters */
    private File m1780(Context context) {
        String str;
        File dir;
        String str2;
        if (context == null) {
            return null;
        }
        try {
            str2 = context.getApplicationInfo().sourceDir;
        } catch (Throwable unused) {
        }
        if (str2 != null) {
            File file = new File(str2);
            if (file.exists()) {
                str = (file.lastModified() / 1000) + "";
                if (str != null || (dir = context.getDir("SGLib", 0)) == null) {
                    return null;
                }
                return new File(dir, "app_" + str);
            }
        }
        str = null;
        if (str != null) {
            return null;
        }
        return new File(dir, "app_" + str);
    }

    /* renamed from: в, reason: contains not printable characters */
    public static /* synthetic */ int m1783(SGApmMonitorManager sGApmMonitorManager) {
        int i10 = sGApmMonitorManager.f13;
        sGApmMonitorManager.f13 = i10 - 1;
        return i10;
    }

    /* renamed from: в, reason: contains not printable characters */
    private void m1786(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        ((Application) context).registerActivityLifecycleCallbacks(new C0039());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* renamed from: е, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1793() {
        /*
            r12 = this;
            java.lang.String r0 = "securityguard_orange_namespace"
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            boolean r2 = r12.m1805()
            java.lang.String r3 = "1"
            if (r2 == 0) goto Le
            r2 = r3
            goto L10
        Le:
            java.lang.String r2 = "0"
        L10:
            java.lang.String r4 = "com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener"
            r5 = 0
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r6 = "getOrangeConfig"
            r7 = 3
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch: java.lang.Throwable -> L4e
            r9 = 0
            r8[r9] = r1     // Catch: java.lang.Throwable -> L4e
            r10 = 1
            r8[r10] = r1     // Catch: java.lang.Throwable -> L4e
            r11 = 2
            r8[r11] = r1     // Catch: java.lang.Throwable -> L4e
            java.lang.reflect.Method r1 = r4.getMethod(r6, r8)     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L4c
            java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L4e
            r6[r9] = r0     // Catch: java.lang.Throwable -> L4e
            java.lang.String r8 = "128"
            r6[r10] = r8     // Catch: java.lang.Throwable -> L4e
            r6[r11] = r2     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r2 = r1.invoke(r4, r6)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L4e
            java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L4f
            r6[r9] = r0     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = "129"
            r6[r10] = r0     // Catch: java.lang.Throwable -> L4f
            r6[r11] = r3     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r0 = r1.invoke(r4, r6)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L4f
            goto L50
        L4c:
            r0 = r5
            goto L51
        L4e:
            r2 = r5
        L4f:
            r0 = r5
        L50:
            r5 = r2
        L51:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> Lbb
            android.content.Context r2 = r12.f4081     // Catch: java.lang.Exception -> Lbb
            java.io.File r2 = r12.m1780(r2)     // Catch: java.lang.Exception -> Lbb
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbb
            r4.<init>()     // Catch: java.lang.Exception -> Lbb
            java.lang.String r6 = ".pma_"
            r4.append(r6)     // Catch: java.lang.Exception -> Lbb
            java.lang.String r6 = r12.m1797()     // Catch: java.lang.Exception -> Lbb
            r4.append(r6)     // Catch: java.lang.Exception -> Lbb
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Lbb
            r1.<init>(r2, r4)     // Catch: java.lang.Exception -> Lbb
            boolean r2 = r1.exists()     // Catch: java.lang.Exception -> Lbb
            boolean r4 = r3.equals(r5)     // Catch: java.lang.Exception -> Lbb
            if (r4 == 0) goto L81
            if (r2 != 0) goto L86
            r1.createNewFile()     // Catch: java.lang.Exception -> Lbb
            goto L86
        L81:
            if (r2 == 0) goto L86
            r1.delete()     // Catch: java.lang.Exception -> Lbb
        L86:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> Lbb
            android.content.Context r2 = r12.f4081     // Catch: java.lang.Exception -> Lbb
            java.io.File r2 = r12.m1780(r2)     // Catch: java.lang.Exception -> Lbb
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbb
            r4.<init>()     // Catch: java.lang.Exception -> Lbb
            java.lang.String r5 = ".istbg_"
            r4.append(r5)     // Catch: java.lang.Exception -> Lbb
            java.lang.String r5 = r12.m1797()     // Catch: java.lang.Exception -> Lbb
            r4.append(r5)     // Catch: java.lang.Exception -> Lbb
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> Lbb
            r1.<init>(r2, r4)     // Catch: java.lang.Exception -> Lbb
            boolean r2 = r1.exists()     // Catch: java.lang.Exception -> Lbb
            boolean r0 = r3.equals(r0)     // Catch: java.lang.Exception -> Lbb
            if (r0 == 0) goto Lb6
            if (r2 != 0) goto Lbb
            r1.createNewFile()     // Catch: java.lang.Exception -> Lbb
            goto Lbb
        Lb6:
            if (r2 == 0) goto Lbb
            r1.delete()     // Catch: java.lang.Exception -> Lbb
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.SGApmMonitorManager.m1793():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ж, reason: contains not printable characters */
    public void m1795() {
        Context context = this.f4081;
        if (context == null) {
            return;
        }
        File file = new File(context.getDir("SGLib", 0), ".nt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        try {
            SharedPreferences sharedPreferences = this.f4081.getSharedPreferences("sgloadfailed", 0);
            if (sharedPreferences.getInt("times", 0) != 0) {
                sharedPreferences.edit().putInt("times", 0).commit();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: з, reason: contains not printable characters */
    public static /* synthetic */ int m1796(SGApmMonitorManager sGApmMonitorManager) {
        int i10 = sGApmMonitorManager.f4080;
        sGApmMonitorManager.f4080 = i10 + 1;
        return i10;
    }

    /* renamed from: з, reason: contains not printable characters */
    private String m1797() {
        try {
            return this.f4081.getPackageManager().getPackageInfo(this.f4081.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0031, code lost:
    
        if (r3.contains(com.huawei.appgallery.agd.common.constant.SymbolValues.QUESTION_EN_SYMBOL) == false) goto L11;
     */
    /* renamed from: и, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m1799() {
        /*
            r11 = this;
            java.lang.String r0 = "getUtdid"
            java.lang.String r1 = ""
            android.content.Context r2 = r11.f4081
            java.lang.String r3 = "com.ut.device.UTDevice"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L58
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L58
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6     // Catch: java.lang.Exception -> L58
            java.lang.reflect.Method r3 = r3.getMethod(r0, r5)     // Catch: java.lang.Exception -> L58
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L58
            r5[r7] = r2     // Catch: java.lang.Exception -> L58
            r6 = 0
            java.lang.Object r3 = r3.invoke(r6, r5)     // Catch: java.lang.Exception -> L58
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> L58
            java.lang.String r5 = "?"
            if (r3 == 0) goto L36
            boolean r8 = r3.isEmpty()     // Catch: java.lang.Exception -> L34
            if (r8 != 0) goto L36
            boolean r8 = r3.contains(r5)     // Catch: java.lang.Exception -> L34
            if (r8 == 0) goto L34
            goto L36
        L34:
            r1 = r3
            goto L58
        L36:
            java.lang.String r8 = "com.ta.utdid2.device.UTDevice"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch: java.lang.Exception -> L34
            java.lang.Class[] r9 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L34
            java.lang.Class<android.content.Context> r10 = android.content.Context.class
            r9[r7] = r10     // Catch: java.lang.Exception -> L34
            java.lang.reflect.Method r0 = r8.getMethod(r0, r9)     // Catch: java.lang.Exception -> L34
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L34
            r4[r7] = r2     // Catch: java.lang.Exception -> L34
            java.lang.Object r0 = r0.invoke(r6, r4)     // Catch: java.lang.Exception -> L34
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L34
            boolean r2 = r0.contains(r5)     // Catch: java.lang.Exception -> L57
            if (r2 == 0) goto L57
            goto L58
        L57:
            r1 = r0
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.SGApmMonitorManager.m1799():java.lang.String");
    }

    /* renamed from: й, reason: contains not printable characters */
    private String m1800() {
        if (this.f20 == null) {
            try {
                C0057 m1857 = C0057.m1857(new File(m1780(this.f4081), "init.config"));
                if (m1857 != null) {
                    this.f20 = "" + m1857.m1860();
                }
            } catch (Exception unused) {
            }
        }
        return this.f20;
    }

    /* renamed from: к, reason: contains not printable characters */
    private boolean m1803() {
        File m1780 = m1780(this.f4081);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(".pma_");
        sb2.append(m1797());
        return new File(m1780, sb2.toString()).exists();
    }

    /* renamed from: л, reason: contains not printable characters */
    private boolean m1805() {
        Context context = this.f4081;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        return "com.taobao.taobao".equals(packageName) || "com.alibaba.wireless.securityguard".equals(packageName);
    }

    /* renamed from: м, reason: contains not printable characters */
    private boolean m1807() {
        try {
            if (m1805() && m1809()) {
                return m1797().split("\\.").length == 4;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: н, reason: contains not printable characters */
    private boolean m1809() {
        File m1780 = m1780(this.f4081);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(".istbg_");
        sb2.append(m1797());
        return new File(m1780, sb2.toString()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: о, reason: contains not printable characters */
    public void m1810() {
        String str;
        HttpURLConnection httpURLConnection;
        Context context = this.f4081;
        if (context == null) {
            return;
        }
        String packageName = context.getPackageName();
        try {
            str = this.f4081.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (Exception unused) {
            str = "";
        }
        String m1800 = m1800();
        if (m1800 == null) {
            return;
        }
        String str2 = "http://cdn-mum.alibabachengdun.com/sg7sX1/rYxU/pDDw/" + m1800 + "?pn=" + packageName + "&pv=" + str;
        BufferedReader bufferedReader = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
                httpURLConnection.setRequestProperty(BaseHttpManager.HTTP_REQ_PROPERTY_CHARSET, "UTF-8");
                if (httpURLConnection.getResponseCode() == 200) {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    try {
                        char[] cArr = new char[1100];
                        StringBuffer stringBuffer = new StringBuffer();
                        int read = bufferedReader2.read(cArr);
                        if (read < 1024) {
                            stringBuffer.append(cArr, 0, read);
                        }
                        m1775(str2, stringBuffer.toString());
                        bufferedReader = bufferedReader2;
                    } catch (Exception unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                        httpURLConnection.disconnect();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        if (httpURLConnection == null) {
                            throw th;
                        }
                        httpURLConnection.disconnect();
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused4) {
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
        httpURLConnection.disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ё, reason: contains not printable characters */
    public void m1814() {
        Context context = this.f4081;
        if (context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("sgloadfailed", 0);
            int i10 = sharedPreferences.getInt("times", 0);
            if (i10 > 5) {
                File file = new File(this.f4081.getDir("SGLib", 0), ".nt");
                if (file.exists()) {
                    file.delete();
                }
            } else {
                sharedPreferences.edit().putInt("times", i10 + 1).commit();
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void addTrackInfo(String str) {
        JSONArray jSONArray;
        if (str != null) {
            if (this.f21) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("@");
                sb2.append(this.f14 ? "1" : "0");
                String sb3 = sb2.toString();
                String str2 = "" + Process.myPid() + "_" + Process.myTid();
                try {
                    jSONArray = (JSONArray) f4076.get(str2);
                } catch (Exception unused) {
                    jSONArray = new JSONArray();
                    try {
                        f4076.put(str2, jSONArray);
                    } catch (Exception unused2) {
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", sb3);
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Exception unused3) {
                }
            }
        }
    }

    public void init(Context context) {
        this.f4081 = context;
        f4077 = System.currentTimeMillis();
        Context context2 = this.f4081;
        if (context2 == null || !C0055.m1850(context2)) {
            return;
        }
        f4074 = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC0040(this));
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC0041(this));
        f4075 = newSingleThreadScheduledExecutor;
        if (f4074 == null || newSingleThreadScheduledExecutor == null) {
            return;
        }
        newSingleThreadScheduledExecutor.schedule(new RunnableC0042(), 5L, TimeUnit.SECONDS);
        boolean m1803 = m1803();
        this.f12 = m1776();
        if (m1803) {
            this.f21 = true;
            this.f19 = isEnableFullTrackRecord();
            m1786(this.f4081);
            f4074.schedule(new RunnableC0045(), f4073 * 5, TimeUnit.MILLISECONDS);
            f4075.submit(new RunnableC0043());
        }
    }

    public boolean isAllPluginLoaded() {
        return this.f4079.containsKey("getInstance") && this.f4079.containsKey("securitybody") && this.f4079.containsKey("middletier");
    }

    public boolean isEnableFullTrackRecord() {
        if (this.f4081 == null) {
            return false;
        }
        if (m1807()) {
            return true;
        }
        return new File(this.f4081.getDir("SGLib", 0), ".nt").exists();
    }

    public boolean isForeground() {
        return this.f14;
    }

    public void monitorEnd(String str) {
        if (str == null || !this.f21) {
            return;
        }
        addTrackInfo("j_" + str + "_e");
        Number number = this.f4078.get(str);
        if (number != null && this.f4079.get(str) == null) {
            this.f4079.put(str, Long.valueOf(System.currentTimeMillis() - number.longValue()));
        }
    }

    public void monitorStart(String str) {
        monitorStartWithTimeout(str, f4073);
    }

    public void monitorStartWithTimeout(String str, int i10) {
        if (str == null || !this.f21) {
            return;
        }
        addTrackInfo("j_" + str + "_s");
        if (this.f4078.get(str) != null) {
            return;
        }
        this.f4078.put(str, Long.valueOf(System.currentTimeMillis()));
        f4074.schedule(new RunnableC0046(str, 1, i10), i10, TimeUnit.MILLISECONDS);
    }

    public void setMainPluginVersion(String str) {
        this.f11 = str;
    }

    public void setSGPluginManager(C0059 c0059) {
        this.f10 = c0059;
    }
}
