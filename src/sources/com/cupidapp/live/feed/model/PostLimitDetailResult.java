package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitFriendsModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitDetailResult {

    @Nullable
    private final PostLimitDetailModel postLimit;

    public PostLimitDetailResult() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public PostLimitDetailResult(@Nullable PostLimitDetailModel postLimitDetailModel) {
        this.postLimit = postLimitDetailModel;
    }

    public static /* synthetic */ PostLimitDetailResult copy$default(PostLimitDetailResult postLimitDetailResult, PostLimitDetailModel postLimitDetailModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            postLimitDetailModel = postLimitDetailResult.postLimit;
        }
        return postLimitDetailResult.copy(postLimitDetailModel);
    }

    @Nullable
    public final PostLimitDetailModel component1() {
        return this.postLimit;
    }

    @NotNull
    public final PostLimitDetailResult copy(@Nullable PostLimitDetailModel postLimitDetailModel) {
        return new PostLimitDetailResult(postLimitDetailModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PostLimitDetailResult) && s.d(this.postLimit, ((PostLimitDetailResult) obj).postLimit);
    }

    @Nullable
    public final PostLimitDetailModel getPostLimit() {
        return this.postLimit;
    }

    public int hashCode() {
        PostLimitDetailModel postLimitDetailModel = this.postLimit;
        if (postLimitDetailModel == null) {
            return 0;
        }
        return postLimitDetailModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "PostLimitDetailResult(postLimit=" + ((Object) this.postLimit) + ")";
    }

    public /* synthetic */ PostLimitDetailResult(PostLimitDetailModel postLimitDetailModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : postLimitDetailModel);
    }
}
