package com.cupidapp.live.mediapicker.model;

import android.graphics.RectF;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoAttributeViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageAttributeViewModel implements Serializable {

    @Nullable
    private RectF afterTrimImageBoundRectF;

    @Nullable
    private String afterTrimOriginalImagePath;

    @NotNull
    private final String compressedImagePath;

    @NotNull
    private FrameAspectRatio frameType;

    @NotNull
    private String imageViewPath;

    @NotNull
    private final String originalImageUriString;

    @NotNull
    private String uploadImagePath;

    public ImageAttributeViewModel(@NotNull String originalImageUriString, @NotNull String compressedImagePath, @NotNull String imageViewPath, @Nullable String str, @NotNull String uploadImagePath, @NotNull FrameAspectRatio frameType, @Nullable RectF rectF) {
        s.i(originalImageUriString, "originalImageUriString");
        s.i(compressedImagePath, "compressedImagePath");
        s.i(imageViewPath, "imageViewPath");
        s.i(uploadImagePath, "uploadImagePath");
        s.i(frameType, "frameType");
        this.originalImageUriString = originalImageUriString;
        this.compressedImagePath = compressedImagePath;
        this.imageViewPath = imageViewPath;
        this.afterTrimOriginalImagePath = str;
        this.uploadImagePath = uploadImagePath;
        this.frameType = frameType;
        this.afterTrimImageBoundRectF = rectF;
    }

    public static /* synthetic */ ImageAttributeViewModel copy$default(ImageAttributeViewModel imageAttributeViewModel, String str, String str2, String str3, String str4, String str5, FrameAspectRatio frameAspectRatio, RectF rectF, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = imageAttributeViewModel.originalImageUriString;
        }
        if ((i10 & 2) != 0) {
            str2 = imageAttributeViewModel.compressedImagePath;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = imageAttributeViewModel.imageViewPath;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = imageAttributeViewModel.afterTrimOriginalImagePath;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = imageAttributeViewModel.uploadImagePath;
        }
        String str9 = str5;
        if ((i10 & 32) != 0) {
            frameAspectRatio = imageAttributeViewModel.frameType;
        }
        FrameAspectRatio frameAspectRatio2 = frameAspectRatio;
        if ((i10 & 64) != 0) {
            rectF = imageAttributeViewModel.afterTrimImageBoundRectF;
        }
        return imageAttributeViewModel.copy(str, str6, str7, str8, str9, frameAspectRatio2, rectF);
    }

    @NotNull
    public final String component1() {
        return this.originalImageUriString;
    }

    @NotNull
    public final String component2() {
        return this.compressedImagePath;
    }

    @NotNull
    public final String component3() {
        return this.imageViewPath;
    }

    @Nullable
    public final String component4() {
        return this.afterTrimOriginalImagePath;
    }

    @NotNull
    public final String component5() {
        return this.uploadImagePath;
    }

    @NotNull
    public final FrameAspectRatio component6() {
        return this.frameType;
    }

    @Nullable
    public final RectF component7() {
        return this.afterTrimImageBoundRectF;
    }

    @NotNull
    public final ImageAttributeViewModel copy(@NotNull String originalImageUriString, @NotNull String compressedImagePath, @NotNull String imageViewPath, @Nullable String str, @NotNull String uploadImagePath, @NotNull FrameAspectRatio frameType, @Nullable RectF rectF) {
        s.i(originalImageUriString, "originalImageUriString");
        s.i(compressedImagePath, "compressedImagePath");
        s.i(imageViewPath, "imageViewPath");
        s.i(uploadImagePath, "uploadImagePath");
        s.i(frameType, "frameType");
        return new ImageAttributeViewModel(originalImageUriString, compressedImagePath, imageViewPath, str, uploadImagePath, frameType, rectF);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageAttributeViewModel)) {
            return false;
        }
        ImageAttributeViewModel imageAttributeViewModel = (ImageAttributeViewModel) obj;
        return s.d(this.originalImageUriString, imageAttributeViewModel.originalImageUriString) && s.d(this.compressedImagePath, imageAttributeViewModel.compressedImagePath) && s.d(this.imageViewPath, imageAttributeViewModel.imageViewPath) && s.d(this.afterTrimOriginalImagePath, imageAttributeViewModel.afterTrimOriginalImagePath) && s.d(this.uploadImagePath, imageAttributeViewModel.uploadImagePath) && this.frameType == imageAttributeViewModel.frameType && s.d(this.afterTrimImageBoundRectF, imageAttributeViewModel.afterTrimImageBoundRectF);
    }

    @Nullable
    public final RectF getAfterTrimImageBoundRectF() {
        return this.afterTrimImageBoundRectF;
    }

    @Nullable
    public final String getAfterTrimOriginalImagePath() {
        return this.afterTrimOriginalImagePath;
    }

    @NotNull
    public final String getCompressedImagePath() {
        return this.compressedImagePath;
    }

    @NotNull
    public final FrameAspectRatio getFrameType() {
        return this.frameType;
    }

    @NotNull
    public final String getImageViewPath() {
        return this.imageViewPath;
    }

    @NotNull
    public final String getOriginalImageUriString() {
        return this.originalImageUriString;
    }

    @NotNull
    public final String getUploadImagePath() {
        return this.uploadImagePath;
    }

    public int hashCode() {
        int hashCode = ((((this.originalImageUriString.hashCode() * 31) + this.compressedImagePath.hashCode()) * 31) + this.imageViewPath.hashCode()) * 31;
        String str = this.afterTrimOriginalImagePath;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.uploadImagePath.hashCode()) * 31) + this.frameType.hashCode()) * 31;
        RectF rectF = this.afterTrimImageBoundRectF;
        return hashCode2 + (rectF != null ? rectF.hashCode() : 0);
    }

    public final void setAfterTrimImageBoundRectF(@Nullable RectF rectF) {
        this.afterTrimImageBoundRectF = rectF;
    }

    public final void setAfterTrimOriginalImagePath(@Nullable String str) {
        this.afterTrimOriginalImagePath = str;
    }

    public final void setFrameType(@NotNull FrameAspectRatio frameAspectRatio) {
        s.i(frameAspectRatio, "<set-?>");
        this.frameType = frameAspectRatio;
    }

    public final void setImageViewPath(@NotNull String str) {
        s.i(str, "<set-?>");
        this.imageViewPath = str;
    }

    public final void setUploadImagePath(@NotNull String str) {
        s.i(str, "<set-?>");
        this.uploadImagePath = str;
    }

    @NotNull
    public String toString() {
        return "ImageAttributeViewModel(originalImageUriString=" + this.originalImageUriString + ", compressedImagePath=" + this.compressedImagePath + ", imageViewPath=" + this.imageViewPath + ", afterTrimOriginalImagePath=" + this.afterTrimOriginalImagePath + ", uploadImagePath=" + this.uploadImagePath + ", frameType=" + ((Object) this.frameType) + ", afterTrimImageBoundRectF=" + ((Object) this.afterTrimImageBoundRectF) + ")";
    }

    public /* synthetic */ ImageAttributeViewModel(String str, String str2, String str3, String str4, String str5, FrameAspectRatio frameAspectRatio, RectF rectF, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, frameAspectRatio, (i10 & 64) != 0 ? null : rectF);
    }
}
