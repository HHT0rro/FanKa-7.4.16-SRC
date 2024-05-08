package com.cupidapp.live.base.share.helper;

import android.app.Activity;
import android.text.TextUtils;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ImageSizeConstants;
import com.cupidapp.live.base.sensorslog.ShareContent;
import com.cupidapp.live.base.sensorslog.ShareType;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.profile.model.User;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: ShareBuilder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareBuilder implements Serializable {

    @Nullable
    private final Activity activity;

    @Nullable
    private String contentId;

    @Nullable
    private final String description;

    @Nullable
    private String ownerId;

    @Nullable
    private String ownerNickName;

    @Nullable
    private final String path;

    @Nullable
    private ShareContent shareContent;

    @Nullable
    private SharePlatform sharePlatform;

    @Nullable
    private ShareType shareType;

    @Nullable
    private final ImageModel thumb;
    private final int thumbPlaceHolderResId;

    @Nullable
    private final String thumbUrl;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    @Nullable
    private final String userId;

    public ShareBuilder(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable Activity activity, @Nullable String str4, @Nullable ShareContent shareContent, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable ShareType shareType, int i10, @Nullable String str8, @Nullable SharePlatform sharePlatform, @Nullable String str9) {
        this.url = str;
        this.title = str2;
        this.description = str3;
        this.thumb = imageModel;
        this.activity = activity;
        this.userId = str4;
        this.shareContent = shareContent;
        this.contentId = str5;
        this.ownerId = str6;
        this.ownerNickName = str7;
        this.shareType = shareType;
        this.thumbPlaceHolderResId = i10;
        this.path = str8;
        this.sharePlatform = sharePlatform;
        this.thumbUrl = str9;
    }

    private final String component1() {
        return this.url;
    }

    private final String component15() {
        return this.thumbUrl;
    }

    private final ImageModel component4() {
        return this.thumb;
    }

    @Nullable
    public final String component10() {
        return this.ownerNickName;
    }

    @Nullable
    public final ShareType component11() {
        return this.shareType;
    }

    public final int component12() {
        return this.thumbPlaceHolderResId;
    }

    @Nullable
    public final String component13() {
        return this.path;
    }

    @Nullable
    public final SharePlatform component14() {
        return this.sharePlatform;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final Activity component5() {
        return this.activity;
    }

    @Nullable
    public final String component6() {
        return this.userId;
    }

    @Nullable
    public final ShareContent component7() {
        return this.shareContent;
    }

    @Nullable
    public final String component8() {
        return this.contentId;
    }

    @Nullable
    public final String component9() {
        return this.ownerId;
    }

    public final void configShareBuilder(@NotNull SharePlatform sharePlatform, @Nullable ShareType shareType) {
        s.i(sharePlatform, "sharePlatform");
        this.sharePlatform = sharePlatform;
        this.shareType = shareType;
    }

    @NotNull
    public final ShareBuilder copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable Activity activity, @Nullable String str4, @Nullable ShareContent shareContent, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable ShareType shareType, int i10, @Nullable String str8, @Nullable SharePlatform sharePlatform, @Nullable String str9) {
        return new ShareBuilder(str, str2, str3, imageModel, activity, str4, shareContent, str5, str6, str7, shareType, i10, str8, sharePlatform, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareBuilder)) {
            return false;
        }
        ShareBuilder shareBuilder = (ShareBuilder) obj;
        return s.d(this.url, shareBuilder.url) && s.d(this.title, shareBuilder.title) && s.d(this.description, shareBuilder.description) && s.d(this.thumb, shareBuilder.thumb) && s.d(this.activity, shareBuilder.activity) && s.d(this.userId, shareBuilder.userId) && this.shareContent == shareBuilder.shareContent && s.d(this.contentId, shareBuilder.contentId) && s.d(this.ownerId, shareBuilder.ownerId) && s.d(this.ownerNickName, shareBuilder.ownerNickName) && this.shareType == shareBuilder.shareType && this.thumbPlaceHolderResId == shareBuilder.thumbPlaceHolderResId && s.d(this.path, shareBuilder.path) && this.sharePlatform == shareBuilder.sharePlatform && s.d(this.thumbUrl, shareBuilder.thumbUrl);
    }

    @Nullable
    public final Activity getActivity() {
        return this.activity;
    }

    @Nullable
    public final String getContentId() {
        return this.contentId;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getOwnerId() {
        return this.ownerId;
    }

    @Nullable
    public final String getOwnerNickName() {
        return this.ownerNickName;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final ShareContent getShareContent() {
        return this.shareContent;
    }

    @Nullable
    public final SharePlatform getSharePlatform() {
        return this.sharePlatform;
    }

    @Nullable
    public final ShareType getShareType() {
        return this.shareType;
    }

    public final int getThumbPlaceHolderResId() {
        return this.thumbPlaceHolderResId;
    }

    @Nullable
    public final String getThumbnailUrl() {
        String url;
        ImageModel imageModel = this.thumb;
        return (imageModel == null || (url = imageModel.getUrl(ImageSizeConstants.SQUARE_SMALL_SIZE.getWidth())) == null) ? this.thumbUrl : url;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ImageModel imageModel = this.thumb;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        Activity activity = this.activity;
        int hashCode5 = (hashCode4 + (activity == null ? 0 : activity.hashCode())) * 31;
        String str4 = this.userId;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ShareContent shareContent = this.shareContent;
        int hashCode7 = (hashCode6 + (shareContent == null ? 0 : shareContent.hashCode())) * 31;
        String str5 = this.contentId;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.ownerId;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.ownerNickName;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        ShareType shareType = this.shareType;
        int hashCode11 = (((hashCode10 + (shareType == null ? 0 : shareType.hashCode())) * 31) + this.thumbPlaceHolderResId) * 31;
        String str8 = this.path;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        SharePlatform sharePlatform = this.sharePlatform;
        int hashCode13 = (hashCode12 + (sharePlatform == null ? 0 : sharePlatform.hashCode())) * 31;
        String str9 = this.thumbUrl;
        return hashCode13 + (str9 != null ? str9.hashCode() : 0);
    }

    public final boolean onlyShareImage() {
        return !TextUtils.isEmpty(this.path);
    }

    public final void setContentId(@Nullable String str) {
        this.contentId = str;
    }

    public final void setOwnerId(@Nullable String str) {
        this.ownerId = str;
    }

    public final void setOwnerNickName(@Nullable String str) {
        this.ownerNickName = str;
    }

    public final void setShareContent(@Nullable ShareContent shareContent) {
        this.shareContent = shareContent;
    }

    public final void setSharePlatform(@Nullable SharePlatform sharePlatform) {
        this.sharePlatform = sharePlatform;
    }

    public final void setShareType(@Nullable ShareType shareType) {
        this.shareType = shareType;
    }

    @NotNull
    public final String shareUrl() {
        String str = this.url;
        if (str != null && StringsKt__StringsKt.K(str, SymbolValues.QUESTION_EN_SYMBOL, false, 2, null)) {
            String str2 = this.url;
            User X = g.f52734a.X();
            String userId = X != null ? X.userId() : null;
            SharePlatform sharePlatform = this.sharePlatform;
            return str2 + "&shareBy=" + userId + "&channel=" + (sharePlatform != null ? sharePlatform.getValue() : null);
        }
        String str3 = this.url;
        User X2 = g.f52734a.X();
        String userId2 = X2 != null ? X2.userId() : null;
        SharePlatform sharePlatform2 = this.sharePlatform;
        return str3 + "?shareBy=" + userId2 + "&channel=" + (sharePlatform2 != null ? sharePlatform2.getValue() : null);
    }

    @NotNull
    public String toString() {
        String str = this.url;
        String str2 = this.title;
        String str3 = this.description;
        ImageModel imageModel = this.thumb;
        Activity activity = this.activity;
        String str4 = this.userId;
        ShareContent shareContent = this.shareContent;
        String str5 = this.contentId;
        String str6 = this.ownerId;
        String str7 = this.ownerNickName;
        ShareType shareType = this.shareType;
        int i10 = this.thumbPlaceHolderResId;
        String str8 = this.path;
        SharePlatform sharePlatform = this.sharePlatform;
        return "ShareBuilder(url=" + str + ", title=" + str2 + ", description=" + str3 + ", thumb=" + ((Object) imageModel) + ", activity=" + ((Object) activity) + ", userId=" + str4 + ", shareContent=" + ((Object) shareContent) + ", contentId=" + str5 + ", ownerId=" + str6 + ", ownerNickName=" + str7 + ", shareType=" + ((Object) shareType) + ", thumbPlaceHolderResId=" + i10 + ", path=" + str8 + ", sharePlatform=" + ((Object) sharePlatform) + ", thumbUrl=" + this.thumbUrl + ")";
    }

    public /* synthetic */ ShareBuilder(String str, String str2, String str3, ImageModel imageModel, Activity activity, String str4, ShareContent shareContent, String str5, String str6, String str7, ShareType shareType, int i10, String str8, SharePlatform sharePlatform, String str9, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, imageModel, activity, (i11 & 32) != 0 ? null : str4, (i11 & 64) != 0 ? null : shareContent, (i11 & 128) != 0 ? null : str5, (i11 & 256) != 0 ? null : str6, (i11 & 512) != 0 ? null : str7, (i11 & 1024) != 0 ? null : shareType, (i11 & 2048) != 0 ? R$mipmap.ic_launcher_square : i10, (i11 & 4096) != 0 ? null : str8, (i11 & 8192) != 0 ? null : sharePlatform, (i11 & 16384) != 0 ? null : str9);
    }
}
