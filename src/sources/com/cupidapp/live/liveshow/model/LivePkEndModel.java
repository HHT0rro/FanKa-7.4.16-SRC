package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkEndModel {
    private final int endingType;

    @NotNull
    private final String matchId;

    @NotNull
    private final User pkUser;

    @Nullable
    private final String resultUrl;

    public LivePkEndModel(@NotNull String matchId, @Nullable String str, @NotNull User pkUser, int i10) {
        s.i(matchId, "matchId");
        s.i(pkUser, "pkUser");
        this.matchId = matchId;
        this.resultUrl = str;
        this.pkUser = pkUser;
        this.endingType = i10;
    }

    public static /* synthetic */ LivePkEndModel copy$default(LivePkEndModel livePkEndModel, String str, String str2, User user, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = livePkEndModel.matchId;
        }
        if ((i11 & 2) != 0) {
            str2 = livePkEndModel.resultUrl;
        }
        if ((i11 & 4) != 0) {
            user = livePkEndModel.pkUser;
        }
        if ((i11 & 8) != 0) {
            i10 = livePkEndModel.endingType;
        }
        return livePkEndModel.copy(str, str2, user, i10);
    }

    @NotNull
    public final String component1() {
        return this.matchId;
    }

    @Nullable
    public final String component2() {
        return this.resultUrl;
    }

    @NotNull
    public final User component3() {
        return this.pkUser;
    }

    public final int component4() {
        return this.endingType;
    }

    @NotNull
    public final LivePkEndModel copy(@NotNull String matchId, @Nullable String str, @NotNull User pkUser, int i10) {
        s.i(matchId, "matchId");
        s.i(pkUser, "pkUser");
        return new LivePkEndModel(matchId, str, pkUser, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkEndModel)) {
            return false;
        }
        LivePkEndModel livePkEndModel = (LivePkEndModel) obj;
        return s.d(this.matchId, livePkEndModel.matchId) && s.d(this.resultUrl, livePkEndModel.resultUrl) && s.d(this.pkUser, livePkEndModel.pkUser) && this.endingType == livePkEndModel.endingType;
    }

    public final int getEndingType() {
        return this.endingType;
    }

    @NotNull
    public final String getMatchId() {
        return this.matchId;
    }

    @NotNull
    public final User getPkUser() {
        return this.pkUser;
    }

    @Nullable
    public final String getResultUrl() {
        return this.resultUrl;
    }

    public int hashCode() {
        int hashCode = this.matchId.hashCode() * 31;
        String str = this.resultUrl;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.pkUser.hashCode()) * 31) + this.endingType;
    }

    @NotNull
    public String toString() {
        String str = this.matchId;
        String str2 = this.resultUrl;
        User user = this.pkUser;
        return "LivePkEndModel(matchId=" + str + ", resultUrl=" + str2 + ", pkUser=" + ((Object) user) + ", endingType=" + this.endingType + ")";
    }
}
