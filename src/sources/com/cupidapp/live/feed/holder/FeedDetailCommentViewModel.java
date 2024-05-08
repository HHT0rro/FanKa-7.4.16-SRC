package com.cupidapp.live.feed.holder;

import com.cupidapp.live.feed.model.PostCommentModel;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedDetailCommentViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailCommentViewModel {

    @NotNull
    private final PostCommentModel commentModel;

    @NotNull
    private final String postId;

    public FeedDetailCommentViewModel(@NotNull String postId, @NotNull PostCommentModel commentModel) {
        s.i(postId, "postId");
        s.i(commentModel, "commentModel");
        this.postId = postId;
        this.commentModel = commentModel;
    }

    @NotNull
    public final PostCommentModel getCommentModel() {
        return this.commentModel;
    }

    @NotNull
    public final String getPostId() {
        return this.postId;
    }
}
