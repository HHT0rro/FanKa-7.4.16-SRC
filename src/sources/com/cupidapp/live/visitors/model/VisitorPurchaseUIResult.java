package com.cupidapp.live.visitors.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorPurchaseUIResult {

    @Nullable
    private final List<VisitorsPurchasePriceModel> alipayOptions;

    @Nullable
    private final Long userStrategyEndTime;

    @Nullable
    private final List<VisitorsPurchasePriceModel> wechatOptions;

    public VisitorPurchaseUIResult() {
        this(null, null, null, 7, null);
    }

    public VisitorPurchaseUIResult(@Nullable List<VisitorsPurchasePriceModel> list, @Nullable List<VisitorsPurchasePriceModel> list2, @Nullable Long l10) {
        this.wechatOptions = list;
        this.alipayOptions = list2;
        this.userStrategyEndTime = l10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VisitorPurchaseUIResult copy$default(VisitorPurchaseUIResult visitorPurchaseUIResult, List list, List list2, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = visitorPurchaseUIResult.wechatOptions;
        }
        if ((i10 & 2) != 0) {
            list2 = visitorPurchaseUIResult.alipayOptions;
        }
        if ((i10 & 4) != 0) {
            l10 = visitorPurchaseUIResult.userStrategyEndTime;
        }
        return visitorPurchaseUIResult.copy(list, list2, l10);
    }

    @Nullable
    public final List<VisitorsPurchasePriceModel> component1() {
        return this.wechatOptions;
    }

    @Nullable
    public final List<VisitorsPurchasePriceModel> component2() {
        return this.alipayOptions;
    }

    @Nullable
    public final Long component3() {
        return this.userStrategyEndTime;
    }

    @NotNull
    public final VisitorPurchaseUIResult copy(@Nullable List<VisitorsPurchasePriceModel> list, @Nullable List<VisitorsPurchasePriceModel> list2, @Nullable Long l10) {
        return new VisitorPurchaseUIResult(list, list2, l10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorPurchaseUIResult)) {
            return false;
        }
        VisitorPurchaseUIResult visitorPurchaseUIResult = (VisitorPurchaseUIResult) obj;
        return s.d(this.wechatOptions, visitorPurchaseUIResult.wechatOptions) && s.d(this.alipayOptions, visitorPurchaseUIResult.alipayOptions) && s.d(this.userStrategyEndTime, visitorPurchaseUIResult.userStrategyEndTime);
    }

    @Nullable
    public final List<VisitorsPurchasePriceModel> getAlipayOptions() {
        return this.alipayOptions;
    }

    @Nullable
    public final Long getUserStrategyEndTime() {
        return this.userStrategyEndTime;
    }

    @Nullable
    public final List<VisitorsPurchasePriceModel> getWechatOptions() {
        return this.wechatOptions;
    }

    public int hashCode() {
        List<VisitorsPurchasePriceModel> list = this.wechatOptions;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<VisitorsPurchasePriceModel> list2 = this.alipayOptions;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Long l10 = this.userStrategyEndTime;
        return hashCode2 + (l10 != null ? l10.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VisitorPurchaseUIResult(wechatOptions=" + ((Object) this.wechatOptions) + ", alipayOptions=" + ((Object) this.alipayOptions) + ", userStrategyEndTime=" + ((Object) this.userStrategyEndTime) + ")";
    }

    public /* synthetic */ VisitorPurchaseUIResult(List list, List list2, Long l10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : list2, (i10 & 4) != 0 ? null : l10);
    }
}
