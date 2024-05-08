package com.cupidapp.live.profile.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.filter.model.FilterTopOptionsUiModel;
import com.cupidapp.live.filter.model.FilterTopRangeUiModel;
import com.cupidapp.live.filter.model.FilterTopTabModel;
import com.cupidapp.live.filter.model.FilterTopTabUiBaseModel;
import com.cupidapp.live.filter.model.TabLayoutStyle;
import com.cupidapp.live.filter.view.FilterTopTabLayout;
import com.cupidapp.live.match.activity.ContactFilterActivity;
import com.cupidapp.live.match.event.ShowPurchaseDialogEvent;
import com.cupidapp.live.match.helper.FloatAvatarHelper;
import com.cupidapp.live.match.model.FilterOption;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import com.cupidapp.live.match.view.FKNearByPermissionRequestLayout;
import com.cupidapp.live.notify.layout.ReplaceAvatarTipLayout;
import com.cupidapp.live.notify.model.CheckAvatarModel;
import com.cupidapp.live.profile.activity.ContactManagerActivity;
import com.cupidapp.live.profile.activity.NonexistentUserActivity;
import com.cupidapp.live.profile.adapter.RelationUserAdapter;
import com.cupidapp.live.profile.holder.NonexistentUserEnterViewModel;
import com.cupidapp.live.profile.holder.RelationType;
import com.cupidapp.live.profile.holder.RelationUserUiModel;
import com.cupidapp.live.profile.model.NearByGuideModel;
import com.cupidapp.live.profile.model.NearByGuideUserModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserListResult;
import com.cupidapp.live.track.group.ActionName;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.track.group.SpreadItemName;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.google.android.material.tabs.TabLayout;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.FormBody;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.y;

/* compiled from: RelationUserListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class RelationUserListFragment extends FKBaseFragment {

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public String f17777i;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Disposable f17780l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17781m = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17773e = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = RelationUserListFragment.this.getContext();
            Lifecycle lifecycle = RelationUserListFragment.this.getLifecycle();
            s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public UserListOrder f17774f = UserListOrder.Newest;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f17775g = kotlin.c.b(new Function0<FloatAvatarHelper<NearByGuideUserModel>>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$animHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FloatAvatarHelper<NearByGuideUserModel> invoke() {
            return new FloatAvatarHelper<>();
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f17776h = kotlin.c.b(new Function0<RelationUserAdapter>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$relationUserAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final RelationUserAdapter invoke() {
            FloatAvatarHelper o12;
            o12 = RelationUserListFragment.this.o1();
            RelationUserAdapter relationUserAdapter = new RelationUserAdapter(o12);
            final RelationUserListFragment relationUserListFragment = RelationUserListFragment.this;
            relationUserAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$relationUserAdapter$2$1$1
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
                    Context context;
                    if (obj instanceof RelationUserUiModel) {
                        RelationUserListFragment.this.m1((RelationUserUiModel) obj);
                    } else {
                        if (!(obj instanceof NonexistentUserEnterViewModel) || (context = RelationUserListFragment.this.getContext()) == null) {
                            return;
                        }
                        NonexistentUserActivity.f17639r.a(context, ((NonexistentUserEnterViewModel) obj).getRelationType());
                    }
                }
            });
            relationUserAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.emptyPromptBtn), new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$relationUserAdapter$2$1$2
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
                    if (obj instanceof FKEmptyViewModel) {
                        RelationUserListFragment.this.D1();
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.near_by_guide_btn), new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$relationUserAdapter$2$1$3
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
                    if (obj instanceof NearByGuideModel) {
                        j.a.b(com.cupidapp.live.base.router.j.f12156c, RelationUserListFragment.this.getContext(), ((NearByGuideModel) obj).getUrl(), null, 4, null);
                        GroupOthersLog.f18702a.h0(RelationUserListFragment.this.O0(), SpreadItemName.NEARBY_SPREAD, ActionName.LOOK_NEARBY);
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.near_bg_guide_close), new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$relationUserAdapter$2$1$4
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
                    if (obj instanceof NearByGuideModel) {
                        RelationUserListFragment.this.n1();
                        GroupOthersLog.f18702a.h0(RelationUserListFragment.this.O0(), SpreadItemName.NEARBY_SPREAD, ActionName.CLOSE);
                    }
                }
            })));
            return relationUserAdapter;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f17778j = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final RelationUserListFragment relationUserListFragment = RelationUserListFragment.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$loadMoreListener$2.1
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
                    str = RelationUserListFragment.this.f17777i;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    RelationUserListFragment relationUserListFragment2 = RelationUserListFragment.this;
                    str2 = relationUserListFragment2.f17777i;
                    relationUserListFragment2.x1(str2);
                }
            });
        }
    });

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f17779k = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(RelationUserListFragment.this);
        }
    });

    /* compiled from: RelationUserListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements TabLayout.OnTabSelectedListener {
        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            if (tab == null) {
                return;
            }
            String obj = StringsKt__StringsKt.P0(String.valueOf(tab.getText())).toString();
            tab.setText(t.n(obj, new StyleSpan(1), new String[]{obj}, false, 4, null));
            int position = tab.getPosition();
            UserListOrder userListOrder = UserListOrder.Location;
            if (position != userListOrder.getIndex()) {
                userListOrder = UserListOrder.Active;
                if (position != userListOrder.getIndex()) {
                    userListOrder = UserListOrder.Newest;
                }
            }
            RelationUserListFragment.this.O1(userListOrder);
            GroupSocialLog.f18708a.i(userListOrder, RelationUserListFragment.this.u1());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
            if (tab == null) {
                return;
            }
            String obj = StringsKt__StringsKt.P0(String.valueOf(tab.getText())).toString();
            tab.setText(t.n(obj, new StyleSpan(0), new String[]{obj}, false, 4, null));
        }
    }

    public static final Pair A1(Result t12, Result t2) {
        s.i(t12, "t1");
        s.i(t2, "t2");
        return new Pair(t12, t2);
    }

    public static final void B1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void H1(RelationUserListFragment this$0) {
        s.i(this$0, "this$0");
        RecyclerExposureHelper.f12092j.d(this$0.K1());
        y1(this$0, null, 1, null);
    }

    public static /* synthetic */ void y1(RelationUserListFragment relationUserListFragment, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResultList");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        relationUserListFragment.x1(str);
    }

    public static final void z1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final xb.b C1() {
        return (xb.b) this.f17779k.getValue();
    }

    public final void D1() {
        Context context = getContext();
        if (context != null) {
            LocationUtils.f12270h.e(context, C1(), new Function0<p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$gotoContactFilter$1$1
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
                    ContactFilterActivity.f16483u.a(RelationUserListFragment.this);
                }
            });
        }
    }

    public final void E1() {
        SensorsLogKeyButtonClick.f12211a.b(O0(), SensorsLogKeyButtonClick.ClickButtonName.MANAGE);
        Context context = getContext();
        if (context != null) {
            ContactManagerActivity.f17601t.a(context, l1());
        }
    }

    public final void F1() {
        RecyclerView recyclerView = (RecyclerView) W0(R$id.relationUserListRecyclerView);
        recyclerView.setAdapter(v1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addOnScrollListener(r1());
        RelationUserAdapter v12 = v1();
        ExposureScene K1 = K1();
        s.h(recyclerView, "this");
        v12.t(new RecyclerExposureHelper(K1, recyclerView, 0.0f, 0L, this.f17774f.name(), new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$initAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> itemList) {
                String L1;
                s.i(itemList, "itemList");
                RelationUserListFragment relationUserListFragment = RelationUserListFragment.this;
                Iterator<h1.a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof RelationUserUiModel) {
                        L1 = relationUserListFragment.L1();
                        GroupSocialLog.f18708a.w(L1, ((RelationUserUiModel) a10).getUserId(), (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : false);
                    }
                    if (a10 instanceof NearByGuideModel) {
                        GroupOthersLog.f18702a.i0(relationUserListFragment.O0(), SpreadItemName.NEARBY_SPREAD);
                    }
                }
            }
        }, 12, null));
    }

    public final void G0() {
        RecyclerExposureHelper.f12092j.d(K1());
        v1().j().clear();
        v1().notifyDataSetChanged();
        FKSwipeRefreshLayout fKSwipeRefreshLayout = (FKSwipeRefreshLayout) W0(R$id.userListRefreshLayout);
        if (fKSwipeRefreshLayout != null) {
            fKSwipeRefreshLayout.setRefreshing(true);
        }
        y1(this, null, 1, null);
    }

    public final void G1() {
        ((FKSwipeRefreshLayout) W0(R$id.userListRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.profile.fragment.i
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                RelationUserListFragment.H1(RelationUserListFragment.this);
            }
        });
        TextView manage_txt = (TextView) W0(R$id.manage_txt);
        s.h(manage_txt, "manage_txt");
        y.d(manage_txt, new Function1<View, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$initEvent$2
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
                RelationUserListFragment.this.E1();
            }
        });
    }

    public final void I1() {
        int i10 = R$id.filter_tab_layout;
        TabLayout.Tab tabAt = ((TabLayout) W0(i10)).getTabAt(0);
        String obj = StringsKt__StringsKt.P0(String.valueOf(tabAt != null ? tabAt.getText() : null)).toString();
        SpannableString spannableString = new SpannableString(obj);
        spannableString.setSpan(new StyleSpan(1), 0, obj.length(), 17);
        if (tabAt != null) {
            tabAt.setText(spannableString);
        }
        ((TabLayout) W0(i10)).addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
    }

    public final void J1() {
        I1();
        F1();
        ((TextView) W0(R$id.manage_txt)).setVisibility(0);
        ((FilterTopTabLayout) W0(R$id.contact_filter_tab_layout)).setClickListener(new com.cupidapp.live.filter.view.a() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$initView$1
            @Override // com.cupidapp.live.filter.view.a
            public void a(@NotNull final FilterTopTabUiBaseModel model) {
                s.i(model, "model");
                Context context = RelationUserListFragment.this.getContext();
                if (context != null) {
                    final RelationUserListFragment relationUserListFragment = RelationUserListFragment.this;
                    LocationUtils.f12270h.e(context, relationUserListFragment.C1(), new Function0<p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$initView$1$tabClick$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            Disposable disposable;
                            disposable = RelationUserListFragment.this.f17780l;
                            if (disposable != null) {
                                disposable.dispose();
                            }
                            ((FKSwipeRefreshLayout) RelationUserListFragment.this.W0(R$id.userListRefreshLayout)).setRefreshing(false);
                            ((FilterTopTabLayout) RelationUserListFragment.this.W0(R$id.contact_filter_tab_layout)).u(model);
                        }
                    });
                }
            }

            @Override // com.cupidapp.live.filter.view.a
            public void b() {
                RelationUserListFragment.this.D1();
            }

            @Override // com.cupidapp.live.filter.view.a
            public void c(@NotNull FilterTopTabUiBaseModel model) {
                s.i(model, "model");
                RelationUserListFragment.this.M1(model);
            }
        });
    }

    public final ExposureScene K1() {
        return this instanceof FollowYouUserListFragment ? ExposureScene.FollowingList : this instanceof YouFollowedUserListFragment ? ExposureScene.FollowerList : ExposureScene.MatchList;
    }

    public final String L1() {
        return this instanceof FollowYouUserListFragment ? SensorScene.FollowerList.getValue() : this instanceof YouFollowedUserListFragment ? SensorScene.FollowingList.getValue() : SensorScene.MatchList.getValue();
    }

    public final void M1(FilterTopTabUiBaseModel filterTopTabUiBaseModel) {
        FormBody.Builder builder = new FormBody.Builder(null, 1, null);
        String key = filterTopTabUiBaseModel.getKey();
        builder.add("scene", "1");
        builder.add("filterKey", key);
        if (filterTopTabUiBaseModel instanceof FilterTopRangeUiModel) {
            String str = key + "[]";
            FilterTopRangeUiModel filterTopRangeUiModel = (FilterTopRangeUiModel) filterTopTabUiBaseModel;
            RangeMatchFilterViewModel filterModel = filterTopRangeUiModel.getFilterModel();
            builder.add(str, String.valueOf(filterModel != null ? Integer.valueOf(filterModel.getMin()) : null));
            String str2 = key + "[]";
            RangeMatchFilterViewModel filterModel2 = filterTopRangeUiModel.getFilterModel();
            builder.add(str2, String.valueOf(filterModel2 != null ? Integer.valueOf(filterModel2.getMax()) : null));
        } else if (filterTopTabUiBaseModel instanceof FilterTopOptionsUiModel) {
            for (FilterOption filterOption : ((FilterTopOptionsUiModel) filterTopTabUiBaseModel).getOptions()) {
                if (filterOption.getChecked()) {
                    builder.add(key + "[]", filterOption.getId());
                }
            }
        }
        Disposable disposed = NetworkClient.f11868a.N().w(builder.build()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$postContactFilterTabs$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                RelationUserListFragment.this.G0();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17781m.clear();
    }

    public final void N1() {
        FKNearByPermissionRequestLayout fKNearByPermissionRequestLayout = (FKNearByPermissionRequestLayout) W0(R$id.relation_no_location_layout);
        String string = getString(R$string.authorize_app_permission);
        s.h(string, "getString(R.string.authorize_app_permission)");
        String string2 = getString(R$string.authorize_aloha_permission_match);
        s.h(string2, "getString(R.string.autho…e_aloha_permission_match)");
        fKNearByPermissionRequestLayout.b(string, string2, PermissionType.LocationPermission, true, C1(), false, R$mipmap.ic_white_location);
    }

    public final void O1(@NotNull UserListOrder value) {
        s.i(value, "value");
        if (this.f17774f != value) {
            this.f17774f = value;
            G0();
        }
    }

    public abstract void P1(@NotNull User user);

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17781m;
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

    public abstract void k1();

    public abstract boolean l1();

    public final void m1(RelationUserUiModel relationUserUiModel) {
        if (relationUserUiModel.getSecret()) {
            Disposable disposed = NetworkClient.f11868a.C().a().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<CheckAvatarModel, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$clickItemEvent$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(CheckAvatarModel checkAvatarModel) {
                    m2762invoke(checkAvatarModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2762invoke(CheckAvatarModel checkAvatarModel) {
                    if (checkAvatarModel.getRealFake()) {
                        Context it = RelationUserListFragment.this.getContext();
                        if (it != null) {
                            s.h(it, "it");
                            new ReplaceAvatarTipLayout(it).e(SensorPosition.MyAlohaGet);
                            return;
                        }
                        return;
                    }
                    com.cupidapp.live.base.view.h.f12779a.c(RelationUserListFragment.this.getContext(), R$string.avatar_under_review_review_pass_to_unlock);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
            return;
        }
        P1(relationUserUiModel.getUser());
    }

    public final void n1() {
        Disposable disposed = NetworkClient.f11868a.C().c().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$closeNearByGuide$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                List<Object> j10 = RelationUserListFragment.this.v1().j();
                if (CollectionsKt___CollectionsKt.V(j10) instanceof NearByGuideModel) {
                    j10.remove(0);
                    RelationUserListFragment.this.v1().notifyItemRemoved(0);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final FloatAvatarHelper<NearByGuideUserModel> o1() {
        return (FloatAvatarHelper) this.f17775g.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 422) {
            G0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_relation_user_list, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        o1().l();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowPurchaseDialogEvent event) {
        s.i(event, "event");
        t1().l(event.getEntranceType(), event.getSensorFrom(), event.getProductType().getValue());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (LocationUtils.f12270h.d(getContext()) && this.f17774f == UserListOrder.Location) {
            x1(null);
        } else {
            if (this.f17774f != UserListOrder.Location || v1().n() > 0) {
                return;
            }
            x1(null);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        J1();
        G1();
        ((FKSwipeRefreshLayout) W0(R$id.userListRefreshLayout)).setRefreshing(true);
        y1(this, null, 1, null);
    }

    public final void p1() {
        Observable<Result<FilterTopTabModel>> r10 = NetworkClient.f11868a.N().r(1);
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = r10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FilterTopTabModel, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$getContactFilterTabs$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FilterTopTabModel filterTopTabModel) {
                m2763invoke(filterTopTabModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2763invoke(FilterTopTabModel filterTopTabModel) {
                ((FilterTopTabLayout) RelationUserListFragment.this.W0(R$id.contact_filter_tab_layout)).l(filterTopTabModel, TabLayoutStyle.RED_WHITE, RelationUserListFragment.this.O0(), "CONTACTS_", RelationUserListFragment.this.C1());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final Observable<Result<NearByGuideModel>> q1(double d10, double d11) {
        return NetworkClient.f11868a.C().b(d10, d11);
    }

    public final FKLoadMoreListener r1() {
        return (FKLoadMoreListener) this.f17778j.getValue();
    }

    @NotNull
    public final UserListOrder s1() {
        return this.f17774f;
    }

    public final PurchaseDialogManager t1() {
        return (PurchaseDialogManager) this.f17773e.getValue();
    }

    @NotNull
    public abstract RelationType u1();

    @NotNull
    public final RelationUserAdapter v1() {
        return (RelationUserAdapter) this.f17776h.getValue();
    }

    @NotNull
    public abstract Observable<Result<UserListResult>> w1(@Nullable String str);

    public final void x1(final String str) {
        Observable<Result<NearByGuideModel>> just;
        Disposable disposable = this.f17780l;
        if (disposable != null) {
            disposable.dispose();
        }
        if (str == null) {
            if (LocationUtils.f12270h.d(getContext()) && this.f17774f == UserListOrder.Location) {
                int i10 = R$id.userListRefreshLayout;
                ((FKSwipeRefreshLayout) W0(i10)).setRefreshing(false);
                ((FKSwipeRefreshLayout) W0(i10)).setEnabled(false);
                ((FKNearByPermissionRequestLayout) W0(R$id.relation_no_location_layout)).setVisibility(0);
                N1();
                return;
            }
            p1();
        }
        ((FKSwipeRefreshLayout) W0(R$id.userListRefreshLayout)).setEnabled(true);
        ((FKNearByPermissionRequestLayout) W0(R$id.relation_no_location_layout)).setVisibility(8);
        if (str == null) {
            o1().l();
            RecyclerView recyclerView = (RecyclerView) W0(R$id.relationUserListRecyclerView);
            if (recyclerView != null) {
                recyclerView.scrollToPosition(0);
            }
            CoordinateModel j10 = LocationUtils.f12270h.a().j();
            if (this.f17774f == UserListOrder.Location) {
                just = q1(j10.getLatitude(), j10.getLongitude()).onErrorReturnItem(new Result<>(null, false, null, null, null, null, null, 127, null));
                s.h(just, "getFloatAvatars(\n       …ErrorReturnItem(Result())");
            } else {
                just = Observable.just(new Result(null, false, null, null, null, null, null, 127, null));
                s.h(just, "just(Result())");
            }
        } else {
            just = Observable.just(new Result(null, false, null, null, null, null, null, 127, null));
            s.h(just, "just(Result())");
        }
        Observable observeOn = Observable.zip(w1(str), just, new BiFunction() { // from class: com.cupidapp.live.profile.fragment.j
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair A1;
                A1 = RelationUserListFragment.A1((Result) obj, (Result) obj2);
                return A1;
            }
        }).delay(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<Pair<? extends Result<? extends UserListResult>, ? extends Result<? extends NearByGuideModel>>, p> function1 = new Function1<Pair<? extends Result<? extends UserListResult>, ? extends Result<? extends NearByGuideModel>>, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$getResultList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Pair<? extends Result<? extends UserListResult>, ? extends Result<? extends NearByGuideModel>> pair) {
                invoke2((Pair<Result<UserListResult>, Result<NearByGuideModel>>) pair);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Result<UserListResult>, Result<NearByGuideModel>> pair) {
                String str2;
                FKLoadMoreListener r12;
                NearByGuideModel data;
                UserListResult data2 = pair.getFirst().getData();
                if (data2 == null) {
                    return;
                }
                RelationUserListFragment.this.f17777i = data2.getNextCursorId();
                if (str == null) {
                    RelationUserListFragment.this.v1().j().clear();
                    RelationUserListFragment.this.v1().d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                }
                NearByGuideModel data3 = pair.getSecond().getData();
                String url = data3 != null ? data3.getUrl() : null;
                if (!(url == null || url.length() == 0) && (data = pair.getSecond().getData()) != null) {
                    RelationUserListFragment.this.v1().d(data);
                }
                List<User> list = data2.getList();
                if (list == null || list.isEmpty()) {
                    if (s.d(data2.getUseFilter(), Boolean.TRUE)) {
                        RelationUserListFragment.this.v1().d(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_filter_no_person), Integer.valueOf(R$string.filter_no_match), null, -15066598, null, null, null, false, Integer.valueOf(R$string.filter_again), null, MetricsProto.MetricsEvent.DIALOG_SUPPORT_SYSTEM_INFORMATION, null));
                    } else {
                        RelationUserListFragment.this.v1().d(new FKEmptyViewModel(null, Integer.valueOf(R$string.empty_list_prompt), null, null, null, null, null, false, null, null, 1021, null));
                    }
                } else {
                    RelationUserAdapter v12 = RelationUserListFragment.this.v1();
                    List<User> list2 = data2.getList();
                    s.f(list2);
                    RelationUserListFragment relationUserListFragment = RelationUserListFragment.this;
                    ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list2, 10));
                    for (User user : list2) {
                        arrayList.add(new RelationUserUiModel(user, user.userId(), user.getAvatarImage(), user.getName(), user.getMatch(), user.getSummaryInfo(), user.getLocation(), user.getLastOnline(), data2.getSecret(), relationUserListFragment.u1()));
                    }
                    v12.e(arrayList);
                }
                str2 = RelationUserListFragment.this.f17777i;
                if (str2 == null || str2.length() == 0) {
                    RelationUserListFragment.this.v1().s();
                    if (s.d(data2.getHasBanUser(), Boolean.TRUE)) {
                        RelationUserListFragment.this.v1().r();
                        RelationUserListFragment.this.k1();
                    }
                }
                RelationUserListFragment.this.v1().notifyDataSetChanged();
                FKSwipeRefreshLayout fKSwipeRefreshLayout = (FKSwipeRefreshLayout) RelationUserListFragment.this.W0(R$id.userListRefreshLayout);
                if (fKSwipeRefreshLayout != null) {
                    fKSwipeRefreshLayout.setRefreshing(false);
                }
                r12 = RelationUserListFragment.this.r1();
                r12.c(false);
                GroupOthersLog.f18702a.T(RelationUserListFragment.this.O0(), Boolean.TRUE);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.profile.fragment.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RelationUserListFragment.B1(Function1.this, obj);
            }
        };
        final Function1<Throwable, p> function12 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.profile.fragment.RelationUserListFragment$getResultList$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                FKLoadMoreListener r12;
                FKSwipeRefreshLayout fKSwipeRefreshLayout = (FKSwipeRefreshLayout) RelationUserListFragment.this.W0(R$id.userListRefreshLayout);
                if (fKSwipeRefreshLayout != null) {
                    fKSwipeRefreshLayout.setRefreshing(false);
                }
                r12 = RelationUserListFragment.this.r1();
                r12.c(false);
            }
        };
        Disposable subscribe = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.profile.fragment.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RelationUserListFragment.z1(Function1.this, obj);
            }
        });
        this.f17780l = subscribe;
        if (subscribe != null) {
            H(subscribe);
        }
    }
}
