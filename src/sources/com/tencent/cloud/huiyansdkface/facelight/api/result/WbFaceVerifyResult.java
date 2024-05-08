package com.tencent.cloud.huiyansdkface.facelight.api.result;

import com.tencent.cloud.huiyansdkface.facelight.net.model.result.RiskInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbFaceVerifyResult {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40573a;

    /* renamed from: b, reason: collision with root package name */
    private String f40574b;

    /* renamed from: c, reason: collision with root package name */
    private String f40575c;

    /* renamed from: d, reason: collision with root package name */
    private String f40576d;

    /* renamed from: e, reason: collision with root package name */
    private String f40577e;

    /* renamed from: f, reason: collision with root package name */
    private String f40578f;

    /* renamed from: g, reason: collision with root package name */
    private WbFaceError f40579g;

    /* renamed from: h, reason: collision with root package name */
    private RiskInfo f40580h;

    /* renamed from: i, reason: collision with root package name */
    private WbSimpleModeResult f40581i;

    /* renamed from: j, reason: collision with root package name */
    private WbCusFaceVerifyResult f40582j;

    /* renamed from: k, reason: collision with root package name */
    private WbFaceWillModeResult f40583k;

    public WbCusFaceVerifyResult getCusResult() {
        return this.f40582j;
    }

    public WbFaceError getError() {
        return this.f40579g;
    }

    public String getLiveRate() {
        return this.f40575c;
    }

    public String getOrderNo() {
        return this.f40578f;
    }

    public RiskInfo getRiskInfo() {
        return this.f40580h;
    }

    public String getSign() {
        return this.f40574b;
    }

    public String getSimilarity() {
        return this.f40576d;
    }

    public WbSimpleModeResult getSimpleModeResult() {
        return this.f40581i;
    }

    public String getUserImageString() {
        return this.f40577e;
    }

    public WbFaceWillModeResult getWillResult() {
        return this.f40583k;
    }

    public boolean isSuccess() {
        return this.f40573a;
    }

    public void setCusResult(WbCusFaceVerifyResult wbCusFaceVerifyResult) {
        this.f40582j = wbCusFaceVerifyResult;
    }

    public void setError(WbFaceError wbFaceError) {
        this.f40579g = wbFaceError;
    }

    public void setIsSuccess(boolean z10) {
        this.f40573a = z10;
    }

    public void setLiveRate(String str) {
        this.f40575c = str;
    }

    public void setOrderNo(String str) {
        this.f40578f = str;
    }

    public void setRiskInfo(RiskInfo riskInfo) {
        this.f40580h = riskInfo;
    }

    public void setSign(String str) {
        this.f40574b = str;
    }

    public void setSimilarity(String str) {
        this.f40576d = str;
    }

    public void setSimpleModeResult(WbSimpleModeResult wbSimpleModeResult) {
        this.f40581i = wbSimpleModeResult;
    }

    public void setUserImageString(String str) {
        this.f40577e = str;
    }

    public void setWillResult(WbFaceWillModeResult wbFaceWillModeResult) {
        this.f40583k = wbFaceWillModeResult;
    }

    public String toString() {
        WbFaceError wbFaceError = this.f40579g;
        String wbFaceError2 = wbFaceError == null ? "" : wbFaceError.toString();
        WbFaceWillModeResult wbFaceWillModeResult = this.f40583k;
        return "WbFaceVerifyResult{isSuccess=" + this.f40573a + ", sign='" + this.f40574b + "', liveRate='" + this.f40575c + "', similarity='" + this.f40576d + "', orderNo='" + this.f40578f + "', riskInfo=" + ((Object) this.f40580h) + ", error=" + wbFaceError2 + ", willResult=" + (wbFaceWillModeResult != null ? wbFaceWillModeResult.toString() : "") + '}';
    }
}
