package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedImageInfoModel implements Serializable {

    @NotNull
    private final ImageModel image;

    public FeedImageInfoModel(@NotNull ImageModel image) {
        s.i(image, "image");
        this.image = image;
    }

    public static /* synthetic */ FeedImageInfoModel copy$default(FeedImageInfoModel feedImageInfoModel, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = feedImageInfoModel.image;
        }
        return feedImageInfoModel.copy(imageModel);
    }

    @NotNull
    public final ImageModel component1() {
        return this.image;
    }

    @NotNull
    public final FeedImageInfoModel copy(@NotNull ImageModel image) {
        s.i(image, "image");
        return new FeedImageInfoModel(image);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedImageInfoModel) && s.d(this.image, ((FeedImageInfoModel) obj).image);
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    public int hashCode() {
        return this.image.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedImageInfoModel(image=" + ((Object) this.image) + ")";
    }
}
