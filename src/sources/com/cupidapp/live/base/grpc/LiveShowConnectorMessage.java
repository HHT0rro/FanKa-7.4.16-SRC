package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowConnectorMessage {

    @Nullable
    private final String commission;

    @NotNull
    private final String liveShowId;

    @Nullable
    private final String viewerCount;

    public LiveShowConnectorMessage(@NotNull String liveShowId, @Nullable String str, @Nullable String str2) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.viewerCount = str;
        this.commission = str2;
    }

    public static /* synthetic */ LiveShowConnectorMessage copy$default(LiveShowConnectorMessage liveShowConnectorMessage, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveShowConnectorMessage.liveShowId;
        }
        if ((i10 & 2) != 0) {
            str2 = liveShowConnectorMessage.viewerCount;
        }
        if ((i10 & 4) != 0) {
            str3 = liveShowConnectorMessage.commission;
        }
        return liveShowConnectorMessage.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @Nullable
    public final String component2() {
        return this.viewerCount;
    }

    @Nullable
    public final String component3() {
        return this.commission;
    }

    @NotNull
    public final LiveShowConnectorMessage copy(@NotNull String liveShowId, @Nullable String str, @Nullable String str2) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveShowConnectorMessage(liveShowId, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowConnectorMessage)) {
            return false;
        }
        LiveShowConnectorMessage liveShowConnectorMessage = (LiveShowConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.liveShowId, liveShowConnectorMessage.liveShowId) && kotlin.jvm.internal.s.d(this.viewerCount, liveShowConnectorMessage.viewerCount) && kotlin.jvm.internal.s.d(this.commission, liveShowConnectorMessage.commission);
    }

    @Nullable
    public final String getCommission() {
        return this.commission;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @Nullable
    public final String getViewerCount() {
        return this.viewerCount;
    }

    public int hashCode() {
        int hashCode = this.liveShowId.hashCode() * 31;
        String str = this.viewerCount;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.commission;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveShowConnectorMessage(liveShowId=" + this.liveShowId + ", viewerCount=" + this.viewerCount + ", commission=" + this.commission + ")";
    }
}
