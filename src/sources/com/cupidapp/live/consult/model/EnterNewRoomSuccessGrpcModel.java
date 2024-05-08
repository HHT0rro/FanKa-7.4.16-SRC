package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EnterNewRoomSuccessGrpcModel extends BaseConsultLiveGrpcModel {

    @NotNull
    private final String newRoomId;

    @NotNull
    private final String privateMapKey;

    @NotNull
    private final String voiceConnectType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterNewRoomSuccessGrpcModel(@Nullable String str, @NotNull String voiceConnectType, @NotNull String newRoomId, @NotNull String privateMapKey) {
        super(str);
        s.i(voiceConnectType, "voiceConnectType");
        s.i(newRoomId, "newRoomId");
        s.i(privateMapKey, "privateMapKey");
        this.voiceConnectType = voiceConnectType;
        this.newRoomId = newRoomId;
        this.privateMapKey = privateMapKey;
    }

    @NotNull
    public final String getNewRoomId() {
        return this.newRoomId;
    }

    @NotNull
    public final String getPrivateMapKey() {
        return this.privateMapKey;
    }

    @NotNull
    public final String getVoiceConnectType() {
        return this.voiceConnectType;
    }
}
