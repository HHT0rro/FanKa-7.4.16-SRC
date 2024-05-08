package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkingInfoModel implements Serializable {
    private final float balance;
    private final boolean chatting;
    private final long countdownMillis;
    private final float credit;

    @NotNull
    private final String matchId;

    @Nullable
    private final List<String> winnerLiveShowIds;

    public LivePkingInfoModel(@NotNull String matchId, float f10, float f11, long j10, boolean z10, @Nullable List<String> list) {
        s.i(matchId, "matchId");
        this.matchId = matchId;
        this.balance = f10;
        this.credit = f11;
        this.countdownMillis = j10;
        this.chatting = z10;
        this.winnerLiveShowIds = list;
    }

    public final float getBalance() {
        return this.balance;
    }

    public final boolean getChatting() {
        return this.chatting;
    }

    public final long getCountdownMillis() {
        return this.countdownMillis;
    }

    public final float getCredit() {
        return this.credit;
    }

    @NotNull
    public final String getMatchId() {
        return this.matchId;
    }

    @Nullable
    public final List<String> getWinnerLiveShowIds() {
        return this.winnerLiveShowIds;
    }
}
