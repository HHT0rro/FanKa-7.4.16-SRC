package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitFriendsModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitDetailModel implements Serializable {
    private final boolean expired;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f14611id;

    @Nullable
    private final ImageModel image;
    private final int messageLimit;

    @NotNull
    private final String timeContent;

    @Nullable
    private final User user;

    @Nullable
    private final String viewCount;

    @Nullable
    private final List<User> viewers;

    public PostLimitDetailModel(@NotNull String id2, @Nullable User user, @NotNull String timeContent, @Nullable ImageModel imageModel, @Nullable List<User> list, @Nullable String str, int i10, boolean z10) {
        s.i(id2, "id");
        s.i(timeContent, "timeContent");
        this.f14611id = id2;
        this.user = user;
        this.timeContent = timeContent;
        this.image = imageModel;
        this.viewers = list;
        this.viewCount = str;
        this.messageLimit = i10;
        this.expired = z10;
    }

    @NotNull
    public final String component1() {
        return this.f14611id;
    }

    @Nullable
    public final User component2() {
        return this.user;
    }

    @NotNull
    public final String component3() {
        return this.timeContent;
    }

    @Nullable
    public final ImageModel component4() {
        return this.image;
    }

    @Nullable
    public final List<User> component5() {
        return this.viewers;
    }

    @Nullable
    public final String component6() {
        return this.viewCount;
    }

    public final int component7() {
        return this.messageLimit;
    }

    public final boolean component8() {
        return this.expired;
    }

    @NotNull
    public final PostLimitDetailModel copy(@NotNull String id2, @Nullable User user, @NotNull String timeContent, @Nullable ImageModel imageModel, @Nullable List<User> list, @Nullable String str, int i10, boolean z10) {
        s.i(id2, "id");
        s.i(timeContent, "timeContent");
        return new PostLimitDetailModel(id2, user, timeContent, imageModel, list, str, i10, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostLimitDetailModel)) {
            return false;
        }
        PostLimitDetailModel postLimitDetailModel = (PostLimitDetailModel) obj;
        return s.d(this.f14611id, postLimitDetailModel.f14611id) && s.d(this.user, postLimitDetailModel.user) && s.d(this.timeContent, postLimitDetailModel.timeContent) && s.d(this.image, postLimitDetailModel.image) && s.d(this.viewers, postLimitDetailModel.viewers) && s.d(this.viewCount, postLimitDetailModel.viewCount) && this.messageLimit == postLimitDetailModel.messageLimit && this.expired == postLimitDetailModel.expired;
    }

    public final boolean getExpired() {
        return this.expired;
    }

    @NotNull
    public final String getId() {
        return this.f14611id;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    public final int getMessageLimit() {
        return this.messageLimit;
    }

    @NotNull
    public final String getTimeContent() {
        return this.timeContent;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final String getViewCount() {
        return this.viewCount;
    }

    @Nullable
    public final List<User> getViewers() {
        return this.viewers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f14611id.hashCode() * 31;
        User user = this.user;
        int hashCode2 = (((hashCode + (user == null ? 0 : user.hashCode())) * 31) + this.timeContent.hashCode()) * 31;
        ImageModel imageModel = this.image;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        List<User> list = this.viewers;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.viewCount;
        int hashCode5 = (((hashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.messageLimit) * 31;
        boolean z10 = this.expired;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode5 + i10;
    }

    @NotNull
    public String toString() {
        String str = this.f14611id;
        User user = this.user;
        String str2 = this.timeContent;
        ImageModel imageModel = this.image;
        List<User> list = this.viewers;
        return "PostLimitDetailModel(id=" + str + ", user=" + ((Object) user) + ", timeContent=" + str2 + ", image=" + ((Object) imageModel) + ", viewers=" + ((Object) list) + ", viewCount=" + this.viewCount + ", messageLimit=" + this.messageLimit + ", expired=" + this.expired + ")";
    }

    public /* synthetic */ PostLimitDetailModel(String str, User user, String str2, ImageModel imageModel, List list, String str3, int i10, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, user, str2, imageModel, (i11 & 16) != 0 ? null : list, (i11 & 32) != 0 ? null : str3, i10, (i11 & 128) != 0 ? false : z10);
    }
}
