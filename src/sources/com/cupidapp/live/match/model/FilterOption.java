package com.cupidapp.live.match.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FilterOption implements Serializable {
    private boolean checked;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private String f16835id;

    @NotNull
    private String label;

    @Nullable
    private String tag;

    public FilterOption(@NotNull String id2, @NotNull String label, boolean z10, @Nullable String str) {
        s.i(id2, "id");
        s.i(label, "label");
        this.f16835id = id2;
        this.label = label;
        this.checked = z10;
        this.tag = str;
    }

    public static /* synthetic */ FilterOption copy$default(FilterOption filterOption, String str, String str2, boolean z10, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = filterOption.f16835id;
        }
        if ((i10 & 2) != 0) {
            str2 = filterOption.label;
        }
        if ((i10 & 4) != 0) {
            z10 = filterOption.checked;
        }
        if ((i10 & 8) != 0) {
            str3 = filterOption.tag;
        }
        return filterOption.copy(str, str2, z10, str3);
    }

    @NotNull
    public final String component1() {
        return this.f16835id;
    }

    @NotNull
    public final String component2() {
        return this.label;
    }

    public final boolean component3() {
        return this.checked;
    }

    @Nullable
    public final String component4() {
        return this.tag;
    }

    @NotNull
    public final FilterOption copy(@NotNull String id2, @NotNull String label, boolean z10, @Nullable String str) {
        s.i(id2, "id");
        s.i(label, "label");
        return new FilterOption(id2, label, z10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterOption)) {
            return false;
        }
        FilterOption filterOption = (FilterOption) obj;
        return s.d(this.f16835id, filterOption.f16835id) && s.d(this.label, filterOption.label) && this.checked == filterOption.checked && s.d(this.tag, filterOption.tag);
    }

    public final boolean getChecked() {
        return this.checked;
    }

    @NotNull
    public final String getId() {
        return this.f16835id;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f16835id.hashCode() * 31) + this.label.hashCode()) * 31;
        boolean z10 = this.checked;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        String str = this.tag;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public final void setChecked(boolean z10) {
        this.checked = z10;
    }

    public final void setId(@NotNull String str) {
        s.i(str, "<set-?>");
        this.f16835id = str;
    }

    public final void setLabel(@NotNull String str) {
        s.i(str, "<set-?>");
        this.label = str;
    }

    public final void setTag(@Nullable String str) {
        this.tag = str;
    }

    @NotNull
    public String toString() {
        return "FilterOption(id=" + this.f16835id + ", label=" + this.label + ", checked=" + this.checked + ", tag=" + this.tag + ")";
    }

    public /* synthetic */ FilterOption(String str, String str2, boolean z10, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? false : z10, str3);
    }
}
