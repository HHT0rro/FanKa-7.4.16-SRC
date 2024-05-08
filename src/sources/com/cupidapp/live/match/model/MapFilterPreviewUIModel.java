package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MapFilterPreviewUIModel {

    @NotNull
    private final List<ImageModel> avatars;

    @Nullable
    private final String title;

    public MapFilterPreviewUIModel(@Nullable String str, @NotNull List<ImageModel> avatars) {
        s.i(avatars, "avatars");
        this.title = str;
        this.avatars = avatars;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MapFilterPreviewUIModel copy$default(MapFilterPreviewUIModel mapFilterPreviewUIModel, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mapFilterPreviewUIModel.title;
        }
        if ((i10 & 2) != 0) {
            list = mapFilterPreviewUIModel.avatars;
        }
        return mapFilterPreviewUIModel.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<ImageModel> component2() {
        return this.avatars;
    }

    @NotNull
    public final MapFilterPreviewUIModel copy(@Nullable String str, @NotNull List<ImageModel> avatars) {
        s.i(avatars, "avatars");
        return new MapFilterPreviewUIModel(str, avatars);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapFilterPreviewUIModel)) {
            return false;
        }
        MapFilterPreviewUIModel mapFilterPreviewUIModel = (MapFilterPreviewUIModel) obj;
        return s.d(this.title, mapFilterPreviewUIModel.title) && s.d(this.avatars, mapFilterPreviewUIModel.avatars);
    }

    @NotNull
    public final List<ImageModel> getAvatars() {
        return this.avatars;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.avatars.hashCode();
    }

    @NotNull
    public String toString() {
        return "MapFilterPreviewUIModel(title=" + this.title + ", avatars=" + ((Object) this.avatars) + ")";
    }
}
