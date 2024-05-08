package com.cupidapp.live.consult.model;

import b2.a;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectChargeResult {
    private final long balance;

    @Nullable
    private final String tips;

    public ConsultConnectChargeResult(long j10, @Nullable String str) {
        this.balance = j10;
        this.tips = str;
    }

    public static /* synthetic */ ConsultConnectChargeResult copy$default(ConsultConnectChargeResult consultConnectChargeResult, long j10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = consultConnectChargeResult.balance;
        }
        if ((i10 & 2) != 0) {
            str = consultConnectChargeResult.tips;
        }
        return consultConnectChargeResult.copy(j10, str);
    }

    public final long component1() {
        return this.balance;
    }

    @Nullable
    public final String component2() {
        return this.tips;
    }

    @NotNull
    public final ConsultConnectChargeResult copy(long j10, @Nullable String str) {
        return new ConsultConnectChargeResult(j10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultConnectChargeResult)) {
            return false;
        }
        ConsultConnectChargeResult consultConnectChargeResult = (ConsultConnectChargeResult) obj;
        return this.balance == consultConnectChargeResult.balance && s.d(this.tips, consultConnectChargeResult.tips);
    }

    public final long getBalance() {
        return this.balance;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        int a10 = a.a(this.balance) * 31;
        String str = this.tips;
        return a10 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "ConsultConnectChargeResult(balance=" + this.balance + ", tips=" + this.tips + ")";
    }
}
