package com.cupidapp.live.base.extension;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BitmapExtension.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ImageAttributeModel {
    private final int height;
    private final boolean isVertical;
    private final int orientation;
    private final int width;

    public ImageAttributeModel(int i10, int i11, boolean z10, int i12) {
        this.width = i10;
        this.height = i11;
        this.isVertical = z10;
        this.orientation = i12;
    }

    public static /* synthetic */ ImageAttributeModel copy$default(ImageAttributeModel imageAttributeModel, int i10, int i11, boolean z10, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = imageAttributeModel.width;
        }
        if ((i13 & 2) != 0) {
            i11 = imageAttributeModel.height;
        }
        if ((i13 & 4) != 0) {
            z10 = imageAttributeModel.isVertical;
        }
        if ((i13 & 8) != 0) {
            i12 = imageAttributeModel.orientation;
        }
        return imageAttributeModel.copy(i10, i11, z10, i12);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final boolean component3() {
        return this.isVertical;
    }

    public final int component4() {
        return this.orientation;
    }

    @NotNull
    public final ImageAttributeModel copy(int i10, int i11, boolean z10, int i12) {
        return new ImageAttributeModel(i10, i11, z10, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageAttributeModel)) {
            return false;
        }
        ImageAttributeModel imageAttributeModel = (ImageAttributeModel) obj;
        return this.width == imageAttributeModel.width && this.height == imageAttributeModel.height && this.isVertical == imageAttributeModel.isVertical && this.orientation == imageAttributeModel.orientation;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i10 = ((this.width * 31) + this.height) * 31;
        boolean z10 = this.isVertical;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        return ((i10 + i11) * 31) + this.orientation;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    @NotNull
    public String toString() {
        return "ImageAttributeModel(width=" + this.width + ", height=" + this.height + ", isVertical=" + this.isVertical + ", orientation=" + this.orientation + ")";
    }
}
