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
public final class ProfileMBTIModel implements Serializable {

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String subtitle;

    @Nullable
    private final String title;

    public ProfileMBTIModel(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.icon = imageModel;
        this.title = str;
        this.subtitle = str2;
        this.jumpUrl = str3;
    }

    public static /* synthetic */ ProfileMBTIModel copy$default(ProfileMBTIModel profileMBTIModel, ImageModel imageModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = profileMBTIModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = profileMBTIModel.title;
        }
        if ((i10 & 4) != 0) {
            str2 = profileMBTIModel.subtitle;
        }
        if ((i10 & 8) != 0) {
            str3 = profileMBTIModel.jumpUrl;
        }
        return profileMBTIModel.copy(imageModel, str, str2, str3);
    }

    @Nullable
    public final ImageModel component1() {
        return this.icon;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subtitle;
    }

    @Nullable
    public final String component4() {
        return this.jumpUrl;
    }

    @NotNull
    public final ProfileMBTIModel copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new ProfileMBTIModel(imageModel, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileMBTIModel)) {
            return false;
        }
        ProfileMBTIModel profileMBTIModel = (ProfileMBTIModel) obj;
        return s.d(this.icon, profileMBTIModel.icon) && s.d(this.title, profileMBTIModel.title) && s.d(this.subtitle, profileMBTIModel.subtitle) && s.d(this.jumpUrl, profileMBTIModel.jumpUrl);
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        ImageModel imageModel = this.icon;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subtitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.jumpUrl;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "ProfileMBTIModel(icon=" + ((Object) imageModel) + ", title=" + this.title + ", subtitle=" + this.subtitle + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
