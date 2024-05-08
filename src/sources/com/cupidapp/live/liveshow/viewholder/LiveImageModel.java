package com.cupidapp.live.liveshow.viewholder;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveImageViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveImageModel {

    @Nullable
    private final String bannerId;

    @NotNull
    private final ImageModel imageModel;

    @Nullable
    private final String url;

    public LiveImageModel(@NotNull ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        s.i(imageModel, "imageModel");
        this.imageModel = imageModel;
        this.url = str;
        this.bannerId = str2;
    }

    public static /* synthetic */ LiveImageModel copy$default(LiveImageModel liveImageModel, ImageModel imageModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = liveImageModel.imageModel;
        }
        if ((i10 & 2) != 0) {
            str = liveImageModel.url;
        }
        if ((i10 & 4) != 0) {
            str2 = liveImageModel.bannerId;
        }
        return liveImageModel.copy(imageModel, str, str2);
    }

    @NotNull
    public final ImageModel component1() {
        return this.imageModel;
    }

    @Nullable
    public final String component2() {
        return this.url;
    }

    @Nullable
    public final String component3() {
        return this.bannerId;
    }

    @NotNull
    public final LiveImageModel copy(@NotNull ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        s.i(imageModel, "imageModel");
        return new LiveImageModel(imageModel, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveImageModel)) {
            return false;
        }
        LiveImageModel liveImageModel = (LiveImageModel) obj;
        return s.d(this.imageModel, liveImageModel.imageModel) && s.d(this.url, liveImageModel.url) && s.d(this.bannerId, liveImageModel.bannerId);
    }

    @Nullable
    public final String getBannerId() {
        return this.bannerId;
    }

    @NotNull
    public final ImageModel getImageModel() {
        return this.imageModel;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.imageModel.hashCode() * 31;
        String str = this.url;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bannerId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.imageModel;
        return "LiveImageModel(imageModel=" + ((Object) imageModel) + ", url=" + this.url + ", bannerId=" + this.bannerId + ")";
    }
}
