package com.cupidapp.live.base.web.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.baidu.mobads.sdk.internal.cj;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.b;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKTransparentWebFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKTransparentWebFragment extends FKBaseFragment {

    /* renamed from: l */
    @NotNull
    public static final a f13065l = new a(null);

    /* renamed from: f */
    @Nullable
    public j f13067f;

    /* renamed from: g */
    @Nullable
    public FKWebViewFragment.b f13068g;

    /* renamed from: j */
    @Nullable
    public b f13071j;

    /* renamed from: k */
    @NotNull
    public Map<Integer, View> f13072k = new LinkedHashMap();

    /* renamed from: e */
    @NotNull
    public final Lazy f13066e = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.base.web.fragment.FKTransparentWebFragment$mUrl$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            Bundle arguments = FKTransparentWebFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getString("TRANSPARENT_URL");
            }
            return null;
        }
    });

    /* renamed from: h */
    public boolean f13069h = true;

    /* renamed from: i */
    public boolean f13070i = true;

    /* compiled from: FKTransparentWebFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FKTransparentWebFragment b(a aVar, String str, FKWebViewFragment.b bVar, b bVar2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                bVar = null;
            }
            return aVar.a(str, bVar, bVar2);
        }

        @NotNull
        public final FKTransparentWebFragment a(@Nullable String str, @Nullable FKWebViewFragment.b bVar, @NotNull b loadListener) {
            s.i(loadListener, "loadListener");
            FKTransparentWebFragment fKTransparentWebFragment = new FKTransparentWebFragment();
            Bundle bundle = new Bundle();
            bundle.putString("TRANSPARENT_URL", str);
            fKTransparentWebFragment.setArguments(bundle);
            fKTransparentWebFragment.f13068g = bVar;
            fKTransparentWebFragment.f13071j = loadListener;
            return fKTransparentWebFragment;
        }
    }

    /* compiled from: FKTransparentWebFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(boolean z10);
    }

    /* compiled from: FKTransparentWebFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements b.a {
        public c() {
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void a(@Nullable WebView webView, int i10, boolean z10) {
            b.a.C0148a.a(this, webView, i10, z10);
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void b(int i10) {
            if (FKTransparentWebFragment.this.f13069h) {
                FKTransparentWebFragment.this.R0();
                j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
                aVar.a("FKTransparentWebFragment", "onProgress progress: " + i10);
                if (i10 == 100) {
                    FKTransparentWebFragment.this.f13069h = false;
                    FKTransparentWebFragment.this.Q0();
                    aVar.a("FKTransparentWebFragment", "onProgress isLoadSuccess: " + FKTransparentWebFragment.this.f13070i);
                    if (FKTransparentWebFragment.this.f13070i) {
                        b bVar = FKTransparentWebFragment.this.f13071j;
                        if (bVar != null) {
                            bVar.a(true);
                            return;
                        }
                        return;
                    }
                    h.f12779a.r(FKTransparentWebFragment.this.getContext(), R$string.web_load_failed);
                    b bVar2 = FKTransparentWebFragment.this.f13071j;
                    if (bVar2 != null) {
                        bVar2.a(false);
                    }
                }
            }
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void c(@NotNull String title) {
            s.i(title, "title");
            com.cupidapp.live.base.utils.j.f12332a.a("FKTransparentWebFragment", "onReceivedTitle title: " + title);
            if (!StringsKt__StringsKt.K(title, cj.f10033b, false, 2, null) && !StringsKt__StringsKt.K(title, "500", false, 2, null)) {
                Locale locale = Locale.getDefault();
                s.h(locale, "getDefault()");
                String lowerCase = title.toLowerCase(locale);
                s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!StringsKt__StringsKt.K(lowerCase, "error", false, 2, null)) {
                    return;
                }
            }
            FKTransparentWebFragment.this.f13070i = false;
        }
    }

    /* compiled from: FKTransparentWebFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements FKWebView.b {
        public d() {
        }

        @Override // com.cupidapp.live.base.web.FKWebView.b
        public void a(boolean z10) {
            com.cupidapp.live.base.utils.j.f12332a.a("FKTransparentWebFragment", "loadSuccess isLoadSuccess: " + FKTransparentWebFragment.this.f13070i + " success: " + z10);
            if (FKTransparentWebFragment.this.f13070i) {
                FKTransparentWebFragment.this.f13070i = z10;
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13072k.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13072k;
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

    public final String a1() {
        return (String) this.f13066e.getValue();
    }

    public final void b1() {
        int i10 = R$id.appWebView;
        ((FKWebView) S0(i10)).stopLoading();
        ((FKWebView) S0(i10)).u(a1());
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        s.i(context, "context");
        super.onAttach(context);
        this.f13067f = new com.cupidapp.live.base.router.j(context);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_transparent_web, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Q0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        int i10 = R$id.appWebView;
        FKWebView fKWebView = (FKWebView) S0(i10);
        fKWebView.setBackgroundColor(0);
        fKWebView.getBackground().setAlpha(0);
        FKWebViewFragment.b bVar = this.f13068g;
        if (bVar != null) {
            s.f(bVar);
            FKWebView appWebView = (FKWebView) S0(i10);
            s.h(appWebView, "appWebView");
            bVar.y(appWebView);
            FKWebViewFragment.b bVar2 = this.f13068g;
            s.f(bVar2);
            bVar2.v(this.f13067f);
        } else {
            FKWebView appWebView2 = (FKWebView) S0(i10);
            s.h(appWebView2, "appWebView");
            FragmentActivity activity = getActivity();
            Lifecycle lifecycle = getLifecycle();
            s.h(lifecycle, "lifecycle");
            FKWebView.w(appWebView2, activity, lifecycle, null, null, 12, null);
            com.cupidapp.live.base.router.j jVar = this.f13067f;
            if (jVar != null) {
                Lifecycle lifecycle2 = getLifecycle();
                s.h(lifecycle2, "lifecycle");
                jVar.f(lifecycle2, null);
            }
        }
        com.cupidapp.live.base.router.j jVar2 = this.f13067f;
        if (jVar2 != null) {
            ((FKWebView) S0(i10)).q(jVar2);
        }
        ((FKWebView) S0(i10)).setLoadProgressListener(new c());
        ((FKWebView) S0(i10)).setWebLoadStateListener(new d());
        b1();
    }
}
