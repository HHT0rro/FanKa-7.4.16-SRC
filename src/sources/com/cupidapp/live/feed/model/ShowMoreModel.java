package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShowMoreModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShowMoreModel {

    @NotNull
    private final String content;

    public ShowMoreModel(@NotNull String content) {
        s.i(content, "content");
        this.content = content;
    }

    public static /* synthetic */ ShowMoreModel copy$default(ShowMoreModel showMoreModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = showMoreModel.content;
        }
        return showMoreModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.content;
    }

    @NotNull
    public final ShowMoreModel copy(@NotNull String content) {
        s.i(content, "content");
        return new ShowMoreModel(content);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShowMoreModel) && s.d(this.content, ((ShowMoreModel) obj).content);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShowMoreModel(content=" + this.content + ")";
    }
}
