package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveAnchorPrivilegeHintConnectorMessage {
    private final int level;

    @NotNull
    private final String liveShowId;
    private final int privilegeType;

    @Nullable
    private final Integer usefulLife;

    public LiveAnchorPrivilegeHintConnectorMessage(int i10, @Nullable Integer num, int i11, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.level = i10;
        this.usefulLife = num;
        this.privilegeType = i11;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LiveAnchorPrivilegeHintConnectorMessage copy$default(LiveAnchorPrivilegeHintConnectorMessage liveAnchorPrivilegeHintConnectorMessage, int i10, Integer num, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = liveAnchorPrivilegeHintConnectorMessage.level;
        }
        if ((i12 & 2) != 0) {
            num = liveAnchorPrivilegeHintConnectorMessage.usefulLife;
        }
        if ((i12 & 4) != 0) {
            i11 = liveAnchorPrivilegeHintConnectorMessage.privilegeType;
        }
        if ((i12 & 8) != 0) {
            str = liveAnchorPrivilegeHintConnectorMessage.liveShowId;
        }
        return liveAnchorPrivilegeHintConnectorMessage.copy(i10, num, i11, str);
    }

    public final int component1() {
        return this.level;
    }

    @Nullable
    public final Integer component2() {
        return this.usefulLife;
    }

    public final int component3() {
        return this.privilegeType;
    }

    @NotNull
    public final String component4() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveAnchorPrivilegeHintConnectorMessage copy(int i10, @Nullable Integer num, int i11, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveAnchorPrivilegeHintConnectorMessage(i10, num, i11, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveAnchorPrivilegeHintConnectorMessage)) {
            return false;
        }
        LiveAnchorPrivilegeHintConnectorMessage liveAnchorPrivilegeHintConnectorMessage = (LiveAnchorPrivilegeHintConnectorMessage) obj;
        return this.level == liveAnchorPrivilegeHintConnectorMessage.level && kotlin.jvm.internal.s.d(this.usefulLife, liveAnchorPrivilegeHintConnectorMessage.usefulLife) && this.privilegeType == liveAnchorPrivilegeHintConnectorMessage.privilegeType && kotlin.jvm.internal.s.d(this.liveShowId, liveAnchorPrivilegeHintConnectorMessage.liveShowId);
    }

    public final int getLevel() {
        return this.level;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public final int getPrivilegeType() {
        return this.privilegeType;
    }

    @Nullable
    public final Integer getUsefulLife() {
        return this.usefulLife;
    }

    public int hashCode() {
        int i10 = this.level * 31;
        Integer num = this.usefulLife;
        return ((((i10 + (num == null ? 0 : num.hashCode())) * 31) + this.privilegeType) * 31) + this.liveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        int i10 = this.level;
        Integer num = this.usefulLife;
        return "LiveAnchorPrivilegeHintConnectorMessage(level=" + i10 + ", usefulLife=" + ((Object) num) + ", privilegeType=" + this.privilegeType + ", liveShowId=" + this.liveShowId + ")";
    }
}
