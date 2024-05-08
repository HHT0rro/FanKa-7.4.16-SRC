package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CurrentSelectCityUiModel {

    @NotNull
    private final RegionModel region;

    @NotNull
    private final String title;

    public CurrentSelectCityUiModel(@NotNull String title, @NotNull RegionModel region) {
        s.i(title, "title");
        s.i(region, "region");
        this.title = title;
        this.region = region;
    }

    public static /* synthetic */ CurrentSelectCityUiModel copy$default(CurrentSelectCityUiModel currentSelectCityUiModel, String str, RegionModel regionModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = currentSelectCityUiModel.title;
        }
        if ((i10 & 2) != 0) {
            regionModel = currentSelectCityUiModel.region;
        }
        return currentSelectCityUiModel.copy(str, regionModel);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final RegionModel component2() {
        return this.region;
    }

    @NotNull
    public final CurrentSelectCityUiModel copy(@NotNull String title, @NotNull RegionModel region) {
        s.i(title, "title");
        s.i(region, "region");
        return new CurrentSelectCityUiModel(title, region);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurrentSelectCityUiModel)) {
            return false;
        }
        CurrentSelectCityUiModel currentSelectCityUiModel = (CurrentSelectCityUiModel) obj;
        return s.d(this.title, currentSelectCityUiModel.title) && s.d(this.region, currentSelectCityUiModel.region);
    }

    @NotNull
    public final RegionModel getRegion() {
        return this.region;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.region.hashCode();
    }

    @NotNull
    public String toString() {
        return "CurrentSelectCityUiModel(title=" + this.title + ", region=" + ((Object) this.region) + ")";
    }
}
