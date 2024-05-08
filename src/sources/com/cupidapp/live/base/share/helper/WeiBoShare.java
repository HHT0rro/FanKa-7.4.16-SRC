package com.cupidapp.live.base.share.helper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.h;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.share.WbShareCallback;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.f;

/* compiled from: WeiBoShare.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WeiBoShare implements c, WbShareCallback {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WeiBoShare f12251a = new WeiBoShare();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final IWBAPI f12252b = AppApplication.f11612d.h().k();

    @Override // com.cupidapp.live.base.share.helper.c
    public void a(@NotNull final ShareBuilder shareBuilder) {
        s.i(shareBuilder, "shareBuilder");
        if (!f12252b.isWBAppInstalled()) {
            h.f12779a.r(shareBuilder.getActivity(), R$string.please_install_weibo_client);
            return;
        }
        String thumbnailUrl = shareBuilder.getThumbnailUrl();
        if (thumbnailUrl == null || thumbnailUrl.length() == 0) {
            Activity activity = shareBuilder.getActivity();
            f(shareBuilder, BitmapFactory.decodeResource(activity != null ? activity.getResources() : null, shareBuilder.getThumbPlaceHolderResId()));
        } else {
            Activity activity2 = shareBuilder.getActivity();
            if (activity2 != null) {
                ImageLoaderUtil.c(ImageLoaderUtil.f11832a, activity2, thumbnailUrl, false, new Function1<Bitmap, p>() { // from class: com.cupidapp.live.base.share.helper.WeiBoShare$share$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Bitmap bitmap) {
                        invoke2(bitmap);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Bitmap bitmap) {
                        s.i(bitmap, "bitmap");
                        WeiBoShare.f12251a.f(ShareBuilder.this, bitmap);
                    }
                }, 4, null);
            }
        }
    }

    @Override // com.cupidapp.live.base.share.helper.c
    public void b(@NotNull ShareBuilder shareBuilder) {
        s.i(shareBuilder, "shareBuilder");
        IWBAPI iwbapi = f12252b;
        if (!iwbapi.isWBAppInstalled()) {
            h.f12779a.r(shareBuilder.getActivity(), R$string.please_install_weibo_client);
            return;
        }
        String path = shareBuilder.getPath();
        if (path == null) {
            return;
        }
        if (!new File(path).exists()) {
            h.f12779a.r(shareBuilder.getActivity(), R$string.image_not_exists);
            return;
        }
        ImageObject imageObject = new ImageObject();
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        s.h(bitmap, "bitmap");
        imageObject.imageData = f.i(bitmap, 0, 1, null);
        TextObject textObject = new TextObject();
        textObject.text = shareBuilder.getDescription();
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.imageObject = imageObject;
        weiboMultiMessage.textObject = textObject;
        iwbapi.shareMessage(shareBuilder.getActivity(), weiboMultiMessage, true);
    }

    public final WebpageObject d(ShareBuilder shareBuilder, Bitmap bitmap) {
        String description;
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = UUID.randomUUID().toString();
        webpageObject.title = shareBuilder.getTitle();
        String description2 = shareBuilder.getDescription();
        if (description2 == null || description2.length() == 0) {
            Activity activity = shareBuilder.getActivity();
            description = activity != null ? activity.getString(R$string.share_description) : null;
        } else {
            description = shareBuilder.getDescription();
        }
        webpageObject.description = description;
        webpageObject.thumbData = bitmap != null ? f.i(bitmap, 0, 1, null) : null;
        webpageObject.actionUrl = shareBuilder.shareUrl();
        Activity activity2 = shareBuilder.getActivity();
        webpageObject.defaultText = activity2 != null ? activity2.getString(R$string.share_default_text) : null;
        return webpageObject;
    }

    public final void e(@Nullable Intent intent) {
        f12252b.doResultIntent(intent, this);
    }

    public final void f(ShareBuilder shareBuilder, Bitmap bitmap) {
        String description;
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.mediaObject = d(shareBuilder, bitmap);
        TextObject textObject = new TextObject();
        String description2 = shareBuilder.getDescription();
        if (description2 == null || description2.length() == 0) {
            Activity activity = shareBuilder.getActivity();
            description = activity != null ? activity.getString(R$string.share_description) : null;
        } else {
            description = shareBuilder.getDescription();
        }
        textObject.text = description;
        weiboMultiMessage.textObject = textObject;
        if (bitmap != null) {
            ImageObject imageObject = new ImageObject();
            imageObject.imageData = f.i(bitmap, 0, 1, null);
            weiboMultiMessage.imageObject = imageObject;
        }
        f12252b.shareMessage(shareBuilder.getActivity(), weiboMultiMessage, true);
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onCancel() {
        d.f12255a.m(false, "WB_SHARE_CANCEL");
        EventBus.c().o(new ShareResultEvent(false));
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onComplete() {
        d.n(d.f12255a, true, null, 2, null);
        EventBus.c().o(new ShareResultEvent(true));
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onError(@Nullable UiError uiError) {
        j.f12332a.a("weibo", "share error ,info = " + (uiError != null ? uiError.errorMessage : null));
        d.f12255a.m(false, "WB_SHARE_FAIL");
        EventBus.c().o(new ShareResultEvent(false));
    }
}
