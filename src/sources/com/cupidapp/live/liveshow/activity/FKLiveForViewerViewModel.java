package com.cupidapp.live.liveshow.activity;

import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveForViewerActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForViewerViewModel implements Serializable {

    @Nullable
    private final LiveInRoomSensorModel liveRoomSensor;

    @NotNull
    private final LiveShowModel liveShow;
    private final boolean needNewTask;

    @Nullable
    private final LiveshowOpenSource openSource;

    public FKLiveForViewerViewModel(@NotNull LiveShowModel liveShow, @Nullable LiveshowOpenSource liveshowOpenSource, @Nullable LiveInRoomSensorModel liveInRoomSensorModel, boolean z10) {
        s.i(liveShow, "liveShow");
        this.liveShow = liveShow;
        this.openSource = liveshowOpenSource;
        this.liveRoomSensor = liveInRoomSensorModel;
        this.needNewTask = z10;
    }

    public static /* synthetic */ FKLiveForViewerViewModel copy$default(FKLiveForViewerViewModel fKLiveForViewerViewModel, LiveShowModel liveShowModel, LiveshowOpenSource liveshowOpenSource, LiveInRoomSensorModel liveInRoomSensorModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowModel = fKLiveForViewerViewModel.liveShow;
        }
        if ((i10 & 2) != 0) {
            liveshowOpenSource = fKLiveForViewerViewModel.openSource;
        }
        if ((i10 & 4) != 0) {
            liveInRoomSensorModel = fKLiveForViewerViewModel.liveRoomSensor;
        }
        if ((i10 & 8) != 0) {
            z10 = fKLiveForViewerViewModel.needNewTask;
        }
        return fKLiveForViewerViewModel.copy(liveShowModel, liveshowOpenSource, liveInRoomSensorModel, z10);
    }

    @NotNull
    public final LiveShowModel component1() {
        return this.liveShow;
    }

    @Nullable
    public final LiveshowOpenSource component2() {
        return this.openSource;
    }

    @Nullable
    public final LiveInRoomSensorModel component3() {
        return this.liveRoomSensor;
    }

    public final boolean component4() {
        return this.needNewTask;
    }

    @NotNull
    public final FKLiveForViewerViewModel copy(@NotNull LiveShowModel liveShow, @Nullable LiveshowOpenSource liveshowOpenSource, @Nullable LiveInRoomSensorModel liveInRoomSensorModel, boolean z10) {
        s.i(liveShow, "liveShow");
        return new FKLiveForViewerViewModel(liveShow, liveshowOpenSource, liveInRoomSensorModel, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveForViewerViewModel)) {
            return false;
        }
        FKLiveForViewerViewModel fKLiveForViewerViewModel = (FKLiveForViewerViewModel) obj;
        return s.d(this.liveShow, fKLiveForViewerViewModel.liveShow) && this.openSource == fKLiveForViewerViewModel.openSource && s.d(this.liveRoomSensor, fKLiveForViewerViewModel.liveRoomSensor) && this.needNewTask == fKLiveForViewerViewModel.needNewTask;
    }

    @Nullable
    public final LiveInRoomSensorModel getLiveRoomSensor() {
        return this.liveRoomSensor;
    }

    @NotNull
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    public final boolean getNeedNewTask() {
        return this.needNewTask;
    }

    @Nullable
    public final LiveshowOpenSource getOpenSource() {
        return this.openSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.liveShow.hashCode() * 31;
        LiveshowOpenSource liveshowOpenSource = this.openSource;
        int hashCode2 = (hashCode + (liveshowOpenSource == null ? 0 : liveshowOpenSource.hashCode())) * 31;
        LiveInRoomSensorModel liveInRoomSensorModel = this.liveRoomSensor;
        int hashCode3 = (hashCode2 + (liveInRoomSensorModel != null ? liveInRoomSensorModel.hashCode() : 0)) * 31;
        boolean z10 = this.needNewTask;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode3 + i10;
    }

    @NotNull
    public String toString() {
        LiveShowModel liveShowModel = this.liveShow;
        LiveshowOpenSource liveshowOpenSource = this.openSource;
        LiveInRoomSensorModel liveInRoomSensorModel = this.liveRoomSensor;
        return "FKLiveForViewerViewModel(liveShow=" + ((Object) liveShowModel) + ", openSource=" + ((Object) liveshowOpenSource) + ", liveRoomSensor=" + ((Object) liveInRoomSensorModel) + ", needNewTask=" + this.needNewTask + ")";
    }

    public /* synthetic */ FKLiveForViewerViewModel(LiveShowModel liveShowModel, LiveshowOpenSource liveshowOpenSource, LiveInRoomSensorModel liveInRoomSensorModel, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(liveShowModel, liveshowOpenSource, (i10 & 4) != 0 ? null : liveInRoomSensorModel, (i10 & 8) != 0 ? false : z10);
    }
}
