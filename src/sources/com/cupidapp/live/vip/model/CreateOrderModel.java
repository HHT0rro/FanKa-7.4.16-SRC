package com.cupidapp.live.vip.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CreateOrderModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CreateOrderModel {

    @Nullable
    private final String callback;

    @Nullable
    private final PayInfoModel payInfo;

    public CreateOrderModel(@Nullable PayInfoModel payInfoModel, @Nullable String str) {
        this.payInfo = payInfoModel;
        this.callback = str;
    }

    public static /* synthetic */ CreateOrderModel copy$default(CreateOrderModel createOrderModel, PayInfoModel payInfoModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            payInfoModel = createOrderModel.payInfo;
        }
        if ((i10 & 2) != 0) {
            str = createOrderModel.callback;
        }
        return createOrderModel.copy(payInfoModel, str);
    }

    @Nullable
    public final PayInfoModel component1() {
        return this.payInfo;
    }

    @Nullable
    public final String component2() {
        return this.callback;
    }

    @NotNull
    public final CreateOrderModel copy(@Nullable PayInfoModel payInfoModel, @Nullable String str) {
        return new CreateOrderModel(payInfoModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateOrderModel)) {
            return false;
        }
        CreateOrderModel createOrderModel = (CreateOrderModel) obj;
        return s.d(this.payInfo, createOrderModel.payInfo) && s.d(this.callback, createOrderModel.callback);
    }

    @Nullable
    public final String getCallback() {
        return this.callback;
    }

    @Nullable
    public final PayInfoModel getPayInfo() {
        return this.payInfo;
    }

    public int hashCode() {
        PayInfoModel payInfoModel = this.payInfo;
        int hashCode = (payInfoModel == null ? 0 : payInfoModel.hashCode()) * 31;
        String str = this.callback;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        PayInfoModel payInfoModel = this.payInfo;
        return "CreateOrderModel(payInfo=" + ((Object) payInfoModel) + ", callback=" + this.callback + ")";
    }
}
