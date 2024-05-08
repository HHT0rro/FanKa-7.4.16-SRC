package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowPkWarResult {

    @Nullable
    private final LiveShowModel liveShow;

    @Nullable
    private final String pkContributionPath;

    @Nullable
    private final LiveShowModel pkLiveShow;
    private final int pkTodayHangupCount;

    @Nullable
    private final Map<String, List<User>> sofa;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveShowPkWarResult(@Nullable LiveShowModel liveShowModel, @Nullable LiveShowModel liveShowModel2, @Nullable Map<String, ? extends List<User>> map, int i10, @Nullable String str) {
        this.liveShow = liveShowModel;
        this.pkLiveShow = liveShowModel2;
        this.sofa = map;
        this.pkTodayHangupCount = i10;
        this.pkContributionPath = str;
    }

    public static /* synthetic */ LiveShowPkWarResult copy$default(LiveShowPkWarResult liveShowPkWarResult, LiveShowModel liveShowModel, LiveShowModel liveShowModel2, Map map, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            liveShowModel = liveShowPkWarResult.liveShow;
        }
        if ((i11 & 2) != 0) {
            liveShowModel2 = liveShowPkWarResult.pkLiveShow;
        }
        LiveShowModel liveShowModel3 = liveShowModel2;
        if ((i11 & 4) != 0) {
            map = liveShowPkWarResult.sofa;
        }
        Map map2 = map;
        if ((i11 & 8) != 0) {
            i10 = liveShowPkWarResult.pkTodayHangupCount;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            str = liveShowPkWarResult.pkContributionPath;
        }
        return liveShowPkWarResult.copy(liveShowModel, liveShowModel3, map2, i12, str);
    }

    @Nullable
    public final LiveShowModel component1() {
        return this.liveShow;
    }

    @Nullable
    public final LiveShowModel component2() {
        return this.pkLiveShow;
    }

    @Nullable
    public final Map<String, List<User>> component3() {
        return this.sofa;
    }

    public final int component4() {
        return this.pkTodayHangupCount;
    }

    @Nullable
    public final String component5() {
        return this.pkContributionPath;
    }

    @NotNull
    public final LiveShowPkWarResult copy(@Nullable LiveShowModel liveShowModel, @Nullable LiveShowModel liveShowModel2, @Nullable Map<String, ? extends List<User>> map, int i10, @Nullable String str) {
        return new LiveShowPkWarResult(liveShowModel, liveShowModel2, map, i10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowPkWarResult)) {
            return false;
        }
        LiveShowPkWarResult liveShowPkWarResult = (LiveShowPkWarResult) obj;
        return s.d(this.liveShow, liveShowPkWarResult.liveShow) && s.d(this.pkLiveShow, liveShowPkWarResult.pkLiveShow) && s.d(this.sofa, liveShowPkWarResult.sofa) && this.pkTodayHangupCount == liveShowPkWarResult.pkTodayHangupCount && s.d(this.pkContributionPath, liveShowPkWarResult.pkContributionPath);
    }

    @Nullable
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    @Nullable
    public final String getPkContributionPath() {
        return this.pkContributionPath;
    }

    @Nullable
    public final LiveShowModel getPkLiveShow() {
        return this.pkLiveShow;
    }

    public final int getPkTodayHangupCount() {
        return this.pkTodayHangupCount;
    }

    @Nullable
    public final Map<String, List<User>> getSofa() {
        return this.sofa;
    }

    public int hashCode() {
        LiveShowModel liveShowModel = this.liveShow;
        int hashCode = (liveShowModel == null ? 0 : liveShowModel.hashCode()) * 31;
        LiveShowModel liveShowModel2 = this.pkLiveShow;
        int hashCode2 = (hashCode + (liveShowModel2 == null ? 0 : liveShowModel2.hashCode())) * 31;
        Map<String, List<User>> map = this.sofa;
        int hashCode3 = (((hashCode2 + (map == null ? 0 : map.hashCode())) * 31) + this.pkTodayHangupCount) * 31;
        String str = this.pkContributionPath;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        LiveShowModel liveShowModel = this.liveShow;
        LiveShowModel liveShowModel2 = this.pkLiveShow;
        Map<String, List<User>> map = this.sofa;
        return "LiveShowPkWarResult(liveShow=" + ((Object) liveShowModel) + ", pkLiveShow=" + ((Object) liveShowModel2) + ", sofa=" + ((Object) map) + ", pkTodayHangupCount=" + this.pkTodayHangupCount + ", pkContributionPath=" + this.pkContributionPath + ")";
    }
}
