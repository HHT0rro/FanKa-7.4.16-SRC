package com.cupidapp.live.feed.layout;

import com.cupidapp.live.feed.model.PostCommentModel;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedDetailEditTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailClickCommentItemTagModel {
    private final int clickItemIndex;

    @NotNull
    private final PostCommentModel commentModel;

    public FeedDetailClickCommentItemTagModel(int i10, @NotNull PostCommentModel commentModel) {
        kotlin.jvm.internal.s.i(commentModel, "commentModel");
        this.clickItemIndex = i10;
        this.commentModel = commentModel;
    }

    public final int getClickItemIndex() {
        return this.clickItemIndex;
    }

    @NotNull
    public final PostCommentModel getCommentModel() {
        return this.commentModel;
    }
}
