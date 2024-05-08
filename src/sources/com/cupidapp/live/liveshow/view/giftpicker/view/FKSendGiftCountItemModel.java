package com.cupidapp.live.liveshow.view.giftpicker.view;

import com.cupidapp.live.liveshow.model.FKHornType;
import com.cupidapp.live.liveshow.model.SendGiftCountModel;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSendGiftCountSelectItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSendGiftCountItemModel {

    @NotNull
    private final SendGiftCountModel giftCountModel;

    @Nullable
    private final FKHornType hornType;

    public FKSendGiftCountItemModel(@NotNull SendGiftCountModel giftCountModel, @Nullable FKHornType fKHornType) {
        s.i(giftCountModel, "giftCountModel");
        this.giftCountModel = giftCountModel;
        this.hornType = fKHornType;
    }

    public static /* synthetic */ FKSendGiftCountItemModel copy$default(FKSendGiftCountItemModel fKSendGiftCountItemModel, SendGiftCountModel sendGiftCountModel, FKHornType fKHornType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sendGiftCountModel = fKSendGiftCountItemModel.giftCountModel;
        }
        if ((i10 & 2) != 0) {
            fKHornType = fKSendGiftCountItemModel.hornType;
        }
        return fKSendGiftCountItemModel.copy(sendGiftCountModel, fKHornType);
    }

    @NotNull
    public final SendGiftCountModel component1() {
        return this.giftCountModel;
    }

    @Nullable
    public final FKHornType component2() {
        return this.hornType;
    }

    @NotNull
    public final FKSendGiftCountItemModel copy(@NotNull SendGiftCountModel giftCountModel, @Nullable FKHornType fKHornType) {
        s.i(giftCountModel, "giftCountModel");
        return new FKSendGiftCountItemModel(giftCountModel, fKHornType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKSendGiftCountItemModel)) {
            return false;
        }
        FKSendGiftCountItemModel fKSendGiftCountItemModel = (FKSendGiftCountItemModel) obj;
        return s.d(this.giftCountModel, fKSendGiftCountItemModel.giftCountModel) && this.hornType == fKSendGiftCountItemModel.hornType;
    }

    @NotNull
    public final SendGiftCountModel getGiftCountModel() {
        return this.giftCountModel;
    }

    @Nullable
    public final FKHornType getHornType() {
        return this.hornType;
    }

    public int hashCode() {
        int hashCode = this.giftCountModel.hashCode() * 31;
        FKHornType fKHornType = this.hornType;
        return hashCode + (fKHornType == null ? 0 : fKHornType.hashCode());
    }

    @NotNull
    public String toString() {
        return "FKSendGiftCountItemModel(giftCountModel=" + ((Object) this.giftCountModel) + ", hornType=" + ((Object) this.hornType) + ")";
    }
}
