package com.cupidapp.live.superlike.model;

import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperLikePurchaseSkuModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikePurchaseModel implements Serializable {

    @Nullable
    private final LinkDictTipsModel assignment;

    @Nullable
    private final List<SuperLikePurchaseSkuModel> products;

    @Nullable
    private final String superboostMarketingInfo;

    @Nullable
    private final String vipFreeUsageCountDescription;

    public SuperLikePurchaseModel(@Nullable List<SuperLikePurchaseSkuModel> list, @Nullable String str, @Nullable LinkDictTipsModel linkDictTipsModel, @Nullable String str2) {
        this.products = list;
        this.vipFreeUsageCountDescription = str;
        this.assignment = linkDictTipsModel;
        this.superboostMarketingInfo = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuperLikePurchaseModel copy$default(SuperLikePurchaseModel superLikePurchaseModel, List list, String str, LinkDictTipsModel linkDictTipsModel, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = superLikePurchaseModel.products;
        }
        if ((i10 & 2) != 0) {
            str = superLikePurchaseModel.vipFreeUsageCountDescription;
        }
        if ((i10 & 4) != 0) {
            linkDictTipsModel = superLikePurchaseModel.assignment;
        }
        if ((i10 & 8) != 0) {
            str2 = superLikePurchaseModel.superboostMarketingInfo;
        }
        return superLikePurchaseModel.copy(list, str, linkDictTipsModel, str2);
    }

    @Nullable
    public final List<SuperLikePurchaseSkuModel> component1() {
        return this.products;
    }

    @Nullable
    public final String component2() {
        return this.vipFreeUsageCountDescription;
    }

    @Nullable
    public final LinkDictTipsModel component3() {
        return this.assignment;
    }

    @Nullable
    public final String component4() {
        return this.superboostMarketingInfo;
    }

    @NotNull
    public final SuperLikePurchaseModel copy(@Nullable List<SuperLikePurchaseSkuModel> list, @Nullable String str, @Nullable LinkDictTipsModel linkDictTipsModel, @Nullable String str2) {
        return new SuperLikePurchaseModel(list, str, linkDictTipsModel, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperLikePurchaseModel)) {
            return false;
        }
        SuperLikePurchaseModel superLikePurchaseModel = (SuperLikePurchaseModel) obj;
        return s.d(this.products, superLikePurchaseModel.products) && s.d(this.vipFreeUsageCountDescription, superLikePurchaseModel.vipFreeUsageCountDescription) && s.d(this.assignment, superLikePurchaseModel.assignment) && s.d(this.superboostMarketingInfo, superLikePurchaseModel.superboostMarketingInfo);
    }

    @Nullable
    public final LinkDictTipsModel getAssignment() {
        return this.assignment;
    }

    @Nullable
    public final List<SuperLikePurchaseSkuModel> getProducts() {
        return this.products;
    }

    @Nullable
    public final String getSuperboostMarketingInfo() {
        return this.superboostMarketingInfo;
    }

    @Nullable
    public final String getVipFreeUsageCountDescription() {
        return this.vipFreeUsageCountDescription;
    }

    public int hashCode() {
        List<SuperLikePurchaseSkuModel> list = this.products;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.vipFreeUsageCountDescription;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        LinkDictTipsModel linkDictTipsModel = this.assignment;
        int hashCode3 = (hashCode2 + (linkDictTipsModel == null ? 0 : linkDictTipsModel.hashCode())) * 31;
        String str2 = this.superboostMarketingInfo;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<SuperLikePurchaseSkuModel> list = this.products;
        String str = this.vipFreeUsageCountDescription;
        LinkDictTipsModel linkDictTipsModel = this.assignment;
        return "SuperLikePurchaseModel(products=" + ((Object) list) + ", vipFreeUsageCountDescription=" + str + ", assignment=" + ((Object) linkDictTipsModel) + ", superboostMarketingInfo=" + this.superboostMarketingInfo + ")";
    }

    public /* synthetic */ SuperLikePurchaseModel(List list, String str, LinkDictTipsModel linkDictTipsModel, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i10 & 4) != 0 ? null : linkDictTipsModel, str2);
    }
}
