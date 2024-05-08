package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePopupWindowModel {
    private final int dayMaxViewCount;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f12009id;

    @NotNull
    private final ImageModel image;
    private final int intervalViewTime;

    @Nullable
    private final String url;

    public LivePopupWindowModel(@NotNull String id2, @NotNull ImageModel image, @Nullable String str, int i10, int i11) {
        s.i(id2, "id");
        s.i(image, "image");
        this.f12009id = id2;
        this.image = image;
        this.url = str;
        this.dayMaxViewCount = i10;
        this.intervalViewTime = i11;
    }

    public static /* synthetic */ LivePopupWindowModel copy$default(LivePopupWindowModel livePopupWindowModel, String str, ImageModel imageModel, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = livePopupWindowModel.f12009id;
        }
        if ((i12 & 2) != 0) {
            imageModel = livePopupWindowModel.image;
        }
        ImageModel imageModel2 = imageModel;
        if ((i12 & 4) != 0) {
            str2 = livePopupWindowModel.url;
        }
        String str3 = str2;
        if ((i12 & 8) != 0) {
            i10 = livePopupWindowModel.dayMaxViewCount;
        }
        int i13 = i10;
        if ((i12 & 16) != 0) {
            i11 = livePopupWindowModel.intervalViewTime;
        }
        return livePopupWindowModel.copy(str, imageModel2, str3, i13, i11);
    }

    @NotNull
    public final String component1() {
        return this.f12009id;
    }

    @NotNull
    public final ImageModel component2() {
        return this.image;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    public final int component4() {
        return this.dayMaxViewCount;
    }

    public final int component5() {
        return this.intervalViewTime;
    }

    @NotNull
    public final LivePopupWindowModel copy(@NotNull String id2, @NotNull ImageModel image, @Nullable String str, int i10, int i11) {
        s.i(id2, "id");
        s.i(image, "image");
        return new LivePopupWindowModel(id2, image, str, i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePopupWindowModel)) {
            return false;
        }
        LivePopupWindowModel livePopupWindowModel = (LivePopupWindowModel) obj;
        return s.d(this.f12009id, livePopupWindowModel.f12009id) && s.d(this.image, livePopupWindowModel.image) && s.d(this.url, livePopupWindowModel.url) && this.dayMaxViewCount == livePopupWindowModel.dayMaxViewCount && this.intervalViewTime == livePopupWindowModel.intervalViewTime;
    }

    public final int getDayMaxViewCount() {
        return this.dayMaxViewCount;
    }

    @NotNull
    public final String getId() {
        return this.f12009id;
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    public final int getIntervalViewTime() {
        return this.intervalViewTime;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = ((this.f12009id.hashCode() * 31) + this.image.hashCode()) * 31;
        String str = this.url;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.dayMaxViewCount) * 31) + this.intervalViewTime;
    }

    @NotNull
    public String toString() {
        String str = this.f12009id;
        ImageModel imageModel = this.image;
        return "LivePopupWindowModel(id=" + str + ", image=" + ((Object) imageModel) + ", url=" + this.url + ", dayMaxViewCount=" + this.dayMaxViewCount + ", intervalViewTime=" + this.intervalViewTime + ")";
    }
}
