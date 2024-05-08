package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveAnimationModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowShakeResult {

    @Nullable
    private final LiveShowAnimationModel animation;

    @Nullable
    private final CommentModel comment;

    public LiveShowShakeResult(@Nullable CommentModel commentModel, @Nullable LiveShowAnimationModel liveShowAnimationModel) {
        this.comment = commentModel;
        this.animation = liveShowAnimationModel;
    }

    public static /* synthetic */ LiveShowShakeResult copy$default(LiveShowShakeResult liveShowShakeResult, CommentModel commentModel, LiveShowAnimationModel liveShowAnimationModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            commentModel = liveShowShakeResult.comment;
        }
        if ((i10 & 2) != 0) {
            liveShowAnimationModel = liveShowShakeResult.animation;
        }
        return liveShowShakeResult.copy(commentModel, liveShowAnimationModel);
    }

    @Nullable
    public final CommentModel component1() {
        return this.comment;
    }

    @Nullable
    public final LiveShowAnimationModel component2() {
        return this.animation;
    }

    @NotNull
    public final LiveShowShakeResult copy(@Nullable CommentModel commentModel, @Nullable LiveShowAnimationModel liveShowAnimationModel) {
        return new LiveShowShakeResult(commentModel, liveShowAnimationModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowShakeResult)) {
            return false;
        }
        LiveShowShakeResult liveShowShakeResult = (LiveShowShakeResult) obj;
        return s.d(this.comment, liveShowShakeResult.comment) && s.d(this.animation, liveShowShakeResult.animation);
    }

    @Nullable
    public final LiveShowAnimationModel getAnimation() {
        return this.animation;
    }

    @Nullable
    public final CommentModel getComment() {
        return this.comment;
    }

    public int hashCode() {
        CommentModel commentModel = this.comment;
        int hashCode = (commentModel == null ? 0 : commentModel.hashCode()) * 31;
        LiveShowAnimationModel liveShowAnimationModel = this.animation;
        return hashCode + (liveShowAnimationModel != null ? liveShowAnimationModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveShowShakeResult(comment=" + ((Object) this.comment) + ", animation=" + ((Object) this.animation) + ")";
    }
}
