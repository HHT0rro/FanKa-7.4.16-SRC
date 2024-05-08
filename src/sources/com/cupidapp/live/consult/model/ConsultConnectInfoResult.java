package com.cupidapp.live.consult.model;

import b2.a;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectInfoResult implements Serializable {
    private final long balance;

    @NotNull
    private final ConsultConnectInfoModel connectInfo;

    public ConsultConnectInfoResult(long j10, @NotNull ConsultConnectInfoModel connectInfo) {
        s.i(connectInfo, "connectInfo");
        this.balance = j10;
        this.connectInfo = connectInfo;
    }

    public static /* synthetic */ ConsultConnectInfoResult copy$default(ConsultConnectInfoResult consultConnectInfoResult, long j10, ConsultConnectInfoModel consultConnectInfoModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = consultConnectInfoResult.balance;
        }
        if ((i10 & 2) != 0) {
            consultConnectInfoModel = consultConnectInfoResult.connectInfo;
        }
        return consultConnectInfoResult.copy(j10, consultConnectInfoModel);
    }

    public final long component1() {
        return this.balance;
    }

    @NotNull
    public final ConsultConnectInfoModel component2() {
        return this.connectInfo;
    }

    @NotNull
    public final ConsultConnectInfoResult copy(long j10, @NotNull ConsultConnectInfoModel connectInfo) {
        s.i(connectInfo, "connectInfo");
        return new ConsultConnectInfoResult(j10, connectInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultConnectInfoResult)) {
            return false;
        }
        ConsultConnectInfoResult consultConnectInfoResult = (ConsultConnectInfoResult) obj;
        return this.balance == consultConnectInfoResult.balance && s.d(this.connectInfo, consultConnectInfoResult.connectInfo);
    }

    public final long getBalance() {
        return this.balance;
    }

    @NotNull
    public final ConsultConnectInfoModel getConnectInfo() {
        return this.connectInfo;
    }

    public int hashCode() {
        return (a.a(this.balance) * 31) + this.connectInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConsultConnectInfoResult(balance=" + this.balance + ", connectInfo=" + ((Object) this.connectInfo) + ")";
    }
}
