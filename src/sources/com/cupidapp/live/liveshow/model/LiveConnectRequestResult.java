package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKliveConnectResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectRequestResult {

    @Nullable
    private final Integer waitingToConnectCount;

    public LiveConnectRequestResult() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public LiveConnectRequestResult(@Nullable Integer num) {
        this.waitingToConnectCount = num;
    }

    public static /* synthetic */ LiveConnectRequestResult copy$default(LiveConnectRequestResult liveConnectRequestResult, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = liveConnectRequestResult.waitingToConnectCount;
        }
        return liveConnectRequestResult.copy(num);
    }

    @Nullable
    public final Integer component1() {
        return this.waitingToConnectCount;
    }

    @NotNull
    public final LiveConnectRequestResult copy(@Nullable Integer num) {
        return new LiveConnectRequestResult(num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveConnectRequestResult) && s.d(this.waitingToConnectCount, ((LiveConnectRequestResult) obj).waitingToConnectCount);
    }

    @Nullable
    public final Integer getWaitingToConnectCount() {
        return this.waitingToConnectCount;
    }

    public int hashCode() {
        Integer num = this.waitingToConnectCount;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveConnectRequestResult(waitingToConnectCount=" + ((Object) this.waitingToConnectCount) + ")";
    }

    public /* synthetic */ LiveConnectRequestResult(Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0 : num);
    }
}
