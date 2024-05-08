package com.cupidapp.live.base.web.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.fragment.ShareBottomFragment;
import com.cupidapp.live.base.share.fragment.ShareModel;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.WebConfigViewModel;
import com.cupidapp.live.base.web.b;
import com.cupidapp.live.base.web.model.ReloadWebPageEvent;
import com.cupidapp.live.base.web.model.ShowWebShareDialogEvent;
import com.cupidapp.live.base.web.model.WebShareModel;
import com.cupidapp.live.base.web.view.FKWebProgressBar;
import com.cupidapp.live.match.view.CommonFaultPromptLayout;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import j1.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.h0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;

/* compiled from: FKWebViewFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKWebViewFragment extends FKBaseFragment implements FKWebView.c {

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public static final a f13075p = new a(null);

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public b f13079h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public String f13080i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public j f13081j;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Function0<p> f13083l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public o f13084m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13085n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13086o = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f13076e = kotlin.c.b(new Function0<WebConfigViewModel>() { // from class: com.cupidapp.live.base.web.fragment.FKWebViewFragment$webConfigViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final WebConfigViewModel invoke() {
            WebConfigViewModel webConfigViewModel;
            Bundle arguments = FKWebViewFragment.this.getArguments();
            return (arguments == null || (webConfigViewModel = (WebConfigViewModel) g.b(arguments, WebConfigViewModel.class)) == null) ? new WebConfigViewModel(false, false, false, false, false, null, false, 127, null) : webConfigViewModel;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    public boolean f13077f = true;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f13078g = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.base.web.fragment.FKWebViewFragment$webUrl$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            Bundle arguments = FKWebViewFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getString("URL_BUNDLE_KEY");
            }
            return null;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final i f13082k = new i();

    /* compiled from: FKWebViewFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Activity activity, String str, String str2, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str2 = null;
            }
            aVar.a(activity, str, str2);
        }

        public static /* synthetic */ FKWebViewFragment e(a aVar, String str, b bVar, WebConfigViewModel webConfigViewModel, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                bVar = null;
            }
            return aVar.d(str, bVar, webConfigViewModel);
        }

        public final void a(@NotNull Activity activity, @Nullable String str, @Nullable String str2) {
            FKWebView c4;
            s.i(activity, "activity");
            if ((str == null || str.length() == 0) || (c4 = c(activity)) == null) {
                return;
            }
            c4.evaluateJavascript(str + "(" + str2 + ")", null);
        }

        @Nullable
        public final FKWebView c(@NotNull Activity activity) {
            s.i(activity, "activity");
            return (FKWebView) activity.findViewById(R$id.appWebView);
        }

        @NotNull
        public final FKWebViewFragment d(@Nullable String str, @Nullable b bVar, @NotNull WebConfigViewModel webConfigViewModel) {
            s.i(webConfigViewModel, "webConfigViewModel");
            FKWebViewFragment fKWebViewFragment = new FKWebViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("URL_BUNDLE_KEY", str);
            g.d(bundle, webConfigViewModel);
            fKWebViewFragment.setArguments(bundle);
            fKWebViewFragment.f13079h = bVar;
            return fKWebViewFragment;
        }
    }

    /* compiled from: FKWebViewFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void v(@Nullable j jVar);

        void y(@NotNull FKWebView fKWebView);
    }

    /* compiled from: FKWebViewFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements o.c {
        public c() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            k.b(k.f50238a, SensorPosition.Web, null, null, j10, 6, null);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            s.i(imageUriString, "imageUriString");
            FKWebViewFragment fKWebViewFragment = FKWebViewFragment.this;
            fKWebViewFragment.h1(fKWebViewFragment.f13080i, z10);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13086o.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return d1().getCurrentFragmentPageName();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13086o;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b1(String str) {
        FragmentActivity activity;
        if (str == null) {
            return;
        }
        Uri parse = Uri.parse(str);
        boolean d10 = s.d(parse.getQueryParameter("hideNavi"), "true");
        String queryParameter = parse.getQueryParameter("statusBarStyle");
        String queryParameter2 = parse.getQueryParameter("loadingBackgroundColor");
        String queryParameter3 = parse.getQueryParameter("statusBarColor");
        int i10 = 0;
        boolean z10 = d1().getShowTitleBar() && !d10;
        this.f13077f = z10;
        if (z10) {
            int i11 = R$id.webTitleLayout;
            ((FKTitleBarLayout) S0(i11)).setVisibility(0);
            ((FKTitleBarLayout) S0(i11)).k();
        } else {
            ((FKTitleBarLayout) S0(R$id.webTitleLayout)).setVisibility(8);
        }
        if (d10 && d1().getAgreeUrlConfigStatusBar() && (activity = getActivity()) != null) {
            boolean d11 = s.d(queryParameter, WbCloudFaceContant.WHITE);
            if (queryParameter3 != null) {
                i10 = h.b(queryParameter3);
            } else if (queryParameter2 != null) {
                i10 = h.b(queryParameter2);
            }
            p0.b(activity, d11, i10);
        }
        ((FKWebView) S0(R$id.appWebView)).setBackgroundColor(queryParameter2 != null ? h.b(queryParameter2) : -1);
    }

    public final void c1(final String str, String str2) {
        final Uri parse = Uri.parse(str);
        if (!parse.getBooleanQueryParameter("showShareButton", false)) {
            ((FKTitleBarLayout) S0(R$id.webTitleLayout)).setRightImageVisible(false);
            return;
        }
        Context context = getContext();
        if (!(str2 == null || str2.length() == 0) && context != null) {
            Drawable b4 = z0.i.f54815a.b(ContextCompat.getDrawable(context, R$mipmap.icon_feed_share), h.b(str2));
            if (b4 != null) {
                ((FKTitleBarLayout) S0(R$id.webTitleLayout)).setRightImageDrawable(b4);
            }
        } else {
            ((FKTitleBarLayout) S0(R$id.webTitleLayout)).setRightImageRes(Integer.valueOf(R$mipmap.icon_feed_share));
        }
        int i10 = R$id.webTitleLayout;
        ((FKTitleBarLayout) S0(i10)).setRightImageVisible(true);
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ((FKTitleBarLayout) S0(i10)).setRightImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.base.web.fragment.FKWebViewFragment$configWebTitleRightShareBtn$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                String queryParameter = parse.getQueryParameter("shareOriginUrl");
                if (queryParameter == null) {
                    queryParameter = str;
                }
                s.h(queryParameter, "uri.getQueryParameter(\"shareOriginUrl\") ?: url");
                WebShareModel f10 = ((FKWebView) this.S0(R$id.appWebView)).getH5CallNativeHelper().f();
                this.k1(new ShareModel(null, null, com.cupidapp.live.base.share.helper.d.f12255a.h(activity, queryParameter, f10), null, null, SensorPosition.Web, null, null, f10 != null ? f10.getNotShowPlatformTypes() : null, null, null, 1755, null));
            }
        });
    }

    public final WebConfigViewModel d1() {
        return (WebConfigViewModel) this.f13076e.getValue();
    }

    @Nullable
    public final Function0<p> e1() {
        return this.f13083l;
    }

    public final String f1() {
        return (String) this.f13078g.getValue();
    }

    public final void g1(@Nullable String str) {
        int i10 = R$id.appWebView;
        ((FKWebView) S0(i10)).stopLoading();
        ((FKWebView) S0(i10)).u(str);
    }

    public final void h1(String str, boolean z10) {
        if (str == null) {
            k.f50238a.e("WebView", z10);
        } else {
            k.f50238a.e(str, z10);
        }
    }

    public final void i1() {
        Context context = getContext();
        if (context != null) {
            o c4 = o.f12354i.c(context);
            this.f13084m = c4;
            if (c4 != null) {
                c4.l(new c());
            }
        }
    }

    public final void j1(@Nullable Function0<p> function0) {
        this.f13083l = function0;
    }

    public final void k1(ShareModel shareModel) {
        ShareBottomFragment a10 = ShareBottomFragment.f12224k.a();
        FragmentManager childFragmentManager = getChildFragmentManager();
        s.h(childFragmentManager, "childFragmentManager");
        ShareBottomFragment.w1(a10, childFragmentManager, shareModel, null, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        s.i(context, "context");
        super.onAttach(context);
        this.f13081j = new j(context);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean onBackPressed() {
        return ((FKWebView) S0(R$id.appWebView)).a();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_web, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ReloadWebPageEvent event) {
        s.i(event, "event");
        ((FKWebView) S0(R$id.appWebView)).reload();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ((FKWebProgressBar) S0(R$id.progressBar)).d();
        this.f13082k.g();
        o oVar = this.f13084m;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f13085n) {
            g1(f1());
            this.f13085n = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        o oVar = this.f13084m;
        if (oVar != null) {
            oVar.m();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        this.f13085n = d1().getOnResumeLoad();
        int i10 = R$id.webTitleLayout;
        ((FKTitleBarLayout) S0(i10)).setLeftImageVisible(d1().isShowCloseIcon());
        i1();
        b bVar = this.f13079h;
        if (bVar != null) {
            if (bVar != null) {
                FKWebView appWebView = (FKWebView) S0(R$id.appWebView);
                s.h(appWebView, "appWebView");
                bVar.y(appWebView);
            }
            b bVar2 = this.f13079h;
            if (bVar2 != null) {
                bVar2.v(this.f13081j);
            }
        } else {
            FKWebView appWebView2 = (FKWebView) S0(R$id.appWebView);
            s.h(appWebView2, "appWebView");
            FragmentActivity activity = getActivity();
            Lifecycle lifecycle = getLifecycle();
            s.h(lifecycle, "lifecycle");
            FKWebView.w(appWebView2, activity, lifecycle, null, null, 12, null);
            j jVar = this.f13081j;
            if (jVar != null) {
                Lifecycle lifecycle2 = getLifecycle();
                s.h(lifecycle2, "lifecycle");
                jVar.f(lifecycle2, null);
            }
        }
        b1(f1());
        int i11 = R$id.appWebView;
        ((FKWebView) S0(i11)).setWebTitleBarConfigListener(this);
        j jVar2 = this.f13081j;
        if (jVar2 != null) {
            ((FKWebView) S0(i11)).q(jVar2);
        }
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ((FKWebView) S0(i11)).setLoadProgressListener(new b.a() { // from class: com.cupidapp.live.base.web.fragment.FKWebViewFragment$onViewCreated$2
            @Override // com.cupidapp.live.base.web.b.a
            public void a(@Nullable final WebView webView, int i12, boolean z10) {
                i iVar;
                WebConfigViewModel d12;
                FKWebViewFragment fKWebViewFragment = FKWebViewFragment.this;
                int i13 = R$id.progressBar;
                if (((FKWebProgressBar) fKWebViewFragment.S0(i13)) == null) {
                    return;
                }
                if (((FKWebProgressBar) FKWebViewFragment.this.S0(i13)).getVisibility() != 0 && i12 != 0) {
                    d12 = FKWebViewFragment.this.d1();
                    if (d12.getShowLoadingProgressBar()) {
                        ((FKWebProgressBar) FKWebViewFragment.this.S0(i13)).setVisibility(0);
                    }
                }
                if (i12 == 0) {
                    return;
                }
                FKWebProgressBar fKWebProgressBar = (FKWebProgressBar) FKWebViewFragment.this.S0(i13);
                final FKWebViewFragment fKWebViewFragment2 = FKWebViewFragment.this;
                fKWebProgressBar.i(i12, new Function0<p>() { // from class: com.cupidapp.live.base.web.fragment.FKWebViewFragment$onViewCreated$2$onProgress$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ p invoke() {
                        invoke2();
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        WebView webView2 = WebView.this;
                        if (webView2 != null) {
                            webView2.setVisibility(0);
                        }
                        FKWebProgressBar fKWebProgressBar2 = (FKWebProgressBar) fKWebViewFragment2.S0(R$id.progressBar);
                        if (fKWebProgressBar2 != null) {
                            fKWebProgressBar2.d();
                        }
                    }
                });
                Context context = FKWebViewFragment.this.getContext();
                if ((context != null ? z0.h.g(context) : null) == NetworkStateConstants.DISCONNECT) {
                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                    if (ref$BooleanRef2.element) {
                        return;
                    }
                    ref$BooleanRef2.element = true;
                    if (webView != null) {
                        webView.setVisibility(8);
                    }
                    iVar = FKWebViewFragment.this.f13082k;
                    final FKWebViewFragment fKWebViewFragment3 = FKWebViewFragment.this;
                    final Ref$BooleanRef ref$BooleanRef3 = ref$BooleanRef;
                    Function0<p> function0 = new Function0<p>() { // from class: com.cupidapp.live.base.web.fragment.FKWebViewFragment$onViewCreated$2$onProgress$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ p invoke() {
                            invoke2();
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ((FKWebProgressBar) FKWebViewFragment.this.S0(R$id.progressBar)).d();
                            FKWebViewFragment fKWebViewFragment4 = FKWebViewFragment.this;
                            int i14 = R$id.netErrorLayout;
                            ((CommonFaultPromptLayout) fKWebViewFragment4.S0(i14)).setVisibility(0);
                            CommonFaultPromptLayout commonFaultPromptLayout = (CommonFaultPromptLayout) FKWebViewFragment.this.S0(i14);
                            String string = FKWebViewFragment.this.getString(R$string.unable_to_connect_to_server);
                            s.h(string, "getString(R.string.unable_to_connect_to_server)");
                            String string2 = FKWebViewFragment.this.getString(R$string.internet_is_unavailable);
                            String string3 = FKWebViewFragment.this.getString(R$string.reload);
                            final FKWebViewFragment fKWebViewFragment5 = FKWebViewFragment.this;
                            final Ref$BooleanRef ref$BooleanRef4 = ref$BooleanRef3;
                            commonFaultPromptLayout.b(string, string2, string3, new Function0<p>() { // from class: com.cupidapp.live.base.web.fragment.FKWebViewFragment$onViewCreated$2$onProgress$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ p invoke() {
                                    invoke2();
                                    return p.f51048a;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    String f12;
                                    ((CommonFaultPromptLayout) FKWebViewFragment.this.S0(R$id.netErrorLayout)).setVisibility(8);
                                    ref$BooleanRef4.element = false;
                                    FKWebViewFragment fKWebViewFragment6 = FKWebViewFragment.this;
                                    f12 = fKWebViewFragment6.f1();
                                    fKWebViewFragment6.g1(f12);
                                    ((FKWebView) FKWebViewFragment.this.S0(R$id.appWebView)).setVisibility(4);
                                }
                            });
                        }
                    };
                    final FKWebViewFragment fKWebViewFragment4 = FKWebViewFragment.this;
                    iVar.c(40, 1, function0, new Function1<Integer, p>() { // from class: com.cupidapp.live.base.web.fragment.FKWebViewFragment$onViewCreated$2$onProgress$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(Integer num) {
                            invoke(num.intValue());
                            return p.f51048a;
                        }

                        public final void invoke(int i14) {
                            String f12;
                            i iVar2;
                            Context context2 = FKWebViewFragment.this.getContext();
                            if ((context2 != null ? z0.h.g(context2) : null) != NetworkStateConstants.WIFI) {
                                Context context3 = FKWebViewFragment.this.getContext();
                                if ((context3 != null ? z0.h.g(context3) : null) != NetworkStateConstants.MOBILE) {
                                    return;
                                }
                            }
                            FKWebViewFragment fKWebViewFragment5 = FKWebViewFragment.this;
                            f12 = fKWebViewFragment5.f1();
                            fKWebViewFragment5.g1(f12);
                            iVar2 = FKWebViewFragment.this.f13082k;
                            iVar2.g();
                        }
                    });
                }
            }

            @Override // com.cupidapp.live.base.web.b.a
            public void b(int i12) {
            }

            @Override // com.cupidapp.live.base.web.b.a
            public void c(@NotNull String title) {
                s.i(title, "title");
                FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) FKWebViewFragment.this.S0(R$id.webTitleLayout);
                if (fKTitleBarLayout != null) {
                    FKTitleBarLayout.setSingleTitle$default(fKTitleBarLayout, title, null, 2, null);
                }
                FKWebViewFragment.this.f13080i = title;
            }
        });
        if (!this.f13085n) {
            g1(f1());
        }
        ((FKTitleBarLayout) S0(i10)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.base.web.fragment.FKWebViewFragment$onViewCreated$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view2) {
                invoke2(view2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                if (FKWebViewFragment.this.e1() != null) {
                    Function0<p> e12 = FKWebViewFragment.this.e1();
                    if (e12 != null) {
                        e12.invoke();
                        return;
                    }
                    return;
                }
                FragmentActivity activity2 = FKWebViewFragment.this.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        });
    }

    @Override // com.cupidapp.live.base.web.FKWebView.c
    public void s0(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        int i10 = R$id.webTitleLayout;
        if (((FKTitleBarLayout) S0(i10)) != null && this.f13077f) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("fgColor");
            String queryParameter2 = parse.getQueryParameter("bgColor");
            if (!(queryParameter == null || queryParameter.length() == 0)) {
                int b4 = h.b(queryParameter);
                ((FKTitleBarLayout) S0(i10)).setTitleTextColor(b4);
                Context context = getContext();
                if (context != null) {
                    Drawable b10 = z0.i.f54815a.b(ContextCompat.getDrawable(context, R$mipmap.close_black), b4);
                    if (b10 != null) {
                        ((FKTitleBarLayout) S0(i10)).setLeftImageDrawable(b10);
                    }
                }
            }
            if (!(queryParameter2 == null || queryParameter2.length() == 0)) {
                ((FKTitleBarLayout) S0(i10)).setTitleBackgroundColor(h.b(queryParameter2));
            }
            c1(str, queryParameter);
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowWebShareDialogEvent event) {
        s.i(event, "event");
        WebShareModel shareModel = event.getShareModel();
        if (getActivity() != null) {
            String url = shareModel.getUrl();
            if (!(url == null || url.length() == 0)) {
                com.cupidapp.live.base.share.helper.d dVar = com.cupidapp.live.base.share.helper.d.f12255a;
                FragmentActivity requireActivity = requireActivity();
                s.h(requireActivity, "requireActivity()");
                k1(new ShareModel(null, null, dVar.h(requireActivity, shareModel.getUrl(), shareModel), null, null, SensorPosition.Web, null, null, shareModel.getNotShowPlatformTypes(), null, h0.d(f.a(ShareOperateType.CLUB, shareModel.getClubActivityInfo())), MetricsProto.MetricsEvent.ACTION_PERMISSION_GRANT_WRITE_EXTERNAL_STORAGE, null));
            }
        }
    }
}
