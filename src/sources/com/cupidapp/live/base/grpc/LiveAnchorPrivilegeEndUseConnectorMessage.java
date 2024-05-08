package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveAnchorPrivilegeEndUseConnectorMessage {

    @NotNull
    private final String liveShowId;
    private final int privilegeId;
    private final int privilegeType;

    public LiveAnchorPrivilegeEndUseConnectorMessage(int i10, int i11, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.privilegeId = i10;
        this.privilegeType = i11;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LiveAnchorPrivilegeEndUseConnectorMessage copy$default(LiveAnchorPrivilegeEndUseConnectorMessage liveAnchorPrivilegeEndUseConnectorMessage, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = liveAnchorPrivilegeEndUseConnectorMessage.privilegeId;
        }
        if ((i12 & 2) != 0) {
            i11 = liveAnchorPrivilegeEndUseConnectorMessage.privilegeType;
        }
        if ((i12 & 4) != 0) {
            str = liveAnchorPrivilegeEndUseConnectorMessage.liveShowId;
        }
        return liveAnchorPrivilegeEndUseConnectorMessage.copy(i10, i11, str);
    }

    public final int component1() {
        return this.privilegeId;
    }

    public final int component2() {
        return this.privilegeType;
    }

    @NotNull
    public final String component3() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveAnchorPrivilegeEndUseConnectorMessage copy(int i10, int i11, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveAnchorPrivilegeEndUseConnectorMessage(i10, i11, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveAnchorPrivilegeEndUseConnectorMessage)) {
            return false;
        }
        LiveAnchorPrivilegeEndUseConnectorMessage liveAnchorPrivilegeEndUseConnectorMessage = (LiveAnchorPrivilegeEndUseConnectorMessage) obj;
        return this.privilegeId == liveAnchorPrivilegeEndUseConnectorMessage.privilegeId && this.privilegeType == liveAnchorPrivilegeEndUseConnectorMessage.privilegeType && kotlin.jvm.internal.s.d(this.liveShowId, liveAnchorPrivilegeEndUseConnectorMessage.liveShowId);
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public final int getPrivilegeId() {
        return this.privilegeId;
    }

    public final int getPrivilegeType() {
        return this.privilegeType;
    }

    public int hashCode() {
        return (((this.privilegeId * 31) + this.privilegeType) * 31) + this.liveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveAnchorPrivilegeEndUseConnectorMessage(privilegeId=" + this.privilegeId + ", privilegeType=" + this.privilegeType + ", liveShowId=" + this.liveShowId + ")";
    }
}
