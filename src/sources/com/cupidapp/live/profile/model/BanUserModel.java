package com.cupidapp.live.profile.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BanUserModel {
    private final int bottomSpaceHeight;

    public BanUserModel() {
        this(0, 1, null);
    }

    public BanUserModel(int i10) {
        this.bottomSpaceHeight = i10;
    }

    public static /* synthetic */ BanUserModel copy$default(BanUserModel banUserModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = banUserModel.bottomSpaceHeight;
        }
        return banUserModel.copy(i10);
    }

    public final int component1() {
        return this.bottomSpaceHeight;
    }

    @NotNull
    public final BanUserModel copy(int i10) {
        return new BanUserModel(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BanUserModel) && this.bottomSpaceHeight == ((BanUserModel) obj).bottomSpaceHeight;
    }

    public final int getBottomSpaceHeight() {
        return this.bottomSpaceHeight;
    }

    public int hashCode() {
        return this.bottomSpaceHeight;
    }

    @NotNull
    public String toString() {
        return "BanUserModel(bottomSpaceHeight=" + this.bottomSpaceHeight + ")";
    }

    public /* synthetic */ BanUserModel(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
