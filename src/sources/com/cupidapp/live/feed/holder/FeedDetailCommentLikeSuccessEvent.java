package com.cupidapp.live.feed.holder;

import com.cupidapp.live.feed.model.PostCommentModel;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedDetailCommentViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailCommentLikeSuccessEvent {

    @NotNull
    private final PostCommentModel commentModel;

    public FeedDetailCommentLikeSuccessEvent(@NotNull PostCommentModel commentModel) {
        s.i(commentModel, "commentModel");
        this.commentModel = commentModel;
    }

    @NotNull
    public final PostCommentModel getCommentModel() {
        return this.commentModel;
    }
}
