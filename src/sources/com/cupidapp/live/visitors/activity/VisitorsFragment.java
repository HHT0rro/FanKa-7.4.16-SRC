package com.cupidapp.live.visitors.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.abtest.ABTestGroup;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.recyclerview.model.KeyWordsSpanViewModel;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.match.fragment.FKMatchContainerFragment;
import com.cupidapp.live.mediapicker.event.TabRedDotEvent;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserRankModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.cupidapp.live.visitors.adapter.VisitorsAdapter;
import com.cupidapp.live.visitors.event.RefreshVisitorsListEvent;
import com.cupidapp.live.visitors.model.BaseVisitorsViewModel;
import com.cupidapp.live.visitors.model.RenewViewModel;
import com.cupidapp.live.visitors.model.VisitorMarketingInfoModel;
import com.cupidapp.live.visitors.model.VisitorModel;
import com.cupidapp.live.visitors.model.VisitorPurchaseUIResult;
import com.cupidapp.live.visitors.model.VisitorRecallResult;
import com.cupidapp.live.visitors.model.VisitorsPurchasePriceModel;
import com.cupidapp.live.visitors.model.VisitorsResult;
import com.cupidapp.live.visitors.model.VisitorsSquareStyleModel;
import com.cupidapp.live.visitors.model.VisitorsStripStyleModel;
import com.cupidapp.live.visitors.model.VisitorsTitleModel;
import com.cupidapp.live.visitors.model.VisitorsViewModel;
import com.cupidapp.live.visitors.viewholder.VisitorMarketingUIModel;
import he.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: VisitorsFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsFragment extends FKBaseFragment {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public static final a f18910q = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final VisitorsAdapter f18913g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f18914h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18915i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public VisitorPurchaseUIResult f18916j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final List<String> f18917k;

    /* renamed from: l, reason: collision with root package name */
    public long f18918l;

    /* renamed from: m, reason: collision with root package name */
    public float f18919m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f18920n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f18921o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18922p = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18911e = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$operationPosition$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            Bundle arguments = VisitorsFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getString("OPERATION_POSITION");
            }
            return null;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f18912f = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$purchaseManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = VisitorsFragment.this.getContext();
            Lifecycle lifecycle = VisitorsFragment.this.getLifecycle();
            s.h(lifecycle, "this.lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    /* compiled from: VisitorsFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VisitorsFragment a(@Nullable String str) {
            VisitorsFragment visitorsFragment = new VisitorsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("OPERATION_POSITION", str);
            visitorsFragment.setArguments(bundle);
            return visitorsFragment;
        }
    }

    /* compiled from: VisitorsFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends h0 {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            Context context = VisitorsFragment.this.getContext();
            if (context != null) {
                MainActivity.F.d(context, FKMatchContainerFragment.f16640u.a(context, FKMatchContainerFragment.MatchTabType.Match));
            }
        }
    }

    /* compiled from: VisitorsFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements com.cupidapp.live.visitors.viewholder.a {
        public c() {
        }

        @Override // com.cupidapp.live.visitors.viewholder.a
        public void a(@NotNull VisitorMarketingInfoModel item) {
            s.i(item, "item");
            if (VisitorsFragment.this.f18915i) {
                VisitorsFragment.this.r1(item.getSecondTitle(), item.getMarketingType());
            } else {
                z3.d.f54832a.o(VisitorsFragment.this.o1());
                VisitorsFragment.this.B1();
            }
        }
    }

    public VisitorsFragment() {
        VisitorsAdapter visitorsAdapter = new VisitorsAdapter(new c());
        visitorsAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.renewNowTextView), new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$visitorsAdapter$2$1
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
                if (obj instanceof RenewViewModel) {
                    SensorsLogKeyButtonClick.MyVisitors.RenewNow.click();
                    z3.d.f54832a.o(VisitorsFragment.this.o1());
                    VisitorsFragment.this.B1();
                }
            }
        })));
        visitorsAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$visitorsAdapter$2$2
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
                if (obj instanceof BaseVisitorsViewModel) {
                    if (VisitorsFragment.this.f18915i) {
                        User user = ((BaseVisitorsViewModel) obj).getVisitorModel().getUser();
                        if (user != null) {
                            VisitorsFragment visitorsFragment = VisitorsFragment.this;
                            String o12 = visitorsFragment.o1();
                            SensorPosition sensorPosition = SensorPosition.Setting;
                            if (!s.d(o12, sensorPosition.getValue())) {
                                sensorPosition = SensorPosition.Message;
                                if (!s.d(o12, sensorPosition.getValue())) {
                                    sensorPosition = null;
                                }
                            }
                            SensorPosition sensorPosition2 = sensorPosition;
                            String value = ViewProfilePrefer.VisitorToProfile.getValue();
                            SensorPosition sensorPosition3 = SensorPosition.MyVisitors;
                            SensorScene sensorScene = SensorScene.MyVisitors;
                            UserProfileActivity.G.a(visitorsFragment.getContext(), user, new ProfileSensorContext(value, null, false, sensorPosition3, sensorPosition2, sensorScene), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                            GroupSocialLog.f18708a.u(sensorScene.getValue(), user.userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                            return;
                        }
                        return;
                    }
                    z3.d.f54832a.o(VisitorsFragment.this.o1());
                    VisitorsFragment.this.B1();
                }
            }
        });
        this.f18913g = visitorsAdapter;
        this.f18914h = kotlin.c.b(new Function0<GridLayoutManager>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$mGridLayoutManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GridLayoutManager invoke() {
                VisitorsAdapter visitorsAdapter2;
                Context context = VisitorsFragment.this.getContext();
                visitorsAdapter2 = VisitorsFragment.this.f18913g;
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, visitorsAdapter2.v());
                final VisitorsFragment visitorsFragment = VisitorsFragment.this;
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$mGridLayoutManager$2$1$1
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i10) {
                        VisitorsAdapter visitorsAdapter3;
                        visitorsAdapter3 = VisitorsFragment.this.f18913g;
                        return visitorsAdapter3.u(i10);
                    }
                });
                return gridLayoutManager;
            }
        });
        this.f18917k = new ArrayList();
    }

    public static final void t1(VisitorsFragment this$0) {
        s.i(this$0, "this$0");
        this$0.q1();
    }

    public static final void x1(VisitorsFragment this$0) {
        s.i(this$0, "this$0");
        this$0.z1();
    }

    public final void A1(int i10) {
        User user;
        Object obj = this.f18913g.j().get(i10);
        String str = null;
        BaseVisitorsViewModel baseVisitorsViewModel = obj instanceof BaseVisitorsViewModel ? (BaseVisitorsViewModel) obj : null;
        VisitorModel visitorModel = baseVisitorsViewModel != null ? baseVisitorsViewModel.getVisitorModel() : null;
        if (visitorModel != null && (user = visitorModel.getUser()) != null) {
            str = user.userId();
        }
        if (visitorModel != null) {
            if ((str == null || str.length() == 0) || this.f18917k.contains(str)) {
                return;
            }
            this.f18917k.add(str);
        }
    }

    public final void B1() {
        PurchaseDialogManager.u(p1(), VipPurchaseEntranceType.Visitor, null, false, 6, null);
    }

    public final void C1(List<VisitorMarketingInfoModel> list, List<VisitorModel> list2) {
        StringBuilder sb2 = new StringBuilder();
        if (list != null) {
            Iterator<VisitorMarketingInfoModel> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                sb2.append(iterator2.next().getMarketingType());
                sb2.append(",");
            }
        }
        StringBuilder sb3 = new StringBuilder();
        if (list2 != null) {
            for (VisitorModel visitorModel : list2) {
                User user = visitorModel.getUser();
                boolean z10 = false;
                if (user != null && !user.getNameMask()) {
                    z10 = true;
                }
                if (z10 && !this.f18915i) {
                    sb3.append(visitorModel.getUser().getName());
                    sb3.append("|");
                }
            }
        }
        o.f50242a.a(StringsKt__StringsKt.p0(sb2, ",").toString(), StringsKt__StringsKt.p0(sb3, "|").toString());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18922p.clear();
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18922p;
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

    public final void g1() {
        FKUniversalButton purchaseVisitorsButton = (FKUniversalButton) U0(R$id.purchaseVisitorsButton);
        s.h(purchaseVisitorsButton, "purchaseVisitorsButton");
        y.d(purchaseVisitorsButton, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$bindClickEvent$1
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
                z3.d.f54832a.o(VisitorsFragment.this.o1());
                VisitorsFragment.this.B1();
            }
        });
    }

    public final void h1(boolean z10) {
        if (this.f18921o != z10) {
            EventBus.c().l(new TabRedDotEvent(z10, SensorPosition.HideFootmark));
        }
        this.f18921o = z10;
    }

    public final FKEmptyViewModel i1() {
        int i10 = 0;
        List o10 = kotlin.collections.s.o(getString(R$string.go_to_match));
        ArrayList arrayList = new ArrayList();
        for (Object obj : o10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            arrayList.add(i10, new b());
            i10 = i11;
        }
        return new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_no_visitors), Integer.valueOf(R$string.no_visitors), null, null, new KeyWordsSpanViewModel(o10, arrayList, -49088), null, null, false, null, null, 1004, null);
    }

    public final void j1(VisitorsResult visitorsResult) {
        List<VisitorMarketingInfoModel> visitorMarketingInfo = visitorsResult.getVisitorMarketingInfo();
        if (!(visitorMarketingInfo == null || visitorMarketingInfo.isEmpty())) {
            this.f18913g.d(new VisitorMarketingUIModel(visitorsResult.getVisitorMarketingInfo()));
        }
        List<VisitorModel> list = visitorsResult.getList();
        if (list == null || list.isEmpty()) {
            this.f18913g.j().clear();
            this.f18913g.d(i1());
            return;
        }
        VisitorsAdapter visitorsAdapter = this.f18913g;
        List<VisitorModel> list2 = visitorsResult.getList();
        ArrayList arrayList = new ArrayList(t.t(list2, 10));
        Iterator<VisitorModel> iterator2 = list2.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new VisitorsViewModel(iterator2.next(), visitorsResult.getVisitorEnable()));
        }
        visitorsAdapter.e(arrayList);
        this.f18913g.d(new FKFooterViewModel(false, true, getString(R$string.all_visitors_shown), -3750202, 0, 0, 48, null));
    }

    public final void k1(VisitorsResult visitorsResult) {
        String title = visitorsResult.getTitle();
        if (!(title == null || title.length() == 0)) {
            this.f18913g.d(new VisitorsTitleModel(visitorsResult.getTitle()));
        }
        List<VisitorModel> list = visitorsResult.getList();
        if (list == null || list.isEmpty()) {
            this.f18913g.j().clear();
            this.f18913g.d(i1());
            return;
        }
        VisitorsAdapter visitorsAdapter = this.f18913g;
        List<VisitorModel> list2 = visitorsResult.getList();
        ArrayList arrayList = new ArrayList(t.t(list2, 10));
        Iterator<VisitorModel> iterator2 = list2.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new VisitorsSquareStyleModel(iterator2.next(), visitorsResult.getVisitorEnable()));
        }
        visitorsAdapter.e(arrayList);
        this.f18913g.d(new FKFooterViewModel(false, true, getString(R$string.all_visitors_shown), -3750202, 0, 0, 48, null));
    }

    public final void l1(VisitorsResult visitorsResult) {
        List<VisitorMarketingInfoModel> visitorMarketingInfo = visitorsResult.getVisitorMarketingInfo();
        if (!(visitorMarketingInfo == null || visitorMarketingInfo.isEmpty())) {
            this.f18913g.d(new VisitorMarketingUIModel(visitorsResult.getVisitorMarketingInfo()));
        }
        List<VisitorModel> list = visitorsResult.getList();
        if (list == null || list.isEmpty()) {
            this.f18913g.j().clear();
            this.f18913g.d(i1());
            return;
        }
        VisitorsAdapter visitorsAdapter = this.f18913g;
        List<VisitorModel> list2 = visitorsResult.getList();
        ArrayList arrayList = new ArrayList(t.t(list2, 10));
        Iterator<VisitorModel> iterator2 = list2.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new VisitorsStripStyleModel(iterator2.next(), visitorsResult.getVisitorEnable()));
        }
        visitorsAdapter.e(arrayList);
        this.f18913g.d(new FKFooterViewModel(false, true, getString(R$string.all_visitors_shown), -3750202, 0, 0, 48, null));
    }

    public final int m1() {
        return n1().findLastCompletelyVisibleItemPosition();
    }

    public final GridLayoutManager n1() {
        return (GridLayoutManager) this.f18914h.getValue();
    }

    public final String o1() {
        return (String) this.f18911e.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return LayoutInflater.from(getContext()).inflate(R$layout.activity_visitors, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f18917k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RefreshVisitorsListEvent event) {
        s.i(event, "event");
        p1.g gVar = p1.g.f52734a;
        UserRankModel c4 = gVar.F1().c();
        if (c4 != null) {
            c4.setVisitorEnable(Boolean.TRUE);
        }
        gVar.F1().d(c4);
        q1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f18915i) {
            this.f18918l = System.currentTimeMillis();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        this.f18920n = true;
        s1();
        g1();
        q1();
    }

    public final PurchaseDialogManager p1() {
        return (PurchaseDialogManager) this.f18912f.getValue();
    }

    public final void q1() {
        ((FKSwipeRefreshLayout) U0(R$id.visitorsRefreshLayout)).setRefreshing(true);
        Disposable disposed = NetworkClient.f11868a.N().z0().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<VisitorsResult, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$getVisitorsData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VisitorsResult visitorsResult) {
                m2839invoke(visitorsResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2839invoke(VisitorsResult visitorsResult) {
                final VisitorsResult visitorsResult2 = visitorsResult;
                ((FKSwipeRefreshLayout) VisitorsFragment.this.U0(R$id.visitorsRefreshLayout)).setRefreshing(false);
                if (!visitorsResult2.getVisitorEnable()) {
                    Observable<Result<VisitorRecallResult>> j10 = NetworkClient.f11868a.p().j(3, visitorsResult2.getActCodes());
                    final VisitorsFragment visitorsFragment = VisitorsFragment.this;
                    Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$getVisitorsData$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull Throwable it) {
                            s.i(it, "it");
                            VisitorsFragment.this.w1(visitorsResult2);
                            return Boolean.TRUE;
                        }
                    };
                    Observable observeOn = j10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread());
                    final VisitorsFragment visitorsFragment2 = VisitorsFragment.this;
                    Disposable disposed2 = observeOn.subscribe(new com.cupidapp.live.base.network.e(new Function1<VisitorRecallResult, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$getVisitorsData$lambda$4$$inlined$handle$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(VisitorRecallResult visitorRecallResult) {
                            m2840invoke(visitorRecallResult);
                            return p.f51048a;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
                        
                            if ((r0 == null || r0.isEmpty()) == false) goto L16;
                         */
                        /* renamed from: invoke, reason: collision with other method in class */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void m2840invoke(com.cupidapp.live.visitors.model.VisitorRecallResult r4) {
                            /*
                                r3 = this;
                                com.cupidapp.live.visitors.model.VisitorRecallResult r4 = (com.cupidapp.live.visitors.model.VisitorRecallResult) r4
                                java.util.List r0 = r4.getAlipayOptions()
                                r1 = 0
                                r2 = 1
                                if (r0 == 0) goto L13
                                boolean r0 = r0.isEmpty()
                                if (r0 == 0) goto L11
                                goto L13
                            L11:
                                r0 = 0
                                goto L14
                            L13:
                                r0 = 1
                            L14:
                                if (r0 == 0) goto L25
                                java.util.List r0 = r4.getWechatOptions()
                                if (r0 == 0) goto L22
                                boolean r0 = r0.isEmpty()
                                if (r0 == 0) goto L23
                            L22:
                                r1 = 1
                            L23:
                                if (r1 != 0) goto L34
                            L25:
                                com.cupidapp.live.visitors.activity.VisitorsFragment r0 = com.cupidapp.live.visitors.activity.VisitorsFragment.this
                                com.cupidapp.live.vip.PurchaseDialogManager r0 = com.cupidapp.live.visitors.activity.VisitorsFragment.W0(r0)
                                com.cupidapp.live.visitors.activity.VisitorsFragment r1 = com.cupidapp.live.visitors.activity.VisitorsFragment.this
                                java.lang.String r1 = com.cupidapp.live.visitors.activity.VisitorsFragment.V0(r1)
                                r0.s(r1, r4)
                            L34:
                                com.cupidapp.live.visitors.activity.VisitorsFragment r4 = com.cupidapp.live.visitors.activity.VisitorsFragment.this
                                com.cupidapp.live.visitors.model.VisitorsResult r0 = r2
                                com.cupidapp.live.visitors.activity.VisitorsFragment.c1(r4, r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.visitors.activity.VisitorsFragment$getVisitorsData$lambda$4$$inlined$handle$1.m2840invoke(java.lang.Object):void");
                        }
                    }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, VisitorsFragment.this)));
                    if (disposed2 != null) {
                        s.h(disposed2, "disposed");
                        VisitorsFragment visitorsFragment3 = VisitorsFragment.this;
                        if (visitorsFragment3 != null) {
                            visitorsFragment3.H(disposed2);
                        }
                    }
                    s.h(disposed2, "disposed");
                    return;
                }
                VisitorsFragment.this.w1(visitorsResult2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$getVisitorsData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                ((FKSwipeRefreshLayout) VisitorsFragment.this.U0(R$id.visitorsRefreshLayout)).setRefreshing(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void r1(String str, String str2) {
        VisitorMarksActivity.f18895r.a(getContext(), o1(), str, str2);
    }

    public final void s1() {
        RecyclerView initView$lambda$1 = (RecyclerView) U0(R$id.visitorsRecyclerView);
        initView$lambda$1.setLayoutManager(n1());
        initView$lambda$1.setAdapter(this.f18913g);
        VisitorsAdapter visitorsAdapter = this.f18913g;
        s.h(initView$lambda$1, "initView$lambda$1");
        initView$lambda$1.addItemDecoration(new MutableColumnDecoration(visitorsAdapter, z0.h.c(initView$lambda$1, 8.0f)));
        this.f18913g.t(new RecyclerExposureHelper(ExposureScene.MyVisitors, initView$lambda$1, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$initView$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> list) {
                s.i(list, "list");
                VisitorsFragment visitorsFragment = VisitorsFragment.this;
                Iterator<h1.a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if ((a10 instanceof BaseVisitorsViewModel) && visitorsFragment.f18915i) {
                        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                        String value = SensorScene.MyVisitors.getValue();
                        User user = ((BaseVisitorsViewModel) a10).getVisitorModel().getUser();
                        groupSocialLog.w(value, user != null ? user.userId() : null, (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : false);
                    }
                }
            }
        }, 28, null));
        RecyclerView.ItemAnimator itemAnimator = initView$lambda$1.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        initView$lambda$1.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$initView$1$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int i10, int i11) {
                boolean u12;
                s.i(recyclerView, "recyclerView");
                if (i11 > 0) {
                    VisitorsFragment.this.y1();
                    if (VisitorsFragment.this.f18915i) {
                        return;
                    }
                    u12 = VisitorsFragment.this.u1();
                    if (u12) {
                        z3.d.f54832a.o(VisitorsFragment.this.o1());
                        VisitorsFragment.this.B1();
                    }
                }
            }
        });
        initView$lambda$1.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: com.cupidapp.live.visitors.activity.VisitorsFragment$initView$1$3
            @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(@NotNull RecyclerView rv, @NotNull MotionEvent e2) {
                VisitorsAdapter visitorsAdapter2;
                float f10;
                boolean u12;
                s.i(rv, "rv");
                s.i(e2, "e");
                int action = e2.getAction();
                if (action == 0) {
                    VisitorsFragment.this.f18919m = e2.getY();
                } else if (action == 2) {
                    visitorsAdapter2 = VisitorsFragment.this.f18913g;
                    List<Object> j10 = visitorsAdapter2.j();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : j10) {
                        if (obj instanceof BaseVisitorsViewModel) {
                            arrayList.add(obj);
                        }
                    }
                    if (!arrayList.isEmpty() && !VisitorsFragment.this.f18915i) {
                        float y10 = e2.getY();
                        f10 = VisitorsFragment.this.f18919m;
                        if (y10 - f10 < 0.0f) {
                            u12 = VisitorsFragment.this.u1();
                            if (u12) {
                                z3.d.f54832a.o(VisitorsFragment.this.o1());
                                VisitorsFragment.this.B1();
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        });
        ((FKSwipeRefreshLayout) U0(R$id.visitorsRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.visitors.activity.g
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                VisitorsFragment.t1(VisitorsFragment.this);
            }
        });
    }

    public final boolean u1() {
        return m1() == this.f18913g.n();
    }

    public final void v1(User user) {
        int i10 = 0;
        for (Object obj : this.f18913g.j()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            if (obj instanceof BaseVisitorsViewModel) {
                BaseVisitorsViewModel baseVisitorsViewModel = (BaseVisitorsViewModel) obj;
                User user2 = baseVisitorsViewModel.getVisitorModel().getUser();
                if (s.d(user2 != null ? user2.userId() : null, user.userId())) {
                    User user3 = baseVisitorsViewModel.getVisitorModel().getUser();
                    user3.setMatch(user.getMatch());
                    user3.setAloha(user.getAloha());
                    user3.setAlohaGet(user.getAlohaGet());
                    this.f18913g.notifyItemChanged(i10);
                }
            }
            i10 = i11;
        }
    }

    public final void w1(VisitorsResult visitorsResult) {
        this.f18913g.j().clear();
        this.f18915i = visitorsResult.getVisitorEnable();
        this.f18916j = new VisitorPurchaseUIResult(visitorsResult.getVisitorWechatOptions(), visitorsResult.getVisitorAlipayOptions(), visitorsResult.getUserStrategyEndTime());
        boolean z10 = true;
        if (visitorsResult.getValidDate() != null) {
            List<VisitorsPurchasePriceModel> visitorAlipayOptions = visitorsResult.getVisitorAlipayOptions();
            if (!(visitorAlipayOptions == null || visitorAlipayOptions.isEmpty())) {
                List<VisitorsPurchasePriceModel> visitorWechatOptions = visitorsResult.getVisitorWechatOptions();
                if (!(visitorWechatOptions == null || visitorWechatOptions.isEmpty())) {
                    this.f18913g.d(new RenewViewModel(visitorsResult.getValidDate().longValue()));
                }
            }
        }
        String e02 = p1.g.f52734a.e0();
        if (s.d(e02, ABTestGroup.A.getValue())) {
            j1(visitorsResult);
        } else if (s.d(e02, ABTestGroup.B.getValue())) {
            k1(visitorsResult);
        } else if (s.d(e02, ABTestGroup.C.getValue())) {
            l1(visitorsResult);
        } else {
            j1(visitorsResult);
        }
        this.f18913g.notifyDataSetChanged();
        List<VisitorModel> list = visitorsResult.getList();
        if (!(list == null || list.isEmpty()) && !visitorsResult.getVisitorEnable()) {
            ((FKUniversalButton) U0(R$id.purchaseVisitorsButton)).setVisibility(0);
            String description = visitorsResult.getDescription();
            if (description != null && description.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) U0(R$id.purchase_tip)).setVisibility(8);
            } else {
                int i10 = R$id.purchase_tip;
                ((TextView) U0(i10)).setVisibility(0);
                ((TextView) U0(i10)).setText(visitorsResult.getDescription());
            }
        } else {
            ((FKUniversalButton) U0(R$id.purchaseVisitorsButton)).setVisibility(8);
            ((TextView) U0(R$id.purchase_tip)).setVisibility(8);
        }
        if (this.f18920n && visitorsResult.getVisitorEnable()) {
            this.f18920n = false;
            this.f18918l = System.currentTimeMillis();
        }
        ((RecyclerView) U0(R$id.visitorsRecyclerView)).post(new Runnable() { // from class: com.cupidapp.live.visitors.activity.h
            @Override // java.lang.Runnable
            public final void run() {
                VisitorsFragment.x1(VisitorsFragment.this);
            }
        });
        Boolean redDot = visitorsResult.getRedDot();
        h1(redDot != null ? redDot.booleanValue() : false);
        C1(visitorsResult.getVisitorMarketingInfo(), visitorsResult.getList());
    }

    public final void y1() {
        int m12;
        if (this.f18915i && (m12 = m1()) >= 0 && m12 < this.f18913g.j().size()) {
            A1(m12);
        }
    }

    public final void z1() {
        int m12;
        if (!this.f18915i || (m12 = m1()) < 0 || m12 >= this.f18913g.j().size()) {
            return;
        }
        int i10 = 0;
        if (m12 < 0) {
            return;
        }
        while (true) {
            A1(i10);
            if (i10 == m12) {
                return;
            } else {
                i10++;
            }
        }
    }

    @j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        v1(event.getUser());
    }

    @j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        q1();
    }
}
