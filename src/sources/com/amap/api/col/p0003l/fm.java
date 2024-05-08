package com.amap.api.col.p0003l;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.hailiang.advlib.core.ADEvent;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.kuaishou.weapon.p0.g;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DeviceInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fm {
    private static String A = "";
    private static boolean B = false;
    private static String C = "";
    private static String D = "";
    private static String E = "";
    private static boolean F = false;
    private static boolean G = false;
    private static String H = "";
    private static boolean I = false;
    private static boolean J = false;
    private static long K = 0;
    private static int L = 0;
    private static String M = null;
    private static String N = "";
    private static boolean O = true;
    private static boolean P = false;
    private static String Q = "";
    private static boolean R = false;
    private static int S = -1;
    private static boolean T = false;
    private static Object U = null;
    private static int V = -1;
    private static boolean W = false;
    private static volatile b X = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f5859a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f5860b = "";

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f5861c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f5862d = false;

    /* renamed from: e, reason: collision with root package name */
    public static String f5863e = "";

    /* renamed from: f, reason: collision with root package name */
    public static boolean f5864f = false;

    /* renamed from: g, reason: collision with root package name */
    public static a f5865g = null;

    /* renamed from: h, reason: collision with root package name */
    public static int f5866h = -1;

    /* renamed from: i, reason: collision with root package name */
    public static String f5867i = "";

    /* renamed from: j, reason: collision with root package name */
    public static String f5868j = "";

    /* renamed from: k, reason: collision with root package name */
    private static String f5869k = null;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f5870l = false;

    /* renamed from: m, reason: collision with root package name */
    private static String f5871m = "";

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f5872n = false;

    /* renamed from: o, reason: collision with root package name */
    private static String f5873o = "";

    /* renamed from: p, reason: collision with root package name */
    private static boolean f5874p = false;

    /* renamed from: q, reason: collision with root package name */
    private static String f5875q = null;

    /* renamed from: r, reason: collision with root package name */
    private static IBinder f5876r = null;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f5877s = false;

    /* renamed from: t, reason: collision with root package name */
    private static boolean f5878t = false;

    /* renamed from: u, reason: collision with root package name */
    private static String f5879u = "";

    /* renamed from: v, reason: collision with root package name */
    private static String f5880v = "";

    /* renamed from: w, reason: collision with root package name */
    private static boolean f5881w = false;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f5882x = false;

    /* renamed from: y, reason: collision with root package name */
    private static String f5883y = "";

    /* renamed from: z, reason: collision with root package name */
    private static boolean f5884z;

    /* compiled from: DeviceInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        id a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* compiled from: DeviceInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Context f5887a;

        /* renamed from: b, reason: collision with root package name */
        private static BroadcastReceiver f5888b;

        /* renamed from: c, reason: collision with root package name */
        private static ConnectivityManager f5889c;

        /* renamed from: d, reason: collision with root package name */
        private static NetworkRequest f5890d;

        /* renamed from: e, reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f5891e;

        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || f5888b != null) {
                    return;
                }
                f5888b = new BroadcastReceiver() { // from class: com.amap.api.col.3l.fm.b.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context2, Intent intent) {
                        if (fv.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                            fm.q();
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(fv.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(f5888b, intentFilter);
                return;
            }
            if (fm.b(context, fv.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f5889c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f5889c = connectivityManager;
                if (connectivityManager != null) {
                    f5890d = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
                    ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.amap.api.col.3l.fm.b.2
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onAvailable(Network network) {
                            super.onAvailable(network);
                            fm.q();
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onLost(Network network) {
                            super.onLost(network);
                            fm.q();
                        }
                    };
                    f5891e = networkCallback;
                    f5889c.registerNetworkCallback(f5890d, networkCallback);
                    f5887a = context;
                }
            }
        }
    }

    /* compiled from: DeviceInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = fm.f5876r = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String A(Context context) {
        String c4 = fv.c("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!c4.equalsIgnoreCase(str)) {
            String c10 = fv.c("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!c10.equalsIgnoreCase(str2) && !fv.c("IUkVETUk=").equalsIgnoreCase(str) && !fv.c("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (!fv.c("Idml2bw").equalsIgnoreCase(str) && !fv.c("Idml2bw").equalsIgnoreCase(str2)) {
                    if (!fv.c("IaHVhd2Vp").equalsIgnoreCase(str) && !fv.c("IaHVhd2Vp").equalsIgnoreCase(str2) && !fv.c("ISE9OT1I=").equalsIgnoreCase(str)) {
                        if (!fv.c("Mc2Ftc3VuZw").equalsIgnoreCase(str) && !fv.c("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                            if (!fv.c("IT1BQTw").equalsIgnoreCase(str) && !fv.c("IT1BQTw").equalsIgnoreCase(str2) && !fv.c("MT25lUGx1cw").equalsIgnoreCase(str) && !fv.c("MT25lUGx1cw").equalsIgnoreCase(str2) && !fv.c("IUkVBTE1F").equalsIgnoreCase(str2)) {
                                f5874p = true;
                                return f5873o;
                            }
                            return a(context, 5);
                        }
                        return a(context, 4);
                    }
                    return a(context, 2);
                }
                return z(context);
            }
        }
        return y(context);
    }

    private static String B(Context context) {
        if (!TextUtils.isEmpty(H)) {
            return H;
        }
        try {
            String b4 = hl.b(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(b4)) {
                H = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor a10 = hl.a(context, "open_common");
                hl.a(a10, "a1", fv.b(H));
                hl.a(a10);
            } else {
                H = fv.c(b4);
            }
            return H;
        } catch (Throwable unused) {
            return H;
        }
    }

    private static String C(Context context) {
        if (R) {
            return Q;
        }
        L(context);
        TelephonyManager G2 = G(context);
        if (G2 == null) {
            return Q;
        }
        String simOperatorName = G2.getSimOperatorName();
        Q = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            Q = G2.getNetworkOperatorName();
        }
        R = true;
        return Q;
    }

    private static int D(Context context) {
        if (T) {
            return S;
        }
        L(context);
        if (context != null && b(context, fv.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            ConnectivityManager E2 = E(context);
            if (E2 == null) {
                return S;
            }
            NetworkInfo activeNetworkInfo = E2.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                T = true;
                return S;
            }
            int type = activeNetworkInfo.getType();
            S = type;
            T = true;
            return type;
        }
        return S;
    }

    private static ConnectivityManager E(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static int F(Context context) {
        if (W) {
            return V;
        }
        L(context);
        if (!b(context, fv.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return V;
        }
        ConnectivityManager E2 = E(context);
        if (E2 == null) {
            return V;
        }
        NetworkInfo activeNetworkInfo = E2.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            V = activeNetworkInfo.getSubtype();
            W = true;
        }
        return V;
    }

    private static TelephonyManager G(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String H(Context context) {
        if (!f5861c) {
            return "";
        }
        String str = null;
        try {
            str = I(context);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            f5861c = false;
            return "";
        }
        try {
            byte[] bytes = fv.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(fn.a(fv.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), fn.b(str), bytes), "UTF-8");
        } catch (Throwable unused2) {
            f5861c = false;
            return "";
        }
    }

    private static String I(Context context) {
        String str;
        try {
            str = J(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(fv.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(fq.b(fv.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String J(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        if (!b(context, fv.c("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            return "";
        }
        String b4 = fq.b(fv.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String K2 = K(context);
        if (TextUtils.isEmpty(K2)) {
            return "";
        }
        File file = new File(K2 + File.separator + fv.c("KYmFja3Vwcw"), fv.c("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, t.f36226k);
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = randomAccessFile.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (Throwable unused) {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            a(byteArrayOutputStream2);
                            a(randomAccessFile);
                            return "";
                        }
                    }
                    str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                randomAccessFile = null;
            }
            if (!TextUtils.isEmpty(str) && str.contains(fv.c("SIw")) && (split = str.split(fv.c("SIw"))) != null && split.length == 2 && TextUtils.equals(b4, split[0])) {
                String str2 = split[1];
                a(byteArrayOutputStream);
                a(randomAccessFile);
                return str2;
            }
            a(byteArrayOutputStream);
            a(randomAccessFile);
        }
        return "";
    }

    private static String K(Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(fv.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(fv.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(fv.c("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(fv.c("DaXNSZW1vdmFibGU"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = Array.get(invoke, i10);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static synchronized b L(Context context) {
        synchronized (fm.class) {
            if (X == null) {
                if (context == null) {
                    return null;
                }
                b bVar = new b();
                X = bVar;
                bVar.a(context.getApplicationContext());
            }
            return X;
        }
    }

    public static String b() {
        try {
            if (!TextUtils.isEmpty(f5863e)) {
                return f5863e;
            }
            a aVar = f5865g;
            return aVar == null ? "" : aVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static a c() {
        return f5865g;
    }

    public static String d() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String n10 = n();
            return n10.length() < 5 ? "" : n10.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String e() {
        return "";
    }

    public static String e(final Context context) {
        if (f5874p) {
            return "";
        }
        if (!TextUtils.isEmpty(f5873o)) {
            return f5873o;
        }
        if (f5877s) {
            return f5873o;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            jd.a().a(new je() { // from class: com.amap.api.col.3l.fm.2
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    fm.A(context);
                    fm.r();
                }
            });
            return f5873o;
        }
        f5877s = true;
        return A(context);
    }

    public static String f() {
        return "";
    }

    public static String f(Context context) {
        String str;
        if (f5878t) {
            String str2 = f5859a;
            return str2 == null ? "" : str2;
        }
        try {
            str = f5859a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f5859a;
        }
        if (b(context, fv.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f5859a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(f5859a)) {
            f5878t = true;
            return f5859a;
        }
        try {
            String v2 = v(context);
            f5859a = v2;
            if (!TextUtils.isEmpty(v2)) {
                f5878t = true;
                return f5859a;
            }
        } catch (Throwable unused2) {
        }
        try {
            f5859a = w(context);
            f5878t = true;
        } catch (Throwable unused3) {
        }
        String str3 = f5859a;
        return str3 == null ? "" : str3;
    }

    public static String g() {
        return "";
    }

    public static String g(Context context) {
        try {
            TelephonyManager G2 = G(context);
            if (G2 == null) {
                return "";
            }
            String networkOperator = G2.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                return networkOperator.substring(0, 3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String h() {
        return f5883y;
    }

    public static String[] i() {
        return new String[]{"", ""};
    }

    public static int j(Context context) {
        try {
            return D(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static NetworkInfo k(Context context) {
        ConnectivityManager E2;
        if (b(context, fv.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (E2 = E(context)) != null) {
            return E2.getActiveNetworkInfo();
        }
        return null;
    }

    public static String l(Context context) {
        try {
            NetworkInfo k10 = k(context);
            if (k10 == null) {
                return null;
            }
            return k10.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String m() {
        return "";
    }

    public static String m(Context context) {
        String str;
        String str2;
        try {
            str = C;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return C;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        if (i11 > i10) {
            str2 = i10 + StringUtils.NO_PRINT_CODE + i11;
        } else {
            str2 = i11 + StringUtils.NO_PRINT_CODE + i10;
        }
        C = str2;
        return C;
    }

    public static String n() {
        return "";
    }

    public static String n(Context context) {
        try {
            if (!b(context, fv.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return N;
            }
            TelephonyManager G2 = G(context);
            return G2 == null ? "" : G2.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long o() {
        long j10 = K;
        if (j10 != 0) {
            return j10;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            K = ((statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576) + ((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576);
        } catch (Throwable unused) {
        }
        return K;
    }

    public static String p(Context context) {
        try {
            String k10 = k();
            try {
                if (TextUtils.isEmpty(k10)) {
                    k10 = a(context);
                }
                if (TextUtils.isEmpty(k10)) {
                    k10 = f(context);
                }
                if (TextUtils.isEmpty(k10)) {
                    k10 = e(context);
                }
                if (TextUtils.isEmpty(k10)) {
                    k10 = g();
                }
                return TextUtils.isEmpty(k10) ? B(context) : k10;
            } catch (Throwable unused) {
                return k10;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String q(Context context) {
        return k() + "#" + a(context) + "#" + p(context);
    }

    public static /* synthetic */ boolean r() {
        f5877s = true;
        return true;
    }

    public static String s(Context context) {
        try {
            return C(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String t(Context context) {
        try {
            if (TextUtils.isEmpty(f5871m)) {
                f5871m = gc.a(context);
            }
        } catch (Throwable unused) {
        }
        return f5871m;
    }

    private static String v(Context context) {
        try {
            String b4 = hl.b(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(b4) ? hl.b(context, "Alvin2", "UTDID", "") : b4;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String w(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (fv.a(context, g.f36123i) && "mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser newPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z10 = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z10 = false;
                            } else if (eventType == 4 && z10) {
                                String text = newPullParser.getText();
                                try {
                                    fileInputStream2.close();
                                } catch (Throwable unused) {
                                }
                                return text;
                            }
                        } else if (newPullParser.getAttributeCount() > 0) {
                            int attributeCount = newPullParser.getAttributeCount();
                            for (int i10 = 0; i10 < attributeCount; i10++) {
                                String attributeValue = newPullParser.getAttributeValue(i10);
                                if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                                    z10 = true;
                                }
                            }
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                        return "";
                    }
                    fileInputStream.close();
                }
            }
            if (fileInputStream == null) {
                return "";
            }
        } catch (Throwable unused3) {
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused4) {
            return "";
        }
    }

    private static String x(Context context) {
        try {
            if (!TextUtils.isEmpty(f5875q)) {
                return f5875q;
            }
            byte[] digest = MessageDigest.getInstance(fv.c("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                stringBuffer.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                f5875q = stringBuffer2;
            }
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String y(Context context) {
        try {
            Class<?> cls = Class.forName(fv.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(fv.c("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                f5873o = str;
                return str;
            }
        } catch (Throwable th) {
            gv.a(th, "oa", "xm");
            f5874p = true;
        }
        return f5873o;
    }

    private static String z(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(fv.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= columnCount) {
                            break;
                        }
                        if (fv.c("IdmFsdWU").equals(query.getColumnName(i10))) {
                            f5873o = query.getString(i10);
                            break;
                        }
                        i10++;
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            f5874p = true;
            gv.a(th, "oa", ADEvent.VIVO);
        }
        return f5873o;
    }

    public static int c(Context context) {
        try {
            return F(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String h(Context context) {
        TelephonyManager G2;
        if (B) {
            return A;
        }
        try {
            L(context);
            G2 = G(context);
        } catch (Throwable unused) {
        }
        if (G2 == null) {
            return A;
        }
        String networkOperator = G2.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            A = networkOperator.substring(3);
            B = true;
            return A;
        }
        B = true;
        return A;
    }

    public static int i(Context context) {
        try {
            return F(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String j() {
        return f5867i;
    }

    public static void q() {
        S = -1;
        T = false;
        V = -1;
        W = false;
        Q = "";
        R = false;
        A = "";
        B = false;
    }

    public static int r(Context context) {
        int i10 = L;
        if (i10 != 0) {
            return i10;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i11 = ((int) (memoryInfo.totalMem / 1024)) / 1024;
        L = i11;
        return i11;
    }

    public static void a(String str) {
        f5869k = str;
    }

    public static void l() {
        try {
            gu.a();
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        return f5869k;
    }

    public static String k() {
        return D;
    }

    public static void a(a aVar) {
        if (f5865g == null) {
            f5865g = aVar;
        }
    }

    public static String b(Context context) {
        try {
            return C(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int d(Context context) {
        try {
            return D(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String a(final Context context) {
        if (!TextUtils.isEmpty(f5860b)) {
            return f5860b;
        }
        if (context == null) {
            return "";
        }
        String H2 = H(context);
        f5860b = H2;
        if (!TextUtils.isEmpty(H2)) {
            return f5860b;
        }
        if (c() == null || f5872n) {
            return "";
        }
        f5872n = true;
        jd.a().a(new je() { // from class: com.amap.api.col.3l.fm.1
            @Override // com.amap.api.col.p0003l.je
            public final void runTask() {
                try {
                    Map<String, String> b4 = fm.f5865g.b();
                    String a10 = fm.f5865g.a(fm.f(context), "", "", fm.n());
                    if (TextUtils.isEmpty(a10)) {
                        return;
                    }
                    hw.a();
                    String a11 = fm.f5865g.a(context, new String(hw.a(fm.f5865g.a(a10.getBytes(), b4)).f6444a));
                    if (TextUtils.isEmpty(a11)) {
                        return;
                    }
                    fm.f5860b = a11;
                } catch (Throwable unused) {
                }
            }
        });
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String o(Context context) {
        ConnectivityManager E2;
        NetworkInfo activeNetworkInfo;
        try {
            return (!b(context, fv.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (E2 = E(context)) == null || (activeNetworkInfo = E2.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String p() {
        if (!TextUtils.isEmpty(M)) {
            return M;
        }
        String property = System.getProperty("os.arch");
        M = property;
        return property;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r12, int r13) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.fm.a(android.content.Context, int):java.lang.String");
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
