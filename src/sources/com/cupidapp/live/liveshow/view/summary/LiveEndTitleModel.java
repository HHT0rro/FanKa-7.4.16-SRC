package com.cupidapp.live.liveshow.view.summary;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveEndAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveEndTitleModel {

    @NotNull
    private final String title;

    public LiveEndTitleModel(@NotNull String title) {
        s.i(title, "title");
        this.title = title;
    }

    public static /* synthetic */ LiveEndTitleModel copy$default(LiveEndTitleModel liveEndTitleModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveEndTitleModel.title;
        }
        return liveEndTitleModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final LiveEndTitleModel copy(@NotNull String title) {
        s.i(title, "title");
        return new LiveEndTitleModel(title);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveEndTitleModel) && s.d(this.title, ((LiveEndTitleModel) obj).title);
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
        return "LiveEndTitleModel(title=" + this.title + ")";
    }
}
