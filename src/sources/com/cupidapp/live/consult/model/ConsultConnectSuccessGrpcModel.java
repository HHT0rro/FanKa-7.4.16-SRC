package com.cupidapp.live.consult.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectSuccessGrpcModel extends BaseConsultLiveGrpcModel {

    @Nullable
    private final String connectedUserReportData;

    @NotNull
    private final String requestId;

    @Nullable
    private final String tips;

    @NotNull
    private final User user;

    @NotNull
    private final String voiceConnectType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultConnectSuccessGrpcModel(@Nullable String str, @NotNull String voiceConnectType, @NotNull String requestId, @NotNull User user, @Nullable String str2, @Nullable String str3) {
        super(str);
        s.i(voiceConnectType, "voiceConnectType");
        s.i(requestId, "requestId");
        s.i(user, "user");
        this.voiceConnectType = voiceConnectType;
        this.requestId = requestId;
        this.user = user;
        this.connectedUserReportData = str2;
        this.tips = str3;
    }

    @Nullable
    public final String getConnectedUserReportData() {
        return this.connectedUserReportData;
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
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final String getVoiceConnectType() {
        return this.voiceConnectType;
    }
}
