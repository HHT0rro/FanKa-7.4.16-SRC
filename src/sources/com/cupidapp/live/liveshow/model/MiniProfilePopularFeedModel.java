package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMiniProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MiniProfilePopularFeedModel implements Serializable {

    @Nullable
    private final String description;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String type;

    @Nullable
    private final VideoModel video;

    public MiniProfilePopularFeedModel(@Nullable String str, @Nullable String str2, @Nullable VideoModel videoModel, @Nullable ImageModel imageModel) {
        this.type = str;
        this.description = str2;
        this.video = videoModel;
        this.image = imageModel;
    }

    public static /* synthetic */ MiniProfilePopularFeedModel copy$default(MiniProfilePopularFeedModel miniProfilePopularFeedModel, String str, String str2, VideoModel videoModel, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = miniProfilePopularFeedModel.type;
        }
        if ((i10 & 2) != 0) {
            str2 = miniProfilePopularFeedModel.description;
        }
        if ((i10 & 4) != 0) {
            videoModel = miniProfilePopularFeedModel.video;
        }
        if ((i10 & 8) != 0) {
            imageModel = miniProfilePopularFeedModel.image;
        }
        return miniProfilePopularFeedModel.copy(str, str2, videoModel, imageModel);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final VideoModel component3() {
        return this.video;
    }

    @Nullable
    public final ImageModel component4() {
        return this.image;
    }

    @NotNull
    public final MiniProfilePopularFeedModel copy(@Nullable String str, @Nullable String str2, @Nullable VideoModel videoModel, @Nullable ImageModel imageModel) {
        return new MiniProfilePopularFeedModel(str, str2, videoModel, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniProfilePopularFeedModel)) {
            return false;
        }
        MiniProfilePopularFeedModel miniProfilePopularFeedModel = (MiniProfilePopularFeedModel) obj;
        return s.d(this.type, miniProfilePopularFeedModel.type) && s.d(this.description, miniProfilePopularFeedModel.description) && s.d(this.video, miniProfilePopularFeedModel.video) && s.d(this.image, miniProfilePopularFeedModel.image);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final VideoModel getVideo() {
        return this.video;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        VideoModel videoModel = this.video;
        int hashCode3 = (hashCode2 + (videoModel == null ? 0 : videoModel.hashCode())) * 31;
        ImageModel imageModel = this.image;
        return hashCode3 + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MiniProfilePopularFeedModel(type=" + this.type + ", description=" + this.description + ", video=" + ((Object) this.video) + ", image=" + ((Object) this.image) + ")";
    }

    public /* synthetic */ MiniProfilePopularFeedModel(String str, String str2, VideoModel videoModel, ImageModel imageModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, videoModel, imageModel);
    }
}
