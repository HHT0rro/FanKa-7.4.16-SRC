package com.cupidapp.live.feed.holder;

import com.cupidapp.live.feed.model.PostCommentModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedDetailShowMoreCommentViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailShowMoreCommentViewModel {

    @NotNull
    private final PostCommentModel firstCommentModel;

    @Nullable
    private String nextLevelCursor;

    @Nullable
    private final Integer notLoadCommentCount;
    private boolean showMoreText;

    public FeedDetailShowMoreCommentViewModel(@NotNull PostCommentModel firstCommentModel, @Nullable String str, boolean z10, @Nullable Integer num) {
        s.i(firstCommentModel, "firstCommentModel");
        this.firstCommentModel = firstCommentModel;
        this.nextLevelCursor = str;
        this.showMoreText = z10;
        this.notLoadCommentCount = num;
    }

    @NotNull
    public final PostCommentModel getFirstCommentModel() {
        return this.firstCommentModel;
    }

    @Nullable
    public final String getNextLevelCursor() {
        return this.nextLevelCursor;
    }

    @Nullable
    public final Integer getNotLoadCommentCount() {
        return this.notLoadCommentCount;
    }

    public final boolean getShowMoreText() {
        return this.showMoreText;
    }

    public final void setNextLevelCursor(@Nullable String str) {
        this.nextLevelCursor = str;
    }

    public final void setShowMoreText(boolean z10) {
        this.showMoreText = z10;
    }

    public /* synthetic */ FeedDetailShowMoreCommentViewModel(PostCommentModel postCommentModel, String str, boolean z10, Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(postCommentModel, str, (i10 & 4) != 0 ? true : z10, (i10 & 8) != 0 ? 0 : num);
    }
}
