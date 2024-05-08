package com.cupidapp.live.liveshow.fanclub.model;

import b2.a;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AutoLightUpResult {
    private final long balance;

    public AutoLightUpResult(long j10) {
        this.balance = j10;
    }

    public static /* synthetic */ AutoLightUpResult copy$default(AutoLightUpResult autoLightUpResult, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = autoLightUpResult.balance;
        }
        return autoLightUpResult.copy(j10);
    }

    public final long component1() {
        return this.balance;
    }

    @NotNull
    public final AutoLightUpResult copy(long j10) {
        return new AutoLightUpResult(j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AutoLightUpResult) && this.balance == ((AutoLightUpResult) obj).balance;
    }

    public final long getBalance() {
        return this.balance;
    }

    public int hashCode() {
        return a.a(this.balance);
    }

    @NotNull
    public String toString() {
        return "AutoLightUpResult(balance=" + this.balance + ")";
    }
}
