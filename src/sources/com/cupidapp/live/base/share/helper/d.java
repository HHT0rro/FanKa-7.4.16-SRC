package com.cupidapp.live.base.share.helper;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogShare;
import com.cupidapp.live.base.sensorslog.ShareBtnPos;
import com.cupidapp.live.base.sensorslog.ShareContent;
import com.cupidapp.live.base.sensorslog.ShareType;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.model.WebShareModel;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.feed.FeedType;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.profile.model.User;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShareManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f12255a = new d();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static ShareBuilder f12256b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static SensorPosition f12257c;

    /* compiled from: ShareManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12258a;

        static {
            int[] iArr = new int[SharePlatform.values().length];
            try {
                iArr[SharePlatform.Wechat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SharePlatform.WechatMoments.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SharePlatform.Weibo.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SharePlatform.QQ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SharePlatform.QZone.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SharePlatform.Copylink.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f12258a = iArr;
        }
    }

    public static /* synthetic */ void n(d dVar, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        dVar.m(z10, str);
    }

    @Nullable
    public final ShareBuilder a(@NotNull Activity activity, @NotNull ConsultLiveModel model, @NotNull SensorPosition sensorPosition) {
        s.i(activity, "activity");
        s.i(model, "model");
        s.i(sensorPosition, "sensorPosition");
        User user = model.getUser();
        if (user.getShareLink() == null) {
            return null;
        }
        String shareLink = user.getShareLink();
        String shareTitle = user.getShareTitle();
        String shareContent = user.getShareContent();
        ImageModel cover = model.getCover();
        if (cover == null) {
            cover = user.getAvatarImage();
        }
        String userId = user.userId();
        ShareContent shareContent2 = ShareContent.LIVE;
        ShareBuilder shareBuilder = new ShareBuilder(shareLink, shareTitle, shareContent, cover, activity, userId, shareContent2, model.getId(), user.userId(), user.getName(), null, 0, null, null, null, 31744, null);
        SensorsLogShare.f12216a.a(shareContent2, model.getId(), user.userId(), user.getName(), sensorPosition, null, (r17 & 64) != 0 ? "" : null);
        return shareBuilder;
    }

    @Nullable
    public final ShareBuilder b(@NotNull Activity activity, @NotNull User user, @NotNull LiveShowModel liveShow, @NotNull SensorPosition sensorPosition, @Nullable ShareBtnPos shareBtnPos) {
        s.i(activity, "activity");
        s.i(user, "user");
        s.i(liveShow, "liveShow");
        s.i(sensorPosition, "sensorPosition");
        if (user.getShareLink() == null) {
            return null;
        }
        String shareLink = user.getShareLink();
        String shareTitle = user.getShareTitle();
        String shareContent = user.getShareContent();
        ImageModel avatarImage = user.getAvatarImage();
        String userId = user.userId();
        ShareContent shareContent2 = ShareContent.LIVE;
        ShareBuilder shareBuilder = new ShareBuilder(shareLink, shareTitle, shareContent, avatarImage, activity, userId, shareContent2, liveShow.getItemId(), liveShow.getUser().userId(), liveShow.getUser().getNickname(), null, 0, null, null, null, 31744, null);
        SensorsLogShare.f12216a.a(shareContent2, liveShow.getItemId(), user.userId(), user.getNickname(), sensorPosition, shareBtnPos, (r17 & 64) != 0 ? "" : null);
        return shareBuilder;
    }

    @Nullable
    public final ShareBuilder c(@NotNull Activity activity, @Nullable User user, @NotNull SensorPosition sensorPosition, @Nullable ShareBtnPos shareBtnPos) {
        s.i(activity, "activity");
        s.i(sensorPosition, "sensorPosition");
        if ((user != null ? user.getShareLink() : null) == null) {
            return null;
        }
        String shareLink = user.getShareLink();
        String shareTitle = user.getShareTitle();
        String shareContent = user.getShareContent();
        ImageModel avatarImage = user.getAvatarImage();
        String userId = user.userId();
        ShareContent shareContent2 = ShareContent.HOMEPAGE;
        ShareBuilder shareBuilder = new ShareBuilder(shareLink, shareTitle, shareContent, avatarImage, activity, userId, shareContent2, user.userId(), user.userId(), user.getName(), null, 0, null, null, null, 31744, null);
        SensorsLogShare.f12216a.a(shareContent2, shareBuilder.getContentId(), shareBuilder.getOwnerId(), shareBuilder.getOwnerNickName(), sensorPosition, shareBtnPos, (r17 & 64) != 0 ? "" : null);
        return shareBuilder;
    }

    @Nullable
    public final ShareBuilder d(@Nullable Activity activity, @NotNull FeedModel feedModel, @NotNull SensorPosition sensorPosition, @Nullable ShareBtnPos shareBtnPos) {
        ShareContent shareContent;
        s.i(feedModel, "feedModel");
        s.i(sensorPosition, "sensorPosition");
        if (feedModel.getShareLink() == null) {
            return null;
        }
        if (s.d(feedModel.getType(), FeedType.ImagePost.getValue())) {
            shareContent = ShareContent.PHOTO;
        } else {
            shareContent = ShareContent.VIDEO;
        }
        ShareContent shareContent2 = shareContent;
        ShareBuilder shareBuilder = new ShareBuilder(feedModel.getShareLink(), feedModel.getShareTitle(), "", feedModel.getImageListFirst(), activity, feedModel.getUser().userId(), shareContent2, feedModel.getPostId(), feedModel.getUser().userId(), feedModel.getUser().getName(), null, 0, null, null, null, 31744, null);
        SensorsLogShare.f12216a.a(shareContent2, shareBuilder.getContentId(), shareBuilder.getOwnerId(), shareBuilder.getOwnerNickName(), sensorPosition, shareBtnPos, (r17 & 64) != 0 ? "" : null);
        return shareBuilder;
    }

    @Nullable
    public final ShareBuilder e(@Nullable Activity activity, @NotNull HashTag hashTag, @Nullable ImageModel imageModel, @NotNull SensorPosition sensorPosition) {
        s.i(hashTag, "hashTag");
        s.i(sensorPosition, "sensorPosition");
        if (hashTag.getShareLink() == null) {
            return null;
        }
        ShareContent shareContent = ShareContent.NEW_TOPIC;
        String shareLink = hashTag.getShareLink();
        String shareTitle = hashTag.getShareTitle();
        String shareContent2 = hashTag.getShareContent();
        ImageModel backgroundImage = hashTag.getBackgroundImage();
        ShareBuilder shareBuilder = new ShareBuilder(shareLink, shareTitle, shareContent2, backgroundImage == null ? imageModel : backgroundImage, activity, null, shareContent, hashTag.getItemId(), null, null, null, 0, null, null, null, 31744, null);
        SensorsLogShare.f12216a.a(shareContent, hashTag.getItemId(), null, null, sensorPosition, null, (r17 & 64) != 0 ? "" : null);
        return shareBuilder;
    }

    @Nullable
    public final ShareBuilder f(@NotNull Activity activity, @NotNull Uri uri) {
        s.i(activity, "activity");
        s.i(uri, "uri");
        SensorsLogShare.f12216a.a(ShareContent.WEB, uri.toString(), null, null, SensorPosition.Web, null, (r17 & 64) != 0 ? "" : null);
        return g(uri, activity);
    }

    @Nullable
    public final ShareBuilder g(@NotNull Uri uri, @Nullable Activity activity) {
        s.i(uri, "uri");
        String queryParameter = uri.getQueryParameter("params");
        if (queryParameter == null) {
            return null;
        }
        byte[] decode = Base64.decode(queryParameter, 0);
        s.h(decode, "decode(jsonString, Base64.DEFAULT)");
        String str = new String(decode, kotlin.text.c.f51097b);
        if (str.length() == 0) {
            return null;
        }
        WebShareConfig webShareConfig = (WebShareConfig) NetworkClient.f11868a.m().fromJson(str, WebShareConfig.class);
        return new ShareBuilder(webShareConfig.getUrl(), webShareConfig.getTitle(), webShareConfig.getDescription(), null, activity, null, ShareContent.WEB, null, null, null, null, 0, null, null, null, 32640, null);
    }

    @NotNull
    public final ShareBuilder h(@NotNull Activity activity, @NotNull String url, @Nullable WebShareModel webShareModel) {
        s.i(activity, "activity");
        s.i(url, "url");
        SensorsLogShare sensorsLogShare = SensorsLogShare.f12216a;
        ShareContent shareContent = ShareContent.WEB;
        sensorsLogShare.a(shareContent, url, null, null, SensorPosition.Web, null, webShareModel != null ? webShareModel.getShareTitle() : null);
        return new ShareBuilder(url, webShareModel != null ? webShareModel.getShareTitle() : null, webShareModel != null ? webShareModel.getShareDescription() : null, null, activity, null, shareContent, null, null, null, null, 0, null, null, webShareModel != null ? webShareModel.getShareImageUrl() : null, 16288, null);
    }

    public final void i(int i10, int i11, @Nullable Intent intent) {
        ShareBuilder shareBuilder = f12256b;
        if (shareBuilder != null) {
            SharePlatform sharePlatform = shareBuilder.getSharePlatform();
            int i12 = sharePlatform == null ? -1 : a.f12258a[sharePlatform.ordinal()];
            if (i12 == 3) {
                WeiBoShare.f12251a.e(intent);
            } else if (i12 == 4 || i12 == 5) {
                QQShare.f12245a.f(i10, i11, intent);
            }
        }
    }

    public final void j(ShareBuilder shareBuilder) {
        FKWebView l10 = l();
        if (l10 == null) {
            return;
        }
        com.cupidapp.live.base.web.bridge.b bVar = com.cupidapp.live.base.web.bridge.b.f13062a;
        SharePlatform sharePlatform = shareBuilder.getSharePlatform();
        bVar.g(l10, sharePlatform != null ? sharePlatform.getValue() : null);
    }

    public final void k(ShareBuilder shareBuilder, boolean z10) {
        SharePlatform sharePlatform;
        FKWebView l10 = l();
        if (l10 == null) {
            return;
        }
        com.cupidapp.live.base.web.bridge.b.f13062a.h(l10, (shareBuilder == null || (sharePlatform = shareBuilder.getSharePlatform()) == null) ? null : sharePlatform.getValue(), z10);
    }

    public final FKWebView l() {
        Activity activity;
        ShareBuilder shareBuilder = f12256b;
        if (shareBuilder == null || (activity = shareBuilder.getActivity()) == null) {
            return null;
        }
        return (FKWebView) activity.findViewById(R$id.appWebView);
    }

    public final void m(boolean z10, @Nullable String str) {
        ShareBuilder shareBuilder = f12256b;
        if (shareBuilder == null) {
            return;
        }
        k(shareBuilder, z10);
        if (z10) {
            SensorsLogShare sensorsLogShare = SensorsLogShare.f12216a;
            ShareBuilder shareBuilder2 = f12256b;
            ShareContent shareContent = shareBuilder2 != null ? shareBuilder2.getShareContent() : null;
            ShareBuilder shareBuilder3 = f12256b;
            String contentId = shareBuilder3 != null ? shareBuilder3.getContentId() : null;
            ShareBuilder shareBuilder4 = f12256b;
            String ownerId = shareBuilder4 != null ? shareBuilder4.getOwnerId() : null;
            ShareBuilder shareBuilder5 = f12256b;
            String ownerNickName = shareBuilder5 != null ? shareBuilder5.getOwnerNickName() : null;
            ShareBuilder shareBuilder6 = f12256b;
            ShareType shareType = shareBuilder6 != null ? shareBuilder6.getShareType() : null;
            SensorPosition sensorPosition = f12257c;
            ShareBuilder shareBuilder7 = f12256b;
            String title = shareBuilder7 != null ? shareBuilder7.getTitle() : null;
            ShareBuilder shareBuilder8 = f12256b;
            sensorsLogShare.f(shareContent, contentId, ownerId, ownerNickName, shareType, z10, str, sensorPosition, title, shareBuilder8 != null ? shareBuilder8.shareUrl() : null);
        }
        f12256b = null;
    }

    public final void o(@NotNull SharePlatform sharePlatform, @NotNull ShareBuilder shareBuilder, @NotNull SensorPosition sensorPosition) {
        c cVar;
        s.i(sharePlatform, "sharePlatform");
        s.i(shareBuilder, "shareBuilder");
        s.i(sensorPosition, "sensorPosition");
        f12257c = sensorPosition;
        switch (a.f12258a[sharePlatform.ordinal()]) {
            case 1:
                shareBuilder.configShareBuilder(sharePlatform, ShareType.WECHAT_FRIEND);
                cVar = WeChatShare.f12249a;
                break;
            case 2:
                shareBuilder.configShareBuilder(sharePlatform, ShareType.WECHAT_MOMENTS);
                cVar = WeChatShare.f12249a;
                break;
            case 3:
                shareBuilder.configShareBuilder(sharePlatform, ShareType.WEIBO);
                cVar = WeiBoShare.f12251a;
                break;
            case 4:
                shareBuilder.configShareBuilder(sharePlatform, ShareType.QQ);
                cVar = QQShare.f12245a;
                break;
            case 5:
                shareBuilder.configShareBuilder(sharePlatform, ShareType.QQ_ZONE);
                cVar = QQShare.f12245a;
                break;
            case 6:
                shareBuilder.configShareBuilder(sharePlatform, ShareType.COPY_LINK);
                cVar = b.f12254a;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        f12256b = shareBuilder;
        if (shareBuilder.onlyShareImage()) {
            cVar.b(shareBuilder);
        } else {
            cVar.a(shareBuilder);
        }
        SensorsLogShare.f12216a.d(shareBuilder.getShareContent(), shareBuilder.getContentId(), shareBuilder.getOwnerId(), shareBuilder.getOwnerNickName(), shareBuilder.getShareType(), sensorPosition, shareBuilder.getTitle(), shareBuilder.shareUrl());
        j(shareBuilder);
    }
}
