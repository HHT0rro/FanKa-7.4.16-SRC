package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostBoostModel implements Serializable {

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String postBoostWebUrl;

    public PostBoostModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public PostBoostModel(@Nullable ImageModel imageModel, @Nullable String str) {
        this.image = imageModel;
        this.postBoostWebUrl = str;
    }

    public static /* synthetic */ PostBoostModel copy$default(PostBoostModel postBoostModel, ImageModel imageModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = postBoostModel.image;
        }
        if ((i10 & 2) != 0) {
            str = postBoostModel.postBoostWebUrl;
        }
        return postBoostModel.copy(imageModel, str);
    }

    @Nullable
    public final ImageModel component1() {
        return this.image;
    }

    @Nullable
    public final String component2() {
        return this.postBoostWebUrl;
    }

    @NotNull
    public final PostBoostModel copy(@Nullable ImageModel imageModel, @Nullable String str) {
        return new PostBoostModel(imageModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostBoostModel)) {
            return false;
        }
        PostBoostModel postBoostModel = (PostBoostModel) obj;
        return s.d(this.image, postBoostModel.image) && s.d(this.postBoostWebUrl, postBoostModel.postBoostWebUrl);
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getPostBoostWebUrl() {
        return this.postBoostWebUrl;
    }

    public int hashCode() {
        ImageModel imageModel = this.image;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.postBoostWebUrl;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.image;
        return "PostBoostModel(image=" + ((Object) imageModel) + ", postBoostWebUrl=" + this.postBoostWebUrl + ")";
    }

    public /* synthetic */ PostBoostModel(ImageModel imageModel, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : imageModel, (i10 & 2) != 0 ? null : str);
    }
}
