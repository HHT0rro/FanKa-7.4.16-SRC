package com.cupidapp.live.filter.view;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterTabLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterItemModel {

    @NotNull
    private final String content;
    private boolean isSelected;

    @NotNull
    private final String key;

    public FilterItemModel(@NotNull String content, @NotNull String key, boolean z10) {
        s.i(content, "content");
        s.i(key, "key");
        this.content = content;
        this.key = key;
        this.isSelected = z10;
    }

    public static /* synthetic */ FilterItemModel copy$default(FilterItemModel filterItemModel, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = filterItemModel.content;
        }
        if ((i10 & 2) != 0) {
            str2 = filterItemModel.key;
        }
        if ((i10 & 4) != 0) {
            z10 = filterItemModel.isSelected;
        }
        return filterItemModel.copy(str, str2, z10);
    }

    @NotNull
    public final String component1() {
        return this.content;
    }

    @NotNull
    public final String component2() {
        return this.key;
    }

    public final boolean component3() {
        return this.isSelected;
    }

    @NotNull
    public final FilterItemModel copy(@NotNull String content, @NotNull String key, boolean z10) {
        s.i(content, "content");
        s.i(key, "key");
        return new FilterItemModel(content, key, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterItemModel)) {
            return false;
        }
        FilterItemModel filterItemModel = (FilterItemModel) obj;
        return s.d(this.content, filterItemModel.content) && s.d(this.key, filterItemModel.key) && this.isSelected == filterItemModel.isSelected;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.content.hashCode() * 31) + this.key.hashCode()) * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    @NotNull
    public String toString() {
        return "FilterItemModel(content=" + this.content + ", key=" + this.key + ", isSelected=" + this.isSelected + ")";
    }
}
