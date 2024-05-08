package com.cupidapp.live.match.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RegionModel implements Serializable {

    @NotNull
    private final String code;

    @NotNull
    private final String name;

    @Nullable
    private List<RegionModel> regions;

    public RegionModel(@NotNull String code, @NotNull String name, @Nullable List<RegionModel> list) {
        s.i(code, "code");
        s.i(name, "name");
        this.code = code;
        this.name = name;
        this.regions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegionModel copy$default(RegionModel regionModel, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = regionModel.code;
        }
        if ((i10 & 2) != 0) {
            str2 = regionModel.name;
        }
        if ((i10 & 4) != 0) {
            list = regionModel.regions;
        }
        return regionModel.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final List<RegionModel> component3() {
        return this.regions;
    }

    @NotNull
    public final RegionModel copy(@NotNull String code, @NotNull String name, @Nullable List<RegionModel> list) {
        s.i(code, "code");
        s.i(name, "name");
        return new RegionModel(code, name, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegionModel)) {
            return false;
        }
        RegionModel regionModel = (RegionModel) obj;
        return s.d(this.code, regionModel.code) && s.d(this.name, regionModel.name) && s.d(this.regions, regionModel.regions);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<RegionModel> getRegions() {
        return this.regions;
    }

    public int hashCode() {
        int hashCode = ((this.code.hashCode() * 31) + this.name.hashCode()) * 31;
        List<RegionModel> list = this.regions;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setRegions(@Nullable List<RegionModel> list) {
        this.regions = list;
    }

    @NotNull
    public String toString() {
        return "RegionModel(code=" + this.code + ", name=" + this.name + ", regions=" + ((Object) this.regions) + ")";
    }
}
