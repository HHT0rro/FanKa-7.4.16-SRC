package com.cupidapp.live.mediapicker.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoContentModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoContentModel extends MediaContentModel {

    @Nullable
    private UploadImageModel coverImage;

    @Nullable
    private UploadImageModel firstFrameImage;
    private int height;

    @NotNull
    private UploadVideoModel uploadVideo;
    private int width;

    public /* synthetic */ VideoContentModel(UploadVideoModel uploadVideoModel, UploadImageModel uploadImageModel, UploadImageModel uploadImageModel2, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(uploadVideoModel, (i12 & 2) != 0 ? null : uploadImageModel, (i12 & 4) != 0 ? null : uploadImageModel2, (i12 & 8) != 0 ? 0 : i10, (i12 & 16) != 0 ? 0 : i11);
    }

    public static /* synthetic */ VideoContentModel copy$default(VideoContentModel videoContentModel, UploadVideoModel uploadVideoModel, UploadImageModel uploadImageModel, UploadImageModel uploadImageModel2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            uploadVideoModel = videoContentModel.uploadVideo;
        }
        if ((i12 & 2) != 0) {
            uploadImageModel = videoContentModel.firstFrameImage;
        }
        UploadImageModel uploadImageModel3 = uploadImageModel;
        if ((i12 & 4) != 0) {
            uploadImageModel2 = videoContentModel.coverImage;
        }
        UploadImageModel uploadImageModel4 = uploadImageModel2;
        if ((i12 & 8) != 0) {
            i10 = videoContentModel.width;
        }
        int i13 = i10;
        if ((i12 & 16) != 0) {
            i11 = videoContentModel.height;
        }
        return videoContentModel.copy(uploadVideoModel, uploadImageModel3, uploadImageModel4, i13, i11);
    }

    @NotNull
    public final UploadVideoModel component1() {
        return this.uploadVideo;
    }

    @Nullable
    public final UploadImageModel component2() {
        return this.firstFrameImage;
    }

    @Nullable
    public final UploadImageModel component3() {
        return this.coverImage;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    @NotNull
    public final VideoContentModel copy(@NotNull UploadVideoModel uploadVideo, @Nullable UploadImageModel uploadImageModel, @Nullable UploadImageModel uploadImageModel2, int i10, int i11) {
        s.i(uploadVideo, "uploadVideo");
        return new VideoContentModel(uploadVideo, uploadImageModel, uploadImageModel2, i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoContentModel)) {
            return false;
        }
        VideoContentModel videoContentModel = (VideoContentModel) obj;
        return s.d(this.uploadVideo, videoContentModel.uploadVideo) && s.d(this.firstFrameImage, videoContentModel.firstFrameImage) && s.d(this.coverImage, videoContentModel.coverImage) && this.width == videoContentModel.width && this.height == videoContentModel.height;
    }

    @Nullable
    public final UploadImageModel getCoverImage() {
        return this.coverImage;
    }

    @Nullable
    public final UploadImageModel getFirstFrameImage() {
        return this.firstFrameImage;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final UploadVideoModel getUploadVideo() {
        return this.uploadVideo;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode = this.uploadVideo.hashCode() * 31;
        UploadImageModel uploadImageModel = this.firstFrameImage;
        int hashCode2 = (hashCode + (uploadImageModel == null ? 0 : uploadImageModel.hashCode())) * 31;
        UploadImageModel uploadImageModel2 = this.coverImage;
        return ((((hashCode2 + (uploadImageModel2 != null ? uploadImageModel2.hashCode() : 0)) * 31) + this.width) * 31) + this.height;
    }

    public final void setCoverImage(@Nullable UploadImageModel uploadImageModel) {
        this.coverImage = uploadImageModel;
    }

    public final void setFirstFrameImage(@Nullable UploadImageModel uploadImageModel) {
        this.firstFrameImage = uploadImageModel;
    }

    public final void setHeight(int i10) {
        this.height = i10;
    }

    public final void setUploadVideo(@NotNull UploadVideoModel uploadVideoModel) {
        s.i(uploadVideoModel, "<set-?>");
        this.uploadVideo = uploadVideoModel;
    }

    public final void setWidth(int i10) {
        this.width = i10;
    }

    @NotNull
    public String toString() {
        UploadVideoModel uploadVideoModel = this.uploadVideo;
        UploadImageModel uploadImageModel = this.firstFrameImage;
        UploadImageModel uploadImageModel2 = this.coverImage;
        return "VideoContentModel(uploadVideo=" + ((Object) uploadVideoModel) + ", firstFrameImage=" + ((Object) uploadImageModel) + ", coverImage=" + ((Object) uploadImageModel2) + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public VideoContentModel(@NotNull UploadVideoModel uploadVideo, @Nullable UploadImageModel uploadImageModel, @Nullable UploadImageModel uploadImageModel2, int i10, int i11) {
        s.i(uploadVideo, "uploadVideo");
        this.uploadVideo = uploadVideo;
        this.firstFrameImage = uploadImageModel;
        this.coverImage = uploadImageModel2;
        this.width = i10;
        this.height = i11;
    }
}
