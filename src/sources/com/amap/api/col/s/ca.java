package com.amap.api.col.s;

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
public final class ca {
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
    private static int U = -1;
    private static boolean V = false;
    private static volatile b W = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f7414a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f7415b = "";

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f7416c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f7417d = false;

    /* renamed from: e, reason: collision with root package name */
    public static String f7418e = "";

    /* renamed from: f, reason: collision with root package name */
    public static boolean f7419f = false;

    /* renamed from: g, reason: collision with root package name */
    public static a f7420g = null;

    /* renamed from: h, reason: collision with root package name */
    public static int f7421h = -1;

    /* renamed from: i, reason: collision with root package name */
    public static String f7422i = "";

    /* renamed from: j, reason: collision with root package name */
    public static String f7423j = "";

    /* renamed from: k, reason: collision with root package name */
    private static String f7424k = null;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f7425l = false;

    /* renamed from: m, reason: collision with root package name */
    private static String f7426m = "";

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f7427n = false;

    /* renamed from: o, reason: collision with root package name */
    private static String f7428o = "";

    /* renamed from: p, reason: collision with root package name */
    private static boolean f7429p = false;

    /* renamed from: q, reason: collision with root package name */
    private static String f7430q = null;

    /* renamed from: r, reason: collision with root package name */
    private static IBinder f7431r = null;

    /* renamed from: s, reason: collision with root package name */
    private static boolean f7432s = false;

    /* renamed from: t, reason: collision with root package name */
    private static boolean f7433t = false;

    /* renamed from: u, reason: collision with root package name */
    private static String f7434u = "";

    /* renamed from: v, reason: collision with root package name */
    private static String f7435v = "";

    /* renamed from: w, reason: collision with root package name */
    private static boolean f7436w = false;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f7437x = false;

    /* renamed from: y, reason: collision with root package name */
    private static String f7438y = "";

    /* renamed from: z, reason: collision with root package name */
    private static boolean f7439z;

    /* compiled from: DeviceInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        dz a(byte[] bArr, Map<String, String> map);

        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Map<String, String> b();
    }

    /* compiled from: DeviceInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Context f7442a;

        /* renamed from: b, reason: collision with root package name */
        private static BroadcastReceiver f7443b;

        /* renamed from: c, reason: collision with root package name */
        private static ConnectivityManager f7444c;

        /* renamed from: d, reason: collision with root package name */
        private static NetworkRequest f7445d;

        /* renamed from: e, reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f7446e;

        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || f7443b != null) {
                    return;
                }
                f7443b = new BroadcastReceiver() { // from class: com.amap.api.col.s.ca.b.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context2, Intent intent) {
                        if (ci.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                            ca.p();
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ci.c("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(f7443b, intentFilter);
                return;
            }
            if (ca.b(context, ci.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f7444c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f7444c = connectivityManager;
                if (connectivityManager != null) {
                    f7445d = new NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.amap.api.col.s.ca.b.2
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onAvailable(Network network) {
                            super.onAvailable(network);
                            ca.p();
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onLost(Network network) {
                            super.onLost(network);
                            ca.p();
                        }
                    };
                    f7446e = networkCallback;
                    f7444c.registerNetworkCallback(f7445d, networkCallback);
                    f7442a = context;
                }
            }
        }
    }

    /* compiled from: DeviceInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = ca.f7431r = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static int A(Context context) {
        if (V) {
            return U;
        }
        G(context);
        if (!b(context, ci.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return U;
        }
        TelephonyManager B2 = B(context);
        if (B2 == null) {
            return U;
        }
        int networkType = B2.getNetworkType();
        U = networkType;
        V = true;
        return networkType;
    }

    private static TelephonyManager B(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String C(Context context) {
        if (!f7416c) {
            return "";
        }
        String str = null;
        try {
            str = D(context);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            f7416c = false;
            return "";
        }
        try {
            byte[] bytes = ci.c("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
            return new String(cb.a(ci.c("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), cb.b(str), bytes), "UTF-8");
        } catch (Throwable unused2) {
            f7416c = false;
            return "";
        }
    }

    private static String D(Context context) {
        String str;
        try {
            str = E(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(ci.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(ce.a(ci.c("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String E(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        if (!b(context, ci.c("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            return "";
        }
        String a10 = ce.a(ci.c("LYW1hcF9kZXZpY2VfYWRpdQ"));
        String F2 = F(context);
        if (TextUtils.isEmpty(F2)) {
            return "";
        }
        File file = new File(F2 + File.separator + ci.c("KYmFja3Vwcw"), ci.c("MLmFkaXU"));
        if (file.exists() && file.canRead()) {
            if (file.length() == 0) {
                file.delete();
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, com.kuaishou.weapon.p0.t.f36226k);
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
            if (!TextUtils.isEmpty(str) && str.contains(ci.c("SIw")) && (split = str.split(ci.c("SIw"))) != null && split.length == 2 && TextUtils.equals(a10, split[0])) {
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

    private static String F(Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(ci.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(ci.c("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(ci.c("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(ci.c("DaXNSZW1vdmFibGU"), new Class[0]);
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

    private static synchronized b G(Context context) {
        synchronized (ca.class) {
            if (W == null) {
                if (context == null) {
                    return null;
                }
                b bVar = new b();
                W = bVar;
                bVar.a(context.getApplicationContext());
            }
            return W;
        }
    }

    public static String b() {
        try {
            if (!TextUtils.isEmpty(f7418e)) {
                return f7418e;
            }
            a aVar = f7420g;
            return aVar == null ? "" : aVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static a c() {
        return f7420g;
    }

    public static String d() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String m10 = m();
            return m10.length() < 5 ? "" : m10.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String e() {
        return "";
    }

    public static String e(final Context context) {
        if (f7429p) {
            return "";
        }
        if (!TextUtils.isEmpty(f7428o)) {
            return f7428o;
        }
        if (f7432s) {
            return f7428o;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ex.a().b(new ey() { // from class: com.amap.api.col.s.ca.2
                @Override // com.amap.api.col.s.ey
                public final void a() {
                    ca.v(context);
                    ca.q();
                }
            });
            return f7428o;
        }
        f7432s = true;
        return v(context);
    }

    public static String f() {
        return "";
    }

    public static String f(Context context) {
        String str;
        if (f7433t) {
            String str2 = f7414a;
            return str2 == null ? "" : str2;
        }
        try {
            str = f7414a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f7414a;
        }
        if (b(context, ci.c("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f7414a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(f7414a)) {
            f7433t = true;
            return f7414a;
        }
        try {
            String q10 = q(context);
            f7414a = q10;
            if (!TextUtils.isEmpty(q10)) {
                f7433t = true;
                return f7414a;
            }
        } catch (Throwable unused2) {
        }
        try {
            f7414a = r(context);
            f7433t = true;
        } catch (Throwable unused3) {
        }
        String str3 = f7414a;
        return str3 == null ? "" : str3;
    }

    public static String g() {
        return "";
    }

    public static String g(Context context) {
        TelephonyManager B2;
        if (B) {
            return A;
        }
        try {
            G(context);
            B2 = B(context);
        } catch (Throwable unused) {
        }
        if (B2 == null) {
            return A;
        }
        String networkOperator = B2.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            A = networkOperator.substring(3);
            B = true;
            return A;
        }
        B = true;
        return A;
    }

    public static String h() {
        return f7438y;
    }

    public static String[] i() {
        return new String[]{"", ""};
    }

    public static String j(Context context) {
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

    public static String k() {
        return D;
    }

    public static String l() {
        return "";
    }

    public static String l(Context context) {
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
                return TextUtils.isEmpty(k10) ? w(context) : k10;
            } catch (Throwable unused) {
                return k10;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static int m(Context context) {
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

    public static String m() {
        return "";
    }

    public static long n() {
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

    public static String o() {
        if (!TextUtils.isEmpty(M)) {
            return M;
        }
        String property = System.getProperty("os.arch");
        M = property;
        return property;
    }

    public static /* synthetic */ boolean q() {
        f7432s = true;
        return true;
    }

    private static String r(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (ci.a(context, com.kuaishou.weapon.p0.g.f36123i) && "mounted".equals(Environment.getExternalStorageState())) {
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

    private static String s(Context context) {
        try {
            if (!TextUtils.isEmpty(f7430q)) {
                return f7430q;
            }
            byte[] digest = MessageDigest.getInstance(ci.c("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                stringBuffer.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                f7430q = stringBuffer2;
            }
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String t(Context context) {
        try {
            Class<?> cls = Class.forName(ci.c("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(ci.c("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                f7428o = str;
                return str;
            }
        } catch (Throwable th) {
            dc.a(th, "oa", "xm");
            f7429p = true;
        }
        return f7428o;
    }

    private static String u(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(ci.c("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= columnCount) {
                            break;
                        }
                        if (ci.c("IdmFsdWU").equals(query.getColumnName(i10))) {
                            f7428o = query.getString(i10);
                            break;
                        }
                        i10++;
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            f7429p = true;
            dc.a(th, "oa", ADEvent.VIVO);
        }
        return f7428o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String v(Context context) {
        String c4 = ci.c("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!c4.equalsIgnoreCase(str)) {
            String c10 = ci.c("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!c10.equalsIgnoreCase(str2) && !ci.c("IUkVETUk=").equalsIgnoreCase(str) && !ci.c("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (!ci.c("Idml2bw").equalsIgnoreCase(str) && !ci.c("Idml2bw").equalsIgnoreCase(str2)) {
                    if (!ci.c("IaHVhd2Vp").equalsIgnoreCase(str) && !ci.c("IaHVhd2Vp").equalsIgnoreCase(str2) && !ci.c("ISE9OT1I=").equalsIgnoreCase(str)) {
                        if (!ci.c("Mc2Ftc3VuZw").equalsIgnoreCase(str) && !ci.c("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                            if (!ci.c("IT1BQTw").equalsIgnoreCase(str) && !ci.c("IT1BQTw").equalsIgnoreCase(str2) && !ci.c("MT25lUGx1cw").equalsIgnoreCase(str) && !ci.c("MT25lUGx1cw").equalsIgnoreCase(str2) && !ci.c("IUkVBTE1F").equalsIgnoreCase(str2)) {
                                f7429p = true;
                                return f7428o;
                            }
                            return a(context, 5);
                        }
                        return a(context, 4);
                    }
                    return a(context, 2);
                }
                return u(context);
            }
        }
        return t(context);
    }

    private static String w(Context context) {
        if (!TextUtils.isEmpty(H)) {
            return H;
        }
        try {
            String b4 = di.b(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(b4)) {
                H = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor a10 = di.a(context, "open_common");
                di.a(a10, "a1", ci.b(H));
                di.a(a10);
            } else {
                H = ci.c(b4);
            }
            return H;
        } catch (Throwable unused) {
            return H;
        }
    }

    private static String x(Context context) {
        if (R) {
            return Q;
        }
        G(context);
        if (!b(context, ci.c("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return Q;
        }
        TelephonyManager B2 = B(context);
        if (B2 == null) {
            return Q;
        }
        String simOperatorName = B2.getSimOperatorName();
        Q = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            Q = B2.getNetworkOperatorName();
        }
        R = true;
        return Q;
    }

    private static int y(Context context) {
        if (T) {
            return S;
        }
        G(context);
        if (context != null && b(context, ci.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            ConnectivityManager z10 = z(context);
            if (z10 == null) {
                return S;
            }
            NetworkInfo activeNetworkInfo = z10.getActiveNetworkInfo();
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

    private static ConnectivityManager z(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static int c(Context context) {
        try {
            return A(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static int h(Context context) {
        try {
            return A(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int i(Context context) {
        try {
            return y(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String k(Context context) {
        ConnectivityManager z10;
        NetworkInfo activeNetworkInfo;
        try {
            return (!b(context, ci.c("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (z10 = z(context)) == null || (activeNetworkInfo = z10.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void p() {
        S = -1;
        T = false;
        U = -1;
        V = false;
        Q = "";
        R = false;
        A = "";
        B = false;
    }

    private static String q(Context context) {
        try {
            String b4 = di.b(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(b4) ? di.b(context, "Alvin2", "UTDID", "") : b4;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a() {
        return f7424k;
    }

    public static void a(a aVar) {
        if (f7420g == null) {
            f7420g = aVar;
        }
    }

    public static String b(Context context) {
        try {
            return x(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String o(Context context) {
        try {
            if (TextUtils.isEmpty(f7426m)) {
                f7426m = cp.a(context);
            }
        } catch (Throwable unused) {
        }
        return f7426m;
    }

    public static String a(final Context context) {
        if (!TextUtils.isEmpty(f7415b)) {
            return f7415b;
        }
        if (context == null) {
            return "";
        }
        String C2 = C(context);
        f7415b = C2;
        if (!TextUtils.isEmpty(C2)) {
            return f7415b;
        }
        if (c() == null || f7427n) {
            return "";
        }
        f7427n = true;
        ex.a().b(new ey() { // from class: com.amap.api.col.s.ca.1
            @Override // com.amap.api.col.s.ey
            public final void a() {
                try {
                    Map<String, String> b4 = ca.f7420g.b();
                    String a10 = ca.f7420g.a(ca.f(context), "", "", ca.m());
                    if (TextUtils.isEmpty(a10)) {
                        return;
                    }
                    dt.a();
                    String a11 = ca.f7420g.a(context, new String(dt.a(ca.f7420g.a(a10.getBytes(), b4)).f7866a));
                    if (TextUtils.isEmpty(a11)) {
                        return;
                    }
                    ca.f7415b = a11;
                } catch (Throwable unused) {
                }
            }
        });
        return "";
    }

    public static int d(Context context) {
        try {
            return y(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String n(Context context) {
        try {
            return x(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String j() {
        return f7422i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.ca.a(android.content.Context, int):java.lang.String");
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
