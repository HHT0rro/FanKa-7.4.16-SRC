package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveActivityItemModel implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f15097id;

    @NotNull
    private String title;

    public LiveActivityItemModel(@Nullable String str, @NotNull String title) {
        s.i(title, "title");
        this.f15097id = str;
        this.title = title;
    }

    public static /* synthetic */ LiveActivityItemModel copy$default(LiveActivityItemModel liveActivityItemModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveActivityItemModel.f15097id;
        }
        if ((i10 & 2) != 0) {
            str2 = liveActivityItemModel.title;
        }
        return liveActivityItemModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.f15097id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final LiveActivityItemModel copy(@Nullable String str, @NotNull String title) {
        s.i(title, "title");
        return new LiveActivityItemModel(str, title);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveActivityItemModel)) {
            return false;
        }
        LiveActivityItemModel liveActivityItemModel = (LiveActivityItemModel) obj;
        return s.d(this.f15097id, liveActivityItemModel.f15097id) && s.d(this.title, liveActivityItemModel.title);
    }

    @Nullable
    public final String getId() {
        return this.f15097id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.f15097id;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.title.hashCode();
    }

    public final void setTitle(@NotNull String str) {
        s.i(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "LiveActivityItemModel(id=" + this.f15097id + ", title=" + this.title + ")";
    }
}
