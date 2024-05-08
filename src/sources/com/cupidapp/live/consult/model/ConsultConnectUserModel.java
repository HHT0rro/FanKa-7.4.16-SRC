package com.cupidapp.live.consult.model;

import b2.a;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectUserModel implements Serializable {

    @Nullable
    private final String connectedUserReportData;

    @Nullable
    private final String requestId;
    private final long startDurationMills;
    private final long startTimeMills;

    @NotNull
    private final User user;

    public ConsultConnectUserModel(@NotNull User user, @Nullable String str, long j10, long j11, @Nullable String str2) {
        s.i(user, "user");
        this.user = user;
        this.requestId = str;
        this.startDurationMills = j10;
        this.startTimeMills = j11;
        this.connectedUserReportData = str2;
    }

    public static /* synthetic */ ConsultConnectUserModel copy$default(ConsultConnectUserModel consultConnectUserModel, User user, String str, long j10, long j11, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = consultConnectUserModel.user;
        }
        if ((i10 & 2) != 0) {
            str = consultConnectUserModel.requestId;
        }
        String str3 = str;
        if ((i10 & 4) != 0) {
            j10 = consultConnectUserModel.startDurationMills;
        }
        long j12 = j10;
        if ((i10 & 8) != 0) {
            j11 = consultConnectUserModel.startTimeMills;
        }
        long j13 = j11;
        if ((i10 & 16) != 0) {
            str2 = consultConnectUserModel.connectedUserReportData;
        }
        return consultConnectUserModel.copy(user, str3, j12, j13, str2);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final String component2() {
        return this.requestId;
    }

    public final long component3() {
        return this.startDurationMills;
    }

    public final long component4() {
        return this.startTimeMills;
    }

    @Nullable
    public final String component5() {
        return this.connectedUserReportData;
    }

    @NotNull
    public final ConsultConnectUserModel copy(@NotNull User user, @Nullable String str, long j10, long j11, @Nullable String str2) {
        s.i(user, "user");
        return new ConsultConnectUserModel(user, str, j10, j11, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultConnectUserModel)) {
            return false;
        }
        ConsultConnectUserModel consultConnectUserModel = (ConsultConnectUserModel) obj;
        return s.d(this.user, consultConnectUserModel.user) && s.d(this.requestId, consultConnectUserModel.requestId) && this.startDurationMills == consultConnectUserModel.startDurationMills && this.startTimeMills == consultConnectUserModel.startTimeMills && s.d(this.connectedUserReportData, consultConnectUserModel.connectedUserReportData);
    }

    @Nullable
    public final String getConnectedUserReportData() {
        return this.connectedUserReportData;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    public final long getStartDurationMills() {
        return this.startDurationMills;
    }

    public final long getStartTimeMills() {
        return this.startTimeMills;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        String str = this.requestId;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.startDurationMills)) * 31) + a.a(this.startTimeMills)) * 31;
        String str2 = this.connectedUserReportData;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "ConsultConnectUserModel(user=" + ((Object) user) + ", requestId=" + this.requestId + ", startDurationMills=" + this.startDurationMills + ", startTimeMills=" + this.startTimeMills + ", connectedUserReportData=" + this.connectedUserReportData + ")";
    }
}
