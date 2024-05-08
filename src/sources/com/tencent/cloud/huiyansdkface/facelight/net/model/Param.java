package com.tencent.cloud.huiyansdkface.facelight.net.model;

import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.c.d.d;
import com.tencent.cloud.huiyansdkface.facelight.common.WbSecureProviders;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class Param {
    private static String appId;
    private static String compareMode;
    private static String csrfToken;
    private static String deviceInfo;
    private static String deviceModel;
    private static String faceId;
    private static String gradeCompareType;
    private static String orderNo;
    private static String rolateInfo;
    private static String turingPackage;
    private static String turingVideoData;
    private static String userId;
    private static String verifyType;
    private static String version;

    public static void appendBestImgInfo(String str) {
        deviceInfo += ";wbimage=" + str;
    }

    public static void appendBlinkInfo(String str) {
        String str2 = deviceInfo;
        if (TextUtils.isEmpty(str2) || !str2.contains(";blinkcheck=")) {
            deviceInfo += ";blinkcheck=" + str;
        }
    }

    public static void appendGmInfo() {
        deviceInfo += (WbSecureProviders.isUseGm() ? ";gm=1" : ";gm=0");
    }

    public static void appendLightLocalInfo(int i10) {
        deviceInfo += ";light_error=" + i10;
    }

    public static void appendRequestRetryInfo(int i10) {
        String str = deviceInfo;
        if (i10 == 0) {
            str = str + ";internet_retry=" + i10;
        } else {
            try {
                str = str.replace(";internet_retry=" + (i10 - 1), ";internet_retry=" + i10);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        deviceInfo = str;
    }

    public static void appendTuringInfo(String str) {
        deviceInfo += ";ignoreTld=" + str;
    }

    public static void appendTuringSdkInfo() {
        deviceInfo += ";tsv=" + d.b();
    }

    public static String getAppId() {
        return appId;
    }

    public static String getCompareMode() {
        return compareMode;
    }

    public static String getCsrfToken() {
        return csrfToken;
    }

    public static String getDeviceInfo() {
        return deviceInfo;
    }

    public static String getDeviceModel() {
        return deviceModel;
    }

    public static String getFaceId() {
        return faceId;
    }

    public static String getGradeCompareType() {
        return gradeCompareType;
    }

    public static String getOrderNo() {
        return orderNo;
    }

    public static String getRolateInfo() {
        return rolateInfo;
    }

    public static String getTuringPackage() {
        return turingPackage;
    }

    public static String getTuringVideoData() {
        return turingVideoData;
    }

    public static String getUserId() {
        return userId;
    }

    public static String getVerifyType() {
        return verifyType;
    }

    public static String getVersion(boolean z10) {
        return z10 ? "2.0.0" : version;
    }

    public static void resetParams() {
        deviceModel = null;
        deviceInfo = null;
        version = null;
        appId = null;
        userId = null;
        orderNo = null;
        faceId = null;
        csrfToken = null;
        compareMode = null;
        rolateInfo = null;
        gradeCompareType = null;
        turingPackage = null;
        turingVideoData = null;
        verifyType = null;
    }

    public static void setAppId(String str) {
        appId = str;
    }

    public static void setCompareMode(String str) {
        compareMode = str;
    }

    public static void setCsrfToken(String str) {
        csrfToken = str;
    }

    public static void setDeviceInfo(String str) {
        deviceInfo = str;
    }

    public static void setDeviceModel(String str) {
        deviceModel = str;
    }

    public static void setFaceId(String str) {
        faceId = str;
    }

    public static void setGradeCompareType(String str) {
        gradeCompareType = str;
    }

    public static void setOrderNo(String str) {
        orderNo = str;
    }

    public static void setRolateInfo(String str) {
        rolateInfo = str;
    }

    public static void setTuringPackage(String str) {
        turingPackage = str;
    }

    public static void setTuringVideoData(String str) {
        turingVideoData = str;
    }

    public static void setUserId(String str) {
        userId = str;
    }

    public static void setVerifyType(String str) {
        verifyType = str;
    }

    public static void setVersion(String str) {
        version = str;
    }
}
