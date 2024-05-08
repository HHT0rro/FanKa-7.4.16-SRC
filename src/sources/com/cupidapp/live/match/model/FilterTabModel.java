package com.cupidapp.live.match.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FilterTabModel implements Serializable {

    @NotNull
    private final String key;

    @Nullable
    private final List<FilterOption> options;
    private final int productType;

    @NotNull
    private final String tabName;

    @NotNull
    private final String title;

    public FilterTabModel(@NotNull String key, @Nullable List<FilterOption> list, int i10, @NotNull String tabName, @NotNull String title) {
        s.i(key, "key");
        s.i(tabName, "tabName");
        s.i(title, "title");
        this.key = key;
        this.options = list;
        this.productType = i10;
        this.tabName = tabName;
        this.title = title;
    }

    public static /* synthetic */ FilterTabModel copy$default(FilterTabModel filterTabModel, String str, List list, int i10, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = filterTabModel.key;
        }
        if ((i11 & 2) != 0) {
            list = filterTabModel.options;
        }
        List list2 = list;
        if ((i11 & 4) != 0) {
            i10 = filterTabModel.productType;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            str2 = filterTabModel.tabName;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            str3 = filterTabModel.title;
        }
        return filterTabModel.copy(str, list2, i12, str4, str3);
    }

    @NotNull
    public final String component1() {
        return this.key;
    }

    @Nullable
    public final List<FilterOption> component2() {
        return this.options;
    }

    public final int component3() {
        return this.productType;
    }

    @NotNull
    public final String component4() {
        return this.tabName;
    }

    @NotNull
    public final String component5() {
        return this.title;
    }

    @NotNull
    public final FilterTabModel copy(@NotNull String key, @Nullable List<FilterOption> list, int i10, @NotNull String tabName, @NotNull String title) {
        s.i(key, "key");
        s.i(tabName, "tabName");
        s.i(title, "title");
        return new FilterTabModel(key, list, i10, tabName, title);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterTabModel)) {
            return false;
        }
        FilterTabModel filterTabModel = (FilterTabModel) obj;
        return s.d(this.key, filterTabModel.key) && s.d(this.options, filterTabModel.options) && this.productType == filterTabModel.productType && s.d(this.tabName, filterTabModel.tabName) && s.d(this.title, filterTabModel.title);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final List<FilterOption> getOptions() {
        return this.options;
    }

    public final int getProductType() {
        return this.productType;
    }

    @NotNull
    public final String getTabName() {
        return this.tabName;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        List<FilterOption> list = this.options;
        return ((((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.productType) * 31) + this.tabName.hashCode()) * 31) + this.title.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.key;
        List<FilterOption> list = this.options;
        return "FilterTabModel(key=" + str + ", options=" + ((Object) list) + ", productType=" + this.productType + ", tabName=" + this.tabName + ", title=" + this.title + ")";
    }
}
