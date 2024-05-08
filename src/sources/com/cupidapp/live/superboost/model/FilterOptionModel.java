package com.cupidapp.live.superboost.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DirectSuperBoostFilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FilterOptionModel {
    private boolean checked;

    @NotNull
    private final String label;
    private final int value;

    public FilterOptionModel(@NotNull String label, int i10, boolean z10) {
        s.i(label, "label");
        this.label = label;
        this.value = i10;
        this.checked = z10;
    }

    public static /* synthetic */ FilterOptionModel copy$default(FilterOptionModel filterOptionModel, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = filterOptionModel.label;
        }
        if ((i11 & 2) != 0) {
            i10 = filterOptionModel.value;
        }
        if ((i11 & 4) != 0) {
            z10 = filterOptionModel.checked;
        }
        return filterOptionModel.copy(str, i10, z10);
    }

    @NotNull
    public final String component1() {
        return this.label;
    }

    public final int component2() {
        return this.value;
    }

    public final boolean component3() {
        return this.checked;
    }

    @NotNull
    public final FilterOptionModel copy(@NotNull String label, int i10, boolean z10) {
        s.i(label, "label");
        return new FilterOptionModel(label, i10, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterOptionModel)) {
            return false;
        }
        FilterOptionModel filterOptionModel = (FilterOptionModel) obj;
        return s.d(this.label, filterOptionModel.label) && this.value == filterOptionModel.value && this.checked == filterOptionModel.checked;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public final int getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.label.hashCode() * 31) + this.value) * 31;
        boolean z10 = this.checked;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setChecked(boolean z10) {
        this.checked = z10;
    }

    @NotNull
    public String toString() {
        return "FilterOptionModel(label=" + this.label + ", value=" + this.value + ", checked=" + this.checked + ")";
    }
}
