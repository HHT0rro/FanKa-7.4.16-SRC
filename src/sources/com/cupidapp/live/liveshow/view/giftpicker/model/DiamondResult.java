package com.cupidapp.live.liveshow.view.giftpicker.model;

import b2.a;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DiamondResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DiamondResult {
    private final long balance;

    @Nullable
    private final String diamondRechargeTosUrl;

    @Nullable
    private final List<RechargeRewardModel> firstBuyOffers;

    @NotNull
    private final List<DiamondModel> products;

    @Nullable
    private final String rechargeHistoryWebUrl;

    @Nullable
    private final String rechargeRuleUrl;

    @Nullable
    private final BalanceModel rechargeTips;

    public DiamondResult(@NotNull List<DiamondModel> products, long j10, @Nullable String str, @Nullable BalanceModel balanceModel, @Nullable List<RechargeRewardModel> list, @Nullable String str2, @Nullable String str3) {
        s.i(products, "products");
        this.products = products;
        this.balance = j10;
        this.rechargeRuleUrl = str;
        this.rechargeTips = balanceModel;
        this.firstBuyOffers = list;
        this.rechargeHistoryWebUrl = str2;
        this.diamondRechargeTosUrl = str3;
    }

    @NotNull
    public final List<DiamondModel> component1() {
        return this.products;
    }

    public final long component2() {
        return this.balance;
    }

    @Nullable
    public final String component3() {
        return this.rechargeRuleUrl;
    }

    @Nullable
    public final BalanceModel component4() {
        return this.rechargeTips;
    }

    @Nullable
    public final List<RechargeRewardModel> component5() {
        return this.firstBuyOffers;
    }

    @Nullable
    public final String component6() {
        return this.rechargeHistoryWebUrl;
    }

    @Nullable
    public final String component7() {
        return this.diamondRechargeTosUrl;
    }

    @NotNull
    public final DiamondResult copy(@NotNull List<DiamondModel> products, long j10, @Nullable String str, @Nullable BalanceModel balanceModel, @Nullable List<RechargeRewardModel> list, @Nullable String str2, @Nullable String str3) {
        s.i(products, "products");
        return new DiamondResult(products, j10, str, balanceModel, list, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiamondResult)) {
            return false;
        }
        DiamondResult diamondResult = (DiamondResult) obj;
        return s.d(this.products, diamondResult.products) && this.balance == diamondResult.balance && s.d(this.rechargeRuleUrl, diamondResult.rechargeRuleUrl) && s.d(this.rechargeTips, diamondResult.rechargeTips) && s.d(this.firstBuyOffers, diamondResult.firstBuyOffers) && s.d(this.rechargeHistoryWebUrl, diamondResult.rechargeHistoryWebUrl) && s.d(this.diamondRechargeTosUrl, diamondResult.diamondRechargeTosUrl);
    }

    public final long getBalance() {
        return this.balance;
    }

    @Nullable
    public final String getDiamondRechargeTosUrl() {
        return this.diamondRechargeTosUrl;
    }

    @Nullable
    public final List<RechargeRewardModel> getFirstBuyOffers() {
        return this.firstBuyOffers;
    }

    @NotNull
    public final List<DiamondModel> getProducts() {
        return this.products;
    }

    @Nullable
    public final String getRechargeHistoryWebUrl() {
        return this.rechargeHistoryWebUrl;
    }

    @Nullable
    public final String getRechargeRuleUrl() {
        return this.rechargeRuleUrl;
    }

    @Nullable
    public final BalanceModel getRechargeTips() {
        return this.rechargeTips;
    }

    public int hashCode() {
        int hashCode = ((this.products.hashCode() * 31) + a.a(this.balance)) * 31;
        String str = this.rechargeRuleUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        BalanceModel balanceModel = this.rechargeTips;
        int hashCode3 = (hashCode2 + (balanceModel == null ? 0 : balanceModel.hashCode())) * 31;
        List<RechargeRewardModel> list = this.firstBuyOffers;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.rechargeHistoryWebUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.diamondRechargeTosUrl;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<DiamondModel> list = this.products;
        long j10 = this.balance;
        String str = this.rechargeRuleUrl;
        BalanceModel balanceModel = this.rechargeTips;
        List<RechargeRewardModel> list2 = this.firstBuyOffers;
        return "DiamondResult(products=" + ((Object) list) + ", balance=" + j10 + ", rechargeRuleUrl=" + str + ", rechargeTips=" + ((Object) balanceModel) + ", firstBuyOffers=" + ((Object) list2) + ", rechargeHistoryWebUrl=" + this.rechargeHistoryWebUrl + ", diamondRechargeTosUrl=" + this.diamondRechargeTosUrl + ")";
    }
}
