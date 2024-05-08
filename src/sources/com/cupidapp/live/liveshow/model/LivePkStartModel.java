package com.cupidapp.live.liveshow.model;

import b2.a;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkStartModel {
    private final long countdownMillis;
    private final boolean isAppointPk;

    @NotNull
    private final String matchId;

    @NotNull
    private final String pkLiveShowId;
    private final int pkType;

    @NotNull
    private final User pkUser;

    @Nullable
    private final List<String> winnerLiveShowIds;

    public LivePkStartModel(@NotNull String pkLiveShowId, @NotNull User pkUser, long j10, @NotNull String matchId, @Nullable List<String> list, boolean z10, int i10) {
        s.i(pkLiveShowId, "pkLiveShowId");
        s.i(pkUser, "pkUser");
        s.i(matchId, "matchId");
        this.pkLiveShowId = pkLiveShowId;
        this.pkUser = pkUser;
        this.countdownMillis = j10;
        this.matchId = matchId;
        this.winnerLiveShowIds = list;
        this.isAppointPk = z10;
        this.pkType = i10;
    }

    @NotNull
    public final String component1() {
        return this.pkLiveShowId;
    }

    @NotNull
    public final User component2() {
        return this.pkUser;
    }

    public final long component3() {
        return this.countdownMillis;
    }

    @NotNull
    public final String component4() {
        return this.matchId;
    }

    @Nullable
    public final List<String> component5() {
        return this.winnerLiveShowIds;
    }

    public final boolean component6() {
        return this.isAppointPk;
    }

    public final int component7() {
        return this.pkType;
    }

    @NotNull
    public final LivePkStartModel copy(@NotNull String pkLiveShowId, @NotNull User pkUser, long j10, @NotNull String matchId, @Nullable List<String> list, boolean z10, int i10) {
        s.i(pkLiveShowId, "pkLiveShowId");
        s.i(pkUser, "pkUser");
        s.i(matchId, "matchId");
        return new LivePkStartModel(pkLiveShowId, pkUser, j10, matchId, list, z10, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkStartModel)) {
            return false;
        }
        LivePkStartModel livePkStartModel = (LivePkStartModel) obj;
        return s.d(this.pkLiveShowId, livePkStartModel.pkLiveShowId) && s.d(this.pkUser, livePkStartModel.pkUser) && this.countdownMillis == livePkStartModel.countdownMillis && s.d(this.matchId, livePkStartModel.matchId) && s.d(this.winnerLiveShowIds, livePkStartModel.winnerLiveShowIds) && this.isAppointPk == livePkStartModel.isAppointPk && this.pkType == livePkStartModel.pkType;
    }

    public final long getCountdownMillis() {
        return this.countdownMillis;
    }

    @NotNull
    public final String getMatchId() {
        return this.matchId;
    }

    @NotNull
    public final String getPkLiveShowId() {
        return this.pkLiveShowId;
    }

    public final int getPkType() {
        return this.pkType;
    }

    @NotNull
    public final User getPkUser() {
        return this.pkUser;
    }

    @Nullable
    public final List<String> getWinnerLiveShowIds() {
        return this.winnerLiveShowIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.pkLiveShowId.hashCode() * 31) + this.pkUser.hashCode()) * 31) + a.a(this.countdownMillis)) * 31) + this.matchId.hashCode()) * 31;
        List<String> list = this.winnerLiveShowIds;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z10 = this.isAppointPk;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode2 + i10) * 31) + this.pkType;
    }

    public final boolean isAppointPk() {
        return this.isAppointPk;
    }

    @NotNull
    public String toString() {
        String str = this.pkLiveShowId;
        User user = this.pkUser;
        long j10 = this.countdownMillis;
        String str2 = this.matchId;
        List<String> list = this.winnerLiveShowIds;
        return "LivePkStartModel(pkLiveShowId=" + str + ", pkUser=" + ((Object) user) + ", countdownMillis=" + j10 + ", matchId=" + str2 + ", winnerLiveShowIds=" + ((Object) list) + ", isAppointPk=" + this.isAppointPk + ", pkType=" + this.pkType + ")";
    }
}
