package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RequestConnectResult {

    @Nullable
    private final Integer count;

    @NotNull
    private final String requestId;

    @Nullable
    private final Boolean suspend;

    public RequestConnectResult(@NotNull String requestId, @Nullable Integer num, @Nullable Boolean bool) {
        s.i(requestId, "requestId");
        this.requestId = requestId;
        this.count = num;
        this.suspend = bool;
    }

    public static /* synthetic */ RequestConnectResult copy$default(RequestConnectResult requestConnectResult, String str, Integer num, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = requestConnectResult.requestId;
        }
        if ((i10 & 2) != 0) {
            num = requestConnectResult.count;
        }
        if ((i10 & 4) != 0) {
            bool = requestConnectResult.suspend;
        }
        return requestConnectResult.copy(str, num, bool);
    }

    @NotNull
    public final String component1() {
        return this.requestId;
    }

    @Nullable
    public final Integer component2() {
        return this.count;
    }

    @Nullable
    public final Boolean component3() {
        return this.suspend;
    }

    @NotNull
    public final RequestConnectResult copy(@NotNull String requestId, @Nullable Integer num, @Nullable Boolean bool) {
        s.i(requestId, "requestId");
        return new RequestConnectResult(requestId, num, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestConnectResult)) {
            return false;
        }
        RequestConnectResult requestConnectResult = (RequestConnectResult) obj;
        return s.d(this.requestId, requestConnectResult.requestId) && s.d(this.count, requestConnectResult.count) && s.d(this.suspend, requestConnectResult.suspend);
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @Nullable
    public final Boolean getSuspend() {
        return this.suspend;
    }

    public int hashCode() {
        int hashCode = this.requestId.hashCode() * 31;
        Integer num = this.count;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.suspend;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RequestConnectResult(requestId=" + this.requestId + ", count=" + ((Object) this.count) + ", suspend=" + ((Object) this.suspend) + ")";
    }
}
