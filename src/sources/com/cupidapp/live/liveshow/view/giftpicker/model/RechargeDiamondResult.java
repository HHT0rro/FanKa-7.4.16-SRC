package com.cupidapp.live.liveshow.view.giftpicker.model;

import b2.a;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DiamondResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RechargeDiamondResult {
    private final long balance;

    @Nullable
    private final BalanceModel rechargeTips;

    @Nullable
    private final SendGiftModel recommendGift;

    public RechargeDiamondResult(@Nullable SendGiftModel sendGiftModel, long j10, @Nullable BalanceModel balanceModel) {
        this.recommendGift = sendGiftModel;
        this.balance = j10;
        this.rechargeTips = balanceModel;
    }

    public static /* synthetic */ RechargeDiamondResult copy$default(RechargeDiamondResult rechargeDiamondResult, SendGiftModel sendGiftModel, long j10, BalanceModel balanceModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sendGiftModel = rechargeDiamondResult.recommendGift;
        }
        if ((i10 & 2) != 0) {
            j10 = rechargeDiamondResult.balance;
        }
        if ((i10 & 4) != 0) {
            balanceModel = rechargeDiamondResult.rechargeTips;
        }
        return rechargeDiamondResult.copy(sendGiftModel, j10, balanceModel);
    }

    @Nullable
    public final SendGiftModel component1() {
        return this.recommendGift;
    }

    public final long component2() {
        return this.balance;
    }

    @Nullable
    public final BalanceModel component3() {
        return this.rechargeTips;
    }

    @NotNull
    public final RechargeDiamondResult copy(@Nullable SendGiftModel sendGiftModel, long j10, @Nullable BalanceModel balanceModel) {
        return new RechargeDiamondResult(sendGiftModel, j10, balanceModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RechargeDiamondResult)) {
            return false;
        }
        RechargeDiamondResult rechargeDiamondResult = (RechargeDiamondResult) obj;
        return s.d(this.recommendGift, rechargeDiamondResult.recommendGift) && this.balance == rechargeDiamondResult.balance && s.d(this.rechargeTips, rechargeDiamondResult.rechargeTips);
    }

    public final long getBalance() {
        return this.balance;
    }

    @Nullable
    public final BalanceModel getRechargeTips() {
        return this.rechargeTips;
    }

    @Nullable
    public final SendGiftModel getRecommendGift() {
        return this.recommendGift;
    }

    public int hashCode() {
        SendGiftModel sendGiftModel = this.recommendGift;
        int hashCode = (((sendGiftModel == null ? 0 : sendGiftModel.hashCode()) * 31) + a.a(this.balance)) * 31;
        BalanceModel balanceModel = this.rechargeTips;
        return hashCode + (balanceModel != null ? balanceModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        SendGiftModel sendGiftModel = this.recommendGift;
        return "RechargeDiamondResult(recommendGift=" + ((Object) sendGiftModel) + ", balance=" + this.balance + ", rechargeTips=" + ((Object) this.rechargeTips) + ")";
    }
}
