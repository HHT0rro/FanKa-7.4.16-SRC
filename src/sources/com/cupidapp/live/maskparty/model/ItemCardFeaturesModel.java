package com.cupidapp.live.maskparty.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ItemCardFeaturesModel {

    @NotNull
    private final List<ItemCardFeaturesItemModel> list;

    public ItemCardFeaturesModel(@NotNull List<ItemCardFeaturesItemModel> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItemCardFeaturesModel copy$default(ItemCardFeaturesModel itemCardFeaturesModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = itemCardFeaturesModel.list;
        }
        return itemCardFeaturesModel.copy(list);
    }

    @NotNull
    public final List<ItemCardFeaturesItemModel> component1() {
        return this.list;
    }

    @NotNull
    public final ItemCardFeaturesModel copy(@NotNull List<ItemCardFeaturesItemModel> list) {
        s.i(list, "list");
        return new ItemCardFeaturesModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ItemCardFeaturesModel) && s.d(this.list, ((ItemCardFeaturesModel) obj).list);
    }

    @NotNull
    public final List<ItemCardFeaturesItemModel> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "ItemCardFeaturesModel(list=" + ((Object) this.list) + ")";
    }
}
