package com.cupidapp.live.consult.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConnectOrderModel {

    @NotNull
    private final String requestId;
    private final int state;

    @NotNull
    private final User user;

    @NotNull
    private final String voiceConnectType;

    public ConnectOrderModel(@NotNull User user, int i10, @NotNull String requestId, @NotNull String voiceConnectType) {
        s.i(user, "user");
        s.i(requestId, "requestId");
        s.i(voiceConnectType, "voiceConnectType");
        this.user = user;
        this.state = i10;
        this.requestId = requestId;
        this.voiceConnectType = voiceConnectType;
    }

    public static /* synthetic */ ConnectOrderModel copy$default(ConnectOrderModel connectOrderModel, User user, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            user = connectOrderModel.user;
        }
        if ((i11 & 2) != 0) {
            i10 = connectOrderModel.state;
        }
        if ((i11 & 4) != 0) {
            str = connectOrderModel.requestId;
        }
        if ((i11 & 8) != 0) {
            str2 = connectOrderModel.voiceConnectType;
        }
        return connectOrderModel.copy(user, i10, str, str2);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    public final int component2() {
        return this.state;
    }

    @NotNull
    public final String component3() {
        return this.requestId;
    }

    @NotNull
    public final String component4() {
        return this.voiceConnectType;
    }

    @NotNull
    public final ConnectOrderModel copy(@NotNull User user, int i10, @NotNull String requestId, @NotNull String voiceConnectType) {
        s.i(user, "user");
        s.i(requestId, "requestId");
        s.i(voiceConnectType, "voiceConnectType");
        return new ConnectOrderModel(user, i10, requestId, voiceConnectType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectOrderModel)) {
            return false;
        }
        ConnectOrderModel connectOrderModel = (ConnectOrderModel) obj;
        return s.d(this.user, connectOrderModel.user) && this.state == connectOrderModel.state && s.d(this.requestId, connectOrderModel.requestId) && s.d(this.voiceConnectType, connectOrderModel.voiceConnectType);
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    public final int getState() {
        return this.state;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final String getVoiceConnectType() {
        return this.voiceConnectType;
    }

    public int hashCode() {
        return (((((this.user.hashCode() * 31) + this.state) * 31) + this.requestId.hashCode()) * 31) + this.voiceConnectType.hashCode();
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "ConnectOrderModel(user=" + ((Object) user) + ", state=" + this.state + ", requestId=" + this.requestId + ", voiceConnectType=" + this.voiceConnectType + ")";
    }
}
