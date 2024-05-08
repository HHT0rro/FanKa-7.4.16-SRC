package com.cupidapp.live.chat.service;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewUserGuideItemModel {

    @NotNull
    private final String desc;

    @NotNull
    private final ImageModel icon;

    @NotNull
    private final String jumpDesc;

    @NotNull
    private final String jumpUrl;

    @NotNull
    private final String title;

    public NewUserGuideItemModel(@NotNull ImageModel icon, @NotNull String title, @NotNull String desc, @NotNull String jumpDesc, @NotNull String jumpUrl) {
        s.i(icon, "icon");
        s.i(title, "title");
        s.i(desc, "desc");
        s.i(jumpDesc, "jumpDesc");
        s.i(jumpUrl, "jumpUrl");
        this.icon = icon;
        this.title = title;
        this.desc = desc;
        this.jumpDesc = jumpDesc;
        this.jumpUrl = jumpUrl;
    }

    public static /* synthetic */ NewUserGuideItemModel copy$default(NewUserGuideItemModel newUserGuideItemModel, ImageModel imageModel, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = newUserGuideItemModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = newUserGuideItemModel.title;
        }
        String str5 = str;
        if ((i10 & 4) != 0) {
            str2 = newUserGuideItemModel.desc;
        }
        String str6 = str2;
        if ((i10 & 8) != 0) {
            str3 = newUserGuideItemModel.jumpDesc;
        }
        String str7 = str3;
        if ((i10 & 16) != 0) {
            str4 = newUserGuideItemModel.jumpUrl;
        }
        return newUserGuideItemModel.copy(imageModel, str5, str6, str7, str4);
    }

    @NotNull
    public final ImageModel component1() {
        return this.icon;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.desc;
    }

    @NotNull
    public final String component4() {
        return this.jumpDesc;
    }

    @NotNull
    public final String component5() {
        return this.jumpUrl;
    }

    @NotNull
    public final NewUserGuideItemModel copy(@NotNull ImageModel icon, @NotNull String title, @NotNull String desc, @NotNull String jumpDesc, @NotNull String jumpUrl) {
        s.i(icon, "icon");
        s.i(title, "title");
        s.i(desc, "desc");
        s.i(jumpDesc, "jumpDesc");
        s.i(jumpUrl, "jumpUrl");
        return new NewUserGuideItemModel(icon, title, desc, jumpDesc, jumpUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewUserGuideItemModel)) {
            return false;
        }
        NewUserGuideItemModel newUserGuideItemModel = (NewUserGuideItemModel) obj;
        return s.d(this.icon, newUserGuideItemModel.icon) && s.d(this.title, newUserGuideItemModel.title) && s.d(this.desc, newUserGuideItemModel.desc) && s.d(this.jumpDesc, newUserGuideItemModel.jumpDesc) && s.d(this.jumpUrl, newUserGuideItemModel.jumpUrl);
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getJumpDesc() {
        return this.jumpDesc;
    }

    @NotNull
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((this.icon.hashCode() * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.jumpDesc.hashCode()) * 31) + this.jumpUrl.hashCode();
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "NewUserGuideItemModel(icon=" + ((Object) imageModel) + ", title=" + this.title + ", desc=" + this.desc + ", jumpDesc=" + this.jumpDesc + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
