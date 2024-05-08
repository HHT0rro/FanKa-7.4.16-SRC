package com.cupidapp.live.liveshow.view.shake;

import com.cupidapp.live.liveshow.model.CommentModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShakeAnimationLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class InsertShakeCommentEvent {

    @NotNull
    private final CommentModel comment;

    public InsertShakeCommentEvent(@NotNull CommentModel comment) {
        s.i(comment, "comment");
        this.comment = comment;
    }

    public static /* synthetic */ InsertShakeCommentEvent copy$default(InsertShakeCommentEvent insertShakeCommentEvent, CommentModel commentModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            commentModel = insertShakeCommentEvent.comment;
        }
        return insertShakeCommentEvent.copy(commentModel);
    }

    @NotNull
    public final CommentModel component1() {
        return this.comment;
    }

    @NotNull
    public final InsertShakeCommentEvent copy(@NotNull CommentModel comment) {
        s.i(comment, "comment");
        return new InsertShakeCommentEvent(comment);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InsertShakeCommentEvent) && s.d(this.comment, ((InsertShakeCommentEvent) obj).comment);
    }

    @NotNull
    public final CommentModel getComment() {
        return this.comment;
    }

    public int hashCode() {
        return this.comment.hashCode();
    }

    @NotNull
    public String toString() {
        return "InsertShakeCommentEvent(comment=" + ((Object) this.comment) + ")";
    }
}
