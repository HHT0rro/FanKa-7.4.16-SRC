package com.cupidapp.live.setting.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGameModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfilePasterAdModel {

    @NotNull
    private final ImageModel pasterImage;

    public ProfilePasterAdModel(@NotNull ImageModel pasterImage) {
        s.i(pasterImage, "pasterImage");
        this.pasterImage = pasterImage;
    }

    public static /* synthetic */ ProfilePasterAdModel copy$default(ProfilePasterAdModel profilePasterAdModel, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = profilePasterAdModel.pasterImage;
        }
        return profilePasterAdModel.copy(imageModel);
    }

    @NotNull
    public final ImageModel component1() {
        return this.pasterImage;
    }

    @NotNull
    public final ProfilePasterAdModel copy(@NotNull ImageModel pasterImage) {
        s.i(pasterImage, "pasterImage");
        return new ProfilePasterAdModel(pasterImage);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProfilePasterAdModel) && s.d(this.pasterImage, ((ProfilePasterAdModel) obj).pasterImage);
    }

    @NotNull
    public final ImageModel getPasterImage() {
        return this.pasterImage;
    }

    public int hashCode() {
        return this.pasterImage.hashCode();
    }

    @NotNull
    public String toString() {
        return "ProfilePasterAdModel(pasterImage=" + ((Object) this.pasterImage) + ")";
    }
}
