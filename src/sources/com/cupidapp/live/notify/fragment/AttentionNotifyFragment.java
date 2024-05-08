package com.cupidapp.live.notify.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.match.helper.FakeUserUploadAvatarDialogHelper;
import com.cupidapp.live.notify.adapter.AttentionListAdapter;
import com.cupidapp.live.notify.model.AttentionNotifyModel;
import com.cupidapp.live.notify.model.AttentionStatusTitleViewModel;
import com.cupidapp.live.notify.model.NotifyListResult;
import com.cupidapp.live.notify.model.RefreshAttentionNotifyEvent;
import com.cupidapp.live.notify.viewholder.AttentionFakeTitleViewModel;
import com.cupidapp.live.notify.viewholder.FakeUploadAvatarTipModel;
import com.cupidapp.live.notify.viewholder.NotifyTopTitleUiModel;
import com.cupidapp.live.profile.activity.RelationUserListActivity;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.FKPushType;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import h3.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.u;
import z0.y;

/* compiled from: AttentionNotifyFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AttentionNotifyFragment extends FKBaseFragment {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f17506o = new a(null);

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public String f17510h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public String f17511i;

    /* renamed from: l, reason: collision with root package name */
    public boolean f17514l;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17516n = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17507e = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(AttentionNotifyFragment.this);
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f17508f = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = AttentionNotifyFragment.this.getContext();
            Lifecycle lifecycle = AttentionNotifyFragment.this.getLifecycle();
            s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f17509g = kotlin.c.b(new Function0<AttentionListAdapter>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$attentionAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AttentionListAdapter invoke() {
            AttentionListAdapter attentionListAdapter = new AttentionListAdapter();
            final AttentionNotifyFragment attentionNotifyFragment = AttentionNotifyFragment.this;
            attentionListAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$attentionAdapter$2$1$1
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
                    if (obj instanceof AttentionNotifyModel) {
                        AttentionNotifyModel attentionNotifyModel = (AttentionNotifyModel) obj;
                        if (attentionNotifyModel.getShowMosaic()) {
                            AttentionNotifyFragment.this.P1();
                        } else {
                            AttentionNotifyFragment.this.w1(attentionNotifyModel);
                        }
                    }
                }
            });
            attentionListAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.followImageButton), new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$attentionAdapter$2$1$2
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
                    if (obj instanceof AttentionNotifyModel) {
                        AttentionNotifyFragment.this.x1((AttentionNotifyModel) obj);
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.followedImageButton), new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$attentionAdapter$2$1$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                }
            }), kotlin.f.a(Integer.valueOf(R$id.chatImageButton), new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$attentionAdapter$2$1$4
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
                    if (obj instanceof AttentionNotifyModel) {
                        AttentionNotifyFragment.this.v1((AttentionNotifyModel) obj);
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.seeAllFollowingUsers), new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$attentionAdapter$2$1$5
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
                    if (obj instanceof FKFooterViewModel) {
                        RelationUserListActivity.f17672s.b(AttentionNotifyFragment.this.getContext(), 1);
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.fake_upload_avatar_root), new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$attentionAdapter$2$1$6

                /* compiled from: AttentionNotifyFragment.kt */
                @kotlin.d
                /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
                public static final class a implements com.cupidapp.live.match.helper.a {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ AttentionNotifyFragment f17517a;

                    public a(AttentionNotifyFragment attentionNotifyFragment) {
                        this.f17517a = attentionNotifyFragment;
                    }

                    @Override // com.cupidapp.live.match.helper.a
                    public void dismiss() {
                        this.f17517a.H1();
                    }
                }

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
                    xb.b F1;
                    if (!(obj instanceof FakeUploadAvatarTipModel) || (context = AttentionNotifyFragment.this.getContext()) == null) {
                        return;
                    }
                    AttentionNotifyFragment attentionNotifyFragment2 = AttentionNotifyFragment.this;
                    FakeUserUploadAvatarDialogHelper fakeUserUploadAvatarDialogHelper = FakeUserUploadAvatarDialogHelper.f16755a;
                    F1 = attentionNotifyFragment2.F1();
                    fakeUserUploadAvatarDialogHelper.g(F1, context, attentionNotifyFragment2.O0(), new a(attentionNotifyFragment2));
                    GroupOthersLog.f18702a.F(GroupOthersLog.GuideType.WHY_GET_FAKE_LIKE, attentionNotifyFragment2.O0(), SensorScene.NewFollower);
                }
            })));
            return attentionListAdapter;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f17512j = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final AttentionNotifyFragment attentionNotifyFragment = AttentionNotifyFragment.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$loadMoreListener$2.1
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
                    str = AttentionNotifyFragment.this.f17510h;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    AttentionNotifyFragment attentionNotifyFragment2 = AttentionNotifyFragment.this;
                    str2 = attentionNotifyFragment2.f17510h;
                    attentionNotifyFragment2.z1(str2);
                }
            });
        }
    });

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final List<String> f17513k = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final Lazy f17515m = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$mSensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            return new FKSensorContext(AttentionNotifyFragment.this.O0(), SensorPosition.Feed, null, SensorScene.NewFollower);
        }
    });

    /* compiled from: AttentionNotifyFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AttentionNotifyFragment a(boolean z10) {
            AttentionNotifyFragment attentionNotifyFragment = new AttentionNotifyFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("defaultShowPurchaseDialog", z10);
            attentionNotifyFragment.setArguments(bundle);
            return attentionNotifyFragment;
        }
    }

    /* compiled from: AttentionNotifyFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AttentionNotifyFragment.this.O1();
        }
    }

    public static /* synthetic */ void A1(AttentionNotifyFragment attentionNotifyFragment, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        attentionNotifyFragment.z1(str);
    }

    public static final void J1(AttentionNotifyFragment this$0) {
        s.i(this$0, "this$0");
        A1(this$0, null, 1, null);
    }

    public static final void R1(AttentionNotifyFragment this$0) {
        s.i(this$0, "this$0");
        ((TextView) this$0.U0(R$id.toast_text)).setVisibility(8);
    }

    public final int B1() {
        RecyclerView recyclerView = (RecyclerView) U0(R$id.baseNotifyRecyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager != null) {
            return gridLayoutManager.findLastCompletelyVisibleItemPosition();
        }
        return 0;
    }

    public final FKLoadMoreListener C1() {
        return (FKLoadMoreListener) this.f17512j.getValue();
    }

    public final FKSensorContext D1() {
        return (FKSensorContext) this.f17515m.getValue();
    }

    public final PurchaseDialogManager E1() {
        return (PurchaseDialogManager) this.f17508f.getValue();
    }

    public final xb.b F1() {
        return (xb.b) this.f17507e.getValue();
    }

    public final List<AttentionNotifyModel> G1() {
        List<Object> j10 = y1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof AttentionNotifyModel) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((AttentionNotifyModel) obj2).getUnread()) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    public final void H1() {
        Iterator<Object> iterator2 = y1().j().iterator2();
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i10 = -1;
                break;
            } else if (iterator2.next() instanceof FakeUploadAvatarTipModel) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            y1().j().remove(i10);
            y1().notifyDataSetChanged();
        }
    }

    public final void I1() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), y1().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$initView$manager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                AttentionListAdapter y1;
                y1 = AttentionNotifyFragment.this.y1();
                return y1.u(i10);
            }
        });
        RecyclerView recyclerView = (RecyclerView) U0(R$id.baseNotifyRecyclerView);
        recyclerView.setAdapter(y1());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addOnScrollListener(C1());
        C1().d(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$initView$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i10, int i11) {
                boolean z10;
                boolean K1;
                s.i(recyclerView2, "recyclerView");
                if (i11 > 0) {
                    AttentionNotifyFragment.this.N1();
                }
                if (i11 > 0) {
                    z10 = AttentionNotifyFragment.this.f17514l;
                    if (z10) {
                        K1 = AttentionNotifyFragment.this.K1();
                        if (K1) {
                            ((RecyclerView) AttentionNotifyFragment.this.U0(R$id.baseNotifyRecyclerView)).stopScroll();
                            AttentionNotifyFragment.this.P1();
                        }
                    }
                }
            }
        });
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        AttentionListAdapter y1 = y1();
        ExposureScene exposureScene = ExposureScene.NotifyAloha;
        s.h(recyclerView, "this");
        y1.t(new RecyclerExposureHelper(exposureScene, recyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$initView$1$2
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
                s.i(itemList, "itemList");
                AttentionNotifyFragment attentionNotifyFragment = AttentionNotifyFragment.this;
                Iterator<h1.a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof AttentionNotifyModel) {
                        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                        String value = SensorScene.NewFollower.getValue();
                        AttentionNotifyModel attentionNotifyModel = (AttentionNotifyModel) a10;
                        String userId = attentionNotifyModel.getFromUser().userId();
                        Integer specialLabelType = attentionNotifyModel.getSpecialLabelType();
                        groupSocialLog.w(value, userId, (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : specialLabelType != null && specialLabelType.intValue() == 1);
                    }
                    if (a10 instanceof FakeUploadAvatarTipModel) {
                        GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.WHY_GET_FAKE_LIKE, attentionNotifyFragment.O0(), SensorScene.NewFollower, null, 8, null);
                    }
                }
            }
        }, 28, null));
        ((FKSwipeRefreshLayout) U0(R$id.baseNotifyRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.notify.fragment.g
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                AttentionNotifyFragment.J1(AttentionNotifyFragment.this);
            }
        });
    }

    public final boolean K1() {
        return !((RecyclerView) U0(R$id.baseNotifyRecyclerView)).canScrollVertically(1);
    }

    public final void L1(User user) {
        int i10 = 0;
        for (Object obj : y1().j()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            if (obj instanceof AttentionNotifyModel) {
                AttentionNotifyModel attentionNotifyModel = (AttentionNotifyModel) obj;
                if (s.d(attentionNotifyModel.getFromUser().userId(), user.userId())) {
                    User fromUser = attentionNotifyModel.getFromUser();
                    fromUser.setMatch(user.getMatch());
                    fromUser.setAloha(user.getAloha());
                    y1().notifyItemChanged(i10);
                }
            }
            i10 = i11;
        }
    }

    public final void M1(NotifyListResult<AttentionNotifyModel> notifyListResult) {
        if (s.d(notifyListResult.getAvatarWindowTipShow(), Boolean.TRUE)) {
            y1().d(new FakeUploadAvatarTipModel());
        }
        boolean z10 = false;
        if (!TextUtils.isEmpty(notifyListResult.getGuideContent())) {
            y1().d(new AttentionFakeTitleViewModel(notifyListResult.getGuideContent(), notifyListResult.getButtonContent(), notifyListResult.getJumpInfo(), notifyListResult.getPopupInfo()));
            z10 = true;
        }
        Q1(notifyListResult.getFiltrateSpammerToast(), z10);
        String title = notifyListResult.getTitle();
        if (title != null) {
            y1().d(new NotifyTopTitleUiModel(title));
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17516n.clear();
    }

    public final void N1() {
        int B1;
        int v2;
        User fromUser;
        List<AttentionNotifyModel> G1 = G1();
        if ((G1 == null || G1.isEmpty()) || (B1 = B1()) < 0 || B1 >= y1().j().size() || (v2 = B1 - ((B1 - 1) % y1().v())) > B1) {
            return;
        }
        while (true) {
            Object obj = y1().j().get(v2);
            String str = null;
            AttentionNotifyModel attentionNotifyModel = obj instanceof AttentionNotifyModel ? (AttentionNotifyModel) obj : null;
            if (attentionNotifyModel != null && (fromUser = attentionNotifyModel.getFromUser()) != null) {
                str = fromUser.userId();
            }
            if (!(str == null || str.length() == 0) && attentionNotifyModel.getUnread() && !this.f17513k.contains(str)) {
                this.f17513k.add(str);
            }
            if (v2 == B1) {
                return;
            } else {
                v2++;
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.NotifyAloha;
    }

    public final void O1() {
        int B1;
        User fromUser;
        List<AttentionNotifyModel> G1 = G1();
        if ((G1 == null || G1.isEmpty()) || (B1 = B1()) < 0 || B1 >= y1().j().size() || B1 < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            Object obj = y1().j().get(i10);
            String str = null;
            AttentionNotifyModel attentionNotifyModel = obj instanceof AttentionNotifyModel ? (AttentionNotifyModel) obj : null;
            if (attentionNotifyModel != null && (fromUser = attentionNotifyModel.getFromUser()) != null) {
                str = fromUser.userId();
            }
            if (!(str == null || str.length() == 0) && attentionNotifyModel.getUnread()) {
                this.f17513k.add(str);
            }
            if (i10 == B1) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void P1() {
        PurchaseDialogManager.q(E1(), VipPurchaseEntranceType.NotifyAlohaYou, null, null, false, false, 30, null);
    }

    public final void Q1(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i10 = R$id.toast_text;
        ((TextView) U0(i10)).setVisibility(0);
        ((TextView) U0(i10)).setText(str);
        ((TextView) U0(i10)).getPaint().setFakeBoldText(true);
        int c4 = z0.h.c(this, 20.0f);
        if (z10) {
            ViewGroup.LayoutParams layoutParams = ((TextView) U0(i10)).getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).setMargins(c4, z0.h.c(this, 76.0f), c4, 0);
            }
        } else {
            ViewGroup.LayoutParams layoutParams2 = ((TextView) U0(i10)).getLayoutParams();
            if (layoutParams2 != null) {
                ((ConstraintLayout.LayoutParams) layoutParams2).setMargins(c4, z0.h.c(this, 20.0f), c4, 0);
            }
        }
        ((TextView) U0(i10)).postDelayed(new Runnable() { // from class: com.cupidapp.live.notify.fragment.h
            @Override // java.lang.Runnable
            public final void run() {
                AttentionNotifyFragment.R1(AttentionNotifyFragment.this);
            }
        }, com.huawei.openalliance.ad.ipc.c.Code);
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17516n;
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
        return inflater.inflate(R$layout.fragment_base_notify, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        L1(event.getUser());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) U0(R$id.baseNotifyRecyclerView)).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        boolean z10 = false;
        int findFirstVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findFirstVisibleItemPosition() : 0;
        if (y1().n() <= 0 || (findFirstVisibleItemPosition <= 1 && p1.g.f52734a.z0() > 0)) {
            A1(this, null, 1, null);
        }
        if (this.f17514l && y1().n() > 0) {
            z10 = true;
        }
        t1(z10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        I1();
        Bundle arguments = getArguments();
        if (s.d(arguments != null ? Boolean.valueOf(arguments.getBoolean("defaultShowPurchaseDialog", false)) : null, Boolean.TRUE)) {
            P1();
        }
    }

    public final void s1(List<AttentionNotifyModel> list) {
        String string;
        ArrayList arrayList = new ArrayList();
        for (AttentionNotifyModel attentionNotifyModel : list) {
            if (attentionNotifyModel.getUnread()) {
                arrayList.add(attentionNotifyModel);
            }
        }
        boolean z10 = true;
        if (!arrayList.isEmpty()) {
            List<Object> j10 = y1().j();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : j10) {
                if (obj instanceof AttentionStatusTitleViewModel) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList2) {
                if (((AttentionStatusTitleViewModel) obj2).getUnread()) {
                    arrayList3.add(obj2);
                }
            }
            if (arrayList3.isEmpty()) {
                p1.g gVar = p1.g.f52734a;
                if (gVar.z0() > 0) {
                    string = getString(R$string.newest_attention_count, Integer.valueOf(gVar.z0()));
                } else {
                    string = getString(R$string.newest_attention);
                }
                s.h(string, "if (LocalStore.notifyAlo….string.newest_attention)");
                y1().d(new AttentionStatusTitleViewModel(string, true));
            }
            y1().e(arrayList);
        }
        ArrayList arrayList4 = new ArrayList();
        for (AttentionNotifyModel attentionNotifyModel2 : list) {
            if (!attentionNotifyModel2.getUnread()) {
                arrayList4.add(attentionNotifyModel2);
            }
        }
        if (arrayList4.isEmpty()) {
            return;
        }
        List<Object> j11 = y1().j();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : j11) {
            if (obj3 instanceof AttentionStatusTitleViewModel) {
                arrayList5.add(obj3);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj4 : arrayList5) {
            if (!((AttentionStatusTitleViewModel) obj4).getUnread()) {
                arrayList6.add(obj4);
            }
        }
        if (arrayList6.isEmpty()) {
            List<AttentionNotifyModel> G1 = G1();
            if (G1 != null && !G1.isEmpty()) {
                z10 = false;
            }
            if (!z10) {
                AttentionListAdapter y1 = y1();
                String string2 = getString(R$string.earlier_attention);
                s.h(string2, "getString(R.string.earlier_attention)");
                y1.d(new AttentionStatusTitleViewModel(string2, false));
            }
        }
        y1().e(arrayList4);
    }

    public final void t1(boolean z10) {
        if (z10) {
            ((FrameLayout) U0(R$id.notify_buy_rl)).setVisibility(0);
            int i10 = R$id.notify_buy_btn;
            TextView notify_buy_btn = (TextView) U0(i10);
            s.h(notify_buy_btn, "notify_buy_btn");
            u.a(notify_buy_btn);
            TextView notify_buy_btn2 = (TextView) U0(i10);
            s.h(notify_buy_btn2, "notify_buy_btn");
            y.d(notify_buy_btn2, new Function1<View, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$checkShowPurchaseBtn$1
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
                    AttentionNotifyFragment.this.P1();
                }
            });
            return;
        }
        ((FrameLayout) U0(R$id.notify_buy_rl)).setVisibility(8);
    }

    public final void u1() {
        com.cupidapp.live.push.d.f17892a.b(FKPushType.Aloha);
        p1.g gVar = p1.g.f52734a;
        gVar.W2(0);
        gVar.X2(gVar.B0() + gVar.C0());
        EventBus.c().l(new RefreshNotifyTitleUnreadCountEvent());
        if (this.f17511i != null) {
            Disposable disposed = NetworkClient.f11868a.C().h(this.f17511i).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$clearUnreadAttentionNotify$$inlined$handle$default$1
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
                    AttentionNotifyFragment.this.f17511i = null;
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    public final void v1(AttentionNotifyModel attentionNotifyModel) {
        ChatDetailActivity.f13276r.a(getContext(), new ChatBundleData(attentionNotifyModel.getFromUser(), attentionNotifyModel.getFromUser().userId(), D1(), null, false, false, true, false, false, 440, null));
    }

    public final void w1(AttentionNotifyModel attentionNotifyModel) {
        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
        SensorScene sensorScene = SensorScene.NewFollower;
        groupSocialLog.u(sensorScene.getValue(), attentionNotifyModel.getFromUser().userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
        String value = ViewProfilePrefer.NotifyLikeToProfile.getValue();
        boolean me2 = attentionNotifyModel.getFromUser().getMe();
        SensorPosition sensorPosition = SensorPosition.NotifyAloha;
        UserProfileActivity.G.a(getContext(), attentionNotifyModel.getFromUser(), new ProfileSensorContext(value, null, me2, sensorPosition, sensorPosition, sensorScene), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
        attentionNotifyModel.setUnread(false);
        y1().y(attentionNotifyModel);
    }

    public final void x1(final AttentionNotifyModel attentionNotifyModel) {
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), attentionNotifyModel.getFromUser().userId(), null, null, FollowPrefer.AlohaNotify.getValue(), 0, null, null, null, 246, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$followButtonClick$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2743invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2743invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                AttentionNotifyFragment.this.L1(swipeCardUserLikeResult2.getUser());
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                String value = SensorScene.NewFollower.getValue();
                String userId = attentionNotifyModel.getFromUser().userId();
                Boolean valueOf = Boolean.valueOf(swipeCardUserLikeResult2.getUser().isAlohaMatched());
                Map<String, Object> recommendContext = swipeCardUserLikeResult2.getRecommendContext();
                Integer specialLabelType = attentionNotifyModel.getSpecialLabelType();
                groupSocialLog.B(true, value, userId, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : valueOf, (r52 & 32) != 0 ? null : recommendContext, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : null, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : Boolean.valueOf(specialLabelType != null && specialLabelType.intValue() == 1));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final AttentionListAdapter y1() {
        return (AttentionListAdapter) this.f17509g.getValue();
    }

    public final void z1(final String str) {
        Disposable disposed = a.C0743a.a(NetworkClient.f11868a.C(), str, 0, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NotifyListResult<AttentionNotifyModel>, p>() { // from class: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$getAttentionList$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(NotifyListResult<AttentionNotifyModel> notifyListResult) {
                m2744invoke(notifyListResult);
                return p.f51048a;
            }

            /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void m2744invoke(com.cupidapp.live.notify.model.NotifyListResult<com.cupidapp.live.notify.model.AttentionNotifyModel> r20) {
                /*
                    Method dump skipped, instructions count: 394
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.notify.fragment.AttentionNotifyFragment$getAttentionList$$inlined$handle$default$1.m2744invoke(java.lang.Object):void");
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RefreshAttentionNotifyEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        H1();
    }
}
