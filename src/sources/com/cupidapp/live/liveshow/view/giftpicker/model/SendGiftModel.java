package com.cupidapp.live.liveshow.view.giftpicker.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DiamondResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendGiftModel {

    @Nullable
    private final ImageModel image;

    @NotNull
    private final String itemId;

    @NotNull
    private final String name;
    private final int price;

    public SendGiftModel(@NotNull String itemId, @NotNull String name, @Nullable ImageModel imageModel, int i10) {
        s.i(itemId, "itemId");
        s.i(name, "name");
        this.itemId = itemId;
        this.name = name;
        this.image = imageModel;
        this.price = i10;
    }

    public static /* synthetic */ SendGiftModel copy$default(SendGiftModel sendGiftModel, String str, String str2, ImageModel imageModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sendGiftModel.itemId;
        }
        if ((i11 & 2) != 0) {
            str2 = sendGiftModel.name;
        }
        if ((i11 & 4) != 0) {
            imageModel = sendGiftModel.image;
        }
        if ((i11 & 8) != 0) {
            i10 = sendGiftModel.price;
        }
        return sendGiftModel.copy(str, str2, imageModel, i10);
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final ImageModel component3() {
        return this.image;
    }

    public final int component4() {
        return this.price;
    }

    @NotNull
    public final SendGiftModel copy(@NotNull String itemId, @NotNull String name, @Nullable ImageModel imageModel, int i10) {
        s.i(itemId, "itemId");
        s.i(name, "name");
        return new SendGiftModel(itemId, name, imageModel, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendGiftModel)) {
            return false;
        }
        SendGiftModel sendGiftModel = (SendGiftModel) obj;
        return s.d(this.itemId, sendGiftModel.itemId) && s.d(this.name, sendGiftModel.name) && s.d(this.image, sendGiftModel.image) && this.price == sendGiftModel.price;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getPrice() {
        return this.price;
    }

    public int hashCode() {
        int hashCode = ((this.itemId.hashCode() * 31) + this.name.hashCode()) * 31;
        ImageModel imageModel = this.image;
        return ((hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31) + this.price;
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        String str2 = this.name;
        ImageModel imageModel = this.image;
        return "SendGiftModel(itemId=" + str + ", name=" + str2 + ", image=" + ((Object) imageModel) + ", price=" + this.price + ")";
    }
}
