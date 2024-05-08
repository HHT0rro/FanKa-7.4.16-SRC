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
public final class SingleTabGiftListModel implements Serializable {

    @Nullable
    private final LiveGiftActivityModel banner;

    @NotNull
    private final String fenceId;

    @Nullable
    private final List<GiftModel> giftList;

    @NotNull
    private final String title;

    public SingleTabGiftListModel(@NotNull String fenceId, @NotNull String title, @Nullable List<GiftModel> list, @Nullable LiveGiftActivityModel liveGiftActivityModel) {
        s.i(fenceId, "fenceId");
        s.i(title, "title");
        this.fenceId = fenceId;
        this.title = title;
        this.giftList = list;
        this.banner = liveGiftActivityModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleTabGiftListModel copy$default(SingleTabGiftListModel singleTabGiftListModel, String str, String str2, List list, LiveGiftActivityModel liveGiftActivityModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = singleTabGiftListModel.fenceId;
        }
        if ((i10 & 2) != 0) {
            str2 = singleTabGiftListModel.title;
        }
        if ((i10 & 4) != 0) {
            list = singleTabGiftListModel.giftList;
        }
        if ((i10 & 8) != 0) {
            liveGiftActivityModel = singleTabGiftListModel.banner;
        }
        return singleTabGiftListModel.copy(str, str2, list, liveGiftActivityModel);
    }

    @NotNull
    public final String component1() {
        return this.fenceId;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final List<GiftModel> component3() {
        return this.giftList;
    }

    @Nullable
    public final LiveGiftActivityModel component4() {
        return this.banner;
    }

    @NotNull
    public final SingleTabGiftListModel copy(@NotNull String fenceId, @NotNull String title, @Nullable List<GiftModel> list, @Nullable LiveGiftActivityModel liveGiftActivityModel) {
        s.i(fenceId, "fenceId");
        s.i(title, "title");
        return new SingleTabGiftListModel(fenceId, title, list, liveGiftActivityModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SingleTabGiftListModel)) {
            return false;
        }
        SingleTabGiftListModel singleTabGiftListModel = (SingleTabGiftListModel) obj;
        return s.d(this.fenceId, singleTabGiftListModel.fenceId) && s.d(this.title, singleTabGiftListModel.title) && s.d(this.giftList, singleTabGiftListModel.giftList) && s.d(this.banner, singleTabGiftListModel.banner);
    }

    @Nullable
    public final LiveGiftActivityModel getBanner() {
        return this.banner;
    }

    @NotNull
    public final String getFenceId() {
        return this.fenceId;
    }

    @Nullable
    public final List<GiftModel> getGiftList() {
        return this.giftList;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.fenceId.hashCode() * 31) + this.title.hashCode()) * 31;
        List<GiftModel> list = this.giftList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        LiveGiftActivityModel liveGiftActivityModel = this.banner;
        return hashCode2 + (liveGiftActivityModel != null ? liveGiftActivityModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SingleTabGiftListModel(fenceId=" + this.fenceId + ", title=" + this.title + ", giftList=" + ((Object) this.giftList) + ", banner=" + ((Object) this.banner) + ")";
    }
}
