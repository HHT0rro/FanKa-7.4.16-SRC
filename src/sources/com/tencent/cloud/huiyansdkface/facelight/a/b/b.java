package com.tencent.cloud.huiyansdkface.facelight.a.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f40561a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f40562b;

        public static a a() {
            return new a();
        }

        public static a a(String str) {
            a aVar = new a();
            aVar.f40561a = 2;
            aVar.f40562b = str;
            return aVar;
        }

        public static a b(String str) {
            a aVar = new a();
            aVar.f40561a = 1;
            aVar.f40562b = str;
            return aVar;
        }

        public boolean b() {
            int i10 = this.f40561a;
            return i10 == 1 || i10 == 0;
        }

        public boolean c() {
            return this.f40561a == 0;
        }
    }

    public static com.tencent.cloud.huiyansdkface.facelight.a.b.a a(Bundle bundle, boolean z10, boolean z11, boolean z12) {
        String substring;
        com.tencent.cloud.huiyansdkface.facelight.a.b.a aVar = new com.tencent.cloud.huiyansdkface.facelight.a.b.a();
        WLogger.d("SdkConfigReader", "readSdkConfig");
        aVar.f40536b = z11;
        aVar.f40535a = z10;
        aVar.f40537c = z12;
        if (z12) {
            aVar.f40535a = true;
        }
        aVar.f40541g = bundle.getBoolean(WbCloudFaceContant.IS_ENABLE_LOG, false);
        aVar.f40538d = bundle.getBoolean(WbCloudFaceContant.IS_UNI, false);
        aVar.f40542h = bundle.getBoolean(WbCloudFaceContant.IS_ABROAD, false);
        aVar.f40545k = (WbCloudFaceVerifySdk.InputData) bundle.getSerializable(WbCloudFaceContant.INPUT_DATA);
        aVar.f40547m = bundle.getString(WbCloudFaceContant.COMPARE_TYPE, WbCloudFaceContant.ID_CARD);
        if (z11) {
            aVar.f40546l = WbCloudFaceContant.LANGUAGE_ZH_CN;
            aVar.f40544j = bundle.getString(WbCloudFaceContant.ENABLE_TRACK_LOG, "-1");
        } else {
            aVar.f40546l = bundle.getString(WbCloudFaceContant.LANGUAGE, WbCloudFaceContant.LANGUAGE_ZH_CN);
            aVar.f40544j = "-1";
        }
        if (z12) {
            if ("none".equals(aVar.f40547m)) {
                aVar.f40547m = WbCloudFaceContant.ID_CARD;
            }
            aVar.f40543i = false;
            aVar.f40559y = WbCloudFaceContant.WHITE;
            aVar.f40560z = 0;
            aVar.f40553s = bundle.getFloat(WbCloudFaceContant.WILL_MAX_PLAY_VOLUME);
            boolean z13 = bundle.getBoolean(WbCloudFaceContant.RECORD_WILL_VIDEO, false);
            aVar.f40551q = z13;
            if (z13) {
                aVar.f40552r = bundle.getBoolean(WbCloudFaceContant.CHECK_WILL_VIDEO, false);
                aVar.f40554t = bundle.getBoolean(WbCloudFaceContant.UPLOAD_AND_RETURN_WILL_VIDEO, false);
            }
        } else {
            aVar.f40543i = bundle.getBoolean(WbCloudFaceContant.IS_LANDSCAPE, false);
            aVar.f40559y = bundle.getString(WbCloudFaceContant.COLOR_MODE, WbCloudFaceContant.WHITE);
            aVar.f40560z = bundle.getInt(WbCloudFaceContant.CUSTOMER_TIPS_LOC, 0);
        }
        aVar.f40549o = bundle.getBoolean(WbCloudFaceContant.VIDEO_UPLOAD, false);
        aVar.f40548n = bundle.getBoolean(WbCloudFaceContant.VIDEO_CHECK, false);
        if (!aVar.f40549o) {
            aVar.f40548n = false;
        }
        aVar.f40550p = true;
        String deviceModel = Param.getDeviceModel();
        if ("ZUK Z2131".equals(deviceModel) || "Lenovo X3c70".equals(deviceModel)) {
            aVar.f40550p = false;
        }
        aVar.f40555u = bundle.getBoolean(WbCloudFaceContant.PLAY_VOICE, false);
        if ("PCHM10".equals(deviceModel) || "PCHT10".equals(deviceModel) || "PCHM30".equals(deviceModel) || "PCHT30".equals(deviceModel) || "PDAM10".equals(deviceModel)) {
            aVar.f40555u = false;
        }
        aVar.f40556v = bundle.getString(WbCloudFaceContant.YT_MODEL_LOC);
        aVar.f40558x = bundle.getBoolean(WbCloudFaceContant.SWITCH_CAM, false);
        aVar.f40557w = bundle.getInt(WbCloudFaceContant.BLINK_SAFETY, 1);
        aVar.A = bundle.getString(WbCloudFaceContant.CUSTOMER_TIPS_LIVE);
        aVar.B = bundle.getString(WbCloudFaceContant.CUSTOMER_TIPS_UPLOAD);
        aVar.C = bundle.getString(WbCloudFaceContant.CUSTOMER_LONG_TIP);
        aVar.D = bundle.getString(WbCloudFaceContant.CUSTOMER_CAM_REASON);
        aVar.E = bundle.getString(WbCloudFaceContant.CUSTOMER_WILL_PERMISSION_REASON);
        if (!TextUtils.isEmpty(aVar.A)) {
            aVar.A = aVar.A.length() > 17 ? aVar.A.substring(0, 17) : aVar.A;
        }
        if (!TextUtils.isEmpty(aVar.B)) {
            aVar.B = aVar.B.length() > 17 ? aVar.B.substring(0, 17) : aVar.B;
        }
        if (!TextUtils.isEmpty(aVar.C)) {
            aVar.C = aVar.C.length() > 70 ? aVar.C.substring(0, 70) : aVar.C;
        }
        if (!TextUtils.isEmpty(aVar.D)) {
            aVar.D = aVar.D.length() > 17 ? aVar.D.substring(0, 17) : aVar.D;
        }
        if (!TextUtils.isEmpty(aVar.E)) {
            aVar.E = aVar.E.length() > 17 ? aVar.E.substring(0, 17) : aVar.E;
        }
        if (WbCloudFaceContant.LANGUAGE_ZH_CN.equals(aVar.f40546l)) {
            aVar.F = bundle.getString(WbCloudFaceContant.DIALOG_TITLE);
            aVar.G = bundle.getString(WbCloudFaceContant.DIALOG_TEXT);
            aVar.H = bundle.getString(WbCloudFaceContant.DIALOG_YES);
            aVar.I = bundle.getString(WbCloudFaceContant.DIALOG_NO);
            if (!TextUtils.isEmpty(aVar.F)) {
                aVar.F = aVar.F.length() > 8 ? aVar.F.substring(0, 8) : aVar.F;
            }
            if (!TextUtils.isEmpty(aVar.G)) {
                aVar.G = aVar.G.length() > 15 ? aVar.G.substring(0, 15) : aVar.G;
            }
            if (!TextUtils.isEmpty(aVar.H)) {
                aVar.H = aVar.H.length() > 5 ? aVar.H.substring(0, 5) : aVar.H;
            }
            substring = TextUtils.isEmpty(aVar.I) ? null : aVar.I.length() > 5 ? aVar.I.substring(0, 5) : aVar.I;
            aVar.J = bundle.getBoolean(WbCloudFaceContant.IS_SIMPLE_MODE, false);
            WLogger.d("SdkConfigReader", "isSimpleMode=" + aVar.J);
            aVar.K = bundle.getBoolean(WbCloudFaceContant.RETURN_VIDEO, false);
            aVar.L = bundle.getString(WbCloudFaceContant.USER_PUBLIC_KEY);
            aVar.M = bundle.getString(WbCloudFaceContant.USER_AES_IV);
            WLogger.d("SdkConfigReader", "finish read setting");
            return aVar;
        }
        WLogger.d("SdkConfigReader", "international");
        aVar.f40555u = false;
        aVar.F = null;
        aVar.G = null;
        aVar.H = null;
        aVar.I = substring;
        aVar.J = bundle.getBoolean(WbCloudFaceContant.IS_SIMPLE_MODE, false);
        WLogger.d("SdkConfigReader", "isSimpleMode=" + aVar.J);
        aVar.K = bundle.getBoolean(WbCloudFaceContant.RETURN_VIDEO, false);
        aVar.L = bundle.getString(WbCloudFaceContant.USER_PUBLIC_KEY);
        aVar.M = bundle.getString(WbCloudFaceContant.USER_AES_IV);
        WLogger.d("SdkConfigReader", "finish read setting");
        return aVar;
    }

    public static a a(com.tencent.cloud.huiyansdkface.facelight.a.b.a aVar) {
        String str;
        WLogger.i("SdkConfigReader", "checkInputData");
        WbCloudFaceVerifySdk.InputData inputData = aVar.f40545k;
        if (inputData == null) {
            WLogger.e("SdkConfigReader", "InputData is null!");
            return a.a("传入的InputData为空");
        }
        Param.setFaceId(inputData.faceId);
        if (!TextUtils.isEmpty(inputData.appId)) {
            str = inputData.appId;
        } else {
            if (!aVar.S()) {
                WLogger.e("SdkConfigReader", "appId is null!");
                return a.a("传入appId为空");
            }
            str = "";
        }
        Param.setAppId(str);
        if (TextUtils.isEmpty(inputData.orderNo)) {
            WLogger.e("SdkConfigReader", "orderNo is null!");
            return a.a("传入orderNo为空");
        }
        Param.setOrderNo(inputData.orderNo);
        if (TextUtils.isEmpty(inputData.licence)) {
            WLogger.e("SdkConfigReader", "licence is null!");
            return a.b("传入licence为空");
        }
        if (aVar.S()) {
            return a.a();
        }
        if (TextUtils.isEmpty(inputData.userId)) {
            WLogger.e("SdkConfigReader", "userId is null!");
            return a.b("传入userId为空");
        }
        Param.setUserId(inputData.userId);
        if (TextUtils.isEmpty(inputData.version)) {
            WLogger.e("SdkConfigReader", "version is null!");
            return a.b("传入version为空");
        }
        Param.setVersion(inputData.version);
        if (TextUtils.isEmpty(inputData.nonce)) {
            WLogger.e("SdkConfigReader", "nonce is null!");
            return a.b("传入nonce为空");
        }
        if (!TextUtils.isEmpty(inputData.sign)) {
            return a.a();
        }
        WLogger.e("SdkConfigReader", "sign is null!");
        return a.b("传入sign为空");
    }

    public static a b(com.tencent.cloud.huiyansdkface.facelight.a.b.a aVar) {
        StringBuilder sb2;
        String str;
        WLogger.i("SdkConfigReader", "checkFaceId");
        WbCloudFaceVerifySdk.InputData inputData = aVar.f40545k;
        if (inputData == null) {
            WLogger.e("SdkConfigReader", "InputData is null!");
            str = "传入的InputData为空";
        } else {
            String str2 = inputData.faceId;
            boolean z10 = false;
            if (TextUtils.isEmpty(str2)) {
                if (aVar.l() || (!aVar.e() && "none".equals(aVar.k()))) {
                    z10 = true;
                }
                if (!z10) {
                    WLogger.e("SdkConfigReader", "faceId is null!");
                    Param.setFaceId("");
                    str = "传入faceId为空";
                }
                return a.a();
            }
            if (str2.length() < 6) {
                WLogger.e("SdkConfigReader", "faceId长度校验不通过：" + str2.length());
                Param.setFaceId("");
                sb2 = new StringBuilder();
                sb2.append("faceId格式效验不通过:len=");
                sb2.append(str2.length());
            } else {
                try {
                    int intValue = Integer.valueOf(str2.substring(2, 3)).intValue();
                    WLogger.d("SdkConfigReader", "label=" + intValue);
                    if ((intValue == 1 && aVar.e()) || ((intValue == 2 && aVar.T()) || (intValue == 0 && !aVar.e() && !aVar.T()))) {
                        z10 = true;
                    }
                    if (z10) {
                        String substring = str2.substring(3, 4);
                        WLogger.d("SdkConfigReader", "control =" + substring);
                        if ("1".equals(substring)) {
                            String faceId = Param.getFaceId();
                            WLogger.d("SdkConfigReader", "last faceId=" + faceId);
                            if (!TextUtils.isEmpty(faceId)) {
                                String substring2 = faceId.substring(faceId.length() - 6);
                                WLogger.d("SdkConfigReader", "lastKey =" + substring2);
                                String substring3 = str2.substring(str2.length() - 6);
                                WLogger.d("SdkConfigReader", "key =" + substring3);
                                if (substring3.equals(substring2)) {
                                    aVar.N = true;
                                }
                            }
                        }
                        return a.a();
                    }
                    WLogger.e("SdkConfigReader", "faceId is not matched!");
                    Param.setFaceId("");
                    str = "faceId不匹配";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    WLogger.e("SdkConfigReader", "extract faceId failed:" + e2.toString());
                    Param.setFaceId("");
                    sb2 = new StringBuilder();
                    sb2.append("faceId格式效验不通过:");
                    sb2.append(str2);
                }
            }
            str = sb2.toString();
        }
        return a.a(str);
    }
}
