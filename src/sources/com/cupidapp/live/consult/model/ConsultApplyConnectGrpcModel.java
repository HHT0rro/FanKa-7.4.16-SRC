package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultApplyConnectGrpcModel extends BaseConsultLiveGrpcModel {

    @Nullable
    private final String newRoomId;

    @NotNull
    private final String privateMapKey;

    @NotNull
    private final String requestId;

    @NotNull
    private final String voiceConnectType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultApplyConnectGrpcModel(@Nullable String str, @NotNull String voiceConnectType, @NotNull String requestId, @Nullable String str2, @NotNull String privateMapKey) {
        super(str);
        s.i(voiceConnectType, "voiceConnectType");
        s.i(requestId, "requestId");
        s.i(privateMapKey, "privateMapKey");
        this.voiceConnectType = voiceConnectType;
        this.requestId = requestId;
        this.newRoomId = str2;
        this.privateMapKey = privateMapKey;
    }

    @Nullable
    public final String getNewRoomId() {
        return this.newRoomId;
    }

    @NotNull
    public final String getPrivateMapKey() {
        return this.privateMapKey;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getVoiceConnectType() {
        return this.voiceConnectType;
    }
}
