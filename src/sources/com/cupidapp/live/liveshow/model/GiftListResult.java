package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftListResult implements Serializable {
    private final int bigHornTriggerDiamonds;

    @NotNull
    private final List<SendGiftCountModel> bulkGiftsCountDesc;

    @Nullable
    private final ExperienceModel experience;
    private final boolean firstBuy;

    @NotNull
    private final List<SingleTabGiftListModel> giftList;

    @Nullable
    private final LiveGiftActivityModel nobleEntryInfo;
    private final boolean openBulkGiftsSwitch;

    @Nullable
    private final ParcelModel parcel;
    private final int smallHornTriggerDiamonds;

    public GiftListResult(@NotNull List<SingleTabGiftListModel> giftList, @Nullable ParcelModel parcelModel, @NotNull List<SendGiftCountModel> bulkGiftsCountDesc, int i10, int i11, boolean z10, @Nullable ExperienceModel experienceModel, @Nullable LiveGiftActivityModel liveGiftActivityModel, boolean z11) {
        s.i(giftList, "giftList");
        s.i(bulkGiftsCountDesc, "bulkGiftsCountDesc");
        this.giftList = giftList;
        this.parcel = parcelModel;
        this.bulkGiftsCountDesc = bulkGiftsCountDesc;
        this.bigHornTriggerDiamonds = i10;
        this.smallHornTriggerDiamonds = i11;
        this.openBulkGiftsSwitch = z10;
        this.experience = experienceModel;
        this.nobleEntryInfo = liveGiftActivityModel;
        this.firstBuy = z11;
    }

    @NotNull
    public final List<SingleTabGiftListModel> component1() {
        return this.giftList;
    }

    @Nullable
    public final ParcelModel component2() {
        return this.parcel;
    }

    @NotNull
    public final List<SendGiftCountModel> component3() {
        return this.bulkGiftsCountDesc;
    }

    public final int component4() {
        return this.bigHornTriggerDiamonds;
    }

    public final int component5() {
        return this.smallHornTriggerDiamonds;
    }

    public final boolean component6() {
        return this.openBulkGiftsSwitch;
    }

    @Nullable
    public final ExperienceModel component7() {
        return this.experience;
    }

    @Nullable
    public final LiveGiftActivityModel component8() {
        return this.nobleEntryInfo;
    }

    public final boolean component9() {
        return this.firstBuy;
    }

    @NotNull
    public final GiftListResult copy(@NotNull List<SingleTabGiftListModel> giftList, @Nullable ParcelModel parcelModel, @NotNull List<SendGiftCountModel> bulkGiftsCountDesc, int i10, int i11, boolean z10, @Nullable ExperienceModel experienceModel, @Nullable LiveGiftActivityModel liveGiftActivityModel, boolean z11) {
        s.i(giftList, "giftList");
        s.i(bulkGiftsCountDesc, "bulkGiftsCountDesc");
        return new GiftListResult(giftList, parcelModel, bulkGiftsCountDesc, i10, i11, z10, experienceModel, liveGiftActivityModel, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftListResult)) {
            return false;
        }
        GiftListResult giftListResult = (GiftListResult) obj;
        return s.d(this.giftList, giftListResult.giftList) && s.d(this.parcel, giftListResult.parcel) && s.d(this.bulkGiftsCountDesc, giftListResult.bulkGiftsCountDesc) && this.bigHornTriggerDiamonds == giftListResult.bigHornTriggerDiamonds && this.smallHornTriggerDiamonds == giftListResult.smallHornTriggerDiamonds && this.openBulkGiftsSwitch == giftListResult.openBulkGiftsSwitch && s.d(this.experience, giftListResult.experience) && s.d(this.nobleEntryInfo, giftListResult.nobleEntryInfo) && this.firstBuy == giftListResult.firstBuy;
    }

    @NotNull
    public final List<SingleTabGiftConfigModel> getAllTabGiftList() {
        ArrayList arrayList = new ArrayList();
        for (SingleTabGiftListModel singleTabGiftListModel : this.giftList) {
            List<GiftModel> giftList = singleTabGiftListModel.getGiftList();
            if (giftList == null) {
                giftList = kotlin.collections.s.j();
            }
            arrayList.add(new SingleTabGiftConfigModel(giftList, singleTabGiftListModel.getTitle(), null, 4, null));
        }
        return arrayList;
    }

    public final int getBigHornTriggerDiamonds() {
        return this.bigHornTriggerDiamonds;
    }

    @NotNull
    public final List<SendGiftCountModel> getBulkGiftsCountDesc() {
        return this.bulkGiftsCountDesc;
    }

    @Nullable
    public final ExperienceModel getExperience() {
        return this.experience;
    }

    public final boolean getFirstBuy() {
        return this.firstBuy;
    }

    @NotNull
    public final List<SingleTabGiftListModel> getGiftList() {
        return this.giftList;
    }

    @Nullable
    public final LiveGiftActivityModel getNobleEntryInfo() {
        return this.nobleEntryInfo;
    }

    public final boolean getOpenBulkGiftsSwitch() {
        return this.openBulkGiftsSwitch;
    }

    @Nullable
    public final ParcelModel getParcel() {
        return this.parcel;
    }

    public final int getSmallHornTriggerDiamonds() {
        return this.smallHornTriggerDiamonds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.giftList.hashCode() * 31;
        ParcelModel parcelModel = this.parcel;
        int hashCode2 = (((((((hashCode + (parcelModel == null ? 0 : parcelModel.hashCode())) * 31) + this.bulkGiftsCountDesc.hashCode()) * 31) + this.bigHornTriggerDiamonds) * 31) + this.smallHornTriggerDiamonds) * 31;
        boolean z10 = this.openBulkGiftsSwitch;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        ExperienceModel experienceModel = this.experience;
        int hashCode3 = (i11 + (experienceModel == null ? 0 : experienceModel.hashCode())) * 31;
        LiveGiftActivityModel liveGiftActivityModel = this.nobleEntryInfo;
        int hashCode4 = (hashCode3 + (liveGiftActivityModel != null ? liveGiftActivityModel.hashCode() : 0)) * 31;
        boolean z11 = this.firstBuy;
        return hashCode4 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean isParcel(@NotNull String fenceId) {
        s.i(fenceId, "fenceId");
        ParcelModel parcelModel = this.parcel;
        return s.d(fenceId, parcelModel != null ? parcelModel.getFenceId() : null);
    }

    @NotNull
    public String toString() {
        List<SingleTabGiftListModel> list = this.giftList;
        ParcelModel parcelModel = this.parcel;
        List<SendGiftCountModel> list2 = this.bulkGiftsCountDesc;
        int i10 = this.bigHornTriggerDiamonds;
        int i11 = this.smallHornTriggerDiamonds;
        boolean z10 = this.openBulkGiftsSwitch;
        ExperienceModel experienceModel = this.experience;
        LiveGiftActivityModel liveGiftActivityModel = this.nobleEntryInfo;
        return "GiftListResult(giftList=" + ((Object) list) + ", parcel=" + ((Object) parcelModel) + ", bulkGiftsCountDesc=" + ((Object) list2) + ", bigHornTriggerDiamonds=" + i10 + ", smallHornTriggerDiamonds=" + i11 + ", openBulkGiftsSwitch=" + z10 + ", experience=" + ((Object) experienceModel) + ", nobleEntryInfo=" + ((Object) liveGiftActivityModel) + ", firstBuy=" + this.firstBuy + ")";
    }
}
