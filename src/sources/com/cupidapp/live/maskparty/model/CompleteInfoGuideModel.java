package com.cupidapp.live.maskparty.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyMatchConfigResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CompleteInfoGuideModel {

    @NotNull
    private final ImageModel avatar;

    @NotNull
    private final String buttonText;

    @NotNull
    private final String desc;

    @NotNull
    private final String jumpUrl;
    private final int score;

    @NotNull
    private final String title;

    @NotNull
    private final String username;

    public CompleteInfoGuideModel(@NotNull ImageModel avatar, @NotNull String username, int i10, @NotNull String title, @NotNull String desc, @NotNull String buttonText, @NotNull String jumpUrl) {
        s.i(avatar, "avatar");
        s.i(username, "username");
        s.i(title, "title");
        s.i(desc, "desc");
        s.i(buttonText, "buttonText");
        s.i(jumpUrl, "jumpUrl");
        this.avatar = avatar;
        this.username = username;
        this.score = i10;
        this.title = title;
        this.desc = desc;
        this.buttonText = buttonText;
        this.jumpUrl = jumpUrl;
    }

    public static /* synthetic */ CompleteInfoGuideModel copy$default(CompleteInfoGuideModel completeInfoGuideModel, ImageModel imageModel, String str, int i10, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            imageModel = completeInfoGuideModel.avatar;
        }
        if ((i11 & 2) != 0) {
            str = completeInfoGuideModel.username;
        }
        String str6 = str;
        if ((i11 & 4) != 0) {
            i10 = completeInfoGuideModel.score;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            str2 = completeInfoGuideModel.title;
        }
        String str7 = str2;
        if ((i11 & 16) != 0) {
            str3 = completeInfoGuideModel.desc;
        }
        String str8 = str3;
        if ((i11 & 32) != 0) {
            str4 = completeInfoGuideModel.buttonText;
        }
        String str9 = str4;
        if ((i11 & 64) != 0) {
            str5 = completeInfoGuideModel.jumpUrl;
        }
        return completeInfoGuideModel.copy(imageModel, str6, i12, str7, str8, str9, str5);
    }

    @NotNull
    public final ImageModel component1() {
        return this.avatar;
    }

    @NotNull
    public final String component2() {
        return this.username;
    }

    public final int component3() {
        return this.score;
    }

    @NotNull
    public final String component4() {
        return this.title;
    }

    @NotNull
    public final String component5() {
        return this.desc;
    }

    @NotNull
    public final String component6() {
        return this.buttonText;
    }

    @NotNull
    public final String component7() {
        return this.jumpUrl;
    }

    @NotNull
    public final CompleteInfoGuideModel copy(@NotNull ImageModel avatar, @NotNull String username, int i10, @NotNull String title, @NotNull String desc, @NotNull String buttonText, @NotNull String jumpUrl) {
        s.i(avatar, "avatar");
        s.i(username, "username");
        s.i(title, "title");
        s.i(desc, "desc");
        s.i(buttonText, "buttonText");
        s.i(jumpUrl, "jumpUrl");
        return new CompleteInfoGuideModel(avatar, username, i10, title, desc, buttonText, jumpUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompleteInfoGuideModel)) {
            return false;
        }
        CompleteInfoGuideModel completeInfoGuideModel = (CompleteInfoGuideModel) obj;
        return s.d(this.avatar, completeInfoGuideModel.avatar) && s.d(this.username, completeInfoGuideModel.username) && this.score == completeInfoGuideModel.score && s.d(this.title, completeInfoGuideModel.title) && s.d(this.desc, completeInfoGuideModel.desc) && s.d(this.buttonText, completeInfoGuideModel.buttonText) && s.d(this.jumpUrl, completeInfoGuideModel.jumpUrl);
    }

    @NotNull
    public final ImageModel getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getButtonText() {
        return this.buttonText;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getScore() {
        return this.score;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((((((this.avatar.hashCode() * 31) + this.username.hashCode()) * 31) + this.score) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.buttonText.hashCode()) * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.avatar;
        return "CompleteInfoGuideModel(avatar=" + ((Object) imageModel) + ", username=" + this.username + ", score=" + this.score + ", title=" + this.title + ", desc=" + this.desc + ", buttonText=" + this.buttonText + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
