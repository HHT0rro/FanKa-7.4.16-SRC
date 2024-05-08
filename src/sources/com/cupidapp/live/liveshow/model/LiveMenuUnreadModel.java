package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveFunctionMenuModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveMenuUnreadModel {
    private final boolean anchorUnread;
    private final boolean userUnread;

    public LiveMenuUnreadModel(boolean z10, boolean z11) {
        this.anchorUnread = z10;
        this.userUnread = z11;
    }

    public static /* synthetic */ LiveMenuUnreadModel copy$default(LiveMenuUnreadModel liveMenuUnreadModel, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = liveMenuUnreadModel.anchorUnread;
        }
        if ((i10 & 2) != 0) {
            z11 = liveMenuUnreadModel.userUnread;
        }
        return liveMenuUnreadModel.copy(z10, z11);
    }

    public final boolean component1() {
        return this.anchorUnread;
    }

    public final boolean component2() {
        return this.userUnread;
    }

    @NotNull
    public final LiveMenuUnreadModel copy(boolean z10, boolean z11) {
        return new LiveMenuUnreadModel(z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveMenuUnreadModel)) {
            return false;
        }
        LiveMenuUnreadModel liveMenuUnreadModel = (LiveMenuUnreadModel) obj;
        return this.anchorUnread == liveMenuUnreadModel.anchorUnread && this.userUnread == liveMenuUnreadModel.userUnread;
    }

    public final boolean getAnchorUnread() {
        return this.anchorUnread;
    }

    public final boolean getUserUnread() {
        return this.userUnread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.anchorUnread;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.userUnread;
        return i10 + (z11 ? 1 : z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "LiveMenuUnreadModel(anchorUnread=" + this.anchorUnread + ", userUnread=" + this.userUnread + ")";
    }
}
