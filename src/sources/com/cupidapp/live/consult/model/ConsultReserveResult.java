package com.cupidapp.live.consult.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultReserveResult {

    @NotNull
    private final User user;

    public ConsultReserveResult(@NotNull User user) {
        s.i(user, "user");
        this.user = user;
    }

    public static /* synthetic */ ConsultReserveResult copy$default(ConsultReserveResult consultReserveResult, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = consultReserveResult.user;
        }
        return consultReserveResult.copy(user);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @NotNull
    public final ConsultReserveResult copy(@NotNull User user) {
        s.i(user, "user");
        return new ConsultReserveResult(user);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsultReserveResult) && s.d(this.user, ((ConsultReserveResult) obj).user);
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
        return "ConsultReserveResult(user=" + ((Object) this.user) + ")";
    }
}
