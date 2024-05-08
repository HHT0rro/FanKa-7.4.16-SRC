package com.cupidapp.live.base.network.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePathModel {

    @Nullable
    private final List<LiveRankModel> rankNav;

    public LivePathModel(@Nullable List<LiveRankModel> list) {
        this.rankNav = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivePathModel copy$default(LivePathModel livePathModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = livePathModel.rankNav;
        }
        return livePathModel.copy(list);
    }

    @Nullable
    public final List<LiveRankModel> component1() {
        return this.rankNav;
    }

    @NotNull
    public final LivePathModel copy(@Nullable List<LiveRankModel> list) {
        return new LivePathModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LivePathModel) && s.d(this.rankNav, ((LivePathModel) obj).rankNav);
    }

    @Nullable
    public final List<LiveRankModel> getRankNav() {
        return this.rankNav;
    }

    public int hashCode() {
        List<LiveRankModel> list = this.rankNav;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "LivePathModel(rankNav=" + ((Object) this.rankNav) + ")";
    }
}
