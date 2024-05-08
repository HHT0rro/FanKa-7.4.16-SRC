package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.PrayContestModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PrayContestMessage {

    @Nullable
    private final PrayContestModel lotteryBattleInfo;

    @Nullable
    private final PrayContestModel lotteryBattleNormalInfo;

    public PrayContestMessage(@Nullable PrayContestModel prayContestModel, @Nullable PrayContestModel prayContestModel2) {
        this.lotteryBattleInfo = prayContestModel;
        this.lotteryBattleNormalInfo = prayContestModel2;
    }

    public static /* synthetic */ PrayContestMessage copy$default(PrayContestMessage prayContestMessage, PrayContestModel prayContestModel, PrayContestModel prayContestModel2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            prayContestModel = prayContestMessage.lotteryBattleInfo;
        }
        if ((i10 & 2) != 0) {
            prayContestModel2 = prayContestMessage.lotteryBattleNormalInfo;
        }
        return prayContestMessage.copy(prayContestModel, prayContestModel2);
    }

    @Nullable
    public final PrayContestModel component1() {
        return this.lotteryBattleInfo;
    }

    @Nullable
    public final PrayContestModel component2() {
        return this.lotteryBattleNormalInfo;
    }

    @NotNull
    public final PrayContestMessage copy(@Nullable PrayContestModel prayContestModel, @Nullable PrayContestModel prayContestModel2) {
        return new PrayContestMessage(prayContestModel, prayContestModel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrayContestMessage)) {
            return false;
        }
        PrayContestMessage prayContestMessage = (PrayContestMessage) obj;
        return kotlin.jvm.internal.s.d(this.lotteryBattleInfo, prayContestMessage.lotteryBattleInfo) && kotlin.jvm.internal.s.d(this.lotteryBattleNormalInfo, prayContestMessage.lotteryBattleNormalInfo);
    }

    @Nullable
    public final PrayContestModel getLotteryBattleInfo() {
        return this.lotteryBattleInfo;
    }

    @Nullable
    public final PrayContestModel getLotteryBattleNormalInfo() {
        return this.lotteryBattleNormalInfo;
    }

    public int hashCode() {
        PrayContestModel prayContestModel = this.lotteryBattleInfo;
        int hashCode = (prayContestModel == null ? 0 : prayContestModel.hashCode()) * 31;
        PrayContestModel prayContestModel2 = this.lotteryBattleNormalInfo;
        return hashCode + (prayContestModel2 != null ? prayContestModel2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PrayContestMessage(lotteryBattleInfo=" + ((Object) this.lotteryBattleInfo) + ", lotteryBattleNormalInfo=" + ((Object) this.lotteryBattleNormalInfo) + ")";
    }
}
