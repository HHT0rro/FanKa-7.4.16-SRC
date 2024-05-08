package com.cupidapp.live.consult.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.StartOrStopScrollEvent;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.consult.activity.ConsultViewerActivity;
import com.cupidapp.live.consult.adapter.ConsultListAdapter;
import com.cupidapp.live.consult.model.ConsultListModel;
import com.cupidapp.live.consult.model.ConsultListResult;
import com.cupidapp.live.consult.model.ConsultLiveType;
import com.cupidapp.live.consult.model.QuickJoinResult;
import com.cupidapp.live.consult.view.ConsultListEmptyLayout;
import com.cupidapp.live.consult.viewholder.ConsultBannerListModel;
import com.cupidapp.live.track.group.EnterConsultRoomSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x0.a;
import z0.h;
import z0.u;
import z0.y;

/* compiled from: ConsultListFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultListFragment extends FKBaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f13770f;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13772h = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f13769e = kotlin.c.b(new Function0<ConsultListAdapter>() { // from class: com.cupidapp.live.consult.fragment.ConsultListFragment$consultListAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ConsultListAdapter invoke() {
            ConsultListAdapter consultListAdapter = new ConsultListAdapter();
            final ConsultListFragment consultListFragment = ConsultListFragment.this;
            consultListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultListFragment$consultListAdapter$2$1$1
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
                    if (obj instanceof ConsultListModel) {
                        ConsultViewerActivity.f13732x.a(ConsultListFragment.this.getContext(), ((ConsultListModel) obj).createConfig(EnterConsultRoomSource.Card.getSource()));
                    }
                }
            });
            return consultListAdapter;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f13771g = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.consult.fragment.ConsultListFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final ConsultListFragment consultListFragment = ConsultListFragment.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.consult.fragment.ConsultListFragment$loadMoreListener$2.1
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
                    String str;
                    String str2;
                    str = ConsultListFragment.this.f13770f;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    ConsultListFragment consultListFragment2 = ConsultListFragment.this;
                    str2 = consultListFragment2.f13770f;
                    consultListFragment2.a1(str2);
                }
            });
        }
    });

    public static /* synthetic */ void b1(ConsultListFragment consultListFragment, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        consultListFragment.a1(str);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13772h.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.ConsultList;
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13772h;
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

    public final void Z0() {
        LinearLayout quick_join_consult_layout = (LinearLayout) S0(R$id.quick_join_consult_layout);
        s.h(quick_join_consult_layout, "quick_join_consult_layout");
        y.d(quick_join_consult_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultListFragment$bindClickEvent$1
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
                ConsultListFragment.this.f1();
            }
        });
    }

    public final void a1(final String str) {
        Disposable disposed = NetworkClient.f11868a.v().r(str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultListResult, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultListFragment$getConsultList$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultListResult consultListResult) {
                m2536invoke(consultListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2536invoke(ConsultListResult consultListResult) {
                FKLoadMoreListener d12;
                String str2;
                ConsultListAdapter c12;
                ConsultListAdapter c13;
                ConsultListAdapter c14;
                ConsultListAdapter c15;
                ConsultListAdapter c16;
                ConsultListAdapter c17;
                ConsultListAdapter c18;
                ConsultListResult consultListResult2 = consultListResult;
                ((FKSwipeRefreshLayout) ConsultListFragment.this.S0(R$id.consult_list_refresh_layout)).setRefreshing(false);
                d12 = ConsultListFragment.this.d1();
                d12.c(false);
                ConsultListFragment.this.f13770f = consultListResult2.getNextCursorId();
                if (str == null) {
                    c17 = ConsultListFragment.this.c1();
                    c17.j().clear();
                    c18 = ConsultListFragment.this.c1();
                    c18.d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                }
                List<ConsultListModel> list = consultListResult2.getList();
                if (list != null) {
                    for (ConsultListModel consultListModel : list) {
                        String type = consultListModel.getType();
                        if (s.d(type, ConsultLiveType.ConsultLiveRoom.getType())) {
                            c15 = ConsultListFragment.this.c1();
                            c15.d(consultListModel);
                        } else if (s.d(type, ConsultLiveType.ConsultBanner.getType())) {
                            c16 = ConsultListFragment.this.c1();
                            c16.d(new ConsultBannerListModel(consultListModel.getBanners()));
                        }
                    }
                }
                if (str == null) {
                    c14 = ConsultListFragment.this.c1();
                    List<Object> j10 = c14.j();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : j10) {
                        if (obj instanceof ConsultListModel) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : arrayList) {
                        if (s.d(((ConsultListModel) obj2).getType(), ConsultLiveType.ConsultLiveRoom.getType())) {
                            arrayList2.add(obj2);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        ConsultListFragment consultListFragment = ConsultListFragment.this;
                        int i10 = R$id.empty_consult_layout;
                        ((ConsultListEmptyLayout) consultListFragment.S0(i10)).setVisibility(0);
                        ((ConsultListEmptyLayout) ConsultListFragment.this.S0(i10)).c(consultListResult2.getEmptyJumpTitle(), consultListResult2.getEmptyJumpUrl());
                        ((LinearLayout) ConsultListFragment.this.S0(R$id.quick_join_consult_layout)).setVisibility(8);
                    } else {
                        ((ConsultListEmptyLayout) ConsultListFragment.this.S0(R$id.empty_consult_layout)).setVisibility(8);
                        ((LinearLayout) ConsultListFragment.this.S0(R$id.quick_join_consult_layout)).setVisibility(0);
                    }
                }
                str2 = ConsultListFragment.this.f13770f;
                if (str2 == null || str2.length() == 0) {
                    c13 = ConsultListFragment.this.c1();
                    c13.s();
                }
                c12 = ConsultListFragment.this.c1();
                c12.notifyDataSetChanged();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.fragment.ConsultListFragment$getConsultList$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener d12;
                s.i(it, "it");
                ((FKSwipeRefreshLayout) ConsultListFragment.this.S0(R$id.consult_list_refresh_layout)).setRefreshing(false);
                d12 = ConsultListFragment.this.d1();
                d12.c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final ConsultListAdapter c1() {
        return (ConsultListAdapter) this.f13769e.getValue();
    }

    public final FKLoadMoreListener d1() {
        return (FKLoadMoreListener) this.f13771g.getValue();
    }

    public final void e1() {
        TextView quick_join_consult_text = (TextView) S0(R$id.quick_join_consult_text);
        s.h(quick_join_consult_text, "quick_join_consult_text");
        u.a(quick_join_consult_text);
        int i10 = R$id.consult_list_recyclerview;
        RecyclerView recyclerView = (RecyclerView) S0(i10);
        recyclerView.setAdapter(c1());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), c1().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.consult.fragment.ConsultListFragment$initView$1$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i11) {
                ConsultListAdapter c12;
                c12 = ConsultListFragment.this.c1();
                return c12.u(i11);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.addOnScrollListener(d1());
        ((FKSwipeRefreshLayout) S0(R$id.consult_list_refresh_layout)).setOnRefreshListener(this);
        a.C0834a c0834a = x0.a.f54353h;
        LinearLayout quick_join_consult_layout = (LinearLayout) S0(R$id.quick_join_consult_layout);
        s.h(quick_join_consult_layout, "quick_join_consult_layout");
        c0834a.a(quick_join_consult_layout, -1, h.c(this, 22.0f), com.cupidapp.live.base.utils.h.a(-16777216, 0.2f), h.c(this, 5.0f), 0.0f, 0.0f);
        ConsultListAdapter c12 = c1();
        RecyclerView consult_list_recyclerview = (RecyclerView) S0(i10);
        s.h(consult_list_recyclerview, "consult_list_recyclerview");
        c12.y(consult_list_recyclerview);
    }

    public final void f1() {
        Disposable disposed = NetworkClient.f11868a.v().e().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<QuickJoinResult, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultListFragment$quickJoinConsultRoom$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(QuickJoinResult quickJoinResult) {
                m2537invoke(quickJoinResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2537invoke(QuickJoinResult quickJoinResult) {
                ConsultViewerActivity.a aVar = ConsultViewerActivity.f13732x;
                Context context = ConsultListFragment.this.getContext();
                ConsultListModel voiceRoom = quickJoinResult.getVoiceRoom();
                aVar.a(context, voiceRoom != null ? voiceRoom.createConfig(EnterConsultRoomSource.QuickJoin.getSource()) : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_consult_list, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        EventBus.c().l(new StartOrStopScrollEvent(true));
        super.onPause();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.ConsultList);
        ((FKSwipeRefreshLayout) S0(R$id.consult_list_refresh_layout)).setRefreshing(true);
        b1(this, null, 1, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (c1().n() <= 0) {
            onRefresh();
        } else {
            EventBus.c().l(new StartOrStopScrollEvent(false));
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        e1();
        Z0();
    }
}
