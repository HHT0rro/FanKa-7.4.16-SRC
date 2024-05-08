package com.cupidapp.live.liveshow.view.giftpicker.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment;
import com.cupidapp.live.liveshow.view.giftpicker.helper.DiamondPurchaseWrapper;
import com.cupidapp.live.liveshow.view.giftpicker.model.BalanceModel;
import com.cupidapp.live.liveshow.view.giftpicker.model.DiamondModel;
import com.cupidapp.live.liveshow.view.giftpicker.model.DiamondResult;
import com.cupidapp.live.liveshow.view.giftpicker.model.RechargeDiamondResult;
import com.cupidapp.live.liveshow.view.giftpicker.model.RechargeRewardModel;
import com.cupidapp.live.liveshow.view.giftpicker.model.SendGiftModel;
import com.cupidapp.live.liveshow.view.giftpicker.view.BalanceDescriptionLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.DiamondPurchaseBottomLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.DiamondPurchaseSuccessLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.DiamondSkuLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.FirstRechargeRewardLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.FirstRechargeTopLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.cupidapp.live.track.group.GroupRechargeLog;
import com.cupidapp.live.vip.wrapper.CreateOrderScene;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.f;
import z0.g;
import z0.u;
import z0.y;

/* compiled from: DiamondBalanceFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DiamondBalanceFragment extends BaseBottomSheetDialogFragment implements com.cupidapp.live.liveshow.view.giftpicker.helper.a {

    /* renamed from: o */
    @NotNull
    public static final a f15433o = new a(null);

    /* renamed from: p */
    public static boolean f15434p;

    /* renamed from: q */
    @Nullable
    public static DiamondBalanceFragment f15435q;

    /* renamed from: f */
    @Nullable
    public com.cupidapp.live.liveshow.view.giftpicker.fragment.a f15437f;

    /* renamed from: i */
    public boolean f15440i;

    /* renamed from: j */
    @Nullable
    public String f15441j;

    /* renamed from: k */
    @Nullable
    public BalanceModel f15442k;

    /* renamed from: l */
    @Nullable
    public DiamondModel f15443l;

    /* renamed from: n */
    @NotNull
    public Map<Integer, View> f15445n = new LinkedHashMap();

    /* renamed from: e */
    public boolean f15436e = true;

    /* renamed from: g */
    @NotNull
    public final Lazy f15438g = c.b(new Function0<SensorPosition>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$enterSource$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final SensorPosition invoke() {
            Bundle arguments = DiamondBalanceFragment.this.getArguments();
            if (arguments != null) {
                return (SensorPosition) g.b(arguments, SensorPosition.class);
            }
            return null;
        }
    });

    /* renamed from: h */
    @NotNull
    public final Lazy f15439h = c.b(new Function0<String>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$tips$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            Bundle arguments = DiamondBalanceFragment.this.getArguments();
            if (arguments != null) {
                return arguments.getString("RECHARGE_TIPS");
            }
            return null;
        }
    });

    /* renamed from: m */
    @NotNull
    public final Lazy f15444m = c.b(new Function0<DiamondPurchaseWrapper>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$purchaseWrapper$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final DiamondPurchaseWrapper invoke() {
            return new DiamondPurchaseWrapper(DiamondBalanceFragment.this);
        }
    });

    /* compiled from: DiamondBalanceFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            DiamondBalanceFragment diamondBalanceFragment;
            if (!b() || (diamondBalanceFragment = DiamondBalanceFragment.f15435q) == null) {
                return;
            }
            diamondBalanceFragment.dismiss();
        }

        public final boolean b() {
            return DiamondBalanceFragment.f15434p;
        }

        public final void c(@Nullable FragmentManager fragmentManager, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull SensorPosition enterSource, @Nullable String str4, @Nullable com.cupidapp.live.liveshow.view.giftpicker.fragment.a aVar) {
            s.i(enterSource, "enterSource");
            if (fragmentManager == null || b()) {
                return;
            }
            DiamondBalanceFragment.f15435q = new DiamondBalanceFragment();
            Bundle bundle = new Bundle();
            bundle.putString("DIAMOND_BALANCE", str);
            bundle.putString("LIVE_SHOW_ID", str2);
            bundle.putString("ROOM_ID", str3);
            g.d(bundle, enterSource);
            bundle.putString("RECHARGE_TIPS", str4);
            DiamondBalanceFragment diamondBalanceFragment = DiamondBalanceFragment.f15435q;
            if (diamondBalanceFragment != null) {
                diamondBalanceFragment.setArguments(bundle);
            }
            DiamondBalanceFragment diamondBalanceFragment2 = DiamondBalanceFragment.f15435q;
            if (diamondBalanceFragment2 != null) {
                diamondBalanceFragment2.f15437f = aVar;
            }
            DiamondBalanceFragment diamondBalanceFragment3 = DiamondBalanceFragment.f15435q;
            if (diamondBalanceFragment3 != null) {
                diamondBalanceFragment3.show(fragmentManager, DiamondBalanceFragment.class.getSimpleName());
            }
        }
    }

    /* compiled from: DiamondBalanceFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15446a;

        static {
            int[] iArr = new int[SensorPosition.values().length];
            try {
                iArr[SensorPosition.LiveShowRoom.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorPosition.CONSULT_ROOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f15446a = iArr;
        }
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.helper.a
    public void J(@NotNull String orderId) {
        s.i(orderId, "orderId");
        Disposable disposed = NetworkClient.f11868a.p().i(orderId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<RechargeDiamondResult, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$purchaseComplete$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(RechargeDiamondResult rechargeDiamondResult) {
                m2643invoke(rechargeDiamondResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2643invoke(RechargeDiamondResult rechargeDiamondResult) {
                DiamondPurchaseWrapper t12;
                boolean z10;
                SensorPosition s12;
                DiamondModel diamondModel;
                boolean z11;
                SensorPosition s13;
                RechargeDiamondResult rechargeDiamondResult2 = rechargeDiamondResult;
                t12 = DiamondBalanceFragment.this.t1();
                t12.a();
                p1.g.f52734a.W1(rechargeDiamondResult2.getBalance());
                DiamondBalanceFragment.this.f15442k = rechargeDiamondResult2.getRechargeTips();
                FirstRechargeTopLayout recharge_top_layout = (FirstRechargeTopLayout) DiamondBalanceFragment.this.V0(R$id.recharge_top_layout);
                s.h(recharge_top_layout, "recharge_top_layout");
                recharge_top_layout.setVisibility(8);
                DiamondBalanceFragment.this.p1(String.valueOf(rechargeDiamondResult2.getBalance()));
                z10 = DiamondBalanceFragment.this.f15440i;
                if (z10) {
                    s13 = DiamondBalanceFragment.this.s1();
                    if (s13 == SensorPosition.LiveShowRoom) {
                        ((TextView) DiamondBalanceFragment.this.V0(R$id.recharge_diamond_textview)).setText(DiamondBalanceFragment.this.getString(R$string.recharge_success));
                        DiamondSkuLayout diamond_sku_layout = (DiamondSkuLayout) DiamondBalanceFragment.this.V0(R$id.diamond_sku_layout);
                        s.h(diamond_sku_layout, "diamond_sku_layout");
                        diamond_sku_layout.setVisibility(8);
                        FirstRechargeRewardLayout firstRechargeRewardLayout = (FirstRechargeRewardLayout) DiamondBalanceFragment.this.V0(R$id.reward_layout);
                        String string = DiamondBalanceFragment.this.getString(R$string.recharge_success_title);
                        s.h(string, "getString(R.string.recharge_success_title)");
                        firstRechargeRewardLayout.c(string);
                        DiamondPurchaseBottomLayout diamond_bottom_layout = (DiamondPurchaseBottomLayout) DiamondBalanceFragment.this.V0(R$id.diamond_bottom_layout);
                        s.h(diamond_bottom_layout, "diamond_bottom_layout");
                        diamond_bottom_layout.setVisibility(8);
                        ((DiamondPurchaseSuccessLayout) DiamondBalanceFragment.this.V0(R$id.purchase_success_layout)).c(rechargeDiamondResult2.getRecommendGift());
                        EventBus.c().l(new RechargeDiamondSuccessEvent());
                    }
                }
                s12 = DiamondBalanceFragment.this.s1();
                if (s12 == SensorPosition.CONSULT_ROOM) {
                    DiamondBalanceFragment.this.dismiss();
                }
                diamondModel = DiamondBalanceFragment.this.f15443l;
                if (diamondModel != null) {
                    GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
                    String priceFormatted = diamondModel.getPriceFormatted();
                    z11 = DiamondBalanceFragment.this.f15440i;
                    groupLiveLog.L(priceFormatted, z11);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$purchaseComplete$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                DiamondPurchaseWrapper t12;
                s.i(it, "it");
                t12 = DiamondBalanceFragment.this.t1();
                t12.a();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.helper.a
    public void M0() {
        t1().a();
        h.f12779a.q(R$string.alipay_close);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15445n.clear();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public boolean P0() {
        return this.f15436e;
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15445n;
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

    public final void o1() {
        View blank_view = V0(R$id.blank_view);
        s.h(blank_view, "blank_view");
        y.d(blank_view, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$bindClickEvent$1
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
                DiamondBalanceFragment.this.dismiss();
            }
        });
        ((FirstRechargeTopLayout) V0(R$id.recharge_top_layout)).setCheckRuleClick(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$bindClickEvent$2
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
                EventBus c4 = EventBus.c();
                str = DiamondBalanceFragment.this.f15441j;
                c4.l(new FKLiveOpenWebFragmentEvent(str, true));
            }
        });
        ImageView balance_description_imageview = (ImageView) V0(R$id.balance_description_imageview);
        s.h(balance_description_imageview, "balance_description_imageview");
        y.d(balance_description_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$bindClickEvent$3
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
                BalanceModel balanceModel;
                BalanceDescriptionLayout.Companion companion = BalanceDescriptionLayout.f15474d;
                Context context = DiamondBalanceFragment.this.getContext();
                balanceModel = DiamondBalanceFragment.this.f15442k;
                companion.a(context, balanceModel);
            }
        });
        ((DiamondSkuLayout) V0(R$id.diamond_sku_layout)).setItemClick(new Function1<DiamondModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(DiamondModel diamondModel) {
                invoke2(diamondModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull DiamondModel it) {
                s.i(it, "it");
                DiamondBalanceFragment.this.f15443l = it;
                DiamondPurchaseBottomLayout diamondPurchaseBottomLayout = (DiamondPurchaseBottomLayout) DiamondBalanceFragment.this.V0(R$id.diamond_bottom_layout);
                String string = DiamondBalanceFragment.this.getString(R$string.confirm_pay, it.getPriceFormatted());
                s.h(string, "getString(R.string.confirm_pay, it.priceFormatted)");
                diamondPurchaseBottomLayout.b(string);
            }
        });
        ((DiamondPurchaseBottomLayout) V0(R$id.diamond_bottom_layout)).setCreateOrder(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$bindClickEvent$5
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
                DiamondBalanceFragment.this.q1();
                DiamondBalanceFragment.this.w1();
            }
        });
        ((DiamondPurchaseSuccessLayout) V0(R$id.purchase_success_layout)).setConfirmSendClick(new Function1<SendGiftModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$bindClickEvent$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SendGiftModel sendGiftModel) {
                invoke2(sendGiftModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SendGiftModel model) {
                s.i(model, "model");
                Context context = DiamondBalanceFragment.this.getContext();
                if (context != null) {
                    new SendGiftConfirmLayout(context).m(model);
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_diamond_balance, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.cupidapp.live.liveshow.view.giftpicker.fragment.a aVar = this.f15437f;
        if (aVar != null) {
            aVar.a();
        }
        f15434p = false;
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Dialog dialog;
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        f15434p = true;
        if (s1() == SensorPosition.LiveShowRoom && (dialog = getDialog()) != null) {
            z0.d.g(dialog, 0.0f);
        }
        DiamondPurchaseWrapper t12 = t1();
        Lifecycle lifecycle = getLifecycle();
        s.h(lifecycle, "lifecycle");
        t12.B(lifecycle);
        v1();
        o1();
        r1();
    }

    public final void p1(String str) {
        TextView textView = (TextView) V0(R$id.balance_textview);
        q1.d dVar = q1.d.f53006a;
        String string = getString(R$string.diamond_balance, str);
        s.h(string, "getString(R.string.diamond_balance, balance)");
        textView.setText(dVar.h(string, r.e(str), -49088, null, true));
    }

    public final void q1() {
        Context context;
        CreateOrderScene createOrderScene;
        if (this.f15443l == null || (context = getContext()) == null) {
            return;
        }
        if (s1() == SensorPosition.LiveShowRoom) {
            if (this.f15440i) {
                createOrderScene = CreateOrderScene.LiveShowDiamondFirstRecharge;
            } else {
                createOrderScene = CreateOrderScene.LiveShowDiamond;
            }
        } else {
            createOrderScene = CreateOrderScene.ConsultLive;
        }
        DiamondPurchaseWrapper t12 = t1();
        Dialog dialog = getDialog();
        DiamondModel diamondModel = this.f15443l;
        s.f(diamondModel);
        t12.O(context, dialog, diamondModel, ((DiamondPurchaseBottomLayout) V0(R$id.diamond_bottom_layout)).getPayType(), createOrderScene);
    }

    public final void r1() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("LIVE_SHOW_ID") : null;
        Bundle arguments2 = getArguments();
        Disposable disposed = NetworkClient.f11868a.p().k(string, arguments2 != null ? arguments2.getString("ROOM_ID") : null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<DiamondResult, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment$getDiamondSkuData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(DiamondResult diamondResult) {
                m2642invoke(diamondResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2642invoke(DiamondResult diamondResult) {
                boolean z10;
                long parseLong;
                SensorPosition s12;
                SensorPosition s13;
                DiamondResult diamondResult2 = diamondResult;
                DiamondBalanceFragment diamondBalanceFragment = DiamondBalanceFragment.this;
                List<RechargeRewardModel> firstBuyOffers = diamondResult2.getFirstBuyOffers();
                diamondBalanceFragment.f15440i = !(firstBuyOffers == null || firstBuyOffers.isEmpty());
                DiamondBalanceFragment.this.f15441j = diamondResult2.getRechargeRuleUrl();
                DiamondBalanceFragment.this.f15442k = diamondResult2.getRechargeTips();
                z10 = DiamondBalanceFragment.this.f15440i;
                if (z10) {
                    s13 = DiamondBalanceFragment.this.s1();
                    int i10 = s13 == null ? -1 : DiamondBalanceFragment.b.f15446a[s13.ordinal()];
                    if (i10 == 1) {
                        FirstRechargeTopLayout recharge_top_layout = (FirstRechargeTopLayout) DiamondBalanceFragment.this.V0(R$id.recharge_top_layout);
                        s.h(recharge_top_layout, "recharge_top_layout");
                        recharge_top_layout.setVisibility(0);
                        ImageView first_recharge_img = (ImageView) DiamondBalanceFragment.this.V0(R$id.first_recharge_img);
                        s.h(first_recharge_img, "first_recharge_img");
                        first_recharge_img.setVisibility(8);
                    } else if (i10 == 2) {
                        FirstRechargeTopLayout recharge_top_layout2 = (FirstRechargeTopLayout) DiamondBalanceFragment.this.V0(R$id.recharge_top_layout);
                        s.h(recharge_top_layout2, "recharge_top_layout");
                        recharge_top_layout2.setVisibility(8);
                        ImageView first_recharge_img2 = (ImageView) DiamondBalanceFragment.this.V0(R$id.first_recharge_img);
                        s.h(first_recharge_img2, "first_recharge_img");
                        first_recharge_img2.setVisibility(0);
                    }
                } else {
                    FirstRechargeTopLayout recharge_top_layout3 = (FirstRechargeTopLayout) DiamondBalanceFragment.this.V0(R$id.recharge_top_layout);
                    s.h(recharge_top_layout3, "recharge_top_layout");
                    recharge_top_layout3.setVisibility(8);
                    ImageView first_recharge_img3 = (ImageView) DiamondBalanceFragment.this.V0(R$id.first_recharge_img);
                    s.h(first_recharge_img3, "first_recharge_img");
                    first_recharge_img3.setVisibility(8);
                }
                Bundle arguments3 = DiamondBalanceFragment.this.getArguments();
                String string2 = arguments3 != null ? arguments3.getString("DIAMOND_BALANCE") : null;
                if (string2 == null || string2.length() == 0) {
                    parseLong = diamondResult2.getBalance();
                } else {
                    parseLong = Long.parseLong(string2);
                }
                p1.g.f52734a.W1(parseLong);
                DiamondBalanceFragment.this.p1(String.valueOf(parseLong));
                ImageView balance_description_imageview = (ImageView) DiamondBalanceFragment.this.V0(R$id.balance_description_imageview);
                s.h(balance_description_imageview, "balance_description_imageview");
                BalanceModel rechargeTips = diamondResult2.getRechargeTips();
                balance_description_imageview.setVisibility((rechargeTips != null ? rechargeTips.getNobilityBalance() : null) != null ? 0 : 8);
                ((DiamondSkuLayout) DiamondBalanceFragment.this.V0(R$id.diamond_sku_layout)).e(diamondResult2.getProducts(), diamondResult2.getRechargeHistoryWebUrl());
                FirstRechargeRewardLayout firstRechargeRewardLayout = (FirstRechargeRewardLayout) DiamondBalanceFragment.this.V0(R$id.reward_layout);
                String string3 = DiamondBalanceFragment.this.getString(R$string.first_recharge_reward);
                s.h(string3, "getString(R.string.first_recharge_reward)");
                s12 = DiamondBalanceFragment.this.s1();
                firstRechargeRewardLayout.b(string3, s12 != SensorPosition.CONSULT_ROOM ? diamondResult2.getFirstBuyOffers() : null);
                ((DiamondPurchaseBottomLayout) DiamondBalanceFragment.this.V0(R$id.diamond_bottom_layout)).setAgreementUrl(diamondResult2.getDiamondRechargeTosUrl());
                DiamondBalanceFragment.this.x1();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final SensorPosition s1() {
        return (SensorPosition) this.f15438g.getValue();
    }

    public final DiamondPurchaseWrapper t1() {
        return (DiamondPurchaseWrapper) this.f15444m.getValue();
    }

    public final String u1() {
        return (String) this.f15439h.getValue();
    }

    public final void v1() {
        int i10 = R$id.recharge_diamond_textview;
        TextView recharge_diamond_textview = (TextView) V0(i10);
        s.h(recharge_diamond_textview, "recharge_diamond_textview");
        u.a(recharge_diamond_textview);
        BitmapFactory.Options m10 = f.m(getContext(), R$mipmap.first_recharge_banner);
        int l10 = (m10.outHeight * (z0.h.l(this) - z0.h.c(this, 32.0f))) / m10.outWidth;
        ImageView first_recharge_img = (ImageView) V0(R$id.first_recharge_img);
        s.h(first_recharge_img, "first_recharge_img");
        boolean z10 = true;
        y.o(first_recharge_img, null, Integer.valueOf(l10), 1, null);
        String u12 = u1();
        if (u12 != null && u12.length() != 0) {
            z10 = false;
        }
        if (z10) {
            ((TextView) V0(i10)).setText(getString(R$string.recharge_diamond));
            return;
        }
        TextView textView = (TextView) V0(i10);
        q1.d dVar = q1.d.f53006a;
        String u13 = u1();
        s.f(u13);
        textView.setText(dVar.j(u13, "#", -49088));
    }

    public final void w1() {
        DiamondModel diamondModel = this.f15443l;
        if (diamondModel != null) {
            GroupRechargeLog.f18707a.b(String.valueOf(diamondModel.getPrice()), diamondModel.getAmount(), s1(), this.f15440i, u1());
        }
    }

    public final void x1() {
        GroupRechargeLog.f18707a.c(s1(), this.f15440i, u1());
    }
}
