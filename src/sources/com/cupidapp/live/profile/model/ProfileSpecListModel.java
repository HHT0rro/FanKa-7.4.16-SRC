package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileSpecListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileSpecListModel implements Serializable {

    @Nullable
    private final String displayName;

    @Nullable
    private final ImageModel icon;

    @NotNull
    private final String itemId;

    @Nullable
    private final List<String> labelList;

    @NotNull
    private final String maxValue;

    @NotNull
    private final String minValue;

    @NotNull
    private final String name;

    @Nullable
    private final List<AddInfoOptionsModel> options;
    private final boolean primary;
    private final boolean redDot;

    @NotNull
    private final String type;

    @Nullable
    private String unit;

    @Nullable
    private final List<String> valueList;

    public ProfileSpecListModel(@NotNull String minValue, @NotNull String maxValue, boolean z10, @NotNull String itemId, @NotNull String name, @NotNull String type, @Nullable String str, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<AddInfoOptionsModel> list3, @Nullable ImageModel imageModel, @Nullable String str2, boolean z11) {
        s.i(minValue, "minValue");
        s.i(maxValue, "maxValue");
        s.i(itemId, "itemId");
        s.i(name, "name");
        s.i(type, "type");
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.primary = z10;
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.unit = str;
        this.valueList = list;
        this.labelList = list2;
        this.options = list3;
        this.icon = imageModel;
        this.displayName = str2;
        this.redDot = z11;
    }

    @NotNull
    public final String component1() {
        return this.minValue;
    }

    @Nullable
    public final List<AddInfoOptionsModel> component10() {
        return this.options;
    }

    @Nullable
    public final ImageModel component11() {
        return this.icon;
    }

    @Nullable
    public final String component12() {
        return this.displayName;
    }

    public final boolean component13() {
        return this.redDot;
    }

    @NotNull
    public final String component2() {
        return this.maxValue;
    }

    public final boolean component3() {
        return this.primary;
    }

    @NotNull
    public final String component4() {
        return this.itemId;
    }

    @NotNull
    public final String component5() {
        return this.name;
    }

    @NotNull
    public final String component6() {
        return this.type;
    }

    @Nullable
    public final String component7() {
        return this.unit;
    }

    @Nullable
    public final List<String> component8() {
        return this.valueList;
    }

    @Nullable
    public final List<String> component9() {
        return this.labelList;
    }

    @NotNull
    public final ProfileSpecListModel copy(@NotNull String minValue, @NotNull String maxValue, boolean z10, @NotNull String itemId, @NotNull String name, @NotNull String type, @Nullable String str, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<AddInfoOptionsModel> list3, @Nullable ImageModel imageModel, @Nullable String str2, boolean z11) {
        s.i(minValue, "minValue");
        s.i(maxValue, "maxValue");
        s.i(itemId, "itemId");
        s.i(name, "name");
        s.i(type, "type");
        return new ProfileSpecListModel(minValue, maxValue, z10, itemId, name, type, str, list, list2, list3, imageModel, str2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileSpecListModel)) {
            return false;
        }
        ProfileSpecListModel profileSpecListModel = (ProfileSpecListModel) obj;
        return s.d(this.minValue, profileSpecListModel.minValue) && s.d(this.maxValue, profileSpecListModel.maxValue) && this.primary == profileSpecListModel.primary && s.d(this.itemId, profileSpecListModel.itemId) && s.d(this.name, profileSpecListModel.name) && s.d(this.type, profileSpecListModel.type) && s.d(this.unit, profileSpecListModel.unit) && s.d(this.valueList, profileSpecListModel.valueList) && s.d(this.labelList, profileSpecListModel.labelList) && s.d(this.options, profileSpecListModel.options) && s.d(this.icon, profileSpecListModel.icon) && s.d(this.displayName, profileSpecListModel.displayName) && this.redDot == profileSpecListModel.redDot;
    }

    @Nullable
    public final String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final List<String> getLabelList() {
        return this.labelList;
    }

    @NotNull
    public final String getMaxValue() {
        return this.maxValue;
    }

    @NotNull
    public final String getMinValue() {
        return this.minValue;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<AddInfoOptionsModel> getOptions() {
        return this.options;
    }

    public final boolean getPrimary() {
        return this.primary;
    }

    public final boolean getRedDot() {
        return this.redDot;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUnit() {
        return this.unit;
    }

    @Nullable
    public final List<String> getValueList() {
        return this.valueList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.minValue.hashCode() * 31) + this.maxValue.hashCode()) * 31;
        boolean z10 = this.primary;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int hashCode2 = (((((((hashCode + i10) * 31) + this.itemId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str = this.unit;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.valueList;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.labelList;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<AddInfoOptionsModel> list3 = this.options;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        ImageModel imageModel = this.icon;
        int hashCode7 = (hashCode6 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.displayName;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z11 = this.redDot;
        return hashCode8 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final void setUnit(@Nullable String str) {
        this.unit = str;
    }

    @NotNull
    public String toString() {
        String str = this.minValue;
        String str2 = this.maxValue;
        boolean z10 = this.primary;
        String str3 = this.itemId;
        String str4 = this.name;
        String str5 = this.type;
        String str6 = this.unit;
        List<String> list = this.valueList;
        List<String> list2 = this.labelList;
        List<AddInfoOptionsModel> list3 = this.options;
        ImageModel imageModel = this.icon;
        return "ProfileSpecListModel(minValue=" + str + ", maxValue=" + str2 + ", primary=" + z10 + ", itemId=" + str3 + ", name=" + str4 + ", type=" + str5 + ", unit=" + str6 + ", valueList=" + ((Object) list) + ", labelList=" + ((Object) list2) + ", options=" + ((Object) list3) + ", icon=" + ((Object) imageModel) + ", displayName=" + this.displayName + ", redDot=" + this.redDot + ")";
    }

    public /* synthetic */ ProfileSpecListModel(String str, String str2, boolean z10, String str3, String str4, String str5, String str6, List list, List list2, List list3, ImageModel imageModel, String str7, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z10, str3, str4, str5, str6, list, list2, list3, imageModel, str7, (i10 & 4096) != 0 ? false : z11);
    }
}
