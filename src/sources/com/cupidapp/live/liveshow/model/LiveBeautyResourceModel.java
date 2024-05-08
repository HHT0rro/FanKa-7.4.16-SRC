package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveBeautyResourceModel implements Serializable {

    @Nullable
    private final String name;
    private final int size;

    @Nullable
    private final String url;

    public LiveBeautyResourceModel(int i10, @Nullable String str, @Nullable String str2) {
        this.size = i10;
        this.url = str;
        this.name = str2;
    }

    public static /* synthetic */ LiveBeautyResourceModel copy$default(LiveBeautyResourceModel liveBeautyResourceModel, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = liveBeautyResourceModel.size;
        }
        if ((i11 & 2) != 0) {
            str = liveBeautyResourceModel.url;
        }
        if ((i11 & 4) != 0) {
            str2 = liveBeautyResourceModel.name;
        }
        return liveBeautyResourceModel.copy(i10, str, str2);
    }

    public final int component1() {
        return this.size;
    }

    @Nullable
    public final String component2() {
        return this.url;
    }

    @Nullable
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final LiveBeautyResourceModel copy(int i10, @Nullable String str, @Nullable String str2) {
        return new LiveBeautyResourceModel(i10, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveBeautyResourceModel)) {
            return false;
        }
        LiveBeautyResourceModel liveBeautyResourceModel = (LiveBeautyResourceModel) obj;
        return this.size == liveBeautyResourceModel.size && s.d(this.url, liveBeautyResourceModel.url) && s.d(this.name, liveBeautyResourceModel.name);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final int getSize() {
        return this.size;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i10 = this.size * 31;
        String str = this.url;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveBeautyResourceModel(size=" + this.size + ", url=" + this.url + ", name=" + this.name + ")";
    }
}
