package com.cupidapp.live.profile.event;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserCloseFriendChangeEvent {
    private final boolean closeFriend;

    @NotNull
    private final String userId;

    public UserCloseFriendChangeEvent(@NotNull String userId, boolean z10) {
        s.i(userId, "userId");
        this.userId = userId;
        this.closeFriend = z10;
    }

    public static /* synthetic */ UserCloseFriendChangeEvent copy$default(UserCloseFriendChangeEvent userCloseFriendChangeEvent, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = userCloseFriendChangeEvent.userId;
        }
        if ((i10 & 2) != 0) {
            z10 = userCloseFriendChangeEvent.closeFriend;
        }
        return userCloseFriendChangeEvent.copy(str, z10);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    public final boolean component2() {
        return this.closeFriend;
    }

    @NotNull
    public final UserCloseFriendChangeEvent copy(@NotNull String userId, boolean z10) {
        s.i(userId, "userId");
        return new UserCloseFriendChangeEvent(userId, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserCloseFriendChangeEvent)) {
            return false;
        }
        UserCloseFriendChangeEvent userCloseFriendChangeEvent = (UserCloseFriendChangeEvent) obj;
        return s.d(this.userId, userCloseFriendChangeEvent.userId) && this.closeFriend == userCloseFriendChangeEvent.closeFriend;
    }

    public final boolean getCloseFriend() {
        return this.closeFriend;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.userId.hashCode() * 31;
        boolean z10 = this.closeFriend;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        return "UserCloseFriendChangeEvent(userId=" + this.userId + ", closeFriend=" + this.closeFriend + ")";
    }
}
