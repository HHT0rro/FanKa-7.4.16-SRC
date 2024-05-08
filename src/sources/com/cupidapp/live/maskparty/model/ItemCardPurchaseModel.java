package com.cupidapp.live.maskparty.model;

import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ItemCardPurchaseModel {

    @Nullable
    private SuperLikePurchaseModel purchaseModel;

    public ItemCardPurchaseModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ItemCardPurchaseModel(@Nullable SuperLikePurchaseModel superLikePurchaseModel) {
        this.purchaseModel = superLikePurchaseModel;
    }

    public static /* synthetic */ ItemCardPurchaseModel copy$default(ItemCardPurchaseModel itemCardPurchaseModel, SuperLikePurchaseModel superLikePurchaseModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            superLikePurchaseModel = itemCardPurchaseModel.purchaseModel;
        }
        return itemCardPurchaseModel.copy(superLikePurchaseModel);
    }

    @Nullable
    public final SuperLikePurchaseModel component1() {
        return this.purchaseModel;
    }

    @NotNull
    public final ItemCardPurchaseModel copy(@Nullable SuperLikePurchaseModel superLikePurchaseModel) {
        return new ItemCardPurchaseModel(superLikePurchaseModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ItemCardPurchaseModel) && s.d(this.purchaseModel, ((ItemCardPurchaseModel) obj).purchaseModel);
    }

    @Nullable
    public final SuperLikePurchaseModel getPurchaseModel() {
        return this.purchaseModel;
    }

    public int hashCode() {
        SuperLikePurchaseModel superLikePurchaseModel = this.purchaseModel;
        if (superLikePurchaseModel == null) {
            return 0;
        }
        return superLikePurchaseModel.hashCode();
    }

    public final void setPurchaseModel(@Nullable SuperLikePurchaseModel superLikePurchaseModel) {
        this.purchaseModel = superLikePurchaseModel;
    }

    @NotNull
    public String toString() {
        return "ItemCardPurchaseModel(purchaseModel=" + ((Object) this.purchaseModel) + ")";
    }

    public /* synthetic */ ItemCardPurchaseModel(SuperLikePurchaseModel superLikePurchaseModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : superLikePurchaseModel);
    }
}
