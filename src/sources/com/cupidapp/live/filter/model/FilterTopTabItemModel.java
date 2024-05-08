package com.cupidapp.live.filter.model;

import com.cupidapp.live.match.model.FilterOption;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterTopTabModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterTopTabItemModel {
    private final int defaultMax;
    private final int defaultMin;

    @SerializedName("type")
    @NotNull
    private final String filterType;

    @NotNull
    private final String key;
    private final int maxValue;
    private final int minValue;

    @NotNull
    private final String name;

    @Nullable
    private final List<FilterOption> options;
    private final int productType;

    @Nullable
    private final String unit;

    public FilterTopTabItemModel(@NotNull String name, @NotNull String key, @NotNull String filterType, @Nullable List<FilterOption> list, int i10, int i11, int i12, int i13, @Nullable String str, int i14) {
        s.i(name, "name");
        s.i(key, "key");
        s.i(filterType, "filterType");
        this.name = name;
        this.key = key;
        this.filterType = filterType;
        this.options = list;
        this.minValue = i10;
        this.maxValue = i11;
        this.defaultMin = i12;
        this.defaultMax = i13;
        this.unit = str;
        this.productType = i14;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final int component10() {
        return this.productType;
    }

    @NotNull
    public final String component2() {
        return this.key;
    }

    @NotNull
    public final String component3() {
        return this.filterType;
    }

    @Nullable
    public final List<FilterOption> component4() {
        return this.options;
    }

    public final int component5() {
        return this.minValue;
    }

    public final int component6() {
        return this.maxValue;
    }

    public final int component7() {
        return this.defaultMin;
    }

    public final int component8() {
        return this.defaultMax;
    }

    @Nullable
    public final String component9() {
        return this.unit;
    }

    @NotNull
    public final FilterTopTabItemModel copy(@NotNull String name, @NotNull String key, @NotNull String filterType, @Nullable List<FilterOption> list, int i10, int i11, int i12, int i13, @Nullable String str, int i14) {
        s.i(name, "name");
        s.i(key, "key");
        s.i(filterType, "filterType");
        return new FilterTopTabItemModel(name, key, filterType, list, i10, i11, i12, i13, str, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterTopTabItemModel)) {
            return false;
        }
        FilterTopTabItemModel filterTopTabItemModel = (FilterTopTabItemModel) obj;
        return s.d(this.name, filterTopTabItemModel.name) && s.d(this.key, filterTopTabItemModel.key) && s.d(this.filterType, filterTopTabItemModel.filterType) && s.d(this.options, filterTopTabItemModel.options) && this.minValue == filterTopTabItemModel.minValue && this.maxValue == filterTopTabItemModel.maxValue && this.defaultMin == filterTopTabItemModel.defaultMin && this.defaultMax == filterTopTabItemModel.defaultMax && s.d(this.unit, filterTopTabItemModel.unit) && this.productType == filterTopTabItemModel.productType;
    }

    public final int getDefaultMax() {
        return this.defaultMax;
    }

    public final int getDefaultMin() {
        return this.defaultMin;
    }

    @NotNull
    public final String getFilterType() {
        return this.filterType;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final int getMinValue() {
        return this.minValue;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<FilterOption> getOptions() {
        return this.options;
    }

    public final int getProductType() {
        return this.productType;
    }

    @Nullable
    public final String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.key.hashCode()) * 31) + this.filterType.hashCode()) * 31;
        List<FilterOption> list = this.options;
        int hashCode2 = (((((((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.minValue) * 31) + this.maxValue) * 31) + this.defaultMin) * 31) + this.defaultMax) * 31;
        String str = this.unit;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.productType;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.key;
        String str3 = this.filterType;
        List<FilterOption> list = this.options;
        return "FilterTopTabItemModel(name=" + str + ", key=" + str2 + ", filterType=" + str3 + ", options=" + ((Object) list) + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", defaultMin=" + this.defaultMin + ", defaultMax=" + this.defaultMax + ", unit=" + this.unit + ", productType=" + this.productType + ")";
    }
}
