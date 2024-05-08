package com.cupidapp.live.profile.event;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ProfileEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserProfileDataChangeEvent {
    private final boolean notifyMatchCardSwipe;

    @NotNull
    private final User user;

    public UserProfileDataChangeEvent(@NotNull User user, boolean z10) {
        s.i(user, "user");
        this.user = user;
        this.notifyMatchCardSwipe = z10;
    }

    public final boolean getNotifyMatchCardSwipe() {
        return this.notifyMatchCardSwipe;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }
}
