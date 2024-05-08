package com.cupidapp.live.liveshow.view.comment;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowCommentEditTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShowCommentEvent {
    private final int type;

    public ShowCommentEvent(int i10) {
        this.type = i10;
    }

    public static /* synthetic */ ShowCommentEvent copy$default(ShowCommentEvent showCommentEvent, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = showCommentEvent.type;
        }
        return showCommentEvent.copy(i10);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final ShowCommentEvent copy(int i10) {
        return new ShowCommentEvent(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShowCommentEvent) && this.type == ((ShowCommentEvent) obj).type;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "ShowCommentEvent(type=" + this.type + ")";
    }
}
