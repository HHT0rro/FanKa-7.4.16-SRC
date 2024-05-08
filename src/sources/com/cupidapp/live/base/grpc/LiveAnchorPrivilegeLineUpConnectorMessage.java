package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveAnchorPrivilegeLineUpConnectorMessage {

    @NotNull
    private final String liveShowId;
    private final int position;
    private final int privilegeType;

    public LiveAnchorPrivilegeLineUpConnectorMessage(int i10, int i11, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.position = i10;
        this.privilegeType = i11;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LiveAnchorPrivilegeLineUpConnectorMessage copy$default(LiveAnchorPrivilegeLineUpConnectorMessage liveAnchorPrivilegeLineUpConnectorMessage, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = liveAnchorPrivilegeLineUpConnectorMessage.position;
        }
        if ((i12 & 2) != 0) {
            i11 = liveAnchorPrivilegeLineUpConnectorMessage.privilegeType;
        }
        if ((i12 & 4) != 0) {
            str = liveAnchorPrivilegeLineUpConnectorMessage.liveShowId;
        }
        return liveAnchorPrivilegeLineUpConnectorMessage.copy(i10, i11, str);
    }

    public final int component1() {
        return this.position;
    }

    public final int component2() {
        return this.privilegeType;
    }

    @NotNull
    public final String component3() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveAnchorPrivilegeLineUpConnectorMessage copy(int i10, int i11, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveAnchorPrivilegeLineUpConnectorMessage(i10, i11, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveAnchorPrivilegeLineUpConnectorMessage)) {
            return false;
        }
        LiveAnchorPrivilegeLineUpConnectorMessage liveAnchorPrivilegeLineUpConnectorMessage = (LiveAnchorPrivilegeLineUpConnectorMessage) obj;
        return this.position == liveAnchorPrivilegeLineUpConnectorMessage.position && this.privilegeType == liveAnchorPrivilegeLineUpConnectorMessage.privilegeType && kotlin.jvm.internal.s.d(this.liveShowId, liveAnchorPrivilegeLineUpConnectorMessage.liveShowId);
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getPrivilegeType() {
        return this.privilegeType;
    }

    public int hashCode() {
        return (((this.position * 31) + this.privilegeType) * 31) + this.liveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveAnchorPrivilegeLineUpConnectorMessage(position=" + this.position + ", privilegeType=" + this.privilegeType + ", liveShowId=" + this.liveShowId + ")";
    }
}
