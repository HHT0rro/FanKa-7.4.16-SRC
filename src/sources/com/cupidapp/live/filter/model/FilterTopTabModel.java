package com.cupidapp.live.filter.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterTopTabModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterTopTabModel {
    private final boolean limitTimeReward;

    @NotNull
    private final List<FilterTopTabItemModel> list;
    private final boolean useFilter;

    public FilterTopTabModel(@NotNull List<FilterTopTabItemModel> list, boolean z10, boolean z11) {
        s.i(list, "list");
        this.list = list;
        this.useFilter = z10;
        this.limitTimeReward = z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterTopTabModel copy$default(FilterTopTabModel filterTopTabModel, List list, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = filterTopTabModel.list;
        }
        if ((i10 & 2) != 0) {
            z10 = filterTopTabModel.useFilter;
        }
        if ((i10 & 4) != 0) {
            z11 = filterTopTabModel.limitTimeReward;
        }
        return filterTopTabModel.copy(list, z10, z11);
    }

    @NotNull
    public final List<FilterTopTabItemModel> component1() {
        return this.list;
    }

    public final boolean component2() {
        return this.useFilter;
    }

    public final boolean component3() {
        return this.limitTimeReward;
    }

    @NotNull
    public final FilterTopTabModel copy(@NotNull List<FilterTopTabItemModel> list, boolean z10, boolean z11) {
        s.i(list, "list");
        return new FilterTopTabModel(list, z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterTopTabModel)) {
            return false;
        }
        FilterTopTabModel filterTopTabModel = (FilterTopTabModel) obj;
        return s.d(this.list, filterTopTabModel.list) && this.useFilter == filterTopTabModel.useFilter && this.limitTimeReward == filterTopTabModel.limitTimeReward;
    }

    public final boolean getLimitTimeReward() {
        return this.limitTimeReward;
    }

    @NotNull
    public final List<FilterTopTabItemModel> getList() {
        return this.list;
    }

    public final boolean getUseFilter() {
        return this.useFilter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.list.hashCode() * 31;
        boolean z10 = this.useFilter;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.limitTimeReward;
        return i11 + (z11 ? 1 : z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        List<FilterTopTabItemModel> list = this.list;
        return "FilterTopTabModel(list=" + ((Object) list) + ", useFilter=" + this.useFilter + ", limitTimeReward=" + this.limitTimeReward + ")";
    }
}
