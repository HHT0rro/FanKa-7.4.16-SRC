package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveEndModel {

    @NotNull
    private final AnchorModel anchorInfo;

    @Nullable
    private final List<LiveShowModel> rcmdLiveShows;

    public LiveEndModel(@NotNull AnchorModel anchorInfo, @Nullable List<LiveShowModel> list) {
        s.i(anchorInfo, "anchorInfo");
        this.anchorInfo = anchorInfo;
        this.rcmdLiveShows = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveEndModel copy$default(LiveEndModel liveEndModel, AnchorModel anchorModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            anchorModel = liveEndModel.anchorInfo;
        }
        if ((i10 & 2) != 0) {
            list = liveEndModel.rcmdLiveShows;
        }
        return liveEndModel.copy(anchorModel, list);
    }

    @NotNull
    public final AnchorModel component1() {
        return this.anchorInfo;
    }

    @Nullable
    public final List<LiveShowModel> component2() {
        return this.rcmdLiveShows;
    }

    @NotNull
    public final LiveEndModel copy(@NotNull AnchorModel anchorInfo, @Nullable List<LiveShowModel> list) {
        s.i(anchorInfo, "anchorInfo");
        return new LiveEndModel(anchorInfo, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveEndModel)) {
            return false;
        }
        LiveEndModel liveEndModel = (LiveEndModel) obj;
        return s.d(this.anchorInfo, liveEndModel.anchorInfo) && s.d(this.rcmdLiveShows, liveEndModel.rcmdLiveShows);
    }

    @NotNull
    public final AnchorModel getAnchorInfo() {
        return this.anchorInfo;
    }

    @Nullable
    public final List<LiveShowModel> getRcmdLiveShows() {
        return this.rcmdLiveShows;
    }

    public int hashCode() {
        int hashCode = this.anchorInfo.hashCode() * 31;
        List<LiveShowModel> list = this.rcmdLiveShows;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "LiveEndModel(anchorInfo=" + ((Object) this.anchorInfo) + ", rcmdLiveShows=" + ((Object) this.rcmdLiveShows) + ")";
    }
}
