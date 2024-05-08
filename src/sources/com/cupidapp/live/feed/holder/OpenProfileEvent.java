package com.cupidapp.live.feed.holder;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedDetailCommentViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenProfileEvent {

    @NotNull
    private final String userId;

    public OpenProfileEvent(@NotNull String userId) {
        s.i(userId, "userId");
        this.userId = userId;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }
}
