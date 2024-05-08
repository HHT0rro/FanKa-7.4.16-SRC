package com.cupidapp.live.liveshow.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$raw;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.model.BottomTabName;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.fragment.FKBaseMainPagerFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LivePathModel;
import com.cupidapp.live.base.network.model.LiveRankModel;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.title.MultiPageTitleBarLayout;
import com.cupidapp.live.liveshow.activity.FKLiveShowRankWebActivity;
import com.cupidapp.live.liveshow.adapter.FKLiveContainerViewPagerAdapter;
import com.cupidapp.live.liveshow.model.FKLiveHornModel;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuListModel;
import com.cupidapp.live.liveshow.model.LiveMenuUnreadModel;
import com.cupidapp.live.liveshow.model.LiveTabConfigModel;
import com.cupidapp.live.liveshow.view.FKLivePopupWindowWrapper;
import com.cupidapp.live.liveshow.view.horn.FKLiveBaseHornLayout;
import com.cupidapp.live.liveshow.view.horn.FKLiveHornEvent;
import com.cupidapp.live.liveshow.view.menu.LiveFunctionMenuLayout;
import com.cupidapp.live.liveshow.viewmodel.LiveContainerViewModel;
import com.cupidapp.live.match.view.CommonFaultPromptLayout;
import com.cupidapp.live.push.util.AppTopTipPopup;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.irisdt.client.others.OthersProtos;
import he.j;
import j1.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.text.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: FKLiveContainerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveContainerFragment extends FKBaseMainPagerFragment {

    /* renamed from: j, reason: collision with root package name */
    public long f15008j;

    /* renamed from: k, reason: collision with root package name */
    public long f15009k;

    /* renamed from: l, reason: collision with root package name */
    public int f15010l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final Lazy f15011m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public SensorPosition f15012n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15013o = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f15007i = kotlin.c.b(new Function0<FKLiveContainerViewPagerAdapter>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$liveContainerAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLiveContainerViewPagerAdapter invoke() {
            FragmentManager childFragmentManager = FKLiveContainerFragment.this.getChildFragmentManager();
            s.h(childFragmentManager, "childFragmentManager");
            return new FKLiveContainerViewPagerAdapter(childFragmentManager);
        }
    });

    public FKLiveContainerFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f15011m = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(LiveContainerViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
    }

    public static final void z1(FKLiveContainerFragment this$0, LiveMenuUnreadModel liveMenuUnreadModel) {
        s.i(this$0, "this$0");
        MultiPageTitleBarLayout multiPageTitleBarLayout = (MultiPageTitleBarLayout) this$0.h1(R$id.live_container_title_bar);
        multiPageTitleBarLayout.g(liveMenuUnreadModel.getAnchorUnread());
        multiPageTitleBarLayout.h(liveMenuUnreadModel.getUserUnread());
    }

    public final boolean A1() {
        FKBaseFragment u12 = u1();
        return (u12 != null ? u12.O0() : null) == SensorPosition.LiveFollow;
    }

    public final void B1() {
        ActivityResultCaller u12 = u1();
        if (u12 instanceof d) {
            d dVar = (d) u12;
            dVar.K0();
            if (A1()) {
                dVar.G0();
            }
        }
    }

    public final void C1() {
        if (this.f15008j == 0 || System.currentTimeMillis() - this.f15008j <= 180000) {
            return;
        }
        D1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1() {
        for (FKBaseFragment fKBaseFragment : v1().a()) {
            if ((fKBaseFragment instanceof d) && fKBaseFragment.isResumed()) {
                d dVar = (d) fKBaseFragment;
                dVar.K0();
                dVar.G0();
            }
        }
    }

    public final void E1() {
        SensorPosition O0;
        FKBaseFragment u12 = u1();
        if (u12 == null || (O0 = u12.O0()) == null) {
            return;
        }
        j1.c.b(j1.c.f50228a, O0, null, null, 6, null);
        if (O0 != SensorPosition.LiveFollow || g.f52734a.t0() <= 0) {
            return;
        }
        GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_FOLLOW_RED_DOT, null, null, 6, null);
    }

    public final void F1() {
        if (this.f15009k == 0) {
            return;
        }
        FKBaseFragment fKBaseFragment = (FKBaseFragment) CollectionsKt___CollectionsKt.W(v1().a(), this.f15010l);
        SensorPosition O0 = fKBaseFragment != null ? fKBaseFragment.O0() : null;
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.f15009k) / 1000);
        if (O0 == null || currentTimeMillis < 0) {
            return;
        }
        GroupOthersLog.f18702a.e(O0, currentTimeMillis);
    }

    public final void G1() {
        LivePathModel livePaths;
        ConstantsResult q10 = g.f52734a.q();
        List<LiveRankModel> rankNav = (q10 == null || (livePaths = q10.getLivePaths()) == null) ? null : livePaths.getRankNav();
        if (rankNav == null || rankNav.isEmpty()) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (LiveRankModel liveRankModel : rankNav) {
            linkedHashMap.put(liveRankModel.getTitle(), liveRankModel.getUrl());
        }
        FKLiveShowRankWebActivity.f14784s.a(getContext(), new MultiWebTitleModel(linkedHashMap, false));
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f15013o.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.LiveShow;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void X0() {
        D1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void Y0(@NotNull Context context) {
        s.i(context, "context");
        f1();
        this.f15009k = System.currentTimeMillis();
        E1();
        FKLivePopupWindowWrapper.f15260a.b(context);
        e1(BottomTabName.Live);
        if (g.f52734a.t0() > 0) {
            GroupOthersLog.p(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_ENTRANCE_RED_DOT, null, null, 6, null);
        }
        if (A1()) {
            B1();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void Z0() {
        F1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void a1(@Nullable String str) {
        SensorPosition sensorPosition;
        if (str == null || str.length() == 0) {
            return;
        }
        int i10 = R$id.liveContainerViewPager;
        if (((ViewPager) h1(i10)) == null) {
            return;
        }
        if (p.r(str, "LiveRecommend", true)) {
            sensorPosition = SensorPosition.LiveRecommend;
        } else if (p.r(str, "LiveHot", true)) {
            sensorPosition = SensorPosition.LiveHot;
        } else if (p.r(str, "LiveFollow", true)) {
            sensorPosition = SensorPosition.LiveFollow;
        } else if (p.r(str, "LiveNearby", true)) {
            sensorPosition = SensorPosition.LiveNearby;
        } else if (p.r(str, "LiveGeneral", true)) {
            sensorPosition = SensorPosition.LiveConfigurable;
        } else if (p.r(str, "LiveCounseling", true)) {
            sensorPosition = SensorPosition.ConsultList;
        } else {
            sensorPosition = SensorPosition.Unknown;
        }
        this.f15012n = sensorPosition;
        Integer x12 = x1(sensorPosition);
        if (x12 != null) {
            ((ViewPager) h1(i10)).setCurrentItem(x12.intValue());
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void b1(long j10) {
        k.f50238a.a(SensorPosition.LiveShow, (i10 & 2) != 0 ? null : null, (i10 & 4) != 0 ? null : null, j10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void c1(boolean z10) {
        k.f50238a.d(SensorPosition.LiveShow, z10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment
    public void f1() {
        g gVar = g.f52734a;
        if (gVar.t0() > 0) {
            GroupOthersLog.r(GroupOthersLog.f18702a, OthersProtos.Enum_type.LIVE_FOLLOW_RED_DOT, null, 2, null);
        }
        Integer x12 = x1(SensorPosition.LiveFollow);
        if (x12 != null) {
            int intValue = x12.intValue();
            MultiPageTitleBarLayout multiPageTitleBarLayout = (MultiPageTitleBarLayout) h1(R$id.live_container_title_bar);
            if (multiPageTitleBarLayout != null) {
                multiPageTitleBarLayout.setViewPagerTitleUnreadCount(intValue, gVar.t0());
            }
        }
    }

    @Nullable
    public View h1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15013o;
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

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_container, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseMainPagerFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ((FKLiveBaseHornLayout) h1(R$id.liveHornLayout)).j();
        super.onDestroyView();
        N0();
    }

    @j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FKLiveHornEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        ((FKLiveBaseHornLayout) h1(R$id.liveHornLayout)).k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            this.f15008j = System.currentTimeMillis();
            LiveFunctionMenuLayout.f15734g.a();
        } else {
            FKBaseFragment u12 = u1();
            if (u12 instanceof FKNearbyLiveListFragment) {
                FKNearbyLiveListFragment fKNearbyLiveListFragment = (FKNearbyLiveListFragment) u12;
                if (fKNearbyLiveListFragment.f1()) {
                    fKNearbyLiveListFragment.k1();
                    AppTopTipPopup.f17896a.c();
                    w1().getMenuRedDot();
                }
            }
            C1();
            AppTopTipPopup.f17896a.c();
            w1().getMenuRedDot();
        }
        FKBaseFragment u13 = u1();
        if (u13 != null) {
            u13.onHiddenChanged(z10);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isVisible()) {
            F1();
        }
        this.f15008j = System.currentTimeMillis();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        C1();
        if (isVisible()) {
            this.f15009k = System.currentTimeMillis();
            AppTopTipPopup.f17896a.c();
            w1().getMenuRedDot();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        w1().callTitleApi(!LocationUtils.f12270h.d(getContext()));
        y1();
        s1();
    }

    public final void r1(@NotNull FKLiveHornModel model) {
        s.i(model, "model");
        if (isResumed()) {
            ((FKLiveBaseHornLayout) h1(R$id.liveHornLayout)).f(model);
        }
    }

    public final void s1() {
        LivePathModel livePaths;
        List<LiveRankModel> rankNav;
        int i10 = R$id.live_container_title_bar;
        ((MultiPageTitleBarLayout) h1(i10)).setRightFirstImgClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$bindClickEvent$1
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
                LiveContainerViewModel w12;
                w12 = FKLiveContainerFragment.this.w1();
                w12.anchorLiveMenu();
                GroupLiveLog.f18698a.o();
            }
        });
        ((MultiPageTitleBarLayout) h1(i10)).setRightSecondImgClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$bindClickEvent$2
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
                LiveContainerViewModel w12;
                w12 = FKLiveContainerFragment.this.w1();
                w12.viewerLiveMenu();
                GroupLiveLog.f18698a.r();
            }
        });
        ConstantsResult q10 = g.f52734a.q();
        if ((q10 == null || (livePaths = q10.getLivePaths()) == null || (rankNav = livePaths.getRankNav()) == null || !(rankNav.isEmpty() ^ true)) ? false : true) {
            MultiPageTitleBarLayout live_container_title_bar = (MultiPageTitleBarLayout) h1(i10);
            s.h(live_container_title_bar, "live_container_title_bar");
            MultiPageTitleBarLayout.setRightThirdLottieImg$default(live_container_title_bar, R$raw.lottie_live_rank, false, 2, null);
            ((MultiPageTitleBarLayout) h1(i10)).setRightThirdImgClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$bindClickEvent$3
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
                    SensorsLogKeyButtonClick.LiveShow.LeaderBoard.click();
                    FKLiveContainerFragment.this.G1();
                }
            });
        }
    }

    public final void t1(List<LiveTabConfigModel> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        for (LiveTabConfigModel liveTabConfigModel : list) {
            ActivityResultCaller liveSubTabFragment = liveTabConfigModel.getLiveSubTabFragment();
            if (liveSubTabFragment != null) {
                arrayList.add(liveTabConfigModel.getTab());
                arrayList2.add(liveSubTabFragment);
                if (liveTabConfigModel.getDefault()) {
                    i10 = kotlin.collections.s.l(arrayList2);
                }
                if (liveSubTabFragment instanceof d) {
                    ((d) liveSubTabFragment).O(liveTabConfigModel);
                }
            }
        }
        v1().b(arrayList2);
        MultiPageTitleBarLayout live_container_title_bar = (MultiPageTitleBarLayout) h1(R$id.live_container_title_bar);
        s.h(live_container_title_bar, "live_container_title_bar");
        com.cupidapp.live.base.view.p pVar = new com.cupidapp.live.base.view.p(arrayList, 0.0f, 0, 0, false, 30, null);
        int i11 = R$id.liveContainerViewPager;
        MultiPageTitleBarLayout.d(live_container_title_bar, pVar, (ViewPager) h1(i11), 0, new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$configTitleBar$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i12) {
                int i13;
                FKLiveContainerFragment.this.B1();
                i13 = FKLiveContainerFragment.this.f15010l;
                if (i12 != i13) {
                    FKLiveContainerFragment.this.F1();
                    FKLiveContainerFragment.this.f15010l = i12;
                    FKLiveContainerFragment.this.f15009k = System.currentTimeMillis();
                }
                FKLiveContainerFragment.this.E1();
            }
        }, 4, null);
        ((ViewPager) h1(i11)).setAdapter(v1());
        ((ViewPager) h1(i11)).setOffscreenPageLimit(2);
        Integer x12 = x1(this.f15012n);
        if (x12 != null) {
            i10 = x12.intValue();
        }
        this.f15010l = i10;
        this.f15012n = null;
        ((ViewPager) h1(i11)).setCurrentItem(this.f15010l);
    }

    public final FKBaseFragment u1() {
        int currentItem;
        int i10 = R$id.liveContainerViewPager;
        ViewPager viewPager = (ViewPager) h1(i10);
        if (viewPager == null || (currentItem = viewPager.getCurrentItem()) < 0 || currentItem >= v1().a().size()) {
            return null;
        }
        return v1().a().get(((ViewPager) h1(i10)).getCurrentItem());
    }

    public final FKLiveContainerViewPagerAdapter v1() {
        return (FKLiveContainerViewPagerAdapter) this.f15007i.getValue();
    }

    public final LiveContainerViewModel w1() {
        return (LiveContainerViewModel) this.f15011m.getValue();
    }

    public final Integer x1(SensorPosition sensorPosition) {
        if (sensorPosition == null) {
            return null;
        }
        Iterator<FKBaseFragment> iterator2 = v1().a().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            }
            if (iterator2.next().O0() == sensorPosition) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            return null;
        }
        return Integer.valueOf(i10);
    }

    public final void y1() {
        w1().getTitleData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<StateResult<List<? extends LiveTabConfigModel>>, kotlin.p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(StateResult<List<? extends LiveTabConfigModel>> stateResult) {
                invoke2((StateResult<List<LiveTabConfigModel>>) stateResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull StateResult<List<LiveTabConfigModel>> result) {
                s.i(result, "result");
                if (result.getData() != null) {
                    ((ViewPager) FKLiveContainerFragment.this.h1(R$id.liveContainerViewPager)).setVisibility(0);
                    ((CommonFaultPromptLayout) FKLiveContainerFragment.this.h1(R$id.live_container_network_error_layout)).setVisibility(8);
                    FKLiveContainerFragment.this.t1(result.getData());
                    return;
                }
                ((ViewPager) FKLiveContainerFragment.this.h1(R$id.liveContainerViewPager)).setVisibility(8);
                FKLiveContainerFragment fKLiveContainerFragment = FKLiveContainerFragment.this;
                int i10 = R$id.live_container_network_error_layout;
                ((CommonFaultPromptLayout) fKLiveContainerFragment.h1(i10)).setVisibility(0);
                CommonFaultPromptLayout commonFaultPromptLayout = (CommonFaultPromptLayout) FKLiveContainerFragment.this.h1(i10);
                String string = FKLiveContainerFragment.this.getString(R$string.unable_to_connect_to_server);
                s.h(string, "getString(R.string.unable_to_connect_to_server)");
                String string2 = FKLiveContainerFragment.this.getString(R$string.internet_is_unavailable);
                String string3 = FKLiveContainerFragment.this.getString(R$string.reload);
                final FKLiveContainerFragment fKLiveContainerFragment2 = FKLiveContainerFragment.this;
                commonFaultPromptLayout.b(string, string2, string3, new Function0<kotlin.p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$initObserve$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ kotlin.p invoke() {
                        invoke2();
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LiveContainerViewModel w12;
                        w12 = FKLiveContainerFragment.this.w1();
                        w12.callTitleApi(!LocationUtils.f12270h.d(FKLiveContainerFragment.this.getContext()));
                    }
                });
            }
        }));
        w1().getAnchorLiveMenuEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<List<? extends LiveFunctionMenuListModel>, kotlin.p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends LiveFunctionMenuListModel> list) {
                invoke2((List<LiveFunctionMenuListModel>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<LiveFunctionMenuListModel> list) {
                if ((list == null || list.isEmpty()) || FKLiveContainerFragment.this.isHidden()) {
                    return;
                }
                LiveFunctionMenuLayout.f15734g.b(FKLiveContainerFragment.this.getContext(), (MultiPageTitleBarLayout) FKLiveContainerFragment.this.h1(R$id.live_container_title_bar), false, list);
            }
        }));
        w1().getViewerLiveMenuEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<List<? extends LiveFunctionMenuListModel>, kotlin.p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveContainerFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends LiveFunctionMenuListModel> list) {
                invoke2((List<LiveFunctionMenuListModel>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<LiveFunctionMenuListModel> list) {
                if ((list == null || list.isEmpty()) || FKLiveContainerFragment.this.isHidden()) {
                    return;
                }
                LiveFunctionMenuLayout.f15734g.b(FKLiveContainerFragment.this.getContext(), (MultiPageTitleBarLayout) FKLiveContainerFragment.this.h1(R$id.live_container_title_bar), true, list);
            }
        }));
        w1().getLiveMenuUnreadLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.liveshow.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKLiveContainerFragment.z1(FKLiveContainerFragment.this, (LiveMenuUnreadModel) obj);
            }
        });
    }
}
