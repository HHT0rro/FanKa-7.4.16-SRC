package com.cupidapp.live.base.network.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EnableButtonsModel {
    private boolean showSuperboost;
    private boolean showSuperlike;

    public EnableButtonsModel(boolean z10, boolean z11) {
        this.showSuperlike = z10;
        this.showSuperboost = z11;
    }

    public static /* synthetic */ EnableButtonsModel copy$default(EnableButtonsModel enableButtonsModel, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = enableButtonsModel.showSuperlike;
        }
        if ((i10 & 2) != 0) {
            z11 = enableButtonsModel.showSuperboost;
        }
        return enableButtonsModel.copy(z10, z11);
    }

    public final boolean component1() {
        return this.showSuperlike;
    }

    public final boolean component2() {
        return this.showSuperboost;
    }

    @NotNull
    public final EnableButtonsModel copy(boolean z10, boolean z11) {
        return new EnableButtonsModel(z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnableButtonsModel)) {
            return false;
        }
        EnableButtonsModel enableButtonsModel = (EnableButtonsModel) obj;
        return this.showSuperlike == enableButtonsModel.showSuperlike && this.showSuperboost == enableButtonsModel.showSuperboost;
    }

    public final boolean getShowSuperboost() {
        return this.showSuperboost;
    }

    public final boolean getShowSuperlike() {
        return this.showSuperlike;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.showSuperlike;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.showSuperboost;
        return i10 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final void setShowSuperboost(boolean z10) {
        this.showSuperboost = z10;
    }

    public final void setShowSuperlike(boolean z10) {
        this.showSuperlike = z10;
    }

    @NotNull
    public String toString() {
        return "EnableButtonsModel(showSuperlike=" + this.showSuperlike + ", showSuperboost=" + this.showSuperboost + ")";
    }
}
