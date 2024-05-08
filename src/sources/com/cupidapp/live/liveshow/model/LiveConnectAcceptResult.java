package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKliveConnectResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectAcceptResult {

    @Nullable
    private final LiveShowModel liveShow;

    @Nullable
    private final Integer waitingToConnectCount;

    public LiveConnectAcceptResult(@Nullable LiveShowModel liveShowModel, @Nullable Integer num) {
        this.liveShow = liveShowModel;
        this.waitingToConnectCount = num;
    }

    public static /* synthetic */ LiveConnectAcceptResult copy$default(LiveConnectAcceptResult liveConnectAcceptResult, LiveShowModel liveShowModel, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowModel = liveConnectAcceptResult.liveShow;
        }
        if ((i10 & 2) != 0) {
            num = liveConnectAcceptResult.waitingToConnectCount;
        }
        return liveConnectAcceptResult.copy(liveShowModel, num);
    }

    @Nullable
    public final LiveShowModel component1() {
        return this.liveShow;
    }

    @Nullable
    public final Integer component2() {
        return this.waitingToConnectCount;
    }

    @NotNull
    public final LiveConnectAcceptResult copy(@Nullable LiveShowModel liveShowModel, @Nullable Integer num) {
        return new LiveConnectAcceptResult(liveShowModel, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveConnectAcceptResult)) {
            return false;
        }
        LiveConnectAcceptResult liveConnectAcceptResult = (LiveConnectAcceptResult) obj;
        return s.d(this.liveShow, liveConnectAcceptResult.liveShow) && s.d(this.waitingToConnectCount, liveConnectAcceptResult.waitingToConnectCount);
    }

    @Nullable
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    @Nullable
    public final Integer getWaitingToConnectCount() {
        return this.waitingToConnectCount;
    }

    public int hashCode() {
        LiveShowModel liveShowModel = this.liveShow;
        int hashCode = (liveShowModel == null ? 0 : liveShowModel.hashCode()) * 31;
        Integer num = this.waitingToConnectCount;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveConnectAcceptResult(liveShow=" + ((Object) this.liveShow) + ", waitingToConnectCount=" + ((Object) this.waitingToConnectCount) + ")";
    }

    public /* synthetic */ LiveConnectAcceptResult(LiveShowModel liveShowModel, Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(liveShowModel, (i10 & 2) != 0 ? 0 : num);
    }
}
