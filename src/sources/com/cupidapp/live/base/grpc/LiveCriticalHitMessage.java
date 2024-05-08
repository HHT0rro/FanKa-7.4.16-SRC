package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.FKCriticalHitModel;
import com.cupidapp.live.liveshow.model.FKTurnTableModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCriticalHitMessage {

    @Nullable
    private final FKCriticalHitModel critInfo;

    @Nullable
    private final FKTurnTableModel lotteryBtn;

    public LiveCriticalHitMessage() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public LiveCriticalHitMessage(@Nullable FKTurnTableModel fKTurnTableModel, @Nullable FKCriticalHitModel fKCriticalHitModel) {
        this.lotteryBtn = fKTurnTableModel;
        this.critInfo = fKCriticalHitModel;
    }

    public static /* synthetic */ LiveCriticalHitMessage copy$default(LiveCriticalHitMessage liveCriticalHitMessage, FKTurnTableModel fKTurnTableModel, FKCriticalHitModel fKCriticalHitModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fKTurnTableModel = liveCriticalHitMessage.lotteryBtn;
        }
        if ((i10 & 2) != 0) {
            fKCriticalHitModel = liveCriticalHitMessage.critInfo;
        }
        return liveCriticalHitMessage.copy(fKTurnTableModel, fKCriticalHitModel);
    }

    @Nullable
    public final FKTurnTableModel component1() {
        return this.lotteryBtn;
    }

    @Nullable
    public final FKCriticalHitModel component2() {
        return this.critInfo;
    }

    @NotNull
    public final LiveCriticalHitMessage copy(@Nullable FKTurnTableModel fKTurnTableModel, @Nullable FKCriticalHitModel fKCriticalHitModel) {
        return new LiveCriticalHitMessage(fKTurnTableModel, fKCriticalHitModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveCriticalHitMessage)) {
            return false;
        }
        LiveCriticalHitMessage liveCriticalHitMessage = (LiveCriticalHitMessage) obj;
        return kotlin.jvm.internal.s.d(this.lotteryBtn, liveCriticalHitMessage.lotteryBtn) && kotlin.jvm.internal.s.d(this.critInfo, liveCriticalHitMessage.critInfo);
    }

    @Nullable
    public final FKCriticalHitModel getCritInfo() {
        return this.critInfo;
    }

    @Nullable
    public final FKTurnTableModel getLotteryBtn() {
        return this.lotteryBtn;
    }

    public int hashCode() {
        FKTurnTableModel fKTurnTableModel = this.lotteryBtn;
        int hashCode = (fKTurnTableModel == null ? 0 : fKTurnTableModel.hashCode()) * 31;
        FKCriticalHitModel fKCriticalHitModel = this.critInfo;
        return hashCode + (fKCriticalHitModel != null ? fKCriticalHitModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveCriticalHitMessage(lotteryBtn=" + ((Object) this.lotteryBtn) + ", critInfo=" + ((Object) this.critInfo) + ")";
    }

    public /* synthetic */ LiveCriticalHitMessage(FKTurnTableModel fKTurnTableModel, FKCriticalHitModel fKCriticalHitModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : fKTurnTableModel, (i10 & 2) != 0 ? null : fKCriticalHitModel);
    }
}
