package com.cupidapp.live.superboost.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DirectSuperBoostFilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FilterItemUiModel {

    @NotNull
    private final String key;

    @NotNull
    private final List<FilterOptionModel> options;

    @NotNull
    private final String title;

    public FilterItemUiModel(@NotNull String title, @NotNull List<FilterOptionModel> options, @NotNull String key) {
        s.i(title, "title");
        s.i(options, "options");
        s.i(key, "key");
        this.title = title;
        this.options = options;
        this.key = key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterItemUiModel copy$default(FilterItemUiModel filterItemUiModel, String str, List list, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = filterItemUiModel.title;
        }
        if ((i10 & 2) != 0) {
            list = filterItemUiModel.options;
        }
        if ((i10 & 4) != 0) {
            str2 = filterItemUiModel.key;
        }
        return filterItemUiModel.copy(str, list, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<FilterOptionModel> component2() {
        return this.options;
    }

    @NotNull
    public final String component3() {
        return this.key;
    }

    @NotNull
    public final FilterItemUiModel copy(@NotNull String title, @NotNull List<FilterOptionModel> options, @NotNull String key) {
        s.i(title, "title");
        s.i(options, "options");
        s.i(key, "key");
        return new FilterItemUiModel(title, options, key);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterItemUiModel)) {
            return false;
        }
        FilterItemUiModel filterItemUiModel = (FilterItemUiModel) obj;
        return s.d(this.title, filterItemUiModel.title) && s.d(this.options, filterItemUiModel.options) && s.d(this.key, filterItemUiModel.key);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final List<FilterOptionModel> getOptions() {
        return this.options;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.options.hashCode()) * 31) + this.key.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        List<FilterOptionModel> list = this.options;
        return "FilterItemUiModel(title=" + str + ", options=" + ((Object) list) + ", key=" + this.key + ")";
    }
}
