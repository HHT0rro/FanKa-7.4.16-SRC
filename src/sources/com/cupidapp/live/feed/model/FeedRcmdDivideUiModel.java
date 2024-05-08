package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedRcmdDivideUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRcmdDivideUiModel {

    @NotNull
    private final String title;

    public FeedRcmdDivideUiModel(@NotNull String title) {
        s.i(title, "title");
        this.title = title;
    }

    public static /* synthetic */ FeedRcmdDivideUiModel copy$default(FeedRcmdDivideUiModel feedRcmdDivideUiModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedRcmdDivideUiModel.title;
        }
        return feedRcmdDivideUiModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final FeedRcmdDivideUiModel copy(@NotNull String title) {
        s.i(title, "title");
        return new FeedRcmdDivideUiModel(title);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedRcmdDivideUiModel) && s.d(this.title, ((FeedRcmdDivideUiModel) obj).title);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.title.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedRcmdDivideUiModel(title=" + this.title + ")";
    }
}
