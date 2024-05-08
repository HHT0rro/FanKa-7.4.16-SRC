package com.cupidapp.live.vip.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CreateOrderModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PayInfoModel {

    @Nullable
    private final String appId;

    @Nullable
    private final String nonceStr;

    @Nullable
    private final String orderId;

    @Nullable
    private final String partnerId;

    @Nullable
    private final String payInfo;

    @Nullable
    private final String paymentType;

    @Nullable
    private final String prepayId;

    @Nullable
    private final String sign;

    @Nullable
    private final String timestamp;

    public PayInfoModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        this.paymentType = str;
        this.orderId = str2;
        this.payInfo = str3;
        this.appId = str4;
        this.sign = str5;
        this.prepayId = str6;
        this.partnerId = str7;
        this.nonceStr = str8;
        this.timestamp = str9;
    }

    @Nullable
    public final String component1() {
        return this.paymentType;
    }

    @Nullable
    public final String component2() {
        return this.orderId;
    }

    @Nullable
    public final String component3() {
        return this.payInfo;
    }

    @Nullable
    public final String component4() {
        return this.appId;
    }

    @Nullable
    public final String component5() {
        return this.sign;
    }

    @Nullable
    public final String component6() {
        return this.prepayId;
    }

    @Nullable
    public final String component7() {
        return this.partnerId;
    }

    @Nullable
    public final String component8() {
        return this.nonceStr;
    }

    @Nullable
    public final String component9() {
        return this.timestamp;
    }

    @NotNull
    public final PayInfoModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        return new PayInfoModel(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayInfoModel)) {
            return false;
        }
        PayInfoModel payInfoModel = (PayInfoModel) obj;
        return s.d(this.paymentType, payInfoModel.paymentType) && s.d(this.orderId, payInfoModel.orderId) && s.d(this.payInfo, payInfoModel.payInfo) && s.d(this.appId, payInfoModel.appId) && s.d(this.sign, payInfoModel.sign) && s.d(this.prepayId, payInfoModel.prepayId) && s.d(this.partnerId, payInfoModel.partnerId) && s.d(this.nonceStr, payInfoModel.nonceStr) && s.d(this.timestamp, payInfoModel.timestamp);
    }

    @Nullable
    public final String getAppId() {
        return this.appId;
    }

    @Nullable
    public final String getNonceStr() {
        return this.nonceStr;
    }

    @Nullable
    public final String getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final String getPartnerId() {
        return this.partnerId;
    }

    @Nullable
    public final String getPayInfo() {
        return this.payInfo;
    }

    @Nullable
    public final String getPaymentType() {
        return this.paymentType;
    }

    @Nullable
    public final String getPrepayId() {
        return this.prepayId;
    }

    @Nullable
    public final String getSign() {
        return this.sign;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.paymentType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.orderId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.payInfo;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.appId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sign;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.prepayId;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.partnerId;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.nonceStr;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.timestamp;
        return hashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PayInfoModel(paymentType=" + this.paymentType + ", orderId=" + this.orderId + ", payInfo=" + this.payInfo + ", appId=" + this.appId + ", sign=" + this.sign + ", prepayId=" + this.prepayId + ", partnerId=" + this.partnerId + ", nonceStr=" + this.nonceStr + ", timestamp=" + this.timestamp + ")";
    }
}
