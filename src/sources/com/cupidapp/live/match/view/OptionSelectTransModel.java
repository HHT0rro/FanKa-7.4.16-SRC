package com.cupidapp.live.match.view;

import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OptionSelectLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class OptionSelectTransModel {

    @NotNull
    private final VipPurchaseEntranceType entranceType;
    private final int itemWidth;
    private final boolean needPurchaseFirst;

    @Nullable
    private final List<FilterOption> options;
    private final int productType;

    public OptionSelectTransModel(@Nullable List<FilterOption> list, int i10, boolean z10, int i11, @NotNull VipPurchaseEntranceType entranceType) {
        kotlin.jvm.internal.s.i(entranceType, "entranceType");
        this.options = list;
        this.itemWidth = i10;
        this.needPurchaseFirst = z10;
        this.productType = i11;
        this.entranceType = entranceType;
    }

    public static /* synthetic */ OptionSelectTransModel copy$default(OptionSelectTransModel optionSelectTransModel, List list, int i10, boolean z10, int i11, VipPurchaseEntranceType vipPurchaseEntranceType, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = optionSelectTransModel.options;
        }
        if ((i12 & 2) != 0) {
            i10 = optionSelectTransModel.itemWidth;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            z10 = optionSelectTransModel.needPurchaseFirst;
        }
        boolean z11 = z10;
        if ((i12 & 8) != 0) {
            i11 = optionSelectTransModel.productType;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            vipPurchaseEntranceType = optionSelectTransModel.entranceType;
        }
        return optionSelectTransModel.copy(list, i13, z11, i14, vipPurchaseEntranceType);
    }

    @Nullable
    public final List<FilterOption> component1() {
        return this.options;
    }

    public final int component2() {
        return this.itemWidth;
    }

    public final boolean component3() {
        return this.needPurchaseFirst;
    }

    public final int component4() {
        return this.productType;
    }

    @NotNull
    public final VipPurchaseEntranceType component5() {
        return this.entranceType;
    }

    @NotNull
    public final OptionSelectTransModel copy(@Nullable List<FilterOption> list, int i10, boolean z10, int i11, @NotNull VipPurchaseEntranceType entranceType) {
        kotlin.jvm.internal.s.i(entranceType, "entranceType");
        return new OptionSelectTransModel(list, i10, z10, i11, entranceType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionSelectTransModel)) {
            return false;
        }
        OptionSelectTransModel optionSelectTransModel = (OptionSelectTransModel) obj;
        return kotlin.jvm.internal.s.d(this.options, optionSelectTransModel.options) && this.itemWidth == optionSelectTransModel.itemWidth && this.needPurchaseFirst == optionSelectTransModel.needPurchaseFirst && this.productType == optionSelectTransModel.productType && this.entranceType == optionSelectTransModel.entranceType;
    }

    @NotNull
    public final VipPurchaseEntranceType getEntranceType() {
        return this.entranceType;
    }

    public final int getItemWidth() {
        return this.itemWidth;
    }

    public final boolean getNeedPurchaseFirst() {
        return this.needPurchaseFirst;
    }

    @Nullable
    public final List<FilterOption> getOptions() {
        return this.options;
    }

    public final int getProductType() {
        return this.productType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<FilterOption> list = this.options;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.itemWidth) * 31;
        boolean z10 = this.needPurchaseFirst;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((((hashCode + i10) * 31) + this.productType) * 31) + this.entranceType.hashCode();
    }

    @NotNull
    public String toString() {
        List<FilterOption> list = this.options;
        return "OptionSelectTransModel(options=" + ((Object) list) + ", itemWidth=" + this.itemWidth + ", needPurchaseFirst=" + this.needPurchaseFirst + ", productType=" + this.productType + ", entranceType=" + ((Object) this.entranceType) + ")";
    }
}
