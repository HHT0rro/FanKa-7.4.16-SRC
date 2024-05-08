package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RangeMatchFilterViewModel {

    @NotNull
    private final MatchFilterModel matchFilterModel;
    private int max;
    private int min;

    @NotNull
    private final PurchaseProductType productType;
    private final boolean searchHasMax;
    private final boolean searchHasMin;

    public RangeMatchFilterViewModel(@NotNull MatchFilterModel matchFilterModel, int i10, int i11, boolean z10, boolean z11, @NotNull PurchaseProductType productType) {
        s.i(matchFilterModel, "matchFilterModel");
        s.i(productType, "productType");
        this.matchFilterModel = matchFilterModel;
        this.min = i10;
        this.max = i11;
        this.searchHasMax = z10;
        this.searchHasMin = z11;
        this.productType = productType;
    }

    public static /* synthetic */ RangeMatchFilterViewModel copy$default(RangeMatchFilterViewModel rangeMatchFilterViewModel, MatchFilterModel matchFilterModel, int i10, int i11, boolean z10, boolean z11, PurchaseProductType purchaseProductType, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            matchFilterModel = rangeMatchFilterViewModel.matchFilterModel;
        }
        if ((i12 & 2) != 0) {
            i10 = rangeMatchFilterViewModel.min;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            i11 = rangeMatchFilterViewModel.max;
        }
        int i14 = i11;
        if ((i12 & 8) != 0) {
            z10 = rangeMatchFilterViewModel.searchHasMax;
        }
        boolean z12 = z10;
        if ((i12 & 16) != 0) {
            z11 = rangeMatchFilterViewModel.searchHasMin;
        }
        boolean z13 = z11;
        if ((i12 & 32) != 0) {
            purchaseProductType = rangeMatchFilterViewModel.productType;
        }
        return rangeMatchFilterViewModel.copy(matchFilterModel, i13, i14, z12, z13, purchaseProductType);
    }

    @NotNull
    public final MatchFilterModel component1() {
        return this.matchFilterModel;
    }

    public final int component2() {
        return this.min;
    }

    public final int component3() {
        return this.max;
    }

    public final boolean component4() {
        return this.searchHasMax;
    }

    public final boolean component5() {
        return this.searchHasMin;
    }

    @NotNull
    public final PurchaseProductType component6() {
        return this.productType;
    }

    @NotNull
    public final RangeMatchFilterViewModel copy(@NotNull MatchFilterModel matchFilterModel, int i10, int i11, boolean z10, boolean z11, @NotNull PurchaseProductType productType) {
        s.i(matchFilterModel, "matchFilterModel");
        s.i(productType, "productType");
        return new RangeMatchFilterViewModel(matchFilterModel, i10, i11, z10, z11, productType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RangeMatchFilterViewModel)) {
            return false;
        }
        RangeMatchFilterViewModel rangeMatchFilterViewModel = (RangeMatchFilterViewModel) obj;
        return s.d(this.matchFilterModel, rangeMatchFilterViewModel.matchFilterModel) && this.min == rangeMatchFilterViewModel.min && this.max == rangeMatchFilterViewModel.max && this.searchHasMax == rangeMatchFilterViewModel.searchHasMax && this.searchHasMin == rangeMatchFilterViewModel.searchHasMin && this.productType == rangeMatchFilterViewModel.productType;
    }

    @NotNull
    public final MatchFilterModel getMatchFilterModel() {
        return this.matchFilterModel;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    @NotNull
    public final PurchaseProductType getProductType() {
        return this.productType;
    }

    public final boolean getSearchHasMax() {
        return this.searchHasMax;
    }

    public final boolean getSearchHasMin() {
        return this.searchHasMin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.matchFilterModel.hashCode() * 31) + this.min) * 31) + this.max) * 31;
        boolean z10 = this.searchHasMax;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.searchHasMin;
        return ((i11 + (z11 ? 1 : z11 ? 1 : 0)) * 31) + this.productType.hashCode();
    }

    public final void setMax(int i10) {
        this.max = i10;
    }

    public final void setMin(int i10) {
        this.min = i10;
    }

    @NotNull
    public String toString() {
        MatchFilterModel matchFilterModel = this.matchFilterModel;
        return "RangeMatchFilterViewModel(matchFilterModel=" + ((Object) matchFilterModel) + ", min=" + this.min + ", max=" + this.max + ", searchHasMax=" + this.searchHasMax + ", searchHasMin=" + this.searchHasMin + ", productType=" + ((Object) this.productType) + ")";
    }

    public /* synthetic */ RangeMatchFilterViewModel(MatchFilterModel matchFilterModel, int i10, int i11, boolean z10, boolean z11, PurchaseProductType purchaseProductType, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(matchFilterModel, (i12 & 2) != 0 ? matchFilterModel.getMinValue() : i10, (i12 & 4) != 0 ? matchFilterModel.getMaxValue() : i11, (i12 & 8) != 0 ? false : z10, (i12 & 16) != 0 ? false : z11, (i12 & 32) != 0 ? PurchaseProductType.VIP : purchaseProductType);
    }
}
