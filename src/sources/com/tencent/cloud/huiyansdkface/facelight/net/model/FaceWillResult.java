package com.tencent.cloud.huiyansdkface.facelight.net.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceWillModeResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.result.RiskInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FaceWillResult implements Parcelable {
    public static final Parcelable.Creator<FaceWillResult> CREATOR = new Parcelable.Creator<FaceWillResult>() { // from class: com.tencent.cloud.huiyansdkface.facelight.net.model.FaceWillResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FaceWillResult createFromParcel(Parcel parcel) {
            return new FaceWillResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FaceWillResult[] newArray(int i10) {
            return new FaceWillResult[i10];
        }
    };
    public String code;
    public String faceCode;
    public String faceMsg;
    public String isRecorded;
    public String liveRate;
    public String msg;
    public String orderNo;
    public String retry;
    public RiskInfo riskInfo;
    public String sign;
    public String similarity;
    public String willCode;
    public String willMsg;

    public FaceWillResult() {
    }

    public FaceWillResult(Parcel parcel) {
        this.code = parcel.readString();
        this.msg = parcel.readString();
        this.faceCode = parcel.readString();
        this.faceMsg = parcel.readString();
        this.willCode = parcel.readString();
        this.willMsg = parcel.readString();
        this.orderNo = parcel.readString();
        this.similarity = parcel.readString();
        this.liveRate = parcel.readString();
        this.retry = parcel.readString();
        this.sign = parcel.readString();
        this.isRecorded = parcel.readString();
    }

    public FaceWillResult(String str, String str2, String str3, String str4, String str5, RiskInfo riskInfo, String str6, String str7) {
        this.faceCode = str;
        this.faceMsg = str2;
        this.similarity = str3;
        this.liveRate = str4;
        this.retry = str5;
        this.riskInfo = riskInfo;
        this.sign = str6;
        this.isRecorded = str7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FaceWillResult{code='" + this.code + "', msg='" + this.msg + "', faceCode='" + this.faceCode + "', faceMsg='" + this.faceMsg + "', willCode='" + this.willCode + "', willMsg='" + this.willMsg + "', orderNo='" + this.orderNo + "', similarity='" + this.similarity + "', liveRate='" + this.liveRate + "', retry='" + this.retry + "', riskInfo=" + ((Object) this.riskInfo) + ", sign='" + this.sign + "', isRecorded='" + this.isRecorded + "'}";
    }

    public WbFaceVerifyResult toWbFaceVerifyResult(String str) {
        WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
        wbFaceVerifyResult.setIsSuccess(true);
        wbFaceVerifyResult.setSign(this.sign);
        wbFaceVerifyResult.setRiskInfo(this.riskInfo);
        wbFaceVerifyResult.setLiveRate(this.liveRate);
        wbFaceVerifyResult.setSimilarity(this.similarity);
        wbFaceVerifyResult.setRiskInfo(this.riskInfo);
        wbFaceVerifyResult.setError(null);
        WbFaceWillModeResult wbFaceWillResult = toWbFaceWillResult();
        wbFaceWillResult.setVideoPath(str);
        wbFaceVerifyResult.setWillResult(wbFaceWillResult);
        return wbFaceVerifyResult;
    }

    public WbFaceWillModeResult toWbFaceWillModeResult() {
        WbFaceWillModeResult wbFaceWillModeResult = new WbFaceWillModeResult();
        wbFaceWillModeResult.setWillCode(this.willCode);
        wbFaceWillModeResult.setWillMsg(this.willMsg);
        wbFaceWillModeResult.setFaceCode(this.faceCode);
        wbFaceWillModeResult.setFaceMsg(this.faceMsg);
        return wbFaceWillModeResult;
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
        parcel.writeString(this.code);
        parcel.writeString(this.msg);
        parcel.writeString(this.faceCode);
        parcel.writeString(this.faceMsg);
        parcel.writeString(this.willCode);
        parcel.writeString(this.willMsg);
        parcel.writeString(this.orderNo);
        parcel.writeString(this.similarity);
        parcel.writeString(this.liveRate);
        parcel.writeString(this.retry);
        parcel.writeString(this.sign);
        parcel.writeString(this.isRecorded);
    }
}
