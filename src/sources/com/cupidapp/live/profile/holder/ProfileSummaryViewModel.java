package com.cupidapp.live.profile.holder;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ProfileSummaryViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileSummaryViewModel {

    @NotNull
    private final User user;

    public ProfileSummaryViewModel(@NotNull User user) {
        s.i(user, "user");
        this.user = user;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }
}
