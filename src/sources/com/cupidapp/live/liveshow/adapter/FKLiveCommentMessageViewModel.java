package com.cupidapp.live.liveshow.adapter;

import com.cupidapp.live.liveshow.model.CommentModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCommentAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveCommentMessageViewModel implements FKLiveMessageViewModel {
    private final boolean commentInvalid;

    @NotNull
    private final CommentModel commentModel;

    public FKLiveCommentMessageViewModel(@NotNull CommentModel commentModel, boolean z10) {
        s.i(commentModel, "commentModel");
        this.commentModel = commentModel;
        this.commentInvalid = z10;
    }

    public static /* synthetic */ FKLiveCommentMessageViewModel copy$default(FKLiveCommentMessageViewModel fKLiveCommentMessageViewModel, CommentModel commentModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            commentModel = fKLiveCommentMessageViewModel.commentModel;
        }
        if ((i10 & 2) != 0) {
            z10 = fKLiveCommentMessageViewModel.commentInvalid;
        }
        return fKLiveCommentMessageViewModel.copy(commentModel, z10);
    }

    @NotNull
    public final CommentModel component1() {
        return this.commentModel;
    }

    public final boolean component2() {
        return this.commentInvalid;
    }

    @NotNull
    public final FKLiveCommentMessageViewModel copy(@NotNull CommentModel commentModel, boolean z10) {
        s.i(commentModel, "commentModel");
        return new FKLiveCommentMessageViewModel(commentModel, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveCommentMessageViewModel)) {
            return false;
        }
        FKLiveCommentMessageViewModel fKLiveCommentMessageViewModel = (FKLiveCommentMessageViewModel) obj;
        return s.d(this.commentModel, fKLiveCommentMessageViewModel.commentModel) && this.commentInvalid == fKLiveCommentMessageViewModel.commentInvalid;
    }

    public final boolean getCommentInvalid() {
        return this.commentInvalid;
    }

    @NotNull
    public final CommentModel getCommentModel() {
        return this.commentModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.commentModel.hashCode() * 31;
        boolean z10 = this.commentInvalid;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        CommentModel commentModel = this.commentModel;
        return "FKLiveCommentMessageViewModel(commentModel=" + ((Object) commentModel) + ", commentInvalid=" + this.commentInvalid + ")";
    }

    public /* synthetic */ FKLiveCommentMessageViewModel(CommentModel commentModel, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(commentModel, (i10 & 2) != 0 ? false : z10);
    }
}
