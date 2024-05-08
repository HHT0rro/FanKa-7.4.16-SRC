package com.cupidapp.live.filter.model;

import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterTopTabModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterTopRangeUiModel extends FilterTopTabUiBaseModel {

    @Nullable
    private final RangeMatchFilterViewModel filterModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterTopRangeUiModel(@Nullable String str, @NotNull String key, int i10, @NotNull TabLayoutStyle style, boolean z10, @NotNull String name, @Nullable RangeMatchFilterViewModel rangeMatchFilterViewModel, boolean z11) {
        super(str, name, key, i10, style, z10, z11);
        s.i(key, "key");
        s.i(style, "style");
        s.i(name, "name");
        this.filterModel = rangeMatchFilterViewModel;
    }

    @Nullable
    public final RangeMatchFilterViewModel getFilterModel() {
        return this.filterModel;
    }
}
