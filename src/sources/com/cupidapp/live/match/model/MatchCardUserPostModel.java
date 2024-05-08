package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchCardUserPostModel implements Serializable {

    @NotNull
    private final ImageModel image;

    @NotNull
    private final String postId;

    public MatchCardUserPostModel(@NotNull String postId, @NotNull ImageModel image) {
        s.i(postId, "postId");
        s.i(image, "image");
        this.postId = postId;
        this.image = image;
    }

    public static /* synthetic */ MatchCardUserPostModel copy$default(MatchCardUserPostModel matchCardUserPostModel, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = matchCardUserPostModel.postId;
        }
        if ((i10 & 2) != 0) {
            imageModel = matchCardUserPostModel.image;
        }
        return matchCardUserPostModel.copy(str, imageModel);
    }

    @NotNull
    public final String component1() {
        return this.postId;
    }

    @NotNull
    public final ImageModel component2() {
        return this.image;
    }

    @NotNull
    public final MatchCardUserPostModel copy(@NotNull String postId, @NotNull ImageModel image) {
        s.i(postId, "postId");
        s.i(image, "image");
        return new MatchCardUserPostModel(postId, image);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchCardUserPostModel)) {
            return false;
        }
        MatchCardUserPostModel matchCardUserPostModel = (MatchCardUserPostModel) obj;
        return s.d(this.postId, matchCardUserPostModel.postId) && s.d(this.image, matchCardUserPostModel.image);
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getPostId() {
        return this.postId;
    }

    public int hashCode() {
        return (this.postId.hashCode() * 31) + this.image.hashCode();
    }

    @NotNull
    public String toString() {
        return "MatchCardUserPostModel(postId=" + this.postId + ", image=" + ((Object) this.image) + ")";
    }
}
