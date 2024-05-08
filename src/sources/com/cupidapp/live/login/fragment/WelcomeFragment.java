package com.cupidapp.live.login.fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.GuidHelper;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.safe.e;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.base.utils.o0;
import com.cupidapp.live.base.view.dialog.FKBottomLoft;
import com.cupidapp.live.login.activity.InputPhoneNumberActivity;
import com.cupidapp.live.login.fragment.WelcomeFragment;
import com.cupidapp.live.login.helper.LoginMethod;
import com.cupidapp.live.login.helper.OnePassLoginHelper;
import com.cupidapp.live.login.helper.SignInResultHelper;
import com.cupidapp.live.login.helper.h;
import com.cupidapp.live.login.layout.PrivacyPermissionLayout;
import com.cupidapp.live.login.layout.QuickLoginLayout;
import com.cupidapp.live.login.model.QuickLoginResult;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.tourist.activity.AbnormalModeType;
import com.cupidapp.live.tourist.activity.FKTouristMainActivity;
import e1.b;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.f;
import z0.y;

/* compiled from: WelcomeFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class WelcomeFragment extends FKBaseFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f16126g = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16128f = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f16127e = kotlin.c.b(new Function0<SignInResultHelper>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$signInResultHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SignInResultHelper invoke() {
            return new SignInResultHelper();
        }
    });

    /* compiled from: WelcomeFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Activity activity) {
            if (activity != null) {
                activity.finishAffinity();
            }
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }

        @NotNull
        public final WelcomeFragment b(boolean z10) {
            WelcomeFragment welcomeFragment = new WelcomeFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("TOURIST_LOGIN", z10);
            welcomeFragment.setArguments(bundle);
            return welcomeFragment;
        }
    }

    /* compiled from: WelcomeFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements QuickLoginLayout.b {
        public b() {
        }

        @Override // com.cupidapp.live.login.layout.QuickLoginLayout.b
        public void a() {
            WelcomeFragment.this.g1();
        }
    }

    /* compiled from: WelcomeFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends h0 {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f16131c;

        public c(int i10) {
            this.f16131c = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, WelcomeFragment.this.getContext(), PrivacyPermissionLayout.f16177e.a().get(this.f16131c), null, 4, null);
        }
    }

    /* compiled from: WelcomeFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements h {
        public d() {
        }

        @Override // com.cupidapp.live.login.helper.h
        public void a(@Nullable String str) {
            Observable a10 = b.a.a(NetworkClient.f11868a.J(), null, null, null, e.f12185a.a(), str, null, false, 103, null);
            WelcomeFragment welcomeFragment = WelcomeFragment.this;
            SignInResultHelper d12 = welcomeFragment.d1();
            FragmentActivity activity = welcomeFragment.getActivity();
            d12.f(activity instanceof FKBaseActivity ? (FKBaseActivity) activity : null, a10, LoginMethod.OneClickLogin, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : null);
            WelcomeFragment.this.a1();
        }

        @Override // com.cupidapp.live.login.helper.h
        public void b() {
            WelcomeFragment.this.a1();
            InputPhoneNumberActivity.f16098t.a(WelcomeFragment.this.getContext(), InputPhoneNumberActivity.PageSource.Welcome);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16128f.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16128f;
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
        ImageView welcome_logo_imageView = (ImageView) S0(R$id.welcome_logo_imageView);
        s.h(welcome_logo_imageView, "welcome_logo_imageView");
        y.c(welcome_logo_imageView, new Function1<View, p>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$bindClickEvent$1
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
            }
        });
        TextView login_textview = (TextView) S0(R$id.login_textview);
        s.h(login_textview, "login_textview");
        y.d(login_textview, new Function1<View, p>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$bindClickEvent$2
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
                z3.e.f54837a.e();
                WelcomeFragment.this.f1();
            }
        });
        ImageView agree_imageview = (ImageView) S0(R$id.agree_imageview);
        s.h(agree_imageview, "agree_imageview");
        y.d(agree_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$bindClickEvent$3
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
                WelcomeFragment welcomeFragment = WelcomeFragment.this;
                int i10 = R$id.agree_imageview;
                ((ImageView) welcomeFragment.S0(i10)).setSelected(!((ImageView) WelcomeFragment.this.S0(i10)).isSelected());
                if (((ImageView) WelcomeFragment.this.S0(i10)).isSelected()) {
                    z3.e.f54837a.F();
                }
            }
        });
        ImageView close_login_image = (ImageView) S0(R$id.close_login_image);
        s.h(close_login_image, "close_login_image");
        y.d(close_login_image, new Function1<View, p>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$bindClickEvent$4
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
                Bundle arguments = WelcomeFragment.this.getArguments();
                boolean z10 = false;
                if (arguments != null && !arguments.getBoolean("TOURIST_LOGIN")) {
                    z10 = true;
                }
                if (z10) {
                    FKTouristMainActivity.f18670x.a(WelcomeFragment.this.getContext(), AbnormalModeType.TouristModeType);
                }
                FragmentActivity activity = WelcomeFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
    }

    public final void Z0() {
        g gVar = g.f52734a;
        if (gVar.Q3()) {
            b1();
            OnePassLoginHelper onePassLoginHelper = OnePassLoginHelper.f16139a;
            FragmentActivity activity = getActivity();
            onePassLoginHelper.m(activity instanceof FKBaseActivity ? (FKBaseActivity) activity : null);
            return;
        }
        if (s.d(gVar.d(), Boolean.FALSE)) {
            return;
        }
        j1();
    }

    public final void a1() {
        if (g.f52734a.Q3()) {
            q1.b.e(q1.b.f53003a, getContext(), (ConstraintLayout) S0(R$id.welcomeLayout), null, 4, null);
        }
    }

    public final void b1() {
        NetworkClient networkClient = NetworkClient.f11868a;
        Disposable disposed = networkClient.i().o().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ConstantsResult, p>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$getData$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConstantsResult constantsResult) {
                m2667invoke(constantsResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2667invoke(ConstantsResult constantsResult) {
                g.f52734a.b2(constantsResult);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$getData$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
        if (QuickLoginLayout.f16187f.a()) {
            Disposable disposed2 = networkClient.J().d().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<QuickLoginResult, p>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$getData$$inlined$handle$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(QuickLoginResult quickLoginResult) {
                    m2668invoke(quickLoginResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2668invoke(QuickLoginResult quickLoginResult) {
                    User info = quickLoginResult.getInfo();
                    if (info != null) {
                        QuickLoginLayout quickLoginLayout = (QuickLoginLayout) WelcomeFragment.this.S0(R$id.quick_login_layout);
                        Lifecycle lifecycle = WelcomeFragment.this.getLifecycle();
                        s.h(lifecycle, "lifecycle");
                        quickLoginLayout.l(lifecycle, info, new WelcomeFragment.b());
                    }
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$getData$4
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    return Boolean.TRUE;
                }
            }, this)));
            if (disposed2 != null) {
                s.h(disposed2, "disposed");
                H(disposed2);
            }
            s.h(disposed2, "disposed");
        }
    }

    public final CharSequence c1(int i10) {
        SpannableStringBuilder c4;
        int i11 = 0;
        List o10 = kotlin.collections.s.o(getString(R$string.user_agreement), getString(R$string.privacy_policy));
        ArrayList arrayList = new ArrayList();
        for (Object obj : o10) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            arrayList.add(new c(i11));
            i11 = i12;
        }
        q1.d dVar = q1.d.f53006a;
        String string = getString(R$string.login_and_register_protocol_prompt);
        s.h(string, "getString(R.string.login…register_protocol_prompt)");
        c4 = dVar.c(string, o10, (r18 & 4) != 0 ? null : Integer.valueOf(i10), (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : true, (r18 & 32) != 0 ? null : arrayList, (r18 & 64) != 0 ? null : null);
        return c4;
    }

    public final SignInResultHelper d1() {
        return (SignInResultHelper) this.f16127e.getValue();
    }

    public final void e1() {
        ImageView close_login_image = (ImageView) S0(R$id.close_login_image);
        s.h(close_login_image, "close_login_image");
        y.m(close_login_image, Integer.valueOf(z0.h.c(this, 6.0f)), Integer.valueOf(z0.h.m(getContext()) + z0.h.c(this, 6.0f)), null, null, 12, null);
        ((TextView) S0(R$id.login_textview)).getPaint().setFakeBoldText(true);
        if (Build.VERSION.SDK_INT >= 28) {
            ((TextView) S0(R$id.protocol_textview)).setTypeface(Typeface.create(Typeface.DEFAULT, 300, false));
        }
        int i10 = R$id.protocol_textview;
        ((TextView) S0(i10)).setText(c1(-1));
        ((TextView) S0(i10)).setMovementMethod(LinkMovementMethod.getInstance());
        ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
        Context context = getContext();
        int i11 = R$id.welcome_bg_imageview;
        ImageLoaderView welcome_bg_imageview = (ImageLoaderView) S0(i11);
        s.h(welcome_bg_imageview, "welcome_bg_imageview");
        imageLoaderUtil.g(context, welcome_bg_imageview, R$mipmap.icon_welcome_bg);
        BitmapFactory.Options m10 = f.m(getContext(), R$mipmap.icon_welcome_bg);
        int l10 = (m10.outHeight * z0.h.l(this)) / m10.outWidth;
        ImageLoaderView welcome_bg_imageview2 = (ImageLoaderView) S0(i11);
        s.h(welcome_bg_imageview2, "welcome_bg_imageview");
        y.o(welcome_bg_imageview2, null, Integer.valueOf(l10), 1, null);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ImageLoaderView) S0(i11), (Property<ImageLoaderView, Float>) View.TRANSLATION_Y, 0.0f, (z0.h.k(this) + z0.h.m(getContext())) - l10);
        ofFloat.setDuration(30000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    public final void f1() {
        if (g.f52734a.Q3()) {
            if (!((ImageView) S0(R$id.agree_imageview)).isSelected()) {
                FKBottomLoft.f12709e.a(getContext()).f(c1(-8618884), -8618884, 300).k(R$string.agree_and_continue, new Function0<p>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$login$1
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
                        ((ImageView) WelcomeFragment.this.S0(R$id.agree_imageview)).setSelected(true);
                        WelcomeFragment.this.g1();
                        j1.i.f50236a.a(PopupName.AGREEMENT_PRIVACY, PopupButtonName.Agree, SensorPosition.Welcome);
                    }
                }).n();
                j1.i.g(j1.i.f50236a, PopupName.AGREEMENT_PRIVACY, SensorPosition.Welcome, null, 4, null);
                return;
            } else {
                g1();
                return;
            }
        }
        j1();
    }

    public final void g1() {
        OnePassLoginHelper onePassLoginHelper = OnePassLoginHelper.f16139a;
        FragmentActivity activity = getActivity();
        onePassLoginHelper.n(activity instanceof FKBaseActivity ? (FKBaseActivity) activity : null, new d());
    }

    public final void h1() {
        GuidHelper.f11866a.e(getContext());
        com.cupidapp.live.base.network.a.f11902a.v(getContext());
        if (((ImageView) S0(R$id.agree_imageview)).isSelected()) {
            g1();
        }
    }

    public final void i1() {
        g gVar = g.f52734a;
        gVar.M1(false);
        gVar.R1(Boolean.TRUE);
        AppApplication.a aVar = AppApplication.f11612d;
        AppApplication h10 = aVar.h();
        Context context = getContext();
        String a10 = context != null ? com.cupidapp.live.base.utils.c.a(context) : null;
        Context context2 = getContext();
        aVar.i(h10, a10, context2 != null ? context2.getPackageName() : null);
        aVar.h().h(aVar.h());
        z3.e.f54837a.a();
        b1();
        h1();
        OnePassLoginHelper onePassLoginHelper = OnePassLoginHelper.f16139a;
        FragmentActivity activity = getActivity();
        onePassLoginHelper.m(activity instanceof FKBaseActivity ? (FKBaseActivity) activity : null);
    }

    public final void j1() {
        Context context = getContext();
        if (context != null) {
            new PrivacyPermissionLayout(context).h(new Function1<Boolean, p>() { // from class: com.cupidapp.live.login.fragment.WelcomeFragment$showPrivacyPermissionDialog$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(boolean z10) {
                    if (z10) {
                        WelcomeFragment.this.i1();
                    } else {
                        ((ImageView) WelcomeFragment.this.S0(R$id.agree_imageview)).setSelected(false);
                    }
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_welcome, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OnePassLoginHelper.f16139a.p();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            z0.h.q(context, null, 1, null);
        }
        o0.f12367a.e(getContext());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        e1();
        Y0();
        p1.h.f52842c.a().b();
        NetworkClient.f11868a.f();
        Z0();
        j1.c.b(j1.c.f50228a, SensorPosition.Welcome, null, null, 6, null);
    }
}
