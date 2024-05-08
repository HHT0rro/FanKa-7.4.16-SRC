package com.cupidapp.live.liveshow.view.comment;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveCommentQuickChatLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCommentQuickChatModel {

    @NotNull
    private final String message;

    public LiveCommentQuickChatModel(@NotNull String message) {
        s.i(message, "message");
        this.message = message;
    }

    public static /* synthetic */ LiveCommentQuickChatModel copy$default(LiveCommentQuickChatModel liveCommentQuickChatModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveCommentQuickChatModel.message;
        }
        return liveCommentQuickChatModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final LiveCommentQuickChatModel copy(@NotNull String message) {
        s.i(message, "message");
        return new LiveCommentQuickChatModel(message);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveCommentQuickChatModel) && s.d(this.message, ((LiveCommentQuickChatModel) obj).message);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveCommentQuickChatModel(message=" + this.message + ")";
    }
}
