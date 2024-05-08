package com.cupidapp.live.liveshow.view.giftpicker.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DiamondResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DiamondModel {
    private final int amount;

    @NotNull
    private final String code;
    private boolean isSelect;
    private final float price;

    @NotNull
    private final String priceFormatted;

    @NotNull
    private final String title;

    public DiamondModel(@NotNull String code, @NotNull String title, @NotNull String priceFormatted, float f10, int i10, boolean z10) {
        s.i(code, "code");
        s.i(title, "title");
        s.i(priceFormatted, "priceFormatted");
        this.code = code;
        this.title = title;
        this.priceFormatted = priceFormatted;
        this.price = f10;
        this.amount = i10;
        this.isSelect = z10;
    }

    public static /* synthetic */ DiamondModel copy$default(DiamondModel diamondModel, String str, String str2, String str3, float f10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = diamondModel.code;
        }
        if ((i11 & 2) != 0) {
            str2 = diamondModel.title;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = diamondModel.priceFormatted;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            f10 = diamondModel.price;
        }
        float f11 = f10;
        if ((i11 & 16) != 0) {
            i10 = diamondModel.amount;
        }
        int i12 = i10;
        if ((i11 & 32) != 0) {
            z10 = diamondModel.isSelect;
        }
        return diamondModel.copy(str, str4, str5, f11, i12, z10);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.priceFormatted;
    }

    public final float component4() {
        return this.price;
    }

    public final int component5() {
        return this.amount;
    }

    public final boolean component6() {
        return this.isSelect;
    }

    @NotNull
    public final DiamondModel copy(@NotNull String code, @NotNull String title, @NotNull String priceFormatted, float f10, int i10, boolean z10) {
        s.i(code, "code");
        s.i(title, "title");
        s.i(priceFormatted, "priceFormatted");
        return new DiamondModel(code, title, priceFormatted, f10, i10, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiamondModel)) {
            return false;
        }
        DiamondModel diamondModel = (DiamondModel) obj;
        return s.d(this.code, diamondModel.code) && s.d(this.title, diamondModel.title) && s.d(this.priceFormatted, diamondModel.priceFormatted) && Float.compare(this.price, diamondModel.price) == 0 && this.amount == diamondModel.amount && this.isSelect == diamondModel.isSelect;
    }

    public final int getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final float getPrice() {
        return this.price;
    }

    @NotNull
    public final String getPriceFormatted() {
        return this.priceFormatted;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.code.hashCode() * 31) + this.title.hashCode()) * 31) + this.priceFormatted.hashCode()) * 31) + Float.floatToIntBits(this.price)) * 31) + this.amount) * 31;
        boolean z10 = this.isSelect;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z10) {
        this.isSelect = z10;
    }

    @NotNull
    public String toString() {
        return "DiamondModel(code=" + this.code + ", title=" + this.title + ", priceFormatted=" + this.priceFormatted + ", price=" + this.price + ", amount=" + this.amount + ", isSelect=" + this.isSelect + ")";
    }
}
