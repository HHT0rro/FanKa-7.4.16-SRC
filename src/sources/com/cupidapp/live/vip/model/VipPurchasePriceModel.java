package com.cupidapp.live.vip.model;

import android.text.TextUtils;
import java.math.BigDecimal;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchasePriceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchasePriceModel {

    @Nullable
    private final String actCodes;
    private final int allowanceDay;

    @Nullable
    private Integer animationType;

    @Nullable
    private final Integer bookingTypeId;

    @Nullable
    private final VipPurchaseActivityModel cornerMark;

    @Nullable
    private final String crossedPrice;
    private final int day;

    @Nullable
    private final String depPrice;

    @Nullable
    private final String description;

    @Nullable
    private final String detailInfo;

    @NotNull
    private final String googlePayId;

    @NotNull
    private final String iapId;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f18813id;
    private boolean isSelected;
    private final int month;

    @Nullable
    private final String name;

    @Nullable
    private final Integer originPriceInCent;

    @Nullable
    private final String paymentButtonTag;

    @NotNull
    private final String perMonthPrice;
    private final float price;

    @Nullable
    private final String promoCodes;

    @Nullable
    private final String reduction;

    @Nullable
    private final String skuCode;

    @NotNull
    private final String title;

    @NotNull
    private VipType vipType;

    public VipPurchasePriceModel(@NotNull String title, @NotNull String id2, float f10, @Nullable Integer num, int i10, int i11, @NotNull String iapId, @NotNull String googlePayId, int i12, @NotNull String perMonthPrice, @Nullable Integer num2, @Nullable String str, @Nullable VipPurchaseActivityModel vipPurchaseActivityModel, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z10, @Nullable String str6, @Nullable String str7, @Nullable String str8, @NotNull VipType vipType, @Nullable String str9, @Nullable String str10, @Nullable Integer num3) {
        s.i(title, "title");
        s.i(id2, "id");
        s.i(iapId, "iapId");
        s.i(googlePayId, "googlePayId");
        s.i(perMonthPrice, "perMonthPrice");
        s.i(vipType, "vipType");
        this.title = title;
        this.f18813id = id2;
        this.price = f10;
        this.originPriceInCent = num;
        this.month = i10;
        this.day = i11;
        this.iapId = iapId;
        this.googlePayId = googlePayId;
        this.allowanceDay = i12;
        this.perMonthPrice = perMonthPrice;
        this.bookingTypeId = num2;
        this.skuCode = str;
        this.cornerMark = vipPurchaseActivityModel;
        this.description = str2;
        this.actCodes = str3;
        this.promoCodes = str4;
        this.crossedPrice = str5;
        this.isSelected = z10;
        this.reduction = str6;
        this.depPrice = str7;
        this.name = str8;
        this.vipType = vipType;
        this.detailInfo = str9;
        this.paymentButtonTag = str10;
        this.animationType = num3;
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component10() {
        return this.perMonthPrice;
    }

    @Nullable
    public final Integer component11() {
        return this.bookingTypeId;
    }

    @Nullable
    public final String component12() {
        return this.skuCode;
    }

    @Nullable
    public final VipPurchaseActivityModel component13() {
        return this.cornerMark;
    }

    @Nullable
    public final String component14() {
        return this.description;
    }

    @Nullable
    public final String component15() {
        return this.actCodes;
    }

    @Nullable
    public final String component16() {
        return this.promoCodes;
    }

    @Nullable
    public final String component17() {
        return this.crossedPrice;
    }

    public final boolean component18() {
        return this.isSelected;
    }

    @Nullable
    public final String component19() {
        return this.reduction;
    }

    @NotNull
    public final String component2() {
        return this.f18813id;
    }

    @Nullable
    public final String component20() {
        return this.depPrice;
    }

    @Nullable
    public final String component21() {
        return this.name;
    }

    @NotNull
    public final VipType component22() {
        return this.vipType;
    }

    @Nullable
    public final String component23() {
        return this.detailInfo;
    }

    @Nullable
    public final String component24() {
        return this.paymentButtonTag;
    }

    @Nullable
    public final Integer component25() {
        return this.animationType;
    }

    public final float component3() {
        return this.price;
    }

    @Nullable
    public final Integer component4() {
        return this.originPriceInCent;
    }

    public final int component5() {
        return this.month;
    }

    public final int component6() {
        return this.day;
    }

    @NotNull
    public final String component7() {
        return this.iapId;
    }

    @NotNull
    public final String component8() {
        return this.googlePayId;
    }

    public final int component9() {
        return this.allowanceDay;
    }

    @NotNull
    public final VipPurchasePriceModel copy(@NotNull String title, @NotNull String id2, float f10, @Nullable Integer num, int i10, int i11, @NotNull String iapId, @NotNull String googlePayId, int i12, @NotNull String perMonthPrice, @Nullable Integer num2, @Nullable String str, @Nullable VipPurchaseActivityModel vipPurchaseActivityModel, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z10, @Nullable String str6, @Nullable String str7, @Nullable String str8, @NotNull VipType vipType, @Nullable String str9, @Nullable String str10, @Nullable Integer num3) {
        s.i(title, "title");
        s.i(id2, "id");
        s.i(iapId, "iapId");
        s.i(googlePayId, "googlePayId");
        s.i(perMonthPrice, "perMonthPrice");
        s.i(vipType, "vipType");
        return new VipPurchasePriceModel(title, id2, f10, num, i10, i11, iapId, googlePayId, i12, perMonthPrice, num2, str, vipPurchaseActivityModel, str2, str3, str4, str5, z10, str6, str7, str8, vipType, str9, str10, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipPurchasePriceModel)) {
            return false;
        }
        VipPurchasePriceModel vipPurchasePriceModel = (VipPurchasePriceModel) obj;
        return s.d(this.title, vipPurchasePriceModel.title) && s.d(this.f18813id, vipPurchasePriceModel.f18813id) && Float.compare(this.price, vipPurchasePriceModel.price) == 0 && s.d(this.originPriceInCent, vipPurchasePriceModel.originPriceInCent) && this.month == vipPurchasePriceModel.month && this.day == vipPurchasePriceModel.day && s.d(this.iapId, vipPurchasePriceModel.iapId) && s.d(this.googlePayId, vipPurchasePriceModel.googlePayId) && this.allowanceDay == vipPurchasePriceModel.allowanceDay && s.d(this.perMonthPrice, vipPurchasePriceModel.perMonthPrice) && s.d(this.bookingTypeId, vipPurchasePriceModel.bookingTypeId) && s.d(this.skuCode, vipPurchasePriceModel.skuCode) && s.d(this.cornerMark, vipPurchasePriceModel.cornerMark) && s.d(this.description, vipPurchasePriceModel.description) && s.d(this.actCodes, vipPurchasePriceModel.actCodes) && s.d(this.promoCodes, vipPurchasePriceModel.promoCodes) && s.d(this.crossedPrice, vipPurchasePriceModel.crossedPrice) && this.isSelected == vipPurchasePriceModel.isSelected && s.d(this.reduction, vipPurchasePriceModel.reduction) && s.d(this.depPrice, vipPurchasePriceModel.depPrice) && s.d(this.name, vipPurchasePriceModel.name) && this.vipType == vipPurchasePriceModel.vipType && s.d(this.detailInfo, vipPurchasePriceModel.detailInfo) && s.d(this.paymentButtonTag, vipPurchasePriceModel.paymentButtonTag) && s.d(this.animationType, vipPurchasePriceModel.animationType);
    }

    @Nullable
    public final String getActCodes() {
        return this.actCodes;
    }

    public final int getAllowanceDay() {
        return this.allowanceDay;
    }

    @Nullable
    public final Integer getAnimationType() {
        return this.animationType;
    }

    @Nullable
    public final Integer getBookingTypeId() {
        return this.bookingTypeId;
    }

    @Nullable
    public final VipPurchaseActivityModel getCornerMark() {
        return this.cornerMark;
    }

    @Nullable
    public final String getCrossedPrice() {
        return this.crossedPrice;
    }

    public final int getDay() {
        return this.day;
    }

    @Nullable
    public final String getDepPrice() {
        return this.depPrice;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDetailInfo() {
        return this.detailInfo;
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
    public final String getId() {
        return this.f18813id;
    }

    public final int getMonth() {
        return this.month;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer getOriginPriceInCent() {
        return this.originPriceInCent;
    }

    @Nullable
    public final String getPaymentButtonTag() {
        return this.paymentButtonTag;
    }

    @NotNull
    public final String getPerMonthPrice() {
        return this.perMonthPrice;
    }

    public final float getPrice() {
        return this.price;
    }

    @Nullable
    public final String getPromoCodes() {
        return this.promoCodes;
    }

    @Nullable
    public final String getReduction() {
        return this.reduction;
    }

    @Nullable
    public final String getSkuCode() {
        return this.skuCode;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final VipType getVipType() {
        return this.vipType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.f18813id.hashCode()) * 31) + Float.floatToIntBits(this.price)) * 31;
        Integer num = this.originPriceInCent;
        int hashCode2 = (((((((((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.month) * 31) + this.day) * 31) + this.iapId.hashCode()) * 31) + this.googlePayId.hashCode()) * 31) + this.allowanceDay) * 31) + this.perMonthPrice.hashCode()) * 31;
        Integer num2 = this.bookingTypeId;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.skuCode;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        VipPurchaseActivityModel vipPurchaseActivityModel = this.cornerMark;
        int hashCode5 = (hashCode4 + (vipPurchaseActivityModel == null ? 0 : vipPurchaseActivityModel.hashCode())) * 31;
        String str2 = this.description;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.actCodes;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.promoCodes;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.crossedPrice;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode9 + i10) * 31;
        String str6 = this.reduction;
        int hashCode10 = (i11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.depPrice;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.name;
        int hashCode12 = (((hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31) + this.vipType.hashCode()) * 31;
        String str9 = this.detailInfo;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.paymentButtonTag;
        int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num3 = this.animationType;
        return hashCode14 + (num3 != null ? num3.hashCode() : 0);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isSubscribeBookingType() {
        Integer num = this.bookingTypeId;
        return num != null && num.intValue() == VasBookingType.SUBSCRIBE.getValue();
    }

    @NotNull
    public final String price() {
        String plainString = new BigDecimal(String.valueOf(this.price)).stripTrailingZeros().toPlainString();
        s.h(plainString, "BigDecimal(price.toStrin…ngZeros().toPlainString()");
        return plainString;
    }

    @NotNull
    public final String promotionPrice() {
        String str;
        if (TextUtils.isEmpty(this.depPrice)) {
            str = String.valueOf(this.price);
        } else {
            str = this.depPrice;
        }
        String plainString = new BigDecimal(str).stripTrailingZeros().toPlainString();
        s.h(plainString, "BigDecimal(temp).stripTr…ngZeros().toPlainString()");
        return plainString;
    }

    @NotNull
    public final String reduce() {
        if (TextUtils.isEmpty(this.reduction)) {
            return "50";
        }
        String str = this.reduction;
        s.f(str);
        return str.toString();
    }

    public final void setAnimationType(@Nullable Integer num) {
        this.animationType = num;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public final void setVipType(@NotNull VipType vipType) {
        s.i(vipType, "<set-?>");
        this.vipType = vipType;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.f18813id;
        float f10 = this.price;
        Integer num = this.originPriceInCent;
        int i10 = this.month;
        int i11 = this.day;
        String str3 = this.iapId;
        String str4 = this.googlePayId;
        int i12 = this.allowanceDay;
        String str5 = this.perMonthPrice;
        Integer num2 = this.bookingTypeId;
        String str6 = this.skuCode;
        VipPurchaseActivityModel vipPurchaseActivityModel = this.cornerMark;
        String str7 = this.description;
        String str8 = this.actCodes;
        String str9 = this.promoCodes;
        String str10 = this.crossedPrice;
        boolean z10 = this.isSelected;
        String str11 = this.reduction;
        String str12 = this.depPrice;
        String str13 = this.name;
        VipType vipType = this.vipType;
        return "VipPurchasePriceModel(title=" + str + ", id=" + str2 + ", price=" + f10 + ", originPriceInCent=" + ((Object) num) + ", month=" + i10 + ", day=" + i11 + ", iapId=" + str3 + ", googlePayId=" + str4 + ", allowanceDay=" + i12 + ", perMonthPrice=" + str5 + ", bookingTypeId=" + ((Object) num2) + ", skuCode=" + str6 + ", cornerMark=" + ((Object) vipPurchaseActivityModel) + ", description=" + str7 + ", actCodes=" + str8 + ", promoCodes=" + str9 + ", crossedPrice=" + str10 + ", isSelected=" + z10 + ", reduction=" + str11 + ", depPrice=" + str12 + ", name=" + str13 + ", vipType=" + ((Object) vipType) + ", detailInfo=" + this.detailInfo + ", paymentButtonTag=" + this.paymentButtonTag + ", animationType=" + ((Object) this.animationType) + ")";
    }

    public /* synthetic */ VipPurchasePriceModel(String str, String str2, float f10, Integer num, int i10, int i11, String str3, String str4, int i12, String str5, Integer num2, String str6, VipPurchaseActivityModel vipPurchaseActivityModel, String str7, String str8, String str9, String str10, boolean z10, String str11, String str12, String str13, VipType vipType, String str14, String str15, Integer num3, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, f10, num, i10, i11, str3, str4, i12, str5, num2, str6, vipPurchaseActivityModel, str7, str8, str9, str10, (i13 & 131072) != 0 ? false : z10, (i13 & 262144) != 0 ? "50" : str11, str12, str13, (i13 & 2097152) != 0 ? VipType.SUPER : vipType, str14, (i13 & 8388608) != 0 ? null : str15, num3);
    }
}
