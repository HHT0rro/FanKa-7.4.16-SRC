package com.cupidapp.live.base.view.timepicker;

import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OptionsPickerWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OptionsModel {

    @NotNull
    private final List<String> optionList;

    @Nullable
    private final String selectedValue;

    public OptionsModel(@NotNull List<String> optionList, @Nullable String str) {
        s.i(optionList, "optionList");
        this.optionList = optionList;
        this.selectedValue = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OptionsModel copy$default(OptionsModel optionsModel, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = optionsModel.optionList;
        }
        if ((i10 & 2) != 0) {
            str = optionsModel.selectedValue;
        }
        return optionsModel.copy(list, str);
    }

    @NotNull
    public final List<String> component1() {
        return this.optionList;
    }

    @Nullable
    public final String component2() {
        return this.selectedValue;
    }

    @NotNull
    public final OptionsModel copy(@NotNull List<String> optionList, @Nullable String str) {
        s.i(optionList, "optionList");
        return new OptionsModel(optionList, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionsModel)) {
            return false;
        }
        OptionsModel optionsModel = (OptionsModel) obj;
        return s.d(this.optionList, optionsModel.optionList) && s.d(this.selectedValue, optionsModel.selectedValue);
    }

    @NotNull
    public final List<String> getOptionList() {
        return this.optionList;
    }

    @Nullable
    public final String getSelectedValue() {
        return this.selectedValue;
    }

    public int hashCode() {
        int hashCode = this.optionList.hashCode() * 31;
        String str = this.selectedValue;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        List<String> list = this.optionList;
        return "OptionsModel(optionList=" + ((Object) list) + ", selectedValue=" + this.selectedValue + ")";
    }
}
