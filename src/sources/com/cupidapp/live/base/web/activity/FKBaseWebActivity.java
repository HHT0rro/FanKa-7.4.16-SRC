package com.cupidapp.live.base.web.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.WebStyleEnum;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;

/* compiled from: FKBaseWebActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKBaseWebActivity extends FKBaseActivity implements FKWebViewFragment.b {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f13036s = new a(null);

    /* renamed from: t, reason: collision with root package name */
    public static boolean f13037t = true;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public FKWebViewFragment f13038q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13039r = new LinkedHashMap();

    /* compiled from: FKBaseWebActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {

        /* compiled from: FKBaseWebActivity.kt */
        @d
        /* renamed from: com.cupidapp.live.base.web.activity.FKBaseWebActivity$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public /* synthetic */ class C0147a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f13040a;

            static {
                int[] iArr = new int[WebStyleEnum.values().length];
                try {
                    iArr[WebStyleEnum.CardStyle.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WebStyleEnum.BottomToTopStyle.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[WebStyleEnum.RightToLeftStyle.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f13040a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return FKBaseWebActivity.f13037t;
        }

        public final void b(boolean z10) {
            FKBaseWebActivity.f13037t = z10;
        }

        public final void c(@Nullable Context context, @Nullable String str, @NotNull WebStyleViewModel webStyleViewModel) {
            s.i(webStyleViewModel, "webStyleViewModel");
            if (context != null) {
                if (str == null || str.length() == 0) {
                    return;
                }
                WebStyleEnum webStyle = webStyleViewModel.getWebStyle();
                int[] iArr = C0147a.f13040a;
                Intent intent = new Intent(context, (Class<?>) (iArr[webStyle.ordinal()] == 1 ? FKCardWebActivity.class : FKWebActivity.class));
                intent.putExtra("UrlKey", str);
                g.c(intent, webStyleViewModel);
                if (!webStyleViewModel.isShowCloseIcon()) {
                    intent.addFlags(536870912);
                }
                context.startActivity(intent);
                int i10 = iArr[webStyleViewModel.getWebStyle().ordinal()];
                if (i10 == 1) {
                    FKBaseActivity.f11750o.b(context, 0, 0);
                } else if (i10 == 2) {
                    FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
                }
            }
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.Web;
    }

    public void l1() {
    }

    @Nullable
    public final FKWebViewFragment m1() {
        return this.f13038q;
    }

    public final void n1(@Nullable FKWebViewFragment fKWebViewFragment) {
        this.f13038q = fKWebViewFragment;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        com.cupidapp.live.base.share.helper.d.f12255a.i(i10, i11, intent);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        WebView.enableSlowWholeDocumentDraw();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        String stringExtra = getIntent().getStringExtra("UrlKey");
        if (stringExtra != null) {
            EventBus.c().o(new CloseWebEvent(stringExtra));
        }
    }

    @Override // com.cupidapp.live.base.web.fragment.FKWebViewFragment.b
    public void v(@Nullable j jVar) {
        if (jVar != null) {
            Lifecycle lifecycle = getLifecycle();
            s.h(lifecycle, "lifecycle");
            jVar.f(lifecycle, O0());
        }
    }

    @Override // com.cupidapp.live.base.web.fragment.FKWebViewFragment.b
    public void y(@NotNull FKWebView appWebView) {
        s.i(appWebView, "appWebView");
        Lifecycle lifecycle = getLifecycle();
        s.h(lifecycle, "lifecycle");
        appWebView.v(this, lifecycle, O0(), P0());
    }
}
