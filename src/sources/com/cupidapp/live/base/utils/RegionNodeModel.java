package com.cupidapp.live.base.utils;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RegionNodeUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RegionNodeModel {

    @Nullable
    private final String abbr;

    @NotNull
    private final String name;

    @Nullable
    private final Map<String, RegionNodeModel> regions;

    public RegionNodeModel(@NotNull String name, @Nullable String str, @Nullable Map<String, RegionNodeModel> map) {
        kotlin.jvm.internal.s.i(name, "name");
        this.name = name;
        this.abbr = str;
        this.regions = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegionNodeModel copy$default(RegionNodeModel regionNodeModel, String str, String str2, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = regionNodeModel.name;
        }
        if ((i10 & 2) != 0) {
            str2 = regionNodeModel.abbr;
        }
        if ((i10 & 4) != 0) {
            map = regionNodeModel.regions;
        }
        return regionNodeModel.copy(str, str2, map);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.abbr;
    }

    @Nullable
    public final Map<String, RegionNodeModel> component3() {
        return this.regions;
    }

    @NotNull
    public final RegionNodeModel copy(@NotNull String name, @Nullable String str, @Nullable Map<String, RegionNodeModel> map) {
        kotlin.jvm.internal.s.i(name, "name");
        return new RegionNodeModel(name, str, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegionNodeModel)) {
            return false;
        }
        RegionNodeModel regionNodeModel = (RegionNodeModel) obj;
        return kotlin.jvm.internal.s.d(this.name, regionNodeModel.name) && kotlin.jvm.internal.s.d(this.abbr, regionNodeModel.abbr) && kotlin.jvm.internal.s.d(this.regions, regionNodeModel.regions);
    }

    @Nullable
    public final String getAbbr() {
        return this.abbr;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Map<String, RegionNodeModel> getRegions() {
        return this.regions;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.abbr;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, RegionNodeModel> map = this.regions;
        return hashCode2 + (map != null ? map.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RegionNodeModel(name=" + this.name + ", abbr=" + this.abbr + ", regions=" + ((Object) this.regions) + ")";
    }
}
