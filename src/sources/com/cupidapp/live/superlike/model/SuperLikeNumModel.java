package com.cupidapp.live.superlike.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperLikeModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikeNumModel {
    private final int nums;

    public SuperLikeNumModel(int i10) {
        this.nums = i10;
    }

    public static /* synthetic */ SuperLikeNumModel copy$default(SuperLikeNumModel superLikeNumModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = superLikeNumModel.nums;
        }
        return superLikeNumModel.copy(i10);
    }

    public final int component1() {
        return this.nums;
    }

    @NotNull
    public final SuperLikeNumModel copy(int i10) {
        return new SuperLikeNumModel(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SuperLikeNumModel) && this.nums == ((SuperLikeNumModel) obj).nums;
    }

    public final int getNums() {
        return this.nums;
    }

    public int hashCode() {
        return this.nums;
    }

    @NotNull
    public String toString() {
        return "SuperLikeNumModel(nums=" + this.nums + ")";
    }
}
