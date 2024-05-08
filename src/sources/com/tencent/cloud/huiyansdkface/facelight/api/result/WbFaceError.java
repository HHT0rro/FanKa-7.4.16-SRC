package com.tencent.cloud.huiyansdkface.facelight.api.result;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbFaceError {
    public static final String WBFaceErrorCodeActOutOfTime = "41008";
    public static final String WBFaceErrorCodeCameraException = "41003";
    public static final String WBFaceErrorCodeCompareNetworkError = "51100";
    public static final String WBFaceErrorCodeCompareServerError = "51200";
    public static final String WBFaceErrorCodeDataSerilizerError = "11002";
    public static final String WBFaceErrorCodeFindFaceOutOfTime = "41007";
    public static final String WBFaceErrorCodeGetInfoNetworkError = "31100";
    public static final String WBFaceErrorCodeGetInfoServerError = "31200";
    public static final String WBFaceErrorCodeInitModel = "41012";
    public static final String WBFaceErrorCodeInputModelsError = "11005";
    public static final String WBFaceErrorCodeInputParaNull = "11000";
    public static final String WBFaceErrorCodeKeyLicenceError = "11001";
    public static final String WBFaceErrorCodeLipStrError = "41001";
    public static final String WBFaceErrorCodeLocalLightError = "41009";
    public static final String WBFaceErrorCodeLoginNetworkError = "21100";
    public static final String WBFaceErrorCodeLoginServerError = "21200";
    public static final String WBFaceErrorCodeMediaFileError = "41006";
    public static final String WBFaceErrorCodeMediaRecord = "41004";
    public static final String WBFaceErrorCodeNoBestPic = "41005";
    public static final String WBFaceErrorCodeNoPermission = "41002";
    public static final String WBFaceErrorCodeNoVolumn = "41011";
    public static final String WBFaceErrorCodeOutOfControlNum = "41010";
    public static final String WBFaceErrorCodeSdkInitFail = "41013";
    public static final String WBFaceErrorCodeSimpleLocalError = "41014";
    public static final String WBFaceErrorCodeUserCancle = "41000";
    public static final String WBFaceErrorCodeWillLowPlayVolumeError = "41106";
    public static final String WBFaceErrorCodeWillNoVoiceError = "41102";
    public static final String WBFaceErrorCodeWillPlayError = "41104";
    public static final String WBFaceErrorCodeWillPrepareError = "41103";
    public static final String WBFaceErrorCodeWillRecordError = "41101";
    public static final String WBFaceErrorCodeWillVideoRecordError = "41105";
    public static final String WBFaceErrorDomainCompareNetwork = "WBFaceErrorDomainCompareNetwork";
    public static final String WBFaceErrorDomainCompareServer = "WBFaceErrorDomainCompareServer";
    public static final String WBFaceErrorDomainDevices = "WBFaceErrorDomainDevices";
    public static final String WBFaceErrorDomainGetInfoNetwork = "WBFaceErrorDomainGetInfoNetwork";
    public static final String WBFaceErrorDomainGetInfoServer = "WBFaceErrorDomainGetInfoServer";
    public static final String WBFaceErrorDomainLoginNetwork = "WBFaceErrorDomainLoginNetwork";
    public static final String WBFaceErrorDomainLoginServer = "WBFaceErrorDomainLoginServer";
    public static final String WBFaceErrorDomainNativeProcess = "WBFaceErrorDomainNativeProcess";
    public static final String WBFaceErrorDomainParams = "WBFaceErrorDomainParams";
    public static final String WBFaceErrorDomainSeverFailed = "WBFaceErrorDomainSeverFailed";

    /* renamed from: a, reason: collision with root package name */
    private String f40569a;

    /* renamed from: b, reason: collision with root package name */
    private String f40570b;

    /* renamed from: c, reason: collision with root package name */
    private String f40571c;

    /* renamed from: d, reason: collision with root package name */
    private String f40572d;

    public WbFaceError() {
    }

    public WbFaceError(String str, String str2, String str3, String str4) {
        this.f40569a = str;
        this.f40570b = str2;
        this.f40571c = str3;
        this.f40572d = str4;
    }

    public String getCode() {
        return this.f40570b;
    }

    public String getDesc() {
        return this.f40571c;
    }

    public String getDomain() {
        return this.f40569a;
    }

    public String getReason() {
        return this.f40572d;
    }

    public void setCode(String str) {
        this.f40570b = str;
    }

    public void setDesc(String str) {
        this.f40571c = str;
    }

    public void setDomain(String str) {
        this.f40569a = str;
    }

    public void setReason(String str) {
        this.f40572d = str;
    }

    public String toString() {
        return "WbFaceError{domain='" + this.f40569a + "', code='" + this.f40570b + "', desc='" + this.f40571c + "', reason='" + this.f40572d + "'}";
    }
}
