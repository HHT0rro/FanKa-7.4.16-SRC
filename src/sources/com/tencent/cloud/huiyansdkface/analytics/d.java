package com.tencent.cloud.huiyansdkface.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.analytics.EventSender;
import com.tencent.cloud.huiyansdkface.wehttp2.BaseCallback;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f40467a = "d";

    /* renamed from: c, reason: collision with root package name */
    public static String f40468c = "ecifNo";

    /* renamed from: d, reason: collision with root package name */
    public static String f40469d = "unionId";

    /* renamed from: e, reason: collision with root package name */
    public static String f40470e = "openId";

    /* renamed from: f, reason: collision with root package name */
    public static String f40471f = "filedY0";

    /* renamed from: g, reason: collision with root package name */
    public static Context f40472g = null;

    /* renamed from: q, reason: collision with root package name */
    private static String f40473q = "subAppId";

    /* renamed from: r, reason: collision with root package name */
    private static String f40474r = "appVersion";

    /* renamed from: i, reason: collision with root package name */
    public String f40477i;

    /* renamed from: j, reason: collision with root package name */
    private int f40478j;

    /* renamed from: k, reason: collision with root package name */
    private String f40479k;

    /* renamed from: l, reason: collision with root package name */
    private String f40480l;

    /* renamed from: m, reason: collision with root package name */
    private float f40481m;

    /* renamed from: n, reason: collision with root package name */
    private String f40482n;

    /* renamed from: o, reason: collision with root package name */
    private String f40483o;

    /* renamed from: t, reason: collision with root package name */
    private volatile Handler f40486t;

    /* renamed from: b, reason: collision with root package name */
    public WBSAParam f40475b = new WBSAParam();

    /* renamed from: p, reason: collision with root package name */
    private a f40484p = new a();

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f40485s = false;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f40476h = true;

    private static Context a(Context context) {
        return context != null ? context.getApplicationContext() != null ? context.getApplicationContext() : context : f40472g;
    }

    public static /* synthetic */ void a(d dVar, Context context) {
        dVar.f40475b.setAppBundleId(c.a(context));
        dVar.f40475b.setWaName("WBSimpleAnalytics SDK");
        dVar.f40475b.setWaVersion("v1.2.18");
    }

    public static /* synthetic */ void a(d dVar, WBSAEvent wBSAEvent, final String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(wBSAEvent);
        final b a10 = b.a();
        final WBSAParam wBSAParam = dVar.f40475b;
        EventSender.requestExec(a10.f40458a, wBSAParam, str, arrayList, new WeReq.Callback<EventSender.sendEventResponse>() { // from class: com.tencent.cloud.huiyansdkface.analytics.b.2

            /* renamed from: a */
            public final /* synthetic */ String f40460a;

            /* renamed from: b */
            public final /* synthetic */ WBSAParam f40461b;

            /* renamed from: com.tencent.cloud.huiyansdkface.analytics.b$2$1 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
            public class AnonymousClass1 extends BaseCallback<EventSender.sendEventResponse> {
                public AnonymousClass1() {
                }

                @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                public final void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str, IOException iOException) {
                    WBSLogger.e("ReportWBAEvents", "requestFailExec onFailed msg=".concat(String.valueOf(str)), new Object[0]);
                }

                @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                public final /* synthetic */ void onSuccess(WeReq weReq, Object obj) {
                    EventSender.sendEventResponse sendeventresponse = (EventSender.sendEventResponse) obj;
                    if (sendeventresponse != null) {
                        WBSLogger.w("ReportWBAEvents", "requestFailExec onSuccess code" + sendeventresponse.code, new Object[0]);
                        WBSLogger.w("ReportWBAEvents", "requestFailExec onSuccess msg" + sendeventresponse.msg, new Object[0]);
                    }
                }
            }

            public AnonymousClass2(final String str2, final WBSAParam wBSAParam2) {
                r2 = str2;
                r3 = wBSAParam2;
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public final void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str2, IOException iOException) {
                WBSLogger.d("ReportWBAEvents", "WBCF onFailed:" + ((Object) errType) + "," + i10 + "," + str2, new Object[0]);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public final void onFinish() {
                WBSLogger.d("ReportWBAEvents", "onFinish", new Object[0]);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public final void onStart(WeReq weReq) {
                WBSLogger.d("ReportWBAEvents", "onStart", new Object[0]);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public final /* synthetic */ void onSuccess(WeReq weReq, Object obj) {
                EventSender.sendEventResponse sendeventresponse = (EventSender.sendEventResponse) obj;
                if (sendeventresponse != null) {
                    String str2 = sendeventresponse.code;
                    if ("10000".equals(str2)) {
                        return;
                    }
                    WBSLogger.w("ReportWBAEvents", "onSuccess requestFailExec errorCode" + sendeventresponse.code, new Object[0]);
                    if (TextUtils.isEmpty(r2)) {
                        return;
                    }
                    EventSender.RequestFailParam requestFailParam = new EventSender.RequestFailParam();
                    requestFailParam.errorCode = str2;
                    requestFailParam.errorMsg = sendeventresponse.msg;
                    WBSAParam wBSAParam2 = r3;
                    requestFailParam.subAppId = wBSAParam2.app_id;
                    requestFailParam.account = wBSAParam2.sub_app_id;
                    requestFailParam.createTime = System.currentTimeMillis();
                    WBSAParam wBSAParam3 = r3;
                    requestFailParam.appVersion = wBSAParam3.app_version;
                    requestFailParam.waVersion = wBSAParam3.getWaVersion();
                    requestFailParam.deviceId = r3.wba_device_id;
                    requestFailParam.deviceInfo = r3.getAppBundleId() + "|" + r3.getWaName() + "|" + r3.getMetricsDevice() + "|" + r3.getMetricsOsVersion();
                    WBSLogger.w("ReportWBAEvents", "requestFailExec paramJson".concat(String.valueOf(new WeJson().toJson(requestFailParam))), new Object[0]);
                    String[] split = r2.split("/rcrm-codcs/");
                    if (split != null) {
                        String str3 = split[0];
                        WBSLogger.w("ReportWBAEvents", "requestFailExec baseUrl=" + str3 + "/rcrm-codcs/fail-msg", new Object[0]);
                        EventSender.requestFailExec(b.this.f40458a, requestFailParam, str3 + "/rcrm-codcs/fail-msg", new BaseCallback<EventSender.sendEventResponse>() { // from class: com.tencent.cloud.huiyansdkface.analytics.b.2.1
                            public AnonymousClass1() {
                            }

                            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                            public final void onFailed(WeReq weReq2, WeReq.ErrType errType, int i10, String str4, IOException iOException) {
                                WBSLogger.e("ReportWBAEvents", "requestFailExec onFailed msg=".concat(String.valueOf(str4)), new Object[0]);
                            }

                            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
                            public final /* synthetic */ void onSuccess(WeReq weReq2, Object obj2) {
                                EventSender.sendEventResponse sendeventresponse2 = (EventSender.sendEventResponse) obj2;
                                if (sendeventresponse2 != null) {
                                    WBSLogger.w("ReportWBAEvents", "requestFailExec onSuccess code" + sendeventresponse2.code, new Object[0]);
                                    WBSLogger.w("ReportWBAEvents", "requestFailExec onSuccess msg" + sendeventresponse2.msg, new Object[0]);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    private Handler b(Context context) {
        if (this.f40486t == null) {
            synchronized (d.class) {
                if (this.f40486t == null) {
                    try {
                        c(context);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        WBSLogger.e(f40467a, th.getMessage(), new Object[0]);
                        this.f40476h = false;
                    }
                }
            }
        } else {
            WBSLogger.d(f40467a, "initWBASdk null == eventHandler", new Object[0]);
        }
        return this.f40486t;
    }

    public static /* synthetic */ void b(d dVar, Context context) {
        dVar.f40475b.setMetricsOs("Android");
        dVar.f40478j = Build.VERSION.SDK_INT;
        dVar.f40479k = Build.MODEL;
        int i10 = c.c(context).widthPixels;
        int i11 = c.c(context).heightPixels;
        float f10 = c.c(context).density;
        dVar.f40480l = i10 + LanguageTag.PRIVATEUSE + i11;
        dVar.f40481m = f10;
        dVar.f40482n = c.d(context);
        dVar.f40483o = c.a();
    }

    private synchronized void c(final Context context) {
        String str = f40467a;
        WBSLogger.d(str, "initWBASdk WBAService!", new Object[0]);
        if (this.f40486t != null) {
            WBSLogger.e(str, "initWBASdk already has eventHandler,return!", new Object[0]);
            return;
        }
        this.f40484p.a();
        if (context != null) {
            if (context.getApplicationContext() != null) {
                f40472g = context.getApplicationContext();
            } else {
                f40472g = context;
            }
        }
        final Context a10 = a(context);
        HandlerThread handlerThread = new HandlerThread("WBAService");
        handlerThread.start();
        this.f40486t = new Handler(handlerThread.getLooper());
        this.f40486t.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.analytics.d.2
            @Override // java.lang.Runnable
            public final void run() {
                d.a(d.this, a10);
                d.b(d.this, a10);
                b.a();
                WBSLogger.d(d.f40467a, "initWBASdk Init WBAService success!", new Object[0]);
                Properties properties = new Properties();
                properties.put("metrics_device", d.this.f40479k);
                properties.put("metrics_os_version", Integer.valueOf(d.this.f40478j));
                properties.put("metrics_locale", d.this.f40482n);
                properties.put("metrics_density", Float.valueOf(d.this.f40481m));
                properties.put("metrics_resolution", d.this.f40480l);
                properties.put("timezone", d.this.f40483o);
                d.this.a(context, "autotrack", "device_info", properties, false);
            }
        });
    }

    public final void a(Context context, final String str, final String str2, final Properties properties, final boolean z10) {
        if (this.f40476h) {
            Context a10 = a(context);
            if (a10 == null) {
                WBSLogger.e(f40467a, "The Context of StatService.trackCustomKVEvent() can not be null!", new Object[0]);
                return;
            }
            if (!this.f40485s) {
                String str3 = f40467a;
                WBSLogger.w(str3, "sdk未初始化，调用了trackCustomKVEvent", new Object[0]);
                SharedPreferences sharedPreferences = a10.getSharedPreferences(this.f40475b.getAppId(), 0);
                if (sharedPreferences == null) {
                    WBSLogger.e(str3, "hasInit false,wbwaconfig null", new Object[0]);
                    return;
                }
                String string = sharedPreferences.getString(f40473q, null);
                if (TextUtils.isEmpty(string)) {
                    WBSLogger.e(str3, "hasInit false,wbwaconfig subAppId  null", new Object[0]);
                    return;
                }
                WBSLogger.w(str3, "hasInit false,wbwaconfig true", new Object[0]);
                String string2 = sharedPreferences.getString(f40468c, null);
                String string3 = sharedPreferences.getString(f40469d, null);
                String string4 = sharedPreferences.getString(f40470e, null);
                String string5 = sharedPreferences.getString(f40474r, null);
                String string6 = sharedPreferences.getString(f40471f, null);
                this.f40475b.setSubAppId(string);
                this.f40475b.setEcifNo(string2);
                this.f40475b.setUnionId(string3);
                this.f40475b.setOpenId(string4);
                this.f40475b.setAppVersion(string5);
                this.f40475b.setField_y_0(string6);
                this.f40485s = true;
            }
            if (c.a(str, str2, properties)) {
                WBSLogger.e(f40467a, "The length of event_id/properties for StatService.trackCustomKVEvent() exceeds the limit:61440", new Object[0]);
            }
            if (b(a10) != null) {
                this.f40486t.post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.analytics.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            WBSAEvent customEvent = WBSAEvent.customEvent(str, str2, properties, Boolean.valueOf(z10), d.this.f40484p);
                            d dVar = d.this;
                            d.a(dVar, customEvent, dVar.f40477i);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            WBSLogger.e(d.f40467a, th.getMessage(), new Object[0]);
                        }
                    }
                });
            }
        }
    }

    public final boolean a(Context context, WBSimpleStartParam wBSimpleStartParam) {
        WBSAParam wBSAParam;
        String b4;
        try {
            if (!wBSimpleStartParam.isEnableService()) {
                WBSLogger.e(f40467a, "WBAService is disable.", new Object[0]);
                this.f40476h = false;
                return false;
            }
            if (context == null) {
                throw new WBSASDKException("context must not be null");
            }
            if (TextUtils.isEmpty(wBSimpleStartParam.getAppId())) {
                throw new WBSASDKException("valid appId is required, but was provided either 'null' or empty String");
            }
            if (TextUtils.isEmpty(wBSimpleStartParam.getSubAppId())) {
                throw new WBSASDKException("valid subAppId is required, but was provided either 'null' or empty String");
            }
            if (TextUtils.isEmpty(wBSimpleStartParam.getBaseUrl())) {
                throw new WBSASDKException("valid baseUrl is required, but was provided either 'null' or empty String");
            }
            String appId = wBSimpleStartParam.getAppId();
            String subAppId = wBSimpleStartParam.getSubAppId();
            this.f40477i = wBSimpleStartParam.getBaseUrl();
            String ecifNo = wBSimpleStartParam.getEcifNo();
            String unionId = wBSimpleStartParam.getUnionId();
            String openId = wBSimpleStartParam.getOpenId();
            String customFiled = wBSimpleStartParam.getCustomFiled();
            this.f40475b.setAppId(appId);
            this.f40475b.setSubAppId(subAppId);
            this.f40475b.setEcifNo(ecifNo);
            this.f40475b.setUnionId(unionId);
            this.f40475b.setOpenId(openId);
            this.f40475b.setField_y_0(customFiled);
            if (TextUtils.isEmpty(wBSimpleStartParam.getAppVersion())) {
                wBSAParam = this.f40475b;
                b4 = c.b(context);
            } else {
                wBSAParam = this.f40475b;
                b4 = wBSimpleStartParam.getAppVersion();
            }
            wBSAParam.setAppVersion(b4);
            SharedPreferences.Editor edit = context.getSharedPreferences(this.f40475b.getAppId(), 0).edit();
            edit.putString(f40473q, subAppId);
            edit.putString(f40468c, ecifNo);
            edit.putString(f40469d, unionId);
            edit.putString(f40470e, openId);
            edit.putString(f40474r, this.f40475b.getAppVersion());
            edit.putString(f40471f, customFiled);
            edit.commit();
            if (wBSimpleStartParam.isLogEnable()) {
                WBSLogger.setLogLevel(3);
            } else {
                WBSLogger.setLogLevel(7);
            }
            if (b(context) != null) {
                this.f40485s = true;
                this.f40476h = true;
                return true;
            }
            WBSLogger.e(f40467a, "Context or sdkVersion in StatService.startStatService() is null, please check it!", new Object[0]);
            this.f40476h = false;
            return false;
        } catch (Throwable th) {
            WBSLogger.e(f40467a, th.getMessage(), new Object[0]);
            this.f40476h = false;
            return false;
        }
    }
}
