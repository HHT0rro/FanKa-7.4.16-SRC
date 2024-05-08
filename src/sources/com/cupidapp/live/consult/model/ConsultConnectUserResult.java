package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectUserResult {

    @Nullable
    private final ConsultConnectUserModel connectingUserInfo;

    public ConsultConnectUserResult(@Nullable ConsultConnectUserModel consultConnectUserModel) {
        this.connectingUserInfo = consultConnectUserModel;
    }

    public static /* synthetic */ ConsultConnectUserResult copy$default(ConsultConnectUserResult consultConnectUserResult, ConsultConnectUserModel consultConnectUserModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            consultConnectUserModel = consultConnectUserResult.connectingUserInfo;
        }
        return consultConnectUserResult.copy(consultConnectUserModel);
    }

    @Nullable
    public final ConsultConnectUserModel component1() {
        return this.connectingUserInfo;
    }

    @NotNull
    public final ConsultConnectUserResult copy(@Nullable ConsultConnectUserModel consultConnectUserModel) {
        return new ConsultConnectUserResult(consultConnectUserModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsultConnectUserResult) && s.d(this.connectingUserInfo, ((ConsultConnectUserResult) obj).connectingUserInfo);
    }

    @Nullable
    public final ConsultConnectUserModel getConnectingUserInfo() {
        return this.connectingUserInfo;
    }

    public int hashCode() {
        ConsultConnectUserModel consultConnectUserModel = this.connectingUserInfo;
        if (consultConnectUserModel == null) {
            return 0;
        }
        return consultConnectUserModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConsultConnectUserResult(connectingUserInfo=" + ((Object) this.connectingUserInfo) + ")";
    }
}
