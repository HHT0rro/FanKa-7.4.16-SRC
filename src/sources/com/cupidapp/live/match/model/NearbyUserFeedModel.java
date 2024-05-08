package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyUserFeedModel implements Serializable {

    @NotNull
    private final ImageModel image;

    @NotNull
    private final String type;

    @Nullable
    private final VideoModel video;

    public NearbyUserFeedModel(@NotNull String type, @Nullable VideoModel videoModel, @NotNull ImageModel image) {
        s.i(type, "type");
        s.i(image, "image");
        this.type = type;
        this.video = videoModel;
        this.image = image;
    }

    public static /* synthetic */ NearbyUserFeedModel copy$default(NearbyUserFeedModel nearbyUserFeedModel, String str, VideoModel videoModel, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = nearbyUserFeedModel.type;
        }
        if ((i10 & 2) != 0) {
            videoModel = nearbyUserFeedModel.video;
        }
        if ((i10 & 4) != 0) {
            imageModel = nearbyUserFeedModel.image;
        }
        return nearbyUserFeedModel.copy(str, videoModel, imageModel);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final VideoModel component2() {
        return this.video;
    }

    @NotNull
    public final ImageModel component3() {
        return this.image;
    }

    @NotNull
    public final NearbyUserFeedModel copy(@NotNull String type, @Nullable VideoModel videoModel, @NotNull ImageModel image) {
        s.i(type, "type");
        s.i(image, "image");
        return new NearbyUserFeedModel(type, videoModel, image);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyUserFeedModel)) {
            return false;
        }
        NearbyUserFeedModel nearbyUserFeedModel = (NearbyUserFeedModel) obj;
        return s.d(this.type, nearbyUserFeedModel.type) && s.d(this.video, nearbyUserFeedModel.video) && s.d(this.image, nearbyUserFeedModel.image);
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final VideoModel getVideo() {
        return this.video;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        VideoModel videoModel = this.video;
        return ((hashCode + (videoModel == null ? 0 : videoModel.hashCode())) * 31) + this.image.hashCode();
    }

    @NotNull
    public String toString() {
        return "NearbyUserFeedModel(type=" + this.type + ", video=" + ((Object) this.video) + ", image=" + ((Object) this.image) + ")";
    }
}
