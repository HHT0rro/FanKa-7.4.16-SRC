package com.cupidapp.live.profile.event;

import com.cupidapp.live.liveshow.model.LiveShowModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UpdateLiveShowEvent {

    @NotNull
    private final LiveShowModel liveShow;

    public UpdateLiveShowEvent(@NotNull LiveShowModel liveShow) {
        s.i(liveShow, "liveShow");
        this.liveShow = liveShow;
    }

    public static /* synthetic */ UpdateLiveShowEvent copy$default(UpdateLiveShowEvent updateLiveShowEvent, LiveShowModel liveShowModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowModel = updateLiveShowEvent.liveShow;
        }
        return updateLiveShowEvent.copy(liveShowModel);
    }

    @NotNull
    public final LiveShowModel component1() {
        return this.liveShow;
    }

    @NotNull
    public final UpdateLiveShowEvent copy(@NotNull LiveShowModel liveShow) {
        s.i(liveShow, "liveShow");
        return new UpdateLiveShowEvent(liveShow);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdateLiveShowEvent) && s.d(this.liveShow, ((UpdateLiveShowEvent) obj).liveShow);
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
        return "UpdateLiveShowEvent(liveShow=" + ((Object) this.liveShow) + ")";
    }
}
