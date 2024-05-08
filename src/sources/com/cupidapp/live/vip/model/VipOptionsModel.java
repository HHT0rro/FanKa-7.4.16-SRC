package com.cupidapp.live.vip.model;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchasePriceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipOptionsModel {
    private final boolean remindFlag;

    @Nullable
    private final String superLikePurchaseDescription;
    private final long userStrategyEndTime;

    @Nullable
    private final List<VipPurchasePriceModel> vipAlipayHideOptions;

    @Nullable
    private final List<VipPurchasePriceModel> vipAlipayOptions;

    @Nullable
    private final List<VipPurchasePriceModel> vipAlipayPublicOptions;

    @Nullable
    private final VipClientUiInfoModel vipClientUiInfo;

    @Nullable
    private final List<VipPurchasePriceModel> vipWechatHideOptions;

    @Nullable
    private final List<VipPurchasePriceModel> vipWechatOptions;

    @Nullable
    private final List<VipPurchasePriceModel> vipWechatPublicOptions;

    /* compiled from: VipPurchasePriceModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18812a;

        static {
            int[] iArr = new int[PayType.values().length];
            try {
                iArr[PayType.WeChatPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f18812a = iArr;
        }
    }

    public VipOptionsModel(@Nullable List<VipPurchasePriceModel> list, @Nullable List<VipPurchasePriceModel> list2, @Nullable List<VipPurchasePriceModel> list3, @Nullable List<VipPurchasePriceModel> list4, @Nullable List<VipPurchasePriceModel> list5, @Nullable List<VipPurchasePriceModel> list6, boolean z10, @Nullable String str, long j10, @Nullable VipClientUiInfoModel vipClientUiInfoModel) {
        this.vipAlipayOptions = list;
        this.vipAlipayPublicOptions = list2;
        this.vipAlipayHideOptions = list3;
        this.vipWechatOptions = list4;
        this.vipWechatPublicOptions = list5;
        this.vipWechatHideOptions = list6;
        this.remindFlag = z10;
        this.superLikePurchaseDescription = str;
        this.userStrategyEndTime = j10;
        this.vipClientUiInfo = vipClientUiInfoModel;
    }

    @Nullable
    public final List<VipPurchasePriceModel> component1() {
        return this.vipAlipayOptions;
    }

    @Nullable
    public final VipClientUiInfoModel component10() {
        return this.vipClientUiInfo;
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
        return this.vipWechatOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> component5() {
        return this.vipWechatPublicOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> component6() {
        return this.vipWechatHideOptions;
    }

    public final boolean component7() {
        return this.remindFlag;
    }

    @Nullable
    public final String component8() {
        return this.superLikePurchaseDescription;
    }

    public final long component9() {
        return this.userStrategyEndTime;
    }

    @NotNull
    public final VipOptionsModel copy(@Nullable List<VipPurchasePriceModel> list, @Nullable List<VipPurchasePriceModel> list2, @Nullable List<VipPurchasePriceModel> list3, @Nullable List<VipPurchasePriceModel> list4, @Nullable List<VipPurchasePriceModel> list5, @Nullable List<VipPurchasePriceModel> list6, boolean z10, @Nullable String str, long j10, @Nullable VipClientUiInfoModel vipClientUiInfoModel) {
        return new VipOptionsModel(list, list2, list3, list4, list5, list6, z10, str, j10, vipClientUiInfoModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipOptionsModel)) {
            return false;
        }
        VipOptionsModel vipOptionsModel = (VipOptionsModel) obj;
        return s.d(this.vipAlipayOptions, vipOptionsModel.vipAlipayOptions) && s.d(this.vipAlipayPublicOptions, vipOptionsModel.vipAlipayPublicOptions) && s.d(this.vipAlipayHideOptions, vipOptionsModel.vipAlipayHideOptions) && s.d(this.vipWechatOptions, vipOptionsModel.vipWechatOptions) && s.d(this.vipWechatPublicOptions, vipOptionsModel.vipWechatPublicOptions) && s.d(this.vipWechatHideOptions, vipOptionsModel.vipWechatHideOptions) && this.remindFlag == vipOptionsModel.remindFlag && s.d(this.superLikePurchaseDescription, vipOptionsModel.superLikePurchaseDescription) && this.userStrategyEndTime == vipOptionsModel.userStrategyEndTime && s.d(this.vipClientUiInfo, vipOptionsModel.vipClientUiInfo);
    }

    @NotNull
    public final List<VipPurchasePriceModel> getAllAlipayOptions() {
        List<VipPurchasePriceModel> list = this.vipAlipayPublicOptions;
        if (list == null || list.isEmpty()) {
            List<VipPurchasePriceModel> list2 = this.vipAlipayOptions;
            return list2 == null ? kotlin.collections.s.j() : list2;
        }
        List<VipPurchasePriceModel> list3 = this.vipAlipayHideOptions;
        if (list3 == null || list3.isEmpty()) {
            return this.vipAlipayPublicOptions;
        }
        return CollectionsKt___CollectionsKt.k0(this.vipAlipayPublicOptions, this.vipAlipayHideOptions);
    }

    @NotNull
    public final List<VipPurchasePriceModel> getAllWeChatOptions() {
        List<VipPurchasePriceModel> list = this.vipWechatPublicOptions;
        if (list == null || list.isEmpty()) {
            List<VipPurchasePriceModel> list2 = this.vipWechatOptions;
            return list2 == null ? kotlin.collections.s.j() : list2;
        }
        List<VipPurchasePriceModel> list3 = this.vipWechatHideOptions;
        if (list3 == null || list3.isEmpty()) {
            return this.vipWechatPublicOptions;
        }
        return CollectionsKt___CollectionsKt.k0(this.vipWechatPublicOptions, this.vipWechatHideOptions);
    }

    @NotNull
    public final List<VipPurchasePriceModel> getBaseAlipayOptions() {
        List<VipPurchasePriceModel> list = this.vipAlipayPublicOptions;
        if (list == null || list.isEmpty()) {
            List<VipPurchasePriceModel> list2 = this.vipAlipayOptions;
            return list2 == null ? kotlin.collections.s.j() : list2;
        }
        return this.vipAlipayPublicOptions;
    }

    @NotNull
    public final List<VipPurchasePriceModel> getBaseWechatOptions() {
        List<VipPurchasePriceModel> list = this.vipWechatPublicOptions;
        if (list == null || list.isEmpty()) {
            List<VipPurchasePriceModel> list2 = this.vipWechatOptions;
            return list2 == null ? kotlin.collections.s.j() : list2;
        }
        return this.vipWechatPublicOptions;
    }

    public final boolean getRemindFlag() {
        return this.remindFlag;
    }

    @Nullable
    public final String getSuperLikePurchaseDescription() {
        return this.superLikePurchaseDescription;
    }

    public final long getUserStrategyEndTime() {
        return this.userStrategyEndTime;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipAlipayHideOptions() {
        return this.vipAlipayHideOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipAlipayOptions() {
        return this.vipAlipayOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipAlipayPublicOptions() {
        return this.vipAlipayPublicOptions;
    }

    @Nullable
    public final VipClientUiInfoModel getVipClientUiInfo() {
        return this.vipClientUiInfo;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipWechatHideOptions() {
        return this.vipWechatHideOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipWechatOptions() {
        return this.vipWechatOptions;
    }

    @Nullable
    public final List<VipPurchasePriceModel> getVipWechatPublicOptions() {
        return this.vipWechatPublicOptions;
    }

    public final boolean hasHideOptions(@NotNull PayType payType) {
        s.i(payType, "payType");
        if (a.f18812a[payType.ordinal()] == 1) {
            if (this.vipWechatHideOptions == null || !(!r3.isEmpty())) {
                return false;
            }
        } else {
            if (this.vipAlipayHideOptions == null || !(!r3.isEmpty())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<VipPurchasePriceModel> list = this.vipAlipayOptions;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<VipPurchasePriceModel> list2 = this.vipAlipayPublicOptions;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<VipPurchasePriceModel> list3 = this.vipAlipayHideOptions;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<VipPurchasePriceModel> list4 = this.vipWechatOptions;
        int hashCode4 = (hashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<VipPurchasePriceModel> list5 = this.vipWechatPublicOptions;
        int hashCode5 = (hashCode4 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<VipPurchasePriceModel> list6 = this.vipWechatHideOptions;
        int hashCode6 = (hashCode5 + (list6 == null ? 0 : list6.hashCode())) * 31;
        boolean z10 = this.remindFlag;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode6 + i10) * 31;
        String str = this.superLikePurchaseDescription;
        int hashCode7 = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + b2.a.a(this.userStrategyEndTime)) * 31;
        VipClientUiInfoModel vipClientUiInfoModel = this.vipClientUiInfo;
        return hashCode7 + (vipClientUiInfoModel != null ? vipClientUiInfoModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<VipPurchasePriceModel> list = this.vipAlipayOptions;
        List<VipPurchasePriceModel> list2 = this.vipAlipayPublicOptions;
        List<VipPurchasePriceModel> list3 = this.vipAlipayHideOptions;
        List<VipPurchasePriceModel> list4 = this.vipWechatOptions;
        List<VipPurchasePriceModel> list5 = this.vipWechatPublicOptions;
        List<VipPurchasePriceModel> list6 = this.vipWechatHideOptions;
        return "VipOptionsModel(vipAlipayOptions=" + ((Object) list) + ", vipAlipayPublicOptions=" + ((Object) list2) + ", vipAlipayHideOptions=" + ((Object) list3) + ", vipWechatOptions=" + ((Object) list4) + ", vipWechatPublicOptions=" + ((Object) list5) + ", vipWechatHideOptions=" + ((Object) list6) + ", remindFlag=" + this.remindFlag + ", superLikePurchaseDescription=" + this.superLikePurchaseDescription + ", userStrategyEndTime=" + this.userStrategyEndTime + ", vipClientUiInfo=" + ((Object) this.vipClientUiInfo) + ")";
    }

    public /* synthetic */ VipOptionsModel(List list, List list2, List list3, List list4, List list5, List list6, boolean z10, String str, long j10, VipClientUiInfoModel vipClientUiInfoModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5, list6, (i10 & 64) != 0 ? false : z10, (i10 & 128) != 0 ? null : str, (i10 & 256) != 0 ? 0L : j10, (i10 & 512) != 0 ? null : vipClientUiInfoModel);
    }
}
