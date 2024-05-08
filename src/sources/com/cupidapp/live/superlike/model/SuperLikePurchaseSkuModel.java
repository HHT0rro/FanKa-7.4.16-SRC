package com.cupidapp.live.superlike.model;

import com.cupidapp.live.vip.model.VipPurchaseActivityModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperLikePurchaseSkuModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikePurchaseSkuModel implements Serializable {

    @Nullable
    private final String actCodes;

    @Nullable
    private final String category;
    private boolean checked;

    @Nullable
    private final String code;

    @Nullable
    private final VipPurchaseActivityModel cornerMark;

    @Nullable
    private final String description;

    @Nullable
    private final String itemId;

    @Nullable
    private final Float originPrice;

    @Nullable
    private final String originPriceFormatted;

    @NotNull
    private final String priceFormatted;

    @Nullable
    private final String promoCodes;

    @NotNull
    private final String title;

    @NotNull
    private final String unitPriceFormatted;

    public SuperLikePurchaseSkuModel(@Nullable String str, @NotNull String title, @Nullable String str2, @Nullable String str3, @Nullable Float f10, @Nullable String str4, @NotNull String priceFormatted, @NotNull String unitPriceFormatted, @Nullable String str5, @Nullable VipPurchaseActivityModel vipPurchaseActivityModel, @Nullable String str6, @Nullable String str7, boolean z10) {
        s.i(title, "title");
        s.i(priceFormatted, "priceFormatted");
        s.i(unitPriceFormatted, "unitPriceFormatted");
        this.itemId = str;
        this.title = title;
        this.category = str2;
        this.code = str3;
        this.originPrice = f10;
        this.originPriceFormatted = str4;
        this.priceFormatted = priceFormatted;
        this.unitPriceFormatted = unitPriceFormatted;
        this.description = str5;
        this.cornerMark = vipPurchaseActivityModel;
        this.actCodes = str6;
        this.promoCodes = str7;
        this.checked = z10;
    }

    @Nullable
    public final String component1() {
        return this.itemId;
    }

    @Nullable
    public final VipPurchaseActivityModel component10() {
        return this.cornerMark;
    }

    @Nullable
    public final String component11() {
        return this.actCodes;
    }

    @Nullable
    public final String component12() {
        return this.promoCodes;
    }

    public final boolean component13() {
        return this.checked;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.category;
    }

    @Nullable
    public final String component4() {
        return this.code;
    }

    @Nullable
    public final Float component5() {
        return this.originPrice;
    }

    @Nullable
    public final String component6() {
        return this.originPriceFormatted;
    }

    @NotNull
    public final String component7() {
        return this.priceFormatted;
    }

    @NotNull
    public final String component8() {
        return this.unitPriceFormatted;
    }

    @Nullable
    public final String component9() {
        return this.description;
    }

    @NotNull
    public final SuperLikePurchaseSkuModel copy(@Nullable String str, @NotNull String title, @Nullable String str2, @Nullable String str3, @Nullable Float f10, @Nullable String str4, @NotNull String priceFormatted, @NotNull String unitPriceFormatted, @Nullable String str5, @Nullable VipPurchaseActivityModel vipPurchaseActivityModel, @Nullable String str6, @Nullable String str7, boolean z10) {
        s.i(title, "title");
        s.i(priceFormatted, "priceFormatted");
        s.i(unitPriceFormatted, "unitPriceFormatted");
        return new SuperLikePurchaseSkuModel(str, title, str2, str3, f10, str4, priceFormatted, unitPriceFormatted, str5, vipPurchaseActivityModel, str6, str7, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperLikePurchaseSkuModel)) {
            return false;
        }
        SuperLikePurchaseSkuModel superLikePurchaseSkuModel = (SuperLikePurchaseSkuModel) obj;
        return s.d(this.itemId, superLikePurchaseSkuModel.itemId) && s.d(this.title, superLikePurchaseSkuModel.title) && s.d(this.category, superLikePurchaseSkuModel.category) && s.d(this.code, superLikePurchaseSkuModel.code) && s.d(this.originPrice, superLikePurchaseSkuModel.originPrice) && s.d(this.originPriceFormatted, superLikePurchaseSkuModel.originPriceFormatted) && s.d(this.priceFormatted, superLikePurchaseSkuModel.priceFormatted) && s.d(this.unitPriceFormatted, superLikePurchaseSkuModel.unitPriceFormatted) && s.d(this.description, superLikePurchaseSkuModel.description) && s.d(this.cornerMark, superLikePurchaseSkuModel.cornerMark) && s.d(this.actCodes, superLikePurchaseSkuModel.actCodes) && s.d(this.promoCodes, superLikePurchaseSkuModel.promoCodes) && this.checked == superLikePurchaseSkuModel.checked;
    }

    @Nullable
    public final String getActCodes() {
        return this.actCodes;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final VipPurchaseActivityModel getCornerMark() {
        return this.cornerMark;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final Float getOriginPrice() {
        return this.originPrice;
    }

    @Nullable
    public final String getOriginPriceFormatted() {
        return this.originPriceFormatted;
    }

    @NotNull
    public final String getPriceFormatted() {
        return this.priceFormatted;
    }

    @Nullable
    public final String getPromoCodes() {
        return this.promoCodes;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUnitPriceFormatted() {
        return this.unitPriceFormatted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.itemId;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str2 = this.category;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.code;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f10 = this.originPrice;
        int hashCode4 = (hashCode3 + (f10 == null ? 0 : f10.hashCode())) * 31;
        String str4 = this.originPriceFormatted;
        int hashCode5 = (((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.priceFormatted.hashCode()) * 31) + this.unitPriceFormatted.hashCode()) * 31;
        String str5 = this.description;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        VipPurchaseActivityModel vipPurchaseActivityModel = this.cornerMark;
        int hashCode7 = (hashCode6 + (vipPurchaseActivityModel == null ? 0 : vipPurchaseActivityModel.hashCode())) * 31;
        String str6 = this.actCodes;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.promoCodes;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z10 = this.checked;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode9 + i10;
    }

    public final void setChecked(boolean z10) {
        this.checked = z10;
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        String str2 = this.title;
        String str3 = this.category;
        String str4 = this.code;
        Float f10 = this.originPrice;
        String str5 = this.originPriceFormatted;
        String str6 = this.priceFormatted;
        String str7 = this.unitPriceFormatted;
        String str8 = this.description;
        VipPurchaseActivityModel vipPurchaseActivityModel = this.cornerMark;
        return "SuperLikePurchaseSkuModel(itemId=" + str + ", title=" + str2 + ", category=" + str3 + ", code=" + str4 + ", originPrice=" + ((Object) f10) + ", originPriceFormatted=" + str5 + ", priceFormatted=" + str6 + ", unitPriceFormatted=" + str7 + ", description=" + str8 + ", cornerMark=" + ((Object) vipPurchaseActivityModel) + ", actCodes=" + this.actCodes + ", promoCodes=" + this.promoCodes + ", checked=" + this.checked + ")";
    }

    public /* synthetic */ SuperLikePurchaseSkuModel(String str, String str2, String str3, String str4, Float f10, String str5, String str6, String str7, String str8, VipPurchaseActivityModel vipPurchaseActivityModel, String str9, String str10, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, f10, str5, str6, str7, str8, vipPurchaseActivityModel, str9, str10, (i10 & 4096) != 0 ? false : z10);
    }
}
