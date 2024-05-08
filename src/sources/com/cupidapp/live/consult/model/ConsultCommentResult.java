package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultCommentResult {

    @Nullable
    private final ConsultCommentModel comment;

    public ConsultCommentResult(@Nullable ConsultCommentModel consultCommentModel) {
        this.comment = consultCommentModel;
    }

    public static /* synthetic */ ConsultCommentResult copy$default(ConsultCommentResult consultCommentResult, ConsultCommentModel consultCommentModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            consultCommentModel = consultCommentResult.comment;
        }
        return consultCommentResult.copy(consultCommentModel);
    }

    @Nullable
    public final ConsultCommentModel component1() {
        return this.comment;
    }

    @NotNull
    public final ConsultCommentResult copy(@Nullable ConsultCommentModel consultCommentModel) {
        return new ConsultCommentResult(consultCommentModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsultCommentResult) && s.d(this.comment, ((ConsultCommentResult) obj).comment);
    }

    @Nullable
    public final ConsultCommentModel getComment() {
        return this.comment;
    }

    public int hashCode() {
        ConsultCommentModel consultCommentModel = this.comment;
        if (consultCommentModel == null) {
            return 0;
        }
        return consultCommentModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConsultCommentResult(comment=" + ((Object) this.comment) + ")";
    }
}
