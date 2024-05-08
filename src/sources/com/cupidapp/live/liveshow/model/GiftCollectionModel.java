package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftCollectionModel implements Serializable {

    @Nullable
    private final List<GiftCollectionItemModel> images;

    @NotNull
    private final String status;

    @Nullable
    private final String tips;

    public GiftCollectionModel(@NotNull String status, @Nullable String str, @Nullable List<GiftCollectionItemModel> list) {
        s.i(status, "status");
        this.status = status;
        this.tips = str;
        this.images = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GiftCollectionModel copy$default(GiftCollectionModel giftCollectionModel, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = giftCollectionModel.status;
        }
        if ((i10 & 2) != 0) {
            str2 = giftCollectionModel.tips;
        }
        if ((i10 & 4) != 0) {
            list = giftCollectionModel.images;
        }
        return giftCollectionModel.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.status;
    }

    @Nullable
    public final String component2() {
        return this.tips;
    }

    @Nullable
    public final List<GiftCollectionItemModel> component3() {
        return this.images;
    }

    @NotNull
    public final GiftCollectionModel copy(@NotNull String status, @Nullable String str, @Nullable List<GiftCollectionItemModel> list) {
        s.i(status, "status");
        return new GiftCollectionModel(status, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftCollectionModel)) {
            return false;
        }
        GiftCollectionModel giftCollectionModel = (GiftCollectionModel) obj;
        return s.d(this.status, giftCollectionModel.status) && s.d(this.tips, giftCollectionModel.tips) && s.d(this.images, giftCollectionModel.images);
    }

    @Nullable
    public final List<GiftCollectionItemModel> getImages() {
        return this.images;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        String str = this.tips;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<GiftCollectionItemModel> list = this.images;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GiftCollectionModel(status=" + this.status + ", tips=" + this.tips + ", images=" + ((Object) this.images) + ")";
    }
}
