package com.cupidapp.live.mediapicker.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageContentModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageContentModel extends MediaContentModel {

    @Nullable
    private FrameAspectRatio frameType;

    @NotNull
    private List<String> originImageUriStrings;

    @NotNull
    private List<UploadImageModel> uploadImageList;

    public /* synthetic */ ImageContentModel(List list, FrameAspectRatio frameAspectRatio, List list2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i10 & 2) != 0 ? null : frameAspectRatio, (i10 & 4) != 0 ? new ArrayList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageContentModel copy$default(ImageContentModel imageContentModel, List list, FrameAspectRatio frameAspectRatio, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = imageContentModel.uploadImageList;
        }
        if ((i10 & 2) != 0) {
            frameAspectRatio = imageContentModel.frameType;
        }
        if ((i10 & 4) != 0) {
            list2 = imageContentModel.originImageUriStrings;
        }
        return imageContentModel.copy(list, frameAspectRatio, list2);
    }

    @NotNull
    public final List<UploadImageModel> component1() {
        return this.uploadImageList;
    }

    @Nullable
    public final FrameAspectRatio component2() {
        return this.frameType;
    }

    @NotNull
    public final List<String> component3() {
        return this.originImageUriStrings;
    }

    @NotNull
    public final ImageContentModel copy(@NotNull List<UploadImageModel> uploadImageList, @Nullable FrameAspectRatio frameAspectRatio, @NotNull List<String> originImageUriStrings) {
        s.i(uploadImageList, "uploadImageList");
        s.i(originImageUriStrings, "originImageUriStrings");
        return new ImageContentModel(uploadImageList, frameAspectRatio, originImageUriStrings);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageContentModel)) {
            return false;
        }
        ImageContentModel imageContentModel = (ImageContentModel) obj;
        return s.d(this.uploadImageList, imageContentModel.uploadImageList) && this.frameType == imageContentModel.frameType && s.d(this.originImageUriStrings, imageContentModel.originImageUriStrings);
    }

    @Nullable
    public final FrameAspectRatio getFrameType() {
        return this.frameType;
    }

    @NotNull
    public final List<String> getOriginImageUriStrings() {
        return this.originImageUriStrings;
    }

    @NotNull
    public final List<UploadImageModel> getUploadImageList() {
        return this.uploadImageList;
    }

    public int hashCode() {
        int hashCode = this.uploadImageList.hashCode() * 31;
        FrameAspectRatio frameAspectRatio = this.frameType;
        return ((hashCode + (frameAspectRatio == null ? 0 : frameAspectRatio.hashCode())) * 31) + this.originImageUriStrings.hashCode();
    }

    public final void setFrameType(@Nullable FrameAspectRatio frameAspectRatio) {
        this.frameType = frameAspectRatio;
    }

    public final void setOriginImageUriStrings(@NotNull List<String> list) {
        s.i(list, "<set-?>");
        this.originImageUriStrings = list;
    }

    public final void setUploadImageList(@NotNull List<UploadImageModel> list) {
        s.i(list, "<set-?>");
        this.uploadImageList = list;
    }

    @NotNull
    public String toString() {
        return "ImageContentModel(uploadImageList=" + ((Object) this.uploadImageList) + ", frameType=" + ((Object) this.frameType) + ", originImageUriStrings=" + ((Object) this.originImageUriStrings) + ")";
    }

    public ImageContentModel(@NotNull List<UploadImageModel> uploadImageList, @Nullable FrameAspectRatio frameAspectRatio, @NotNull List<String> originImageUriStrings) {
        s.i(uploadImageList, "uploadImageList");
        s.i(originImageUriStrings, "originImageUriStrings");
        this.uploadImageList = uploadImageList;
        this.frameType = frameAspectRatio;
        this.originImageUriStrings = originImageUriStrings;
    }
}
