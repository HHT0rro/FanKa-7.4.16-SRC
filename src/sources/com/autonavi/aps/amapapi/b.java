package com.autonavi.aps.amapapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.WindowManager;
import com.amap.api.col.p0003l.fv;
import com.amap.api.col.p0003l.gy;
import com.amap.api.col.p0003l.ie;
import com.amap.api.col.p0003l.ks;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.g;
import com.autonavi.aps.amapapi.restruct.k;
import com.autonavi.aps.amapapi.trans.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: Aps.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {
    public static int A = -1;
    private static boolean K;
    public boolean F;
    private Handler N;
    private g O;
    private String P;
    private c R;
    public static String[] D = {com.kuaishou.weapon.p0.g.f36122h, com.kuaishou.weapon.p0.g.f36121g};
    public static String E = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static volatile boolean Q = false;

    /* renamed from: a, reason: collision with root package name */
    public Context f9317a = null;

    /* renamed from: b, reason: collision with root package name */
    public ConnectivityManager f9318b = null;

    /* renamed from: c, reason: collision with root package name */
    public k f9319c = null;

    /* renamed from: d, reason: collision with root package name */
    public e f9320d = null;

    /* renamed from: e, reason: collision with root package name */
    public com.autonavi.aps.amapapi.storage.a f9321e = null;

    /* renamed from: f, reason: collision with root package name */
    public com.autonavi.aps.amapapi.trans.e f9322f = null;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<ks> f9323g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public a f9324h = null;

    /* renamed from: i, reason: collision with root package name */
    public AMapLocationClientOption f9325i = new AMapLocationClientOption();

    /* renamed from: j, reason: collision with root package name */
    public com.autonavi.aps.amapapi.model.a f9326j = null;

    /* renamed from: k, reason: collision with root package name */
    public long f9327k = 0;
    private int I = 0;

    /* renamed from: l, reason: collision with root package name */
    public f f9328l = null;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9329m = false;
    private String J = null;

    /* renamed from: n, reason: collision with root package name */
    public com.autonavi.aps.amapapi.trans.c f9330n = null;

    /* renamed from: o, reason: collision with root package name */
    public StringBuilder f9331o = new StringBuilder();

    /* renamed from: p, reason: collision with root package name */
    public boolean f9332p = true;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9333q = true;

    /* renamed from: r, reason: collision with root package name */
    public AMapLocationClientOption.GeoLanguage f9334r = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9335s = true;

    /* renamed from: t, reason: collision with root package name */
    public boolean f9336t = false;
    private String L = null;

    /* renamed from: u, reason: collision with root package name */
    public StringBuilder f9337u = null;

    /* renamed from: v, reason: collision with root package name */
    public boolean f9338v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f9339w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f9340x = 12;
    private boolean M = true;

    /* renamed from: y, reason: collision with root package name */
    public com.autonavi.aps.amapapi.restruct.b f9341y = null;

    /* renamed from: z, reason: collision with root package name */
    public boolean f9342z = false;
    public com.autonavi.aps.amapapi.filters.a B = null;
    public String C = null;
    public IntentFilter G = null;
    public LocationManager H = null;

    /* compiled from: Aps.java */
    /* renamed from: com.autonavi.aps.amapapi.b$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9343a;

        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            f9343a = iArr;
            try {
                iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9343a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9343a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Aps.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            k kVar;
            k kVar2;
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    k kVar3 = b.this.f9319c;
                    if (kVar3 != null) {
                        kVar3.i();
                    }
                    try {
                        if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (kVar2 = b.this.f9319c) == null) {
                            return;
                        }
                        kVar2.h();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (!action.equals("android.net.wifi.WIFI_STATE_CHANGED") || (kVar = b.this.f9319c) == null) {
                    return;
                }
                kVar.j();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "onReceive");
            }
        }
    }

    public b(boolean z10) {
        this.F = z10;
    }

    private void k() {
        if (this.f9330n != null) {
            try {
                if (this.f9325i == null) {
                    this.f9325i = new AMapLocationClientOption();
                }
                this.f9330n.a(this.f9325i.getHttpTimeOut(), this.f9325i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), l());
            } catch (Throwable unused) {
            }
        }
    }

    private int l() {
        int i10;
        if (this.f9325i.getGeoLanguage() != null && (i10 = AnonymousClass1.f9343a[this.f9325i.getGeoLanguage().ordinal()]) != 1) {
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 3) {
                return 2;
            }
        }
        return 0;
    }

    private void m() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z14 = true;
        try {
            geoLanguage = this.f9325i.getGeoLanguage();
            z10 = this.f9325i.isNeedAddress();
            try {
                z12 = this.f9325i.isOffset();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z10 = true;
        }
        try {
            z13 = this.f9325i.isLocationCacheEnable();
            try {
                this.f9336t = this.f9325i.isOnceLocationLatest();
                this.f9342z = this.f9325i.isSensorEnable();
                if (z12 != this.f9333q || z10 != this.f9332p || z13 != this.f9335s || geoLanguage != this.f9334r) {
                    t();
                }
            } catch (Throwable unused3) {
                z11 = z13;
                z14 = z12;
                boolean z15 = z11;
                z12 = z14;
                z13 = z15;
                this.f9333q = z12;
                this.f9332p = z10;
                this.f9335s = z13;
                this.f9334r = geoLanguage;
            }
        } catch (Throwable unused4) {
            z14 = z12;
            z11 = true;
            boolean z152 = z11;
            z12 = z14;
            z13 = z152;
            this.f9333q = z12;
            this.f9332p = z10;
            this.f9335s = z13;
            this.f9334r = geoLanguage;
        }
        this.f9333q = z12;
        this.f9332p = z10;
        this.f9335s = z13;
        this.f9334r = geoLanguage;
    }

    private void n() {
        try {
            if (this.f9324h == null) {
                this.f9324h = new a();
            }
            if (this.G == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.G = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.G.addAction("android.net.wifi.SCAN_RESULTS");
            }
            this.f9317a.registerReceiver(this.f9324h, this.G);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBroadcastListener");
        }
    }

    private byte[] o() throws Throwable {
        if (this.f9328l == null) {
            this.f9328l = new f();
        }
        if (this.f9325i == null) {
            this.f9325i = new AMapLocationClientOption();
        }
        if (this.f9320d != null && this.f9319c != null) {
            this.f9328l.a(this.f9317a, this.f9325i.isNeedAddress(), this.f9325i.isOffset(), this.f9320d, this.f9319c, this.f9318b, this.C, this.O);
        }
        return this.f9328l.a();
    }

    private boolean p() {
        return this.f9327k == 0 || j.b() - this.f9327k > 20000;
    }

    private void q() {
        k kVar = this.f9319c;
        if (kVar == null) {
            return;
        }
        kVar.a(this.f9329m);
    }

    private boolean r() {
        k kVar = this.f9319c;
        if (kVar != null) {
            this.f9323g = kVar.e();
        }
        ArrayList<ks> arrayList = this.f9323g;
        return arrayList == null || arrayList.size() <= 0;
    }

    private void s() {
        if (this.L != null) {
            this.L = null;
        }
        StringBuilder sb2 = this.f9337u;
        if (sb2 != null) {
            sb2.delete(0, sb2.length());
        }
    }

    private void t() {
        try {
            com.autonavi.aps.amapapi.storage.a aVar = this.f9321e;
            if (aVar != null) {
                aVar.a();
            }
            d(null);
            this.M = false;
            com.autonavi.aps.amapapi.filters.a aVar2 = this.B;
            if (aVar2 != null) {
                aVar2.a();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "cleanCache");
        }
    }

    public final void a(Handler handler) {
        this.N = handler;
    }

    public final void b() {
        this.f9330n = com.autonavi.aps.amapapi.trans.c.a(this.f9317a);
        k();
        if (this.f9318b == null) {
            this.f9318b = (ConnectivityManager) j.a(this.f9317a, "connectivity");
        }
        if (this.f9328l == null) {
            this.f9328l = new f();
        }
    }

    public final void c() {
        if (this.f9341y == null) {
            this.f9341y = new com.autonavi.aps.amapapi.restruct.b(this.f9317a);
        }
        n();
        k kVar = this.f9319c;
        if (kVar != null) {
            kVar.b(false);
            this.f9323g = this.f9319c.e();
        }
        e eVar = this.f9320d;
        if (eVar != null) {
            eVar.a(false, r());
        }
        this.f9321e.a(this.f9317a);
        b(this.f9317a);
        this.f9339w = true;
    }

    public final void d() {
        if (this.f9331o.length() > 0) {
            StringBuilder sb2 = this.f9331o;
            sb2.delete(0, sb2.length());
        }
    }

    public final void e() {
        this.C = null;
        this.f9338v = false;
        this.f9339w = false;
        com.autonavi.aps.amapapi.storage.a aVar = this.f9321e;
        if (aVar != null) {
            aVar.b(this.f9317a);
        }
        com.autonavi.aps.amapapi.filters.a aVar2 = this.B;
        if (aVar2 != null) {
            aVar2.a();
        }
        if (this.f9322f != null) {
            this.f9322f = null;
        }
        g gVar = this.O;
        if (gVar != null) {
            gVar.a(this.F);
        }
        g();
        ArrayList<ks> arrayList = this.f9323g;
        if (arrayList != null) {
            arrayList.clear();
        }
        com.autonavi.aps.amapapi.restruct.b bVar = this.f9341y;
        if (bVar != null) {
            bVar.f();
        }
        this.f9326j = null;
        this.f9317a = null;
        this.f9337u = null;
        this.H = null;
    }

    public final void f() {
        if (this.f9319c == null) {
            this.f9319c = new k(this.f9317a, (WifiManager) j.a(this.f9317a, "wifi"), this.N);
        }
        if (this.f9320d == null) {
            this.f9320d = new e(this.f9317a, this.N);
        }
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f9317a     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto Lc
            com.autonavi.aps.amapapi.b$a r2 = r4.f9324h     // Catch: java.lang.Throwable -> Lf
            if (r2 == 0) goto Lc
            r1.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> Lf
        Lc:
            r4.f9324h = r0
            goto L18
        Lf:
            r1 = move-exception
            java.lang.String r2 = "Aps"
            java.lang.String r3 = "destroy"
            com.autonavi.aps.amapapi.utils.b.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L2f
            goto Lc
        L18:
            com.autonavi.aps.amapapi.restruct.e r1 = r4.f9320d
            if (r1 == 0) goto L23
            boolean r2 = r4.F
            r1.a(r2)
            r4.f9320d = r0
        L23:
            com.autonavi.aps.amapapi.restruct.k r1 = r4.f9319c
            if (r1 == 0) goto L2e
            boolean r2 = r4.F
            r1.c(r2)
            r4.f9319c = r0
        L2e:
            return
        L2f:
            r1 = move-exception
            r4.f9324h = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.g():void");
    }

    public final void h() {
        c cVar = this.R;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void i() {
        k kVar;
        try {
            if (this.f9317a == null) {
                return;
            }
            if (this.R == null) {
                this.R = new c(this.f9317a);
            }
            e eVar = this.f9320d;
            if (eVar == null || (kVar = this.f9319c) == null) {
                return;
            }
            this.R.a(eVar, kVar, this.N);
        } catch (Throwable th) {
            gy.b(th, "as", "stc");
        }
    }

    public final void j() {
        c cVar = this.R;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void a(Context context) {
        try {
            if (this.f9317a != null) {
                return;
            }
            this.B = new com.autonavi.aps.amapapi.filters.a();
            Context applicationContext = context.getApplicationContext();
            this.f9317a = applicationContext;
            j.b(applicationContext);
            if (this.f9319c == null) {
                this.f9319c = new k(this.f9317a, (WifiManager) j.a(this.f9317a, "wifi"), this.N);
            }
            if (this.f9320d == null) {
                this.f9320d = new e(this.f9317a, this.N);
            }
            this.O = new g(context, this.N);
            if (this.f9321e == null) {
                this.f9321e = new com.autonavi.aps.amapapi.storage.a();
            }
            if (this.f9322f == null) {
                this.f9322f = new com.autonavi.aps.amapapi.trans.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initBase");
        }
    }

    private void d(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            this.f9326j = aVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0106 A[Catch: all -> 0x01fd, TRY_LEAVE, TryCatch #2 {all -> 0x01fd, blocks: (B:12:0x0052, B:14:0x007b, B:17:0x0086, B:19:0x008e, B:22:0x0096, B:23:0x0098, B:25:0x009e, B:26:0x00a8, B:29:0x00b1, B:31:0x00c4, B:33:0x00c8, B:34:0x00d2, B:37:0x00e8, B:39:0x00ee, B:41:0x00f2, B:42:0x0102, B:44:0x0106, B:74:0x00f9, B:75:0x00ff), top: B:11:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a b(boolean r12, com.autonavi.aps.amapapi.a r13) {
        /*
            Method dump skipped, instructions count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.b(boolean, com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private String c(com.autonavi.aps.amapapi.a aVar) {
        e eVar = this.f9320d;
        String str = "";
        if (eVar == null || this.f9319c == null) {
            return "";
        }
        int h10 = eVar.h();
        com.autonavi.aps.amapapi.restruct.d e2 = this.f9320d.e();
        com.autonavi.aps.amapapi.restruct.d f10 = this.f9320d.f();
        ArrayList<ks> arrayList = this.f9323g;
        boolean z10 = arrayList == null || arrayList.isEmpty();
        if (e2 == null && f10 == null && z10) {
            if (this.f9318b == null) {
                this.f9318b = (ConnectivityManager) j.a(this.f9317a, "connectivity");
            }
            if (j.c() >= 31) {
                if (j.a(this.f9317a) && !this.f9319c.l()) {
                    this.f9340x = 18;
                    this.f9331o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
                    h.a((String) null, 2132);
                    aVar.f("#1802");
                    return "";
                }
            } else if (j.a(this.f9317a) && !this.f9319c.k()) {
                this.f9340x = 18;
                this.f9331o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                h.a((String) null, 2132);
                aVar.f("#1801");
                return "";
            }
            if (j.c() >= 28) {
                if (this.H == null) {
                    this.H = (LocationManager) this.f9317a.getApplicationContext().getSystemService("location");
                }
                if (!((Boolean) com.autonavi.aps.amapapi.utils.f.a(this.H, "isLocationEnabled", new Object[0])).booleanValue()) {
                    this.f9340x = 12;
                    this.f9331o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    aVar.f("#1206");
                    h.a((String) null, 2121);
                    return "";
                }
            }
            if (!j.e(this.f9317a)) {
                this.f9340x = 12;
                this.f9331o.append("定位权限被禁用,请授予应用定位权限#1201");
                aVar.f("#1201");
                h.a((String) null, 2121);
                return "";
            }
            if (j.c() >= 24 && j.c() < 28 && Settings.Secure.getInt(this.f9317a.getContentResolver(), "location_mode", 0) == 0) {
                this.f9340x = 12;
                aVar.f("#1206");
                this.f9331o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                h.a((String) null, 2121);
                return "";
            }
            String k10 = this.f9320d.k();
            String d10 = this.f9319c.d();
            if (this.f9319c.a(this.f9318b) && d10 != null) {
                this.f9340x = 12;
                aVar.f("#1202");
                this.f9331o.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                h.a((String) null, 2121);
                return "";
            }
            if (k10 != null) {
                this.f9340x = 12;
                if (!this.f9319c.k()) {
                    aVar.f("#1204");
                    this.f9331o.append("WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204");
                } else {
                    aVar.f("#1205");
                    this.f9331o.append("获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205");
                }
                h.a((String) null, 2121);
                return "";
            }
            if (!this.f9319c.k() && !this.f9320d.n()) {
                this.f9340x = 19;
                aVar.f("#1901");
                this.f9331o.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                h.a((String) null, 2133);
                return "";
            }
            if (!this.f9319c.k()) {
                aVar.f("#1301");
                this.f9331o.append("获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301");
            } else {
                aVar.f("#1302");
                if (this.f9319c.c() != null) {
                    this.f9331o.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
                    if (!j.f(this.f9317a)) {
                        this.f9331o.append("或后台运行没有后台定位权限");
                    }
                    this.f9331o.append("#1302");
                } else {
                    this.f9331o.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
                    if (!j.f(this.f9317a)) {
                        this.f9331o.append("或后台运行没有后台定位权限");
                    }
                    this.f9331o.append("#1302");
                }
            }
            this.f9340x = 13;
            h.a((String) null, 2131);
            return "";
        }
        boolean a10 = this.f9319c.a(this.f9319c.m());
        if (h10 == 0) {
            boolean z11 = !this.f9323g.isEmpty() || a10;
            boolean z12 = f10 != null;
            if (!z12) {
                if (a10 && this.f9323g.isEmpty()) {
                    this.f9340x = 2;
                    aVar.f("#0201");
                    this.f9331o.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                    h.a((String) null, 2021);
                    return "";
                }
                if (this.f9323g.size() == 1) {
                    this.f9340x = 2;
                    if (!a10) {
                        aVar.f("#0202");
                        this.f9331o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        h.a((String) null, 2022);
                        return "";
                    }
                    if (this.f9323g.get(0).f6692h) {
                        aVar.f("#0202");
                        this.f9331o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        h.a((String) null, 2021);
                        return "";
                    }
                }
            }
            String format = String.format(Locale.US, "#%s#", "network");
            if (z12) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f10.b());
                String str2 = (!this.f9323g.isEmpty() || a10) ? "cgiwifi" : "cgi";
                sb2.append("network");
                sb2.append("#");
                sb2.append(str2);
                str = sb2.toString();
            } else if (z11) {
                str = format + "wifi";
            } else {
                this.f9340x = 2;
                if (!this.f9319c.k()) {
                    aVar.f("#0203");
                    this.f9331o.append("当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203");
                } else {
                    aVar.f("#0204");
                    this.f9331o.append("当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204");
                }
                h.a((String) null, 2022);
            }
        } else if (h10 != 1) {
            if (h10 != 2) {
                this.f9340x = 11;
                h.a((String) null, 2111);
                aVar.f("#1101");
                this.f9331o.append("get cgi failure#1101");
            } else if (e2 != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(e2.f9429a);
                sb3.append("#");
                sb3.append(e2.f9430b);
                sb3.append("#");
                sb3.append(e2.f9436h);
                sb3.append("#");
                sb3.append(e2.f9437i);
                sb3.append("#");
                sb3.append(e2.f9438j);
                sb3.append("#");
                sb3.append("network");
                sb3.append("#");
                sb3.append((!this.f9323g.isEmpty() || a10) ? "cgiwifi" : "cgi");
                str = sb3.toString();
            }
        } else if (e2 != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(e2.f9429a);
            sb4.append("#");
            sb4.append(e2.f9430b);
            sb4.append("#");
            sb4.append(e2.f9431c);
            sb4.append("#");
            sb4.append(e2.f9432d);
            sb4.append("#");
            sb4.append("network");
            sb4.append("#");
            sb4.append((!this.f9323g.isEmpty() || a10) ? "cgiwifi" : "cgi");
            str = sb4.toString();
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        return j.e() + str;
    }

    public final void a() {
        e eVar = this.f9320d;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.f9325i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f9325i = new AMapLocationClientOption();
        }
        k kVar = this.f9319c;
        if (kVar != null) {
            this.f9325i.isWifiActiveScan();
            kVar.a(this.f9325i.isWifiScan(), this.f9325i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        k();
        com.autonavi.aps.amapapi.storage.a aVar = this.f9321e;
        if (aVar != null) {
            aVar.a(this.f9325i);
        }
        com.autonavi.aps.amapapi.trans.e eVar = this.f9322f;
        if (eVar != null) {
            eVar.a(this.f9325i);
        }
        m();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:20|(2:22|(1:24)(1:25))|26|(2:27|28)|(8:33|34|(1:36)|38|39|(1:41)|43|(2:45|46)(2:47|(11:53|(1:100)(1:57)|58|(1:60)(2:86|(3:88|(1:90)|91)(4:92|(1:96)|97|(1:99)))|61|62|(2:65|(1:67)(2:68|(1:70)(2:71|(1:73)(1:74))))|75|(2:77|(1:82)(1:81))|83|84)(2:51|52)))|103|34|(0)|38|39|(0)|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00a3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00a4, code lost:
    
        com.autonavi.aps.amapapi.utils.b.a(r0, "Aps", "getLocation getCgiListParam");
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #0 {all -> 0x0091, blocks: (B:28:0x006d, B:30:0x0075, B:34:0x0081, B:36:0x0085), top: B:27:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009b A[Catch: all -> 0x00a3, TRY_LEAVE, TryCatch #1 {all -> 0x00a3, blocks: (B:39:0x0097, B:41:0x009b), top: B:38:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.a r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.b.a(com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private void b(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(fv.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.f9329m = true;
            }
        } catch (Throwable unused) {
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        this.B.a(this.f9335s);
        return this.B.a(aVar);
    }

    public final void b(com.autonavi.aps.amapapi.a aVar) {
        try {
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "initFirstLocateParam");
        }
        if (this.f9338v) {
            return;
        }
        s();
        if (this.f9336t) {
            n();
        }
        k kVar = this.f9319c;
        if (kVar != null) {
            kVar.b(this.f9336t);
            this.f9323g = this.f9319c.e();
        }
        e eVar = this.f9320d;
        if (eVar != null) {
            eVar.a(true, r());
        }
        String c4 = c(aVar);
        this.L = c4;
        if (!TextUtils.isEmpty(c4)) {
            this.f9337u = a(this.f9337u);
        }
        this.f9338v = true;
    }

    private boolean a(long j10) {
        if (!this.M) {
            this.M = true;
            return false;
        }
        if (j.b() - j10 < 800) {
            if ((j.a(this.f9326j) ? j.a() - this.f9326j.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    private StringBuilder a(StringBuilder sb2) {
        if (sb2 == null) {
            sb2 = new StringBuilder(700);
        } else {
            sb2.delete(0, sb2.length());
        }
        e eVar = this.f9320d;
        if (eVar != null && this.f9319c != null) {
            sb2.append(eVar.m());
            sb2.append(this.f9319c.o());
        }
        return sb2;
    }

    private com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar, ie ieVar, com.autonavi.aps.amapapi.a aVar2) {
        if (ieVar != null) {
            try {
                byte[] bArr = ieVar.f6444a;
                if (bArr != null && bArr.length != 0) {
                    com.autonavi.aps.amapapi.trans.e eVar = new com.autonavi.aps.amapapi.trans.e();
                    String str = new String(ieVar.f6444a, "UTF-8");
                    if (str.contains("\"status\":\"0\"")) {
                        com.autonavi.aps.amapapi.model.a a10 = eVar.a(str, this.f9317a, ieVar, aVar2);
                        a10.h(this.f9337u.toString());
                        return a10;
                    }
                    if (!str.contains("</body></html>")) {
                        return null;
                    }
                    aVar.setErrorCode(5);
                    k kVar = this.f9319c;
                    if (kVar != null && kVar.a(this.f9318b)) {
                        aVar2.f("#0501");
                        this.f9331o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                        h.a((String) null, 2051);
                    } else {
                        aVar2.f("#0502");
                        this.f9331o.append("请求可能被劫持了#0502");
                        h.a((String) null, 2052);
                    }
                    aVar.setLocationDetail(this.f9331o.toString());
                    return aVar;
                }
            } catch (Throwable th) {
                aVar.setErrorCode(4);
                com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "checkResponseEntity");
                aVar2.f("#0403");
                this.f9331o.append("check response exception ex is" + th.getMessage() + "#0403");
                aVar.setLocationDetail(this.f9331o.toString());
                return aVar;
            }
        }
        aVar.setErrorCode(4);
        this.f9331o.append("网络异常,请求异常#0403");
        aVar2.f("#0403");
        aVar.h(this.f9337u.toString());
        aVar.setLocationDetail(this.f9331o.toString());
        if (ieVar != null) {
            h.a(ieVar.f6447d, WindowManager.LayoutParams.TYPE_STATUS_BAR_ADDITIONAL);
        }
        return aVar;
    }

    public final void b(com.autonavi.aps.amapapi.model.a aVar) {
        if (j.a(aVar)) {
            this.f9321e.a(this.L, this.f9337u, aVar, this.f9317a, true);
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(boolean z10) {
        k kVar = this.f9319c;
        if (kVar != null && kVar.n()) {
            return a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.L)) {
            return a(this.f9340x, this.f9331o.toString());
        }
        com.autonavi.aps.amapapi.model.a a10 = this.f9321e.a(this.f9317a, this.L, this.f9337u, true, z10);
        if (j.a(a10)) {
            d(a10);
        }
        return a10;
    }

    private static void c(com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar.getErrorCode() == 0 && aVar.getLocationType() == 0) {
            if (!"-5".equals(aVar.d()) && !"1".equals(aVar.d()) && !"2".equals(aVar.d()) && !Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(aVar.d()) && !Constants.VIA_REPORT_TYPE_CHAT_AIO.equals(aVar.d()) && !"-1".equals(aVar.d())) {
                aVar.setLocationType(6);
            } else {
                aVar.setLocationType(5);
            }
        }
    }

    public final com.autonavi.aps.amapapi.model.a a(boolean z10, com.autonavi.aps.amapapi.a aVar) {
        if (z10) {
            aVar.e("statics");
        } else {
            aVar.e("first");
        }
        if (this.f9317a == null) {
            aVar.f("#0101");
            this.f9331o.append("context is null#0101");
            h.a((String) null, 2011);
            return a(1, this.f9331o.toString());
        }
        k kVar = this.f9319c;
        if (kVar != null && kVar.n()) {
            aVar.f("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        }
        b();
        if (TextUtils.isEmpty(this.L)) {
            return a(this.f9340x, this.f9331o.toString());
        }
        com.autonavi.aps.amapapi.model.a b4 = b(z10, aVar);
        if (j.a(b4) && !Q) {
            this.f9321e.a(this.f9337u.toString());
            e eVar = this.f9320d;
            if (eVar != null) {
                this.f9321e.a(eVar.e());
            }
            d(b4);
        }
        Q = true;
        return b4;
    }

    public final com.autonavi.aps.amapapi.model.a a(double d10, double d11) {
        try {
            String a10 = this.f9330n.a(this.f9317a, d10, d11);
            if (!a10.contains("\"status\":\"1\"")) {
                return null;
            }
            com.autonavi.aps.amapapi.model.a a11 = this.f9322f.a(a10);
            a11.setLatitude(d10);
            a11.setLongitude(d11);
            return a11;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 0) {
            return;
        }
        com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
        fVar.f9472a = aMapLocation.getLocationType();
        fVar.f9475d = aMapLocation.getTime();
        fVar.f9476e = (int) aMapLocation.getAccuracy();
        fVar.f9473b = aMapLocation.getLatitude();
        fVar.f9474c = aMapLocation.getLongitude();
        if (aMapLocation.getLocationType() == 1) {
            this.O.a(fVar);
        }
    }

    public final void a(com.autonavi.aps.amapapi.model.a aVar, int i10) {
        if (aVar != null && aVar.getErrorCode() == 0) {
            com.autonavi.aps.amapapi.restruct.f fVar = new com.autonavi.aps.amapapi.restruct.f();
            fVar.f9475d = aVar.getTime();
            fVar.f9476e = (int) aVar.getAccuracy();
            fVar.f9473b = aVar.getLatitude();
            fVar.f9474c = aVar.getLongitude();
            fVar.f9472a = i10;
            fVar.f9478g = Integer.parseInt(aVar.d());
            fVar.f9479h = aVar.l();
            this.O.b(fVar);
        }
    }

    private static com.autonavi.aps.amapapi.model.a a(int i10, String str) {
        com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
        aVar.setErrorCode(i10);
        aVar.setLocationDetail(str);
        if (i10 == 15) {
            h.a((String) null, 2151);
        }
        return aVar;
    }
}
