package com.cupidapp.live.visitors.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKSVipImgLayout;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.setting.model.FootMarkResult;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.VipDiscountDescription;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.cupidapp.live.visitors.adapter.FootmarkAdapter;
import com.cupidapp.live.visitors.model.FootmarkModel;
import com.cupidapp.live.visitors.viewholder.FootMarkEmptyModel;
import he.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.jvm.internal.y;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;

/* compiled from: FootmarkFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FootmarkFragment extends FKBaseFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f18887k = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18888e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f18889f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f18890g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f18891h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18892i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18893j = new LinkedHashMap();

    /* compiled from: FootmarkFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FootmarkFragment a() {
            return new FootmarkFragment();
        }
    }

    /* compiled from: FootmarkFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements VipDiscountDescription.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FKSVipImgLayout f18894a;

        public b(FKSVipImgLayout fKSVipImgLayout) {
            this.f18894a = fKSVipImgLayout;
        }

        @Override // com.cupidapp.live.vip.VipDiscountDescription.a
        public void a(@Nullable String str) {
            this.f18894a.c(str);
        }
    }

    public FootmarkFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$special$$inlined$viewModels$default$1
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
        this.f18888e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(FootmarkViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$special$$inlined$viewModels$default$2
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
        this.f18889f = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$purchaseDialogManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PurchaseDialogManager invoke() {
                Context context = FootmarkFragment.this.getContext();
                Lifecycle lifecycle = FootmarkFragment.this.getLifecycle();
                s.h(lifecycle, "lifecycle");
                return new PurchaseDialogManager(context, lifecycle);
            }
        });
        this.f18890g = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final FootmarkFragment footmarkFragment = FootmarkFragment.this;
                return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$loadMoreListener$2.1
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
                        FootmarkViewModel k12;
                        k12 = FootmarkFragment.this.k1();
                        k12.getData(false);
                    }
                });
            }
        });
        this.f18891h = kotlin.c.b(new Function0<FootmarkAdapter>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FootmarkAdapter invoke() {
                FootmarkAdapter footmarkAdapter = new FootmarkAdapter();
                final FootmarkFragment footmarkFragment = FootmarkFragment.this;
                footmarkAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.empty_btn), new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$adapter$2$1$1
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
                        if (obj instanceof FootMarkEmptyModel) {
                            FootmarkFragment.this.l1();
                        }
                    }
                })));
                footmarkAdapter.l().h(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$adapter$2$1$2
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
                        if (obj instanceof FootmarkModel) {
                            FootmarkFragment.this.r1((FootmarkModel) obj);
                        }
                    }
                });
                footmarkAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$adapter$2$1$3
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
                        if (obj instanceof FootmarkModel) {
                            FootmarkModel footmarkModel = (FootmarkModel) obj;
                            UserProfileActivity.G.a(FootmarkFragment.this.getContext(), footmarkModel.getUser(), new ProfileSensorContext(ViewProfilePrefer.FootmarkToProfile.getValue(), null, footmarkModel.getUser().getMe(), SensorPosition.HideFootmark, null, SensorScene.Footmark), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                        }
                    }
                });
                return footmarkAdapter;
            }
        });
    }

    public static final void g1(FootmarkFragment this$0, CheckBox checkBox, CompoundButton compoundButton, boolean z10) {
        s.i(this$0, "this$0");
        if (compoundButton.isPressed()) {
            if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
                this$0.k1().changeHideFootmarkState(z10);
                GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.HIDE_VISIT, z10, SensorPosition.HideFootmark, null, 8, null);
            } else {
                checkBox.setChecked(false);
                PurchaseDialogManager.q(this$0.j1(), VipPurchaseEntranceType.HiddenFootmark, null, null, false, false, 30, null);
            }
        }
    }

    public static final void n1(FootmarkFragment this$0, FootMarkResult footMarkResult) {
        s.i(this$0, "this$0");
        this$0.f1(footMarkResult.getHiddenFootmark(), Integer.valueOf(footMarkResult.getFootmarkDelCount()), Integer.valueOf(footMarkResult.getFootmarkDelPerMonth()), footMarkResult.getIntroduction());
    }

    public static final void o1(FootmarkFragment this$0, Pair pair) {
        s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.W0(R$id.foot_mark_refresh)).setRefreshing(false);
        this$0.i1().c(false);
        if (pair.getFirst() instanceof StateResult.c) {
            Collection<? extends Object> collection = (List) ((StateResult) pair.getFirst()).getData();
            if (collection == null) {
                collection = new ArrayList<>();
            }
            if (((Boolean) pair.getSecond()).booleanValue()) {
                this$0.h1().j().clear();
                if (collection.isEmpty()) {
                    this$0.d1();
                    this$0.h1().notifyDataSetChanged();
                    return;
                } else {
                    this$0.h1().j().addAll(collection);
                    this$0.h1().notifyDataSetChanged();
                    return;
                }
            }
            if (!collection.isEmpty()) {
                this$0.h1().j().addAll(collection);
                this$0.h1().notifyDataSetChanged();
            }
        }
    }

    public static final void q1(FootmarkFragment this$0) {
        s.i(this$0, "this$0");
        ((FKSwipeRefreshLayout) this$0.W0(R$id.foot_mark_refresh)).setRefreshing(true);
        this$0.k1().getData(true);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18893j.clear();
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18893j;
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

    public final void d1() {
        h1().j().add(new FootMarkEmptyModel(Integer.valueOf(R$mipmap.ic_empty_footer), Integer.valueOf(R$string.no_footmark), Integer.valueOf(R$string.no_foot_des), Integer.valueOf(R$string.goto_flip)));
    }

    public final void e1(FootmarkModel footmarkModel) {
        if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
            if (s.d(footmarkModel.isFootmarkHidden(), Boolean.FALSE)) {
                s1(footmarkModel);
                return;
            } else {
                com.cupidapp.live.base.view.h.f12779a.l(getContext(), R$string.no_need_del_footmark);
                return;
            }
        }
        PurchaseDialogManager.q(j1(), VipPurchaseEntranceType.HiddenDelFootmark, null, null, false, false, 30, null);
    }

    public final void f1(boolean z10, Integer num, Integer num2, final String str) {
        int i10 = R$id.view_footmark_open;
        VipDiscountDescription.f18726b.b(this, new b((FKSVipImgLayout) W0(i10).findViewById(R$id.hide_foot_svip)));
        final CheckBox checkBox = (CheckBox) W0(i10).findViewById(R$id.footmark_checkbox);
        checkBox.setChecked(z10);
        if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
            ((TextView) W0(i10).findViewById(R$id.footmark_sub_title_txt)).setText(getString(R$string.use_hide_footmark));
            TextView textView = (TextView) W0(i10).findViewById(R$id.footmark_des_txt);
            y yVar = y.f51038a;
            String string = getString(R$string.hide_footmark_count);
            s.h(string, "getString(R.string.hide_footmark_count)");
            String format = String.format(string, Arrays.copyOf(new Object[]{num}, 1));
            s.h(format, "format(format, *args)");
            textView.setText(t.k(format, -49088, new String[]{String.valueOf(num)}, false, 4, null));
        } else {
            ((TextView) W0(i10).findViewById(R$id.footmark_sub_title_txt)).setText(getString(R$string.hide_footmark_function));
            TextView textView2 = (TextView) W0(i10).findViewById(R$id.footmark_des_txt);
            y yVar2 = y.f51038a;
            String string2 = getString(R$string.hide_footmark_other_function);
            s.h(string2, "getString(R.string.hide_footmark_other_function)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{num2}, 1));
            s.h(format2, "format(format, *args)");
            textView2.setText(format2);
        }
        View findViewById = W0(i10).findViewById(R$id.footmark_help_img);
        s.h(findViewById, "view_footmark_open.findV…>(R.id.footmark_help_img)");
        z0.y.d(findViewById, new Function1<View, p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$configRecordData$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                String str2 = String.this;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, this.getContext(), false, 2, null).n(String.this), R$string.all_right, null, null, 6, null), null, 1, null);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.visitors.activity.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                FootmarkFragment.g1(FootmarkFragment.this, checkBox, compoundButton, z11);
            }
        });
        W0(i10).setVisibility(0);
    }

    public final FootmarkAdapter h1() {
        return (FootmarkAdapter) this.f18891h.getValue();
    }

    public final FKLoadMoreListener i1() {
        return (FKLoadMoreListener) this.f18890g.getValue();
    }

    public final PurchaseDialogManager j1() {
        return (PurchaseDialogManager) this.f18889f.getValue();
    }

    public final FootmarkViewModel k1() {
        return (FootmarkViewModel) this.f18888e.getValue();
    }

    public final void l1() {
        Context context = getContext();
        if (context != null) {
            MainActivity.F.e("match", context, "match");
        }
    }

    public final void m1() {
        k1().getHideRecordMsgLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.visitors.activity.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FootmarkFragment.n1(FootmarkFragment.this, (FootMarkResult) obj);
            }
        });
        k1().getDelRecordEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<String, p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String id2) {
                FootmarkAdapter h12;
                FootmarkAdapter h13;
                FootmarkAdapter h14;
                FootmarkAdapter h15;
                s.i(id2, "id");
                h12 = FootmarkFragment.this.h1();
                Iterator<Object> iterator2 = h12.j().iterator2();
                int i10 = 0;
                while (true) {
                    if (!iterator2.hasNext()) {
                        i10 = -1;
                        break;
                    }
                    Object next = iterator2.next();
                    if (next instanceof FootmarkModel ? s.d(((FootmarkModel) next).getUser().userId(), id2) : false) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 >= 0) {
                    h13 = FootmarkFragment.this.h1();
                    h13.j().remove(i10);
                    h14 = FootmarkFragment.this.h1();
                    if (h14.j().size() == 0) {
                        FootmarkFragment.this.d1();
                    }
                    h15 = FootmarkFragment.this.h1();
                    h15.notifyDataSetChanged();
                    com.cupidapp.live.base.view.h.f12779a.c(FootmarkFragment.this.getContext(), R$string.deleted_successfully);
                }
            }
        }));
        k1().getRecordListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.visitors.activity.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FootmarkFragment.o1(FootmarkFragment.this, (Pair) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        View inflate = inflater.inflate(R$layout.footmark_fragment, viewGroup, false);
        s.h(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        k1().getData(true);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f18892i) {
            return;
        }
        this.f18892i = true;
        k1().getData(true);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        p1();
        m1();
    }

    public final void p1() {
        int i10 = R$id.footmark_rv;
        ((RecyclerView) W0(i10)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) W0(i10)).setAdapter(h1());
        ((RecyclerView) W0(i10)).addOnScrollListener(i1());
        ((FKSwipeRefreshLayout) W0(R$id.foot_mark_refresh)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.visitors.activity.d
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                FootmarkFragment.q1(FootmarkFragment.this);
            }
        });
    }

    public final void r1(final FootmarkModel footmarkModel) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FKActionSheetItemModel(R$string.delete_footer, ActionSheetItemType.Warning, null, Integer.valueOf(R$mipmap.super_aplus_logo), null, new Function0<p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$showDelDialog$deleteFootMark$1
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
                FootmarkFragment.this.e1(footmarkModel);
            }
        }, 20, null));
        FKActionSheetDialog.f12692f.a(getContext()).f(arrayList).h();
        if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
            return;
        }
        z3.d.f54832a.j(VipPurchaseEntranceType.HiddenDelFootmark.getFrom());
    }

    public final void s1(final FootmarkModel footmarkModel) {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.delete_footer_tip, 0, 2, null), R$string.delete, null, new Function0<p>() { // from class: com.cupidapp.live.visitors.activity.FootmarkFragment$showDoubleConfirmDelDialog$1
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
                FootmarkViewModel k12;
                k12 = FootmarkFragment.this.k1();
                k12.deleteRecord(footmarkModel.getUser().userId());
            }
        }, 2, null), R$string.think_again, null, 2, null), null, 1, null);
    }
}
