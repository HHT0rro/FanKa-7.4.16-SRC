package com.cupidapp.live.mediapicker.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoContentModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UploadImageModel implements Serializable {

    @Nullable
    private Boolean hasFace;

    @Nullable
    private ImageModel image;

    @Nullable
    private final String localPath;

    public UploadImageModel(@Nullable ImageModel imageModel, @Nullable String str, @Nullable Boolean bool) {
        this.image = imageModel;
        this.localPath = str;
        this.hasFace = bool;
    }

    public static /* synthetic */ UploadImageModel copy$default(UploadImageModel uploadImageModel, ImageModel imageModel, String str, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = uploadImageModel.image;
        }
        if ((i10 & 2) != 0) {
            str = uploadImageModel.localPath;
        }
        if ((i10 & 4) != 0) {
            bool = uploadImageModel.hasFace;
        }
        return uploadImageModel.copy(imageModel, str, bool);
    }

    @Nullable
    public final ImageModel component1() {
        return this.image;
    }

    @Nullable
    public final String component2() {
        return this.localPath;
    }

    @Nullable
    public final Boolean component3() {
        return this.hasFace;
    }

    @NotNull
    public final UploadImageModel copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable Boolean bool) {
        return new UploadImageModel(imageModel, str, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadImageModel)) {
            return false;
        }
        UploadImageModel uploadImageModel = (UploadImageModel) obj;
        return s.d(this.image, uploadImageModel.image) && s.d(this.localPath, uploadImageModel.localPath) && s.d(this.hasFace, uploadImageModel.hasFace);
    }

    @Nullable
    public final Boolean getHasFace() {
        return this.hasFace;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    public int hashCode() {
        ImageModel imageModel = this.image;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.localPath;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.hasFace;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setHasFace(@Nullable Boolean bool) {
        this.hasFace = bool;
    }

    public final void setImage(@Nullable ImageModel imageModel) {
        this.image = imageModel;
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.image;
        return "UploadImageModel(image=" + ((Object) imageModel) + ", localPath=" + this.localPath + ", hasFace=" + ((Object) this.hasFace) + ")";
    }

    public /* synthetic */ UploadImageModel(ImageModel imageModel, String str, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : imageModel, str, (i10 & 4) != 0 ? null : bool);
    }
}
