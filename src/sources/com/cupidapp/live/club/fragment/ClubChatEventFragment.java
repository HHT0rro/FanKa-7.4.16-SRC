package com.cupidapp.live.club.fragment;

import a2.a;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.club.adapter.ActivityListAdapter;
import com.cupidapp.live.club.model.ActivityListResult;
import com.cupidapp.live.club.model.ActivityModel;
import com.cupidapp.live.club.viewholder.EmptyListModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;

/* compiled from: ClubChatEventFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatEventFragment extends FKBaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f13546k = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f13549g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13550h;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13552j = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f13547e = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.club.fragment.ClubChatEventFragment$mClubId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            Bundle arguments = ClubChatEventFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getString("CLUB_ID");
            }
            return null;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f13548f = kotlin.c.b(new Function0<ActivityListAdapter>() { // from class: com.cupidapp.live.club.fragment.ClubChatEventFragment$eventAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ActivityListAdapter invoke() {
            final ActivityListAdapter activityListAdapter = new ActivityListAdapter(SensorPosition.ClubGroupActivity);
            final ClubChatEventFragment clubChatEventFragment = ClubChatEventFragment.this;
            activityListAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatEventFragment$eventAdapter$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof ActivityModel) {
                        ActivityModel activityModel = (ActivityModel) obj;
                        j.a.b(com.cupidapp.live.base.router.j.f12156c, ClubChatEventFragment.this.getContext(), activityModel.getJumpUrl(), null, 4, null);
                        activityListAdapter.x(activityModel, SensorPosition.ClubGroupActivity);
                    }
                }
            });
            return activityListAdapter;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f13551i = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.club.fragment.ClubChatEventFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final ClubChatEventFragment clubChatEventFragment = ClubChatEventFragment.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatEventFragment$loadMoreListener$2.1
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
                    String str;
                    String str2;
                    boolean z10;
                    str = ClubChatEventFragment.this.f13549g;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    ClubChatEventFragment clubChatEventFragment2 = ClubChatEventFragment.this;
                    str2 = clubChatEventFragment2.f13549g;
                    z10 = ClubChatEventFragment.this.f13550h;
                    clubChatEventFragment2.b1(str2, z10);
                }
            });
        }
    });

    /* compiled from: ClubChatEventFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubChatEventFragment a(@Nullable String str, boolean z10, @Nullable String str2) {
            ClubChatEventFragment clubChatEventFragment = new ClubChatEventFragment();
            Bundle bundle = new Bundle();
            bundle.putString("CLUB_ID", str);
            bundle.putBoolean("SHOW_CREATE_ACTIVITY", z10);
            bundle.putString("CREATE_ACTIVITY_URL", str2);
            clubChatEventFragment.setArguments(bundle);
            return clubChatEventFragment;
        }
    }

    public static /* synthetic */ void c1(ClubChatEventFragment clubChatEventFragment, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        clubChatEventFragment.b1(str, z10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13552j.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13552j;
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

    public final void a1() {
        LinearLayout create_activity_layout = (LinearLayout) S0(R$id.create_activity_layout);
        kotlin.jvm.internal.s.h(create_activity_layout, "create_activity_layout");
        y.d(create_activity_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatEventFragment$bindClickEvent$1
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
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                Context context = ClubChatEventFragment.this.getContext();
                Bundle arguments = ClubChatEventFragment.this.getArguments();
                j.a.b(aVar, context, arguments != null ? arguments.getString("CREATE_ACTIVITY_URL") : null, null, 4, null);
                SensorsLogKeyButtonClick.ClubGroupActivity.CreateActivity.click();
            }
        });
    }

    public final void b1(final String str, boolean z10) {
        String f12 = f1();
        if (f12 == null || f12.length() == 0) {
            return;
        }
        Disposable disposed = a.C0010a.a(NetworkClient.f11868a.u(), str, z10, f1(), null, 8, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ActivityListResult, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubChatEventFragment$getClubEvent$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ActivityListResult activityListResult) {
                m2512invoke(activityListResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2512invoke(ActivityListResult activityListResult) {
                FKLoadMoreListener e12;
                ActivityListAdapter d12;
                ActivityListAdapter d13;
                ActivityListAdapter d14;
                ActivityListAdapter d15;
                ActivityListAdapter d16;
                ActivityListResult activityListResult2 = activityListResult;
                ((FKSwipeRefreshLayout) ClubChatEventFragment.this.S0(R$id.club_activity_refresh_layout)).setRefreshing(false);
                e12 = ClubChatEventFragment.this.e1();
                e12.c(false);
                ClubChatEventFragment.this.f13549g = activityListResult2.getNextCursorId();
                ClubChatEventFragment.this.f13550h = activityListResult2.getEndedActivity();
                if (str == null) {
                    d14 = ClubChatEventFragment.this.d1();
                    d14.j().clear();
                    List<ActivityModel> recentList = activityListResult2.getRecentList();
                    if (recentList == null || recentList.isEmpty()) {
                        d16 = ClubChatEventFragment.this.d1();
                        d16.d(new EmptyListModel(R$mipmap.icon_empty_activity, R$string.club_empty_activity_prompt, 0, 4, null));
                    } else {
                        String nextCursorId = activityListResult2.getNextCursorId();
                        boolean z11 = !(nextCursorId == null || nextCursorId.length() == 0);
                        d15 = ClubChatEventFragment.this.d1();
                        d15.d(new FKFooterViewModel(z11, false, null, 0, z11 ? 80 : 20, 0, 46, null));
                    }
                }
                d12 = ClubChatEventFragment.this.d1();
                d12.e(activityListResult2.getRecentList());
                d13 = ClubChatEventFragment.this.d1();
                d13.notifyDataSetChanged();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.fragment.ClubChatEventFragment$getClubEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener e12;
                kotlin.jvm.internal.s.i(it, "it");
                ((FKSwipeRefreshLayout) ClubChatEventFragment.this.S0(R$id.club_activity_refresh_layout)).setRefreshing(false);
                e12 = ClubChatEventFragment.this.e1();
                e12.c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final ActivityListAdapter d1() {
        return (ActivityListAdapter) this.f13548f.getValue();
    }

    public final FKLoadMoreListener e1() {
        return (FKLoadMoreListener) this.f13551i.getValue();
    }

    public final String f1() {
        return (String) this.f13547e.getValue();
    }

    public final void g1() {
        TextView create_activity_textview = (TextView) S0(R$id.create_activity_textview);
        kotlin.jvm.internal.s.h(create_activity_textview, "create_activity_textview");
        u.a(create_activity_textview);
        LinearLayout create_activity_layout = (LinearLayout) S0(R$id.create_activity_layout);
        kotlin.jvm.internal.s.h(create_activity_layout, "create_activity_layout");
        Bundle arguments = getArguments();
        create_activity_layout.setVisibility(arguments != null ? arguments.getBoolean("SHOW_CREATE_ACTIVITY", false) : false ? 0 : 8);
        int i10 = R$id.club_activity_recyclerview;
        RecyclerView recyclerView = (RecyclerView) S0(i10);
        recyclerView.setAdapter(d1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addOnScrollListener(e1());
        ActivityListAdapter d12 = d1();
        RecyclerView club_activity_recyclerview = (RecyclerView) S0(i10);
        kotlin.jvm.internal.s.h(club_activity_recyclerview, "club_activity_recyclerview");
        d12.F(club_activity_recyclerview, SensorPosition.ClubGroupActivity);
        ((FKSwipeRefreshLayout) S0(R$id.club_activity_refresh_layout)).setOnRefreshListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_club_chat_event, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.ActivityList);
        c1(this, null, false, 3, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        g1();
        a1();
        c1(this, null, false, 3, null);
    }
}
