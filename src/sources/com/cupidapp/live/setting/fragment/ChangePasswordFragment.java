package com.cupidapp.live.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.login.layout.FKBottomLineEditLayout;
import com.cupidapp.live.setting.fragment.ChangePasswordFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: ChangePasswordFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChangePasswordFragment extends FKBaseFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final b f18102g = new b(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public a f18103e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18104f = new LinkedHashMap();

    /* compiled from: ChangePasswordFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(@NotNull String str);
    }

    /* compiled from: ChangePasswordFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChangePasswordFragment a(@NotNull a listener) {
            kotlin.jvm.internal.s.i(listener, "listener");
            ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment();
            changePasswordFragment.f18103e = listener;
            return changePasswordFragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18104f.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18104f;
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

    public final void V0() {
        ((FKTitleBarLayout) S0(R$id.changePasswordTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.ChangePasswordFragment$bindClickEvent$1
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
                FragmentActivity activity = ChangePasswordFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        FKUniversalButton nextStepButton = (FKUniversalButton) S0(R$id.nextStepButton);
        kotlin.jvm.internal.s.h(nextStepButton, "nextStepButton");
        y.d(nextStepButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.ChangePasswordFragment$bindClickEvent$2
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
                Context context = ChangePasswordFragment.this.getContext();
                if (context != null) {
                    z0.h.q(context, null, 1, null);
                }
                String getText = ((FKBottomLineEditLayout) ChangePasswordFragment.this.S0(R$id.changePasswordEditLayout)).getGetText();
                final ChangePasswordFragment changePasswordFragment = ChangePasswordFragment.this;
                z0.t.h(getText, new Function2<Boolean, Integer, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.ChangePasswordFragment$bindClickEvent$2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Boolean bool, Integer num) {
                        invoke(bool.booleanValue(), num);
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(boolean z10, @Nullable Integer num) {
                        ChangePasswordFragment.a aVar;
                        if (z10) {
                            aVar = ChangePasswordFragment.this.f18103e;
                            if (aVar != null) {
                                aVar.a(((FKBottomLineEditLayout) ChangePasswordFragment.this.S0(R$id.changePasswordEditLayout)).getGetText());
                                return;
                            }
                            return;
                        }
                        if (num != null) {
                            ChangePasswordFragment changePasswordFragment2 = ChangePasswordFragment.this;
                            num.intValue();
                            com.cupidapp.live.base.view.h.f12779a.r(changePasswordFragment2.getContext(), num.intValue());
                        }
                    }
                });
            }
        });
    }

    public final void W0() {
        Context context = getContext();
        if (context != null) {
            EditText editText = (EditText) ((FKBottomLineEditLayout) S0(R$id.changePasswordEditLayout)).c(R$id.bottomLineEditText);
            kotlin.jvm.internal.s.h(editText, "changePasswordEditLayout.bottomLineEditText");
            z0.h.v(context, editText);
        }
        int i10 = R$id.changePasswordEditLayout;
        ((FKBottomLineEditLayout) S0(i10)).setInputType(129);
        int i11 = R$id.nextStepButton;
        ((FKUniversalButton) S0(i11)).a(false);
        new com.cupidapp.live.base.utils.g(kotlin.collections.r.e((EditText) ((FKBottomLineEditLayout) S0(i10)).c(R$id.bottomLineEditText)), new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.ChangePasswordFragment$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((FKUniversalButton) ChangePasswordFragment.this.S0(R$id.nextStepButton)).a(z10);
            }
        });
        FKUniversalButton nextStepButton = (FKUniversalButton) S0(i11);
        kotlin.jvm.internal.s.h(nextStepButton, "nextStepButton");
        y.a(nextStepButton);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_change_password, viewGroup, false);
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
        j1.c.b(j1.c.f50228a, SensorPosition.ChangePasswordInputNewPassword, null, null, 6, null);
        W0();
        V0();
    }
}
