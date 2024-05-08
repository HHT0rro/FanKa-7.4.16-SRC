package com.cupidapp.live.filter.model;

import com.cupidapp.live.match.model.FilterOption;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterTopTabModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterTopOptionsUiModel extends FilterTopTabUiBaseModel {

    @NotNull
    private final List<FilterOption> options;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterTopOptionsUiModel(@Nullable String str, @NotNull String key, int i10, @NotNull TabLayoutStyle style, boolean z10, @NotNull String name, @NotNull List<FilterOption> options, boolean z11) {
        super(str, name, key, i10, style, z10, z11);
        s.i(key, "key");
        s.i(style, "style");
        s.i(name, "name");
        s.i(options, "options");
        this.options = options;
    }

    @NotNull
    public final List<FilterOption> getOptions() {
        return this.options;
    }
}
