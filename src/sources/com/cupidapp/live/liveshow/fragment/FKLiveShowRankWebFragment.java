package com.cupidapp.live.liveshow.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.view.BaseScrollViewPager;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;

/* compiled from: FKLiveShowRankWebFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveShowRankWebFragment extends FKBaseFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f15052g = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public LiveShowRankWebContainerViewPagerAdapter f15053e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15054f = new LinkedHashMap();

    /* compiled from: FKLiveShowRankWebFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveShowRankWebFragment a(@NotNull MultiWebTitleModel model) {
            s.i(model, "model");
            FKLiveShowRankWebFragment fKLiveShowRankWebFragment = new FKLiveShowRankWebFragment();
            Bundle bundle = new Bundle();
            g.d(bundle, model);
            fKLiveShowRankWebFragment.setArguments(bundle);
            return fKLiveShowRankWebFragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f15054f.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15054f;
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
        FKTitleBarLayout initView$lambda$1$lambda$0 = (FKTitleBarLayout) S0(R$id.containerTitleLayout);
        initView$lambda$1$lambda$0.setLeftImageVisible(true);
        initView$lambda$1$lambda$0.setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveShowRankWebFragment$initView$1$1
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
                FragmentActivity activity = FKLiveShowRankWebFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            s.h(arguments, "arguments");
            MultiWebTitleModel multiWebTitleModel = (MultiWebTitleModel) g.b(arguments, MultiWebTitleModel.class);
            if (multiWebTitleModel != null) {
                int i10 = R$id.containerViewPager;
                ((BaseScrollViewPager) S0(i10)).setCanScroll(multiWebTitleModel.getViewpagerCanScroll());
                s.h(initView$lambda$1$lambda$0, "initView$lambda$1$lambda$0");
                FKTitleBarLayout.f(initView$lambda$1$lambda$0, new com.cupidapp.live.base.view.p(multiWebTitleModel.getWebTitles(), 0.0f, 0, 0, false, 30, null), (BaseScrollViewPager) S0(i10), 0, null, 12, null);
                FragmentManager childFragmentManager = getChildFragmentManager();
                s.h(childFragmentManager, "childFragmentManager");
                this.f15053e = new LiveShowRankWebContainerViewPagerAdapter(childFragmentManager, multiWebTitleModel.getWebUrls());
                ((BaseScrollViewPager) S0(i10)).setAdapter(this.f15053e);
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean onBackPressed() {
        List<FKBaseFragment> a10;
        LiveShowRankWebContainerViewPagerAdapter liveShowRankWebContainerViewPagerAdapter = this.f15053e;
        ActivityResultCaller activityResultCaller = (liveShowRankWebContainerViewPagerAdapter == null || (a10 = liveShowRankWebContainerViewPagerAdapter.a()) == null) ? null : (FKBaseFragment) a10.get(((BaseScrollViewPager) S0(R$id.containerViewPager)).getCurrentItem());
        FKWebViewFragment fKWebViewFragment = activityResultCaller instanceof FKWebViewFragment ? (FKWebViewFragment) activityResultCaller : null;
        if (fKWebViewFragment != null) {
            return fKWebViewFragment.onBackPressed();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_pager_container, viewGroup, false);
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
        T0();
    }
}
