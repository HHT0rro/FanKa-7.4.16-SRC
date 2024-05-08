package com.cupidapp.live.maskparty.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyRecommendModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyRecommendUserModel {

    @NotNull
    private final ImageModel avatar;

    @NotNull
    private final String basicInfo;

    @NotNull
    private final String buttonDesc;

    @NotNull
    private final String commonHobby;
    private final int countDownSeconds;
    private final boolean match;

    @NotNull
    private final String title;
    private final int type;

    public MaskPartyRecommendUserModel(int i10, @NotNull String title, @NotNull ImageModel avatar, @NotNull String basicInfo, @NotNull String commonHobby, int i11, boolean z10, @NotNull String buttonDesc) {
        s.i(title, "title");
        s.i(avatar, "avatar");
        s.i(basicInfo, "basicInfo");
        s.i(commonHobby, "commonHobby");
        s.i(buttonDesc, "buttonDesc");
        this.type = i10;
        this.title = title;
        this.avatar = avatar;
        this.basicInfo = basicInfo;
        this.commonHobby = commonHobby;
        this.countDownSeconds = i11;
        this.match = z10;
        this.buttonDesc = buttonDesc;
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final ImageModel component3() {
        return this.avatar;
    }

    @NotNull
    public final String component4() {
        return this.basicInfo;
    }

    @NotNull
    public final String component5() {
        return this.commonHobby;
    }

    public final int component6() {
        return this.countDownSeconds;
    }

    public final boolean component7() {
        return this.match;
    }

    @NotNull
    public final String component8() {
        return this.buttonDesc;
    }

    @NotNull
    public final MaskPartyRecommendUserModel copy(int i10, @NotNull String title, @NotNull ImageModel avatar, @NotNull String basicInfo, @NotNull String commonHobby, int i11, boolean z10, @NotNull String buttonDesc) {
        s.i(title, "title");
        s.i(avatar, "avatar");
        s.i(basicInfo, "basicInfo");
        s.i(commonHobby, "commonHobby");
        s.i(buttonDesc, "buttonDesc");
        return new MaskPartyRecommendUserModel(i10, title, avatar, basicInfo, commonHobby, i11, z10, buttonDesc);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyRecommendUserModel)) {
            return false;
        }
        MaskPartyRecommendUserModel maskPartyRecommendUserModel = (MaskPartyRecommendUserModel) obj;
        return this.type == maskPartyRecommendUserModel.type && s.d(this.title, maskPartyRecommendUserModel.title) && s.d(this.avatar, maskPartyRecommendUserModel.avatar) && s.d(this.basicInfo, maskPartyRecommendUserModel.basicInfo) && s.d(this.commonHobby, maskPartyRecommendUserModel.commonHobby) && this.countDownSeconds == maskPartyRecommendUserModel.countDownSeconds && this.match == maskPartyRecommendUserModel.match && s.d(this.buttonDesc, maskPartyRecommendUserModel.buttonDesc);
    }

    @NotNull
    public final ImageModel getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getBasicInfo() {
        return this.basicInfo;
    }

    @NotNull
    public final String getButtonDesc() {
        return this.buttonDesc;
    }

    @NotNull
    public final String getCommonHobby() {
        return this.commonHobby;
    }

    public final int getCountDownSeconds() {
        return this.countDownSeconds;
    }

    public final boolean getMatch() {
        return this.match;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.type * 31) + this.title.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.basicInfo.hashCode()) * 31) + this.commonHobby.hashCode()) * 31) + this.countDownSeconds) * 31;
        boolean z10 = this.match;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return ((hashCode + i10) * 31) + this.buttonDesc.hashCode();
    }

    @NotNull
    public String toString() {
        int i10 = this.type;
        String str = this.title;
        ImageModel imageModel = this.avatar;
        return "MaskPartyRecommendUserModel(type=" + i10 + ", title=" + str + ", avatar=" + ((Object) imageModel) + ", basicInfo=" + this.basicInfo + ", commonHobby=" + this.commonHobby + ", countDownSeconds=" + this.countDownSeconds + ", match=" + this.match + ", buttonDesc=" + this.buttonDesc + ")";
    }
}
