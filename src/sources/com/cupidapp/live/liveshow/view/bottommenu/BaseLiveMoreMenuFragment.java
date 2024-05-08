package com.cupidapp.live.liveshow.view.bottommenu;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseLiveMoreMenuFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseLiveMoreMenuFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Function1<? super MenuType, p> f15314f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15315g = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f15313e = kotlin.c.b(new Function0<LiveMoreMenuAdapter>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment$moreMenuAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final LiveMoreMenuAdapter invoke() {
            LiveMoreMenuAdapter liveMoreMenuAdapter = new LiveMoreMenuAdapter();
            final BaseLiveMoreMenuFragment baseLiveMoreMenuFragment = BaseLiveMoreMenuFragment.this;
            liveMoreMenuAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.bottommenu.BaseLiveMoreMenuFragment$moreMenuAdapter$2$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof LiveMoreMenuModel) {
                        BaseLiveMoreMenuFragment.this.a1((LiveMoreMenuModel) obj);
                    }
                }
            });
            return liveMoreMenuAdapter;
        }
    });

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15315g.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15315g;
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

    public void W0() {
    }

    @Nullable
    public final Function1<MenuType, p> X0() {
        return this.f15314f;
    }

    @NotNull
    public final LiveMoreMenuAdapter Y0() {
        return (LiveMoreMenuAdapter) this.f15313e.getValue();
    }

    public final void Z0() {
        int i10 = R$id.more_menu_recyclerview;
        RecyclerView recyclerView = (RecyclerView) V0(i10);
        recyclerView.setAdapter(Y0());
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 5));
        RecyclerView more_menu_recyclerview = (RecyclerView) V0(i10);
        s.h(more_menu_recyclerview, "more_menu_recyclerview");
        U0(more_menu_recyclerview);
    }

    public void a1(@NotNull LiveMoreMenuModel model) {
        s.i(model, "model");
    }

    public final void b1(@NotNull String url) {
        s.i(url, "url");
        EventBus.c().l(new FKLiveOpenWebFragmentEvent(url, false, 2, null));
    }

    public final void c1(@Nullable Function1<? super MenuType, p> function1) {
        this.f15314f = function1;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_more_menu, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        Z0();
        W0();
    }
}
