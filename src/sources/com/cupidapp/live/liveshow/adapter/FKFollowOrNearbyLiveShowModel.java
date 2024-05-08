package com.cupidapp.live.liveshow.adapter;

import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFollowOrNearbyLiveShowAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFollowOrNearbyLiveShowModel {

    @NotNull
    private final SensorsLogLiveShow.EnterLiveShowSource enterSource;

    @NotNull
    private final LiveShowModel liveShow;

    public FKFollowOrNearbyLiveShowModel(@NotNull LiveShowModel liveShow, @NotNull SensorsLogLiveShow.EnterLiveShowSource enterSource) {
        s.i(liveShow, "liveShow");
        s.i(enterSource, "enterSource");
        this.liveShow = liveShow;
        this.enterSource = enterSource;
    }

    public static /* synthetic */ FKFollowOrNearbyLiveShowModel copy$default(FKFollowOrNearbyLiveShowModel fKFollowOrNearbyLiveShowModel, LiveShowModel liveShowModel, SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowModel = fKFollowOrNearbyLiveShowModel.liveShow;
        }
        if ((i10 & 2) != 0) {
            enterLiveShowSource = fKFollowOrNearbyLiveShowModel.enterSource;
        }
        return fKFollowOrNearbyLiveShowModel.copy(liveShowModel, enterLiveShowSource);
    }

    @NotNull
    public final LiveShowModel component1() {
        return this.liveShow;
    }

    @NotNull
    public final SensorsLogLiveShow.EnterLiveShowSource component2() {
        return this.enterSource;
    }

    @NotNull
    public final FKFollowOrNearbyLiveShowModel copy(@NotNull LiveShowModel liveShow, @NotNull SensorsLogLiveShow.EnterLiveShowSource enterSource) {
        s.i(liveShow, "liveShow");
        s.i(enterSource, "enterSource");
        return new FKFollowOrNearbyLiveShowModel(liveShow, enterSource);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKFollowOrNearbyLiveShowModel)) {
            return false;
        }
        FKFollowOrNearbyLiveShowModel fKFollowOrNearbyLiveShowModel = (FKFollowOrNearbyLiveShowModel) obj;
        return s.d(this.liveShow, fKFollowOrNearbyLiveShowModel.liveShow) && this.enterSource == fKFollowOrNearbyLiveShowModel.enterSource;
    }

    @NotNull
    public final SensorsLogLiveShow.EnterLiveShowSource getEnterSource() {
        return this.enterSource;
    }

    @NotNull
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    public int hashCode() {
        return (this.liveShow.hashCode() * 31) + this.enterSource.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKFollowOrNearbyLiveShowModel(liveShow=" + ((Object) this.liveShow) + ", enterSource=" + ((Object) this.enterSource) + ")";
    }
}
