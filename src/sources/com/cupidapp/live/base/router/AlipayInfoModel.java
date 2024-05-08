package com.cupidapp.live.base.router;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AliypayHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AlipayInfoModel {

    @NotNull
    private final String orderId;

    @NotNull
    private final String payInfo;

    public AlipayInfoModel(@NotNull String orderId, @NotNull String payInfo) {
        s.i(orderId, "orderId");
        s.i(payInfo, "payInfo");
        this.orderId = orderId;
        this.payInfo = payInfo;
    }

    public static /* synthetic */ AlipayInfoModel copy$default(AlipayInfoModel alipayInfoModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = alipayInfoModel.orderId;
        }
        if ((i10 & 2) != 0) {
            str2 = alipayInfoModel.payInfo;
        }
        return alipayInfoModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.orderId;
    }

    @NotNull
    public final String component2() {
        return this.payInfo;
    }

    @NotNull
    public final AlipayInfoModel copy(@NotNull String orderId, @NotNull String payInfo) {
        s.i(orderId, "orderId");
        s.i(payInfo, "payInfo");
        return new AlipayInfoModel(orderId, payInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlipayInfoModel)) {
            return false;
        }
        AlipayInfoModel alipayInfoModel = (AlipayInfoModel) obj;
        return s.d(this.orderId, alipayInfoModel.orderId) && s.d(this.payInfo, alipayInfoModel.payInfo);
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final String getPayInfo() {
        return this.payInfo;
    }

    public int hashCode() {
        return (this.orderId.hashCode() * 31) + this.payInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "AlipayInfoModel(orderId=" + this.orderId + ", payInfo=" + this.payInfo + ")";
    }
}
