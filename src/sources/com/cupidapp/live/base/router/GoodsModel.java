package com.cupidapp.live.base.router;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AliypayHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GoodsModel {
    private final int allowance;
    private final int amount;

    @NotNull
    private String googlePayId;

    @NotNull
    private final String iapId;

    @NotNull
    private final String itemId;

    @NotNull
    private final String name;
    private final int price;

    public GoodsModel(@NotNull String itemId, int i10, @NotNull String iapId, int i11, @NotNull String name, int i12, @NotNull String googlePayId) {
        s.i(itemId, "itemId");
        s.i(iapId, "iapId");
        s.i(name, "name");
        s.i(googlePayId, "googlePayId");
        this.itemId = itemId;
        this.amount = i10;
        this.iapId = iapId;
        this.price = i11;
        this.name = name;
        this.allowance = i12;
        this.googlePayId = googlePayId;
    }

    public static /* synthetic */ GoodsModel copy$default(GoodsModel goodsModel, String str, int i10, String str2, int i11, String str3, int i12, String str4, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = goodsModel.itemId;
        }
        if ((i13 & 2) != 0) {
            i10 = goodsModel.amount;
        }
        int i14 = i10;
        if ((i13 & 4) != 0) {
            str2 = goodsModel.iapId;
        }
        String str5 = str2;
        if ((i13 & 8) != 0) {
            i11 = goodsModel.price;
        }
        int i15 = i11;
        if ((i13 & 16) != 0) {
            str3 = goodsModel.name;
        }
        String str6 = str3;
        if ((i13 & 32) != 0) {
            i12 = goodsModel.allowance;
        }
        int i16 = i12;
        if ((i13 & 64) != 0) {
            str4 = goodsModel.googlePayId;
        }
        return goodsModel.copy(str, i14, str5, i15, str6, i16, str4);
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    public final int component2() {
        return this.amount;
    }

    @NotNull
    public final String component3() {
        return this.iapId;
    }

    public final int component4() {
        return this.price;
    }

    @NotNull
    public final String component5() {
        return this.name;
    }

    public final int component6() {
        return this.allowance;
    }

    @NotNull
    public final String component7() {
        return this.googlePayId;
    }

    @NotNull
    public final GoodsModel copy(@NotNull String itemId, int i10, @NotNull String iapId, int i11, @NotNull String name, int i12, @NotNull String googlePayId) {
        s.i(itemId, "itemId");
        s.i(iapId, "iapId");
        s.i(name, "name");
        s.i(googlePayId, "googlePayId");
        return new GoodsModel(itemId, i10, iapId, i11, name, i12, googlePayId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsModel)) {
            return false;
        }
        GoodsModel goodsModel = (GoodsModel) obj;
        return s.d(this.itemId, goodsModel.itemId) && this.amount == goodsModel.amount && s.d(this.iapId, goodsModel.iapId) && this.price == goodsModel.price && s.d(this.name, goodsModel.name) && this.allowance == goodsModel.allowance && s.d(this.googlePayId, goodsModel.googlePayId);
    }

    public final int getAllowance() {
        return this.allowance;
    }

    public final int getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getGooglePayId() {
        return this.googlePayId;
    }

    @NotNull
    public final String getIapId() {
        return this.iapId;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getPrice() {
        return this.price;
    }

    public int hashCode() {
        return (((((((((((this.itemId.hashCode() * 31) + this.amount) * 31) + this.iapId.hashCode()) * 31) + this.price) * 31) + this.name.hashCode()) * 31) + this.allowance) * 31) + this.googlePayId.hashCode();
    }

    public final void setGooglePayId(@NotNull String str) {
        s.i(str, "<set-?>");
        this.googlePayId = str;
    }

    @NotNull
    public String toString() {
        return "GoodsModel(itemId=" + this.itemId + ", amount=" + this.amount + ", iapId=" + this.iapId + ", price=" + this.price + ", name=" + this.name + ", allowance=" + this.allowance + ", googlePayId=" + this.googlePayId + ")";
    }
}
