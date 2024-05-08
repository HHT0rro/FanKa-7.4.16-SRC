package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SingleTabParcelListModel implements Serializable {

    @NotNull
    private final List<ParcelItemModel> list;
    private final int parcelType;

    @NotNull
    private final String title;

    public SingleTabParcelListModel(@NotNull String title, @NotNull List<ParcelItemModel> list, int i10) {
        s.i(title, "title");
        s.i(list, "list");
        this.title = title;
        this.list = list;
        this.parcelType = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleTabParcelListModel copy$default(SingleTabParcelListModel singleTabParcelListModel, String str, List list, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = singleTabParcelListModel.title;
        }
        if ((i11 & 2) != 0) {
            list = singleTabParcelListModel.list;
        }
        if ((i11 & 4) != 0) {
            i10 = singleTabParcelListModel.parcelType;
        }
        return singleTabParcelListModel.copy(str, list, i10);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<ParcelItemModel> component2() {
        return this.list;
    }

    public final int component3() {
        return this.parcelType;
    }

    @NotNull
    public final SingleTabParcelListModel copy(@NotNull String title, @NotNull List<ParcelItemModel> list, int i10) {
        s.i(title, "title");
        s.i(list, "list");
        return new SingleTabParcelListModel(title, list, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SingleTabParcelListModel)) {
            return false;
        }
        SingleTabParcelListModel singleTabParcelListModel = (SingleTabParcelListModel) obj;
        return s.d(this.title, singleTabParcelListModel.title) && s.d(this.list, singleTabParcelListModel.list) && this.parcelType == singleTabParcelListModel.parcelType;
    }

    @NotNull
    public final List<ParcelItemModel> getList() {
        return this.list;
    }

    public final int getParcelType() {
        return this.parcelType;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.list.hashCode()) * 31) + this.parcelType;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        List<ParcelItemModel> list = this.list;
        return "SingleTabParcelListModel(title=" + str + ", list=" + ((Object) list) + ", parcelType=" + this.parcelType + ")";
    }
}
