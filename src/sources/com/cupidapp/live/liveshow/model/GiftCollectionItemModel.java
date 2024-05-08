package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftCollectionItemModel implements Serializable {

    @Nullable
    private final Integer count;

    @Nullable
    private final ImageModel image;

    public GiftCollectionItemModel(@Nullable ImageModel imageModel, @Nullable Integer num) {
        this.image = imageModel;
        this.count = num;
    }

    public static /* synthetic */ GiftCollectionItemModel copy$default(GiftCollectionItemModel giftCollectionItemModel, ImageModel imageModel, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = giftCollectionItemModel.image;
        }
        if ((i10 & 2) != 0) {
            num = giftCollectionItemModel.count;
        }
        return giftCollectionItemModel.copy(imageModel, num);
    }

    @Nullable
    public final ImageModel component1() {
        return this.image;
    }

    @Nullable
    public final Integer component2() {
        return this.count;
    }

    @NotNull
    public final GiftCollectionItemModel copy(@Nullable ImageModel imageModel, @Nullable Integer num) {
        return new GiftCollectionItemModel(imageModel, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftCollectionItemModel)) {
            return false;
        }
        GiftCollectionItemModel giftCollectionItemModel = (GiftCollectionItemModel) obj;
        return s.d(this.image, giftCollectionItemModel.image) && s.d(this.count, giftCollectionItemModel.count);
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    public int hashCode() {
        ImageModel imageModel = this.image;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        Integer num = this.count;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GiftCollectionItemModel(image=" + ((Object) this.image) + ", count=" + ((Object) this.count) + ")";
    }
}
