package com.cupidapp.live.profile.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.adapter.FriendPraiseDetailPageType;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FriendPraiseModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseDetailModel implements Serializable {

    @Nullable
    private final Boolean anonymous;

    @Nullable
    private final String content;

    @Nullable
    private Boolean homePageDisplay;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f17841id;
    private int likeCount;

    @Nullable
    private Boolean liked;

    @NotNull
    private FriendPraiseDetailPageType pageType;

    @Nullable
    private final String reportData;

    @Nullable
    private final String senderId;

    @Nullable
    private final ImageModel userIcon;

    @Nullable
    private final String userId;

    @Nullable
    private final String username;

    public FriendPraiseDetailModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable String str4, int i10, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str5, @Nullable Boolean bool3, @NotNull FriendPraiseDetailPageType pageType, @Nullable String str6) {
        s.i(pageType, "pageType");
        this.f17841id = str;
        this.userId = str2;
        this.senderId = str3;
        this.userIcon = imageModel;
        this.username = str4;
        this.likeCount = i10;
        this.liked = bool;
        this.homePageDisplay = bool2;
        this.content = str5;
        this.anonymous = bool3;
        this.pageType = pageType;
        this.reportData = str6;
    }

    @Nullable
    public final String component1() {
        return this.f17841id;
    }

    @Nullable
    public final Boolean component10() {
        return this.anonymous;
    }

    @NotNull
    public final FriendPraiseDetailPageType component11() {
        return this.pageType;
    }

    @Nullable
    public final String component12() {
        return this.reportData;
    }

    @Nullable
    public final String component2() {
        return this.userId;
    }

    @Nullable
    public final String component3() {
        return this.senderId;
    }

    @Nullable
    public final ImageModel component4() {
        return this.userIcon;
    }

    @Nullable
    public final String component5() {
        return this.username;
    }

    public final int component6() {
        return this.likeCount;
    }

    @Nullable
    public final Boolean component7() {
        return this.liked;
    }

    @Nullable
    public final Boolean component8() {
        return this.homePageDisplay;
    }

    @Nullable
    public final String component9() {
        return this.content;
    }

    @NotNull
    public final FriendPraiseDetailModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable String str4, int i10, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str5, @Nullable Boolean bool3, @NotNull FriendPraiseDetailPageType pageType, @Nullable String str6) {
        s.i(pageType, "pageType");
        return new FriendPraiseDetailModel(str, str2, str3, imageModel, str4, i10, bool, bool2, str5, bool3, pageType, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FriendPraiseDetailModel)) {
            return false;
        }
        FriendPraiseDetailModel friendPraiseDetailModel = (FriendPraiseDetailModel) obj;
        return s.d(this.f17841id, friendPraiseDetailModel.f17841id) && s.d(this.userId, friendPraiseDetailModel.userId) && s.d(this.senderId, friendPraiseDetailModel.senderId) && s.d(this.userIcon, friendPraiseDetailModel.userIcon) && s.d(this.username, friendPraiseDetailModel.username) && this.likeCount == friendPraiseDetailModel.likeCount && s.d(this.liked, friendPraiseDetailModel.liked) && s.d(this.homePageDisplay, friendPraiseDetailModel.homePageDisplay) && s.d(this.content, friendPraiseDetailModel.content) && s.d(this.anonymous, friendPraiseDetailModel.anonymous) && this.pageType == friendPraiseDetailModel.pageType && s.d(this.reportData, friendPraiseDetailModel.reportData);
    }

    @Nullable
    public final Boolean getAnonymous() {
        return this.anonymous;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Boolean getHomePageDisplay() {
        return this.homePageDisplay;
    }

    @Nullable
    public final String getId() {
        return this.f17841id;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final Boolean getLiked() {
        return this.liked;
    }

    @NotNull
    public final FriendPraiseDetailPageType getPageType() {
        return this.pageType;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final String getSenderId() {
        return this.senderId;
    }

    @Nullable
    public final ImageModel getUserIcon() {
        return this.userIcon;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.f17841id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.senderId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ImageModel imageModel = this.userIcon;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str4 = this.username;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.likeCount) * 31;
        Boolean bool = this.liked;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.homePageDisplay;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str5 = this.content;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool3 = this.anonymous;
        int hashCode9 = (((hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31) + this.pageType.hashCode()) * 31;
        String str6 = this.reportData;
        return hashCode9 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setHomePageDisplay(@Nullable Boolean bool) {
        this.homePageDisplay = bool;
    }

    public final void setLikeCount(int i10) {
        this.likeCount = i10;
    }

    public final void setLiked(@Nullable Boolean bool) {
        this.liked = bool;
    }

    public final void setPageType(@NotNull FriendPraiseDetailPageType friendPraiseDetailPageType) {
        s.i(friendPraiseDetailPageType, "<set-?>");
        this.pageType = friendPraiseDetailPageType;
    }

    @NotNull
    public String toString() {
        String str = this.f17841id;
        String str2 = this.userId;
        String str3 = this.senderId;
        ImageModel imageModel = this.userIcon;
        String str4 = this.username;
        int i10 = this.likeCount;
        Boolean bool = this.liked;
        Boolean bool2 = this.homePageDisplay;
        String str5 = this.content;
        Boolean bool3 = this.anonymous;
        FriendPraiseDetailPageType friendPraiseDetailPageType = this.pageType;
        return "FriendPraiseDetailModel(id=" + str + ", userId=" + str2 + ", senderId=" + str3 + ", userIcon=" + ((Object) imageModel) + ", username=" + str4 + ", likeCount=" + i10 + ", liked=" + ((Object) bool) + ", homePageDisplay=" + ((Object) bool2) + ", content=" + str5 + ", anonymous=" + ((Object) bool3) + ", pageType=" + ((Object) friendPraiseDetailPageType) + ", reportData=" + this.reportData + ")";
    }

    public /* synthetic */ FriendPraiseDetailModel(String str, String str2, String str3, ImageModel imageModel, String str4, int i10, Boolean bool, Boolean bool2, String str5, Boolean bool3, FriendPraiseDetailPageType friendPraiseDetailPageType, String str6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, imageModel, str4, (i11 & 32) != 0 ? 0 : i10, bool, bool2, str5, bool3, friendPraiseDetailPageType, str6);
    }
}
