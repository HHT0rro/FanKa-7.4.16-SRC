package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ApsManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class e {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f5404g;

    /* renamed from: e, reason: collision with root package name */
    public Context f5409e;

    /* renamed from: w, reason: collision with root package name */
    private List<Messenger> f5426w;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5418o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5419p = false;

    /* renamed from: a, reason: collision with root package name */
    public String f5405a = null;

    /* renamed from: b, reason: collision with root package name */
    public b f5406b = null;

    /* renamed from: q, reason: collision with root package name */
    private long f5420q = 0;

    /* renamed from: r, reason: collision with root package name */
    private long f5421r = 0;

    /* renamed from: s, reason: collision with root package name */
    private com.autonavi.aps.amapapi.model.a f5422s = null;

    /* renamed from: c, reason: collision with root package name */
    public AMapLocation f5407c = null;

    /* renamed from: t, reason: collision with root package name */
    private long f5423t = 0;

    /* renamed from: u, reason: collision with root package name */
    private int f5424u = 0;

    /* renamed from: d, reason: collision with root package name */
    public a f5408d = null;

    /* renamed from: v, reason: collision with root package name */
    private j f5425v = null;

    /* renamed from: f, reason: collision with root package name */
    public com.autonavi.aps.amapapi.b f5410f = null;

    /* renamed from: h, reason: collision with root package name */
    public HashMap<Messenger, Long> f5411h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    public h f5412i = null;

    /* renamed from: j, reason: collision with root package name */
    public long f5413j = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f5414k = 0;

    /* renamed from: x, reason: collision with root package name */
    private long f5427x = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f5415l = null;

    /* renamed from: y, reason: collision with root package name */
    private boolean f5428y = true;

    /* renamed from: z, reason: collision with root package name */
    private String f5429z = "";

    /* renamed from: m, reason: collision with root package name */
    public AMapLocationClientOption f5416m = null;

    /* renamed from: n, reason: collision with root package name */
    public AMapLocationClientOption f5417n = new AMapLocationClientOption();

    /* compiled from: ApsManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x011e A[Catch: all -> 0x012c, TryCatch #2 {all -> 0x012c, blocks: (B:7:0x0058, B:10:0x005e, B:12:0x0128, B:19:0x0063, B:20:0x006a, B:21:0x0071, B:22:0x007f, B:24:0x0083, B:26:0x008b, B:28:0x0097, B:29:0x00a0, B:31:0x00a8, B:33:0x00b4, B:34:0x00bc, B:36:0x00c0, B:38:0x00c8, B:40:0x00d4, B:42:0x00e9, B:43:0x00ef, B:44:0x00f5, B:45:0x00fb, B:46:0x0108, B:47:0x0113, B:48:0x011e, B:62:0x0051), top: B:61:0x0051 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x005c  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r9) {
            /*
                Method dump skipped, instructions count: 332
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3l.e.a.handleMessage(android.os.Message):void");
        }
    }

    /* compiled from: ApsManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                try {
                    e.this.f5425v = new j(e.this.f5409e);
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "APSManager$ActionThread", "init 2");
                }
                try {
                    com.autonavi.aps.amapapi.utils.a.b(e.this.f5409e);
                    com.autonavi.aps.amapapi.utils.a.a(e.this.f5409e);
                } catch (Throwable th2) {
                    com.autonavi.aps.amapapi.utils.b.a(th2, "APSManager$ActionThread", "init 3");
                }
                e.this.f5410f = new com.autonavi.aps.amapapi.b(false);
                super.onLooperPrepared();
            } catch (Throwable th3) {
                com.autonavi.aps.amapapi.utils.b.a(th3, "APSManager$ActionThread", "onLooperPrepared");
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public e(Context context) {
        this.f5409e = null;
        this.f5409e = context;
    }

    public static /* synthetic */ com.autonavi.aps.amapapi.model.a b(String str) {
        return a(10, str);
    }

    public static void f() {
        f5404g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (j.m(this.f5409e)) {
            d.a();
            return;
        }
        try {
            com.autonavi.aps.amapapi.b bVar = this.f5410f;
            if (bVar == null || bVar == null) {
                return;
            }
            bVar.a(this.f5408d);
            this.f5410f.i();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "startColl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            com.autonavi.aps.amapapi.utils.a.c(this.f5409e);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    public final void d() {
        com.autonavi.aps.amapapi.b bVar = this.f5410f;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void e() {
        try {
            HashMap<Messenger, Long> hashMap = this.f5411h;
            if (hashMap != null) {
                hashMap.clear();
                this.f5411h = null;
            }
            try {
                List<Messenger> list = this.f5426w;
                if (list != null) {
                    list.clear();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "apm", "des1");
            }
            j jVar = this.f5425v;
            if (jVar != null) {
                jVar.c();
                this.f5425v = null;
            }
            this.f5418o = false;
            this.f5419p = false;
            this.f5410f.e();
            a aVar = this.f5408d;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.f5408d = null;
            b bVar = this.f5406b;
            if (bVar != null) {
                try {
                    f.a(bVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                    this.f5406b.quit();
                }
            }
            this.f5406b = null;
            if (this.f5412i != null && this.f5413j != 0 && this.f5414k != 0) {
                long b4 = j.b() - this.f5413j;
                h.a(this.f5409e, this.f5412i.c(this.f5409e), this.f5412i.d(this.f5409e), this.f5414k, b4);
                this.f5412i.e(this.f5409e);
            }
            h.a(this.f5409e);
            gy.b();
            if (f5404g) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "apm", "tdest");
        }
    }

    public final void c() {
        com.autonavi.aps.amapapi.b bVar = this.f5410f;
        if (bVar != null) {
            bVar.g();
        }
    }

    public final Handler b() {
        return this.f5408d;
    }

    private void b(Messenger messenger) {
        try {
            this.f5410f.h();
            if (com.autonavi.aps.amapapi.utils.a.l()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                a(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "initAuth");
        }
    }

    public final void a() {
        try {
            this.f5412i = new h();
            b bVar = new b("amapLocCoreThread");
            this.f5406b = bVar;
            bVar.setPriority(5);
            this.f5406b.start();
            this.f5408d = new a(this.f5406b.getLooper());
            this.f5426w = new ArrayList();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "onCreate");
        }
    }

    private static AMapLocationClientOption b(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = null;
        try {
            aMapLocationClientOption = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            try {
                String string = bundle.getString("d");
                if (!TextUtils.isEmpty(string)) {
                    fm.a(string);
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "APSManager", "doLocation setUmidToken");
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "APSManager", "parseBundle");
        }
        return aMapLocationClientOption;
    }

    public final void a(Intent intent) {
        a aVar;
        if (!"true".equals(intent.getStringExtra("as")) || (aVar = this.f5408d) == null) {
            return;
        }
        aVar.sendEmptyMessageDelayed(9, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger) {
        this.f5411h.remove(messenger);
    }

    private static com.autonavi.aps.amapapi.model.a a(int i10, String str) {
        try {
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(i10);
            aVar.setLocationDetail(str);
            return aVar;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:26|27|28|29|(14:34|(1:36)(2:62|(1:64))|37|38|(1:40)|41|(1:43)|44|(2:46|47)(1:60)|48|49|(2:53|54)|56|57)|65|37|38|(0)|41|(0)|44|(0)(0)|48|49|(3:51|53|54)|56|57) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0163, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0164, code lost:
    
        com.autonavi.aps.amapapi.utils.b.a(r13, "ApsServiceCore", "fixLastLocation");
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0127 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:9:0x0010, B:11:0x0029, B:13:0x002f, B:16:0x0047, B:18:0x004c, B:20:0x0079, B:22:0x0086, B:24:0x008f, B:26:0x00a0, B:38:0x011f, B:40:0x0127, B:41:0x012d, B:43:0x0131, B:44:0x013c, B:46:0x0140, B:56:0x0169, B:59:0x0164, B:68:0x00f9, B:49:0x014f, B:51:0x0155, B:53:0x0159, B:29:0x00a9, B:31:0x00b9, B:34:0x00c3, B:36:0x00cb, B:37:0x00eb, B:62:0x00d3, B:64:0x00dc, B:65:0x00e4), top: B:3:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0131 A[Catch: all -> 0x016d, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:9:0x0010, B:11:0x0029, B:13:0x002f, B:16:0x0047, B:18:0x004c, B:20:0x0079, B:22:0x0086, B:24:0x008f, B:26:0x00a0, B:38:0x011f, B:40:0x0127, B:41:0x012d, B:43:0x0131, B:44:0x013c, B:46:0x0140, B:56:0x0169, B:59:0x0164, B:68:0x00f9, B:49:0x014f, B:51:0x0155, B:53:0x0159, B:29:0x00a9, B:31:0x00b9, B:34:0x00c3, B:36:0x00cb, B:37:0x00eb, B:62:0x00d3, B:64:0x00dc, B:65:0x00e4), top: B:3:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0140 A[Catch: all -> 0x016d, TRY_LEAVE, TryCatch #2 {all -> 0x016d, blocks: (B:4:0x0008, B:9:0x0010, B:11:0x0029, B:13:0x002f, B:16:0x0047, B:18:0x004c, B:20:0x0079, B:22:0x0086, B:24:0x008f, B:26:0x00a0, B:38:0x011f, B:40:0x0127, B:41:0x012d, B:43:0x0131, B:44:0x013c, B:46:0x0140, B:56:0x0169, B:59:0x0164, B:68:0x00f9, B:49:0x014f, B:51:0x0155, B:53:0x0159, B:29:0x00a9, B:31:0x00b9, B:34:0x00c3, B:36:0x00cb, B:37:0x00eb, B:62:0x00d3, B:64:0x00dc, B:65:0x00e4), top: B:3:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.os.Messenger r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.e.b(android.os.Messenger, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        try {
            if (this.f5418o) {
                com.autonavi.aps.amapapi.b bVar = this.f5410f;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            com.autonavi.aps.amapapi.utils.b.a(this.f5409e);
            if (bundle != null) {
                this.f5417n = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            }
            this.f5410f.a(this.f5409e);
            this.f5410f.b();
            a(this.f5417n);
            this.f5410f.c();
            this.f5418o = true;
            this.f5428y = true;
            this.f5429z = "";
            List<Messenger> list = this.f5426w;
            if (list == null || list.size() <= 0) {
                return;
            }
            g();
        } catch (Throwable th) {
            this.f5428y = false;
            th.printStackTrace();
            this.f5429z = th.getMessage();
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "init");
        }
    }

    private void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            com.autonavi.aps.amapapi.b bVar = this.f5410f;
            if (bVar != null) {
                bVar.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                f5404g = aMapLocationClientOption.isKillProcess();
                if (this.f5416m != null) {
                    if (aMapLocationClientOption.isOffset() != this.f5416m.isOffset() || aMapLocationClientOption.isNeedAddress() != this.f5416m.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.f5416m.isLocationCacheEnable() || this.f5416m.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f5421r = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.f5416m.isOffset() || this.f5416m.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f5407c = null;
                    }
                }
                this.f5416m = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "setExtra");
        }
    }

    private static void a(Messenger messenger, int i10, Bundle bundle) {
        if (messenger != null) {
            try {
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = i10;
                messenger.send(obtain);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty() || this.f5419p) {
                    return;
                }
                this.f5419p = true;
                b(messenger);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    public final void b(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            fk.a(this.f5409e, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("b");
        this.f5405a = stringExtra2;
        fj.a(stringExtra2);
        String stringExtra3 = intent.getStringExtra("d");
        if (TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        fm.a(stringExtra3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger, AMapLocation aMapLocation, String str, com.autonavi.aps.amapapi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", aVar);
        this.f5411h.put(messenger, Long.valueOf(j.b()));
        a(messenger, 1, bundle);
    }

    public final void a(Messenger messenger, Bundle bundle, String str) {
        AMapLocationClientOption b4;
        float f10;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d10 = bundle.getDouble("lat");
                double d11 = bundle.getDouble("lon");
                float f11 = bundle.getFloat("radius");
                long j10 = bundle.getLong("time");
                if ("FINE_LOC".equals(str)) {
                    AMapLocation aMapLocation = new AMapLocation(GeocodeSearch.GPS);
                    aMapLocation.setLatitude(d10);
                    aMapLocation.setLocationType(1);
                    aMapLocation.setLongitude(d11);
                    aMapLocation.setAccuracy(f11);
                    aMapLocation.setTime(j10);
                    this.f5410f.a(aMapLocation);
                }
                if (com.autonavi.aps.amapapi.utils.a.h() && (b4 = b(bundle)) != null && b4.isNeedAddress()) {
                    a(b4);
                    AMapLocation aMapLocation2 = this.f5407c;
                    if (aMapLocation2 != null) {
                        f10 = j.a(new double[]{d10, d11, aMapLocation2.getLatitude(), this.f5407c.getLongitude()});
                        if (f10 < com.autonavi.aps.amapapi.utils.a.i() * 3) {
                            a(messenger, str);
                        }
                    } else {
                        f10 = -1.0f;
                    }
                    if (f10 == -1.0f || (f10 > com.autonavi.aps.amapapi.utils.a.i() && j.b() - this.f5427x > com.autonavi.aps.amapapi.utils.a.j() * 1000)) {
                        a(bundle);
                        this.f5407c = this.f5410f.a(d10, d11);
                        this.f5427x = j.b();
                        AMapLocation aMapLocation3 = this.f5407c;
                        if (aMapLocation3 == null || TextUtils.isEmpty(aMapLocation3.getAdCode())) {
                            return;
                        }
                        a(messenger, str);
                    }
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    private void a(Messenger messenger, String str) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i() * 3);
        bundle.putInt("I_MIN_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i());
        bundle.putParcelable("loc", this.f5407c);
        if ("COARSE_LOC".equals(str)) {
            a(messenger, 103, bundle);
        } else {
            a(messenger, 6, bundle);
        }
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(this.f5415l)) {
            this.f5415l = com.autonavi.aps.amapapi.utils.b.b(this.f5409e);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.f5415l);
    }
}
