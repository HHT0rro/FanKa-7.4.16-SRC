package com.cupidapp.live.profile.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AddInfoOptionsModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AddInfoOptionsModel implements Serializable {

    @Nullable
    private final String alias;
    private boolean checked;

    @NotNull
    private final String label;

    @NotNull
    private final String value;

    public AddInfoOptionsModel(boolean z10, @NotNull String label, @Nullable String str, @NotNull String value) {
        s.i(label, "label");
        s.i(value, "value");
        this.checked = z10;
        this.label = label;
        this.alias = str;
        this.value = value;
    }

    public static /* synthetic */ AddInfoOptionsModel copy$default(AddInfoOptionsModel addInfoOptionsModel, boolean z10, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = addInfoOptionsModel.checked;
        }
        if ((i10 & 2) != 0) {
            str = addInfoOptionsModel.label;
        }
        if ((i10 & 4) != 0) {
            str2 = addInfoOptionsModel.alias;
        }
        if ((i10 & 8) != 0) {
            str3 = addInfoOptionsModel.value;
        }
        return addInfoOptionsModel.copy(z10, str, str2, str3);
    }

    public final boolean component1() {
        return this.checked;
    }

    @NotNull
    public final String component2() {
        return this.label;
    }

    @Nullable
    public final String component3() {
        return this.alias;
    }

    @NotNull
    public final String component4() {
        return this.value;
    }

    @NotNull
    public final AddInfoOptionsModel copy(boolean z10, @NotNull String label, @Nullable String str, @NotNull String value) {
        s.i(label, "label");
        s.i(value, "value");
        return new AddInfoOptionsModel(z10, label, str, value);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddInfoOptionsModel)) {
            return false;
        }
        AddInfoOptionsModel addInfoOptionsModel = (AddInfoOptionsModel) obj;
        return this.checked == addInfoOptionsModel.checked && s.d(this.label, addInfoOptionsModel.label) && s.d(this.alias, addInfoOptionsModel.alias) && s.d(this.value, addInfoOptionsModel.value);
    }

    @Nullable
    public final String getAlias() {
        return this.alias;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z10 = this.checked;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int hashCode = ((r02 * 31) + this.label.hashCode()) * 31;
        String str = this.alias;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.value.hashCode();
    }

    public final void setChecked(boolean z10) {
        this.checked = z10;
    }

    @NotNull
    public String toString() {
        return "AddInfoOptionsModel(checked=" + this.checked + ", label=" + this.label + ", alias=" + this.alias + ", value=" + this.value + ")";
    }
}
