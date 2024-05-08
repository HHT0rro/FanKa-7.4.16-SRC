package com.tencent.cloud.huiyansdkface.facelight.provider;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceWillModeResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.FaceWillResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.RiskInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbFaceInnerError implements Parcelable {
    public static final Parcelable.Creator<WbFaceInnerError> CREATOR = new Parcelable.Creator<WbFaceInnerError>() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WbFaceInnerError createFromParcel(Parcel parcel) {
            return new WbFaceInnerError(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WbFaceInnerError[] newArray(int i10) {
            return new WbFaceInnerError[i10];
        }
    };
    public String code;
    public String desc;
    public String domain;
    public String faceCode;
    public String faceMsg;
    public String isRecorded;
    public String liveRate;
    public String reason;
    public String retry;
    public RiskInfo riskInfo;
    public String sign;
    public String similarity;
    public String willCode;
    public String willMsg;

    public WbFaceInnerError() {
    }

    public WbFaceInnerError(Parcel parcel) {
        this.domain = parcel.readString();
        this.code = parcel.readString();
        this.desc = parcel.readString();
        this.reason = parcel.readString();
        this.faceCode = parcel.readString();
        this.faceMsg = parcel.readString();
        this.similarity = parcel.readString();
        this.liveRate = parcel.readString();
        this.retry = parcel.readString();
        this.sign = parcel.readString();
        this.isRecorded = parcel.readString();
        this.willCode = parcel.readString();
        this.willMsg = parcel.readString();
    }

    public static WbFaceInnerError create(String str, String str2, String str3, String str4) {
        WbFaceInnerError wbFaceInnerError = new WbFaceInnerError();
        wbFaceInnerError.domain = str;
        wbFaceInnerError.code = str2;
        wbFaceInnerError.desc = str3;
        wbFaceInnerError.reason = str4;
        return wbFaceInnerError;
    }

    public static WbFaceInnerError create(String str, String str2, String str3, String str4, String str5, String str6, String str7, RiskInfo riskInfo, String str8, String str9) {
        WbFaceInnerError wbFaceInnerError = new WbFaceInnerError();
        wbFaceInnerError.domain = str;
        wbFaceInnerError.code = str2;
        wbFaceInnerError.desc = str3;
        wbFaceInnerError.reason = str4;
        wbFaceInnerError.similarity = str5;
        wbFaceInnerError.liveRate = str6;
        wbFaceInnerError.retry = str7;
        wbFaceInnerError.riskInfo = riskInfo;
        wbFaceInnerError.sign = str8;
        wbFaceInnerError.isRecorded = str9;
        return wbFaceInnerError;
    }

    public static WbFaceInnerError parseFromFinalResult(FaceWillResult faceWillResult) {
        WbFaceInnerError wbFaceInnerError = new WbFaceInnerError();
        wbFaceInnerError.code = faceWillResult.code;
        String str = faceWillResult.msg;
        wbFaceInnerError.desc = str;
        wbFaceInnerError.reason = str;
        wbFaceInnerError.faceCode = faceWillResult.faceCode;
        wbFaceInnerError.faceMsg = faceWillResult.faceMsg;
        wbFaceInnerError.similarity = faceWillResult.similarity;
        wbFaceInnerError.liveRate = faceWillResult.liveRate;
        wbFaceInnerError.retry = faceWillResult.retry;
        wbFaceInnerError.riskInfo = faceWillResult.riskInfo;
        wbFaceInnerError.sign = faceWillResult.sign;
        wbFaceInnerError.isRecorded = faceWillResult.isRecorded;
        wbFaceInnerError.willCode = faceWillResult.willCode;
        wbFaceInnerError.willMsg = faceWillResult.willMsg;
        return wbFaceInnerError;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WbFaceInnerError{domain='" + this.domain + "', code='" + this.code + "', desc='" + this.desc + "', reason='" + this.reason + "', faceCode='" + this.faceCode + "', faceMsg='" + this.faceMsg + "', similarity='" + this.similarity + "', liveRate='" + this.liveRate + "', retry='" + this.retry + "', riskInfo=" + ((Object) this.riskInfo) + ", sign='" + this.sign + "', isRecorded='" + this.isRecorded + "', willCode='" + this.willCode + "', willMsg='" + this.willMsg + "'}";
    }

    public WbFaceError toWbFaceError() {
        WbFaceError wbFaceError = new WbFaceError();
        wbFaceError.setDomain(this.domain);
        wbFaceError.setCode(this.code);
        wbFaceError.setDesc(this.desc);
        wbFaceError.setReason(this.reason);
        return wbFaceError;
    }

    public WbFaceVerifyResult toWbFaceVerifyResult() {
        WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
        wbFaceVerifyResult.setIsSuccess(false);
        wbFaceVerifyResult.setSign(this.sign);
        wbFaceVerifyResult.setRiskInfo(this.riskInfo);
        wbFaceVerifyResult.setLiveRate(this.liveRate);
        wbFaceVerifyResult.setSimilarity(this.similarity);
        wbFaceVerifyResult.setRiskInfo(this.riskInfo);
        wbFaceVerifyResult.setError(toWbFaceError());
        wbFaceVerifyResult.setWillResult(toWbFaceWillResult());
        return wbFaceVerifyResult;
    }

    public WbFaceWillModeResult toWbFaceWillResult() {
        WbFaceWillModeResult wbFaceWillModeResult = new WbFaceWillModeResult();
        wbFaceWillModeResult.setWillCode(this.willCode);
        wbFaceWillModeResult.setWillMsg(this.willMsg);
        wbFaceWillModeResult.setFaceCode(this.faceCode);
        wbFaceWillModeResult.setFaceMsg(this.faceMsg);
        return wbFaceWillModeResult;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.domain);
        parcel.writeString(this.code);
        parcel.writeString(this.desc);
        parcel.writeString(this.reason);
        parcel.writeString(this.faceCode);
        parcel.writeString(this.faceMsg);
        parcel.writeString(this.similarity);
        parcel.writeString(this.liveRate);
        parcel.writeString(this.retry);
        parcel.writeString(this.sign);
        parcel.writeString(this.isRecorded);
        parcel.writeString(this.willCode);
        parcel.writeString(this.willMsg);
    }
}
