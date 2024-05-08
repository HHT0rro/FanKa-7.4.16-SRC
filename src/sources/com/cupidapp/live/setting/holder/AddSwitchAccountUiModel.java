package com.cupidapp.live.setting.holder;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AddSwitchAccountViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AddSwitchAccountUiModel {
    private boolean isVisible;

    public AddSwitchAccountUiModel(boolean z10) {
        this.isVisible = z10;
    }

    public static /* synthetic */ AddSwitchAccountUiModel copy$default(AddSwitchAccountUiModel addSwitchAccountUiModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = addSwitchAccountUiModel.isVisible;
        }
        return addSwitchAccountUiModel.copy(z10);
    }

    public final boolean component1() {
        return this.isVisible;
    }

    @NotNull
    public final AddSwitchAccountUiModel copy(boolean z10) {
        return new AddSwitchAccountUiModel(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AddSwitchAccountUiModel) && this.isVisible == ((AddSwitchAccountUiModel) obj).isVisible;
    }

    public int hashCode() {
        boolean z10 = this.isVisible;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z10) {
        this.isVisible = z10;
    }

    @NotNull
    public String toString() {
        return "AddSwitchAccountUiModel(isVisible=" + this.isVisible + ")";
    }
}
