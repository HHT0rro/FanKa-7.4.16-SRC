package com.cupidapp.live.club.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.club.adapter.ClubMemberListAdapter;
import com.cupidapp.live.club.model.ClubInfoModel;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubMemberListActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubMemberListActivity extends FKBaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public static final a f13489w = new a(null);

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public String f13493t;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13495v = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f13490q = c.b(new Function0<String>() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$clubId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return ClubMemberListActivity.this.getIntent().getStringExtra("CLUB_ID");
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f13491r = c.b(new Function0<String>() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$clubName$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return ClubMemberListActivity.this.getIntent().getStringExtra("CLUB_NAME");
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f13492s = c.b(new Function0<ClubMemberListAdapter>() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$memberListAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ClubMemberListAdapter invoke() {
            ClubMemberListAdapter clubMemberListAdapter = new ClubMemberListAdapter();
            final ClubMemberListActivity clubMemberListActivity = ClubMemberListActivity.this;
            clubMemberListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$memberListAdapter$2$1$1
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
                    String s12;
                    String v12;
                    if (obj instanceof User) {
                        boolean z10 = false;
                        if (ClubMemberListActivity.this.getIntent().getBooleanExtra("CAN_KICK_OUT", false) && !((User) obj).isMyself()) {
                            z10 = true;
                        }
                        s12 = ClubMemberListActivity.this.s1();
                        v12 = ClubMemberListActivity.this.v1();
                        ClubInfoModel clubInfoModel = new ClubInfoModel(z10, s12, v12);
                        User user = (User) obj;
                        NearByMiniProfileActivity.f16517r.a(ClubMemberListActivity.this, new NearbyUserModel(user.userId(), false, false, false, false, false, user.getAvatarImage(), user.getNickname(), null, null, false, false, false, null, null, null, null, false, false, false, null, 2096958, null), SensorScene.GroupChat, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : null, (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : clubInfoModel, (r27 & 1024) != 0 ? false : false);
                    }
                }
            });
            return clubMemberListAdapter;
        }
    });

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f13494u = c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final ClubMemberListActivity clubMemberListActivity = ClubMemberListActivity.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$loadMoreListener$2.1
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
                    str = ClubMemberListActivity.this.f13493t;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    ClubMemberListActivity clubMemberListActivity2 = ClubMemberListActivity.this;
                    str2 = clubMemberListActivity2.f13493t;
                    clubMemberListActivity2.t1(str2);
                }
            });
        }
    });

    /* compiled from: ClubMemberListActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable String str, @Nullable String str2, int i10, boolean z10) {
            s.i(context, "context");
            if (str == null || str.length() == 0) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) ClubMemberListActivity.class);
            intent.putExtra("CLUB_ID", str);
            intent.putExtra("CLUB_NAME", str2);
            intent.putExtra("MEMBER_COUNT", i10);
            intent.putExtra("CAN_KICK_OUT", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static /* synthetic */ void u1(ClubMemberListActivity clubMemberListActivity, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        clubMemberListActivity.t1(str);
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f13495v;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_club_member_list);
        y1();
        r1();
        u1(this, null, 1, null);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        u1(this, null, 1, null);
    }

    public final void r1() {
        ((FKTitleBarLayout) j1(R$id.club_member_title_layout)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$bindClickEvent$1
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
                ClubMemberListActivity.this.finish();
            }
        });
    }

    public final String s1() {
        return (String) this.f13490q.getValue();
    }

    public final void t1(final String str) {
        if (s1() == null) {
            return;
        }
        a2.a u10 = NetworkClient.f11868a.u();
        String s12 = s1();
        s.f(s12);
        Disposable disposed = u10.b(s12, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<User>, p>() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$getClubMember$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<User> listResult) {
                m2508invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2508invoke(ListResult<User> listResult) {
                FKLoadMoreListener w12;
                String str2;
                ClubMemberListAdapter x12;
                ClubMemberListAdapter x13;
                ClubMemberListAdapter x14;
                ClubMemberListAdapter x15;
                ClubMemberListAdapter x16;
                ListResult<User> listResult2 = listResult;
                ((FKSwipeRefreshLayout) ClubMemberListActivity.this.j1(R$id.club_member_refresh_layout)).setRefreshing(false);
                w12 = ClubMemberListActivity.this.w1();
                w12.c(false);
                ClubMemberListActivity.this.f13493t = listResult2.getNextCursorId();
                if (str == null) {
                    x15 = ClubMemberListActivity.this.x1();
                    x15.j().clear();
                    x16 = ClubMemberListActivity.this.x1();
                    x16.d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                }
                str2 = ClubMemberListActivity.this.f13493t;
                if (str2 == null) {
                    x14 = ClubMemberListActivity.this.x1();
                    x14.s();
                }
                x12 = ClubMemberListActivity.this.x1();
                x12.e(listResult2.getList());
                x13 = ClubMemberListActivity.this.x1();
                x13.notifyDataSetChanged();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$getClubMember$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener w12;
                s.i(it, "it");
                ((FKSwipeRefreshLayout) ClubMemberListActivity.this.j1(R$id.club_member_refresh_layout)).setRefreshing(false);
                w12 = ClubMemberListActivity.this.w1();
                w12.c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final String v1() {
        return (String) this.f13491r.getValue();
    }

    public final FKLoadMoreListener w1() {
        return (FKLoadMoreListener) this.f13494u.getValue();
    }

    public final ClubMemberListAdapter x1() {
        return (ClubMemberListAdapter) this.f13492s.getValue();
    }

    public final void y1() {
        int intExtra = getIntent().getIntExtra("MEMBER_COUNT", 0);
        FKTitleBarLayout club_member_title_layout = (FKTitleBarLayout) j1(R$id.club_member_title_layout);
        s.h(club_member_title_layout, "club_member_title_layout");
        FKTitleBarLayout.setSingleTitle$default(club_member_title_layout, getString(R$string.club_members, new Object[]{Integer.valueOf(intExtra)}), null, 2, null);
        RecyclerView recyclerView = (RecyclerView) j1(R$id.club_member_recyclerview);
        recyclerView.setAdapter(x1());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), x1().v(), 1, false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.club.activity.ClubMemberListActivity$initView$1$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                ClubMemberListAdapter x12;
                x12 = ClubMemberListActivity.this.x1();
                return x12.u(i10);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(w1());
        ((FKSwipeRefreshLayout) j1(R$id.club_member_refresh_layout)).setOnRefreshListener(this);
    }
}
