package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserTagModel implements Serializable {

    @Nullable
    private final ImageModel image;

    @NotNull
    private final String name;

    public UserTagModel(@NotNull String name, @Nullable ImageModel imageModel) {
        s.i(name, "name");
        this.name = name;
        this.image = imageModel;
    }

    public static /* synthetic */ UserTagModel copy$default(UserTagModel userTagModel, String str, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = userTagModel.name;
        }
        if ((i10 & 2) != 0) {
            imageModel = userTagModel.image;
        }
        return userTagModel.copy(str, imageModel);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final ImageModel component2() {
        return this.image;
    }

    @NotNull
    public final UserTagModel copy(@NotNull String name, @Nullable ImageModel imageModel) {
        s.i(name, "name");
        return new UserTagModel(name, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserTagModel)) {
            return false;
        }
        UserTagModel userTagModel = (UserTagModel) obj;
        return s.d(this.name, userTagModel.name) && s.d(this.image, userTagModel.image);
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        ImageModel imageModel = this.image;
        return hashCode + (imageModel == null ? 0 : imageModel.hashCode());
    }

    @NotNull
    public String toString() {
        return "UserTagModel(name=" + this.name + ", image=" + ((Object) this.image) + ")";
    }
}
