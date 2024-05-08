package com.cupidapp.live.match.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HotViewModel {

    @NotNull
    private final List<RegionModel> regions;

    @NotNull
    private final String title;

    public HotViewModel(@NotNull String title, @NotNull List<RegionModel> regions) {
        s.i(title, "title");
        s.i(regions, "regions");
        this.title = title;
        this.regions = regions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HotViewModel copy$default(HotViewModel hotViewModel, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = hotViewModel.title;
        }
        if ((i10 & 2) != 0) {
            list = hotViewModel.regions;
        }
        return hotViewModel.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<RegionModel> component2() {
        return this.regions;
    }

    @NotNull
    public final HotViewModel copy(@NotNull String title, @NotNull List<RegionModel> regions) {
        s.i(title, "title");
        s.i(regions, "regions");
        return new HotViewModel(title, regions);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HotViewModel)) {
            return false;
        }
        HotViewModel hotViewModel = (HotViewModel) obj;
        return s.d(this.title, hotViewModel.title) && s.d(this.regions, hotViewModel.regions);
    }

    @NotNull
    public final List<RegionModel> getRegions() {
        return this.regions;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.regions.hashCode();
    }

    @NotNull
    public String toString() {
        return "HotViewModel(title=" + this.title + ", regions=" + ((Object) this.regions) + ")";
    }
}
