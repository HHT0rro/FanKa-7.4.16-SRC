package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UploadImageFileResult {

    @NotNull
    private final ImageModel image;

    public UploadImageFileResult(@NotNull ImageModel image) {
        s.i(image, "image");
        this.image = image;
    }

    public static /* synthetic */ UploadImageFileResult copy$default(UploadImageFileResult uploadImageFileResult, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = uploadImageFileResult.image;
        }
        return uploadImageFileResult.copy(imageModel);
    }

    @NotNull
    public final ImageModel component1() {
        return this.image;
    }

    @NotNull
    public final UploadImageFileResult copy(@NotNull ImageModel image) {
        s.i(image, "image");
        return new UploadImageFileResult(image);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UploadImageFileResult) && s.d(this.image, ((UploadImageFileResult) obj).image);
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    public int hashCode() {
        return this.image.hashCode();
    }

    @NotNull
    public String toString() {
        return "UploadImageFileResult(image=" + ((Object) this.image) + ")";
    }
}
