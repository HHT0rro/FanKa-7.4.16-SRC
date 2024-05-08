package com.cupidapp.live.liveshow.viewholder;

import com.cupidapp.live.liveshow.model.LiveShowModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveStreamViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveStreamModel {

    @NotNull
    private final LiveShowModel liveShow;

    public LiveStreamModel(@NotNull LiveShowModel liveShow) {
        s.i(liveShow, "liveShow");
        this.liveShow = liveShow;
    }

    public static /* synthetic */ LiveStreamModel copy$default(LiveStreamModel liveStreamModel, LiveShowModel liveShowModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowModel = liveStreamModel.liveShow;
        }
        return liveStreamModel.copy(liveShowModel);
    }

    @NotNull
    public final LiveShowModel component1() {
        return this.liveShow;
    }

    @NotNull
    public final LiveStreamModel copy(@NotNull LiveShowModel liveShow) {
        s.i(liveShow, "liveShow");
        return new LiveStreamModel(liveShow);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveStreamModel) && s.d(this.liveShow, ((LiveStreamModel) obj).liveShow);
    }

    @NotNull
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    public int hashCode() {
        return this.liveShow.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveStreamModel(liveShow=" + ((Object) this.liveShow) + ")";
    }
}
