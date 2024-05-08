package com.cupidapp.live.mediapicker.model;

import android.graphics.RectF;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageTrimModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageTrimModel implements Serializable {

    @Nullable
    private final RectF afterTrimImageBoundRectF;
    private final float aspectRatio;

    @NotNull
    private final String compressedImagePath;

    @NotNull
    private final String imageViewPath;

    public ImageTrimModel(@NotNull String compressedImagePath, @NotNull String imageViewPath, float f10, @Nullable RectF rectF) {
        s.i(compressedImagePath, "compressedImagePath");
        s.i(imageViewPath, "imageViewPath");
        this.compressedImagePath = compressedImagePath;
        this.imageViewPath = imageViewPath;
        this.aspectRatio = f10;
        this.afterTrimImageBoundRectF = rectF;
    }

    public static /* synthetic */ ImageTrimModel copy$default(ImageTrimModel imageTrimModel, String str, String str2, float f10, RectF rectF, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = imageTrimModel.compressedImagePath;
        }
        if ((i10 & 2) != 0) {
            str2 = imageTrimModel.imageViewPath;
        }
        if ((i10 & 4) != 0) {
            f10 = imageTrimModel.aspectRatio;
        }
        if ((i10 & 8) != 0) {
            rectF = imageTrimModel.afterTrimImageBoundRectF;
        }
        return imageTrimModel.copy(str, str2, f10, rectF);
    }

    @NotNull
    public final String component1() {
        return this.compressedImagePath;
    }

    @NotNull
    public final String component2() {
        return this.imageViewPath;
    }

    public final float component3() {
        return this.aspectRatio;
    }

    @Nullable
    public final RectF component4() {
        return this.afterTrimImageBoundRectF;
    }

    @NotNull
    public final ImageTrimModel copy(@NotNull String compressedImagePath, @NotNull String imageViewPath, float f10, @Nullable RectF rectF) {
        s.i(compressedImagePath, "compressedImagePath");
        s.i(imageViewPath, "imageViewPath");
        return new ImageTrimModel(compressedImagePath, imageViewPath, f10, rectF);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageTrimModel)) {
            return false;
        }
        ImageTrimModel imageTrimModel = (ImageTrimModel) obj;
        return s.d(this.compressedImagePath, imageTrimModel.compressedImagePath) && s.d(this.imageViewPath, imageTrimModel.imageViewPath) && Float.compare(this.aspectRatio, imageTrimModel.aspectRatio) == 0 && s.d(this.afterTrimImageBoundRectF, imageTrimModel.afterTrimImageBoundRectF);
    }

    @Nullable
    public final RectF getAfterTrimImageBoundRectF() {
        return this.afterTrimImageBoundRectF;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    @NotNull
    public final String getCompressedImagePath() {
        return this.compressedImagePath;
    }

    @NotNull
    public final String getImageViewPath() {
        return this.imageViewPath;
    }

    public int hashCode() {
        int hashCode = ((((this.compressedImagePath.hashCode() * 31) + this.imageViewPath.hashCode()) * 31) + Float.floatToIntBits(this.aspectRatio)) * 31;
        RectF rectF = this.afterTrimImageBoundRectF;
        return hashCode + (rectF == null ? 0 : rectF.hashCode());
    }

    @NotNull
    public String toString() {
        return "ImageTrimModel(compressedImagePath=" + this.compressedImagePath + ", imageViewPath=" + this.imageViewPath + ", aspectRatio=" + this.aspectRatio + ", afterTrimImageBoundRectF=" + ((Object) this.afterTrimImageBoundRectF) + ")";
    }

    public /* synthetic */ ImageTrimModel(String str, String str2, float f10, RectF rectF, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, f10, (i10 & 8) != 0 ? null : rectF);
    }
}
