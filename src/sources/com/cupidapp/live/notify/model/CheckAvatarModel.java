package com.cupidapp.live.notify.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CheckAvatarModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CheckAvatarModel {
    private final boolean realFake;

    public CheckAvatarModel(boolean z10) {
        this.realFake = z10;
    }

    public static /* synthetic */ CheckAvatarModel copy$default(CheckAvatarModel checkAvatarModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = checkAvatarModel.realFake;
        }
        return checkAvatarModel.copy(z10);
    }

    public final boolean component1() {
        return this.realFake;
    }

    @NotNull
    public final CheckAvatarModel copy(boolean z10) {
        return new CheckAvatarModel(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CheckAvatarModel) && this.realFake == ((CheckAvatarModel) obj).realFake;
    }

    public final boolean getRealFake() {
        return this.realFake;
    }

    public int hashCode() {
        boolean z10 = this.realFake;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "CheckAvatarModel(realFake=" + this.realFake + ")";
    }
}
