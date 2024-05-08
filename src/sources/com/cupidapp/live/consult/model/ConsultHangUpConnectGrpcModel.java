package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultHangUpConnectGrpcModel extends BaseConsultLiveGrpcModel {

    @Nullable
    private final String reason;

    @NotNull
    private final String requestId;

    @Nullable
    private final String tips;

    @NotNull
    private final String voiceConnectType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultHangUpConnectGrpcModel(@Nullable String str, @Nullable String str2, @NotNull String voiceConnectType, @NotNull String requestId, @Nullable String str3) {
        super(str);
        s.i(voiceConnectType, "voiceConnectType");
        s.i(requestId, "requestId");
        this.reason = str2;
        this.voiceConnectType = voiceConnectType;
        this.requestId = requestId;
        this.tips = str3;
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    @NotNull
    public final String getVoiceConnectType() {
        return this.voiceConnectType;
    }
}
