package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveAnchorPrivilegeInUseConnectorMessage {

    @NotNull
    private final String liveShowId;
    private final int privilegeType;
    private final long startUseTimestamp;
    private final int usefulLifeSeconds;

    public LiveAnchorPrivilegeInUseConnectorMessage(long j10, int i10, int i11, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.startUseTimestamp = j10;
        this.usefulLifeSeconds = i10;
        this.privilegeType = i11;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LiveAnchorPrivilegeInUseConnectorMessage copy$default(LiveAnchorPrivilegeInUseConnectorMessage liveAnchorPrivilegeInUseConnectorMessage, long j10, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            j10 = liveAnchorPrivilegeInUseConnectorMessage.startUseTimestamp;
        }
        long j11 = j10;
        if ((i12 & 2) != 0) {
            i10 = liveAnchorPrivilegeInUseConnectorMessage.usefulLifeSeconds;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            i11 = liveAnchorPrivilegeInUseConnectorMessage.privilegeType;
        }
        int i14 = i11;
        if ((i12 & 8) != 0) {
            str = liveAnchorPrivilegeInUseConnectorMessage.liveShowId;
        }
        return liveAnchorPrivilegeInUseConnectorMessage.copy(j11, i13, i14, str);
    }

    public final long component1() {
        return this.startUseTimestamp;
    }

    public final int component2() {
        return this.usefulLifeSeconds;
    }

    public final int component3() {
        return this.privilegeType;
    }

    @NotNull
    public final String component4() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveAnchorPrivilegeInUseConnectorMessage copy(long j10, int i10, int i11, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveAnchorPrivilegeInUseConnectorMessage(j10, i10, i11, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveAnchorPrivilegeInUseConnectorMessage)) {
            return false;
        }
        LiveAnchorPrivilegeInUseConnectorMessage liveAnchorPrivilegeInUseConnectorMessage = (LiveAnchorPrivilegeInUseConnectorMessage) obj;
        return this.startUseTimestamp == liveAnchorPrivilegeInUseConnectorMessage.startUseTimestamp && this.usefulLifeSeconds == liveAnchorPrivilegeInUseConnectorMessage.usefulLifeSeconds && this.privilegeType == liveAnchorPrivilegeInUseConnectorMessage.privilegeType && kotlin.jvm.internal.s.d(this.liveShowId, liveAnchorPrivilegeInUseConnectorMessage.liveShowId);
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public final int getPrivilegeType() {
        return this.privilegeType;
    }

    public final long getStartUseTimestamp() {
        return this.startUseTimestamp;
    }

    public final int getUsefulLifeSeconds() {
        return this.usefulLifeSeconds;
    }

    public int hashCode() {
        return (((((b2.a.a(this.startUseTimestamp) * 31) + this.usefulLifeSeconds) * 31) + this.privilegeType) * 31) + this.liveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveAnchorPrivilegeInUseConnectorMessage(startUseTimestamp=" + this.startUseTimestamp + ", usefulLifeSeconds=" + this.usefulLifeSeconds + ", privilegeType=" + this.privilegeType + ", liveShowId=" + this.liveShowId + ")";
    }
}
