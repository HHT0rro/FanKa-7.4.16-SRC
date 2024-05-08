package com.cupidapp.live.setting.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AvatarProfileModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AvatarProfileModel implements Serializable {

    @Nullable
    private ImageModel avatarImage;

    @Nullable
    private VideoModel avatarVideo;

    public AvatarProfileModel(@Nullable VideoModel videoModel, @Nullable ImageModel imageModel) {
        this.avatarVideo = videoModel;
        this.avatarImage = imageModel;
    }

    public static /* synthetic */ AvatarProfileModel copy$default(AvatarProfileModel avatarProfileModel, VideoModel videoModel, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            videoModel = avatarProfileModel.avatarVideo;
        }
        if ((i10 & 2) != 0) {
            imageModel = avatarProfileModel.avatarImage;
        }
        return avatarProfileModel.copy(videoModel, imageModel);
    }

    @Nullable
    public final VideoModel component1() {
        return this.avatarVideo;
    }

    @Nullable
    public final ImageModel component2() {
        return this.avatarImage;
    }

    @NotNull
    public final AvatarProfileModel copy(@Nullable VideoModel videoModel, @Nullable ImageModel imageModel) {
        return new AvatarProfileModel(videoModel, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvatarProfileModel)) {
            return false;
        }
        AvatarProfileModel avatarProfileModel = (AvatarProfileModel) obj;
        return s.d(this.avatarVideo, avatarProfileModel.avatarVideo) && s.d(this.avatarImage, avatarProfileModel.avatarImage);
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final VideoModel getAvatarVideo() {
        return this.avatarVideo;
    }

    public int hashCode() {
        VideoModel videoModel = this.avatarVideo;
        int hashCode = (videoModel == null ? 0 : videoModel.hashCode()) * 31;
        ImageModel imageModel = this.avatarImage;
        return hashCode + (imageModel != null ? imageModel.hashCode() : 0);
    }

    public final void setAvatarImage(@Nullable ImageModel imageModel) {
        this.avatarImage = imageModel;
    }

    public final void setAvatarVideo(@Nullable VideoModel videoModel) {
        this.avatarVideo = videoModel;
    }

    @NotNull
    public String toString() {
        return "AvatarProfileModel(avatarVideo=" + ((Object) this.avatarVideo) + ", avatarImage=" + ((Object) this.avatarImage) + ")";
    }
}
