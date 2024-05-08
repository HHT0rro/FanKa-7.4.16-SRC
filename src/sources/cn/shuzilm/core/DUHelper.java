package cn.shuzilm.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DUHelper extends PhoneStateListener {
    public static final int MAIN_DU_ASYNCHRONOUS = 1;
    public static final int MAIN_DU_SYNCHRONOUS = 0;

    /* renamed from: a */
    private static final String f1679a = "du.lock";

    /* renamed from: b */
    private static final String f1680b = "du";

    /* renamed from: c */
    private static AIClient f1681c;
    public static Context mContext;
    public static int mMeic;
    public static int mPopu;
    public static int mPort;
    public static int mSplt;

    /* renamed from: t */
    private static u f1698t;

    /* renamed from: w */
    private int f1701w = 2;

    /* renamed from: x */
    private boolean f1702x = false;

    /* renamed from: y */
    private long f1703y = 0;

    /* renamed from: d */
    private static final DUHelper f1682d = new DUHelper();

    /* renamed from: e */
    private static final Lock f1683e = new ReentrantLock();

    /* renamed from: f */
    private static final Lock f1684f = new ReentrantLock();

    /* renamed from: g */
    private static final ReentrantReadWriteLock f1685g = new ReentrantReadWriteLock();

    /* renamed from: h */
    private static boolean f1686h = false;

    /* renamed from: i */
    private static String f1687i = null;

    /* renamed from: j */
    private static String f1688j = null;

    /* renamed from: k */
    private static final JSONObject f1689k = new JSONObject();

    /* renamed from: l */
    private static final JSONObject f1690l = new JSONObject();

    /* renamed from: m */
    private static JSONObject f1691m = null;

    /* renamed from: n */
    private static final ThreadLocal f1692n = new ThreadLocal();

    /* renamed from: o */
    private static String f1693o = null;

    /* renamed from: p */
    private static JSONObject f1694p = new JSONObject();

    /* renamed from: q */
    private static final ExecutorService f1695q = Executors.newSingleThreadExecutor();

    /* renamed from: r */
    private static final ExecutorService f1696r = Executors.newSingleThreadExecutor();

    /* renamed from: s */
    private static final ExecutorService f1697s = Executors.newSingleThreadExecutor();

    /* renamed from: u */
    private static Timer f1699u = null;

    /* renamed from: v */
    private static TimerTask f1700v = new h();

    private DUHelper() {
    }

    public static String Q3VzdG(Context context, String str) {
        if (str == null) {
            return null;
        }
        return context.getSharedPreferences(context.getPackageName() + "_dna", 0).getString(str, null);
    }

    public static void ZVTFJRA(Context context, Listener listener, int i10) {
        try {
            f1696r.execute(new g(b(context), i10, listener));
        } catch (Exception e2) {
            listener.handler("NA_E");
            e2.printStackTrace();
        }
    }

    public static void ZVTFJRAAsyn(Context context, DUListener dUListener) {
        try {
            f1696r.execute(new f(b(context), dUListener));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String a(Context context, String str, String str2, int i10) {
        try {
            if (!f1682d.d(context)) {
                return null;
            }
            setConfig("apiKey", f1687i);
            JSONObject jSONObject = f1690l;
            a(context, jSONObject, str);
            JSONObject jSONObject2 = f1689k;
            a(jSONObject2, str2);
            String query = query(context, jSONObject.toString(), jSONObject2.toString(), i10);
            if (query != null && !query.isEmpty()) {
                dl.d(mContext, query);
            }
            return query;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private void a(Context context, int i10) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f1703y > 7000) {
                f1695q.execute(new t(this, i10));
                this.f1703y = currentTimeMillis;
            }
        } catch (Exception unused) {
        }
    }

    private void a(Context context, SensorManager sensorManager, Sensor sensor) {
        sensorManager.registerListener(new d(this, context, sensorManager), sensor, 1);
    }

    private void a(Context context, String str, String str2, DUListener dUListener) {
        try {
            f1695q.execute(new b(this, context, str, str2, dUListener));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, String str, String str2, Listener listener, int i10) {
        try {
            f1695q.execute(new c(this, context, str, str2, i10, listener));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, String str, String str2, String str3, DUListener dUListener) {
        f1695q.execute(new r(this, context, str, str2, str3, dUListener));
    }

    private void a(Context context, String str, String str2, String str3, Listener listener) {
        f1695q.execute(new s(this, context, str, str2, str3, listener));
    }

    public void a(Context context, JSONObject jSONObject, String str) {
        String str2;
        try {
            if (jSONObject.isNull("store")) {
                if (str == null && (str = f(context)) == null) {
                    str = (String) c(context, "store");
                }
                if (str != null) {
                    jSONObject.put("store", str);
                }
            }
            if (!jSONObject.isNull("apiKey") || (str2 = (String) c(context, "apiKey")) == null) {
                return;
            }
            jSONObject.put("apiKey", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, String str2) {
        try {
            ThreadLocal threadLocal = f1692n;
            JSONObject jSONObject = (JSONObject) threadLocal.get();
            if (jSONObject != null) {
                jSONObject.put(str, str2);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, str2);
            threadLocal.set(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, String str) {
        a(jSONObject, "custom", str);
    }

    private void a(JSONObject jSONObject, String str, String str2) {
        jSONObject.put(str, str2);
    }

    public static native void aXZlZWNl(Context context, Intent intent);

    private static Context b(Context context) {
        Context applicationContext;
        try {
            applicationContext = context.getApplicationContext();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return applicationContext != null ? applicationContext : context;
    }

    public String b(Context context, int i10) {
        String str;
        try {
            str = c6M2YmYQ(context, i10);
        } catch (Exception unused) {
            str = null;
        }
        if (i10 != 1) {
            a(context, i10);
        }
        return str;
    }

    private String b(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    open.close();
                    return sb2.toString();
                }
                sb2.append(readLine);
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public String b(Context context, String str, String str2, String str3) {
        String str4 = null;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
        }
        if (!f1682d.d(context)) {
            return null;
        }
        a("pEventCode", str);
        if (str2 != null) {
            a("mEventCode", str2);
        }
        ThreadLocal threadLocal = f1692n;
        String jSONObject = threadLocal.get() != null ? ((JSONObject) threadLocal.get()).toString() : null;
        String jSONObject2 = f1689k.toString();
        synchronized (this) {
            str4 = onEvent(context, jSONObject, jSONObject2, str3);
        }
        return str4;
    }

    public static void bm(Context context, String str) {
        try {
            f1695q.execute(new i(b(context), str));
        } catch (Exception unused) {
        }
    }

    private static int c(Context context) {
        String packageName = context.getPackageName();
        try {
            int i10 = ((int) context.getPackageManager().getPackageInfo(packageName, 0).firstInstallTime) % 10000;
            int hashCode = (packageName + Build.MODEL).hashCode();
            if (hashCode < 0) {
                hashCode = -hashCode;
            }
            mPort = (hashCode % 5000) + 12000 + i10;
            return 0;
        } catch (Exception e2) {
            mPort = 17835;
            e2.printStackTrace();
            return -1;
        }
    }

    private Object c(Context context, String str) {
        try {
            JSONObject jSONObject = f1691m;
            if (jSONObject == null) {
                jSONObject = e(context);
                f1691m = jSONObject;
            }
            return jSONObject.opt(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized String c(Context context, int i10, String str) {
        String c6M3YmYQ;
        synchronized (DUHelper.class) {
            try {
                c6M3YmYQ = c6M3YmYQ(context, i10, str);
            } catch (Exception unused) {
                return null;
            }
        }
        return c6M3YmYQ;
    }

    private static native String c6M2YmYQ(Context context, int i10);

    private static native String c6M3YmYQ(Context context, int i10, String str);

    private String d(Context context, String str) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean d(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (Build.VERSION.SDK_INT > 23) {
                if (connectivityManager.getActiveNetwork() != null) {
                    return true;
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return false;
    }

    public static native void dGZvcmRQ(Context context, String str, String str2);

    private JSONObject e(Context context) {
        String b4 = b(context, "cn.shuzilm.config.json");
        if (b4 != null) {
            return new JSONObject(b4);
        }
        return null;
    }

    private String f(Context context) {
        try {
            DUHelper dUHelper = f1682d;
            Object c4 = dUHelper.c(context, "store");
            if (c4 instanceof String) {
                return null;
            }
            return dUHelper.d(context, new JSONObject(c4.toString()).getJSONObject("metadata").getString("name"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void f2c071(int i10, Listener listener) {
        try {
            Context b4 = b(mContext);
            DUHelper dUHelper = f1682d;
            if (dUHelper.f1702x && b4 != null && f1687i != null) {
                if (i10 == 1) {
                    getQueryID(mContext, "NA", "", 1, new a(b4, i10, listener), i10 + 100);
                } else {
                    listener.handler(dUHelper.b(b4, i10));
                }
            }
        } catch (Exception unused) {
        }
    }

    public String g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_dna", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(MonitorConstants.EXTRA_DEVICE_ID, null);
        }
        return null;
    }

    private static void g() {
        if (f1686h) {
            return;
        }
        try {
            new Thread(new n()).start();
            f1686h = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized String getQueryID(Context context, String str, String str2) {
        synchronized (DUHelper.class) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicReference atomicReference = new AtomicReference();
            try {
                getQueryID(context, str, str2, 1, new q(atomicReference, countDownLatch), 2);
                countDownLatch.await(60000L, TimeUnit.MILLISECONDS);
                return (String) atomicReference.get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return null;
            } catch (NullPointerException unused2) {
                return null;
            }
        }
    }

    public static Map getQueryID(Context context, String str, String str2, int i10, Listener listener, int i11) {
        try {
            HashMap hashMap = new HashMap();
            String str3 = "0";
            Context b4 = b(context);
            DUHelper dUHelper = f1682d;
            dUHelper.f1701w = i11;
            if (i10 == 1) {
                dUHelper.a(b4, str, str2, listener, i11);
                return null;
            }
            Lock lock = f1683e;
            if (!lock.tryLock()) {
                String g3 = dUHelper.g(b4);
                if (g3 == null) {
                    dUHelper.a(b4, str, str2, listener, i11);
                }
                hashMap.put(MonitorConstants.EXTRA_DEVICE_ID, g3);
                hashMap.put("valid", "0");
                return hashMap;
            }
            String a10 = dUHelper.a(b4, str, str2, i11);
            if (a10 != null) {
                f1693o = a10;
                str3 = "1";
            }
            if (a10 == null && (a10 = f1693o) == null) {
                a10 = dUHelper.g(b4);
            }
            hashMap.put(MonitorConstants.EXTRA_DEVICE_ID, a10);
            hashMap.put("valid", str3);
            lock.unlock();
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Map getQueryIDDUCallback(Context context, String str, String str2, int i10, DUListener dUListener) {
        try {
            HashMap hashMap = new HashMap();
            String str3 = "0";
            Context b4 = b(context);
            if (i10 == 1) {
                f1682d.a(b4, str, str2, dUListener);
                return null;
            }
            Lock lock = f1683e;
            if (!lock.tryLock()) {
                DUHelper dUHelper = f1682d;
                String g3 = dUHelper.g(b4);
                if (g3 == null) {
                    dUHelper.a(b4, str, str2, dUListener);
                }
                hashMap.put(MonitorConstants.EXTRA_DEVICE_ID, g3);
                hashMap.put("valid", "0");
                return hashMap;
            }
            DUHelper dUHelper2 = f1682d;
            String a10 = dUHelper2.a(b4, str, str2, dUHelper2.f1701w);
            if (a10 != null) {
                f1693o = a10;
                str3 = "1";
            }
            if (a10 == null && (a10 = f1693o) == null) {
                a10 = dUHelper2.g(b4);
            }
            hashMap.put(MonitorConstants.EXTRA_DEVICE_ID, a10);
            hashMap.put("valid", str3);
            lock.unlock();
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void go(Context context, String str, String str2) {
        try {
            Context b4 = b(context);
            if (f1682d.d(b4) && f1683e.tryLock()) {
                try {
                    f1695q.execute(new o(b4, str, str2));
                } catch (Exception unused) {
                }
                f1683e.unlock();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void h(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(9);
        if (defaultSensor != null) {
            a(context, sensorManager, defaultSensor);
        }
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(3);
        if (defaultSensor2 != null) {
            a(context, sensorManager, defaultSensor2);
        }
        Sensor defaultSensor3 = sensorManager.getDefaultSensor(11);
        if (defaultSensor3 != null) {
            a(context, sensorManager, defaultSensor3);
        }
        Sensor defaultSensor4 = sensorManager.getDefaultSensor(6);
        if (defaultSensor4 != null) {
            a(context, sensorManager, defaultSensor4);
        }
        Sensor defaultSensor5 = sensorManager.getDefaultSensor(1);
        if (defaultSensor5 != null) {
            a(context, sensorManager, defaultSensor5);
        }
        Sensor defaultSensor6 = sensorManager.getDefaultSensor(4);
        if (defaultSensor6 != null) {
            a(context, sensorManager, defaultSensor6);
        }
        Sensor defaultSensor7 = sensorManager.getDefaultSensor(5);
        if (defaultSensor7 != null) {
            a(context, sensorManager, defaultSensor7);
        }
        Sensor defaultSensor8 = sensorManager.getDefaultSensor(2);
        if (defaultSensor8 != null) {
            a(context, sensorManager, defaultSensor8);
        }
    }

    public static void i(Context context) {
        if (f1682d.d(context)) {
            try {
                if (aa.p(mContext, "android.permission.CHANGE_NETWORK_STATE") && aa.i(context)) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
                    NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
                    j jVar = new j(context);
                    oxlbmV0d(context, jVar, 2);
                    connectivityManager.requestNetwork(build, jVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(Context context, String str) {
        try {
            mContext = b(context);
            FileOutputStream openFileOutput = context.openFileOutput(f1679a, 0);
            FileLock tryLock = openFileOutput.getChannel().tryLock();
            if (!tryLock.isValid()) {
                openFileOutput.close();
                return;
            }
            g();
            c(mContext);
            f1687i = str;
            f1695q.execute(new m(context));
            tryLock.release();
            openFileOutput.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
        }
    }

    public static void loadLibrary() {
        f1695q.execute(new k());
    }

    public static void m(Context context, int i10, Listener listener) {
        if (i10 == 2) {
            f1697s.execute(new l(context, listener));
        }
    }

    public static String n(Context context) {
        return c(context, 501, (String) null);
    }

    private static native String onEvent(Context context, String str, String str2, String str3);

    public static Map onEvent(Context context, String str, String str2, int i10, Listener listener) {
        if (str == null) {
            return null;
        }
        try {
            Context b4 = b(context);
            if (i10 == 1) {
                f1682d.a(b4, str, (String) null, str2, listener);
                return null;
            }
            HashMap hashMap = new HashMap();
            Lock lock = f1683e;
            if (!lock.tryLock()) {
                f1682d.a(b4, str, (String) null, str2, listener);
                return null;
            }
            hashMap.put("SessionID", f1682d.b(b4, str, null, str2));
            hashMap.put("QueryID", f1693o);
            lock.unlock();
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Map onEventDUCallback(Context context, String str, String str2, String str3, int i10, DUListener dUListener) {
        try {
            HashMap hashMap = new HashMap();
            if (str == null) {
                return null;
            }
            Context b4 = b(context);
            if (i10 == 1) {
                f1682d.a(b4, str, str2, str3, dUListener);
                return null;
            }
            Lock lock = f1683e;
            if (!lock.tryLock()) {
                f1682d.a(b4, str, str2, str3, dUListener);
                return null;
            }
            hashMap.put("SessionID", f1682d.b(b4, str, str2, str3));
            hashMap.put("QueryID", f1693o);
            lock.unlock();
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static native String onIEvent(Context context, String str, String str2, String str3);

    public static void onIEvent(Context context, String str) {
        try {
            f1695q.execute(new e(str, b(context)));
        } catch (Exception unused) {
        }
    }

    private static native void onSSChanged(Context context, SignalStrength signalStrength);

    public static native void onSensorChanged(Context context, SensorEvent sensorEvent);

    public static native void oxlbmV0d(Context context, Object obj, int i10);

    private static native String query(Context context, String str, String str2, int i10);

    public static void report(Context context, String str, String str2) {
        try {
            Context b4 = b(context);
            if (f1682d.d(b4) && f1683e.tryLock()) {
                try {
                    f1695q.execute(new p(b4, str, str2));
                } catch (Exception unused) {
                }
                f1683e.unlock();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static native String reportRun(Context context, String str, String str2);

    public static native String run(Context context, String str, String str2);

    public static int setConfig(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        f1682d.a(f1690l, str, str2);
        return 0;
    }

    public static int setData(String str, String str2) {
        f1682d.a(f1689k, str, str2);
        return 0;
    }

    public static int sl(Context context, IntentFilter intentFilter) {
        try {
            if (f1698t == null) {
                f1698t = new u(null);
            }
            if (f1699u != null) {
                return 0;
            }
            context.registerReceiver(f1698t, intentFilter);
            Timer timer = new Timer();
            f1699u = timer;
            timer.schedule(f1700v, 10000L);
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String startService(Context context, ServiceConnection serviceConnection, String str, int i10) {
        try {
            Context b4 = b(context);
            String packageName = b4.getPackageName();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(packageName, DUService.class.getName()));
            intent.putExtra("apikey", str);
            b4.bindService(intent, serviceConnection, 1);
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int ul(int i10) {
        try {
            mContext.unregisterReceiver(f1698t);
        } catch (Exception unused) {
        }
        if (i10 != 0) {
            return -1;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("MTZiMjcx");
            aXZlZWNl(mContext, intent);
            Timer timer = f1699u;
            if (timer == null) {
                return -1;
            }
            timer.cancel();
            f1699u = null;
            return -1;
        } catch (Exception unused2) {
            return -1;
        }
    }

    public static int unResListener() {
        try {
            ((TelephonyManager) mContext.getSystemService("phone")).listen(f1682d, 0);
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static native String zZVTFJRA(Context context, String str);

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        try {
            onSSChanged(mContext, signalStrength);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }
}
