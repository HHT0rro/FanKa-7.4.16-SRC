package com.cupidapp.live.feed.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CommentResult {

    @Nullable
    private final Integer error;

    @Nullable
    private String lateCursorId;

    @Nullable
    private List<PostCommentModel> list;

    @Nullable
    private String nextCursorId;

    public CommentResult(@Nullable String str, @Nullable List<PostCommentModel> list, @Nullable String str2, @Nullable Integer num) {
        this.nextCursorId = str;
        this.list = list;
        this.lateCursorId = str2;
        this.error = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommentResult copy$default(CommentResult commentResult, String str, List list, String str2, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = commentResult.nextCursorId;
        }
        if ((i10 & 2) != 0) {
            list = commentResult.list;
        }
        if ((i10 & 4) != 0) {
            str2 = commentResult.lateCursorId;
        }
        if ((i10 & 8) != 0) {
            num = commentResult.error;
        }
        return commentResult.copy(str, list, str2, num);
    }

    @Nullable
    public final String component1() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<PostCommentModel> component2() {
        return this.list;
    }

    @Nullable
    public final String component3() {
        return this.lateCursorId;
    }

    @Nullable
    public final Integer component4() {
        return this.error;
    }

    @NotNull
    public final CommentResult copy(@Nullable String str, @Nullable List<PostCommentModel> list, @Nullable String str2, @Nullable Integer num) {
        return new CommentResult(str, list, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentResult)) {
            return false;
        }
        CommentResult commentResult = (CommentResult) obj;
        return s.d(this.nextCursorId, commentResult.nextCursorId) && s.d(this.list, commentResult.list) && s.d(this.lateCursorId, commentResult.lateCursorId) && s.d(this.error, commentResult.error);
    }

    @Nullable
    public final Integer getError() {
        return this.error;
    }

    @Nullable
    public final String getLateCursorId() {
        return this.lateCursorId;
    }

    @Nullable
    public final List<PostCommentModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    public int hashCode() {
        String str = this.nextCursorId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<PostCommentModel> list = this.list;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.lateCursorId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.error;
        return hashCode3 + (num != null ? num.hashCode() : 0);
    }

    public final void setLateCursorId(@Nullable String str) {
        this.lateCursorId = str;
    }

    public final void setList(@Nullable List<PostCommentModel> list) {
        this.list = list;
    }

    public final void setNextCursorId(@Nullable String str) {
        this.nextCursorId = str;
    }

    @NotNull
    public String toString() {
        String str = this.nextCursorId;
        List<PostCommentModel> list = this.list;
        return "CommentResult(nextCursorId=" + str + ", list=" + ((Object) list) + ", lateCursorId=" + this.lateCursorId + ", error=" + ((Object) this.error) + ")";
    }
}
