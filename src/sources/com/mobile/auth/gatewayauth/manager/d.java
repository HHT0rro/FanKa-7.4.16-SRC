package com.mobile.auth.gatewayauth.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.kuaishou.weapon.p0.t;
import com.mobile.auth.BuildConfig;
import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.PnsReporter;
import com.mobile.auth.gatewayauth.model.MonitorStruct;
import com.mobile.auth.gatewayauth.model.UStruct;
import com.mobile.auth.gatewayauth.utils.AESUtils;
import com.mobile.auth.gatewayauth.utils.security.PackageUtils;
import com.nirvana.tools.logger.storage.LoggerIdManager;
import com.nirvana.tools.logger.utils.LocalDeviceUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f37306a;

    /* renamed from: b, reason: collision with root package name */
    public static String f37307b;

    /* renamed from: c, reason: collision with root package name */
    public static String f37308c;

    /* renamed from: d, reason: collision with root package name */
    private Context f37309d;

    /* renamed from: h, reason: collision with root package name */
    private String f37313h;

    /* renamed from: i, reason: collision with root package name */
    private String f37314i;

    /* renamed from: j, reason: collision with root package name */
    private String f37315j;

    /* renamed from: o, reason: collision with root package name */
    private Map<String, String> f37320o;

    /* renamed from: p, reason: collision with root package name */
    private Map<String, String> f37321p;

    /* renamed from: q, reason: collision with root package name */
    private Map<String, String> f37322q;

    /* renamed from: r, reason: collision with root package name */
    private Map<String, String> f37323r;

    /* renamed from: s, reason: collision with root package name */
    private com.mobile.auth.q.a f37324s;

    /* renamed from: e, reason: collision with root package name */
    private final String f37310e = "c78623c22e2f6513";

    /* renamed from: f, reason: collision with root package name */
    private String f37311f = UUID.randomUUID().toString();

    /* renamed from: g, reason: collision with root package name */
    private boolean f37312g = true;

    /* renamed from: k, reason: collision with root package name */
    private String f37316k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f37317l = "";

    /* renamed from: m, reason: collision with root package name */
    private com.mobile.auth.p.a f37318m = null;

    /* renamed from: n, reason: collision with root package name */
    private LoggerIdManager f37319n = null;

    public d(Context context) {
        this.f37309d = context.getApplicationContext();
        o();
    }

    private String a(Context context) {
        try {
            try {
                String str = LocalDeviceUtil.AUTH_DEVICEID_FILE;
                Object invoke = LocalDeviceUtil.class.getDeclaredMethod("getUmaaId", Context.class).invoke(null, context);
                return invoke != null ? invoke.toString() : "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private String a(JSONObject jSONObject, String str, String str2, String str3, String str4) {
        try {
            try {
                jSONObject.put("c", new JSONObject(a(this.f37309d, str2, str4)));
                jSONObject.put("action", str);
                jSONObject.put(CardConstants.KEY_API_LEVEL, str3);
                jSONObject.put("osType", "Android");
                Map<String, String> map = this.f37323r;
                if (map != null && !map.isEmpty()) {
                    for (String str5 : this.f37323r.h()) {
                        jSONObject.put(str5, this.f37323r.get(str5));
                    }
                }
            } catch (JSONException e2) {
                this.f37324s.e("AssembleMonitorInfoError!", Log.getStackTraceString(e2));
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private String b(Context context) {
        try {
            try {
                String str = LocalDeviceUtil.AUTH_DEVICEID_FILE;
                Object invoke = LocalDeviceUtil.class.getDeclaredMethod("getDeviceId", Context.class).invoke(null, context);
                return invoke != null ? invoke.toString() : "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private void o() {
        try {
            com.mobile.auth.q.a a10 = com.mobile.auth.q.a.a(this.f37309d);
            this.f37324s = a10;
            a10.a(this);
            this.f37318m = new com.mobile.auth.p.a(a(), this);
            this.f37319n = new LoggerIdManager(this.f37309d);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private String p() {
        try {
            return q() ? a(this.f37309d) : "";
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private boolean q() {
        try {
            String str = LocalDeviceUtil.AUTH_DEVICEID_FILE;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public com.mobile.auth.q.a a() {
        try {
            return this.f37324s;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public String a(MonitorStruct monitorStruct) {
        try {
            return a(monitorStruct.getVendorKey(), monitorStruct.getAction(), new UStruct(monitorStruct), monitorStruct.getApiLevel(), monitorStruct.getPhoneNumber());
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public String a(String str, String str2, UStruct uStruct, String str3) {
        try {
            return a(str, str2, uStruct, str3, "");
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public String a(String str, String str2, UStruct uStruct, String str3, String str4) {
        String encrypt;
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f37316k)) {
                uStruct.setEt(this.f37316k);
            }
            try {
                JSONObject json = uStruct.toJson();
                Map<String, String> map = this.f37320o;
                if (map != null && !map.isEmpty()) {
                    for (String str5 : this.f37320o.h()) {
                        json.put(str5, this.f37320o.get(str5));
                    }
                }
                jSONObject.put(t.f36224i, json);
                jSONObject.put(t.f36224i, uStruct.toJson());
                if (TextUtils.isEmpty(str4)) {
                    Map<String, String> b4 = b(uStruct.getPrivateIp());
                    Map<String, String> map2 = this.f37322q;
                    if (map2 != null && !map2.isEmpty()) {
                        b4.putAll(this.f37322q);
                    }
                    encrypt = AESUtils.encrypt(new JSONObject(b4).toString(), "c78623c22e2f6513");
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("phoneNumber", str4);
                    hashMap.putAll(b(uStruct.getPrivateIp()));
                    Map<String, String> map3 = this.f37322q;
                    if (map3 != null && !map3.isEmpty()) {
                        hashMap.putAll(this.f37322q);
                    }
                    encrypt = AESUtils.encrypt(new JSONObject(hashMap).toString(), "c78623c22e2f6513");
                }
                jSONObject.put(t.f36222g, encrypt);
            } catch (Exception e2) {
                this.f37324s.e("BuildMonitorError!", Log.getStackTraceString(e2));
            }
            return a(jSONObject, str2, str, str3, uStruct.getNetworkType());
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public Map<String, Object> a(Context context, String str, String str2) {
        String str3;
        Map<String, String> map;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("createTime", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("osVersion", com.mobile.auth.gatewayauth.utils.f.b());
            hashMap.put("deviceName", com.mobile.auth.gatewayauth.utils.f.c());
            hashMap.put("deviceBrand", com.mobile.auth.gatewayauth.utils.f.a());
            hashMap.put("packageName", PackageUtils.getPackageName(context));
            hashMap.put(AttributionReporter.APP_VERSION, PackageUtils.getVersionName(context));
            hashMap.put("signature", PackageUtils.getSign(context));
            if (Constant.VENDOR_CUCC.equals(str)) {
                hashMap.put("vendorKey", Constant.VENDOR_CUXZ);
            } else {
                hashMap.put("vendorKey", str);
            }
            hashMap.put(bg.e.Code, BuildConfig.VERSION_NAME);
            hashMap.put(ConfigBean.Field.NETWORK_TYPE, str2);
            hashMap.put("monitorVersion", "2.1");
            hashMap.put(com.alipay.sdk.cons.b.f4545g, l());
            hashMap.put("um_aaid", m());
            hashMap.put("uniqueId", k());
            hashMap.put("traceId", this.f37311f);
            hashMap.put("archiveName", BuildConfig.FLAVOR);
            if (!Constant.VENDOR_CMCC.equals(str)) {
                if (!Constant.VENDOR_CUCC.equals(str)) {
                    if (Constant.VENDOR_CTCC.equals(str)) {
                        str3 = BuildConfig.CTCC_SDK_VERSION;
                    } else if (!Constant.VENDOR_CUXZ.equals(str)) {
                        str3 = "";
                    }
                }
                hashMap.put("carrierSdkVersion", BuildConfig.CUZX_SDK_VERSION);
                map = this.f37321p;
                if (map != null && !map.isEmpty()) {
                    hashMap.putAll(this.f37321p);
                }
                return hashMap;
            }
            str3 = BuildConfig.CMCC_SDK_VERSION;
            hashMap.put("carrierSdkVersion", str3);
            map = this.f37321p;
            if (map != null) {
                hashMap.putAll(this.f37321p);
            }
            return hashMap;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public void a(f fVar) {
        try {
            this.f37318m.a(fVar);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(String str) {
        try {
            this.f37317l = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public PnsReporter b() {
        try {
            return this.f37318m;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public String b(String str, String str2, UStruct uStruct, String str3) {
        String str4;
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f37316k)) {
                uStruct.setEt(this.f37316k);
            }
            try {
                JSONObject json = uStruct.toJson();
                Map<String, String> map = this.f37320o;
                if (map != null && !map.isEmpty()) {
                    for (String str5 : this.f37320o.h()) {
                        json.put(str5, this.f37320o.get(str5));
                    }
                }
                jSONObject.put(t.f36224i, json);
                Map<String, String> map2 = this.f37322q;
                if (map2 == null || map2.isEmpty()) {
                    str4 = "";
                } else {
                    Map<? extends String, ? extends String> map3 = this.f37322q;
                    map3.putAll(map3);
                    str4 = AESUtils.encrypt(new JSONObject(this.f37322q).toString(), "c78623c22e2f6513");
                }
                jSONObject.put(t.f36222g, str4);
            } catch (Exception e2) {
                this.f37324s.e("BuildMonitorNoSError!", Log.getStackTraceString(e2));
            }
            return a(jSONObject, str2, str, str3, uStruct.getNetworkType());
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public Map<String, String> b(String str) {
        try {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(str)) {
                hashMap.put("innerIP", str);
            }
            hashMap.put("sceneCode", this.f37317l);
            return hashMap;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public synchronized String c() {
        try {
            if (TextUtils.isEmpty(this.f37313h)) {
                return f();
            }
            return this.f37313h;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public void c(String str) {
        if (str != null) {
            try {
                this.f37316k = str;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public synchronized String d() {
        try {
            if (TextUtils.isEmpty(this.f37314i)) {
                return g();
            }
            return this.f37314i;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public synchronized String e() {
        try {
            if (TextUtils.isEmpty(this.f37315j)) {
                return j();
            }
            return this.f37315j;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public synchronized String f() {
        String uuid;
        try {
            uuid = UUID.randomUUID().toString();
            this.f37313h = uuid;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return uuid;
    }

    public synchronized String g() {
        String uuid;
        try {
            uuid = UUID.randomUUID().toString();
            this.f37314i = uuid;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return uuid;
    }

    public synchronized void h() {
        try {
            this.f37313h = null;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public synchronized void i() {
        try {
            this.f37314i = null;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public synchronized String j() {
        String uuid;
        try {
            uuid = UUID.randomUUID().toString();
            this.f37315j = uuid;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return uuid;
    }

    public String k() {
        try {
            if (f37306a == null) {
                f37306a = this.f37319n.getUniqueId();
            }
            return f37306a;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public String l() {
        try {
            if (!this.f37312g) {
                return null;
            }
            if (f37307b == null && q()) {
                f37307b = b(this.f37309d);
            }
            return f37307b;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public String m() {
        try {
            if (f37308c == null) {
                f37308c = p();
            }
            return f37308c;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public void n() {
        try {
            this.f37312g = false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
