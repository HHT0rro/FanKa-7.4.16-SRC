package com.cupidapp.live.base.grpc;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class InLiveShowHeartBeatEvent implements Serializable {

    @Nullable
    private final String consultRoomId;
    private final boolean inLiveShow;

    @Nullable
    private String liveShowId;

    @Nullable
    private Boolean viewer;

    public InLiveShowHeartBeatEvent(boolean z10, @Nullable String str, @Nullable Boolean bool, @Nullable String str2) {
        this.inLiveShow = z10;
        this.liveShowId = str;
        this.viewer = bool;
        this.consultRoomId = str2;
    }

    public static /* synthetic */ InLiveShowHeartBeatEvent copy$default(InLiveShowHeartBeatEvent inLiveShowHeartBeatEvent, boolean z10, String str, Boolean bool, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = inLiveShowHeartBeatEvent.inLiveShow;
        }
        if ((i10 & 2) != 0) {
            str = inLiveShowHeartBeatEvent.liveShowId;
        }
        if ((i10 & 4) != 0) {
            bool = inLiveShowHeartBeatEvent.viewer;
        }
        if ((i10 & 8) != 0) {
            str2 = inLiveShowHeartBeatEvent.consultRoomId;
        }
        return inLiveShowHeartBeatEvent.copy(z10, str, bool, str2);
    }

    public final boolean component1() {
        return this.inLiveShow;
    }

    @Nullable
    public final String component2() {
        return this.liveShowId;
    }

    @Nullable
    public final Boolean component3() {
        return this.viewer;
    }

    @Nullable
    public final String component4() {
        return this.consultRoomId;
    }

    @NotNull
    public final InLiveShowHeartBeatEvent copy(boolean z10, @Nullable String str, @Nullable Boolean bool, @Nullable String str2) {
        return new InLiveShowHeartBeatEvent(z10, str, bool, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InLiveShowHeartBeatEvent)) {
            return false;
        }
        InLiveShowHeartBeatEvent inLiveShowHeartBeatEvent = (InLiveShowHeartBeatEvent) obj;
        return this.inLiveShow == inLiveShowHeartBeatEvent.inLiveShow && kotlin.jvm.internal.s.d(this.liveShowId, inLiveShowHeartBeatEvent.liveShowId) && kotlin.jvm.internal.s.d(this.viewer, inLiveShowHeartBeatEvent.viewer) && kotlin.jvm.internal.s.d(this.consultRoomId, inLiveShowHeartBeatEvent.consultRoomId);
    }

    @Nullable
    public final String getConsultRoomId() {
        return this.consultRoomId;
    }

    public final boolean getInLiveShow() {
        return this.inLiveShow;
    }

    @Nullable
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @Nullable
    public final Boolean getViewer() {
        return this.viewer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z10 = this.inLiveShow;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        String str = this.liveShowId;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.viewer;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.consultRoomId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setLiveShowId(@Nullable String str) {
        this.liveShowId = str;
    }

    public final void setViewer(@Nullable Boolean bool) {
        this.viewer = bool;
    }

    @NotNull
    public String toString() {
        boolean z10 = this.inLiveShow;
        String str = this.liveShowId;
        Boolean bool = this.viewer;
        return "InLiveShowHeartBeatEvent(inLiveShow=" + z10 + ", liveShowId=" + str + ", viewer=" + ((Object) bool) + ", consultRoomId=" + this.consultRoomId + ")";
    }

    public /* synthetic */ InLiveShowHeartBeatEvent(boolean z10, String str, Boolean bool, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : bool, (i10 & 8) != 0 ? null : str2);
    }
}
