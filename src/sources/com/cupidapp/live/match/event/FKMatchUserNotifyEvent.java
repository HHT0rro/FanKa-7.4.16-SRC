package com.cupidapp.live.match.event;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMatchUserNotifyEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKMatchUserNotifyEvent {

    @Nullable
    private final Boolean guide;
    private final boolean initiativeMatch;

    @NotNull
    private final User user;

    public FKMatchUserNotifyEvent(@NotNull User user, boolean z10, @Nullable Boolean bool) {
        s.i(user, "user");
        this.user = user;
        this.initiativeMatch = z10;
        this.guide = bool;
    }

    public static /* synthetic */ FKMatchUserNotifyEvent copy$default(FKMatchUserNotifyEvent fKMatchUserNotifyEvent, User user, boolean z10, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = fKMatchUserNotifyEvent.user;
        }
        if ((i10 & 2) != 0) {
            z10 = fKMatchUserNotifyEvent.initiativeMatch;
        }
        if ((i10 & 4) != 0) {
            bool = fKMatchUserNotifyEvent.guide;
        }
        return fKMatchUserNotifyEvent.copy(user, z10, bool);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    public final boolean component2() {
        return this.initiativeMatch;
    }

    @Nullable
    public final Boolean component3() {
        return this.guide;
    }

    @NotNull
    public final FKMatchUserNotifyEvent copy(@NotNull User user, boolean z10, @Nullable Boolean bool) {
        s.i(user, "user");
        return new FKMatchUserNotifyEvent(user, z10, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKMatchUserNotifyEvent)) {
            return false;
        }
        FKMatchUserNotifyEvent fKMatchUserNotifyEvent = (FKMatchUserNotifyEvent) obj;
        return s.d(this.user, fKMatchUserNotifyEvent.user) && this.initiativeMatch == fKMatchUserNotifyEvent.initiativeMatch && s.d(this.guide, fKMatchUserNotifyEvent.guide);
    }

    @Nullable
    public final Boolean getGuide() {
        return this.guide;
    }

    public final boolean getInitiativeMatch() {
        return this.initiativeMatch;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        boolean z10 = this.initiativeMatch;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        Boolean bool = this.guide;
        return i11 + (bool == null ? 0 : bool.hashCode());
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "FKMatchUserNotifyEvent(user=" + ((Object) user) + ", initiativeMatch=" + this.initiativeMatch + ", guide=" + ((Object) this.guide) + ")";
    }

    public /* synthetic */ FKMatchUserNotifyEvent(User user, boolean z10, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, z10, (i10 & 4) != 0 ? Boolean.FALSE : bool);
    }
}
