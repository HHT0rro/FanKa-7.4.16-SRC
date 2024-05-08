package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftWallModel {

    @Nullable
    private final String desc;

    @Nullable
    private final List<LightUpGiftModel> lightUpList;

    @NotNull
    private final String url;

    public GiftWallModel(@NotNull String url, @Nullable String str, @Nullable List<LightUpGiftModel> list) {
        s.i(url, "url");
        this.url = url;
        this.desc = str;
        this.lightUpList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GiftWallModel copy$default(GiftWallModel giftWallModel, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = giftWallModel.url;
        }
        if ((i10 & 2) != 0) {
            str2 = giftWallModel.desc;
        }
        if ((i10 & 4) != 0) {
            list = giftWallModel.lightUpList;
        }
        return giftWallModel.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @Nullable
    public final String component2() {
        return this.desc;
    }

    @Nullable
    public final List<LightUpGiftModel> component3() {
        return this.lightUpList;
    }

    @NotNull
    public final GiftWallModel copy(@NotNull String url, @Nullable String str, @Nullable List<LightUpGiftModel> list) {
        s.i(url, "url");
        return new GiftWallModel(url, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftWallModel)) {
            return false;
        }
        GiftWallModel giftWallModel = (GiftWallModel) obj;
        return s.d(this.url, giftWallModel.url) && s.d(this.desc, giftWallModel.desc) && s.d(this.lightUpList, giftWallModel.lightUpList);
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final List<LightUpGiftModel> getLightUpList() {
        return this.lightUpList;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        String str = this.desc;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<LightUpGiftModel> list = this.lightUpList;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GiftWallModel(url=" + this.url + ", desc=" + this.desc + ", lightUpList=" + ((Object) this.lightUpList) + ")";
    }
}
