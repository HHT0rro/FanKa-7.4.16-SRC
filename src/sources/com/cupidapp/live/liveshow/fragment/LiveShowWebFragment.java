package com.cupidapp.live.liveshow.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.FKAlertLayout;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.b;
import com.huawei.quickcard.base.Attributes;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: LiveShowWebFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowWebFragment extends BaseAppCompatDialogFragment {

    /* renamed from: k */
    @NotNull
    public static final a f15059k = new a(null);

    /* renamed from: f */
    public int f15062f;

    /* renamed from: g */
    @Nullable
    public j f15063g;

    /* renamed from: i */
    @Nullable
    public AnimatorSet f15065i;

    /* renamed from: j */
    @NotNull
    public Map<Integer, View> f15066j = new LinkedHashMap();

    /* renamed from: d */
    public boolean f15060d = true;

    /* renamed from: e */
    @NotNull
    public final Lazy f15061e = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.liveshow.fragment.LiveShowWebFragment$showLoading$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            Bundle arguments = LiveShowWebFragment.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("SHOW_LOADING") : false);
        }
    });

    /* renamed from: h */
    public boolean f15064h = true;

    /* compiled from: LiveShowWebFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ LiveShowWebFragment b(a aVar, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            return aVar.a(str, z10);
        }

        @Nullable
        public final LiveShowWebFragment a(@Nullable String str, boolean z10) {
            if (str == null) {
                return null;
            }
            LiveShowWebFragment liveShowWebFragment = new LiveShowWebFragment();
            Bundle bundle = new Bundle();
            bundle.putString("LIVE_SHOW_WEB_URL", str);
            bundle.putBoolean("SHOW_LOADING", z10);
            liveShowWebFragment.setArguments(bundle);
            return liveShowWebFragment;
        }
    }

    /* compiled from: LiveShowWebFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements b.a {
        public b() {
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void a(@Nullable WebView webView, int i10, boolean z10) {
            b.a.C0148a.a(this, webView, i10, z10);
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void b(int i10) {
            if (LiveShowWebFragment.this.f15064h) {
                if (LiveShowWebFragment.this.a1()) {
                    LiveShowWebFragment.this.f1();
                }
                if (i10 == 100) {
                    if (LiveShowWebFragment.this.a1()) {
                        LiveShowWebFragment.this.b1();
                        LiveShowWebFragment.this.Z0();
                    } else {
                        LiveShowWebFragment.this.d1();
                    }
                    LiveShowWebFragment.this.f15064h = false;
                }
            }
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void c(@NotNull String str) {
            b.a.C0148a.b(this, str);
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment
    public void N0() {
        this.f15066j.clear();
    }

    @Override // com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment
    public boolean O0() {
        return this.f15060d;
    }

    @Nullable
    public View Q0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15066j;
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

    public final void Y0() {
        View blank_view = Q0(R$id.blank_view);
        s.h(blank_view, "blank_view");
        y.d(blank_view, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fragment.LiveShowWebFragment$bindClickEvent$1
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
                LiveShowWebFragment.this.dismiss();
            }
        });
    }

    public final void Z0() {
        AnimatorSet animatorSet = new AnimatorSet();
        int i10 = R$id.live_show_web_view;
        animatorSet.play(ObjectAnimator.ofFloat((FKWebView) Q0(i10), (Property<FKWebView, Float>) View.TRANSLATION_Y, this.f15062f, 0.0f)).with(ObjectAnimator.ofFloat((FKWebView) Q0(i10), (Property<FKWebView, Float>) View.ALPHA, 0.0f, 1.0f));
        animatorSet.setDuration(200L);
        this.f15065i = animatorSet;
        animatorSet.start();
    }

    public final boolean a1() {
        return ((Boolean) this.f15061e.getValue()).booleanValue();
    }

    public final void b1() {
        Dialog dialog;
        Window window;
        if (!a1() || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        FKAlertLayout.f12456d.d(window);
    }

    public final void c1() {
        String string;
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.o(dialog, true, 0, 2, null);
        }
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("LIVE_SHOW_WEB_URL")) == null) {
            return;
        }
        if (a1()) {
            d1();
        }
        String queryParameter = Uri.parse(string).getQueryParameter(Attributes.Style.ASPECT_RATIO);
        Float valueOf = queryParameter != null ? Float.valueOf(Float.parseFloat(queryParameter)) : null;
        int l10 = h.l(this);
        int k10 = h.k(this);
        float f10 = l10;
        float f11 = k10 / f10;
        if (valueOf == null) {
            k10 = (int) ((k10 / 3) * 2.0f);
        } else if (valueOf.floatValue() < f11) {
            k10 = (int) (f10 * valueOf.floatValue());
        }
        this.f15062f = k10;
        int i10 = R$id.live_show_web_view;
        FKWebView live_show_web_view = (FKWebView) Q0(i10);
        s.h(live_show_web_view, "live_show_web_view");
        y.o(live_show_web_view, null, Integer.valueOf(this.f15062f), 1, null);
        FKWebView live_show_web_view2 = (FKWebView) Q0(i10);
        s.h(live_show_web_view2, "live_show_web_view");
        FragmentActivity activity = getActivity();
        Lifecycle lifecycle = getLifecycle();
        s.h(lifecycle, "lifecycle");
        FKWebView.w(live_show_web_view2, activity, lifecycle, null, null, 12, null);
        j jVar = this.f15063g;
        if (jVar != null) {
            Lifecycle lifecycle2 = getLifecycle();
            s.h(lifecycle2, "lifecycle");
            jVar.f(lifecycle2, null);
        }
        j jVar2 = this.f15063g;
        if (jVar2 != null) {
            ((FKWebView) Q0(i10)).q(jVar2);
        }
        ((FKWebView) Q0(i10)).setLoadProgressListener(new b());
        ((FKWebView) Q0(i10)).stopLoading();
        ((FKWebView) Q0(i10)).u(string);
        if (a1()) {
            return;
        }
        Z0();
    }

    public final void d1() {
        FKWebView fKWebView = (FKWebView) Q0(R$id.live_show_web_view);
        fKWebView.setBackgroundColor(0);
        fKWebView.getBackground().setAlpha(0);
    }

    public final void e1(@NotNull FragmentManager manager) {
        s.i(manager, "manager");
        show(manager, LiveShowWebFragment.class.getSimpleName());
    }

    public final void f1() {
        Dialog dialog;
        Window window;
        if (!a1() || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        FKAlertLayout.f12456d.b(window).e();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        s.i(context, "context");
        super.onAttach(context);
        this.f15063g = new j(context);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_liveshow_web, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        AnimatorSet animatorSet = this.f15065i;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f15065i = null;
        N0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
    }

    @Override // com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        c1();
        Y0();
    }
}
