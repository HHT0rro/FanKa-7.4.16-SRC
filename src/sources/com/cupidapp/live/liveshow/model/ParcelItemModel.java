package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ParcelItemModel extends GiftItemModel {

    @Nullable
    private final Integer category;
    private final int count;

    @Nullable
    private final List<GiftExpireModel> expirationDetails;

    @Nullable
    private final String expireTime;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParcelItemModel(int i10, @Nullable String str, @Nullable List<GiftExpireModel> list, int i11, @Nullable Integer num, @NotNull String itemId, @NotNull String name, int i12, @NotNull ImageModel image, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable ImageModel imageModel, boolean z10, boolean z11, boolean z12, @Nullable ImageModel imageModel2, @NotNull String fenceId, @Nullable Integer num2, @Nullable ImageModel imageModel3, @Nullable Integer num3, @Nullable String str5, @Nullable Long l10, @Nullable ImageModel imageModel4, @NotNull String rushType, boolean z13) {
        super(itemId, name, i12, image, str2, str3, str4, imageModel, z10, z11, z12, imageModel2, fenceId, num2, imageModel3, num3, str5, l10, imageModel4, rushType, z13);
        s.i(itemId, "itemId");
        s.i(name, "name");
        s.i(image, "image");
        s.i(fenceId, "fenceId");
        s.i(rushType, "rushType");
        this.count = i10;
        this.expireTime = str;
        this.expirationDetails = list;
        this.type = i11;
        this.category = num;
    }

    @Nullable
    public final Integer getCategory() {
        return this.category;
    }

    public final int getCount() {
        return this.count;
    }

    @Nullable
    public final List<GiftExpireModel> getExpirationDetails() {
        return this.expirationDetails;
    }

    @Nullable
    public final String getExpireTime() {
        return this.expireTime;
    }

    public final int getType() {
        return this.type;
    }
}
