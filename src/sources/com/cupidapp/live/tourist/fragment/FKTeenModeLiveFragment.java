package com.cupidapp.live.tourist.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.y;
import z0.z;

/* compiled from: FKTeenModeLiveFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKTeenModeLiveFragment extends FKBaseFragment {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18680e = new LinkedHashMap();

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18680e.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18680e;
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

    public final void T0() {
        FKUniversalButton close_teen_model_btn = (FKUniversalButton) S0(R$id.close_teen_model_btn);
        s.h(close_teen_model_btn, "close_teen_model_btn");
        y.d(close_teen_model_btn, new Function1<View, p>() { // from class: com.cupidapp.live.tourist.fragment.FKTeenModeLiveFragment$bindClickEvent$1
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
                ConstantsUrlModel urlModel;
                j.a aVar = j.f12156c;
                Context context = FKTeenModeLiveFragment.this.getContext();
                ConstantsResult q10 = g.f52734a.q();
                j.a.b(aVar, context, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getCloseTeenagerUrl(), null, 4, null);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        if (viewGroup != null) {
            return z.b(viewGroup, R$layout.fragment_teen_mode_live, false, 2, null);
        }
        return null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        if (context != null) {
            TextView teen_mode_textview = (TextView) S0(R$id.teen_mode_textview);
            s.h(teen_mode_textview, "teen_mode_textview");
            com.cupidapp.live.base.view.s.b(context, teen_mode_textview);
        }
        T0();
    }
}
