package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftHistoryModel {
    private final int count;

    @NotNull
    private final GiftModel gift;

    @NotNull
    private final User sender;

    public GiftHistoryModel(@NotNull GiftModel gift, int i10, @NotNull User sender) {
        s.i(gift, "gift");
        s.i(sender, "sender");
        this.gift = gift;
        this.count = i10;
        this.sender = sender;
    }

    public static /* synthetic */ GiftHistoryModel copy$default(GiftHistoryModel giftHistoryModel, GiftModel giftModel, int i10, User user, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            giftModel = giftHistoryModel.gift;
        }
        if ((i11 & 2) != 0) {
            i10 = giftHistoryModel.count;
        }
        if ((i11 & 4) != 0) {
            user = giftHistoryModel.sender;
        }
        return giftHistoryModel.copy(giftModel, i10, user);
    }

    @NotNull
    public final GiftModel component1() {
        return this.gift;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final User component3() {
        return this.sender;
    }

    @NotNull
    public final GiftHistoryModel copy(@NotNull GiftModel gift, int i10, @NotNull User sender) {
        s.i(gift, "gift");
        s.i(sender, "sender");
        return new GiftHistoryModel(gift, i10, sender);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftHistoryModel)) {
            return false;
        }
        GiftHistoryModel giftHistoryModel = (GiftHistoryModel) obj;
        return s.d(this.gift, giftHistoryModel.gift) && this.count == giftHistoryModel.count && s.d(this.sender, giftHistoryModel.sender);
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final GiftModel getGift() {
        return this.gift;
    }

    @NotNull
    public final User getSender() {
        return this.sender;
    }

    public int hashCode() {
        return (((this.gift.hashCode() * 31) + this.count) * 31) + this.sender.hashCode();
    }

    @NotNull
    public String toString() {
        GiftModel giftModel = this.gift;
        return "GiftHistoryModel(gift=" + ((Object) giftModel) + ", count=" + this.count + ", sender=" + ((Object) this.sender) + ")";
    }
}
