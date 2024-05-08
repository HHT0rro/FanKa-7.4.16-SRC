package com.cupidapp.live.club.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatAtUserEvent {

    @Nullable
    private final User user;

    public ClubChatAtUserEvent(@Nullable User user) {
        this.user = user;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }
}
