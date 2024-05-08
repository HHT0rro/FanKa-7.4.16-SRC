package com.cupidapp.live.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.login.helper.FKVerificationCodeViewWrapper;
import com.cupidapp.live.login.layout.FKBottomLineEditLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: VerifyCodeFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VerifyCodeFragment extends FKBaseFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f18151h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FKVerificationCodeViewWrapper f18152e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public b f18153f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18154g = new LinkedHashMap();

    /* compiled from: VerifyCodeFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VerifyCodeFragment a(@Nullable String str, @NotNull b listener) {
            kotlin.jvm.internal.s.i(listener, "listener");
            VerifyCodeFragment verifyCodeFragment = new VerifyCodeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("PHONE_NUMBER", str);
            verifyCodeFragment.setArguments(bundle);
            verifyCodeFragment.f18153f = listener;
            return verifyCodeFragment;
        }
    }

    /* compiled from: VerifyCodeFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(@NotNull String str);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18154g.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18154g;
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

    public final void X0() {
        ((FKTitleBarLayout) S0(R$id.verifyCodeTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.VerifyCodeFragment$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FragmentActivity activity = VerifyCodeFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        TextView getCodeErrorPrompt = (TextView) S0(R$id.getCodeErrorPrompt);
        kotlin.jvm.internal.s.h(getCodeErrorPrompt, "getCodeErrorPrompt");
        y.d(getCodeErrorPrompt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.VerifyCodeFragment$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                VerifyCodeFragment.this.Y0();
            }
        });
    }

    public final void Y0() {
        R0();
        Disposable disposed = NetworkClient.f11868a.N().K().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.VerifyCodeFragment$getVerifyCode$$inlined$handle$1
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
                FKVerificationCodeViewWrapper fKVerificationCodeViewWrapper;
                VerifyCodeFragment.this.Q0();
                fKVerificationCodeViewWrapper = VerifyCodeFragment.this.f18152e;
                if (fKVerificationCodeViewWrapper != null) {
                    fKVerificationCodeViewWrapper.d();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.fragment.VerifyCodeFragment$getVerifyCode$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                VerifyCodeFragment.this.Q0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void Z0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("PHONE_NUMBER")) == null) {
            return;
        }
        int i10 = R$id.inputVerifyCodeEditLayout;
        ((FKBottomLineEditLayout) S0(i10)).setHint(getString(R$string.input_verify_code_prompt, string));
        Context context = getContext();
        if (context != null) {
            EditText editText = (EditText) ((FKBottomLineEditLayout) S0(i10)).c(R$id.bottomLineEditText);
            kotlin.jvm.internal.s.h(editText, "inputVerifyCodeEditLayout.bottomLineEditText");
            z0.h.v(context, editText);
        }
        new com.cupidapp.live.base.utils.g(kotlin.collections.r.e((EditText) ((FKBottomLineEditLayout) S0(i10)).c(R$id.bottomLineEditText)), new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.VerifyCodeFragment$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0019, code lost:
            
                r4 = r3.this$0.f18153f;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(boolean r4) {
                /*
                    r3 = this;
                    com.cupidapp.live.setting.fragment.VerifyCodeFragment r4 = com.cupidapp.live.setting.fragment.VerifyCodeFragment.this
                    int r0 = com.cupidapp.live.R$id.inputVerifyCodeEditLayout
                    android.view.View r4 = r4.S0(r0)
                    com.cupidapp.live.login.layout.FKBottomLineEditLayout r4 = (com.cupidapp.live.login.layout.FKBottomLineEditLayout) r4
                    int r1 = com.cupidapp.live.R$id.bottomLineEditText
                    android.view.View r4 = r4.c(r1)
                    android.widget.EditText r4 = (android.widget.EditText) r4
                    int r4 = r4.length()
                    r2 = 6
                    if (r4 != r2) goto L3a
                    com.cupidapp.live.setting.fragment.VerifyCodeFragment r4 = com.cupidapp.live.setting.fragment.VerifyCodeFragment.this
                    com.cupidapp.live.setting.fragment.VerifyCodeFragment$b r4 = com.cupidapp.live.setting.fragment.VerifyCodeFragment.U0(r4)
                    if (r4 == 0) goto L3a
                    com.cupidapp.live.setting.fragment.VerifyCodeFragment r2 = com.cupidapp.live.setting.fragment.VerifyCodeFragment.this
                    android.view.View r0 = r2.S0(r0)
                    com.cupidapp.live.login.layout.FKBottomLineEditLayout r0 = (com.cupidapp.live.login.layout.FKBottomLineEditLayout) r0
                    android.view.View r0 = r0.c(r1)
                    android.widget.EditText r0 = (android.widget.EditText) r0
                    android.text.Editable r0 = r0.getText()
                    java.lang.String r0 = r0.toString()
                    r4.a(r0)
                L3a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.setting.fragment.VerifyCodeFragment$initView$1.invoke(boolean):void");
            }
        });
        TextView getCodeErrorPrompt = (TextView) S0(R$id.getCodeErrorPrompt);
        kotlin.jvm.internal.s.h(getCodeErrorPrompt, "getCodeErrorPrompt");
        FKVerificationCodeViewWrapper fKVerificationCodeViewWrapper = new FKVerificationCodeViewWrapper(getCodeErrorPrompt, R$string.restart_get_verification_code_in_processing, R$string.restart_get_verification_code_start);
        this.f18152e = fKVerificationCodeViewWrapper;
        fKVerificationCodeViewWrapper.d();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_verify_code, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        FKVerificationCodeViewWrapper fKVerificationCodeViewWrapper = this.f18152e;
        if (fKVerificationCodeViewWrapper != null) {
            fKVerificationCodeViewWrapper.f();
        }
        super.onDestroy();
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
        j1.c.b(j1.c.f50228a, SensorPosition.ChangePasswordInputVerifyCode, null, null, 6, null);
        Z0();
        X0();
    }
}
