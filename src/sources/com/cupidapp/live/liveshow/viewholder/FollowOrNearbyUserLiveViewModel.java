package com.cupidapp.live.liveshow.viewholder;

import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.adapter.FKFollowOrNearbyLiveShowModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFollowOrNearbyUserLiveViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FollowOrNearbyUserLiveViewModel {

    @NotNull
    private final SensorsLogLiveShow.EnterLiveShowSource enterSource;
    private final boolean haveMore;

    @NotNull
    private final List<FKFollowOrNearbyLiveShowModel> liveList;

    @Nullable
    private final String title;

    public FollowOrNearbyUserLiveViewModel(@Nullable String str, @NotNull List<FKFollowOrNearbyLiveShowModel> liveList, @NotNull SensorsLogLiveShow.EnterLiveShowSource enterSource, boolean z10) {
        s.i(liveList, "liveList");
        s.i(enterSource, "enterSource");
        this.title = str;
        this.liveList = liveList;
        this.enterSource = enterSource;
        this.haveMore = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FollowOrNearbyUserLiveViewModel copy$default(FollowOrNearbyUserLiveViewModel followOrNearbyUserLiveViewModel, String str, List list, SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = followOrNearbyUserLiveViewModel.title;
        }
        if ((i10 & 2) != 0) {
            list = followOrNearbyUserLiveViewModel.liveList;
        }
        if ((i10 & 4) != 0) {
            enterLiveShowSource = followOrNearbyUserLiveViewModel.enterSource;
        }
        if ((i10 & 8) != 0) {
            z10 = followOrNearbyUserLiveViewModel.haveMore;
        }
        return followOrNearbyUserLiveViewModel.copy(str, list, enterLiveShowSource, z10);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<FKFollowOrNearbyLiveShowModel> component2() {
        return this.liveList;
    }

    @NotNull
    public final SensorsLogLiveShow.EnterLiveShowSource component3() {
        return this.enterSource;
    }

    public final boolean component4() {
        return this.haveMore;
    }

    @NotNull
    public final FollowOrNearbyUserLiveViewModel copy(@Nullable String str, @NotNull List<FKFollowOrNearbyLiveShowModel> liveList, @NotNull SensorsLogLiveShow.EnterLiveShowSource enterSource, boolean z10) {
        s.i(liveList, "liveList");
        s.i(enterSource, "enterSource");
        return new FollowOrNearbyUserLiveViewModel(str, liveList, enterSource, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowOrNearbyUserLiveViewModel)) {
            return false;
        }
        FollowOrNearbyUserLiveViewModel followOrNearbyUserLiveViewModel = (FollowOrNearbyUserLiveViewModel) obj;
        return s.d(this.title, followOrNearbyUserLiveViewModel.title) && s.d(this.liveList, followOrNearbyUserLiveViewModel.liveList) && this.enterSource == followOrNearbyUserLiveViewModel.enterSource && this.haveMore == followOrNearbyUserLiveViewModel.haveMore;
    }

    @NotNull
    public final SensorsLogLiveShow.EnterLiveShowSource getEnterSource() {
        return this.enterSource;
    }

    public final boolean getHaveMore() {
        return this.haveMore;
    }

    @NotNull
    public final List<FKFollowOrNearbyLiveShowModel> getLiveList() {
        return this.liveList;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.title;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.liveList.hashCode()) * 31) + this.enterSource.hashCode()) * 31;
        boolean z10 = this.haveMore;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        List<FKFollowOrNearbyLiveShowModel> list = this.liveList;
        SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource = this.enterSource;
        return "FollowOrNearbyUserLiveViewModel(title=" + str + ", liveList=" + ((Object) list) + ", enterSource=" + ((Object) enterLiveShowSource) + ", haveMore=" + this.haveMore + ")";
    }
}
