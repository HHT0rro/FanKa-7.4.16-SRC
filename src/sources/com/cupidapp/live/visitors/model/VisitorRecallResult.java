package com.cupidapp.live.visitors.model;

import com.cupidapp.live.base.network.model.ImageModel;
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
public final class VisitorRecallResult {

    @Nullable
    private final List<VipPurchasePriceModel> alipayOptions;

    @Nullable
    private final String discountReason;

    @Nullable
    private final ImageModel imageUrl;

    @Nullable
    private final Long userStrategyEndTime;

    @Nullable
    private final List<VipPurchasePriceModel> wechatOptions;

    public VisitorRecallResult(@Nullable List<VipPurchasePriceModel> list, @Nullable List<VipPurchasePriceModel> list2, @Nullable Long l10, @Nullable ImageModel imageModel, @Nullable String str) {
        this.wechatOptions = list;
        this.alipayOptions = list2;
        this.userStrategyEndTime = l10;
        this.imageUrl = imageModel;
        this.discountReason = str;
    }

    public static /* synthetic */ VisitorRecallResult copy$default(VisitorRecallResult visitorRecallResult, List list, List list2, Long l10, ImageModel imageModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = visitorRecallResult.wechatOptions;
        }
        if ((i10 & 2) != 0) {
            list2 = visitorRecallResult.alipayOptions;
        }
        List list3 = list2;
        if ((i10 & 4) != 0) {
            l10 = visitorRecallResult.userStrategyEndTime;
        }
        Long l11 = l10;
        if ((i10 & 8) != 0) {
            imageModel = visitorRecallResult.imageUrl;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 16) != 0) {
            str = visitorRecallResult.discountReason;
        }
        return visitorRecallResult.copy(list, list3, l11, imageModel2, str);
    }

    @Nullable
    public final List<VipPurchasePriceModel> component1() {
        return this.wechatOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> component2() {
        return this.alipayOptions;
    }

    @Nullable
    public final Long component3() {
        return this.userStrategyEndTime;
    }

    @Nullable
    public final ImageModel component4() {
        return this.imageUrl;
    }

    @Nullable
    public final String component5() {
        return this.discountReason;
    }

    @NotNull
    public final VisitorRecallResult copy(@Nullable List<VipPurchasePriceModel> list, @Nullable List<VipPurchasePriceModel> list2, @Nullable Long l10, @Nullable ImageModel imageModel, @Nullable String str) {
        return new VisitorRecallResult(list, list2, l10, imageModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorRecallResult)) {
            return false;
        }
        VisitorRecallResult visitorRecallResult = (VisitorRecallResult) obj;
        return s.d(this.wechatOptions, visitorRecallResult.wechatOptions) && s.d(this.alipayOptions, visitorRecallResult.alipayOptions) && s.d(this.userStrategyEndTime, visitorRecallResult.userStrategyEndTime) && s.d(this.imageUrl, visitorRecallResult.imageUrl) && s.d(this.discountReason, visitorRecallResult.discountReason);
    }

    @Nullable
    public final List<VipPurchasePriceModel> getAlipayOptions() {
        return this.alipayOptions;
    }

    @Nullable
    public final String getDiscountReason() {
        return this.discountReason;
    }

    @Nullable
    public final ImageModel getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final Long getUserStrategyEndTime() {
        return this.userStrategyEndTime;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getWechatOptions() {
        return this.wechatOptions;
    }

    public int hashCode() {
        List<VipPurchasePriceModel> list = this.wechatOptions;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<VipPurchasePriceModel> list2 = this.alipayOptions;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Long l10 = this.userStrategyEndTime;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        ImageModel imageModel = this.imageUrl;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.discountReason;
        return hashCode4 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<VipPurchasePriceModel> list = this.wechatOptions;
        List<VipPurchasePriceModel> list2 = this.alipayOptions;
        Long l10 = this.userStrategyEndTime;
        ImageModel imageModel = this.imageUrl;
        return "VisitorRecallResult(wechatOptions=" + ((Object) list) + ", alipayOptions=" + ((Object) list2) + ", userStrategyEndTime=" + ((Object) l10) + ", imageUrl=" + ((Object) imageModel) + ", discountReason=" + this.discountReason + ")";
    }

    public /* synthetic */ VisitorRecallResult(List list, List list2, Long l10, ImageModel imageModel, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : list2, l10, (i10 & 8) != 0 ? null : imageModel, (i10 & 16) != 0 ? null : str);
    }
}
