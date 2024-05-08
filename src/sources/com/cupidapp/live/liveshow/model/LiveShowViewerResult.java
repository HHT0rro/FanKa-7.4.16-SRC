package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKliveConnectResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowViewerResult implements Serializable {

    @Nullable
    private final Boolean closeReceiveRequest;

    @Nullable
    private final List<LiveRequestModel> list;

    @Nullable
    private final Integer maxConnectCount;

    @Nullable
    private final Integer waitingToConnectCount;

    public LiveShowViewerResult(@Nullable Boolean bool, @Nullable Integer num, @Nullable List<LiveRequestModel> list, @Nullable Integer num2) {
        this.closeReceiveRequest = bool;
        this.waitingToConnectCount = num;
        this.list = list;
        this.maxConnectCount = num2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveShowViewerResult copy$default(LiveShowViewerResult liveShowViewerResult, Boolean bool, Integer num, List list, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = liveShowViewerResult.closeReceiveRequest;
        }
        if ((i10 & 2) != 0) {
            num = liveShowViewerResult.waitingToConnectCount;
        }
        if ((i10 & 4) != 0) {
            list = liveShowViewerResult.list;
        }
        if ((i10 & 8) != 0) {
            num2 = liveShowViewerResult.maxConnectCount;
        }
        return liveShowViewerResult.copy(bool, num, list, num2);
    }

    @Nullable
    public final Boolean component1() {
        return this.closeReceiveRequest;
    }

    @Nullable
    public final Integer component2() {
        return this.waitingToConnectCount;
    }

    @Nullable
    public final List<LiveRequestModel> component3() {
        return this.list;
    }

    @Nullable
    public final Integer component4() {
        return this.maxConnectCount;
    }

    @NotNull
    public final LiveShowViewerResult copy(@Nullable Boolean bool, @Nullable Integer num, @Nullable List<LiveRequestModel> list, @Nullable Integer num2) {
        return new LiveShowViewerResult(bool, num, list, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowViewerResult)) {
            return false;
        }
        LiveShowViewerResult liveShowViewerResult = (LiveShowViewerResult) obj;
        return s.d(this.closeReceiveRequest, liveShowViewerResult.closeReceiveRequest) && s.d(this.waitingToConnectCount, liveShowViewerResult.waitingToConnectCount) && s.d(this.list, liveShowViewerResult.list) && s.d(this.maxConnectCount, liveShowViewerResult.maxConnectCount);
    }

    @Nullable
    public final Boolean getCloseReceiveRequest() {
        return this.closeReceiveRequest;
    }

    @Nullable
    public final List<LiveRequestModel> getList() {
        return this.list;
    }

    @Nullable
    public final Integer getMaxConnectCount() {
        return this.maxConnectCount;
    }

    @Nullable
    public final Integer getWaitingToConnectCount() {
        return this.waitingToConnectCount;
    }

    public int hashCode() {
        Boolean bool = this.closeReceiveRequest;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.waitingToConnectCount;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<LiveRequestModel> list = this.list;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.maxConnectCount;
        return hashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveShowViewerResult(closeReceiveRequest=" + ((Object) this.closeReceiveRequest) + ", waitingToConnectCount=" + ((Object) this.waitingToConnectCount) + ", list=" + ((Object) this.list) + ", maxConnectCount=" + ((Object) this.maxConnectCount) + ")";
    }

    public /* synthetic */ LiveShowViewerResult(Boolean bool, Integer num, List list, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? Boolean.FALSE : bool, (i10 & 2) != 0 ? 0 : num, list, (i10 & 8) != 0 ? 0 : num2);
    }
}
