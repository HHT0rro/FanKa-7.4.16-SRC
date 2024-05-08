package com.cupidapp.live.base.share.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.share.helper.QQShare$listener$2;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.view.h;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.f;
import z0.k;

/* compiled from: QQShare.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class QQShare implements c {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Tencent f12246b;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQShare f12245a = new QQShare();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Lazy f12247c = kotlin.c.b(new Function0<QQShare$listener$2.a>() { // from class: com.cupidapp.live.base.share.helper.QQShare$listener$2

        /* compiled from: QQShare.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a implements IUiListener {
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                d.f12255a.m(false, "QQ_USER_CANCEL");
                EventBus.c().o(new ShareResultEvent(false));
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(@Nullable Object obj) {
                d.n(d.f12255a, true, null, 2, null);
                EventBus.c().o(new ShareResultEvent(true));
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(@Nullable UiError uiError) {
                d dVar = d.f12255a;
                Integer valueOf = uiError != null ? Integer.valueOf(uiError.errorCode) : null;
                dVar.m(false, "QQ_ERROR_" + ((Object) valueOf) + "_" + (uiError != null ? uiError.errorMessage : null));
                EventBus.c().o(new ShareResultEvent(false));
            }

            @Override // com.tencent.tauth.IUiListener
            public void onWarning(int i10) {
                EventBus.c().o(new ShareResultEvent(false));
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final a invoke() {
            return new a();
        }
    });

    /* compiled from: QQShare.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12248a;

        static {
            int[] iArr = new int[SharePlatform.values().length];
            try {
                iArr[SharePlatform.QQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SharePlatform.QZone.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f12248a = iArr;
        }
    }

    @Override // com.cupidapp.live.base.share.helper.c
    public void a(@NotNull ShareBuilder shareBuilder) {
        s.i(shareBuilder, "shareBuilder");
        if (shareBuilder.getSharePlatform() == SharePlatform.QZone) {
            h(shareBuilder, d());
        } else {
            g(shareBuilder, d());
        }
    }

    @Override // com.cupidapp.live.base.share.helper.c
    public void b(@NotNull ShareBuilder shareBuilder) {
        s.i(shareBuilder, "shareBuilder");
        if (TextUtils.isEmpty(shareBuilder.getPath())) {
            return;
        }
        SharePlatform sharePlatform = shareBuilder.getSharePlatform();
        int i10 = sharePlatform == null ? -1 : a.f12248a[sharePlatform.ordinal()];
        if (i10 == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("req_type", 5);
            Activity activity = shareBuilder.getActivity();
            bundle.putString("appName", activity != null ? activity.getString(R$string.finka_app_name) : null);
            bundle.putString("imageLocalUrl", shareBuilder.getPath());
            bundle.putInt("cflag", 2);
            Tencent c4 = c(shareBuilder.getActivity());
            if (c4 != null) {
                c4.shareToQQ(shareBuilder.getActivity(), bundle, d());
                return;
            }
            return;
        }
        if (i10 != 2) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("req_type", 5);
        bundle2.putString("imageLocalUrl", shareBuilder.getPath());
        Activity activity2 = shareBuilder.getActivity();
        bundle2.putString("appName", activity2 != null ? activity2.getString(R$string.finka_app_name) : null);
        bundle2.putInt("cflag", 1);
        Tencent c10 = c(shareBuilder.getActivity());
        if (c10 != null) {
            c10.shareToQQ(shareBuilder.getActivity(), bundle2, d());
        }
    }

    public final Tencent c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (f12246b == null) {
                f12246b = Tencent.createInstance("1110527912", context.getApplicationContext(), "com.cupidapp.live");
            }
            Tencent tencent = f12246b;
            boolean z10 = true;
            if (tencent == null || !tencent.isQQInstalled(context)) {
                z10 = false;
            }
            if (z10) {
                return f12246b;
            }
            h.f12779a.r(context, R$string.install_qq_please);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            h.f12779a.r(context, R$string.install_qq_please);
            return null;
        }
    }

    public final QQShare$listener$2.a d() {
        return (QQShare$listener$2.a) f12247c.getValue();
    }

    public final String e(ShareBuilder shareBuilder) {
        String thumbnailUrl = shareBuilder.getThumbnailUrl();
        if (!(thumbnailUrl == null || thumbnailUrl.length() == 0)) {
            return thumbnailUrl;
        }
        File i10 = k.f54819a.i(shareBuilder.getActivity(), "qq_share_thumb_image_logo.jpg");
        if (i10 == null) {
            return null;
        }
        Activity activity = shareBuilder.getActivity();
        Bitmap bitmap = BitmapFactory.decodeResource(activity != null ? activity.getResources() : null, shareBuilder.getThumbPlaceHolderResId());
        s.h(bitmap, "bitmap");
        f.f(bitmap, i10, 100);
        return i10.getAbsolutePath();
    }

    public final void f(int i10, int i11, @Nullable Intent intent) {
        Tencent.onActivityResultData(i10, i11, intent, d());
    }

    public final void g(ShareBuilder shareBuilder, IUiListener iUiListener) {
        Bundle bundle = new Bundle();
        boolean z10 = true;
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareBuilder.getTitle());
        bundle.putString("summary", shareBuilder.getDescription());
        bundle.putString("targetUrl", shareBuilder.shareUrl());
        String thumbnailUrl = shareBuilder.getThumbnailUrl();
        if (thumbnailUrl != null && thumbnailUrl.length() != 0) {
            z10 = false;
        }
        if (!z10) {
            bundle.putString("imageUrl", thumbnailUrl);
        }
        Activity activity = shareBuilder.getActivity();
        bundle.putString("appName", activity != null ? activity.getString(R$string.finka_app_name) : null);
        Tencent c4 = c(shareBuilder.getActivity());
        if (c4 != null) {
            c4.shareToQQ(shareBuilder.getActivity(), bundle, iUiListener);
        }
    }

    public final void h(ShareBuilder shareBuilder, IUiListener iUiListener) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareBuilder.getTitle());
        bundle.putString("summary", shareBuilder.getDescription());
        bundle.putString("targetUrl", shareBuilder.shareUrl());
        String e2 = f12245a.e(shareBuilder);
        if (!(e2 == null || e2.length() == 0)) {
            bundle.putStringArrayList("imageUrl", kotlin.collections.s.f(e2));
        }
        Tencent c4 = c(shareBuilder.getActivity());
        if (c4 != null) {
            c4.shareToQzone(shareBuilder.getActivity(), bundle, iUiListener);
        }
    }
}
