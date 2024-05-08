package com.cupidapp.live.liveshow.beauty.model;

import com.cupidapp.live.liveshow.beauty.view.FKLiveFilterViewModel;
import java.io.Serializable;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveBeautyItemModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBeautyEditCacheModel implements Serializable {

    @Nullable
    private FKLiveFilterViewModel filter;

    @NotNull
    private final Map<String, Float> map;

    public FKLiveBeautyEditCacheModel(@NotNull Map<String, Float> map, @Nullable FKLiveFilterViewModel fKLiveFilterViewModel) {
        s.i(map, "map");
        this.map = map;
        this.filter = fKLiveFilterViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKLiveBeautyEditCacheModel copy$default(FKLiveBeautyEditCacheModel fKLiveBeautyEditCacheModel, Map map, FKLiveFilterViewModel fKLiveFilterViewModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = fKLiveBeautyEditCacheModel.map;
        }
        if ((i10 & 2) != 0) {
            fKLiveFilterViewModel = fKLiveBeautyEditCacheModel.filter;
        }
        return fKLiveBeautyEditCacheModel.copy(map, fKLiveFilterViewModel);
    }

    @NotNull
    public final Map<String, Float> component1() {
        return this.map;
    }

    @Nullable
    public final FKLiveFilterViewModel component2() {
        return this.filter;
    }

    @NotNull
    public final FKLiveBeautyEditCacheModel copy(@NotNull Map<String, Float> map, @Nullable FKLiveFilterViewModel fKLiveFilterViewModel) {
        s.i(map, "map");
        return new FKLiveBeautyEditCacheModel(map, fKLiveFilterViewModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKLiveBeautyEditCacheModel)) {
            return false;
        }
        FKLiveBeautyEditCacheModel fKLiveBeautyEditCacheModel = (FKLiveBeautyEditCacheModel) obj;
        return s.d(this.map, fKLiveBeautyEditCacheModel.map) && s.d(this.filter, fKLiveBeautyEditCacheModel.filter);
    }

    @Nullable
    public final FKLiveFilterViewModel getFilter() {
        return this.filter;
    }

    @NotNull
    public final Map<String, Float> getMap() {
        return this.map;
    }

    public int hashCode() {
        int hashCode = this.map.hashCode() * 31;
        FKLiveFilterViewModel fKLiveFilterViewModel = this.filter;
        return hashCode + (fKLiveFilterViewModel == null ? 0 : fKLiveFilterViewModel.hashCode());
    }

    public final void setFilter(@Nullable FKLiveFilterViewModel fKLiveFilterViewModel) {
        this.filter = fKLiveFilterViewModel;
    }

    @NotNull
    public String toString() {
        return "FKLiveBeautyEditCacheModel(map=" + ((Object) this.map) + ", filter=" + ((Object) this.filter) + ")";
    }

    public /* synthetic */ FKLiveBeautyEditCacheModel(Map map, FKLiveFilterViewModel fKLiveFilterViewModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i10 & 2) != 0 ? null : fKLiveFilterViewModel);
    }
}
