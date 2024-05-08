package com.cupidapp.live.match.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MapFilterPreviewResult {

    @Nullable
    private final List<User> list;

    @Nullable
    private final String title;

    public MapFilterPreviewResult(@Nullable String str, @Nullable List<User> list) {
        this.title = str;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MapFilterPreviewResult copy$default(MapFilterPreviewResult mapFilterPreviewResult, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mapFilterPreviewResult.title;
        }
        if ((i10 & 2) != 0) {
            list = mapFilterPreviewResult.list;
        }
        return mapFilterPreviewResult.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final List<User> component2() {
        return this.list;
    }

    @NotNull
    public final MapFilterPreviewResult copy(@Nullable String str, @Nullable List<User> list) {
        return new MapFilterPreviewResult(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapFilterPreviewResult)) {
            return false;
        }
        MapFilterPreviewResult mapFilterPreviewResult = (MapFilterPreviewResult) obj;
        return s.d(this.title, mapFilterPreviewResult.title) && s.d(this.list, mapFilterPreviewResult.list);
    }

    @Nullable
    public final List<User> getList() {
        return this.list;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<User> list = this.list;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MapFilterPreviewResult(title=" + this.title + ", list=" + ((Object) this.list) + ")";
    }
}
