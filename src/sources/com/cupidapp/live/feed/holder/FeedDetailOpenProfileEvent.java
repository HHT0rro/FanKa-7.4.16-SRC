package com.cupidapp.live.feed.holder;

import com.cupidapp.live.profile.model.User;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedDetailCommentViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailOpenProfileEvent {

    @NotNull
    private final User user;

    public FeedDetailOpenProfileEvent(@NotNull User user) {
        s.i(user, "user");
        this.user = user;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }
}
