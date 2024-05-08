package com.cupidapp.live.feed.holder;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedDetailCommentViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenFeedDetailEvent {

    @NotNull
    private final String postId;

    public OpenFeedDetailEvent(@NotNull String postId) {
        s.i(postId, "postId");
        this.postId = postId;
    }

    @NotNull
    public final String getPostId() {
        return this.postId;
    }
}
