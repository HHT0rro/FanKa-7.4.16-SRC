package com.cupidapp.live.feed.holder;

import com.cupidapp.live.feed.model.FeedModel;
import org.jetbrains.annotations.Nullable;

/* compiled from: CommentTitleViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailCommentTitleModel {

    @Nullable
    private FeedModel feedModel;

    public FeedDetailCommentTitleModel(@Nullable FeedModel feedModel) {
        this.feedModel = feedModel;
    }

    @Nullable
    public final FeedModel getFeedModel() {
        return this.feedModel;
    }

    public final void setFeedModel(@Nullable FeedModel feedModel) {
        this.feedModel = feedModel;
    }
}
