package com.cupidapp.live.maskparty.model;

import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ItemCardFeaturesItemModel {
    private boolean selected;

    @NotNull
    private final ItemCardType type;

    @Nullable
    private Integer value;

    @Nullable
    private List<Integer> values;

    /* compiled from: MaskPartyItemCardModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16368a;

        static {
            int[] iArr = new int[ItemCardType.values().length];
            try {
                iArr[ItemCardType.AttackMatch.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemCardType.CitySearch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemCardType.SpeedUpMatch.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ItemCardType.MatchNumber.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f16368a = iArr;
        }
    }

    public ItemCardFeaturesItemModel(@NotNull ItemCardType type, @Nullable Integer num, @Nullable List<Integer> list, boolean z10) {
        s.i(type, "type");
        this.type = type;
        this.value = num;
        this.values = list;
        this.selected = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItemCardFeaturesItemModel copy$default(ItemCardFeaturesItemModel itemCardFeaturesItemModel, ItemCardType itemCardType, Integer num, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            itemCardType = itemCardFeaturesItemModel.type;
        }
        if ((i10 & 2) != 0) {
            num = itemCardFeaturesItemModel.value;
        }
        if ((i10 & 4) != 0) {
            list = itemCardFeaturesItemModel.values;
        }
        if ((i10 & 8) != 0) {
            z10 = itemCardFeaturesItemModel.selected;
        }
        return itemCardFeaturesItemModel.copy(itemCardType, num, list, z10);
    }

    @NotNull
    public final ItemCardType component1() {
        return this.type;
    }

    @Nullable
    public final Integer component2() {
        return this.value;
    }

    @Nullable
    public final List<Integer> component3() {
        return this.values;
    }

    public final boolean component4() {
        return this.selected;
    }

    @NotNull
    public final ItemCardFeaturesItemModel copy(@NotNull ItemCardType type, @Nullable Integer num, @Nullable List<Integer> list, boolean z10) {
        s.i(type, "type");
        return new ItemCardFeaturesItemModel(type, num, list, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemCardFeaturesItemModel)) {
            return false;
        }
        ItemCardFeaturesItemModel itemCardFeaturesItemModel = (ItemCardFeaturesItemModel) obj;
        return this.type == itemCardFeaturesItemModel.type && s.d(this.value, itemCardFeaturesItemModel.value) && s.d(this.values, itemCardFeaturesItemModel.values) && this.selected == itemCardFeaturesItemModel.selected;
    }

    public final int getBigIcon() {
        int i10 = a.f16368a[this.type.ordinal()];
        if (i10 == 1) {
            return R$mipmap.icon_attack_match;
        }
        if (i10 == 2) {
            return R$mipmap.icon_city_search;
        }
        if (i10 == 3) {
            return R$mipmap.icon_speed_up_match;
        }
        if (i10 == 4) {
            return R$mipmap.icon_match_number;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getContent() {
        int i10 = a.f16368a[this.type.ordinal()];
        if (i10 == 1) {
            return R$string.attack_match_content;
        }
        if (i10 == 2) {
            return R$string.city_search_content;
        }
        if (i10 == 3) {
            return R$string.speed_up_match_content;
        }
        if (i10 == 4) {
            return R$string.match_number_content;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getIcon() {
        int i10 = a.f16368a[this.type.ordinal()];
        if (i10 == 1) {
            return R$mipmap.icon_attack_match_mini;
        }
        if (i10 == 2) {
            return R$mipmap.icon_city_search_mini;
        }
        if (i10 == 3) {
            return R$mipmap.icon_speed_up_match_mini;
        }
        if (i10 == 4) {
            return R$mipmap.icon_match_number_mini;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final int getTitle() {
        int i10 = a.f16368a[this.type.ordinal()];
        if (i10 == 1) {
            return R$string.attack_match;
        }
        if (i10 == 2) {
            return R$string.city_search;
        }
        if (i10 == 3) {
            return R$string.speed_up_match;
        }
        if (i10 == 4) {
            return R$string.match_number;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final ItemCardType getType() {
        return this.type;
    }

    @Nullable
    public final Integer getValue() {
        return this.value;
    }

    @Nullable
    public final List<Integer> getValues() {
        return this.values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        Integer num = this.value;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<Integer> list = this.values;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z10 = this.selected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode3 + i10;
    }

    public final void setSelected(boolean z10) {
        this.selected = z10;
    }

    public final void setValue(@Nullable Integer num) {
        this.value = num;
    }

    public final void setValues(@Nullable List<Integer> list) {
        this.values = list;
    }

    @NotNull
    public String toString() {
        ItemCardType itemCardType = this.type;
        Integer num = this.value;
        List<Integer> list = this.values;
        return "ItemCardFeaturesItemModel(type=" + ((Object) itemCardType) + ", value=" + ((Object) num) + ", values=" + ((Object) list) + ", selected=" + this.selected + ")";
    }

    public /* synthetic */ ItemCardFeaturesItemModel(ItemCardType itemCardType, Integer num, List list, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemCardType, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : list, (i10 & 8) != 0 ? false : z10);
    }
}
