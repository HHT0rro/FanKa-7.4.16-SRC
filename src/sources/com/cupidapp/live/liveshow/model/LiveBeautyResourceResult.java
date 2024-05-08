package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveBeautyResourceResult {

    @Nullable
    private final List<LiveBeautyResourceModel> resources;
    private final int version;

    public LiveBeautyResourceResult(int i10, @Nullable List<LiveBeautyResourceModel> list) {
        this.version = i10;
        this.resources = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveBeautyResourceResult copy$default(LiveBeautyResourceResult liveBeautyResourceResult, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = liveBeautyResourceResult.version;
        }
        if ((i11 & 2) != 0) {
            list = liveBeautyResourceResult.resources;
        }
        return liveBeautyResourceResult.copy(i10, list);
    }

    public final int component1() {
        return this.version;
    }

    @Nullable
    public final List<LiveBeautyResourceModel> component2() {
        return this.resources;
    }

    @NotNull
    public final LiveBeautyResourceResult copy(int i10, @Nullable List<LiveBeautyResourceModel> list) {
        return new LiveBeautyResourceResult(i10, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveBeautyResourceResult)) {
            return false;
        }
        LiveBeautyResourceResult liveBeautyResourceResult = (LiveBeautyResourceResult) obj;
        return this.version == liveBeautyResourceResult.version && s.d(this.resources, liveBeautyResourceResult.resources);
    }

    @Nullable
    public final List<LiveBeautyResourceModel> getResources() {
        return this.resources;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int i10 = this.version * 31;
        List<LiveBeautyResourceModel> list = this.resources;
        return i10 + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "LiveBeautyResourceResult(version=" + this.version + ", resources=" + ((Object) this.resources) + ")";
    }
}
