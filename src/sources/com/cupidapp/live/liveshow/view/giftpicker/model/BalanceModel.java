package com.cupidapp.live.liveshow.view.giftpicker.model;

import b2.a;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DiamondResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BalanceModel {
    private final long genericBalance;

    @Nullable
    private final Long nobilityBalance;

    @Nullable
    private final String tips;

    public BalanceModel(long j10, @Nullable Long l10, @Nullable String str) {
        this.genericBalance = j10;
        this.nobilityBalance = l10;
        this.tips = str;
    }

    public static /* synthetic */ BalanceModel copy$default(BalanceModel balanceModel, long j10, Long l10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = balanceModel.genericBalance;
        }
        if ((i10 & 2) != 0) {
            l10 = balanceModel.nobilityBalance;
        }
        if ((i10 & 4) != 0) {
            str = balanceModel.tips;
        }
        return balanceModel.copy(j10, l10, str);
    }

    public final long component1() {
        return this.genericBalance;
    }

    @Nullable
    public final Long component2() {
        return this.nobilityBalance;
    }

    @Nullable
    public final String component3() {
        return this.tips;
    }

    @NotNull
    public final BalanceModel copy(long j10, @Nullable Long l10, @Nullable String str) {
        return new BalanceModel(j10, l10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BalanceModel)) {
            return false;
        }
        BalanceModel balanceModel = (BalanceModel) obj;
        return this.genericBalance == balanceModel.genericBalance && s.d(this.nobilityBalance, balanceModel.nobilityBalance) && s.d(this.tips, balanceModel.tips);
    }

    public final long getGenericBalance() {
        return this.genericBalance;
    }

    @Nullable
    public final Long getNobilityBalance() {
        return this.nobilityBalance;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        int a10 = a.a(this.genericBalance) * 31;
        Long l10 = this.nobilityBalance;
        int hashCode = (a10 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.tips;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        long j10 = this.genericBalance;
        Long l10 = this.nobilityBalance;
        return "BalanceModel(genericBalance=" + j10 + ", nobilityBalance=" + ((Object) l10) + ", tips=" + this.tips + ")";
    }
}
