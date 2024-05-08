package com.cupidapp.live.mentionuser.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AtUserModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AtUserTitleUIModel {

    @NotNull
    private final String title;

    public AtUserTitleUIModel(@NotNull String title) {
        s.i(title, "title");
        this.title = title;
    }

    public static /* synthetic */ AtUserTitleUIModel copy$default(AtUserTitleUIModel atUserTitleUIModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = atUserTitleUIModel.title;
        }
        return atUserTitleUIModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final AtUserTitleUIModel copy(@NotNull String title) {
        s.i(title, "title");
        return new AtUserTitleUIModel(title);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AtUserTitleUIModel) && s.d(this.title, ((AtUserTitleUIModel) obj).title);
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
        return "AtUserTitleUIModel(title=" + this.title + ")";
    }
}
