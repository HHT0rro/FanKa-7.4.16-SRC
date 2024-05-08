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
public final class MBTIInfoModel implements Serializable {

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String mbti;

    public MBTIInfoModel(@Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2) {
        this.mbti = str;
        this.icon = imageModel;
        this.jumpUrl = str2;
    }

    public static /* synthetic */ MBTIInfoModel copy$default(MBTIInfoModel mBTIInfoModel, String str, ImageModel imageModel, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mBTIInfoModel.mbti;
        }
        if ((i10 & 2) != 0) {
            imageModel = mBTIInfoModel.icon;
        }
        if ((i10 & 4) != 0) {
            str2 = mBTIInfoModel.jumpUrl;
        }
        return mBTIInfoModel.copy(str, imageModel, str2);
    }

    @Nullable
    public final String component1() {
        return this.mbti;
    }

    @Nullable
    public final ImageModel component2() {
        return this.icon;
    }

    @Nullable
    public final String component3() {
        return this.jumpUrl;
    }

    @NotNull
    public final MBTIInfoModel copy(@Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2) {
        return new MBTIInfoModel(str, imageModel, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MBTIInfoModel)) {
            return false;
        }
        MBTIInfoModel mBTIInfoModel = (MBTIInfoModel) obj;
        return s.d(this.mbti, mBTIInfoModel.mbti) && s.d(this.icon, mBTIInfoModel.icon) && s.d(this.jumpUrl, mBTIInfoModel.jumpUrl);
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
    public final String getMbti() {
        return this.mbti;
    }

    public int hashCode() {
        String str = this.mbti;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.icon;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.jumpUrl;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.mbti;
        ImageModel imageModel = this.icon;
        return "MBTIInfoModel(mbti=" + str + ", icon=" + ((Object) imageModel) + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
