package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FriendPraiseModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseShareModel {

    @Nullable
    private final String content;

    @Nullable
    private final ImageModel img;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    public FriendPraiseShareModel(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable String str3) {
        this.url = str;
        this.title = str2;
        this.img = imageModel;
        this.content = str3;
    }

    public static /* synthetic */ FriendPraiseShareModel copy$default(FriendPraiseShareModel friendPraiseShareModel, String str, String str2, ImageModel imageModel, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = friendPraiseShareModel.url;
        }
        if ((i10 & 2) != 0) {
            str2 = friendPraiseShareModel.title;
        }
        if ((i10 & 4) != 0) {
            imageModel = friendPraiseShareModel.img;
        }
        if ((i10 & 8) != 0) {
            str3 = friendPraiseShareModel.content;
        }
        return friendPraiseShareModel.copy(str, str2, imageModel, str3);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final ImageModel component3() {
        return this.img;
    }

    @Nullable
    public final String component4() {
        return this.content;
    }

    @NotNull
    public final FriendPraiseShareModel copy(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable String str3) {
        return new FriendPraiseShareModel(str, str2, imageModel, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FriendPraiseShareModel)) {
            return false;
        }
        FriendPraiseShareModel friendPraiseShareModel = (FriendPraiseShareModel) obj;
        return s.d(this.url, friendPraiseShareModel.url) && s.d(this.title, friendPraiseShareModel.title) && s.d(this.img, friendPraiseShareModel.img) && s.d(this.content, friendPraiseShareModel.content);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final ImageModel getImg() {
        return this.img;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.img;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str3 = this.content;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.url;
        String str2 = this.title;
        ImageModel imageModel = this.img;
        return "FriendPraiseShareModel(url=" + str + ", title=" + str2 + ", img=" + ((Object) imageModel) + ", content=" + this.content + ")";
    }
}
