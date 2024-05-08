package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PropCardResult {

    @Nullable
    private final SingleTabGiftListModel giftDiscountCard;

    @Nullable
    private final NobleCardModel nobilityCard;

    public PropCardResult(@Nullable SingleTabGiftListModel singleTabGiftListModel, @Nullable NobleCardModel nobleCardModel) {
        this.giftDiscountCard = singleTabGiftListModel;
        this.nobilityCard = nobleCardModel;
    }

    public static /* synthetic */ PropCardResult copy$default(PropCardResult propCardResult, SingleTabGiftListModel singleTabGiftListModel, NobleCardModel nobleCardModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            singleTabGiftListModel = propCardResult.giftDiscountCard;
        }
        if ((i10 & 2) != 0) {
            nobleCardModel = propCardResult.nobilityCard;
        }
        return propCardResult.copy(singleTabGiftListModel, nobleCardModel);
    }

    @Nullable
    public final SingleTabGiftListModel component1() {
        return this.giftDiscountCard;
    }

    @Nullable
    public final NobleCardModel component2() {
        return this.nobilityCard;
    }

    @NotNull
    public final PropCardResult copy(@Nullable SingleTabGiftListModel singleTabGiftListModel, @Nullable NobleCardModel nobleCardModel) {
        return new PropCardResult(singleTabGiftListModel, nobleCardModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PropCardResult)) {
            return false;
        }
        PropCardResult propCardResult = (PropCardResult) obj;
        return s.d(this.giftDiscountCard, propCardResult.giftDiscountCard) && s.d(this.nobilityCard, propCardResult.nobilityCard);
    }

    @Nullable
    public final SingleTabGiftListModel getGiftDiscountCard() {
        return this.giftDiscountCard;
    }

    @Nullable
    public final NobleCardModel getNobilityCard() {
        return this.nobilityCard;
    }

    public int hashCode() {
        SingleTabGiftListModel singleTabGiftListModel = this.giftDiscountCard;
        int hashCode = (singleTabGiftListModel == null ? 0 : singleTabGiftListModel.hashCode()) * 31;
        NobleCardModel nobleCardModel = this.nobilityCard;
        return hashCode + (nobleCardModel != null ? nobleCardModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PropCardResult(giftDiscountCard=" + ((Object) this.giftDiscountCard) + ", nobilityCard=" + ((Object) this.nobilityCard) + ")";
    }
}
