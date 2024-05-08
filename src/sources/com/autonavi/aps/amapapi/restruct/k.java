package com.autonavi.aps.amapapi.restruct;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003l.ks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* compiled from: WifiManagerWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static long f9492d;

    /* renamed from: e, reason: collision with root package name */
    public static long f9493e;

    /* renamed from: f, reason: collision with root package name */
    public static long f9494f;

    /* renamed from: g, reason: collision with root package name */
    public static long f9495g;

    /* renamed from: h, reason: collision with root package name */
    public static long f9496h;

    /* renamed from: v, reason: collision with root package name */
    public static HashMap<String, Long> f9497v = new HashMap<>(36);

    /* renamed from: w, reason: collision with root package name */
    public static long f9498w = 0;

    /* renamed from: x, reason: collision with root package name */
    public static int f9499x = 0;

    /* renamed from: z, reason: collision with root package name */
    public static long f9500z = 0;
    private com.autonavi.aps.amapapi.c E;

    /* renamed from: a, reason: collision with root package name */
    public WifiManager f9501a;

    /* renamed from: i, reason: collision with root package name */
    public Context f9504i;

    /* renamed from: t, reason: collision with root package name */
    public i f9515t;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<ks> f9502b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<ks> f9503c = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public boolean f9505j = false;

    /* renamed from: k, reason: collision with root package name */
    public StringBuilder f9506k = null;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9507l = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9508m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9509n = true;
    private volatile j B = null;

    /* renamed from: o, reason: collision with root package name */
    public String f9510o = null;

    /* renamed from: p, reason: collision with root package name */
    public TreeMap<Integer, ks> f9511p = null;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9512q = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f9513r = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9514s = false;
    private String C = "";

    /* renamed from: u, reason: collision with root package name */
    public long f9516u = 0;

    /* renamed from: y, reason: collision with root package name */
    public ConnectivityManager f9517y = null;
    private long D = 30000;
    public volatile boolean A = false;

    public k(Context context, WifiManager wifiManager, Handler handler) {
        this.f9501a = wifiManager;
        this.f9504i = context;
        i iVar = new i(context, "wifiAgee", handler);
        this.f9515t = iVar;
        iVar.a();
    }

    private void A() {
        try {
            if (com.autonavi.aps.amapapi.utils.j.c(this.f9504i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.f9513r = this.f9501a.isWifiEnabled();
            }
        } catch (Throwable unused) {
            com.autonavi.aps.amapapi.utils.d.b();
        }
    }

    private boolean B() {
        this.f9512q = v();
        A();
        if (this.f9512q && this.f9507l) {
            if (f9494f == 0) {
                return true;
            }
            if (com.autonavi.aps.amapapi.utils.j.b() - f9494f >= 4900 && com.autonavi.aps.amapapi.utils.j.b() - f9495g >= 1500) {
                com.autonavi.aps.amapapi.utils.j.b();
                return true;
            }
        }
        return false;
    }

    public static long b() {
        return ((com.autonavi.aps.amapapi.utils.j.b() - f9498w) / 1000) + 1;
    }

    public static String p() {
        return String.valueOf(com.autonavi.aps.amapapi.utils.j.b() - f9495g);
    }

    private List<ks> r() {
        List<ScanResult> list;
        if (this.f9501a != null) {
            try {
                if (com.autonavi.aps.amapapi.utils.j.c(this.f9504i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    list = this.f9501a.getScanResults();
                } else {
                    com.autonavi.aps.amapapi.utils.b.a(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    list = null;
                }
                HashMap<String, Long> hashMap = new HashMap<>(36);
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                }
                if (f9497v.isEmpty() || !f9497v.equals(hashMap)) {
                    f9497v = hashMap;
                    f9498w = com.autonavi.aps.amapapi.utils.j.b();
                }
                this.f9510o = null;
                ArrayList arrayList = new ArrayList();
                this.C = "";
                this.B = m();
                if (a(this.B)) {
                    this.C = this.B.a();
                }
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        ScanResult scanResult2 = list.get(i10);
                        ks ksVar = new ks(!TextUtils.isEmpty(this.C) && this.C.equals(scanResult2.BSSID));
                        ksVar.f6686b = scanResult2.SSID;
                        ksVar.f6688d = scanResult2.frequency;
                        ksVar.f6689e = scanResult2.timestamp;
                        ksVar.f6685a = ks.a(scanResult2.BSSID);
                        ksVar.f6687c = (short) scanResult2.level;
                        short elapsedRealtime = (short) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                        ksVar.f6691g = elapsedRealtime;
                        if (elapsedRealtime < 0) {
                            ksVar.f6691g = (short) 0;
                        }
                        ksVar.f6690f = com.autonavi.aps.amapapi.utils.j.b();
                        arrayList.add(ksVar);
                    }
                }
                this.f9515t.a((List) arrayList);
                return arrayList;
            } catch (SecurityException e2) {
                this.f9510o = e2.getMessage();
            } catch (Throwable th) {
                this.f9510o = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private int s() {
        WifiManager wifiManager = this.f9501a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean t() {
        long b4 = com.autonavi.aps.amapapi.utils.j.b() - f9492d;
        if (b4 < 4900) {
            return false;
        }
        if (u() && b4 < 9900) {
            return false;
        }
        if (f9499x > 1) {
            long j10 = this.D;
            if (j10 == 30000) {
                j10 = com.autonavi.aps.amapapi.utils.a.o() != -1 ? com.autonavi.aps.amapapi.utils.a.o() : 30000L;
            }
            if (Build.VERSION.SDK_INT >= 28 && b4 < j10) {
                return false;
            }
        }
        if (this.f9501a != null) {
            f9492d = com.autonavi.aps.amapapi.utils.j.b();
            int i10 = f9499x;
            if (i10 < 2) {
                f9499x = i10 + 1;
            }
            if (com.autonavi.aps.amapapi.utils.j.c(this.f9504i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                return this.f9501a.startScan();
            }
            com.autonavi.aps.amapapi.utils.b.a(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        }
        return false;
    }

    private boolean u() {
        if (this.f9517y == null) {
            this.f9517y = (ConnectivityManager) com.autonavi.aps.amapapi.utils.j.a(this.f9504i, "connectivity");
        }
        return a(this.f9517y);
    }

    private boolean v() {
        if (this.f9501a == null) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.j.g(this.f9504i);
    }

    private void w() {
        if (B()) {
            long b4 = com.autonavi.aps.amapapi.utils.j.b();
            if (b4 - f9493e >= 10000) {
                this.f9502b.clear();
                f9496h = f9495g;
            }
            x();
            if (b4 - f9493e >= 10000) {
                for (int i10 = 20; i10 > 0 && f9495g == f9496h; i10--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void x() {
        if (B()) {
            try {
                if (t()) {
                    f9494f = com.autonavi.aps.amapapi.utils.j.b();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void y() {
        if (f9496h != f9495g) {
            List<ks> list = null;
            try {
                list = r();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "updateScanResult");
            }
            f9496h = f9495g;
            if (list != null) {
                this.f9502b.clear();
                this.f9502b.addAll(list);
            } else {
                this.f9502b.clear();
            }
        }
    }

    private void z() {
        int i10;
        try {
            if (this.f9501a == null) {
                return;
            }
            try {
                i10 = s();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "OPENSDK_WMW", "cwsc");
                i10 = 4;
            }
            if (this.f9502b == null) {
                this.f9502b = new ArrayList<>();
            }
            if (i10 == 0 || i10 == 1 || i10 == 4) {
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public final ArrayList<ks> a() {
        if (!this.f9514s) {
            return this.f9503c;
        }
        b(true);
        return this.f9503c;
    }

    public final WifiInfo c() {
        try {
            if (this.f9501a == null) {
                return null;
            }
            if (com.autonavi.aps.amapapi.utils.j.c(this.f9504i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                return this.f9501a.getConnectionInfo();
            }
            com.autonavi.aps.amapapi.utils.b.a(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
            return null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final String d() {
        return this.f9510o;
    }

    public final ArrayList<ks> e() {
        if (this.f9502b == null) {
            return null;
        }
        ArrayList<ks> arrayList = new ArrayList<>();
        if (!this.f9502b.isEmpty()) {
            arrayList.addAll(this.f9502b);
        }
        return arrayList;
    }

    public final void f() {
        try {
            this.f9514s = true;
            List<ks> r10 = r();
            if (r10 != null) {
                this.f9502b.clear();
                this.f9502b.addAll(r10);
            }
            d(true);
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        this.B = null;
        this.f9502b.clear();
    }

    public final void h() {
        f9500z = System.currentTimeMillis();
        com.autonavi.aps.amapapi.c cVar = this.E;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void i() {
        if (this.f9501a != null && com.autonavi.aps.amapapi.utils.j.b() - f9495g > 4900) {
            f9495g = com.autonavi.aps.amapapi.utils.j.b();
        }
    }

    public final void j() {
        if (this.f9501a == null) {
            return;
        }
        this.A = true;
    }

    public final boolean k() {
        return this.f9512q;
    }

    public final boolean l() {
        return this.f9513r;
    }

    public final j m() {
        A();
        if (!l()) {
            return null;
        }
        if (this.B == null) {
            new StringBuilder("getwifiAccess ").append((Object) this.B);
            this.B = new j(c());
        }
        return this.B;
    }

    public final boolean n() {
        return this.f9505j;
    }

    public final String o() {
        boolean z10;
        String str;
        StringBuilder sb2 = this.f9506k;
        if (sb2 == null) {
            this.f9506k = new StringBuilder(700);
        } else {
            sb2.delete(0, sb2.length());
        }
        this.f9505j = false;
        int size = this.f9502b.size();
        int i10 = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (i10 < size) {
            String a10 = ks.a(this.f9502b.get(i10).f6685a);
            if (!this.f9508m && !"<unknown ssid>".equals(this.f9502b.get(i10).f6686b)) {
                z11 = true;
            }
            if (TextUtils.isEmpty(this.C) || !this.C.equals(a10)) {
                z10 = z12;
                str = "nb";
            } else {
                str = "access";
                z10 = true;
            }
            this.f9506k.append(String.format(Locale.US, "#%s,%s", a10, str));
            i10++;
            z12 = z10;
        }
        if (this.f9502b.size() == 0) {
            z11 = true;
        }
        if (!this.f9508m && !z11) {
            this.f9505j = true;
        }
        if (!z12 && !TextUtils.isEmpty(this.C)) {
            StringBuilder sb3 = this.f9506k;
            sb3.append("#");
            sb3.append(this.C);
            this.f9506k.append(",access");
        }
        return this.f9506k.toString();
    }

    public final long q() {
        return this.f9516u;
    }

    private void d(boolean z10) {
        ArrayList<ks> arrayList = this.f9502b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (com.autonavi.aps.amapapi.utils.j.b() - f9495g > 3600000) {
            g();
        }
        if (this.f9511p == null) {
            this.f9511p = new TreeMap<>(Collections.reverseOrder());
        }
        this.f9511p.clear();
        if (this.f9514s && z10) {
            try {
                this.f9503c.clear();
            } catch (Throwable unused) {
            }
        }
        int size = this.f9502b.size();
        this.f9516u = 0L;
        for (int i10 = 0; i10 < size; i10++) {
            ks ksVar = this.f9502b.get(i10);
            if (ksVar.f6692h) {
                this.f9516u = ksVar.f6690f;
            }
            if (com.autonavi.aps.amapapi.utils.j.a(ks.a(ksVar.f6685a)) && (size <= 20 || a(ksVar.f6687c))) {
                if (this.f9514s && z10) {
                    this.f9503c.add(ksVar);
                }
                if (!TextUtils.isEmpty(ksVar.f6686b)) {
                    if (!"<unknown ssid>".equals(ksVar.f6686b)) {
                        ksVar.f6686b = String.valueOf(i10);
                    }
                } else {
                    ksVar.f6686b = "unkwn";
                }
                this.f9511p.put(Integer.valueOf((ksVar.f6687c * 25) + i10), ksVar);
            }
        }
        this.f9502b.clear();
        Iterator<ks> iterator2 = this.f9511p.values().iterator2();
        while (iterator2.hasNext()) {
            this.f9502b.add(iterator2.next());
        }
        this.f9511p.clear();
    }

    public final void b(boolean z10) {
        if (z10) {
            w();
        } else {
            x();
        }
        boolean z11 = false;
        if (this.A) {
            this.A = false;
            z();
        }
        y();
        if (com.autonavi.aps.amapapi.utils.j.b() - f9495g > 20000) {
            this.f9502b.clear();
        }
        f9493e = com.autonavi.aps.amapapi.utils.j.b();
        if (this.f9502b.isEmpty()) {
            f9495g = com.autonavi.aps.amapapi.utils.j.b();
            List<ks> r10 = r();
            if (r10 != null) {
                this.f9502b.addAll(r10);
                z11 = true;
            }
        }
        d(z11);
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        try {
            if (com.autonavi.aps.amapapi.utils.j.a(connectivityManager.getActiveNetworkInfo()) == 1) {
                return a(m());
            }
            return false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void c(boolean z10) {
        g();
        this.f9502b.clear();
        this.f9515t.a(z10);
    }

    public final void a(boolean z10) {
        Context context = this.f9504i;
        if (!com.autonavi.aps.amapapi.utils.a.n() || !this.f9509n || this.f9501a == null || context == null || !z10 || com.autonavi.aps.amapapi.utils.j.c() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) com.autonavi.aps.amapapi.utils.f.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                com.autonavi.aps.amapapi.utils.f.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public final boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean d10 = jVar.d();
        if (!d10 && v()) {
            g();
        }
        return d10;
    }

    public final void a(boolean z10, boolean z11, boolean z12, long j10) {
        this.f9507l = z10;
        this.f9508m = z11;
        this.f9509n = z12;
        if (j10 < 10000) {
            this.D = 10000L;
        } else {
            this.D = j10;
        }
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.E = cVar;
    }

    private static boolean a(int i10) {
        int i11 = 20;
        try {
            i11 = WifiManager.calculateSignalLevel(i10, 20);
        } catch (ArithmeticException e2) {
            com.autonavi.aps.amapapi.utils.b.a(e2, "Aps", "wifiSigFine");
        }
        return i11 > 0;
    }
}
