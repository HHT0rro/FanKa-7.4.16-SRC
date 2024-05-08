package com.amap.api.col.p0003l;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.GeoFenceListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.DPoint;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.openalliance.ad.constant.as;
import com.huawei.quickcard.base.Attributes;
import com.jd.ad.sdk.dl.model.JADSlot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: GeoFenceManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {
    private static boolean A;

    /* renamed from: b, reason: collision with root package name */
    public Context f4838b;

    /* renamed from: a, reason: collision with root package name */
    public h f4837a = null;

    /* renamed from: c, reason: collision with root package name */
    public PendingIntent f4839c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f4840d = null;

    /* renamed from: e, reason: collision with root package name */
    public GeoFenceListener f4841e = null;

    /* renamed from: z, reason: collision with root package name */
    private Object f4862z = new Object();

    /* renamed from: f, reason: collision with root package name */
    public volatile int f4842f = 1;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<GeoFence> f4843g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public c f4844h = null;

    /* renamed from: i, reason: collision with root package name */
    public Object f4845i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public Object f4846j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public HandlerC0099a f4847k = null;

    /* renamed from: l, reason: collision with root package name */
    public b f4848l = null;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f4849m = false;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f4850n = false;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f4851o = false;

    /* renamed from: p, reason: collision with root package name */
    public com.amap.api.col.p0003l.b f4852p = null;

    /* renamed from: q, reason: collision with root package name */
    public com.amap.api.col.p0003l.c f4853q = null;

    /* renamed from: r, reason: collision with root package name */
    public AMapLocationClient f4854r = null;

    /* renamed from: s, reason: collision with root package name */
    public volatile AMapLocation f4855s = null;

    /* renamed from: t, reason: collision with root package name */
    public long f4856t = 0;

    /* renamed from: u, reason: collision with root package name */
    public AMapLocationClientOption f4857u = null;

    /* renamed from: v, reason: collision with root package name */
    public int f4858v = 0;

    /* renamed from: w, reason: collision with root package name */
    public AMapLocationListener f4859w = new AMapLocationListener() { // from class: com.amap.api.col.3l.a.1
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            boolean z10;
            int i10;
            try {
                if (!a.this.f4861y && a.this.f4851o) {
                    a.this.f4855s = aMapLocation;
                    if (aMapLocation != null) {
                        i10 = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            a.this.f4856t = j.b();
                            a.this.a(5, (Bundle) null, 0L);
                            z10 = true;
                        } else {
                            a.a("定位失败", aMapLocation.getErrorCode(), aMapLocation.getErrorInfo(), "locationDetail:" + aMapLocation.getLocationDetail());
                            z10 = false;
                        }
                    } else {
                        z10 = false;
                        i10 = 8;
                    }
                    if (z10) {
                        a aVar = a.this;
                        aVar.f4858v = 0;
                        aVar.a(6, (Bundle) null, 0L);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (!a.this.f4849m) {
                        a.this.b(7);
                        bundle.putLong(Attributes.Style.INTERVAL, 2000L);
                        a.this.a(8, bundle, 2000L);
                    }
                    a aVar2 = a.this;
                    int i11 = aVar2.f4858v + 1;
                    aVar2.f4858v = i11;
                    if (i11 >= 3) {
                        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i10);
                        a.this.a(1002, bundle);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    };

    /* renamed from: x, reason: collision with root package name */
    public final int f4860x = 3;

    /* renamed from: y, reason: collision with root package name */
    public volatile boolean f4861y = false;

    /* compiled from: GeoFenceManager.java */
    /* renamed from: com.amap.api.col.3l.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class HandlerC0099a extends Handler {
        public HandlerC0099a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.this.b(message.getData());
                        return;
                    case 1:
                        a.this.c(message.getData());
                        return;
                    case 2:
                        a.this.e(message.getData());
                        return;
                    case 3:
                        a.this.d(message.getData());
                        return;
                    case 4:
                        a.this.f(message.getData());
                        return;
                    case 5:
                        a.this.e();
                        return;
                    case 6:
                        a aVar = a.this;
                        aVar.a(aVar.f4855s);
                        return;
                    case 7:
                        a.this.d();
                        return;
                    case 8:
                        a.this.j(message.getData());
                        return;
                    case 9:
                        a.this.a(message.getData());
                        return;
                    case 10:
                        a.this.c();
                        return;
                    case 11:
                        a.this.h(message.getData());
                        return;
                    case 12:
                        a.this.g(message.getData());
                        return;
                    case 13:
                        a.this.g();
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: GeoFenceManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public a(Context context) {
        this.f4838b = null;
        try {
            this.f4838b = context.getApplicationContext();
            j();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "<init>");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x002b -> B:12:0x0030). Please report as a decompilation issue!!! */
    private void j() {
        if (!this.f4851o) {
            this.f4851o = true;
        }
        if (this.f4850n) {
            return;
        }
        try {
            if (Looper.myLooper() == null) {
                this.f4844h = new c(this.f4838b.getMainLooper());
            } else {
                this.f4844h = new c();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManger", "init 1");
        }
        try {
            b bVar = new b("fenceActionThread");
            this.f4848l = bVar;
            bVar.setPriority(5);
            this.f4848l.start();
            this.f4847k = new HandlerC0099a(this.f4848l.getLooper());
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "GeoFenceManger", "init 2");
        }
        try {
            this.f4852p = new com.amap.api.col.p0003l.b(this.f4838b);
            this.f4853q = new com.amap.api.col.p0003l.c();
            this.f4857u = new AMapLocationClientOption();
            this.f4854r = new AMapLocationClient(this.f4838b);
            this.f4857u.setLocationCacheEnable(true);
            this.f4857u.setNeedAddress(false);
            this.f4854r.setLocationListener(this.f4859w);
            if (this.f4837a == null) {
                this.f4837a = new h();
            }
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "GeoFenceManger", "initBase");
        }
        this.f4850n = true;
        try {
            String str = this.f4840d;
            if (str != null && this.f4839c == null) {
                a(str);
            }
        } catch (Throwable th4) {
            com.autonavi.aps.amapapi.utils.b.a(th4, "GeoFenceManger", "init 4");
        }
        if (A) {
            return;
        }
        A = true;
        h.a(this.f4838b, "O020", (JSONObject) null);
    }

    private boolean k() {
        ArrayList<GeoFence> arrayList = this.f4843g;
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        Iterator<GeoFence> iterator2 = this.f4843g.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().isAble()) {
                return false;
            }
        }
        return true;
    }

    private void l() {
        try {
            synchronized (this.f4846j) {
                c cVar = this.f4844h;
                if (cVar != null) {
                    cVar.removeCallbacksAndMessages(null);
                }
                this.f4844h = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "destroyResultHandler");
        }
    }

    private void m() {
        try {
            synchronized (this.f4845i) {
                HandlerC0099a handlerC0099a = this.f4847k;
                if (handlerC0099a != null) {
                    handlerC0099a.removeCallbacksAndMessages(null);
                }
                this.f4847k = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "destroyActionHandler");
        }
    }

    private void n() {
        if (this.f4861y || this.f4847k == null) {
            return;
        }
        if (p()) {
            a(6, (Bundle) null, 0L);
            a(5, (Bundle) null, 0L);
        } else {
            b(7);
            a(7, (Bundle) null, 0L);
        }
    }

    private void o() {
        try {
            if (this.f4849m) {
                b(8);
            }
            AMapLocationClient aMapLocationClient = this.f4854r;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f4849m = false;
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        return this.f4855s != null && j.a(this.f4855s) && j.b() - this.f4856t < 10000;
    }

    public final PendingIntent a(String str) {
        synchronized (this.f4862z) {
            try {
                Intent intent = new Intent(str);
                intent.setPackage(fj.c(this.f4838b));
                if (Build.VERSION.SDK_INT >= 31 && this.f4838b.getApplicationInfo().targetSdkVersion >= 31) {
                    this.f4839c = PendingIntent.getBroadcast(this.f4838b, 0, intent, 33554432);
                } else {
                    this.f4839c = PendingIntent.getBroadcast(this.f4838b, 0, intent, 0);
                }
                this.f4840d = str;
                ArrayList<GeoFence> arrayList = this.f4843g;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> iterator2 = this.f4843g.iterator2();
                    while (iterator2.hasNext()) {
                        GeoFence next = iterator2.next();
                        next.setPendingIntent(this.f4839c);
                        next.setPendingIntentAction(this.f4840d);
                    }
                }
            } finally {
                return this.f4839c;
            }
        }
        return this.f4839c;
    }

    public final void b(Bundle bundle) {
        String str;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str2 = "";
            int i10 = 1;
            if (bundle != null && !bundle.isEmpty()) {
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                        GeoFence a10 = a(bundle, false);
                        i10 = c(a10);
                        if (i10 == 0) {
                            arrayList.add(a10);
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("errorCode", i10);
                        bundle2.putParcelableArrayList("resultList", arrayList);
                        bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                        a(1000, bundle2);
                    }
                    a("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    Bundle bundle22 = new Bundle();
                    bundle22.putInt("errorCode", i10);
                    bundle22.putParcelableArrayList("resultList", arrayList);
                    bundle22.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
                    a(1000, bundle22);
                }
                str2 = str;
            }
            str = str2;
            Bundle bundle222 = new Bundle();
            bundle222.putInt("errorCode", i10);
            bundle222.putParcelableArrayList("resultList", arrayList);
            bundle222.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1000, bundle222);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    public final void c(Bundle bundle) {
        GeoFence a10;
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            String str = "";
            int i10 = 1;
            if (bundle != null && !bundle.isEmpty()) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null && parcelableArrayList.size() > 2 && (i10 = c((a10 = a(bundle, true)))) == 0) {
                    arrayList.add(a10);
                }
                str = string;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt("errorCode", i10);
            bundle2.putParcelableArrayList("resultList", arrayList);
            a(1000, bundle2);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    public final void d(Bundle bundle) {
        b(2, bundle);
    }

    public final void e(Bundle bundle) {
        b(1, bundle);
    }

    public final void f(Bundle bundle) {
        b(3, bundle);
    }

    public final void g(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                String string = bundle.getString("fid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                boolean z10 = bundle.getBoolean("ab", true);
                ArrayList<GeoFence> arrayList = this.f4843g;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<GeoFence> iterator2 = this.f4843g.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        GeoFence next = iterator2.next();
                        if (next.getFenceId().equals(string)) {
                            next.setAble(z10);
                            break;
                        }
                    }
                }
                if (!z10) {
                    if (k()) {
                        g();
                        return;
                    }
                    return;
                }
                n();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    public final void h(Bundle bundle) {
        try {
            if (this.f4843g != null) {
                GeoFence geoFence = (GeoFence) bundle.getParcelable("fc");
                if (this.f4843g.contains(geoFence)) {
                    this.f4843g.remove(geoFence);
                }
                if (this.f4843g.size() <= 0) {
                    c();
                } else {
                    n();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void i(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                int i10 = bundle.getInt("errorCode");
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                if (parcelableArrayList == null) {
                    parcelableArrayList = new ArrayList();
                }
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                if (string == null) {
                    string = "";
                }
                GeoFenceListener geoFenceListener = this.f4841e;
                if (geoFenceListener != null) {
                    geoFenceListener.onGeoFenceCreateFinished((ArrayList) parcelableArrayList.clone(), i10, string);
                }
                if (i10 == 0) {
                    n();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    /* compiled from: GeoFenceManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        a.this.i(data);
                        return;
                    case 1001:
                        try {
                            a.this.b((GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    case 1002:
                        try {
                            a.this.c(data.getInt(GeoFence.BUNDLE_KEY_LOCERRORCODE));
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }

        public c() {
        }
    }

    private void d(GeoFence geoFence) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("geoFence", geoFence);
        a(1001, bundle);
    }

    public final void e() {
        try {
            if (!this.f4861y && j.a(this.f4855s)) {
                float a10 = a(this.f4855s, this.f4843g);
                if (a10 == Float.MAX_VALUE) {
                    return;
                }
                if (a10 < 1000.0f) {
                    b(7);
                    Bundle bundle = new Bundle();
                    bundle.putLong(Attributes.Style.INTERVAL, 2000L);
                    a(8, bundle, 500L);
                    return;
                }
                if (a10 < 5000.0f) {
                    o();
                    b(7);
                    a(7, (Bundle) null, 10000L);
                } else {
                    o();
                    b(7);
                    a(7, (Bundle) null, ((a10 - 4000.0f) / 100.0f) * 1000.0f);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    public final void f() {
        try {
            j();
            this.f4861y = true;
            a(13, (Bundle) null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    public final void d() {
        try {
            if (this.f4854r != null) {
                o();
                this.f4857u.setOnceLocation(true);
                this.f4854r.setLocationOption(this.f4857u);
                this.f4854r.startLocation();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    public final void h() {
        try {
            j();
            if (this.f4861y) {
                this.f4861y = false;
                n();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    public final boolean i() {
        return this.f4861y;
    }

    private static int d(int i10) {
        if (i10 != 1 && i10 != 7 && i10 != 4 && i10 != 5 && i10 != 16 && i10 != 17) {
            switch (i10) {
                case 10000:
                    i10 = 0;
                    break;
                case 10001:
                case 10002:
                case 10007:
                case 10008:
                case BaseBioNavigatorActivity.f2177j /* 10009 */:
                case 10012:
                case 10013:
                    i10 = 7;
                    break;
                case 10003:
                case 10004:
                case 10005:
                case JADSlot.MediaSpecSetType.MEDIA_SPEC_SET_TYPE_FEED2_1_SINGLE /* 10006 */:
                case BaseBioNavigatorActivity.f2178k /* 10010 */:
                case RequestManager.NOTIFY_CONNECT_SUCCESS /* 10011 */:
                case 10014:
                case 10015:
                case 10016:
                case 10017:
                    i10 = 4;
                    break;
                default:
                    switch (i10) {
                        case 20000:
                        case 20001:
                        case 20002:
                            i10 = 1;
                            break;
                        case 20003:
                        default:
                            i10 = 8;
                            break;
                    }
            }
        }
        if (i10 != 0) {
            a("添加围栏失败", i10, "searchErrCode is ".concat(String.valueOf(i10)), new String[0]);
        }
        return i10;
    }

    public final void g() {
        try {
            b(7);
            b(8);
            AMapLocationClient aMapLocationClient = this.f4854r;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.f4849m = false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    public final void c() {
        if (this.f4850n) {
            ArrayList<GeoFence> arrayList = this.f4843g;
            if (arrayList != null) {
                arrayList.clear();
                this.f4843g = null;
            }
            if (this.f4851o) {
                return;
            }
            m();
            AMapLocationClient aMapLocationClient = this.f4854r;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
                this.f4854r.onDestroy();
            }
            this.f4854r = null;
            b bVar = this.f4848l;
            if (bVar != null) {
                bVar.quitSafely();
            }
            this.f4848l = null;
            this.f4852p = null;
            synchronized (this.f4862z) {
                PendingIntent pendingIntent = this.f4839c;
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                this.f4839c = null;
            }
            l();
            h hVar = this.f4837a;
            if (hVar != null) {
                hVar.b(this.f4838b);
            }
            this.f4849m = false;
            this.f4850n = false;
        }
    }

    public final void a(int i10) {
        try {
            j();
            if (i10 > 7 || i10 <= 0) {
                i10 = 1;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("activatesAction", i10);
            a(9, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "setActivateAction");
        }
    }

    private void b(int i10, Bundle bundle) {
        String str;
        int i11;
        String str2;
        int i12;
        String str3;
        String str4;
        String a10;
        Bundle bundle2 = new Bundle();
        try {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                str2 = "errorCode";
                i12 = 1;
            } else {
                List<GeoFence> arrayList2 = new ArrayList<>();
                String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string2 = bundle.getString(as.f32241p);
                String string3 = bundle.getString(DistrictSearchQuery.KEYWORDS_CITY);
                String string4 = bundle.getString("poiType");
                DPoint dPoint = (DPoint) bundle.getParcelable("centerPoint");
                int i13 = bundle.getInt("searchSize", 10);
                float f10 = bundle.getFloat("aroundRadius", 3000.0f);
                if (a(i10, string2, string4, dPoint)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(GeoFence.BUNDLE_KEY_CUSTOMID, string);
                    bundle3.putString("pendingIntentAction", this.f4840d);
                    str3 = GeoFence.BUNDLE_KEY_CUSTOMID;
                    str4 = "errorCode";
                    try {
                        bundle3.putLong("expiration", -1L);
                        bundle3.putInt("activatesAction", this.f4842f);
                        if (i10 == 1) {
                            bundle3.putFloat("fenceRadius", 1000.0f);
                            a10 = this.f4852p.a(this.f4838b, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, String.valueOf(i13));
                        } else if (i10 != 2) {
                            a10 = i10 != 3 ? null : this.f4852p.a(this.f4838b, "http://restsdk.amap.com/v3/config/district?", string2);
                        } else {
                            double b4 = j.b(dPoint.getLatitude());
                            double b10 = j.b(dPoint.getLongitude());
                            int intValue = Float.valueOf(f10).intValue();
                            bundle3.putFloat("fenceRadius", 200.0f);
                            a10 = this.f4852p.a(this.f4838b, "http://restsdk.amap.com/v3/place/around?", string2, string4, String.valueOf(i13), String.valueOf(b4), String.valueOf(b10), String.valueOf(intValue));
                        }
                        if (a10 != null) {
                            int a11 = 1 == i10 ? com.amap.api.col.p0003l.c.a(a10, arrayList2, bundle3) : 0;
                            if (2 == i10) {
                                a11 = com.amap.api.col.p0003l.c.b(a10, arrayList2, bundle3);
                            }
                            if (3 == i10) {
                                a11 = this.f4853q.c(a10, arrayList2, bundle3);
                            }
                            if (a11 == 10000) {
                                if (arrayList2.isEmpty()) {
                                    i11 = 16;
                                } else {
                                    i11 = a(arrayList2);
                                    if (i11 == 0) {
                                        try {
                                            arrayList.addAll(arrayList2);
                                        } catch (Throwable th) {
                                            th = th;
                                            str = str4;
                                            try {
                                                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                                bundle2.putInt(str, 8);
                                                a(1000, bundle2);
                                                return;
                                            } catch (Throwable th2) {
                                                bundle2.putInt(str, i11);
                                                a(1000, bundle2);
                                                throw th2;
                                            }
                                        }
                                    }
                                }
                            } else {
                                i11 = d(a11);
                            }
                        } else {
                            i11 = 4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = str4;
                        i11 = 0;
                        com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                        bundle2.putInt(str, 8);
                        a(1000, bundle2);
                        return;
                    }
                } else {
                    str3 = GeoFence.BUNDLE_KEY_CUSTOMID;
                    str4 = "errorCode";
                    i11 = 1;
                }
                bundle2.putString(str3, string);
                bundle2.putParcelableArrayList("resultList", arrayList);
                i12 = i11;
                str2 = str4;
            }
            bundle2.putInt(str2, i12);
            a(1000, bundle2);
        } catch (Throwable th4) {
            th = th4;
            str = "errorCode";
        }
    }

    public final void a(Bundle bundle) {
        int i10 = 1;
        if (bundle != null) {
            try {
                i10 = bundle.getInt("activatesAction", 1);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f4842f != i10) {
            ArrayList<GeoFence> arrayList = this.f4843g;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<GeoFence> iterator2 = this.f4843g.iterator2();
                while (iterator2.hasNext()) {
                    GeoFence next = iterator2.next();
                    next.setStatus(0);
                    next.setEnterTime(-1L);
                }
            }
            n();
        }
        this.f4842f = i10;
    }

    public final void j(Bundle bundle) {
        try {
            if (this.f4854r != null) {
                long j10 = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j10 = bundle.getLong(Attributes.Style.INTERVAL, 2000L);
                }
                this.f4857u.setOnceLocation(false);
                this.f4857u.setInterval(j10);
                this.f4854r.setLocationOption(this.f4857u);
                if (this.f4849m) {
                    return;
                }
                this.f4854r.stopLocation();
                this.f4854r.startLocation();
                this.f4849m = true;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }

    public final void a(GeoFenceListener geoFenceListener) {
        try {
            this.f4841e = geoFenceListener;
        } catch (Throwable unused) {
        }
    }

    public final void a(DPoint dPoint, float f10, String str) {
        try {
            j();
            Bundle bundle = new Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f10);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(0, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final void a(List<DPoint> list, String str) {
        try {
            j();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pointList", new ArrayList<>(list));
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    private int c(GeoFence geoFence) {
        try {
            if (this.f4843g == null) {
                this.f4843g = new ArrayList<>();
            }
            if (this.f4843g.contains(geoFence)) {
                return 17;
            }
            this.f4843g.add(geoFence);
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFence2List");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    private GeoFence a(Bundle bundle, boolean z10) {
        GeoFence geoFence = new GeoFence();
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = new DPoint();
        if (z10) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = b(arrayList);
            }
            geoFence.setMaxDis2Center(b(dPoint, arrayList));
            geoFence.setMinDis2Center(a(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f10 = bundle.getFloat("fenceRadius", 1000.0f);
            float f11 = f10 > 0.0f ? f10 : 1000.0f;
            geoFence.setRadius(f11);
            geoFence.setMinDis2Center(f11);
            geoFence.setMaxDis2Center(f11);
        }
        geoFence.setActivatesAction(this.f4842f);
        geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.f4840d);
        geoFence.setExpiration(-1L);
        geoFence.setPendingIntent(this.f4839c);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.amap.api.col.p0003l.c.a());
        geoFence.setFenceId(sb2.toString());
        h hVar = this.f4837a;
        if (hVar != null) {
            hVar.a(this.f4838b, 2);
        }
        return geoFence;
    }

    public final void c(int i10) {
        try {
            if (this.f4838b != null) {
                synchronized (this.f4862z) {
                    if (this.f4839c == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(a((GeoFence) null, (String) null, (String) null, 4, i10));
                    this.f4839c.send(this.f4838b, 0, intent);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    public final List<GeoFence> b() {
        try {
            if (this.f4843g == null) {
                this.f4843g = new ArrayList<>();
            }
            return (ArrayList) this.f4843g.clone();
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public final void a(String str, String str2, DPoint dPoint, float f10, int i10, String str3) {
        try {
            j();
            if (f10 <= 0.0f || f10 > 50000.0f) {
                f10 = 3000.0f;
            }
            if (i10 <= 0) {
                i10 = 10;
            }
            if (i10 > 25) {
                i10 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString(as.f32241p, str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f10);
            bundle.putInt("searchSize", i10);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            a(3, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public final void b(int i10) {
        try {
            synchronized (this.f4845i) {
                HandlerC0099a handlerC0099a = this.f4847k;
                if (handlerC0099a != null) {
                    handlerC0099a.removeMessages(i10);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    public final void b(GeoFence geoFence) {
        try {
            synchronized (this.f4862z) {
                if (this.f4838b != null) {
                    if (this.f4839c == null && geoFence.getPendingIntent() == null) {
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtras(a(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                    String str = this.f4840d;
                    if (str != null) {
                        intent.setAction(str);
                    }
                    intent.setPackage(fj.c(this.f4838b));
                    if (geoFence.getPendingIntent() != null) {
                        geoFence.getPendingIntent().send(this.f4838b, 0, intent);
                    } else {
                        this.f4839c.send(this.f4838b, 0, intent);
                    }
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    public final void a(String str, String str2, String str3, int i10, String str4) {
        try {
            j();
            if (i10 <= 0) {
                i10 = 10;
            }
            if (i10 > 25) {
                i10 = 25;
            }
            Bundle bundle = new Bundle();
            bundle.putString(as.f32241p, str);
            bundle.putString("poiType", str2);
            bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, str3);
            bundle.putInt("searchSize", i10);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            a(2, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void a(String str, String str2) {
        try {
            j();
            Bundle bundle = new Bundle();
            bundle.putString(as.f32241p, str);
            bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            a(4, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    private static boolean a(int i10, String str, String str2, DPoint dPoint) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i10 != 1) {
            if (i10 == 2) {
                if (dPoint == null) {
                    return false;
                }
                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    a("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new String[0]);
                    return false;
                }
            }
        } else if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    private static DPoint b(List<DPoint> list) {
        DPoint dPoint = new DPoint();
        if (list == null) {
            return dPoint;
        }
        try {
            double d10 = ShadowDrawableWrapper.COS_45;
            double d11 = 0.0d;
            for (DPoint dPoint2 : list) {
                d10 += dPoint2.getLatitude();
                d11 += dPoint2.getLongitude();
            }
            return new DPoint(j.b(d10 / list.size()), j.b(d11 / list.size()));
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceUtil", "getPolygonCenter");
            return dPoint;
        }
    }

    public static float b(DPoint dPoint, List<DPoint> list) {
        float f10 = Float.MIN_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            Iterator<DPoint> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                f10 = Math.max(f10, j.a(dPoint, iterator2.next()));
            }
        }
        return f10;
    }

    public final void a() {
        try {
            this.f4851o = false;
            a(10, (Bundle) null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    private static boolean b(AMapLocation aMapLocation, List<DPoint> list) {
        if (list.size() < 3) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.b.a(new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list);
    }

    public final boolean a(GeoFence geoFence) {
        try {
            ArrayList<GeoFence> arrayList = this.f4843g;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (!this.f4843g.contains(geoFence)) {
                    return false;
                }
                if (this.f4843g.size() == 1) {
                    this.f4851o = false;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("fc", geoFence);
                a(11, bundle, 0L);
                return true;
            }
            this.f4851o = false;
            a(10, (Bundle) null, 0L);
            return true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    private static boolean b(AMapLocation aMapLocation, GeoFence geoFence) {
        boolean z10 = true;
        try {
            if (!a(aMapLocation, geoFence)) {
                if (geoFence.getStatus() != 2) {
                    try {
                        geoFence.setStatus(2);
                        geoFence.setEnterTime(-1L);
                    } catch (Throwable th) {
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "Utils", "isFenceStatusChanged");
                        return z10;
                    }
                }
                z10 = false;
            } else if (geoFence.getEnterTime() == -1) {
                if (geoFence.getStatus() != 1) {
                    geoFence.setEnterTime(j.b());
                    geoFence.setStatus(1);
                }
                z10 = false;
            } else {
                if (geoFence.getStatus() != 3 && j.b() - geoFence.getEnterTime() > TTAdConstant.AD_MAX_EVENT_TIME) {
                    geoFence.setStatus(3);
                }
                z10 = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
        }
        return z10;
    }

    public final void a(String str, boolean z10) {
        try {
            j();
            Bundle bundle = new Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z10);
            a(12, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    private int a(List<GeoFence> list) {
        try {
            if (this.f4843g == null) {
                this.f4843g = new ArrayList<>();
            }
            Iterator<GeoFence> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                c(iterator2.next());
            }
            return 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "addGeoFenceList");
            a("添加围栏失败", 8, th.getMessage(), new String[0]);
            return 8;
        }
    }

    public final void a(int i10, Bundle bundle, long j10) {
        try {
            synchronized (this.f4845i) {
                HandlerC0099a handlerC0099a = this.f4847k;
                if (handlerC0099a != null) {
                    Message obtainMessage = handlerC0099a.obtainMessage();
                    obtainMessage.what = i10;
                    obtainMessage.setData(bundle);
                    this.f4847k.sendMessageDelayed(obtainMessage, j10);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    public final void a(int i10, Bundle bundle) {
        try {
            synchronized (this.f4846j) {
                c cVar = this.f4844h;
                if (cVar != null) {
                    Message obtainMessage = cVar.obtainMessage();
                    obtainMessage.what = i10;
                    obtainMessage.setData(bundle);
                    this.f4844h.sendMessage(obtainMessage);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    private static Bundle a(GeoFence geoFence, String str, String str2, int i10, int i11) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i10);
        bundle.putInt(GeoFence.BUNDLE_KEY_LOCERRORCODE, i11);
        bundle.putParcelable(GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    public final void a(AMapLocation aMapLocation) {
        ArrayList<GeoFence> arrayList;
        try {
            if (this.f4861y || (arrayList = this.f4843g) == null || arrayList.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
                return;
            }
            Iterator<GeoFence> iterator2 = this.f4843g.iterator2();
            while (iterator2.hasNext()) {
                GeoFence next = iterator2.next();
                if (next.isAble() && b(aMapLocation, next) && a(next, this.f4842f)) {
                    next.setCurrentLocation(aMapLocation);
                    d(next);
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    private static float a(AMapLocation aMapLocation, List<GeoFence> list) {
        float f10 = Float.MAX_VALUE;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && list != null && !list.isEmpty()) {
            DPoint dPoint = new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            for (GeoFence geoFence : list) {
                if (geoFence.isAble()) {
                    float a10 = j.a(dPoint, geoFence.getCenter());
                    if (a10 > geoFence.getMinDis2Center() && a10 < geoFence.getMaxDis2Center()) {
                        return 0.0f;
                    }
                    if (a10 > geoFence.getMaxDis2Center()) {
                        f10 = Math.min(f10, a10 - geoFence.getMaxDis2Center());
                    }
                    if (a10 < geoFence.getMinDis2Center()) {
                        f10 = Math.min(f10, geoFence.getMinDis2Center() - a10);
                    }
                }
            }
        }
        return f10;
    }

    public static float a(DPoint dPoint, List<DPoint> list) {
        float f10 = Float.MAX_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            Iterator<DPoint> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                f10 = Math.min(f10, j.a(dPoint, iterator2.next()));
            }
        }
        return f10;
    }

    private static boolean a(AMapLocation aMapLocation, DPoint dPoint, float f10) {
        return j.a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= f10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0056, code lost:
    
        if (a(r4, r5.getCenter(), r5.getRadius()) != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.amap.api.location.AMapLocation r4, com.amap.api.fence.GeoFence r5) {
        /*
            r0 = 1
            r1 = 0
            boolean r2 = com.autonavi.aps.amapapi.utils.j.a(r4)     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L59
            if (r5 == 0) goto L59
            java.util.List r2 = r5.getPointList()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L59
            java.util.List r2 = r5.getPointList()     // Catch: java.lang.Throwable -> L5b
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L5b
            if (r2 != 0) goto L59
            int r2 = r5.getType()     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L4a
            if (r2 == r0) goto L29
            r3 = 2
            if (r2 == r3) goto L4a
            r3 = 3
            if (r2 == r3) goto L29
            goto L59
        L29:
            java.util.List r5 = r5.getPointList()     // Catch: java.lang.Throwable -> L5b
            java.util.Iterator r5 = r5.iterator2()     // Catch: java.lang.Throwable -> L5b
        L31:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L45
            java.lang.Object r2 = r5.next()     // Catch: java.lang.Throwable -> L47
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L47
            boolean r2 = b(r4, r2)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L31
            r1 = 1
            goto L31
        L45:
            r0 = r1
            goto L64
        L47:
            r4 = move-exception
            r0 = r1
            goto L5d
        L4a:
            com.amap.api.location.DPoint r2 = r5.getCenter()     // Catch: java.lang.Throwable -> L5b
            float r5 = r5.getRadius()     // Catch: java.lang.Throwable -> L5b
            boolean r4 = a(r4, r2, r5)     // Catch: java.lang.Throwable -> L5b
            if (r4 == 0) goto L59
            goto L64
        L59:
            r0 = 0
            goto L64
        L5b:
            r4 = move-exception
            r0 = 0
        L5d:
            java.lang.String r5 = "Utils"
            java.lang.String r1 = "isInGeoFence"
            com.autonavi.aps.amapapi.utils.b.a(r4, r5, r1)
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.a.a(com.amap.api.location.AMapLocation, com.amap.api.fence.GeoFence):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r4.getStatus() == 3) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.amap.api.fence.GeoFence r4, int r5) {
        /*
            r0 = r5 & 1
            r1 = 1
            r2 = 0
            if (r0 != r1) goto L10
            int r0 = r4.getStatus()     // Catch: java.lang.Throwable -> Le
            if (r0 != r1) goto L10
            r2 = 1
            goto L10
        Le:
            r4 = move-exception
            goto L28
        L10:
            r0 = r5 & 2
            r3 = 2
            if (r0 != r3) goto L1c
            int r0 = r4.getStatus()     // Catch: java.lang.Throwable -> Le
            if (r0 != r3) goto L1c
            r2 = 1
        L1c:
            r0 = 4
            r5 = r5 & r0
            if (r5 != r0) goto L30
            int r4 = r4.getStatus()     // Catch: java.lang.Throwable -> Le
            r5 = 3
            if (r4 != r5) goto L30
            goto L31
        L28:
            java.lang.String r5 = "Utils"
            java.lang.String r0 = "remindStatus"
            com.autonavi.aps.amapapi.utils.b.a(r4, r5, r0)
            goto L32
        L30:
            r1 = r2
        L31:
            r2 = r1
        L32:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.a.a(com.amap.api.fence.GeoFence, int):boolean");
    }

    public static void a(String str, int i10, String str2, String... strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(String.valueOf(i10)));
        stringBuffer.append("\n");
        stringBuffer.append("错误信息:".concat(String.valueOf(str2)));
        stringBuffer.append("\n");
        if (strArr.length > 0) {
            for (String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
    }
}
