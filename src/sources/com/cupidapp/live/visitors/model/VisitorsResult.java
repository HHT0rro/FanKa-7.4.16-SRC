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
public final class VisitorsResult {

    @Nullable
    private final Integer actCodes;

    @Nullable
    private final String description;
    private final boolean haveVisitors;

    @Nullable
    private final List<VisitorModel> list;

    @Nullable
    private Boolean redDot;

    @Nullable
    private final String title;

    @Nullable
    private final Long userStrategyEndTime;

    @Nullable
    private final Long validDate;

    @Nullable
    private final List<VisitorsPurchasePriceModel> visitorAlipayOptions;
    private final boolean visitorEnable;

    @Nullable
    private final List<VisitorMarketingInfoModel> visitorMarketingInfo;

    @Nullable
    private final List<VisitorsPurchasePriceModel> visitorWechatOptions;

    public VisitorsResult(boolean z10, boolean z11, @Nullable Boolean bool, @Nullable List<VisitorModel> list, @Nullable Long l10, @Nullable List<VisitorMarketingInfoModel> list2, @Nullable List<VisitorsPurchasePriceModel> list3, @Nullable List<VisitorsPurchasePriceModel> list4, @Nullable String str, @Nullable Long l11, @Nullable Integer num, @Nullable String str2) {
        this.visitorEnable = z10;
        this.haveVisitors = z11;
        this.redDot = bool;
        this.list = list;
        this.validDate = l10;
        this.visitorMarketingInfo = list2;
        this.visitorAlipayOptions = list3;
        this.visitorWechatOptions = list4;
        this.description = str;
        this.userStrategyEndTime = l11;
        this.actCodes = num;
        this.title = str2;
    }

    public final boolean component1() {
        return this.visitorEnable;
    }

    @Nullable
    public final Long component10() {
        return this.userStrategyEndTime;
    }

    @Nullable
    public final Integer component11() {
        return this.actCodes;
    }

    @Nullable
    public final String component12() {
        return this.title;
    }

    public final boolean component2() {
        return this.haveVisitors;
    }

    @Nullable
    public final Boolean component3() {
        return this.redDot;
    }

    @Nullable
    public final List<VisitorModel> component4() {
        return this.list;
    }

    @Nullable
    public final Long component5() {
        return this.validDate;
    }

    @Nullable
    public final List<VisitorMarketingInfoModel> component6() {
        return this.visitorMarketingInfo;
    }

    @Nullable
    public final List<VisitorsPurchasePriceModel> component7() {
        return this.visitorAlipayOptions;
    }

    @Nullable
    public final List<VisitorsPurchasePriceModel> component8() {
        return this.visitorWechatOptions;
    }

    @Nullable
    public final String component9() {
        return this.description;
    }

    @NotNull
    public final VisitorsResult copy(boolean z10, boolean z11, @Nullable Boolean bool, @Nullable List<VisitorModel> list, @Nullable Long l10, @Nullable List<VisitorMarketingInfoModel> list2, @Nullable List<VisitorsPurchasePriceModel> list3, @Nullable List<VisitorsPurchasePriceModel> list4, @Nullable String str, @Nullable Long l11, @Nullable Integer num, @Nullable String str2) {
        return new VisitorsResult(z10, z11, bool, list, l10, list2, list3, list4, str, l11, num, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorsResult)) {
            return false;
        }
        VisitorsResult visitorsResult = (VisitorsResult) obj;
        return this.visitorEnable == visitorsResult.visitorEnable && this.haveVisitors == visitorsResult.haveVisitors && s.d(this.redDot, visitorsResult.redDot) && s.d(this.list, visitorsResult.list) && s.d(this.validDate, visitorsResult.validDate) && s.d(this.visitorMarketingInfo, visitorsResult.visitorMarketingInfo) && s.d(this.visitorAlipayOptions, visitorsResult.visitorAlipayOptions) && s.d(this.visitorWechatOptions, visitorsResult.visitorWechatOptions) && s.d(this.description, visitorsResult.description) && s.d(this.userStrategyEndTime, visitorsResult.userStrategyEndTime) && s.d(this.actCodes, visitorsResult.actCodes) && s.d(this.title, visitorsResult.title);
    }

    @Nullable
    public final Integer getActCodes() {
        return this.actCodes;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    public final boolean getHaveVisitors() {
        return this.haveVisitors;
    }

    @Nullable
    public final List<VisitorModel> getList() {
        return this.list;
    }

    @Nullable
    public final Boolean getRedDot() {
        return this.redDot;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Long getUserStrategyEndTime() {
        return this.userStrategyEndTime;
    }

    @Nullable
    public final Long getValidDate() {
        return this.validDate;
    }

    @Nullable
    public final List<VisitorsPurchasePriceModel> getVisitorAlipayOptions() {
        return this.visitorAlipayOptions;
    }

    public final boolean getVisitorEnable() {
        return this.visitorEnable;
    }

    @Nullable
    public final List<VisitorMarketingInfoModel> getVisitorMarketingInfo() {
        return this.visitorMarketingInfo;
    }

    @Nullable
    public final List<VisitorsPurchasePriceModel> getVisitorWechatOptions() {
        return this.visitorWechatOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    public int hashCode() {
        boolean z10 = this.visitorEnable;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.haveVisitors;
        int i11 = (i10 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        Boolean bool = this.redDot;
        int hashCode = (i11 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<VisitorModel> list = this.list;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Long l10 = this.validDate;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        List<VisitorMarketingInfoModel> list2 = this.visitorMarketingInfo;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<VisitorsPurchasePriceModel> list3 = this.visitorAlipayOptions;
        int hashCode5 = (hashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<VisitorsPurchasePriceModel> list4 = this.visitorWechatOptions;
        int hashCode6 = (hashCode5 + (list4 == null ? 0 : list4.hashCode())) * 31;
        String str = this.description;
        int hashCode7 = (hashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        Long l11 = this.userStrategyEndTime;
        int hashCode8 = (hashCode7 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num = this.actCodes;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.title;
        return hashCode9 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setRedDot(@Nullable Boolean bool) {
        this.redDot = bool;
    }

    @NotNull
    public String toString() {
        boolean z10 = this.visitorEnable;
        boolean z11 = this.haveVisitors;
        Boolean bool = this.redDot;
        List<VisitorModel> list = this.list;
        Long l10 = this.validDate;
        List<VisitorMarketingInfoModel> list2 = this.visitorMarketingInfo;
        List<VisitorsPurchasePriceModel> list3 = this.visitorAlipayOptions;
        List<VisitorsPurchasePriceModel> list4 = this.visitorWechatOptions;
        String str = this.description;
        Long l11 = this.userStrategyEndTime;
        Integer num = this.actCodes;
        return "VisitorsResult(visitorEnable=" + z10 + ", haveVisitors=" + z11 + ", redDot=" + ((Object) bool) + ", list=" + ((Object) list) + ", validDate=" + ((Object) l10) + ", visitorMarketingInfo=" + ((Object) list2) + ", visitorAlipayOptions=" + ((Object) list3) + ", visitorWechatOptions=" + ((Object) list4) + ", description=" + str + ", userStrategyEndTime=" + ((Object) l11) + ", actCodes=" + ((Object) num) + ", title=" + this.title + ")";
    }

    public /* synthetic */ VisitorsResult(boolean z10, boolean z11, Boolean bool, List list, Long l10, List list2, List list3, List list4, String str, Long l11, Integer num, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? Boolean.FALSE : bool, (i10 & 8) != 0 ? null : list, l10, (i10 & 32) != 0 ? null : list2, (i10 & 64) != 0 ? null : list3, (i10 & 128) != 0 ? null : list4, (i10 & 256) != 0 ? null : str, (i10 & 512) != 0 ? null : l11, (i10 & 1024) != 0 ? null : num, (i10 & 2048) != 0 ? null : str2);
    }
}
