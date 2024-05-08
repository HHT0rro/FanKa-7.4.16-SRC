package cn.shuzilm.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.ProxyInfo;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.rtt.RangingRequest;
import android.net.wifi.rtt.RangingResult;
import android.net.wifi.rtt.RangingResultCallback;
import android.net.wifi.rtt.WifiRttManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.window.TaskConstants;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class dl {

    /* renamed from: b, reason: collision with root package name */
    private static Context f1730b;

    /* renamed from: c, reason: collision with root package name */
    private static NsdManager f1731c;

    /* renamed from: d, reason: collision with root package name */
    private static LinkedList f1732d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    private static JSONObject f1733e = new JSONObject();

    /* renamed from: f, reason: collision with root package name */
    private static JSONObject f1734f = null;

    /* renamed from: g, reason: collision with root package name */
    private static Timer f1735g = null;

    /* renamed from: h, reason: collision with root package name */
    private static int f1736h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static int f1737i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static String f1738j = "";

    /* renamed from: k, reason: collision with root package name */
    private static String f1739k = "";

    /* renamed from: l, reason: collision with root package name */
    private static String f1740l = "";

    /* renamed from: m, reason: collision with root package name */
    private static String f1741m = "";

    /* renamed from: n, reason: collision with root package name */
    private static int f1742n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static int f1743o = -1;

    /* renamed from: p, reason: collision with root package name */
    private static int f1744p = -1;

    /* renamed from: q, reason: collision with root package name */
    private static int f1745q = -1;

    /* renamed from: r, reason: collision with root package name */
    private static int f1746r = -1;

    /* renamed from: s, reason: collision with root package name */
    private static String f1747s = null;

    /* renamed from: t, reason: collision with root package name */
    private static String f1748t = null;

    /* renamed from: u, reason: collision with root package name */
    private static int f1749u = 0;

    /* renamed from: v, reason: collision with root package name */
    private static String f1750v = "";

    /* renamed from: a, reason: collision with root package name */
    public static int f1729a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class sd extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public NsdManager.DiscoveryListener f1757a;

        /* renamed from: b, reason: collision with root package name */
        public NsdManager f1758b;

        /* renamed from: c, reason: collision with root package name */
        public int f1759c;

        /* renamed from: d, reason: collision with root package name */
        public String f1760d;

        public sd(NsdManager nsdManager, NsdManager.DiscoveryListener discoveryListener, int i10, String str) {
            this.f1757a = discoveryListener;
            this.f1758b = nsdManager;
            this.f1759c = i10;
            this.f1760d = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            synchronized (this) {
                try {
                    dl.b(this.f1758b, this.f1757a);
                    if (this.f1759c == 2) {
                        int length = dl.f1734f.length();
                        if (dl.f1734f != null && length > 0 && dl.f1733e.length() + length < 4096) {
                            dl.f1733e.put(this.f1760d, dl.f1734f);
                        }
                    }
                    if (dl.f1732d != null && dl.f1732d.size() > 0 && (str = (String) dl.f1732d.poll()) != null) {
                        dl.c(str, 2);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Network network, String str, int i10) {
        InputStream inputStream;
        String str2;
        InputStream inputStream2 = null;
        try {
            URLConnection openConnection = network.openConnection(new URL(str));
            if (openConnection == null) {
                return null;
            }
            openConnection.setConnectTimeout(5000);
            openConnection.setReadTimeout(5000);
            openConnection.setDoInput(true);
            openConnection.connect();
            if (((HttpURLConnection) openConnection).getResponseCode() == 200) {
                inputStream = openConnection.getInputStream();
                try {
                    str2 = new String(aa.b(inputStream));
                    inputStream2 = inputStream;
                } catch (Throwable unused) {
                    if (inputStream == null) {
                        return null;
                    }
                    try {
                        inputStream.close();
                        return null;
                    } catch (Exception unused2) {
                        return null;
                    }
                }
            } else {
                str2 = null;
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused3) {
                }
            }
            return str2;
        } catch (Throwable unused4) {
            inputStream = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:8|9|10|11|12|(3:65|66|(1:68))|(6:63|64|(1:58)(4:27|28|29|30)|31|(1:34)|(1:41)(3:37|38|39))|19|20|21|(1:23)|58|31|(1:34)|(1:41)(1:42)) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c0, code lost:
    
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x002a, code lost:
    
        if (cn.shuzilm.core.dl.f1746r == 0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(final int r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 >= r1) goto L7
            return
        L7:
            int r0 = cn.shuzilm.core.dl.f1744p
            if (r0 == 0) goto Lc
            return
        Lc:
            r0 = 0
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch: java.lang.Throwable -> Lb3
            r2 = 2
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb3
            android.content.Context r2 = cn.shuzilm.core.dl.f1730b     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r3 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r3)     // Catch: java.lang.Throwable -> Lb3
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch: java.lang.Throwable -> Lb3
            r3 = 12
            r4 = 1
            java.lang.String r5 = "0"
            if (r8 != 0) goto L2c
            int r6 = cn.shuzilm.core.dl.f1745q     // Catch: java.lang.Throwable -> Lb4
            if (r6 != 0) goto L2c
            int r6 = cn.shuzilm.core.dl.f1746r     // Catch: java.lang.Throwable -> Lb4
            if (r6 == 0) goto L3c
        L2c:
            if (r8 != 0) goto L36
            int r6 = cn.shuzilm.core.dl.f1745q     // Catch: java.lang.Throwable -> Lb4
            if (r6 != 0) goto L36
            int r6 = cn.shuzilm.core.dl.f1743o     // Catch: java.lang.Throwable -> Lb4
            if (r6 == 0) goto L3c
        L36:
            if (r8 != r4) goto L57
            int r6 = cn.shuzilm.core.dl.f1745q     // Catch: java.lang.Throwable -> Lb4
            if (r6 != 0) goto L57
        L3c:
            android.net.NetworkRequest$Builder r6 = new android.net.NetworkRequest$Builder     // Catch: java.lang.Throwable -> Lb4
            r6.<init>()     // Catch: java.lang.Throwable -> Lb4
            android.net.NetworkRequest$Builder r6 = r6.addCapability(r3)     // Catch: java.lang.Throwable -> Lb4
            r7 = 0
            android.net.NetworkRequest$Builder r6 = r6.addTransportType(r7)     // Catch: java.lang.Throwable -> Lb4
            android.net.NetworkRequest r6 = r6.build()     // Catch: java.lang.Throwable -> Lb4
            cn.shuzilm.core.dl$4 r7 = new cn.shuzilm.core.dl$4     // Catch: java.lang.Throwable -> Lb4
            r7.<init>()     // Catch: java.lang.Throwable -> Lb4
            r2.requestNetwork(r6, r7)     // Catch: java.lang.Throwable -> Lb0
            goto L64
        L57:
            r1.countDown()     // Catch: java.lang.Throwable -> Lb4
            android.content.Context r6 = cn.shuzilm.core.dl.f1730b     // Catch: java.lang.Throwable -> Lb4
            r7 = 201(0xc9, float:2.82E-43)
            cn.shuzilm.core.DUHelper.c(r6, r7, r5)     // Catch: java.lang.Throwable -> Lb4
            cn.shuzilm.core.dl.f1747s = r5     // Catch: java.lang.Throwable -> Lb4
            r7 = r0
        L64:
            if (r8 != 0) goto L6e
            int r6 = cn.shuzilm.core.dl.f1743o     // Catch: java.lang.Throwable -> Lb0
            if (r6 != 0) goto L6e
            int r6 = cn.shuzilm.core.dl.f1746r     // Catch: java.lang.Throwable -> Lb0
            if (r6 == 0) goto L74
        L6e:
            if (r8 != r4) goto L91
            int r6 = cn.shuzilm.core.dl.f1746r     // Catch: java.lang.Throwable -> Lb0
            if (r6 != 0) goto L91
        L74:
            android.net.NetworkRequest$Builder r5 = new android.net.NetworkRequest$Builder     // Catch: java.lang.Throwable -> Lb0
            r5.<init>()     // Catch: java.lang.Throwable -> Lb0
            android.net.NetworkRequest$Builder r3 = r5.addCapability(r3)     // Catch: java.lang.Throwable -> Lb0
            android.net.NetworkRequest$Builder r3 = r3.addTransportType(r4)     // Catch: java.lang.Throwable -> Lb0
            android.net.NetworkRequest r3 = r3.build()     // Catch: java.lang.Throwable -> Lb0
            cn.shuzilm.core.dl$5 r4 = new cn.shuzilm.core.dl$5     // Catch: java.lang.Throwable -> Lb0
            r4.<init>()     // Catch: java.lang.Throwable -> Lb0
            r2.requestNetwork(r3, r4)     // Catch: java.lang.Throwable -> L8f
            r0 = r4
            goto L9d
        L8f:
            r0 = r4
            goto Lb0
        L91:
            r1.countDown()     // Catch: java.lang.Throwable -> Lb0
            android.content.Context r8 = cn.shuzilm.core.dl.f1730b     // Catch: java.lang.Throwable -> Lb0
            r3 = 202(0xca, float:2.83E-43)
            cn.shuzilm.core.DUHelper.c(r8, r3, r5)     // Catch: java.lang.Throwable -> Lb0
            cn.shuzilm.core.dl.f1748t = r5     // Catch: java.lang.Throwable -> Lb0
        L9d:
            r3 = 3600(0xe10, double:1.7786E-320)
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> Lb0
            r1.await(r3, r8)     // Catch: java.lang.Throwable -> Lb0
            if (r2 == 0) goto Lab
            if (r7 == 0) goto Lab
            r2.unregisterNetworkCallback(r7)     // Catch: java.lang.Exception -> Lc4
        Lab:
            if (r2 == 0) goto Lc4
            if (r0 == 0) goto Lc4
            goto Lc1
        Lb0:
            r8 = r0
            r0 = r7
            goto Lb5
        Lb3:
            r2 = r0
        Lb4:
            r8 = r0
        Lb5:
            if (r2 == 0) goto Lbc
            if (r0 == 0) goto Lbc
            r2.unregisterNetworkCallback(r0)     // Catch: java.lang.Exception -> Lc4
        Lbc:
            if (r2 == 0) goto Lc4
            if (r8 == 0) goto Lc4
            r0 = r8
        Lc1:
            r2.unregisterNetworkCallback(r0)     // Catch: java.lang.Exception -> Lc4
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.shuzilm.core.dl.b(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(NsdManager nsdManager, NsdManager.DiscoveryListener discoveryListener) {
        try {
            nsdManager.stopServiceDiscovery(discoveryListener);
        } catch (Throwable unused) {
        }
    }

    private static void b(String str, int i10) {
        NsdManager.RegistrationListener registrationListener;
        try {
            registrationListener = new NsdManager.RegistrationListener() { // from class: cn.shuzilm.core.dl.1
                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i11) {
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i11) {
                }
            };
            try {
                NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
                nsdServiceInfo.setServiceName(str);
                nsdServiceInfo.setServiceType(f1740l);
                nsdServiceInfo.setPort(i10);
                f1731c.registerService(nsdServiceInfo, 1, registrationListener);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            registrationListener = null;
        }
        try {
            f1731c.unregisterService(registrationListener);
        } catch (Throwable unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(int i10) {
        synchronized (dl.class) {
            if (aa.p(f1730b, "android.permission.CHANGE_NETWORK_STATE")) {
                r();
                b(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(String str, final int i10) {
        synchronized (dl.class) {
            try {
                NsdManager.DiscoveryListener discoveryListener = new NsdManager.DiscoveryListener() { // from class: cn.shuzilm.core.dl.2
                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onDiscoveryStarted(String str2) {
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onDiscoveryStopped(String str2) {
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
                        String serviceName = nsdServiceInfo.getServiceName();
                        String serviceType = nsdServiceInfo.getServiceType();
                        int i11 = i10;
                        if (i11 == 1) {
                            dl.c(serviceName, serviceType);
                        } else if (i11 == 2) {
                            dl.d(serviceName, serviceType);
                        }
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onStartDiscoveryFailed(String str2, int i11) {
                        dl.b(dl.f1731c, this);
                    }

                    @Override // android.net.nsd.NsdManager.DiscoveryListener
                    public void onStopDiscoveryFailed(String str2, int i11) {
                        dl.b(dl.f1731c, this);
                    }
                };
                f1734f = new JSONObject();
                f1731c.discoverServices(str, 1, discoveryListener);
                if (f1735g == null) {
                    f1735g = new Timer();
                }
                f1735g.schedule(new sd(f1731c, discoveryListener, i10, str), 500L);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(String str, String str2) {
        synchronized (dl.class) {
            try {
                if (str2.contains(".")) {
                    f1732d.add(str + "." + str2.split("\\.")[0] + ".");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(Context context, final String str) {
        Context applicationContext;
        if (f1729a > 0) {
            return;
        }
        try {
            applicationContext = context.getApplicationContext();
            f1730b = applicationContext;
        } catch (Exception unused) {
        }
        if (applicationContext == null) {
            return;
        }
        new Thread(new Runnable() { // from class: cn.shuzilm.core.dl.6
            /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
            @Override // java.lang.Runnable
            public synchronized void run() {
                try {
                    dl.f1729a++;
                    int f10 = dl.f();
                    if (aa.i(dl.f1730b) && dl.f1736h <= 0) {
                        String str2 = String.this;
                        String unused2 = dl.f1738j = (str2 == null || str2.length() <= 10) ? "a60c" : String.this.substring(2, 10).replace("-", "Z").replace("_", "l");
                        String unused3 = dl.f1739k = Integer.toHexString(dl.f1730b.getPackageName().hashCode());
                        dl.f(dl.g("h#TYch\"hY#TjYe"));
                        dl.p();
                        dl.m();
                    }
                    dl.c(1);
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception unused4) {
                    }
                    if (dl.f1733e.length() > 0) {
                        dl.f1733e.put("wrs", "" + f10);
                    }
                    if (dl.f1733e != null) {
                        dl.f1733e.put(com.kuaishou.weapon.p0.t.f36220e, dl.f1747s + "," + dl.f1748t + ";");
                    }
                    dl.n();
                } catch (Throwable unused5) {
                }
            }
        }).start();
        f1729a++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(String str, String str2) {
        synchronized (dl.class) {
            try {
                if (str2.equals(f1740l) && str != null && str.contains("-")) {
                    String[] split = str.split("-");
                    if (split.length >= 3) {
                        if ((split[1] + split[2]).equals(f1739k + f1738j)) {
                            f1737i = 1;
                        }
                    }
                }
                f1734f.put(String.valueOf(f1734f.length()), str);
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ int f() {
        return q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(String str) {
        LinkedList linkedList;
        try {
            f1740l = g("TV^geaVn#TiXe#");
            JSONObject jSONObject = f1733e;
            if (jSONObject != null && jSONObject.length() <= 0 && (linkedList = f1732d) != null && linkedList.size() <= 0) {
                f1731c = (NsdManager) f1730b.getSystemService("servicediscovery");
                c("_service" + str + ".", 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            bytes[i10] = (byte) (bytes[i10] + 11);
        }
        return new String(bytes);
    }

    public static synchronized void ia(Context context) {
        synchronized (dl.class) {
            f1730b = context;
            if (f1742n == 0) {
                f1744p = 0;
                f1741m = "";
            }
            c(1);
            f1742n++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        try {
            if (f1736h <= 0 && f1737i == 0) {
                f1736h = new Random().nextInt(20000) + TaskConstants.TASK_CHILD_LAYER_TASK_OVERLAY;
                String str = "z" + Long.toHexString(System.currentTimeMillis()) + "-" + f1739k + "-" + f1738j;
                b(str, f1736h);
                f1733e.put("sn", str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        DUHelper.bm(f1730b, f1733e.toString());
    }

    private static String o() {
        String str = "";
        if (Build.VERSION.SDK_INT < 23) {
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) f1730b.getSystemService("connectivity");
        LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
        if (linkProperties == null) {
            return "";
        }
        String interfaceName = linkProperties.getInterfaceName();
        if (interfaceName != null && interfaceName.contains("wlan")) {
            List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
            int size = linkAddresses.size();
            for (int i10 = 0; i10 < size; i10++) {
                String linkAddress = linkAddresses.get(i10).toString();
                if (linkAddress != null && linkAddress.contains(".") && !linkAddress.contains(com.huawei.openalliance.ad.constant.u.bD)) {
                    str = linkAddress.substring(0, linkAddress.lastIndexOf(".") + 1);
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        int i10;
        String o10;
        int p10;
        try {
            if ((System.currentTimeMillis() / 1000) - (f1730b.getPackageManager().getPackageInfo(f1730b.getPackageName(), 0).lastUpdateTime / 1000) < 2000) {
                i10 = 20;
                o10 = o();
                if ((o10 != null || o10 != "") && (p10 = aa.p(f1730b)) != 0) {
                    o10 = (p10 & 255) + "." + ((p10 >> 8) & 255) + "." + ((p10 >> 16) & 255) + ".";
                }
                if (o10 != null || o10 == "") {
                    return;
                }
                if (o10.lastIndexOf(".") == o10.length() - 1) {
                    for (int i11 = 1; i11 < i10; i11++) {
                        InetAddress.getByName(o10 + String.valueOf(i11)).isReachable(60);
                    }
                    return;
                }
                return;
            }
            o10 = o();
            if (o10 != null) {
            }
            o10 = (p10 & 255) + "." + ((p10 >> 8) & 255) + "." + ((p10 >> 16) & 255) + ".";
            if (o10 != null) {
                return;
            } else {
                return;
            }
        } catch (Exception unused) {
            return;
        }
        i10 = 256;
    }

    private static int q() {
        int size;
        if (DUHelper.mPopu == 10001) {
            return -6;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 28) {
            return -1;
        }
        PackageManager packageManager = f1730b.getPackageManager();
        String packageName = f1730b.getPackageName();
        int checkPermission = packageManager.checkPermission(com.kuaishou.weapon.p0.g.f36121g, packageName);
        int checkPermission2 = packageManager.checkPermission("android.permission.CHANGE_WIFI_STATE", packageName);
        int checkPermission3 = packageManager.checkPermission(com.kuaishou.weapon.p0.g.f36118d, packageName);
        if (checkPermission == 0 && checkPermission2 == 0 && checkPermission3 == 0) {
            if (i10 > 32 && packageManager.checkPermission("android.permission.NEARBY_WIFI_DEVICES", packageName) != 0) {
                return -2;
            }
            int maxPeers = RangingRequest.getMaxPeers();
            if (maxPeers <= 0) {
                return -1;
            }
            if (maxPeers > 2) {
                maxPeers--;
            }
            WifiRttManager wifiRttManager = (WifiRttManager) f1730b.getSystemService("wifirtt");
            if (!wifiRttManager.isAvailable() || !f1730b.getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                return -3;
            }
            WifiManager wifiManager = (WifiManager) f1730b.getSystemService("wifi");
            if (wifiManager.getWifiState() != 3) {
                return -3;
            }
            RangingRequest.Builder builder = new RangingRequest.Builder();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults == null || (size = scanResults.size()) <= 0) {
                return -4;
            }
            if (size < maxPeers) {
                maxPeers = size;
            }
            for (int i11 = 0; i11 < maxPeers; i11++) {
                builder.addAccessPoint(scanResults.get(i11));
            }
            wifiRttManager.startRanging(builder.build(), f1730b.getMainExecutor(), new RangingResultCallback() { // from class: cn.shuzilm.core.dl.3
                @Override // android.net.wifi.rtt.RangingResultCallback
                public void onRangingFailure(int i12) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        dl.f1733e.put("wr", currentTimeMillis + ";err_" + i12 + ";");
                    } catch (Exception unused) {
                    }
                }

                @Override // android.net.wifi.rtt.RangingResultCallback
                public void onRangingResults(List list) {
                    if (list == null) {
                        return;
                    }
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(System.currentTimeMillis() + ";");
                        for (int i12 = 0; i12 < list.size(); i12++) {
                            RangingResult rangingResult = (RangingResult) list.get(i12);
                            if (rangingResult.getStatus() == 0) {
                                try {
                                    Object invoke = rangingResult.getClass().getMethod(dl.g("\\ZiBVX6YYgZhh"), new Class[0]).invoke(rangingResult, new Object[0]);
                                    if (invoke != null) {
                                        sb2.append(invoke.toString().replace(com.huawei.openalliance.ad.constant.u.bD, ""));
                                    }
                                } catch (Throwable unused) {
                                }
                                sb2.append(",");
                                sb2.append(rangingResult.getDistanceMm() + "," + rangingResult.getRssi());
                                sb2.append(";");
                            }
                        }
                        dl.f1733e.put("wr", sb2.toString());
                    } catch (Throwable unused2) {
                    }
                }
            });
            return 0;
        }
        return -2;
    }

    private static void r() {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        boolean z10;
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) f1730b.getSystemService("phone");
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null) {
            simOperator = "";
        }
        try {
            if (telephonyManager.getSimState() == 5) {
                f1745q = 0;
            } else {
                f1745q = 1;
            }
        } catch (Exception unused) {
        }
        int p10 = aa.p(f1730b);
        if (p10 != 0) {
            f1746r = 0;
        } else {
            f1746r = 1;
        }
        try {
            connectivityManager = (ConnectivityManager) f1730b.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (activeNetwork == null) {
            f1744p = 1;
            f1747s = "0";
            f1748t = "0";
            DUHelper.c(f1730b, 201, "0");
            DUHelper.c(f1730b, 202, "0");
            return;
        }
        LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
        if (linkProperties == null) {
            return;
        }
        List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
        if (linkAddresses.isEmpty()) {
            f1744p = 1;
        } else {
            StringBuilder sb2 = new StringBuilder();
            Iterator<LinkAddress> iterator2 = linkAddresses.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    z10 = false;
                    break;
                }
                String hostAddress = iterator2.next().getAddress().getHostAddress();
                sb2.append(hostAddress);
                if (!f1741m.isEmpty() && f1741m.contains(hostAddress)) {
                    f1744p = 1;
                    z10 = true;
                    break;
                }
            }
            if (f1741m.isEmpty()) {
                f1741m = sb2.toString();
                f1744p = 0;
            }
            if (!z10 && !f1741m.isEmpty()) {
                f1741m = sb2.toString();
                f1744p = 0;
            }
        }
        ProxyInfo httpProxy = linkProperties.getHttpProxy();
        if (httpProxy != null) {
            if (httpProxy.getHost() != null) {
                f1743o = 0;
            } else {
                f1743o = 1;
            }
        }
        if (!f1750v.isEmpty() && !f1750v.equals(simOperator)) {
            f1744p = 0;
        }
        f1750v = simOperator;
        int i10 = f1749u;
        if (i10 != 0 && i10 != p10) {
            f1744p = 0;
        }
        f1749u = p10;
    }
}
