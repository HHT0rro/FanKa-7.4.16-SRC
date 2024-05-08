package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import com.cupidapp.live.liveshow.model.GiftItemModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftPickerItemAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SelectCurrentGiftEvent {

    @NotNull
    private final GiftItemModel giftItemModel;

    public SelectCurrentGiftEvent(@NotNull GiftItemModel giftItemModel) {
        s.i(giftItemModel, "giftItemModel");
        this.giftItemModel = giftItemModel;
    }

    public static /* synthetic */ SelectCurrentGiftEvent copy$default(SelectCurrentGiftEvent selectCurrentGiftEvent, GiftItemModel giftItemModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            giftItemModel = selectCurrentGiftEvent.giftItemModel;
        }
        return selectCurrentGiftEvent.copy(giftItemModel);
    }

    @NotNull
    public final GiftItemModel component1() {
        return this.giftItemModel;
    }

    @NotNull
    public final SelectCurrentGiftEvent copy(@NotNull GiftItemModel giftItemModel) {
        s.i(giftItemModel, "giftItemModel");
        return new SelectCurrentGiftEvent(giftItemModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SelectCurrentGiftEvent) && s.d(this.giftItemModel, ((SelectCurrentGiftEvent) obj).giftItemModel);
    }

    @NotNull
    public final GiftItemModel getGiftItemModel() {
        return this.giftItemModel;
    }

    public int hashCode() {
        return this.giftItemModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "SelectCurrentGiftEvent(giftItemModel=" + ((Object) this.giftItemModel) + ")";
    }
}
