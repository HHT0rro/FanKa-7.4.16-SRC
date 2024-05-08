package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.R$string;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ParcelModel implements Serializable {

    @Nullable
    private final GiftFragmentsModel clientButton;

    @NotNull
    private final String fenceId;

    @NotNull
    private final List<SingleTabParcelListModel> parcelList;

    @NotNull
    private final String title;

    public ParcelModel(@NotNull String title, @NotNull String fenceId, @NotNull List<SingleTabParcelListModel> parcelList, @Nullable GiftFragmentsModel giftFragmentsModel) {
        s.i(title, "title");
        s.i(fenceId, "fenceId");
        s.i(parcelList, "parcelList");
        this.title = title;
        this.fenceId = fenceId;
        this.parcelList = parcelList;
        this.clientButton = giftFragmentsModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParcelModel copy$default(ParcelModel parcelModel, String str, String str2, List list, GiftFragmentsModel giftFragmentsModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = parcelModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = parcelModel.fenceId;
        }
        if ((i10 & 4) != 0) {
            list = parcelModel.parcelList;
        }
        if ((i10 & 8) != 0) {
            giftFragmentsModel = parcelModel.clientButton;
        }
        return parcelModel.copy(str, str2, list, giftFragmentsModel);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.fenceId;
    }

    @NotNull
    public final List<SingleTabParcelListModel> component3() {
        return this.parcelList;
    }

    @Nullable
    public final GiftFragmentsModel component4() {
        return this.clientButton;
    }

    @NotNull
    public final ParcelModel copy(@NotNull String title, @NotNull String fenceId, @NotNull List<SingleTabParcelListModel> parcelList, @Nullable GiftFragmentsModel giftFragmentsModel) {
        s.i(title, "title");
        s.i(fenceId, "fenceId");
        s.i(parcelList, "parcelList");
        return new ParcelModel(title, fenceId, parcelList, giftFragmentsModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelModel)) {
            return false;
        }
        ParcelModel parcelModel = (ParcelModel) obj;
        return s.d(this.title, parcelModel.title) && s.d(this.fenceId, parcelModel.fenceId) && s.d(this.parcelList, parcelModel.parcelList) && s.d(this.clientButton, parcelModel.clientButton);
    }

    @NotNull
    public final List<SingleTabGiftConfigModel> getAllTabParcelList() {
        Integer valueOf;
        ArrayList arrayList = new ArrayList();
        for (SingleTabParcelListModel singleTabParcelListModel : this.parcelList) {
            int parcelType = singleTabParcelListModel.getParcelType();
            if (parcelType == ParcelModelType.ParcelGiftType.getType()) {
                valueOf = Integer.valueOf(R$string.no_gift);
            } else if (parcelType == ParcelModelType.PropCardType.getType()) {
                valueOf = Integer.valueOf(R$string.no_props);
            } else {
                valueOf = parcelType == ParcelModelType.GiftFragments.getType() ? Integer.valueOf(R$string.no_fragments) : null;
            }
            arrayList.add(new SingleTabGiftConfigModel(singleTabParcelListModel.getList(), singleTabParcelListModel.getTitle(), valueOf));
        }
        return arrayList;
    }

    @Nullable
    public final GiftFragmentsModel getClientButton() {
        return this.clientButton;
    }

    @NotNull
    public final String getFenceId() {
        return this.fenceId;
    }

    @NotNull
    public final List<SingleTabParcelListModel> getParcelList() {
        return this.parcelList;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.fenceId.hashCode()) * 31) + this.parcelList.hashCode()) * 31;
        GiftFragmentsModel giftFragmentsModel = this.clientButton;
        return hashCode + (giftFragmentsModel == null ? 0 : giftFragmentsModel.hashCode());
    }

    @NotNull
    public String toString() {
        return "ParcelModel(title=" + this.title + ", fenceId=" + this.fenceId + ", parcelList=" + ((Object) this.parcelList) + ", clientButton=" + ((Object) this.clientButton) + ")";
    }
}
