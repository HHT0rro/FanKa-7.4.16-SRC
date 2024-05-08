package com.cupidapp.live.maskparty.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.tabview.TopTabView;
import com.cupidapp.live.maskparty.adapter.MaskPartyItemCardAdapter;
import com.cupidapp.live.maskparty.helper.MaskPartyItemCardPurchaseWrapper;
import com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesModel;
import com.cupidapp.live.maskparty.model.ItemCardPurchaseModel;
import com.cupidapp.live.maskparty.model.ItemCardType;
import com.cupidapp.live.maskparty.model.MaskPartyItemCardConfigModel;
import com.cupidapp.live.maskparty.model.RoleType;
import com.cupidapp.live.maskparty.viewmodel.MaskPartyItemCardViewModel;
import com.cupidapp.live.superboost.model.UnLimitRemainsUIModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.model.CreateOrderModel;
import com.cupidapp.live.vip.model.PayType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final a f16285m = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f16286e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public m f16287f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f16288g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f16289h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f16290i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f16291j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final Lazy f16292k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16293l = new LinkedHashMap();

    /* compiled from: MaskPartyItemCardFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MaskPartyItemCardFragment a(@NotNull MaskPartyItemCardConfigModel config, @NotNull SensorPosition sensorPosition, @NotNull m listener) {
            kotlin.jvm.internal.s.i(config, "config");
            kotlin.jvm.internal.s.i(sensorPosition, "sensorPosition");
            kotlin.jvm.internal.s.i(listener, "listener");
            MaskPartyItemCardFragment maskPartyItemCardFragment = new MaskPartyItemCardFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, config);
            z0.g.d(bundle, sensorPosition);
            maskPartyItemCardFragment.setArguments(bundle);
            maskPartyItemCardFragment.f16287f = listener;
            return maskPartyItemCardFragment;
        }
    }

    public MaskPartyItemCardFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$special$$inlined$viewModels$default$1
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
        this.f16286e = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(MaskPartyItemCardViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f16288g = kotlin.c.b(new Function0<List<? extends ItemCardFeaturesItemModel>>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$itemCardFeatures$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends ItemCardFeaturesItemModel> invoke() {
                ArrayList arrayList;
                ItemCardFeaturesItemModel[] itemCardFeaturesItemModelArr = new ItemCardFeaturesItemModel[4];
                ItemCardType itemCardType = ItemCardType.AttackMatch;
                List<RoleType> O0 = p1.g.f52734a.O0();
                if (O0 != null) {
                    ArrayList arrayList2 = new ArrayList(kotlin.collections.t.t(O0, 10));
                    Iterator<RoleType> iterator2 = O0.iterator2();
                    while (iterator2.hasNext()) {
                        arrayList2.add(Integer.valueOf(iterator2.next().getType()));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                itemCardFeaturesItemModelArr[0] = new ItemCardFeaturesItemModel(itemCardType, null, arrayList, false, 10, null);
                itemCardFeaturesItemModelArr[1] = new ItemCardFeaturesItemModel(ItemCardType.CitySearch, null, kotlin.collections.r.e(1), false, 10, null);
                itemCardFeaturesItemModelArr[2] = new ItemCardFeaturesItemModel(ItemCardType.SpeedUpMatch, null, kotlin.collections.r.e(1), false, 10, null);
                itemCardFeaturesItemModelArr[3] = new ItemCardFeaturesItemModel(ItemCardType.MatchNumber, null, null, false, 14, null);
                return kotlin.collections.s.m(itemCardFeaturesItemModelArr);
            }
        });
        this.f16289h = kotlin.c.b(new Function0<MaskPartyItemCardConfigModel>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$configModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final MaskPartyItemCardConfigModel invoke() {
                Bundle arguments = MaskPartyItemCardFragment.this.getArguments();
                if (arguments != null) {
                    return (MaskPartyItemCardConfigModel) z0.g.b(arguments, MaskPartyItemCardConfigModel.class);
                }
                return null;
            }
        });
        this.f16290i = kotlin.c.b(new Function0<SensorPosition>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$sensorPosition$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SensorPosition invoke() {
                Bundle arguments = MaskPartyItemCardFragment.this.getArguments();
                if (arguments != null) {
                    return (SensorPosition) z0.g.b(arguments, SensorPosition.class);
                }
                return null;
            }
        });
        this.f16291j = kotlin.c.b(new Function0<MaskPartyItemCardAdapter>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$itemCardAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MaskPartyItemCardAdapter invoke() {
                return new MaskPartyItemCardAdapter();
            }
        });
        this.f16292k = kotlin.c.b(new Function0<MaskPartyItemCardPurchaseWrapper>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$purchaseWrapper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MaskPartyItemCardPurchaseWrapper invoke() {
                return new MaskPartyItemCardPurchaseWrapper();
            }
        });
    }

    public static final void n1(MaskPartyItemCardFragment this$0, UnLimitRemainsUIModel unLimitRemainsUIModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        com.cupidapp.live.base.view.h.f12779a.b(R$string.exchange_success);
        if (!unLimitRemainsUIModel.hasRemains() && p1.g.f52734a.N() != null) {
            List<Object> j10 = this$0.h1().j();
            ArrayList arrayList = new ArrayList();
            for (Object obj : j10) {
                if (obj instanceof ItemCardFeaturesModel) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                kotlin.collections.x.x(arrayList2, ((ItemCardFeaturesModel) iterator2.next()).getList());
            }
            Iterator<E> iterator22 = arrayList2.iterator2();
            while (iterator22.hasNext()) {
                ((ItemCardFeaturesItemModel) iterator22.next()).setSelected(false);
            }
            this$0.h1().notifyItemChanged(0);
            p1.g.f52734a.P1(null);
        }
        m mVar = this$0.f16287f;
        if (mVar != null) {
            mVar.a();
        }
    }

    public static final void o1(MaskPartyItemCardFragment this$0, SuperLikePurchaseModel superLikePurchaseModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        Object obj = this$0.h1().j().get(1);
        ItemCardPurchaseModel itemCardPurchaseModel = obj instanceof ItemCardPurchaseModel ? (ItemCardPurchaseModel) obj : null;
        if (itemCardPurchaseModel != null) {
            itemCardPurchaseModel.setPurchaseModel(superLikePurchaseModel);
            this$0.h1().notifyItemChanged(1);
        }
    }

    public static final void p1(MaskPartyItemCardFragment this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            this$0.j1().K();
            return;
        }
        if (stateResult instanceof StateResult.c) {
            FragmentActivity activity = this$0.getActivity();
            if (activity == null || stateResult.getData() == null) {
                return;
            }
            this$0.j1().M(activity, (CreateOrderModel) ((Pair) stateResult.getData()).getFirst(), (PayType) ((Pair) stateResult.getData()).getSecond());
            return;
        }
        if (stateResult instanceof StateResult.a) {
            this$0.j1().a();
        }
    }

    public static final void q1(MaskPartyItemCardFragment this$0, UnLimitRemainsUIModel unLimitRemainsUIModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((TextView) this$0.Z0(R$id.item_card_count_textview)).setText(unLimitRemainsUIModel.getFormattedRemains());
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f16293l.clear();
    }

    @Nullable
    public View Z0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16293l;
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

    public final void f1() {
        LinearLayout item_card_instruction_layout = (LinearLayout) Z0(R$id.item_card_instruction_layout);
        kotlin.jvm.internal.s.h(item_card_instruction_layout, "item_card_instruction_layout");
        z0.y.d(item_card_instruction_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$bindClickEvent$1
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
                MaskPartyItemCardConfigModel g12;
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                Context context = MaskPartyItemCardFragment.this.getContext();
                g12 = MaskPartyItemCardFragment.this.g1();
                j.a.b(aVar, context, g12 != null ? g12.getInstructionUrl() : null, null, 4, null);
            }
        });
        LinearLayout item_card_order_layout = (LinearLayout) Z0(R$id.item_card_order_layout);
        kotlin.jvm.internal.s.h(item_card_order_layout, "item_card_order_layout");
        z0.y.d(item_card_order_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$bindClickEvent$2
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
                MaskPartyItemCardConfigModel g12;
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                Context context = MaskPartyItemCardFragment.this.getContext();
                g12 = MaskPartyItemCardFragment.this.g1();
                j.a.b(aVar, context, g12 != null ? g12.getOrderUrl() : null, null, 4, null);
            }
        });
        ((TopTabView) Z0(R$id.item_card_tabview)).setClickListener(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$bindClickEvent$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i10) {
                ((ViewPager2) MaskPartyItemCardFragment.this.Z0(R$id.item_card_viewpager)).setCurrentItem(i10);
                if (i10 == 0) {
                    SensorsLogKeyButtonClick.PropCard.CARD_INTRODUCE.click();
                } else {
                    SensorsLogKeyButtonClick.PropCard.BUY_PROP.click();
                }
            }
        });
        h1().w(new Function1<ItemCardFeaturesItemModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ItemCardFeaturesItemModel itemCardFeaturesItemModel) {
                invoke2(itemCardFeaturesItemModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable ItemCardFeaturesItemModel itemCardFeaturesItemModel) {
                MaskPartyItemCardViewModel l12;
                m mVar;
                if (itemCardFeaturesItemModel == null) {
                    mVar = MaskPartyItemCardFragment.this.f16287f;
                    if (mVar != null) {
                        mVar.c(null);
                        return;
                    }
                    return;
                }
                l12 = MaskPartyItemCardFragment.this.l1();
                l12.userItemCard(itemCardFeaturesItemModel);
            }
        });
        h1().v(new Function2<SuperLikePurchaseSkuModel, PayType, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$bindClickEvent$5
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(SuperLikePurchaseSkuModel superLikePurchaseSkuModel, PayType payType) {
                invoke2(superLikePurchaseSkuModel, payType);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SuperLikePurchaseSkuModel model, @NotNull PayType type) {
                MaskPartyItemCardViewModel l12;
                kotlin.jvm.internal.s.i(model, "model");
                kotlin.jvm.internal.s.i(type, "type");
                if (type == PayType.AliPay || type == PayType.AliPayHuaBei || NetworkClient.f11868a.P(MaskPartyItemCardFragment.this.getContext()) != null) {
                    l12 = MaskPartyItemCardFragment.this.l1();
                    l12.createOrder(model, type);
                }
            }
        });
        j1().O(new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$bindClickEvent$6
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
                MaskPartyItemCardViewModel l12;
                m mVar;
                l12 = MaskPartyItemCardFragment.this.l1();
                l12.getItemCardCount();
                mVar = MaskPartyItemCardFragment.this.f16287f;
                if (mVar != null) {
                    mVar.b();
                }
            }
        });
    }

    public final MaskPartyItemCardConfigModel g1() {
        return (MaskPartyItemCardConfigModel) this.f16289h.getValue();
    }

    public final MaskPartyItemCardAdapter h1() {
        return (MaskPartyItemCardAdapter) this.f16291j.getValue();
    }

    public final List<ItemCardFeaturesItemModel> i1() {
        return (List) this.f16288g.getValue();
    }

    public final MaskPartyItemCardPurchaseWrapper j1() {
        return (MaskPartyItemCardPurchaseWrapper) this.f16292k.getValue();
    }

    public final SensorPosition k1() {
        return (SensorPosition) this.f16290i.getValue();
    }

    public final MaskPartyItemCardViewModel l1() {
        return (MaskPartyItemCardViewModel) this.f16286e.getValue();
    }

    public final void m1() {
        l1().getItemCardPurchaseDataLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyItemCardFragment.o1(MaskPartyItemCardFragment.this, (SuperLikePurchaseModel) obj);
            }
        });
        l1().getCreateOrderLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyItemCardFragment.p1(MaskPartyItemCardFragment.this, (StateResult) obj);
            }
        });
        l1().getItemCardCountLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyItemCardFragment.q1(MaskPartyItemCardFragment.this, (UnLimitRemainsUIModel) obj);
            }
        });
        l1().getUseItemCardEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends UnLimitRemainsUIModel, ? extends ItemCardFeaturesItemModel>, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$initObserve$4

            /* compiled from: MaskPartyItemCardFragment.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f16294a;

                static {
                    int[] iArr = new int[ItemCardType.values().length];
                    try {
                        iArr[ItemCardType.AttackMatch.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ItemCardType.CitySearch.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ItemCardType.MatchNumber.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f16294a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends UnLimitRemainsUIModel, ? extends ItemCardFeaturesItemModel> pair) {
                invoke2((Pair<UnLimitRemainsUIModel, ItemCardFeaturesItemModel>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<UnLimitRemainsUIModel, ItemCardFeaturesItemModel> it) {
                kotlin.jvm.internal.s.i(it, "it");
                UnLimitRemainsUIModel first = it.getFirst();
                ItemCardFeaturesItemModel second = it.getSecond();
                if (!(first != null && first.hasRemains())) {
                    ((ViewPager2) MaskPartyItemCardFragment.this.Z0(R$id.item_card_viewpager)).setCurrentItem(1);
                    return;
                }
                int i10 = a.f16294a[second.getType().ordinal()];
                if (i10 == 1) {
                    List<RoleType> O0 = p1.g.f52734a.O0();
                    if (O0 == null || O0.isEmpty()) {
                        com.cupidapp.live.base.view.h.f12779a.l(MaskPartyItemCardFragment.this.getContext(), R$string.choose_role_prompt);
                        return;
                    } else {
                        MaskPartyItemCardFragment.this.t1(second);
                        return;
                    }
                }
                if (i10 == 2) {
                    if (LocationUtils.f12270h.d(MaskPartyItemCardFragment.this.getContext())) {
                        com.cupidapp.live.base.view.h.f12779a.k(R$string.city_search_prompt);
                        return;
                    } else {
                        MaskPartyItemCardFragment.this.t1(second);
                        return;
                    }
                }
                if (i10 != 3) {
                    MaskPartyItemCardFragment.this.t1(second);
                    return;
                }
                MaskPartyPromptHelper maskPartyPromptHelper = MaskPartyPromptHelper.f16347a;
                Context context = MaskPartyItemCardFragment.this.getContext();
                final MaskPartyItemCardFragment maskPartyItemCardFragment = MaskPartyItemCardFragment.this;
                maskPartyPromptHelper.a(context, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$initObserve$4.1
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
                        MaskPartyItemCardViewModel l12;
                        l12 = MaskPartyItemCardFragment.this.l1();
                        l12.exchangeMatchNumber();
                    }
                });
            }
        }));
        l1().getExchangeMatchNumberLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyItemCardFragment.n1(MaskPartyItemCardFragment.this, (UnLimitRemainsUIModel) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_mask_party_item_card, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        r1();
        f1();
        m1();
        Context context = getContext();
        if (context != null) {
            MaskPartyItemCardViewModel l12 = l1();
            UnLimitRemainsUIModel.Companion companion = UnLimitRemainsUIModel.Companion;
            MaskPartyItemCardConfigModel g12 = g1();
            l12.setItemCardCount(companion.a(context, g12 != null ? Integer.valueOf(g12.getRemains()) : null));
        }
        l1().getItemCardPurchaseData();
        Context context2 = getContext();
        if (context2 != null) {
            j1().N(getDialog(), context2);
        }
        MaskPartyItemCardPurchaseWrapper j12 = j1();
        Lifecycle lifecycle = getLifecycle();
        kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
        j12.B(lifecycle);
        j1.c cVar = j1.c.f50228a;
        SensorPosition sensorPosition = SensorPosition.PropCard;
        SensorPosition k12 = k1();
        j1.c.b(cVar, sensorPosition, null, k12 != null ? k12.getValue() : null, 2, null);
    }

    public final void r1() {
        ((TextView) Z0(R$id.item_card_count_textview)).getPaint().setFakeBoldText(true);
        ((TopTabView) Z0(R$id.item_card_tabview)).b(kotlin.collections.s.m(getString(R$string.features), getString(R$string.item_purchase)), 0);
        ViewPager2 viewPager2 = (ViewPager2) Z0(R$id.item_card_viewpager);
        viewPager2.setAdapter(h1());
        viewPager2.setUserInputEnabled(false);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyItemCardFragment$initView$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                LinearLayout item_card_instruction_layout = (LinearLayout) MaskPartyItemCardFragment.this.Z0(R$id.item_card_instruction_layout);
                kotlin.jvm.internal.s.h(item_card_instruction_layout, "item_card_instruction_layout");
                item_card_instruction_layout.setVisibility(i10 == 0 ? 0 : 8);
                LinearLayout item_card_order_layout = (LinearLayout) MaskPartyItemCardFragment.this.Z0(R$id.item_card_order_layout);
                kotlin.jvm.internal.s.h(item_card_order_layout, "item_card_order_layout");
                item_card_order_layout.setVisibility(i10 == 1 ? 0 : 8);
                ((TopTabView) MaskPartyItemCardFragment.this.Z0(R$id.item_card_tabview)).a(i10);
            }
        });
        Iterator<ItemCardFeaturesItemModel> iterator2 = i1().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            ItemCardFeaturesItemModel next = iterator2.next();
            ItemCardType type = next.getType();
            ItemCardFeaturesItemModel N = p1.g.f52734a.N();
            next.setSelected(type == (N != null ? N.getType() : null));
        }
        h1().d(new ItemCardFeaturesModel(i1()));
        h1().d(new ItemCardPurchaseModel(null, 1, null));
        h1().notifyDataSetChanged();
        ViewPager2 viewPager22 = (ViewPager2) Z0(R$id.item_card_viewpager);
        MaskPartyItemCardConfigModel g12 = g1();
        viewPager22.setCurrentItem(g12 != null ? g12.getDefaultIndex() : 0, false);
    }

    public final void s1(@NotNull FragmentManager manager) {
        kotlin.jvm.internal.s.i(manager, "manager");
        show(manager, MaskPartyItemCardFragment.class.getSimpleName());
    }

    public final void t1(ItemCardFeaturesItemModel itemCardFeaturesItemModel) {
        p1.g.f52734a.P1(itemCardFeaturesItemModel);
        m mVar = this.f16287f;
        if (mVar != null) {
            mVar.c(itemCardFeaturesItemModel);
        }
        dismiss();
    }
}
