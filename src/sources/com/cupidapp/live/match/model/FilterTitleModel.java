package com.cupidapp.live.match.model;

import com.cupidapp.live.vip.model.VipDiscountDescriptionResult;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FilterTitleModel {

    @Nullable
    private final String des;
    private final int productType;

    @Nullable
    private final VipDiscountDescriptionResult sVipDiscount;
    private final boolean showGap;

    @NotNull
    private final String title;

    public FilterTitleModel(@NotNull String title, @Nullable String str, boolean z10, int i10, @Nullable VipDiscountDescriptionResult vipDiscountDescriptionResult) {
        s.i(title, "title");
        this.title = title;
        this.des = str;
        this.showGap = z10;
        this.productType = i10;
        this.sVipDiscount = vipDiscountDescriptionResult;
    }

    public static /* synthetic */ FilterTitleModel copy$default(FilterTitleModel filterTitleModel, String str, String str2, boolean z10, int i10, VipDiscountDescriptionResult vipDiscountDescriptionResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = filterTitleModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = filterTitleModel.des;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            z10 = filterTitleModel.showGap;
        }
        boolean z11 = z10;
        if ((i11 & 8) != 0) {
            i10 = filterTitleModel.productType;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            vipDiscountDescriptionResult = filterTitleModel.sVipDiscount;
        }
        return filterTitleModel.copy(str, str3, z11, i12, vipDiscountDescriptionResult);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.des;
    }

    public final boolean component3() {
        return this.showGap;
    }

    public final int component4() {
        return this.productType;
    }

    @Nullable
    public final VipDiscountDescriptionResult component5() {
        return this.sVipDiscount;
    }

    @NotNull
    public final FilterTitleModel copy(@NotNull String title, @Nullable String str, boolean z10, int i10, @Nullable VipDiscountDescriptionResult vipDiscountDescriptionResult) {
        s.i(title, "title");
        return new FilterTitleModel(title, str, z10, i10, vipDiscountDescriptionResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterTitleModel)) {
            return false;
        }
        FilterTitleModel filterTitleModel = (FilterTitleModel) obj;
        return s.d(this.title, filterTitleModel.title) && s.d(this.des, filterTitleModel.des) && this.showGap == filterTitleModel.showGap && this.productType == filterTitleModel.productType && s.d(this.sVipDiscount, filterTitleModel.sVipDiscount);
    }

    @Nullable
    public final String getDes() {
        return this.des;
    }

    public final int getProductType() {
        return this.productType;
    }

    @Nullable
    public final VipDiscountDescriptionResult getSVipDiscount() {
        return this.sVipDiscount;
    }

    public final boolean getShowGap() {
        return this.showGap;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        String str = this.des;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.showGap;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (((hashCode2 + i10) * 31) + this.productType) * 31;
        VipDiscountDescriptionResult vipDiscountDescriptionResult = this.sVipDiscount;
        return i11 + (vipDiscountDescriptionResult != null ? vipDiscountDescriptionResult.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FilterTitleModel(title=" + this.title + ", des=" + this.des + ", showGap=" + this.showGap + ", productType=" + this.productType + ", sVipDiscount=" + ((Object) this.sVipDiscount) + ")";
    }

    public /* synthetic */ FilterTitleModel(String str, String str2, boolean z10, int i10, VipDiscountDescriptionResult vipDiscountDescriptionResult, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z10, i10, (i11 & 16) != 0 ? null : vipDiscountDescriptionResult);
    }
}
