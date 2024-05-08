package com.cupidapp.live.base.web.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FaceCallbackModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FaceInfoModel {

    @NotNull
    private final String appId;

    @NotNull
    private final String faceId;

    @NotNull
    private final String keyLicence;

    @NotNull
    private final String nonce;

    @NotNull
    private final String orderNo;

    @NotNull
    private final String sign;

    public FaceInfoModel(@NotNull String appId, @NotNull String faceId, @NotNull String keyLicence, @NotNull String nonce, @NotNull String orderNo, @NotNull String sign) {
        s.i(appId, "appId");
        s.i(faceId, "faceId");
        s.i(keyLicence, "keyLicence");
        s.i(nonce, "nonce");
        s.i(orderNo, "orderNo");
        s.i(sign, "sign");
        this.appId = appId;
        this.faceId = faceId;
        this.keyLicence = keyLicence;
        this.nonce = nonce;
        this.orderNo = orderNo;
        this.sign = sign;
    }

    public static /* synthetic */ FaceInfoModel copy$default(FaceInfoModel faceInfoModel, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = faceInfoModel.appId;
        }
        if ((i10 & 2) != 0) {
            str2 = faceInfoModel.faceId;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = faceInfoModel.keyLicence;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = faceInfoModel.nonce;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = faceInfoModel.orderNo;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = faceInfoModel.sign;
        }
        return faceInfoModel.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.appId;
    }

    @NotNull
    public final String component2() {
        return this.faceId;
    }

    @NotNull
    public final String component3() {
        return this.keyLicence;
    }

    @NotNull
    public final String component4() {
        return this.nonce;
    }

    @NotNull
    public final String component5() {
        return this.orderNo;
    }

    @NotNull
    public final String component6() {
        return this.sign;
    }

    @NotNull
    public final FaceInfoModel copy(@NotNull String appId, @NotNull String faceId, @NotNull String keyLicence, @NotNull String nonce, @NotNull String orderNo, @NotNull String sign) {
        s.i(appId, "appId");
        s.i(faceId, "faceId");
        s.i(keyLicence, "keyLicence");
        s.i(nonce, "nonce");
        s.i(orderNo, "orderNo");
        s.i(sign, "sign");
        return new FaceInfoModel(appId, faceId, keyLicence, nonce, orderNo, sign);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FaceInfoModel)) {
            return false;
        }
        FaceInfoModel faceInfoModel = (FaceInfoModel) obj;
        return s.d(this.appId, faceInfoModel.appId) && s.d(this.faceId, faceInfoModel.faceId) && s.d(this.keyLicence, faceInfoModel.keyLicence) && s.d(this.nonce, faceInfoModel.nonce) && s.d(this.orderNo, faceInfoModel.orderNo) && s.d(this.sign, faceInfoModel.sign);
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getFaceId() {
        return this.faceId;
    }

    @NotNull
    public final String getKeyLicence() {
        return this.keyLicence;
    }

    @NotNull
    public final String getNonce() {
        return this.nonce;
    }

    @NotNull
    public final String getOrderNo() {
        return this.orderNo;
    }

    @NotNull
    public final String getSign() {
        return this.sign;
    }

    public int hashCode() {
        return (((((((((this.appId.hashCode() * 31) + this.faceId.hashCode()) * 31) + this.keyLicence.hashCode()) * 31) + this.nonce.hashCode()) * 31) + this.orderNo.hashCode()) * 31) + this.sign.hashCode();
    }

    @NotNull
    public String toString() {
        return "FaceInfoModel(appId=" + this.appId + ", faceId=" + this.faceId + ", keyLicence=" + this.keyLicence + ", nonce=" + this.nonce + ", orderNo=" + this.orderNo + ", sign=" + this.sign + ")";
    }
}
