package com.cupidapp.live.match.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchFilterModel implements Serializable {
    private final int defaultMax;
    private final int defaultMin;

    @NotNull
    private final String key;

    @Nullable
    private final List<Map<String, String>> labelValueList;
    private int maxValue;
    private int minValue;

    @NotNull
    private final String name;

    @NotNull
    private final MatchFilterType type;

    @Nullable
    private final String unit;

    @Nullable
    private final List<String> valueList;

    /* compiled from: MatchSetttingModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum MatchFilterType {
        Checkbox("Checkbox"),
        Range("Range");


        @NotNull
        private final String type;

        MatchFilterType(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MatchFilterModel(@NotNull String name, @NotNull String key, @NotNull MatchFilterType type, @Nullable List<? extends Map<String, String>> list, @Nullable List<String> list2, int i10, int i11, int i12, int i13, @Nullable String str) {
        s.i(name, "name");
        s.i(key, "key");
        s.i(type, "type");
        this.name = name;
        this.key = key;
        this.type = type;
        this.labelValueList = list;
        this.valueList = list2;
        this.minValue = i10;
        this.maxValue = i11;
        this.defaultMin = i12;
        this.defaultMax = i13;
        this.unit = str;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component10() {
        return this.unit;
    }

    @NotNull
    public final String component2() {
        return this.key;
    }

    @NotNull
    public final MatchFilterType component3() {
        return this.type;
    }

    @Nullable
    public final List<Map<String, String>> component4() {
        return this.labelValueList;
    }

    @Nullable
    public final List<String> component5() {
        return this.valueList;
    }

    public final int component6() {
        return this.minValue;
    }

    public final int component7() {
        return this.maxValue;
    }

    public final int component8() {
        return this.defaultMin;
    }

    public final int component9() {
        return this.defaultMax;
    }

    @NotNull
    public final MatchFilterModel copy(@NotNull String name, @NotNull String key, @NotNull MatchFilterType type, @Nullable List<? extends Map<String, String>> list, @Nullable List<String> list2, int i10, int i11, int i12, int i13, @Nullable String str) {
        s.i(name, "name");
        s.i(key, "key");
        s.i(type, "type");
        return new MatchFilterModel(name, key, type, list, list2, i10, i11, i12, i13, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchFilterModel)) {
            return false;
        }
        MatchFilterModel matchFilterModel = (MatchFilterModel) obj;
        return s.d(this.name, matchFilterModel.name) && s.d(this.key, matchFilterModel.key) && this.type == matchFilterModel.type && s.d(this.labelValueList, matchFilterModel.labelValueList) && s.d(this.valueList, matchFilterModel.valueList) && this.minValue == matchFilterModel.minValue && this.maxValue == matchFilterModel.maxValue && this.defaultMin == matchFilterModel.defaultMin && this.defaultMax == matchFilterModel.defaultMax && s.d(this.unit, matchFilterModel.unit);
    }

    public final int getDefaultMax() {
        return this.defaultMax;
    }

    public final int getDefaultMin() {
        return this.defaultMin;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final Map<String, String> getLabelMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Map<String, String>> list = this.labelValueList;
        if (list != null) {
            Iterator<Map<String, String>> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                linkedHashMap.putAll(iterator2.next());
            }
        }
        return linkedHashMap;
    }

    @Nullable
    public final List<Map<String, String>> getLabelValueList() {
        return this.labelValueList;
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

    @NotNull
    public final MatchFilterType getType() {
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

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.key.hashCode()) * 31) + this.type.hashCode()) * 31;
        List<Map<String, String>> list = this.labelValueList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.valueList;
        int hashCode3 = (((((((((hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31) + this.minValue) * 31) + this.maxValue) * 31) + this.defaultMin) * 31) + this.defaultMax) * 31;
        String str = this.unit;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final void setMaxValue(int i10) {
        this.maxValue = i10;
    }

    public final void setMinValue(int i10) {
        this.minValue = i10;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        String str2 = this.key;
        MatchFilterType matchFilterType = this.type;
        List<Map<String, String>> list = this.labelValueList;
        List<String> list2 = this.valueList;
        return "MatchFilterModel(name=" + str + ", key=" + str2 + ", type=" + ((Object) matchFilterType) + ", labelValueList=" + ((Object) list) + ", valueList=" + ((Object) list2) + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", defaultMin=" + this.defaultMin + ", defaultMax=" + this.defaultMax + ", unit=" + this.unit + ")";
    }
}
