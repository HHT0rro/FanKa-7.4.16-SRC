package com.amap.api.col.p0003l;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.openalliance.ad.constant.u;
import com.kuaishou.weapon.p0.t;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AmapLocationManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class d {
    private static boolean I = true;
    private static boolean K;
    private static AtomicBoolean L = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    public static volatile boolean f5289g;
    private Context E;
    private g F;

    /* renamed from: a, reason: collision with root package name */
    public com.autonavi.aps.amapapi.model.a f5290a;

    /* renamed from: c, reason: collision with root package name */
    public c f5292c;

    /* renamed from: k, reason: collision with root package name */
    public j f5299k;

    /* renamed from: n, reason: collision with root package name */
    public Intent f5302n;

    /* renamed from: b, reason: collision with root package name */
    public AMapLocationClientOption f5291b = new AMapLocationClientOption();

    /* renamed from: d, reason: collision with root package name */
    public h f5293d = null;
    private boolean G = false;
    private volatile boolean H = false;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<AMapLocationListener> f5294e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f5295f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5296h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5297i = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5298j = true;

    /* renamed from: l, reason: collision with root package name */
    public Messenger f5300l = null;

    /* renamed from: m, reason: collision with root package name */
    public Messenger f5301m = null;

    /* renamed from: o, reason: collision with root package name */
    public int f5303o = 0;
    private boolean J = true;

    /* renamed from: p, reason: collision with root package name */
    public b f5304p = null;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5305q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5306r = false;

    /* renamed from: s, reason: collision with root package name */
    public AMapLocationClientOption.AMapLocationMode f5307s = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* renamed from: t, reason: collision with root package name */
    public Object f5308t = new Object();

    /* renamed from: u, reason: collision with root package name */
    public h f5309u = null;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5310v = false;

    /* renamed from: w, reason: collision with root package name */
    public e f5311w = null;
    private AMapLocationClientOption M = new AMapLocationClientOption();
    private i N = null;

    /* renamed from: x, reason: collision with root package name */
    public String f5312x = null;
    private ServiceConnection O = new ServiceConnection() { // from class: com.amap.api.col.3l.d.2
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                d.this.f5300l = new Messenger(iBinder);
                d.this.G = true;
                d.this.f5310v = true;
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d dVar = d.this;
            dVar.f5300l = null;
            dVar.G = false;
        }
    };

    /* renamed from: y, reason: collision with root package name */
    public AMapLocationQualityReport f5313y = null;

    /* renamed from: z, reason: collision with root package name */
    public boolean f5314z = false;
    public boolean A = false;
    private volatile boolean P = false;
    public a B = null;
    public String C = null;
    public boolean D = false;

    /* compiled from: AmapLocationManager.java */
    /* renamed from: com.amap.api.col.3l.d$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5317a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f5317a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5317a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5317a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: AmapLocationManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v7 */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ?? r02 = 0;
            try {
                super.handleMessage(message);
                if (com.autonavi.aps.amapapi.utils.a.f9612h) {
                    return;
                }
                int i10 = message.what;
                if (i10 == 11) {
                    d.this.a(message.getData());
                    return;
                }
                if (i10 == 12) {
                    d.this.b(message);
                    return;
                }
                if (i10 == 1011) {
                    d.this.a(14, (Bundle) null);
                    d.this.g();
                    return;
                }
                try {
                    switch (i10) {
                        case 1002:
                            d.this.c((AMapLocationListener) message.obj);
                            return;
                        case 1003:
                            d.this.j();
                            d.this.a(13, (Bundle) null);
                            return;
                        case 1004:
                            d.this.l();
                            d.this.a(14, (Bundle) null);
                            return;
                        case 1005:
                            d.this.d((AMapLocationListener) message.obj);
                            return;
                        default:
                            switch (i10) {
                                case 1014:
                                    d.this.a(message);
                                    return;
                                case 1015:
                                    d dVar = d.this;
                                    dVar.f5293d.a(dVar.f5291b);
                                    d.this.a(1025, (Object) null, u.as);
                                    return;
                                case 1016:
                                    if (j.m(d.this.E)) {
                                        com.autonavi.aps.amapapi.utils.d.a();
                                        d.this.r();
                                        return;
                                    } else if (!d.this.f5293d.b()) {
                                        d.this.n();
                                        return;
                                    } else {
                                        d.this.a(1016, (Object) null, 1000L);
                                        return;
                                    }
                                case 1017:
                                    d.this.f5293d.a();
                                    d.this.a(1025);
                                    return;
                                case 1018:
                                    d dVar2 = d.this;
                                    AMapLocationClientOption aMapLocationClientOption = (AMapLocationClientOption) message.obj;
                                    dVar2.f5291b = aMapLocationClientOption;
                                    if (aMapLocationClientOption != null) {
                                        dVar2.s();
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i10) {
                                        case 1023:
                                            d.this.c(message);
                                            return;
                                        case 1024:
                                            d.this.d(message);
                                            return;
                                        case 1025:
                                            if (d.this.f5293d.f()) {
                                                d.this.f5293d.a();
                                                d dVar3 = d.this;
                                                dVar3.f5293d.a(dVar3.f5291b);
                                            }
                                            d.this.a(1025, (Object) null, u.as);
                                            return;
                                        case 1026:
                                            com.autonavi.aps.amapapi.utils.d.b();
                                            d.this.F.a(d.this.f5291b);
                                            return;
                                        case 1027:
                                            d.this.F.a();
                                            return;
                                        case 1028:
                                            d.this.g((AMapLocation) message.obj);
                                            return;
                                        case 1029:
                                            d.this.a(16, (Bundle) null);
                                            d.this.f5306r = true;
                                            return;
                                        case 1030:
                                            d.this.a(17, (Bundle) null);
                                            d.this.f5306r = false;
                                            return;
                                        default:
                                            return;
                                    }
                            }
                    }
                } catch (Throwable th) {
                    r02 = message;
                    th = th;
                    if (r02 == 0) {
                        r02 = "handleMessage";
                    }
                    com.autonavi.aps.amapapi.utils.b.a(th, "AMapLocationManage$MHandlerr", r02);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* compiled from: AmapLocationManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b extends HandlerThread {

        /* renamed from: a, reason: collision with root package name */
        public d f5319a;

        public b(String str, d dVar) {
            super(str);
            this.f5319a = dVar;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                this.f5319a.f5299k.a();
                g.a(this.f5319a.E);
                this.f5319a.p();
                d dVar = this.f5319a;
                if (dVar != null && dVar.E != null) {
                    com.autonavi.aps.amapapi.utils.a.b(this.f5319a.E);
                    com.autonavi.aps.amapapi.utils.a.a(this.f5319a.E);
                }
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public d(Context context, Intent intent, Looper looper) {
        this.f5302n = null;
        this.E = context;
        this.f5302n = intent;
        b(looper);
    }

    private void k() {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.f5313y == null) {
            this.f5313y = new AMapLocationQualityReport();
        }
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        this.f5313y = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.f5313y.setGPSSatellites(0);
        this.f5313y.setLocationMode(this.f5291b.getLocationMode());
        this.f5313y.setWifiAble(j.g(this.E));
        this.f5313y.setNetworkType(j.h(this.E));
        this.f5313y.setNetUseTime(0L);
        aMapLocation.setLocationQualityReport(this.f5313y);
        h.a((String) null, 2121);
        d(aMapLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            a(1025);
            h hVar = this.f5293d;
            if (hVar != null) {
                hVar.a();
            }
            g gVar = this.F;
            if (gVar != null) {
                gVar.a();
            }
            a(1016);
            a(1029, (Object) null, 60000L);
            this.H = false;
            this.f5303o = 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    private void m() {
        com.autonavi.aps.amapapi.model.a b4 = b(new com.autonavi.aps.amapapi.b(true));
        if (i()) {
            Bundle bundle = new Bundle();
            String str = (b4 == null || !(b4.getLocationType() == 2 || b4.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5291b));
            bundle.putString("isCacheLoc", str);
            a(0, bundle);
            if (this.H) {
                a(13, (Bundle) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (!I && (this.f5310v || this.P)) {
                try {
                    if (this.f5310v && !a() && !this.A) {
                        this.A = true;
                        p();
                    }
                } catch (Throwable th) {
                    this.A = true;
                    com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doLBSLocation reStartService");
                }
                if (i()) {
                    this.A = false;
                    Bundle bundle = new Bundle();
                    bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5291b));
                    bundle.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!this.f5293d.b()) {
                        a(1, bundle);
                    }
                }
            } else {
                I = false;
                this.P = true;
                m();
            }
        } catch (Throwable th2) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "doLBSLocation");
                try {
                    if (this.f5291b.isOnceLocation()) {
                        return;
                    }
                    o();
                } catch (Throwable unused) {
                }
            } finally {
                try {
                    if (!this.f5291b.isOnceLocation()) {
                        o();
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private void o() {
        if (this.f5291b.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            a(1016, (Object) null, this.f5291b.getInterval() >= 1000 ? this.f5291b.getInterval() : 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            if (this.f5301m == null) {
                this.f5301m = new Messenger(this.f5292c);
            }
            a(q());
        } catch (Throwable unused) {
        }
    }

    private Intent q() {
        String str;
        if (this.f5302n == null) {
            this.f5302n = new Intent(this.E, (Class<?>) APSService.class);
        }
        try {
            if (!TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY())) {
                str = AMapLocationClientOption.getAPIKEY();
            } else {
                str = fj.f(this.E);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl p2");
            str = "";
        }
        this.f5302n.putExtra("a", str);
        this.f5302n.putExtra("b", fj.c(this.E));
        this.f5302n.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.f5302n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            StringBuilder sb2 = new StringBuilder();
            new com.autonavi.aps.amapapi.a().f("#2001");
            sb2.append("模糊权限下不支持低功耗定位#2001");
            h.a((String) null, 2153);
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(20);
            aVar.setLocationDetail(sb2.toString());
            g(aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:callback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f5293d.b(this.f5291b);
        this.F.b(this.f5291b);
        if (this.H && !this.f5291b.getLocationMode().equals(this.f5307s)) {
            l();
            j();
        }
        this.f5307s = this.f5291b.getLocationMode();
        if (this.f5309u != null) {
            if (this.f5291b.isOnceLocation()) {
                this.f5309u.a(this.E, 0);
            } else {
                this.f5309u.a(this.E, 1);
            }
            this.f5309u.a(this.E, this.f5291b);
        }
    }

    private boolean t() {
        if (j.j(this.E)) {
            int i10 = -1;
            try {
                i10 = f.b(((Application) this.E.getApplicationContext()).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
            }
            if (i10 != 0) {
                return false;
            }
        }
        return true;
    }

    /* compiled from: AmapLocationManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            c cVar;
            c cVar2;
            try {
                super.handleMessage(message);
                d dVar = d.this;
                if (dVar.f5305q) {
                    return;
                }
                int i10 = message.what;
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 13) {
                            switch (i10) {
                                case 5:
                                    Bundle data = message.getData();
                                    data.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(d.this.f5291b));
                                    d.this.a(10, data);
                                    return;
                                case 6:
                                    Bundle data2 = message.getData();
                                    h hVar = d.this.f5293d;
                                    if (hVar != null) {
                                        hVar.a(data2);
                                        return;
                                    }
                                    return;
                                case 7:
                                    d.this.J = message.getData().getBoolean("ngpsAble");
                                    return;
                                case 8:
                                    h.a((String) null, 2141);
                                    break;
                                case 9:
                                    boolean unused = d.K = message.getData().getBoolean("installMockApp");
                                    return;
                                case 10:
                                    dVar.a((AMapLocation) message.obj);
                                    return;
                                default:
                                    switch (i10) {
                                        case 100:
                                            h.a((String) null, 2155);
                                            break;
                                        case 101:
                                            break;
                                        case 102:
                                            Bundle data3 = message.getData();
                                            data3.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(d.this.f5291b));
                                            d.this.a(15, data3);
                                            return;
                                        case 103:
                                            Bundle data4 = message.getData();
                                            if (d.this.F != null) {
                                                d.this.F.a(data4);
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                    Message obtain = Message.obtain();
                                    obtain.what = 1028;
                                    obtain.obj = message.obj;
                                    d.this.B.sendMessage(obtain);
                                    if (d.this.M == null || !d.this.M.getCacheCallBack() || (cVar2 = d.this.f5292c) == null) {
                                        return;
                                    }
                                    cVar2.removeMessages(13);
                                    return;
                            }
                        } else {
                            com.autonavi.aps.amapapi.model.a aVar = dVar.f5290a;
                            if (aVar != null) {
                                dVar.a(aVar);
                                return;
                            }
                            AMapLocation aMapLocation = new AMapLocation("LBS");
                            aMapLocation.setErrorCode(33);
                            d.this.a(aMapLocation);
                            return;
                        }
                    }
                    Message obtain2 = Message.obtain();
                    obtain2.what = 12;
                    obtain2.obj = message.obj;
                    d.this.B.sendMessage(obtain2);
                    if (d.this.M == null || !d.this.M.getCacheCallBack() || (cVar = d.this.f5292c) == null) {
                        return;
                    }
                    cVar.removeMessages(13);
                    return;
                }
                Message obtainMessage = dVar.B.obtainMessage();
                obtainMessage.what = 11;
                obtainMessage.setData(message.getData());
                d.this.B.sendMessage(obtainMessage);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager$MainHandler", 0 == 0 ? "handleMessage" : null);
            }
        }

        public c() {
        }
    }

    private void h() {
        synchronized (this.f5308t) {
            a aVar = this.B;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.B = null;
        }
    }

    private boolean i() {
        boolean z10 = false;
        int i10 = 0;
        while (this.f5300l == null) {
            try {
                Thread.sleep(100L);
                i10++;
                if (i10 >= 50) {
                    break;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "checkAPSManager");
            }
        }
        if (this.f5300l == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            if (!j.k(this.E.getApplicationContext())) {
                aMapLocation.setLocationDetail("请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003");
            } else {
                aMapLocation.setLocationDetail("启动ApsServcie失败#1001");
            }
            bundle.putParcelable("loc", aMapLocation);
            obtain.setData(bundle);
            obtain.what = 1;
            this.f5292c.sendMessage(obtain);
        } else {
            z10 = true;
        }
        if (!z10) {
            if (!j.k(this.E.getApplicationContext())) {
                h.a((String) null, TXLiveConstants.PLAY_WARNING_RECONNECT);
            } else {
                h.a((String) null, 2101);
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        int i10 = Build.VERSION.SDK_INT;
        if ((i10 < 29 && i10 >= 23 && !j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i10 < 31 && i10 >= 29 && this.E.getApplicationInfo().targetSdkVersion >= 29 && !j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i10 < 31 && i10 >= 29 && this.E.getApplicationInfo().targetSdkVersion < 29 && !j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || (i10 >= 31 && !j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O"))))) {
            k();
            return;
        }
        if (this.f5291b == null) {
            this.f5291b = new AMapLocationClientOption();
        }
        if (this.H) {
            return;
        }
        this.H = true;
        a(1029);
        long j10 = 0;
        if (this.f5306r) {
            a(1030, (Object) null, 0L);
        }
        int i11 = AnonymousClass3.f5317a[this.f5291b.getLocationMode().ordinal()];
        if (i11 == 1) {
            a(1027, (Object) null, 0L);
            a(1017, (Object) null, 0L);
            a(1016, (Object) null, 0L);
            return;
        }
        if (i11 == 2) {
            if (j.m(this.E)) {
                a(1016);
                a(1017, (Object) null, 0L);
                a(1026, (Object) null, 0L);
                return;
            } else {
                a(1016);
                a(1027, (Object) null, 0L);
                a(1015, (Object) null, 0L);
                return;
            }
        }
        if (i11 == 3) {
            if (j.m(this.E)) {
                a(1016);
                a(1017, (Object) null, 0L);
                a(1026, (Object) null, 0L);
            } else {
                a(1027, (Object) null, 0L);
                a(1015, (Object) null, 0L);
                if (this.f5291b.isGpsFirst() && this.f5291b.isOnceLocation()) {
                    j10 = this.f5291b.getGpsFirstTimeout();
                }
                a(1016, (Object) null, j10);
            }
        }
    }

    public final AMapLocation e() {
        AMapLocation aMapLocation = null;
        try {
            j jVar = this.f5299k;
            if (jVar != null && (aMapLocation = jVar.b()) != null) {
                aMapLocation.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "getLastKnownLocation");
        }
        return aMapLocation;
    }

    public final void f() {
        try {
            i iVar = this.N;
            if (iVar != null) {
                iVar.b();
                this.N = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopAssistantLocation");
        }
    }

    public final void g() {
        a(12, (Bundle) null);
        this.f5296h = true;
        this.f5297i = true;
        this.f5298j = true;
        this.G = false;
        this.f5310v = false;
        l();
        h hVar = this.f5309u;
        if (hVar != null) {
            hVar.b(this.E);
        }
        g.a(this.E).a();
        h.a(this.E);
        e eVar = this.f5311w;
        if (eVar != null) {
            eVar.b().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.O;
            if (serviceConnection != null) {
                this.E.unbindService(serviceConnection);
            }
        }
        try {
            if (this.D) {
                this.E.stopService(q());
            }
        } catch (Throwable unused) {
        }
        this.D = false;
        ArrayList<AMapLocationListener> arrayList = this.f5294e;
        if (arrayList != null) {
            arrayList.clear();
            this.f5294e = null;
        }
        this.O = null;
        h();
        b bVar = this.f5304p;
        if (bVar != null) {
            try {
                f.a(bVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
            } catch (Throwable unused2) {
                this.f5304p.quit();
            }
        }
        this.f5304p = null;
        c cVar = this.f5292c;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
        j jVar = this.f5299k;
        if (jVar != null) {
            jVar.c();
            this.f5299k = null;
        }
    }

    public final void c() {
        try {
            a(1004, (Object) null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    public final void d() {
        try {
            i iVar = this.N;
            if (iVar != null) {
                iVar.b();
                this.N = null;
            }
            a(1011, (Object) null, 0L);
            this.f5305q = true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onDestroy");
        }
    }

    private void c(AMapLocation aMapLocation) {
        StringBuilder sb2;
        if (aMapLocation != null) {
            try {
                String locationDetail = aMapLocation.getLocationDetail();
                if (TextUtils.isEmpty(locationDetail)) {
                    sb2 = new StringBuilder();
                } else {
                    sb2 = new StringBuilder(locationDetail);
                }
                boolean c4 = j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean c10 = j.c(this.E, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean c11 = j.c(this.E, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean c12 = j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean c13 = j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean c14 = j.c(this.E, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb2.append(c4 ? "#pm1" : "#pm0");
                String str = "1";
                sb2.append(c10 ? "1" : "0");
                sb2.append(c11 ? "1" : "0");
                sb2.append(c12 ? "1" : "0");
                sb2.append(c13 ? "1" : "0");
                if (!c14) {
                    str = "0";
                }
                sb2.append(str);
                aMapLocation.setLocationDetail(sb2.toString());
            } catch (Throwable unused) {
                com.autonavi.aps.amapapi.utils.d.b();
            }
        }
    }

    private synchronized void e(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerCoarseLocation part2");
                return;
            }
        }
        if (this.f5313y == null) {
            this.f5313y = new AMapLocationQualityReport();
        }
        this.f5313y.setLocationMode(this.f5291b.getLocationMode());
        if (this.F != null) {
            this.f5313y.setGPSSatellites(aMapLocation.getSatellites());
            this.f5313y.setGpsStatus(this.F.b());
        }
        this.f5313y.setWifiAble(j.g(this.E));
        this.f5313y.setNetworkType(j.h(this.E));
        this.f5313y.setNetUseTime(0L);
        this.f5313y.setInstallHighDangerMockApp(K);
        aMapLocation.setLocationQualityReport(this.f5313y);
        try {
            if (this.H) {
                h.a(this.E, aMapLocation);
                d(aMapLocation.m1956clone());
                g.a(this.E).a(aMapLocation);
                g.a(this.E).b();
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "handlerCoarseLocation part");
        }
        if (this.f5305q) {
            return;
        }
        if (this.F != null) {
            l();
        }
        a(14, (Bundle) null);
    }

    private void f(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        AMapLocation aMapLocation2 = null;
        try {
            com.autonavi.aps.amapapi.storage.b bVar = j.f6517b;
            if (bVar == null) {
                j jVar = this.f5299k;
                if (jVar != null) {
                    aMapLocation2 = jVar.b();
                }
            } else {
                aMapLocation2 = bVar.a();
            }
            h.a(aMapLocation2, aMapLocation);
        } catch (Throwable unused) {
        }
    }

    public final void b(AMapLocationListener aMapLocationListener) {
        try {
            a(1005, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    private void d(AMapLocation aMapLocation) {
        Message obtainMessage = this.f5292c.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = aMapLocation;
        this.f5292c.sendMessage(obtainMessage);
    }

    public final boolean a() {
        return this.G;
    }

    public final void b() {
        c cVar;
        try {
            if (this.M.getCacheCallBack() && (cVar = this.f5292c) != null) {
                cVar.sendEmptyMessageDelayed(13, this.M.getCacheCallBackTime());
            }
        } catch (Throwable unused) {
        }
        try {
            a(1003, (Object) null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, Object obj, long j10) {
        synchronized (this.f5308t) {
            if (this.B != null) {
                Message obtain = Message.obtain();
                obtain.what = i10;
                if (obj instanceof Bundle) {
                    obtain.setData((Bundle) obj);
                } else {
                    obtain.obj = obj;
                }
                this.B.sendMessageDelayed(obtain, j10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AMapLocationListener aMapLocationListener) {
        if (!this.f5294e.isEmpty() && this.f5294e.contains(aMapLocationListener)) {
            this.f5294e.remove(aMapLocationListener);
        }
        if (this.f5294e.isEmpty()) {
            l();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0029 -> B:7:0x002e). Please report as a decompilation issue!!! */
    private void b(Looper looper) {
        try {
            if (looper == null) {
                if (Looper.myLooper() == null) {
                    this.f5292c = new c(this.E.getMainLooper());
                } else {
                    this.f5292c = new c();
                }
            } else {
                this.f5292c = new c(looper);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "init 1");
        }
        try {
            try {
                this.f5299k = new j(this.E);
            } catch (Throwable th2) {
                com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "init 5");
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "ALManager", "init 2");
        }
        b bVar = new b("amapLocManagerThread", this);
        this.f5304p = bVar;
        bVar.setPriority(5);
        this.f5304p.start();
        this.B = a(this.f5304p.getLooper());
        try {
            this.f5293d = new h(this.E, this.f5292c);
            this.F = new g(this.E, this.f5292c);
        } catch (Throwable th4) {
            com.autonavi.aps.amapapi.utils.b.a(th4, "ALManager", "init 3");
        }
        if (this.f5309u == null) {
            this.f5309u = new h();
        }
        a(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z10 = data.getBoolean("j", true);
            Intent q10 = q();
            q10.putExtra("j", z10);
            q10.putExtra("g", 2);
            a(q10, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doDisableBackgroundLocation");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        synchronized (this.f5308t) {
            a aVar = this.B;
            if (aVar != null) {
                aVar.removeMessages(i10);
            }
        }
    }

    private a a(Looper looper) {
        a aVar;
        synchronized (this.f5308t) {
            aVar = new a(looper);
            this.B = aVar;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            if (this.f5294e == null) {
                this.f5294e = new ArrayList<>();
            }
            if (this.f5294e.contains(aMapLocationListener)) {
                return;
            }
            this.f5294e.add(aMapLocationListener);
            return;
        }
        throw new IllegalArgumentException("listener参数不能为null");
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.M = aMapLocationClientOption.m1957clone();
            a(1018, aMapLocationClientOption.m1957clone(), 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationOption");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i10 = data.getInt(t.f36220e, 0);
            Notification notification = (Notification) data.getParcelable("h");
            Intent q10 = q();
            q10.putExtra(t.f36220e, i10);
            q10.putExtra("h", notification);
            q10.putExtra("g", 1);
            a(q10, true);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doEnableBackgroundLocation");
        }
    }

    public final void a(AMapLocationListener aMapLocationListener) {
        try {
            a(1002, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationListener");
        }
    }

    private static void b(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return;
        }
        try {
            if (2 == aMapLocation.getLocationType() || 4 == aMapLocation.getLocationType()) {
                long time = aMapLocation.getTime();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis > time) {
                    aMapLocation.setTime(currentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(WebView webView) {
        if (this.N == null) {
            this.N = new i(this.E, webView);
        }
        this.N.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(AMapLocation aMapLocation) {
        try {
            if (this.f5297i && this.f5300l != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5291b));
                a(0, bundle);
                if (this.H) {
                    a(13, (Bundle) null);
                }
                this.f5297i = false;
            }
            e(aMapLocation);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private static void a(final Context context) {
        if (L.compareAndSet(false, true)) {
            jd.a().a(new je() { // from class: com.amap.api.col.3l.d.1
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    fm.l();
                    fm.a(context);
                    fm.f(context);
                }
            });
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:1|2|3|(3:4|5|(1:7))|9|10|(1:12)|14|15|16|17|(3:19|(2:21|(2:99|(2:101|(1:105)))(1:23))|106)(1:107)|24|(4:(20:(1:27)(1:97)|28|29|(2:31|(1:33))|35|(3:86|87|88)(1:37)|38|39|(1:43)|45|46|(1:50)|52|53|(1:55)|56|(1:58)|(1:64)|66|67)(1:98)|66|67|(2:(0)|(1:68)))|93|(0)(0)|38|39|(2:41|43)|45|46|(2:48|50)|52|53|(0)|56|(0)|(2:62|64)) */
    /* JADX WARN: Can't wrap try/catch for region: R(33:1|2|3|4|5|(1:7)|9|10|(1:12)|14|15|16|17|(3:19|(2:21|(2:99|(2:101|(1:105)))(1:23))|106)(1:107)|24|(20:(1:27)(1:97)|28|29|(2:31|(1:33))|35|(3:86|87|88)(1:37)|38|39|(1:43)|45|46|(1:50)|52|53|(1:55)|56|(1:58)|(1:64)|66|67)(1:98)|93|(0)(0)|38|39|(2:41|43)|45|46|(2:48|50)|52|53|(0)|56|(0)|(2:62|64)|66|67|(2:(0)|(1:68))) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0123, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0124, code lost:
    
        com.autonavi.aps.amapapi.utils.b.a(r1, "ALManager", "apsLocation:callback");
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00e9, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ea, code lost:
    
        com.autonavi.aps.amapapi.utils.b.a(r8, "ALManager", "fixLastLocation");
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0107 A[Catch: all -> 0x0123, TryCatch #3 {all -> 0x0123, blocks: (B:53:0x0100, B:55:0x0107, B:56:0x011a, B:58:0x011f), top: B:52:0x0100, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011f A[Catch: all -> 0x0123, TRY_LEAVE, TryCatch #3 {all -> 0x0123, blocks: (B:53:0x0100, B:55:0x0107, B:56:0x011a, B:58:0x011f), top: B:52:0x0100, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.autonavi.aps.amapapi.model.a b(com.autonavi.aps.amapapi.b r14) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.d.b(com.autonavi.aps.amapapi.b):com.autonavi.aps.amapapi.model.a");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z10 = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z10) {
                    this.f5300l = null;
                    this.G = false;
                }
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.f5312x)) {
            this.f5312x = com.autonavi.aps.amapapi.utils.b.b(this.E);
        }
        bundle.putString("c", this.f5312x);
        Message obtain = Message.obtain();
        obtain.what = i10;
        obtain.setData(bundle);
        obtain.replyTo = this.f5301m;
        Messenger messenger = this.f5300l;
        if (messenger != null) {
            messenger.send(obtain);
        }
    }

    private void a(Intent intent) {
        try {
            this.E.bindService(intent, this.O, 1);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == ShadowDrawableWrapper.COS_45 && longitude == ShadowDrawableWrapper.COS_45) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    h.a("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if (GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) || !this.f5293d.b()) {
                aMapLocation.setAltitude(j.c(aMapLocation.getAltitude()));
                aMapLocation.setBearing(j.a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(j.a(aMapLocation.getSpeed()));
                c(aMapLocation);
                b(aMapLocation);
                Iterator<AMapLocationListener> iterator2 = this.f5294e.iterator2();
                while (iterator2.hasNext()) {
                    try {
                        iterator2.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private synchronized void a(AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerLocation part3");
                return;
            }
        }
        if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            aMapLocation.setProvider("lbs");
        }
        if (this.f5313y == null) {
            this.f5313y = new AMapLocationQualityReport();
        }
        this.f5313y.setLocationMode(this.f5291b.getLocationMode());
        h hVar = this.f5293d;
        if (hVar != null) {
            this.f5313y.setGPSSatellites(hVar.e());
            this.f5313y.setGpsStatus(this.f5293d.d());
        }
        this.f5313y.setWifiAble(j.g(this.E));
        this.f5313y.setNetworkType(j.h(this.E));
        if (aMapLocation.getLocationType() == 1 || GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider())) {
            this.f5313y.setNetUseTime(0L);
        }
        if (aVar != null) {
            this.f5313y.setNetUseTime(aVar.a());
        }
        this.f5313y.setInstallHighDangerMockApp(K);
        aMapLocation.setLocationQualityReport(this.f5313y);
        try {
            if (this.H) {
                a(aMapLocation, this.C);
                if (aVar != null) {
                    aVar.d(j.b());
                }
                h.a(this.E, aMapLocation, aVar);
                h.a(this.E, aMapLocation);
                d(aMapLocation.m1956clone());
                g.a(this.E).a(aMapLocation);
                g.a(this.E).b();
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "handlerLocation part2");
        }
        if (this.f5305q) {
            return;
        }
        if (this.f5291b.isOnceLocation()) {
            l();
            a(14, (Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (this.f5296h && this.f5300l != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5291b));
                a(0, bundle);
                if (this.H) {
                    a(13, (Bundle) null);
                }
                this.f5296h = false;
            }
            a(aMapLocation, (com.autonavi.aps.amapapi.a) null);
            a(1025);
            a(1025, (Object) null, u.as);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    private void a(AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        a(1014, bundle, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            f(aMapLocation);
            if (this.f5299k.a(aMapLocation, string)) {
                this.f5299k.d();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doSaveLastLocation");
        }
    }

    private void a(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.a aVar) {
        try {
            bVar.a(this.E);
            bVar.a(this.f5291b);
            bVar.b(aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "initApsBase");
        }
    }

    private com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.b bVar, boolean z10) {
        if (!this.f5291b.isLocationCacheEnable()) {
            return null;
        }
        try {
            return bVar.a(z10);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doFirstCacheLoc");
            return null;
        }
    }

    private static void a(com.autonavi.aps.amapapi.b bVar) {
        try {
            bVar.d();
            bVar.a(new AMapLocationClientOption().setNeedAddress(false));
            bVar.a(true, new com.autonavi.aps.amapapi.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    private static void a(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.getErrorCode() == 0) {
                    bVar.b(aVar);
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        com.autonavi.aps.amapapi.a aVar;
        AMapLocation aMapLocation;
        h hVar;
        AMapLocation aMapLocation2 = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                this.C = bundle.getString("nb");
                aVar = (com.autonavi.aps.amapapi.a) bundle.getParcelable("statics");
                if (aMapLocation != null) {
                    try {
                        if (aMapLocation.getErrorCode() == 0 && (hVar = this.f5293d) != null) {
                            hVar.c();
                            if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                h.f6214y = aMapLocation;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                        a(aMapLocation2, aVar);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                a(aMapLocation2, aVar);
            }
        } else {
            aVar = null;
            aMapLocation = null;
        }
        h hVar2 = this.f5293d;
        aMapLocation2 = hVar2 != null ? hVar2.a(aMapLocation, this.C) : aMapLocation;
        a(aMapLocation2, aVar);
    }

    public final void a(int i10, Notification notification) {
        if (i10 == 0 || notification == null) {
            return;
        }
        try {
            if (this.f5298j && this.f5300l != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f5291b));
                a(0, bundle);
                this.f5298j = false;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt(t.f36220e, i10);
            bundle2.putParcelable("h", notification);
            a(1023, bundle2, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final void a(boolean z10) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z10);
            a(1024, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    private void a(Intent intent, boolean z10) {
        Context context = this.E;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 26 && z10) {
                if (!t()) {
                    return;
                }
                try {
                    this.E.getClass().getMethod("startForegroundService", Intent.class).invoke(this.E, intent);
                } catch (Throwable unused) {
                    this.E.startService(intent);
                }
            } else {
                context.startService(intent);
            }
            this.D = true;
        }
    }
}
