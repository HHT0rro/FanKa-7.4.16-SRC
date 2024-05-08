package com.cupidapp.live.visitors.model;

import com.cupidapp.live.vip.model.VasBookingType;
import java.math.BigDecimal;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsPurchasePriceModel {

    @Nullable
    private final String actCodes;
    private final int allowanceDay;

    @Nullable
    private final Integer bookingTypeId;

    @Nullable
    private final CornerMarkModel cornerMark;

    @Nullable
    private final String crossedPrice;
    private final int day;

    @Nullable
    private final String description;

    @NotNull
    private final String googlePayId;

    @NotNull
    private final String iapId;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f18960id;
    private boolean isSelected;
    private final int month;

    @Nullable
    private final String name;

    @NotNull
    private final String perMonthPrice;
    private final float price;

    @Nullable
    private final String promoCodes;

    @Nullable
    private final String skuCode;

    @NotNull
    private final String title;

    public VisitorsPurchasePriceModel(@Nullable String str, @NotNull String id2, float f10, int i10, int i11, @NotNull String iapId, @NotNull String googlePayId, int i12, @NotNull String perMonthPrice, @Nullable Integer num, @Nullable String str2, @Nullable CornerMarkModel cornerMarkModel, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z10, @NotNull String title) {
        s.i(id2, "id");
        s.i(iapId, "iapId");
        s.i(googlePayId, "googlePayId");
        s.i(perMonthPrice, "perMonthPrice");
        s.i(title, "title");
        this.name = str;
        this.f18960id = id2;
        this.price = f10;
        this.month = i10;
        this.day = i11;
        this.iapId = iapId;
        this.googlePayId = googlePayId;
        this.allowanceDay = i12;
        this.perMonthPrice = perMonthPrice;
        this.bookingTypeId = num;
        this.skuCode = str2;
        this.cornerMark = cornerMarkModel;
        this.description = str3;
        this.actCodes = str4;
        this.promoCodes = str5;
        this.crossedPrice = str6;
        this.isSelected = z10;
        this.title = title;
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final Integer component10() {
        return this.bookingTypeId;
    }

    @Nullable
    public final String component11() {
        return this.skuCode;
    }

    @Nullable
    public final CornerMarkModel component12() {
        return this.cornerMark;
    }

    @Nullable
    public final String component13() {
        return this.description;
    }

    @Nullable
    public final String component14() {
        return this.actCodes;
    }

    @Nullable
    public final String component15() {
        return this.promoCodes;
    }

    @Nullable
    public final String component16() {
        return this.crossedPrice;
    }

    public final boolean component17() {
        return this.isSelected;
    }

    @NotNull
    public final String component18() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.f18960id;
    }

    public final float component3() {
        return this.price;
    }

    public final int component4() {
        return this.month;
    }

    public final int component5() {
        return this.day;
    }

    @NotNull
    public final String component6() {
        return this.iapId;
    }

    @NotNull
    public final String component7() {
        return this.googlePayId;
    }

    public final int component8() {
        return this.allowanceDay;
    }

    @NotNull
    public final String component9() {
        return this.perMonthPrice;
    }

    @NotNull
    public final VisitorsPurchasePriceModel copy(@Nullable String str, @NotNull String id2, float f10, int i10, int i11, @NotNull String iapId, @NotNull String googlePayId, int i12, @NotNull String perMonthPrice, @Nullable Integer num, @Nullable String str2, @Nullable CornerMarkModel cornerMarkModel, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z10, @NotNull String title) {
        s.i(id2, "id");
        s.i(iapId, "iapId");
        s.i(googlePayId, "googlePayId");
        s.i(perMonthPrice, "perMonthPrice");
        s.i(title, "title");
        return new VisitorsPurchasePriceModel(str, id2, f10, i10, i11, iapId, googlePayId, i12, perMonthPrice, num, str2, cornerMarkModel, str3, str4, str5, str6, z10, title);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorsPurchasePriceModel)) {
            return false;
        }
        VisitorsPurchasePriceModel visitorsPurchasePriceModel = (VisitorsPurchasePriceModel) obj;
        return s.d(this.name, visitorsPurchasePriceModel.name) && s.d(this.f18960id, visitorsPurchasePriceModel.f18960id) && Float.compare(this.price, visitorsPurchasePriceModel.price) == 0 && this.month == visitorsPurchasePriceModel.month && this.day == visitorsPurchasePriceModel.day && s.d(this.iapId, visitorsPurchasePriceModel.iapId) && s.d(this.googlePayId, visitorsPurchasePriceModel.googlePayId) && this.allowanceDay == visitorsPurchasePriceModel.allowanceDay && s.d(this.perMonthPrice, visitorsPurchasePriceModel.perMonthPrice) && s.d(this.bookingTypeId, visitorsPurchasePriceModel.bookingTypeId) && s.d(this.skuCode, visitorsPurchasePriceModel.skuCode) && s.d(this.cornerMark, visitorsPurchasePriceModel.cornerMark) && s.d(this.description, visitorsPurchasePriceModel.description) && s.d(this.actCodes, visitorsPurchasePriceModel.actCodes) && s.d(this.promoCodes, visitorsPurchasePriceModel.promoCodes) && s.d(this.crossedPrice, visitorsPurchasePriceModel.crossedPrice) && this.isSelected == visitorsPurchasePriceModel.isSelected && s.d(this.title, visitorsPurchasePriceModel.title);
    }

    @Nullable
    public final String getActCodes() {
        return this.actCodes;
    }

    public final int getAllowanceDay() {
        return this.allowanceDay;
    }

    @Nullable
    public final Integer getBookingTypeId() {
        return this.bookingTypeId;
    }

    @Nullable
    public final CornerMarkModel getCornerMark() {
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
    public final String getDescription() {
        return this.description;
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
        return this.f18960id;
    }

    public final int getMonth() {
        return this.month;
    }

    @Nullable
    public final String getName() {
        return this.name;
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
    public final String getSkuCode() {
        return this.skuCode;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.name;
        int hashCode = (((((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.f18960id.hashCode()) * 31) + Float.floatToIntBits(this.price)) * 31) + this.month) * 31) + this.day) * 31) + this.iapId.hashCode()) * 31) + this.googlePayId.hashCode()) * 31) + this.allowanceDay) * 31) + this.perMonthPrice.hashCode()) * 31;
        Integer num = this.bookingTypeId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.skuCode;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        CornerMarkModel cornerMarkModel = this.cornerMark;
        int hashCode4 = (hashCode3 + (cornerMarkModel == null ? 0 : cornerMarkModel.hashCode())) * 31;
        String str3 = this.description;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.actCodes;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.promoCodes;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.crossedPrice;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode8 + i10) * 31) + this.title.hashCode();
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

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.f18960id;
        float f10 = this.price;
        int i10 = this.month;
        int i11 = this.day;
        String str3 = this.iapId;
        String str4 = this.googlePayId;
        int i12 = this.allowanceDay;
        String str5 = this.perMonthPrice;
        Integer num = this.bookingTypeId;
        String str6 = this.skuCode;
        CornerMarkModel cornerMarkModel = this.cornerMark;
        return "VisitorsPurchasePriceModel(name=" + str + ", id=" + str2 + ", price=" + f10 + ", month=" + i10 + ", day=" + i11 + ", iapId=" + str3 + ", googlePayId=" + str4 + ", allowanceDay=" + i12 + ", perMonthPrice=" + str5 + ", bookingTypeId=" + ((Object) num) + ", skuCode=" + str6 + ", cornerMark=" + ((Object) cornerMarkModel) + ", description=" + this.description + ", actCodes=" + this.actCodes + ", promoCodes=" + this.promoCodes + ", crossedPrice=" + this.crossedPrice + ", isSelected=" + this.isSelected + ", title=" + this.title + ")";
    }

    public /* synthetic */ VisitorsPurchasePriceModel(String str, String str2, float f10, int i10, int i11, String str3, String str4, int i12, String str5, Integer num, String str6, CornerMarkModel cornerMarkModel, String str7, String str8, String str9, String str10, boolean z10, String str11, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, f10, i10, i11, str3, str4, i12, str5, num, str6, cornerMarkModel, str7, str8, str9, str10, (i13 & 65536) != 0 ? false : z10, str11);
    }
}
