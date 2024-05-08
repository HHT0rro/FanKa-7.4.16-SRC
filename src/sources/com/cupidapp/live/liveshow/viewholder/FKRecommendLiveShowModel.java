package com.cupidapp.live.liveshow.viewholder;

import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKRecommendLiveListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKRecommendLiveShowModel {

    @NotNull
    private final SensorsLogLiveShow.EnterLiveShowSource enterSource;

    @NotNull
    private final LiveShowModel liveShow;
    private boolean showLiveData;

    public FKRecommendLiveShowModel(@NotNull LiveShowModel liveShow, @NotNull SensorsLogLiveShow.EnterLiveShowSource enterSource, boolean z10) {
        s.i(liveShow, "liveShow");
        s.i(enterSource, "enterSource");
        this.liveShow = liveShow;
        this.enterSource = enterSource;
        this.showLiveData = z10;
    }

    public static /* synthetic */ FKRecommendLiveShowModel copy$default(FKRecommendLiveShowModel fKRecommendLiveShowModel, LiveShowModel liveShowModel, SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowModel = fKRecommendLiveShowModel.liveShow;
        }
        if ((i10 & 2) != 0) {
            enterLiveShowSource = fKRecommendLiveShowModel.enterSource;
        }
        if ((i10 & 4) != 0) {
            z10 = fKRecommendLiveShowModel.showLiveData;
        }
        return fKRecommendLiveShowModel.copy(liveShowModel, enterLiveShowSource, z10);
    }

    @NotNull
    public final LiveShowModel component1() {
        return this.liveShow;
    }

    @NotNull
    public final SensorsLogLiveShow.EnterLiveShowSource component2() {
        return this.enterSource;
    }

    public final boolean component3() {
        return this.showLiveData;
    }

    @NotNull
    public final FKRecommendLiveShowModel copy(@NotNull LiveShowModel liveShow, @NotNull SensorsLogLiveShow.EnterLiveShowSource enterSource, boolean z10) {
        s.i(liveShow, "liveShow");
        s.i(enterSource, "enterSource");
        return new FKRecommendLiveShowModel(liveShow, enterSource, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKRecommendLiveShowModel)) {
            return false;
        }
        FKRecommendLiveShowModel fKRecommendLiveShowModel = (FKRecommendLiveShowModel) obj;
        return s.d(this.liveShow, fKRecommendLiveShowModel.liveShow) && this.enterSource == fKRecommendLiveShowModel.enterSource && this.showLiveData == fKRecommendLiveShowModel.showLiveData;
    }

    @NotNull
    public final SensorsLogLiveShow.EnterLiveShowSource getEnterSource() {
        return this.enterSource;
    }

    @NotNull
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    public final boolean getShowLiveData() {
        return this.showLiveData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.liveShow.hashCode() * 31) + this.enterSource.hashCode()) * 31;
        boolean z10 = this.showLiveData;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setShowLiveData(boolean z10) {
        this.showLiveData = z10;
    }

    @NotNull
    public String toString() {
        LiveShowModel liveShowModel = this.liveShow;
        SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource = this.enterSource;
        return "FKRecommendLiveShowModel(liveShow=" + ((Object) liveShowModel) + ", enterSource=" + ((Object) enterLiveShowSource) + ", showLiveData=" + this.showLiveData + ")";
    }

    public /* synthetic */ FKRecommendLiveShowModel(LiveShowModel liveShowModel, SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(liveShowModel, enterLiveShowSource, (i10 & 4) != 0 ? false : z10);
    }
}
