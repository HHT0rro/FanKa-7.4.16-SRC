package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HeartbeatRequestModel extends BaseGrpcRequestModel {
    private final boolean active;

    @Nullable
    private final String liveShowId;
    private final long timestamp;

    @Nullable
    private final Boolean viewer;

    @Nullable
    private final String voiceRoomId;

    public /* synthetic */ HeartbeatRequestModel(long j10, String str, String str2, Boolean bool, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? Boolean.FALSE : bool, z10);
    }

    public final boolean getActive() {
        return this.active;
    }

    @Nullable
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @Override // com.cupidapp.live.base.grpc.BaseGrpcRequestModel
    @NotNull
    public CuConnectorOuterClass.MessageType getMessageType() {
        return CuConnectorOuterClass.MessageType.Heartbeat;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final Boolean getViewer() {
        return this.viewer;
    }

    @Nullable
    public final String getVoiceRoomId() {
        return this.voiceRoomId;
    }

    public HeartbeatRequestModel(long j10, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, boolean z10) {
        this.timestamp = j10;
        this.liveShowId = str;
        this.voiceRoomId = str2;
        this.viewer = bool;
        this.active = z10;
    }
}
