package com.cupidapp.live.profile.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UnfollowNotifyModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UnfollowNotifyModel {
    private final int unfollowNotifyRange;

    public UnfollowNotifyModel(int i10) {
        this.unfollowNotifyRange = i10;
    }

    public static /* synthetic */ UnfollowNotifyModel copy$default(UnfollowNotifyModel unfollowNotifyModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = unfollowNotifyModel.unfollowNotifyRange;
        }
        return unfollowNotifyModel.copy(i10);
    }

    public final int component1() {
        return this.unfollowNotifyRange;
    }

    @NotNull
    public final UnfollowNotifyModel copy(int i10) {
        return new UnfollowNotifyModel(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UnfollowNotifyModel) && this.unfollowNotifyRange == ((UnfollowNotifyModel) obj).unfollowNotifyRange;
    }

    public final int getUnfollowNotifyRange() {
        return this.unfollowNotifyRange;
    }

    public int hashCode() {
        return this.unfollowNotifyRange;
    }

    @NotNull
    public String toString() {
        return "UnfollowNotifyModel(unfollowNotifyRange=" + this.unfollowNotifyRange + ")";
    }
}
