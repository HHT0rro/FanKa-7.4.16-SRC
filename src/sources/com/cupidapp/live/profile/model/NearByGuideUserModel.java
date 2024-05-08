package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByGuideModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByGuideUserModel implements Serializable {

    @NotNull
    private final ImageModel avatarImage;

    @Nullable
    private final String distanceDes;

    public NearByGuideUserModel(@Nullable String str, @NotNull ImageModel avatarImage) {
        s.i(avatarImage, "avatarImage");
        this.distanceDes = str;
        this.avatarImage = avatarImage;
    }

    public static /* synthetic */ NearByGuideUserModel copy$default(NearByGuideUserModel nearByGuideUserModel, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = nearByGuideUserModel.distanceDes;
        }
        if ((i10 & 2) != 0) {
            imageModel = nearByGuideUserModel.avatarImage;
        }
        return nearByGuideUserModel.copy(str, imageModel);
    }

    @Nullable
    public final String component1() {
        return this.distanceDes;
    }

    @NotNull
    public final ImageModel component2() {
        return this.avatarImage;
    }

    @NotNull
    public final NearByGuideUserModel copy(@Nullable String str, @NotNull ImageModel avatarImage) {
        s.i(avatarImage, "avatarImage");
        return new NearByGuideUserModel(str, avatarImage);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearByGuideUserModel)) {
            return false;
        }
        NearByGuideUserModel nearByGuideUserModel = (NearByGuideUserModel) obj;
        return s.d(this.distanceDes, nearByGuideUserModel.distanceDes) && s.d(this.avatarImage, nearByGuideUserModel.avatarImage);
    }

    @NotNull
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final String getDistanceDes() {
        return this.distanceDes;
    }

    public int hashCode() {
        String str = this.distanceDes;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.avatarImage.hashCode();
    }

    @NotNull
    public String toString() {
        return "NearByGuideUserModel(distanceDes=" + this.distanceDes + ", avatarImage=" + ((Object) this.avatarImage) + ")";
    }
}
