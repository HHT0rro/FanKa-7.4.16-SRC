package com.tencent.cloud.huiyansdkface.facelight.common;

import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeOkHttpProvider {
    public static String getComparePath(boolean z10) {
        boolean equals = "none".equals(d.z().x().k());
        return z10 ? equals ? "/v3/sdk/appUploadGen" : "/v3/sdk/faceCompareGen" : equals ? "/gradelive/appuploadEn" : "/grade/facecompareEn";
    }

    public static String getLoginPath(boolean z10) {
        return z10 ? "/v3/sdk/ssoLoginGen" : "/idap/v2/ssoLoginEn";
    }

    public static String getPathEnv() {
        int Y = d.z().x().Y();
        return Y != 1 ? Y != 2 ? "/api" : "/api-press" : "/api-dev";
    }

    public static String getQueryPath(boolean z10) {
        return z10 ? "/v3/sdk/getFaceResultGen" : "/server/getfaceresult";
    }

    public static String getResPath(boolean z10) {
        d z11 = d.z();
        boolean z12 = "none".equals(z11.x().k()) || z11.x().l();
        return z10 ? z12 ? "/v3/sdk/getLiveFlashResourceGen" : "/v3/sdk/getFlashResourceGen" : z12 ? "/gradelive/getflashresourceEn" : "/grade/getflashresourceEn";
    }

    public static String getTuringCamPath(boolean z10) {
        return z10 ? "/v3/sdk/turingPackageCameraGen" : "/server/turingpackagecamera";
    }

    public static String getTuringPath(boolean z10) {
        return z10 ? "/v3/sdk/turingPackageSyncGen" : "/server/turingpackagesync";
    }

    public static WeOkHttp getWeOkHttp() {
        return d.z().a();
    }

    public static String getWillAsrPath() {
        return "/asr/sdkasr";
    }

    public static String getWillComparePath(boolean z10) {
        return z10 ? "/v3/sdk/willFacecompareGen" : "/grade/willFacecompareEn";
    }

    public static String getWillLoginPath(boolean z10) {
        return z10 ? "/v3/sdk/willLoginGen" : "/idap/v2/willLoginEn";
    }

    public static String getWillResPath(boolean z10) {
        return z10 ? "/v3/sdk/getWillResourceGen" : "/asr/getWillResource";
    }

    public static String getWillUploadVideoPath() {
        return "/asr/uploadData";
    }
}
