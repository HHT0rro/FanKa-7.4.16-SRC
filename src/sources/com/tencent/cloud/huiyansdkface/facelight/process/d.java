package com.tencent.cloud.huiyansdkface.facelight.process;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cloud.huiyansdkface.facelight.a.b.b;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbFaceVerifyInitCusSdkCallback;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.c.e;
import com.tencent.cloud.huiyansdkface.facelight.c.f;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.CusInitParam;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.LoginResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.WbCusMetaData;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbUiTips;
import com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity;
import com.tencent.cloud.huiyansdkface.facelight.ui.FaceVerifyActivity;
import com.tencent.cloud.huiyansdkface.facelivesdk.BuildConfig;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFrameworkTool;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f40795a;

    /* renamed from: b, reason: collision with root package name */
    private WbCloudFaceVerifyResultListener f40796b;

    /* renamed from: c, reason: collision with root package name */
    private WbCloudFaceVerifyLoginListener f40797c;

    /* renamed from: d, reason: collision with root package name */
    private WbFaceVerifyInitCusSdkCallback f40798d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f40799e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f40800f;

    /* renamed from: g, reason: collision with root package name */
    private String f40801g;

    /* renamed from: k, reason: collision with root package name */
    private boolean f40805k;

    /* renamed from: l, reason: collision with root package name */
    private int f40806l;

    /* renamed from: m, reason: collision with root package name */
    private int f40807m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f40808n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f40809o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f40810p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f40811q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f40812r;

    /* renamed from: s, reason: collision with root package name */
    private int f40813s;

    /* renamed from: t, reason: collision with root package name */
    private String f40814t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f40815u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f40816v;

    /* renamed from: w, reason: collision with root package name */
    private CloudFaceCountDownTimer f40817w;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.a.a.c f40802h = new com.tencent.cloud.huiyansdkface.facelight.a.a.c();

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.a.a.b f40803i = new com.tencent.cloud.huiyansdkface.facelight.a.a.b();

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.a.b.a f40804j = new com.tencent.cloud.huiyansdkface.facelight.a.b.a();

    /* renamed from: x, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.c.c f40818x = new com.tencent.cloud.huiyansdkface.facelight.c.c();

    private void B() {
        this.f40807m = 0;
        this.f40806l = 0;
        this.f40813s = 0;
        this.f40814t = "";
        this.f40815u = false;
        this.f40816v = false;
        this.f40809o = false;
        this.f40810p = false;
        this.f40811q = false;
        this.f40812r = false;
        this.f40808n = false;
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.f40817w;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.f40817w = null;
        }
        Param.setDeviceModel(Build.MODEL);
    }

    private void C() {
        WLogger.d("WbFaceVerifyControl", "encrySdkInfoAndReturn");
        String str = null;
        this.f40801g = null;
        String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(false, generateAESKey, "cus login:");
        try {
            str = WbCloudNetSecurityManger.base64Encry(false, new WeJson().toJson(new CusInitParam()), generateAESKey);
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w("WbFaceVerifyControl", "encry CusInitParam failed!" + e2.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry CusInitParam failed!" + e2.toString(), null);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("encryptedAESKey", encryptAESKey);
        hashMap.put("identityStr", str);
        WbFaceVerifyInitCusSdkCallback wbFaceVerifyInitCusSdkCallback = this.f40798d;
        if (wbFaceVerifyInitCusSdkCallback != null) {
            this.f40801g = generateAESKey;
            wbFaceVerifyInitCusSdkCallback.onInitSuccess(hashMap);
        }
    }

    private void D() {
        if (this.f40804j.O()) {
            WLogger.e("WbFaceVerifyControl", "[WBFACE] duplicate init,ignore!");
        }
    }

    private void a(Context context) {
        WLogger.setEnable(this.f40804j.O(), "cloud face");
        WLogger.localLogFileName(context, "kyc-face-log");
    }

    private void a(final Context context, long j10) {
        WLogger.d("WbFaceVerifyControl", "startLoginRequest");
        this.f40809o = true;
        new com.tencent.cloud.huiyansdkface.facelight.process.d.a(f40795a, this.f40818x).a(context, j10, new ProcessCallback<LoginResult>() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.d.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(LoginResult loginResult) {
                d.this.f40804j.f(loginResult.protocolCorpName);
                d.this.f40804j.g(loginResult.authProtocolVersion);
                d.this.f40804j.h(loginResult.testMsg);
                d.this.f40804j.k(loginResult.activeType);
                d.this.f40804j.j(loginResult.colorData);
                d.this.f40804j.d(loginResult.needLogReport);
                d.this.f40804j.b(loginResult.needAuth);
                d.this.f40804j.c(loginResult.authTickSwitch);
                d.this.f40804j.a(loginResult.popupWarnSwitch);
                d.this.f40804j.e(loginResult.optimalGradeType);
                d.this.f40804j.i(loginResult.uploadWillVideo);
                WLogger.d("WbFaceVerifyControl", "isLoginOk true");
                d.this.f40815u = true;
                d.this.e(context);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                d.this.a(context, wbFaceInnerError.toWbFaceError());
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, WbFaceError wbFaceError) {
        WLogger.w("WbFaceVerifyControl", "LoginFailed!" + wbFaceError.getReason());
        this.f40799e = false;
        Properties Z = this.f40804j.Z();
        Z.setProperty("isInit", String.valueOf(this.f40799e));
        Z.setProperty("isStartSdk", String.valueOf(this.f40800f));
        if (WbFaceError.WBFaceErrorDomainLoginNetwork.equals(wbFaceError.getDomain())) {
            KycWaSDK.getInstance().trackIMSWarnVEvent(context, "faceservice_login_network_fail", wbFaceError.getReason(), Z);
        } else {
            KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_login_fail", wbFaceError.getReason(), Z);
        }
        WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener = this.f40797c;
        if (wbCloudFaceVerifyLoginListener != null) {
            wbCloudFaceVerifyLoginListener.onLoginFailed(wbFaceError);
        }
    }

    private void a(final Context context, String str) {
        WLogger.d("WbFaceVerifyControl", "getCdnConfig：" + str);
        this.f40803i = new com.tencent.cloud.huiyansdkface.facelight.a.a.b();
        com.tencent.cloud.huiyansdkface.facelight.a.a.c cVar = new com.tencent.cloud.huiyansdkface.facelight.a.a.c();
        this.f40802h = cVar;
        cVar.a(this.f40804j.X(), context, str, new com.tencent.cloud.huiyansdkface.facelight.a.a.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.process.d.3
            @Override // com.tencent.cloud.huiyansdkface.facelight.a.a.a
            public void a() {
                WLogger.d("WbFaceVerifyControl", "cdn finish!isGetConfig true");
                d dVar = d.this;
                dVar.f40803i = dVar.f40802h.a();
                d.this.f40816v = true;
                d.this.e(context);
            }
        });
    }

    private void a(Context context, String str, String str2, String str3) {
        a(context, str, str2, str3, true);
    }

    private void a(Context context, String str, String str2, String str3, boolean z10) {
        this.f40799e = false;
        if (z10) {
            Properties properties = new Properties();
            properties.setProperty("isInit", String.valueOf(this.f40799e));
            properties.setProperty("isStartSdk", String.valueOf(this.f40800f));
            KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_params_invalid", str3, properties);
        }
        if (this.f40797c != null) {
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainParams);
            wbFaceError.setCode(str);
            wbFaceError.setDesc(str2);
            wbFaceError.setReason(str3);
            this.f40797c.onLoginFailed(wbFaceError);
        }
        if (this.f40798d != null) {
            WbFaceError wbFaceError2 = new WbFaceError();
            wbFaceError2.setDomain(WbFaceError.WBFaceErrorDomainParams);
            wbFaceError2.setCode(str);
            wbFaceError2.setDesc(str2);
            wbFaceError2.setReason(str3);
            this.f40798d.onInitFailed(wbFaceError2);
        }
    }

    private void a(Context context, boolean z10, boolean z11, boolean z12, Bundle bundle, WbFaceVerifyInitCusSdkCallback wbFaceVerifyInitCusSdkCallback, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        String str;
        if (z12) {
            if (wbFaceVerifyInitCusSdkCallback == null) {
                throw new IllegalArgumentException("InitCusSdkCallback is null！");
            }
        } else if (wbCloudFaceVerifyLoginListener == null) {
            throw new IllegalArgumentException("FaceVerifyLoginListener is null！");
        }
        if (context == null) {
            WbFaceError wbFaceError = new WbFaceError(WbFaceError.WBFaceErrorDomainParams, WbFaceError.WBFaceErrorDomainParams, "传入参数为空", "传入context为空");
            if (z12) {
                wbFaceVerifyInitCusSdkCallback.onInitFailed(wbFaceError);
                return;
            } else {
                wbCloudFaceVerifyLoginListener.onLoginFailed(wbFaceError);
                return;
            }
        }
        if (bundle == null) {
            WbFaceError wbFaceError2 = new WbFaceError(WbFaceError.WBFaceErrorDomainParams, WbFaceError.WBFaceErrorDomainParams, "传入参数为空", "传入bundle Data对象为空");
            if (z12) {
                wbFaceVerifyInitCusSdkCallback.onInitFailed(wbFaceError2);
                return;
            } else {
                wbCloudFaceVerifyLoginListener.onLoginFailed(wbFaceError2);
                return;
            }
        }
        Context applicationContext = context.getApplicationContext();
        WLogger.setEnable(true, "cloud face");
        com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().a(applicationContext);
        com.tencent.cloud.huiyansdkface.facelight.a.b.a a10 = com.tencent.cloud.huiyansdkface.facelight.a.b.b.a(bundle, z10, z12, z11);
        if (!z12) {
            b.a b4 = com.tencent.cloud.huiyansdkface.facelight.a.b.b.b(a10);
            if (!b4.c()) {
                wbCloudFaceVerifyLoginListener.onLoginFailed(new WbFaceError(WbFaceError.WBFaceErrorDomainParams, WbFaceError.WBFaceErrorCodeInputParaNull, "传入参数有误", b4.f40562b));
                WLogger.setEnable(false, "cloud face");
                return;
            }
        }
        if (a(applicationContext, a10.g())) {
            WLogger.w("WbFaceVerifyControl", "double click,check is same faceId");
            if (a10.g()) {
                D();
                return;
            }
        }
        WLogger.d("WbFaceVerifyControl", "initSdk:" + z10);
        if (a(applicationContext, a10.t(), wbCloudFaceVerifyLoginListener)) {
            this.f40799e = true;
            this.f40804j = a10;
            if (wbFaceVerifyInitCusSdkCallback != null) {
                this.f40798d = wbFaceVerifyInitCusSdkCallback;
                this.f40797c = null;
            } else {
                this.f40798d = null;
                this.f40797c = wbCloudFaceVerifyLoginListener;
            }
            B();
            a(applicationContext);
            if (b(applicationContext)) {
                int a11 = com.tencent.cloud.huiyansdkface.b.a.a(this.f40804j.i().licence);
                if (a11 != 0) {
                    WLogger.e("WbFaceVerifyControl", "keyLicence is not valid!keyValid=" + a11);
                    Properties properties = new Properties();
                    properties.setProperty("licence", this.f40804j.i().licence);
                    KycWaSDK.getInstance().trackCustomKVEvent(applicationContext, "faceservice_keylicence_invalid", "keyValid=" + a11, properties);
                    a(applicationContext, "11001", "传入keyLicence不可用", "传入keyLicence不可用(" + a11 + ")");
                    return;
                }
                d(applicationContext);
                WbFaceModeProviders.faceMode().onStartFaceVerify(applicationContext);
                if (this.f40804j.S()) {
                    this.f40809o = true;
                    C();
                    return;
                }
                if ("none".equals(this.f40804j.k())) {
                    WLogger.d("WbFaceVerifyControl", "compareType: NONE");
                    str = "gradelive";
                } else {
                    str = "grade";
                }
                Param.setCompareMode(str);
                this.f40818x.a(this.f40804j.O());
                this.f40818x.b(this.f40804j.X(), this.f40804j.P(), false);
                a(applicationContext, this.f40804j.H());
                KycWaSDK.getInstance().trackCustomKVEvent(applicationContext, "faceservice_login_start", null, null);
                a(applicationContext, 5000L);
            }
        }
    }

    private void a(String str, String str2, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        wbCloudFaceVerifyLoginListener.onLoginFailed(new WbFaceError(WbFaceError.WBFaceErrorDomainParams, WbFaceError.WBFaceErrorCodeInputModelsError, str, str2));
        WLogger.setEnable(false, "cloud face");
    }

    private boolean a(Context context, String str, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("WbFaceVerifyControl", "check assets");
            if (f.a(context.getAssets(), "models/face-tracker-v001", "yt_model_config.ini")) {
                return true;
            }
            a("资源文件为空，请检查", "ytModelLoc is null and assets is also null! ", wbCloudFaceVerifyLoginListener);
            return false;
        }
        WLogger.d("WbFaceVerifyControl", "check input ytModelLoc:" + str);
        YtSDKKitFrameworkTool.a a10 = new YtSDKKitFrameworkTool().a(str);
        if (a10 == YtSDKKitFrameworkTool.a.VALIDITY_OK) {
            return true;
        }
        a("资源文件校验失败", "ytModelLoc check failed:" + a10.toString(), wbCloudFaceVerifyLoginListener);
        return false;
    }

    private boolean a(Context context, Map<String, Object> map) {
        WbCusMetaData wbCusMetaData;
        String str;
        if (context != null && map != null) {
            try {
                wbCusMetaData = (WbCusMetaData) WbCloudNetSecurityManger.decry(false, (String) map.get("envInfo"), WbCusMetaData.class, this.f40801g);
            } catch (Exception e2) {
                e2.printStackTrace();
                wbCusMetaData = null;
            }
            if (wbCusMetaData == null) {
                return false;
            }
            WLogger.d("WbFaceVerifyControl", "cusMetaData=" + wbCusMetaData.toString());
            String str2 = wbCusMetaData.appId;
            WLogger.d("WbFaceVerifyControl", "appId=" + str2);
            if (!TextUtils.isEmpty(str2)) {
                Param.setAppId(str2);
                String str3 = wbCusMetaData.orderNo;
                WLogger.d("WbFaceVerifyControl", "orderNo=" + str3);
                if (!TextUtils.isEmpty(str3) && str3.equals(Param.getOrderNo())) {
                    WLogger.d("WbFaceVerifyControl", "orderNo matched!");
                    String str4 = TextUtils.isEmpty(wbCusMetaData.cdnFile) ? null : new String(Base64.decode(wbCusMetaData.cdnFile, 2));
                    WLogger.d("WbFaceVerifyControl", "cdnContent=" + str4);
                    com.tencent.cloud.huiyansdkface.facelight.a.a.c cVar = new com.tencent.cloud.huiyansdkface.facelight.a.a.c();
                    this.f40802h = cVar;
                    cVar.a(context, this.f40804j.H(), str4);
                    this.f40803i = this.f40802h.a();
                    String str5 = wbCusMetaData.verifyType;
                    WLogger.d("WbFaceVerifyControl", "verifyType=" + str5);
                    if (!TextUtils.isEmpty(str5)) {
                        Param.setVerifyType(str5);
                        if (TextUtils.isEmpty(wbCusMetaData.gradeCompareType)) {
                            str = "gradeCompareType is null!";
                        } else {
                            Param.setGradeCompareType(wbCusMetaData.gradeCompareType);
                            KycWaSDK.getInstance().updateFiled_y("field_y_0", wbCusMetaData.gradeCompareType);
                            String str6 = wbCusMetaData.optimalGradeType;
                            if (!TextUtils.isEmpty(str6)) {
                                this.f40804j.e(str6);
                                String str7 = wbCusMetaData.activeType;
                                String str8 = wbCusMetaData.colorData;
                                WLogger.d("WbFaceVerifyControl", "actType=" + str7);
                                WLogger.d("WbFaceVerifyControl", "colorData=" + str8);
                                if (str6.contains("2")) {
                                    if (TextUtils.isEmpty(str7)) {
                                        return false;
                                    }
                                    this.f40804j.k(str7);
                                }
                                if (str6.contains("3")) {
                                    if (TextUtils.isEmpty(str8)) {
                                        return false;
                                    }
                                    WLogger.d("WbFaceVerifyControl", "set colorData");
                                    this.f40804j.j(str8);
                                    WLogger.d("WbFaceVerifyControl", "set colorData finish:" + this.f40804j.M());
                                }
                                String str9 = wbCusMetaData.faceId;
                                Param.setFaceId(str9);
                                WLogger.d("WbFaceVerifyControl", "faceId=" + str9);
                                this.f40804j.f(wbCusMetaData.protocolCorpName);
                                this.f40804j.g(wbCusMetaData.authProtocolVersion);
                                this.f40804j.h(wbCusMetaData.testMsg);
                                WLogger.d("WbFaceVerifyControl", "protocolCorpName=" + this.f40804j.U());
                                WLogger.d("WbFaceVerifyControl", "protocolNo=" + this.f40804j.V());
                                this.f40804j.d(wbCusMetaData.needLogReport);
                                WLogger.d("WbFaceVerifyControl", "needLogReport=" + this.f40804j.c());
                                this.f40804j.b(wbCusMetaData.needAuth);
                                WLogger.d("WbFaceVerifyControl", "needAuth=" + this.f40804j.a());
                                this.f40804j.c(wbCusMetaData.authTickSwitch);
                                WLogger.d("WbFaceVerifyControl", "authTickSwitch=" + this.f40804j.b());
                                this.f40804j.a(wbCusMetaData.popupWarnSwitch);
                                WLogger.d("WbFaceVerifyControl", "isLoginOk true");
                                return true;
                            }
                            str = "optimalGradeType is null!";
                        }
                        WLogger.w("WbFaceVerifyControl", str);
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private boolean a(Context context, boolean z10) {
        if (!this.f40799e && !this.f40800f) {
            return false;
        }
        WLogger.d("WbFaceVerifyControl", "checkSdkInService,isInit=" + this.f40799e + ",isStartSdk=" + this.f40800f);
        KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_sdk_dup_init", "isIdDup:" + z10 + ",isInit=" + this.f40799e + ",isStartSdk=" + this.f40800f, null);
        return true;
    }

    private void b(Context context, String str, String str2, String str3) {
        a(context, str, str2, str3, false);
    }

    private boolean b(Context context) {
        WLogger.d("WbFaceVerifyControl", "checkParams");
        b.a a10 = com.tencent.cloud.huiyansdkface.facelight.a.b.b.a(this.f40804j);
        if ("-1".equals(this.f40804j.h()) || "1".equals(this.f40804j.h())) {
            if (a10.b()) {
                c(context);
            }
        } else if ("0".equals(this.f40804j.h())) {
            WLogger.i("WbFaceVerifyControl", "no report:" + this.f40804j.h() + "," + a10.b());
        }
        if (a10.c()) {
            return true;
        }
        if (a10.f40561a == 1) {
            a(context, WbFaceError.WBFaceErrorCodeInputParaNull, "传入参数有误", a10.f40562b);
            return false;
        }
        b(context, WbFaceError.WBFaceErrorCodeInputParaNull, "传入参数有误", a10.f40562b);
        return false;
    }

    private void c(Context context) {
        WLogger.i("WbFaceVerifyControl", "initReport");
        String str = Param.getAppId() + Param.getOrderNo();
        com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().a(str);
        e.a(context, this.f40804j.O(), str);
    }

    private void d(Context context) {
        Param.setTuringPackage(null);
        Param.setTuringVideoData(null);
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        String deviceModel = Param.getDeviceModel();
        WLogger.d("WbFaceVerifyControl", "deviceModel=" + deviceModel);
        String a10 = f.a(context);
        String a11 = f.a(this.f40804j.H());
        StringBuilder sb2 = new StringBuilder();
        String str = Build.BRAND;
        sb2.append(str);
        sb2.append("/");
        sb2.append(com.tencent.cloud.huiyansdkface.facelight.c.a.a(str));
        String sb3 = sb2.toString();
        String str2 = this.f40804j.f() ? "uni" : "nor";
        Param.setDeviceInfo("di=;dt=Android;dv=" + valueOf + ";dm=" + deviceModel + ";rom=" + sb3 + ";st=" + a10 + ";wv=" + BuildConfig.VERSION_NAME + ";lang=" + a11 + ";apt=" + str2 + com.tencent.cloud.huiyansdkface.facelight.c.d.d.b(context));
        StringBuilder sb4 = new StringBuilder();
        sb4.append("deviceInfo:");
        sb4.append(Param.getDeviceInfo());
        WLogger.d("WbFaceVerifyControl", sb4.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final Context context) {
        WLogger.d("WbFaceVerifyControl", "canStartFaceVerify");
        if (this.f40815u) {
            if (!this.f40816v) {
                WLogger.d("WbFaceVerifyControl", "wait cdn!");
                this.f40817w = new CloudFaceCountDownTimer(200L, 100L) { // from class: com.tencent.cloud.huiyansdkface.facelight.process.d.2
                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onFinish() {
                        WLogger.d("WbFaceVerifyControl", "get cdn out of time!no wait!");
                        d.this.f40802h.a(context, d.this.f40804j.H());
                        d dVar = d.this;
                        dVar.f40803i = dVar.f40802h.a();
                        d.this.f40816v = true;
                        d.this.e(context);
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onTick(long j10) {
                    }
                }.start();
                return;
            }
            WLogger.d("WbFaceVerifyControl", "return login sucess!");
            CloudFaceCountDownTimer cloudFaceCountDownTimer = this.f40817w;
            if (cloudFaceCountDownTimer != null) {
                cloudFaceCountDownTimer.cancel();
                this.f40817w = null;
            }
            if (this.f40797c != null) {
                KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_login_success", null, this.f40804j.Z());
                this.f40797c.onLoginSuccess();
                this.f40815u = false;
                this.f40816v = false;
            }
        }
    }

    public static d z() {
        if (f40795a == null) {
            synchronized (d.class) {
                if (f40795a == null) {
                    f40795a = new d();
                }
            }
        }
        return f40795a;
    }

    public void A() {
        WLogger.d("WbFaceVerifyControl", "release");
        h();
        if (this.f40797c != null) {
            this.f40797c = null;
        }
        if (this.f40798d != null) {
            this.f40798d = null;
        }
        if (this.f40796b != null) {
            this.f40796b = null;
        }
    }

    public WeOkHttp a() {
        return this.f40818x.a();
    }

    public void a(Context context, Bundle bundle, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        WLogger.d("WbFaceVerifyControl", "initCommonSdk");
        a(context, false, false, false, bundle, null, wbCloudFaceVerifyLoginListener);
    }

    public void a(Context context, Bundle bundle, WbFaceVerifyInitCusSdkCallback wbFaceVerifyInitCusSdkCallback) {
        WLogger.d("WbFaceVerifyControl", "initCusSdk");
        a(context, false, false, true, bundle, wbFaceVerifyInitCusSdkCallback, null);
    }

    public void a(Context context, WbCloudFaceVerifyResultListener wbCloudFaceVerifyResultListener) {
        Intent intent;
        Class<?> cls;
        if (context == null) {
            throw new IllegalArgumentException("startWbFaceVerifySdk context is null");
        }
        Context applicationContext = context.getApplicationContext();
        if (this.f40800f) {
            WLogger.w("WbFaceVerifyControl", "already in service！Please not duplicate start!");
            KycWaSDK.getInstance().trackCustomKVEvent(applicationContext, "faceservice_startwb_failed", "duplicate startWb", null);
            if (this.f40804j.g()) {
                D();
                return;
            }
        } else if (!this.f40799e) {
            WLogger.e("WbFaceVerifyControl", "not init,please init first...");
            KycWaSDK.getInstance().trackCustomKVEvent(applicationContext, "faceservice_startwb_failed", "not init", null);
        }
        WLogger.i("WbFaceVerifyControl", "startWbFaceVerifySdk");
        this.f40800f = true;
        this.f40799e = false;
        if ("1".equals(this.f40804j.c())) {
            WLogger.i("WbFaceVerifyControl", "enable startStatService");
            KycWaSDK.getInstance().updateEnableWBAService(true);
        } else {
            WLogger.i("WbFaceVerifyControl", "disable startStatService");
            KycWaSDK.getInstance().updateEnableWBAService(false);
        }
        KycWaSDK.getInstance().trackCustomKVEvent(applicationContext, "faceservice_startwb", Param.getCompareMode(), null);
        this.f40796b = wbCloudFaceVerifyResultListener;
        if ("1".equals(this.f40804j.a())) {
            intent = new Intent();
            cls = FaceGuideActivity.class;
        } else {
            intent = new Intent();
            cls = FaceVerifyActivity.class;
        }
        intent.setClass(context, cls);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(0, 0);
    }

    public void a(Context context, String str, Properties properties) {
        WLogger.d("WbFaceVerifyControl", "sdk release start status");
        this.f40800f = false;
        if (properties == null) {
            properties = new Properties();
        }
        properties.setProperty("isInit", String.valueOf(this.f40799e));
        properties.setProperty("isStartSdk", String.valueOf(this.f40800f));
        KycWaSDK.getInstance().trackCustomKVEvent(context, "facepage_returnresult", str, properties);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b8, code lost:
    
        if ("1".equals(r7.f40804j.c()) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00bb, code lost:
    
        com.tencent.cloud.huiyansdkface.normal.tools.WLogger.i("WbFaceVerifyControl", "disable startStatService");
        com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK.getInstance().updateEnableWBAService(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e9, code lost:
    
        if ("0".equals(r7.f40804j.h()) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r8, java.util.Map<java.lang.String, java.lang.Object> r9, com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener r10) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.process.d.a(android.content.Context, java.util.Map, com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener):void");
    }

    public void a(boolean z10) {
        this.f40812r = z10;
    }

    public void b(Context context, Bundle bundle, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        WLogger.d("WbFaceVerifyControl", "initAdvSdk");
        a(context, true, false, false, bundle, null, wbCloudFaceVerifyLoginListener);
    }

    public void b(boolean z10) {
        this.f40810p = z10;
        if (z10 || !this.f40811q) {
            return;
        }
        this.f40811q = false;
    }

    public boolean b() {
        return this.f40812r;
    }

    public void c(Context context, Bundle bundle, WbCloudFaceVerifyLoginListener wbCloudFaceVerifyLoginListener) {
        WLogger.d("WbFaceVerifyControl", "initWillSdk");
        a(context, true, true, false, bundle, null, wbCloudFaceVerifyLoginListener);
    }

    public void c(boolean z10) {
        this.f40811q = z10;
    }

    public boolean c() {
        return this.f40810p;
    }

    public void d(boolean z10) {
        this.f40808n = z10;
    }

    public boolean d() {
        return this.f40811q;
    }

    public com.tencent.cloud.huiyansdkface.facelight.a.a.b e() {
        return this.f40803i;
    }

    public void e(boolean z10) {
        this.f40805k = z10;
    }

    public WbUiTips f() {
        return this.f40803i.G();
    }

    public boolean g() {
        return this.f40809o;
    }

    public void h() {
        WLogger.d("WbFaceVerifyControl", "resetSdkServiceStatus");
        this.f40799e = false;
        this.f40800f = false;
    }

    public int i() {
        return this.f40813s;
    }

    public void j() {
        this.f40813s++;
    }

    public void k() {
        this.f40813s--;
    }

    public void l() {
        this.f40813s = 0;
    }

    public String m() {
        return this.f40814t;
    }

    public void n() {
        this.f40814t += "0";
    }

    public void o() {
        this.f40814t += "1";
    }

    public void p() {
        this.f40814t = "";
    }

    public boolean q() {
        return this.f40808n;
    }

    public int r() {
        return this.f40806l;
    }

    public void s() {
        this.f40806l++;
    }

    public boolean t() {
        return this.f40805k;
    }

    public boolean u() {
        return this.f40804j.n() && this.f40803i.y();
    }

    public boolean v() {
        return this.f40804j.I() && this.f40803i.D();
    }

    public String w() {
        return this.f40804j.i().orderNo;
    }

    public com.tencent.cloud.huiyansdkface.facelight.a.b.a x() {
        return this.f40804j;
    }

    public WbCloudFaceVerifyResultListener y() {
        return this.f40796b;
    }
}
