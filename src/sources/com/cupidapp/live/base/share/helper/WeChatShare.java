package com.cupidapp.live.base.share.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.utils.j;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import z0.f;

/* compiled from: WeChatShare.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WeChatShare implements c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WeChatShare f12249a = new WeChatShare();

    /* compiled from: WeChatShare.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12250a;

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
            f12250a = iArr;
        }
    }

    @Override // com.cupidapp.live.base.share.helper.c
    public void a(@NotNull final ShareBuilder shareBuilder) {
        s.i(shareBuilder, "shareBuilder");
        String thumbnailUrl = shareBuilder.getThumbnailUrl();
        if (thumbnailUrl == null || thumbnailUrl.length() == 0) {
            Activity activity = shareBuilder.getActivity();
            Bitmap bitmap = BitmapFactory.decodeResource(activity != null ? activity.getResources() : null, shareBuilder.getThumbPlaceHolderResId());
            s.h(bitmap, "bitmap");
            e(shareBuilder, bitmap);
            return;
        }
        Activity activity2 = shareBuilder.getActivity();
        if (activity2 != null) {
            ImageLoaderUtil.c(ImageLoaderUtil.f11832a, activity2, thumbnailUrl, false, new Function1<Bitmap, p>() { // from class: com.cupidapp.live.base.share.helper.WeChatShare$share$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Bitmap bitmap2) {
                    invoke2(bitmap2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Bitmap bitmap2) {
                    s.i(bitmap2, "bitmap");
                    WeChatShare.f12249a.e(ShareBuilder.this, bitmap2);
                }
            }, 4, null);
        }
    }

    @Override // com.cupidapp.live.base.share.helper.c
    public void b(@NotNull ShareBuilder shareBuilder) {
        s.i(shareBuilder, "shareBuilder");
        if (TextUtils.isEmpty(shareBuilder.getPath())) {
            return;
        }
        try {
            WXImageObject wXImageObject = new WXImageObject(BitmapFactory.decodeFile(shareBuilder.getPath()));
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.message = wXMediaMessage;
            req.transaction = String.valueOf(System.currentTimeMillis());
            SharePlatform sharePlatform = shareBuilder.getSharePlatform();
            int i10 = sharePlatform == null ? -1 : a.f12250a[sharePlatform.ordinal()];
            if (i10 == 1) {
                req.scene = 0;
            } else if (i10 == 2) {
                req.scene = 1;
            }
            IWXAPI P = NetworkClient.f11868a.P(shareBuilder.getActivity());
            if (P != null) {
                P.sendReq(req);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final byte[] d(Bitmap bitmap) {
        int i10 = 100;
        byte[] c4 = f.c(bitmap, 100);
        j.f12332a.a("bmpToByteArray", "start size: " + c4.length);
        while (c4.length > 32768) {
            i10 -= i10 <= 10 ? 1 : 10;
            if (i10 <= 0) {
                break;
            }
            c4 = f.c(bitmap, i10);
            j.f12332a.a("bmpToByteArray", "end size: " + c4.length);
        }
        return c4;
    }

    public final void e(ShareBuilder shareBuilder, Bitmap bitmap) {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = shareBuilder.shareUrl();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.thumbData = d(bitmap);
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.description = shareBuilder.getDescription();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = wXMediaMessage;
        req.transaction = String.valueOf(System.currentTimeMillis());
        if (shareBuilder.getSharePlatform() == SharePlatform.WechatMoments) {
            req.scene = 1;
            wXMediaMessage.title = String.valueOf(shareBuilder.getTitle());
        } else {
            req.scene = 0;
            wXMediaMessage.title = String.valueOf(shareBuilder.getTitle());
        }
        IWXAPI P = NetworkClient.f11868a.P(shareBuilder.getActivity());
        if (P != null) {
            P.sendReq(req);
        }
    }
}
