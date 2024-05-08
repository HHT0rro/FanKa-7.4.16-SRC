package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BigPictureModel {

    @Nullable
    private final String bannerId;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final LiveShowModel liveShow;
    private final boolean stream;

    @Nullable
    private final String url;

    public BigPictureModel(@Nullable String str, boolean z10, @Nullable ImageModel imageModel, @Nullable LiveShowModel liveShowModel, @Nullable String str2) {
        this.url = str;
        this.stream = z10;
        this.image = imageModel;
        this.liveShow = liveShowModel;
        this.bannerId = str2;
    }

    public static /* synthetic */ BigPictureModel copy$default(BigPictureModel bigPictureModel, String str, boolean z10, ImageModel imageModel, LiveShowModel liveShowModel, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bigPictureModel.url;
        }
        if ((i10 & 2) != 0) {
            z10 = bigPictureModel.stream;
        }
        boolean z11 = z10;
        if ((i10 & 4) != 0) {
            imageModel = bigPictureModel.image;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 8) != 0) {
            liveShowModel = bigPictureModel.liveShow;
        }
        LiveShowModel liveShowModel2 = liveShowModel;
        if ((i10 & 16) != 0) {
            str2 = bigPictureModel.bannerId;
        }
        return bigPictureModel.copy(str, z11, imageModel2, liveShowModel2, str2);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    public final boolean component2() {
        return this.stream;
    }

    @Nullable
    public final ImageModel component3() {
        return this.image;
    }

    @Nullable
    public final LiveShowModel component4() {
        return this.liveShow;
    }

    @Nullable
    public final String component5() {
        return this.bannerId;
    }

    @NotNull
    public final BigPictureModel copy(@Nullable String str, boolean z10, @Nullable ImageModel imageModel, @Nullable LiveShowModel liveShowModel, @Nullable String str2) {
        return new BigPictureModel(str, z10, imageModel, liveShowModel, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BigPictureModel)) {
            return false;
        }
        BigPictureModel bigPictureModel = (BigPictureModel) obj;
        return s.d(this.url, bigPictureModel.url) && this.stream == bigPictureModel.stream && s.d(this.image, bigPictureModel.image) && s.d(this.liveShow, bigPictureModel.liveShow) && s.d(this.bannerId, bigPictureModel.bannerId);
    }

    @Nullable
    public final String getBannerId() {
        return this.bannerId;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    public final boolean getStream() {
        return this.stream;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z10 = this.stream;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        ImageModel imageModel = this.image;
        int hashCode2 = (i11 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        LiveShowModel liveShowModel = this.liveShow;
        int hashCode3 = (hashCode2 + (liveShowModel == null ? 0 : liveShowModel.hashCode())) * 31;
        String str2 = this.bannerId;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.url;
        boolean z10 = this.stream;
        ImageModel imageModel = this.image;
        LiveShowModel liveShowModel = this.liveShow;
        return "BigPictureModel(url=" + str + ", stream=" + z10 + ", image=" + ((Object) imageModel) + ", liveShow=" + ((Object) liveShowModel) + ", bannerId=" + this.bannerId + ")";
    }
}
