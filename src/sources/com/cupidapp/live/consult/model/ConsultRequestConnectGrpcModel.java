package com.cupidapp.live.consult.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultRequestConnectGrpcModel extends BaseConsultLiveGrpcModel {
    private final boolean cancel;

    @NotNull
    private final String requestId;

    @NotNull
    private final User user;

    @NotNull
    private final String voiceConnectType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultRequestConnectGrpcModel(@Nullable String str, @NotNull User user, @NotNull String voiceConnectType, boolean z10, @NotNull String requestId) {
        super(str);
        s.i(user, "user");
        s.i(voiceConnectType, "voiceConnectType");
        s.i(requestId, "requestId");
        this.user = user;
        this.voiceConnectType = voiceConnectType;
        this.cancel = z10;
        this.requestId = requestId;
    }

    public final boolean getCancel() {
        return this.cancel;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final String getVoiceConnectType() {
        return this.voiceConnectType;
    }
}
