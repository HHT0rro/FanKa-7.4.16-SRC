package com.cupidapp.live.mediapicker.model;

import com.cupidapp.live.base.network.model.VideoModel;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoContentModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UploadVideoModel implements Serializable {

    @Nullable
    private final String localPath;

    @Nullable
    private VideoModel video;

    public UploadVideoModel(@Nullable VideoModel videoModel, @Nullable String str) {
        this.video = videoModel;
        this.localPath = str;
    }

    public static /* synthetic */ UploadVideoModel copy$default(UploadVideoModel uploadVideoModel, VideoModel videoModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            videoModel = uploadVideoModel.video;
        }
        if ((i10 & 2) != 0) {
            str = uploadVideoModel.localPath;
        }
        return uploadVideoModel.copy(videoModel, str);
    }

    @Nullable
    public final VideoModel component1() {
        return this.video;
    }

    @Nullable
    public final String component2() {
        return this.localPath;
    }

    @NotNull
    public final UploadVideoModel copy(@Nullable VideoModel videoModel, @Nullable String str) {
        return new UploadVideoModel(videoModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadVideoModel)) {
            return false;
        }
        UploadVideoModel uploadVideoModel = (UploadVideoModel) obj;
        return s.d(this.video, uploadVideoModel.video) && s.d(this.localPath, uploadVideoModel.localPath);
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    public final VideoModel getVideo() {
        return this.video;
    }

    public int hashCode() {
        VideoModel videoModel = this.video;
        int hashCode = (videoModel == null ? 0 : videoModel.hashCode()) * 31;
        String str = this.localPath;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setVideo(@Nullable VideoModel videoModel) {
        this.video = videoModel;
    }

    @NotNull
    public String toString() {
        VideoModel videoModel = this.video;
        return "UploadVideoModel(video=" + ((Object) videoModel) + ", localPath=" + this.localPath + ")";
    }

    public /* synthetic */ UploadVideoModel(VideoModel videoModel, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : videoModel, str);
    }
}
