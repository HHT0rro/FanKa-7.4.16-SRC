package com.cupidapp.live.profile.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.layout.FKIntroduceBottomDialog;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.profile.adapter.CloseFriendManageAdapter;
import com.cupidapp.live.profile.event.UserCloseFriendChangeEvent;
import com.cupidapp.live.profile.event.UserManageViewEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.view.UserAlertDialogHelper;
import com.cupidapp.live.profile.viewmodel.CloseFriendManagerViewModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CloseFriendManagerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CloseFriendManagerFragment extends FKBaseFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f17728k = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f17730f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f17731g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17732h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f17733i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17734j = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17729e = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$sensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final FKSensorContext invoke() {
            Bundle arguments = CloseFriendManagerFragment.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("sensorContext") : null;
            if (serializable instanceof FKSensorContext) {
                return (FKSensorContext) serializable;
            }
            return null;
        }
    });

    /* compiled from: CloseFriendManagerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CloseFriendManagerFragment a(@Nullable FKSensorContext fKSensorContext) {
            CloseFriendManagerFragment closeFriendManagerFragment = new CloseFriendManagerFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("sensorContext", fKSensorContext);
            closeFriendManagerFragment.setArguments(bundle);
            return closeFriendManagerFragment;
        }
    }

    /* compiled from: CloseFriendManagerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            CloseFriendManagerFragment.this.j1();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            s.i(ds, "ds");
            ds.setFakeBoldText(true);
            ds.setUnderlineText(false);
        }
    }

    public CloseFriendManagerFragment() {
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final CloseFriendManagerFragment closeFriendManagerFragment = CloseFriendManagerFragment.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        FKSensorContext c12;
                        s.i(p02, "p0");
                        c12 = CloseFriendManagerFragment.this.c1();
                        return new CloseFriendManagerViewModel(c12);
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return androidx.lifecycle.k.b(this, cls, creationExtras);
                    }
                };
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$special$$inlined$viewModels$default$1
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
        this.f17730f = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(CloseFriendManagerViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$special$$inlined$viewModels$default$2
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
        }, function0);
        this.f17731g = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final CloseFriendManagerFragment closeFriendManagerFragment = CloseFriendManagerFragment.this;
                return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$loadMoreListener$2.1
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
                        CloseFriendManagerViewModel d12;
                        d12 = CloseFriendManagerFragment.this.d1();
                        d12.loadData(false);
                    }
                });
            }
        });
        this.f17733i = kotlin.c.b(new Function0<CloseFriendManageAdapter>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$adapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CloseFriendManageAdapter invoke() {
                CloseFriendManageAdapter closeFriendManageAdapter = new CloseFriendManageAdapter();
                final CloseFriendManagerFragment closeFriendManagerFragment = CloseFriendManagerFragment.this;
                closeFriendManageAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$adapter$2$1$1
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
                        FKSensorContext c12;
                        SensorPosition sensorPosition;
                        FKSensorContext c13;
                        if (obj instanceof User) {
                            com.cupidapp.live.feed.helper.k kVar = com.cupidapp.live.feed.helper.k.f14350a;
                            Context context = CloseFriendManagerFragment.this.getContext();
                            User user = (User) obj;
                            SensorPosition sensorPosition2 = SensorPosition.CloseFriend;
                            c12 = CloseFriendManagerFragment.this.c1();
                            if (c12 == null || (sensorPosition = c12.getPosition()) == null) {
                                sensorPosition = SensorPosition.Unknown;
                            }
                            c13 = CloseFriendManagerFragment.this.c1();
                            kVar.b(context, user, (r16 & 4) != 0 ? null : null, new FeedSensorContext(sensorPosition2, sensorPosition, null, c13 != null ? c13.getScene() : null), (r16 & 16) != 0 ? false : false, (r16 & 32) != 0 ? null : null);
                        }
                    }
                });
                closeFriendManageAdapter.l().i(i0.h(kotlin.f.a(Integer.valueOf(R$id.item_close_state_cb), new Function3<Object, Boolean, Integer, p>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$adapter$2$1$2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ p invoke(Object obj, Boolean bool, Integer num) {
                        invoke(obj, bool.booleanValue(), num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable final Object obj, final boolean z10, final int i10) {
                        CloseFriendManagerViewModel d12;
                        if (obj instanceof User) {
                            User user = (User) obj;
                            if (user.getCloseFriend()) {
                                FKAlertDialog j10 = FKAlertDialog.o(FKAlertDialog.f12698l.b(CloseFriendManagerFragment.this.getContext(), true).D(R$string.confirm_un_close_friend), R$string.remove_close_friend_con, 0, 2, null).j(false);
                                final CloseFriendManagerFragment closeFriendManagerFragment2 = CloseFriendManagerFragment.this;
                                FKAlertDialog r10 = FKAlertDialog.r(j10, 0, new Function0<p>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$adapter$2$1$2.1
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
                                        CloseFriendManageAdapter a12;
                                        ((User) Object.this).setCloseFriend(!z10);
                                        if (i10 >= 0) {
                                            a12 = closeFriendManagerFragment2.a1();
                                            a12.notifyItemChanged(i10);
                                        }
                                    }
                                }, 1, null);
                                final CloseFriendManagerFragment closeFriendManagerFragment3 = CloseFriendManagerFragment.this;
                                FKAlertDialog.G(FKAlertDialog.w(r10, 0, null, new Function0<p>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$adapter$2$1$2.2
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
                                        CloseFriendManagerViewModel d13;
                                        d13 = CloseFriendManagerFragment.this.d1();
                                        d13.changeCloseFriend((User) obj, z10, i10);
                                    }
                                }, 3, null), null, 1, null);
                                return;
                            }
                            d12 = CloseFriendManagerFragment.this.d1();
                            d12.changeCloseFriend(user, z10, i10);
                        }
                    }
                })));
                return closeFriendManageAdapter;
            }
        });
    }

    public static final void f1(CloseFriendManagerFragment this$0, StateResult stateResult) {
        s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            ((FKSwipeRefreshLayout) this$0.U0(R$id.close_friend_refresh_root)).setRefreshing(false);
            this$0.b1().c(false);
            Pair pair = (Pair) stateResult.getData();
            if (pair != null) {
                if (((Boolean) pair.getSecond()).booleanValue()) {
                    this$0.a1().j().clear();
                    this$0.a1().j().addAll((Collection) pair.getFirst());
                    this$0.a1().notifyDataSetChanged();
                    return;
                } else {
                    this$0.a1().j().addAll((Collection) pair.getFirst());
                    this$0.a1().notifyDataSetChanged();
                    return;
                }
            }
            return;
        }
        if (stateResult instanceof StateResult.a) {
            ((FKSwipeRefreshLayout) this$0.U0(R$id.close_friend_refresh_root)).setRefreshing(false);
            this$0.b1().c(false);
        }
    }

    public static final void i1(CloseFriendManagerFragment this$0) {
        s.i(this$0, "this$0");
        this$0.d1().loadData(true);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17734j.clear();
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17734j;
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

    public final CloseFriendManageAdapter a1() {
        return (CloseFriendManageAdapter) this.f17733i.getValue();
    }

    public final FKLoadMoreListener b1() {
        return (FKLoadMoreListener) this.f17731g.getValue();
    }

    public final FKSensorContext c1() {
        return (FKSensorContext) this.f17729e.getValue();
    }

    public final CloseFriendManagerViewModel d1() {
        return (CloseFriendManagerViewModel) this.f17730f.getValue();
    }

    public final void e1() {
        d1().getListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.profile.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CloseFriendManagerFragment.f1(CloseFriendManagerFragment.this, (StateResult) obj);
            }
        });
        d1().getCloseFriendChangeEvent().observe(getViewLifecycleOwner(), new EventObserver(new Function1<StateResult<Pair<? extends Integer, ? extends Boolean>>, p>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(StateResult<Pair<? extends Integer, ? extends Boolean>> stateResult) {
                invoke2((StateResult<Pair<Integer, Boolean>>) stateResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull StateResult<Pair<Integer, Boolean>> result) {
                CloseFriendManageAdapter a12;
                CloseFriendManagerViewModel d12;
                CloseFriendManageAdapter a13;
                s.i(result, "result");
                boolean z10 = false;
                if (result instanceof StateResult.c) {
                    CloseFriendManagerFragment.this.f17732h = true;
                    Pair<Integer, Boolean> data = result.getData();
                    Integer first = data != null ? data.getFirst() : null;
                    if (first != null && first.intValue() >= 0) {
                        a13 = CloseFriendManagerFragment.this.a1();
                        a13.notifyItemChanged(first.intValue());
                    }
                    Context context = CloseFriendManagerFragment.this.getContext();
                    if (context != null) {
                        CloseFriendManagerFragment closeFriendManagerFragment = CloseFriendManagerFragment.this;
                        Pair<Integer, Boolean> data2 = result.getData();
                        if (data2 != null && data2.getSecond().booleanValue()) {
                            z10 = true;
                        }
                        if (!z10 || r0.f12373a.a(context)) {
                            return;
                        }
                        d12 = closeFriendManagerFragment.d1();
                        d12.checkAlertPushTip();
                        return;
                    }
                    return;
                }
                if (result instanceof StateResult.a) {
                    Pair<Integer, Boolean> data3 = result.getData();
                    Integer first2 = data3 != null ? data3.getFirst() : null;
                    if (first2 != null && first2.intValue() >= 0) {
                        a12 = CloseFriendManagerFragment.this.a1();
                        a12.notifyItemChanged(first2.intValue());
                    }
                    String message = result.getMessage();
                    if (message == null || message.length() == 0) {
                        return;
                    }
                    FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.f12698l.b(CloseFriendManagerFragment.this.getContext(), false).n(result.getMessage()), R$string.i_know, null, new Function0<p>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$initObserve$2.2
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ p invoke() {
                            invoke2();
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            j1.i.f50236a.a(PopupName.CLOSE_FRIENDS_LIMIT, PopupButtonName.I_KNOW, SensorPosition.CloseFriend);
                        }
                    }, 2, null), null, 1, null);
                    j1.i.g(j1.i.f50236a, PopupName.CLOSE_FRIENDS_LIMIT, SensorPosition.CloseFriend, null, 4, null);
                }
            }
        }));
        d1().getTipPushOpenDialog().observe(getViewLifecycleOwner(), new EventObserver(new Function1<p, p>() { // from class: com.cupidapp.live.profile.fragment.CloseFriendManagerFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(p pVar) {
                invoke2(pVar);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull p it) {
                s.i(it, "it");
                String string = CloseFriendManagerFragment.this.getString(R$string.add_close_friend_suc);
                s.h(string, "getString(R.string.add_close_friend_suc)");
                String string2 = CloseFriendManagerFragment.this.getString(R$string.push_close_and_close_friend_tip_open);
                s.h(string2, "getString(R.string.push_…nd_close_friend_tip_open)");
                UserAlertDialogHelper.f17874a.b(CloseFriendManagerFragment.this.getContext(), string, string2, PopupName.CLOSE_FRIENDS_PUSH_GUIDE, SensorPosition.CloseFriend);
            }
        }));
    }

    public final void g1() {
        String str = getString(R$string.close_friend_introduce) + "\n" + getString(R$string.more_introduce);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        int i10 = R$id.close_friend_intro_txt;
        TextView textView = (TextView) U0(i10);
        q1.d dVar = q1.d.f53006a;
        String string = getString(R$string.more_introduce);
        s.h(string, "getString(R.string.more_introduce)");
        textView.setText(q1.d.d(dVar, str, kotlin.collections.s.o(string), -16747822, null, false, arrayList, null, 64, null));
        ((TextView) U0(i10)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void h1() {
        int i10 = R$id.close_friend_rv;
        ((RecyclerView) U0(i10)).setAdapter(a1());
        ((RecyclerView) U0(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((RecyclerView) U0(i10)).addItemDecoration(new FKAddExtraSpacingDecoration(0, 0, 0, 16, 0, 34));
        RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) U0(i10)).getItemAnimator();
        s.g(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        ((RecyclerView) U0(i10)).addOnScrollListener(b1());
        ((FKSwipeRefreshLayout) U0(R$id.close_friend_refresh_root)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.profile.fragment.b
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                CloseFriendManagerFragment.i1(CloseFriendManagerFragment.this);
            }
        });
    }

    public final void j1() {
        if (getContext() == null) {
            return;
        }
        View contentView = LayoutInflater.from(getContext()).inflate(R$layout.layout_intro_close_friend, (ViewGroup) null, false);
        TextView textView = (TextView) contentView.findViewById(R$id.intro_share_title);
        TextPaint paint = textView != null ? textView.getPaint() : null;
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        TextView textView2 = (TextView) contentView.findViewById(R$id.intro_feed_title);
        TextPaint paint2 = textView2 != null ? textView2.getPaint() : null;
        if (paint2 != null) {
            paint2.setFakeBoldText(true);
        }
        TextView textView3 = (TextView) contentView.findViewById(R$id.intro_push_title);
        TextPaint paint3 = textView3 != null ? textView3.getPaint() : null;
        if (paint3 != null) {
            paint3.setFakeBoldText(true);
        }
        FKIntroduceBottomDialog e2 = FKIntroduceBottomDialog.f11681e.a(getContext()).e(R$string.what_close_friend);
        s.h(contentView, "contentView");
        e2.d(contentView).f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        g1();
        h1();
        e1();
        p1.g gVar = p1.g.f52734a;
        if (s.d(gVar.o(), Boolean.TRUE)) {
            j1();
            gVar.a2(Boolean.FALSE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        View inflate = inflater.inflate(R$layout.close_friend_manager_fragment, viewGroup, false);
        s.h(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserCloseFriendChangeEvent event) {
        Object obj;
        s.i(event, "event");
        EventBus.c().r(event);
        Iterator<Object> iterator2 = a1().j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if ((obj instanceof User) && s.d(((User) obj).userId(), event.getUserId())) {
                    break;
                }
            }
        }
        if (obj instanceof User) {
            User user = (User) obj;
            if (user.getCloseFriend() != event.getCloseFriend()) {
                user.setCloseFriend(event.getCloseFriend());
                a1().notifyDataSetChanged();
            }
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        EventBus.c().o(new UserManageViewEvent(SensorPosition.CloseFriend, this.f17732h));
        super.onPause();
    }
}
