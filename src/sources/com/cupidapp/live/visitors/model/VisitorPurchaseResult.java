package com.cupidapp.live.visitors.model;

import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorPurchaseResult {

    @Nullable
    private final Long userStrategyEndTime;

    @Nullable
    private final List<VipPurchasePriceModel> vipAlipayHideOptions;

    @Nullable
    private final List<VipPurchasePriceModel> vipAlipayPublicOptions;

    @Nullable
    private final List<VipPurchasePriceModel> vipWechatHideOptions;

    @Nullable
    private final List<VipPurchasePriceModel> vipWechatPublicOptions;

    @Nullable
    private final List<VipPurchasePriceModel> visitorAlipayOptions;

    @Nullable
    private final List<VipPurchasePriceModel> visitorWechatOptions;

    public VisitorPurchaseResult(@Nullable List<VipPurchasePriceModel> list, @Nullable List<VipPurchasePriceModel> list2, @Nullable List<VipPurchasePriceModel> list3, @Nullable List<VipPurchasePriceModel> list4, @Nullable List<VipPurchasePriceModel> list5, @Nullable List<VipPurchasePriceModel> list6, @Nullable Long l10) {
        this.visitorAlipayOptions = list;
        this.vipAlipayPublicOptions = list2;
        this.vipAlipayHideOptions = list3;
        this.visitorWechatOptions = list4;
        this.vipWechatPublicOptions = list5;
        this.vipWechatHideOptions = list6;
        this.userStrategyEndTime = l10;
    }

    public static /* synthetic */ VisitorPurchaseResult copy$default(VisitorPurchaseResult visitorPurchaseResult, List list, List list2, List list3, List list4, List list5, List list6, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = visitorPurchaseResult.visitorAlipayOptions;
        }
        if ((i10 & 2) != 0) {
            list2 = visitorPurchaseResult.vipAlipayPublicOptions;
        }
        List list7 = list2;
        if ((i10 & 4) != 0) {
            list3 = visitorPurchaseResult.vipAlipayHideOptions;
        }
        List list8 = list3;
        if ((i10 & 8) != 0) {
            list4 = visitorPurchaseResult.visitorWechatOptions;
        }
        List list9 = list4;
        if ((i10 & 16) != 0) {
            list5 = visitorPurchaseResult.vipWechatPublicOptions;
        }
        List list10 = list5;
        if ((i10 & 32) != 0) {
            list6 = visitorPurchaseResult.vipWechatHideOptions;
        }
        List list11 = list6;
        if ((i10 & 64) != 0) {
            l10 = visitorPurchaseResult.userStrategyEndTime;
        }
        return visitorPurchaseResult.copy(list, list7, list8, list9, list10, list11, l10);
    }

    @Nullable
    public final List<VipPurchasePriceModel> component1() {
        return this.visitorAlipayOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> component2() {
        return this.vipAlipayPublicOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> component3() {
        return this.vipAlipayHideOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> component4() {
        return this.visitorWechatOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> component5() {
        return this.vipWechatPublicOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> component6() {
        return this.vipWechatHideOptions;
    }

    @Nullable
    public final Long component7() {
        return this.userStrategyEndTime;
    }

    @NotNull
    public final VisitorPurchaseResult copy(@Nullable List<VipPurchasePriceModel> list, @Nullable List<VipPurchasePriceModel> list2, @Nullable List<VipPurchasePriceModel> list3, @Nullable List<VipPurchasePriceModel> list4, @Nullable List<VipPurchasePriceModel> list5, @Nullable List<VipPurchasePriceModel> list6, @Nullable Long l10) {
        return new VisitorPurchaseResult(list, list2, list3, list4, list5, list6, l10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorPurchaseResult)) {
            return false;
        }
        VisitorPurchaseResult visitorPurchaseResult = (VisitorPurchaseResult) obj;
        return s.d(this.visitorAlipayOptions, visitorPurchaseResult.visitorAlipayOptions) && s.d(this.vipAlipayPublicOptions, visitorPurchaseResult.vipAlipayPublicOptions) && s.d(this.vipAlipayHideOptions, visitorPurchaseResult.vipAlipayHideOptions) && s.d(this.visitorWechatOptions, visitorPurchaseResult.visitorWechatOptions) && s.d(this.vipWechatPublicOptions, visitorPurchaseResult.vipWechatPublicOptions) && s.d(this.vipWechatHideOptions, visitorPurchaseResult.vipWechatHideOptions) && s.d(this.userStrategyEndTime, visitorPurchaseResult.userStrategyEndTime);
    }

    @Nullable
    public final Long getUserStrategyEndTime() {
        return this.userStrategyEndTime;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipAlipayHideOptions() {
        return this.vipAlipayHideOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipAlipayPublicOptions() {
        return this.vipAlipayPublicOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipWechatHideOptions() {
        return this.vipWechatHideOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipWechatPublicOptions() {
        return this.vipWechatPublicOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVisitorAlipayOptions() {
        return this.visitorAlipayOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVisitorWechatOptions() {
        return this.visitorWechatOptions;
    }

    public int hashCode() {
        List<VipPurchasePriceModel> list = this.visitorAlipayOptions;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<VipPurchasePriceModel> list2 = this.vipAlipayPublicOptions;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<VipPurchasePriceModel> list3 = this.vipAlipayHideOptions;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<VipPurchasePriceModel> list4 = this.visitorWechatOptions;
        int hashCode4 = (hashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<VipPurchasePriceModel> list5 = this.vipWechatPublicOptions;
        int hashCode5 = (hashCode4 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<VipPurchasePriceModel> list6 = this.vipWechatHideOptions;
        int hashCode6 = (hashCode5 + (list6 == null ? 0 : list6.hashCode())) * 31;
        Long l10 = this.userStrategyEndTime;
        return hashCode6 + (l10 != null ? l10.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VisitorPurchaseResult(visitorAlipayOptions=" + ((Object) this.visitorAlipayOptions) + ", vipAlipayPublicOptions=" + ((Object) this.vipAlipayPublicOptions) + ", vipAlipayHideOptions=" + ((Object) this.vipAlipayHideOptions) + ", visitorWechatOptions=" + ((Object) this.visitorWechatOptions) + ", vipWechatPublicOptions=" + ((Object) this.vipWechatPublicOptions) + ", vipWechatHideOptions=" + ((Object) this.vipWechatHideOptions) + ", userStrategyEndTime=" + ((Object) this.userStrategyEndTime) + ")";
    }

    public /* synthetic */ VisitorPurchaseResult(List list, List list2, List list3, List list4, List list5, List list6, Long l10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list, list2, list3, (i10 & 8) != 0 ? null : list4, list5, list6, (i10 & 64) != 0 ? null : l10);
    }
}
