package com.cupidapp.live.liveshow.model;

import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveBeautyResourceSaveModel {

    @Nullable
    private final Map<String, String> resources;

    public LiveBeautyResourceSaveModel(@Nullable Map<String, String> map) {
        this.resources = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveBeautyResourceSaveModel copy$default(LiveBeautyResourceSaveModel liveBeautyResourceSaveModel, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = liveBeautyResourceSaveModel.resources;
        }
        return liveBeautyResourceSaveModel.copy(map);
    }

    @Nullable
    public final Map<String, String> component1() {
        return this.resources;
    }

    @NotNull
    public final LiveBeautyResourceSaveModel copy(@Nullable Map<String, String> map) {
        return new LiveBeautyResourceSaveModel(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveBeautyResourceSaveModel) && s.d(this.resources, ((LiveBeautyResourceSaveModel) obj).resources);
    }

    @Nullable
    public final Map<String, String> getResources() {
        return this.resources;
    }

    public int hashCode() {
        Map<String, String> map = this.resources;
        if (map == null) {
            return 0;
        }
        return map.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveBeautyResourceSaveModel(resources=" + ((Object) this.resources) + ")";
    }
}
