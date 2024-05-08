package com.cupidapp.live.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.utils.q0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.login.layout.FKBottomLineEditLayout;
import com.cupidapp.live.setting.fragment.CheckPasswordFragment;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: CheckPasswordFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CheckPasswordFragment extends FKBaseFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final b f18105h = new b(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public a f18106e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Function1<? super Boolean, kotlin.p> f18107f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18108g = new LinkedHashMap();

    /* compiled from: CheckPasswordFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {
        public void a() {
            throw null;
        }

        public void b() {
        }

        public void c() {
            throw null;
        }
    }

    /* compiled from: CheckPasswordFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CheckPasswordFragment a(@NotNull String title, @NotNull a checkPasswordFragmentListenerAdapter) {
            kotlin.jvm.internal.s.i(title, "title");
            kotlin.jvm.internal.s.i(checkPasswordFragmentListenerAdapter, "checkPasswordFragmentListenerAdapter");
            CheckPasswordFragment checkPasswordFragment = new CheckPasswordFragment();
            Bundle bundle = new Bundle();
            bundle.putString("TITLE_KEY", title);
            checkPasswordFragment.setArguments(bundle);
            checkPasswordFragment.f18106e = checkPasswordFragmentListenerAdapter;
            return checkPasswordFragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18108g.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18108g;
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

    public final void X0(String str) {
        if (str == null) {
            return;
        }
        R0();
        Disposable disposed = NetworkClient.f11868a.N().p0(q0.e(str)).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.CheckPasswordFragment$checkPassword$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Function1 function1;
                CheckPasswordFragment.a aVar;
                CheckPasswordFragment.this.Q0();
                function1 = CheckPasswordFragment.this.f18107f;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                }
                aVar = CheckPasswordFragment.this.f18106e;
                if (aVar != null) {
                    aVar.c();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.fragment.CheckPasswordFragment$checkPassword$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                CheckPasswordFragment.a aVar;
                kotlin.jvm.internal.s.i(it, "it");
                CheckPasswordFragment.this.Q0();
                aVar = CheckPasswordFragment.this.f18106e;
                if (aVar != null) {
                    aVar.b();
                }
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_check_password, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        if (context != null) {
            EditText editText = (EditText) ((FKBottomLineEditLayout) S0(R$id.passwordEditLayout)).c(R$id.bottomLineEditText);
            kotlin.jvm.internal.s.h(editText, "passwordEditLayout.bottomLineEditText");
            z0.h.v(context, editText);
        }
        int i10 = R$id.passwordEditLayout;
        ((FKBottomLineEditLayout) S0(i10)).setInputType(129);
        ((TextView) S0(R$id.errorPromptTextView)).getPaint().setFakeBoldText(true);
        FKTitleBarLayout onViewCreated$lambda$0 = (FKTitleBarLayout) S0(R$id.checkPasswordTitleBarLayout);
        kotlin.jvm.internal.s.h(onViewCreated$lambda$0, "onViewCreated$lambda$0");
        Bundle arguments = getArguments();
        FKTitleBarLayout.setSingleTitle$default(onViewCreated$lambda$0, arguments != null ? arguments.getString("TITLE_KEY") : null, null, 2, null);
        onViewCreated$lambda$0.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.CheckPasswordFragment$onViewCreated$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view2) {
                invoke2(view2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                Function1 function1;
                CheckPasswordFragment.a aVar;
                function1 = CheckPasswordFragment.this.f18107f;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
                aVar = CheckPasswordFragment.this.f18106e;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
        new com.cupidapp.live.base.utils.g(kotlin.collections.s.o((EditText) ((FKBottomLineEditLayout) S0(i10)).c(R$id.bottomLineEditText)), new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.CheckPasswordFragment$onViewCreated$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((FKUniversalButton) CheckPasswordFragment.this.S0(R$id.checkPasswordButton)).a(z10);
            }
        });
        int i11 = R$id.checkPasswordButton;
        ((FKUniversalButton) S0(i11)).a(false);
        FKUniversalButton checkPasswordButton = (FKUniversalButton) S0(i11);
        kotlin.jvm.internal.s.h(checkPasswordButton, "checkPasswordButton");
        y.a(checkPasswordButton);
        FKUniversalButton checkPasswordButton2 = (FKUniversalButton) S0(i11);
        kotlin.jvm.internal.s.h(checkPasswordButton2, "checkPasswordButton");
        y.d(checkPasswordButton2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.CheckPasswordFragment$onViewCreated$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view2) {
                invoke2(view2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view2) {
                Context context2 = CheckPasswordFragment.this.getContext();
                if (context2 != null) {
                    z0.h.q(context2, null, 1, null);
                }
                String obj = ((EditText) ((FKBottomLineEditLayout) CheckPasswordFragment.this.S0(R$id.passwordEditLayout)).c(R$id.bottomLineEditText)).getText().toString();
                if (!(obj.length() == 0) && obj.length() >= 6) {
                    CheckPasswordFragment.this.X0(obj);
                    return;
                }
                CheckPasswordFragment checkPasswordFragment = CheckPasswordFragment.this;
                int i12 = R$id.errorPromptTextView;
                ((TextView) checkPasswordFragment.S0(i12)).setVisibility(0);
                ((TextView) CheckPasswordFragment.this.S0(i12)).setText(CheckPasswordFragment.this.getString(R$string.password_error_try_again));
            }
        });
    }
}
