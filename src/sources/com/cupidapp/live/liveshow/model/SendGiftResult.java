package com.cupidapp.live.liveshow.model;

import b2.a;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendGiftResult {
    private final long balance;

    @Nullable
    private final Boolean giftPackageAnimationEnabled;

    public SendGiftResult(long j10, @Nullable Boolean bool) {
        this.balance = j10;
        this.giftPackageAnimationEnabled = bool;
    }

    public static /* synthetic */ SendGiftResult copy$default(SendGiftResult sendGiftResult, long j10, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = sendGiftResult.balance;
        }
        if ((i10 & 2) != 0) {
            bool = sendGiftResult.giftPackageAnimationEnabled;
        }
        return sendGiftResult.copy(j10, bool);
    }

    public final long component1() {
        return this.balance;
    }

    @Nullable
    public final Boolean component2() {
        return this.giftPackageAnimationEnabled;
    }

    @NotNull
    public final SendGiftResult copy(long j10, @Nullable Boolean bool) {
        return new SendGiftResult(j10, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendGiftResult)) {
            return false;
        }
        SendGiftResult sendGiftResult = (SendGiftResult) obj;
        return this.balance == sendGiftResult.balance && s.d(this.giftPackageAnimationEnabled, sendGiftResult.giftPackageAnimationEnabled);
    }

    public final long getBalance() {
        return this.balance;
    }

    @Nullable
    public final Boolean getGiftPackageAnimationEnabled() {
        return this.giftPackageAnimationEnabled;
    }

    public int hashCode() {
        int a10 = a.a(this.balance) * 31;
        Boolean bool = this.giftPackageAnimationEnabled;
        return a10 + (bool == null ? 0 : bool.hashCode());
    }

    @NotNull
    public String toString() {
        return "SendGiftResult(balance=" + this.balance + ", giftPackageAnimationEnabled=" + ((Object) this.giftPackageAnimationEnabled) + ")";
    }

    public /* synthetic */ SendGiftResult(long j10, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, (i10 & 2) != 0 ? Boolean.FALSE : bool);
    }
}
