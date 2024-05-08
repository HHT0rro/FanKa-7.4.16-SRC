package com.cupidapp.live.base.router.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.cupidapp.live.base.router.helper.WebActionSnapWebContentHelper;
import com.cupidapp.live.base.router.helper.WebActionUploadImageHelper;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.fragment.ShareBottomFragment;
import com.cupidapp.live.base.share.fragment.ShareModel;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.activity.FKBaseWebActivity;
import com.cupidapp.live.base.web.activity.FKTransparentWebActivity;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import com.cupidapp.live.consult.activity.BaseConsultActivity;
import com.cupidapp.live.liveshow.activity.FKBaseLiveActivity;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.mediapicker.helper.VideoTrimUtil;
import com.cupidapp.live.setting.view.OpenNotificationLayout;
import com.tencent.connect.common.Constants;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebActionJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WebActionJumper implements com.cupidapp.live.base.router.h, com.cupidapp.live.base.activity.b, LifecycleObserver {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public WebActionUploadImageHelper f12163b;

    public static /* synthetic */ void c(WebActionJumper webActionJumper, Activity activity, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        webActionJumper.b(activity, z10);
    }

    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        FragmentActivity fragmentActivity;
        FKWebView c4;
        kotlin.jvm.internal.s.i(uri, "uri");
        com.cupidapp.live.base.utils.j.f12332a.a("WebActionJumper", "jump uri:" + ((Object) uri));
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return;
        }
        String path = uri.getPath();
        String A = path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null;
        if (A != null) {
            switch (A.hashCode()) {
                case -1878830771:
                    if (A.equals("shareToPlatform")) {
                        f(activity, uri);
                        return;
                    }
                    return;
                case -1424975841:
                    if (A.equals("goSystemPushSetting")) {
                        com.cupidapp.live.base.utils.r0.f12373a.c(context);
                        return;
                    }
                    return;
                case -1263210762:
                    if (A.equals("openNew")) {
                        e(activity, uri);
                        return;
                    }
                    return;
                case -446402065:
                    if (A.equals("snapWebContent")) {
                        fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
                        if (fragmentActivity != null) {
                            WebActionSnapWebContentHelper.f12130a.j(fragmentActivity, uri);
                            return;
                        }
                        return;
                    }
                    return;
                case 3015911:
                    if (A.equals(com.alipay.sdk.widget.j.f4804j) && (c4 = FKWebViewFragment.f13075p.c(activity)) != null) {
                        c4.goBack();
                        return;
                    }
                    return;
                case 94756344:
                    if (A.equals("close")) {
                        b(activity, uri.getBooleanQueryParameter("newUserActivityAnimation", false));
                        return;
                    }
                    return;
                case 109400031:
                    if (A.equals("share")) {
                        fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
                        if (fragmentActivity != null) {
                            g(fragmentActivity, uri);
                            return;
                        }
                        return;
                    }
                    return;
                case 563519438:
                    if (A.equals("goPushSetting")) {
                        d(activity, uri);
                        return;
                    }
                    return;
                case 1044464602:
                    if (A.equals("uploadImage")) {
                        fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
                        if (fragmentActivity != null) {
                            WebActionUploadImageHelper webActionUploadImageHelper = new WebActionUploadImageHelper();
                            this.f12163b = webActionUploadImageHelper;
                            webActionUploadImageHelper.E(fragmentActivity, uri);
                            return;
                        }
                        return;
                    }
                    return;
                case 1427818632:
                    if (A.equals("download")) {
                        fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
                        if (fragmentActivity != null) {
                            com.cupidapp.live.base.router.helper.d.f12144a.c(fragmentActivity, uri);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void b(Activity activity, boolean z10) {
        if (activity instanceof FKBaseWebActivity) {
            ((FKBaseWebActivity) activity).l1();
            return;
        }
        if (activity instanceof FKBaseLiveActivity) {
            ((FKBaseLiveActivity) activity).m1();
        } else if (activity instanceof FKTransparentWebActivity) {
            ((FKTransparentWebActivity) activity).k1(z10);
        } else if (activity instanceof BaseConsultActivity) {
            ((BaseConsultActivity) activity).j1();
        }
    }

    public final void d(Activity activity, Uri uri) {
        String queryParameter = uri.getQueryParameter("callback");
        if (com.cupidapp.live.base.utils.r0.f12373a.a(activity)) {
            FKWebViewFragment.a.b(FKWebViewFragment.f13075p, activity, queryParameter, null, 4, null);
        } else {
            new OpenNotificationLayout(activity).f();
        }
    }

    public final void e(Activity activity, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        if (kotlin.jvm.internal.s.d(uri.getQueryParameter("closeFirst"), "1")) {
            c(this, activity, false, 2, null);
        }
        if (activity instanceof FKBaseLiveActivity) {
            EventBus.c().l(new FKLiveOpenWebFragmentEvent(queryParameter, false, 2, null));
        } else if (activity instanceof BaseConsultActivity) {
            ((BaseConsultActivity) activity).l1(queryParameter);
        } else {
            j.a.b(com.cupidapp.live.base.router.j.f12156c, activity, queryParameter, null, 4, null);
        }
    }

    public final void f(Activity activity, Uri uri) {
        com.cupidapp.live.base.share.helper.d dVar;
        ShareBuilder g3;
        SharePlatform a10 = SharePlatform.Companion.a(uri.getQueryParameter(Constants.PARAM_PLATFORM));
        if (a10 == null || (g3 = (dVar = com.cupidapp.live.base.share.helper.d.f12255a).g(uri, activity)) == null) {
            return;
        }
        dVar.o(a10, g3, SensorPosition.Web);
    }

    public final void g(FragmentActivity fragmentActivity, Uri uri) {
        ShareBuilder f10 = com.cupidapp.live.base.share.helper.d.f12255a.f(fragmentActivity, uri);
        if (f10 == null) {
            return;
        }
        ShareModel shareModel = new ShareModel(null, null, f10, null, null, SensorPosition.Web, null, null, null, null, null, 2011, null);
        ShareBottomFragment a10 = ShareBottomFragment.f12224k.a();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        kotlin.jvm.internal.s.h(supportFragmentManager, "activity.supportFragmentManager");
        ShareBottomFragment.w1(a10, supportFragmentManager, shareModel, null, 4, null);
    }

    @Override // com.cupidapp.live.base.activity.b
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        com.cupidapp.live.base.share.helper.d.f12255a.i(i10, i11, intent);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        VideoTrimUtil.f17238a.g();
    }
}
