package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveReserveResult {

    @NotNull
    private final User user;

    public LiveReserveResult(@NotNull User user) {
        s.i(user, "user");
        this.user = user;
    }

    public static /* synthetic */ LiveReserveResult copy$default(LiveReserveResult liveReserveResult, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = liveReserveResult.user;
        }
        return liveReserveResult.copy(user);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @NotNull
    public final LiveReserveResult copy(@NotNull User user) {
        s.i(user, "user");
        return new LiveReserveResult(user);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveReserveResult) && s.d(this.user, ((LiveReserveResult) obj).user);
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        return this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveReserveResult(user=" + ((Object) this.user) + ")";
    }
}
