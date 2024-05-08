package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveRankModel {

    @NotNull
    private final String title;

    @NotNull
    private final String url;

    public LiveRankModel(@NotNull String title, @NotNull String url) {
        s.i(title, "title");
        s.i(url, "url");
        this.title = title;
        this.url = url;
    }

    public static /* synthetic */ LiveRankModel copy$default(LiveRankModel liveRankModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveRankModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = liveRankModel.url;
        }
        return liveRankModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final LiveRankModel copy(@NotNull String title, @NotNull String url) {
        s.i(title, "title");
        s.i(url, "url");
        return new LiveRankModel(title, url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveRankModel)) {
            return false;
        }
        LiveRankModel liveRankModel = (LiveRankModel) obj;
        return s.d(this.title, liveRankModel.title) && s.d(this.url, liveRankModel.url);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveRankModel(title=" + this.title + ", url=" + this.url + ")";
    }
}
