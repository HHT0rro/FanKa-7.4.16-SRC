package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import android.view.textclassifier.TextClassifier;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.security.realidentity.build.bh;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.utils.b;
import org.json.JSONObject;
import sun.util.locale.LanguageTag;

/* compiled from: H5LocationClient.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public a f6337c;

    /* renamed from: d, reason: collision with root package name */
    private Context f6338d;

    /* renamed from: f, reason: collision with root package name */
    private WebView f6340f;

    /* renamed from: a, reason: collision with root package name */
    public Object f6335a = new Object();

    /* renamed from: e, reason: collision with root package name */
    private AMapLocationClient f6339e = null;

    /* renamed from: g, reason: collision with root package name */
    private String f6341g = "AMap.Geolocation.cbk";

    /* renamed from: b, reason: collision with root package name */
    public AMapLocationClientOption f6336b = null;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f6342h = false;

    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.i$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6344a;

        public AnonymousClass2(String str) {
            this.f6344a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.this.f6340f.loadUrl(bh.f3176j + i.this.f6341g + "('" + this.f6344a + "')");
        }
    }

    /* compiled from: H5LocationClient.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements AMapLocationListener {
        public a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (i.this.f6342h) {
                i.this.b(i.b(aMapLocation));
            }
        }
    }

    public i(Context context, WebView webView) {
        this.f6340f = null;
        this.f6337c = null;
        this.f6338d = context.getApplicationContext();
        this.f6340f = webView;
        this.f6337c = new a();
    }

    @JavascriptInterface
    public final void getLocation(String str) {
        synchronized (this.f6335a) {
            if (this.f6342h) {
                a(str);
                AMapLocationClient aMapLocationClient = this.f6339e;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(this.f6336b);
                    this.f6339e.stopLocation();
                    this.f6339e.startLocation();
                }
            }
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.f6342h && (aMapLocationClient = this.f6339e) != null) {
            aMapLocationClient.stopLocation();
        }
    }

    public final void b() {
        synchronized (this.f6335a) {
            this.f6342h = false;
            AMapLocationClient aMapLocationClient = this.f6339e;
            if (aMapLocationClient != null) {
                aMapLocationClient.unRegisterLocationListener(this.f6337c);
                this.f6339e.stopLocation();
                this.f6339e.onDestroy();
                this.f6339e = null;
            }
            this.f6336b = null;
        }
    }

    public final void a() {
        if (this.f6340f == null || this.f6338d == null || this.f6342h) {
            return;
        }
        try {
            this.f6340f.getSettings().setJavaScriptEnabled(true);
            this.f6340f.addJavascriptInterface(this, "AMapAndroidLoc");
            if (!TextUtils.isEmpty(this.f6340f.getUrl())) {
                this.f6340f.reload();
            }
            if (this.f6339e == null) {
                AMapLocationClient aMapLocationClient = new AMapLocationClient(this.f6338d);
                this.f6339e = aMapLocationClient;
                aMapLocationClient.setLocationListener(this.f6337c);
            }
            this.f6342h = true;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            WebView webView = this.f6340f;
            if (webView != null) {
                webView.evaluateJavascript(bh.f3176j + this.f6341g + "('" + str + "')", new ValueCallback<String>() { // from class: com.amap.api.col.3l.i.1
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            b.a(th, "H5LocationClient", "callbackJs()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(AMapLocation aMapLocation) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (aMapLocation == null) {
                jSONObject.put("errorCode", -1);
                jSONObject.put(MyLocationStyle.ERROR_INFO, "unknownError");
            } else if (aMapLocation.getErrorCode() == 0) {
                jSONObject.put("errorCode", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(LanguageTag.PRIVATEUSE, aMapLocation.getLongitude());
                jSONObject2.put("y", aMapLocation.getLatitude());
                jSONObject2.put("precision", aMapLocation.getAccuracy());
                jSONObject2.put("type", aMapLocation.getLocationType());
                jSONObject2.put("country", aMapLocation.getCountry());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity());
                jSONObject2.put("cityCode", aMapLocation.getCityCode());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
                jSONObject2.put("adCode", aMapLocation.getAdCode());
                jSONObject2.put("street", aMapLocation.getStreet());
                jSONObject2.put("streetNum", aMapLocation.getStreetNum());
                jSONObject2.put("floor", aMapLocation.getFloor());
                jSONObject2.put(TextClassifier.TYPE_ADDRESS, aMapLocation.getAddress());
                jSONObject.put("result", jSONObject2);
            } else {
                jSONObject.put("errorCode", aMapLocation.getErrorCode());
                jSONObject.put(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
                jSONObject.put("locationDetail", aMapLocation.getLocationDetail());
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:21:0x004e
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055 A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:19:0x004e, B:24:0x0055, B:25:0x0064, B:28:0x006a, B:30:0x006f, B:36:0x005d), top: B:18:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f A[Catch: all -> 0x0077, TRY_LEAVE, TryCatch #0 {all -> 0x0077, blocks: (B:19:0x004e, B:24:0x0055, B:25:0x0064, B:28:0x006a, B:30:0x006f, B:36:0x005d), top: B:18:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:19:0x004e, B:24:0x0055, B:25:0x0064, B:28:0x006a, B:30:0x006f, B:36:0x005d), top: B:18:0x004e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r10) {
        /*
            r9 = this;
            com.amap.api.location.AMapLocationClientOption r0 = r9.f6336b
            if (r0 != 0) goto Lb
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption
            r0.<init>()
            r9.f6336b = r0
        Lb:
            r0 = 5
            r1 = 30000(0x7530, double:1.4822E-319)
            r3 = 1
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4c
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r10 = "to"
            long r1 = r5.optLong(r10, r1)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r10 = "useGPS"
            int r10 = r5.optInt(r10, r3)     // Catch: java.lang.Throwable -> L4c
            if (r10 != r3) goto L25
            r10 = 1
            goto L26
        L25:
            r10 = 0
        L26:
            java.lang.String r6 = "watch"
            int r6 = r5.optInt(r6, r4)     // Catch: java.lang.Throwable -> L4d
            if (r6 != r3) goto L30
            r6 = 1
            goto L31
        L30:
            r6 = 0
        L31:
            java.lang.String r7 = "interval"
            int r0 = r5.optInt(r7, r0)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r7 = "callback"
            r8 = 0
            java.lang.String r5 = r5.optString(r7, r8)     // Catch: java.lang.Throwable -> L4e
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L4e
            if (r7 != 0) goto L47
            r9.f6341g = r5     // Catch: java.lang.Throwable -> L4e
            goto L4e
        L47:
            java.lang.String r5 = "AMap.Geolocation.cbk"
            r9.f6341g = r5     // Catch: java.lang.Throwable -> L4e
            goto L4e
        L4c:
            r10 = 0
        L4d:
            r6 = 0
        L4e:
            com.amap.api.location.AMapLocationClientOption r5 = r9.f6336b     // Catch: java.lang.Throwable -> L77
            r5.setHttpTimeOut(r1)     // Catch: java.lang.Throwable -> L77
            if (r10 == 0) goto L5d
            com.amap.api.location.AMapLocationClientOption r10 = r9.f6336b     // Catch: java.lang.Throwable -> L77
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy     // Catch: java.lang.Throwable -> L77
            r10.setLocationMode(r1)     // Catch: java.lang.Throwable -> L77
            goto L64
        L5d:
            com.amap.api.location.AMapLocationClientOption r10 = r9.f6336b     // Catch: java.lang.Throwable -> L77
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving     // Catch: java.lang.Throwable -> L77
            r10.setLocationMode(r1)     // Catch: java.lang.Throwable -> L77
        L64:
            com.amap.api.location.AMapLocationClientOption r10 = r9.f6336b     // Catch: java.lang.Throwable -> L77
            if (r6 != 0) goto L69
            goto L6a
        L69:
            r3 = 0
        L6a:
            r10.setOnceLocation(r3)     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L77
            com.amap.api.location.AMapLocationClientOption r10 = r9.f6336b     // Catch: java.lang.Throwable -> L77
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L77
            r10.setInterval(r0)     // Catch: java.lang.Throwable -> L77
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.i.a(java.lang.String):void");
    }
}
