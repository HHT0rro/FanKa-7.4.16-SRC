package com.cupidapp.live.profile.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FocusResultModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FocusResultModel {
    private final boolean aloha;
    private final boolean match;

    public FocusResultModel(boolean z10, boolean z11) {
        this.aloha = z10;
        this.match = z11;
    }

    public static /* synthetic */ FocusResultModel copy$default(FocusResultModel focusResultModel, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = focusResultModel.aloha;
        }
        if ((i10 & 2) != 0) {
            z11 = focusResultModel.match;
        }
        return focusResultModel.copy(z10, z11);
    }

    public final boolean component1() {
        return this.aloha;
    }

    public final boolean component2() {
        return this.match;
    }

    @NotNull
    public final FocusResultModel copy(boolean z10, boolean z11) {
        return new FocusResultModel(z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FocusResultModel)) {
            return false;
        }
        FocusResultModel focusResultModel = (FocusResultModel) obj;
        return this.aloha == focusResultModel.aloha && this.match == focusResultModel.match;
    }

    public final boolean getAloha() {
        return this.aloha;
    }

    public final boolean getMatch() {
        return this.match;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.aloha;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.match;
        return i10 + (z11 ? 1 : z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "FocusResultModel(aloha=" + this.aloha + ", match=" + this.match + ")";
    }
}
