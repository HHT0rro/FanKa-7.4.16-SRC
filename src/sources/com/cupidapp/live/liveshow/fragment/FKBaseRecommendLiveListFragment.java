package com.cupidapp.live.liveshow.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKLiveScrollListener;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.NestingRecyclerView;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.activity.LiveshowOpenSource;
import com.cupidapp.live.liveshow.adapter.FKFollowOrNearbyLiveShowModel;
import com.cupidapp.live.liveshow.adapter.FKRecommendLiveListAdapter;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.event.CloseMiniWindowEvent;
import com.cupidapp.live.liveshow.event.PlayLiveEvent;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.liveshow.model.AdModel;
import com.cupidapp.live.liveshow.model.AdViewModel;
import com.cupidapp.live.liveshow.model.BigPictureModel;
import com.cupidapp.live.liveshow.model.LiveListResult;
import com.cupidapp.live.liveshow.model.LiveModuleListModel;
import com.cupidapp.live.liveshow.model.LiveModuleType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveTabConfigModel;
import com.cupidapp.live.liveshow.viewholder.EmptyFollowedUserModel;
import com.cupidapp.live.liveshow.viewholder.FKLiveSquareCardModel;
import com.cupidapp.live.liveshow.viewholder.FKLiveTitleModel;
import com.cupidapp.live.liveshow.viewholder.FKRecommendLiveShowModel;
import com.cupidapp.live.liveshow.viewholder.FollowOrNearbyUserLiveViewModel;
import com.cupidapp.live.liveshow.viewholder.LiveImageModel;
import com.cupidapp.live.liveshow.viewholder.LiveStreamModel;
import com.cupidapp.live.main.event.RefreshSpecifyTabUnreadCountEvent;
import com.cupidapp.live.setting.helper.PersonalizedRecommendHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: FKBaseRecommendLiveListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class FKBaseRecommendLiveListFragment extends FKBaseFragment implements d {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f14996f;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public LiveTabConfigModel f14999i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15000j = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f14995e = kotlin.c.b(new Function0<FKRecommendLiveListAdapter>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment$recommendLiveListAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKRecommendLiveListAdapter invoke() {
            final FKRecommendLiveListAdapter fKRecommendLiveListAdapter = new FKRecommendLiveListAdapter();
            final FKBaseRecommendLiveListFragment fKBaseRecommendLiveListFragment = FKBaseRecommendLiveListFragment.this;
            fKRecommendLiveListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment$recommendLiveListAdapter$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    if (obj instanceof FKRecommendLiveShowModel) {
                        List<Object> j10 = FKRecommendLiveListAdapter.this.j();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : j10) {
                            if (obj2 instanceof FKRecommendLiveShowModel) {
                                arrayList.add(obj2);
                            }
                        }
                        if (arrayList.contains(obj)) {
                            fKBaseRecommendLiveListFragment.r1();
                            FKRecommendLiveShowModel fKRecommendLiveShowModel = (FKRecommendLiveShowModel) obj;
                            FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, fKBaseRecommendLiveListFragment.getContext(), new FKLiveForViewerViewModel(fKRecommendLiveShowModel.getLiveShow(), fKBaseRecommendLiveListFragment.k1(), new LiveInRoomSensorModel(fKRecommendLiveShowModel.getEnterSource().name(), Integer.valueOf(arrayList.indexOf(obj) + 1), SensorScene.Live, fKBaseRecommendLiveListFragment.O0(), fKRecommendLiveShowModel.getLiveShow().getUserType(), fKRecommendLiveShowModel.getLiveShow().getScore()), false, 8, null), false, 4, null);
                        }
                    }
                    if (obj instanceof LiveImageModel) {
                        j.a.b(j.f12156c, fKBaseRecommendLiveListFragment.getContext(), ((LiveImageModel) obj).getUrl(), null, 4, null);
                    }
                    if (obj instanceof LiveStreamModel) {
                        fKBaseRecommendLiveListFragment.r1();
                        FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, fKBaseRecommendLiveListFragment.getContext(), new FKLiveForViewerViewModel(((LiveStreamModel) obj).getLiveShow(), null, new LiveInRoomSensorModel("PUSH_CARD", null, SensorScene.Live, fKBaseRecommendLiveListFragment.O0(), null, null, 48, null), false, 8, null), false, 4, null);
                    }
                }
            });
            return fKRecommendLiveListAdapter;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f14997g = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FKBaseRecommendLiveListFragment fKBaseRecommendLiveListFragment = FKBaseRecommendLiveListFragment.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment$loadMoreListener$2.1
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
                    String m12 = FKBaseRecommendLiveListFragment.this.m1();
                    if (m12 == null || m12.length() == 0) {
                        return;
                    }
                    FKBaseRecommendLiveListFragment fKBaseRecommendLiveListFragment2 = FKBaseRecommendLiveListFragment.this;
                    fKBaseRecommendLiveListFragment2.h1(fKBaseRecommendLiveListFragment2.m1());
                }
            });
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f14998h = kotlin.c.b(new Function0<FKLiveScrollListener>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment$fkLiveScrollListener$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLiveScrollListener invoke() {
            return new FKLiveScrollListener();
        }
    });

    /* compiled from: FKBaseRecommendLiveListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15001a;

        static {
            int[] iArr = new int[SensorPosition.values().length];
            try {
                iArr[SensorPosition.LiveRecommend.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorPosition.LiveHot.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SensorPosition.LiveFollow.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15001a = iArr;
        }
    }

    /* compiled from: FKBaseRecommendLiveListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            FKBaseRecommendLiveListFragment fKBaseRecommendLiveListFragment = FKBaseRecommendLiveListFragment.this;
            int i10 = R$id.liveListRecyclerView;
            if (((NestingRecyclerView) fKBaseRecommendLiveListFragment.T0(i10)) != null) {
                FKBaseRecommendLiveListFragment fKBaseRecommendLiveListFragment2 = FKBaseRecommendLiveListFragment.this;
                FKLiveScrollListener g12 = fKBaseRecommendLiveListFragment2.g1();
                NestingRecyclerView liveListRecyclerView = (NestingRecyclerView) fKBaseRecommendLiveListFragment2.T0(i10);
                s.h(liveListRecyclerView, "liveListRecyclerView");
                g12.b(liveListRecyclerView);
            }
        }
    }

    public static final void p1(FKBaseRecommendLiveListFragment this$0) {
        s.i(this$0, "this$0");
        this$0.s1();
        FKLiveScrollListener g12 = this$0.g1();
        NestingRecyclerView liveListRecyclerView = (NestingRecyclerView) this$0.T0(R$id.liveListRecyclerView);
        s.h(liveListRecyclerView, "liveListRecyclerView");
        g12.o(liveListRecyclerView);
        this$0.h1(null);
    }

    @Override // com.cupidapp.live.liveshow.fragment.d
    public void G0() {
        FKSwipeRefreshLayout fKSwipeRefreshLayout = (FKSwipeRefreshLayout) T0(R$id.liveListRefreshLayout);
        if (fKSwipeRefreshLayout != null) {
            fKSwipeRefreshLayout.setRefreshing(true);
        }
        s1();
        h1(null);
    }

    @Override // com.cupidapp.live.liveshow.fragment.d
    public void K0() {
        NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) T0(R$id.liveListRecyclerView);
        if (nestingRecyclerView != null) {
            nestingRecyclerView.scrollToPosition(0);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f15000j.clear();
    }

    @Override // com.cupidapp.live.liveshow.fragment.d
    public void O(@NotNull LiveTabConfigModel model) {
        s.i(model, "model");
        this.f14999i = model;
    }

    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15000j;
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

    public final void c1() {
        g gVar = g.f52734a;
        if (gVar.t0() <= 0 || O0() != SensorPosition.LiveFollow) {
            return;
        }
        gVar.T2(0);
        EventBus.c().l(new RefreshSpecifyTabUnreadCountEvent(MainActivity.MainPagerType.Live));
    }

    public final void d1(String str, boolean z10) {
        if (z10) {
            int i10 = a.f15001a[O0().ordinal()];
            boolean z11 = true;
            if (i10 == 1 || i10 == 2) {
                if (str != null && str.length() != 0) {
                    z11 = false;
                }
                if (z11) {
                    return;
                }
                n1().d(new FKLiveTitleModel(str, null, 2, null));
                return;
            }
            if (i10 != 3) {
                return;
            }
            int c4 = PersonalizedRecommendHelper.f18179a.c();
            FKRecommendLiveListAdapter n12 = n1();
            Context context = getContext();
            n12.d(new FKLiveTitleModel(context != null ? context.getString(c4) : null, Integer.valueOf(R$mipmap.icon_live)));
        }
    }

    public final void e1(List<LiveModuleListModel> list) {
        ArrayList arrayList;
        if (list == null || list.isEmpty()) {
            if (O0() == SensorPosition.LiveFollow) {
                n1().d(new EmptyFollowedUserModel());
                return;
            }
            return;
        }
        for (LiveModuleListModel liveModuleListModel : list) {
            int type = liveModuleListModel.getType();
            if (type == LiveModuleType.SquareCardType.getType()) {
                List<LiveShowModel> squareCardList = liveModuleListModel.getSquareCardList();
                if (!(squareCardList == null || squareCardList.isEmpty())) {
                    n1().d(new FKLiveSquareCardModel(liveModuleListModel.getId(), liveModuleListModel.getTitle(), liveModuleListModel.getSquareCardList(), liveModuleListModel.getHaveMore()));
                }
            } else if (type == LiveModuleType.AdBannerType.getType()) {
                List<AdModel> adList = liveModuleListModel.getAdList();
                if (!(adList == null || adList.isEmpty())) {
                    n1().d(new AdViewModel(liveModuleListModel.getAdList()));
                }
            } else if (type == LiveModuleType.BigHorizontalSlipType.getType()) {
                if (O0() == SensorPosition.LiveFollow) {
                    FKRecommendLiveListAdapter n12 = n1();
                    List<LiveShowModel> followList = liveModuleListModel.getFollowList();
                    if (followList != null) {
                        arrayList = new ArrayList(t.t(followList, 10));
                        Iterator<LiveShowModel> iterator2 = followList.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList.add(new FKRecommendLiveShowModel(iterator2.next(), SensorsLogLiveShow.EnterLiveShowSource.FOLLOWING_LIST, false, 4, null));
                        }
                    } else {
                        arrayList = null;
                    }
                    n12.e(arrayList);
                } else {
                    List<LiveShowModel> followList2 = liveModuleListModel.getFollowList();
                    if (!(followList2 == null || followList2.isEmpty())) {
                        FKRecommendLiveListAdapter n13 = n1();
                        String title = liveModuleListModel.getTitle();
                        List<LiveShowModel> followList3 = liveModuleListModel.getFollowList();
                        ArrayList arrayList2 = new ArrayList(t.t(followList3, 10));
                        Iterator<LiveShowModel> iterator22 = followList3.iterator2();
                        while (iterator22.hasNext()) {
                            arrayList2.add(new FKFollowOrNearbyLiveShowModel(iterator22.next(), SensorsLogLiveShow.EnterLiveShowSource.FOLLOWING_LIST));
                        }
                        n13.d(new FollowOrNearbyUserLiveViewModel(title, arrayList2, SensorsLogLiveShow.EnterLiveShowSource.FOLLOWING_LIST, liveModuleListModel.getHaveMore()));
                    }
                }
            } else if (type == LiveModuleType.BigImageOrStreamType.getType()) {
                List<BigPictureModel> bigPictureList = liveModuleListModel.getBigPictureList();
                if (!(bigPictureList == null || bigPictureList.isEmpty())) {
                    for (BigPictureModel bigPictureModel : liveModuleListModel.getBigPictureList()) {
                        if (bigPictureModel.getStream()) {
                            LiveShowModel liveShow = bigPictureModel.getLiveShow();
                            if (liveShow != null) {
                                n1().d(new LiveStreamModel(liveShow));
                            }
                        } else {
                            ImageModel image = bigPictureModel.getImage();
                            if (image != null) {
                                n1().d(new LiveImageModel(image, bigPictureModel.getUrl(), bigPictureModel.getBannerId()));
                            }
                        }
                    }
                }
            } else if (type == LiveModuleType.NearbyHorizontalSlipType.getType()) {
                List<LiveShowModel> nearbyList = liveModuleListModel.getNearbyList();
                if (!(nearbyList == null || nearbyList.isEmpty())) {
                    FKRecommendLiveListAdapter n14 = n1();
                    String title2 = liveModuleListModel.getTitle();
                    List<LiveShowModel> nearbyList2 = liveModuleListModel.getNearbyList();
                    ArrayList arrayList3 = new ArrayList(t.t(nearbyList2, 10));
                    Iterator<LiveShowModel> iterator23 = nearbyList2.iterator2();
                    while (iterator23.hasNext()) {
                        arrayList3.add(new FKFollowOrNearbyLiveShowModel(iterator23.next(), SensorsLogLiveShow.EnterLiveShowSource.LIVE_NEARBY));
                    }
                    n14.d(new FollowOrNearbyUserLiveViewModel(title2, arrayList3, SensorsLogLiveShow.EnterLiveShowSource.LIVE_NEARBY, liveModuleListModel.getHaveMore()));
                }
            }
        }
    }

    @NotNull
    public abstract ExposureScene f1();

    public final FKLiveScrollListener g1() {
        return (FKLiveScrollListener) this.f14998h.getValue();
    }

    public final void h1(final String str) {
        Disposable disposed = i1(this.f14999i, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveListResult, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment$getLiveList$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveListResult liveListResult) {
                m2612invoke(liveListResult);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:63:0x015a, code lost:
            
                if ((r14 == null || r14.isEmpty()) != false) goto L53;
             */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void m2612invoke(com.cupidapp.live.liveshow.model.LiveListResult r14) {
                /*
                    Method dump skipped, instructions count: 393
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment$getLiveList$$inlined$handle$1.m2612invoke(java.lang.Object):void");
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment$getLiveList$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                ((FKSwipeRefreshLayout) FKBaseRecommendLiveListFragment.this.T0(R$id.liveListRefreshLayout)).setRefreshing(false);
                FKBaseRecommendLiveListFragment.this.l1().c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public abstract Observable<Result<LiveListResult>> i1(@Nullable LiveTabConfigModel liveTabConfigModel, @Nullable String str);

    @NotNull
    public abstract SensorsLogLiveShow.EnterLiveShowSource j1();

    @NotNull
    public abstract LiveshowOpenSource k1();

    @NotNull
    public final FKLoadMoreListener l1() {
        return (FKLoadMoreListener) this.f14997g.getValue();
    }

    @Nullable
    public final String m1() {
        return this.f14996f;
    }

    public final FKRecommendLiveListAdapter n1() {
        return (FKRecommendLiveListAdapter) this.f14995e.getValue();
    }

    public final void o1() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), n1().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment$initView$manager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                FKRecommendLiveListAdapter n12;
                n12 = FKBaseRecommendLiveListFragment.this.n1();
                return n12.u(i10);
            }
        });
        FKRecommendLiveListAdapter n12 = n1();
        int i10 = R$id.liveListRecyclerView;
        NestingRecyclerView liveListRecyclerView = (NestingRecyclerView) T0(i10);
        s.h(liveListRecyclerView, "liveListRecyclerView");
        n12.y(liveListRecyclerView, f1(), O0());
        NestingRecyclerView initView$lambda$1 = (NestingRecyclerView) T0(i10);
        initView$lambda$1.setAdapter(n1());
        initView$lambda$1.setLayoutManager(gridLayoutManager);
        FKRecommendLiveListAdapter n13 = n1();
        s.h(initView$lambda$1, "initView$lambda$1");
        initView$lambda$1.addItemDecoration(new MutableColumnDecoration(n13, h.c(initView$lambda$1, 1.0f)));
        RecyclerView.ItemAnimator itemAnimator = initView$lambda$1.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        initView$lambda$1.addOnScrollListener(l1());
        initView$lambda$1.addOnScrollListener(g1());
        ((FKSwipeRefreshLayout) T0(R$id.liveListRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.liveshow.fragment.b
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FKBaseRecommendLiveListFragment.p1(FKBaseRecommendLiveListFragment.this);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_base_live_list, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        r1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull CloseMiniWindowEvent event) {
        s.i(event, "event");
        NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) T0(R$id.liveListRecyclerView);
        if (nestingRecyclerView != null) {
            g1().b(nestingRecyclerView);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (z10) {
            r1();
            return;
        }
        int i10 = R$id.liveListRecyclerView;
        if (((NestingRecyclerView) T0(i10)) != null) {
            FKLiveScrollListener g12 = g1();
            NestingRecyclerView liveListRecyclerView = (NestingRecyclerView) T0(i10);
            s.h(liveListRecyclerView, "liveListRecyclerView");
            g12.b(liveListRecyclerView);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        r1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (n1().n() <= 0) {
            G0();
            return;
        }
        int i10 = R$id.liveListRecyclerView;
        if (((NestingRecyclerView) T0(i10)) != null) {
            FKLiveScrollListener g12 = g1();
            NestingRecyclerView liveListRecyclerView = (NestingRecyclerView) T0(i10);
            s.h(liveListRecyclerView, "liveListRecyclerView");
            g12.b(liveListRecyclerView);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        o1();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q1(com.cupidapp.live.liveshow.model.LiveListResult r9) {
        /*
            r8 = this;
            java.util.List r0 = r9.getModuleList()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L30
            java.util.Iterator r0 = r0.iterator2()
        Ld:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L2c
            java.lang.Object r4 = r0.next()
            r5 = r4
            com.cupidapp.live.liveshow.model.LiveModuleListModel r5 = (com.cupidapp.live.liveshow.model.LiveModuleListModel) r5
            com.cupidapp.live.liveshow.model.LiveModuleType r6 = com.cupidapp.live.liveshow.model.LiveModuleType.BigImageOrStreamType
            int r6 = r6.getType()
            int r5 = r5.getType()
            if (r6 != r5) goto L28
            r5 = 1
            goto L29
        L28:
            r5 = 0
        L29:
            if (r5 == 0) goto Ld
            goto L2d
        L2c:
            r4 = r3
        L2d:
            com.cupidapp.live.liveshow.model.LiveModuleListModel r4 = (com.cupidapp.live.liveshow.model.LiveModuleListModel) r4
            goto L31
        L30:
            r4 = r3
        L31:
            if (r4 == 0) goto L55
            java.util.List r0 = r4.getBigPictureList()
            if (r0 == 0) goto L55
            java.util.Iterator r0 = r0.iterator2()
        L3d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L51
            java.lang.Object r4 = r0.next()
            r5 = r4
            com.cupidapp.live.liveshow.model.BigPictureModel r5 = (com.cupidapp.live.liveshow.model.BigPictureModel) r5
            boolean r5 = r5.getStream()
            if (r5 == 0) goto L3d
            goto L52
        L51:
            r4 = r3
        L52:
            com.cupidapp.live.liveshow.model.BigPictureModel r4 = (com.cupidapp.live.liveshow.model.BigPictureModel) r4
            goto L56
        L55:
            r4 = r3
        L56:
            java.util.List r9 = r9.getList()
            if (r9 == 0) goto L86
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r9 = r9.iterator2()
        L65:
            boolean r5 = r9.hasNext()
            if (r5 == 0) goto L87
            java.lang.Object r5 = r9.next()
            r6 = r5
            com.cupidapp.live.liveshow.model.LiveShowModel r6 = (com.cupidapp.live.liveshow.model.LiveShowModel) r6
            java.lang.String r6 = r6.getType()
            com.cupidapp.live.liveshow.model.LiveShowType r7 = com.cupidapp.live.liveshow.model.LiveShowType.LiveShow
            java.lang.String r7 = r7.getType()
            boolean r6 = kotlin.jvm.internal.s.d(r6, r7)
            if (r6 == 0) goto L65
            r0.add(r5)
            goto L65
        L86:
            r0 = r3
        L87:
            com.cupidapp.live.liveshow.constants.FKLiveConstantsData r9 = com.cupidapp.live.liveshow.constants.FKLiveConstantsData.INSTANCE
            com.cupidapp.live.liveshow.model.LiveShowResult r5 = r9.getFkLiveShowResult()
            if (r5 != 0) goto Lb0
            if (r4 == 0) goto L96
            com.cupidapp.live.liveshow.model.LiveShowModel r5 = r4.getLiveShow()
            goto L97
        L96:
            r5 = r3
        L97:
            if (r5 == 0) goto L9e
            com.cupidapp.live.liveshow.model.LiveShowModel r0 = r4.getLiveShow()
            goto Lb1
        L9e:
            if (r0 == 0) goto La6
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto La7
        La6:
            r1 = 1
        La7:
            if (r1 != 0) goto Lb0
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.T(r0)
            com.cupidapp.live.liveshow.model.LiveShowModel r0 = (com.cupidapp.live.liveshow.model.LiveShowModel) r0
            goto Lb1
        Lb0:
            r0 = r3
        Lb1:
            if (r0 == 0) goto Lc1
            com.cupidapp.live.liveshow.model.LiveShowResult$Companion r1 = com.cupidapp.live.liveshow.model.LiveShowResult.Companion
            com.cupidapp.live.liveshow.model.LiveShowResult r0 = r1.a(r0)
            r9.setFkLiveShowResult(r0)
            com.cupidapp.live.liveshow.entity.j$a r9 = com.cupidapp.live.liveshow.entity.j.f14922f
            com.cupidapp.live.liveshow.entity.j.a.c(r9, r3, r2, r3)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment.q1(com.cupidapp.live.liveshow.model.LiveListResult):void");
    }

    public final void r1() {
        int i10 = R$id.liveListRecyclerView;
        if (((NestingRecyclerView) T0(i10)) != null) {
            FKLiveScrollListener g12 = g1();
            NestingRecyclerView liveListRecyclerView = (NestingRecyclerView) T0(i10);
            s.h(liveListRecyclerView, "liveListRecyclerView");
            g12.o(liveListRecyclerView);
        }
        if (FKLiveMiniWindow.f15074m.a().H()) {
            return;
        }
        FKLiveUtil.f14913a.m();
    }

    public final void s1() {
        RecyclerExposureHelper.a aVar = RecyclerExposureHelper.f12092j;
        aVar.d(f1());
        aVar.d(ExposureScene.LiveNearbyOrFollow);
    }

    public final void t1(@Nullable String str) {
        this.f14996f = str;
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PlayLiveEvent event) {
        s.i(event, "event");
        NestingRecyclerView nestingRecyclerView = (NestingRecyclerView) T0(R$id.liveListRecyclerView);
        if (nestingRecyclerView != null) {
            g1().b(nestingRecyclerView);
        }
    }
}
