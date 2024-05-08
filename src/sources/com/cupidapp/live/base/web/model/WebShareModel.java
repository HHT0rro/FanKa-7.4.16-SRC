package com.cupidapp.live.base.web.model;

import com.cupidapp.live.base.share.model.SharePlatform;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebShareModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WebShareModel {

    @Nullable
    private final ClubActivityInfoModel clubActivityInfo;

    @Nullable
    private final String message;

    @Nullable
    private final Boolean moments;

    @Nullable
    private final Boolean qq;

    @Nullable
    private final Boolean qzone;

    @Nullable
    private final String shareDescription;

    @Nullable
    private final String shareImageUrl;

    @Nullable
    private final String shareTitle;

    @Nullable
    private final String url;

    @Nullable
    private final Boolean wechat;

    @Nullable
    private final Boolean weibo;

    public WebShareModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable ClubActivityInfoModel clubActivityInfoModel) {
        this.shareTitle = str;
        this.shareDescription = str2;
        this.shareImageUrl = str3;
        this.message = str4;
        this.url = str5;
        this.wechat = bool;
        this.moments = bool2;
        this.qq = bool3;
        this.qzone = bool4;
        this.weibo = bool5;
        this.clubActivityInfo = clubActivityInfoModel;
    }

    @Nullable
    public final String component1() {
        return this.shareTitle;
    }

    @Nullable
    public final Boolean component10() {
        return this.weibo;
    }

    @Nullable
    public final ClubActivityInfoModel component11() {
        return this.clubActivityInfo;
    }

    @Nullable
    public final String component2() {
        return this.shareDescription;
    }

    @Nullable
    public final String component3() {
        return this.shareImageUrl;
    }

    @Nullable
    public final String component4() {
        return this.message;
    }

    @Nullable
    public final String component5() {
        return this.url;
    }

    @Nullable
    public final Boolean component6() {
        return this.wechat;
    }

    @Nullable
    public final Boolean component7() {
        return this.moments;
    }

    @Nullable
    public final Boolean component8() {
        return this.qq;
    }

    @Nullable
    public final Boolean component9() {
        return this.qzone;
    }

    @NotNull
    public final WebShareModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable ClubActivityInfoModel clubActivityInfoModel) {
        return new WebShareModel(str, str2, str3, str4, str5, bool, bool2, bool3, bool4, bool5, clubActivityInfoModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebShareModel)) {
            return false;
        }
        WebShareModel webShareModel = (WebShareModel) obj;
        return s.d(this.shareTitle, webShareModel.shareTitle) && s.d(this.shareDescription, webShareModel.shareDescription) && s.d(this.shareImageUrl, webShareModel.shareImageUrl) && s.d(this.message, webShareModel.message) && s.d(this.url, webShareModel.url) && s.d(this.wechat, webShareModel.wechat) && s.d(this.moments, webShareModel.moments) && s.d(this.qq, webShareModel.qq) && s.d(this.qzone, webShareModel.qzone) && s.d(this.weibo, webShareModel.weibo) && s.d(this.clubActivityInfo, webShareModel.clubActivityInfo);
    }

    @Nullable
    public final ClubActivityInfoModel getClubActivityInfo() {
        return this.clubActivityInfo;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Boolean getMoments() {
        return this.moments;
    }

    @NotNull
    public final List<SharePlatform> getNotShowPlatformTypes() {
        ArrayList arrayList = new ArrayList();
        Boolean bool = this.wechat;
        Boolean bool2 = Boolean.TRUE;
        if (!s.d(bool, bool2)) {
            arrayList.add(SharePlatform.Wechat);
        }
        if (!s.d(this.moments, bool2)) {
            arrayList.add(SharePlatform.WechatMoments);
        }
        if (!s.d(this.qq, bool2)) {
            arrayList.add(SharePlatform.QQ);
        }
        if (!s.d(this.qzone, bool2)) {
            arrayList.add(SharePlatform.QZone);
        }
        if (!s.d(this.weibo, bool2)) {
            arrayList.add(SharePlatform.Weibo);
        }
        return arrayList;
    }

    @Nullable
    public final Boolean getQq() {
        return this.qq;
    }

    @Nullable
    public final Boolean getQzone() {
        return this.qzone;
    }

    @Nullable
    public final String getShareDescription() {
        return this.shareDescription;
    }

    @Nullable
    public final String getShareImageUrl() {
        return this.shareImageUrl;
    }

    @Nullable
    public final String getShareTitle() {
        return this.shareTitle;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Boolean getWechat() {
        return this.wechat;
    }

    @Nullable
    public final Boolean getWeibo() {
        return this.weibo;
    }

    public int hashCode() {
        String str = this.shareTitle;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.shareDescription;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.shareImageUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.message;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.url;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.wechat;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.moments;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.qq;
        int hashCode8 = (hashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.qzone;
        int hashCode9 = (hashCode8 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.weibo;
        int hashCode10 = (hashCode9 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        ClubActivityInfoModel clubActivityInfoModel = this.clubActivityInfo;
        return hashCode10 + (clubActivityInfoModel != null ? clubActivityInfoModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "WebShareModel(shareTitle=" + this.shareTitle + ", shareDescription=" + this.shareDescription + ", shareImageUrl=" + this.shareImageUrl + ", message=" + this.message + ", url=" + this.url + ", wechat=" + ((Object) this.wechat) + ", moments=" + ((Object) this.moments) + ", qq=" + ((Object) this.qq) + ", qzone=" + ((Object) this.qzone) + ", weibo=" + ((Object) this.weibo) + ", clubActivityInfo=" + ((Object) this.clubActivityInfo) + ")";
    }
}
