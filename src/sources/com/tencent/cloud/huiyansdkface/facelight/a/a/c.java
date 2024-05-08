package com.tencent.cloud.huiyansdkface.facelight.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.packet.e;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.c.d.d;
import com.tencent.cloud.huiyansdkface.facelight.c.g;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.GetCdnGradeInfo;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbUiTips;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.cloud.huiyansdkface.wejson.WeJsonException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private b f40527a = new b();

    /* renamed from: b, reason: collision with root package name */
    private CloudFaceCountDownTimer f40528b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40529c;

    private String a(Context context) {
        WLogger.d("GetCdnInfo", "check local config is exist");
        return (String) new g(context).b("gradeInfo", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Properties a(b bVar) {
        Properties properties = new Properties();
        properties.setProperty("cdnConfig", bVar.toString());
        return properties;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, GetCdnGradeInfo.GetGradeInfoResponse getGradeInfoResponse) {
        WLogger.d("GetCdnInfo", "updateSp");
        if (getGradeInfoResponse == null) {
            return;
        }
        g gVar = new g(context);
        if (!TextUtils.isEmpty(getGradeInfoResponse.version)) {
            gVar.a("version", getGradeInfoResponse.version);
        }
        String json = new WeJson().toJson(getGradeInfoResponse);
        if (TextUtils.isEmpty(json)) {
            return;
        }
        gVar.a("gradeInfo", json);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0c45  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0c6b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0c91  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0ccb  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0d00  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0d35  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0d6a  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0d9f  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0dd4  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0e09  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0e3e  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x1023  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x106e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0cbf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r104, java.lang.String r105, com.tencent.cloud.huiyansdkface.facelight.net.GetCdnGradeInfo.GetGradeInfoResponse r106) {
        /*
            Method dump skipped, instructions count: 4402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.a.a.c.a(android.content.Context, java.lang.String, com.tencent.cloud.huiyansdkface.facelight.net.GetCdnGradeInfo$GetGradeInfoResponse):void");
    }

    private void a(List<String> list, List<String> list2) {
        String str;
        WLogger.d("GetCdnInfo", "after appId set,check version and model is use Turing");
        if (this.f40527a.G) {
            if (list != null) {
                String valueOf = String.valueOf(Build.VERSION.SDK_INT);
                WLogger.d("GetCdnInfo", "versionList=" + list.toString().trim() + ",version=" + valueOf);
                if (list.contains(valueOf)) {
                    WLogger.d("GetCdnInfo", "match banTuringSdkVersionList! no use TuringSdk:osversion");
                    this.f40527a.G = false;
                    str = "osversion";
                } else {
                    WLogger.d("GetCdnInfo", "dont match banTuringSdkVersionList list! ");
                }
            } else {
                WLogger.e("GetCdnInfo", "cdn cant get banTuringSdkVersionList list");
            }
            if (list2 == null) {
                WLogger.e("GetCdnInfo", "cdn cant get banTuringSdk list");
                return;
            }
            WLogger.d("GetCdnInfo", "banTuringList=" + list2.toString().trim());
            String deviceModel = Param.getDeviceModel();
            WLogger.d("GetCdnInfo", "model=" + deviceModel);
            if (!list2.contains(deviceModel)) {
                WLogger.d("GetCdnInfo", "dont match banTuringSdk list! ");
                return;
            } else {
                WLogger.d("GetCdnInfo", "match banTuringSdk list! ");
                this.f40527a.G = false;
                str = e.f4642n;
            }
        } else {
            WLogger.d("GetCdnInfo", "appId already false");
            str = "appid";
        }
        Param.appendTuringInfo(str);
    }

    private String b(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1179248177:
                if (str.equals(WbCloudFaceContant.LANGUAGE_EN)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1179248063:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ID)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1179248035:
                if (str.equals(WbCloudFaceContant.LANGUAGE_JA)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1179247990:
                if (str.equals(WbCloudFaceContant.LANGUAGE_KO)) {
                    c4 = 3;
                    break;
                }
                break;
            case -1179247718:
                if (str.equals(WbCloudFaceContant.LANGUAGE_TH)) {
                    c4 = 4;
                    break;
                }
                break;
            case 1869350094:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ZH_HK)) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "kyc_language_US";
            case 1:
                return "kyc_language_ID";
            case 2:
                return "kyc_language_JP";
            case 3:
                return "kyc_language_KR";
            case 4:
                return "kyc_language_TH";
            case 5:
                return "kyc_language_TCN";
            default:
                return "kyc_language_CN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        if (this.f40529c) {
            WLogger.d("GetCdnInfo", "already init TuringSdk");
            return;
        }
        this.f40529c = true;
        if (!this.f40527a.G) {
            WLogger.d("GetCdnInfo", "no need to initTuringSdk");
            return;
        }
        WLogger.d("GetCdnInfo", "initTuringSdk");
        Param.appendTuringSdkInfo();
        d.a(context);
        this.f40527a.H = true;
    }

    private WbUiTips c(String str) {
        str.hashCode();
        return new WbUiTips();
    }

    public b a() {
        return this.f40527a;
    }

    public GetCdnGradeInfo.GetGradeInfoResponse a(String str) {
        WLogger.d("GetCdnInfo", "parseStringToConfig");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (GetCdnGradeInfo.GetGradeInfoResponse) new WeJson().fromJson(str, GetCdnGradeInfo.GetGradeInfoResponse.class);
        } catch (WeJsonException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(Context context, String str) {
        WLogger.d("GetCdnInfo", "checkDefaultOrLocalConfig");
        String a10 = a(context);
        if (TextUtils.isEmpty(a10)) {
            b(context, str);
        } else {
            a(context, str, a(a10));
        }
    }

    public void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            WLogger.i("GetCdnInfo", "cus cdn config is null,use default or local");
            a(context, str);
        } else {
            WLogger.i("GetCdnInfo", "useCusCdnConfig");
            GetCdnGradeInfo.GetGradeInfoResponse a10 = a(str2);
            a(context, str, a10);
            a(context, a10);
        }
    }

    public void a(boolean z10, final Context context, final String str, final a aVar) {
        WLogger.d("GetCdnInfo", "getConfigInfo");
        String str2 = "https://kyccdn.tencentcloudapi.com" + (!WbCloudFaceContant.LANGUAGE_ZH_CN.equals(str) ? "/kyc/WbGradeInfoInternational.json" : "/kyc/WbGradeInfo.json");
        WLogger.d("GetCdnInfo", "start getConfigInfo request:" + str2);
        KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_cdn_request", null, null);
        GetCdnGradeInfo.requestExec(str2, new WeReq.Callback<GetCdnGradeInfo.GetGradeInfoResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.a.a.c.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WeReq weReq, GetCdnGradeInfo.GetGradeInfoResponse getGradeInfoResponse) {
                WLogger.d("GetCdnInfo", "cdn拉取设置信息 onSuccess");
                if (getGradeInfoResponse != null) {
                    c.this.a(context, str, getGradeInfoResponse);
                } else {
                    WLogger.e("GetCdnInfo", "getGradeInfoResponse is null!");
                    c.this.a(context, str);
                }
                KycWaSDK kycWaSDK = KycWaSDK.getInstance();
                Context context2 = context;
                c cVar = c.this;
                kycWaSDK.trackCustomKVEvent(context2, "faceservice_cdn_response", "onSuccess", cVar.a(cVar.f40527a));
                aVar.a();
                c.this.a(context, getGradeInfoResponse);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str3, IOException iOException) {
                WLogger.e("GetCdnInfo", "cdn拉取设置信息失败:" + ((Object) errType) + ",code=" + i10 + "; msg=" + str3);
                KycWaSDK.getInstance().trackCustomKVEvent(context, "faceservice_cdn_response", "onFailed:type=" + ((Object) errType) + "code=" + i10 + ",msg=" + str3, null);
                c.this.a(context, str);
                aVar.a();
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
                if (c.this.f40528b == null) {
                    c.this.f40528b = new CloudFaceCountDownTimer(500L, 250L) { // from class: com.tencent.cloud.huiyansdkface.facelight.a.a.c.1.1
                        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                        public void onFinish() {
                            WLogger.d("GetCdnInfo", "init turing cdt finish");
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c.this.b(context);
                        }

                        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                        public void onTick(long j10) {
                        }
                    }.start();
                    WLogger.d("GetCdnInfo", "init turing cdt start");
                }
            }
        });
    }

    public void b(Context context, String str) {
        WLogger.d("GetCdnInfo", "useDefaultConfig");
        a(context, str, a(new b().aC));
    }
}
