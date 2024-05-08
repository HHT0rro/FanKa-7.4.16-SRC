package com.cupidapp.live.liveshow.model;

import b2.a;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCommentResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CommentResult {
    private final long balance;
    private final int barrageCardCount;

    @Nullable
    private final String barrageHintText;

    @NotNull
    private final CommentModel comment;
    private final boolean commentInvalid;

    public CommentResult(@NotNull CommentModel comment, long j10, @Nullable String str, boolean z10, int i10) {
        s.i(comment, "comment");
        this.comment = comment;
        this.balance = j10;
        this.barrageHintText = str;
        this.commentInvalid = z10;
        this.barrageCardCount = i10;
    }

    public static /* synthetic */ CommentResult copy$default(CommentResult commentResult, CommentModel commentModel, long j10, String str, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            commentModel = commentResult.comment;
        }
        if ((i11 & 2) != 0) {
            j10 = commentResult.balance;
        }
        long j11 = j10;
        if ((i11 & 4) != 0) {
            str = commentResult.barrageHintText;
        }
        String str2 = str;
        if ((i11 & 8) != 0) {
            z10 = commentResult.commentInvalid;
        }
        boolean z11 = z10;
        if ((i11 & 16) != 0) {
            i10 = commentResult.barrageCardCount;
        }
        return commentResult.copy(commentModel, j11, str2, z11, i10);
    }

    @NotNull
    public final CommentModel component1() {
        return this.comment;
    }

    public final long component2() {
        return this.balance;
    }

    @Nullable
    public final String component3() {
        return this.barrageHintText;
    }

    public final boolean component4() {
        return this.commentInvalid;
    }

    public final int component5() {
        return this.barrageCardCount;
    }

    @NotNull
    public final CommentResult copy(@NotNull CommentModel comment, long j10, @Nullable String str, boolean z10, int i10) {
        s.i(comment, "comment");
        return new CommentResult(comment, j10, str, z10, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentResult)) {
            return false;
        }
        CommentResult commentResult = (CommentResult) obj;
        return s.d(this.comment, commentResult.comment) && this.balance == commentResult.balance && s.d(this.barrageHintText, commentResult.barrageHintText) && this.commentInvalid == commentResult.commentInvalid && this.barrageCardCount == commentResult.barrageCardCount;
    }

    public final long getBalance() {
        return this.balance;
    }

    public final int getBarrageCardCount() {
        return this.barrageCardCount;
    }

    @Nullable
    public final String getBarrageHintText() {
        return this.barrageHintText;
    }

    @NotNull
    public final CommentModel getComment() {
        return this.comment;
    }

    public final boolean getCommentInvalid() {
        return this.commentInvalid;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.comment.hashCode() * 31) + a.a(this.balance)) * 31;
        String str = this.barrageHintText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.commentInvalid;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode2 + i10) * 31) + this.barrageCardCount;
    }

    @NotNull
    public String toString() {
        CommentModel commentModel = this.comment;
        return "CommentResult(comment=" + ((Object) commentModel) + ", balance=" + this.balance + ", barrageHintText=" + this.barrageHintText + ", commentInvalid=" + this.commentInvalid + ", barrageCardCount=" + this.barrageCardCount + ")";
    }
}
